CREATE DATABASE Examen2016

GO

USE Examen2016

GO

--Creamos las tablas--

CREATE TABLE Dones
(
	ID SMALLINT,
	Nombre VARCHAR (30) UNIQUE,
	Apellidos VARCHAR (50),
	Apodo VARCHAR (20),
	Fecha_de_nacimiento DATE,
	Procedencia VARCHAR (30),

	CONSTRAINT PK_Dones PRIMARY KEY (ID)
)

GO

CREATE TABLE Consiglieres
(
	Nombre VARCHAR (30) UNIQUE,
	Apellidos VARCHAR (50),
	Apodo VARCHAR (20) UNIQUE,
	Fecha_de_nacimiento DATE,
	Procedencia VARCHAR (30),
	Titulacion VARCHAR (30),
	ID SMALLINT,
	ID_Dones SMALLINT,

	CONSTRAINT PK_Consiglieres PRIMARY KEY (ID, ID_Dones),
	CONSTRAINT FK_Consiglieres_Dones FOREIGN KEY (ID_Dones) REFERENCES Dones (ID) ON UPDATE CASCADE ON DELETE CASCADE --Es ON DELETE CASCADE porque es una entidad debil
)

GO

CREATE TABLE Famiglias
(
	Nombre VARCHAR (30) UNIQUE,
	Procedencia VARCHAR (30),
	ID1 SMALLINT,
	ID2 SMALLINT,

	CONSTRAINT PK_Famiglias PRIMARY KEY (ID1, ID2),
)

GO 

CREATE TABLE Negocios
(
	ID SMALLINT,
	Denominacion VARCHAR (30),
	IlegalSN CHAR (1),

	CONSTRAINT PK_Negocios PRIMARY KEY (ID),
)

GO

CREATE TABLE Territorios
(
	ID SMALLINT,
	Ciudad VARCHAR (30),
	Barrio VARCHAR (30),

	CONSTRAINT PK_Territorios PRIMARY KEY (ID)
)


GO

CREATE TABLE Capos
(
	ID SMALLINT,
	Nombre VARCHAR (30) UNIQUE,
	Apellidos VARCHAR (50),
	Apodo VARCHAR (20) UNIQUE,
	Fecha_de_nacimiento DATE,
	Procedencia VARCHAR (30),
	Procentaje_comisión SMALLINT,
	Sueldo SMALLINT,
	Fecha_de_contratacion DATE,
	ID1_Famiglias SMALLINT,
	ID2_Famiglias SMALLINT,

	CONSTRAINT PK_Capos PRIMARY KEY (ID),
	CONSTRAINT FK_Capos_Famiglias FOREIGN KEY (ID1_Famiglias, ID2_Famiglias) REFERENCES Famiglias (ID1, ID2) ON UPDATE CASCADE ON DELETE NO ACTION
)

GO

CREATE TABLE Soldatos
(
	ID SMALLINT,
	Nombre VARCHAR (30) UNIQUE,
	Apellidos VARCHAR (50),
	Apodo VARCHAR (20),
	Fecha_de_nacimiento DATE,
	Procedencia VARCHAR (30),
	Tatuaje_principal VARCHAR (50),
	ID_Capos SMALLINT,

	CONSTRAINT PK_Soldatos PRIMARY KEY (ID),
	CONSTRAINT FK_Soldatos_Capos FOREIGN KEY (ID_Capos) REFERENCES Capos (ID) ON UPDATE CASCADE ON DELETE NO ACTION
)

GO

CREATE TABLE Lugartenientes
(
	ID SMALLINT,
	Nombre VARCHAR (30) UNIQUE,
	Apellidos VARCHAR (50),
	Apodo VARCHAR (20),
	ID_Capos SMALLINT,

	CONSTRAINT PK_Lugartenientes PRIMARY KEY (ID),
	CONSTRAINT FK_Lugartenientes_Capos FOREIGN KEY (ID_Capos) REFERENCES Capos (ID) ON UPDATE CASCADE ON DELETE NO ACTION 
)

GO

