package pruebasBinario;

import java.io.*;


public class pruebaCrearFichero 
{
	public static void main (String [] args)
	{
		String nombreArchivo = "pepejava";
		File objetoFile = new File (nombreArchivo);
		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		try
		{
			fos = new FileOutputStream (nombreArchivo, true);
			oos = new ObjectOutputStream (fos) 
			{
				@Override protected void writeStreamHeader (){}
			};
			
			fis = new FileInputStream (nombreArchivo);
			ois = new ObjectInputStream (fis) 
			{
				@Override protected void readStreamHeader (){}
			};
			
			ois.readObject();
		}
		
		
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		
		catch (EOFException e)
		{
			e.printStackTrace();
		}
		catch (IOException error)
		{
			System.out.println("fndsjifndasfad: "+error);
		}
		
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
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
					e.printStackTrace();
				}
			}
		}
		
		
	}
}
