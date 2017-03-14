USE LeoMetro

GO

/*
1. Crea una función inline que nos devuelva el número de estaciones que ha recorrido cada tren en un determinado periodo de tiempo. 
El principio y el fin de ese periodo se pasarán como parámetros. */

set dateformat ymd --Pa darle el formato que yo quiero, que normalmente está el americano.

GO

CREATE FUNCTION NumeroEstaciones (@Principio DATETIME, @Final DATETIME)
RETURNS TABLE AS
RETURN
	(
		SELECT COUNT (estacion) AS NumeroEstaciones, Tren
			FROM LM_Recorridos
			WHERE Momento BETWEEN @Principio AND @Final
			GROUP BY Tren
	)

GO

SELECT *
	FROM NumeroEstaciones ('2017-02-26 09:27:13.000', '2017-02-28 09:27:13.000')

/*
2. Crea una función inline que nos devuelva el número de veces que cada usuario ha entrado en el metro en un periodo de tiempo. 
El principio y el fin de ese periodo se pasarán como parámetros. */

GO

CREATE FUNCTION NumeroViajes (@Principio DATETIME, @Final DATETIME)
RETURNS TABLE AS
RETURN
	(
		SELECT COUNT (MomentoEntrada) AS NumeroViajes,IDPasajero
			FROM LM_Viajes
			WHERE MomentoEntrada >= @Principio AND MomentoSalida <= @Final
			GROUP BY IDPasajero
	)

GO

SELECT *
	FROM NumeroViajes('2017-02-24 16:50:00', '2017-02-27 18:59:00')

/*
3. Crea una función inline a la que pasemos la matrícula de un tren y una fecha de inicio y fin y nos devuelva una tabla con el 
número de veces que ese tren ha estado en cada estación, además del ID, nombre y dirección de la estación. */

GO

CREATE FUNCTION NumeroVecesEstacion (@Matricula CHAR (7), @FechaInicio DATETIME, @FechaFin DATETIME)
RETURNS TABLE AS
RETURN
	(
		SELECT COUNT (R.Momento) AS NumeroPasadas, E.ID, E.Denominacion, E.Direccion
			FROM LM_Estaciones AS E
			INNER JOIN
			LM_Recorridos AS R
			ON E.ID = R.estacion
			INNER JOIN
			LM_Trenes AS T
			ON R.Tren = T.ID
			WHERE T.Matricula = @Matricula AND (R.Momento BETWEEN @FechaInicio AND @FechaFin)
			GROUP BY T.ID, E.ID, E.Denominacion, E.Direccion
	)

GO

SELECT *
	FROM NumeroVecesEstacion ('0100FLZ', '2017-02-26 02:20:00.000', '2017-02-28 05:24:50.000')

/*
4. Crea una función inline que nos diga el número de personas que han pasado por una estacion en un periodo de tiempo. 
Se considera que alguien ha pasado por una estación si ha entrado o salido del metro por ella. El principio y 
el fin de ese periodo se pasarán como parámetros. */

GO

CREATE FUNCTION NumeroPasajeros (@Inicio DATETIME, @Fin DATETIME)
RETURNS TABLE AS
RETURN
	(
		SELECT COUNT (IDPasajero) AS NumeroPasajeros, E.ID
			FROM LM_Viajes AS V
			INNER JOIN
			LM_Estaciones AS E
			ON V.IDEstacionEntrada = E.ID OR V.IDEstacionSalida = E.ID
			WHERE (MomentoEntrada BETWEEN @Inicio AND @Fin) OR (MomentoSalida BETWEEN @Inicio AND @Fin)
			GROUP BY E.ID
	)

GO

SELECT *
	FROM NumeroPasajeros ('2017-02-26 00:00:00', '2017-02-28 23:59:59')

/*
5. Crea una función inline que nos devuelva los kilómetros que ha recorrido cada tren en un periodo de tiempo.
El principio y el fin de ese periodo se pasarán como parámetros
*/

GO

CREATE FUNCTION KilometrosRecorridos (@Inicio DATETIME, @Fin DATETIME)
RETURNS TABLE AS
RETURN
	(
		SELECT SUM (Distancia) AS KilometrosRecorridos, R.Tren
			FROM LM_Itinerarios AS I
			INNER JOIN
			LM_Estaciones AS E
			ON I.estacionIni = E.ID OR I.estacionFin = E.ID
			INNER JOIN
			LM_Recorridos AS R
			ON E.ID = R.estacion
			WHERE R.Momento BETWEEN @Inicio AND @Fin
			GROUP BY R.Tren
	)

GO

SELECT *
	FROM KilometrosRecorridos ('2017-02-26 00:00:00', '2017-02-28 23:59:59')