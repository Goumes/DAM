package utilidades;
import java.util.*;
import java.io.*;
import java.math.*;

public class TestUtilArray 
{
	public static void main (String [] args)
	{
		//arrayPar
			
			//double operacion = 10.0/2.0;
			//int operacion2 = (int) Math.round(operacion);
			
			//System.out.println(operacion2);
			int [] array1 = {0,1,2,3,4,5,6,7,8,9, 10};
			
			int [] arrayPar = utilArray.arrayPar (array1);
			
			System.out.println("Array original");
			System.out.println("----------------------------------");
			
			for (int i = 0; i < array1.length; i++)
			{
				System.out.println(array1 [i]);
			}
			
			System.out.println("----------------------------------");
			System.out.println("Array con solo los indices pares del original");
			System.out.println("----------------------------------");
			for (int i = 0; i < arrayPar.length; i++)
			{
				System.out.println(arrayPar [i]);
			}
		//Fin arrayPar
		
		//arrayAleatorio
		

			System.out.println("----------------------------------");
			System.out.println("Array de 20 enteros aleatorios entre 100 y 300 sin repetirse");
			System.out.println("----------------------------------");
			
			
			int [] array2 = utilArray.arrayAleatorio ();
			
			for (int i = 0; i < array2.length; i++)
			{
				System.out.println(array2 [i]);
			}
			
		//Fin arrayAleatorio
		
		//alrrayVes
		
			System.out.println("----------------------------------");
			System.out.println("Array con los elementos al reves del introducido");
			System.out.println("----------------------------------");
		
			int [] array3 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
			
			int [] alreves = utilArray.alrrayVes (array3);
		
			for (int i = 0; i < alreves.length; i++)
			{
				System.out.println(alreves [i]);
			}
			
		//Fin alrrayVes
		
		//imprimirArray
			
			System.out.println("----------------------------------");
			System.out.println("Funcionalidad que imprime un array");
			System.out.println("----------------------------------");
		
			
			Integer [] arrayInteger = {0, 1, 2, 3, 4, 5};
			utilArray.imprimirArray (arrayInteger);
			
		//Fin imprimirArray
			
		//dondeEstaWaldo
			
			System.out.println("----------------------------------");
			System.out.println("Funcionalidad 'dondeEstaWaldo'");
			System.out.println("----------------------------------");
			
			int resultadoWaldo = 0;
			
			resultadoWaldo = utilArray.dondeEstaWaldo(array3, 4);
			
			
			System.out.println(resultadoWaldo);
			
		//Fin dondeEstaWaldo
		
		//sonIguales
			
			System.out.println("----------------------------------");
			System.out.println("Funcionalidad 'sonIguales'");
			System.out.println("----------------------------------");
			
			boolean resultadoIguales = false;
			
			Integer [] arrayIguales = {1, 2, 2, 4};
			
			resultadoIguales = utilArray.sonIguales(arrayIguales);
			
			System.out.println(resultadoIguales);
			
		//Fin sonIguales
		
			
	}//fin_main
}//fin_clase
