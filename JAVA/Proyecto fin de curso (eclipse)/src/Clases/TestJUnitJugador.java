package Clases;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestJUnitJugador 
{
	Arma pistola = new Arma ("Rifle de pulsos", 45.5, 100);
	Item armadura = new Item ("Casco de hierro", 70, 0.0, 20.0, 0.0, "Un casco de hierro que aumenta la defensa en 20 puntos");
	Jugador pepejava = new Jugador ("pepe.java", 420, 1.0, 45.6, armadura, pistola, 0);
	Jugador pepejava2 = new Jugador ("pepe.java", 420, 1.0, 45.6, armadura, pistola, 0);
	Jugador estoNoEsUnaCopiaDeIsaac = new Jugador ("EstoNoEsUnaCopiaDeIsaac", 3, 3.5, 0.0, armadura, pistola, 0);
	Jugador pepejava3;
	
	@Test
	public void testGetters() 
	{
		assertEquals ("pepe.java", pepejava.getNombre ());
		assertEquals (0, pepejava.getOro ());
		assertEquals("TestGetters. Comparando 0 con el getOro de pepejava (0)", 0, pepejava.getOro ());
	}
	
	
}