/*Nombre del programa: Moneda
 * Análisis:Simular el lanzamiento de una moneda al aire e imprimir si ha salido cara o cruz. 
 * Repetir el proceso tantas veces como desee el jugador.
 * Entrada: 
 * Salida: Resultado lanzamiento
 * Restricciones:
 * Estudio de los bucles: 
 * 1. Bucle 'iniciar' controlado por centinela, condición de salida = 'n' 
 * Bucles 2 y 3 controlados por centinela.
 * 		2. 'LeerValidarIniciar' condición de salida = 'y' || 'n'
 * 		3. 'LeerValidarReiniciar' condición de salida = 'y' || 'n'
 * 
 * P.G.
 * Inicio
 * LeerValidarIniciar
 * Mientras QuieraIniciar
 * 		LanzarMoneda
 * 		PrintRes
 * 		LeerValidarReiniciar
 * Fin_Mientras
 * Fin
 */
 
 
 //Inicio
 import java.util.Scanner;
 import java.util.Random;
 public class Moneda {
	 public static void main (String[]args){
		 Scanner teclado = new Scanner (System.in);
		 Random aleatorio = new Random();
		 char iniciar = ' ';
		 int moneda = 0;
		 
		//LeerValidarIniciar
		do
		{
		System.out.println("Desea tirar una moneda? Y/N");
		iniciar = Character.toLowerCase(teclado.next().charAt(0));
		}
		while (iniciar != 'y' && iniciar != 'n');
		//Fin LeerValidarIniciar
		
		//Mientras QuieraIniciar
		while (iniciar == 'y')
		{
			//LanzarMoneda
			moneda = aleatorio.nextInt(2) + 1;
			
			//Fin LanzarMoneda
			
			//PrintRes
			if (moneda == 1)
			{
				System.out.println("--------------");
				System.out.println("  00000000");
				System.out.println("  0      0");
				System.out.println("  0      0");
				System.out.println("  0 Cara 0");
				System.out.println("  0      0");
				System.out.println("  0      0");
				System.out.println("  00000000");
				System.out.println("--------------");
				
			}
			else
			{
				System.out.println("--------------");
				System.out.println("  00000000");
				System.out.println("  0      0");
				System.out.println("  0      0");
				System.out.println("  0 Cruz 0");
				System.out.println("  0      0");
				System.out.println("  0      0");
				System.out.println("  00000000");
				System.out.println("--------------");
			}
			//Fin PrintRes
			
			//LeerValidarReiniciar
			do
			{
			System.out.println("Desea volver a tirar una moneda? Y/N");
			iniciar = Character.toLowerCase(teclado.next().charAt(0));
			}
			while (iniciar != 'y' && iniciar != 'n');
			//Fin LeerValidarReiniciar
			
		}//Fin_Mientras
		//Fin
	 }//Fin_main
 }//Fin_pp
