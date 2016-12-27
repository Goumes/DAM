/* Nombre del programa: Boletín6
 * Análisis: programa que recoja todos los ejercicios del boletín 6
 * Entradas: Opciones
 * Salidas: Mensajes
 * Restricciones: ninguna
 * 
 * Inicio
 * LeerValidarIniciar
 * Mientras QuieraIniciar
 * 		PrintMenuLeerValidarOpcion
 * 		si (opcion != 0)
 * 			segun (opcion)
 * 				case 1: sumaAcumulada
 * 				case 2: Ejercicio 2
 * 				case 3: Ejercicio 3
 * 				case 4: Ejercicio 4
 * 			fin_segun
 * 		fin_si
 * 		LeerValidarReiniciar
 * Fin_mientras
 * Fin
 * 
 * 
 * sumaAcumulada:
 * Inicio
 * 	LeerValidarNumero
 * 	Calcular sumaAcumulada *
 * 	PrintRes
 * Fin
 */


//Inicio
import java.util.Scanner;
public class Boletin6
{
	public static void main (String[]args)
	{
		char iniciar = ' ';
		int opcion;
		int numeroAcumulado;
		int resultadoSumaAcumulada;
		Scanner teclado = new Scanner (System.in);
		
		//LeerValidarIniciar
		do
		{
		System.out.println("Desea ejecutar el programa? Y/N");
		iniciar = Character.toLowerCase(teclado.next().charAt(0));
		}
		while (iniciar != 'y' && iniciar != 'n');
		//Fin LeerValidarIniciar
		
		while (iniciar == 'y')
		{
			//PrintMenuLeerValidarOpcion
			do
			{
				System.out.println("-----------------------Menu-----------------------");
				System.out.println("----------1. Suma acumulada de un numero----------");
				System.out.println("---------------2. [EN CONSTRUCCION]---------------");
				System.out.println("---------------3. [EN CONSTRUCCION]---------------");
				System.out.println("---------------4. [EN CONSTRUCCION]---------------");
				System.out.println("-----------------0. Salir del menu----------------");
				opcion = teclado.nextInt();
			}
			while (opcion < 0 || opcion > 4);
			//Fin PrintMenuLeerValidarOpcion
			
			if (opcion != 0)
			{
				switch (opcion)
				{
					case 1:
					
					//LeerValidarNumero
					do
					{
					System.out.println("Introduzca el numero deseado");
					numeroAcumulado = teclado.nextInt();
						if (numeroAcumulado < 0)
						{
							System.out.println("Introduzca un numero positivo");
							numeroAcumulado = teclado.nextInt();
						}
					}
					while(numeroAcumulado < 0);
					//Fin LeerValidarNumero
					
					//Calcular sumaAcumulada
					resultadoSumaAcumulada = MetodosBoletin6.sumaAcumulada (numeroAcumulado);
					//Fin Calcular sumaAcumulada
					
					//PrintRes
					System.out.println("La suma acumulada es: "+resultadoSumaAcumulada);
					//Fin PrintRes
					
					break;
					
					case 2:
					System.out.println("[EN CONSTRUCCION]");
					break;
					
					case 3:
					System.out.println("[EN CONSTRUCCION]");
					break;
					
					case 4:
					System.out.println("[EN CONSTRUCCION]");
					break;
					
				}//fin_segun
			}//fin_if	
			
			//LeerValidarReiniciar
			do
			{
			System.out.println("Desea volver a ejecutar el programa? Y/N");
			iniciar = Character.toLowerCase(teclado.next().charAt(0));
			}
			while (iniciar != 'y' && iniciar != 'n');
			//Fin LeerValidarReiniciar
		}//fin_while
	}//fin_main
}//fin_pp
//Fin
