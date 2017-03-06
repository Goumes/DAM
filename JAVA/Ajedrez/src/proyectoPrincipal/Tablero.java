package proyectoPrincipal;

import java.util.Objects;

/* Propiedades.
 * 		Básicas:		Pieza [][] tablero			----------			Consultable / Modificable
 * 		Derivadas:
 * 		Compartidas:
 * 
 * Restricciones: El tablero debe ser siempre de 8 x 8
 * 
 * Criterio de comparación: Tamaño del array tablero.
 * Criterio de igualdad: Tamaño del array tablero.
 * 
 * Metodos añadidos: generarTablero, mostrarTablero, moverPieza
 * 
 */

public class Tablero implements Cloneable, Comparable <Tablero>
{
	private Pieza [][] tablero;
	
	//Constructores
	public Tablero ()
	{
		tablero = null;
	}
	
	public Tablero (Tablero copia)
	{
		this.tablero = copia.tablero;
	}
	
	public Tablero (Pieza [][] tablero) throws ExceptionAjedrez
	{
		if ((tablero.length == 8) && (tablero [0].length == 8))
		{
			this.tablero = tablero;
		}
		else
		{
			throw new ExceptionAjedrez ("Error, el tablero debe ser de 8 x 8");
		}
	}
	//Fin Constructores
	
	//Getters y setters
	public Pieza [][] getTablero ()
	{
		return tablero;
	}
	
	public void setTablero (Pieza [][] tablero) throws ExceptionAjedrez
	{
		if ((tablero.length == 8) && (tablero [0].length == 8))
		{
			this.tablero = tablero;
		}
		else
		{
			throw new ExceptionAjedrez ("Error, el tablero debe ser de 8 x 8");
		}
	}
	//Fin Getters y setters
	
	//Metodos añadidos
	@Override
	public boolean equals (Object objeto)
	{
		boolean resultado = false;
		
		if (objeto != null && objeto instanceof Tablero)
		{
			Tablero tablero = (Tablero) objeto;
			
			if (this.getTablero ().length == tablero.getTablero ().length
				&& this.getTablero ()[0].length == tablero.getTablero ()[0].length)
			{
				resultado = true;
			}
		}
		
		return resultado;
	}
	
	@Override
	public String toString ()
	{
		String s = this.getTablero()+"";
		return s;
	}
	
	@Override
	public int hashCode ()
	{
		return (Objects.hash(this.getTablero()));
	}
	
	@Override
	public Tablero clone ()
	{
		Tablero copia = null;
		
		try
		{
			copia = (Tablero) super.clone ();
		}
		
		catch (CloneNotSupportedException error)
		{
			System.out.println("No se ha podido clonar el objeto");
		}
		
		return copia;
	}
	
	public Tablero cloneProfundidad () //Preguntar esto
	{
		Tablero copia = null;
		
		try
		{
			copia = (Tablero) super.clone ();
			copia.tablero = this.tablero;
		}
		
		catch (CloneNotSupportedException error)
		{
			System.out.println("No se ha podido clonar el objeto");
		}
		
		return copia;
	}
	
	@Override
	public int compareTo (Tablero tablero)
	{
		int resultado = 0;
		
		if (this.getTablero().length > tablero.getTablero().length
			&& this.getTablero()[0].length > tablero.getTablero()[0].length)
		{
			resultado = 1;
		}
		
		else if (this.getTablero().length < tablero.getTablero().length
				&& this.getTablero()[0].length < tablero.getTablero()[0].length)
		{
			resultado = -1;
		}
		
		return resultado;
	}
	
	/* Prototipo: Tablero generarTablero ()
	 * Breve comentario: Funcionalidad que crea un array de Piezas para hacer un tablero inicial.
	 * Precondiciones: Ninguna
	 * Entradas: Ninguna
	 * Salidas: Tablero
	 * Entradas/Salidas: Ninguna
	 * Postcondiciones: Un objeto Tablero rellenado en forma de un tablero de ajedrez.
	 * 
	 * Resguardo: public static Pieza [][] generarTablero ()
		{
			System.out.println("Llamada al metodo generarTablero");
			return tablero;
		}
	 */
	public Tablero generarTablero () throws ExceptionAjedrez
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
								
