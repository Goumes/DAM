package Clases;

import java.util.Objects;
import Interfaces.Objeto;

/* Propiedades:
 * 
 * 		Basicas: 				String nombre		-----------		Consultable / Modificable
 * 								double precio		----------- 	Consultable / Modificable
 * 		Derivadas:
 * 		Compartidas:
 * 
 * 
 * String getNombre ();
 * void setNombre (String nombre);
 * 
 * double getPrecio ();
 * void setPrecio (double precio);
 * 
 * Metodos añadidos: Ninguno
 * 
 * Criterio de comparación : precio
 */

public class ObjetoIMPL implements Cloneable, Comparable <ObjetoIMPL>, Objeto
{
	String nombre;
	double precio;
	
	//Constructores
	public ObjetoIMPL ()
	{
		nombre = "";
		precio = 0.0;
	}
	
	public ObjetoIMPL (ObjetoIMPL objeto)
	{
		this.nombre = objeto.nombre;
		this.precio = objeto.precio;
	}
	
	public ObjetoIMPL (String nombre, double precio)
	{
		this.nombre = nombre;
		this.precio = precio;
	}
	//Fin Constructores
	
	//Getters y setters
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
	//Fin Getters y setters
	
	//Metodos añadidos
	@Override
	public boolean equals (Object object)
	{
		boolean resultado = false;
		
		if ( object != null && object instanceof ObjetoIMPL)
		{
			ObjetoIMPL copia = (ObjetoIMPL) object;
			
			if (this.getNombre().equals(copia.getNombre())
				&& this.getPrecio() == copia.getPrecio())
			{
				resultado = true;
			}
		}
		
		return resultado;
	}
	
	@Override
	public String toString ()
	{
		return (this.getNombre()+ ","+this.getPrecio());
	}
	
	@Override
	public int hashCode ()
	{
		return (Objects.hash(this.getNombre(), this.getPrecio()));
	}
	
	@Override
	public ObjetoIMPL clone ()
	{
		ObjetoIMPL copia = null;
		
		try
		{
			copia = (ObjetoIMPL) super.clone();
		}
		
		catch (CloneNotSupportedException e)
		{
			e.printStackTrace();
		}
		
		return copia;
	}
	
	public int compareTo (ObjetoIMPL objeto)
	{
		int resultado = 0;
		
		if (this.getPrecio() > objeto.getPrecio())
		{
			resultado = 1;
		}
		
		else if (this.getPrecio() < objeto.getPrecio())
		{
			resultado = -1;
		}
		
		return resultado;
	}
	//Fin Metodos añadidos
}
