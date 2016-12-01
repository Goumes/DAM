CREATE TABLE PruebasCheck (
	Numero Int 
	,Palabra VarChar (20)
)
GO
INSERT INTO PruebasCheck (Numero, Palabra) VALUES (1000,'Mil'),(5,'Cinco')
GO
ALTER TABLE PruebasCheck WITH NOCHECK ADD CONSTRAINT CK_Prueba CHECK (Numero < 500)

ALTER TABLE PruebasCheck ADD Numero AS (3+5)
ALTER TABLE PruebasCheck ADD CONSTRAINT DF_PruebasCheck DEFAULT 3 FOR Numero