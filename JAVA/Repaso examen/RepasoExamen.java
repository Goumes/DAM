/* Nombre del programa: RepasoExamen
 * Análisis: El programa imprimirá en pantalla un menú que te dará a elegir entre tres opciones. La primera te hará imprimir un cuadrado, la segunda será del juego lolxdmafia pero se mostrará en construcción.
 * La tercera será el juego de los trileros.
 * Entradas: Opción del menu elegida, elección trile.
 * Salidas: Un cuadrado, un mensaje de en construcción o el resultado del juego
 * Restricciones: Validar todos los datos de entrada.
 * Estudio de los bucles:
 * 
 * P.G.
 * 
 * Inicio
 * LeerValidarIniciar
 * Mientras QuieraIniciar
 * 		MostrarMenuLeerValidarOpcion
 * 		segun (opcion)
 * 			caso 1: ImprimirCuadrado
 * 			caso 2: JuegoLolxdmafia
 * 			caso 3: JuegoTrileros
 * 		Fin_segun
 * 		LeerValidarReiniciar
 * Fin_Mientras
 * Fin
 * 
 * 
 * Apertura de módulos:
 * JuegoTrileros
 * 		SeleccionarTrile
 * 		MoverTrilesElegirResultado
 * 		PrintRes
 */

//Inicio
import java.util.Scanner;
import java.util.Random;
public class RepasoExamen{
	public static void main (String[]args){
		Scanner teclado = new Scanner (System.in);
		Random aleatorio = new Random();
		char iniciar = ' ';
		int opcion;
		int trile;
		int resultado;
		
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
		//MostrarMenuLeerValidarOpcion
		do
		{
			System.out.println("------------------Menu------------------");
			System.out.println("---------1. Pintar un cuadrado----------");
			System.out.println("----------2. Juego lolxdmafia-----------");
			System.out.println("--------3. Juego de los trileros--------");
			System.out.println("----------------0. Salir----------------");
			System.out.println("----------------------------------------");
			opcion = teclado.nextInt();
		}
		while (opcion < 0 || opcion > 3);
		//Fin MostrarMenuLeerValidarOpcion
		
		//segun (opcion)
		if (opcion != 0)
		{
			switch (opcion)
			{
				//caso 1: ImprimirCuadrado
				case 1:
					System.out.println("*************");
					System.out.println("*           *");
					System.out.println("*           *");
					System.out.println("*           *");
					System.out.println("*           *");
					System.out.println("*           *");
					System.out.println("*           *");
					System.out.println("*************");
				break;
				//caso 2: JuegoLolxdmafia
				case 2:
					System.out.println("[En construccion]");
				break;
				//caso 3: JuegoTrileros
				case 3:
					//SeleccionarTrile
					do
					{
						System.out.println("--------------------------------------------Elija un trile--------------------------------------------");
						System.out.println("     --------------                         --------------                        --------------");
						System.out.println("   ------------------                     ------------------                    ------------------");
						System.out.println("  ---------------------                  ---------------------                 ---------------------");
						System.out.println("-------------------------              -------------------------             -------------------------");
						System.out.println("-------------------------              -------------------------             -------------------------");
						System.out.println("-------------------------              -------------------------             -------------------------");
						System.out.println("-------------------------              -------------------------             -------------------------");
						System.out.println("-------------------------              -------------------------             -------------------------");
						System.out.println("------------1------------              -------------2-----------             --------------3----------");
						System.out.println("-------------------------              -------------------------             -------------------------");
						System.out.println("-------------------------              -------------------------             -------------------------");
						System.out.println("-------------------------              -------------------------             -------------------------");
						System.out.println("-------------------------              -------------------------             -------------------------");
						System.out.println("-------------------------              -------------------------             -------------------------");
						System.out.println("-------------------------              -------------------------             -------------------------");
						System.out.println("-------------------------              -------------------------             -------------------------");
						System.out.println("------------------------------------------------------------------------------------------------------");
						
						trile = teclado.nextInt();
					}
					while (trile < 1 || trile > 3);
					//Fin SeleccionarTrile
					
					//MoverTrilesElegirResultado
					resultado = aleatorio.nextInt (3) + 1; 
					//Fin MoverTrilesElegirResultado
					
					//PrintRes
					if (resultado == trile)
					{
						System.out.println("¡Has ganado, enhorabuena!");
					}
					else
					{
						System.out.println("El trile correcto era: "+resultado);
						System.out.println("Vaya, mas suerte la proxima vez");
					}
					//Fin PrintRes
				break;
			}//Fin_segun
		}//Fin_si
		
		//LeerValidarReiniciar
		do
		{
			System.out.println("Desea volver a ejecutar el programa? Y/N");
			iniciar = Character.toLowerCase(teclado.next().charAt(0));
		}
		while (iniciar != 'y' && iniciar != 'n');
		//Fin LeerValidarReiniciar
		
	}//Fin_Mientras
	}//Fin_main
}//Fin_pp
//Fin
