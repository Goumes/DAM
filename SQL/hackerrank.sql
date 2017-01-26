CREATE DATABASE hackerrank

GO

USE hackerrank

GO

CREATE TABLE EMPLOYEES
(
ID INTEGER IDENTITY (1,1) NOT NULL,
Name VARCHAR (30) NOT NULL,
Salary INTEGER NOT NULL
)

GO

CREATE TABLE TRIANGLES
(
A INTEGER NOT NULL,
B INTEGER NOT NULL,
C INTEGER NOT NULL
)

INSERT INTO EMPLOYEES (Name, Salary)
	VALUES
	('Ashley', 2340),
	('Julia', 1198),
	('Britney', 9009),
	('Kristeen', 2341), 
	('Dyana', 9990),
	('Diana', 8011),
	('Jenny', 2341),
	('Christeen', 2342), 
	('Meera', 2343),
	('Priya', 2344),
	('Priyanka', 2345), 
	('Paige', 2346),
	('Jane', 2347),
	('Belvet', 2348),
	('Scarlet', 2349), 
	('Salma', 9087),
	('Amanda', 7777),
	('Aamina', 5500),
	('Amina', 2570),
	('Ketty', 2007)

	/*Samantha was tasked with calculating the average monthly salaries for all employees in the EMPLOYEES table, 
	but did not realize her keyboard's 0 key was broken until after completing the calculation. 
	She wants your help finding the difference between her miscalculation (using salaries with any zeroes removed), 
	and the actual average salary.
	Write a query calculating the amount of error (i.e.: actual - miscalculated  average monthly salaries), 
	and round it up to the next integer.*/

	SELECT AVG (Salary) - 
		(SELECT AVG (Salary) 
			FROM EMPLOYEES 
			WHERE /**/) 
	FROM EMPLOYEES;



	INSERT INTO TRIANGLES (A, B, C)
		VALUES
		(10, 10, 10),
		(11, 11, 11),
		(30, 32, 30),
		(40, 40, 40),
		(20, 20, 21),
		(21, 21, 21),
		(20, 22, 21),
		(20, 20, 40),
		(20, 22, 21),
		(30, 32, 41),
		(50, 22, 51),
		(20, 12, 61),
		(20, 22, 50),
		(50, 52, 51),
		(80, 80, 80)

/*Write a query identifying the type of each record in the TRIANGLES table using its three side lengths. 
Output one of the following statements for each record in the table:

	Not A Triangle: The given values of A, B, and C don't form a triangle.
	Equilateral: It's a triangle with  sides of equal length.
	Isosceles: It's a triangle with  sides of equal length.
	Scalene: It's a triangle with  sides of differing lengths.*/

SELECT ((A) AS ISOSCELES) AS ISOSCELES FROM TRIANGLES WHERE A = B AND A != C

--SELECT '('A,+','B,+')' FROM TRIANGLES