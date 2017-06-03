package Main;

import java.util.*;

import Clases.ArmaIMPL;
import Clases.ItemIMPL;
import Clases.JugadorIMPL;
import Clases.Mazmorra;
import Clases.ObjetoIMPL;
import Clases.Partida;
import Exceptions.JuegoException;
import Gestoras.GestoraArchivos;
import Gestoras.GestoraJuego;

import java.io.*;

public class CrearFichero 
{	
	/* Prototipo: void menuCrear ()
	 * Breve comentario: Menu de crear del programa.
	 * Precondiciones: Ninguna
	 * Entradas: Ninguna
	 * Salidas: Ninguna
	 * Entradas/Salidas: Ninguna
	 * Postcondiciones: Ninguna
	 * 
	 * Resguardo: public void menuCrear ()
		{
			System.out.println("Llamada al metodo menuCrear");
		}
	 */
	public static void menuCrear ()
	{
		System.out.println("Elija que archivo desea crear");
		System.out.println("1. Partidas");
		System.out.println("2. Armas");
		System.out.println("3. Items");
		System.out.println("4. Enemigos");
		System.out.println("0. Salir");
	}
	//Fin menuCrear
	
	/* Nombre del programa: CrearFichero
	 * Breve comentario: Programa dedicado a la creación de ficheros del programa principal del juego
	 * Entradas: Opcion menu
	 * Salidas: Ninguna
	 * Restricciones: Ninguna
	 * 
	 * P.G.
	 * Inicio
	 * 	ImprimirMenuLeerValidarOpcion
	 * 	Mientras Opcion != 0
	 * 		segun (opcion)
	 *			caso 1: Crear partidas
	 *			caso 2: Crear items
	 *			caso 3: Crear armas
	 *			caso 4: Crear enemigos
	 *		fin_Segun
	 *		ImprimirMenuLeerValidarOpcion
	 *	fin_Mientras
	 * Fin
	 */
	
	
	public static void main (String [] args)
	{
		int opcion = 0;
		Scanner teclado = new Scanner (System.in);
		GestoraArchivos gestora = new GestoraArchivos ();
		
		//ImprimirMenuLeerValidarOpcion
		do
		{
			menuCrear();
			opcion = teclado.nextInt();
		}
		while (opcion < 0 || opcion > 4);
		//Fin ImprimirMenuLeerValidarOpcion
		
		while (opcion != 0)
		{
			switch (opcion)
			{
				case 1:
					gestora.crearPartidas ();
				break;
				
				case 2:
					gestora.crearArmas ();
				break;
				
				case 3:
					gestora.crearItems ();
				break;
				
				case 4:
					gestora.crearEnemigos ();
				break;
			}//Fin_Segun
			
			//ImprimirMenuLeerValidarOpcion
			do
			{
				menuCrear();
				opcion = teclado.nextInt();
			}
			while (opcion < 0 || opcion > 4);
			//Fin ImprimirMenuLeerValidarOpcion
		}//Fin_Mientras
		
	}//fin_main
}
