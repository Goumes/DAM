/*
Propiedades.
	Básicas:	String Nombre			-----------		Consultable / Modificable
				Int Valor				-----------		Consultable / Modificable
				Double modificadorDmg	-----------		Consultable / Modificable
				Double modificadorDef	-----------		Consultable / Modificable
				Double duracion			-----------		Consultable / Modificable
				String efecto			-----------		Consultable / Modificable
	Derivadas:
	Compartidas:

Fórmulas:

Getes y Setes: 

String getNombre ();
void setNombre (String Nombre);

Int getValor();
void setValor (int Valor);

double getModificadorDmg();
void setModificadorDmg (double modificadorDmg);

double getModificadorDef();
void setModificadorDef (double modificadorDef);

double getDuracion ();
void setDuracion (doublé duracion);

String getEfecto ();
void setEfecto (String efecto);



Métodos añadidos:

Restricciones:

 */
package Clases;

import java.io.Serializable;
import java.util.*;

public class ItemIMPL extends ObjetoIMPL implements Comparable <ObjetoIMPL>, Serializable
{
	private static final long serialVersionUID = -1109388286406543710L;
	private double modificadorDmg;
	private double modificadorDef;
	private double duracion;
	private String efecto;
	
	//Constructores
	public ItemIMPL ()
	{
		modificadorDmg = 0.0;
		modificadorDef = 0.0;
		duracion = 0.0;
		efecto = "";
	}
	
	public ItemIMPL (ItemIMPL item)
	{
		this.modificadorDmg = item.modificadorDmg;
		this.modificadorDef = item.modificadorDef;
		this.duracion = item.duracion;
		this.efecto = item.efecto;
	}
	
	public ItemIMPL (String Nombre, int Valor, double modificadorDmg, double modificadorDef, double duracion, String efecto)
	{
		this.modificadorDmg = modificadorDmg;
		this.modificadorDef = modificadorDef;
		this.duracion = duracion;
		this.efecto = efecto;
	}
	//Fin Constructores
	
	//Getes y setes
	public double getModificadorDmg ()
	{
		return modificadorDmg;
	}
	
	public void setModificadorDmg (double modificadorDmg)
	{
		this.modificadorDmg = modificadorDmg;
	}
	
	public double getModificadorDef ()
	{
		return modificadorDef;
	}
	public void setModificadorDef (double modificadorDef)
	{
		this.modificadorDef = modificadorDef;
	}
	
	public double getDuracion ()
	{
		return duracion;
	}
	
	public void setDuracion (double duracion)
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
		String s = (super.toString()+","+getModificadorDmg ()+
					","+getModificadorDef ()+
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
				&& this.getDuracion () == item.getDuracion ()
				&& this.efecto.equals(item.getEfecto ()))
			{
				resultado = true;
			}

		}
		
		return resultado;
	}
	
	@Override
	public int hashCode ()
	{
		
		
		return (super.hashCode() + Objects.hash (this.getModificadorDmg (), this.getModificadorDef (), this.getDuracion (), this.getEfecto ()));
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
