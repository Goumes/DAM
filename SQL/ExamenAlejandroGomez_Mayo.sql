USE LeoFest

GO
/* 1. Escribe un procedimiento almacenado que de de baja a una banda, actualizando su fecha de disolución y fecha
de abandono de todos sus componentes actuales. La fecha de disolución y el ID de la banda se pasarán por parámetros. Si no se
especifica fecha, se tomará la actual.*/

BEGIN TRANSACTION

GO

CREATE PROCEDURE darBajaBanda
	@IDBanda SMALLINT,
	@FechaDisolucion DATE = NULL

AS
	BEGIN
	
		IF @FechaDisolucion IS NULL
		BEGIN
			SET @FechaDisolucion = CAST (CURRENT_TIMESTAMP AS DATE)	
		END

			BEGIN TRANSACTION

			UPDATE LFMusicosBandas
			SET FechaAbandono = @FechaDisolucion
			WHERE IDBanda = @IDBanda

			COMMIT TRANSACTION

			BEGIN TRANSACTION

			UPDATE LFBandas
			SET FechaDisolucion = @FechaDisolucion
			WHERE ID = @IDBanda

			COMMIT TRANSACTION

	END

--ROLLBACK
COMMIT TRANSACTION

BEGIN TRANSACTION


EXECUTE darBajaBanda 1

--ROLLBACK
COMMIT TRANSACTION

-- Utilizo transacciones al crear el procedimiento y al ejecutarlo para hacer pruebas sin alterar la base de datos.

GO

/* 2. Escribe una función que reciba como parámetro un año y nos devuelva una tabla indicando cuantas canciones (temas) de 
cada estilo se han cantado en los distintos festivales celebrados a lo largo de ese año, el mismo dato para el año 
inmediatamente anterior y una cuarta columna en la que aparezca un símbolo "+” si ha aumentado el número de canciones 
de ese estilo respecto al año anterior, un "-” si ha disminuido y un "=” si no varía.

El resultado tendrá cuatro columnas: Estilo, número de interpretaciones de ese estilo en el año anterior, número de 
interpretaciones de ese estilo en el año que nos piden y símbolo que indique aumento o disminución.

Puedes hacer otras funciones auxiliares a las que llames, pero no declarar vistas.*/

GO

/* Breve comentario: Funcionalidad que calcula el numero de interpretaciones del año anterior
   Entradas: Ninguna
   Salidas: Una tabla*/

CREATE FUNCTION NumeroInterpretacionesAñoAnterior ()
RETURNS @resultado TABLE (
							numeroInterpretaciones INT,
							Estilo VARCHAR (30)
						 )
AS

	BEGIN
		
		INSERT INTO @resultado (numeroInterpretaciones, Estilo)
		SELECT COUNT (IDTema), T.IDEstilo
			FROM LFTemas AS T 
			INNER JOIN
			LFTemasBandasEdiciones AS TBE
			ON TBE.IDTema = T.ID
			INNER JOIN
			LFEdiciones AS E
			ON TBE.IDFestival = E.IDFestival AND TBE.Ordinal = E.Ordinal
			WHERE FechaHoraInicio BETWEEN DATEFROMPARTS (((YEAR (CURRENT_TIMESTAMP)) - 1), 1, 1) 
			AND DATEFROMPARTS (((YEAR (CURRENT_TIMESTAMP)) - 1), 12, 31) -- Entre el primer dia del año anterior y el ultimo
			GROUP BY T.IDEstilo
			ORDER BY T.IDEstilo

		RETURN

	END

GO

/* Breve comentario: Funcionalidad que calcula el numero de interpretaciones de un año concreto
   Entradas: El año deseado (INT)
   Salidas: Una tabla*/

CREATE FUNCTION NumeroInterpretacionesAñoConcreto (@Año INT)
RETURNS @resultado TABLE (
							numeroInterpretaciones INT,
							Estilo VARCHAR (30)
						 )
