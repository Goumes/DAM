package AlgoritmosBase;

import java.util.*;

public class QuickSort 
{
	/* Propósito: Metodo rápido de ordenación ascendente para ordenar un array (lista), desde la primera casilla (primero) hasta la última (ultimo), 
	 * siendo puntoParticion la casilla por la que se divide el array.
	 * 	Caso general: Realizar si primero es menor que ultimo:
	 * 		- Cortar array por un punto.
	 * 		- Ordenar utilizando el método rápido por la mitad izquierda.
	 * 		- Ordenar utilizando el método rápido la mitad derecha.
	 * 	Caso base: Seria el "en-otro-caso" del si anterior, que no existe explicitamente, es decir, si primero es mayor o igual que ultimo no hacer nada,
	 * 	con lo que se acaban las llamadas recursivas.
	 * Entradas: Un array (lista), indice del primero y ultimo elemento.
	 * Precondiciones: el array (lista) no debe estar vacio.
	 * Salida: el mismo array (cambiado).
	 * Postcondiciones: lista [0],..., lista [n-1] esta ordenado ascendentemente.
	 * 
	 */
	
	public static void QuickSort (Integer [] array, int primero, int ultimo)
	{
		int puntoParticion = 0;
		
		if (primero < ultimo)
		{
			puntoParticion = Partir (array, primero, ultimo);
		
			QuickSort (array, primero, puntoParticion - 1);
			QuickSort (array, puntoParticion + 1, ultimo);
		
		}
	}
	//Fin_QuickSort
	
	/* Propósito: El objetivo es escoger un valor de partición, valorPartición, y reordenar el array de manera que se coloquen delante de ese valor
	 * todos los elementos del array que son menores o iguales a dicho valor de partición y detrás a todos los que son mayores. Se devolverá el
	 * punto de partición, índice, de la tabla donde ha quedado situado dicho valor de partición. Es decir, puesto que el objetivo es ordenar el array
	 * de forma ascendente, el algoritmo elige el valorParticion y rehace el array de forma que:
	 * 		- tabla [ppio], ..., tabla [puntoParticion - 1] < = valorParticion
	 * 		- tabla [puntoParticion] = valorParticion
	 * 		- tabla [puntoParticion + 1], ..., tabla [fin] > valorParticion
	 * Entradas: Un array (lista), indice de la primera y de la ultima casilla
	 * Precondiciones: el array (lista) no debe estar vacio.
	 * Salida: el mismo array (cambiado) y el punto por donde se ha partido el array.
	 * Postcondiciones: Según las especificaciones, array [ppio], ..., array [fin] quedará dividido respecto a valorParticion.
	 * 					Asociado al nombre del subprograma se devuelve el lugar por el que se divide el array. Por tanto, el subprograma se 
	 * 					diseñará como función.
	 */
	public static int Partir (Integer [] array, int ppio, int fin)
	{
		int valorParticion, i, j, aux = 0;
		
		valorParticion = array [ppio];
		
		for (i = ppio + 1, j = fin; i<j;)
		{
			for (;(array[i] <= valorParticion) && (i < j); i++);
			for (;(array[j] > valorParticion) && (i < j); j--);
			aux = array [i];
			array [i] = array [j];
			array [j] = aux;
		}
		
		if (valorParticion <= array [i])
		{
			i = i -1;
		}
		
		array [ppio] = array [i];
		array [i] = valorParticion;
		
		return i;
	}
	//Fin Partir
	
	public static void main (String [] args)
	{
		Scanner teclado = new Scanner (System.in);
		Character centinela = ' ';
		ArrayList <Integer> array = new ArrayList <Integer> ();
		
		//castear todo a integer y de vuelta a int
		
		System.out.println("Comienza la travesía de introducir números, escribe '*' cuando quieras parar. A disfrutar.");
		
		do
		{
			System.out.println("Introduce un número. Para con '*'.");
			centinela = teclado.next().charAt(0);
			
			if (centinela != '*')
			{
				array.add ((Integer)Character.getNumericValue (centinela));
			}
			
		}
		while (centinela != '*');
		
		System.out.println("-----------");
		System.out.println("Sin ordenar");
		System.out.println("-----------");
		
		for (int i = 0; i < array.size (); i++)
		{
			System.out.println(array.get(i));
		}
		
		System.out.println("-----------");
		System.out.println("Ya ordenado");
		System.out.println("-----------");
		
		Integer[] arrayInteger = array.toArray(new Integer[array.size()]);
		
		QuickSort (arrayInteger, 0, 4);
		
		for (int i = 0; i < arrayInteger.length; i++)
		{
			System.out.println(arrayInteger[i]);
		}
	}
}
