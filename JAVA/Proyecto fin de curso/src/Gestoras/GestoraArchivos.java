package Gestoras;

import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import Clases.ArmaIMPL;
import Clases.EnemigoIMPL;
import Clases.ItemIMPL;
import Clases.JugadorIMPL;
import Clases.Mazmorra;
import Clases.ObjetoIMPL;
import Clases.Partida;
import Exceptions.JuegoException;

public class GestoraArchivos 
{
	/* Prototipo: void crearPartidas ()
	 * Breve comentario: Metodo dedicado a la creación del fichero de partidas.
	 * Precondiciones: Ninguna
	 * Entradas: Ninguna
	 * Salidas: Ninguna
	 * Entradas/Salidas: Ninguna
	 * Postcondiciones: Ninguna
	 * 
	 * Resguardo: public void crearPartidas ()
	 * {
	 * 		System.out.println("Llamada al metodo crearPartidas");
	 * }
	 */
	public void crearPartidas ()
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
	 * Resguardo: public void crearArmas ()
	 	{
	 		System.out.println("Llamada al metodo crearArmas");
	 	}
	 */
	public void crearArmas ()
	{
		File armas = new File ("./src/Archivos/armas.dat");
		ObjectOutputStream oos = null;
		
		try
		{
			oos = new ObjectOutputStream (new FileOutputStream (armas))
			{
				@Override protected void writeStreamHeader () {}
			};
			
			oos.writeObject(new ArmaIMPL ()); //Aquí va toda la tralla
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
	
	/* Prototipo: void crearItems ()
	 * Breve comentario: Metodo dedicado a la creación del fichero de items.
	 * Precondiciones: Ninguna
	 * Entradas: Ninguna
	 * Salidas: Ninguna
	 * Entradas/Salidas: Ninguna
	 * Postcondiciones: Ninguna
	 * 
	 * Resguardo: public void crearItems ()
	 	{
	 		System.out.println("Llamada al metodo crearItems");
	 	}
	 */
	public void crearItems ()
	{
		File items = new File ("./src/Archivos/items.dat");
		ObjectOutputStream oos = null;
		
		try
		{
			oos = new ObjectOutputStream (new FileOutputStream (items))
			{
				@Override protected void writeStreamHeader () {}
			};
			
			oos.writeObject(new ItemIMPL ()); //Aquí va toda la tralla
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
	//Fin crearItems
	
	/* Prototipo: void crearEnemigos ()
	 * Breve comentario: Metodo dedicado a la creación del fichero de enemigos.
	 * Precondiciones: Ninguna
	 * Entradas: Ninguna
	 * Salidas: Ninguna
	 * Entradas/Salidas: Ninguna
	 * Postcondiciones: Ninguna
	 * 
	 * Resguardo: public void crearEnemigos ()
	 	{
	 		System.out.println("Llamada al metodo crearEnemigos");
	 	}
	 */
	public void crearEnemigos ()
	{
		File enemigos = new File ("./src/Archivos/enemigos.dat");
		ObjectOutputStream oos = null;
		
		try
		{
			oos = new ObjectOutputStream (new FileOutputStream (enemigos))
			{
				@Override protected void writeStreamHeader () {}
			};
			
			oos.writeObject(new EnemigoIMPL ()); //Aquí va toda la tralla
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
	//Fin crearEnemigos
}
