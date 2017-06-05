package Gestoras;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Random;

import Clases.ArmaIMPL;
import Clases.CofreIMPL;
import Clases.EnemigoIMPL;
import Clases.HabitacionIMPL;
import Clases.ItemIMPL;
import Clases.Mazmorra;
import Clases.TiendaIMPL;
import Exceptions.JuegoException;
import Interfaces.Habitacion;

public class GestoraAleatoria 
{
	/* Prototipo: generarTiendaAleatoria ()
	 * Breve comentario: Metodo dedicado a la generación aleatoria de la tienda
	 * Precondiciones: Ninguna
	 * Entradas: Ninguna
	 * Salidas: Una TiendaIMPL
	 * Entradas/Salidas: Ninguna
	 * Postcondiciones: Una TiendaIMPL generada aleatoriamente
	 * 
	 * Resguardo: public TiendaIMPL generarTiendaAleatoria ()
		{
			System.out.println("Llamada al metodo generarTiendaAleatoria");
		}
	 */
	public TiendaIMPL generarTiendaAleatoria ()
	{
		 ItemIMPL item = null;
		 ArmaIMPL arma = null;
		 int contador = 0;
		 TiendaIMPL tienda = new TiendaIMPL ();
		 
		 while (tienda.getObjeto1().equals(new ItemIMPL ())
				 || tienda.getObjeto2().equals(new ItemIMPL ())
				 || tienda.getObjeto3().equals(new ItemIMPL ()))
		 {
		 
			 item = itemAleatorio ();
			 
			 if (contador == 0)
			 {
				 tienda.setObjeto1(item);
			 }
			 
			 else if (contador == 1)
			 {
				 tienda.setObjeto2(item);
			 }
			 
			 else
			 {
				 tienda.setObjeto3(item);
			 }
			 
			 contador++;
		 }
		 
		 arma = armaAleatoria ();
		 tienda.setObjeto4(arma);
		 
		 return tienda;
	}
	//Fin generarTiendaAleatoria
	
	/* Prototipo: cofreIMPL generarCofreAleatorio ()
	 * Breve comentario: Metodo encargado de generar un cofre aleatorimente
	 * Precondiciones: Ninguna
	 * Entradas: Ninguna
	 * Salidas: Un cofreIMPL
	 * Entradas/Salidas:
	 * Postcondiciones:
	 * 
	 * Resguardo: public CofreIMPL generarCofreAleatorio ()
		{
			System.out.println("Llamada al metodo generarCofreAleatorio");
			return (new CofreIMPL ());
		}
	 */
	public CofreIMPL generarCofreAleatorio ()
	{
		Random aleatorio = new Random ();
		CofreIMPL cofre = new CofreIMPL ();
		ItemIMPL item = null;
		double dinero = 0.0;
		
		dinero = aleatorio.nextDouble() * 20.0;
		
		item = itemAleatorio ();
		
		cofre.setDrop(item);
		cofre.setValor(dinero);
		
		return cofre;
	}
	//Fin generarCofreAleatorio
	
