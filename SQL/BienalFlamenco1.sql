CREATE DATABASE BienalFlamenco1
GO
USE BienalFlamenco1
GO

CREATE TABLE empresas
(
	CIF SMALLINT,
	Nombre NVARCHAR (20),
	Dirección NVARCHAR (30),

	CONSTRAINT PK_empresas PRIMARY KEY (CIF)
)

GO

CREATE TABLE trabajadores
(
	DNI NCHAR (9),
	Nombre NVARCHAR (20),
	Trabajo NVARCHAR (20),
	CIF_Empresa SMALLINT,

	CONSTRAINT PK_trabajadores PRIMARY KEY (DNI),
	CONSTRAINT FK_trabajadores_empresas FOREIGN KEY (CIF_Empresa) REFERENCES empresas (CIF)
)

GO

CREATE TABLE representantes
(
	DNI NCHAR (9),
	Nombre NVARCHAR (20),

	CONSTRAINT PK_representantes PRIMARY KEY (DNI)
)

GO

CREATE TABLE artistas
(
	DNI NCHAR (9),
	Nombre NVARCHAR (20),
	TIPO NVARCHAR (20),
	DNI_representante NCHAR (9),


	CONSTRAINT PK_artistas PRIMARY KEY (DNI),
	CONSTRAINT FK_artistas_representantes FOREIGN KEY (DNI_representante) REFERENCES representantes (DNI) ON DELETE NO ACTION ON UPDATE CASCADE
)

GO

CREATE TABLE espacios_numerados
(
	Nombre NVARCHAR,
	Direccion NVARCHAR (50),
	Aforo SMALLINT,
	Tipo NVARCHAR (20),

	CONSTRAINT PK_espacios_numerados PRIMARY KEY (Direccion)
)

GO

CREATE TABLE espacios_no_numerados
(
	Nombre NVARCHAR,
	Direccion NVARCHAR (50),
	Aforo SMALLINT,
	Tipo NVARCHAR (20),

	CONSTRAINT PK_espacios_no_numerados PRIMARY KEY (Direccion)
)

GO

CREATE TABLE espectaculos
(
	Fecha DATE,
	Hora TIME,
	Direccion_espacios_numerados NVARCHAR (50),
	Direccion_espacios_no_numerados NVARCHAR (50),

	CONSTRAINT PK_espectaculos PRIMARY KEY (Fecha),
	CONSTRAINT FK_espectaculos_espacios_numerados FOREIGN KEY (Direccion_espacios_numerados) REFERENCES Espacios_numerados (direccion) ON DELETE NO ACTION ON UPDATE CASCADE,
	CONSTRAINT FK_espectaculos_espacios_no_numerados FOREIGN KEY (Direccion_espacios_no_numerados) REFERENCES Espacios_no_numerados (direccion) ON DELETE NO ACTION ON UPDATE CASCADE
	/*PONER QUE ALGUNA DE LAS DOS DIRECCIONES SEA NULL*/
)

GO

CREATE TABLE zonas
(
	Numero_filas SMALLINT,
	Asientos_por_filas SMALLINT,
	Direccion_espacios_numerados NVARCHAR (50),

	CONSTRAINT PK_zonas PRIMARY KEY (Numero_filas),
	CONSTRAINT FK_zonas_espacios_numerados FOREIGN KEY (Direccion_espacios_numerados) REFERENCES Espacios_numerados (Direccion) ON UPDATE CASCADE ON DELETE NO ACTION
)

GO

CREATE TABLE entradas
(
	Asiento SMALLINT,
	Fila SMALLINT,
	Numero_filas_zonas SMALLINT,

	CONSTRAINT PK_entradas PRIMARY KEY (Asiento),
	CONSTRAINT FK_entradas_zonas FOREIGN KEY (Numero_filas_zonas) REFERENCES zonas (numero_filas) ON UPDATE CASCADE ON DELETE NO ACTION
)

GO

CREATE TABLE trabajadores_espectaculos
(
	DNI_trabajadores NCHAR (9),
	fecha_espectaculos DATE,
	tarea NVARCHAR (50),

	CONSTRAINT PK_trabajadores_espectaculos PRIMARY KEY (DNI_trabajadores, fecha_espectaculos),
	CONSTRAINT FK_trabajadores_espectaculos_espectaculos FOREIGN KEY (fecha_espectaculos) REFERENCES espectaculos (fecha) ON UPDATE CASCADE ON DELETE NO ACTION,
	CONSTRAINT FK_trabajadores_espectaculos_trabajadores FOREIGN KEY (DNI_trabajadores) REFERENCES trabajadores (DNI) ON UPDATE CASCADE ON DELETE NO ACTION
)

GO

CREATE TABLE espectaculos_artistas
(
	fecha_espectaculos DATE,
	DNI_artistas NCHAR (9),

	CONSTRAINT PK_espectaculos_artistas PRIMARY KEY (DNI_artistas, fecha_espectaculos),
	CONSTRAINT FK_espectaculos_artistas_espectaculos FOREIGN KEY (fecha_espectaculos) REFERENCES espectaculos (fecha) ON UPDATE CASCADE ON DELETE NO ACTION,
	CONSTRAINT FK_espectaculos_artistas_artistas FOREIGN KEY (DNI_artistas) REFERENCES artistas (DNI) ON UPDATE CASCADE ON DELETE NO ACTION
)