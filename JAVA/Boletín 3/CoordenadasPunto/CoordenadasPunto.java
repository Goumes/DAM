/* Nombre del programa: CoordenadasPunto
 * Análisis: Diseñar un algoritmo que lea de teclado las coordenadas cartesinas de un punto en el plano y calcule e imprima 
 * el cuadrante al que pertenece dicho punto (sin considerar los ejes de coordenadas).
 * Una coordenada no pertenence a ningún cuadrante si cualquier de las dos son igual a 0.
 * Utilizar cuatro estructuras de selección simples independientes.
 * Entradas: coordenadas
 * Salidas: cuadrante
 * Restricciones:
 * 
 * P.G
 *
 * Inicio
 * Leer y validar inicio
 * Mientras QuieraEjecutar
 * 	LeerCoordenadas
 * 	CalcularCuadrantePrintRes
 * Fin_mientras
 * Fin
 * 
 */
 
 //Inicio
 import java.util.Scanner;
 public class CoordenadasPunto{
	 public static void main (String[] args){
		double x;
		double y;
		char iniciar=' ';
		Scanner teclado = new Scanner (System.in);
		//Leer y validar iniciar
		while ( iniciar != 'y' && iniciar != 'n')
		{
		System.out.println("Desea ejecutar el programa? Y/N");
		iniciar = Character.toLowerCase(teclado.next().charAt(0));
		}
		//Fin Leer y validar iniciar
		
		//Mientras QuieraEjecutar
		while (iniciar == 'y')
		{
		//Fin Mientras QuieraEjecutar
		
		//LeerDatos
		System.out.println("Introduzca el valor de la X");
		x = teclado.nextDouble();
		System.out.println("Introduzca el valor de la Y");
		y = teclado.nextDouble();
		//Fin LeerDatos
		
		//CalcularCuadrantePrintRes
		if ( x != 0 && y != 0)
		{
			if (x > 0 && y > 0)
			{
				System.out.println ("Estas coordenadas pertenencen al primer cuadrante.");
			}
			else
			{
				if (x >0 && y < 0)
				{
					System.out.println("Estas coordenadas pertenencen al cuarto cuadrante.");
				}
				else
				{
					if (x < 0 && y > 0)
					{
						System.out.println("Estas coordenadas pertenencen al segundo cuadrante.");
					}
					else
					{
							System.out.println("Estas coordenadas pertenecen al tercer cuadrante.");
					}
				}
			}
		}
		else
		{
			if (x == 0 && y == 0)
			{
					System.out.println ("Estas coordenadas pertenecen al Origen de Coordenadas.");
			}
			else
			{
				if (x == 0)
				{
					System.out.println("Estas coordenadas pertenecen al eje Y, no a un cuadrante.");
				}
				else
				{
						System.out.println("Estas coordenadas pertenecen al eje X, no a un cuadrante.");
				}
			}
		}
		//Fin CalcularCuadrantePrintRes
		
		//Desea volver a ejecutar el programa?
		while ( iniciar != 'y' && iniciar != 'n')
		{
		System.out.println("Desea ejecutar el programa? Y/N");
		iniciar = Character.toLowerCase(teclado.next().charAt(0));
		}
		//Fin Desea volver a ejectuar el programa?
		
		}//fin_mientras
	 }//fin_main
 }//fin_pp
 //Fin
