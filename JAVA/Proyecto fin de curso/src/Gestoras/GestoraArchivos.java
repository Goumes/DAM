package Gestoras;

import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

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
		GestoraAleatoria gestora = new GestoraAleatoria ();
		ArrayList <ObjetoIMPL> partida2 = new ArrayList <ObjetoIMPL> ();
		ArrayList <ObjetoIMPL> partida3 = new ArrayList <ObjetoIMPL> ();
		
		try
		{
			oos = new ObjectOutputStream (new FileOutputStream (partidas))
			{
				@Override protected void writeStreamHeader () {}
			};
			partida2.add(gestora.itemAleatorio ());
			partida2.add(gestora.itemAleatorio ());
			partida2.add(gestora.armaAleatoria ());
			partida2.add(gestora.itemAleatorio ());
			partida3.add(gestora.itemAleatorio ());
			partida3.add(gestora.itemAleatorio ());
			partida3.add(gestora.armaAleatoria ());
			partida3.add(gestora.itemAleatorio ());
			
			oos.writeObject(new Partida (new Mazmorra (), new JugadorIMPL ()));
			oos.writeObject(new Partida (gestora.generarMazmorraAleatoria(), new JugadorIMPL ("pepejava", 450, 10, 10,new ItemIMPL (), new ArmaIMPL (), 100,partida2)));
			oos.writeObject(new Partida (gestora.generarMazmorraAleatoria(), new JugadorIMPL ("XnoScoperX", 550, 12, 12,new ItemIMPL (), new ArmaIMPL (), 100, partida3 )));
			

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
			
			oos.writeObject (new ItemIMPL ("Pocion de vida", 20, 0, 0, 25, false, "Una poción que cura 25 de vida"));
			oos.writeObject (new ItemIMPL ("Pocion de ataque", 100, 20, 0, 0, true, "Una poción que aumenta el ataque 20 puntos durante un combate"));
			oos.writeObject (new ItemIMPL ("Pocion de defensa", 100, 0, 20, 0, true, "Una poción que aumenta la defensa 20 puntos durante un combate"));
			oos.writeObject (new ItemIMPL ("Casco de hierro", 70, 0, 20, 0, false, "Un casco de hierro que aumenta la defensa en 20 puntos"));
			oos.writeObject (new ItemIMPL ("Peto de hierro", 150, 0, 40, 0, false, "Un peto de hierro que aumenta la defensa en 40 puntos"));
			oos.writeObject (new ItemIMPL ("Pocion de vida +", 150, 0, 0, 200, false, "Una poción que cura 200 de vida"));
			oos.writeObject (new ItemIMPL ("Pocion de ataque +", 200, 50, 0, 0, true, "Una poción que aumenta el ataque 50 puntos durante un combate"));
			oos.writeObject (new ItemIMPL ("Pocion de defensa +", 200, 0, 50, 0, true, "Una poción que aumenta la defensa 50 puntos durante un combate"));
			oos.writeObject (new ItemIMPL ("Casco de acero pa los barcos", 500, 0, 100, 0, false, "Un casco de acero pa los barcos que aumenta la defensa en 100 puntos"));
			oos.writeObject (new ItemIMPL ("Peto de acero pa los barcos", 700, 0, 150, 0, false, "Un peto de acero pa los barcos que aumenta la defensa en 150 puntos"));
			oos.writeObject (new ItemIMPL ("Casco divino", 1000, 0, 300, 0, false, "Un casco hecho por lo dioses que aumenta la defensa en 300 puntos"));
			oos.writeObject (new ItemIMPL ("Peto divino", 1200, 0, 350, 0, false, "Un peto hecho por los dioses que aumenta la defensa en 350 puntos"));
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
		GestoraAleatoria gestora = new GestoraAleatoria ();
		
		try
		{
			oos = new ObjectOutputStream (new FileOutputStream (enemigos))
			{
				@Override protected void writeStreamHeader () {}
			};
			
			oos.writeObject(new EnemigoIMPL ("Guilliedhu", 30, 30, 10, gestora.itemAleatorio (), 20, 1, false)); 
			oos.writeObject(new EnemigoIMPL ("Dientes de sable", 50, 20, 15, gestora.itemAleatorio (), 50, 1, false)); 
			oos.writeObject(new EnemigoIMPL ("Disco segador", 20, 60, 0, gestora.itemAleatorio (), 30, 1, false)); 
			oos.writeObject(new EnemigoIMPL ("Dakurion", 200, 50, 30, gestora.itemAleatorio (), 200, 1, true)); 
			oos.writeObject(new EnemigoIMPL ("Basilisk", 50, 20, 20, gestora.itemAleatorio (), 70, 2, false)); 
			oos.writeObject(new EnemigoIMPL ("Kalkhazka", 100, 40, 30, gestora.itemAleatorio (), 100, 2, false)); 
			oos.writeObject(new EnemigoIMPL ("Jabalí ciclao", 40, 100, 0, gestora.itemAleatorio (), 80, 2, false)); 
			oos.writeObject(new EnemigoIMPL ("Bankayas", 400, 80, 40, gestora.itemAleatorio (), 500, 2, true)); 
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
