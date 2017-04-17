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

		--ROLLBACK
		COMMIT TRANSACTION


		BEGIN TRANSACTION
		DELETE FROM AL_Pasajes WHERE Numero = @IDPasaje

		--ROLLBACK
		COMMIT TRANSACTION

	END

GO

--ROLLBACK
COMMIT TRANSACTION

-- NO EJECUTAR