USE LeoMetroV2

GO


/* 0. La dimisión de Esperanza Aguirre ha causado tal conmoción entre los directivos de LeoMetro que han decidido conceder 
una amnistía a todos los pasajeros que tengan un saldo negativo en sus tarjetas.
Crea un procedimiento que recargue la cantidad necesaria para dejar a 0 el saldo de las tarjetas que tengan un saldo negativo 
y hayan sido recargadas al menos una vez en los últimos dos meses.
Ejercicio elaborado en colaboración con Sefran. */

BEGIN TRANSACTION

GO

CREATE PROCEDURE ConcederAmnistia

AS

	BEGIN

		IF EXISTS (SELECT T.Saldo
					 FROM LM_Tarjetas AS T
					 INNER JOIN
					 LM_Recargas AS R
					 ON T.ID = R.ID_Tarjeta
					 WHERE T.Saldo < 0 AND (R.Momento_Recarga BETWEEN CAST (CURRENT_TIMESTAMP AS SMALLDATETIME) AND CAST ((MONTH (CURRENT_TIMESTAMP) - 2) AS SMALLDATETIME)))

		BEGIN

			BEGIN TRANSACTION

			UPDATE LM_Tarjetas
			SET Saldo = 0

			COMMIT TRANSACTION

		END

	END

--ROLLBACK

COMMIT TRANSACTION


BEGIN TRANSACTION

EXECUTE ConcederAmnistia

COMMIT TRANSACTION

/* 1. Crea un procedimiento RecargarTarjeta que reciba como parámetros el ID de una tarjeta y un importe y actualice el saldo 
de la tarjeta sumándole dicho importe, además de grabar la correspondiente recarga */

BEGIN TRANSACTION

GO

CREATE PROCEDURE RecargarTarjeta
	@ID INT,
	@Importe SMALLMONEY

AS

	BEGIN

		BEGIN TRANSACTION

		INSERT INTO LM_Recargas (ID,ID_Tarjeta, Cantidad_Recarga, Momento_Recarga, SaldoResultante)
		VALUES (NEWID (), @ID, @Importe, CAST (CURRENT_TIMESTAMP AS SMALLDATETIME), (SELECT Saldo + @Importe
																			FROM LM_Tarjetas
																			WHERE ID = @ID))

		UPDATE LM_Tarjetas
		SET Saldo = Saldo + @Importe
		WHERE ID = @ID

		COMMIT TRANSACTION

	END

ROLLBACK

COMMIT TRANSACTION

/* 2. Crea un procedimiento almacenado llamado PasajeroSale que reciba como parámetros el ID de una tarjeta, el ID de una 
estación y una fecha/hora (opcional). El procedimiento se llamará cuando un pasajero pasa su tarjeta por uno de los tornos de 
salida del metro. Su misión es grabar la salida en la tabla LM_Viajes. Para ello deberá localizar la entrada que corresponda, 
que será la última entrada correspondiente al mismo pasajero y hará un update de las columnas que corresponda. 
Si no existe la entrada, grabaremos una nueva fila en LM_Viajes dejando a NULL la estación y el momento de entrada.
Si se omite el parámetro de la fecha/hora, se tomará la actual. */

BEGIN TRANSACTION

GO

CREATE PROCEDURE PasajeroSale
	@ID_Tarjeta INT,
	@ID_Estacion SMALLINT,
	@Fecha_Hora SMALLDATETIME = NULL

AS
	BEGIN

		IF (@Fecha_Hora IS NULL)

		BEGIN

		SET	@Fecha_Hora = CURRENT_TIMESTAMP

		END

		IF NOT EXISTS (SELECT IDEstacionEntrada
							FROM LM_Viajes
							WHERE MomentoEntrada IN (SELECT MomentoEntrada
														FROM LM_Viajes
														WHERE IDTarjeta = @ID_Tarjeta)) -- Cambiar el where del segundo select.
		BEGIN

			BEGIN TRANSACTION

			INSERT INTO LM_Viajes (IDTarjeta, IDEstacionSalida, MomentoSalida)
			VALUES (@ID_Tarjeta, @ID_Estacion, @Fecha_Hora)

			COMMIT TRANSACTION

		END

		ELSE

		BEGIN 
			
			BEGIN TRANSACTION

			UPDATE LM_Viajes
			SET MomentoSalida = @Fecha_Hora, 
			IDEstacionSalida = @ID_Estacion
			WHERE IDTarjeta = @ID_Tarjeta

			COMMIT TRANSACTION

		END

	END

ROLLBACK
COMMIT TRANSACTION

/* 3. A veces, un pasajero reclama que le hemos cobrado un viaje de forma indebida. Escribe un procedimiento que reciba como parámetro el ID de un pasajero 
y la fecha y hora de la entrada en el metro y anule ese viaje, actualizando además el saldo de la tarjeta que utilizó. */

BEGIN TRANSACTION

GO

CREATE PROCEDURE anularViaje
	@IDPasajero INT,
	@MomentoEntrada SMALLDATETIME

