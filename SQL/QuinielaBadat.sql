CREATE DATABASE Quinielas

GO

USE Quinielas

GO

CREATE TABLE Temporadas
(
	ID INT IDENTITY (1,1) NOT NULL,
	Numero INT NOT NULL,

	CONSTRAINT PK_Temporadas PRIMARY KEY (ID)
)



GO

CREATE TABLE Jornadas
(
	ID INT IDENTITY (1,1) NOT NULL,
	Fecha DATE NOT NULL,
	IDTemporada INT NOT NULL,
	Estado BIT NOT NULL,

	CONSTRAINT PK_Jornadas PRIMARY KEY (ID),
	CONSTRAINT FK_Jornadas_Temporadas FOREIGN KEY (IDTemporada) REFERENCES Temporadas (ID) ON UPDATE CASCADE ON DELETE NO ACTION
)

GO

CREATE TABLE Boletos
(
	ID INT IDENTITY (1,1) NOT NULL,
	IDJornada INT NOT NULL,
	NumeroApuestas INT NOT NULL,

	CONSTRAINT PK_Boletos PRIMARY KEY (ID),
	CONSTRAINT UQ_Boletos_ID UNIQUE (ID),
	CONSTRAINT FK_Boletos_Jornadas FOREIGN KEY (IDJornada) REFERENCES Jornadas (ID) ON UPDATE CASCADE ON DELETE NO ACTION
)

GO


CREATE TABLE Partidos
(
	ID INT IDENTITY (1,1) NOT NULL,
	Equipo1 VARCHAR (50) NOT NULL,
	Equipo2 VARCHAR (50) NOT NULL,
	Resultado VARCHAR (3) NULL,
	IDJornada INT NOT NULL,
	
	CONSTRAINT PK_Partidos PRIMARY KEY (ID),
	CONSTRAINT FK_Partidos_Jornadas FOREIGN KEY (IDJornada) REFERENCES Jornadas (ID) ON UPDATE CASCADE ON DELETE NO ACTION
)

GO


GO

CREATE TABLE Apuestas
(
	ID INT IDENTITY (1,1) NOT NULL,
	IDBoleto INT NOT NULL,
	Tipo VARCHAR (7) NOT NULL,
	Prediccion1 VARCHAR (3) NOT NULL,
	Prediccion2 VARCHAR (3) NOT NULL,
	Prediccion3 VARCHAR (3) NOT NULL,
	Prediccion4 VARCHAR (3) NOT NULL,
	Prediccion5 VARCHAR (3) NOT NULL,
	Prediccion6 VARCHAR (3) NOT NULL,
	Prediccion7 VARCHAR (3) NOT NULL,
	Prediccion8 VARCHAR (3) NOT NULL,
	Prediccion9 VARCHAR (3) NOT NULL,
	Prediccion10 VARCHAR (3) NOT NULL,
	Prediccion11 VARCHAR (3) NOT NULL,
	Prediccion12 VARCHAR (3) NOT NULL,
	Prediccion13 VARCHAR (3) NOT NULL,
	Prediccion14 VARCHAR (3) NOT NULL,
	PrediccionPleno VARCHAR (4) NULL,

	CONSTRAINT PK_Apuesta PRIMARY KEY (ID, IDBoleto),
	CONSTRAINT FK_Apuestas_Boletos FOREIGN KEY (IDBoleto) REFERENCES Boletos (ID) ON UPDATE CASCADE ON DELETE CASCADE
)

GO

CREATE TABLE Boletos_Partidos
(
	IDBoleto INT NOT NULL,
	IDPartido INT NOT NULL,
	GolesEquipo1 INT NULL,
	GolesEquipo2 INT NULL,

	CONSTRAINT PK_Boletos_Partidos PRIMARY KEY (IDBoleto, IDPartido),
	CONSTRAINT FK_Boletos_Partidos_Boletos FOREIGN KEY (IDBoleto) REFERENCES Boletos (ID) ON UPDATE CASCADE ON DELETE NO ACTION,
	CONSTRAINT FK_Boletos_Partidos_Partidos FOREIGN KEY (IDPartido) REFERENCES Partidos (ID) ON UPDATE NO ACTION ON DELETE NO ACTION --Cambiar estos dos update y cascade
)

GO

CREATE TABLE Premios
(
	ID INT NOT NULL,
	IDJornada INT NOT NULL,
	Categoria INT NOT NULL,
	Valor MONEY NULL,

	CONSTRAINT PK_Premios PRIMARY KEY (ID),
	CONSTRAINT FK_Premios_Jornadas FOREIGN KEY (IDJornada) REFERENCES Jornadas (ID)
)

