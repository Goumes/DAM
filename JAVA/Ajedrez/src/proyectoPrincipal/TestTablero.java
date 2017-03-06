package proyectoPrincipal;

public class TestTablero 
{
	public static void main (String [] args) throws ExceptionAjedrez
	{
		Tablero tablero = new Tablero ();
		Tablero tablero2 = new Tablero ();
		Tablero tableroCopia = null;
		
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
	
	
	
	
	Pieza [][] arrayPiezas = {
							
							{torreNegra1, caballoNegro1, alfilNegro1, damaNegra, reyNegro, alfilNegro2, caballoNegro2, torreNegra2},
							{peonNegro1, peonNegro2, peonNegro3, peonNegro4, peonNegro5, peonNegro6, peonNegro7, peonNegro8},
							{null, null, null, null, null, null, null, null},
							{null, null, null, null, null, null, null, null},
							{null, null, null, null, null, null, null, null},
							{null, null, null, null, null, null, null, null},
							{torreBlanca1, peonBlanco2, peonBlanco3, peonBlanco4, peonBlanco5, peonBlanco6, peonBlanco7, peonBlanco8},
							{torreBlanca1, caballoBlanco1, alfilBlanco1, damaBlanca, reyBlanco, alfilBlanco2, caballoBlanco2, torreBlanca2}
						 };
	
	Pieza [][] arrayPiezas2 = {
			
							{torreNegra1, caballoNegro1, alfilNegro1, damaNegra, reyNegro, alfilNegro2, caballoNegro2, torreNegra2},
							{peonNegro1, peonNegro2, peonNegro3, peonNegro4, peonNegro5, peonNegro6, peonNegro7, peonNegro8},
							{null, null, null, null, null, null, null, null},
							{null, null, null, null, null, null, null, null},
							{null, null, null, null, null, null, null, null},
							{null, null, null, null, null, null, null, null},
							{torreBlanca1, peonBlanco2, peonBlanco3, peonBlanco4, peonBlanco5, peonBlanco6, peonBlanco7, peonBlanco8},
							{torreBlanca1, caballoBlanco1, alfilBlanco1, damaBlanca, reyBlanco, alfilBlanco2, caballoBlanco2, torreBlanca2}
						 };
		
		//Prueba gettes, settes y toString
		System.out.println("----------------------------------");
		System.out.println("Get y set:");
		
		try
		{
			tablero.setTablero(arrayPiezas);
			tablero2.setTablero(arrayPiezas2);
		}
		
		catch (ExceptionAjedrez error)
		{
			System.out.println("Error al crear el tablero");
		}
		
		System.out.println(tablero.getTablero());
		System.out.println("----------------------------------");
		System.out.println("toString:");
		System.out.println(tablero.toString());
		//Fin Prueba Gettes, settes y toString
		
		//Prueba clone
		System.out.println("----------------------------------");
		System.out.println("clone:");
		//tableroCopia = tablero2.cloneProfundidad(); //Preguntar clone de arrays
		
		//Fin Prueba clone
		
		//Prueba equals
		System.out.println("----------------------------------");
		System.out.println("equals:");
		System.out.println(tablero.equals (tablero2));
		System.out.println(tablero2.equals (tablero2));
		//Fin Prueba equals
		
		//Prueba hashCode
		System.out.println("----------------------------------");
		System.out.println("hashCode:");
		System.out.println(tablero2.hashCode());
		//Fin prueba hashCode
		
		//Prueba compareTo
		System.out.println("----------------------------------");
		System.out.println("compareTo:");
		System.out.println(tablero.compareTo(tablero2));
		System.out.println(tablero2.compareTo(tablero));
		System.out.println(tablero.compareTo(tablero2));
		//Fin Prueba compareTo
		
		//Prueba mostrarTablero
		System.out.println("----------------------------------");
		System.out.println("mostrarTablero:");
		tablero.mostrarTablero();
		//Fin Prueba mostrarTablero
		
		//Prueba generarTablero
		System.out.println("----------------------------------");
		System.out.println("generarTablero:");
		tablero2.generarTablero();
		tablero2.mostrarTablero();
		//Fin Prueba generarTablero
		
		//Prueba moverPieza
		System.out.println("----------------------------------");
		System.out.println("moverPieza:");
		tablero2.moverPieza(0, 0, 4, 5);
		tablero2.mostrarTablero();
		//Fin Prueba moverPieza
	}
}
