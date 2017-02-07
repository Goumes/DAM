import java.util.*;
import java.io.*;
import java.math.*;

public class TestUtilArray 
{
	public static void main (String [] args)
	{
		//double operacion = 10.0/2.0;
		//int operacion2 = (int) Math.round(operacion);
		
		//System.out.println(operacion2);
		int [] array = {0,1,2,3,4,5,6,7,8,9, 10};
		
		int [] arrayPar = utilArray.arrayPar (array);
		
		System.out.println("Array original");
		System.out.println("--------------");
		
		for (int i = 0; i < array.length; i++)
		{
			System.out.println(array [i]);
		}
		
		System.out.println("--------------");
		System.out.println("Array con solo los indices pares del original");
		System.out.println("--------------");
		for (int i = 0; i < arrayPar.length; i++)
		{
			System.out.println(arrayPar [i]);
		}
	}//fin_main
}//fin_clase
