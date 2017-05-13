USE TransLeo

GO

/* 1. Crea un función fn_VolumenPaquete que reciba el código de un paquete y nos devuelva
su volumen. El volumen se expresa en litros (dm3) y será de tipo decimal (6,2). */

BEGIN TRANSACTION

GO

CREATE FUNCTION fn_VolumenPaquete2 (@CodigoPaquete INT)
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


SELECT dbo.fn_VolumenPaquete2 (600) AS Volumen


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

		SELECT @Papel = (2 * (Largo * Ancho + Largo * Alto + Ancho * Alto) * 1.8) 
			FROM TL_PaquetesNormales
			WHERE Codigo = @Codigo

		RETURN @Papel
	END

ROLLBACK
COMMIT TRANSACTION

GO

SELECT dbo.fn_PapelEnvolver (600) AS CantidadDePapel

/* 3. Crea una función fn_OcupacionFregoneta a la que se pase el código de un vehículo y una
fecha y nos indique cuál es el volumen total que ocupan los paquetes que ese vehículo
entregó en el día en cuestión. Usa las funciones de fecha y hora para comparar sólo el día,
independientemente de la hora*/

BEGIN TRANSACTION

GO

ALTER FUNCTION fn_OcupacionFregoneta (@Codigo INT, @Fecha SMALLDATETIME)
RETURNS INT AS
	BEGIN
		DECLARE @Volumen INT

		SELECT @Volumen = SUM (Alto*Ancho*Largo)
			FROM TL_PaquetesNormales
			WHERE CAST (fechaEntrega AS DATE) = DATEFROMPARTS (YEAR (@Fecha), MONTH (@Fecha), DAY (@Fecha)) AND codigoFregoneta = @Codigo
		
		RETURN @Volumen
	END

ROLLBACK

COMMIT TRANSACTION

SELECT dbo.fn_OcupacionFregoneta (3, '14/03/2013 00:00') AS VolumenTotal

SELECT *
	FROM TL_PaquetesNormales