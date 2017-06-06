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
			
			oos.writeObject(new ArmaIMPL ("Hacha estándar", 70, 300)); 
			oos.writeObject(new ArmaIMPL ("Hacha de combate", 150, 500)); 
			oos.writeObject(new ArmaIMPL ("RotChopper", 300, 1000)); //Cortador de putrefacción (??????????????????????)
			oos.writeObject(new ArmaIMPL ("Arco estándar", 50, 200)); 
			oos.writeObject(new ArmaIMPL ("Arco de la federación", 100, 400)); 
			oos.writeObject(new ArmaIMPL ("Pertinax", 250, 800)); //El nombre de un tio
			oos.writeObject(new ArmaIMPL ("Mandoble estándar", 60, 250)); 
			oos.writeObject(new ArmaIMPL ("Frenzyedge", 150, 500));	//Filo del frenesí
			oos.writeObject(new ArmaIMPL ("Woecleaver", 700, 2000)); //Cuchillo del dolor fuerte o algo así yo que se Jarana me dio estos nombres y yo los traduzco
			oos.writeObject(new ArmaIMPL ("Bastón estándar", 40, 100)); 
			oos.writeObject(new ArmaIMPL ("Tuskrender", 170, 600)); //Generador de colmillos
			oos.writeObject(new ArmaIMPL ("Bastón del guardián", 600, 1500)); 
			oos.writeObject(new ArmaIMPL ("Acero armenio pa los barcos", 9999, 5000)); //Este puño es capaz de destruir de un golpe a cualquier enemigo del juego
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
