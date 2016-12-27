/* Nombre del programa: ModificacionesNumeros
 * Análisis: Un programa que se presentará un menú que nos permita sumar dígitos o bien devolverlo invertido.
 * Entradas: Opcion menu, Opcion ejecutar
 * Salidas: mensajes
 * Restricciones: ninguna
 * 
 * 
 * P.G 
 * 
 * Inicio
 * 	LeerValidarIniciar
 * 	Mientras QuieraIniciar
 * 		LeerValidarOpcionPrintMenu
 * 		segun (opcion)
 * 			Caso 1: SumarDigitos
 * 			Caso 2: InvertirNumero
 * 		fin_segun 
 * 		LeerValidarReiniciar
 * 	fin_mientras
 * Fin
 * 
 * 
 * SumarDigitos:
 * 
 * Inicio
 * 	LeerNumero
 * 	SumarDigitos*
 * 	PrintRes
 * Fin
 * 
 * InvertirNumero:
 * 
 * Inicio
 * 	LeerNumero
 * 	InvertirNumero*
 * 	PrintRes
 * Fin
 */
 
 
//Inicio
import java.util.Scanner;

public class ModificacionesNumeros 
{
	public static void main (String[]args)
	{
		Scanner teclado = new Scanner (System.in);
		char iniciar = ' ';
		int opcion;
		int numeroSuma;
		int numeroInvertir;
		int resultadoSuma;
		int resultadoInvertir;
		
		//LeerValidarIniciar
		do
		{
			System.out.println("Desea ejecutar el programa? Y/N");
			iniciar = Character.toLowerCase (teclado.next().charAt(0));
		}
		while (iniciar != 'y' && iniciar != 'n');
		//Fin LeerValidarIniciar
		
		while (iniciar == 'y')
		{
			//LeerValidarOpcionPrintMenu
			do
			{
				System.out.println("-----------------Menu-----------------");
				System.out.println("-----1. Sumar digitos de un numero----");
				System.out.println("-2. Invertir los digitos de un numero-");
				System.out.println("-----------0. Salir del menu----------");
				System.out.println("--------------------------------------");
				opcion = teclado.nextInt();
			}
			while (opcion < 0 || opcion > 2);
			//Fin LeerValidarOpcionPrintMenu
			
			switch (opcion)
			{
				case 1:
				
				//LeerNumero
				System.out.println("Introduzca el numero deseado");
				numeroSuma = teclado.nextInt();
				//Fin LeerNumero
				
				//SumarDigitos
				resultadoSuma = MetodosModificacionesNumeros.sumarDigitos (numeroSuma);
				//Fin SumarDigitos
				
				//PrintRes
				System.out.println("La suma de los digitos de este numero es: "+resultadoSuma);
				//Fin PrintRes
				
				break;
				
				case 2:
				//LeerNumero
				System.out.println("Introduzca el numero deseado");
				numeroInvertir = teclado.nextInt();
				//Fin LeerNumero
				
				//InvertirNumero
				resultadoInvertir = MetodosModificacionesNumeros.invertirDigitos (numeroInvertir);
				//Fin InvertirNumero
				
				//PrintRes
				System.out.println("El numero invertido es: "+resultadoInvertir);
				//Fin PrintRes
				break;
			}
			
			//LeerValidarIniciar
			do
			{
				System.out.println("Desea volver a ejecutar el programa? Y/N");
				iniciar = Character.toLowerCase (teclado.next().charAt(0));
			}
			while (iniciar != 'y' && iniciar != 'n');
		//Fin LeerValidarIniciar
			
		}//fin_mientras
	}//fin_main
}//fin_pp
