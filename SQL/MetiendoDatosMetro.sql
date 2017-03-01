USE [LeoMetroBeta]
GO

---insert TRENES
BEGIN TRANSACTION
GO
INSERT INTO LM_Trenes(ID,Matricula,Tipo,Capacidad,FechaEntraServicio)
			   VALUES(001,'TER101',1,100,'12/02/2010')
					,(002,'TER102',1,100,'10/04/2010')
					,(003,'TER103',2,90,'20/02/2012')
					,(004,'TER104',1,100,'16/09/2013')
					,(005,'TER105',2,100,'19/02/2013')
					,(006,'TER106',1,60,'10/04/2010')
					,(007,'TER107',3,100,'23/02/2012')
					,(008,'TER108',1,70,'11/07/2012')
					,(009,'TER109',3,100,'14/03/2013')

ROLLBACK
COMMIT TRANSACTION


SELECT * FROM LM_Trenes

---INSERT LINEA 
begin transaction 
go
INSERT INTO LM_Lineas(ID,Denominacion,Color)
			   values('L001','Pinar Chamartin - Valdecarros','azul')
					,('L002','Las Rosas - Cuatro Caminos','roja')
					,('L003','Villaverde Alto - Moncloa','amarillo')
					,('L004','Argüelles - Pinar Chamartin','marron')
					,('L005','Alameda de Osuna - Casa Campo','verde')
					
rollback
commit transaction

select * from LM_Lineas

--INSERT LM_Estaciones
DELETE FROM LM_Estaciones
BEGIN TRANSACTION 
GO
 INSERT INTO LM_Estaciones(ID,Denominacion,Direccion)
					values(1011,'Pinar Chamartin','Calle Los Pinos N.20')
						 ,(1012,'Quintana','Avenida Q N.1')
						 ,(1013,'Gran Via','Avenida GB N.15')
						 ,(1014,'Chueca','Avenida CH N.17')
						 ,(1015,'Acacias','Avenida AC N.11')
				         ,(1016,'Valdecarros','Avenida car N.31')

						 ,(1021,'Las Rosas','Calle Flores N.99')
						 ,(1022,'Estrecho','Avenida ES N.41')
						 ,(1023,'Alsacia','Avenida VL N.74')
						 ,(1024,'Goya','Avenida TR N.51')
						 ,(1025,'Retiro','Avenida RT N.51')
						 ,(1026,'Cuatro Caminos','Calle El Serro N.36')

						 ,(1031,'Villaverde Alto','Ave. LosPijos N.02')
						 ,(1032,'Almendrales','Calle ALM N.78')
						 ,(1033,'Delicias','Calle DL N.79')
						 ,(1034,'Argüelles','Calle Flores N.32')
						 ,(1035,'Cuatro Caminos','Calle El Serro N.36')
						 ,(1036,'Moncloa','Calle MasRata N.10')

						 ,(1041,'Argüelles','Calle Esparrago N.07')
						 ,(1042,'Lista','Calle UJM N.10')
						 ,(1043,'Canillas','Calle DF N.88')
						 ,(1044,'Esperanza','Calle EZX N.02')
						 ,(1045,'Manoteras','Calle MAN N.3')

						 ,(1051,'Alameda de Osuna','Calle N.15')
						 ,(1052,'Canillejas','Calle N.5')
						 ,(1053,'Ventas','Calle N.102')
						 ,(1054,'Chueca','Calle N.96')
						 ,(1055,'Callao','Calle N.452')
						 ,(1056,'Casa Campo','Calle MedioBosque N.06')
						 
ROLLBACK
COMMIT TRANSACTION

-- DELETE  LM_Estaciones

SELECT * FROM LM_Estaciones

