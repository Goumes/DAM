/*Nombre del programa: ExamenAlejandroG
 * Inicio
 * LeerValidarIniciar
 * Mientras QuieraIniciar
		* PrintMenuLeerValidarOpcion
		* Según (opción)
			* caso 1: PintarCuadrado
			* caso 2: NumeroVampiro
			* caso 3: FuegoBarcoAgua
		* Fin_segun
		* LeerValidarReiniciar
 * Fin_mientras
 * Fin   
 * 
 * 
 * Modulo desarrollado de 'FuegoBarcoAgua'
 * 
 * Inicio
 * LeerValidarJugadas
 * para (contador = 0; contador es menor que jugadas; contador++)
		* PrintOpcionesLeerValidarOpcion
		* HacerReglas
		* PrintGanadorRonda		
 * fin_para
 * PrintResultados
 * Fin
 */
 
//Inicio
import java.util.Scanner;
import java.util.Random;
public class ExamenAlejandroG{
	public static void main (String[]args){
		Scanner teclado = new Scanner (System.in);
		Random aleatorio = new Random();
		char iniciar = ' ';
		int opcion;
		int lado; //lado del cuadrado
		char caracter = ' '; //caracter del cuadrado
		int jugadas;
		int opcionJuego; //Opción del juego elegida por el usuario
		int opcionOrdenador; //Opción del juego elegida por la máquina
		
		//LeerValidarIniciar
		do
		{
		System.out.println("Desea ejecutar el programa? S/N");
		iniciar = Character.toLowerCase(teclado.next().charAt(0));
		}
		while (iniciar != 's' && iniciar != 'n');
		//Fin LeerValidarIniciar

		//Mientras QuieraIniciar
		while (iniciar == 's')
		{

			//PrintMenuLeerValidarOpcion
			do
			{
				System.out.println("-------------------Menu------------------");
				System.out.println("----------1. Pintar un cuadrado----------");
				System.out.println("------------2. Numero Vampiro------------");
				System.out.println("----------3. Fuego, barco, agua----------");
				System.out.println("------------0. Salir del menu------------");
				System.out.println("-----------------------------------------");
				opcion = teclado.nextInt();
			}
			while (opcion < 0 || opcion > 3);
			//Fin PrintMenuLeerValidarOpcion
			if (opcion != 0)
			{
				//Según (opción)
				switch (opcion)
				{
					//caso 1: PintarCuadrado
					case 1: 
						/* Bucle de sucesos, controlado por centinela con condición de salida lado % 2 != 0 && lado  >= 5 && lado <= 30) 
						 * Se incializa por lectura anticipada y se actualiza por lectura final. Ambas coinciden en el mismo punto. 
						*/
						do
						{
						System.out.println("Introduzca el valor del lado. Debe ser impar entre 5 y 30.");
						lado = teclado.nextInt();
							while (lado % 2 == 0 || lado < 5 || lado > 30)
							{
								System.out.println("Error. Por favor introduzca un valor impar entre 5 y 30.");
								lado = teclado.nextInt();
							}
						}
						while (lado % 2 == 0 || lado < 5 || lado > 30);
						
						/* Bucle de sucesos, controlado por centinela con condición de salida caracter == '*' || caracter == '+' ||
						 * caracter == 'a') 
						 * Se incializa por lectura anticipada y se actualiza por lectura final. Ambas coinciden en el mismo punto. 
						*/
						do
						{
							System.out.println("Introduzca el caracter deseado para dibujar. Debe ser '*', '+' o 'a'.");
							caracter = teclado.next().charAt(0);
								while (caracter != '*' && caracter != 'a' && caracter != '+')
								{
									System.out.println("Error. Por favor introduzca '*', '+' o 'a'.");
									caracter = teclado.next().charAt(0);
								}
						}
						while (caracter != '*' && caracter != 'a' && caracter != '+');
						
						System.out.println("[LA FUNCIONALIDAD ESTA EN CONSTRUCCION]");

					break;
					
					//caso 2: NumeroVampiro
					case 2: 
						System.out.println("[EN CONSTRUCCION]");
					break;
					
					//caso 3: FuegoBarcoAgua
					case 3: 
					int contadorVictorias = 0;
					int contadorDerrotas = 0;
					int contadorEmpates = 0;
					
						//Inicio
						System.out.println("------------------------------------------");
						System.out.println("Bienvenid@ al juego 'Fuego, barco o agua!'");
						
						//LeerValidarJugadas
						/* Bucle de sucesos, controlado por centinela con condición de salida jugadas >= 0) Se incializa por 
						* lectura anticipada y se actualiza por lectura final. Ambas coinciden en el mismo punto. 
						*/
						do
						{
							System.out.println("--------------------------------------------");
							System.out.println("Indique el numero de jugadas que desea jugar");
							System.out.println("--------------------------------------------");
							jugadas = teclado.nextInt();
								while (jugadas < 0)
								{
									System.out.println("------------------------------------------------------------------------");
									System.out.println("Por favor, introduzca un numero positivo o 0 en caso de que desee salir.");
									System.out.println("------------------------------------------------------------------------");
									jugadas = teclado.nextInt();
								}
						}
						while(jugadas < 0);
						//Fin LeerValidarJugadas
						
						
						if (jugadas != 0)
						{
							//para (contador = 0; contador es menor que jugadas; contador++)
							/*Bucle de contador, controlado por centinela con condición de salida contador >= jugadas. Se inicializa
							 * y actualiza en la misma declaración del bucle.
							 */ 
							for (int contador = 0; contador < jugadas; contador++)
							{
								/*Variables booleanas que indican la elección en el juego. */
								boolean fuego = false;
								boolean agua = false;
								boolean barco = false;
								boolean fuego2 = false;
								boolean agua2 = false;
								boolean barco2 = false;
								boolean ganador = false;
								boolean empate = false;
								
								//PrintOpcionesLeerValidarOpcion
								do
								{
								System.out.println("------------------------------------------------");
								System.out.println("Seleccione una de las siguientes tres opciones: ");
								System.out.println("---------------------1. Fuego-------------------");
								System.out.println("---------------------2. Barco-------------------");
								System.out.println("---------------------3. Agua--------------------");
								System.out.println("------------------------------------------------");
								opcionJuego = teclado.nextInt();
								}
								while (opcionJuego < 1 || opcionJuego > 3);
								//Fin PrintOpcionesLeerValidarOpcion
								
								//HacerReglas
								
								/*generar opcion aleatoria de la máquina*/
								opcionOrdenador = aleatorio.nextInt(3) + 1;
								
								
								/*relacionar opcion elegida con variable booleana*/
								if (opcionOrdenador == 1)
								{
										fuego2 = true;
								}
								
								if (opcionOrdenador == 2)
								{
										barco2 = true;
								}
								
								if (opcionOrdenador == 3)
								{
										agua2 = true;
								}
								
								if (opcionJuego == 1)
								{
										fuego = true;
								}
								
								if (opcionJuego == 2)
								{
										barco = true;
								}
								
								if (opcionJuego == 3)
								{
										agua = true;
								}
								
								/*Reglas del juego*/
								if (fuego == true && barco2 == true)
								{
									System.out.println("-----------------");
									System.out.println("FUEGO QUEMA BARCO");
									System.out.println("-----------------");
									ganador = true;
								}
								if (fuego == true && agua2 == true)
								{
									System.out.println("---------------------------------------");
									System.out.println("EL FUEGO ES APAGADO POR EL AGUA ENEMIGA");
									System.out.println("---------------------------------------");
								}
								
								if (agua == true && barco2 == true)
								{
									System.out.println("---------------------------------");
									System.out.println("EL BARCO ENEMIGO FLOTA EN EL AGUA");
									System.out.println("---------------------------------");
								}
								
								if (barco == true && fuego2 == true)
								{
									System.out.println("---------------------------------------");
									System.out.println("EL FUEGO ENEMIGO QUEMA EL BARCO");
									System.out.println("---------------------------------------");
								}
								
								if (barco == true && agua2 == true)
								{
									System.out.println("-------------------");
									System.out.println("BARCO FLOTA EN AGUA");
									System.out.println("-------------------");
									ganador = true;
								}
								
								if (agua == true && fuego2 == true)
								{
									System.out.println("----------------");
									System.out.println("AGUA APAGA FUEGO");
									System.out.println("----------------");
									ganador = true;
								}
								
								if (agua == true && agua2 == true)
								{
									System.out.println("--------------------");
									System.out.println("AGUA EMPATA CON AGUA");
									System.out.println("--------------------");
									empate = true;
								}
								
								if (fuego == true && fuego2 == true)
								{
									System.out.println("----------------------");
									System.out.println("FUEGO EMPATA CON FUEGO");
									System.out.println("----------------------");
									empate = true;
								}
								
								if (barco == true && barco2 == true)
								{
									System.out.println("----------------------");
									System.out.println("BARCO EMPATA CON BARCO");
									System.out.println("----------------------");
									empate = true;
								}
								
								//Fin HacerReglas
								
								//PrintGanadorRonda
								
								if (ganador == true)
								{
									System.out.println("-----------------------------------");
									System.out.println("ENHORABUENA! Has ganado esta ronda.");
									System.out.println("-----------------------------------");
									contadorVictorias++;
								}
								if (empate == true)
								{
									System.out.println("--------------------------");
									System.out.println("Se ha producido un empate!");
									System.out.println("--------------------------");
									contadorEmpates++;
								}
								if (ganador == false && empate == false)
								{
									System.out.println("---------------------------------------------");
									System.out.println("VAYA! Has perdido. Mas suerte la proxima vez.");
									System.out.println("---------------------------------------------");
									contadorDerrotas++;
								}
								//Fin PrintGanadorRonda
							}//Fin_para
							
							//PrintResultados
							
							/*PrintResumenJugadas*/
							System.out.println("Has ganado: "+contadorVictorias);
							System.out.println("Has perdido: "+contadorDerrotas);
							System.out.println("Has empatado: "+contadorEmpates);
							
							/*PrintGanadorFinal*/
							if (contadorVictorias > contadorDerrotas)
							{
							System.out.println("-------------------------------");
							System.out.println("El veredicto final es: VICTORIA");
							System.out.println("-------------------------------");
							}
							
							if (contadorEmpates > contadorVictorias && contadorEmpates > contadorDerrotas)
							{
								System.out.println("------------------------------");
								System.out.println("El veredicto final es: EMPATE");
								System.out.println("------------------------------");
							}
							if (contadorDerrotas > contadorVictorias)
							{
								System.out.println("-------------------------------");
								System.out.println("El veredicto final es: DERROTA");
								System.out.println("-------------------------------");
							}
							//Fin PrintResultados
						}//fin_si
						//Fin
					break;
					
				}//Fin_segun
			}//Fin_ si
			
			//LeerValidarReiniciar
			do
			{
			System.out.println("Desea volver a ejecutar el programa? S/N");
			iniciar = Character.toLowerCase(teclado.next().charAt(0));
			}
			while (iniciar != 's' && iniciar != 'n');
			//Fin LeerValidarReiniciar
			
		}//Fin_mientras
	}//Fin_main
}//Fin_pp
//Fin   
 
