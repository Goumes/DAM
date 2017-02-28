USE Northwind

GO

-- 1. Número de clientes de cada país.

SELECT COUNT (CustomerID) AS NumeroClientes, Country
	FROM Customers
	GROUP BY Country

-- 2. Número de clientes diferentes que compran cada producto.

SELECT /* DISTINCT */COUNT (DISTINCT C.CustomerID) AS NumeroClientesDiferentes, P.ProductName
	FROM Customers AS C
	INNER JOIN
	Orders AS O
	ON C.CustomerID = O.CustomerID
	INNER JOIN
	[Order Details] AS OD
	ON O.OrderID = OD.OrderID
	INNER JOIN
	Products AS P
	ON OD.ProductID = P.ProductID
	GROUP BY P.ProductName

-- 3. Número de países diferentes en los que se vende cada producto.

SELECT COUNT (DISTINCT O.ShipCountry) AS NumeroPaisesDiferentes, P.ProductName
	FROM Customers AS C
	INNER JOIN
	Orders AS O
	ON C.CustomerID = O.CustomerID
	INNER JOIN
	[Order Details] AS OD
	ON O.OrderID = OD.OrderID
	INNER JOIN
	Products AS P
	ON OD.ProductID = P.ProductID
	GROUP BY P.ProductName

/* 4. Empleados que han vendido alguna vez “Gudbrandsdalsost”, “Lakkalikööri”,
“Tourtière” o “Boston Crab Meat”. */

SELECT E.FirstName
	FROM Employees AS E
	INNER JOIN
	Orders AS O
	ON E.EmployeeID = O.EmployeeID
	INNER JOIN
	[Order Details] AS OD
	ON O.OrderID = OD.OrderID
	INNER JOIN
	Products AS P
	ON OD.ProductID = P.ProductID
	WHERE P.ProductName IN ('Gudbrandsdalsost', 'Lakkalikööri', 'Tourtière', 'Boston Crab Meat')

--5. Empleados que no han vendido nunca “Chartreuse verte” ni “Ravioli Angelo”.

SELECT FirstName, LastName
	FROM Employees

EXCEPT

SELECT E.FirstName, E.LastName
	FROM Employees AS E
	INNER JOIN
	Orders AS O
	ON E.EmployeeID = O.EmployeeID
	INNER JOIN
	[Order Details] AS OD
	ON O.OrderID = OD.OrderID
	INNER JOIN
	Products AS P
	ON OD.ProductID = P.ProductID
	WHERE P.ProductName IN ('Chartreuse verte', 'Ravioli Angelo')

/* 6. Número de unidades de cada categoría de producto que ha vendido cada
empleado. */

SELECT COUNT (OD.Quantity) AS NumeroUnidades, E.FirstName, E.LastName, C.CategoryName
	FROM Employees AS E
	INNER JOIN
	Orders AS O
	ON E.EmployeeID = O.EmployeeID
	INNER JOIN
	[Order Details] AS OD
	ON O.OrderID = OD.OrderID
	INNER JOIN
	Products AS P
	ON OD.ProductID = P.ProductID
	INNER JOIN
	Categories AS C
	ON P.CategoryID = C.CategoryID
	GROUP BY E.FirstName, E.LastName, C.CategoryName
	ORDER BY E.FirstName

-- 7. Total de ventas (US$) de cada categoría en el año 97.