AS

	BEGIN
	DECLARE @Importe SMALLMONEY

		SET @Importe = (SELECT Importe_Viaje
							FROM LM_Viajes
							WHERE IDTarjeta = (SELECT ID
													FROM LM_Tarjetas
													WHERE IDPasajero = @IDPasajero) AND MomentoEntrada = @MomentoEntrada)



		BEGIN TRANSACTION

		DELETE FROM LM_Viajes WHERE ID = (SELECT ID
											FROM LM_Viajes
											WHERE IDTarjeta = (SELECT ID
																	FROM LM_Tarjetas
																	WHERE IDPasajero = @IDPasajero) AND MomentoEntrada = @MomentoEntrada)

		UPDATE LM_Tarjetas
		SET Saldo = Saldo + @Importe
		WHERE ID = (SELECT ID
						FROM LM_Tarjetas
						WHERE IDPasajero = @IDPasajero)

		COMMIT TRANSACTION

	END

--ROLLBACK

COMMIT TRANSACTION

GO

BEGIN TRANSACTION

GO

EXECUTE anularViaje 1, '24/02/2017 16:50'

COMMIT TRANSACTION

SELECT *
	FROM LM_Viajes

SELECT *
	FROM LM_Tarjetas
	WHERE ID = 1

/* 4. La empresa de Metro realiza una campaña de promoción para pasajeros fieles.

Crea un procedimiento almacenado que recargue saldo a los pasajeros que cumplan determinados requisitos. 
Se recargarán N1 euros a los pasajeros que hayan consumido más de 30 euros en el mes anterior (considerar mes completo, del día 1 al fin) y N2 euros a los que hayan utilizado más de 10 veces alguna estación de las zonas 3 o 4. 

Los valores de N1 y N2 se pasarán como parámetros. Si se omiten, se tomará el valor 5.

Ambos premios son excluyentes. Si algún pasajero cumple ambas condiciones se le aplicará la que suponga mayor bonificación de las dos. */

BEGIN TRANSACTION

GO

CREATE PROCEDURE Promocion
	@IDPasajero INT,
	@N1 SMALLMONEY = NULL,
	@N2 SMALLMONEY = NULL

AS

	BEGIN
	DECLARE @Resultado1 BIT
	DECLARE @Resultado2 BIT
		
		IF (@N1 IS NULL)
			BEGIN
				SET @N1 = 5
			END

		IF (@N2 IS NULL)
			BEGIN
				SET @N2 = 5
			END

		IF EXISTS (SELECT T.ID
					 FROM LM_Tarjetas AS T
					 INNER JOIN
					 LM_Viajes AS V
					 ON T.ID = V.IDTarjeta
					 WHERE V.MomentoEntrada BETWEEN DATEFROMPARTS (YEAR (CURRENT_TIMESTAMP), (MONTH (CURRENT_TIMESTAMP) - 1), 1) AND DATEFROMPARTS (YEAR (CURRENT_TIMESTAMP), (MONTH (CURRENT_TIMESTAMP) - 1), 30) AND IDPasajero =  @IDPasajero
					 GROUP BY T.ID
					 HAVING SUM (V.Importe_Viaje) > 30)
					 

			BEGIN
				
			SET @Resultado1 = 1

			END

		IF EXISTS (SELECT COUNT (V.ID)
						FROM LM_Estaciones AS E
						INNER JOIN
						LM_Viajes AS V
						ON E.ID = V.IDEstacionEntrada OR E.ID = V.IDEstacionSalida
						WHERE (IDEstacionEntrada IN (3,4) OR IDEstacionSalida IN (3,4)) AND IDTarjeta = (SELECT ID
																										FROM LM_Tarjetas
																										WHERE IDPasajero = 1)
						HAVING COUNT (V.ID) >= 10)
					 

		BEGIN
				
		SET @Resultado2 = 1

		END


		BEGIN TRANSACTION

		IF (@Resultado1 = 1 AND @Resultado2 = 1)

			BEGIN

			IF (@N1 > @N2)

				BEGIN

					UPDATE LM_Tarjetas
						SET Saldo = Saldo + @N1
						WHERE ID = (SELECT ID
										FROM LM_Tarjetas
										WHERE IDPasajero = @IDPasajero)

				END

			IF (@N2 > @N1)

				BEGIN

					UPDATE LM_Tarjetas
						SET Saldo = Saldo + @N2
						WHERE ID = (SELECT ID
										FROM LM_Tarjetas
										WHERE IDPasajero = @IDPasajero)

				END
			END

		ELSE

			IF (@Resultado1 = 1)

				BEGIN

					UPDATE LM_Tarjetas
							SET Saldo = Saldo + @N1
							WHERE ID = (SELECT ID
											FROM LM_Tarjetas
											WHERE IDPasajero = @IDPasajero)

				END

			IF (@Resultado2 = 1)

				BEGIN

					UPDATE LM_Tarjetas
						SET Saldo = Saldo + @N2
						WHERE ID = (SELECT ID
										FROM LM_Tarjetas
										WHERE IDPasajero = @IDPasajero)

				END

		COMMIT TRANSACTION

	END

