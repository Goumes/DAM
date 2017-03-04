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
		boolean Turno = true;
		boolean Continuar = true;
		int filaOriginal = 0;
		int columnaOriginal = 0;
		int filaNueva = 0;
		int columnaNueva = 0;
		
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
		 			
		 			if (Turno == false)
		 			{
		 				if (jugador1.getColor () == false)
		 				{
		 					System.out.println("Es el turno de: "+jugador1.getNombre());
		 				}
		 				
		 				else
		 				{
		 					System.out.println("Es el turno de: "+jugador2.getNombre());
		 				}
		 			}
					//Fin IndicarJugador
		
		 			//LeerValidarMovimientoJugador
		 			System.out.println();
	 				System.out.println("Realiza tu movimiento. Indica la posici�n actual y a la que te gustar�a mover la pieza.");
		 			do
		 			{
		 				Continuar = true;
		 				do
		 				{
		 					if (Continuar == false)
		 					{
		 						System.out.println();
		 		 				System.out.println("No hagas trampas. S�lo puedes mover tus piezas.");
		 					}
			 				do
			 				{
			 					filaOriginal = teclado.nextInt();
			 				}
			 				while (filaOriginal < 0 || filaOriginal > 7);
			 				
			 				do
			 				{
			 					columnaOriginal = teclado.nextInt();
			 				}
			 				while (columnaOriginal < 0 || columnaOriginal > 7);
			 				
			 				if (tablero.getTablero()[filaOriginal][columnaOriginal].getColor() != Turno)
			 				{
			 					Continuar = false;
			 				}
			 				else
			 				{
			 					Continuar = true;
			 				}
		 				}
		 				while (Continuar == false);
 					
		 				do
		 				{
		 					filaNueva = teclado.nextInt();
		 				}
		 				while (filaNueva < 0 || filaNueva > 7);
		 				
		 				do
		 				{
		 					columnaNueva = teclado.nextInt();
		 				}
		 				while (columnaNueva < 0 || columnaNueva > 7);
		 				
		 				if ((tablero.getTablero()[filaNueva][columnaNueva] != null
		 					&& tablero.getTablero()[filaNueva][columnaNueva].getColor() == Turno) 
		 					|| tablero.getTablero()[filaNueva][columnaNueva] == tablero.getTablero()[filaOriginal][columnaOriginal])
		 				{
		 					Continuar = false;
		 				}
		 				else
		 				{
		 					Continuar = true;
		 				}
		 				
		 				if (Continuar == false)
	 					{
	 						System.out.println("No puedes mover la pieza a esa posici�n.");
	 					}
	 				}
	 				while (Continuar == false);
		 				
	 				tablero.moverPieza(filaOriginal, columnaOriginal, filaNueva, columnaNueva);
	 				
	 				Turno = !Turno;
			 		//Fin LeerValidarMovimientoJugador
			
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