GO

CREATE TABLE Boletos_Premios
(
	IDBoleto INT NOT NULL,
	IDPremio INT NOT NULL,

	CONSTRAINT PK_Boletos_Premios PRIMARY KEY (IDBoleto,IDPremio),
	CONSTRAINT FK_Boletos_Premios_Boletos FOREIGN KEY (IDBoleto) REFERENCES Boletos (ID) ON UPDATE CASCADE ON DELETE NO ACTION,
	CONSTRAINT FK_Boletos_Premios_Premios FOREIGN KEY (IDPremio) REFERENCES Premios (ID) ON UPDATE CASCADE ON DELETE NO ACTION
)

ALTER TABLE Apuestas ADD CONSTRAINT CK_Apuestas_Tipo CHECK (Tipo IN ('Simple', 'Multiple'))
ALTER TABLE Jornadas ADD CONSTRAINT CK_Jornadas_Estado CHECK (Estado IN ('Abierto', 'Cerrado'))
ALTER TABLE Premios ADD CONSTRAINT CK_Premios_Categoria CHECK (Categoria BETWEEN 1 AND 6)
ALTER TABLE Apuestas ADD CONSTRAINT CK_Apuestas_Prediccion1 CHECK (Prediccion1 IN ('1', 'X', '2', '1X', '12', 'X2', '1X2'))
ALTER TABLE Apuestas ADD CONSTRAINT CK_Apuestas_Prediccion2 CHECK (Prediccion2 IN ('1', 'X', '2', '1X', '12', 'X2', '1X2'))
ALTER TABLE Apuestas ADD CONSTRAINT CK_Apuestas_Prediccion3 CHECK (Prediccion3 IN ('1', 'X', '2', '1X', '12', 'X2', '1X2'))
ALTER TABLE Apuestas ADD CONSTRAINT CK_Apuestas_Prediccion4 CHECK (Prediccion4 IN ('1', 'X', '2', '1X', '12', 'X2', '1X2'))
ALTER TABLE Apuestas ADD CONSTRAINT CK_Apuestas_Prediccion5 CHECK (Prediccion5 IN ('1', 'X', '2', '1X', '12', 'X2', '1X2'))
ALTER TABLE Apuestas ADD CONSTRAINT CK_Apuestas_Prediccion6 CHECK (Prediccion6 IN ('1', 'X', '2', '1X', '12', 'X2', '1X2'))
ALTER TABLE Apuestas ADD CONSTRAINT CK_Apuestas_Prediccion7 CHECK (Prediccion7 IN ('1', 'X', '2', '1X', '12', 'X2', '1X2'))
ALTER TABLE Apuestas ADD CONSTRAINT CK_Apuestas_Prediccion8 CHECK (Prediccion8 IN ('1', 'X', '2', '1X', '12', 'X2', '1X2'))
ALTER TABLE Apuestas ADD CONSTRAINT CK_Apuestas_Prediccion9 CHECK (Prediccion9 IN ('1', 'X', '2', '1X', '12', 'X2', '1X2'))
ALTER TABLE Apuestas ADD CONSTRAINT CK_Apuestas_Prediccion10 CHECK (Prediccion10 IN ('1', 'X', '2', '1X', '12', 'X2', '1X2'))
ALTER TABLE Apuestas ADD CONSTRAINT CK_Apuestas_Prediccion11 CHECK (Prediccion11 IN ('1', 'X', '2', '1X', '12', 'X2', '1X2'))
ALTER TABLE Apuestas ADD CONSTRAINT CK_Apuestas_Prediccion12 CHECK (Prediccion12 IN ('1', 'X', '2', '1X', '12', 'X2', '1X2'))
ALTER TABLE Apuestas ADD CONSTRAINT CK_Apuestas_Prediccion13 CHECK (Prediccion13 IN ('1', 'X', '2', '1X', '12', 'X2', '1X2'))
ALTER TABLE Apuestas ADD CONSTRAINT CK_Apuestas_Prediccion14 CHECK (Prediccion14 IN ('1', 'X', '2', '1X', '12', 'X2', '1X2'))
ALTER TABLE Apuestas ADD CONSTRAINT CK_Apuestas_Prediccion15 CHECK (PrediccionPleno IN ('0', '1', '2', 'M', '01', '02', '0M', 
																									'12', '1M', '2M', '012', '01M', '12M', '012M'))

ALTER TABLE Apuestas ADD CONSTRAINT CK_Apuestas_Longitud1 CHECK ((Tipo = 'Simple' AND LEN (Prediccion1) = 1) 
																	OR (Tipo = 'Multiple' AND LEN (Prediccion1) IN (2, 3)))

