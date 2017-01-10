USE pubs

GO

--1. Inserta un nuevo autor.

INSERT INTO authors (au_id, au_lname, au_fname, phone, [contract])
	VALUES
	('543-32-1243', 'Jones', 'Jhonny', '555 123-5897',1)

--2. Inserta dos libros, escritos por el autor que has insertado antes y publicados por la editorial "Ramona publishers”.

INSERT INTO titles (title_id, title, [type], pubdate)
	VALUES 
	('', '', '', '')
	('', '', '', '')

--3. Modifica la tabla jobs para que el nivel mínimo sea 90.
--4. Crea una nueva editorial (publihers) con ID 9908, nombre Mostachon Books y sede en Utrera.
--5. Cambia el nombre de la editorial con sede en Alemania para que se llame "Machen Wücher" y traslasde su sede a Stuttgart