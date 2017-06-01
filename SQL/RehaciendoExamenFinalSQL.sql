USE LeoFest

GO

/*
Ejercicio 1
Escribe un procedimiento almacenado que dé de baja a una banda, actualizando su fecha de disolución y 
la fecha de abandono de todos sus componentes actuales. La fecha de disolución y el ID de la banda se pasarán como parámetros. 
Si no se especifica fecha, se tomará la actual.
*/

CREATE PROCEDURE bajaBanda
	@IDBanda SMALLINT,
	@FechaDisolucion DATE = NULL

AS
	BEGIN
		IF (@FechaDisolucion IS NULL)
		BEGIN
			SET @FechaDisolucion = CAST (CURRENT_TIMESTAMP AS DATE)
		END

		BEGIN TRANSACTION

		UPDATE LFMusicosBandas
		SET FechaAbandono = @FechaDisolucion
		WHERE IDBanda = @IDBanda

		UPDATE LFBandas
		SET FechaDisolucion = @FechaDisolucion
		WHERE ID = @IDBanda

		COMMIT TRANSACTION
	END

/*
Ejercicio 2
Escribe una función que reciba como parámetro un año y nos devuelva una tabla indicando cuantas canciones (temas) 
de cada estilo se han cantado en los distintos festivales celebrados a lo largo de ese año, el mismo dato para el año 
inmediatamente anterior y una cuarta columna en la que aparezca un símbolo "+” si ha aumentado el número de canciones 
de ese estilo respecto al año anterior, un "-” si ha disminuido y un "=” si no varía.

El resultado tendrá cuatro columnas: Estilo, número de interpretaciones de ese estilo en el año anterior, 
número de interpretaciones de ese estilo en el año que nos piden y símbolo que indique aumento o disminución.

Puedes hacer otras funciones auxiliares a las que llames, pero no declarar vistas.
*/



/*
Ejercicio 3
Escribe un procedimiento TemaEjecutado y anote en la tabla LFBandasEdiciones que una banda ha interpretado ese tema en una 
edición concreta de un festival.

Los datos de entrada son: Titulo, IDAutor, Estilo (nombre del estilo), Duracion, El Id de un festival, el ordinal de la edición y 
el ID de una banda.

Si el tema es nuevo y no está dado de alta en la base de datos, se insertará en la tabla correspondiente. Si el estilo no existe, 
también se dará de alta.
*/
GO

CREATE PROCEDURE TemaEjecutado2
	@Titulo VARCHAR (120),
	@IDAutor INT,
	@Estilo VARCHAR (30),
	@Duracion TIME (7),
	@IDFestival INT,
	@Ordinal TINYINT,
	@IDBanda SMALLINT
AS
	BEGIN
		BEGIN TRANSACTION

			IF NOT EXISTS (SELECT ID
							  FROM LFTemas
							  WHERE Titulo = @Titulo)
			BEGIN
				IF NOT EXISTS (SELECT ID FROM LFEstilos WHERE Estilo = @Estilo)
				BEGIN
					INSERT INTO LFEstilos (ID, Estilo)
					VALUES ((SELECT MAX (ID) + 1 
								FROM LFEstilos), @Estilo)
				END

				INSERT INTO LFTemas (ID,Titulo, IDAutor, IDEstilo, Duracion)
				VALUES (NEWID (), @Titulo, @IDAutor, (SELECT ID FROM LFEstilos WHERE Estilo = @Estilo), @Duracion)
			END

			INSERT INTO LFTemasBandasEdiciones(IDBanda, IDFestival, Ordinal, IDTema)
			VALUES (@IDBanda, @IDFestival, @Ordinal, (SELECT ID FROM LFTemas WHERE Titulo = @Titulo))

		COMMIT TRANSACTION
	END


/*
Ejercicio 4
Escribe un procedimiento almacenado que actualice la columna caché de la tabla LFBandas de acuerdo a las siguientes reglas:

Se computarán 105 € por cada miembro activo de la banda
Se añadirán 170 € por cada actuación en los tres años anteriores
Esa cantidad se incrementará un 5% si la banda toca alguno de los estilos Rock, Flamenco, Jazz o Blues y se 
decrementará un 50% si toca Reggaeton o Hip-Hop
Nota: Valora la posibilidad de diseñar funciones para comprobar las condiciones.
*/

