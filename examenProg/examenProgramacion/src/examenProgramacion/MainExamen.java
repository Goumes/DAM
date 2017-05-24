package examenProgramacion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/* Nombre del programa: examenProgramacion
 * Breve comentario: Programa gestor de un almacén de pantallas
 * Entradas: Menus y parametros de los subprogramas que lo requieran
 * Salidas: Ninguna
 * Restricciones: Ninguna
 * 
 * P.G
 * Inicio
 * 	LeerValidarEjecutar
 * 	Mientras QuieraEjecutar
 * 		PrintMenuLeerValidarOpcion
 * 		Mientras OpcionDistinta0
 * 			segun (opcion)
 * 				caso 1: Menu impresion
 * 				caso 2: Menu calculos
 * 				caso 3: Menu gestion
 * 			Fin_segun
 * 			PrintMenuLeerValidarOpcion
 * 			Fin_Mientras2
 * 		LeerValidarVolverEjecutar
 * 	Fin_Mientras
 * Fin
 * 
 * P.G Nivel 1 Caso 1
 * 
 * Inicio
 * 	PrintMenuImpresionLeerValidarOpcion
 * 	Mientras OpcionValida
 * 		segun (opcion)
 * 			caso 1: Imprimir listado pantallas de un fabricante *
 * 			caso 2: Imprimir listado pantallas  con fecha posterior a elegida *
 * 			caso 3: Imprimir en pantalla el total en euros de las pantallas en el almacen *
 * 		fin_segun
 * 		PrintMenuImpresionLeerValidarOpcion
 * 	Fin Mientras
 * Fin
 * 
 *  * P.G Nivel 1 Caso 2
 * 
 * Inicio
 * 	PrintMenuCalculosLeerValidarOpcion
 * 	Mientras OpcionValida
 * 		segun (opcion)
 * 			caso 1: Total pantallas LED
 * 			caso 2: Total pantallas LCD
 * 			caso 3: Total pantallas OLED
 * 		fin_segun
 * 		PrintMenuCalculosLeerValidarOpcion
 * 	Fin Mientras
 * Fin
 * 
 *  * P.G Nivel 1 Caso 3
 * 
 * Inicio
 * 	PrintMenuGestionLeerValidarOpcion
 * 	Mientras OpcionValida
 * 		segun (opcion)
 * 			caso 1: Añadir pantalla
 * 			caso 2: Borrar pantalla
 * 		fin_segun
 * 		PrintMenuGestionLeerValidarOpcion
 * 	Fin Mientras
 * Fin
 */

public class MainExamen 
{
	/* Prototipo: void menuPrincipal ()
	 * Breve comentario: menu principal
	 * Precondiciones: Ninguna
	 * Entradas: Ninguna
	 * Salidas: Ninguna
	 * Entradas/Salidas: Ninguna
	 * Postcondiciones: Ninguna
	 * 
	 * Resguardo: public void menuPrincipal ()
		{
			System.out.println("Llamada al metodo menuPrincipal");
		}
	 */
	public static void menuPrincipal ()
	{
		System.out.println();
		System.out.println("Menu principal");
		System.out.println();
		System.out.println("1. Menu Impresión");
		System.out.println("2. Menu Cálculos");
		System.out.println("3. Menu Gestión");
		System.out.println("0. Salir");
		System.out.println();
		
	}
	//Fin menuPrincipal
	
	/* Prototipo: void menuImpresion ()
	 * Breve comentario: menu Impresion
	 * Precondiciones: Ninguna
	 * Entradas: Ninguna
	 * Salidas: Ninguna
	 * Entradas/Salidas: Ninguna
	 * Postcondiciones: Ninguna
	 * 
	 * Resguardo: public void menuImpresion ()
		{
			System.out.println("Llamada al metodo menuImpresion");
		}
	 */
	public static void menuImpresion ()
	{
		System.out.println();
		System.out.println("Menu Impresion");
		System.out.println();
		System.out.println("1. Imprimir el listado de pantallas de un mismo fabricante");
		System.out.println("2. Imprimir el listado de pantallas con fecha posterior a la elegida");
		System.out.println("3. Imprimir el montante total de todas las pantallas del almacén");
		System.out.println("0. Salir");
		System.out.println();
		
	}
	//Fin menuImpresion
	
