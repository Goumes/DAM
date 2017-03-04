package proyectoPrincipal;

public class GestionadoraAjedrez 
{
	/* Prototipo: Pieza [][] generarTablero ()
	 * Breve comentario: Funcionalidad que crea un array de Piezas para hacer un tablero inicial.
	 * Precondiciones: Ninguna
	 * Entradas: Ninguna
	 * Salidas: Un array bidimensional de Piezas
	 * Entradas/Salidas: Ninguna
	 * Postcondiciones: Un array bidimensional de Piezas rellenado en forma de un tablero de ajedrez.
	 * 
	 * Resguardo: public static Pieza [][] generarTablero ()
		{
			System.out.println("Llamada al metodo generarTablero");
			return tablero;
		}
	 */
	public static Pieza [][] generarTablero () throws ExceptionAjedrez
	{
			Pieza torreBlanca1 = new Pieza (true, "Torre");
			Pieza torreBlanca2 = new Pieza (true, "Torre");
			
			Pieza torreNegra1 = new Pieza (false, "Torre");
			Pieza torreNegra2 = new Pieza (false, "Torre");
			
			Pieza caballoBlanco1 = new Pieza (true, "Caballo");
			Pieza caballoBlanco2 = new Pieza (true, "Caballo");
			
			Pieza caballoNegro1 = new Pieza (false, "Caballo");
			Pieza caballoNegro2 = new Pieza (false, "Caballo");
			
			Pieza alfilBlanco1 = new Pieza (true, "Alfil");
			Pieza alfilBlanco2 = new Pieza (true, "Alfil");
			
			Pieza alfilNegro1 = new Pieza (false, "Alfil");
			Pieza alfilNegro2 = new Pieza (false, "Alfil");
			
			Pieza damaBlanca = new Pieza (true, "Dama");
			
			Pieza damaNegra = new Pieza (false, "Dama");
			
			Pieza reyBlanco = new Pieza (true, "Rey");
			
			Pieza reyNegro = new Pieza (false, "Rey");
			
			Pieza peonBlanco1 = new Pieza (true, "Peon");
			Pieza peonBlanco2 = new Pieza (true, "Peon");
			Pieza peonBlanco3 = new Pieza (true, "Peon");
			Pieza peonBlanco4 = new Pieza (true, "Peon");
			Pieza peonBlanco5 = new Pieza (true, "Peon");
			Pieza peonBlanco6 = new Pieza (true, "Peon");
			Pieza peonBlanco7 = new Pieza (true, "Peon");
			Pieza peonBlanco8 = new Pieza (true, "Peon");
			
			Pieza peonNegro1 = new Pieza (false, "Peon");
			Pieza peonNegro2 = new Pieza (false, "Peon");
			Pieza peonNegro3 = new Pieza (false, "Peon");
			Pieza peonNegro4 = new Pieza (false, "Peon");
			Pieza peonNegro5 = new Pieza (false, "Peon");
			Pieza peonNegro6 = new Pieza (false, "Peon");
			Pieza peonNegro7 = new Pieza (false, "Peon");
			Pieza peonNegro8 = new Pieza (false, "Peon");
		
		
		
		
		Pieza [][] tablero = {
								{torreBlanca1, caballoBlanco1, alfilBlanco1, damaBlanca, reyBlanco, alfilBlanco2, caballoBlanco2, torreBlanca2},
								{peonBlanco1, peonBlanco2, peonBlanco3, peonBlanco4, peonBlanco5, peonBlanco6, peonBlanco7, peonBlanco8},
								{null, null, null, null, null, null, null, null},
								{null, null, null, null, null, null, null, null},
								{null, null, null, null, null, null, null, null},
								{null, null, null, null, null, null, null, null},
								{torreNegra1, caballoNegro1, alfilNegro1, damaNegra, reyNegro, alfilNegro2, caballoNegro2, torreNegra2},
								{peonNegro1, peonNegro2, peonNegro3, peonNegro4, peonNegro5, peonNegro6, peonNegro7, peonNegro8}
							 };
		return tablero;
	}
	//Fin
	
	/* Prototipo:
	 * Breve comentario:
	 * Precondiciones:
	 * Entradas:
	 * Salidas:
	 * Entradas/Salidas:
	 * Postcondiciones:
	 * 
	 * Resguardo:
	 */
	//Fin
}