								{torreNegra1, caballoNegro1, alfilNegro1, damaNegra, reyNegro, alfilNegro2, caballoNegro2, torreNegra2},
								{peonNegro1, peonNegro2, peonNegro3, peonNegro4, peonNegro5, peonNegro6, peonNegro7, peonNegro8},
								{null, null, null, null, null, null, null, null},
								{null, null, null, null, null, null, null, null},
								{null, null, null, null, null, null, null, null},
								{null, null, null, null, null, null, null, null},
								{peonBlanco1, peonBlanco2, peonBlanco3, peonBlanco4, peonBlanco5, peonBlanco6, peonBlanco7, peonBlanco8},
								{torreBlanca1, caballoBlanco1, alfilBlanco1, damaBlanca, reyBlanco, alfilBlanco2, caballoBlanco2, torreBlanca2}
							 };
		
		this.setTablero(tablero);
		
		return this;
	}
	//Fin generarTablero
	
	/* Prototipo: void mostrarTablero ()
	 * Breve comentario: Funcionalidad que muestra el tablero en pantalla
	 * Precondiciones: Ninguna
	 * Entradas: Ninguna
	 * Salidas: Ninguna
	 * Entradas/Salidas: Ninguna
	 * Postcondiciones: Ninguna
	 * 
	 * Resguardo: public void mostrarTablero ()
		{
			System.out.println("Llamada al metodo mostrarTablero");
		}
	 */
	public void mostrarTablero ()
	{
		for (int i = 0; i < this.tablero.length; i++)
		{
			System.out.println("  --------- --------- --------- --------- --------- --------- --------- ---------");
			System.out.println(" |         |         |         |         |         |         |         |         |");
			for (int j = 0; j < this.tablero[0].length; j++)
			{
				
 				if (this.tablero[i][j] != null)
				{
 					if (this.tablero[i][j].getColor () == false)
 					{
		 				if (this.tablero[i][j].getTipo().equals("Torre") == true || this.tablero[i][j].getTipo ().equals("Alfil") == true)
		 				{
		 					System.out.print(" | *" + this.tablero[i][j].getTipo() + " ");
		 				}
						
		 				else if (this.tablero[i][j].getTipo().equals("Rey") == true)
		 				{
		 					System.out.print(" |  *" + this.tablero[i][j].getTipo() + "  ");
		 				}
		 				
		 				else if (this.tablero[i][j].getTipo().equals("Dama") == true || this.tablero[i][j].getTipo ().equals("Peon") == true)
		 				{
		 					System.out.print(" |  *" + this.tablero[i][j].getTipo() + " ");
		 				}
		 				
		 				else if (this.tablero[i][j].getTipo().equals("Caballo") == true)
		 				{
		 					System.out.print(" |*" + this.tablero[i][j].getTipo());
		 					
		 				}
 					}
 					else
 					{
 						if (this.tablero[i][j].getTipo().equals("Torre") == true || this.tablero[i][j].getTipo ().equals("Alfil") == true)
		 				{
		 					System.out.print(" |  " + this.tablero[i][j].getTipo() + " ");
		 				}
						
		 				else if (this.tablero[i][j].getTipo().equals("Rey") == true)
		 				{
		 					System.out.print(" |   " + this.tablero[i][j].getTipo() + "  ");
		 				}
		 				
		 				else if (this.tablero[i][j].getTipo().equals("Dama") == true || this.tablero[i][j].getTipo ().equals("Peon") == true)
		 				{
		 					System.out.print(" |   " + this.tablero[i][j].getTipo() + " ");
		 				}
		 				
		 				else if (this.tablero[i][j].getTipo().equals("Caballo") == true)
		 				{
		 					System.out.print(" | " + this.tablero[i][j].getTipo());
		 					
		 				}
 					}
				}
				else
				{
					System.out.print(" |        ");
				}
			}
			
			System.out.print(" |  "+  (8 - i)); 
			System.out.println("");
			System.out.println(" |         |         |         |         |         |         |         |         |");
				
			if (i == (this.tablero.length - 1))
			{
				System.out.println("  --------- --------- --------- --------- --------- --------- --------- ---------");
				System.out.println("      A         B         C         D         E         F         G         H    ");
				System.out.println();
			}
			
		}
	}
	//Fin mostrarTablero
	
	/* Prototipo: Tablero moverPieza (int Fila1, int Columna1, int Fila2, int Columna2)
	 * Breve comentario: Mueve una pieza de una posición a otra.
	 * Precondiciones: La primera fila y columna son la posición original.
	 * Entradas: Cuatro enteros
	 * Salidas: Un tablero
	 * Entradas/Salidas: Ninguna
	 * Postcondiciones: El tablero con las piezas movidas.
	 * 
	 * Resguardo: public Tablero moverPieza (int Fila1, int Columna1, int Fila2, int Columna2)
		{
			System.out.println("Llamada al metodo moverPieza");
			
			return this;
		}
	 */
	public Tablero moverPieza (int Fila1, int Columna1, int Fila2, int Columna2)
	{
		
			this.tablero [Fila2][Columna2] = this.tablero [Fila1][Columna1];
			this.tablero [Fila1][Columna1] = null;
		
		return this;
	}
	//Fin moverPieza
	
	//Fin Metodos añadidos
}