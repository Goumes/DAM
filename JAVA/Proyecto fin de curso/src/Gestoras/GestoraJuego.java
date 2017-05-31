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
	 * Postcondiciones: Una partida dependiendo de la selección recibida por parámetros
	 * 
	 * Resguardo:	public Partida leerPartida (int numero)
	 * {
	 * 		System.out.println("Llamada al metodo leerpartida");
	 * }
	 */
	public Partida leerPartida (int numero)
	{
		File partidas = new File ("./src/Archivos/partidas.dat");
		Partida partida = null;
		ObjectInputStream ois = null;
		int contador = 1;
		Partida resultado = null;
		
		try
		{
			ois = new ObjectInputStream (new FileInputStream (partidas))
			{
				@Override protected void readStreamHeader () {}
			};
			
			partida = (Partida) ois.readObject();
			
			while (!partida.equals(null) && resultado.equals(null))
			{
				if (contador == numero)
				{
					resultado = partida.clone();
				}
				
				partida = (Partida) ois.readObject ();
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
			System.out.println("EOFException");
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
		
		return partida;
	}
	//Fin leerPartida
	
	/* Prototipo: Partida asignarPartida (Partida partida1, Partida partida2, Partida partida3, int numero)
	 * Breve comentario: Metodo dedicado a la asignación de una partida a la partida definitiva a utilizar en el main.
	 * Precondiciones: Ninguna
	 * Entradas: Tres partidas y un entero
	 * Salidas: Una Partida
	 * Entradas/Salidas: Ninguna
	 * Postcondiciones: Una partida en función de la partida definitiva indicada
	 * 
	 * Resguardo: public Partida asignarPartida (Partida partida1, Partida partida2, Partida partida3, int numero)
	 * {
	 * 		System.out.println("Llamada al metodo asignarPartida");
	 * }
	 */
	public Partida asignarPartida (Partida partida1, Partida partida2, Partida partida3, int numero)
	{
		Partida partidaDefinitiva = null;
		
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
	public void guardarPartida (Mazmorra mazmorra, Jugador jugador)
	{
		File partidas = new File ("./src/Archivos/partidas.dat");
		Partida partida = null;
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