--ROLLBACK
COMMIT TRANSACTION

SELECT *
	FROM LM_Tarjetas
	WHERE IDPasajero = 1

/*5. Crea una función que nos devuelva verdadero si es posible que un pasajero haya subido a un tren en un determinado viaje. Se pasará como parámetro el código del viaje y la matrícula del tren. */

BEGIN TRANSACTION

GO

CREATE PROCEDURE pasajeroEmbarcado /* Esto tiene que estar fatal */
	@IDViaje INT,
	@Matricula CHAR (7),
	@Resultado BIT OUTPUT

AS

	BEGIN

		IF EXISTS (SELECT IDTarjeta 
						FROM LM_Viajes AS V
						INNER JOIN
						LM_Estaciones AS E
						ON V.IDEstacionEntrada = E.ID OR V.IDEstacionEntrada = E.ID
						INNER JOIN
						LM_Recorridos AS R
						ON E.ID = R.estacion
						INNER JOIN
						LM_Trenes AS T
						ON R.Tren = T.ID
						WHERE T.Matricula = '0100FRY' AND V.ID = 1)

		BEGIN
		
			SET @Resultado = 1

		END

		RETURN
	END

--ROLLBACK
COMMIT TRANSACTION

SELECT ID
	FROM LM_Trenes
	WHERE Matricula = '0100FRY'

SELECT *
	FROM LM_Recorridos

SELECT *
	FROM LM_Tarjetas



/* 6. Crea un procedimiento SustituirTarjeta que Cree una nueva tarjeta y la asigne al mismo usuario y con el mismo saldo que otra tarjeta existente. El código de la tarjeta a sustituir se pasará como parámetro. */

BEGIN TRANSACTION

GO

CREATE PROCEDURE SustituirTarjeta
	@IDTarjeta INT

AS

	BEGIN

		BEGIN TRANSACTION
		
		INSERT INTO LM_Tarjetas (Saldo, IDPasajero)
		VALUES ((SELECT Saldo
					FROM LM_Tarjetas
					WHERE ID = 1), (SELECT IDPasajero
										FROM LM_Tarjetas
										WHERE ID = 1))

		COMMIT TRANSACTION

	END

--ROLLBACK

COMMIT TRANSACTION

BEGIN TRANSACTION

EXECUTE SustituirTarjeta 1

COMMIT TRANSACTION

/* 7. Las estaciones de la zona 3 tienen ciertas deficiencias, lo que nos ha obligado a introducir una serie de modificaciones en los trenes  para cumplir las medidas de seguridad.

A consecuencia de estas modificaciones, la capacidad de los trenes se ha visto reducida en 6 plazas para los trenes de tipo 1 y 4 plazas para los trenes de tipo 2.

Realiza un procedimiento al que se pase un intervalo de tiempo y modifique la capacidad de todos los trenes que hayan circulado más de una vez por alguna estación de la zona 3 en ese intervalo. */

BEGIN TRANSACTION

GO

CREATE PROCEDURE ModificarCapacidad
	@FechaInicial SMALLDATETIME,
	@FechaFinal SMALLDATETIME

AS

	BEGIN

	DECLARE @TrenesIntervalo TABLE
	(
		IDTren INT
	)

		INSERT INTO @TrenesIntervalo 
		SELECT T.ID, Tipo
			FROM LM_Trenes AS T
			INNER JOIN
			LM_Recorridos AS R
			ON T.ID = R.Tren
			INNER JOIN
			LM_Estaciones AS E
			ON R.estacion = E.ID
			INNER JOIN
			LM_Viajes AS V
			ON E.ID = V.IDEstacionEntrada OR E.ID = V.IDEstacionSalida
			WHERE (MomentoEntrada BETWEEN @FechaFinal AND @FechaFinal) OR (MomentoSalida BETWEEN @FechaInicial AND @FechaFinal) AND R.estacion IN (SELECT ID
																																					FROM LM_Estaciones
																																					WHERE Zona_Estacion = 3)


			/* De esta forma no contemplo que hayan pasado más de una vez por la misma estación */

			BEGIN TRANSACTION

			IF ((SELECT Tipo
					FROM @TrenesIntervalo) = 1)

					BEGIN

					UPDATE LM_Trenes
					SET Capacidad = Capacidad - 6
					WHERE ID IN (SELECT ID
									FROM @TrenesIntervalo) AND Tipo = 1

					END

			IF ((SELECT Tipo
					FROM @TrenesIntervalo) = 2)

					BEGIN

					UPDATE LM_Trenes
					SET Capacidad = Capacidad - 4
					WHERE ID IN (SELECT ID
									FROM @TrenesIntervalo) AND Tipo = 2

					END

			

			COMMIT TRANSACTION

	END

ROLLBACK

COMMIT TRANSACTION

SELECT *
	FROM LM_Estaciones