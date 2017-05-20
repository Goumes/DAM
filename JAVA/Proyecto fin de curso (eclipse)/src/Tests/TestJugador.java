package Tests;

import Clases.Arma;
import Clases.Item;
import Clases.Jugador;
import Clases.ObjetoIMPL;

public class TestJugador
{
	public static void main (String []args)
	{
		Arma pistola = new Arma ("Rifle de pulsos", 45.5, 100);
		Item armadura = new Item ("Casco de hierro", 70, 0.0, 20.0, 0.0, "Un casco de hierro que aumenta la defensa en 20 puntos");
		Jugador pepejava = new Jugador ("pepe.java", 420, 1.0, 45.6, armadura, pistola, 0);
		Jugador pepejava2 = new Jugador ("pepe.java", 420, 1.0, 45.6, armadura, pistola, 0);
		Jugador estoNoEsUnaCopiaDeIsaac = new Jugador ("EstoNoEsUnaCopiaDeIsaac", 3, 3.5, 0.0, armadura, pistola, 0);
		Jugador pepejava3;
		
		
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
		
		
	}//fin_main
}//fin_pp
