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

SELECT *
	FROM Orders AS O
	INNER JOIN
		(SELECT SUM (OD.Quantity * OD.UnitPrice) AS TotalVentas, C.CategoryID
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
	ON  = TotalVentasCategoria.CategoryID

/* 8. Productos que han comprado más de un cliente del mismo país, indicando el
nombre del producto, el país y el número de clientes distintos de ese país que
lo han comprado. */



-- 9. Total de ventas (US$) en cada país cada año.



/* 10. Producto superventas de cada año, indicando año, nombre del producto,
categoría y cifra total de ventas. */



/* 11. Cifra de ventas de cada producto en el año 97 y su aumento o disminución
respecto al año anterior en US $ y en %. */



-- 12. Mejor cliente (el que más nos compra) de cada país.



--13. Número de productos diferentes que nos compra cada cliente.



-- 14. Clientes que nos compran más de cinco productos diferentes.



/* 15. Vendedores que han vendido una mayor cantidad que la media en US $ en el
año 97. */



/* 16. Empleados que hayan aumentado su cifra de ventas más de un 10% entre dos
años consecutivos, indicando el año en que se produjo el aumento. */