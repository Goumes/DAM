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
 * 				caso 3: minMay
 * 				caso 4: annoBisiesto
 * 				caso 5: digitoHex
 * 				caso 6:
 * 				caso 7: Alfabeto
 * 				caso 8:
 * 				caso 9:
 * 				caso 10:
 * 				caso 11:
 * 				caso 12: ecuacionSegundoGrado
 * 			fin_segun
 * 		fin_si
 * 		LeerValidarReiniciar
 * Fin_mientras
 * Fin
 * 
 * Modulo: Linea
 * 
 * Inicio
 * 	LeerValidarNumero
 * 	LeerCaracter
 * 	PintarLinea
 * Fin
 * 
 * 
 * Modulo: Par
 * 
 * Inicio
 * 	LeerNumero
 * 	CalcularPar
 * 	PrintRes
 * Fin
 * 
 * 
 * Modulo: minMay
 * 
 * Inicio
 * 	LeerValidarCaracter
 * 	PasarMinusculas
 * 	PrintRes
 * Fin
 * 
 * 
 * Modulo: AnnoBisiesto
 * 
 * Inicio
 * 	LeerValidarAño
 * 	CalcularBisiesto
 * 	PrintRes
 * Fin
 * 
 * 
 * Modulo: digitoHex
 * 
 * Inicio
 * 	LeerCaracter
 * 	CalcularHex
 * 	PrintRes
 * Fin
 * 
 * 
 * Modulo: Alfabeto
 * 
 * Inicio
 * 	LeerCaracter
 * 	CalcularAlfabeto
 * 	PrintRes
 * Fin
 * 
 * 
 * Modulo: ecuacionSegundoGrado
 * 
 * Inicio
 * 	LeerValidarCoeficientes
 * 	CalcularEcuacionPrintRes
 * Fin
 */
 
 //Inicio
 
 import java.util.Scanner;
 public class PracticaSubprogramas {	 

/*	Prototipo: char MinMay (char caracter)
 * 	Breve comentario de lo que realiza: 
 * 	Precondiciones: Un carácter en minúsculas 
 * 	Entradas: carácter 
 * 	Salidas: carácter  (Asignado nombre)
 *	Entradas/Salidas: carácter 
 *	Postcondiciones: Un carácter en mayúscula 
 * 
 * 
 * Resguardo: public static char MinMay (char caracter)
 * {
 *  	System.out.println("Llamada al método MinMay");
 * 		System.out.println("Variables: "+caracter);
 * }
 */

	public static char MinMay (char caracter)
	{
		char resultado = ' ';
		resultado = Character.toUpperCase(caracter);
		return resultado;
	}
//Fin subprograma MinMay


/*	Prototipo: boolean AnnoBisiesto (int numero)
 * 	Breve comentario de lo que realiza: 
 * 	Precondiciones: Ninguna
 * 	Entradas: entero
 *  Salidas: lógico (Asignado nombre)
 * 	Entradas/Salidas: Nada
 * 	Postcondiciones: VERDAD si el número es bisiesto y FALSO si no lo es.
 * 
 * 
 * Resguardo: public static boolean AnnoBisiesto (int numero)
 * {
 *  	System.out.println("Llamada al método AnnoBisiesto");
 * 		System.out.println("Variables: "+numero);
 * }
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


/*	Prototipo: boolean digitoHex (char caracter)
 * 	Breve comentario de lo que realiza: Subprograma DigitoHex que diga si un carácter es un dígito hexadecimal
 * 	Precondiciones: 
 * 	Entradas: char caracter
 * 	Salidas: boolean
 * 	Entradas/Salidas:
 * 	Postcondiciones: verdad si el carácter es hexadecimal, y falso si no lo es.
 * 
 * 
 * Resguardo: public static boolean digitoHex (char caracter)
 * {
 *  	System.out.println("Llamada al método digitoHex");
 * 		System.out.println("Variables: "+caracter);
 * }
 */
	public static boolean digitoHex (char caracter)
	{
		boolean resultado = false;
		if ((caracter >= '0' && caracter <= '9') || (caracter >= 'a' && caracter <= 'f'))
		{
			resultado = true;
		}
		return (resultado);
	}
	 
//Fin subprograma DigitoHex


/*	Prototipo: boolean Alfabeto (char caracter)
 * 	Breve comentario de lo que realiza: 
 * 	Precondiciones: Ninguna
 * 	Entradas: carácter 
 * 	Salidas: lógico (Asignado a nombre)
 * 	Entradas/Salidas: Nada
 * 	Postcondiciones: VERDAD si el carácter pertenece al alfabeto español y FALSO sino.
 * 
 * 
 * Resguardo: public static boolean Alfabeto (char caracter)
 * {
 *  	System.out.println("Llamada al método Alfabeto");
 * 		System.out.println("Variables: "+caracter);
 * }
 */

	public static boolean Alfabeto (char caracter)
	{
		boolean resultado = false;
		
		if ((caracter >= 'a' && caracter <= 'z') || (caracter >= 'A' && caracter <= 'Z'))
		{
				resultado = true;
		}
		return resultado;
	}
//Fin subprograma Alfabeto

/*	Prototipo: void EcuacionSegundoGrado (real1, real2, real3, resultado1, resultado2)
 * 	Breve comentario de lo que realiza: Resuelve una ecuación de segundo grado.
 * 	Precondiciones: El primer valor debe ser mayor o igual que cero
 * 	Entradas: tres reales
 * 	Salidas: dos reales (Por referencia)
 * 	Entradas/Salidas: Dos reales 
 * 	Postcondiciones: real  resultado1 y real resultado2
 * 
 * 
 * (Como no podemos hacer todavía salida una salida múltiple en java, lo haré con prints)
 * 
 * Prototipo: void EcuacionSegundoGrado (real1, real2, real3)
 * 	Breve comentario de lo que realiza: Resuelve una ecuación de segundo grado.
 * 	Precondiciones: El primer valor debe ser distinto que cero
 * 	Entradas: tres reales
 * 	Salidas: nada
 * 	Entradas/Salidas: nada
 * 	Postcondiciones:
 * 
 * 
 * 
 * Resguardo: void ecuacionSegundoGrado (double numero1, double numero2, double numero3)
 * {
 *  	System.out.println("Llamada al método ecuacionSegundoGrado");
 * 		System.out.println("Variables: "+numero1+", "+numero2+", "+numero3);
 * }
 */
	
	public static void ecuacionSegundoGrado (double numero1, double numero2, double numero3)
	{
		double resultado1;
		double resultado2; 
		
		if (numero2*numero2-(4*numero1*numero3)>= 0)
			{
				resultado1 = (-(numero2) + Math.pow(numero2*numero2-(4*numero1*numero3),0.5))/(2*numero1);
				resultado2 = (-(numero2) - Math.pow(numero2*numero2-(4*numero1*numero3),0.5))/(2*numero1);
				System.out.println ("x1= "+resultado1);
				System.out.println ("x2= "+resultado2);
			}
		else
			{
				System.out.println ("Esta ecuaci\u00f3n no se puede calcular");
			}
	}
 
 //Fin subprograma EcuacionSegundoGrado

	 public static void main (String[]args){
		Scanner teclado = new Scanner (System.in);
		char iniciar = ' ';
		int opcion;
		int numeroLinea;
		char caracterLinea = ' ';
		boolean resultadoPar;
		int numeroPar;
		char resultadoMinMay = ' ';
		char caracterMinMay = ' ';
		int numeroAnnoBisiesto;
		boolean resultadoAnnoBisiesto;
		char caracterHex = ' ';
		boolean resultadoHex;
		boolean resultadoAlfabeto;
		char caracterAlfabeto = ' ';
		double numeroEcuacion1;
		double numeroEcuacion2;
		double numeroEcuacion3;
		 
	
		
		
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
					System.out.println("----------------------------------Men\u00fa--------------------------------");
					System.out.println("---------------------------1. Imprimir linea--------------------------");
					System.out.println("--------------------2. Calcular si el n\u00famero es par-------------------");
					System.out.println("------------------3. Pasar de min\u00fasculas a may\u00fasculas-----------------");
					System.out.println("------------------4. Calcular si un a\u00f1o es bisiesto-------------------");
					System.out.println("----------5. Calcular si un car\u00e1cter es un n\u00famero hexadecimal---------");
					System.out.println("--------------------------6. [EN CONSTRUCCION]------------------------");
					System.out.println("----------7. Calcular si el c\u00e1racter es del alfabeto espa\u00f1ol----------");
					System.out.println("--------------------------8. [EN CONSTRUCCION]------------------------");
					System.out.println("--------------------------9. [EN CONSTRUCCION]------------------------");
					System.out.println("-------------------------10. [EN CONSTRUCCION]------------------------");
					System.out.println("-------------------------11. [EN CONSTRUCCION]------------------------");
					System.out.println("----------------12. Calcular ecuaci\u00f3n de segundo grado----------------");
					System.out.println("--------------------------0. Salir del men\u00fa---------------------------");
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
						
							//LeerValidarNumero
							do
							{
							System.out.println("Introduzca un n\u00famero positivo");
							numeroLinea = teclado.nextInt();
							}
							while (numeroLinea <= 0);
							//Fin LeerValidarNumero
							
							//LeerCaracter
							System.out.println("Introduzca un car\u00e1cter");
							caracterLinea = teclado.next().charAt(0);
							//LeerCaracter
							
							//PrintLinea
							MetodosPracticaSubprogramas.Linea (numeroLinea, caracterLinea);
							//Fin PrintLinea
						
						break;
						//fin caso 1
						
						//caso 2: Par
						case 2:
							
							//LeerNumero
							System.out.println("Introduzca el n\u00famero deseado");
							numeroPar = teclado.nextInt();
							//Fin LeerNumero
							
							//CalcularPar
							resultadoPar = MetodosPracticaSubprogramas.Par (numeroPar);
							//Fin CalcularPar
							
							//PrintRes
							if (resultadoPar == true)
							{
								System.out.println("El n\u00famero es par");
							}
							else
							{
								System.out.println("El n\u00famero es impar");
							}
							//Fin PrintRes
						
						break;
						//fin caso 2
						
						//caso 3: MinMay
						case 3:
						
							//LeerValidarCaracter
							do
							{
								System.out.println("Introduzca un car\u00e1cter en min\u00fasculas");
								caracterMinMay = teclado.next().charAt(0);
							}
							while (caracterMinMay < 'a' || caracterMinMay > 'z');
							//Fin LeerValidarCaracter
							
							//PasarMinusculas
							resultadoMinMay = MinMay (caracterMinMay);
							//Fin PasarMinusculas
							
							//PrintRes
							System.out.println("----");
							System.out.println(resultadoMinMay);
							System.out.println("----");
							//Fin PrintRes
						
						break;
						//fin caso 3
						
						//caso 4: AnnoBisiesto
						case 4:
						
							//LeerValidarAño
							System.out.println("Introduzca un a\u00f1o");
							numeroAnnoBisiesto = teclado.nextInt();
							//Fin LeerValidarAño
							
							//CalcularBisiesto
							resultadoAnnoBisiesto = AnnoBisiesto (numeroAnnoBisiesto);
							//Fin CalcularBisiesto
							
							//PrintRes
							if (resultadoAnnoBisiesto == true)
								{
									System.out.println("El a\u00f1o es bisiesto");
								}
								else
								{
									System.out.println("El a\u00f1o no es bisiesto");
								}
							//Fin PrintRes
						
						break;
						//fin caso 4
						
						//caso 5:
						case 5:
						
							//LeerCaracter
							System.out.println("Introduzca un caracter");
							caracterHex = teclado.next().charAt(0);
							//Fin LeerCaracter
							
							//CalcularHex
							resultadoHex = digitoHex (caracterHex);
							//CalcularHex
							
							//PrintRes
							if (resultadoHex == true)
							{
								System.out.println("El caracter es un n\u00famero hexadecimal");
							}
							else
							{
								System.out.println("El caracter no es un n\u00famero hexadecimal");
							}
							//Fin Print Res
							
						break;
						//fin caso 5
						
						//caso 6:
						case 6:
						System.out.println("[EN CONSTRUCCION]");
						break;
						//fin caso 6
						
						//caso 7: Alfabeto
						case 7:
						
						//LeerCaracter
						System.out.println("Introduzca el caracter deseado");
						caracterAlfabeto = teclado.next().charAt(0);
						//Fin LeerCaracter
						
						//CalcularAlfabeto
						resultadoAlfabeto = Alfabeto (caracterAlfabeto);
						//Fin CalcularAlfabeto
						
						//PrintRes
						if (resultadoAlfabeto == true)
						{
							System.out.println("El caracter pertenece al alfabeto espa\u00f1ol");
						}
						else
						{
							System.out.println("El caracter no pertenece al alfabeto espa\u00f1ol");
						}
						//Fin PrintRes
						
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
						
						//LeerValidarCoeficientes
						do
						{
						System.out.println("Introduzca el primer coeficiente. Ojo, debe ser distinto de 0.");
						numeroEcuacion1 = teclado.nextInt();
						}
						while (numeroEcuacion1 == 0);
						
						System.out.println("Introduzca el segundo coeficiente");
						numeroEcuacion2 = teclado.nextInt();
						System.out.println("Introduzca el tercer coeficiente");
						numeroEcuacion3 = teclado.nextInt();
						//Fin LeerValidarCoeficientes
						
						//CalcularEcuacionPrintRes
						ecuacionSegundoGrado (numeroEcuacion1, numeroEcuacion2, numeroEcuacion3);
						//Fin CalcularEcuacionPrintRes
						
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
