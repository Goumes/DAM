USE AirLeo

GO

/* 1. Escribe un procedimiento que cancele un pasaje y las tarjetas de embarque asociadas. 
Recibirá como parámetros el ID del pasaje. */

BEGIN TRANSACTION

GO

CREATE PROCEDURE CancelarPasajeEmbarque (@IDPasaje INT)
AS
	BEGIN

	select * from AL_Tarjetas where Numero_Pasaje = 0


		BEGIN TRANSACTION

		DELETE FROM AL_Tarjetas WHERE Numero_Pasaje = @IDPasaje
		DELETE FROM AL_Pasajes WHERE Numero = @IDPasaje
		DELETE FROM AL_Vuelos_Pasajes WHERE Numero_Pasaje = @IDPasaje

		--ROLLBACK
		COMMIT TRANSACTION

	END

GO

--ROLLBACK
COMMIT TRANSACTION


EXECUTE CancelarPasajeEmbarque 209

SELECT *
	FROm AL_Tarjetas


/* 2. Escribe un procedimiento almacenado que reciba como parámetro el ID de un pasajero y devuelva en un parámetro 
de salida el número de vuelos diferentes que ha tomado ese pasajero. */

BEGIN TRANSACTION

GO

CREATE PROCEDURE NumeroVuelos 
	@IDPasajero CHAR (9),
	@NumeroVuelosDiferentes INT OUTPUT
AS
	BEGIN
		SELECT DISTINCT COUNT (Codigo_Vuelo)
			FROM AL_Pasajeros AS P
			INNER JOIN
			AL_Pasajes AS Pa
			ON P.ID = Pa.ID_Pasajero
			INNER JOIN
			AL_Vuelos_Pasajes AS VP
			ON Pa.Numero = VP.Numero_Pasaje
			WHERE P.ID = @IDPasajero

		RETURN
	END
GO

ROLLBACK
COMMIT TRANSACTION

DECLARE @NumeroVuelosDiferentesResultados INT
EXECUTE NumeroVuelos 'A003', @NumeroVuelosDiferentes = @NumeroVuelosDiferentesResultados OUTPUT

/* 3. Escribe un procedimiento almacenado que reciba como parámetro el ID de un pasajero y dos fechas y nos 
devuelva en otro parámetro (de salida) el número de horas que ese pasajero ha volado durante ese intervalo de fechas.*/

BEGIN TRANSACTION

GO

CREATE PROCEDURE TiempoVolado
	@IDPasajero CHAR (9),
	@FechaInicial SMALLDATETIME,
	@FechaFinal SMALLDATETIME,
	@TiempoEnVuelo DECIMAL (5,2) OUTPUT

	AS

	BEGIN
		SELECT SUM (DATEPART (HOUR, (Llegada - Salida)))
			FROM AL_Vuelos AS V
			INNER JOIN
			AL_Vuelos_Pasajes AS VP
			ON V.Codigo = VP.Codigo_Vuelo
			INNER JOIN
			AL_Pasajes AS P
			ON VP.Numero_Pasaje = P.Numero
			WHERE P.ID_Pasajero = @IDPasajero AND (Salida BETWEEN @FechaInicial AND @FechaFinal) AND (Llegada BETWEEN @FechaInicial AND @FechaFinal)

		RETURN
	END

ROLLBACK

COMMIT TRANSACTION

DECLARE @TiempoEnVueloResultado DECIMAL (5,2)
EXECUTE TiempoVolado 'A003', '01/01/2008 12:30', '01/12/2015 12:30', @TiempoEnVuelo = @TiempoEnVueloResultado OUTPUT

/* 4. Escribe un procedimiento que reciba como parámetro todos los datos de un pasajero y un número de vuelo y realice el siguiente proceso:
En primer lugar, comprobará si existe el pasajero. Si no es así, lo dará de alta. A continuación comprobará si el vuelo 
tiene plazas disponibles (hay que consultar la capacidad del avión) y en caso afirmativo creará un nuevo pasaje para ese vuelo.*/

BEGIN TRANSACTION

GO

