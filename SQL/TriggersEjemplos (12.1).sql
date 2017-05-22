USE Ejemplos

GO

CREATE TABLE Palabras (

ID SmallInt Not Null Identity Constraint PK_Palabras Primary Key

,Palabra VarChar(30) Null

)

-- Nota: No olvides probar cada trigger con diferentes valores.

--Sin usar datos modificados
/*
1.- Queremos que cada vez que se actualice la tabla Palabras aparezca un mensaje diciendo si se han añadido, 
borrado o actualizado filas. Pista: Crea tres triggers diferentes. 
*/
GO

CREATE TRIGGER actualizarPalabras ON Palabras
AFTER UPDATE AS

IF EXISTS (SELECT * FROM inserted)

BEGIN
	Print 'Se han actualizado datos en la tabla Palabras correctamente.'
END

GO


CREATE TRIGGER borrarPalabras ON Palabras
AFTER DELETE AS

IF EXISTS (SELECT * FROM deleted)

BEGIN
	Print 'Se han borrado datos en la tabla Palabras correctamente.'
END

GO


CREATE TRIGGER insertarPalabras ON Palabras
AFTER INSERT AS

IF EXISTS (SELECT * FROM inserted)

BEGIN
	Print 'Se han insertado datos en la tabla Palabras correctamente.'
END

GO

BEGIN TRANSACTION

INSERT INTO Palabras (Palabra)
VALUES ('pepejava')

DELETE FROM Palabras WHERE Palabra = 'pepejava2'

UPDATE Palabras
SET Palabra = 'pepejava2'
WHERE Palabra = 'pepejava'

ROLLBACK
COMMIT TRANSACTION
/*
2.- Haz un trigger que cada vez que se aumente o disminuya el número de filas de la tabla Palabras nos diga cuántas filas hay. 
*/
GO

CREATE TRIGGER numeroFilas ON Palabras
AFTER INSERT AS

DECLARE @Resultado INT
IF EXISTS (SELECT * FROM inserted)

BEGIN

	SELECT @Resultado = COUNT (ID) FROM Palabras

	PRINT 'La tabla tiene ' + CAST (@Resultado AS VARCHAR) + ' filas.'

END

GO

CREATE TRIGGER numeroFilasBorrar ON Palabras
AFTER DELETE AS

DECLARE @Resultado INT
IF EXISTS (SELECT * FROM deleted)

BEGIN

	SELECT COUNT (ID) AS NumeroFilas FROM Palabras

	PRINT 'La tabla tiene ' + CAST (@Resultado AS VARCHAR) + ' filas.'

END

GO


BEGIN TRANSACTION

INSERT INTO Palabras (Palabra)
VALUES ('pepejava2')


ROLLBACK
COMMIT TRANSACTION
/*
3.-  Cada vez que se inserte una fila queremos que se muestre un mensaje indicando "Insertada la palabra ________”
*/
--Se usan inserted y deleted. Si es complicado procesar varias filas, supón que se modifica sólo una.
GO

CREATE TRIGGER palabraInsertada ON Palabras
AFTER INSERT AS

print ''

GO
/*
4.- Cada vez que se inserten filas que nos diga "XX filas insertadas”
*/

/*
5.- que no permita introducir palabras repetidas (sin usar UNIQUE).
*/

-- Sobre LEO METRO
/*
6.- Comprueba que un pasajero no pueda entrar o salir por la misma estación más de tres
veces el mismo día
*/
/*7.- Haz un trigger que al insertar un viaje compruebe que no hay otro viaje simultáneo */
--EJEMPLOS
/*
8.- Queremos evitar que se introduzcan palabras que terminen en "azo”
*/
--Se incluye la posibilidad de que se modifiquen varias filas y de que haya que consultar otras tablas.