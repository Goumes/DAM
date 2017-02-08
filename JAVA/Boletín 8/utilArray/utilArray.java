import java.util.*;
import java.io.*;

public class utilArray
{
	/* Prototipo: int [] arrayPar (int [] array)
	 * Breve comentario: Dado un array cargado aleatoriamente, generar a partir de Ã©l otro
	 * array que contenga los elementos pares que se encuentran en el primero.
	 * Precondiciones: Ninguna
	 * Entradas: Un array de enteros
	 * Salidas: Un array de enteros
	 * Entradas/Salidas: Ninguna
	 * Postcondiciones: Un array de enteros con los numeros pares del primero.
	 * 
	 * Resguardo: public static int [] arrayPar (int [] array)
		{
			System.out.println("Llamada al metodo arrayPar");
			System.out.println("Variables: "+array);
			return array;
		}
	 */
	public static int [] arrayPar (int [] array)
	{
		int arraySize = (int) Math.round((double) array.length / 2.0); //Dividir el tamaño del array original entre dos para crear el nuevo. Hay que redondearlo para evitar fallos de tamaño en el array. Math.round devuelve un double.
		
		int [] resultado = new int [arraySize]; //Crear nuevo array con el tamaño antes obtenido
		//int j = 0;
		
		for (int i = 0, j = 0; i < array.length; i = i+2, j++)
		{
				resultado [j] = array [i];
				//j++;
		}
		return resultado;
	}
	
}//fin_clase
