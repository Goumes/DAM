USE Northwind

GO

-- Inserta un nuevo cliente.
INSERT INTO Customers (CustomerID, CompanyName, ContactName, City)
	VALUES
	('PP4v4', 'pepejavaproductions', 'pepe.java', 'Granite Valley')


/* Véndele (hoy) tres unidades de "Pavlova”, diez de "Inlagd Sill” y 25 de "Filo Mix”. 
El distribuidor será Speedy Express y el vendedor Laura Callahan. */

INSERT INTO Orders (CustomerID, EmployeeID, OrderDate)


(SELECT CustomerID, (SELECT EmployeeID
								FROM Employees
								WHERE FirstName = 'Laura' AND LastName = 'Callahan'), CURRENT_TIMESTAMP
	FROM Customers
	WHERE ContactName = 'pepe.java')

--DELETE FROM Orders WHERE OrderID = '11078'

INSERT INTO [Order Details] (OrderID, ProductID, UnitPrice, Quantity, Discount)

VALUES
((SELECT OrderID
	FROM Orders
	WHERE CustomerID = 'PP4v4'), (SELECT ProductID
									FROM Products
									WHERE ProductName = 'Pavlova'),(SELECT DISTINCT P.UnitPrice
																		FROM [Order Details] AS OD
																		INNER JOIN
																		Products AS P
																		ON OD.ProductID = P.ProductID
																		WHERE P.ProductName = 'Pavlova'), 3, 0),

((SELECT OrderID
	FROM Orders
	WHERE CustomerID = 'PP4v4'), (SELECT ProductID
									FROM Products
									WHERE ProductName = 'Inlagd Sill'),(SELECT DISTINCT P.UnitPrice
																		FROM [Order Details] AS OD
																		INNER JOIN
																		Products AS P
																		ON OD.ProductID = P.ProductID
																		WHERE P.ProductName = 'Inlagd Sill'), 10, 0),

((SELECT OrderID
	FROM Orders
	WHERE CustomerID = 'PP4v4'), (SELECT ProductID
									FROM Products
									WHERE ProductName = 'Filo Mix'),(SELECT DISTINCT P.UnitPrice
																		FROM [Order Details] AS OD
																		INNER JOIN
																		Products AS P
																		ON OD.ProductID = P.ProductID
																		WHERE P.ProductName = 'Filo Mix'), 25, 0)

/*
Ante la bajada de ventas producida por la crisis, hemos de adaptar nuestros precios según las siguientes reglas:
Los productos de la categoría de bebidas (Beverages) que cuesten más de $10 reducen su precio en un dólar.
Los productos de la categoría Lácteos que cuesten más de $5 reducen su precio en un 10%.
Los productos de los que se hayan vendido menos de 200 unidades en el último año, reducen su precio en un 5% */

UPDATE Products
SET UnitPrice = UnitPrice - 1
WHERE CategoryID = (SELECT CategoryID
						FROM Categories
						WHERE CategoryName = 'Beverages') AND UnitPrice > 10


UPDATE Products
SET UnitPrice = UnitPrice - (UnitPrice * (10/100))
WHERE CategoryID = (SELECT CategoryID
						FROM Categories
						WHERE CategoryName = 'Dairy Products') AND UnitPrice > 5


UPDATE Products
SET UnitPrice = UnitPrice - (UnitPrice * (5/100))
WHERE ProductID IN (SELECT ProductID
						FROM 
							(SELECT SUM (OD.Quantity) AS CantidadVentas, OD.ProductID
								FROM [Order Details] AS OD
								INNER JOIN
								Orders AS O
								ON OD.OrderID = O.OrderID
								WHERE YEAR (O.OrderDate) = 1998
								GROUP BY ProductID) AS pepejava
						GROUP BY ProductID, pepejava.CantidadVentas
						HAVING pepejava.CantidadVentas < 200)

-- Inserta un nuevo vendedor llamado Michael Trump. Asígnale los territorios de Louisville, Phoenix, Santa Cruz y Atlanta.

INSERT INTO Employees (LastName, FirstName)
VALUES ('Trump', 'Michael')

INSERT INTO EmployeeTerritories (EmployeeID, TerritoryID)
VALUES
((SELECT EmployeeID
	FROM Employees
	WHERE FirstName = 'Michael' AND LastName = 'Trump'), (SELECT TerritoryID
															FROM Territories
															WHERE TerritoryDescription = 'Louisville'))

INSERT INTO EmployeeTerritories (EmployeeID, TerritoryID)
VALUES
((SELECT EmployeeID
	FROM Employees
	WHERE FirstName = 'Michael' AND LastName = 'Trump'), (SELECT TerritoryID
															FROM Territories
															WHERE TerritoryDescription = 'Phoenix'))

INSERT INTO EmployeeTerritories (EmployeeID, TerritoryID)
VALUES
((SELECT EmployeeID
	FROM Employees
	WHERE FirstName = 'Michael' AND LastName = 'Trump'), (SELECT TerritoryID
															FROM Territories
															WHERE TerritoryDescription = 'Santa Cruz'))

INSERT INTO EmployeeTerritories (EmployeeID, TerritoryID)
VALUES
((SELECT EmployeeID
	FROM Employees
	WHERE FirstName = 'Michael' AND LastName = 'Trump'), (SELECT TerritoryID
															FROM Territories
															WHERE TerritoryDescription = 'Atlanta'))

-- Haz que las ventas del año 97 de Robert King que haya hecho a clientes de los estados de California y Texas se le asignen al nuevo empleado.

