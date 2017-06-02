package Clases;

import java.io.Serializable;
import java.util.Objects;

import Exceptions.JuegoException;
import Interfaces.Arma;

public class ArmaIMPL extends ObjetoIMPL implements Comparable <ObjetoIMPL>, Cloneable, Serializable, Arma
{
	private static final long serialVersionUID = 551200043961558334L;
	private double dmg;
	
	//Constructores
	public ArmaIMPL ()
	{
		dmg = 0.0;
	}
	
	public ArmaIMPL (ArmaIMPL arma)
	{
		this.dmg = arma.dmg;
	}
	
	public ArmaIMPL (String nombre, double Dmg, double precio) throws JuegoException
	{
		super (nombre, precio);
		this.dmg = Dmg;
	}
	//Fin Constructores
	
	//Getes y setes
	public double getDmg ()
	{
		return dmg;
	}
	
	public void setDmg (double dmg)
	{
		this.dmg = dmg;
	}
	
	public String getNombre ()
	{
		return nombre;
	}
	
	public void setNombre (String nombre)
	{
		this.nombre = nombre;
	}
	
	public double getPrecio ()
	{
		return precio;
	}
	
	public void setPrecio (double precio)
	{
		this.precio = precio;
	}
	//Fin Getes y setes
	
	//Metodos añadidos
	@Override
	public String toString ()
	{
		String s =	super.toString()+","+getDmg ();
		return s;
	}
	
	//Criterio de igualdad: Propiedades iguales
	@Override
	public boolean equals (Object objeto)
	{
		boolean resultado = false;
		
		if (objeto != null && objeto instanceof ArmaIMPL)
		{
			ArmaIMPL arma = (ArmaIMPL) objeto;
			
			if (super.equals(arma) 
				&& this.getDmg() == arma.getDmg())
			{
				resultado = true;
			}
		}
		
		return (resultado);
	}
	
	@Override
	public ArmaIMPL clone ()
	{
		ArmaIMPL copia = null;
		
		try
		{
			copia = (ArmaIMPL) super.clone();
		}
		
		catch (CloneNotSupportedException e)
		{
			e.printStackTrace();
		}
		
		return copia;
	}
	
	@Override
	public int hashCode ()
	{
		return (super.hashCode() + Objects.hash(this.getDmg()));
	}
	
	//Criterio de comparación: Precio
	public int compareTo (ArmaIMPL arma)
	{
		int resultado = 0;
		
		resultado = super.compareTo(arma);
		
		return (resultado);
	}
	//Fin Metodos Añadidos
		
}//fin_pp