AS

	BEGIN
		
		INSERT INTO @resultado (numeroInterpretaciones, Estilo)
		SELECT COUNT (IDTema), T.IDEstilo
			FROM LFTemas AS T 
			INNER JOIN
			LFTemasBandasEdiciones AS TBE
			ON TBE.IDTema = T.ID
			INNER JOIN
			LFEdiciones AS E
			ON TBE.IDFestival = E.IDFestival AND TBE.Ordinal = E.Ordinal
			WHERE FechaHoraInicio BETWEEN DATEFROMPARTS (@Año, 1, 1) 
			AND DATEFROMPARTS (@Año, 12, 31) -- Entre el primer dia del año deseado y el ultimo
			GROUP BY T.IDEstilo
			ORDER BY T.IDEstilo

		RETURN

	END

GO

/* Breve comentario: Funcionalidad que calcula indica el simbolo de aumento
   Entradas: Ninguna
   Salidas: Una tabla*/

CREATE FUNCTION simboloAumento ()
RETURNS @resultado TABLE (
							Simbolo CHAR (1),
							Estilo VARCHAR (30)
						 )
AS

	BEGIN
	DECLARE @Estilo INT

	SET @Estilo = 1

	WHILE (@Estilo IN (SELECT ID
						FROM LFEstilos)) --Mientras queden estilos existentes

	BEGIN

	-- Sacamos todos los símbolos dependiendo de si la diferencia es mayor, menor o igual

		-- Menor
		IF ((SELECT numeroInterpretaciones 
				FROM dbo.NumeroInterpretacionesAñoAnterior () 
				WHERE Estilo = @Estilo)
				> 
				(SELECT numeroInterpretaciones 
					FROM dbo.NumeroInterpretacionesAñoConcreto (YEAR (CURRENT_TIMESTAMP))
					WHERE Estilo = @Estilo))

			BEGIN
		
				INSERT INTO @resultado (Simbolo, Estilo)
				SELECT DISTINCT '-', IDEstilo
					FROM LFTemas
					ORDER BY IDEstilo

			END

			-- Mayor
		ELSE IF ((SELECT numeroInterpretaciones 
				FROM dbo.NumeroInterpretacionesAñoAnterior () 
				WHERE Estilo = @Estilo)
				< 
				(SELECT numeroInterpretaciones 
					FROM dbo.NumeroInterpretacionesAñoConcreto (YEAR (CURRENT_TIMESTAMP))
					WHERE Estilo = @Estilo))

			BEGIN
		
				INSERT INTO @resultado (Simbolo, Estilo)
				SELECT DISTINCT '+', IDEstilo
					FROM LFTemas
					ORDER BY IDEstilo

			END

			-- Igual
			ELSE

			BEGIN
		
				INSERT INTO @resultado (Simbolo, Estilo)
				SELECT DISTINCT '=', IDEstilo
					FROM LFTemas
					ORDER BY IDEstilo

			END

	SET @Estilo = @Estilo + 1 --Aumentar el contador de estilo

	END
			

		RETURN

	END

GO


-- Funcion principal

CREATE FUNCTION tablaCanciones (@Año INT)
RETURNS @resultado TABLE (
							Estilo VARCHAR (30),
							NumeroInterpretacionesAñoAnterior INT,
							NumeroInterpretacionesAñoConcreto INT,
							Simbolo CHAR (1)
						) 
AS

	BEGIN

		INSERT INTO @resultado (Estilo, NumeroInterpretacionesAñoAnterior, NumeroInterpretacionesAñoConcreto, Simbolo)
		SELECT E.Estilo, NAA.numeroInterpretaciones, NAC.numeroInterpretaciones, S.Simbolo
			FROM LFEstilos AS E
			LEFT JOIN
			NumeroInterpretacionesAñoAnterior () AS NAA
			ON E.ID = NAA.Estilo
			LEFT JOIN
			NumeroInterpretacionesAñoConcreto (@Año) AS NAC
			ON E.Estilo = NAC.Estilo
			LEFT JOIN
			simboloAumento () AS S
			ON E.Estilo = S.Estilo

		RETURN
	END

GO

SELECT * FROM dbo.tablaCanciones (2016)


SELECT * FROM dbo.NumeroInterpretacionesAñoAnterior () -- Prueba funcionalidad NumeroInterpretacionesAñoAnterior
SELECT * FROM dbo.NumeroInterpretacionesAñoConcreto (2017) -- Prueba funcionalidad NumeroInterpretacionesAñoConcreto
SELECT * FROM dbo.simboloAumento () -- Prueba funcionalidad simboloAumento. Me da fallo, por lo que sospecho son los JOIN.


