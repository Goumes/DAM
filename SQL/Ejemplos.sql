CREATE DATABASE Ejemplos
GO
USE Ejemplos
GO

/*
1. DatosRestrictivos.
a. ID Es un SmallInt autonumérico que se rellenará con números impares.. No admite nulos. Clave primaria
b. Nombre: Cadena de tamaño 15. No puede empezar por "N” ni por "X” Añade una restiricción UNIQUE. No admite nulos
c. Numpelos: Int con valores comprendidos entre 0 y 145.000
d. TipoRopa: Carácter con uno de los siguientes valores: "C”, "F”, "E”, "P”, "B”, ”N”
e. NumSuerte: TinyInt. Tiene que ser un número divisible por 3.
f. Minutos: TinyInt Con valores comprendidos entre 20 y 85 o entre 120 y 185.
*/

CREATE TABLE DatosRestrictivos
(
	ID SMALLINT IDENTITY (1,2) NOT NULL,
	Nombre NCHAR (15) UNIQUE,
	Numpelos INT,
	TipoRopa NCHAR (1),
	NumSuerte TINYINT,
	Minutos TINYINT,

	CONSTRAINT PK_DatosRestrictivos PRIMARY KEY (ID),

	CONSTRAINT CK_ID CHECK (ID%2!=0),
	CONSTRAINT CK_Nombre CHECK (Nombre LIKE '[^NX]%'), /*También se puede poner como NOT LIKE '[NX]%' */
	CONSTRAINT CK_Numpelos CHECK (Numpelos BETWEEN 0 AND 145000),
	CONSTRAINT CK_TipoRopa CHECK (TipoRopa IN ('C','F','E','P','B','N')),
	CONSTRAINT CK_NumSuerte CHECK (NumSuerte % 3 = 0),
	CONSTRAINT CK_Minutos CHECK ((Minutos BETWEEN 20 AND 85) OR (Minutos BETWEEN 120 AND 185))
)
GO
/*
2. DatosRelacionados.
a. NombreRelacionado: Cadena de tamaño 15. Define una FK para relacionarla con la columna "Nombre” de la tabla DatosRestrictivos.
¿Deberíamos poner la misma restricción que en la columna correspondiente? NO, PORQUE TRAE LOS DATOS DE LA OTRA COLUMNA. SI QUIERES AÑADIR MÁS RESTRICCIONES SI SERÍA NECESARIO.
¿Qué ocurriría si la ponemos? QUE COMPROBARÍA DOS VECES LO MISMO.
¿Y si no la ponemos?
b. PalabraTabu: Cadena de longitud max 20. No admitirá los valores "Barcenas”, "Gurtel”, "Púnica”, "Bankia” ni "sobre”. Tampoco admitirá ninguna palabra terminada en "eo”
c. NumRarito: TinyInt menor que 20. No admitirá números primos.
d. NumMasgrande: SmallInt. Valores comprendidos entre NumRarito y 1000. Definirlo como clave primaria.
¿Puede tener valores menores que 20?

SOLO SE PUEDE UTILIZAR COMO CLAVE AJENA CUANDO LA CLAVE REFERIDA ES UNIQUE O PRIMARY.
*/

CREATE TABLE DatosRelacionados
(
	NombreRelacionado NCHAR (15),
	PalabraTabu NVARCHAR (20),
	NumRarito TINYINT,
	NumMasgrande SMALLINT,

	CONSTRAINT PK_DatosRelacionados PRIMARY KEY (NumMasgrande),
	CONSTRAINT FK_DatosRelacionados_DatosRestrictivos FOREIGN KEY (NombreRelacionado) REFERENCES DatosRestrictivos (Nombre) ON DELETE NO ACTION ON UPDATE CASCADE,

	CONSTRAINT CK_PalabraTabu CHECK (PalabraTabu  NOT IN ('Barcenas', 'Gurtel', 'Púnica', 'Bankia', 'sobre') AND PalabraTabu NOT LIKE '%eo'), /*SI LO PONES ENTRE CORCHETES SIGNIFICA QUE NO PUEDE SER NINGUNO DE ESOS CARACTERES INDIVIDUALES, INCLUIDO EL %.*/
	CONSTRAINT CK_NumRarito_NoPrimos CHECK ((NumRarito < 20) AND (NumRarito NOT IN (2, 3, 5, 7, 11, 13, 17, 19))),
	CONSTRAINT CK_NumMasgrande CHECK (NumMasgrande BETWEEN NumRarito AND 1000),
)

GO

/*
3. DatosAlMogollon.
a. ID. SmallInt. No admitirá múltiplos de 5. Definirlo como PK
b. LimiteSuperior. SmallInt comprendido entre 1500 y 2000.
c. OtroNumero. Será mayor que el ID y Menor que LimiteSuperior. Poner UNIQUE
d. NumeroQueVinoDelMasAlla: SmallInt FK relacionada con NumMasGrande de la tabla DatosRelacionados
e. Etiqueta. Cadena de 3 caracteres. No puede tener los valores "pao”, "peo”, "pio” ni "puo”
*/

CREATE TABLE DatosAlMogollon
(
	ID SMALLINT,
	LimiteSuperior SMALLINT,
	OtroNumero SMALLINT UNIQUE, --Si es UNIQUE por norma general será NOT NULL
	NumeroQueVinoDelMasAlla SMALLINT,
	Etiqueta NCHAR (3),

	CONSTRAINT PK_DatosAlMogollon PRIMARY KEY (ID),
	CONSTRAINT Fk_DatosAlMogollon_DatosRelacionados FOREIGN KEY (NumeroQueVinoDelMasAlla) REFERENCES DatosRelacionados (NumMasGrande) ON UPDATE CASCADE ON DELETE NO ACTION,

	CONSTRAINT CK_ID_NoMultiplos5 CHECK (ID % 5 != 0),
	CONSTRAINT CK_LimiteSuperior_Entre1500Y2000 CHECK (LimiteSuperior BETWEEN 1500 AND 2000),
	CONSTRAINT CK_OtroNumero_EntreIDyLimiteSuperior CHECK ((OtroNumero > ID) AND (OtroNumero < LimiteSuperior)),
	CONSTRAINT CK_Etiqueta_ValoresInvalidos CHECK (Etiqueta NOT IN ('pao', 'peo', 'pio', 'puo'))
)

GO