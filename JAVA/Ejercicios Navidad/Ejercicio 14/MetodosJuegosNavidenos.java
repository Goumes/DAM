import java.util.*;
import java.io.*;

public class MetodosJuegosNavidenos
{
	/* Prototipo: int tirarDado (char caracter)
	 * Breve comentario: Tirar un dado
	 * Precondiciones: El caracter 's' para tirar el dado
	 * Entradas: Un caracter
	 * Salidas: un entero
	 * Entradas/Salidas: ninguna
	 * Postcondiciones: el entero indica el numero que ha salido al tirar el dado. Se devuelve 0 si no se tira el dado.
	 * 
	 * Resguardo:public static int tirarDado (char caracter)
		{
			System.out.println("Llamada al subprograma tirarDado");
			System.out.println("Variables: "+caracter);
			return (-1);
		}
	 */
	public static int tirarDado (char caracter)
	{
		Random aleatorio = new Random ();
		int resultado = 0;
		
		if (caracter == 's')
		{
			resultado = aleatorio.nextInt(6) + 1;
			
			switch (resultado)
			{
				case 1:
					System.out.println("---------------------------------");
					System.out.println("          ***********");
					System.out.println("          *         *");
					System.out.println("          *         *");
					System.out.println("          *    *    *");
					System.out.println("          *         *");
					System.out.println("          *         *");
					System.out.println("          ***********");
					System.out.println("---------------------------------");
				break;
				case 2:
					System.out.println("---------------------------------");
					System.out.println("          ***********");
					System.out.println("          * *       *");
					System.out.println("          *         *");
					System.out.println("          *         *");
					System.out.println("          *         *");
					System.out.println("          *       * *");
					System.out.println("          ***********");
					System.out.println("---------------------------------");
					break;
				case 3:
					System.out.println("---------------------------------");
					System.out.println("          ***********");
					System.out.println("          * *       *");
					System.out.println("          *         *");
					System.out.println("          *    *    *");
					System.out.println("          *         *");
					System.out.println("          *       * *");
					System.out.println("          ***********");
					System.out.println("---------------------------------");
					break;
				case 4:
					System.out.println("---------------------------------");
					System.out.println("          ***********");
					System.out.println("          * *     * *");
					System.out.println("          *         *");
					System.out.println("          *         *");
					System.out.println("          *         *");
					System.out.println("          * *     * *");
					System.out.println("          ***********");
					System.out.println("---------------------------------");
					break;
				case 5:
					System.out.println("---------------------------------");
					System.out.println("          ***********");
					System.out.println("          * *     * *");
					System.out.println("          *         *");
					System.out.println("          *    *    *");
					System.out.println("          *         *");
					System.out.println("          * *     * *");
					System.out.println("          ***********");
					System.out.println("---------------------------------");
					break;
				
				case 6:
					System.out.println("---------------------------------");
					System.out.println("          ***********");
					System.out.println("          * *     * *");
					System.out.println("          *         *");
					System.out.println("          * *     * *");
					System.out.println("          *         *");
					System.out.println("          * *     * *");
					System.out.println("          ***********");
					System.out.println("---------------------------------");
					break;
			}
		}
		return (resultado);
	}
	//fin subprograma tirarDado
}//fin_pp
