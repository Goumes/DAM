CREATE DATABASE Prueba

GO

USE Prueba

GO


CREATE TABLE Prueba1
(
	Nombre VARCHAR (30),
	Apellidos VARCHAR (50),

	CONSTRAINT PK_Prueba1 PRIMARY KEY (Nombre)
)

GO

CREATE TABLE Prueba2
(
	ID SMALLINT IDENTITY (1, 1),
	Localizacion VARCHAR (20),
	Nombre_Prueba1 VARCHAR (30),

	CONSTRAINT PK_Prueba2 PRIMARY KEY (Nombre_Prueba1),
	CONSTRAINT FK_Prueba2_Prueba1 FOREIGN KEY (Nombre_Prueba1) REFERENCES Prueba1 (Nombre) ON DELETE NO ACTION ON UPDATE CASCADE
)