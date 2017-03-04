package proyectoPrincipal;

/* Nombre del programa: Ajedrez
 * Entradas: Movimientos
 * Salidas: Mensajes
 * 
 * Restricciones: Ninguna
 * 
 * P.G
 * 
 * Inicio
 * 	LeerValidarEjecutar
 * 	Mientras QuieraEjecutar
 * 		GenerarTablero*
 * 		LeerNombresJugadores
 * 		ElegirColor*
 * 		JugarAjedrez
 * 		LeerValidarReiniciar
 * 	Fin_Mientras
 * Fin
 * 
 * ElegirColor es una funcionalidad que con un random asigna el lado blanco a un jugador aleatorio.
 * 
 * JugarAjedrez detallado Nivel 1.
 * 
 * Inicio
 * 	Mientras PartidaNoAcabada
 * 		MostrarTablero *
 * 		IndicarJugador
 * 		Repetir
 * 			MoverPieza
 * 		Mientras el movimiento sea incorrecto
 * 		Si Ficha sobreescribe otra
 *  		MoverFichaCementerio
 *  	Fin_si
 * 	Fin_Mientras
 * Fin
 */

import java.util.*;
import java.io.*;

public class Ajedrez
{
	public static void main (String [] args) throws IOException
	{
		Scanner teclado = new Scanner (System.in);
		InputStreamReader flujo = new InputStreamReader (System.in);
		BufferedReader tecladoString = new BufferedReader (flujo);
		Pieza [][] tablero = null;
		String Jugador1 = "";
		String Jugador2 = "";
		char Ejecutar = ' ';
		
		 	//LeerValidarEjecutar
			do
			{
				System.out.println("Desea comenzar una partida de ajedrez? S/N");
				Ejecutar = Character.toLowerCase(teclado.next().charAt(0));
			}
			while (Ejecutar != 's' && Ejecutar != 'n');
			//Fin LeerValidarEjecutar
		
		 	while (Ejecutar == 's')
		 	{
		
				//GenerarTablero
		 		try
		 		{
		 			tablero = GestionadoraAjedrez.generarTablero();
		 		}
		 		catch (ExceptionAjedrez error)
		 		{
		 			System.out.println("Ha ocurrido un error generando el tablero.");
		 		}
				//Fin GenerarTablero
		
		 		//LeerNombresJugadores
	 			System.out.println("Introduzca el nombre del Jugador 1");
	 			Jugador1 = tecladoString.readLine();
	 			
	 			System.out.println("Introduzca el nombre del Jugador 2");
	 			Jugador2 = tecladoString.readLine();

		 		System.out.println(Jugador1+", "+Jugador2);
				//Fin LeerNombresJugadores
		
		 		//ElegirColor
		 		
		 		/* Implementar clase Jugador con atributos Nombre, color del tablero y algo más. */
		 		
				//Fin ElegirColor
		
		 		//Mientras PartidaNoAcabada
		
	 		 		//MostrarTablero
					//Fin MostrarTablero
		
	 		 		//IndicarJugador
					//Fin IndicarJugador
		
	 		 		//Repetir
		
	 		 			//LeerValidarMovimientoJugador
						//Fin LeerValidarMovimientoJugador
		
	 		 		//Mientras el movimiento sea incorrecto
		
	 		 		//Si Ficha sobreescribe otra
		
	 		 			//MoverFichaCementerio
						//Fin MoverFichaCementerio
		
 		 		  	//Fin_si
		
		 		//Fin_Mientras
		
		 		//LeerValidarReiniciar
				do
				{
					System.out.println("Desea jugar otra partida de ajedrez? S/N");
					Ejecutar = Character.toLowerCase(teclado.next().charAt(0));
				}
				while (Ejecutar != 's' && Ejecutar != 'n');
				//Fin LeerValidarReiniciar
		
		}//Fin_Mientras
		
	}//fin_main
}//fin_clase