UPDATE Orders
SET EmployeeID = (SELECT EmployeeID
					FROM Employees
					WHERE FirstName = 'Michael' AND LastName = 'Trump')
WHERE OrderID IN (SELECT OrderID
					FROM Orders
					WHERE ShipRegion IN ('CA', 'TX') AND YEAR (OrderDate) = 1997)

/*Inserta un nuevo producto con los siguientes datos:
ProductID: 90
ProductName: Nesquick Power Max
SupplierID: 12
CategoryID: 3
QuantityPerUnit: 10 x 300g
UnitPrice: 2,40
UnitsInStock: 38
UnitsOnOrder: 0
ReorderLevel: 0
Discontinued: 0
*/

INSERT INTO Products (ProductID, ProductName, SupplierID, CategoryID, QuantityPerUnit, UnitPrice, UnitsInStock, UnitsOnOrder, ReorderLevel, Discontinued)
VALUES
(90, 'Nesquick Power Max', 12, 3, '10 x 300g', 2.40, 38, 0, 0, 0)

UPDATE Products -- No se puede tocar el productID porque es identity
SET ProductID = 90
WHERE ProductID = (SELECT ProductID
					FROM Products
					WHERE ProductName = 'Nesquick Power Max')

SET identity_insert Products ON -- Esto lo arregla. Pero tiene que ser creandolo desde 0, no con update. Cambiar a OFF después de hacer los cambios.

DELETE FROM Products WHERE ProductName = 'Nesquick Power Max'

/*
Inserta un nuevo producto con los siguientes datos:
ProductID: 91
ProductName: Mecca Cola
SupplierID: 1
CategoryID: 1
QuantityPerUnit: 6 x 75 cl
UnitPrice: 7,35
UnitsInStock: 14
UnitsOnOrder: 0
ReorderLevel: 0
Discontinued: 0
*/

INSERT INTO Products (ProductID, ProductName, SupplierID, CategoryID, QuantityPerUnit, UnitPrice, UnitsInStock, UnitsOnOrder, ReorderLevel, Discontinued)
VALUES
(91, 'Mecca Cola', 1, 1, '6 x 75 cl', 7.35, 14, 0, 0, 0)

DELETE FROM Products WHERE ProductName = 'Mecca Cola' -- Para meterle el identity

-- Todos los que han comprado "Outback Lager" han comprado cinco años después la misma cantidad de Mecca Cola al mismo vendedor

GO

CREATE VIEW OrderIDs AS
(SELECT OrderID, CustomerID
	FROM Orders
	WHERE CustomerID IN (SELECT CustomerID
							FROM Orders
							WHERE OrderID IN (SELECT OrderID
												FROM [Order Details]
												WHERE ProductID = (SELECT ProductID
																	FROM Products
																	WHERE ProductName = 'Outback Lager'))) AND OrderDate IN (SELECT DATEADD (YEAR, 5,OrderDate)
																																FROM Orders
																																WHERE OrderID IN (SELECT OrderID
																																					FROM [Order Details]
																																					WHERE ProductID = (SELECT ProductID
																																										FROM Products
																																										WHERE ProductName = 'Outback Lager'))))

GO

CREATE VIEW Cantidades AS
(SELECT Quantity, CustomerID
	FROM [Order Details] AS OD
	INNER JOIN
	Orders AS O
	ON OD.OrderID = O.OrderID
	WHERE ProductID = 70)

GO

INSERT INTO Orders (CustomerID, OrderDate)
SELECT CustomerID, DATEADD (YEAR, 5,OrderDate)
	FROM Orders
	WHERE OrderID IN (SELECT OrderID
						FROM [Order Details]
						WHERE ProductID = (SELECT ProductID
											FROM Products
											WHERE ProductName = 'Outback Lager'))


INSERT INTO [Order Details] (OrderID, ProductID, Quantity)

SELECT OID.OrderID, 91, SUM (C.Quantity)
	FROM OrderIDs AS OID
	INNER JOIN
	Cantidades AS C
	ON OID.CustomerID = C.CustomerID
	GROUP BY OID.OrderID

-- El pasado 20 de enero, Margaret Peacock consiguió vender una caja de Nesquick Power Max a todos los clientes que le habían comprado algo anteriormente. Los datos de envío (dirección, transportista, etc) son los mismos de alguna de sus ventas anteriores a ese cliente). */
GO

CREATE VIEW Compradores AS

SELECT DISTINCT CustomerID, EmployeeID
	FROM Orders
	WHERE EmployeeID = (SELECT EmployeeID
							FROM Employees
							WHERE FirstName = 'Margaret' AND LastName = 'Peacock')

GO

INSERT INTO Orders (CustomerID, EmployeeID, OrderDate)

SELECT  CustomerID, EmployeeID, ('20170120 00:00')
	FROM Compradores

INSERT INTO [Order Details] (OrderID, ProductID)
SELECT OrderID, 90
	FROM Orders
	WHERE OrderDate = '20170120 00:00'

-- Falta meter los mismos datos de envío. Hay que corregir.

INSERT INTO Orders (ShipVia,ShipName, ShipAddress, ShipRegion, ShipPostalCode, ShipCountry)

SELECT DISTINCT ShipVia,ShipName, ShipAddress, ShipRegion, ShipPostalCode, ShipCountry
	FROM Orders
	WHERE CustomerID IN (SELECT DISTINCT CustomerID
							FROM Orders
							WHERE EmployeeID = (SELECT EmployeeID
													FROM Employees
													WHERE FirstName = 'Margaret' AND LastName = 'Peacock'))