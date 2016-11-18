/* Nombre del programa: Domino2
 * Análisis: El juego del dominó consta de 28 fichas. Sacamos una al azar y anotamos la suma de las puntuaciones. 
 * Analiza cuántas veces sale cada uno de los 13 casos que pueden darse (0, 1, 2, 3, 4, 5, 6, 7, 8, 9,10, 11, 12). 
 * Entradas:
 * Salidas: Ficha dominó y número de casos
 * Restricciones:
 * Estudio de los bucles:
 * Bucle 1. 'Iniciar' de tipo sucesos controlado por centinela, con condición de salida != 'y'. Se inicializa por lectura anticipada
 * 			 y se actualiza por lectura final.
 * Bucles 2 y 3. De tipo sucesos controlados por centinela. Se inicializan por lectura anticipada y se actualiza por lectura final.
	* Bucle 2. 'LeerValidariniciar' con condición de salida != 'y' && != 'n'.
	* Bucle 3. 'LeerValidarReiniciar' con condición de saldia != 'y' && != 'n'.
 * 
 * 
 * P.G.
 * 
 * Inicio
 *  LeerValidarIniciar
 * 	Mientras QuieraIniciar
 * 		PrintMenuLeerValidarOpcion
 * 		Segun (opcion)
 * 			1. Ficha Automática
 * 			2. Ficha Manual
 * 		Fin_segun
 * 		PrintRes
 * 		LeerValidarReiniciar
 * 	Fin_Mientras
 * Fin
 * 
 * 
 * Módulo GenerarSumarFicha:
 * 
 * GenerarSumarFicha
 * 		LeerValidarSiGenerar
 * 		Mientras QuieraGenerar
 * 			GenerarFicha
 * 			SumarContarFicha
 * 			LeerValidarVolverGenerar
 * 		Fin_mientras2
 */
 
