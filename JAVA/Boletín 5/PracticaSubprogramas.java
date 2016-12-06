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
 * 				caso 6: Distancia
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
 * 	PintarLinea *
 * Fin
 * 
 * 
 * Modulo: Par
 * 
 * Inicio
 * 	LeerNumero
 * 	CalcularPar *
 * 	PrintRes
 * Fin
 * 
 * 
 * Modulo: minMay
 * 
 * Inicio
 * 	LeerValidarCaracter
 * 	PasarMinusculas *
 * 	PrintRes
 * Fin
 * 
 * 
 * Modulo: AnnoBisiesto
 * 
 * Inicio
 * 	LeerValidarAño
 * 	CalcularBisiesto * 
 * 	PrintRes
 * Fin
 * 
 * 
 * Modulo: digitoHex
 * 
 * Inicio
 * 	LeerCaracter
 * 	CalcularHex * 
 * 	PrintRes
 * Fin
 * 
 * 
 * Modulo: Distancia
 * 
 * Inicio
 * 	LeerCoordenadas
 * 	CalcularDistanciaPrintRes *
 * Fin
 * 
 * Modulo: Alfabeto
 * 
 * Inicio
 * 	LeerCaracter
 * 	CalcularAlfabeto *
 * 	PrintRes
 * Fin
 * 
 * 
 * Modulo: Compuesto
 * 
 * Inicio
 * 	LeerValidarNumero
 * 	CalcularCompuesto *
 * 	PrintRes
 * Fin
 * 
 * Modulo: ecuacionSegundoGrado
 * 
 * Inicio
 * 	LeerValidarCoeficientes
 * 	CalcularEcuacionPrintRes +
 * Fin
 */
 
 //Inicio
 
 import java.util.Scanner;
 public class PracticaSubprogramas {	 
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
		double Coordenada1;
		double Coordenada2;
		double Coordenada3;
		double Coordenada4;
		char caracterHex = ' ';
		boolean resultadoHex;
		boolean resultadoAlfabeto;
		char caracterAlfabeto = ' ';
		double unidad;
		char medidaConversor = ' ';
		double numeroCompuesto;
		boolean resultadoCompuesto;
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
					System.out.println("-------6. Calcular la distancia entre dos puntos de un plano----------");
					System.out.println("----------7. Calcular si el c\u00e1racter es del alfabeto espa\u00f1ol----------");
					System.out.println("------------8. Convertir hectareas y areas a metros cuadrados---------");
					System.out.println("------------------9. Calcular si un numero es compuesto---------------");
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
							resultadoMinMay = MetodosPracticaSubprogramas.MinMay (caracterMinMay);
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
							resultadoAnnoBisiesto = MetodosPracticaSubprogramas.AnnoBisiesto (numeroAnnoBisiesto);
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
							resultadoHex = MetodosPracticaSubprogramas.digitoHex (caracterHex);
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
						
						//LeerCoordenadas
						System.out.println("Introduzca la primera coordenada del primer punto");
						Coordenada1 = teclado.nextDouble();
						System.out.println("Introduzca la segunda coordenada del primer punto");
						Coordenada2 = teclado.nextDouble();
						System.out.println("Introduzca la primera coordenada del segundo punto");
						Coordenada3 = teclado.nextDouble();
						System.out.println("Introduzca la segunda coordenada del segundo punto");
						Coordenada4 = teclado.nextDouble();
						//Fin LeerCoordenadas
						
						//CalcularDistanciaPrintRes
						MetodosPracticaSubprogramas.Distancia (Coordenada1, Coordenada2, Coordenada3, Coordenada4);
						//Fin CalcularDistanciaPrintRes
						
						break;
						//fin caso 6
						
						//caso 7: Alfabeto
						case 7:
						
						//LeerCaracter
						System.out.println("Introduzca el caracter deseado");
						caracterAlfabeto = teclado.next().charAt(0);
						//Fin LeerCaracter
						
						//CalcularAlfabeto
						resultadoAlfabeto = MetodosPracticaSubprogramas.Alfabeto (caracterAlfabeto);
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
						
						//LeerValidarTipo
						do
						{
						System.out.println("Desea introducir la medida en hectareas o en areas? H/A");
						medidaConversor = Character.toLowerCase (teclado.next().charAt(0));
						}
						while (medidaConversor != 'h' && medidaConversor != 'a');	
						//Fin LeerValidarTipo
						
						//LeerValidarUnidad
						System.out.println("Introduzca la medida");
						if (medidaConversor == 'h')
						{
							unidad = (teclado.nextDouble() * 100);
						}
						else
						{
							unidad = teclado.nextDouble();
						}
						//Fin LeerValidarUnidad
						
						//ConvertirMedida
						MetodosPracticaSubprogramas.conversorMedidas (unidad);
						//Fin ConvertirMedida
						
						//PrintRes
						System.out.println("El resultado de la conversion es: "+unidad+" metros cuadrados");
						//Fin PrintRes
						
						break;
						//fin caso 8
						
						//caso 9:
						case 9:
						
						//LeerValidarNumero
						System.out.println("Introduzca el numero que desee saber si es compuesto");
						numeroCompuesto = teclado.nextDouble();
						//Fin LeerValidarNumero
						
						//CalcularCompuesto
						resultadoCompuesto = MetodosPracticaSubprogramas.Compuesto (numeroCompuesto);
						//Fin CalcularCompuesto
						
						//PrintRes
						if (resultadoCompuesto == true)
						{
							System.out.println("El numero es compuesto");
						}
						else
						{
							System.out.println("El numero no es compuesto");
						}
						//Fin PrintRes
						
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
						MetodosPracticaSubprogramas.ecuacionSegundoGrado (numeroEcuacion1, numeroEcuacion2, numeroEcuacion3);
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
