package proyectoPrincipal;

import utilidades.utilArray;

public class TestGestionadoraAjedrez 
{
	public static void main (String [] args)
	{
		Tablero tablero = new Tablero ();
		Jugador jugador = new Jugador();
		
		try
		{
			tablero.generarTablero ();
		}
		catch (ExceptionAjedrez error)
		{
			System.out.println("Ha ocurrido un error creando el tablero.");
		}
		tablero.mostrarTablero();
		
		System.out.println(GestionadoraAjedrez.comprobarVictoria(tablero));
	}
}
