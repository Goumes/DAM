package Main;

import Clases.*;
import Gestoras.GestoraJuego;

import java.util.*;
import java.io.*;

/* Nombre del programa: MainJuego
 * Breve comentario: Juego roge-like y con combate por turnos
 * Entradas: 
 * Salidas: 
 * Restricciones: Ninguna
 * 
 * OBLIGATORIO HACERLO CON FICHEROS Y CON BADAT.
 * 
 * PG.
 * Inicio
 * 	LeerValidarJugar
 * 	Mientras QuieraJugar
 * 		LeerPartidas *
 * 		PrintElegirPartidas *
 *		EjecutarJuego
 *		Preguntar JugarOtraVez
 * 	Fin_Mientras QuieraJugar        
 * Fin
 * 
 * Modulo EjecutarJuego Nivel 1
 * Inicio
 * 	si Partida no creada
 *		GenerarMazmorra *
 *		CrearPersonaje *
 *		GuardarPartida *
 * 	fin_si
 * 	CargarPartida *
 * 	Jugar *
 * 	GuardarPartida *
 * 	PrintEstadoPartida *
 * Fin
 * 
 * Modulo EligePartida Nivel 1
 * Inicio
 * 	PrintPartidasDisponibles *
 * 	LeerValidarElegirPartida *
 * Fin
 */

public class MainJuego 
{
	/* Prototipo: void printPartidas (Partida partida1, Partida partida2, Partida partida3)
	 * Breve comentario: Subprograma dedicado
	 * Precondiciones: Ninguna
	 * Entradas: Tres partidas
	 * Salidas: Ninguna
	 * Entradas/Salidas: Ninguna
	 * Postcondiciones: Ninguna
	 * 
	 * Resguardo: public void printPartidas (Partida partida1, Partida partida2, Partida partida3)
		{
			System.out.println("Llamada al metodo printPartidas");
		}
	 */
	public static void printPartidas (Partida partida1, Partida partida2, Partida partida3)
	{
		System.out.println("Seleccione una partida:");
		System.out.println("Partida 1: "+partida1.toString());
		System.out.println("Partida 2: "+partida2.toString());
		System.out.println("Partida 3: "+partida3.toString ());
	}
	//Fin printPartidas
	
	public static void main (String [] args)
	{
		Scanner teclado = new Scanner (System.in);
		char ejecutar = ' ';
		int numeroPartida = 0;
		Partida partida1 = new Partida ();
		Partida partida2 = new Partida ();
		Partida partida3 = new Partida ();
		Partida partidaDefinitiva = new Partida ();
		GestoraJuego gestora = new GestoraJuego ();
		
		//LeerValidarJugar
		do
		{
			System.out.println("Desea jugar a 'UnknownName'? S/N");
			ejecutar = Character.toLowerCase(teclado.next().charAt(0));
		}
		while (ejecutar != 's' && ejecutar != 'n');
		//Fin LeerValidarJugar
		
		while (ejecutar == 's')
		{
		
			//LeerPartidas
			partida1 = gestora.leerPartida (1);
			partida2 = gestora.leerPartida (2);
			partida3 = gestora.leerPartida (3);
			//Fin LeerPartidas
			
			//PrintElegirPartidas
			do
			{
				MainJuego.printPartidas (partida1, partida2, partida3);
				numeroPartida = teclado.nextInt();
			}
			while (numeroPartida < 0 || numeroPartida > 3);
			
			partidaDefinitiva = gestora.asignarPartida (partida1, partida2, partida3, numeroPartida);
			//Fin PrintElegirPartidas
		
			//EjecutarJuego
			
				//si Partida no creada
				if (partidaDefinitiva.equals(null))
				{
				
					//GenerarMazmorra *
					//Fin GenerarMazmorra
					
					//CrearPersonaje *
					//Fin CrearPersonaje
					
					//GuardarPartida *
					//Fin GuardarPartida
				
				}//fin_si
				
				//CargarPartida *
				//Fin CargarPartida
				
				//Jugar *
				//Fin Jugar
				
				//GuardarPartida *
				//Fin GuardarPartida
				
				//PrintEstadoPartida *
				//Fin PrintEstadoPartida
			
			//Fin EjecutarJuego
		
			//Preguntar JugarOtraVez
			do
			{
				System.out.println("Desea volver a jugar a 'UnknownName'? S/N");
				ejecutar = Character.toLowerCase(teclado.next().charAt(0));
			}
			while (ejecutar != 's' && ejecutar != 'n');
			//Fin Preguntar JugarOtraVez
		
		}//Fin_Mientras QuieraJugar
	}//Fin_Main
}//Fin_Clase