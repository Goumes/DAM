package Tests;

import Gestoras.GestoraAleatoria;

public class TestGestoraAleatoria 
{
	public static void main (String [] args)
	{
		GestoraAleatoria g = new GestoraAleatoria ();
		System.out.println(g.enemigoAleatorio().toString());
	}
}
