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

SELECT MaxVentasAño.Superventas, YEAR (O.OrderDate) AS Año, P.ProductName, P.CategoryID
	FROM Products AS P
		INNER JOIN
		[Order Details] AS OD
		ON P.ProductID = OD.ProductID
		INNER JOIN
		Orders AS O
		ON OD.OrderID = O.OrderID
		INNER JOIN
		(SELECT MAX (TotalVentasAño.TotalVentas) AS Superventas, YEAR (O.OrderDate) AS Año
			FROM Products AS P
				INNER JOIN
				[Order Details] AS OD
				ON P.ProductID = OD.ProductID
				INNER JOIN
				Orders AS O
				ON OD.OrderID = O.OrderID
				INNER JOIN
				(SELECT SUM (OD.Quantity) AS TotalVentas, P.ProductID, YEAR (O.OrderDate) AS Año
					FROM Products AS P
						INNER JOIN
						[Order Details] AS OD
						ON P.ProductID = OD.ProductID
						INNER JOIN
						Orders AS O
						ON OD.OrderID = O.OrderID
					GROUP BY YEAR (O.OrderDate), P.ProductID) AS TotalVentasAño
				ON P.ProductID = TotalVentasAño.ProductID
				GROUP BY YEAR (O.OrderDate), TotalVentasAño.TotalVentas
				HAVING MAX (TotalVentasAño.TotalVentas) = TotalVentasAño.TotalVentas) AS MaxVentasAño
		ON YEAR (O.OrderDate) = MaxVentasAño.Año


/* 11. Cifra de ventas de cada producto en el año 97 y su aumento o disminución
respecto al año anterior en US $ y en %. */



-- 12. Mejor cliente (el que más nos compra) de cada país.



--13. Número de productos diferentes que nos compra cada cliente.



-- 14. Clientes que nos compran más de cinco productos diferentes.



/* 15. Vendedores que han vendido una mayor cantidad que la media en US $ en el
año 97. */



/* 16. Empleados que hayan aumentado su cifra de ventas más de un 10% entre dos
años consecutivos, indicando el año en que se produjo el aumento. */