ALTER PROCEDURE RegistrarVuelo
	@ID CHAR (9),
	@Nombre VARCHAR (20),
	@Apellidos VARCHAR (50),
	@Direccion VARCHAR (60),
	@Fecha_Nacimiento DATE,
	@Nacionalidad VARCHAR (30),
	@Codigo_Vuelo INT

	AS

	BEGIN
		DECLARE @Capacidad INT
		DECLARE @Pasajes_Vendidos INT
		DECLARE @NumeroDelPasaje INT

		IF NOT EXISTS  (SELECT *
						FROM AL_Pasajeros
						WHERE ID = @ID)
			BEGIN

				INSERT INTO AL_Pasajeros (ID, Nombre, Apellidos, Direccion, Fecha_Nacimiento, Nacionalidad)
				VALUES
						(@ID, @Nombre, @Apellidos, @Direccion, @Fecha_Nacimiento, @Nacionalidad)
			END

		ELSE PRINT 'El cliente ya existe'

		/* La capacidad del avión es el numero de asientos_x_fila * filas. Si el numero de pasajes vendidos en un vuelo es menor al resultado
		del calculo de la capacidad del avión, significa que hay plazas libres. */

		SELECT @Capacidad = Asientos_x_Fila * Filas
			FROM AL_Aviones AS A
			INNER JOIN
			AL_Vuelos AS V
			ON A.Matricula = V.Matricula_Avion
			WHERE V.Codigo = @Codigo_Vuelo

		
		SELECT @Pasajes_Vendidos = COUNT (Numero)
			FROM AL_Pasajes AS P
			INNER JOIN
			AL_Vuelos_Pasajes AS VP
			ON P.Numero = VP.Numero_Pasaje
			WHERE VP.Codigo_Vuelo = @Codigo_Vuelo

		IF (@Capacidad > @Pasajes_Vendidos)

			BEGIN
		
				BEGIN TRANSACTION

				INSERT INTO AL_Pasajes (ID_Pasajero)
				VALUES (@ID)

				SET @NumeroDelPasaje = @@IDENTITY

				INSERT INTO AL_Vuelos_Pasajes (Codigo_Vuelo, Numero_Pasaje, Embarcado)
				VALUES (@Codigo_Vuelo, @NumeroDelPasaje, 'N')

				COMMIT TRANSACTION
			END

		ELSE PRINT 'Lo sentimos, todos los asientos están ocupados.'
	END

--ROLLBACK
COMMIT TRANSACTION

GO

BEGIN TRANSACTION

SET DATEFORMAT YMD
DECLARE @ID CHAR (9) = 'P3P3'
DECLARE	@Nombre VARCHAR (20) = 'pepe'
DECLARE	@Apellidos VARCHAR (50) = 'java'
DECLARE	@Direccion VARCHAR (60) = 'el valle de la silicona'
DECLARE	@Fecha_Nacimiento DATE = '1993-12-25'
DECLARE	@Nacionalidad VARCHAR (30) = 'Oracle'
DECLARE	@Codigo_Vuelo INT = '3'

EXECUTE RegistrarVuelo @ID, @Nombre, @Apellidos, @Direccion, @Fecha_Nacimiento, @Nacionalidad, @Codigo_Vuelo


ROLLBACK


 
SELECT * FROM AL_Pasajeros
SELECT * FROM AL_Pasajes
SELECT * FROM AL_Vuelos

/* 5. Escribe un procedimiento almacenado que cancele un vuelo y reubique a sus pasajeros en otro. 
Se ocuparán los asientos libres en el vuelo sustituto. Se comprobará que ambos vuelos realicen el mismo recorrido. 
Se borrarán todos los pasajes y las tarjetas de embarque y se generarán nuevos pasajes. No se generarán nuevas tarjetas 
de embarque. El vuelo a cancelar y el sustituto se pasarán como parámetros. Si no se pasa el vuelo sustituto, 
se buscará el primer vuelo inmediatamente posterior al cancelado que realice el mismo recorrido. */

BEGIN TRANSACTION

GO

