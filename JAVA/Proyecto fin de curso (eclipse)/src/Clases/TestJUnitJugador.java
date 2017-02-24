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
		assertEquals ("TestGetters. Comparando armadura con el getArmadura (armadura)", armadura, pepejava.getArmadura());
		assertEquals ("TestGetters. Comparando pistola con el getArmaEquipada (pistola)", pistola, pepejava.getArmaEquipada());
		assertEquals ("TestGetters. Comparando 45.6 con el getBaseDef (45.6)", 45.6, pepejava.getBaseDef(), 4);
		assertEquals ("TestGetters. Comparando 1.0 con el getBaseDmg (1.0)", 1.0, pepejava.getBaseDmg(), 4);
		assertEquals ("TestGetters. Comparando 'pepe.java' con el getNombre (pepe.java)", "pepe.java", pepejava.getNombre ());
		assertEquals ("TestGetters. Comparando 0 con el getOro de pepejava (0)", 0, pepejava.getOro ());
		assertEquals ("TestGetters. Comparando 420 con el getVida (420)", 420, pepejava.getVida());
	}
	
	@Test
	public void testSetters ()
	{
		pepejava.setNombre("ya no soy pepe.java");
		assertEquals ("TestSetters. Comparando 'ya no soy pepe.java' con el setNombre ('ya no soy pepe.java')", "ya no soy pepe.java", pepejava.getNombre());
		pepejava.setOro (69);
		assertEquals ("TestSetters. Comparando 69 con el setOro (69)", 69, pepejava.getOro());
		pepejava.setVida(999);
		assertEquals ("TestSetters. Comparando 999 con el setVida (999)", 999, pepejava.getVida());
	}

	
}