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
							System.out.println("¿Cuántos puntos quieres asignar a la defensa base?");
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
	
	/* Prototipo: ItemIMPL itemAleatorio ()
	 * Breve comentario: Metodo dedicado a devolver un item con posición aleatoria del archivo de items
	 * Precondiciones: Ninguna
	 * Entradas: Ninguna
	 * Salidas: Un ItemIMPL
	 * Entradas/Salidas: Ninguna
	 * Postcondiciones: Un ItemIMPL devuelto aleatoriamente
	 * 
	 * Resguardo: public void crearItems ()
	 	{
	 		System.out.println("Llamada al metodo crearItems");
	 	}
	 */
}