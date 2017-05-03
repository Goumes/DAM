USE LeoMetroV2

GO


/* 0. La dimisi�n de Esperanza Aguirre ha causado tal conmoci�n entre los directivos de LeoMetro que han decidido conceder 
una amnist�a a todos los pasajeros que tengan un saldo negativo en sus tarjetas.
Crea un procedimiento que recargue la cantidad necesaria para dejar a 0 el saldo de las tarjetas que tengan un saldo negativo 
y hayan sido recargadas al menos una vez en los �ltimos dos meses.
Ejercicio elaborado en colaboraci�n con Sefran. */

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

/* 1. Crea un procedimiento RecargarTarjeta que reciba como par�metros el ID de una tarjeta y un importe y actualice el saldo 
de la tarjeta sum�ndole dicho importe, adem�s de grabar la correspondiente recarga */

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

/* 2. Crea un procedimiento almacenado llamado PasajeroSale que reciba como par�metros el ID de una tarjeta, el ID de una 
estaci�n y una fecha/hora (opcional). El procedimiento se llamar� cuando un pasajero pasa su tarjeta por uno de los tornos de 
salida del metro. Su misi�n es grabar la salida en la tabla LM_Viajes. Para ello deber� localizar la entrada que corresponda, 
que ser� la �ltima entrada correspondiente al mismo pasajero y har� un update de las columnas que corresponda. 
Si no existe la entrada, grabaremos una nueva fila en LM_Viajes dejando a NULL la estaci�n y el momento de entrada.
Si se omite el par�metro de la fecha/hora, se tomar� la actual. */

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

/* 3. A veces, un pasajero reclama que le hemos cobrado un viaje de forma indebida. Escribe un procedimiento que reciba como par�metro el ID de un pasajero y la fecha y hora de la entrada en el metro y anule ese viaje, actualizando adem�s el saldo de la tarjeta que utiliz�. */

/* 4. La empresa de Metro realiza una campa�a de promoci�n para pasajeros fieles.

Crea un procedimiento almacenado que recargue saldo a los pasajeros que cumplan determinados requisitos. 
Se recargar�n N1 euros a los pasajeros que hayan consumido m�s de 30 euros en el mes anterior (considerar mes completo, del d�a 1 al fin) y N2 euros a los que hayan utilizado m�s de 10 veces alguna estaci�n de las zonas 3 o 4. 

Los valores de N1 y N2 se pasar�n como par�metros. Si se omiten, se tomar� el valor 5.

Ambos premios son excluyentes. Si alg�n pasajero cumple ambas condiciones se le aplicar� la que suponga mayor bonificaci�n de las dos. */

/*5. Crea una funci�n que nos devuelva verdadero si es posible que un pasajero haya subido a un tren en un determinado viaje. Se pasar� como par�metro el c�digo del viaje y la matr�cula del tren. */

/* 6. Crea un procedimiento SustituirTarjeta que Cree una nueva tarjeta y la asigne al mismo usuario y con el mismo saldo que otra tarjeta existente. El c�digo de la tarjeta a sustituir se pasar� como par�metro. */


/* 7. Las estaciones de la zona 3 tienen ciertas deficiencias, lo que nos ha obligado a introducir una serie de modificaciones en los trenes  para cumplir las medidas de seguridad.

A consecuencia de estas modificaciones, la capacidad de los trenes se ha visto reducida en 6 plazas para los trenes de tipo 1 y 4 plazas para los trenes de tipo 2.

Realiza un procedimiento al que se pase un intervalo de tiempo y modifique la capacidad de todos los trenes que hayan circulado m�s de una vez por alguna estaci�n de la zona 3 en ese intervalo. */