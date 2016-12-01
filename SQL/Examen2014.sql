CREATE DATABASE Examen2014
GO

USE Examen2014

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


CREATE TABLE Socios
(
	Numero_Socio SMALLINT IDENTITY (1, 1),
	Nombre VARCHAR (20),
	Apellidos VARCHAR (40),
	Dirección VARCHAR (40),
	Email NVARCHAR (30),
	Telefono SMALLINT,

	CONSTRAINT PK_Socios PRIMARY KEY (Numero_Socio)
)

GO


CREATE TABLE Acuarios
(
	Capacidad INT,
	Medida SMALLINT,
	Alto SMALLINT,
	Largo SMALLINT,
	Ancho SMALLINT,
	Temperatura SMALLINT,
	Modelo_Bombas VARCHAR (20),
	Numero_Socio SMALLINT UNIQUE,
	ID_Acuario SMALLINT IDENTITY (1, 1),

	CONSTRAINT PK_Acuarios PRIMARY KEY (ID_Acuario),
	CONSTRAINT FK_Acuarios_Bombas FOREIGN KEY (Modelo_Bombas) REFERENCES Bombas (Modelo) ON UPDATE CASCADE ON DELETE NO ACTION,
	CONSTRAINT FK_Acuarios_Socios FOREIGN KEY (Numero_Socio) REFERENCES Socios (Numero_Socio) ON UPDATE CASCADE ON DELETE NO ACTION
)

GO


CREATE TABLE Seres_vivos
(
	Especie VARCHAR (30),
	Temperatura_maxima SMALLINT,
	Temperatura_minima SMALLINT,

	CONSTRAINT PK_Seres_vivos PRIMARY KEY (Especie),
)

GO

CREATE TABLE Tierras
(
	Nombre VARCHAR (30),
	Arcillas TINYINT,
	Silicatos TINYINT,
	Sustratos TINYINT,
	Otros TINYINT,

	CONSTRAINT PK_Tierras PRIMARY KEY (Nombre)
)

GO

CREATE TABLE Alimentos
(
	Tipo VARCHAR (30),
	Nombre VARCHAR (30),
	Valor_energetico SMALLINT,

	CONSTRAINT PK_Alimentos PRIMARY KEY (Nombre)
)

GO

CREATE TABLE Plantas
(
	Nombre_común VARCHAR (30),
	Tamaño_maximo SMALLINT,
	Necesidad_luz SMALLINT,
	Especie_Seres_vivos VARCHAR (30),

	CONSTRAINT PK_Plantas PRIMARY KEY (Especie_Seres_vivos),
	CONSTRAINT FK_Plantas_Seres_vivos FOREIGN KEY (Especie_Seres_vivos) REFERENCES Seres_vivos (Especie) ON DELETE CASCADE ON UPDATE CASCADE
)

GO

CREATE TABLE Peces
(
	Nombre_común VARCHAR (30),
	Color VARCHAR (30),
	Tipo VARCHAR (30),
	Tamaño_medio SMALLINT,
	Nombre_Alimento VARCHAR (30),
	Especie_Seres_vivos VARCHAR (30),

	CONSTRAINT PK_Peces PRIMARY KEY (Especie_Seres_vivos),
	CONSTRAINT FK_Peces_Seres_vivos FOREIGN KEY (Especie_Seres_vivos) REFERENCES Seres_vivos (Especie) ON DELETE CASCADE ON UPDATE CASCADE,
	CONSTRAINT FK_Peces_Alimentos FOREIGN KEY (Nombre_Alimento) REFERENCES Alimentos (Nombre) ON UPDATE CASCADE ON DELETE NO ACTION
)

GO

CREATE TABLE Seres_vivos_Acuarios
(
	Especie_Seres_vivos VARCHAR (30),
	ID_Acuario SMALLINT,
	Numero_individuos_especie SMALLINT,

	CONSTRAINT PK_Seres_vivos_Acuarios PRIMARY KEY (Especie_Seres_vivos, ID_Acuario),
	CONSTRAINT FK_Seres_vivos_Acuarios_Seres_vivos FOREIGN KEY (Especie_Seres_vivos) REFERENCES Seres_vivos (Especie) ON DELETE NO ACTION ON UPDATE CASCADE,
	CONSTRAINT FK_Seres_vivos_Acuarios_Acuarios FOREIGN KEY (ID_Acuario) REFERENCES Acuarios (ID_Acuario) ON DELETE NO ACTION ON UPDATE CASCADE,
)

GO

CREATE TABLE Peces_Peces
(
	Especie_Seres_vivos1 VARCHAR (30),
	Especie_Seres_vivos2 VARCHAR (30),

	CONSTRAINT PK_Peces_Peces PRIMARY KEY (Especie_Seres_vivos1, Especie_Seres_vivos2),
	CONSTRAINT FK_Peces_Peces_Peces1 FOREIGN KEY (Especie_Seres_vivos1) REFERENCES Peces (Especie_Seres_vivos) ON DELETE NO ACTION ON UPDATE CASCADE,
	CONSTRAINT FK_Peces_Peces_Peces2 FOREIGN KEY (Especie_Seres_vivos2) REFERENCES Peces (Especie_Seres_vivos) ON DELETE NO ACTION ON UPDATE NO ACTION
)

GO

CREATE TABLE Plantas_Tierras
(
	Especie_Seres_vivos VARCHAR (30),
	Nombre_Tierras VARCHAR (30),

	CONSTRAINT PK_Plantas_Tierras PRIMARY KEY (Especie_Seres_vivos, Nombre_Tierras),
	CONSTRAINT FK_Plantas_Tierras_Plantas FOREIGN KEY (Especie_Seres_vivos) REFERENCES Plantas (Especie_Seres_vivos) ON UPDATE CASCADE ON DELETE NO ACTION,
	CONSTRAINT FK_Plantas_Tierras_Tierras FOREIGN KEY (Nombre_Tierras) REFERENCES Tierras (Nombre) ON UPDATE CASCADE ON DELETE NO ACTION,
)
ALTER TABLE Tierras ADD Nitratos TINYINT
ALTER TABLE Acuarios WITH NOCHECK ADD CONSTRAINT CK_Dimensiones_Positivas CHECK (Alto > 0 AND Largo > 0 AND Ancho > 0)
ALTER TABLE Acuarios WITH NOCHECK ADD CONSTRAINT CK_Temperatura CHECK (Temperatura BETWEEN 10 AND 30)
ALTER TABLE Peces WITH NOCHECK ADD CONSTRAINT CK_Tipo CHECK (Tipo IN ('T', 'R', 'P', 'S', 'A', 'L'))
ALTER TABLE Plantas WITH NOCHECK ADD CONSTRAINT CK_Necesidad_Luz CHECK (Necesidad_Luz BETWEEN 4 AND 10)
ALTER TABLE Peces_Peces WITH NOCHECK ADD CONSTRAINT CK_Compatibilidad CHECK (Especie_Seres_vivos1 != Especie_Seres_vivos2)
ALTER TABLE Tierras WITH NOCHECK ADD CONSTRAINT CK_Porcentajes CHECK ((Arcillas + Silicatos + Sustratos + Nitratos + Otros) = 100)
ALTER TABLE Socios WITH NOCHECK ADD CONSTRAINT UQ_Email UNIQUE (Email)