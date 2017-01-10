/* Nombre del programa: JuegosNavidenos
 * Análisis: Programa que presentará un menú donde se pueda elegir jugar al chicago, al barbudi o a los chinos.
 * El proceso completo podrá ejecutarse más de una vez.
 * Cada opción podrá repetirse mientras lo desee el usuario.
 * Se deben validar todas las entradas posibles.
 * Los subprogramas que se diseñen responderán de los casos de error si los hubiera.
 * Entradas: opciones menu, opcion iniciar
 * Salidas:
 * 
 * P.G.
 * Inicio
 * 	LeerValidarIniciar
 * 	Mientras QuieraIniciar
 * 		PrintMenuLeerValidarOpcion
 * 		si (opcion no es 0)
 * 			segun (opcion)
 * 				caso 1: Chicago
 * 				caso 2: Barbudi
 * 				caso 3: Chinos
 * 			fin_segun
 * 		fin_si
 * 		LeerValidarReiniciar
 * 	fin_mientras
 * Fin
 * 
 * P.G. nivel 1
 * 
 * Caso1: Chicago
 * 
 * Inicio
 * 	TirarDados*
 * 	SeleccionarGanador*
 * 	LeerValidarApuesta
 * 	JugarChicago*
 * Fin
 */
 
//Inicio
import java.util.*;
import java.io.*;

public class JuegosNavidenos
{
	public static void main (String[]args)
	{
		char iniciar = ' ';
		int opcion = 0;
		char tirarDados = ' ';
		int dadoInicial = 0;
		int dadoInicialCPU = 0;
		
		Scanner teclado = new Scanner (System.in);
		
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
			//PrintMenuLeerValidarOpcion
			do
			{
				System.out.println("-----------------Menu-----------------");
				System.out.println("----------1. Juego 'Chicago'----------");
				System.out.println("----------2. Juego 'Barbudi'----------");
				System.out.println("----------3. Juego 'Chinos'-----------");
				System.out.println("----------0. Salir del menu-----------");
				System.out.println("--------------------------------------");
				opcion = teclado.nextInt();
			}
			while (opcion < 0 || opcion > 3);
			//Fin PrintMenuLeerValidarOpcion
			
			if (opcion != 0)
			{
				switch (opcion)
				{
				
					//caso 1: Chicago
					case 1:
					
					//TirarDados
					do
					{
						System.out.println("Desea tirar los dados para ver quien empieza? S/N");
						tirarDados = Character.toLowerCase (teclado.next().charAt(0));
					}
					while (tirarDados != 's' && tirarDados != 'n');

					dadoInicial = MetodosJuegosNavidenos.tirarDado (tirarDados);
					System.out.println("Has sacado un: "+dadoInicial);
					dadoInicialCPU = MetodosJuegosNavidenos.tirarDado (tirarDados);
					System.out.println("La CPU ha sacado un: "+dadoInicialCPU);
					//Fin TirarDados
					
					//SeleccionarGanador
					
					//Fin SeleccionarGanador
					
					//LeerValidarApuesta
					//Fin LeerValidarApuesta
					
					//JugarChicago
					//Fin JugarChicago
					
					break;
					
					//caso 2: Barbudi
					case 2:
					System.out.println("[EN CONSTRUCCION]");
					break;
					
					//caso 3: Chinos
					case 3:
					System.out.println("[EN CONSTRUCCION]");
					break;
				
				}//fin_segun
			
			}//fin_si
			
			//LeerValidarReiniciar
			do
			{
				System.out.println("Desea volver a ejecutar el programa? Y/N");
				iniciar = Character.toLowerCase (teclado.next().charAt(0));
			}
			while (iniciar != 'y' && iniciar != 'n');
			//Fin LeerValidarReiniciar
			
		}//fin_mientras
	}//fin_main
}//fin_pp
//Fin
