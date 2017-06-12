package Gestoras;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.lang.reflect.Array;
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
	/* Prototipo: TiendaIMPL generarTiendaAleatoria ()
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
		int dinero = 0;
		
		dinero = aleatorio.nextInt(20) + 1;
		
		item = itemAleatorio ();
		
		cofre.setDrop(item);
		cofre.setValor(dinero);
		
		return cofre;
	}
	//Fin generarCofreAleatorio
	
	/* Prototipo: generarHabitacionAleatoria (boolean existeTienda)
	 * Breve comentario: Metodo dedicado a la generación aleatoria de una habitacion
	 * Precondiciones: Ninguna
	 * Entradas: Un booleano indicando si existe ya una tienda en la mazmorra o no
	 * Salidas: Una HabitacionIMPL
	 * Entradas/Salidas: Ninguna
	 * Postcondiciones: Una HabitacionIMPL generada aleatoriamente
	 * 
	 * Resguardo: public HabitacionIMPL generarHabitacionAleatoria (boolean existeTienda)
		{
			System.out.println("Llamada al metodo generarHabitacionAleatoria");
			return (new HabitacionIMPL ());
		}
	 */
	public HabitacionIMPL generarHabitacionAleatoria (boolean existeTienda)
	{
		Random aleatorio = new Random ();
		HabitacionIMPL habitacion = new HabitacionIMPL ();
		TiendaIMPL tienda = new TiendaIMPL ();
		EnemigoIMPL enemigo = new EnemigoIMPL ();
		CofreIMPL cofre = new CofreIMPL ();
		
		if (aleatorio.nextBoolean())
		{
			if (!existeTienda)
			{
				tienda = generarTiendaAleatoria ();
				habitacion.setShop(tienda);
				existeTienda = true;
			}
		}
		
		if (aleatorio.nextBoolean())
		{
			enemigo = enemigoAleatorio ();
			habitacion.setEnemy(enemigo);
		}
		
		if (aleatorio.nextBoolean())
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
		 Mazmorra mazmorra = new Mazmorra ();
		 
		 HabitacionIMPL habitacion1 = null;
		 HabitacionIMPL habitacion2 = null;
		 HabitacionIMPL habitacion3 = null;
		 HabitacionIMPL habitacion4 = null;
		 HabitacionIMPL habitacion5 = null;
		 HabitacionIMPL habitacion6 = null;
		 HabitacionIMPL habitacion7 = null;
		 HabitacionIMPL habitacion8 = null;
		 HabitacionIMPL habitacion9 = null;
		 HabitacionIMPL habitacion10 = null;
		 HabitacionIMPL habitacion11 = null;
		 HabitacionIMPL habitacion12 = null;
		 HabitacionIMPL habitacion13 = null;
		 HabitacionIMPL habitacion14 = null;
		 HabitacionIMPL habitacion15 = null;
		 HabitacionIMPL habitacion16 = null;
		 HabitacionIMPL habitacion17 = null;
		 HabitacionIMPL habitacion18 = null;
		 HabitacionIMPL habitacion19 = null;
		 HabitacionIMPL habitacion20 = null;
		 HabitacionIMPL habitacion21 = null;
		 HabitacionIMPL habitacion22 = null;
		 HabitacionIMPL habitacion23 = null;
		 HabitacionIMPL habitacion24 = null;
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
		 
		 backtracking (mapa, 5, 5, false);
		 
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
	
	/* Prototipo: HabitacionIMPL [][] backtracking (HabitacionIMPL [][] mapa, int i, int j, boolean tiendaGenerada)
	 * Breve comentario: Metodo dedicado a generar la estructura de las mazmorras de forma recursiva
	 * Precondiciones: Ninguna
	 * Entradas: Dos enteros y un booleano
	 * Salidas: Ninguna
	 * Entradas/Salidas: Un Array bidimensional de HabitacionIMPL
	 * Postcondiciones: Un Array bidimensional de HabitacionIMPL con las mismas ya generadas aleatoriamente
	 * 
	 * Resguardo: public HabitacionIMPL [][] backtracking (HabitacionIMPL [][] mapa, int i, int j, boolean tiendaGenerada)
		{
			System.out.println("Llamada al metodo backtracking");
			
			return (new HabitacionIMPL [][] {});
		}
	 */
	public HabitacionIMPL [][] backtracking (HabitacionIMPL [][] mapa, int i, int j, boolean tiendaGenerada)
	{
		Random aleatorio = new Random ();
		int direccion = 0;
		boolean avanzar = false;
		int contador = 0;
		
		//Crear entrada aleatoria
		if (i == 5 && j == 5)
		{
			i = aleatorio.nextInt ((mapa.length - 1)) + 0;
			j = aleatorio.nextInt ((mapa[0].length - 1)) + 0;
			mapa [i][j] = new HabitacionIMPL ();
			mapa [i][j].setEntrada(true);
			mapa [i][j].setJugador(true);
		}
		
		else if ((i  + 1< mapa.length
				&& j < mapa[0].length
				&& i + 1>= 0
				&& j >= 0
				&& mapa[i + 1][j] != null)
			||(i - 1< mapa.length
					&& j < mapa[0].length
					&& i - 1>= 0
					&& j >= 0
					&& mapa[i - 1][j] != null)
			|| (i < mapa.length
					&& j + 1< mapa[0].length
					&& i >= 0
					&& j + 1>= 0
					&& mapa[i][j + 1] != null)
			|| (i < mapa.length
					&& j - 1< mapa[0].length
					&& i >= 0
					&& j - 1>= 0
					&& mapa[i][j - 1] != null))
		{
			for (int k = 0; k < mapa.length; k++)
			{
				for (int l = 0; l < mapa[0].length; l++)
				{
					if (mapa[k][l] == null)
					{
						contador++;
					}
					
					else if (k == 4 && l == 4 && contador == 0)
					{
						mapa[i][j].setSalida(true);
					}
				}
			}
		}
		
		mapa[i][j].setVisitada(true);
		
		while (!avanzar)
		{
			
			if ((i  + 1< mapa.length
					&& j < mapa[0].length
					&& i + 1>= 0
					&& j >= 0
					&& mapa[i + 1][j] == null)
				||(i - 1< mapa.length
						&& j < mapa[0].length
						&& i - 1>= 0
						&& j >= 0
						&& mapa[i - 1][j] == null)
				|| (i < mapa.length
						&& j + 1< mapa[0].length
						&& i >= 0
						&& j + 1>= 0
						&& mapa[i][j + 1] == null)
				|| (i < mapa.length
						&& j - 1< mapa[0].length
						&& i >= 0
						&& j - 1>= 0
						&& mapa[i][j - 1] == null))
			{
			
				direccion = aleatorio.nextInt (4) + 1;
				
				switch (direccion)
				{
					case 1:
						if (i  + 1< mapa.length
								&& j < mapa[0].length
								&& i + 1>= 0
								&& j >= 0
								&& mapa[i + 1][j] == null)
						{
							mapa[i][j].setAbajo (true);
							i++;
							mapa[i][j] = generarHabitacionAleatoria (tiendaGenerada);
							
							if (!mapa[i][j].getShop ().equals(new TiendaIMPL ()))
							{
								tiendaGenerada = true;
							}
							
							mapa[i][j].setArriba(true);
							backtracking (mapa, i, j, tiendaGenerada);
						}
					break;
					
					case 2:
						if (i - 1< mapa.length
							&& j < mapa[0].length
							&& i - 1>= 0
							&& j >= 0
							&& mapa[i - 1][j] == null)
						{
							mapa[i][j].setArriba (true);
							i--;
							mapa[i][j] = generarHabitacionAleatoria (tiendaGenerada);
							
							if (!mapa[i][j].getShop ().equals(new TiendaIMPL ()))
							{
								tiendaGenerada = true;
							}
							
							mapa[i][j].setAbajo (true);
							backtracking (mapa, i, j, tiendaGenerada);
						}
					break;
					
					case 3:
						if (i < mapa.length
							&& j + 1< mapa[0].length
							&& i >= 0
							&& j + 1>= 0
							&& mapa[i][j + 1] == null)
						{
							mapa[i][j].setDerecha (true);
							j++;
							mapa[i][j] = generarHabitacionAleatoria (tiendaGenerada);
							
							if (!mapa[i][j].getShop ().equals(new TiendaIMPL ()))
							{
								tiendaGenerada = true;
							}
							
							mapa[i][j].setIzquierda (true);
							backtracking (mapa, i, j, tiendaGenerada);
						}
					break;
					
					case 4:
						if (i < mapa.length
							&& j - 1< mapa[0].length
							&& i >= 0
							&& j - 1>= 0
							&& mapa[i][j - 1] == null)
						{
							mapa[i][j].setIzquierda (true);
							j--;
							mapa[i][j] = generarHabitacionAleatoria (tiendaGenerada);
							
							if (!mapa[i][j].getShop ().equals(new TiendaIMPL ()))
							{
								tiendaGenerada = true;
							}
							
							mapa[i][j].setDerecha (true);
							backtracking (mapa, i, j, tiendaGenerada);
						}
					break;
				}
				
			}
			
			else
			{
				avanzar = true;
			}
		}		
		
		return mapa;
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
		numero = aleatorio.nextInt(12) + 1;
		
		try
		{
			
			ois = new ObjectInputStream (new FileInputStream (items))
			{
				@Override protected void readStreamHeader () {}
			};
			
			item = (ItemIMPL) ois.readObject();
			
			while (item != null && resultado == null)
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
		numero = aleatorio.nextInt(13) + 1;
		
		try
		{
			
			ois = new ObjectInputStream (new FileInputStream (armas))
			{
				@Override protected void readStreamHeader () {}
			};
			
			arma = (ArmaIMPL) ois.readObject();
			
			while (arma != null && resultado == null)
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
		numero = aleatorio.nextInt(8) + 1;
		
		try
		{
			
			ois = new ObjectInputStream (new FileInputStream (enemigos))
			{
				@Override protected void readStreamHeader () {}
			};
			
			enemigo = (EnemigoIMPL) ois.readObject();
			
			while (enemigo != null && resultado == null)
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