---INSERT RECORRIDOS 
DELETE FROM LM_Recorridos
begin transaction
go
INSERT INTO LM_Recorridos(Tren,Linea,estacion, Momento)
				   values(001,'L001',1011, '2017-03-01 19:04:27.097') -- Pinar Chamartin
					    ,(001,'L001',1012, '2017-03-01 19:14:27.097') -- Quintana
						,(001,'L001',1023, '2017-03-01 19:24:27.097') -- Alsacia 
						,(001,'L001',1013, '2017-03-01 19:34:27.097') -- gran via
						,(001,'L001',1014, '2017-03-01 19:44:27.097') -- Chueca
						,(001,'L001',1033, '2017-03-01 19:54:27.097') --
						,(001,'L001',1015, '2017-03-01 20:10:27.097') --
						,(001,'L001',1045, '2017-03-01 20:12:27.097') -- Manoteras
						,(001,'L001',1016, '2017-03-01 20:13:27.097') --

						,(002,'L002',1021,'2017-03-01 19:04:27.097')
						,(002,'L002',1022,'2017-03-01 19:14:27.097') 
						,(002,'L002',1023,'2017-03-01 19:24:27.097') -- Alsacia
						,(002,'L002',1024,'2017-03-01 19:34:27.097')
						,(002,'L002',1045,'2017-03-01 19:44:27.097') -- Manoteras
						,(002,'L002',1025,'2017-03-01 19:54:27.097')
						,(002,'L002',1013,'2017-03-01 20:04:27.097') -- gran via
						,(002,'L002',1026,'2017-03-01 20:14:27.097')

						,(003,'L003',1031,'2017-03-01 19:04:27.097')
						,(003,'L003',1023,'2017-03-01 19:14:27.097') -- Alsacia
						,(003,'L003',1032,'2017-03-01 19:24:27.097')
						,(003,'L003',1133,'2017-03-01 19:34:27.097')
						,(003,'L003',1013,'2017-03-01 19:44:27.097') -- gran via
						,(003,'L003',1034,'2017-03-01 19:54:27.097')
						,(003,'L003',1045,'2017-03-01 20:04:27.097') -- Manoteras
						,(003,'L003',1035,'2017-03-01 20:14:27.097')
						,(003,'L003',1036,'2017-03-01 20:24:27.097') --Moncloa

						,(004,'L004',1041,'2017-03-01 19:04:27.097')
						,(004,'L004',1042,'2017-03-01 19:14:27.097')
						,(004,'L004',1043,'2017-03-01 19:24:27.097')--Canillas
						,(004,'L004',1044,'2017-03-01 19:34:27.097')
						,(004,'L004',1023,'2017-03-01 19:44:27.097') -- Alsacia
						,(004,'L004',1045,'2017-03-01 19:54:27.097') -- Manoteras
						,(004,'L004',1046,'2017-03-01 20:04:27.097')
						,(004,'L004',1013,'2017-03-01 20:14:27.097') -- gran via

						,(005,'L005',1051,'2017-03-01 19:04:27.097')
						,(005,'L005',1052,'2017-03-01 19:14:27.097')
						,(005,'L005',1036,'2017-03-01 19:24:27.097') --Moncloa
						,(005,'L005',1053,'2017-03-01 19:34:27.097')
						,(005,'L005',1054,'2017-03-01 19:44:27.097')
						,(005,'L005',1045,'2017-03-01 19:54:27.097') -- Manoteras
						,(005,'L005',1043,'2017-03-01 20:04:27.097')-- Canillas
						,(005,'L005',1013,'2017-03-01 20:14:27.097')
						,(005,'L005',1023,'2017-03-01 20:24:27.097') -- Alsacia
						,(005,'L005',1055,'2017-03-01 20:34:27.097')


rollback
commit transaction

/*
todos los trenes que hayan pasado por la estacion 'Gran Via'
hay cuatro trenes que han pasado por gran via
*/

SELECT T.ID
	FROM LM_Trenes AS T
	INNER JOIN
	LM_Recorridos AS R
	ON T.ID = R.Tren
	WHERE R.estacion = (SELECT ID
							FROM LM_Estaciones
							WHERE Denominacion = 'Gran Via')

/**
Todos los trenes que tienen en su recorrido Gran Via y Alsacia
hay cuatro trenes ue pasan por las dos 
*/

SELECT T.ID
	FROM LM_Trenes AS T
	INNER JOIN
	LM_Recorridos AS R
	ON T.ID = R.Tren
	WHERE R.estacion IN (SELECT ID
							FROM LM_Estaciones
							WHERE Denominacion = 'Gran Via' OR Denominacion = 'Alsacia')

/*
Los trenes que nunca han pasado por  Manoteras
todos pasan por Manoteras
*/

SELECT T.ID
	FROM LM_Trenes AS T
	INNER JOIN
	LM_Recorridos AS R
	ON T.ID = R.Tren

EXCEPT

SELECT T.ID
	FROM LM_Trenes AS T
	INNER JOIN
	LM_Recorridos AS R
	ON T.ID = R.Tren
	WHERE R.estacion = (SELECT ID
							FROM LM_Estaciones
							WHERE Denominacion = 'Manoteras')

/*
pasajeros que han salido de la estacion 'Las Rosas' y hayan salido por la estacion 
*/

SELECT P.ID
	FROM LM_Pasajeros AS P
	INNER JOIN
	LM_Viajes AS V
	ON P.ID = V.IDPasajero
	WHERE V.IDEstacionEntrada = (SELECT ID
									FROM LM_Estaciones
									WHERE Denominacion = 'Las Rosas') AND V.IDEstacionSalida = (SELECT ID
																									FROM LM_Estaciones
																									WHERE Denominacion = 'Las Rosas')

/*
los trenes que  hayan pasado por una estacion y que no hayan pasado por otra
*/

SELECT T.ID
	FROM LM_Trenes AS T
	INNER JOIN
	LM_Recorridos AS R
	ON T.ID = R.Tren
	WHERE (R.estacion = 1053) AND (R.estacion != 4324)