	/* Prototipo: void menuCalculos ()
	 * Breve comentario: menu Calculos
	 * Precondiciones: Ninguna
	 * Entradas: Ninguna
	 * Salidas: Ninguna
	 * Entradas/Salidas: Ninguna
	 * Postcondiciones: Ninguna
	 * 
	 * Resguardo: public void menuCalculos ()
		{
			System.out.println("Llamada al metodo menuCalculos");
		}
	 */
	public static void menuCalculos ()
	{
		System.out.println();
		System.out.println("Menu Calculos");
		System.out.println();
		System.out.println("1. Imprimir el total de pantallas LED");
		System.out.println("2. Imprimir el total de pantallas LCD");
		System.out.println("3. Imprimir el total de pantallas OLED");
		System.out.println("0. Salir");
		System.out.println();
		
	}
	//Fin menuCalculos
	
	/* Prototipo: void menuGestion ()
	 * Breve comentario: menu Gestion
	 * Precondiciones: Ninguna
	 * Entradas: Ninguna
	 * Salidas: Ninguna
	 * Entradas/Salidas: Ninguna
	 * Postcondiciones: Ninguna
	 * 
	 * Resguardo: public void menuGestion ()
		{
			System.out.println("Llamada al metodo menuGestion");
		}
	 */
	public static void menuGestion ()
	{
		System.out.println();
		System.out.println("Menu Gestion");
		System.out.println();
		System.out.println("1. Añadir una pantalla");
		System.out.println("2. Borrar una pantalla");
		System.out.println("0. Salir");
		System.out.println();
		
	}
	//Fin menuGestion
	
