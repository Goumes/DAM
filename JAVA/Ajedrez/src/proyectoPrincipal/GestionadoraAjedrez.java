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
		char columnaOriginal = ' ';
		int filaOriginal = 0;
		char columnaNueva = ' ';
		int filaNueva = 0;
		int columnaOriginalInt = 0;
		int columnaNuevaInt = 0;
		
		do
			{
				Continuar = true;
				do
				{
	 				do
	 				{
	 					columnaOriginal = Character.toLowerCase(teclado.next().charAt(0));
	 					
	 					if (columnaOriginal < 'a' || columnaOriginal > 'h')
	 					{
	 						System.out.println("Selecciona una columna válida.");
	 					}
	 				}
	 				while (columnaOriginal < 'a' || columnaOriginal > 'h');
	 				
	 				do
	 				{
	 					filaOriginal = teclado.nextInt();
	 					
	 					if (filaOriginal < 1 || filaOriginal > 8)
	 					{
	 						System.out.println("Selecciona una fila válida.");
	 					}
	 				}
	 				while (filaOriginal < 1 || filaOriginal > 8);
	 				
	 				filaOriginal = GestionadoraAjedrez.transformarFila(filaOriginal);
	 				columnaOriginalInt = GestionadoraAjedrez.transformarColumna(columnaOriginal);
	 				
	 				if (tablero.getTablero()[filaOriginal][columnaOriginalInt].getColor() != Turno)
	 				{
	 					Continuar = false;
	 					System.out.println();
		 				System.out.println("No hagas trampas. Sólo puedes mover tus piezas.");
	 				}
	 				else
	 				{
	 					Continuar = true;
	 				}
				}
				while (Continuar == false);
			
				do
				{
					columnaNueva = Character.toLowerCase(teclado.next().charAt(0));
					
					if (columnaNueva < 'a' || columnaNueva > 'h')
 					{
 						System.out.println("Selecciona una columna válida.");
 					}
				}
				while (columnaNueva < 'a' || columnaNueva > 'h');
				
				do
				{
					filaNueva = teclado.nextInt();
					
					if (filaNueva < 1 || filaNueva > 8)
 					{
 						System.out.println("Selecciona una fila válida.");
 					}
				}
				while (filaNueva < 1 || filaNueva > 8);
				
				filaNueva = GestionadoraAjedrez.transformarFila(filaNueva);
				columnaNuevaInt = GestionadoraAjedrez.transformarColumna(columnaNueva);
				
				if ((tablero.getTablero()[filaNueva][columnaNuevaInt] != null
					&& tablero.getTablero()[filaNueva][columnaNuevaInt].getColor() == Turno) 
					|| tablero.getTablero()[filaNueva][columnaNuevaInt] == tablero.getTablero()[filaOriginal][columnaOriginalInt]
					|| GestionadoraAjedrez.comprobarMovimiento (filaOriginal, columnaOriginalInt, filaNueva, columnaNuevaInt, tablero.getTablero()[filaOriginal][columnaOriginalInt].getTipo()) == false)
				{
					Continuar = false;
					System.out.println("No puedes mover la pieza a esa posición.");
				}
				else
				{
					Continuar = true;
				}
				
			}
			while (Continuar == false);
				
			tablero.moverPieza(filaOriginal, columnaOriginalInt, filaNueva, columnaNuevaInt);
			
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
	
	/* Prototipo: int transformaColumna (char Columna)
	 * Breve comentario: Transforma un caracter a un entero relacionado con la posición en el tablero.
	 * Precondiciones: Un caracter de la a a la h.
	 * Entradas: Un caracter
	 * Salidas: Un entero
	 * Entradas/Salidas: Ninguna
	 * Postcondiciones: Un entero en relación al caracter recibido.
	 * 
	 * Resguardo: public static int transformarColumna (char Columna)
		{
			int resultado = 0;
			
			System.out.println("Llamada al metodo transformarColumna");
			
			return resultado;
		}
	 */
	public static int transformarColumna (char Columna)
	{
		int resultado = 0;
		
		if (Columna == 'a')
		{
			resultado = 0;
		}
		else if (Columna == 'b')
		{
			resultado = 1;
		}
		
		else if (Columna == 'c')
		{
			resultado = 2;
		}
		
		else if (Columna == 'd')
		{
			resultado = 3;
		}
		
		else if (Columna == 'e')
		{
			resultado = 4;
		}
		
		else if (Columna == 'f')
		{
			resultado = 5;
		}
		
		else if (Columna == 'g')
		{
			resultado = 6;
		}
		
		else
		{
			resultado = 7;
		}
		
		return resultado;
	}
	//Fin transformarColumna
	
	/* Prototipo: int transformarFila (int Fila)
	 * Breve comentario: Transforma un entero a otro relacionado con la posición en el tablero.
	 * Precondiciones: Un entero del 1 al 8
	 * Entradas: Un entero
	 * Salidas: Un entero
	 * Entradas/Salidas: Ninguna
	 * Postcondiciones: Un entero nuevo en relación al entero recibido.
	 * 
	 * Resguardo: public static int transformarFila (int Fila)
		{
			int resultado = 0;
			
			System.out.println("Llamada al metodo transformarFila");
			
			return resultado;
		}
	 */
	public static int transformarFila (int Fila)
	{
		int resultado = 0;
		
		if (Fila == 1)
		{
			resultado = 7;
		}
		
		else if (Fila == 2)
		{
			resultado = 6;
		}
		
		else if (Fila == 3)
		{
			resultado = 5;
		}
		
		else if (Fila == 4)
		{
			resultado = 4;
		}
		
		else if (Fila == 5)
		{
			resultado = 3;
		}
		
		else if (Fila == 6)
		{
			resultado = 2;
		}
		
		else if (Fila == 7)
		{
			resultado = 1;
		}
		
		else if (Fila == 8)
		{
			resultado = 0;
		}
		
		return resultado;
	}
	//Fin transformarFila
	
	/* Prototipo: boolean comprobarMovimiento (int Fila1, int Columna1, int Fila2, int Columna2, String Tipo)
	 * Breve comentario: Comprueba si el tipo de la pieza recibida puede realizar ese movimiento.
	 * Precondiciones: Ninguna
	 * Entradas: Dos enteros, dos caracteres y un String
	 * Salidas: Un booleano
	 * Entradas/Salidas: Ninguna
	 * Postcondiciones: True si el movimiento es posible, false sino
	 * 
	 * Resguardo: public static boolean comprobarMovimiento (int Fila1, int Columna1, int Fila2, int Columna2, String Tipo)
		{
			boolean resultado = false;
			
			System.out.println("Llamada al metodo comprobarMovimiento");
			
			return resultado;
		}
	 */
	public static boolean comprobarMovimiento (int Fila1, int Columna1, int Fila2, int Columna2, String Tipo)
	{
		boolean resultado = false;
		
		if (Tipo == "Rey" 
			&& ((Fila1 - Fila2 == 1 || Fila1 - Fila2 == -1) && (Columna1 - Columna2 == 1 || Columna1 - Columna2 == -1))
				|| ((Fila1 - Fila2 == 1 || Fila1 - Fila2 == -1) && (Columna1 - Columna2 == 0))
				|| ((Fila1 - Fila2 == 0) && (Columna1 - Columna2 == 1 || Columna1 - Columna2 == -1)))
		{
			resultado = true;
		}
		
		else if (Tipo == "Alfil"
				&& ((Fila1 - Fila2 == Columna1 - Columna2)
					|| (Fila1 - Fila2 == Columna2 - Columna1)
					|| (Fila2 - Fila1 == Columna1 - Columna2)))
		{
			resultado = true;
		}
		
		else if (Tipo == "Torre"
				&& ((Fila1 != Fila2 && Columna1 == Columna2)
					|| Fila1 == Fila2 && Columna1 != Columna2))
		{
			resultado = true;
		}
		
		else if (Tipo == "Caballo"
				&& (
						((Fila1 - Fila2 == 1 || Fila1 - Fila2 == -1) && (Columna1 - Columna2 == 2 || Columna1 - Columna2 == -2))
					|| ((Fila1 - Fila2 == 2 || Fila1 - Fila2 == -2) && (Columna1 - Columna2 == 1 || Columna1 - Columna2 == -1))
					)
				)
		{
			resultado = true;
		}
		
		else if (Tipo == "Dama"
				&& (((Fila1 - Fila2 == Columna1 - Columna2)
						|| (Fila1 - Fila2 == Columna2 - Columna1)
						|| (Fila2 - Fila1 == Columna1 - Columna2))
					|| ((Fila1 != Fila2 && Columna1 == Columna2) 
						|| Fila1 == Fila2 && Columna1 != Columna2)))
		{
			resultado = true;
		}
		
		else if (Tipo == "Peon"
				&& ((Fila2 - Fila1 == 1) && (Columna1 - Columna2 == 0)))
		{
			resultado = true;
		}
		return resultado;
	}
	//Fin comprobarMovimiento
}