//Inicio
import java.util.Scanner;
import java.util.Random;
public class Domino2{
	public static void main (String[]args){
		Scanner teclado = new Scanner (System.in);
		Random aleatorio = new Random ();
		char iniciar = ' ';
		char generar = ' ';
		int ficha1;
		int ficha2;
		int suma;
		int opcion;
		int numero;
		
		//LeerValidarIniciar
		do
		{
		System.out.println("Desea ejecutar el programa? Y/N");
		iniciar = Character.toLowerCase(teclado.next().charAt(0));
		}
		while (iniciar != 'y' && iniciar != 'n');
		//Fin LeerValidarIniciar
		
		//Mientras QuieraIniciar (Bucle 1.)
		while (iniciar == 'y')
		{
			
			//PrintMenuLeerValidarOpcion
			do
			{
				System.out.println("--------Menu:--------");
				System.out.println("---Elija una opcion--");
				System.out.println("-1. Ficha automatica-");
				System.out.println("---2. Ficha Manual---");
				System.out.println("--0. Salir del menu--");
				System.out.println("---------------------");
				opcion = teclado.nextInt();
			}
			while(opcion < 0 || opcion > 2);
			//PrintMenuLeerValidarOpcion
			
			if (opcion != 0)
			{
					int contador1 = 0;
					int contador2 = 0;
					int contador3 = 0;
					int contador4 = 0;
					int contador5 = 0;
					int contador6 = 0;
					int contador7 = 0;
					int contador8 = 0;
					int contador9 = 0;
					int contador10 = 0;
					int contador11 = 0;
					int contador12 = 0;
					int contador13 = 0;
				switch (opcion)
				{

					
					case 1:
					do
					{
						System.out.println("Introduzca el numero de fichas que desea generar");
						numero = teclado.nextInt();
						
						if (numero <= 0)
						{
							System.out.println("Introduzca un numero positivo");
							numero = teclado.nextInt();
						}
						
					}
					while (numero <= 0);
					
					for (int contador = 0; contador < numero; contador++)
					{
						//GenerarFicha
							ficha1 = aleatorio.nextInt (7) + 0;
							ficha2 = aleatorio.nextInt (7) + 0;
							
							if (ficha1 == 0 && ficha2 == 0)
							{
								System.out.println("---------------------------------");
								System.out.println("***********");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("***********");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("***********");
								System.out.println("---------------------------------");
							}
							
							if ((ficha1 == 0 && ficha2 == 1) || (ficha1 == 1 && ficha2 == 0))
							{
								System.out.println("---------------------------------");
								System.out.println("***********");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("***********");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("*    *    *");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("***********");
								System.out.println("---------------------------------");
							}
							
							if ((ficha1 == 0 && ficha2 == 2) || (ficha1 == 2 && ficha2 == 0))
							{
								System.out.println("---------------------------------");
								System.out.println("***********");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("***********");
								System.out.println("* *       *");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("*       * *");
								System.out.println("***********");
								System.out.println("---------------------------------");
							}
							
							if ((ficha1 == 0 && ficha2 == 3) || (ficha1 == 3 && ficha2 == 0))
							{
								System.out.println("---------------------------------");
								System.out.println("***********");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("***********");
								System.out.println("* *       *");
								System.out.println("*         *");
								System.out.println("*    *    *");
								System.out.println("*         *");
								System.out.println("*       * *");
								System.out.println("***********");
								System.out.println("---------------------------------");
							}
							
							if ((ficha1 == 0 && ficha2 == 4) || (ficha1 == 4 && ficha2 == 0))
							{
								System.out.println("---------------------------------");
								System.out.println("***********");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("***********");
								System.out.println("* *     * *");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("* *     * *");
								System.out.println("***********");
								System.out.println("---------------------------------");
							}
							
							if ((ficha1 == 0 && ficha2 == 5) || (ficha1 == 5 && ficha2 == 0))
							{
								System.out.println("---------------------------------");
								System.out.println("***********");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("***********");
								System.out.println("* *     * *");
								System.out.println("*         *");
								System.out.println("*    *    *");
								System.out.println("*         *");
								System.out.println("* *     * *");
								System.out.println("***********");
								System.out.println("---------------------------------");
							}
							
							if ((ficha1 == 0 && ficha2 == 6) || (ficha1 == 6 && ficha2 == 0))
							{
								System.out.println("---------------------------------");
								System.out.println("***********");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("***********");
								System.out.println("* *     * *");
								System.out.println("*         *");
								System.out.println("* *     * *");
								System.out.println("*         *");
								System.out.println("* *     * *");
								System.out.println("***********");;
								System.out.println("---------------------------------");
							}
							
							if (ficha1 == 1 && ficha2 == 1)
							{
								System.out.println("---------------------------------");
								System.out.println("***********");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("*    *    *");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("***********");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("*    *    *");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("***********");
								System.out.println("---------------------------------");
							}
							
							if ((ficha1 == 2 && ficha2 == 1) || ficha1 == 1 && ficha2 == 2)
							{
								System.out.println("---------------------------------");
								System.out.println("***********");
								System.out.println("* *       *");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("*       * *");
								System.out.println("***********");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("*    *    *");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("***********");
								System.out.println("---------------------------------");
							}
							
							if ((ficha1 == 3 && ficha2 == 1) || (ficha1 == 1 && ficha2 == 3))
							{
								System.out.println("---------------------------------");
								System.out.println("***********");
								System.out.println("* *       *");
								System.out.println("*         *");
								System.out.println("*    *    *");
								System.out.println("*         *");
								System.out.println("*       * *");
								System.out.println("***********");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("*    *    *");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("***********");
								System.out.println("---------------------------------");
							}
							
							if ((ficha1 == 4 && ficha2 == 1) || (ficha1 == 1 && ficha2 == 4))
							{
								System.out.println("---------------------------------");
								System.out.println("***********");
								System.out.println("* *     * *");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("* *     * *");
								System.out.println("***********");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("*    *    *");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("***********");
								System.out.println("---------------------------------");
							}
							
							if ((ficha1 == 5 && ficha2 == 1) || (ficha1 == 1 && ficha2 == 5))
							{
								System.out.println("---------------------------------");
								System.out.println("***********");
								System.out.println("* *     * *");
								System.out.println("*         *");
								System.out.println("*    *    *");
								System.out.println("*         *");
								System.out.println("* *     * *");
								System.out.println("***********");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("*    *    *");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("***********");
								System.out.println("---------------------------------");
							}
							
							if ((ficha1 == 6 && ficha2 == 1) || (ficha1 == 1 && ficha2 == 6))
							{
								System.out.println("---------------------------------");
								System.out.println("***********");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("*    *    *");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("***********");
								System.out.println("* *     * *");
								System.out.println("*         *");
								System.out.println("* *     * *");
								System.out.println("*         *");
								System.out.println("* *     * *");
								System.out.println("***********");;
								System.out.println("---------------------------------");
							}
							
							if (ficha1 == 2 && ficha2 == 2)
							{
								System.out.println("---------------------------------");
								System.out.println("***********");
								System.out.println("* *       *");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("*       * *");
								System.out.println("***********");
								System.out.println("* *       *");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("*       * *");
								System.out.println("***********");
								System.out.println("---------------------------------");
							}
							
							if ((ficha1 == 3 && ficha2 == 2) || (ficha1 == 2 && ficha2 == 3))
							{
								System.out.println("---------------------------------");
								System.out.println("***********");
								System.out.println("* *       *");
								System.out.println("*         *");
								System.out.println("*    *    *");
								System.out.println("*         *");
								System.out.println("*       * *");
								System.out.println("***********");
								System.out.println("* *       *");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("*       * *");
								System.out.println("***********");
								System.out.println("---------------------------------");
							}
							
							if ((ficha1 == 4 && ficha2 == 2) || (ficha1 == 2 && ficha2 == 4))
							{
								System.out.println("---------------------------------");
								System.out.println("***********");
								System.out.println("* *     * *");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("* *     * *");
								System.out.println("***********");
								System.out.println("* *       *");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("*       * *");
								System.out.println("***********");
								System.out.println("---------------------------------");
							}
							
							if ((ficha1 == 5 && ficha2 == 2) || (ficha1 == 2 && ficha2 == 5))
							{
								System.out.println("---------------------------------");
								System.out.println("***********");
								System.out.println("* *     * *");
								System.out.println("*         *");
								System.out.println("*    *    *");
								System.out.println("*         *");
								System.out.println("* *     * *");
								System.out.println("***********");
								System.out.println("* *       *");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("*       * *");
								System.out.println("***********");
								System.out.println("---------------------------------");
							}
							
							if ((ficha1 == 6 && ficha2 == 2) || (ficha1 == 2 && ficha2 == 6))
							{
								System.out.println("---------------------------------");
								System.out.println("***********");
								System.out.println("* *       *");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("*       * *");
								System.out.println("***********");
								System.out.println("* *     * *");
								System.out.println("*         *");
								System.out.println("* *     * *");
								System.out.println("*         *");
								System.out.println("* *     * *");
								System.out.println("***********");;
								System.out.println("---------------------------------");
							}
							
							if (ficha1 == 3 && ficha2 == 3)
							{
								System.out.println("---------------------------------");
								System.out.println("***********");
								System.out.println("* *       *");
								System.out.println("*         *");
								System.out.println("*    *    *");
								System.out.println("*         *");
								System.out.println("*       * *");
								System.out.println("***********");
								System.out.println("* *       *");
								System.out.println("*         *");
								System.out.println("*    *    *");
								System.out.println("*         *");
								System.out.println("*       * *");
								System.out.println("***********");
								System.out.println("---------------------------------");
							}
							
							if ((ficha1 == 4 && ficha2 == 3) || (ficha1 == 3 && ficha2 == 4))
							{
								System.out.println("---------------------------------");
								System.out.println("***********");
								System.out.println("* *     * *");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("* *     * *");
								System.out.println("***********");
								System.out.println("* *       *");
								System.out.println("*         *");
								System.out.println("*    *    *");
								System.out.println("*         *");
								System.out.println("*       * *");
								System.out.println("***********");
								System.out.println("---------------------------------");
							}
							
							if ((ficha1 == 5 && ficha2 == 3) || (ficha1 == 3 && ficha2 == 5))
							{
								System.out.println("---------------------------------");
								System.out.println("***********");
								System.out.println("* *     * *");
								System.out.println("*         *");
								System.out.println("*    *    *");
								System.out.println("*         *");
								System.out.println("* *     * *");
								System.out.println("***********");
								System.out.println("* *       *");
								System.out.println("*         *");
								System.out.println("*    *    *");
								System.out.println("*         *");
								System.out.println("*       * *");
								System.out.println("***********");
								System.out.println("---------------------------------");
							}
							
							if ((ficha1 == 6 && ficha2 == 3) || (ficha1 == 3 && ficha2 == 6))
							{
								System.out.println("---------------------------------");
								System.out.println("***********");
								System.out.println("* *       *");
								System.out.println("*         *");
								System.out.println("*    *    *");
								System.out.println("*         *");
								System.out.println("*       * *");
								System.out.println("***********");
								System.out.println("* *     * *");
								System.out.println("*         *");
								System.out.println("* *     * *");
								System.out.println("*         *");
								System.out.println("* *     * *");
								System.out.println("***********");;
								System.out.println("---------------------------------");
							}
							
							if (ficha1 == 4 && ficha2 == 4)
							{
								System.out.println("---------------------------------");
								System.out.println("***********");
								System.out.println("* *     * *");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("* *     * *");
								System.out.println("***********");
								System.out.println("* *     * *");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("* *     * *");
								System.out.println("***********");
								System.out.println("---------------------------------");
							}
								
							if ((ficha1 == 5 && ficha2 == 4) || (ficha1 == 4 && ficha2 == 5))
							{
								System.out.println("---------------------------------");
								System.out.println("***********");
								System.out.println("* *     * *");
								System.out.println("*         *");
								System.out.println("*    *    *");
								System.out.println("*         *");
								System.out.println("* *     * *");
								System.out.println("***********");
								System.out.println("* *     * *");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("* *     * *");
								System.out.println("***********");
								System.out.println("---------------------------------");
							}
							
							if ((ficha1 == 6 && ficha2 == 4) || (ficha1 == 4 && ficha2 == 6))
							{
								System.out.println("---------------------------------");
								System.out.println("***********");
								System.out.println("* *     * *");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("* *     * *");
								System.out.println("***********");
								System.out.println("* *     * *");
								System.out.println("*         *");
								System.out.println("* *     * *");
								System.out.println("*         *");
								System.out.println("* *     * *");
								System.out.println("***********");;
								System.out.println("---------------------------------");
							}
							
							if (ficha1 == 5 && ficha2 == 5)
							{
								System.out.println("---------------------------------");
								System.out.println("***********");
								System.out.println("* *     * *");
								System.out.println("*         *");
								System.out.println("*    *    *");
								System.out.println("*         *");
								System.out.println("* *     * *");
								System.out.println("***********");
								System.out.println("* *     * *");
								System.out.println("*         *");
								System.out.println("*    *    *");
								System.out.println("*         *");
								System.out.println("* *     * *");
								System.out.println("***********");
								System.out.println("---------------------------------");
							}
							
							if ((ficha1 == 6 && ficha2 == 5) || (ficha1 == 5 && ficha2 == 6))
							{
								System.out.println("---------------------------------");
								System.out.println("***********");
								System.out.println("* *     * *");
								System.out.println("*         *");
								System.out.println("*    *    *");
								System.out.println("*         *");
								System.out.println("* *     * *");
								System.out.println("***********");
								System.out.println("* *     * *");
								System.out.println("*         *");
								System.out.println("* *     * *");
								System.out.println("*         *");
								System.out.println("* *     * *");
								System.out.println("***********");;
								System.out.println("---------------------------------");
							}

							if (ficha1 == 6 && ficha2 == 6)
							{
								System.out.println("---------------------------------");
								System.out.println("***********");
								System.out.println("* *     * *");
								System.out.println("*         *");
								System.out.println("* *     * *");
								System.out.println("*         *");
								System.out.println("* *     * *");
								System.out.println("***********");
								System.out.println("* *     * *");
								System.out.println("*         *");
								System.out.println("* *     * *");
								System.out.println("*         *");
								System.out.println("* *     * *");
								System.out.println("***********");;
								System.out.println("---------------------------------");
							}
							
							
							
							//Fin GenerarFicha
							
							//SumarContarPuntuacion
							suma = ficha1 + ficha2;
							
							switch (suma)
							{
								case 0:
								
								contador1++;
								
								break;
								
								case 1:
								
								contador2++;
								
								break;
								
								case 2:
								
								contador3++;
								
								break;
								
								case 3:
								
								contador4++;
								
								break;
								
								case 4:
								
								contador5++;
								
								break;
								
								case 5:
								
								contador6++;
								
								break;
								
								case 6:
								
								contador7++;
								
								break;
								
								case 7:
								
								contador8++;
								
								break;
								
								case 8:
								
								contador9++;
								
								break;
								
								case 9:
								
								contador10++;
								
								break;
								
								case 10:
								
								contador11++;
								
								break;
								
								case 11:
								
								contador12++;
								
								break;
								
								case 12:
								
								contador13++;
								
								break;
								
								
							}//Fin_segun
					}//fin_para
					
					break;
					
					case 2:
					//LeerValidarSiGenerar
					do
					{
					System.out.println("Desea generar una ficha? Y/N");
					generar = Character.toLowerCase(teclado.next().charAt(0));
					}
					while (generar != 'y' && generar != 'n');
					//Fin LeerValidarSiGenerar
					
					//GenerarSumarFicha					
						//Mientras QuieraGenerar
						while (generar == 'y')
						{
						
							//GenerarFicha
							ficha1 = aleatorio.nextInt (7) + 0;
							ficha2 = aleatorio.nextInt (7) + 0;
							
							if (ficha1 == 0 && ficha2 == 0)
							{
								System.out.println("---------------------------------");
								System.out.println("***********");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("***********");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("***********");
								System.out.println("---------------------------------");
							}
							
							if ((ficha1 == 0 && ficha2 == 1) || (ficha1 == 1 && ficha2 == 0))
							{
								System.out.println("---------------------------------");
								System.out.println("***********");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("***********");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("*    *    *");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("***********");
								System.out.println("---------------------------------");
							}
							
							if ((ficha1 == 0 && ficha2 == 2) || (ficha1 == 2 && ficha2 == 0))
							{
								System.out.println("---------------------------------");
								System.out.println("***********");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("***********");
								System.out.println("* *       *");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("*       * *");
								System.out.println("***********");
								System.out.println("---------------------------------");
							}
							
							if ((ficha1 == 0 && ficha2 == 3) || (ficha1 == 3 && ficha2 == 0))
							{
								System.out.println("---------------------------------");
								System.out.println("***********");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("***********");
								System.out.println("* *       *");
								System.out.println("*         *");
								System.out.println("*    *    *");
								System.out.println("*         *");
								System.out.println("*       * *");
								System.out.println("***********");
								System.out.println("---------------------------------");
							}
							
							if ((ficha1 == 0 && ficha2 == 4) || (ficha1 == 4 && ficha2 == 0))
							{
								System.out.println("---------------------------------");
								System.out.println("***********");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("***********");
								System.out.println("* *     * *");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("* *     * *");
								System.out.println("***********");
								System.out.println("---------------------------------");
							}
							
							if ((ficha1 == 0 && ficha2 == 5) || (ficha1 == 5 && ficha2 == 0))
							{
								System.out.println("---------------------------------");
								System.out.println("***********");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("***********");
								System.out.println("* *     * *");
								System.out.println("*         *");
								System.out.println("*    *    *");
								System.out.println("*         *");
								System.out.println("* *     * *");
								System.out.println("***********");
								System.out.println("---------------------------------");
							}
							
							if ((ficha1 == 0 && ficha2 == 6) || (ficha1 == 6 && ficha2 == 0))
							{
								System.out.println("---------------------------------");
								System.out.println("***********");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("***********");
								System.out.println("* *     * *");
								System.out.println("*         *");
								System.out.println("* *     * *");
								System.out.println("*         *");
								System.out.println("* *     * *");
								System.out.println("***********");;
								System.out.println("---------------------------------");
							}
							
							if (ficha1 == 1 && ficha2 == 1)
							{
								System.out.println("---------------------------------");
								System.out.println("***********");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("*    *    *");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("***********");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("*    *    *");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("***********");
								System.out.println("---------------------------------");
							}
							
							if ((ficha1 == 2 && ficha2 == 1) || ficha1 == 1 && ficha2 == 2)
							{
								System.out.println("---------------------------------");
								System.out.println("***********");
								System.out.println("* *       *");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("*       * *");
								System.out.println("***********");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("*    *    *");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("***********");
								System.out.println("---------------------------------");
							}
							
							if ((ficha1 == 3 && ficha2 == 1) || (ficha1 == 1 && ficha2 == 3))
							{
								System.out.println("---------------------------------");
								System.out.println("***********");
								System.out.println("* *       *");
								System.out.println("*         *");
								System.out.println("*    *    *");
								System.out.println("*         *");
								System.out.println("*       * *");
								System.out.println("***********");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("*    *    *");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("***********");
								System.out.println("---------------------------------");
							}
							
							if ((ficha1 == 4 && ficha2 == 1) || (ficha1 == 1 && ficha2 == 4))
							{
								System.out.println("---------------------------------");
								System.out.println("***********");
								System.out.println("* *     * *");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("* *     * *");
								System.out.println("***********");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("*    *    *");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("***********");
								System.out.println("---------------------------------");
							}
							
							if ((ficha1 == 5 && ficha2 == 1) || (ficha1 == 1 && ficha2 == 5))
							{
								System.out.println("---------------------------------");
								System.out.println("***********");
								System.out.println("* *     * *");
								System.out.println("*         *");
								System.out.println("*    *    *");
								System.out.println("*         *");
								System.out.println("* *     * *");
								System.out.println("***********");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("*    *    *");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("***********");
								System.out.println("---------------------------------");
							}
							
							if ((ficha1 == 6 && ficha2 == 1) || (ficha1 == 1 && ficha2 == 6))
							{
								System.out.println("---------------------------------");
								System.out.println("***********");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("*    *    *");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("***********");
								System.out.println("* *     * *");
								System.out.println("*         *");
								System.out.println("* *     * *");
								System.out.println("*         *");
								System.out.println("* *     * *");
								System.out.println("***********");;
								System.out.println("---------------------------------");
							}
							
							if (ficha1 == 2 && ficha2 == 2)
							{
								System.out.println("---------------------------------");
								System.out.println("***********");
								System.out.println("* *       *");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("*       * *");
								System.out.println("***********");
								System.out.println("* *       *");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("*       * *");
								System.out.println("***********");
								System.out.println("---------------------------------");
							}
							
							if ((ficha1 == 3 && ficha2 == 2) || (ficha1 == 2 && ficha2 == 3))
							{
								System.out.println("---------------------------------");
								System.out.println("***********");
								System.out.println("* *       *");
								System.out.println("*         *");
								System.out.println("*    *    *");
								System.out.println("*         *");
								System.out.println("*       * *");
								System.out.println("***********");
								System.out.println("* *       *");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("*       * *");
								System.out.println("***********");
								System.out.println("---------------------------------");
							}
							
							if ((ficha1 == 4 && ficha2 == 2) || (ficha1 == 2 && ficha2 == 4))
							{
								System.out.println("---------------------------------");
								System.out.println("***********");
								System.out.println("* *     * *");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("* *     * *");
								System.out.println("***********");
								System.out.println("* *       *");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("*       * *");
								System.out.println("***********");
								System.out.println("---------------------------------");
							}
							
							if ((ficha1 == 5 && ficha2 == 2) || (ficha1 == 2 && ficha2 == 5))
							{
								System.out.println("---------------------------------");
								System.out.println("***********");
								System.out.println("* *     * *");
								System.out.println("*         *");
								System.out.println("*    *    *");
								System.out.println("*         *");
								System.out.println("* *     * *");
								System.out.println("***********");
								System.out.println("* *       *");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("*       * *");
								System.out.println("***********");
								System.out.println("---------------------------------");
							}
							
							if ((ficha1 == 6 && ficha2 == 2) || (ficha1 == 2 && ficha2 == 6))
							{
								System.out.println("---------------------------------");
								System.out.println("***********");
								System.out.println("* *       *");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("*       * *");
								System.out.println("***********");
								System.out.println("* *     * *");
								System.out.println("*         *");
								System.out.println("* *     * *");
								System.out.println("*         *");
								System.out.println("* *     * *");
								System.out.println("***********");;
								System.out.println("---------------------------------");
							}
							
							if (ficha1 == 3 && ficha2 == 3)
							{
								System.out.println("---------------------------------");
								System.out.println("***********");
								System.out.println("* *       *");
								System.out.println("*         *");
								System.out.println("*    *    *");
								System.out.println("*         *");
								System.out.println("*       * *");
								System.out.println("***********");
								System.out.println("* *       *");
								System.out.println("*         *");
								System.out.println("*    *    *");
								System.out.println("*         *");
								System.out.println("*       * *");
								System.out.println("***********");
								System.out.println("---------------------------------");
							}
							
							if ((ficha1 == 4 && ficha2 == 3) || (ficha1 == 3 && ficha2 == 4))
							{
								System.out.println("---------------------------------");
								System.out.println("***********");
								System.out.println("* *     * *");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("* *     * *");
								System.out.println("***********");
								System.out.println("* *       *");
								System.out.println("*         *");
								System.out.println("*    *    *");
								System.out.println("*         *");
								System.out.println("*       * *");
								System.out.println("***********");
								System.out.println("---------------------------------");
							}
							
							if ((ficha1 == 5 && ficha2 == 3) || (ficha1 == 3 && ficha2 == 5))
							{
								System.out.println("---------------------------------");
								System.out.println("***********");
								System.out.println("* *     * *");
								System.out.println("*         *");
								System.out.println("*    *    *");
								System.out.println("*         *");
								System.out.println("* *     * *");
								System.out.println("***********");
								System.out.println("* *       *");
								System.out.println("*         *");
								System.out.println("*    *    *");
								System.out.println("*         *");
								System.out.println("*       * *");
								System.out.println("***********");
								System.out.println("---------------------------------");
							}
							
							if ((ficha1 == 6 && ficha2 == 3) || (ficha1 == 3 && ficha2 == 6))
							{
								System.out.println("---------------------------------");
								System.out.println("***********");
								System.out.println("* *       *");
								System.out.println("*         *");
								System.out.println("*    *    *");
								System.out.println("*         *");
								System.out.println("*       * *");
								System.out.println("***********");
								System.out.println("* *     * *");
								System.out.println("*         *");
								System.out.println("* *     * *");
								System.out.println("*         *");
								System.out.println("* *     * *");
								System.out.println("***********");;
								System.out.println("---------------------------------");
							}
							
							if (ficha1 == 4 && ficha2 == 4)
							{
								System.out.println("---------------------------------");
								System.out.println("***********");
								System.out.println("* *     * *");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("* *     * *");
								System.out.println("***********");
								System.out.println("* *     * *");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("* *     * *");
								System.out.println("***********");
								System.out.println("---------------------------------");
							}
								
							if ((ficha1 == 5 && ficha2 == 4) || (ficha1 == 4 && ficha2 == 5))
							{
								System.out.println("---------------------------------");
								System.out.println("***********");
								System.out.println("* *     * *");
								System.out.println("*         *");
								System.out.println("*    *    *");
								System.out.println("*         *");
								System.out.println("* *     * *");
								System.out.println("***********");
								System.out.println("* *     * *");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("* *     * *");
								System.out.println("***********");
								System.out.println("---------------------------------");
							}
							
							if ((ficha1 == 6 && ficha2 == 4) || (ficha1 == 4 && ficha2 == 6))
							{
								System.out.println("---------------------------------");
								System.out.println("***********");
								System.out.println("* *     * *");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("*         *");
								System.out.println("* *     * *");
								System.out.println("***********");
								System.out.println("* *     * *");
								System.out.println("*         *");
								System.out.println("* *     * *");
								System.out.println("*         *");
								System.out.println("* *     * *");
								System.out.println("***********");;
								System.out.println("---------------------------------");
							}
							
							if (ficha1 == 5 && ficha2 == 5)
							{
								System.out.println("---------------------------------");
								System.out.println("***********");
								System.out.println("* *     * *");
								System.out.println("*         *");
								System.out.println("*    *    *");
								System.out.println("*         *");
								System.out.println("* *     * *");
								System.out.println("***********");
								System.out.println("* *     * *");
								System.out.println("*         *");
								System.out.println("*    *    *");
								System.out.println("*         *");
								System.out.println("* *     * *");
								System.out.println("***********");
								System.out.println("---------------------------------");
							}
							
							if ((ficha1 == 6 && ficha2 == 5) || (ficha1 == 5 && ficha2 == 6))
							{
								System.out.println("---------------------------------");
								System.out.println("***********");
								System.out.println("* *     * *");
								System.out.println("*         *");
								System.out.println("*    *    *");
								System.out.println("*         *");
								System.out.println("* *     * *");
								System.out.println("***********");
								System.out.println("* *     * *");
								System.out.println("*         *");
								System.out.println("* *     * *");
								System.out.println("*         *");
								System.out.println("* *     * *");
								System.out.println("***********");;
								System.out.println("---------------------------------");
							}

							if (ficha1 == 6 && ficha2 == 6)
							{
								System.out.println("---------------------------------");
								System.out.println("***********");
								System.out.println("* *     * *");
								System.out.println("*         *");
								System.out.println("* *     * *");
								System.out.println("*         *");
								System.out.println("* *     * *");
								System.out.println("***********");
								System.out.println("* *     * *");
								System.out.println("*         *");
								System.out.println("* *     * *");
								System.out.println("*         *");
								System.out.println("* *     * *");
								System.out.println("***********");;
								System.out.println("---------------------------------");
							}
							
							
							
							//Fin GenerarFicha
							
							//SumarContarPuntuacion
							suma = ficha1 + ficha2;
							
							switch (suma)
							{
								case 0:
								
								contador1++;
								
								break;
								
								case 1:
								
								contador2++;
								
								break;
								
								case 2:
								
								contador3++;
								
								break;
								
								case 3:
								
								contador4++;
								
								break;
								
								case 4:
								
								contador5++;
								
								break;
								
								case 5:
								
								contador6++;
								
								break;
								
								case 6:
								
								contador7++;
								
								break;
								
								case 7:
								
								contador8++;
								
								break;
								
								case 8:
								
								contador9++;
								
								break;
								
								case 9:
								
								contador10++;
								
								break;
								
								case 10:
								
								contador11++;
								
								break;
								
								case 11:
								
								contador12++;
								
								break;
								
								case 12:
								
								contador13++;
								
								break;
								
								
							}//Fin_segun
							
					//LeerValidarVolverGenerar
					do
					{
					System.out.println("Desea generar otra ficha? Y/N");
					generar = Character.toLowerCase(teclado.next().charAt(0));
					}
					while (generar != 'y' && generar != 'n');
					//Fin LeerValidarVolverGenerar
				
				//Fin GenerarSumarFicha
				
			}//Mientras_2
			}//fin_segun
			//PrintRes
			System.out.println("La suma 0 ha salido: "+contador1+" veces.");
			System.out.println("La suma 1 ha salido: "+contador2+" veces.");
			System.out.println("La suma 2 ha salido: "+contador3+" veces.");
			System.out.println("La suma 3 ha salido: "+contador4+" veces.");
			System.out.println("La suma 4 ha salido: "+contador5+" veces.");
			System.out.println("La suma 5 ha salido: "+contador6+" veces.");
			System.out.println("La suma 6 ha salido: "+contador7+" veces.");
			System.out.println("La suma 7 ha salido: "+contador8+" veces.");
			System.out.println("La suma 8 ha salido: "+contador9+" veces.");
			System.out.println("La suma 9 ha salido: "+contador10+" veces.");
			System.out.println("La suma 10 ha salido: "+contador11+" veces.");
			System.out.println("La suma 11 ha salido: "+contador12+" veces.");
			System.out.println("La suma 12 ha salido: "+contador13+" veces.");
			//Fin PrintRes
			

			}//Fin_if
			
			
			//LeerValidarReiniciar
			do
			{
			System.out.println("Desea volver a ejecutar el programa? Y/N");
			iniciar = Character.toLowerCase(teclado.next().charAt(0));
			}
			while (iniciar != 'y' && iniciar != 'n');
			//Fin LeerValidarReiniciar
			
		}//Fin_Mientras
		//Fin
	}//Fin_main
}//Fin_pp
