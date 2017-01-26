USE Northwind

GO

--1. Nombre de los proveedores y número de productos que nos vende cada uno

SELECT CompanyName, COUNT (ProductID)
	FROM Suppliers AS S
	INNER JOIN 
	Products AS P 
	ON 

/* 2. Nombre completo y telefono de los vendedores que trabajen en New York, Seattle, Vermont, Columbia, Los Angeles, 
	  Redmond o Atlanta. */



--3. Número de productos de cada categoría y nombre de la categoría.



--4. Nombre de la compañía de todos los clientes que hayan comprado queso de cabrales o tofu.



--5. Empleados (ID, nombre, apellidos y teléfono) que han vendido algo a Bon app' o Meter Franken.



/* 6. Empleados (ID, nombre, apellidos, mes y día de su cumpleaños) que no han vendido nunca nada a ningún cliente 
	 de Francia. */



--7. Total de ventas en US$ de productos de cada categoría (nombre de la categoría).



--8. Total de ventas en US$ de cada empleado cada año (nombre, apellidos, dirección).



--9. Ventas de cada producto en el año 97. Nombre del producto y unidades.



--10. Cuál es el producto del que hemos vendido más unidades en cada país.



--11. Empleados (nombre y apellidos) que trabajan a las órdenes de Andrew Fuller.



--12. Número de subordinados que tiene cada empleado, incluyendo los que no tienen ninguno. Nombre, apellidos, ID.