ALTER TABLE Apuestas ADD CONSTRAINT CK_Apuestas_Longitud2 CHECK ((Tipo = 'Simple' AND LEN (Prediccion2) = 1) 
																	OR (Tipo = 'Multiple' AND LEN (Prediccion2) IN (2, 3)))

ALTER TABLE Apuestas ADD CONSTRAINT CK_Apuestas_Longitud3 CHECK ((Tipo = 'Simple' AND LEN (Prediccion3) = 1) 
																	OR (Tipo = 'Multiple' AND LEN (Prediccion3) IN (2, 3)))

ALTER TABLE Apuestas ADD CONSTRAINT CK_Apuestas_Longitud4 CHECK ((Tipo = 'Simple' AND LEN (Prediccion4) = 1) 
																	OR (Tipo = 'Multiple' AND LEN (Prediccion4) IN (2, 3)))

ALTER TABLE Apuestas ADD CONSTRAINT CK_Apuestas_Longitud5 CHECK ((Tipo = 'Simple' AND LEN (Prediccion5) = 1) 
																	OR (Tipo = 'Multiple' AND LEN (Prediccion5) IN (2, 3)))

ALTER TABLE Apuestas ADD CONSTRAINT CK_Apuestas_Longitud6 CHECK ((Tipo = 'Simple' AND LEN (Prediccion6) = 1) 
																	OR (Tipo = 'Multiple' AND LEN (Prediccion6) IN (2, 3)))

ALTER TABLE Apuestas ADD CONSTRAINT CK_Apuestas_Longitud7 CHECK ((Tipo = 'Simple' AND LEN (Prediccion7) = 1) 
																	OR (Tipo = 'Multiple' AND LEN (Prediccion7) IN (2, 3)))

ALTER TABLE Apuestas ADD CONSTRAINT CK_Apuestas_Longitud8 CHECK ((Tipo = 'Simple' AND LEN (Prediccion8) = 1) 
																	OR (Tipo = 'Multiple' AND LEN (Prediccion8) IN (2, 3)))

ALTER TABLE Apuestas ADD CONSTRAINT CK_Apuestas_Longitud9 CHECK ((Tipo = 'Simple' AND LEN (Prediccion9) = 1) 
																	OR (Tipo = 'Multiple' AND LEN (Prediccion9) IN (2, 3)))

ALTER TABLE Apuestas ADD CONSTRAINT CK_Apuestas_Longitud10 CHECK ((Tipo = 'Simple' AND LEN (Prediccion10) = 1) 
																	OR (Tipo = 'Multiple' AND LEN (Prediccion10) IN (2, 3)))

ALTER TABLE Apuestas ADD CONSTRAINT CK_Apuestas_Longitud11 CHECK ((Tipo = 'Simple' AND LEN (Prediccion11) = 1) 
																	OR (Tipo = 'Multiple' AND LEN (Prediccion11) IN (2, 3)))

ALTER TABLE Apuestas ADD CONSTRAINT CK_Apuestas_Longitud12 CHECK ((Tipo = 'Simple' AND LEN (Prediccion12) = 1) 
																	OR (Tipo = 'Multiple' AND LEN (Prediccion12) IN (2, 3)))

ALTER TABLE Apuestas ADD CONSTRAINT CK_Apuestas_Longitud13 CHECK ((Tipo = 'Simple' AND LEN (Prediccion13) = 1) 
																	OR (Tipo = 'Multiple' AND LEN (Prediccion13) IN (2, 3)))

ALTER TABLE Apuestas ADD CONSTRAINT CK_Apuestas_Longitud14 CHECK ((Tipo = 'Simple' AND LEN (Prediccion14) = 1) 
																	OR (Tipo = 'Multiple' AND LEN (Prediccion14) IN (2, 3)))

ALTER TABLE Apuestas ADD CONSTRAINT CK_Apuestas_LongitudPleno CHECK ((Tipo = 'Simple' AND LEN (PrediccionPleno) = 1)
																	OR (Tipo = 'Multiple' AND LEN (PrediccionPleno) IN (2, 3, 4)))

ALTER TABLE Boletos ADD CONSTRAINT CK_Boletos_NumeroApuesta CHECK (NumeroApuestas > 0 AND NumeroApuestas < 9)

GO

CREATE TRIGGER numeroApuestas ON Apuestas
AFTER INSERT AS

IF EXISTS (SELECT COUNT (I.Tipo)
				FROM inserted AS I
				INNER JOIN
				Boletos AS B
				ON I.IDBoleto = B.ID
				WHERE B.NumeroApuestas > 1 AND I.Tipo = 'Multiple'
				HAVING COUNT (I.Tipo) > 1)
