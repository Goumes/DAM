package a;

import java.io.*;

public class Util 
{
	/* Prototipo: void MostrarDirectorio ()
	 * Breve comentario: Haz un subprograma que liste el contenido del directorio actual, usado File.
	 * Precondiciones: Ninguna
	 * Entradas: Ninguna
	 * Salidas: Ninguna
	 * Entradas/Salidas: Ninguna
	 * Postondiciones: Una lista de mensajes en pantalla mostrando el contenido del directorio actual.
	 * 
	 * Resguardo: public void MostrarDirectorio ()
		{
			System.out.println("Llamada al metodo MostrarDirectorio");
		}
	 */
	public void MostrarDirectorio ()
	{
		File pepejava = new File (".");
		String [] directorios = null;
		
		directorios = pepejava.list();
		
		for (int i = 0; i < directorios.length; i++)
		{
			System.out.println(directorios [i]);
		}
	}
	//Fin MostrarDirectorio
	
	/* Prototipo: void MostrarContenido (String archivo)
	 * Breve comentario: Usa los métodos File para indicar las propiedades y listar el contenido de win.ini 
	 * y system.ini de Windows que serán suministrados desde la línea de comandos.
	 * Precondiciones: Se introducirá un archivo válido.
	 * Entradas: Un String
	 * Salidas: Ninguna
	 * Entradas/Salidas: Ninguna
	 * Postcondiciones: Una lista de mensajes en pantalla mostrando el contenido del archivo suministrado por el usuario.
	 * 
	 * Resguardo: public void MostrarContenido (String archivo)
		{
			System.out.println("Llamada al metodo MostrarContenido");
		}
	 */
	public void MostrarContenido (String archivo)
	{
		File pepejava = new File (archivo);
		File [] directorios = null;
		int valor = 0;
		
		directorios = pepejava.listFiles();
		
		for (int i = 0; i < directorios.length; i++)
		{
			try
			{
				FileReader lector = new FileReader (directorios [i]);
				lector.read();
				while (valor != -1)
				{
					System.out.print((char) valor);
					valor = lector.read();
				}
			}
			catch (IOException error)
			{
				System.out.println("Error: "+error);
			}
		}
	}
	//Fin MostrarContenido
}