	public static void main (String [] args)
	{
		GestoraExamen gestora = new GestoraExamen ();
		Scanner teclado = new Scanner (System.in);
		BufferedReader tecladoString = new BufferedReader (new InputStreamReader (System.in));
		char ejecutar = ' ';
		int opcion = 0;
		int opcionImpresion = 0;
		int opcionCalculos = 0;
		int opcionGestion = 0;
		String fabricante = null;
		Fecha fecha = new Fecha ();
		Pantalla pantalla = null;
		int numeroSerie = 0;
		
		
		//LeerValidarEjecutar
		do
		{
			System.out.println("Desea ejecutar el programa? S/N");
			ejecutar = Character.toLowerCase(teclado.next().charAt(0));
		}
		while (ejecutar != 's' && ejecutar != 'n');
		//Fin LeerValidarEjecutar
		
		while (ejecutar == 's')
		{
			//PrintMenuLeerValidarOpcion
			do
			{
				MainExamen.menuPrincipal();
				opcion = teclado.nextInt();
			}
			while (opcion < 0 || opcion > 3);
			//Fin PrintMenuLeerValidarOpcion
			
			
			while (opcion != 0)
			{
				switch (opcion)
				{
					case 1:
						//PrintMenuImpresionLeerValidarOpcion
						do
						{
							MainExamen.menuImpresion();
							opcionImpresion = teclado.nextInt();
						}
						while (opcionImpresion < 0 || opcionImpresion > 3);
						//Fin PrintMenuImpresionLeerValidarOpcion
							

							while (opcionImpresion != 0)
							{
								switch (opcionImpresion)
								{
									case 1:
										
										do
										{
											try
											{
												System.out.println("Introduzca el nombre del fabricante a listar");
												fabricante = tecladoString.readLine ();
											}
											catch (IOException e)
											{
												System.out.println(e);
											}

										}
										while (fabricante.equals(null) && fabricante.equals(""));
										
										gestora.listarPantallasFabricante(fabricante);
										
									break;
									
									case 2:
										do
										{
											try
											{
												System.out.println("Introduzca el dia de la fecha deseada");
												fecha.setDia(teclado.nextInt());
											}
											
											catch (ExamenException e)
											{
												System.out.println(e);
											}
										}
										while (fecha.getDia() < 1 && fecha.getDia() > 31);
										
										do
										{
											try
											{
												System.out.println("Introduzca el mes de la fecha deseada");
												fecha.setMes(teclado.nextInt());
											}
											
											catch (ExamenException e)
											{
												System.out.println(e);
											
											}
										}
										while (fecha.getMes() < 1 && fecha.getMes() > 12);
										
										do
										{
											System.out.println("Introduzca el año de la fecha deseada");
											fecha.setAnio(teclado.nextInt());
										}
										while (fecha.getAnio() < 0);
										
										gestora.listarPantallasFecha(fecha);
										
									break;
									
									case 3:
										gestora.listarMontante();
									break;
								}//fin_segun
								
								//PrintMenuImpresionLeerValidarOpcion
								do
								{
									MainExamen.menuImpresion();
									opcionImpresion = teclado.nextInt();
								}
								while (opcionImpresion < 0 || opcionImpresion > 3);
								//Fin PrintMenuImpresionLeerValidarOpcion
							}//Fin Mientras
					break;
					
					case 2:
						//PrintMenuCalculosLeerValidarOpcion
						do
						{
							MainExamen.menuCalculos();
							opcionCalculos = teclado.nextInt();
						}
						while (opcionCalculos < 0 || opcionCalculos > 3);
						//Fin PrintMenuCalculosLeerValidarOpcion
							

							while (opcionCalculos != 0)
							{
								switch (opcionCalculos)
								{
									case 1: 
										System.out.println("El total de pantallas LED es: " + gestora.totalPantallasLed());
									break;
									
									case 2:
										System.out.println("El total de pantallas LCD es: " + gestora.totalPantallasLcd());
									break;
									
									case 3:
										System.out.println("El total de pantallas OLED es: " + gestora.totalPantallasOled());
									break;
								}//fin_segun
								
								//PrintMenuCalculosLeerValidarOpcion
								do
								{
									MainExamen.menuCalculos();
									opcionCalculos = teclado.nextInt();
								}
								while (opcionCalculos < 0 || opcionCalculos > 3);
								//Fin PrintMenuCalculosLeerValidarOpcion
							}//Fin Mientras
					break;
					
					case 3:
						//PrintMenuGestionLeerValidarOpcion
						do
						{
							MainExamen.menuGestion();
							opcionGestion = teclado.nextInt();
						}
						while (opcionGestion < 0 || opcionGestion > 3);
						//Fin PrintMenuGestionLeerValidarOpcion
							

							while (opcionGestion != 0)
							{
								switch (opcionGestion)
								{
									case 1: 
										pantalla = gestora.crearPantalla ();
										gestora.addPantalla(pantalla);
									break;
									
									case 2:
										do
										{
											System.out.println("Introduzca el numero de serie de la pantalla");
											numeroSerie = teclado.nextInt();
										}
										while (numeroSerie < 0);
										
										gestora.borrarPantalla(numeroSerie);
									break;
								}//fin_segun
								
								//PrintMenuGestionLeerValidarOpcion
								do
								{
									MainExamen.menuGestion();
									opcionGestion = teclado.nextInt();
								}
								while (opcionGestion < 0 || opcionGestion > 3);
								//Fin PrintMenuGestionLeerValidarOpcion
							}//Fin Mientras
					break;
				}//Fin_segun
				
				///PrintMenuLeerValidarOpcion
				do
				{
					MainExamen.menuPrincipal();
					opcion = teclado.nextInt();
				}
				while (opcion < 0 || opcion > 3);
				//Fin PrintMenuLeerValidarOpcion
				
			}//Fin_Mientras2
			
			//LeerValidarVolverEjecutar
			do
			{
				System.out.println("Desea volver a ejecutar el programa? S/N");
				ejecutar = Character.toLowerCase(teclado.next().charAt(0));
			}
			while (ejecutar != 's' && ejecutar != 'n');
			//Fin LeerValidarVolverEjecutar
			
		}//Fin_Mientras
	}//Fin main
}//Fin clase
