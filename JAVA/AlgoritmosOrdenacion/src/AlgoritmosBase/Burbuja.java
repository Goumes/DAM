package AlgoritmosBase;

public class Burbuja 
{
	/* Propósito: ordenación ascendente de un array unidimensional de tamaño tam.

	 * Entradas: un array. En principio también se necesita el tamaño, pero al

	 * implementar en Java lo conocemos, por estar implícito al crearlo.

	 * Precondiciones: el array no debe estar vacío.

	 * Salida: el mismo array modificado.

	 * Postcondiciones: array [0], ..., array[tam-1] está ordenado según el criterio de ordenación establecido.
	 * 
	 */
	public static int [] bubbleSortInt (int [] array)
	{
		int aux = 0;
		
		for (int i = 0; i < array.length; i++)
		{
			for (int j = array.length - 1; j > 0; j--)
			{
				if (array[j] < array [j - 1])
				{
					aux = array [j];
					array [j] = array [j - 1];
					array [j - 1] = aux;
				}
			}
			
		}
		return array;
	}
	
	public static void main (String [] args)
	{
		int [] array = {4, 7, 5, 98, 2, -1, 12, 65, 2354, 564, 243, 76, 123, 66};
		
		System.out.println("-----------");
		System.out.println("Sin ordenar");
		System.out.println("-----------");
		
		for (int i = 0; i < array.length; i++)
		{
			System.out.println(array [i]);
		}
		
		array = bubbleSortInt (array);
		
		System.out.println("-----------");
		System.out.println("Ya ordenado");
		System.out.println("-----------");
		
		for (int i = 0; i < array.length; i++)
		{
			System.out.println(array [i]);
		}
	}
}
