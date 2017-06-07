package Clases;

import java.io.Serializable;
import java.util.Objects;

import Exceptions.JuegoException;
import Interfaces.Objeto;


public class ObjetoIMPL implements Cloneable, Comparable <ObjetoIMPL>, Objeto, Serializable
{
	private static final long serialVersionUID = -8016225400798258794L;
	String nombre;
	int precio;
	
	//Constructores
	public ObjetoIMPL ()
	{
		nombre = "";
		precio = 0;
	}
	
	public ObjetoIMPL (ObjetoIMPL objeto)
	{
		this.nombre = objeto.nombre;
		this.precio = objeto.precio;
	}
	
	public ObjetoIMPL (String nombre, int precio) throws JuegoException
	{
		if (nombre.equals(null) || nombre.equals("")
			|| precio < 0)
		{
			if ((nombre.equals(null) || nombre.equals("")))
			{
				throw new JuegoException ("El nombre no debe estar vacio");
			}
			
			else if (precio < 0)
			{
				throw new JuegoException ("El precio no puede ser menor a 0");
			}
		}
		
		else
		{
			this.nombre = nombre;
			this.precio = precio;
		}
	}
	//Fin Constructores
	
	//Getters y setters
	public String getNombre ()
	{
		return nombre;
	}
	
	public void setNombre (String nombre) throws JuegoException
	{
		if (nombre.equals(null) || nombre.equals(""))
		{
			throw new JuegoException ("El nombre no debe estar vacio");
		}
		else
		{
			this.nombre = nombre;
		}
	}
	
	public int getPrecio ()
	{
		return precio;
	}
	
	public void setPrecio (int precio) throws JuegoException
	{
		if (precio < 0)
		{
			throw new JuegoException ("El precio no puede ser menor a 0");
		}
		else
		{
			this.precio = precio;
		}
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
	public ObjetoIMPL clone () throws CloneNotSupportedException
	{
		ObjetoIMPL copia = null;
		
			copia = (ObjetoIMPL) super.clone();

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
