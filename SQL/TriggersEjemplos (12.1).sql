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
BEGIN
	DECLARE @PalabraInsertada VARCHAR (30)
	DECLARE cursorInserted CURSOR FOR SELECT Palabra FROM inserted
	DECLARE @PalabraImprimir VARCHAR (30) 
	OPEN cursorInserted
	FETCH NEXT FROM cursorInserted INTO @PalabraInsertada

	IF EXISTS(SELECT * FROM inserted)
	BEGIN
		WHILE (@@FETCH_STATUS = 0)
		BEGIN
			SELECT @PalabraImprimir = Palabra FROM inserted
			PRINT 'Insertada la palabra ' + @Palabraimprimir
			FETCH NEXT FROM cursorInserted INTO @PalabraInsertada
		END
		CLOSE cursorInserted
		DEALLOCATE cursorInserted
	END
END
GO

BEGIN TRANSACTION

INSERT INTO Palabras (Palabra)
VALUES ('Prueba1'),
       ('Prueba2')

--ROLLBACK
COMMIT TRANSACTION
/*
4.- Cada vez que se inserten filas que nos diga "XX filas insertadas”
*/
GO

CREATE TRIGGER numeroFilas2 ON Palabras
AFTER INSERT AS
BEGIN
	DECLARE @numero INT
	SELECT @Numero = COUNT (ID)
		FROM inserted

	PRINT CAST (@Numero AS VARCHAR) + ' filas insertadas'
END

BEGIN TRANSACTION

INSERT INTO Palabras (Palabra)
VALUES ('Prueba3'),
       ('Prueba4')

--ROLLBACK
COMMIT TRANSACTION

/*
5.- Que no permita introducir palabras repetidas (sin usar UNIQUE).
*/
GO

CREATE TRIGGER palabrasRepetidas ON Palabras
AFTER INSERT AS
BEGIN
	IF EXISTS(SELECT Palabra 
				FROM inserted
				WHERE Palabra IN (SELECT Palabra
									FROM Palabras))
	BEGIN
		ROLLBACK
	END
END

GO
-- Sobre LEO METRO
/*
6.- Comprueba que un pasajero no pueda entrar o salir por la misma estación más de tres
veces el mismo día
*/

USE LeoMetroV2

GO

CREATE TRIGGER pasajeroReincidente ON LM_Viajes
AFTER INSERT AS
BEGIN
	IF EXISTS (SELECT IDTarjeta
					FROM inserted
					WHERE DAY (MomentoEntrada) = DAY (CAST (GETDATE () AS SMALLDATETIME))
					GROUP BY IDTarjeta
					HAVING COUNT (IDEstacionEntrada) > 3 OR COUNT (IDEstacionSalida) > 3)
	BEGIN
		ROLLBACK
	END
END

GO

/*7.- Haz un trigger que al insertar un viaje compruebe que no hay otro viaje simultáneo */CREATE TRIGGER viajeSimultaneo ON LM_ViajesAFTER INSERT ASBEGIN	IF EXISTS (SELECT I.ID				FROM inserted AS I				INNER JOIN				LM_Viajes AS V				ON V.ID = I.ID				WHERE I.MomentoEntrada = V.MomentoEntrada)	BEGIN		ROLLBACK	ENDENDGO
--EJEMPLOS
/*
8.- Queremos evitar que se introduzcan palabras que terminen en "azo”
*/

USE EJEMPLOS --VOLVER A MIRAR ESTE EJERCICIO

GO

CREATE TRIGGER restriccionazo ON Palabras
AFTER INSERT AS
BEGIN
DECLARE @PalabraInsertada VARCHAR (30)
	DECLARE cursorInserted CURSOR FOR SELECT Palabra FROM inserted 
	OPEN cursorInserted
	FETCH NEXT FROM cursorInserted INTO @PalabraInsertada

	IF EXISTS (SELECT *
					FROM inserted)
	BEGIN
		WHILE (@@FETCH_STATUS = 0)
		BEGIN 

			IF EXISTS (SELECT @PalabraInsertada
						FROM Palabras
						WHERE RIGHT(@PalabraInsertada,3) = 'azo')
			BEGIN
				ROLLBACK
			END

			FETCH NEXT FROM cursorInserted INTO @PalabraInsertada
		END

		CLOSE cursorInserted
		DEALLOCATE cursorInserted
	END
END

GO
--Se incluye la posibilidad de que se modifiquen varias filas y de que haya que consultar otras tablas.

-- LEOFEST
USE LEOFEST

GO

/*9.- Cuando se inserte una nueva actuación de una banda hemos de comprobar que la banda
no se ha disuelto en esa fecha. */

CREATE TRIGGER bandaDisuelta ON LFEdiciones
AFTER INSERT AS
BEGIN
	SELECT *
		FROM inserted
END

GO

/* 10 .- Comprueba mediante un trigger que en una edición no actúan más de tres bandas de la
misma categoría. */