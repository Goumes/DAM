/*
Propiedades.
	Básicas:	String Nombre			-----------		Consultable / Modificable
				Int Valor				-----------		Consultable / Modificable
				Double modificadorDmg	-----------		Consultable / Modificable
				Double modificadorDef	-----------		Consultable / Modificable
				Double Duracion			-----------		Consultable / Modificable
				String Efecto			-----------		Consultable / Modificable
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
void setDuracion (doublé Duracion);

String getEfecto ();
void setEfecto (String Efecto);



Métodos añadidos:

Restricciones:

 */
package Clases;

import java.lang.*;
import java.util.*;
public class Item implements Cloneable, Comparable <Item>
{
	private String Nombre;
	private int Valor;
	private double modificadorDmg;
	private double modificadorDef;
	private double Duracion;
	private String Efecto;
	
	//Constructores
	public Item ()
	{
		Nombre = "";
		Valor = 0;
		modificadorDmg = 0.0;
		modificadorDef = 0.0;
		Duracion = 0.0;
		Efecto = "";
	}
	
	public Item (Item item)
	{
		this.Nombre = item.Nombre;
		this.Valor = item.Valor;
		this.modificadorDmg = item.modificadorDmg;
		this.modificadorDef = item.modificadorDef;
		this.Duracion = item.Duracion;
		this.Efecto = item.Efecto;
	}
	
	public Item (String Nombre, int Valor, double modificadorDmg, double modificadorDef, double Duracion, String Efecto)
	{
		this.Nombre = Nombre;
		this.Valor = Valor;
		this.modificadorDmg = modificadorDmg;
		this.modificadorDef = modificadorDef;
		this.Duracion = Duracion;
		this.Efecto = Efecto;
	}
	//Fin Constructores
	
	//Getes y setes
	
	public String getNombre ()
	{
		return Nombre;
	}
	
	public void setNombre (String Nombre)
	{
		this.Nombre = Nombre;
	}
	
	public int getValor ()
	{
		return Valor;
	}
	
	public void setValor (int Valor)
	{
		this.Valor = Valor;
	}
	
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
	public void setModificadorDef (double setModificadorDef)
	{
		this.modificadorDef = modificadorDef;
	}
	
	public double getDuracion ()
	{
		return Duracion;
	}
	
	public void setDuracion (double Duracion)
	{
		this.Duracion = Duracion;
	}
	
	public String getEfecto ()
	{
		return Efecto;
	}
	
	public void setEfecto (String Efecto)
	{
		this.Efecto = Efecto;
	}
	//Fin Getes y setes
	
	//Metodos añadidos
	
	@Override
	public String toString ()
	{
		String s = (getNombre ()+
					","+getValor ()+
					","+getModificadorDmg ()+
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
		
		if (objeto != null && objeto instanceof Item)
		{
			Item item = (Item) objeto;
			
			if (this.Nombre.equals (item.getNombre ())
				&& this.getValor () == item.getValor ()
				&& this.getModificadorDmg () == item.getModificadorDmg ()
				&& this.getModificadorDef () == item.getModificadorDef ()
				&& this.getDuracion () == item.getDuracion ()
				&& this.Efecto.equals(item.getEfecto ()))
			{
				resultado = true;
			}

		}
		
		return resultado;
	}
	
	@Override
	public int hashCode ()
	{
		
		
		return (Objects.hash (getNombre (), getValor (), getModificadorDmg (), getModificadorDef (), getDuracion (), getEfecto ()));
	}
	
	@Override
	public Item clone ()
	{
		Item copia = new Item ();
		
		try
		{
			copia = (Item) super.clone ();
			
		}
		
		catch (CloneNotSupportedException error)
		{
			System.out.println("No se ha podido clonar el objeto");
		}
		
		return copia;
	}
	
	//Criterio de comparacion: Valor del item
	public int compareTo (Item item)
	{
		int resultado = 0;
		
		if (this.getValor () > item.getValor ())
		{
			resultado = 1;
		}
		
		else if (this.getValor () < item.getValor ())
		{
			resultado = -1;
		}
		
		return resultado;
	}
	//Fin Metodos añadidos
	
}//fin_clase
