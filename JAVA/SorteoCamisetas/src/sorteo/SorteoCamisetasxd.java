package sorteo;

import java.util.*;
import java.io.*;
import java.lang.*;

public class SorteoCamisetasxd 
{
	public static void main (String [] args)
	{
		int numero = 0;
		Random aleatorio = new Random ();
		
		System.out.println("Eeeeeeeeey que pasa chavales bienvenidos al sorteo de la camiseta blanca de Zelda");
		System.out.println();
		System.out.println("Let's get ready to rumbleeeeeeee");
		System.out.println("---------------------------------------------------------------------------------");
		System.out.println("---------------------------------------------------------------------------------");
		System.out.println("---------------------------------------------------------------------------------");
		System.out.println("---------------------------------------------------------------------------------");
		System.out.println("---------------------------------------------------------------------------------");
		System.out.println("---------------------------------------------------------------------------------");
		System.out.println("---------------------------------------------------------------------------------");
		System.out.println("---------------------------------------------------------------------------------");
		System.out.println("---------------------------------------------------------------------------------");
		
		
		numero = aleatorio.nextInt(3) + 1;
		
		switch (numero)
		{
			case 1:
				System.out.println("La camiseta es de Gabri");
			break;
			
			case 2:
				System.out.println("La camiseta es de María");
			break;
			
			case 3:
				System.out.println("La camiseta es de Tsundere");
			break;
		}
	}
}
