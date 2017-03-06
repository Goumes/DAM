package proyectoPrincipal;

/* Nombre del programa: Ajedrez
 * Entradas: Nombres y movimientos
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
 * JugarAjedrez detallado Nivel 1.
 * 
 * Inicio
 * 	Mientras PartidaNoAcabada
 * 		MostrarTablero *
 * 		IndicarJugador
 * 		EjecutarTurno *
 * 		ComprobarPartidaAcabada *
 * 	Fin_Mientras
 *  DeclararGanador
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
		Tablero tablero = new Tablero ();
		Jugador jugador1 = new Jugador ();
		Jugador jugador2 = new Jugador ();
		char Ejecutar = ' ';
		boolean Acabar = false;
		boolean Turno = true;
		int Ganador = 0;
		
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
				//Fin LeerNombresJugadores
		
		 		//ElegirColor
		 		jugador1.elegirColor();
		 		
		 		if (jugador1.getColor() == true)
		 		{
		 			jugador2.setColor(false);
		 			System.out.println("Las piezas blancas le han tocado a: "+jugador1.getNombre());
		 			System.out.println();
		 		}
		 		
		 		else
		 		{
		 			jugador2.setColor(true);
		 			System.out.println("Las piezas blancas le han tocado a: "+jugador2.getNombre());
		 			System.out.println();
		 		}
				//Fin ElegirColor
		
		 		//Mientras PartidaNoAcabada
		 		while (Acabar == false)
		 		{
		
	 		 		//MostrarTablero
		 			tablero.mostrarTablero();
					//Fin MostrarTablero
		
	 		 		//IndicarJugador
		 			if (Turno == true)
		 			{
		 				if (jugador1.getColor () == true)
		 				{
		 					System.out.println("Es el turno de: "+jugador1.getNombre());
		 				}
		 				
		 				else
		 				{
		 					System.out.println("Es el turno de: "+jugador2.getNombre());
		 				}
		 			}
		 			
					//Fin IndicarJugador
		
		 			//EjecutarTurno
		 			System.out.println();
	 				System.out.println("Realiza tu movimiento. Indica la posición actual y a la que te gustaría mover la pieza.");
		 			
	 				tablero = GestionadoraAjedrez.turnoJugador(tablero, Turno);
	 				
	 				Turno = !Turno;
			 		//Fin EjecutarTurno
	 				
	 				//ComprobarPartidaAcabada
	 				Ganador = GestionadoraAjedrez.comprobarVictoria(tablero);
	 				
	 				if (Ganador != 0)
	 				{
	 					Acabar = true;
	 				}
	 				//Fin ComprobarPartidaAcabada
			
		 		}//Fin_Mientras
		 		
		 		//DeclararGanador
 				if (Ganador == 1 && jugador1.getColor() == true
 					|| Ganador == 2 && jugador1.getColor() == false)
 				{
 					System.out.println("Ha ganado el jugador: "+jugador1.getNombre()+". Enhorabuena!");
 				}
 				
 				else
 				{
 					System.out.println("Ha ganado el jugador: "+jugador2.getNombre()+". Enhorabuena!");	
 				}
 				
 				System.out.println();
 				//Fin DeclararGanador
			
		 		//LeerValidarReiniciar
				do
				{
					System.out.println("Desea jugar otra partida de ajedrez? S/N");
					Ejecutar = Character.toLowerCase(teclado.next().charAt(0));	
				}
				while (Ejecutar != 's' && Ejecutar != 'n');
				Acabar = false;
				//Fin LeerValidarReiniciar
				
		}//Fin_Mientras
		
	}//fin_main
}//fin_clase