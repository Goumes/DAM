/* Nombre del programa: CarreraCaballos
 * Análisis: Diseña un programa para simular una carrera de tres caballos. Las probabilidades de ganar las simulará el diseñador según sus propios criterios. 
 * El programa permitirá al usuario jugar repetidas veces si lo desea. Puede incluirse la posibilidad de apostar interactivamente.
 * Entradas: Elegir caballo
 * Salidas: Resultado
 * Restricciones: 
 * Estudio de bucles:
 * 
 * 
 * P.G.
 * 
 * Inicio
 * LeerValidarIniciar
 * Mientras QuieraIniciar
 * 		GenerarPosibilidades
 * 		LeerValidarElegirCaballo
 * 		LeerValidarApuesta
 * 		SimularCarrera
 * 		PrintRes
 * 		LeerValidarReiniciar
 * Fin_Mientras
 * Fin
 */
 
 
//Inicio
import java.util.Scanner;
import java.util.Random;
import java.lang.Math;
public class CarreraCaballos{
	public static void main (String[]args){
		Scanner teclado = new Scanner (System.in);
		Random aleatorio = new Random ();
		char iniciar = ' ';
		double caballo1;
		double caballo2;
		double caballo3;
		double random1;
		double random2;
		double random3;
		double apuesta;
		int opcion;
		
		//LeerValidarIniciar
		do
		{
		System.out.println("Desea ejecutar el programa? Y/N");
		iniciar = Character.toLowerCase (teclado.next().charAt(0));
		}
		while (iniciar != 'y' && iniciar != 'n');
		//Fin LeerValidarIniciar

		//Mientras QuieraIniciar
		while (iniciar == 'y')
		{
			//GenerarPosibilidades
			caballo1 = aleatorio.nextDouble (10) + 1;
			caballo2 = aleatorio.nextInt (10) + 1;
			caballo3 = aleatorio.nextInt (10) + 1;
			//Fin GenerarPosibilidades
			
			//ElegirCaballo
			do
			{
			System.out.println("------Opciones de ganar------");
			System.out.println("----Caballo 1: "+caballo1+"-------");
			System.out.println("----Caballo 2: "+caballo2+"-------");
			System.out.println("----Caballo 3: "+caballo3+"-------");
			System.out.println("-----------------------------");
			opcion = teclado.nextInt();
			}
			while (opcion < 1 || opcion > 3);
			//Fin ElegirCaballo
			
			//Apostar
			do
			{
			System.out.println("Introduzca la cantidad que desea apostar.");
			apuesta = teclado.nextDouble();
				if (apuesta <= 0)
				{
					System.out.println("Introduzca una cantidad superior a 0, por favor.");
					apuesta = teclado.nextDouble();
				}
			}
			while(apuesta <= 0);
			//Fin Apostar
			
			//SimularCarrera
			random1 = aleatorio.nextDouble();
			caballo1 = caballo1 * random1;
			//Fin SimularCarrera
			
			//PrintRes
			//Fin PrintRes
			
			//LeerValidarReiniciar
			do
			{
			System.out.println("Desea volver a ejecutar el programa? Y/N");
			iniciar = Character.toLowerCase (teclado.next().charAt(0));
			}
			while (iniciar != 'y' && iniciar != 'n');
			//Fin LeerValidarReiniciar
			
		}//Fin_Mientras
	}//Fin main
}//Fin_pp
//Fin