SELECT TotalVentasCategoria.TotalVentas, P.CategoryID, YEAR (O.OrderDate) AS Año
	FROM Orders AS O
	INNER JOIN
	[Order Details] AS OD
	ON O.OrderID = OD.OrderID
	INNER JOIN
	Products AS P
	ON OD.ProductID = P.ProductID
	INNER JOIN
		(SELECT CAST (SUM (OD.Quantity * (OD.UnitPrice * (1 - OD.Discount))) AS DECIMAL (10, 2)) AS TotalVentas, C.CategoryID
			FROM Employees AS E
			INNER JOIN
			Orders AS O
			ON E.EmployeeID = O.EmployeeID
			INNER JOIN
			[Order Details] AS OD
			ON O.OrderID = OD.OrderID
			INNER JOIN
			Products AS P
			ON OD.ProductID = P.ProductID
			INNER JOIN
			Categories AS C
			ON P.CategoryID = C.CategoryID
			GROUP BY C.CategoryID) AS TotalVentasCategoria
	ON  P.CategoryID= TotalVentasCategoria.CategoryID
	WHERE YEAR (O.OrderDate) = 1997 
	GROUP BY YEAR (O.OrderDate), TotalVentasCategoria.TotalVentas, P.CategoryID
	ORDER BY P.CategoryID

/* 8. Productos que han comprado más de un cliente del mismo país, indicando el
nombre del producto, el país y el número de clientes distintos de ese país que
lo han comprado. */

SELECT  P.ProductName, C.Country, COUNT (DISTINCT C.CustomerID) AS NumeroClientes
	FROM Customers AS C
		INNER JOIN
		Orders AS O
		ON C.CustomerID = O.CustomerID
		INNER JOIN
		[Order Details] AS OD
		ON O.OrderID = OD.OrderID
		INNER JOIN
		Products AS P
		ON OD.ProductID = P.ProductID
		INNER JOIN
		Categories AS CA
		ON P.CategoryID = CA.CategoryID
	GROUP BY P.ProductName, C.Country
	HAVING COUNT (DISTINCT C.CustomerID) > 1

-- 9. Total de ventas (US$) en cada país cada año.

SELECT CAST (SUM (OD.Quantity * (OD.UnitPrice * (1- OD.Discount))) AS DECIMAL (12,2)) AS TotalVentas, YEAR (O.OrderDate) AS Año, C.Country
	FROM Customers AS C
		INNER JOIN
		Orders AS O
		ON C.CustomerID = O.CustomerID
		INNER JOIN
		[Order Details] AS OD
		ON O.OrderID = OD.OrderID
	GROUP BY C.Country, YEAR (O.OrderDate)
	ORDER BY YEAR (O.OrderDate)

/* 10. Producto superventas de cada año, indicando año, nombre del producto,
categoría y cifra total de ventas. */

SELECT SUM (OD.Quantity) AS Superventas, YEAR (O.OrderDate) AS Año, P.ProductName, P.CategoryID
	FROM Products AS P
		INNER JOIN
		[Order Details] AS OD
		ON P.ProductID = OD.ProductID
		INNER JOIN
		Orders AS O
		ON OD.OrderID = O.OrderID
		INNER JOIN
		(SELECT MAX (TotalVentasAño.TotalVentas) AS MaxVentas, Año
			FROM (SELECT SUM (OD.Quantity) AS TotalVentas, OD.ProductID, YEAR (O.OrderDate) AS Año
					FROM [Order Details] AS OD
						INNER JOIN
						Orders AS O
						ON OD.OrderID = O.OrderID
					GROUP BY YEAR (O.OrderDate), OD.ProductID) AS TotalVentasAño
				GROUP BY Año ) AS MaxVentasAño
		ON YEAR (O.OrderDate) = MaxVentasAño.Año
		GROUP BY MaxVentasAño.MaxVentas, YEAR (O.OrderDate), P.ProductName, P.CategoryID
		HAVING SUM (OD.Quantity) = MaxVentasAño.MaxVentas

/* 11. Cifra de ventas de cada producto en el año 97 y su aumento o disminución
respecto al año anterior en US $ y en %. */
GO

CREATE VIEW CifraVentas96 AS
SELECT SUM (OD.Quantity * (OD.UnitPrice * (1-OD.Discount))) AS CifraVentas, P.ProductName
	FROM Products AS P
	INNER JOIN
	[Order Details] AS OD
	ON P.ProductID = OD.ProductID
	INNER JOIN
	Orders AS O
	ON OD.OrderID = O.OrderID
	WHERE YEAR (O.OrderDate) = 1996
	GROUP BY P.ProductName

