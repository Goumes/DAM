package Gestoras;
import java.io.*;
import java.util.*;
import Clases.*;

public class GestoraJuego 
{
	/* Protipo: Partida leerPartida (int numero)
	 * Breve comentario: Subprograma dedicado a leer una partida del fichero
	 * Precondiciones: Ninguna
	 * Entradas: Un entero indicando el numero de partida deseado
	 * Salidas: Una partida
	 * Entradas/Salidas: Ninguna
	 * Postcondiciones: Una partida dependiendo de la selecci�n recibida por par�metros
	 * 
	 * Resguardo:	public Partida leerPartida (int numero)
	 * {
	 * 		System.out.println("Llamada al metodo leerpartida");
	 * }
	 */
	public PartidaIMPL leerPartida (int numero)
	{
		File partidas = new File ("./src/Archivos/partidas.dat");
		PartidaIMPL partida = null;
		ObjectInputStream ois = null;
		int contador = 1;
		PartidaIMPL resultado = null;
		
		try
		{
			ois = new ObjectInputStream (new FileInputStream (partidas))
			{
				@Override protected void readStreamHeader () {}
			};
			
			partida = (PartidaIMPL) ois.readObject();
			
			while (!partida.equals(null))
			{
				if (contador == numero)
				{
					resultado = partida.clone();
				}
				
				partida = (PartidaIMPL) ois.readObject ();
				contador++;
			}
		}
		
		catch (FileNotFoundException e)
		{
			System.out.println("FileNotFoundException");
		}
		
		catch (ClassNotFoundException e)
		{
			System.out.println("ClassNotFoundException");
		}
		
		catch (EOFException e)
		{
			
		}
		
		catch (IOException e)
		{
			System.out.println("IOException");
		}
		
		finally
		{
			if (ois != null)
			{
				try
				{
					ois.close();
				}
				
				catch (IOException e)
				{
					System.out.println("IOException close");
				}
			}
		}
		
		return resultado;
	}
	//Fin leerPartida
	
	/* Prototipo: Partida asignarPartida (Partida partida1, Partida partida2, Partida partida3, int numero)
	 * Breve comentario: Metodo dedicado a la asignaci�n de una partida a la partida definitiva a utilizar en el main.
	 * Precondiciones: Ninguna
	 * Entradas: Tres partidas y un entero
	 * Salidas: Una Partida
	 * Entradas/Salidas: Ninguna
	 * Postcondiciones: Una partida en funci�n de la partida definitiva indicada
	 * 
	 * Resguardo: public Partida asignarPartida (Partida partida1, Partida partida2, Partida partida3, int numero)
	 * {
	 * 		System.out.println("Llamada al metodo asignarPartida");
	 * }
	 */
	public PartidaIMPL asignarPartida (PartidaIMPL partida1, PartidaIMPL partida2, PartidaIMPL partida3, int numero)
	{
		PartidaIMPL partidaDefinitiva = null;
		
		switch (numero)
		{
			case 1:
				partidaDefinitiva = partida1;
			break;
				
			case 2:
				partidaDefinitiva = partida2;
			break;
				
			case 3:
				partidaDefinitiva = partida3;
			break;
		}
		
		return partidaDefinitiva;
	}
	//fin asignarPartida
	
	/* Prototipo: Partida guardarpartida (Mazmorra mazmorra, Jugador jugador)
	 * Breve comentario: Metodo dedicado a guardar una partida
	 * Precondiciones: Ninguna
	 * Entradas: Un Jugador y una Mazmorra
	 * Salidas: Ninguna
	 * Entradas/Salidas: Ninguna
	 * Postcondiciones: Ninguna
	 * 
	 * Resguardo:
	 */
	public void guardarPartida (MazmorraIMPL mazmorra, JugadorIMPL jugador)
	{
		File partidas = new File ("./src/Archivos/partidas.dat");
		PartidaIMPL partida = null;
		ObjectOutputStream oos = null;
		
		try
		{
			oos = new ObjectOutputStream (new FileOutputStream (partidas, true))
			{
				@Override protected void writeStreamHeader () {}
			};
			
			oos.writeObject(partida);
		}
		
		catch (FileNotFoundException e)
		{
			System.out.println("FileNotFoundException");
		}
		
		catch (EOFException e)
		{
			System.out.println("EOFException");
		}
		
		catch (IOException e)
		{
			System.out.println("IOException");
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
					System.out.println("IOException close");
				}
			}
		}
	}
	//Fin crearPartida
}