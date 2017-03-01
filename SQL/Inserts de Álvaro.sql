USE [LeoMetroBeta]
GO
BEGIN TRANSACTION
INSERT INTO [dbo].[LM_Estaciones]
           ([ID]
           ,[Denominacion]
           ,[Direccion])
     VALUES
           (1,'Plaza del Duque','Plaza del Duque,1, Sevilla')
GO
INSERT INTO [dbo].[LM_Estaciones]
           ([ID]
           ,[Denominacion]
           ,[Direccion])
     VALUES
           (2,'Encarnación','Calle La Encarnación,1, Sevilla')

GO
INSERT INTO [dbo].[LM_Estaciones]
           ([ID]
           ,[Denominacion]
           ,[Direccion])
     VALUES
           (3,'Ponce de León','Plaza Ponce de León,1, Sevilla')
GO
INSERT INTO [dbo].[LM_Estaciones]
           ([ID]
           ,[Denominacion]
           ,[Direccion])
     VALUES
           (4,'Puerta Osario','Calle Puerta del Osario,1, Sevilla')
GO
INSERT INTO [dbo].[LM_Estaciones]
           ([ID]
           ,[Denominacion]
           ,[Direccion])
     VALUES
           (5,'Sevilla Este','Avenida del Quinto Infierno,1, Sevilla Este')
GO
INSERT INTO [dbo].[LM_Estaciones]
           ([ID]
           ,[Denominacion]
           ,[Direccion])
     VALUES
           (6,'Instituto','Avda Buenaventura Pinillos,1, Sevilla Este')
GO
/*Insertamos Líneas*/
INSERT INTO [dbo].[LM_Lineas]
           ([ID]
           ,[Denominacion]
           ,[Color])
     VALUES
           ('INST','Instituto','Rojo')
GO
INSERT INTO [dbo].[LM_Lineas]
           ([ID]
           ,[Denominacion]
           ,[Color])
     VALUES
           ('SVES','Sevilla Este','Azul')
GO
/*Insertamos itinerarios*/
INSERT INTO [dbo].[LM_Itinerarios]
           ([estacionIni]
           ,[estacionFin]
           ,[NumOrden]
           ,[Linea]
           ,[TiempoEstimado]
           ,[Distancia])
     VALUES
           (1,2, 1,'INST','00:02:00.000',10.50)
GO
INSERT INTO [dbo].[LM_Itinerarios]
           ([estacionIni]
           ,[estacionFin]
           ,[NumOrden]
           ,[Linea]
           ,[TiempoEstimado]
           ,[Distancia])
     VALUES
           (2,3, 2,'INST','00:10:00.000',12.23)
GO
INSERT INTO [dbo].[LM_Itinerarios]
           ([estacionIni]
           ,[estacionFin]
           ,[NumOrden]
           ,[Linea]
           ,[TiempoEstimado]
           ,[Distancia])
     VALUES
           (3,4, 3,'INST','00:05:00.000',08.45)
GO
INSERT INTO [dbo].[LM_Itinerarios]
           ([estacionIni]
           ,[estacionFin]
           ,[NumOrden]
           ,[Linea]
           ,[TiempoEstimado]
           ,[Distancia])
     VALUES
           (4,6, 4,'INST','00:35:00.000',27.32)
GO
--Itinerario Línea Sevilla Este ahora
INSERT INTO [dbo].[LM_Itinerarios]
           ([estacionIni]
           ,[estacionFin]
           ,[NumOrden]
           ,[Linea]
           ,[TiempoEstimado]
           ,[Distancia])
     VALUES
           (1,2, 1,'SVES','00:02:00.000',10.50)
GO
INSERT INTO [dbo].[LM_Itinerarios]
           ([estacionIni]
           ,[estacionFin]
           ,[NumOrden]
           ,[Linea]
           ,[TiempoEstimado]
           ,[Distancia])
     VALUES
           (1,6, 1,'SVES','00:02:00.000',100.50)
GO
INSERT INTO [dbo].[LM_Itinerarios]
           ([estacionIni]
           ,[estacionFin]
           ,[NumOrden]
           ,[Linea]
           ,[TiempoEstimado]
           ,[Distancia])
     VALUES
           (1,5, 1,'SVES','00:02:00.000',80.50)
GO
INSERT INTO [dbo].[LM_Itinerarios]
           ([estacionIni]
           ,[estacionFin]
           ,[NumOrden]
           ,[Linea]
           ,[TiempoEstimado]
           ,[Distancia])
     VALUES
           (1,1, 1,'SVES','00:02:00.000',5.50)
GO
INSERT INTO [dbo].[LM_Itinerarios]
           ([estacionIni]
           ,[estacionFin]
           ,[NumOrden]
           ,[Linea]
           ,[TiempoEstimado]
           ,[Distancia])
     VALUES
           (1,3, 1,'SVES','00:02:00.000',15.50)
GO
INSERT INTO [dbo].[LM_Itinerarios]
           ([estacionIni]
           ,[estacionFin]
           ,[NumOrden]
           ,[Linea]
           ,[TiempoEstimado]
           ,[Distancia])
     VALUES
           (2,3, 2,'SVES','00:10:00.000',12.23)
