package Pruebas;

import java.io.*;

public class pruebaFileReaderFileWriter 
{
	public static void main (String [] args)
	{
		try
		{
			String texto = null;
			FileWriter fw = new FileWriter ("pepejava2.txt", true);
			BufferedWriter bw = new BufferedWriter (fw);
			bw.newLine();
			bw.write("Esto es una prueb");
			bw.write(97);
			bw.newLine();
			bw.write("Esto es una prueba 2");
			bw.close();
			
			FileReader fr = new FileReader ("pepejava2.txt");
			BufferedReader br = new BufferedReader (fr);
			texto = br.readLine();
			
			while (texto != null)
			{
				System.out.println(texto);
				texto = br.readLine();
			}
			
			br.close();
		}
		catch (IOException error)
		{
			System.out.println("Error E/S: "+error);
		}
	}
}