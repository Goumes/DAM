package Clases;

import java.io.Serializable;
import java.util.*;

import Exceptions.JuegoException;
import Interfaces.Item;

public class ItemIMPL extends ObjetoIMPL implements Comparable <ObjetoIMPL>, Serializable, Item
{
	private static final long serialVersionUID = -1109388286406543710L;
	private int modificadorDmg;
	private int modificadorDef;
	private int modificadorVida;
	private boolean duracion;
	private String efecto;
	
	//Constructores
	public ItemIMPL ()
	{
		super ();
		modificadorDmg = 0;
		modificadorDef = 0;
		modificadorVida = 0;
		duracion = false;
		efecto = "";
	}
	
	public ItemIMPL (ItemIMPL item)
	{
		this.modificadorDmg = item.modificadorDmg;
		this.modificadorDef = item.modificadorDef;
		this.modificadorVida = item.modificadorVida;
		this.duracion = item.duracion;
		this.efecto = item.efecto;
	}
	
	public ItemIMPL (String Nombre, int Valor, int modificadorDmg, int modificadorDef, int modificadorVida, boolean duracion, String efecto) throws JuegoException
	{
		super (Nombre, Valor);
		this.modificadorDmg = modificadorDmg;
		this.modificadorDef = modificadorDef;
		this.modificadorVida = modificadorVida;
		this.duracion = duracion;
		this.efecto = efecto;
	}
	//Fin Constructores
	
	//Getes y setes
	public int getModificadorDmg ()
	{
		return modificadorDmg;
	}
	
	public void setModificadorDmg (int modificadorDmg)
	{
		this.modificadorDmg = modificadorDmg;
	}
	
	public int getModificadorDef ()
	{
		return modificadorDef;
	}
	public void setModificadorDef (int modificadorDef)
	{
		this.modificadorDef = modificadorDef;
	}
	
	public int getModificadorVida ()
	{
		return modificadorVida;
	}
	public void setModificadorVida (int modificadorVida)
	{
		this.modificadorVida = modificadorVida;
	}
	
	public boolean getDuracion ()
	{
		return duracion;
	}
	
	public void setDuracion (boolean duracion)
	{
		this.duracion = duracion;
	}
	
	public String getEfecto ()
	{
		return efecto;
	}
	
	public void setEfecto (String efecto)
	{
		this.efecto = efecto;
	}
	//Fin Getes y setes
	
	//Metodos añadidos
	
	@Override
	public String toString ()
	{
		String s = (super.toString()+
					","+getModificadorDmg ()+
					","+getModificadorDef ()+
					","+getModificadorVida ()+
					","+getDuracion ()+
					","+getEfecto ());
		return s;
	}
	
	//Criterio de igualdad: Todas las propiedades.
	@Override
	public boolean equals (Object objeto)
	{
		boolean resultado = false;
		
		if (objeto != null && objeto instanceof ItemIMPL)
		{
			ItemIMPL item = (ItemIMPL) objeto;
			
			if (super.equals(objeto)
				&& this.getModificadorDmg () == item.getModificadorDmg ()
				&& this.getModificadorDef () == item.getModificadorDef ()
				&& this.getModificadorVida () == item.getModificadorVida ()
				&& this.getDuracion () == item.getDuracion ()
				&& this.efecto.equals(item.getEfecto ()))
			{
				resultado = true;
			}

		}
		
		return resultado;
	}
	
	@Override
	public ItemIMPL clone ()
	{
		ItemIMPL copia = null;
		
		try
		{
			copia = (ItemIMPL) super.clone();
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
		
		
		return (super.hashCode() + Objects.hash (this.getModificadorDmg (), this.getModificadorDef (), this.getModificadorVida(), this.getDuracion (), this.getEfecto ()));
	}
	
	//Criterio de comparacion: Valor del item
	public int compareTo (ItemIMPL item)
	{
		int resultado = 0;
		
		resultado = super.compareTo (item);
		
		return resultado;
	}
	//Fin Metodos añadidos
	
}//fin_clase