CREATE TABLE Tecnicas_de_persuasion
(
	ID SMALLINT IDENTITY (1,1),
	Denominacion VARCHAR (30),

	CONSTRAINT PK_Tecnicas_de_persuasion PRIMARY KEY (ID),
)

GO

CREATE TABLE Armas
(
	ID SMALLINT,
	Denominacion VARCHAR (30),
	LegalSN CHAR (1),
	LicenciaSN CHAR (1),

	CONSTRAINT PK_Armas PRIMARY KEY (ID)
)

GO

CREATE TABLE Armas_blancas
(
	Longitud_hoja SMALLINT,
	Tipo_filo VARCHAR (30),
	RetractilSN CHAR (1),
	ID_Armas SMALLINT,

	CONSTRAINT PK_Armas_Blancas PRIMARY KEY (ID_Armas),
	CONSTRAINT FK_Armas_Blancas_Armas FOREIGN KEY (ID_Armas) REFERENCES Armas (ID) ON UPDATE CASCADE ON DELETE CASCADE --Si se borra el arma no tiene sentido mantener el tipo de arma ya que es inexistente.
)

GO

CREATE TABLE Armas_de_fuego
(
	Marca VARCHAR (30),
	Modelo VARCHAR (30) UNIQUE,
	Calibre SMALLINT,
	Capacidad_de_proyectiles SMALLINT,
	ID_Armas SMALLINT,

	CONSTRAINT PK_Armas_de_fuego PRIMARY KEY (ID_Armas),
	CONSTRAINT FK_Armas_de_fuego_Armas FOREIGN KEY (ID_Armas) REFERENCES Armas (ID) ON UPDATE CASCADE ON DELETE CASCADE
)

GO

CREATE TABLE Soldatos_Armas
(
	ID_armas SMALLINT,
	ID_Soldatos SMALLINT,
	Fecha_de_nombramiento DATE,

	CONSTRAINT PK_Soldatos_Armas PRIMARY KEY (ID_Armas, ID_Soldatos),
	CONSTRAINT FK_Soldatos_Armas_Soldatos FOREIGN KEY (ID_Soldatos) REFERENCES Soldatos (ID) ON UPDATE CASCADE ON DELETE NO ACTION,
	CONSTRAINT FK_Soldatos_Armas_Armas FOREIGN KEY (ID_Armas) REFERENCES Armas (ID) ON UPDATE CASCADE ON DELETE NO ACTION
)

GO

CREATE TABLE Capos_Tecnicas_de_persuasion
(
	ID_Capos SMALLINT,
	ID_Tecnicas_de_persuasion SMALLINT,

	CONSTRAINT PK_Capos_Tecnicas_de_persuasion PRIMARY KEY (ID_Capos, ID_Tecnicas_de_persuasion),
	CONSTRAINT FK_Capos_tecnicas_de_persuasion_Capos FOREIGN KEY (ID_Capos) REFERENCES Capos (ID) ON UPDATE CASCADE ON DELETE NO ACTION,
	CONSTRAINT FK_Capos_Tecnicas_de_persuasion_Tecnicas_de_persuasion FOREIGN KEY (ID_Tecnicas_de_persuasion) REFERENCES Tecnicas_de_persuasion (ID) ON UPDATE CASCADE ON DELETE NO ACTION
)

GO

CREATE TABLE Dones_Famiglias
(
	ID_Dones SMALLINT,
	ID1_Famiglias SMALLINT,
	ID2_Famiglias SMALLINT,
	Destreza VARCHAR (20),

	CONSTRAINT PK_Dones_Famiglias PRIMARY KEY (ID_Dones, ID1_Famiglias, ID2_Famiglias),
	CONSTRAINT FK_Dones_Famiglias_Dones FOREIGN KEY (ID_Dones) REFERENCES Dones (ID) ON UPDATE CASCADE ON DELETE NO ACTION,
	CONSTRAINT FK_Dones_Famiglias_Famiglias FOREIGN KEY (ID1_Famiglias, ID2_Famiglias) REFERENCES Famiglias (ID1, ID2) ON UPDATE CASCADE ON DELETE NO ACTION,
)

GO