	/* Prototipo: generarHabitacionAleatoria ()
	 * Breve comentario: Metodo dedicado a la generación aleatoria de una habitacion
	 * Precondiciones: Ninguna
	 * Entradas: Ninguna
	 * Salidas: Una HabitacionIMPL
	 * Entradas/Salidas: Ninguna
	 * Postcondiciones: Una HabitacionIMPL generada aleatoriamente
	 * 
	 * Resguardo: public HabitacionIMPL generarHabitacionAleatoria ()
		{
			System.out.println("Llamada al metodo generarHabitacionAleatoria");
			return (new HabitacionIMPL ());
		}
	 */
	public HabitacionIMPL generarHabitacionAleatoria ()
	{
		Random aleatorio = new Random ();
		HabitacionIMPL habitacion = new HabitacionIMPL ();
		TiendaIMPL tienda = new TiendaIMPL ();
		EnemigoIMPL enemigo = new EnemigoIMPL ();
		CofreIMPL cofre = new CofreIMPL ();
		
		if (aleatorio.nextBoolean())
		{
			tienda = generarTiendaAleatoria ();
			habitacion.setShop(tienda);
		}
		
		else if (aleatorio.nextBoolean())
		{
			enemigo = enemigoAleatorio ();
			habitacion.setEnemy(enemigo);
		}
		
		else if (aleatorio.nextBoolean())
		{
			cofre = generarCofreAleatorio ();
			habitacion.setCofreIMPL(cofre);
		}
		
		return habitacion;
	}
	//Fin generarHabitacionAleatoria
	
	
	/* Prototipo: Mazmorra generarMazmorraAleatoria ()
	 * Breve comentario: Metodo dedicado a la generación aleatoria de la mazmorra
	 * Precondiciones: Ninguna
	 * Entradas: Ninguna
	 * Salidas: Una Mazmorra
	 * Entradas/Salidas: Ninguna
	 * Postcondiciones: Una MazmorraIMPL generada aleatoriamente
	 * 
	 * Resguardo: public MazmorraIMPL generarMazmorraAleatoria ()
		{
			System.out.println("Llamada al metodo generarMazmorraAleatoria");
			return (new Mazmorra ());
		}
	 */
	public Mazmorra generarMazmorraAleatoria ()
	{
		Random aleatorio = new Random ();
		 Mazmorra mazmorra = new Mazmorra ();
		 
		 HabitacionIMPL habitacion1 = null;
		 HabitacionIMPL habitacion2 = null;
		 HabitacionIMPL habitacion3 = null;
		 HabitacionIMPL habitacion4 = new HabitacionIMPL ();
		 HabitacionIMPL habitacion5 = new HabitacionIMPL ();
		 HabitacionIMPL habitacion6 = null;
		 HabitacionIMPL habitacion7 = null;
		 HabitacionIMPL habitacion8 = new HabitacionIMPL ();
		 HabitacionIMPL habitacion9 = new HabitacionIMPL ();
		 HabitacionIMPL habitacion10 = null;
		 HabitacionIMPL habitacion11 = null;
		 HabitacionIMPL habitacion12 = null;
		 HabitacionIMPL habitacion13 = null;
		 HabitacionIMPL habitacion14 = new HabitacionIMPL ();
		 HabitacionIMPL habitacion15 = null;
		 HabitacionIMPL habitacion16 = null;
		 HabitacionIMPL habitacion17 = null;
		 HabitacionIMPL habitacion18 = new HabitacionIMPL ();
		 HabitacionIMPL habitacion19 = new HabitacionIMPL ();
		 HabitacionIMPL habitacion20 = new HabitacionIMPL ();
		 HabitacionIMPL habitacion21 = null;
		 HabitacionIMPL habitacion22 = null;
		 HabitacionIMPL habitacion23 = null;
		 HabitacionIMPL habitacion24 = new HabitacionIMPL ();
		 HabitacionIMPL habitacion25 = null;
		 
		 HabitacionIMPL [][] mapa = {
										{habitacion1, habitacion2, habitacion3, habitacion4, habitacion5},
										{habitacion6, habitacion7, habitacion8, habitacion9, habitacion10},
										{habitacion11, habitacion12, habitacion13, habitacion14, habitacion15},
										{habitacion16, habitacion17, habitacion18, habitacion19, habitacion20},
										{habitacion21, habitacion22, habitacion23, habitacion24, habitacion25}
									};
		 
		 /*
		 
	 	habitacion5.setCofreIMPL(new CofreIMPL (3, new ItemIMPL ()));
		habitacion5.setEnemy(new EnemigoIMPL ("Jaranator", 100, 45.0, 25.0, new ItemIMPL (), 10, 3));
		habitacion5.setShop(new TiendaIMPL (new ItemIMPL (), new ItemIMPL (), new ItemIMPL (), new ArmaIMPL (), true));
		habitacion5.setSalida (true);
		
		//habitacion8.setCofreIMPL(new CofreIMPL (3, new ItemIMPL ()));
		habitacion8.setEnemy(new EnemigoIMPL ("Jaranator", 100, 45.0, 25.0, new ItemIMPL (), 10, 3));
		habitacion8.setShop(new TiendaIMPL (new ItemIMPL (), new ItemIMPL (), new ItemIMPL (), new ArmaIMPL (), true));
		//habitacion8.setSalida (true);
		
		habitacion19.setEnemy(new EnemigoIMPL ("Jaranator", 100, 45.0, 25.0, new ItemIMPL (), 10, 3));
		 
		 */
		 
		 backtracking (mapa);
		 
		 try
		 {
			 mazmorra.setMapa(mapa);
		 }
		 catch (JuegoException e)
		 {
			 System.out.println(e);
		 }
		 
		 return mazmorra;
	}
	//Fin generarMazmorraAleatoria
	