/* 3. Escribe un procedimiento TemaEjecutado y anote en la tabla LFBandasEdiciones que una banda ha interpretado ese 
tema en una edición concreta de un festival.

Los datos de entrada son: Titulo, IDAutor, Estilo (nombre del estilo), Duracion, El Id de un festival, el ordinal de la 
edición, el ID de una banda y una fecha/hora.

Si el tema es nuevo y no está dado de alta en la base de datos, se insertará en la tabla correspondiente. 
Si el estilo no existe, también se dará de alta.*/

BEGIN TRANSACTION

GO

CREATE PROCEDURE TemaEjecutado
	@Titulo VARCHAR (120),
	@IDAutor INT,
	@Estilo VARCHAR (30),
	@Duracion TIME,
	@IDFestival INT,
	@Ordinal TINYINT,
	@IDBanda SMALLINT

AS

	BEGIN

		-- Si el estilo introducido no existe, lo creamos

		IF NOT EXISTS (SELECT ID
						  FROM LFEstilos
						  WHERE Estilo = @Estilo)

				BEGIN

					BEGIN TRANSACTION
					
					INSERT INTO LFEstilos (ID, Estilo)
					VALUES ((SELECT TOP 1 ID
								FROM LFEstilos
								ORDER BY ID DESC) + 1, @Estilo) --Insertamos el estilo nuevo siguiendo el orden de ID ya establecido. Puesto que no es identity hay que hacerlo a mano.

					COMMIT TRANSACTION

				END

		-- Si el tema introducido no existe, lo creamos.

		IF NOT EXISTS (SELECT ID
						FROM LFTemas
						WHERE Titulo = @Titulo)

				BEGIN

					BEGIN TRANSACTION

					INSERT INTO LFTemas (ID, Titulo, IDAutor, IDEstilo, Duracion)
					VALUES (NEWID (), @Titulo, @IDAutor, (SELECT ID
															FROM LFEstilos
															WHERE Estilo = @Estilo), @Duracion) -- Utilizo el NEWID () ya que la clave primera de LFTemas es un Uniqueidentifier.

					COMMIT TRANSACTION

				END

		-- A continuación comprobamos el caso en el que si exista la canción pero el estilo no, asignandole el estilo el Tema en caso de que no lo tenga.
		IF NOT EXISTS (SELECT IDEstilo
							FROM LFTemas
							WHERE Titulo = @Titulo)
					BEGIN

						BEGIN TRANSACTION

						UPDATE LFTemas
						SET IDEstilo = (SELECT ID
											FROM LFEstilos
											WHERE Estilo = @Estilo)
						WHERE Titulo = @Titulo

						COMMIT TRANSACTION

					END

		BEGIN TRANSACTION

		INSERT INTO LFTemasBandasEdiciones (IDBanda, IDFestival, Ordinal, IDTema)
		VALUES (@IDBanda, @IDFestival, @Ordinal, (SELECT ID
													FROM LFTemas
													WHERE Titulo = @Titulo))

		COMMIT TRANSACTION

	END

ROLLBACK
COMMIT TRANSACTION

GO

BEGIN TRANSACTION

EXECUTE TemaEjecutado 'Never gonna give you up', 1, 'Swing', '3:40', 1, 1, 1

ROLLBACK
COMMIT TRANSACTION

/* 4. Escribe un procedimiento almacenado que actualice la columna caché de la tabla LFBandas de acuerdo a las siguientes reglas:

Se computarán 105 € por cada miembro activo de la banda
Se añadirán 170 € por cada actuación en los tres años anteriores
Esa cantidad se incrementará un 5% si la banda toca alguno de los estilos Rock, Flamenco, Jazz o Blues y se 
decrementará un 50% si toca Reggaeton o Hip-Hop*/

GO

/* Breve comentario: Esta funcion se encarga de calcular el cómputo correspondiente al numero de miembros activos en la banda.
   Entradas: El ID de la banda (SMALLINT)
   Salidas: El dinero correspondiente (SMALLMONEY)*/

