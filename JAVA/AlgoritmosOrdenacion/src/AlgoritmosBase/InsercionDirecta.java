package AlgoritmosBase;

public class InsercionDirecta 
{
	
	/* Propósito: ordenación ascendente de un array unidimensional de tamaño tam.

	 * Entradas: un array. En principio también se necesita el tamaño, pero al

	 * implementar en Java lo conocemos, por estar implícito al crearlo.

	 * Precondiciones: el array no debe estar vacío.

	 * Salida: el mismo array modificado.

	 * Postcondiciones: array [0], ..., array[tam-1] está ordenado según el criterio de ordenación establecido.
	 * 
	 */
	public static int [] insercionDirectaInt (int [] array)
	{
		int aux = 0;
		
		for (int i = 1; i < array.length; i++)
		{
			for (int j = i; j > 0 && array [j-1] > array [j]; j--)
			{
				aux = array [j];
				array[j] = array [j-1];
				array [j-1] = aux;
			}
		}
		
		return array;
	}
	
	public static void main (String [] args)
	{
		int [] array = {35, 23, 11, 5, 13};
		
		System.out.println("-----------");
		System.out.println("Sin ordenar");
		System.out.println("-----------");
		
		for (int i = 0; i < array.length; i++)
		{
			System.out.println(array [i]);
		}
		
		System.out.println("-----------");
		System.out.println("Ya ordenado");
		System.out.println("-----------");
		
		insercionDirectaInt (array);
		
		for (int i = 0; i < array.length; i++)
		{
			System.out.println(array [i]);
		}
	}
}
