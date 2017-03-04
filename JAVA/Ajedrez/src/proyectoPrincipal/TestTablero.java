package proyectoPrincipal;

public class TestTablero 
{
	public static void main (String [] args) throws ExceptionAjedrez
	{
		Tablero tablero = new Tablero ();
		
		tablero.generarTablero();
		
		tablero.mostrarTablero();
	}
}
