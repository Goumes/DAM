package Clases;

public class TestEnemigo
{
	public static void main (String[]args)
	{
		Item ataqueDefensaX = new Item ("Ataque y Defensa X", 40, 5.0, 2.0, 5.0, "Aumenta tu ataque en 5 puntos y tu defensa en 2");
		Enemigo aseolake = new Enemigo ("Jaranator", 100, 45.0, 25.0, ataqueDefensaX, 10, 3);
		Enemigo aseolake2 = new Enemigo ("ElHipervinculos", 150, 60.0, 35.0, ataqueDefensaX, 20, 7);
		Enemigo aseolake3;
		
		//Getes, setes y toString
		System.out.println("-------------------");
		System.out.println(aseolake.getNombre());
		aseolake.setNombre ("Pepejava");
		System.out.println(aseolake.getVida());
		aseolake.setVida (1);
		System.out.println(aseolake.getDmg());
		aseolake.setDmg (0.1);
		System.out.println(aseolake.getDef());
		aseolake.setDef (999.9);
		System.out.println(aseolake.getDropDinero());
		aseolake.setDropDinero (99999);
		System.out.println(aseolake.getNivel());
		aseolake.setNivel (1);
		
		System.out.println("-------------------");
		System.out.println("toString despues de los Set");
		System.out.println(aseolake.toString());
		System.out.println("-------------------");
		//Fin Getes, setes y toString
		
		
		//hashCode
		System.out.println("hashCode:");
		System.out.println(aseolake.hashCode ());
		System.out.println("-------------------");
		//Fin hashCode
		
		//clone
		System.out.println("Clone:");
		System.out.println(aseolake3 = aseolake.clone ());
		System.out.println("-------------------");
		//Fin clone
		
		//equals
		System.out.println("Equals:");
		System.out.println(aseolake.equals(aseolake2));
		System.out.println(aseolake.equals(aseolake3));
		System.out.println("-------------------");
		//Fin equals
		
		//compareTo
		System.out.println("compareTo:");
		System.out.println(aseolake.compareTo (aseolake2));
		System.out.println(aseolake.compareTo (aseolake3));
		System.out.println(aseolake2.compareTo (aseolake));
		System.out.println("-------------------");
		//Fin compareTo
		
	}//Fin_main
}//fin_clase