GO

CREATE VIEW CifraVentas97 AS
SELECT SUM (OD.Quantity * (OD.UnitPrice * (1-OD.Discount))) AS CifraVentas, P.ProductName
	FROM Products AS P
	INNER JOIN
	[Order Details] AS OD
	ON P.ProductID = OD.ProductID
	INNER JOIN
	Orders AS O
	ON OD.OrderID = O.OrderID
	WHERE YEAR (O.OrderDate) = 1997
	GROUP BY P.ProductName

GO

SELECT CAST ((CV97.CifraVentas - CV96.CifraVentas) AS DECIMAL (12,2)) AS DiferenciaVentasDollars,
		CAST (((CV97.CifraVentas / CV96.CifraVentas) * 100) AS DECIMAL (12,2)) AS DiferenciaVentasPorcentaje,
		CV97.ProductName
			FROM CifraVentas97 AS CV97
			INNER JOIN
			CifraVentas96 AS CV96
			ON CV97.ProductName = CV96.ProductName

-- 12. Mejor cliente (el que más nos compra) de cada país.

SELECT C.CustomerID
	FROM Customers AS C
	INNER JOIN
		(SELECT MAX (NumeroPedidos) AS MayorNumeroPedidos, PedidosPorCliente.Country
			FROM
				(SELECT COUNT (O.OrderID) AS NumeroPedidos, C.CustomerID, C.Country
					FROM Orders AS O
					INNER JOIN
					Customers AS C
					ON O.CustomerID = C.CustomerID
					GROUP BY C.Country, C.CustomerID) AS PedidosPorCliente
			GROUP BY PedidosPorCliente.Country) AS MaxNumeroPedidosPorPais
	ON C.Country = MaxNumeroPedidosPorPais.Country
	GROUP BY C.CustomerID, MaxNumeroPedidosPorPais.MayorNumeroPedidos
	HAVING C.CustomerID = MaxNumeroPedidosPorPais.MayorNumeroPedidos

--13. Número de productos diferentes que nos compra cada cliente.
GO

CREATE VIEW NumeroProductosDiferentes AS

SELECT DISTINCT COUNT (P.ProductID) AS NumeroProductos, C.CustomerID
	FROM Customers AS C
	INNER JOIN
	Orders AS O
	ON C.CustomerID = O.CustomerID
	INNER JOIN
	[Order Details] AS OD
	ON O.OrderID = OD.OrderID
	INNER JOIN
	Products AS P
	ON OD.ProductID = P.ProductID
	GROUP BY C.CustomerID

GO

-- 14. Clientes que nos compran más de cinco productos diferentes.

SELECT *
	FROM NumeroProductosDiferentes
	WHERE NumeroProductos > 5

/* 15. Vendedores que han vendido una mayor cantidad que la media en US $ en el
año 97. */
GO

CREATE VIEW VentasPorVendedor AS
SELECT SUM (OD.UnitPrice * (OD.Quantity * (1- OD.Discount))) AS Ventas, YEAR (O.OrderDate) AS Año, O.EmployeeID
	FROM [Order Details] AS OD
	INNER JOIN
	Orders AS O
	ON OD.OrderID = O.OrderID
	WHERE YEAR (O.OrderDate) = 1997
	GROUP BY YEAR (O.OrderDate), O.EmployeeID

GO

CREATE VIEW MediaVentasVista AS
SELECT AVG (VentasPorVendedor.Ventas) AS MediaVentas, Año
	FROM VentasPorVendedor
	GROUP BY Año

GO

SELECT EmployeeID, VV.Ventas
	FROM VentasPorVendedor AS VV
	INNER JOIN
	MediaVentasVista AS MV
	ON VV.Año = MV.Año
	WHERE VV.Ventas > MV.MediaVentas

/* 16. Empleados que hayan aumentado su cifra de ventas más de un 10% entre dos
años consecutivos, indicando el año en que se produjo el aumento. */
