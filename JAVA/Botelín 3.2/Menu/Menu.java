/* Nombre del programa: Menu
 * Análisis: Diseñar un programa que realice los ejercicios 6, 7 y 8 según elija el usuario,
 * usar 'en construccion' para las distintas opciones. 
 * Entrada: numero menú
 * Salida: programa seleccionado
 * Restricciones: 
 * Estudio Bucle:
 * 1. Bucle: 'Iniciar' tipo centinela, condición de salida 'n'.
 * 
 * P.G.
 * Inicio
 * LeerValidarIniciar
 * Mientras QuieraIniciar
	* PrintMenu
	* LeerValidarOpcion
	* Segun (opcion)
		* Caso Opcion 1
			* PrintConstruccion
		* Caso Opcion 2
			* PrintConstruccion
		* Caso Opcion 3
			* PrintConstruccion
	* Fin Segun 
	* PrintMenu
 	* LeerValidarReiniciar
 * Fin Mientras
 * Fin
 */


//Inicio
import java.util.Scanner;
public class Menu{
	public static void main (String[]args){
		char opcion = ' ';
		char iniciar = ' ';
		Scanner teclado = new Scanner(System.in);
		
		//LeerValidarIniciar
		do
		{
		System.out.println("Desea ejecutar el programa? Y/N");
		iniciar = Character.toLowerCase(teclado.next().charAt(0));
		}
		while (iniciar != 'y' && iniciar != 'n');
		//Fin LeerValidarIniciar
		
		//Mientras QuieraIniciar
		while (iniciar == 'y')
		{
			
			//PrintMenuLeerValidarOpcion
			do
			{
			System.out.println("-----------------------------------");
			System.out.println("Seleccione un ejercicio a realizar:");
			System.out.println("1. Ejercicio 6");
			System.out.println("2. Ejercicio 7");
			System.out.println("3. Ejercicio 8");
			System.out.println("S. Salir del menu");
			System.out.println("-----------------------------------");
				opcion = Character.toLowerCase(teclado.next().charAt(0));
			}
			while (opcion != '1' && opcion != '2' && opcion != '3' && opcion != 's');
			//Fin PrintMenuLeerValidarOpcion
			
			if(opcion!='s'){
			
			//Segun (opcion)
			switch (opcion)
			{
			
				//Caso Opcion 1
				case '1': 
				
				//PrintConstruccion
				System.out.println("[EN CONSTRUCCION 1]");
				//Fin PrintConstruccion
				
				break;
				//Fin Caso Opcion 1
				
				//Caso Opcion 2
				case '2':
								
				//PrintConstruccion
				System.out.println("[EN CONSTRUCCION 1]");
				//Fin PrintConstruccion
				
				break;
				//Fin Caso Opcion 2
				
				//Caso Opcion 3
				case '3':
								
				//PrintConstruccion
				System.out.println("[EN CONSTRUCCION 1]");
				//Fin PrintConstruccion
				
				break;
				//Fin Caso Opcion 3

			}//Fin Segun 
		}
			//LeerValidarReiniciar
			do
			{
			System.out.println("Desea volver a ejecutar el programa? Y/N");
			iniciar = Character.toLowerCase(teclado.next().charAt(0));
			}
			while (iniciar != 'y' && iniciar != 'n');
			//Fin LeerValidarReiniciar
		}//Fin Mientras
		//Fin
	}//Fin_main
}//Fin_pp
 
