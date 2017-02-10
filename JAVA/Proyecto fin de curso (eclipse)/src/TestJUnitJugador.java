import static org.junit.Assert.*;

import org.junit.Test;

public class TestJUnitJugador 
{
	@Test
	public void test() 
	{
		Jugador pepejava = new Jugador ();
		Jugador pepejava2 = new Jugador ();
		assertEquals(pepejava, pepejava2);
	}
}
