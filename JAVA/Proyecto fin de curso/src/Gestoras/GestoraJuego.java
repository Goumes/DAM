package Gestoras;
import java.io.*;
import java.util.*;
import Clases.*;
import Exceptions.JuegoException;

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
			
			while (!partida.equals(null))
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
	
	/* Protipo: Partida borrarPartida (int numero)
	 * Breve comentario: Subprograma dedicado a borrar una partida del fichero
	 * Precondiciones: Ninguna
	 * Entradas: Un entero indicando el numero de partida deseado
	 * Salidas: Una partida
	 * Entradas/Salidas: Ninguna
	 * Postcondiciones: Una partida borrada dependiendo de la selección recibida por parámetros
	 * 
	 * Resguardo:	public Partida borrarPartida (int numero)
	 * {
	 * 		System.out.println("Llamada al metodo borrarPartida");
	 * }
	 */
	public boolean borrarPartida (int numeroPartida)
	{
		File partidas = new File ("./src/Archivos/partidas.dat");
		File auxiliar = new File ("auxiliar.dat");
		Partida partida = null;
		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;
		int contador = 1;
		boolean resultado = false;
		
		try
		{
			oos = new ObjectOutputStream (new FileOutputStream (auxiliar, true))
			{
				@Override protected void writeStreamHeader () {}
			};
			
			ois = new ObjectInputStream (new FileInputStream (partidas))
			{
				@Override protected void readStreamHeader () {}
			};
		
			partida = (Partida) ois.readObject();
			
			while (!partida.equals(null))
			{
				if (contador == numeroPartida)
				{
					oos.writeObject(new Partida ());
				}
				
				else
				{
					oos.writeObject (partida);
				}
				
				partida = (Partida) ois.readObject();
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
		
		partidas.delete();
		auxiliar.renameTo(partidas);
	
		return resultado;
	}
	//Fin borrarPartida
	
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
				partidaDefinitiva = partida1.clone();
			break;
				
			case 2:
				partidaDefinitiva = partida2.clone();
			break;
				
			case 3:
				partidaDefinitiva = partida3.clone();
			break;
		}
		
		return partidaDefinitiva;
	}
	//fin asignarPartida
	
	/* Prototipo: Partida guardarpartida (Mazmorra mazmorra, Jugador jugador, int numeroPartida)
	 * Breve comentario: Metodo dedicado a guardar una partida
	 * Precondiciones: Ninguna
	 * Entradas: Un Jugador, una Mazmorra y la posición de la partida en el archivo (int).
	 * Salidas: Ninguna
	 * Entradas/Salidas: Ninguna
	 * Postcondiciones: Ninguna
	 * 
	 * Resguardo: public void guardarPartida (Mazmorra mazmorra, JugadorIMPL jugador, int numeroPartida)
		{
			System.out.println("Llamada al metodo guardarPartida");
		}
	 */
	public void guardarPartida (Mazmorra mazmorra, JugadorIMPL jugador, int numeroPartida)
	{
		File partidas = new File ("./src/Archivos/partidas.dat");
		File auxiliar = new File ("auxiliar.dat");
		Partida partida = null;
		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;
		int contador = 1;
		
		try
		{
			oos = new ObjectOutputStream (new FileOutputStream (auxiliar, true))
			{
				@Override protected void writeStreamHeader () {}
			};
			
			ois = new ObjectInputStream (new FileInputStream (partidas))
			{
				@Override protected void readStreamHeader () {}
			};
		
			partida = (Partida) ois.readObject();
			
			while (!partida.equals(null))
			{
				if (contador == numeroPartida)
				{
					oos.writeObject(new Partida (mazmorra, jugador));
				}
				
				else
				{
					oos.writeObject (partida);
				}
				
				partida = (Partida) ois.readObject();
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
		
		partidas.delete();
		auxiliar.renameTo(partidas);
	}
	//Fin crearPartida
	
	/* Prototipo: void Jugador crearJugador ();
	 * Breve comentario: Metodo dedicado a crear un jugador con datos de teclado
	 * Precondiciones: Ninguna
	 * Entradas: Ninguna
	 * Salidas: Un jugador
	 * Entradas/Salidas: NInguna
	 * Postcondiciones: Un jugador con los datos introducidos de teclado
	 * 
	 * Resguardo: public JugadorIMPL crearJugador ()
		{
			System.out.println("Llamada al metodo crearJugador");
		}
	 */
	public JugadorIMPL crearJugador ()
	{
		Scanner teclado = new Scanner (System.in);
		JugadorIMPL jugador = null;
		InputStreamReader flujo = new InputStreamReader (System.in);
		BufferedReader tecladoString = new BufferedReader (flujo);
		int puntos = 10;
		int eleccion = 0;
		int cantidad = 0;
		
		try
		{
			jugador = new JugadorIMPL ();
			jugador.setVida(100);
			jugador.setBaseDmg(50);
			jugador.setBaseDef(50);
			jugador.setOro(0);
			
			do
			{
				System.out.println("¿Cuál es tu nombre?");
				jugador.setNombre(tecladoString.readLine ());
			}
			while (jugador.getNombre().equals(null) || jugador.getNombre().equals(""));
			
			System.out.println("Dispones de 10 puntos a repartir entre los siguientes atributos. Elige sabiamente.");
			System.out.println();
			
			while (puntos > 0)
			{
			
				do
				{
					System.out.println("Te quedan "+puntos+" disponibles");
					System.out.println();
					System.out.println("1. Vida");
					System.out.println("2. Daño base");
					System.out.println("3. Defensa base");
					System.out.println("4. Riqueza");
					eleccion = teclado.nextInt ();
				}
				while (eleccion < 0 || eleccion > 4);
				
				switch (eleccion)
				{
					case 1:
						
						do
						{
							System.out.println("¿Cuántos puntos quieres asignar a la vida?");
							cantidad = teclado.nextInt();
						}
						while (cantidad > puntos);
						
						puntos = puntos - cantidad;
						
						jugador.setVida(jugador.getVida() + (cantidad * 10));
						
					break;
					
					case 2:
						
						do
						{
							System.out.println("¿Cuántos puntos quieres asignar al daño base?");
							cantidad = teclado.nextInt();
						}
						while (cantidad > puntos);
						
						puntos = puntos - cantidad;
						
						jugador.setBaseDmg (jugador.getBaseDmg() + (cantidad * 5));
						
					break;
					
					case 3:
						
						do
						{
							System.out.println("¿Cuántos puntos quieres asignar a la defensa base?");
							cantidad = teclado.nextInt();
						}
						while (cantidad > puntos);
						
						puntos = puntos - cantidad;
						
						jugador.setBaseDef (jugador.getBaseDef() + (cantidad * 5));
						
					break;
					
					case 4:
						
						do
						{
							System.out.println("¿Cuántos puntos quieres asignar a la riqueza?");
							cantidad = teclado.nextInt();
						}
						while (cantidad > puntos);
						
						puntos = puntos - cantidad;
						
						jugador.setOro (jugador.getOro() + (cantidad * 10));
						
					break;
				}//Fin_segun
			
			}//Fin_mientras
		}
		
		catch (JuegoException e)
		{
			System.out.println(e);
		}
		
		catch (IOException e)
		{
			System.out.println(e);
		}
		
		return jugador;
	}
	//Fin crearJugador
	
	/* Prototipo: Partida abrirCofre (Partida partida)
	 * Breve comentario: Metodo dedicado a abrir un cofre
	 * Precondiciones: Ninguna
	 * Entradas: Ninguna
	 * Salidas: Ninguna
	 * Entradas/Salidas: Una Partida
	 * Postcondiciones: Una Mazmorra con el cofre abierto y el jugador con los items del mismo
	 * 
	 * Resguardo: public Partida abrirCofre (Partida partida)
		{
			System.out.println("Llamada al metodo abrirCofre");
			return partida;
		}
	 */
	public Partida abrirCofre (Partida partida)
	{
		boolean añadido = false;
		ItemIMPL item = new ItemIMPL ();
		
		for (int i = 0; i < partida.getMazmorra ().getMapa().length && !añadido; i++)
		{
			for (int j = 0; j < partida.getMazmorra ().getMapa()[0].length; j++)
			{
				if (partida.getMazmorra().getMapa()[i][j].getJugador() 
					&& !partida.getMazmorra().getMapa()[i][j].getCofre().equals(new CofreIMPL ()))
				{
					añadido = true;
					try
					{
						item = (ItemIMPL) partida.getMazmorra ().getMapa()[i][j].getCofreDrop();
						System.out.println("WOW! Has encontrado: ");
						System.out.println ();
						
						System.out.print(item.getNombre ());
						System.out.print(", valor de " + String.valueOf(item.getPrecio ()) + " monedas de oro. ");
						System.out.print("Descripción: " + String.valueOf(item.getEfecto()));
						
						System.out.println ();
						System.out.println ();
						System.out.println("Y "+(partida.getMazmorra ().getMapa()[i][j].getCofreValor())+" monedas de oro");
						System.out.println ();
						System.out.println("Lo recoges y añades a tu inventario");
						
						partida.getJugador().addInventario(item);
						partida.getJugador().setOro (partida.getJugador().getOro() + partida.getMazmorra ().getMapa()[i][j].getCofreValor());
						partida.getMazmorra().getMapa()[i][j].setCofreIMPL (new CofreIMPL ());
					}
					catch (JuegoException e)
					{
						System.out.println(e);
					}
				}
			}
		}
		
		if (!añadido)
		{
			System.out.println("No puedes abrir un cofre en una habitación que no contiene cofre. CRACK.");
		}
		
		return partida;
	}
	//Fin abrirCofre
	
	/* Prototipo: void mostrarInventario (JugadorIMPL jugador)
	 * Breve comentario: Metodo dedicado a mostrar el inventario
	 * Precondiciones: Ninguna
	 * Entradas: Un JugadorIMPL
	 * Salidas: Un entero
	 * Entradas/Salidas: Ninguna
	 * Postcondiciones: Un entero indicando el número de objetos que hay en el inventario
	 * 
	 * Resguardo: public void monstrarInventario (JugadorIMPL jugador)
		{
			System.out.println("Llamada al metodo mostrarInventario");
		}	
	 */
	public int monstrarInventario (JugadorIMPL jugador)
	{
		ItemIMPL item = new ItemIMPL ();
		ArmaIMPL arma = new ArmaIMPL ();
		int numeroObjetos = jugador.getInventario().size ();
		
		for (int i = 0; i < numeroObjetos; i++)
		{
			if (jugador.getInventario().get(i) instanceof ItemIMPL)
			{
				item = (ItemIMPL) jugador.getInventario().get(i);
				System.out.println ();
				
				System.out.print((i + 1) + ". " + item.getNombre ());
				System.out.print(", valor de " + String.valueOf(item.getPrecio ()) + " monedas de oro. ");
				System.out.print("Descripción: " + String.valueOf(item.getEfecto()));
				
				System.out.println ();
			}
			
			else if (jugador.getInventario().get(i) instanceof ArmaIMPL)
			{
				arma = (ArmaIMPL) jugador.getInventario().get(i);
				System.out.println ();
				
				System.out.print((i + 1) + ". " + arma.getNombre ());
				System.out.print(", valor de " + String.valueOf (arma.getPrecio ()) + " monedas de oro. ");
				System.out.print("Daño: " + String.valueOf (arma.getDmg()));
				
				System.out.println ();
			}
		}
		
		System.out.println ();
		System.out.println("0. Salir del inventario");
		System.out.println ();
		
		return (numeroObjetos);
	}
	

	/* Prototipo: boolean utilizarItem (JugadorIMPL jugador, int posicion)
	 * Breve comentario: Metodo dedicado a utilizar un objeto del inventario
	 * Precondiciones: Ninguna
	 * Entradas: Un entero y un JugadorIMPL
	 * Salidas: Un booleano
	 * Entradas/Salidas: Ninguna
	 * Postcondiciones: Un booleano indicando si se ha añadido correctamente
	 * 
	 * Resguardo: public boolean utilizarItem (JugadorIMPL jugador, int posicion)
		{
			System.out.println("Llamada al metodo utilizarItem");
		}	
	 */
	public boolean utilizarItem (JugadorIMPL jugador, int posicion)
	{
		boolean resultado = false;
		ArmaIMPL armaAntigua = new ArmaIMPL ();
		ItemIMPL armaduraAntigua = new ItemIMPL ();
		ItemIMPL item = new ItemIMPL ();
		try
		{
			for (int i = 0; i < jugador.getInventario().size (); i++)
			{
				if ((i) == (posicion - 1))
				{
					if (jugador.getInventario().get (i) instanceof ArmaIMPL)
					{
						if (!jugador.getArmaEquipada().equals (new ArmaIMPL ()))
						{
							armaAntigua = jugador.getArmaEquipada ();
							jugador.addInventario(armaAntigua);
						}
						
						jugador.setArmaEquipada ((ArmaIMPL) jugador.getInventario().get (i));
						jugador.removeInventario(i);
						
						resultado = true;
					}
					
					else if (jugador.getInventario().get (i) instanceof ItemIMPL)
					{
						item = (ItemIMPL) jugador.getInventario().get (i);
						
						if (!item.getDuracion())
						{
							if (item.getModificadorVida() != 0)
							{
								jugador.setVida(jugador.getVida() + item.getModificadorVida());
								jugador.removeInventario(i);
								resultado = true;
							}
							
							else
							{

								if (!jugador.getArmadura ().equals (new ItemIMPL ()))
								{
									armaduraAntigua = jugador.getArmadura ();
									jugador.addInventario(armaduraAntigua);
								}
								
								jugador.setArmadura(item);
								jugador.removeInventario(i);
								
								resultado = true;
							}
						}
					}
				}
			}
		}
		catch (JuegoException e)
		{
			System.out.println(e);
		}
			
		
		return resultado;
	}
	//Fin utilizarItem
	
	
	/* Prototipo: Mazmorra moverJugador (Mazmorra mazmorra, int posicion)
	 * Breve comentario: Metodo dedicado a moverte por la mazmorra
	 * Precondiciones: Ninguna
	 * Entradas: int posicion
	 * Salidas: Ninguna
	 * Entradas/Salidas: Una Mamorra
	 * Postcondiciones: Una mazmorra con la posición del jugador modificada
	 * 
	 * Resguardo: public Mazmorra moverJugador (Mazmorra mazmorra, int posicion)
		{
			System.out.println("Llamada al metodo moverJugador");
			
			return mazmorra;
		}
	 */
	public Mazmorra moverJugador (Mazmorra mazmorra, int posicion)
	{
		boolean resultado = false;
		
		if (posicion == 1)
		{
			for (int i = 0; i < mazmorra.getMapa().length && !resultado; i++)
			{
				for (int j = 0; j < mazmorra.getMapa()[0].length && !resultado; j++)
				{
					if (mazmorra.getMapa()[i][j].getJugador())
					{
						if (mazmorra.getMapa()[i][j].getArriba())
						{
							mazmorra.getMapa()[i][j].setJugador(false);
							mazmorra.getMapa()[i - 1][j].setJugador(true);
							resultado = true;
						}
					}
				}
			}
		}
		
		else if (posicion == 2)
		{
			for (int i = 0; i < mazmorra.getMapa().length && !resultado; i++)
			{
				for (int j = 0; j < mazmorra.getMapa()[0].length && !resultado; j++)
				{
					if (mazmorra.getMapa()[i][j].getJugador())
					{
						if (mazmorra.getMapa()[i][j].getDerecha ())
						{
							mazmorra.getMapa()[i][j].setJugador(false);
							mazmorra.getMapa()[i][j + 1].setJugador(true);
							resultado = true;
						}
					}
				}
			}
		}
		
		else if (posicion == 3)
		{
			for (int i = 0; i < mazmorra.getMapa().length && !resultado; i++)
			{
				for (int j = 0; j < mazmorra.getMapa()[0].length && !resultado; j++)
				{
					if (mazmorra.getMapa()[i][j].getJugador())
					{
						if (mazmorra.getMapa()[i][j].getAbajo ())
						{
							mazmorra.getMapa()[i][j].setJugador(false);
							mazmorra.getMapa()[i + 1][j].setJugador(true);
							resultado = true;
						}
					}
				}
			}
		}
		
		else
		{
			for (int i = 0; i < mazmorra.getMapa().length && !resultado; i++)
			{
				for (int j = 0; j < mazmorra.getMapa()[0].length && !resultado; j++)
				{
					if (mazmorra.getMapa()[i][j].getJugador())
					{
						if (mazmorra.getMapa()[i][j].getIzquierda ())
						{
							mazmorra.getMapa()[i][j].setJugador(false);
							mazmorra.getMapa()[i][j - 1].setJugador(true);
							resultado = true;
						}
					}
				}
			}
		}
		
		if (!resultado)
		{
			System.out.println();
			System.out.println("No puedes avanzar en esa dirección Hulio!");
		}
		
		return mazmorra;
	}
	//Fin moverJugador
	
	/* Prototipo: boolean comprobarEnemigo (Mazmorra mazmorra)
	 * Breve comentario: Metodo dedicado a comprobar si existe un enemigo
	 * Precondiciones: Ninguna
	 * Entradas: Una Mazmorra
	 * Salidas: Un boolean
	 * Entradas/Salidas: Ninguna
	 * Postcondiciones: Un booleano indicando si existe un enemigo o no.
	 * 
	 * Resguardo: public boolean comprobarEnemigo (Mazmorra mazmorra)
		{
			System.out.println("Llamada al metodo comprobarEnemigo");
			return false;
		}
	 */
	//Fin comprobarEnemigo
	public boolean comprobarEnemigo (Mazmorra mazmorra)
	{
		boolean resultado = false;
		
		for (int i = 0; i < mazmorra.getMapa ().length; i++)
		{
			for (int j = 0; j < mazmorra.getMapa()[0].length; j++)
			{
				if (mazmorra.getMapa()[i][j].getJugador())
				{
					if (!mazmorra.getMapa()[i][j].getEnemy().equals(new EnemigoIMPL ()))
					{
						resultado = true;
					}
				}
			}
		}
		
		return resultado;
	}
	//Fin comprobarEnemigo
	
	/* Prototipo: boolean comprobarTienda (Mazmorra mazmorra)
	 * Breve comentario: Metodo dedicado a comprobar si existe una tienda
	 * Precondiciones: Ninguna
	 * Entradas: Una Mazmorra
	 * Salidas: Un boolean
	 * Entradas/Salidas: Ninguna
	 * Postcondiciones: Un booleano indicando si existe una tienda o no.
	 * 
	 * Resguardo: public boolean comprobarTienda (Mazmorra mazmorra)
		{
			System.out.println("Llamada al metodo comprobarTienda");
			return false;
		}
	 */
	public boolean comprobarTienda (Mazmorra mazmorra)
	{
		boolean resultado = false;
		
		for (int i = 0; i < mazmorra.getMapa ().length; i++)
		{
			for (int j = 0; j < mazmorra.getMapa()[0].length; j++)
			{
				if (mazmorra.getMapa()[i][j].getJugador())
				{
					if (!mazmorra.getMapa()[i][j].getShop().equals(new TiendaIMPL ()))
					{
						resultado = true;
					}
				}
			}
		}
		
		return resultado;
	}
	//Fin comprobarTienda
	
	/* Prototipo: void abrirTienda (Partida partida)
	 * Breve comentario: Metodo dedicado a abrir la tienda
	 * Precondiciones: Ninguna
	 * Entradas: Una Partida
	 * Salidas: Ninguna
	 * Entradas/Salidas: Ninguna
	 * Postcondiciones: Ninguna
	 * 
	 * Resguardo: public void abrirTienda (Partida partida)
		{
			System.out.println("Llamada al metodo abrirTienda");
		}
	 */
	public void abrirTienda (Partida partida)
	{
		for (int i = 0; i < partida.getMazmorra ().getMapa ().length; i++)
		{
			for (int j = 0; j < partida.getMazmorra ().getMapa()[0].length; j++)
			{
				if (partida.getMazmorra ().getMapa()[i][j].getJugador())
				{
					if (!partida.getMazmorra ().getMapa()[i][j].getShop().equals (new TiendaIMPL ()))
					{
						System.out.println("Bienvenido a tu tienda de confianza. ¿Algo de tu interés? Tienes " +partida.getJugador().getOro ()+" monedas de oro.");
						System.out.println();
						System.out.println();
						System.out.print(1 + ". ");
						System.out.print(partida.getMazmorra ().getMapa()[i][j].getShop().getObjeto1 ().getNombre ());
						System.out.println(". Efecto: " + partida.getMazmorra ().getMapa()[i][j].getShop().getObjeto1 ().getEfecto() 
											+ ". Precio: " + partida.getMazmorra ().getMapa()[i][j].getShop().getObjeto1 ().getPrecio());
						
						System.out.println();
						System.out.print(2 + ". ");
						System.out.print(partida.getMazmorra ().getMapa()[i][j].getShop().getObjeto2 ().getNombre ());
						System.out.println(". Efecto: " + partida.getMazmorra ().getMapa()[i][j].getShop().getObjeto2 ().getEfecto() 
											+ ". Precio: " + partida.getMazmorra ().getMapa()[i][j].getShop().getObjeto2 ().getPrecio());
						
						System.out.println();
						System.out.print(3 + ". ");
						System.out.print(partida.getMazmorra ().getMapa()[i][j].getShop().getObjeto3 ().getNombre ());
						System.out.println(". Efecto: " + partida.getMazmorra ().getMapa()[i][j].getShop().getObjeto3 ().getEfecto() 
											+ ". Precio: " + partida.getMazmorra ().getMapa()[i][j].getShop().getObjeto3 ().getPrecio());
						
						System.out.println();
						System.out.print(4 + ". ");
						System.out.print(partida.getMazmorra ().getMapa()[i][j].getShop().getObjeto4 ().getNombre ());
						System.out.println(". Daño: " + partida.getMazmorra ().getMapa()[i][j].getShop().getObjeto4 ().getDmg() 
											+ ". Precio: " + partida.getMazmorra ().getMapa()[i][j].getShop().getObjeto4 ().getPrecio());
						System.out.println();
						System.out.println("0. Salir de la tienda");
						System.out.println();
						System.out.println();
						
					}
				}
			}
		}
	}
	//Fin abrirTienda
	
	/* Prototipo: Partida elegirItemTienda (Partida partida, int eleccion)
	 * Breve comentario: Metodo dedicado a abrir la tienda
	 * Precondiciones: Ninguna
	 * Entradas: Un entero indicando la eleccion
	 * Salidas: Un booleano
	 * Entradas/Salidas: Ninguna
	 * Postcondiciones: Un booleano indicando si se ha comprado correctamente el objeto o no
	 * 
	 * Resguardo: public boolean elegirItemTienda (Partida partida, int eleccion)
		{
			System.out.println("Llamada al metodo elegirItemTienda");
			return partida;
		}
	 */
	public boolean elegirItemTienda (Partida partida, int eleccion)
	{
		boolean resultado = false;
		
		try
		{
			for (int i = 0; i < partida.getMazmorra ().getMapa ().length; i++)
			{
				for (int j = 0; j < partida.getMazmorra ().getMapa()[0].length; j++)
				{
					if (partida.getMazmorra ().getMapa()[i][j].getJugador())
					{
						if (eleccion == 1)
						{
							if (partida.getJugador().getOro() >= partida.getMazmorra ().getMapa()[i][j].getShop().getObjeto1 ().getPrecio())
							{
								partida.getJugador().addInventario(partida.getMazmorra ().getMapa()[i][j].getShop().getObjeto1 ());
								partida.getJugador().setOro(partida.getJugador ().getOro () - partida.getMazmorra ().getMapa()[i][j].getShop().getObjeto1 ().getPrecio());
								resultado = true;
							}

						}
						
						else if (eleccion == 2)
						{
							if (partida.getJugador().getOro() >= partida.getMazmorra ().getMapa()[i][j].getShop().getObjeto2 ().getPrecio())
							{
								partida.getJugador().addInventario(partida.getMazmorra ().getMapa()[i][j].getShop().getObjeto2 ());
								partida.getJugador().setOro(partida.getJugador ().getOro () - partida.getMazmorra ().getMapa()[i][j].getShop().getObjeto2 ().getPrecio());
								resultado = true;
							}
						}
						
						else if (eleccion == 3)
						{
							if (partida.getJugador().getOro() >= partida.getMazmorra ().getMapa()[i][j].getShop().getObjeto3 ().getPrecio())
							{
								partida.getJugador().addInventario(partida.getMazmorra ().getMapa()[i][j].getShop().getObjeto3 ());
								partida.getJugador().setOro(partida.getJugador ().getOro () - partida.getMazmorra ().getMapa()[i][j].getShop().getObjeto3 ().getPrecio());
								resultado = true;
							}
						}
						
						else if (eleccion == 4)
						{
							if (partida.getJugador().getOro() >= partida.getMazmorra ().getMapa()[i][j].getShop().getObjeto4 ().getPrecio())
							{
								partida.getJugador().addInventario(partida.getMazmorra ().getMapa()[i][j].getShop().getObjeto4 ());
								partida.getJugador().setOro(partida.getJugador ().getOro () - partida.getMazmorra ().getMapa()[i][j].getShop().getObjeto4 ().getPrecio());
								resultado = true;
							}
						}
					}
				}
			}
		}
		catch (JuegoException e)
		{
			System.out.println(e);
		}
		return resultado;
	}
	//Fin elegirItemTienda
	
	/* Prototipo: boolean comprobarFinNivel (Mazmorra mazmorra)
	 * Breve comentario: Metodo dedicado a comprobar si es posible avanzar al siguiente nivel
	 * Precondiciones: Ninguna
	 * Entradas: Una mazmorra
	 * Salidas: Ninguna
	 * Entradas/Salidas: Ninguna
	 * Postcondiciones: Ninguna
	 * 
	 * Resguardo: public boolean comprobarFinNivel (Mazmorra mazmorra)
		{
			System.out.println("Llamada al metodo comprobarFinNivel");
			return false;
		}
	 */
	public boolean comprobarFinNivel (Mazmorra mazmorra)
	{
		boolean resultado = false;
		
		for (int i = 0; i < mazmorra.getMapa ().length; i++)
		{
			for (int j = 0; j < mazmorra.getMapa()[0].length; j++)
			{
				if (mazmorra.getMapa()[i][j].getSalida())
				{
					if (mazmorra.getMapa ()[i][j].getJugador())
					{
						resultado = true;
					}
				}
			}
		}
		
		return resultado;
	}
	//Fin comprobarFinNivel
	
	/* Prototipo: void interfazCombate (Partida partida)
	 * Breve comentario: Metodo dedicado a mostrar la interfaz de un combate
	 * Precondiciones: Ninguna
	 * Entradas: Una Partida
	 * Salidas: Ninguna
	 * Entradas/Salidas: Ninguna
	 * Postcondiciones: Ninguna
	 * 
	 * Resguardo: public void interfazCombate (Partida partida)
	 * {
	 * 		System.out.println("Llamada al metodo interfazCombate");
	 * }
	 */
	 public void interfazCombate (Partida partida)
	 {
		 boolean salir = false;
		 for (int i = 0; i < partida.getMazmorra().getMapa().length && !salir; i++)
		 {
			 for (int j = 0; j < partida.getMazmorra().getMapa()[0].length && !salir; j++)
			 {
				 if (partida.getMazmorra().getMapa()[i][j].getJugador())
				 {
					 if (!partida.getMazmorra().getMapa()[i][j].getEnemy().equals(new EnemigoIMPL ()))
					 {
						 System.out.println();
						 System.out.println("Te enfrentas a:");
						 System.out.println();
						 partida.getMazmorra().getMapa()[i][j].getEnemy().imprimirEnemigo();
						 System.out.println();
						 System.out.println();
						 System.out.println("Tus estadísticas son: ");
						 System.out.println();
						 partida.getJugador ().imprimirJugadorCombate();
						 System.out.println();
						 System.out.println();
						 System.out.println("¿Qué deseas hacer?");
						 System.out.println();
						 System.out.println("1. Atacar");
						 System.out.println("2. Utilizar un item");
						 System.out.println("0. Dejar el combate");
						 System.out.println();
						 
						 salir = true;
					 }
				 }
			 }
		 }
	 }
	//Fin interfazCombate
	 
	 /* Prototipo: Partida combate (Partida partida)
		 * Breve comentario: Metodo dedicado a mostrar la interfaz de un combate
		 * Precondiciones: Ninguna
		 * Entradas: Una Partida
		 * Salidas: Ninguna
		 * Entradas/Salidas: Una Partida
		 * Postcondiciones: Una Partida con el combate ya efectuado
		 * 
		 * Resguardo: public Partida combate (Partida partida)
		 * {
		 * 		System.out.println("Llamada al metodo combate");
		 * 		return partida;
		 * }
		 */
	 public Partida combate (Partida partida)
	 {
		 boolean salir = false;
		 
		 try
		 {
			 for (int i = 0; i < partida.getMazmorra().getMapa().length && !salir; i++)
			 {
				 for (int j = 0; j < partida.getMazmorra().getMapa()[0].length && !salir; j++)
				 {
					 if (partida.getMazmorra().getMapa()[i][j].getJugador())
					 {
						 if (!partida.getMazmorra().getMapa()[i][j].getEnemy().equals(new EnemigoIMPL ()))
						 {
							 partida.getMazmorra().getMapa()[i][j].getEnemy().setVida(partida.getMazmorra().getMapa()[i][j].getEnemy().getVida()  - (partida.getJugador ().getTotalDmg() - partida.getMazmorra().getMapa()[i][j].getEnemy().getDef ()));
							 
							 if (partida.getMazmorra().getMapa()[i][j].getEnemy().getVida() <= 0)
							 {
								 System.out.println("Has derrotado al enemigo!");
								 System.out.println();
								 System.out.println("Has conseguido:");
								 System.out.println(partida.getMazmorra ().getMapa()[i][j].getEnemy().getDropItem().getNombre() + ". Y también "+partida.getMazmorra ().getMapa()[i][j].getEnemy().getDropDinero()+" monedas de oro.");
								 partida.getJugador().setOro(partida.getJugador ().getOro() + partida.getMazmorra ().getMapa()[i][j].getEnemy().getDropDinero());
								 partida.getJugador().addInventario(partida.getMazmorra ().getMapa()[i][j].getEnemy().getDropItem());
								 partida.getMazmorra ().getMapa()[i][j].setEnemy(new EnemigoIMPL ());
								 salir = true;
							 }
							 
							 else if (partida.getMazmorra().getMapa()[i][j].getEnemyDmg() > partida.getJugador ().getTotalDef())
							 {
								 if ((partida.getJugador ().getVida() - (partida.getMazmorra().getMapa()[i][j].getEnemyDmg() - partida.getJugador ().getTotalDef())) > 1)
								 {
									 partida.getJugador().setVida(partida.getJugador ().getVida() - (partida.getMazmorra().getMapa()[i][j].getEnemyDmg() - partida.getJugador ().getTotalDef()));
								 }
							 }
							 
							 
							 else if (partida.getJugador ().getVida() - (partida.getMazmorra().getMapa()[i][j].getEnemyDmg() - partida.getJugador ().getTotalDef()) < 1 )
							 {
								 partida.getJugador().setVida (0);
							 }
						 }
					 }
				 }
			 }
		 }
		 catch (JuegoException e)
		 {
			 System.out.println(e);
		 }
		 
		 return partida;
	 }
	 //Fin combate
	 
	 /* Prototipo: boolean comprobarEnemigoMuerto (Mazmorra mazmorra)
		 * Breve comentario: Metodo dedicado a comprobar si un enemigo ha muerto
		 * Precondiciones: Ninguna
		 * Entradas: Una mazmorra
		 * Salidas: Ninguna
		 * Entradas/Salidas: Ninguna
		 * Postcondiciones: Ninguna
		 * 
		 * Resguardo: public boolean comprobarEnemigoMuerto (Mazmorra mazmorra)
			{
				System.out.println("Llamada al metodo comprobarEnemigoMuerto");
				return false;
			}
		 */
		public boolean comprobarEnemigoMuerto (Mazmorra mazmorra)
		{
			boolean resultado = false;
			
			for (int i = 0; i < mazmorra.getMapa ().length; i++)
			{
				for (int j = 0; j < mazmorra.getMapa()[0].length; j++)
				{
					if (mazmorra.getMapa()[i][j].getJugador())
					{
						if (mazmorra.getMapa()[i][j].getEnemy().equals(new EnemigoIMPL ()))
						{
							resultado = true;
						}
					}
				}
			}
			
			return resultado;
		}
		//Fin comprobarEnemigoMuerto
	 
	//Fin Metodos Añadidos
}