BEGIN
	ROLLBACK
END

GO

CREATE TRIGGER numeroApuestasTotales ON Apuestas
AFTER INSERT AS

IF EXISTS (SELECT COUNT (I.ID)
				FROM inserted AS I
				INNER JOIN
				Boletos AS B
				ON I.IDBoleto = B.ID
				GROUP BY NumeroApuestas
				HAVING COUNT (I.ID) > NumeroApuestas)
BEGIN
	ROLLBACK
END

GO

CREATE TRIGGER sorteoAbierto ON Apuestas
AFTER INSERT AS

IF EXISTS (SELECT I.ID
				FROM inserted as I
				INNER JOIN
				Boletos AS B
				ON I.IDBoleto = B.ID
				INNER JOIN
				Jornadas AS J
				ON B.IDJornada = J.ID
				WHERE Estado = 'Cerrado')
BEGIN
	Print 'El sorteo debe estar abierto'
	ROLLBACK
END

GO

CREATE FUNCTION calcularFondosTotales ()
RETURNS MONEY AS
BEGIN
	DECLARE @NumeroApuestas INT
	
	SELECT @NumeroApuestas = COUNT (ID)
		FROM Apuestas
	
	RETURN (@NumeroApuestas * 0.75) * 0.55
END

GO

CREATE FUNCTION dividirFondos ()
RETURNS TABLE AS
	RETURN (SELECT P.Categoria,
			CASE 
				WHEN Categoria = 1 THEN (dbo.calcularFondosTotales ()) * 0.16
				WHEN Categoria = 2 THEN (dbo.calcularFondosTotales ()) * 0.075
				WHEN Categoria = 3 THEN (dbo.calcularFondosTotales ()) * 0.075
				WHEN Categoria = 4 THEN (dbo.calcularFondosTotales ()) * 0.075
				WHEN Categoria = 5 THEN (dbo.calcularFondosTotales ()) * 0.09
				ELSE (dbo.calcularFondosTotales ()) * 0.075
			END Fondos
			FROM Premios as P)

/* Crea un procedimiento que grabe una apuesta simple. Los parámetros de entrada

serán los pronósticos para los quince partidos, el número del sorteo, el número del

boleto y el id de la jornada. Si el boleto se deja en NULL, se generará uno nuevo y si se introduce un

código válido se añadirá la apuesta al boleto, comprobando que no haya más de

ocho simples ni más de una múltiple.*/
GO

CREATE PROCEDURE grabarApuestaSimple
	@Pronostico1 CHAR (1),
	@Pronostico2 CHAR (1),
	@Pronostico3 CHAR (1),
	@Pronostico4 CHAR (1),
	@Pronostico5 CHAR (1),
	@Pronostico6 CHAR (1),
	@Pronostico7 CHAR (1),
	@Pronostico8 CHAR (1),
	@Pronostico9 CHAR (1),
	@Pronostico10 CHAR (1),
	@Pronostico11 CHAR (1),
	@Pronostico12 CHAR (1),
	@Pronostico13 CHAR (1),
	@Pronostico14 CHAR (1),
	@Pronostico15 CHAR (1),
	@IDJornada INT,
	@NumeroBoleto INT = NULL
AS
BEGIN

	IF EXISTS (SELECT ID
					FROM Jornadas
					WHERE Estado = 'Abierto' AND ID = @IDJornada)
	BEGIN

		IF (@NumeroBoleto IS NULL)
		BEGIN
			BEGIN TRANSACTION

			INSERT INTO Boletos (IDJornada, NumeroApuestas)
			VALUES (@IDJornada, 1)

			SET @NumeroBoleto = (SELECT MAX (ID) FROM Boletos) -- Necesito la transacción para que esta consulta no de fallo

			COMMIT TRANSACTION
		END

		INSERT INTO Apuestas (IDBoleto, Tipo, Prediccion1, Prediccion2, Prediccion3, Prediccion4, Prediccion5, Prediccion6,
							Prediccion7, Prediccion8, Prediccion9, Prediccion10, Prediccion11, Prediccion12, Prediccion13,
							Prediccion14, PrediccionPleno)
		VALUES(@NumeroBoleto, 'Simple', @Pronostico1, @Pronostico2, @Pronostico3, @Pronostico4, @Pronostico5, @Pronostico6,
			@Pronostico7, @Pronostico8, @Pronostico9, @Pronostico10, @Pronostico11, @Pronostico12, @Pronostico13, @Pronostico14, @Pronostico15)

	END

	ELSE
	BEGIN
		--RAISEERROR ()
		Print 'El sorteo debe estar abierto'
	END
END