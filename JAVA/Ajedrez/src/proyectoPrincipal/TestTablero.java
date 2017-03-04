package proyectoPrincipal;

public class TestTablero 
{
	public static void main (String [] args) throws ExceptionAjedrez
	{
		Tablero tablero = new Tablero ();
		Pieza pieza = new Pieza();
		
		tablero.generarTablero();
		
		tablero.mostrarTablero();
		
		tablero.moverPieza(7, 4, 5, 4);
		
		tablero.mostrarTablero();
	}
}
