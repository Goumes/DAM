CREATE DATABASE Quinielas

GO

USE Quinielas

GO

CREATE TABLE Boletos
(
	numeroBoleto INT NOT NULL,
	CONSTRAINT PK_Boletos PRIMARY KEY (numeroBoleto) -- Pensar más atributos
)

GO