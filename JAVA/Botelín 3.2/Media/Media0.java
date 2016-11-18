/*Nombre programa: Media
 * Análisis: Hallar el menor, mayor y la media de "n" números positivos leídos de teclado.
 * Entrada: numeros
 * Salida: menor, mayor, media.
 * Restricciones: Los números deben ser positivos. No consideramos 0 como número positivo.
 * 
 * 
 * P.G.
 * 
 * Inicio
 * LeerValidariniciar
 * Mientras QuieraIniciar
	 * LeerValidarNumeros
	 * HallarMenorMayorMedia
	 * PrintRes
	 * LeerValidarReiniciar
	*Fin_Mientras
 * Fin
*/

//Inicio
import java.util.Scanner;
public class Media{
	public static void main (String[]args){
		double numero;
		double menor ='0';
		double mayor ='0';
		double media ='0';
		char iniciar =' ';
		Scanner teclado = new Scanner (System.in);

		//LeerValidarIniciar
		while (iniciar != 'y' && iniciar != 'n')
		{
		System.out.println("Desea ejecutar el programa? Y/N");
		iniciar = Character.toLowerCase(teclado.next().charAt(0));
		}
		//Fin LeerValidarIniciar
		
		//Mientras QuieraIniciar
		while (iniciar == 'y')
		{
		
			//LeerValidarNumeros
			System.out.println("Introduzca los números deseados");
			numero = teclado.nextDouble();
			while (numero <= 0)
			{
				System.out.println("El número debe ser positivo, introdúzcalo de nuevo");
			}
			//Fin LeerValidarNumeros
			
			//HallarMenorMayorMedia
			System.out.println("[EN CONSTRUCCION]");
			//Fin HallarMenorMayorMedia
			
			//PrintRes
			//Fin PrintRes
			
			//LeerValidarReiniciar
			System.out.println("Desea volver a ejecutar el programa? Y/N");
			while (iniciar != 'y' && iniciar != 'n')
			{
				System.out.println("Desea volver a ejecutar el programa? Y/N");
				iniciar = Character.toLowerCase(teclado.next().charAt(0));
			}
			//Fin LeerValidarReiniciar
			
		}//Fin_Mientras
		//Fin
		
		}//Fin_Main
	}//Fin_pp
