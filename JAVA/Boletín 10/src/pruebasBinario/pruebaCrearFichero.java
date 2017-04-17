package pruebasBinario;

import java.io.*;


public class pruebaCrearFichero 
{
	public static void main (String [] args)
	{
		String nombreArchivo = "pepejava";
		File objetoFile = new File (nombreArchivo);
		
		try
		{
			if (objetoFile.createNewFile())
			{
				System.out.println("Se ha creado el objeto");
			}
			
			else
			{
				System.out.println("No se ha creado el objeto");
			}
		}
		
		catch (IOException error)
		{
			System.out.println("fndsjifndasfad: "+error);
		}
		
	}
}
