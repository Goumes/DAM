USE Northwind

GO

--1. Nombre de los proveedores y número de productos que nos vende cada uno

SELECT CompanyName, COUNT (ProductID) AS NumeroDeProductos
	FROM Suppliers AS S
	INNER JOIN 
	Products AS P 
	ON S.SupplierID = P.SupplierID
	GROUP BY CompanyName

/* 2. Nombre completo y telefono de los vendedores que trabajen en New York, Seattle, Vermont, Columbia, Los Angeles, 
	  Redmond o Atlanta. */

SELECT FirstName, LastName, HomePhone
	FROM Employees AS E
	INNER JOIN
	EmployeeTerritories AS ET
	ON E.EmployeeID = ET.EmployeeID
	INNER JOIN
	Territories AS T
	ON ET.TerritoryID = T.TerritoryID
	WHERE City IN ('Seattle', 'Vermont','Columbia' ,'Los Angeles' ,'Redmond', 'Atlanta' )


--3. Número de productos de cada categoría y nombre de la categoría.

SELECT COUNT (ProductID) AS NumeroProductos, CategoryName
	FROM Products AS P
	INNER JOIN
	Categories AS C
	ON P.CategoryID = C.CategoryID
	GROUP BY CategoryName

--4. Nombre de la compañía de todos los clientes que hayan comprado queso de cabrales o tofu.

SELECT CompanyName
	FROM Customers AS C
	INNER JOIN
	Orders as O
	ON C.CustomerID = O.CustomerID
	INNER JOIN
	[Order Details] AS OD
	ON O.OrderID = OD.OrderID
	INNER JOIN
	Products AS P
	ON OD.ProductID = P.ProductID
	WHERE ProductName IN ('Queso Cabrales', 'Tofu')

--5. Empleados (ID, nombre, apellidos y teléfono) que han vendido algo a Bon app' o Meter Franken.

SELECT DISTINCT E.EmployeeID, FirstName, LastName, Phone
	FROM Employees AS E
	INNER JOIN
	Orders AS O
	ON E.EmployeeID = O.EmployeeID
	INNER JOIN
	Customers AS C
	ON O.CustomerID = C.CustomerID
	WHERE CompanyName IN ('Bon app''', 'Meter Franken')
	ORDER BY E.EmployeeID

/* 6. Empleados (ID, nombre, apellidos, mes y día de su cumpleaños) que no han vendido nunca nada a ningún cliente 
	 de Francia. */

SELECT EmployeeID, FirstName, LastName
	FROM Employees

EXCEPT

SELECT E.EmployeeID, E.FirstName, E.LastName
	FROM Employees AS E
	INNER JOIN
	Orders AS O
	ON E.EmployeeID = O.EmployeeID
	INNER JOIN
	Customers AS C
	ON O.CustomerID = C.CustomerID
	WHERE C.Country IN ('France')

--7. Total de ventas en US$ de productos de cada categoría (nombre de la categoría).

SELECT *
	FROM

--8. Total de ventas en US$ de cada empleado cada año (nombre, apellidos, dirección).



--9. Ventas de cada producto en el año 97. Nombre del producto y unidades.



--10. Cuál es el producto del que hemos vendido más unidades en cada país.



--11. Empleados (nombre y apellidos) que trabajan a las órdenes de Andrew Fuller.



--12. Número de subordinados que tiene cada empleado, incluyendo los que no tienen ninguno. Nombre, apellidos, ID.