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
