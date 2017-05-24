package examenProgramacion;

import java.io.*;
import java.util.Scanner;

public class GestoraExamen 
{
	/* Prototipo: boolean crearFichero ();
	 * Breve comentario: Metodo dedicado a la creación del fichero Pantallas.dat
	 * Precondiciones: Ninguna
	 * Entradas: Ninguna
	 * Salidas: Un booleano
	 * Entradas/Salidas: Ninguna
	 * Postcondiciones: True si se ha creado, false sino
	 * 
	 * Resguardo: public boolean crearFichero ()
		{
			System.out.println("Llamada al metodo crearFichero");
			return false;
		}
	 */
	public boolean crearFichero ()
	{
		/* No me da tiempo a ordenar el fichero después de la creación. Lo que habría que hacer
		 sería volcar el fichero en un array, utilizar el método .sort de la clase Arrays, y luego
		 volver a escribir los datos de este array en el fichero.
		 Esto sería un método aparte, puesto que este método es crearFichero, no crear y ordenar fichero.
		 */
		File pantallas = new File ("pantallas.dat");
		boolean resultado = false;
		ObjectOutputStream oos = null;
		
		try
		{
			oos = new ObjectOutputStream (new FileOutputStream (pantallas))
			{
				@Override protected void writeStreamHeader () {}
			};
			
			resultado = true;
			
			oos.writeObject(
			new Pantalla ("fabricanteGenerico", 3, 20, 24.5, 1920, "LED", new Fecha (1,2,3))
							);
			
			oos.writeObject(
					new Pantalla ("NOC", 5, 43, 150.5, 2560, "OLED", new Fecha (12,3,2016))
							);
			oos.writeObject(
					new Pantalla ("NOC", 7, 23, 1250.5, 2540, "LCD", new Fecha (14,6,2016))
							);
			oos.writeObject(
					new Pantalla ("fabricanteGenerico", 4, 53, 1430.5, 2560, "OLED", new Fecha (22,8,2016))
							);
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
		
		catch (ExamenException e)
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
		
		
		return resultado;
	}
	//Fin metodo crearFichero
	
	/* Prototipo: void ordenarFichero ();
	 * Breve comentario: Metodo dedicado a ordernar el fichero tras su creación
	 * Precondiciones: Ninguna
	 * Entradas: Ninguna
	 * Salidas: Ninguna
	 * Entradas/Salidas: Ninguna
	 * Postcondiciones: Ninguna
	 * 
	 * Resguardo: public void ordenarFichero ()
		{
			System.out.println("Llamada al metodo ordenarFichero");
		}
	 */
	public void ordenarFichero ()
	{
		System.out.println("Llamada al metodo ordenarFichero");
	}
	//Fin ordenarFichero
	
	/* Prototipo: void listarPantallas ()
	 * Breve comentario: Metodo dedicado a listar las pantallas
	 * Precondiciones: Ninguna
	 * Entradas: Ninguna
	 * Salidas: Ninguna
	 * Entradas/Salidas: Ninguna
	 * Postcondiciones: Ninguna
	 * 
	 * Resguardo: public void listarPantallas ()
		{
			System.out.println("Llamada al metodo listarPantallas");
		}
	 */
		public void listarPantallas ()
		{
			//Metodo creado para mostrar la lista antes y después de la ordenación al crear el archivo
			File pantallas = new File ("pantallas.dat");
			ObjectInputStream ois = null;
			Object aux = null;
			
			try
			{
				ois = new ObjectInputStream (new FileInputStream (pantallas))
				{
					@Override protected void readStreamHeader () {}
				};
				
				aux = ois.readObject();
				
				while (!aux.equals(null))
				{
					if (aux instanceof Pantalla)
					{
						System.out.println(aux.toString());
					}
					
					aux = ois.readObject();
				}
			}
			
			catch (ClassNotFoundException e)
			{
				System.out.println(e);
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
				if (ois != null)
				{
					try
					{
						ois.close();
					}
					
					catch (IOException e)
					{
						System.out.println(e);
					}
				}
			}
		}
	//Fin listarPantallas
	
	/* Prototipo: void listarPantallasFabricante (String fabricante)
	 * Breve comentario: Metodo dedicado a listar las pantallas de un mismo fabricante
	 * Precondiciones: Ninguna
	 * Entradas: Un String indicando el fabricante
	 * Salidas: Ninguna
	 * Entradas/Salidas: Ninguna
	 * Postcondiciones: Ninguna
	 * 
	 * Resguardo: public void listarPantallasFabricante ()
		{
			System.out.println("Llamada al metodo listarPantallasFabricante");
		}
	 */
		public void listarPantallasFabricante (String fabricante)
		{
			File pantallas = new File ("pantallas.dat");
			ObjectInputStream ois = null;
			Object aux = null;
			
			try
			{
				ois = new ObjectInputStream (new FileInputStream (pantallas))
				{
					@Override protected void readStreamHeader () {}
				};
				
				aux = ois.readObject();
				
				while (!aux.equals(null))
				{
					if (aux instanceof Pantalla 
						&& ((Pantalla) aux).getNombreFabricante().equals(fabricante))
					{
						System.out.println(aux.toString());
					}
					
					aux = ois.readObject();
				}
			}
			
			catch (ClassNotFoundException e)
			{
				System.out.println(e);
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
				if (ois != null)
				{
					try
					{
						ois.close();
					}
					
					catch (IOException e)
					{
						System.out.println(e);
					}
				}
			}
		}
	//Fin listarPantallasFabricante
		
	/* Prototipo: void listarPantallasFecha (Fecha fecha)
	 * Breve comentario: Metodo dedicado a listar las pantallas con fecha posterior a la introducida
	 * Precondiciones: Ninguna
	 * Entradas: Una Fecha
	 * Salidas: Ninguna
	 * Entradas/Salidas: Ninguna
	 * Postcondiciones: Ninguna
	 * 
	 * Resguardo: public void listarPantallasFabricante (Fecha fecha)
		{
			System.out.println("Llamada al metodo listarPantallasFabricante");
		}
	 */
	public void listarPantallasFecha (Fecha fecha)
	{
		System.out.println("Llamada al metodo listarPantallasFecha");
	}
	//Fin listarPantallasFecha
	
	/* Prototipo: void listarMontante ()
	 * Breve comentario: Metodo dedicado a listar el montante total de todas las pantallas en el almacen
	 * Precondiciones: Ninguna
	 * Entradas: Ninguna
	 * Salidas: Ninguna
	 * Entradas/Salidas: Ninguna
	 * Postcondiciones: Ninguna
	 * 
	 * Resguardo: public void listarMontante ()
		{
			System.out.println("Llamada al metodo listarMontante");
		}
	 */
	public void listarMontante ()
	{
		System.out.println("Llamada al metodo listarMontante");
	}
	//Fin listarMontante
	
	/* Prototipo: int totalPantallasLED ()
	 * Breve comentario: Metodo dedicado contar el total de las pantallas LED
	 * Precondiciones: Ninguna
	 * Entradas:Ninguna
	 * Salidas: Un entero
	 * Entradas/Salidas: Ninguna
	 * Postcondiciones: Un entero indicando el numero de pantallas LED
	 * 
	 * Resguardo: public int totalPantallasLED ()
		{
			System.out.println("Llamada al metodo totalPantallasLED");
			return -1;
		}
	 */
	public int totalPantallasLed ()
	{		
		File pantallas = new File ("pantallas.dat");
		ObjectInputStream ois = null;
		Object aux = null;
		int contador = 0;
		
		try
		{
			ois = new ObjectInputStream (new FileInputStream (pantallas))
			{
				@Override protected void readStreamHeader () {}
			};
			
			aux = ois.readObject();
			
			while (!aux.equals(null))
			{
				if (aux instanceof Pantalla
					&& ((Pantalla) aux).getTipoTecnologia().equals("LED"))
				{
					contador++;
				}
				
				aux = ois.readObject ();
			}
		}
		
		catch (ClassNotFoundException e)
		{
			System.out.println(e);
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
			if (ois != null)
			{
				try
				{
					ois.close();
				}
				
				catch (IOException e)
				{
					System.out.println(e);
				}
			}
		}
		
		return contador;
	}
	//fin totalPantallasLED
	
	/* Prototipo: int totalPantallasLCD ()
	 * Breve comentario: Metodo dedicado contar el total de las pantallas LCD
	 * Precondiciones: Ninguna
	 * Entradas:Ninguna
	 * Salidas: Un entero
	 * Entradas/Salidas: Ninguna
	 * Postcondiciones: Un entero indicando el numero de pantallas LCD
	 * 
	 * Resguardo: public int totalPantallasLCD ()
		{
			System.out.println("Llamada al metodo totalPantallasLCD");
			return -1;
		}
	 */
	public int totalPantallasLcd ()
	{		
		File pantallas = new File ("pantallas.dat");
		ObjectInputStream ois = null;
		Object aux = null;
		int contador = 0;
		
		try
		{
			ois = new ObjectInputStream (new FileInputStream (pantallas))
			{
				@Override protected void readStreamHeader () {}
			};
			
			aux = ois.readObject();
			
			while (!aux.equals(null))
			{
				if (aux instanceof Pantalla
					&& ((Pantalla) aux).getTipoTecnologia().equals("LCD"))
				{
					contador++;
				}
				
				aux = ois.readObject ();
			}
		}
		
		catch (ClassNotFoundException e)
		{
			System.out.println(e);
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
			if (ois != null)
			{
				try
				{
					ois.close();
				}
				
				catch (IOException e)
				{
					System.out.println(e);
				}
			}
		}
		
		return contador;
	}
	//fin totalPantallasLCD
	
	/* Prototipo: int totalPantallasOLED ()
	 * Breve comentario: Metodo dedicado contar el total de las pantallas OLED
	 * Precondiciones: Ninguna
	 * Entradas:Ninguna
	 * Salidas: Un entero
	 * Entradas/Salidas: Ninguna
	 * Postcondiciones: Un entero indicando el numero de pantallas OLED
	 * 
	 * Resguardo: public int totalPantallasOled ()
		{
			System.out.println("Llamada al metodo totalPantallasOled");
			return -1;
		}
	 */
	public int totalPantallasOled ()
	{		
		File pantallas = new File ("pantallas.dat");
		ObjectInputStream ois = null;
		Object aux = null;
		int contador = 0;
		
		try
		{
			ois = new ObjectInputStream (new FileInputStream (pantallas))
			{
				@Override protected void readStreamHeader () {}
			};
			
			aux = ois.readObject();
			
			while (!aux.equals(null))
			{
				if (aux instanceof Pantalla
					&& ((Pantalla) aux).getTipoTecnologia().equals("OLED"))
				{
					contador++;
				}
				
				aux = ois.readObject ();
			}
		}
		
		catch (ClassNotFoundException e)
		{
			System.out.println(e);
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
			if (ois != null)
			{
				try
				{
					ois.close();
				}
				
				catch (IOException e)
				{
					System.out.println(e);
				}
			}
		}
		
		return contador;
	}
	//fin totalPantallasOled
	
	/* Prototipo: Pantalla crearPantalla ()
	 * Breve comentario: Metodo dedicado a crear una pantalla
	 * Precondiciones: Ninguna
	 * Entradas: Una Pantalla
	 * Salidas: Ninguna
	 * Entradas/Salidas: Ninguna
	 * Postcondiciones: Ninguna
	 * 
	 * Resguardo: public Pantalla crearPantalla ()
		{
			System.out.println("Llamada al metodo crearPantalla");
			return (new Pantalla ());
		}
	 */
	public Pantalla crearPantalla ()
	{
		Pantalla pantalla = null;
		Scanner teclado = new Scanner (System.in);
		BufferedReader tecladoString = new BufferedReader (new InputStreamReader (System.in));
		String fabricante = null;
		int numeroSerie = 0;
			//Lo hago así porque en las especificaciones ponía que estos dos atributos no pueden tener sets.
			//Lo correcto sería simplemente hacer set de cada propiedad.
			try
			{
				do
				{
					System.out.println("Introduzca el nombre del fabricante y el numero de serie");
					pantalla = new Pantalla (fabricante = tecladoString.readLine (), 
					numeroSerie = teclado.nextInt (), 0, 0.0, 0, "", new Fecha ());
				}
				while (pantalla.getNombreFabricante().equals(null) || pantalla.getNombreFabricante().equals("")
						|| pantalla.getNumeroSerie() < 0);
				
				do
				{
					System.out.println("Introduzca las unidades de esta pantalla");
					pantalla.setUnidades(teclado.nextInt());
				}
				while (pantalla.getUnidades() < 0);
				
				do
				{
					System.out.println("Introduzca el precio de esta pantalla");
					pantalla.setPrecio(teclado.nextDouble());
				}
				while (pantalla.getPrecio() < 0);
				
				do
				{
					System.out.println("Introduzca la resolucion de esta pantalla");
					pantalla.setResolucion(teclado.nextInt());
				}
				while (pantalla.getResolucion() < 0);
				
				do
				{
					System.out.println("Introduzca el tipo de tecnologia");
					pantalla.setTipoTecnologia(tecladoString. readLine ());
				}
				while (pantalla.getTipoTecnologia().equals ("LED")
						&& pantalla.getTipoTecnologia().equals ("LCD")
						&& pantalla.getTipoTecnologia().equals ("OLED"));
				
				do
				{
					System.out.println("Introduzca el dia de la fecha de creación de la pantalla");
					pantalla.getFecha ().setDia((teclado.nextInt()));
				}
				while (pantalla.getFecha ().getDia() < 0 && (pantalla.getFecha ().getDia() > 31));
				
				do
				{
					System.out.println("Introduzca el mes de la fecha de creación de la pantalla");
					pantalla.getFecha ().setMes((teclado.nextInt()));
				}
				while (pantalla.getFecha ().getMes() < 0 && (pantalla.getFecha ().getMes() > 12));
				
				
				do
				{
					System.out.println("Introduzca el año de la fecha de creación de la pantalla");
					pantalla.getFecha ().setAnio((teclado.nextInt()));
				}
				while (pantalla.getFecha ().getAnio() < 0);
				
				
			}
			catch (IOException e)
			{
				System.out.println (e);
			}
			
			catch (ExamenException e)
			{
				System.out.println (e);
			}
			return pantalla;
		}
	//Fin crearPantalla
	
	/* Prototipo: void addPantalla (Pantalla pantalla)
	 * Breve comentario: Metodo dedicado a añadir una pantalla al fichero
	 * Precondiciones: Ninguna
	 * Entradas: Una Pantalla
	 * Salidas: Ninguna
	 * Entradas/Salidas: Ninguna
	 * Postcondiciones: Ninguna
	 * 
	 * Resguardo: public void addPantalla (Pantalla pantalla)
		{
			System.out.println("Llamada al metodo addPantalla");
		}
	 */
	public void addPantalla (Pantalla pantalla)
	{
		File pantallas = new File ("pantallas.dat");
		boolean resultado = false;
		ObjectOutputStream oos = null;
		
		try
		{
			oos = new ObjectOutputStream (new FileOutputStream (pantallas, true))
			{
				@Override protected void writeStreamHeader () {}
			};
			
			oos.writeObject(pantalla);
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
	//Fin addPantalla
	
	/* Prototipo: boolean borrarPantalla (int numeroSerie)
	 * Breve comentario: Metodo dedicado a borrar una pantalla al fichero
	 * Precondiciones: Ninguna
	 * Entradas: Un entero indicando el numero de serie
	 * Salidas: Un booleano
	 * Entradas/Salidas: Ninguna
	 * Postcondiciones: Un booleano indicando TRUE si se ha borrado con exito, y FALSE sino.
	 * 
	 * Resguardo: public boolean borrarPantalla (int numeroSerie)
		{
			System.out.println("Llamada al metodo borrarPantalla");
		}
	 */
	public boolean borrarPantalla (int numeroSerie)
	{
		/*Lo he implementado con ficheros auxiliares porque al ser un fichero de secuencia en java
		es muy complejo borrar por marcado. Pero debería ser por marcado. */
		File pantallas = new File ("pantallas.dat");
		File auxiliar = new File ("auxiliar.dat");
		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;
		Object aux = null;
		boolean resultado = false;
		
		try
		{
			oos = new ObjectOutputStream (new FileOutputStream (auxiliar, true))
			{
				@Override protected void writeStreamHeader () {}
			};
			
			ois = new ObjectInputStream (new FileInputStream (pantallas))
			{
				@Override protected void readStreamHeader () {}
			};
			
			aux = ois.readObject ();
			
			while (!aux.equals(null))
			{
				if (aux instanceof Pantalla)
				{
					if (((Pantalla) aux).getNumeroSerie() == numeroSerie)
					{
						resultado = true;
					}
					
					else
					{
						oos.writeObject(aux);
					}
				}
				aux = ois.readObject();
			}
			
		}
		
		catch (ClassNotFoundException e)
		{
			System.out.println(e);
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
			
			if (ois != null)
			{
				try
				{
					ois.close();
				}
				
				catch (IOException e)
				{
					System.out.println(e);
				}
			}
		}
		
		pantallas.delete();
		auxiliar.renameTo(pantallas);
		
		return resultado;
		
	}
	//Fin borrarPantalla
}
