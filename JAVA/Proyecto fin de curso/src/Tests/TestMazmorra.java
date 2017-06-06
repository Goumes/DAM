package Tests;

import Clases.ArmaIMPL;
import Clases.CofreIMPL;
import Clases.EnemigoIMPL;
import Clases.HabitacionIMPL;
import Clases.ItemIMPL;
import Clases.Mazmorra;
import Clases.TiendaIMPL;
import Exceptions.JuegoException;
import Gestoras.GestoraAleatoria;

public class TestMazmorra 
{
	public static void main (String [] args) throws JuegoException
	{
		Mazmorra mazmorra = new Mazmorra ();
		GestoraAleatoria ga = new GestoraAleatoria ();
		 
		/*
		HabitacionIMPL habitacionInicial = null;
		HabitacionIMPL habitacion2 = null;
		HabitacionIMPL habitacion3 = null;
		HabitacionIMPL habitacion4 = new HabitacionIMPL ();
		HabitacionIMPL habitacion5 = new HabitacionIMPL ();
		HabitacionIMPL habitacion6 = null;
		HabitacionIMPL habitacion7 = null;
		HabitacionIMPL habitacion8 = new HabitacionIMPL ();
		HabitacionIMPL habitacion9 = new HabitacionIMPL ();
		HabitacionIMPL habitacion10 = null;
		HabitacionIMPL habitacion11 = null;
		HabitacionIMPL habitacion12 = null;
		HabitacionIMPL habitacion13 = null;
		HabitacionIMPL habitacion14 = new HabitacionIMPL ();
		HabitacionIMPL habitacion15 = null;
		HabitacionIMPL habitacion16 = null;
		HabitacionIMPL habitacion17 = null;
		HabitacionIMPL habitacion18 = new HabitacionIMPL ();
		HabitacionIMPL habitacion19 = new HabitacionIMPL ();
		HabitacionIMPL habitacion20 = new HabitacionIMPL ();
		HabitacionIMPL habitacion21 = null;
		HabitacionIMPL habitacion22 = null;
		HabitacionIMPL habitacion23 = null;
		HabitacionIMPL habitacion24 = new HabitacionIMPL ();
		HabitacionIMPL habitacionFinal = null;
		
		habitacion5.setCofreIMPL(new CofreIMPL (3, new ItemIMPL ()));
		habitacion5.setEnemy(new EnemigoIMPL ("Jaranator", 100, 45.0, 25.0, new ItemIMPL (), 10, 3));
		habitacion5.setShop(new TiendaIMPL (new ItemIMPL (), new ItemIMPL (), new ItemIMPL (), new ArmaIMPL (), true));
		habitacion5.setSalida (true);
		habitacion19.setEntrada(true);
		
		//habitacion8.setCofreIMPL(new CofreIMPL (3, new ItemIMPL ()));
		habitacion8.setEnemy(new EnemigoIMPL ("Jaranator", 100, 45.0, 25.0, new ItemIMPL (), 10, 3));
		habitacion8.setShop(new TiendaIMPL (new ItemIMPL (), new ItemIMPL (), new ItemIMPL (), new ArmaIMPL (), true));
		//habitacion8.setSalida (true);
		
		habitacion19.setEnemy(new EnemigoIMPL ("Jaranator", 100, 45.0, 25.0, new ItemIMPL (), 10, 3));
		
		 HabitacionIMPL [][] mapa = 
			 	{
					{habitacionInicial, habitacion2, habitacion3, habitacion4, habitacion5},
					{habitacion6, habitacion7, habitacion8, habitacion9, habitacion10},
					{habitacion11, habitacion12, habitacion13, habitacion14, habitacion15},
					{habitacion16, habitacion17, habitacion18, habitacion19, habitacion20},
					{habitacion21, habitacion22, habitacion23, habitacion24, habitacionFinal}
				};
		
		*/
		 mazmorra = ga.generarMazmorraAleatoria();

		 //mazmorra.setMapa(mapa);
		 mazmorra.printMazmorra();
	}
}
