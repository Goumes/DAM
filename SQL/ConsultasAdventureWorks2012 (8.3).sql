USE AdventureWorks2012

GO

--1.Nombre del producto, código y precio, ordenado de mayor a menor precio

SELECT Name, ProductID, ListPrice
	FROM Production.Product
	GROUP BY Name, ProductID, ListPrice
	ORDER BY ListPrice DESC

--2.Número de direcciones de cada Estado/Provincia

SELECT COUNT (AddressID) AS NumeroDirecciones, StateProvinceID
	FROM Person.Address
	GROUP BY StateProvinceID

/* 3.Nombre del producto, código, número, tamaño y peso de los productos que estaban a la venta 
durante todo el mes de septiembre de 2002. No queremos que aparezcan aquellos cuyo peso sea superior a 2000. */

SELECT Name, ProductID, ProductNumber AS NumeroProductos, Size, [Weight]
	FROM Production.Product
	WHERE SellStartDate >= DATEFROMPARTS (2002,09,01) AND SellStartDate <= DATEFROMPARTS (2002,09,30) AND 
	SellEndDate >= DATEFROMPARTS (2002,09,01) AND SellEndDate <= DATEFROMPARTS (2002,09,30) OR SellEndDate IS NOT NULL 
	AND [Weight] < 2000


/* 4.Margen de beneficio de cada producto (Precio de venta menos el coste), y porcentaje que supone respecto 
del precio de venta. */



--5.Número de productos de cada categoría
--6.Igual a la anterior, pero considerando las categorías generales (categorías de categorías).
--7.Número de unidades vendidas de cada producto cada año.
--8.Nombre completo, compañía y total facturado a cada cliente
/* 9.Número de producto, nombre y precio de todos aquellos en cuya descripción aparezcan las palabras 
"race”, "competition” o "performance” */


--10.Facturación total en cada país
--11.Facturación total en cada Estado
--12.Margen medio de beneficios y total facturado en cada país