CREATE PROCEDURE CambiarVuelo
	@CodigoCancelar INT,
	@CodigoSustituto INT = NULL

	AS

		BEGIN

		DECLARE @PasajeroInicial INT
		DECLARE @PasajeroFinal INT 

		DECLARE @Tabla TABLE (
		pepejava INT,			--   \0_  \0_  \0_
		pepejava2 CHAR (9)		--	 \0_  \0_  \0_
		)

		IF (@CodigoSustituto IS NULL)
		BEGIN
		 /*
		SET @CodigoSustituto = @CodigoCancelar + 1
			WHILE ((SELECT Salida, Llegada
						FROM AL_Vuelos
						WHERE Codigo = @CodigoSustituto) != (SELECT Salida, Llegada
																FROM AL_Vuelos
																WHERE Codigo = @CodigoCancelar))
			BEGIN
				SET @CodigoSustituto = @CodigoSustituto + 1
			END
		END
		*/

		IF EXISTS (SELECT Salida, Llegada
						FROM AL_Vuelos
						WHERE Codigo = @CodigoCancelar)


		IF ((SELECT Salida, Llegada
				FROM AL_Vuelos
				WHERE Codigo = @CodigoSustituto) = (SELECT Salida, Llegada
														FROM AL_Vuelos
														WHERE Codigo = @CodigoCancelar))
			BEGIN

				BEGIN TRANSACTION

					-- Guardamos en una variable el ultimo Numero de los pasajes antes de hacer el insert.

					SET @PasajeroInicial =
					(SELECT TOP (1) Numero
						FROM AL_Pasajes
						ORDER BY Numero DESC)

					-- Sacamos las IDs de los pasajeros del vuelo cancelado y creamos los pasajes del vuelo nuevo

					INSERT INTO AL_Pasajes (ID_Pasajero)

					(SELECT ID_Pasajero
						FROM AL_Pasajes
						WHERE Numero IN (SELECT Numero_Pasaje
											FROM AL_Vuelos_Pasajes
											WHERE Codigo_Vuelo = @CodigoCancelar))

					/* Sacar el ID del ultimo pasajero existente antes del insert, y en el where hacer un between de entre este pasajero
					y el ultimo despues del insert. Utilizar @@Identity para guardar el ID del pasajero.*/

					SET @PasajeroFinal = @@IDENTITY

					-- Introducimos los pasajeros en el nuevo vuelo

					INSERT INTO AL_Vuelos_Pasajes (Codigo_Vuelo, Numero_Pasaje)

					(SELECT @CodigoSustituto, (SELECT Numero
													FROM AL_Pasajes
													WHERE Numero BETWEEN (@PasajeroInicial + 1) AND @PasajeroFinal)
						FROM AL_Vuelos_Pasajes
						WHERE Codigo_Vuelo = @CodigoCancelar)

					-- Borramos los pasajes y las tarjetas del vuelo cancelado

					DELETE FROM AL_Vuelos_Pasajes WHERE Codigo_Vuelo = @CodigoCancelar
					DELETE FROM AL_Vuelos WHERE Codigo = @CodigoCancelar
					DELETE FROM AL_Tarjetas WHERE Codigo_Vuelo = @CodigoCancelar
					DELETE FROM AL_Pasajes WHERE ID_Pasajero IN (SELECT ID_Pasajero
																	FROM AL_Pasajes
																	WHERE Numero IN (SELECT Numero_Pasaje
																						FROM AL_Vuelos_Pasajes
																						WHERE Codigo_Vuelo = @CodigoCancelar))
				
				COMMIT TRANSACTION

			END

			ELSE PRINT 'Los vuelos no tienen el mismo recorrido'
		END

--ROLLBACK

COMMIT TRANSACTION

/* 6. Escribe un procedimiento al que se pase como parámetros un código de un avión y un momento (dato fecha-hora) y 
nos escriba un mensaje que indique dónde se encontraba ese avión en ese momento. El mensaje puede ser "En vuelo entre 
los aeropuertos de NombreAeropuertoSalida y NombreaeropuertoLlegada” si el avión estaba volando en ese momento, o 
"En tierra en el aeropuerto NombreAeropuerto” si no está volando. Para saber en qué aeropuerto se encuentra el avión 
debemos consultar el último vuelo que realizó antes del momento indicado.
Si se omite el segundo parámetro, se tomará el momento actual.*/