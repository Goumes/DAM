package proyectoPrincipal;

import java.util.*;
import java.lang.*;
import java.io.*;

public class GestionadoraAjedrez 
{	
	/* Prototipo: Tablero turnoJugador (Tablero tablero, boolean Turno)
	 * Breve comentario: Funcionalidad que trata el turno entero de un jugador.
	 * Precondiciones: Ninguna
	 * Entradas: Un booleano
	 * Salidas: Ninguna
	 * Entradas/Salidas: Un tablero
	 * Postcondiciones: Un tablero con el movimiento del jugador ya ejecutado.
	 * 
	 * Resguardo: public static Tablero turnoJugador (Tablero tablero, boolean Turno)
		{
			System.out.println("Llamada al metodo turnoJugador");
			return tablero;
		}
	 */
	public static Tablero turnoJugador (Tablero tablero, boolean Turno)
	{
		Scanner teclado = new Scanner (System.in);
		boolean Continuar = true;
		int filaOriginal = 0;
		int columnaOriginal = 0;
		int filaNueva = 0;
		int columnaNueva = 0;
		
		do
			{
				Continuar = true;
				do
				{
					if (Continuar == false)
					{
						System.out.println();
		 				System.out.println("No hagas trampas. Sólo puedes mover tus piezas.");
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
					System.out.println("No puedes mover la pieza a esa posición.");
				}
			}
			while (Continuar == false);
				
			tablero.moverPieza(filaOriginal, columnaOriginal, filaNueva, columnaNueva);
			
		return tablero;
	}
	//Fin turnoJugador
	
	/* Prototipo: int comprobarVictoria (Tablero tablero)
	 * Breve comentario: Recorre un objeto tablero para comprobar si alguna pieza con tipo "Rey" ha sido eliminada.
	 * Precondiciones: Ninguna
	 * Entradas: Un tablero
	 * Salidas: Un entero
	 * Entradas/Salidas: Ninguna
	 * Postcondiciones: 1 si la partida ha acabado ganando el jugador blanco, 2 si ha ganado el jugador negro, 0 si sigue en juego.
	 * 
	 * Resguardo: public static boolean comprobarVictoria (Tablero tablero)
		{
			boolean resultado = false;
			
			System.out.println("Llamada al método comprobarVictoria");
			
			return resultado;
		}
	 */
	public static int comprobarVictoria (Tablero tablero)
	{
		int resultado = 0;
		int contadorRey = 0;
		boolean ganadorBlanco = false;
		
		for (int i = 0; i < tablero.getTablero ().length && contadorRey < 2; i++)
		{
			for (int j = 0; j < tablero.getTablero ()[0].length && contadorRey < 2; j++)
			{
				if (tablero.getTablero()[i][j] != null)
				{
					if (tablero.getTablero()[i][j].getTipo() == "Rey")
					{
						contadorRey++;
						
						if (tablero.getTablero()[i][j].getColor() == true)
						{
							ganadorBlanco = true;
						}
					}
				}
				
			}
		}
		
		if (contadorRey != 2 && ganadorBlanco == true)
		{
			resultado = 1;
		}
		
		else if (contadorRey != 2 && ganadorBlanco == false)
		{
			resultado = 2;
		}
		
		return resultado;
	}
	//Fin
}
