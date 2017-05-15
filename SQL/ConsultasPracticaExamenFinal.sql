USE LeoFest

GO

BEGIN TRANSACTION

INSERT INTO LFMusicos(ID, Nombre, Apellidos, NombreArtistico, Direccion, Ciudad, Telefono1)
VALUES (1, 'Rick', 'Astley', 'Rick Roll', 'Su casa', 'Sevilla', '987876958')

INSERT INTO LFEstilos (ID, Estilo)
VALUES ((SELECT TOP (1) ID FROM LFEstilos ORDER BY ID DESC) + 1, 'Dios')

INSERT INTO LFTemas (ID, Titulo, IDAutor, IDEstilo, Duracion)
VALUES (NEWID (), 'Never gonna give you up', '1', '1', '3:40')

INSERT INTO LFBandas (NombreBanda, FechaFormacion)
VALUES ('La banda de Rick', '12/02/1998')

INSERT INTO LFBandasEstilos (IDBanda, IDEstilo)
VALUES (@@IDENTITY, 30)

INSERT INTO LFMusicosBandas (ID, IDBanda, IDMusico, FechaIncorporacion)
VALUES (NEWID (), '1', '1', '12/2/1998')

INSERT INTO LFFestivales(Denominacion, Comentarios)
VALUES ('El javaFestival', 'Mola un taco')

INSERT INTO LFEdiciones (IDFestival, Ordinal, Lema, Lugar, Ciudad, ComunidadAutonoma, FechaHoraInicio, FechaHoraFin)
VALUES (1, 1, 'Vamono de rave hente', 'Cai', 'Cadiz', 'Andalusia', '16/05/17 8:00', '16/05/17 11:15')

INSERT INTO LFBandasEdiciones (IDBanda, IDFestival, Ordinal, Categoria)
VALUES (1, 1, 1, 1)

INSERT INTO LFTemasBandasEdiciones (IDBanda, IDFestival, Ordinal, IDTema, Momento)
VALUES (1, 1, 1, (SELECT ID FROM LFTemas WHERE Titulo = 'Never gonna give you up'), '16/05/17 8:00')

ROLLBACK
COMMIT TRANSACTION

/* 1. Hallar los musicos que han tocado en X banda pasada por parámetros.*/

GO

ALTER FUNCTION musicosBanda (@IDBanda SMALLINT)

RETURNS @Tabla TABLE (
						pepejava INT
					 ) 
AS

	BEGIN
		INSERT INTO @Tabla
		SELECT IDMusico
			FROM LFMusicosBandas
			WHERE IDBanda = @IDBanda

		RETURN
	END

GO

SELECT * FROM musicosBanda ('3')



SELECT * FROM LFTemas
SELECT * FROM LFBandasEstilos
SELECT * FROM LFFestivales
SELECT * FROM LFEstilos
SELECT * FROM LFTemasBandasEdiciones
SELECT * FROM LFBandasEdiciones
SELECT * FROM LFMusicosBandas
SELECT * FROM LFMusicos
SELECT * FROM LFBandasEstilos
SELECT * FROM LFEdiciones
