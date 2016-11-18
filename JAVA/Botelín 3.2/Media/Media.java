/*Nombre programa: Media
 * Análisis: Hallar el menor, mayor y la media de "n" números positivos leídos de teclado.
 * Entrada: numeros
 * Salida: menor, mayor, media.
 * Restricciones: Los números deben ser positivos. No consideramos 0 como número positivo.
 * Estudio de los bucles: 
 * Bucle 1. 'Iniciar' tipo centinela, condición de salida = 'n'.
 * Bucle 2. 'Introducir' tipo centinela, condición de salida = 'n'.
 * Bucles 3, 4, 5 y 6. Tipo centinela.
	* Bucle 3. 'LeerValidarIniciar' condición de salida = 'y' || 'n'.
	* Bucle 4. 'LeerValidarNumeros' condición de salida = numero > 0.
	* Bucle 5. 'LeerValidarVolverIntroducir' condición de salida = 'y' || 'n'.
	* Bucle 6. 'LeerValidarReiniciar' condición de salida = 'y' || 'n'.
 * 
 * P.G.
 * 
 * Inicio
 * LeerValidariniciar
 * Mientras QuieraIniciar
	 * Repetir
		* LeerValidarNumeros
		* HallarMenorMayorMedia
		* LeerValidarVolverIntroducir
	 * Mientras QuieraIntroducir
	 * PrintRes
	 * LeerValidarReiniciar
 * Fin_Mientras
 * Fin
*/

//Inicio
import java.util.Scanner;
public class Media{
	public static void main (String[]args){
		double numero;
		char iniciar =' ';
		char introducir = ' ';
		int contador2 = 0;
		Scanner teclado = new Scanner (System.in);

		//LeerValidarIniciar
		do
		{
			System.out.println("----------------------------------------");
			System.out.println("Desea ejecutar el programa? Y/N");
			System.out.println("----------------------------------------");
			iniciar = Character.toLowerCase(teclado.next().charAt(0));
		}
		while (iniciar != 'y' && iniciar != 'n');
		//Fin LeerValidarIniciar
		
		//Mientras QuieraIniciar
		while (iniciar == 'y')
		{
				double menor = 0;
				double mayor = 0;
				double media = 0;
				double suma = 0;
				int contador = 0;
			//Repetir
			do
			{
				//LeerValidarNumeros
				do
				{
					System.out.println("----------------------------------------");
					System.out.println("Introduzca el n\u00famero deseado");
					System.out.println("----------------------------------------");
					numero = teclado.nextDouble();
					while (numero <= 0)
					{
					System.out.println("----------------------------------------");
					System.out.println("El n\u00famero debe ser positivo, introd\u00fazcalo de nuevo");
					System.out.println("----------------------------------------");
					numero = teclado.nextDouble();
					}
				}
				while (numero <= 0);
				contador++;
				//Fin LeerValidarNumeros
				
				//HallarMenorMayorMedia
				suma = numero + suma;
				media = suma/contador;
				if (menor != 0 && mayor != 0)
				{
						if (numero > mayor)
						{
								mayor = numero;
						}
						if (numero < menor)
						{
								menor = numero;
						}
				}
				else
				{
						menor = numero;
						mayor = numero;
				}
				//Fin HallarMenorMayorMedia

				//LeerValidarVolverIntroducir
				do
				{
				System.out.println("----------------------------------------");
				System.out.println("Desea introducir otro n\u00famero? Y/N");
				System.out.println("----------------------------------------");
				introducir = Character.toLowerCase(teclado.next().charAt(0));
				}
				while (introducir != 'y' && introducir != 'n');
				//Fin LeerValidarVolverIntroducir
				
			}//Mientras QuieraIntroducir
			while (introducir == 'y');

						
			//PrintRes
			System.out.println("----------------------------------------");
			System.out.println("Menor: "+menor);
			System.out.println("----------------------------------------");
			System.out.println("Mayor: "+mayor);
			System.out.println("----------------------------------------");
			System.out.println("Media: "+media);
			//Fin PrintRes
			
			//LeerValidarReiniciar
			do
			{
			System.out.println("----------------------------------------");
			System.out.println("Desea volver a ejecutar el programa? Y/N");
			System.out.println("----------------------------------------");
			iniciar = Character.toLowerCase(teclado.next().charAt(0));
			}
			while (iniciar != 'y' && iniciar != 'n');
			//Fin LeerValidarReiniciar
			
		}//Fin Mientras QuieraIniciar
		}//Fin_Main
	}//Fin_pp
