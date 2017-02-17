package pruebas;

import static org.junit.Assert.*;

import org.junit.Test;

public class Prueba1Test 
{

	@Test
	public void testSuma() 
	{
		assertEquals (3, Prueba1.Suma(1, 2));
	}

	@Test
	public void testResta() 
	{
		assertEquals (-255, Prueba1.Resta(10, 265));
	}

}
