import java.util.*;
import java.io.*;
public class PruebaArray
{
	public static void main (String [] args) throws IOException
	{
		InputStreamReader pepejava = new InputStreamReader (System.in);
		BufferedReader tecladoString = new BufferedReader (pepejava);
		Scanner teclado = new Scanner (System.in);
		
		////Array con longitud definida pero sin datos
		//int [] arrayNumeros1 = new int [20];
		
		////Array con longitud definida y con 4 datos
		//int [] arrayNumeros2 = {1,2,3,4};
		
		////Imprimir datos del arrayNumeros2 en base a la posición [i] del mismo
		//for (int i = 0; i < arrayNumeros2.length;i++)
		//{
			//System.out.println(arrayNumeros2 [i]);
		//}
		
		////Imprimir datos del arrayNumeros2 en base a la posición [2] del mismo
		//for (int i = 0; i < arrayNumeros2.length;i++)
		//{
			//System.out.println(arrayNumeros2 [2]);
		//}
		
		////Insertar datos en arrayNumeros1
		//for (int i = 0; i < arrayNumeros1.length;i++)
		//{
			//System.out.println("Introduzca el numero deseado");
			//arrayNumeros1 [i] = teclado.nextInt ();
		//}
		
		////Imprimir dichos datos de inicio a fin
		//for (int i = 0; i < arrayNumeros1.length; i++)
		//{
			//System.out.println(arrayNumeros1 [i]);
		//}
		
		String [] arrayPacman = new String [11];
		
		//Insertar datos en arrayPacman
		for (int i = 0; i < arrayPacman.length;i++)
		{
			System.out.println("Crea tu arte. (Maximo 11 lineas)");
			arrayPacman [i] = tecladoString.readLine ();
		}
		
		//Imprimir dichos datos de inicio a fin
		for (int i = 0; i < arrayPacman.length; i++)
		{
			System.out.println(arrayPacman [i]);
		}
		
		
	}//fin_main
}//fin_clase
