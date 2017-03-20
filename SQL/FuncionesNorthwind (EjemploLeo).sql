USE Northwind

GO

/* Calcular las ventas (uds) de cada producto dividida por estaciones:
	- Primavera: 22 - Marzo / 21 - Junio
	- Verano: 22 - Junio / 21 - Septiembre
	- Otoño: 22 - Septiembre / 21 - Diciembre
	- Invierno: 22 - Diciembre / 21 - Marzo
*/

GO
CREATE VIEW pepejava AS

	SELECT OrderDate,
	CASE
		WHEN (MONTH (OrderDate) = 3 AND DAY (OrderDate) BETWEEN 22 AND 31) OR (MONTH (OrderDate) BETWEEN 4 AND 5) OR (MONTH (OrderDate) = 6 AND DAY (OrderDate) < 21) THEN 'Primavera'
		WHEN (MONTH (OrderDate) = 6 AND DAY (OrderDate) BETWEEN 22 AND 30) OR (MONTH (OrderDate) BETWEEN 7 AND 8) OR (MONTH (OrderDate) = 9 AND DAY (OrderDate) < 21) THEN 'Verano'
		WHEN (MONTH (OrderDate) = 9 AND DAY (OrderDate) BETWEEN 22 AND 31) OR (MONTH (OrderDate) BETWEEN 10 AND 11) OR (MONTH (OrderDate) = 12 AND DAY (OrderDate) < 21) THEN 'Otoño'
		WHEN (MONTH (OrderDate) = 12 AND DAY (OrderDate) BETWEEN 22 AND 31) OR (MONTH (OrderDate) BETWEEN 1 AND 2) OR (MONTH (OrderDate) = 3 AND DAY (OrderDate) < 21) THEN 'Invierno'
	END	AS Estacion 
	FROM Orders

GO

CREATE FUNCTION NumeroVentas (@ProductName VARCHAR (30))
RETURNS TABLE AS
RETURN
	(
		SELECT COUNT (OD.ProductID) AS NumeroProductos, Estacion
			FROM Products AS P
			INNER JOIN
			[Order Details] AS OD
			ON P.ProductID = OD.ProductID
			INNER JOIN
			Orders AS O
			ON OD.OrderID = O.OrderID
			INNER JOIN
			pepejava AS PJ
			ON O.OrderDate = PJ.OrderDate
			WHERE ProductName = @ProductName
			GROUP BY PJ.Estacion
	)

GO

SELECT *
	FROM NumeroVentas ('Chai')