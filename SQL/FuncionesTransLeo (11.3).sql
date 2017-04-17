USE TransLeo

GO

/* 1. Crea un función fn_VolumenPaquete que reciba el código de un paquete y nos devuelva
su volumen. El volumen se expresa en litros (dm3) y será de tipo decimal (6,2). */

BEGIN TRANSACTION

GO

ALTER FUNCTION fn_VolumenPaquete2 (@CodigoPaquete INT)
RETURNS DECIMAL (12,2) AS
	BEGIN
		DECLARE @Volumen DECIMAl (12,2)
		SELECT @Volumen = Alto*Ancho*Largo
			FROM TL_PaquetesNormales
			RETURN @Volumen * 1000
	END

GO

--ROLLBACK
COMMIT TRANSACTION


SELECT dbo.fn_VolumenPaquete2 (600) AS pepejava

	SELECT *
		FROM TL_PaquetesNormales

/* 2. Los paquetes normales han de envolverse. Se calcula que la cantidad de papel necesaria
para envolver el paquete es 1,8 veces su superficie. Crea una función fn_PapelEnvolver
que reciba un código de paquete y nos devuelva la cantidad de papel necesaria para
envolverlo, en metros cuadrados.*/

GO

BEGIN TRANSACTION

GO

CREATE FUNCTION fn_PapelEnvolver (@Codigo INT)
RETURNS INT AS
	BEGIN
		DECLARE @Papel INT
		RETURN @Papel
	END

ROLLBACK
COMMIT TRANSACTION

GO