package proyectoPrincipal;

import utilidades.utilArray;

public class TestGestionadoraAjedrez 
{
	public static void main (String [] args)
	{
		Pieza [][] tablero = new Pieza [8][8];
		Jugador jugador = new Jugador();
		
		try
		{
			tablero = GestionadoraAjedrez.generarTablero ();
		}
		catch (ExceptionAjedrez error)
		{
			System.out.println("Ha ocurrido un error creando el tablero.");
		}
		utilArray.imprimirArrayBidimensional(tablero);
		
	}
}