CREATE TABLE Famiglias_Territorios_Negocios
(
	ID_Negocios SMALLINT,
	ID_Territorios SMALLINT,
	ID1_Famiglias SMALLINT,
	ID2_Famiglias SMALLINT,

	CONSTRAINT PK_Famiglias_Territorios_Negocios PRIMARY KEY (ID_Negocios, ID_Territorios, ID1_Famiglias, ID2_Famiglias),
	CONSTRAINT FK_Famiglias_Territorios_Negocios_Famiglias FOREIGN KEY (ID1_Famiglias, ID2_Famiglias) REFERENCES Famiglias (ID1, ID2) ON UPDATE CASCADE ON DELETE CASCADE,--He decidido poner on DELETE CASCADE debido a que si no hay familia, tampoco hay negocio.
	CONSTRAINT FK_Famiglias_Territorios_Negocios_Territorios FOREIGN KEY (ID_Territorios) REFERENCES Territorios (ID) ON UPDATE CASCADE ON DELETE CASCADE,--Misma razón que para las familias
	CONSTRAINT FK_Famiglias_Territorios_Negocios_Negocios FOREIGN KEY (ID_Negocios) REFERENCES Negocios (ID) ON UPDATE CASCADE ON DELETE NO ACTION
)

GO

--Ejercicio 4
CREATE TABLE Delitos
(
	ID SMALLINT,
	Denominacion VARCHAR (30),
	articuloCP DECIMAL (3,1),
	condenaMin SMALLINT,
	condenaMax SMALLINT,

	CONSTRAINT PK_Delitos PRIMARY KEY (ID),
	CONSTRAINT CK_Rango_condena CHECK (condenaMax BETWEEN condenaMin AND 360)

)


GO

--Ejercicio 5
CREATE TABLE Delitos_Soldatos
(
	ID_Delitos SMALLINT,
	ID_Soldatos SMALLINT,
	Fecha DATE,

	CONSTRAINT PK_Delitos_Soldatos PRIMARY KEY (ID_Delitos, ID_Soldatos),
	CONSTRAINT FK_Delitos_Soldatos_Delitos FOREIGN KEY (ID_Delitos) REFERENCES Delitos (ID) ON UPDATE CASCADE ON DELETE NO ACTION,
	CONSTRAINT FK_Delitos_Soldatos_Soldatos FOREIGN KEY (ID_Soldatos) REFERENCES Soldatos (ID) ON UPDATE CASCADE ON DELETE NO ACTION
)

GO



CREATE TABLE Delitos_Capos
(
	ID_Delitos SMALLINT,
	ID_Capos SMALLINT,
	Fecha DATE,

	CONSTRAINT PK_Delitos_Capos PRIMARY KEY (ID_Delitos, ID_Capos),
	CONSTRAINT FK_Delitos_Capos_Delitos FOREIGN KEY (ID_Delitos) REFERENCES Delitos (ID) ON UPDATE CASCADE ON DELETE NO ACTION,
	CONSTRAINT FK_Delitos_Capos_Capos FOREIGN KEY (ID_Capos) REFERENCES Capos (ID) ON UPDATE CASCADE ON DELETE NO ACTION
)

--Añadimos las restricciones del ejercicio 3
ALTER TABLE Soldatos ADD CONSTRAINT CK_Edad_minima CHECK ((YEAR(CURRENT_TIMESTAMP - CAST (Fecha_de_nacimiento AS DATETIME)) - 1900) BETWEEN 15 AND 55)
ALTER TABLE Armas ADD CONSTRAINT CK_Legal CHECK ((LegalSN = 'n' AND LicenciaSN IS NULL) OR (LegalSN = 's' AND LicenciaSN IS NOT NULL))
ALTER TABLE Capos ADD CONSTRAINT UQ_Apodo UNIQUE (Apodo)
ALTER TABLE Armas_blancas ADD CONSTRAINT CK_Tipo_filo CHECK (Tipo_filo IN ('recto', 'convexo', 'scandi', 'serrado', 'mixto' ))
ALTER TABLE Armas_de_fuego ADD Pupa AS ((Calibre/10)*Capacidad_de_proyectiles)
ALTER TABLE Capos ADD CONSTRAINT DF_Procedencia DEFAULT 'Sicilia' FOR Procedencia

