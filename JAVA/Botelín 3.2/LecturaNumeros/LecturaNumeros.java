/* Nombre del programa: LecturaNumeros
 * Análisis: Leer de teclado una serie de caracteres hasta que aparezca '*'. ¿Cuántos se han leído?
 * Entrada: numeros
 * Salida: numeros leidos
 * Restricciones: El programa debe salir cuando se introduzca '*'.
 * 
 * P.G.
 * 
 * Inicio
 * LeerValidarIniciar
 * Mientras QuieraIniciar
	* LeerValidarContarCaracteres
	* PrintRes
	* LeerValidarReiniciar
 * Fin Mientras QuieraIniciar
 * Fin 
*/

//Inicio
import java.util.Scanner;
public class LecturaNumeros{
	public static void main (String[]args){
		char caracter;
		char iniciar = ' ';
		int resultado = ' ';
		Scanner teclado = new Scanner (System.in);
		
		//LeerValidarIniciar
		do
		{
			System.out.println("------------------------------------------------------");
			System.out.println("Desea iniciar el programa? Y/N");
			System.out.println("------------------------------------------------------");
			iniciar = Character.toLowerCase(teclado.next().charAt(0));
		}
		while (iniciar != 'y' && iniciar != 'n');
		//Fin LeerValidarIniciar
		
		//Mientras QuieraIniciar
		while (iniciar == 'y')
		{
			int contador = 0;
			//LeerValidarContarCaracteres
			do
			{
				System.out.println("------------------------------------------------------");
				System.out.println("Introduzca un car\u00e1cter. Para parar introduzca '*'");
				System.out.println("------------------------------------------------------");
				caracter = teclado.next().charAt(0);
				contador++;
			}
			while(caracter != '*');
			resultado = contador - 1;
			//Fin LeerValidarContarCaracteres
			
			//PrintRes
			System.out.println("------------------------------------------------------");
			System.out.println("Numero de caracteres: "+resultado);
			System.out.println("------------------------------------------------------");
			//Fin PrintRes
			
			//LeerValidarReiniciar
			do
			{
			System.out.println("------------------------------------------------------");
			System.out.println("Desea reiniciar el programa? Y/N");
			System.out.println("------------------------------------------------------");
			iniciar = Character.toLowerCase(teclado.next().charAt(0));
			}
			while (iniciar != 'y' && iniciar != 'n');
			//Fin LeerValidarReiniciar
			
			
		}//Fin Mientras QuieraIniciar
	}//Fin_main
}//Fin_pp
