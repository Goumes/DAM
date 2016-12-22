/*
1. Introduce dos nuevos clientes. Asígnales los códigos que te parezcan adecuados.
2. Introduce una mascota para cada uno de ellos. Asígnales los códigos que te parezcan adecuados.
3. Escribe un SELECT para obtener los IDs de las enfermedades que ha sufrido alguna mascota (una cualquiera). Los IDs no deben repetirse
4. El cliente Josema Ravilla ha llevado a visita a todas sus mascotas.
		Escribe un SELECT para averiguar el código de Josema Ravilla.
		Escribe otro SELECT para averiguar los códigos de las mascotas de Josema Ravilla.
		Con los códigos obtenidos en la consulta anterior, escribe los INSERT correspondientes en la tabla BI_Visitas. La fecha y hora se tomarán del sistema.
5. Todos los perros del cliente 104 han enfermado el 20 de diciembre de sarna.
		Escribe un SELECT para averiguar los códigos de todos los perros del cliente 104
		Con los códigos obtenidos en la consulta anterior, escribe los INSERT correspondientes en la tabla BI_Mascotas_Enfermedades
6. Escribe una consulta para obtener el nombre, especie y raza de todas las mascotas, ordenados por edad.
7. Escribe los códigos de todas las mascotas que han ido alguna vez al veterinario un lunes o un viernes. Para averiguar el dia de la semana de una fecha se usa la función DATEPART (WeekDay, fecha) que devuelve un entero entre 1 y 7 donde el 1 corresponde al lunes, el dos al martes y así sucesivamente.
NOTA: El servidor se puede configurar para que la semana empiece en lunes o domingo.
*/
USE Bichos

GO


INSERT INTO BI_Clientes (Codigo,Telefono,Direccion,NumeroCuenta,Nombre)
	VALUES
	(666,'666666666','Infierno','ES4938236726661224561590','Lucifer'),
	(107,'954874562','Calle Abrazamozas, 13','ES0123456789101112131415','Pamela Chu')

GO

INSERT INTO BI_Mascotas (Codigo,Raza,Especie,FechaNacimiento,FechaFallecimiento,Alias,CodigoPropietario)
     VALUES 
	 ('PM566','Galgo','Perro','16050712',Null,'Quijote',666),
	 ('GH007','Maine Coon','Gato','20141028',Null,'pepe.java',107)

GO

SELECT IDEnfermedad FROM BI_Mascotas_Enfermedades WHERE Mascota = 'PH004'

GO

SELECT Codigo FROM BI_Clientes WHERE Nombre = 'Josema Ravilla'

GO

SELECT Codigo FROM BI_Mascotas WHERE CodigoPropietario = 102

GO

INSERT INTO BI_Visitas (Fecha,Mascota,Temperatura,Peso)
     VALUES
     (CURRENT_TIMESTAMP,'GM002',38,20),
	 (CURRENT_TIMESTAMP,'PH002',38,15)

GO

SELECT Codigo FROM BI_Mascotas WHERE CodigoPropietario = 104

GO

INSERT INTO BI_Mascotas_Enfermedades (Mascota,FechaInicio,FechaCura)
	VALUES
	('GH004','2016-12-20 10:05:00',null),
	('PH004','2016-12-20 10:05:00',null),
	('PH104','2016-12-20 10:05:00',null),
	('PM004','2016-12-20 10:05:00',null)

GO

SELECT Raza, especie, alias FROM BI_Mascotas ORDER BY FechaNacimiento

GO

-- 7. Escribe los códigos de todas las mascotas que han ido alguna vez al veterinario un lunes o un viernes. 
--Para averiguar el dia de la semana de una fecha se usa la función DATEPART (WeekDay, fecha) que devuelve un entero entre 1 y 7 
--donde el 1 corresponde al lunes, el dos al martes y así sucesivamente.

SELECT Mascota FROM BI_Visitas WHERE DATEPART (WEEKDAY, Fecha) IN (1, 5)