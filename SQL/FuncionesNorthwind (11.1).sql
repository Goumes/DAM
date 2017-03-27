USE Northwind

GO

/* Deseamos incluir un producto en la tabla Products llamado "Cruzcampo lata” pero no estamos seguros si se ha insertado o no.

	El precio son 4,40, el proveedor es el 16, la categoría 1 y la cantidad por unidad es "Pack 6 latas” "Discontinued” 
	toma el valor 0 y el resto de columnas se dejarán a NULL.

	Escribe un script que compruebe si existe un producto con ese nombre. En caso afirmativo, 
	actualizará el precio y en caso negativo insertarlo. */

BEGIN TRANSACTION

IF EXISTS (SELECT *
			FROM Products
			WHERE ProductName = 'Cruzcampo lata')
	BEGIN
		UPDATE Products
		SET UnitPrice = 4.40
		WHERE ProductName = 'Cruzcampo lata'
	END

ELSE
	BEGIN
		INSERT INTO Products (ProductName, UnitPrice, SupplierID, CategoryID, QuantityPerUnit, Discontinued)
		VALUES
		('Cruzcampo lata', 4.40, 16, 1, 'Pack 6 latas', 0)
	END

--ROLLBACK
COMMIT TRANSACTION

/* Comprueba si existe una tabla llamada ProductSales. Esta tabla ha de tener de cada producto el ID, 
el Nombre, el Precio unitario, el número total de unidades vendidas y el total de dinero facturado 
con ese producto. Si no existe, créala. */

BEGIN TRANSACTION

IF OBJECT_ID ('ProductSales')IS NULL
	BEGIN
		CREATE TABLE ProductSales
		(
			ID INT NOT NULL,
			ProductID INT NULL,
			Name NVARCHAR (30) NOT NULL,
			UnitPrice MONEY NULL,
			TotalSoldUnits INT NULL,
			TotalCashed MONEY NULL,
			CONSTRAINT PK_ProductSales PRIMARY KEY (ID),
			CONSTRAINT FK_ProductSales_Products FOREIGN KEY (ProductID) REFERENCES Products (ProductID)
		)
	END
ELSE
	BEGIN
		PRINT 'Enhorabuena, la tabla ya existe por lo que tu trabajo aquí ha terminado! Mamá estaría orgullosa... si la verdad
no fuera tan dura y su amor hacia ti tan escaso.'
	END

--ROLLBACK
COMMIT TRANSACTION

/* Comprueba si existe una tabla llamada ShipShip. Esta tabla ha de tener de cada Transportista el ID, 
el Nombre de la compañía, el número total de envíos que ha efectuado y el número de países diferentes a 
los que ha llevado cosas. Si no existe, créala. */

BEGIN TRANSACTION

IF OBJECT_ID ('ShipShip')IS NULL
	BEGIN
		CREATE TABLE ShipShip
		(
			ID INT NOT NULL,
			ShipperID INT NOT NULL,
			Name NVARCHAR (30) NOT NULL,
			TotalSentUnits INT NULL,
			DifferentShippedCountries INT NULL,
			
			CONSTRAINT PK_ShipShip PRIMARY KEY (ID),
			CONSTRAINT FK_ShipShip_Shippers FOREIGN KEY (ShipperID) REFERENCES Shippers (ShipperID)
		)
	END
ELSE
	BEGIN
		PRINT 'Bien, tras el arduo trabajo de hacer Ctrl+C Y Ctrl+V del ejercicio anterior y cambiar un par de columnas, has conseguido
completar el ejercicio. Enhorabuena.'
	END

--ROLLBACK
COMMIT TRANSACTION

/* Comprueba si existe una tabla llamada EmployeeSales. Esta tabla ha de tener de cada empleado su ID, 
el Nombre completo, el número de ventas totales que ha realizado, el número de clientes diferentes a los 
que ha vendido y el total de dinero facturado. Si no existe, créala. */

BEGIN TRANSACTION

IF OBJECT_ID ('EmployeeSales')IS NULL
	BEGIN
		CREATE TABLE EmployeeSales
		(
			EmployeeID INT NOT NULL,
			Name NVARCHAR (30) NOT NULL,
			LastName NVARCHAR (30) NOT NULL,
			TotalSentUnits INT NULL,
			DifferentClients INT NULL,
			TotalSold INT NULL,
			
			CONSTRAINT PK_EmployeeSales PRIMARY KEY (EmployeeID),
			CONSTRAINT FK_EmployeeSales_Employees FOREIGN KEY (EmployeeID) REFERENCES Employees (EmployeeID)
		)
	END
ELSE
	BEGIN
		PRINT 'Y por fin terminan estos maravillosos ejercicios de copiar y pegar la estructura para cambiar los datos. Has hecho un buen
trabajo joven Padawan.'
	END

--ROLLBACK
COMMIT TRANSACTION

/* Entre los años 96 y 97 hay productos que han aumentado sus ventas y otros que las han disminuido. 
Queremos cambiar el precio unitario según la siguiente tabla: 

Incremento de ventas			Incremento de precio
Negativo						-10%
Entre 0% y 10%					No varía
Entre 10% y 50%					+5%
Mayor del 50%					10% con un máximo de 2,25
*/

BEGIN TRANSACTION

UPDATE Products
SET UnitPrice =  
		CASE  
			WHEN IncrementoVentas.IncrementoVentas < 0 THEN (UnitPrice - UnitPrice * 0.1)
			WHEN IncrementoVentas.IncrementoVentas BETWEEN 0 AND 10 THEN UnitPrice
			WHEN IncrementoVentas.IncrementoVentas BETWEEN 10 AND 50 THEN (UnitPrice + UnitPrice * 0.05)
			ELSE (UnitPrice + UnitPrice * 0.1) -- Con un maximo de 2,25
		END 
FROM IncrementoVentas
WHERE Products.ProductID = IncrementoVentas.IDProducto

--ROLLBACK

COMMIT TRANSACTION

GO

CREATE VIEW Ventas96 AS

SELECT SUM (OD.Quantity) AS VentasPorProducto, YEAR (O.OrderDate) AS Año, OD.ProductID
	FROM Orders AS O
	INNER JOIN
	[Order Details] AS OD
	ON O.OrderID = OD.OrderID
	WHERE YEAR (O.OrderDate) = 1996
	GROUP BY OD.ProductID, YEAR (O.OrderDate)

GO

CREATE VIEW Ventas97 AS

SELECT SUM (OD.Quantity) AS VentasPorProducto, YEAR (O.OrderDate) AS Año, OD.ProductID
	FROM Orders AS O
	INNER JOIN
	[Order Details] AS OD
	ON O.OrderID = OD.OrderID
	WHERE YEAR (O.OrderDate) = 1997
	GROUP BY OD.ProductID, YEAR (O.OrderDate)

GO

CREATE VIEW IncrementoVentas AS

SELECT ((V97.VentasPorProducto / CAST ((V96.VentasPorProducto) AS DECIMAL (12,2)) - 1) * 100) AS IncrementoVentas, V96.ProductID AS IDProducto
	FROM Ventas96 AS V96
	INNER JOIN
	Ventas97 AS V97
	ON V96.ProductID = V97.ProductID
