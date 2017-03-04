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
		String resultadoMovimiento = "0";
		String [] partes = null;
		
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
	 					try
	 					{
	 						filaOriginal = teclado.nextInt();
	 					}
	 					catch (InputMismatchException e)
	 					{
	 						System.out.print("No intentes petar el programa pls ty. ");
	 						teclado.next();
	 					}
	 					
	 					if (filaOriginal < 1 || filaOriginal > 8)
	 					{
	 						System.out.println("Selecciona una fila válida.");
	 					}
	 				}
	 				while (filaOriginal < 1 || filaOriginal > 8);
	 				
	 				filaOriginal = GestionadoraAjedrez.transformarFila(filaOriginal);
	 				columnaOriginalInt = GestionadoraAjedrez.transformarColumna(columnaOriginal);
	 				
	 				if (tablero.getTablero()[filaOriginal][columnaOriginalInt] != null)
	 				{
	 				
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
	 				else
	 				{
	 					Continuar = false;
	 					System.out.println("No puedes seleccionar una casilla vacía.");
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
					try
					{
						filaNueva = teclado.nextInt();
					}
					catch (InputMismatchException e)
					{
						System.out.print("No intentes petar el programa pls ty. ");
						teclado.next();
					}
					
					if (filaNueva < 1 || filaNueva > 8)
 					{
 						System.out.println("Selecciona una fila válida.");
 					}
				}
				while (filaNueva < 1 || filaNueva > 8);
				
				filaNueva = GestionadoraAjedrez.transformarFila(filaNueva);
				columnaNuevaInt = GestionadoraAjedrez.transformarColumna(columnaNueva);
				resultadoMovimiento = GestionadoraAjedrez.comprobarMovimiento (filaOriginal, columnaOriginalInt, filaNueva, columnaNuevaInt, tablero.getTablero()[filaOriginal][columnaOriginalInt].getTipo(), tablero);
				
				if ((tablero.getTablero()[filaNueva][columnaNuevaInt] != null
					&& tablero.getTablero()[filaNueva][columnaNuevaInt].getColor() == Turno) 
					|| tablero.getTablero()[filaNueva][columnaNuevaInt] == tablero.getTablero()[filaOriginal][columnaOriginalInt]
					|| (resultadoMovimiento == "-1"))
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
		
			if (resultadoMovimiento != "0" && resultadoMovimiento != "-1")
			{
				partes = resultadoMovimiento.split(",");
				filaNueva = Integer.valueOf(partes [0]);
				columnaNuevaInt = Integer.valueOf(partes [1]);
			}
				
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
	
	/* Prototipo: String comprobarMovimiento (int Fila1, int Columna1, int Fila2, int Columna2, String Tipo, Tablero tablero)
	 * Breve comentario: Comprueba si el tipo de la pieza recibida puede realizar ese movimiento.
	 * Precondiciones: Ninguna
	 * Entradas: Dos enteros, dos caracteres, un String y un Tablero
	 * Salidas: Un String
	 * Entradas/Salidas: Ninguna
	 * Postcondiciones: La cadena devuelve "0" si se ha movido correctamente, -1 sino o un conjunto de dos numeros separados por "," para indicar la nueva posición si se ha encontrado con un obstaculo.
	 * 
	 * Resguardo: public static String comprobarMovimiento (int Fila1, int Columna1, int Fila2, int Columna2, String Tipo, Tablero tablero)
		{
			boolean resultado = false;
			
			System.out.println("Llamada al metodo comprobarMovimiento");
			
			return resultado;
		}
	 */
	public static String comprobarMovimiento (int Fila1, int Columna1, int Fila2, int Columna2, String Tipo, Tablero tablero)
	{
		String resultado = "-1";
		
		if (Tipo == "Rey" 
			&& ((Fila1 - Fila2 == 1 || Fila1 - Fila2 == -1) && (Columna1 - Columna2 == 1 || Columna1 - Columna2 == -1))
				|| ((Fila1 - Fila2 == 1 || Fila1 - Fila2 == -1) && (Columna1 - Columna2 == 0))
				|| ((Fila1 - Fila2 == 0) && (Columna1 - Columna2 == 1 || Columna1 - Columna2 == -1)))
		{
			resultado = "0";
		}
		
		else if (Tipo == "Alfil"
				&& ((Fila1 - Fila2 == (Columna1 - Columna2))
					|| (Fila1 - Fila2 == - (Columna1 - Columna2))
					))
		{
			resultado = "0";
			if ((Fila1 - Fila2 == (Columna1 - Columna2)) && (Fila1 - Fila2) > 0)
			{
				for (int i = Fila1 - 1, j = Columna1 - 1; i > Fila2 && resultado != "-1"; i--, j--)
				{
					if (tablero.getTablero()[i][j] != null)
					{
						if (tablero.getTablero()[i][j].getColor() != tablero.getTablero()[Fila1][Columna1].getColor())
						{
							resultado = (i + "," + j);
						}
						
						else
						{
							resultado = "-1";
						}
					}
					else
					{
						resultado = "0";
					}
				}
			}
			
			else if ((Fila1 - Fila2 == Columna1 - Columna2) && (Fila1 - Fila2) < 0)
			{
				for (int i = Fila1 + 1, j = Columna1 + 1; i < Fila2 && resultado != "-1"; i++, j++)
				{
					if (tablero.getTablero()[i][j] != null)
					{
						if (tablero.getTablero()[i][j].getColor() != tablero.getTablero()[Fila1][Columna1].getColor())
						{
							resultado = (i + "," + j);
						}
						
						else
						{
							resultado = "-1";
						}
					}
					else
					{
						resultado = "0";
					}
				}
			}
			
			else if ((Fila1 - Fila2 == - (Columna1 - Columna2)) && (Fila1 - Fila2) > 0)
			{
				for (int i = Fila1 - 1, j = Columna1 + 1; i > Fila2 && resultado != "-1"; i--, j++)
				{
					if (tablero.getTablero()[i][j] != null)
					{
						if (tablero.getTablero()[i][j].getColor() != tablero.getTablero()[Fila1][Columna1].getColor())
						{
							resultado = (i + "," + j);
						}
						
						else
						{
							resultado = "-1";
						}
					}
					else
					{
						resultado = "0";
					}
				}
			}
			else
			{
				for (int i = Fila1 + 1, j = Columna1 - 1; i < Fila2 && resultado != "-1"; i++, j--)
				{
					if (tablero.getTablero()[i][j] != null)
					{
						if (tablero.getTablero()[i][j].getColor() != tablero.getTablero()[Fila1][Columna1].getColor())
						{
							resultado = (i + "," + j);
						}
						
						else
						{
							resultado = "-1";
						}
					}
					else
					{
						resultado = "0";
					}
				}
			}
		}
		
		else if (Tipo == "Torre"
				&& ((Fila1 != Fila2 && Columna1 == Columna2)
					|| Fila1 == Fila2 && Columna1 != Columna2))
		{
			resultado = "0";
			if ((Fila1 != Fila2 && Columna1 == Columna2) && (Fila1 - Fila2) > 0)
			{
				for (int i = Fila1 - 1, j = Columna1; i > Fila2 && resultado != "-1"; i--)
				{
					if (tablero.getTablero()[i][j] != null)
					{
						if (tablero.getTablero()[i][j].getColor() != tablero.getTablero()[Fila1][Columna1].getColor())
						{
							resultado = (i + "," + j);
						}
						
						else
						{
							resultado = "-1";
						}
					}
					else
					{
						resultado = "0";
					}
				}
			}
			else if ((Fila1 != Fila2 && Columna1 == Columna2) && (Fila1 - Fila2) < 0)
			{

				for (int i = Fila1 + 1, j = Columna1; i < Fila2 && resultado != "-1"; i++)
				{
					if (tablero.getTablero()[i][j] != null)
					{
						if (tablero.getTablero()[i][j].getColor() != tablero.getTablero()[Fila1][Columna1].getColor())
						{
							resultado = (i + "," + j);
						}
						
						else
						{
							resultado = "-1";
						}
					}
					else
					{
						resultado = "0";
					}
				}
			}
			
			else if ((Fila1 == Fila2 && Columna1 != Columna2) && (Columna1 - Columna2) > 0)
			{

				for (int i = Fila1, j = Columna1 - 1; j > Columna2 && resultado != "-1"; j--)
				{
					if (tablero.getTablero()[i][j] != null)
					{
						if (tablero.getTablero()[i][j].getColor() != tablero.getTablero()[Fila1][Columna1].getColor())
						{
							resultado = (i + "," + j);
						}
						
						else
						{
							resultado = "-1";
						}
					}
					else
					{
						resultado = "0";
					}
				}
			}
			
			else
			{
				for (int i = Fila1, j = Columna1 + 1; j < Columna2 && resultado != "-1"; j++)
				{
					if (tablero.getTablero()[i][j] != null)
					{
						if (tablero.getTablero()[i][j].getColor() != tablero.getTablero()[Fila1][Columna1].getColor())
						{
							resultado = (i + "," + j);
						}
						
						else
						{
							resultado = "-1";
						}
					}
					else
					{
						resultado = "0";
					}
				}
			}
		}
		
		else if (Tipo == "Caballo"
				&& (
						((Fila1 - Fila2 == 1 || Fila1 - Fila2 == -1) && (Columna1 - Columna2 == 2 || Columna1 - Columna2 == -2))
					|| ((Fila1 - Fila2 == 2 || Fila1 - Fila2 == -2) && (Columna1 - Columna2 == 1 || Columna1 - Columna2 == -1))
					)
				)
		{
			resultado = "0";
		}
		
		else if (Tipo == "Dama"
				&& (((Fila1 - Fila2 == Columna1 - Columna2)
						|| (Fila1 - Fila2 == - (Columna1 - Columna2)))
					|| ((Fila1 != Fila2 && Columna1 == Columna2) 
						|| Fila1 == Fila2 && Columna1 != Columna2)))
		{
			resultado = "0";
			if ((Fila1 - Fila2 == (Columna1 - Columna2)) && (Fila1 - Fila2) > 0)
			{
				for (int i = Fila1 - 1, j = Columna1 - 1; i > Fila2 && resultado != "-1"; i--, j--)
				{
					if (tablero.getTablero()[i][j] != null)
					{
						if (tablero.getTablero()[i][j].getColor() != tablero.getTablero()[Fila1][Columna1].getColor())
						{
							resultado = (i + "," + j);
						}
						
						else
						{
							resultado = "-1";
						}
					}
					else
					{
						resultado = "0";
					}
				}
			}
			
			else if ((Fila1 - Fila2 == Columna1 - Columna2) && (Fila1 - Fila2) < 0)
			{
				for (int i = Fila1 + 1, j = Columna1 + 1; i < Fila2 && resultado != "-1"; i++, j++)
				{
					if (tablero.getTablero()[i][j] != null)
					{
						if (tablero.getTablero()[i][j].getColor() != tablero.getTablero()[Fila1][Columna1].getColor())
						{
							resultado = (i + "," + j);
						}
						else
						{
							resultado = "-1";
						}
					}
					else
					{
						resultado = "0";
					}
				}
			}
			
			else if ((Fila1 - Fila2 == - (Columna1 - Columna2)) && (Fila1 - Fila2) > 0)
			{
				for (int i = Fila1 - 1, j = Columna1 + 1; i > Fila2 && resultado != "-1"; i--, j++)
				{
					if (tablero.getTablero()[i][j] != null)
					{
						if (tablero.getTablero()[i][j].getColor() != tablero.getTablero()[Fila1][Columna1].getColor())
						{
							resultado = (i + "," + j);
						}
						
						else
						{
							resultado = "-1";
						}
					}
					else
					{
						resultado = "0";
					}
				}
			}
			else if ((Fila1 - Fila2 == - (Columna1 - Columna2)) && (Fila1 - Fila2) < 0)
			{
				for (int i = Fila1 + 1, j = Columna1 - 1; i < Fila2 && resultado != "-1"; i++, j--)
				{
					if (tablero.getTablero()[i][j] != null)
					{
						if (tablero.getTablero()[i][j].getColor() != tablero.getTablero()[Fila1][Columna1].getColor())
						{
							resultado = (i + "," + j);
						}
						
						else
						{
							resultado = "-1";
						}
					}
					else
					{
						resultado = "0";
					}
				}
			}
			else if ((Fila1 != Fila2 && Columna1 == Columna2) && (Fila1 - Fila2) > 0)
			{
				for (int i = Fila1 - 1, j = Columna1; i > Fila2 && resultado != "-1"; i--)
				{
					if (tablero.getTablero()[i][j] != null)
					{
						if (tablero.getTablero()[i][j].getColor() != tablero.getTablero()[Fila1][Columna1].getColor())
						{
							resultado = (i + "," + j);
						}
						
						else
						{
							resultado = "-1";
						}
					}
					else
					{
						resultado = "0";
					}
				}
			}
			else if ((Fila1 != Fila2 && Columna1 == Columna2) && (Fila1 - Fila2) < 0)
			{

				for (int i = Fila1 + 1, j = Columna1; i < Fila2 && resultado != "-1"; i++)
				{
					if (tablero.getTablero()[i][j] != null)
					{
						if (tablero.getTablero()[i][j].getColor() != tablero.getTablero()[Fila1][Columna1].getColor())
						{
							resultado = (i + "," + j);
						}
						
						else
						{
							resultado = "-1";
						}
					}
					else
					{
						resultado = "0";
					}
				}
			}
			
			else if ((Fila1 == Fila2 && Columna1 != Columna2) && (Columna1 - Columna2) > 0)
			{

				for (int i = Fila1, j = Columna1 - 1; j > Columna2 && resultado != "-1"; j--)
				{
					if (tablero.getTablero()[i][j] != null)
					{
						if (tablero.getTablero()[i][j].getColor() != tablero.getTablero()[Fila1][Columna1].getColor())
						{
							resultado = (i + "," + j);
						}
						
						else
						{
							resultado = "-1";
						}
					}
					else
					{
						resultado = "0";
					}
				}
			}
			
			else
			{
				for (int i = Fila1, j = Columna1 + 1; j < Columna2 && resultado != "-1"; j++)
				{
					if (tablero.getTablero()[i][j] != null)
					{
						if (tablero.getTablero()[i][j].getColor() != tablero.getTablero()[Fila1][Columna1].getColor())
						{
							resultado = (i + "," + j);
						}
						
						else
						{
							resultado = "-1";
						}
					}
					else
					{
						resultado = "0";
					}
				}
			}
		}
		
		else if (Tipo == "Peon"
				&& (((Fila1 - Fila2 == 1) && (Columna1 - Columna2 == 0))
					|| ((Fila1 - Fila2 == 1) && (Columna1 - Columna2 == 1))
					|| ((Fila1 - Fila2 == 1) && (Columna1 - Columna2 == -1))
					|| ((Fila1 - Fila2 == -1) && (Columna1 - Columna2 == 0))
					|| ((Fila1 - Fila2 == -1) && (Columna1 - Columna2 == 1))
					|| ((Fila1 - Fila2 == -1) && (Columna1 - Columna2 == -1))
					|| ((Fila1 - Fila2 == 2) && (Columna1 - Columna2 == 0))
					|| ((Fila1 - Fila2 == -2) && (Columna1 - Columna2 == 0))))
		{
			if ((Fila1 - Fila2 == 1) && (Columna1 - Columna2 == 0))
			{
				
				if (tablero.getTablero()[Fila2][Columna2] != null)
				{
					if (tablero.getTablero()[Fila2][Columna2].getColor() != tablero.getTablero()[Fila1][Columna1].getColor())
					{
						resultado = "-1";
					}
				}
				else
				{
					resultado = "0";
				}
			}
			
			else if ((Fila1 - Fila2 == 1) && (Columna1 - Columna2 == 1))
			{
				if (tablero.getTablero()[Fila2][Columna2] != null)
				{
					if (tablero.getTablero()[Fila2][Columna2].getColor() != tablero.getTablero()[Fila1][Columna1].getColor())
					{
						resultado = "0";
					}
				}
				else
				{
					resultado = "-1";
				}
			}
			
			else if ((Fila1 - Fila2 == 1) && (Columna1 - Columna2 == -1))
			{
				if (tablero.getTablero()[Fila2][Columna2] != null)
				{
					if (tablero.getTablero()[Fila2][Columna2].getColor() != tablero.getTablero()[Fila1][Columna1].getColor())
					{
						resultado = "0";
					}
				}
				else
				{
					resultado = "-1";
				}
			}
			

			else if ((Fila1 - Fila2 == -1) && (Columna1 - Columna2 == 0))
			{
				if (tablero.getTablero()[Fila2][Columna2] != null)
				{
					if (tablero.getTablero()[Fila2][Columna2].getColor() != tablero.getTablero()[Fila1][Columna1].getColor())
					{
						resultado = "-1";
					}
				}
				else
				{
					resultado = "0";
				}
			}

			else if ((Fila1 - Fila2 == -1) && (Columna1 - Columna2 == 1))
			{
				if (tablero.getTablero()[Fila2][Columna2] != null)
				{
					if (tablero.getTablero()[Fila2][Columna2].getColor() != tablero.getTablero()[Fila1][Columna1].getColor())
					{
						resultado = "0";
					}
				}
				else
				{
					resultado = "-1";
				}
			}
			
			else if ((Fila1 - Fila2 == -1) && (Columna1 - Columna2 == -1))
			{
				if (tablero.getTablero()[Fila2][Columna2] != null)
				{
					if (tablero.getTablero()[Fila2][Columna2].getColor() != tablero.getTablero()[Fila1][Columna1].getColor())
					{
						resultado = "0";
					}
				}
				else
				{
					resultado = "-1";
				}
			}
			
			else if ((Fila1 - Fila2 == 2) && (Columna1 - Columna2 == 0))
			{
				if (Fila1 == 6)
				{
					resultado = "0";
				}
				
				else
				{
					resultado = "-1";
				}
			}
			
			else if ((Fila1 - Fila2 == -2) && (Columna1 - Columna2 == 0))
			{
				if (Fila1 == 1)
				{
					resultado = "0";
				}
				
				else
				{
					resultado = "-1";
				}
			}
		}
		return resultado;
	}
	//Fin comprobarMovimiento
	
}