CREATE FUNCTION miembrosActivos (@IDBanda SMALLINT)
RETURNS SMALLMONEY AS

	BEGIN
		DECLARE @Resultado SMALLMONEY

		SELECT @Resultado = (COUNT (IDMusico)) * 105
			FROM LFMusicosBandas
			WHERE IDBanda = @IDBanda AND (FechaAbandono IS NULL) -- Los miembros deben de estar activos, por lo tanto no tienen FechaAbandono

		RETURN @Resultado

	END

GO

/* Breve comentario: Esta funcion se encarga de calcular el cómputo correspondiente al numero de actuaciones en los ultimos 3 años.
   Entradas: El ID de la banda (SMALLINT)
   Salidas: El dinero correspondiente (SMALLMONEY)*/

CREATE FUNCTION numeroActuaciones (@IDBanda SMALLINT)
RETURNS SMALLMONEY AS

	BEGIN
		DECLARE @Resultado SMALLMONEY

		SELECT @Resultado = (COUNT (IDBanda)) * 170
			FROM LFBandasEdiciones AS BE
			INNER JOIN
			LFEdiciones AS E
			ON BE.IDFestival = E.IDFestival AND BE.Ordinal = E.Ordinal
			WHERE IDBanda = @IDBanda AND FechaHoraInicio BETWEEN CAST (CURRENT_TIMESTAMP AS SMALLDATETIME) 
			AND CAST (DATEFROMPARTS (((YEAR (CURRENT_TIMESTAMP)) - 3), MONTH (CURRENT_TIMESTAMP), DAY (CURRENT_TIMESTAMP)) AS SMALLDATETIME)
			-- Utilizo DATEFROMPARTS para conseguir la fecha de 3 años antes de la actual.

		RETURN @Resultado

	END

GO


CREATE PROCEDURE actualizarCache
	@IDBanda SMALLINT

AS

	BEGIN
	DECLARE @NuevoCache SMALLMONEY

	SET @NuevoCache = dbo.miembrosActivos (@IDBanda) -- Añadimos al resultado el dinero extra del numero de miembros activos.
	SET @NuevoCache = @NuevoCache + dbo.numeroActuaciones (@IDBanda) -- Añadimos al resultado el dinero extra del numero de actuaciones en los ultimos 3 años.

	-- Comprobamos si el estilo de la banda es alguno de estos 4 para añadirle el porcentaje extra.

	IF EXISTS (SELECT *
				FROM LFBandasEstilos
				WHERE IDEstilo IN (SELECT ID
									 FROM LFEstilos
									 WHERE Estilo IN ('Rock', 'Flamenco', 'Jazz', 'Blues')))

			BEGIN

				SET @NuevoCache = @NuevoCache + ((@NuevoCache * 5)/100)

			END

	-- Comprobamos si el estilo de la banda es alguno de estos 2 para añadirle el procentaje extra.

	IF EXISTS (SELECT *
				FROM LFBandasEstilos
				WHERE IDEstilo IN (SELECT ID
									 FROM LFEstilos
									 WHERE Estilo IN ('Reggaeton', 'Hip-Hop')))
									 
			BEGIN

				SET @NuevoCache = @NuevoCache - ((@NuevoCache * 50)/100)

			END

	BEGIN TRANSACTION

	UPDATE LFBandas
	SET CacheMinimo = @NuevoCache
	WHERE ID = @IDBanda

	COMMIT TRANSACTION

	END

GO

BEGIN TRANSACTION

EXECUTE actualizarCache 6

SELECT dbo.miembrosActivos(6) -- Ejemplo comprobando la funcionalidad miembrosActivos
SELECT dbo.numeroActuaciones (3) -- Ejemplo comprobando la funcionalidad numeroActuaciones

ROLLBACK
COMMIT TRANSACTION


SELECT * FROM LFBandas
SELECT * FROM LFBandasEstilos
SELECT * FROM LFMusicosBandas WHERE IDBanda = 6
SELECT * FROM LFBandasEdiciones WHERE IDFestival = 1 AND Ordinal = 9
SELECT * FROM LFEdiciones WHERE IDFestival = 1 AND Ordinal = 9
SELECT * FROM LFEstilos WHERE ID = 27
SELECT * FROM LFTemas
SELECT * FROM LFMusicos
SELECT * FROM LFFestivales
SELECT * FROM LFTemasBandasEdiciones
