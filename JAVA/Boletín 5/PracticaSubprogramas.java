/* Nombre del programa: PracticaSubprogramas
 * Análisis: Un programa que imprima un menu y cada opción del menú sea un subprograma. 
 * Los subprogramas son los del ejercicio 1 del boletín 5.
 * Entradas: Opción menu
 * Salidas: mensajes
 * Restricciones: 
 * 
 * 
 * P.G. 
 * 
 * Inicio
 * LeerValidariniciar
 * Mientras QuieraIniciar
 * 		PrintMenuLeerValidarOpcion
 * 		si (opcion != 0)
 * 			segun (opcion)
 * 				caso 1: Linea
 * 				caso 2: Par
 * 				caso 3: MinMay
 * 				caso 4: AnnoBisiesto
 * 				caso 5:
 * 				caso 6:
 * 				caso 7: Alfabeto
 * 				caso 8:
 * 				caso 9:
 * 				caso 10:
 * 				caso 11:
 * 				caso 12: EcuacionSegundoGrado
 * 			fin_segun
 * 		fin_si
 * 		LeerValidarReiniciar
 * Fin_mientras
 * Fin
 */
 
 //Inicio
 
 import java.util.Scanner;
 public class PracticaSubprogramas {
	 
/* Prototipo: void Linea (char caracter, int entero)
 * Breve comentario de lo que realiza: Subprograma que teniendo como parámetros un carácter y un número, imprima una línea con tantas veces el carácter como indique el número. 
 * Precondiciones: el entero es mayor que 0
 * Entradas: 1 char y  1 entero
 * Salidas: Nada
 * Entradas/Salidas: Nada
 * Postcondiciones: Ninguna
*/

	public static void Linea (int numero, char caracter)
	{
		/*for (int contador; contador < numero; contador++)
		{
			System.out.println(caracter);
		}
		* NO FUNCIONA
		*/
		
		System.out.println("Llamada al metodo Linea en construccion: ");
		System.out.println ("Parametros:"+ numero+", "+caracter);
	}
//Fin subprograma Linea


/*	Prototipo: boolean Par (int numero)
 * 	Breve comentario de lo que realiza: 
 * 	Precondiciones: Ninguna
 * 	Entradas: entero
 * 	Salidas: lógico
 * 	Entradas/Salidas: Nada
 * 	Postcondiciones: VERDAD si el número es par y FALSO si no lo es.
 */
 
	public static boolean Par (int numero)
	{
		boolean resultado;
		if (numero%2 == 0)
		{
			resultado = true;
		}
		else
		{
			resultado = false;
		}
		return (resultado);
	}
//Fin subprograma Par

/*	Prototipo: char MinMay (char caracter)
 * 	Breve comentario de lo que realiza: 
 * 	Precondiciones: Un carácter en minúsculas 
 * 	Entradas: carácter 
 * 	Salidas: carácter  (Asignado nombre)
 *	Entradas/Salidas: carácter 
 *	Postcondiciones: Un carácter en mayúscula 
 */

	public static char MinMay (char caracter)
	{
		char caracter2 = ' ';
		caracter2 = Character.toUpperCase(caracter);
		return caracter2;
	}
//Fin subprograma MinMay


/*	Prototipo: boolean AnnoBisiesto (int numero)
 * 	Breve comentario de lo que realiza: 
 * 	Precondiciones: Ninguna
 * 	Entradas: entero
 *  Salidas: lógico (Asignado nombre)
 * 	Entradas/Salidas: Nada
 * 	Postcondiciones: VERDAD si el número es bisiesto y FALSO si no lo es.
 */
 
	public static boolean AnnoBisiesto(int numero)
	{
		boolean resultado = false;
		
		if ((numero%4 == 0) && (numero%100 != 0))
		{
			resultado = true;
		}
		return resultado;
	}
//Fin subprograma AnnoBisiesto

/*	Prototipo: boolean Alfabeto (char caracter)
 * 	Breve comentario de lo que realiza: 
 * 	Precondiciones: Ninguna
 * 	Entradas: carácter 
 * 	Salidas: lógico (Asignado a nombre)
 * 	Entradas/Salidas: Nada
 * 	Postcondiciones: VERDAD si el carácter pertenece al alfabeto español y FALSO sino.
 */

	public static boolean Alfabeto (char caracter)
	{
		boolean resultado = false;
		System.out.println("Llamada al metodo Alfabeto: ");
		return resultado;
	}
//Fin subprograma Alfabeto

/*	Prototipo: void EcuacionSegundoGrado (real1, real2, real3, resultado1, resultado2)
 * 	Breve comentario de lo que realiza: 
 * 	Precondiciones: El primer valor debe ser mayor o igual que cero
 * 	Entradas: tres reales
 * 	Salidas: dos reales (Por referencia)
 * 	Entradas/Salidas: Dos reales 
 * 	Postcondiciones: real  resultado1 y real resultado2
 */
	
	//No se cómo hacer que devuelva un resultado por referencia.
 
 //Fin subprograma EcuacionSegundoGrado

	 public static void main (String[]args){
		 Scanner teclado = new Scanner (System.in);
		 char iniciar = ' ';
		 int opcion;
		 
		 
		//LeerValidariniciar
		do
		{
			System.out.println("Desea ejecutar el programa? Y/N");
			iniciar = Character.toLowerCase (teclado.next().charAt(0));
		}
		while (iniciar != 'y' && iniciar != 'n');
		//Fin LeerValidarIniciar
		
		/* Mientras QuieraIniciar) */
		while (iniciar == 'y')
		{
				//PrintMenuLeerValidarOpcion
				do
				{
					System.out.println("----------------------------------Menu--------------------------------");
					System.out.println("---------------------------1. Imprimir linea--------------------------");
					System.out.println("--------------------2. Calcular si el numero es par-------------------");
					System.out.println("------------------3. Pasar de minusculas a mayusculas-----------------");
					System.out.println("-------------------4. Calcular si un anno es bisiesto------------------");
					System.out.println("--------------------------5. [EN CONSTRUCCION]------------------------");
					System.out.println("--------------------------6. [EN CONSTRUCCION]------------------------");
					System.out.println("----------7. Calcular si el caracter es del alfabeto espanol----------");
					System.out.println("--------------------------8. [EN CONSTRUCCION]------------------------");
					System.out.println("--------------------------9. [EN CONSTRUCCION]------------------------");
					System.out.println("-------------------------10. [EN CONSTRUCCION]------------------------");
					System.out.println("-------------------------11. [EN CONSTRUCCION]------------------------");
					System.out.println("----------------12. Calcular ecuacion de segundo grado----------------");
					System.out.println("--------------------------0. Salir del menu---------------------------");
					System.out.println("----------------------------------------------------------------------");
					opcion = teclado.nextInt();
				}
				while (opcion < 0 || opcion > 12);
				//Fin PrintMenuLeerValidarOpcion
				
				//si (opcion != 0)
				if (opcion != 0)
				{
				
					//segun (opcion)
					switch (opcion)
					{
					
						//caso 1: Linea
						case 1:
						
							int numeroLinea;
							char caracterLinea = ' ';
							
							do
							{
								System.out.println("Introduzca un numero positivo");
								numeroLinea = teclado.nextInt();
							}
							while (numeroLinea <= 0);
							
							System.out.println("Introduzca un caracter");
							caracterLinea = teclado.next().charAt(0);
							
							Linea (numeroLinea, caracterLinea);
						
						break;
						//fin caso 1
						
						//caso 2: Par
						case 2:
						
							boolean resultadoPar;
							int numeroPar;
							
							System.out.println("Introduzca el numero deseado");
							numeroPar = teclado.nextInt();
							
							resultadoPar = Par (numeroPar);
							
							if (resultadoPar == true)
							{
								System.out.println("El numero es par");
							}
							else
							{
								System.out.println("El numero es impar");
							}
						
						break;
						//fin caso 2
						
						//caso 3: MinMay
						case 3:
						
						char resultadoMinMay = ' ';
						char caracterMinMay = ' ';
						
						do
						{
							System.out.println("Introduzca un caracter en minusculas");
							caracterMinMay = teclado.next().charAt(0);
						}
						while (caracterMinMay < 'a' || caracterMinMay > 'z');
						
						resultadoMinMay = MinMay (caracterMinMay);
						
						System.out.println("----");
						System.out.println(resultadoMinMay);
						System.out.println("----");
						
						break;
						//fin caso 3
						
						//caso 4: AnnoBisiesto
						case 4:
						
						int numeroAnnoBisiesto;
						boolean resultadoAnnoBisiesto = false;
						
						System.out.println("Introduzca un anno");
						numeroAnnoBisiesto = teclado.nextInt();
						
						resultadoAnnoBisiesto = AnnoBisiesto (numeroAnnoBisiesto);
						
						if (resultadoAnnoBisiesto == true)
							{
								System.out.println("El anno es bisiesto");
							}
							else
							{
								System.out.println("El anno no es bisiesto");
							}
							
						break;
						//fin caso 4
						
						//caso 5:
						case 5:
						System.out.println("[EN CONSTRUCCION]");
						break;
						//fin caso 5
						
						//caso 6:
						case 6:
						System.out.println("[EN CONSTRUCCION]");
						break;
						//fin caso 6
						
						//caso 7: Alfabeto
						case 7:
						boolean resultadoAlfabeto;
						resultadoAlfabeto = Alfabeto ('c');
						System.out.println(resultadoAlfabeto);
						break;
						//fin caso 7
						
						//caso 8:
						case 8:
						System.out.println("[EN CONSTRUCCION]");
						break;
						//fin caso 8
						
						//caso 9:
						case 9:
						System.out.println("[EN CONSTRUCCION]");
						break;
						//fin caso 9
						
						//caso 10:
						case 10:
						System.out.println("[EN CONSTRUCCION]");
						break;
						//fin caso 10
						
						//caso 11:
						case 11:
						System.out.println("[EN CONSTRUCCION]");
						break;
						//fin caso 11
						
						//caso 12: EcuacionSegundoGrado
						case 12:
						System.out.println("[EN CONSTRUCCION]");
						break;
						//fin caso 12
						
					}//fin_segun
					
				}//fin_si
				
				//LeerValidarReiniciar
				do
				{
					System.out.println("Desea volver a ejecutar el programa? Y/N");
					iniciar = Character.toLowerCase (teclado.next().charAt(0));
				}
				while (iniciar != 'y' && iniciar != 'n');
				//Fin LeerValidarReiniciar
				
		}//Fin_mientras
 
	 }//fin_main
 }//fin_pp
 
 //Fin
