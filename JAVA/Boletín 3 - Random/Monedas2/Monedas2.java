/* Nombre del programa: Monedas2
 * Análisis: Lanzar al aire dos monedas y contar cuántas veces salen 2 caras, 2 cruces y una cruz y una cara.
 * Entradas: 
 * Salidas: Numero de caras y cruces.
 * Restricciones: 
 * Estudio de los bucles: 
 * 
 * 
 * P.G.
 * Inicio
 * 	LeerValidarIniciar
 * 	Mientras QuieraIniciar
 * 		LeerValidarLanzar
 * 		Mientras QuieraLanzar
 * 			LanzarContarMonedas
 *	 		LeerValidarVolverLanzar
 * 		Fin_Mientras2
 * 		PrintRes
 * 		LeerValidarReiniciar
 * 	Fin_Mientras
 * Fin
 */
 
 //Inicio
import java.util.Random;
import java.util.Scanner;
public class Monedas2{
	public static void main (String[]args){
		Scanner teclado = new Scanner (System.in);
		Random aleatorio = new Random();
		char iniciar = ' ';
		char lanzar = ' ';
		int moneda;
		int moneda2;
		//LeerValidarIniciar
		do
		{
			System.out.println("----------------------------------------");
			System.out.println("Desea ejecutar el programa? Y/N");
			System.out.println("----------------------------------------");
			iniciar = Character.toLowerCase(teclado.next().charAt(0));
		}
		while(iniciar != 'y' && iniciar != 'n');
		//FIn LeerValidarIniciar
		
		//Mientras QuieraIniciar
		while (iniciar == 'y')
		{
			
			//LeerValidarLanzar
			System.out.println("----------------------------------------");
			System.out.println("Desea tirar dos monedas? Y/N");
			System.out.println("----------------------------------------");
			lanzar = Character.toLowerCase(teclado.next().charAt(0));
			//Fin LeerValidarLanzar
			
			//Mientras QuieraLanzar
			int contador = 0;
			int contador2 = 0;
			int contador3 = 0;
			
			while (lanzar == 'y')
			{
				//LanzarContarMonedas
				boolean cara = false;
				boolean cruz = false;
				boolean cara2 = false;
				boolean cruz2 = false;
				moneda = aleatorio.nextInt (2) + 1;
				moneda2= aleatorio.nextInt (2) + 1;
				if (moneda == 1)
				{
					System.out.println("----");
					System.out.println("Cara");
					System.out.println("----");
					cara = true;
				}
				if (moneda == 2)
				{
					System.out.println("----");
					System.out.println("Cruz");
					System.out.println("----");
					cruz = true;
				}
				if (moneda2 == 1)
				{
					System.out.println("----");
					System.out.println("Cara");
					System.out.println("----");
					cara2 = true;
				}
				if (moneda2 == 2)
				{
					System.out.println("----");
					System.out.println("Cruz");
					System.out.println("----");
					cruz2 = true;
				}
				
				if (cara == true && cara2 == true)
				{
						contador++;
				}
				
				if (cruz == true && cruz2 == true)
				{
						contador2++;
				}
				
				if ((cara == true && cara2 == false) || (cruz == true && cruz2 == false))
				{
						contador3++;
				}
				//Fin LanzarContarMonedas
				
				//LeerValidarVolverLanzar
				System.out.println("----------------------------------------");
				System.out.println("Desea volver a tirar dos monedas? Y/N");
				System.out.println("----------------------------------------");
				lanzar = Character.toLowerCase(teclado.next().charAt(0));
				//FIn LeerValidarVolverLanzar
			}
			//PrintRes
			System.out.println("----------------------------------------");
			System.out.println("Dos caras: "+contador);
			System.out.println("Dos cruces: "+contador2);
			System.out.println("Cara y cruz: "+contador3);
			System.out.println("----------------------------------------");
			//Fin PrintRes
			
			//LeerValidarReiniciar
			do
			{
				System.out.println("----------------------------------------");
				System.out.println("Desea volver a ejecutar el programa? Y/N");
				System.out.println("----------------------------------------");
				iniciar = Character.toLowerCase(teclado.next().charAt(0));
			}
			while(iniciar != 'y' && iniciar != 'n');
			//Fin LeerValidarReiniciar
			
		}//Fin_mientras
	}//Fin_main
}//Fin_pp
