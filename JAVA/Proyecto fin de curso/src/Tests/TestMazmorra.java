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
		Mazmorra mazmorra2 = new Mazmorra ();
		GestoraAleatoria ga = new GestoraAleatoria ();
		 
		HabitacionIMPL habitacionInicial = new HabitacionIMPL ();
		HabitacionIMPL habitacion2 = new HabitacionIMPL ();
		HabitacionIMPL habitacion3 = new HabitacionIMPL ();
		HabitacionIMPL habitacion4 = new HabitacionIMPL ();
		HabitacionIMPL habitacion5 = new HabitacionIMPL ();
		HabitacionIMPL habitacion6 = new HabitacionIMPL ();
		HabitacionIMPL habitacion7 = new HabitacionIMPL ();
		HabitacionIMPL habitacion8 = new HabitacionIMPL ();
		HabitacionIMPL habitacion9 = new HabitacionIMPL ();
		HabitacionIMPL habitacion10 = new HabitacionIMPL ();
		HabitacionIMPL habitacion11 = new HabitacionIMPL ();
		HabitacionIMPL habitacion12 = new HabitacionIMPL ();
		HabitacionIMPL habitacion13 = new HabitacionIMPL ();
		HabitacionIMPL habitacion14 = new HabitacionIMPL ();
		HabitacionIMPL habitacion15 = new HabitacionIMPL ();
		HabitacionIMPL habitacion16 = new HabitacionIMPL ();
		HabitacionIMPL habitacion17 = new HabitacionIMPL ();
		HabitacionIMPL habitacion18 = new HabitacionIMPL ();
		HabitacionIMPL habitacion19 = new HabitacionIMPL ();
		HabitacionIMPL habitacion20 = new HabitacionIMPL ();
		HabitacionIMPL habitacion21 = new HabitacionIMPL ();
		HabitacionIMPL habitacion22 = new HabitacionIMPL ();
		HabitacionIMPL habitacion23 =new HabitacionIMPL ();
		HabitacionIMPL habitacion24 = new HabitacionIMPL ();
		HabitacionIMPL habitacionFinal = new HabitacionIMPL ();
		
		 HabitacionIMPL [][] mapa2 = 
			 	{
					{habitacionInicial, habitacion2, habitacion3, habitacion4, habitacion5},
					{habitacion6, habitacion7, habitacion8, habitacion9, habitacion10},
					{habitacion11, habitacion12, habitacion13, habitacion14, habitacion15},
					{habitacion16, habitacion17, habitacion18, habitacion19, habitacion20},
					{habitacion21, habitacion22, habitacion23, habitacion24, habitacionFinal}
				};
		 
		 mazmorra2.setMapa (mapa2);
		 
		// mazmorra2.printMazmorra3();
		 
		 System.out.println();
		 System.out.println();
		 System.out.println();
		
		 habitacionInicial.setEntrada(true);
		 habitacionInicial.setDerecha (true);
		 habitacion2.setIzquierda(true);
		 habitacion2.setAbajo(true);
		 habitacion7.setArriba (true);
		 habitacion7.setIzquierda(true);
		 habitacion6.setDerecha(true);
		 habitacion6.setAbajo(true);
		 habitacion11.setArriba (true);
		 habitacion11.setAbajo(true);
		 habitacion16.setArriba(true);
		 habitacion16.setAbajo(true);
		 habitacion21.setArriba (true);
		 habitacion21.setDerecha(true);
		 habitacion22.setIzquierda(true);
		 habitacion22.setArriba(true);
		 habitacion17.setAbajo(true);
		 habitacion17.setArriba(true);
		 habitacion12.setAbajo(true);
		 habitacion12.setDerecha(true);
		 habitacion13.setIzquierda(true);
		 habitacion13.setArriba(true);
		 habitacion8.setAbajo(true);
		 habitacion8.setArriba(true);
		 habitacion3.setAbajo(true);
		 habitacion3.setDerecha(true);
		 habitacion4.setIzquierda(true);
		 habitacion4.setAbajo(true);
		 habitacion9.setArriba(true);
		 habitacion9.setAbajo(true);
		 habitacion14.setArriba(true);
		 habitacion14.setAbajo(true);
		 habitacion19.setArriba(true);
		 habitacion19.setAbajo(true);
		 habitacion24.setArriba(true);
		 habitacion24.setIzquierda(true);
		 habitacion24.setDerecha(true);
		 habitacion23.setDerecha(true);
		 habitacion23.setArriba(true);
		 habitacion18.setAbajo(true);
		 habitacionFinal.setIzquierda(true);
		 habitacionFinal.setArriba(true);
		 habitacion20.setAbajo(true);
		 habitacion20.setArriba(true);
		 habitacion15.setAbajo(true);
		 habitacion15.setArriba(true);
		 habitacion10.setAbajo(true);
		 habitacion10.setArriba(true);
		 habitacion5.setAbajo(true);
		 habitacion5.setSalida(true);
		 
		 habitacionInicial.setJugador(true);
		 habitacion4.setCofreIMPL(ga.generarCofreAleatorio ());
		 habitacion5.setCofreIMPL(ga.generarCofreAleatorio ());
		 habitacion8.setCofreIMPL(ga.generarCofreAleatorio ());
		 habitacion24.setCofreIMPL(ga.generarCofreAleatorio ());
		 habitacion23.setCofreIMPL(ga.generarCofreAleatorio ());
		 
		 habitacion4.setShop(ga.generarTiendaAleatoria ());
		 habitacion5.setShop(ga.generarTiendaAleatoria ());
		 habitacion8.setShop(ga.generarTiendaAleatoria ());
		 habitacion24.setShop(ga.generarTiendaAleatoria ());
		 habitacion23.setShop(ga.generarTiendaAleatoria ());
		 
		 habitacion4.setEnemy(ga.enemigoAleatorio ());
		 habitacion5.setEnemy(ga.enemigoAleatorio ());
		 habitacion8.setEnemy(ga.enemigoAleatorio ());
		 habitacion24.setEnemy(ga.enemigoAleatorio ());
		 habitacion23.setEnemy(ga.enemigoAleatorio ());
		
		 HabitacionIMPL [][] mapa = 
			 	{
					{habitacionInicial, habitacion2, habitacion3, habitacion4, habitacion5},
					{habitacion6, habitacion7, habitacion8, habitacion9, habitacion10},
					{habitacion11, habitacion12, habitacion13, habitacion14, habitacion15},
					{habitacion16, habitacion17, habitacion18, habitacion19, habitacion20},
					{habitacion21, habitacion22, habitacion23, habitacion24, habitacionFinal}
				};
		 
		
		 
		
		 mazmorra = ga.generarMazmorraAleatoria();

		 //mazmorra.setMapa(mapa);
		 mazmorra.printMazmorra3();

	}
}
