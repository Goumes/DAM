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

import utilidades.utilArray;

import java.io.*;

public class Ajedrez
{
	public static void main (String [] args) throws IOException
	{
		Scanner teclado = new Scanner (System.in);
		InputStreamReader flujo = new InputStreamReader (System.in);
		BufferedReader tecladoString = new BufferedReader (flujo);
		Tablero tablero = new Tablero ();
		Jugador jugador1 = new Jugador ();
		Jugador jugador2 = new Jugador ();
		char Ejecutar = ' ';
		boolean Acabar = false;
		
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
		 			tablero.generarTablero();
		 		}
		 		catch (ExceptionAjedrez error)
		 		{
		 			System.out.println("Ha ocurrido un error generando el tablero.");
		 		}
		 		
				//Fin GenerarTablero
		
		 		//LeerNombresJugadores
	 			System.out.println("Introduzca el nombre del Jugador 1");
	 			jugador1.setNombre (tecladoString.readLine());
	 			
	 			System.out.println("Introduzca el nombre del Jugador 2");
	 			jugador2.setNombre(tecladoString.readLine());

		 		System.out.println(jugador1.getNombre()+", "+jugador2.getNombre());
				//Fin LeerNombresJugadores
		
		 		//ElegirColor
		 		
		 		jugador1.elegirColor();
		 		
		 		if (jugador1.getColor() == true)
		 		{
		 			jugador2.setColor(false);
		 		}
		 		
		 		else
		 		{
		 			jugador2.setColor(true);
		 		}
		 		
				//Fin ElegirColor
		
		 		//Mientras PartidaNoAcabada
		 		while (Acabar == false)
		 		{
		
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
		
		 		}//Fin_Mientras
		
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