GO
INSERT INTO [dbo].[LM_Itinerarios] 
           ([estacionIni]
           ,[estacionFin]
           ,[NumOrden]
           ,[Linea]
           ,[TiempoEstimado]
           ,[Distancia])
     VALUES
           (3,5, 3,'SVES','01:10:00.000',72.64)
GO

/*Insertamos pasajeros*/
INSERT INTO [dbo].[LM_Pasajeros]
           ([ID]
           ,[Nombre]
           ,[Apellidos]
           ,[Direccion]
           ,[Ciudad]
           ,[Telefono1]
           ,[Telefono2])
     VALUES
           (1,'Álvaro','Lag Caballero','Plaza Alameda de Hércules, nº86 1ºA','Sevilla','697144959','955323629')
		   ,(2,'Alejandro','Gómez','Calle Padre Marchena, 4, Bajo','Sevilla','622547148','955323428')
GO
--Añado uno más al final
INSERT INTO [dbo].[LM_Pasajeros]
           ([ID]
           ,[Nombre]
           ,[Apellidos]
           ,[Direccion]
           ,[Ciudad]
           ,[Telefono1]
           ,[Telefono2])
     VALUES
           (3,'Carlos','Aliaño Pérez','Calle Sus Muerto, 37','Sevilla Este','611123456','912321654')
GO
		   
/*Insertamos trenes*/
INSERT INTO [dbo].[LM_Trenes]
           ([ID]
           ,[Matricula]
           ,[Tipo]
           ,[Capacidad]
           ,[FechaEntraServicio])
     VALUES
           (1,'1234567',1, 70,'27-08-1996')
		   ,(2,'7654321',2, 120,'29-12-2016')
GO

/*Insertamos recorridos*/
INSERT INTO [dbo].[LM_Recorridos]
           ([Tren]
           ,[Linea]
           ,[estacion]
           ,[Momento])
     VALUES
           (1,'INST',1,'2017-03-01 19:42:27.097')
		   ,(1,'INST',2,'2017-03-01 19:44:27.097')
		   ,(1,'INST',3,'2017-03-01 19:54:27.097')
		   ,(1,'INST',4,'2017-03-01 19:59:27.097')
		   ,(1,'INST',6,'2017-03-01 20:34:27.097')
GO
--Recorridos Línea Sevilla Este
INSERT INTO [dbo].[LM_Recorridos]
           ([Tren]
           ,[Linea]
           ,[estacion]
           ,[Momento])
     VALUES
           (2,'SVES',1,'2017-03-01 19:42:27.097')
		   ,(2,'SVES',2,'2017-03-01 19:44:27.097')
		   ,(2,'SVES',3,'2017-03-01 19:54:27.097')
		   ,(2,'SVES',5,'2017-03-01 21:04:27.097')
GO

/*Insertamos viajes*/
INSERT INTO [dbo].[LM_Viajes]
           ([IDPasajero]
           ,[IDEstacionEntrada]
           ,[IDEstacionSalida]
           ,[MomentoEntrada]
           ,[MomentoSalida])
     VALUES
           (1,1,6,'2017-03-01 19:44:27.097','2017-03-01 20:34:27.097')
		   ,(3,1,5,'2017-03-01 19:44:27.097','2017-03-01 21:04:27.097')
		   ,(2,1,1,'2017-03-01 19:44:27.097','2017-03-01 20:34:27.097')
		   ,(2,1,3,'2017-03-01 19:44:27.097','2017-03-01 21:04:27.097')
GO

rollback
commit transaction


/*
Linea que recorre más distancia
*/
GO
CREATE VIEW DistanciaPorLinea AS
SELECT SUM (Distancia) AS DistanciaRecorrida, Linea
	FROM LM_Itinerarios
	GROUP BY Linea
GO

CREATE VIEW MaxDistanciaRecorrida AS
SELECT MAX (DistanciaRecorrida) AS LineaQueRecorreMas
	FROM DistanciaPorLinea

GO

SELECT LineaQueRecorreMas, L.ID, L.Denominacion
	FROM MaxDistanciaRecorrida
	INNER JOIN
	DistanciaPorLinea AS DPL
	ON MaxDistanciaRecorrida.LineaQueRecorreMas = DPL.DistanciaRecorrida
	INNER JOIN
	LM_Lineas AS L
	ON DPL.Linea = L.ID

/*
El pasajero que más distancia recorre
*/
GO

CREATE VIEW DistanciaRecorridaPasajero AS

SELECT DISTINCT SUM (I.Distancia) AS DistanciaRecorrida, V.IDPasajero
	FROM LM_Viajes AS V
	INNER JOIN
	LM_Estaciones AS E
	ON V.IDEstacionEntrada = E.ID OR V.IDEstacionSalida = E.ID
	INNER JOIN
	LM_Itinerarios AS I
	ON E.ID = I.estacionFin OR E.ID = I.estacionIni
	GROUP BY V.IDPasajero

GO

CREATE VIEW DistanciaRecorridaMax AS

SELECT MAX (DistanciaRecorrida) AS MaxDistanciaRecorrida
	FROM DistanciaRecorridaPasajero

GO

SELECT DRP.IDPasajero, MaxDistanciaRecorrida
	FROM DistanciaRecorridaPasajero AS DRP
	INNER JOIN
	DistanciaRecorridaMax AS DRM
	ON DRP.DistanciaRecorrida = DRM.MaxDistanciaRecorrida