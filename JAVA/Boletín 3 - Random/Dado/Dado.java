/* Nombre del programa: Dado
 * Análisis: Simular n tiradas de un dado y contar las veces que aparece cada número. 
 * Presentar los resultados en forma de porcentajes. Hacer que el algoritmo se repita hasta que se desee terminar.
 * Entrada: tiradas
 * Salida: Resultados
 * Restricciones: El numero de tiradas no puede ser negativo ni 0.
 * Estudio de los bucles:
 * 
 * Bucle 1. 'Iniciar'. 
 * 		Tipo sucesos controlado por centinela. 
 * 		Condición de salida = 'n' && 'y'
 * 		Se inicializa por lectura anticipada antes de la primera iteración.
 * 		Se actualiza por lectura final al final del bucle.
 * 
 * Bucles 2, 3, 4.'LeerValidar...'
 * 		Tipo sucesos controlado por centinela
 * 		Se inicializa por lectura anticipada antes de la primera iteración.
 * 		Se actualiza por lectura final al final del bucle.
 * 
 * 			Bucle 2. 'LeerValidarInicio'
 * 				Condición de salida = 'y' && 'n'
 * 			Bucle 3. 'LeerValidarTiradas'
 * 				Condición de salida = tiradas <= 0
 * 			Bucle 4. 'LeerValidarReiniciar'
 * 				Condición de salida = 'y' && 'n'
 * 		
 * Bucle 5. ''
 * 
 * P.G.
 * 
 * 
 * Inicio
 * LeerValidarInicio
 * Mientras QuieraIniciar
 * 		LeerValidarTiradas
 * 		ContarNumeros
 * 		PrintRes
 * 		LeerValidarReiniciar
 * Fin_Mientras
 * Fin
 * 
 * 
 * Módulo detallado:
 * 
 * ContarNumeros
 * 		para (contador = 0, mientras el contador sea menor que el numero de tiradas, contador++)
 * 			segun (dado)
 * 				caso dado == 1
 *  			caso dado == 2
 *   			caso dado == 3
 *   			caso dado == 4
 *   			caso dado == 5
 *   			caso dado == 6
 * 			fin_segun
 * 		fin_para
 */
 //Inicio
import java.util.Scanner;
import java.util.Random;
public class Dado{
	public static void main (String[]args){
		Scanner teclado = new Scanner (System.in);
		Random aleatorio = new Random ();
		char iniciar = ' ';
		int tiradas;
		int dado = 0;

		
			//LeerValidarInicio
			do
			{
			System.out.println("Desea tirar el dado? Y/N");
			iniciar = Character.toLowerCase(teclado.next().charAt(0));
			}
			while (iniciar != 'n' && iniciar !='y');
			//Fin LeerValidarInicio
			
			//Mientras QuieraIniciar
			while (iniciar == 'y')//(Bucle 1.)
			{
			
				//LeerValidarTiradas
				do
				{
				System.out.println("Introduzca el numero de tiradas");
				tiradas = teclado.nextInt();
				}
				while (tiradas <= 0);
				//Fin LeerValidarTiradas
				
				//ContarNumeros
				int contador1 = 0;
				int contador2 = 0;
				int contador3 = 0;
				int contador4 = 0;
				int contador5 = 0;
				int contador6 = 0;
				for (int contador = 0; contador < tiradas; contador++)
				{
					dado = aleatorio.nextInt(6) + 1;
					switch (dado)
					{
						case 1:
							System.out.println("---------------------------------");
							System.out.println("***********");
							System.out.println("*         *");
							System.out.println("*         *");
							System.out.println("*    *    *");
							System.out.println("*         *");
							System.out.println("*         *");
							System.out.println("***********");
							System.out.println("---------------------------------");
							contador1++;
						break;
						case 2:
							System.out.println("---------------------------------");
							System.out.println("***********");
							System.out.println("* *       *");
							System.out.println("*         *");
							System.out.println("*         *");
							System.out.println("*         *");
							System.out.println("*       * *");
							System.out.println("***********");
							System.out.println("---------------------------------");
							contador2++;
							break;
						case 3:
							System.out.println("---------------------------------");
							System.out.println("***********");
							System.out.println("* *       *");
							System.out.println("*         *");
							System.out.println("*    *    *");
							System.out.println("*         *");
							System.out.println("*       * *");
							System.out.println("***********");
							System.out.println("---------------------------------");
							contador3++;
							break;
						case 4:
							System.out.println("---------------------------------");
							System.out.println("***********");
							System.out.println("* *     * *");
							System.out.println("*         *");
							System.out.println("*         *");
							System.out.println("*         *");
							System.out.println("* *     * *");
							System.out.println("***********");
							System.out.println("---------------------------------");
							contador4++;
							break;
						case 5:
							System.out.println("---------------------------------");
							System.out.println("***********");
							System.out.println("* *     * *");
							System.out.println("*         *");
							System.out.println("*    *    *");
							System.out.println("*         *");
							System.out.println("* *     * *");
							System.out.println("***********");
							System.out.println("---------------------------------");
							contador5++;
							break;
						
						case 6:
							System.out.println("---------------------------------");
							System.out.println("***********");
							System.out.println("* *     * *");
							System.out.println("*         *");
							System.out.println("* *     * *");
							System.out.println("*         *");
							System.out.println("* *     * *");
							System.out.println("***********");
							System.out.println("---------------------------------");
							contador6++;
							break;
					}//fin_segun
				}//Fin_para
				//Fin ContarNumeros
				
				//PrintRes
				System.out.println("---------------------------------");
				System.out.println("El numero 1 ha salido: "+contador1);
				System.out.println("El numero 2 ha salido: "+contador2);
				System.out.println("El numero 3 ha salido: "+contador3);
				System.out.println("El numero 4 ha salido: "+contador4);
				System.out.println("El numero 5 ha salido: "+contador5);
				System.out.println("El numero 6 ha salido: "+contador6);
				System.out.println("---------------------------------");
				
				//Fin PrintRes
				
				//LeerReiniciarInicio
				do
				{
				System.out.println("Desea volver a tirar el dado? Y/N");
				iniciar = Character.toLowerCase(teclado.next().charAt(0));
				}
				while (iniciar != 'n' && iniciar !='y');
				//Fin LeerReiniciarInicio
				
			}//Fin_Mientras
		//Fin
	}//Fin_main
}//Fin_pp