	/* Prototipo: int [][] generarEstructuraMazmorra ()
	 * Breve comentario: Metodo dedicado a generar la estructura de las mazmorras de forma recursiva
	 * Precondiciones: Ninguna
	 * Entradas: Ninguna
	 * Salidas: Ninguna
	 * Entradas/Salidas: Un array de HabitacionIMPL
	 * Postcondiciones: Un Array bidimensional de HabitacionIMPL
	 * 
	 * Resguardo: 	public int [][] generarEstructuraMazmorra ()
		{
			System.out.println("Llamada al metodo generarEstructuraMazmorra");
			
			return (new int [][] {});
		}
	 */
	public HabitacionIMPL [][] backtracking (HabitacionIMPL [][] mapa)
	{
		for (int i = 0;)
		{
			
		}
		return mapa;
		/*
		for (int i = 0; i < resultado.length; i++)
		{
			for (int j = 0; j < resultado[0].length; j++)
			{
				if (i == 0 & j == 0)
				{
					resultado[i][j] = 1;
				}
				
				else if (resultado[i + 1][j] == 0
						|| resultado [i - 1][j] == 0
						|| resultado [i][j + 1] == 0
						|| resultado [i][j-1] == 0)
				{
					if (resultado[i + 1][j] == 0)
					{
						i = i+1;
						resultado [i][j] = 1;
					}
				}
			}
		}
		
		return (resultado);
		*/
	}
	//Fin generarEstructuraMazmorra ()
	
