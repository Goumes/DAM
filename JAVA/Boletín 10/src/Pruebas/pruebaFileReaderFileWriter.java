package Pruebas;

import java.io.*;
import java.util.*;

public class pruebaFileReaderFileWriter 
{
	public static void main (String [] args)
	{
		try
		{
			String texto = null;
			FileWriter fw = new FileWriter ("pepejava2.txt", true);
			BufferedWriter bw = new BufferedWriter (fw);
			Scanner entrada = new Scanner (new File ("pepejava2.txt"));
			bw.newLine();
			bw.write("Esto es una prueb");
			bw.write(97);
			bw.newLine();
			bw.write("Esto es una prueba 4");
			bw.close();
			
			FileReader fr = new FileReader ("pepejava2.txt");
			BufferedReader br = new BufferedReader (fr);
			texto = br.readLine();
			
			//while ((Integer) Integer.parseInt(texto) instanceof Integer 
			//		&& Integer.parseInt(texto) != -1)
			//while (entrada.hasNextLine())
			while (texto != null)
			{
				System.out.println(texto);
				texto = br.readLine();
			}
			
			br.close();
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
			System.out.println("Error E/S: "+error);
		}
	}
}