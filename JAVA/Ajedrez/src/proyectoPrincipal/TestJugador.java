package proyectoPrincipal;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestJugador
{	
	@Test
	public void testConstructores()
	{
		boolean resultado = false;
		
		Jugador pepejava = new Jugador (true, "pepejava");
		
		if (pepejava instanceof Jugador)
		{
			resultado = true;
		}
		
		assertTrue(resultado);
	}
	
	@Test
	public void testGetters ()
	{
		Jugador pruebaGetters = new Jugador (true, "Alfil");
		assertEquals ("testGetters. Comparando 'Alfil' con el getNombre (Alfil) de pruebaGetters", "Alfil", pruebaGetters.getNombre());
		assertEquals ("testGetters. Comparando 'true' con el getColor (true) de pruebaGetters", true, pruebaGetters.getColor());
	}

	@Test
	public void testSetters ()
	{
		Jugador pruebaSetters = new Jugador (false, "Caballo");
		
		pruebaSetters.setNombre("Torre");
		pruebaSetters.setColor(true);
		assertEquals ("testSetters. Comparando 'Torre' con el setNombre (Torre) de pruebaSetters", "Torre", pruebaSetters.getNombre());
		assertEquals ("testSetters. Comparando 'true' con el setColor (true) de pruebaSetters", true, pruebaSetters.getColor());
	}
	
	@Test
	public void testEquals ()
	{
		Jugador equals1 = new Jugador ();
		Jugador equals2 = new Jugador ();
		Jugador equals3 = new Jugador (true, "Torre");
		assertEquals("testEquals. Comparando los objetos por defecto 'equals1' e 'equals2'.", equals1, equals2);
		assertNotEquals("testEquals. Comparando los objetos 'equals1' e 'equals3'", equals1, equals3);
	}
	
	@Test
	public void testCompareTo ()
	{
		Jugador compareTo1 = new Jugador (true, "Dama");
		Jugador compareTo2 = new Jugador (false, "Alfil");
		
		assertEquals("testCompareTo. Comparando los objetos compareTo1 y compareTo2", 1, compareTo1.compareTo(compareTo2));
		assertEquals("testCompareTo. Comparando los objetos compareTo1 y compareTo2", -1, compareTo2.compareTo(compareTo1));
		assertEquals("testCompareTo. Comparando los objetos compareTo1 y compareTo2", 0, compareTo1.compareTo(compareTo1));
	}
	
	@Test
	public void testClone ()
	{
		Jugador original = new Jugador ();
		Jugador copia = null;
		
		copia = original.clone();
		
		assertEquals ("testClone. Comparando el Jugador 'original' con el resultado del clone 'copia'.", original, copia);
	}
	
	@Test
	public void testElegirColor ()
	{
		Jugador pepejava = new Jugador ();
		pepejava.elegirColor();
		
	}
}