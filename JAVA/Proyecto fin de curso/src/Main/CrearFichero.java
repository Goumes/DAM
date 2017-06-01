package Main;

import java.util.*;

import Clases.ArmaIMPL;
import Clases.ItemIMPL;
import Clases.JugadorIMPL;
import Clases.Mazmorra;
import Clases.ObjetoIMPL;
import Clases.Partida;
import Exceptions.JuegoException;

import java.io.*;

public class CrearFichero 
{
	/* Prototipo: void crearPartidas ()
	 * Breve comentario: Metodo dedicado a la creación del fichero de partidas.
	 * Precondiciones: Ninguna
	 * Entradas: Ninguna
	 * Salidas: Ninguna
	 * Entradas/Salidas: Ninguna
	 * Postcondiciones: Ninguna
	 * 
	 * Resguardo:
	 */
	public static void crearPartidas ()
	{
		File partidas = new File ("./src/Archivos/partidas.dat");
		ObjectOutputStream oos = null;
		
		try
		{
			oos = new ObjectOutputStream (new FileOutputStream (partidas))
			{
				@Override protected void writeStreamHeader () {}
			};
			
			oos.writeObject(new Partida (new Mazmorra (), new JugadorIMPL ()));
			oos.writeObject(new Partida (new Mazmorra (), new JugadorIMPL ("pepejavaSlayer", 450, 10.0, 10.0,new ItemIMPL (), new ArmaIMPL (), 100, new ObjetoIMPL [] {})));
			oos.writeObject(new Partida (new Mazmorra (), new JugadorIMPL ("XxnoScoper360xX", 550, 12.0, 12.0,new ItemIMPL (), new ArmaIMPL (), 100, new ObjetoIMPL [] {})));
		}
		
		catch (FileNotFoundException e)
		{
			System.out.println(e);
		}
		
		catch (EOFException e)
		{
		}
		
		catch (IOException e)
		{
			System.out.println(e);
		}
		catch (JuegoException e)
		{
			System.out.println(e);
		}
		
		
		finally
		{
			if (oos != null)
			{
				try
				{
					oos.close();
				}
				
				catch (IOException e)
				{
					System.out.println(e);
				}
			}
		}
	}
	//Fin crearPartidas
	
	/* Prototipo: void crearArmas ()
	 * Breve comentario: Metodo dedicado a la creación del fichero de armas.
	 * Precondiciones: Ninguna
	 * Entradas: Ninguna
	 * Salidas: Ninguna
	 * Entradas/Salidas: Ninguna
	 * Postcondiciones: Ninguna
	 * 
	 * Resguardo:
	 */
	public static void crearArmas ()
	{
		File armas = new File ("./src/Archivos/armas.dat");
		ObjectOutputStream oos = null;
		
		try
		{
			oos = new ObjectOutputStream (new FileOutputStream (armas))
			{
				@Override protected void writeStreamHeader () {}
			};
			
			
		}
		
		catch (FileNotFoundException e)
		{
			System.out.println(e);
		}
		
		catch (EOFException e)
		{
		}
		
		catch (IOException e)
		{
			System.out.println(e);
		}
		catch (JuegoException e)
		{
			System.out.println(e);
		}
		
		
		finally
		{
			if (oos != null)
			{
				try
				{
					oos.close();
				}
				
				catch (IOException e)
				{
					System.out.println(e);
				}
			}
		}
	}
	//Fin crearArmas
	
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
	 *		fin_Segun
	 *		ImprimirMenuLeerValidarOpcion
	 *	fin_Mientras
	 * Fin
	 */
	
	
	public static void main (String [] args)
	{
		int opcion = 0;
		Scanner teclado = new Scanner (System.in);
		
		//ImprimirMenuLeerValidarOpcion
		do
		{
			menuCrear();
			opcion = teclado.nextInt();
		}
		while (opcion < 0 || opcion > 1);
		//Fin ImprimirMenuLeerValidarOpcion
		
		while (opcion != 0)
		{
			switch (opcion)
			{
				case 1:
					crearPartidas ();
				break;
			}//Fin_Segun
			
			//ImprimirMenuLeerValidarOpcion
			do
			{
				menuCrear();
				opcion = teclado.nextInt();
			}
			while (opcion < 0 || opcion > 1);
			//Fin ImprimirMenuLeerValidarOpcion
		}//Fin_Mientras
		
	}//fin_main
}
