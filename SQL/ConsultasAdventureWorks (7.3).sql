USE AdventureWorks2014

GO

/* 1. Nombre, numero de producto, precio y color de los productos de color rojo o amarillo cuyo precio esté 
	 comprendido entre 50 y 500 */

SELECT Name, ProductNumber, ListPrice, Color 
	FROM Production.Product 
	WHERE Color IN ('Yellow','Red') AND ListPrice BETWEEN 50 AND 500

/* 2. Nombre, número de producto, precio de coste,  precio de venta, margen de beneficios total y margen de beneficios
	 en % del precio de venta de los productos de categorías inferiores a 16*/

SELECT Name, ProductNumber, StandardCost, ListPrice, (ListPrice-StandardCost) AS MargenBeneficiosTotal/*,
((ListPrice-StandardCost)*ListPrice)/100 AS MargenBeneficiosPorcentaje */
	FROM Production.Product
	WHERE ProductSubcategoryID < 16

/* 3. Empleados cuyo nombre o apellidos contenga la letra "r". Los empleados son los que tienen el valor "EM" en la 
	 columna PersonType de la tabla Person */

SELECT BusinessEntityID, FirstName, MiddleName, LastName, PersonType
	FROM Person.Person
	WHERE PersonType = 'EM' AND (FirstName LIKE '%[r]%' OR MiddleName LIKE '%[r]%' OR LastName LIKE '%[r]%')

/* 4. LoginID, nationalIDNumber, edad y puesto de trabajo (jobTitle) de los empleados (tabla Employees) de sexo
	 femenino que tengan más de cinco años de antigüedad */

SELECT LoginID, NationalIDNumber, (YEAR(CURRENT_TIMESTAMP - CAST (BirthDate AS DATETIME)) - 1900) AS Edad, JobTitle
	FROM HumanResources.Employee
	WHERE Gender = 'F' AND (YEAR(CURRENT_TIMESTAMP - CAST (HireDate AS DATETIME)) - 1900) >= 5

/* 5. Ciudades correspondientes a los estados 11, 14, 35 o 70, sin repetir. Usar la tabla Person.Address */

SELECT DISTINCT City
	FROM Person.Address
	WHERE StateprovinceID IN (11,14,35,70)