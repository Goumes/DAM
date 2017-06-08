package Tests;

import java.util.ArrayList;

import Clases.ArmaIMPL;
import Clases.ItemIMPL;
import Clases.JugadorIMPL;
import Clases.ObjetoIMPL;
import Exceptions.JuegoException;

public class TestJugador
{
	public static void main (String []args)
	{
		try
		{
			ArmaIMPL pistola = new ArmaIMPL ("Rifle de pulsos", 45, 100);
			ItemIMPL armadura = new ItemIMPL ("Casco de hierro", 70, 0, 20, 0, false, "Un casco de hierro que aumenta la defensa en 20 puntos");
			ArrayList <ObjetoIMPL> inventario = null;
			JugadorIMPL pepejava = new JugadorIMPL ("pepe.java", 420, 1, 45, armadura, pistola, 0, inventario);
			JugadorIMPL pepejava2 = new JugadorIMPL ("pepe.java", 420, 1, 45, armadura, pistola, 0, inventario);
			JugadorIMPL estoNoEsUnaCopiaDeIsaac = new JugadorIMPL ("EstoNoEsUnaCopiaDeIsaac", 3, 3.5, 0.0, armadura, pistola, 0, inventario);
			JugadorIMPL pepejava3;
			
			
			//Getes, setes y toString
			System.out.println(pepejava.toString ());
			System.out.println("--------------------");
			System.out.println(pepejava.getNombre ());
			pepejava.setNombre ("Aseolaik");
			pepejava2.setNombre ("Aseolaik");
			System.out.println("--------------------");
			System.out.println(pepejava.getVida ());
			pepejava.setVida (0);
			pepejava2.setVida (0);
			System.out.println("--------------------");
			System.out.println(pepejava.getBaseDmg ());
			pepejava.setBaseDmg (50.0);
			pepejava2.setBaseDmg (50.0);
			System.out.println("--------------------");
			System.out.println(pepejava.getBaseDef ());
			pepejava.setBaseDef (473.25);
			pepejava2.setBaseDef (473.25);
			System.out.println("--------------------");
			System.out.println(pepejava.toString ());
			System.out.println("--------------------");
			//Fin Getes, setes y toString
			
			//Equals
			System.out.println(pepejava.equals (estoNoEsUnaCopiaDeIsaac));
			System.out.println(pepejava.equals (pepejava2));
			System.out.println("--------------------");
			//Fin Equals
			
			//hashCode
			System.out.println(pepejava.hashCode ());
			System.out.println("--------------------");
			//Fin hashCode
			
			//Clone
			pepejava3 = pepejava.clone ();
			System.out.println(pepejava3);
			//Fin Clone
			
			//CompareTo
			System.out.println("--------------------");
			pepejava2.setNombre ("Aseoleik");
			pepejava2.setVida (45);
			pepejava2.setBaseDmg (60.0);
			pepejava2.setBaseDef (43.25);
			System.out.println(pepejava.compareTo (pepejava3));
			System.out.println(pepejava.compareTo (estoNoEsUnaCopiaDeIsaac));
			System.out.println(pepejava.compareTo (pepejava2));
			System.out.println("--------------------");
			//System.out.println(pepejava.toString ());
			//System.out.println(pepejava2.toString ());
			//Fin compareTo
		}
		catch (JuegoException e)
		{
			System.out.println(e);
		}
		
	}//fin_main
}//fin_pp
