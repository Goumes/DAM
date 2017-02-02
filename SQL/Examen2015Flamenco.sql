USE Flamenco

GO

/* Tenemos una base de datos sobre cantaores flamencos. Los artistas cantan diferentes
“palos”. Un mismo palo puede ser cantado por diferentes cantaores.
También registramos peñas flamencas, que están repartidas por diferentes localidades. Los
artistas actúan en las peñas.
Las peñas organizan festivales con periodicidad anual. En esos festivales actúan los artistas. */

/* Ejercicio 1
Número de veces que ha actuado cada cantaor en cada festival de la provincia de Cádiz,
incluyendo a los que no han actuado nunca */

SELECT * FROM F_Festivales
/* Ejercicio 2
Crea un nuevo palo llamado “Toná”.
Haz que todos los cantaores que cantaban Bamberas o Peteneras canten Tonás. No utilices
los códigos de los palos, sino sus nombres. */



/* Ejercicio 3
Número de cantaores mayores de 30 años que han actuado cada año en cada peña. Se
contará la edad que tenían en el año de la actuación. */



/* Ejercicio 4
Cantaores (nombre, apellidos y nombre artístico) que hayan actuado más de dos veces en
peñas de la provincia de Sevilla y canten Fandangos o Bulerías. Sólo se incluyen las
actuaciones directas en Peñas, no los festivales. */



/* Ejercicio 5
Número de actuaciones que se han celebrado en cada peña, incluyendo actuaciones directas
y en festivales. Incluye el nombre de la peña y la localidad. */