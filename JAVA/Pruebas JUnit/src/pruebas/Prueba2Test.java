package pruebas;

import static org.junit.Assert.*;

import org.junit.Test;

public class Prueba2Test {

	@Test
	public void testCopiaArray() 
	{
		int [] pruebaArray = {1, 2, 3, 4};
		int [] prueba2 = pruebaArray.clone ();
		assertArrayEquals (pruebaArray, prueba2);
	}

}