/* 
 * Propiedades.
	 * Básicas: 	String Nombre 	-----------	Consultable / Modificable
 * 					double Dmg		-----------	Consultable / Modificable
 * 					Int Precio		-----------	Consultable / Modificable
			
 * Derivadas:
 * Compartidas:

 * Fórmulas:

 * Getes y Setes: 

 * String getNombre ();
 * void setNombre (String Nombre);

 * Double getDmg ();
 * void setDmg (double Dmg);

 * Int getPrecio ();
 * void setPrecio (int Precio);


 * Métodos añadidos:

 * Restricciones:
 */
package Clases;

import java.util.Objects;

public class Arma extends ObjetoIMPL implements Cloneable, Comparable <ObjetoIMPL>
{
	private double Dmg;
	
	//Constructores
	public Arma ()
	{
		Dmg = 0.0;
	}
	
	public Arma (Arma arma)
	{
		this.Dmg = arma.Dmg;
	}
	
	public Arma (String nombre, double Dmg, double precio)
	{
		super (nombre, precio);
		this.Dmg = Dmg;
	}
	//Fin Constructores
	
	//Getes y setes
	public double getDmg ()
	{
		return Dmg;
	}
	
	public void setDmg (double Dmg)
	{
		this.Dmg = Dmg;
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
		
		if (objeto != null && objeto instanceof Arma)
		{
			Arma arma = (Arma) objeto;
			
			if (super.equals(arma) 
				&& this.getDmg() == arma.getDmg())
			{
				resultado = true;
			}
		}
		
		return (resultado);
	}
	
	@Override
	public int hashCode ()
	{
		return (super.hashCode() + Objects.hash(this.getDmg()));
	}
	
	/*
	@Override
	public Arma clone ()
	{
		Arma copia = null;
		
		try
		{
			copia = (Arma) super.clone ();
		}
		
		catch (CloneNotSupportedException error)
		{
			System.out.println("No se ha podido clonar el objeto");
		}
		return (copia);
	}
	*/
	
	//Criterio de comparación: Precio
	public int compareTo (Arma arma)
	{
		int resultado = 0;
		
		resultado = super.compareTo(arma);
		
		return (resultado);
	}
	//Fin Metodos Añadidos
		
}//fin_pp
