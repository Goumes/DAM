/* AnnoBisiesto
 * Análisis: Diseñar un programa que compruebe si es un año es o no bisiesto usando la siguiente regla: 
 * "Un año es bisiesto si es divisible por 400, o bien es divisible por 4 pero no por 100" y una variable booleana. Verdadero = Bisiesto  Falso = No bisiesto
 * Entradas: year
 * Salidas: year_bisiesto
 * Restricciones: Un año no puede tener más de 365 días si es normal, o 366 si es bisiesto.
 * 
 * P.G
 * 
 * Inicio
 * 	IniciarBucle
 * 	MientrasQuieraIniciar
 * 		LeerAño
 * 		CalcularAñoBisiesto
 *	 	PrintRes
 * 		ActualizarBucle
 * 	Fin_mientras
 * Fin
 * 
*/


import java.util.Scanner;
public class AnnoBisiesto{
	public static void main(String[] args){
		int year;
		boolean year_bisiesto = false;
		char iniciar = ' ';
		Scanner teclado = new Scanner (System.in);
		
		//IniciarBucle
		System.out.println("Desea iniciar el programa? Y/N");
		iniciar = Character.toLowerCase(teclado.next().charAt(0));
		//Fin IniciarBucle
		
		//MientrasQuieraIniciar
		while (iniciar == 'y')
		{
		//MientrasQuieraIniciar
		
		//LeerAño
		System.out.println ("Introduzca un a\u00f1o.");
		year = teclado.nextInt();
		//Fin LeerAño
		
		//CalcularAñoBisiestoPrintRes
		if ((year % 400) == 0)
		{
			year_bisiesto = true;
			System.out.println("A\u00f1o bisiesto= "+year_bisiesto);
		}
		else
		{
			if ((year % 4) == 0 && (year % 100) != 0 )
			{
				year_bisiesto = true;
			}
			else
			{
				year_bisiesto = false;
			}
		}
		//Fin CalcularAñoBisiesto
		
		//PrintRes
		System.out.println("A\u00f1o bisiesto= "+year_bisiesto);
		//Fin PrintRes
		
		//ActualizarBucle
		System.out.println("Desea iniciar el programa? Y/N");
		iniciar = Character.toLowerCase(teclado.next().charAt(0));
		//ActualizarBucle
		
		}//Fin_mientras
	}//fin_main
}//fin_pp
