package proyectoPrincipal;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestPieza
{	
	@Test
	public void testConstructores() throws ExceptionAjedrez
	{
		boolean resultado = false;
		
		Pieza reyBlanco = new Pieza (true, "Rey");

		try
		{
			@SuppressWarnings("unused")
			Pieza reinaNegra = new Pieza (false, "Reina"); //Tiene que lanzar una excepcion porque Reina no es un tipo válido.
		}
		
		catch (ExceptionAjedrez error)
		{
			System.out.println("testConstructores. Excepcion Pieza incorrecta.");
			System.out.println("Reina no es un tipo válido");
		}
		
		if (reyBlanco instanceof Pieza)
		{
			resultado = true;
		}
		
		assertTrue(resultado);
	}
	
	@Test
	public void testGetters () throws ExceptionAjedrez
	{
		Pieza pruebaGetters = new Pieza (true, "Alfil");
		assertEquals ("testGetters. Comparando 'Alfil' con el getTipo (Alfil) de pruebaGetters", "Alfil", pruebaGetters.getTipo());
		assertEquals ("testGetters. Comparando 'true' con el getColor (true) de pruebaGetters", true, pruebaGetters.getColor());
	}

	@Test
	public void testSetters () throws ExceptionAjedrez
	{
		Pieza pruebaSetters = new Pieza (false, "Caballo");
		
		pruebaSetters.setTipo("Torre");
		pruebaSetters.setColor(true);
		assertEquals ("testSetters. Comparando 'Torre' con el setTipo (Torre) de pruebaSetters", "Torre", pruebaSetters.getTipo());
		assertEquals ("testSetters. Comparando 'true' con el setColor (true) de pruebaSetters", true, pruebaSetters.getColor());
	}
	
	@Test
	public void testEquals () throws ExceptionAjedrez
	{
		Pieza equals1 = new Pieza ();
		Pieza equals2 = new Pieza ();
		Pieza equals3 = new Pieza (true, "Torre");
		assertEquals("testEquals. Comparando los objetos por defecto 'equals1' e 'equals2'.", equals1, equals2);
		assertNotEquals("testEquals. Comparando los objetos 'equals1' e 'equals3'", equals1, equals3);
	}
	
	@Test
	public void testCompareTo () throws ExceptionAjedrez
	{
		Pieza compareTo1 = new Pieza (true, "Dama");
		Pieza compareTo2 = new Pieza (false, "Alfil");
		
		assertEquals("testCompareTo. Comparando los objetos compareTo1 y compareTo2", 1, compareTo1.compareTo(compareTo2));
		assertEquals("testCompareTo. Comparando los objetos compareTo1 y compareTo2", -1, compareTo2.compareTo(compareTo1));
		assertEquals("testCompareTo. Comparando los objetos compareTo1 y compareTo2", 0, compareTo1.compareTo(compareTo1));
	}
	
	@Test
	public void testClone () throws ExceptionAjedrez
	{
		Pieza original = new Pieza ();
		Pieza copia = null;
		
		copia = original.clone();
		
		assertEquals ("testClone. Comparando la Pieza 'original' con el resultado del clone 'copia'.", original, copia);
	}
}