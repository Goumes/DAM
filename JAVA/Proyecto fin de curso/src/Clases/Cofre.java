package Clases;

import java.io.Serializable;
import java.util.*;

/* Propiedades.
 * 		Basicas: 		double valor		----------		Consultable / Modificable
 * 						ObjetoIMPL drop			----------		Consultable / Modificable
 * 		Derivadas:
 * 		Compartidas:
 * 
 */

public class Cofre implements Serializable
{
	private static final long serialVersionUID = 1416960979169236387L;
	private double valor;
	private ObjetoIMPL drop;
	
	//Constructores
	public Cofre ()
	{
		valor = 0.0;
		drop = new ObjetoIMPL ();
	}
	
	public Cofre (Cofre cofre)
	{
		this.valor = cofre.valor;
		this.drop = cofre.drop;
	}
	
	public Cofre (double valor, ObjetoIMPL drop)
	{
		this.valor = valor;
		this.drop = drop;
	}
	//Fin Constructores
	
	//Getters y setters
	public double getValor ()
	{
		return valor;
	}
	
	public void setValor (double valor)
	{
		this.valor = valor;
	}
	
	public ObjetoIMPL getDrop ()
	{
		return drop;
	}
	
	public void setDrop (ObjetoIMPL drop)
	{
		this.drop = drop;
	}
	//Fin Getters y setters
	
	//Metodos añadidos
	@Override
	public boolean equals (Object object)
	{
		boolean resultado = false;
		
		if (object != null && object instanceof Object)
		{
			Cofre cofre = (Cofre) object;
			
			if (this.getValor() == cofre.getValor ()
				&& this.getDrop().equals(cofre.getDrop ()))
			{
				resultado = true;
			}
		}
		
		return resultado;
	}
	
	@Override
	public String toString ()
	{
		return (this.getValor()+","+ this.getDrop().toString ());
	}
	
	@Override
	public int hashCode ()
	{
		return (Objects.hash (this.getValor(), this.getDrop()));
	}
	
	@Override
	public Cofre clone ()
	{
		Cofre copia = null;
		
		try
		{
			copia = (Cofre) super.clone ();
		}
		
		catch (CloneNotSupportedException e)
		{
			e.printStackTrace ();
		}
		
		return copia;
	}
	
	public int compareTo (Cofre cofre)
	{
		int resultado = 0;
		
		if (this.getValor() > cofre.getValor())
		{
			resultado = 1;
		}
		
		else if (this.getValor() < cofre.getValor())
		{
			resultado = -1;
		}
		
		return resultado;
	}
	//Fin Metodos añadidos
}
