package Main;

import Clases.*;
import Gestoras.GestoraAleatoria;
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
 * 	Jugar
 * 	GuardarPartida *
 * 	PrintEstadoPartida *
 * Fin
 * 
 * Modulo EligePartida Nivel 1
 * Inicio
 * 	PrintPartidasDisponibles *
 * 	LeerValidarElegirPartida *
 * Fin
 * 
 * Modulo Jugar Nivel 1
 * Inicio
 * 	PrintMenuLeerValidarAcciones
 * 	Mientras Accion != 0
 * 		Segun (accion)
 * 			Caso 1: Abrir cofre
 * 			Caso 2: Ir tienda
 * 			Caso 3: Pelear
 * 			Caso 4: Avanzar
 * 			Caso 5: Abrir Inventario
 * 			Caso 6: Ver mapa
 * 		Fin_segun
 *		PrintMenuLeerValidarAcciones
 * 	Fin_Mientras
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
		System.out.println("Selecciona una partida:");
		
		if (partida1.equals(new Partida (new Mazmorra (), new JugadorIMPL ())))
		{
			System.out.println("Partida 1: Crear nueva partida");
		}
		else
		{
			System.out.println("Partida 1: ");
			partida1.imprimirJugador ();
		}
		
		if (partida2.equals(new Partida (new Mazmorra (), new JugadorIMPL ())))
		{
			System.out.println("Partida 2: Crear nueva partida");
		}
		
		else
		{
			System.out.println("Partida 2: ");
			partida2.imprimirJugador();
		}
		
		if (partida3.equals(new Partida (new Mazmorra (), new JugadorIMPL ())))
		{
			System.out.println("Partida 3: Crear nueva partida");
		}
		
		else
		{
			System.out.println("Partida 3: ");
			partida3.imprimirJugador ();
		}
	}
	//Fin printPartidas
	
	/* Prototipo: void menuAcciones ()
	 * Breve comentario: Menu de acciones del programa.
	 * Precondiciones: Ninguna
	 * Entradas: Ninguna
	 * Salidas: Ninguna
	 * Entradas/Salidas: Ninguna
	 * Postcondiciones: Ninguna
	 * 
	 * Resguardo: public void menuAcciones ()
		{
			System.out.println("Llamada al metodo menuAcciones");
		}
	 */
	public static void menuAcciones ()
	{
		System.out.println();
		System.out.println("Esta es tu interfaz de acciones. Selecciona una opción.");
		System.out.println("1. Abrir cofre");
		System.out.println("2. Ir a tienda");
		System.out.println("3. Pelear");
		System.out.println("4. Avanzar");
		System.out.println("5. Abrir inventario");
		System.out.println("6. Ver mapa");
		System.out.println("0. Guardar y salir");
	}
	//Fin menuAcciones
	
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
		GestoraAleatoria gestoraAleatoria = new GestoraAleatoria ();
		int accion = 0;
		
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
				if (partidaDefinitiva.equals(new Partida (new Mazmorra (), new JugadorIMPL ())))
				{
				
					//GenerarMazmorra *
					partidaDefinitiva.setMazmorra(gestoraAleatoria.generarMazmorraAleatoria ());
					//Fin GenerarMazmorra
					
					//CrearPersonaje *
					partidaDefinitiva.setJugador(gestora.crearJugador());
					//Fin CrearPersonaje
					
					//GuardarPartida *
					gestora.guardarPartida(partidaDefinitiva.getMazmorra (), partidaDefinitiva.getJugador (), numeroPartida);
					//Fin GuardarPartida
				
				}//fin_si
				
				//Jugar 
				
				// PrintMenuLeerValidarAcciones
				do
				{
					menuAcciones ();
					accion = teclado.nextInt();
				}
				while (accion < 0 || accion > 6);
				//Fin PrintMenuLeerValidarAcciones
				
				while (accion != 0)
				{
				
					switch (accion)
					{
						// Caso 1: Abrir cofre
						case 1:
							gestora.abrirCofre (partidaDefinitiva);
						break;
						// Caso 2: Ir tienda
						case 2:
						break;
						// Caso 3: Pelear
						case 3:
						break;
						// Caso 4: Avanzar
						case 4:
						break;
						// Caso 5: Abrir Inventario
						case 5:
							//gestora.abrirInventario (partidaDefinitiva);
						break;
						// Caso 6: Ver mapa
						case 6:
							partidaDefinitiva.getMazmorra ().printMazmorra ();
						break;
					}// Fin_segun
					
					// PrintMenuLeerValidarAcciones
					do
					{
						menuAcciones ();
						accion = teclado.nextInt();
					}
					while (accion < 0 || accion > 6);
					//Fin PrintMenuLeerValidarAcciones
					
				}// Fin_Mientras
				
				//Fin Jugar
				
				//GuardarPartida *
				gestora.guardarPartida(partidaDefinitiva.getMazmorra (), partidaDefinitiva.getJugador (), numeroPartida);
				//Fin GuardarPartida
				
				//PrintEstadoPartida *
				System.out.println("Este es el estado de tu partida actual:");
				System.out.println();
				partidaDefinitiva.imprimirJugador();
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