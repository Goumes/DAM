CREATE DATABASE Examen2014
GO

USE Examen 2014

GO

CREATE TABLE Bombas
(
	Marca VARCHAR (20),
	Modelo VARCHAR (20) NOT NULL,
	Caudal TINYINT,
	Consumo FLOAT,

	CONSTRAINT PK_Bombas PRIMARY KEY (Modelo)
)

GO

CREATE TABLE Acuarios
(
	Capacidad SMALLINT,
	Medida SMALLINT,
	Alto SMALLINT,
	Largo SMALLINT,
	Ancho SMALLINT,
	Temperatura SMALLINT,
	ID_Acuario SMALLINT NOT NULL,

	CONSTRAINT PK_Acuarios PRIMARY KEY (ID_Acuario)
)

GO

CREATE TABLE Socios
(
	Numero_Socio SMALLINT,
	Nombre VARCHAR (20),
	Apellidos VARCHAR (40),
	Dirección VARCHAR (40),
	Email NVARCHAR (30),
	Telefono SMALLINT,

	CONSTRAINT PK_Socios PRIMARY KEY (Numero_Socio)
)