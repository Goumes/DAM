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
		WHEN OrderDate BETWEEN DATEFROMPARTS (1996, 03, 22) AND DATEFROMPARTS (1996, 06, 21) THEN 'Primavera'
		WHEN OrderDate BETWEEN DATEFROMPARTS (1996, 06, 22) AND DATEFROMPARTS (1996, 09, 21) THEN 'Verano'
		WHEN OrderDate BETWEEN DATEFROMPARTS (1996, 09, 22) AND DATEFROMPARTS (1996, 12, 21) THEN 'Otoño'
		WHEN OrderDate BETWEEN DATEFROMPARTS (1996, 12, 22) AND DATEFROMPARTS (1996, 03, 21) THEN 'Invierno'
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