package Clases;

import java.io.Serializable;
import java.util.*;

import Interfaces.Cofre;
import Interfaces.Habitacion;

public class HabitacionIMPL implements Serializable, Habitacion
{
	private static final long serialVersionUID = 7059421015933648577L;
	private TiendaIMPL shop;
	private EnemigoIMPL enemy;
	private CofreIMPL cofre;
	private char entrada;
	private char salida;
	
	//Constructores
	public HabitacionIMPL ()
	{
		shop = new TiendaIMPL ();
		enemy = new EnemigoIMPL ();
		cofre = new CofreIMPL ();
		entrada = ' ';
		salida = ' ';
	}
	
	public HabitacionIMPL (HabitacionIMPL habitacion)
	{
		this.shop = habitacion.shop;
		this.enemy = habitacion.enemy;
		this.cofre = habitacion.cofre;
		this.entrada = habitacion.entrada;
		this.salida = habitacion.salida;
	}
	
	public HabitacionIMPL (TiendaIMPL shop, EnemigoIMPL enemy, CofreIMPL cofre, char entrada, char salida)
	{
		this.shop = shop;
		this.enemy = enemy;
		this.cofre = cofre;
		this.entrada = entrada;
		this.salida = salida;
	}
	//Fin Constructores
	
	//Getters y setters
	public TiendaIMPL getShop ()
	{
		return shop;
	}
	
	public void setShop (TiendaIMPL shop)
	{
		this.shop = shop;
	}
	
	public EnemigoIMPL getEnemy ()
	{
		return enemy;
	}
	
	public void setEnemy (EnemigoIMPL enemy)
	{
		this.enemy = enemy;
	}
	
	public CofreIMPL getCofre ()
	{
		return cofre;
	}
	
	public void setCofreIMPL (CofreIMPL cofre)
	{
		this.cofre = cofre;
	}
	
	public char getEntrada ()
	{
		return entrada;
	}
	
	public void setEntrada (char Entrada)
	{
		this.entrada = Entrada;
	}
	
	public char getSalida ()
	{
		return salida;
	}
	
	public void setSalida (char Salida)
	{
		this.salida = Salida;
	}
	//Fin Getters y setters
	
	//Metodos añadidos
	
	@Override
	public String toString ()
	{
		String s = (getShop ().toString()+
					","+getEnemy ().toString()+
					","+getCofre ().toString()+
					","+getEntrada ()+
					","+getSalida ());
		return s;
	}
	
	//Criterio de igualdad: Todos los atributos
	@Override
	public boolean equals (Object objeto)
	{
		boolean resultado = false;
		
		if (objeto != null && objeto instanceof HabitacionIMPL)
		{
			HabitacionIMPL habitacion = (HabitacionIMPL) objeto;
			
			if (this.getShop ().equals(habitacion.getShop ())
				&& this.getEnemy ().equals(habitacion.getEnemy ())
				&& this.getCofre ().equals(habitacion.getCofre())
				&& this.getEntrada () == habitacion.getEntrada ()
				&& this.getSalida () == habitacion.getSalida ())
			{
				resultado = true;
			}
		}
		return resultado;
	}
	
	@Override
	public int hashCode ()
	{
		return (Objects.hash (this.getShop (), this.getEnemy (), this.getCofre(), this.getEntrada (), this.getSalida ()));
	}
	
	@Override
	public HabitacionIMPL clone ()
	{
		HabitacionIMPL copia = new HabitacionIMPL ();
		
		try
		{
			copia = (HabitacionIMPL) super.clone ();
			
		}
		
		catch (CloneNotSupportedException error)
		{
			System.out.println("No se ha podido clonar el objeto");
		}
		
		return copia;
	}
	
	//Criterio de comparación: 
	/* public int compareTo ()
	{
		int resultado = 0;
		
		if ()
		{
			resultado = 1;
		}
		
		else if ()
		{
			resultado = -1;
		}
		
		
		return resultado;
	} */
	//Fin Metodos añadidos
}//fin_clase
