package Tests;

import Clases.Arma;

public class TestArma
{
	public static void main (String []args)
	{
		Arma riflePulsos = new Arma ("Rifle de pulsos", 45.5, 100);
		Arma cuchilloCombate = new Arma ("Cuchillo de combate", 30.0, 40);
		Arma riflePulsos2;
		
		//Getes setes y toString
		System.out.println("Getes, setes y toString: ");
		System.out.println(riflePulsos.getNombre());
		System.out.println(riflePulsos.getDmg ());
		System.out.println(riflePulsos.getPrecio ());
		riflePulsos.setNombre ("Bomba de humo");
		riflePulsos.setDmg (10.0);
		riflePulsos.setPrecio (20);
		
		System.out.println(riflePulsos.toString ());
		//Fin Getes setes y toString
		
		//clone
		System.out.println("---------------");
		System.out.println("Clone:");
		riflePulsos2 = riflePulsos.clone ();
		System.out.println(riflePulsos2);
		System.out.println("---------------");
		//Fin clone
		
		//equals
		System.out.println("Equals:");
		System.out.println(riflePulsos.equals (riflePulsos2));
		System.out.println(riflePulsos.equals (cuchilloCombate));
		System.out.println("---------------");
		//Fin equals
		
		//hashCode
		System.out.println("hashCode:");
		System.out.println(riflePulsos.hashCode ());
		//Fin hashCode
		
		//compareTo
		System.out.println("compareTo:");
		System.out.println(riflePulsos.compareTo (riflePulsos2));
		System.out.println(riflePulsos.compareTo (cuchilloCombate));
		System.out.println(cuchilloCombate.compareTo (riflePulsos));
		//Fin compareTo
		
	}//fin_main
}//fin_pp
