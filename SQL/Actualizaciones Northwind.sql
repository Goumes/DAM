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


-- Inserta un nuevo vendedor llamado Michael Trump. Asígnale los territorios de Louisville, Phoenix, Santa Cruz y Atlanta.
-- Haz que las ventas del año 97 de Robert King que haya hecho a clientes de los estados de California y Texas se le asignen al nuevo empleado.

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
-- Todos los que han comprado "Outback Lager" han comprado cinco años después la misma cantidad de Mecca Cola al mismo vendedor
-- El pasado 20 de enero, Margaret Peacock consiguió vender una caja de Nesquick Power Max a todos los clientes que le habían comprado algo anteriormente. Los datos de envío (dirección, transportista, etc) son los mismos de alguna de sus ventas anteriores a ese cliente). */