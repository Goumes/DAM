package Tests;

import Clases.ArmaIMPL;
import Clases.ItemIMPL;
import Clases.TiendaIMPL;
import Exceptions.JuegoException;

public class TestTienda
{
	public static void main (String []args)
	{
		try
		{
			ItemIMPL objeto1 = new ItemIMPL ("a", 1, 1.0, 1.0, 1, false, "aa");
			ItemIMPL objeto2 = new ItemIMPL ("b", 2, 2.0, 2.0, 2, false, "ba");
			
			ItemIMPL objeto3 = new ItemIMPL ("c", 3, 3.0, 3.0, 3, false, "ca");
			ArmaIMPL objeto4 = new ArmaIMPL ("Hacha estándar", 70, 300);
			ItemIMPL objeto5 = new ItemIMPL ("e", 5, 5.0, 5.0, 5, false, "ea");
			ItemIMPL objeto6 = new ItemIMPL ("f", 6, 6.0, 6.0, 6, false, "fa");
			ItemIMPL objeto7 = new ItemIMPL ("g", 7, 7.0, 7.0, 7, false, "ga");
			ArmaIMPL objeto8 =  new ArmaIMPL ("Hacha estándar 2", 70, 300);
			
			
			TiendaIMPL tienda1 = new TiendaIMPL (objeto1, objeto2, objeto3, objeto4, true);
			TiendaIMPL tienda2 = new TiendaIMPL (objeto5, objeto6, objeto7, objeto8, false);
			TiendaIMPL copiaTienda;
			
			//Getes, setes y toString
			System.out.println(tienda1.getObjeto1 ());
			tienda1.setObjeto1 (objeto5);
			tienda2.setObjeto1 (objeto1);
			System.out.println(tienda1.getObjeto2 ());
			tienda1.setObjeto2 (objeto6);
			tienda2.setObjeto2 (objeto2);
			System.out.println(tienda1.getObjeto3 ());
			tienda1.setObjeto3 (objeto7);
			tienda2.setObjeto3 (objeto3);
			System.out.println(tienda1.getObjeto4 ());
			tienda1.setObjeto4 (objeto8);
			tienda2.setObjeto4 (objeto4);
			System.out.println(tienda1.getDisponibilidad ());
			tienda1.setDisponibilidad (false);
			tienda2.setDisponibilidad (true);
			
			System.out.println("----------------");
			System.out.println("toString despues de los Set");
			System.out.println(tienda1.toString ());
			//Fin Getes, setes y toString
			
			//Clone
			System.out.println("----------------");
			System.out.println("Clone:");
			System.out.println(copiaTienda = tienda1.clone ());
			//Fin Clone
			
			//hashCode
			System.out.println("----------------");
			System.out.println("hashCode:");
			System.out.println(tienda1.hashCode ());
			//Fin hashCode
			
			//Equals
			System.out.println("----------------");
			System.out.println("Equals:");
			System.out.println(tienda1.equals (copiaTienda));
			System.out.println(tienda1.equals (tienda2));
			//Fin Equals
		}
		catch (JuegoException e)
		{
			System.out.println(e);
		}
		
	}//fin_main
}//fin_pp
