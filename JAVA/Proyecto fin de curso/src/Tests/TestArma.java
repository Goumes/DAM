package Tests;

import Clases.ArmaIMPL;
import Exceptions.JuegoException;
import Gestoras.GestoraAleatoria;

public class TestArma
{
	public static void main (String []args)
	{
		ArmaIMPL riflePulsos = null;
		ArmaIMPL cuchilloCombate = null;
		ArmaIMPL riflePulsos2 = null;
		GestoraAleatoria gestora = new GestoraAleatoria ();
		
		try
		{
			riflePulsos = new ArmaIMPL ("Rifle de pulsos", 45, 100);
			cuchilloCombate = new ArmaIMPL ("Cuchillo de combate", 30, 40);
			riflePulsos2 = new ArmaIMPL ();
		}
		
		catch (JuegoException e)
		{
			System.out.println(e);
		}
		
		//Getes setes y toString
		System.out.println("Getes, setes y toString: ");
		System.out.println(riflePulsos.getNombre());
		System.out.println(riflePulsos.getDmg ());
		System.out.println(riflePulsos.getPrecio ());
		riflePulsos.setNombre ("Bomba de humo");
		riflePulsos.setDmg (10);
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
		
		System.out.println(gestora.armaAleatoria().toString());
		System.out.println(gestora.enemigoAleatorio().toString());
		System.out.println(gestora.itemAleatorio().toString());
		
	}//fin_main
}//fin_pp
