package vestidosJaranasStyle;

import java.util.*;

/* Nombre del programa: ListaVestidosJaranasStyle
 * Entradas: Opciones del programa y datos de vestidos.
 * Salidas: Mensajes
 * Restricciones:
 * 
 * P.G.
 * 
 * Inicio
 * LeerValidarIniciar
 * Mientras QuieraIniciar
 * 		LeerValidarVestido
 * 		LeerValidarEntrarMenu
 * 		Mientras QuieraEntrarMenu
 * 			PrintMenuLeerValidarOpcion *
 * 			Si opcion != 0
 * 				segun (opcion)
 * 					caso 1: Mostrar lista ordenada
 * 					caso 2: Total diseños pedidos
 * 					caso 3: Coste total
 * 				fin_segun
 * 			fin_si
 * 			LeerValidarReiniciar
 * 		Fin_Mientras
 * 		LeerValidarReiniciar
 * Fin_Mientras
 * Fin
 */

public class ListaVestidosJaranasStyle 
{
	/* Prototipo: int Menu ()
	 * Breve comentario: Imprime un menu del programa en cuestion.
	 * Precondiciones: Ninguna
	 * Entradas: Ninguna
	 * Salidas: Un entero
	 * Entradas/Salidas: Ninguna
	 * Postcondiciones: Un entero indicando la opción seleccionada.
	 * 
	 * Resguardo: public static int menu ()
	 * {
	 * 		System.out.println("Llamada al metodo Menu");
	 * 		return -1;
	 * }
	 */
	
	public static int Menu ()
	{
		Scanner teclado = new Scanner (System.in);
		int opcion = 0;
		
		System.out.println("---------------------------------------------------");
		System.out.println("------ Bienvenid@ a vestidos Jarana's Style! ------");
		System.out.println("-------------- Seleccione una opción: -------------");
		System.out.println("--------------- 1. Mostrar la lista ---------------");
		System.out.println("------------ 2. Total diseños pedidos -------------");
		System.out.println("----------------- 3. Coste total ------------------");
		System.out.println("---------------------------------------------------");
		
		opcion = teclado.nextInt ();
		
		return opcion;
	}
	
	public static void main (String [] args)
	{
		//Inicio
		Scanner teclado = new Scanner (System.in);
		int opcion = 0;
		char ejecutar = ' ';
		
			//LeerValidarIniciar
			do
			{
				System.out.println("Desea ejecutar el programa? S/N");
				ejecutar = Character.toLowerCase(teclado.next().charAt(0));
			}
			while (ejecutar != 's' && ejecutar != 'n');
			//Fin LeerValidarIniciar
		
			while (ejecutar == 's')
			{
		
				//LeerValidarVestido
				//Fin LeerValidarVestido
		
		
				//LeerValidarEntrarMenu
				//Fin LeerValidarEntrarMenu
		
		
				//Mientras QuieraEntrarMenu
		
		
					//PrintMenuLeerValidarOpcion
					//Fin PrintMenuLeerValidarOpcion
		
		
					//Si opcion != 0
		
						//segun (opcion)
		
							//caso 1: Mostrar lista ordenada
							//Fin caso 1: Mostrar lista ordenada
		
		
							//caso 2: Total diseños pedidos
							//Fin caso 2: Total diseños pedidos
		
		
							//caso 3: Coste total
							//Fin caso 3: Coste total
		
						//fin_segun
		
					//fin_si
		
					//LeerValidarReiniciar
					//Fin LeerValidarReiniciar
		
		
				//Fin_Mientras
		
		
				//LeerValidarReiniciar
				//Fin LeerValidarReiniciar
		
			}//Fin_Mientras
		
		//Fin
		
	}//fin_main
}//fin_ListaVestidosJaranasStyle