	/* Prototipo: ItemIMPL itemAleatorio ()
	 * Breve comentario: Metodo dedicado a devolver un item con posición aleatoria del archivo de items
	 * Precondiciones: Ninguna
	 * Entradas: Ninguna
	 * Salidas: Un ItemIMPL
	 * Entradas/Salidas: Ninguna
	 * Postcondiciones: Un ItemIMPL devuelto aleatoriamente
	 * 
	 * Resguardo: public ItemIMPL itemAleatorio ()
		{
			System.out.println("Llamada al metodo itemAleatorio");
			return (new ItemIMPL ());
		}
	 */
	public ItemIMPL itemAleatorio ()
	{
		Random aleatorio = new Random ();
		File items = new File ("./src/Archivos/items.dat");
		ItemIMPL item = null;
		ItemIMPL resultado = null;
		ObjectInputStream ois = null;
		int numero = 0;
		int contador = 1;
		numero = aleatorio.nextInt(15) + 1;
		
		try
		{
			
			ois = new ObjectInputStream (new FileInputStream (items))
			{
				@Override protected void readStreamHeader () {}
			};
			
			item = (ItemIMPL) ois.readObject();
			
			while (!item.equals(null) && resultado.equals(null))
			{
				if (numero == contador)
				{
					resultado = (ItemIMPL) item.clone();
				}
				
				item = (ItemIMPL) ois.readObject();
				contador++;
			}
		}
		
		catch (ClassNotFoundException e)
		{
			System.out.println("ClassNotFoundException e");
		}
		
		catch (FileNotFoundException e)
		{
			System.out.println("FileNotFoundException");
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
	//Fin itemAleatorio
	
	/* Protitipo: ArmaIMPL armaAleatoria ()
	 * Breve comentario: Metodo dedicado a devolver un arma con posición aleatoria del archivo de armas
	 * Precondiciones: Ninguna
	 * Entradas: Ninguna
	 * Salidas: Un ArmaIMPL
	 * Entradas/Salidas: Ninguna
	 * Postcondiciones: Un armaIMPL devuelta aleatoriamente
	 * 
	 * Resguardo: public ArmaIMPL armaAleatoria ()
		{
			System.out.println("Llamada al metodo armaAleatoria");
			return (new ArmaIMPL ());
		}
	 */
	public ArmaIMPL armaAleatoria ()
	{
		Random aleatorio = new Random ();
		File armas = new File ("./src/Archivos/armas.dat");
		ArmaIMPL arma = null;
		ArmaIMPL resultado = null;
		ObjectInputStream ois = null;
		int numero = 0;
		int contador = 1;
		numero = aleatorio.nextInt(15) + 1;
		
		try
		{
			
			ois = new ObjectInputStream (new FileInputStream (armas))
			{
				@Override protected void readStreamHeader () {}
			};
			
			arma = (ArmaIMPL) ois.readObject();
			
			while (!arma.equals(null) && resultado.equals(null))
			{
				if (numero == contador)
				{
					resultado = (ArmaIMPL) arma.clone();
				}
				
				arma = (ArmaIMPL) ois.readObject();
				contador++;
			}
		}
		
		catch (ClassNotFoundException e)
		{
			System.out.println("ClassNotFoundException e");
		}
		
		catch (FileNotFoundException e)
		{
			System.out.println("FileNotFoundException");
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
	//Fin
	
	/* Prototipo: EnemigoIMPL enemigoAleatorio ()
	 * Breve comentario: Metodo dedicado a devolver un enemigo con posición aleatoria del archivo de enemigos
	 * Precondiciones: Ninguna
	 * Entradas: Ninguna
	 * Salidas: Un EnemigoIMPL
	 * Entradas/Salidas: Ninguna
	 * Postcondiciones: Un EnemigoIMPL devuelto aleatoriamente
	 * 
	 * Resguardo: public EnemigoIMPL enemigoAleatorio ()
		{
			System.out.println("Llamada al metodo enemigoAleatorio");
			return (new EnemigoIMPL ());
		}
	 */
	public EnemigoIMPL enemigoAleatorio ()
	{
		Random aleatorio = new Random ();
		File enemigos = new File ("./src/Archivos/enemigos.dat");
		EnemigoIMPL enemigo = null;
		EnemigoIMPL resultado = null;
		ObjectInputStream ois = null;
		int numero = 0;
		int contador = 1;
		numero = aleatorio.nextInt(15) + 1;
		
		try
		{
			
			ois = new ObjectInputStream (new FileInputStream (enemigos))
			{
				@Override protected void readStreamHeader () {}
			};
			
			enemigo = (EnemigoIMPL) ois.readObject();
			
			while (!enemigo.equals(null) && resultado.equals(null))
			{
				if (numero == contador)
				{
					resultado = (EnemigoIMPL) enemigo.clone();
				}
				
				enemigo = (EnemigoIMPL) ois.readObject();
				contador++;
			}
		}
		
		catch (ClassNotFoundException e)
		{
			System.out.println("ClassNotFoundException e");
		}
		
		catch (FileNotFoundException e)
		{
			System.out.println("FileNotFoundException");
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
	//Fin enemigoAleatorio
}
