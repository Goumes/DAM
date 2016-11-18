CREATE DATABASE AyuntamientoAlcalde
GO
USE AyuntamientoAlcalde
GO

CREATE TABLE Alcaldes
(
	DNI char (9) NOT NULL,
	Nombre  varchar (20) NOT NULL,
	Apellidos varchar (50)  NOT NULL,
	Fecha_de_alta date  NOT NULL,
	constraint PK_Alcaldes Primary key (DNI)
)

GO

CREATE TABLE Secretarios
(
	DNI char (9) NOT NULL,
	Nombre nvarchar (20) NOT NULL,
	Apellidos nvarchar (50) NOT NULL,
	Fecha_de_alta date NOT NULL,
	CONSTRAINT PK_Secretarios Primary key (DNI)
)

GO

CREATE TABLE Ayuntamientos
(
	Nombre nvarchar (20) NOT NULL,
	Provincia nvarchar (50) NOT NULL,
	DNI_Alcalde char (9) NOT NULL,
	DNI_Secretario char (9) NOT NULL,
	CONSTRAINT PK_Ayuntamientos Primary Key (Nombre),
	CONSTRAINT FK_Alcaldes_Ayuntamientos Foreign Key (DNI_Alcalde) REFERENCES Alcaldes (DNI) ON DELETE NO ACTION ON UPDATE CASCADE,
	CONSTRAINT FK_Ayuntamientos_Secretarios Foreign Key (DNI_Secretario) REFERENCES Secretarios (DNI) ON DELETE NO ACTION ON UPDATE CASCADE
)

GO

CREATE TABLE Alcaldes_Ayuntamientos
(
	DNI_Alcalde nchar (9) NOT NULL,
	Nombre_Ayuntamiento nvarchar (20) NOT NULL,
	CONSTRAINT PK_Alcaldes_ayuntamientos Primary key (DNI_alcalde)
)

GO

CREATE TABLE Secretarios_Ayuntamientos
(
	DNI_Secretario nchar (9) NOT NULL,
	Nombre_Ayuntamiento nvarchar (20) NOT NULL,
	CONSTRAINT PK_Secretarios_Ayuntamientos Primary key (DNI_Secretario)
)