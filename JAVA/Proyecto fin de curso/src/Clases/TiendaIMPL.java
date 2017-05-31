/*
Propiedades.
	Básicas: 	Item Objeto1			-----------    Consultable / Modificable
				Item Objeto2			-----------    Consultable / Modificable
				Item Objeto3			-----------    Consultable / Modificable
				Item Objeto4			-----------    Consultable / Modificable
				Boolean disponibilidad	-----------    Consultable / Modificable
	Derivadas:
	Compartidas:

Fórmulas:

Getes y Setes: 

Item getObjeto1 ();
void setObjeto1 (Item Objeto1);

Item getObjeto2 ();
void setObjeto2 (Item Objeto2);

Item getObjeto3 ();
void setObjeto3 (Item Objeto3);

Item getObjeto4 ();
void setObjeto4 (Item Objeto4);

Boolean getDisponibilidad ();
void setDisponibilidad (Boolean disponibilidad);


Métodos añadidos:

Restricciones:


*/
package Clases;

import java.io.Serializable;
import java.util.*;

public class TiendaIMPL implements Cloneable, Serializable
{
	private static final long serialVersionUID = -9063051013414155572L;
	private ItemIMPL objeto1;
	private ItemIMPL objeto2;
	private ItemIMPL objeto3;
	private ItemIMPL objeto4;
	private boolean disponibilidad;		//Esta variable indica si es posible generar una tienda en la mazmorra. Máximo una por mazmorra.
	
	//Constructores
	public TiendaIMPL ()
	{
		objeto1 = new ItemIMPL ();
		objeto2 = new ItemIMPL ();
		objeto3 = new ItemIMPL ();
		objeto4 = new ItemIMPL ();
		disponibilidad = false;
	}
	
	public TiendaIMPL (TiendaIMPL tienda)
	{
		this.objeto1 = tienda.objeto1;
		this.objeto2 = tienda.objeto2;
		this.objeto3 = tienda.objeto3;
		this.objeto4 = tienda.objeto4;
		this.disponibilidad = tienda.disponibilidad;
	}
	
	public TiendaIMPL (ItemIMPL objeto1, ItemIMPL objeto2, ItemIMPL objeto3, ItemIMPL objeto4, boolean disponibilidad)
	{
		this.objeto1 = objeto1;
		this.objeto2 = objeto2;
		this.objeto3 = objeto3;
		this.objeto4 = objeto4;
		this.disponibilidad = disponibilidad;
	}
	//Fin Constructores
	
	//Getes y setes
	public ItemIMPL getObjeto1 ()
	{
		return objeto1;
	}
	
	public void setObjeto1 (ItemIMPL objeto1)
	{
		this.objeto1 = objeto1;
	}
	
	public ItemIMPL getObjeto2 ()
	{
		return objeto2;
	}
	
	public void setObjeto2 (ItemIMPL objeto2)
	{
		this.objeto2 = objeto2;
	}
	
	public ItemIMPL getObjeto3 ()
	{
		return objeto3;
	}
	
	public void setObjeto3 (ItemIMPL objeto3)
	{
		this.objeto3 = objeto3;
	}
	
	public ItemIMPL getObjeto4 ()
	{
		return objeto4;
	}
	
	public void setObjeto4 (ItemIMPL objeto4)
	{
		this.objeto4 = objeto4;
	}
	
	public boolean getDisponibilidad ()
	{
		return disponibilidad;
	}
	
	public void setDisponibilidad (boolean disponibilidad)
	{
		this.disponibilidad = disponibilidad;
	}
	//Fin Getes y setes
	
	//Metodos añadidos
	@Override
	public String toString ()
	{
		String s =(getObjeto1 ()+
					","+getObjeto2 ()+
					","+getObjeto3 ()+
					","+getObjeto4 ()+
					","+getDisponibilidad ());
		return s;
	}
	
	//Criterio de igualdad: Todos los atributos
	@Override
	public boolean equals (Object objeto)
	{
		boolean resultado = false;
		
		if (objeto != null && objeto instanceof TiendaIMPL)
		{
			TiendaIMPL tienda = (TiendaIMPL) objeto;
			
			if (this.getObjeto1 ().equals (tienda.getObjeto1 ()) 
				&& this.getObjeto2 ().equals (tienda.getObjeto2 ())
				&& this.getObjeto3 ().equals (tienda.getObjeto3 ())
				&& this.getObjeto4 ().equals (tienda.getObjeto4 ())
				&& this.getDisponibilidad () == tienda.getDisponibilidad ())
			{
				resultado = true;
			}
		}
		
		return resultado;
	}
	
	@Override
	public int hashCode ()		//Preguntar si esto es correcto
	{			
		return (Objects.hash (this.getObjeto1 (), this.getObjeto2 (), this.getObjeto3 (), this.getObjeto4 (), getDisponibilidad ()));
	}
	
	@Override
	public TiendaIMPL clone ()
	{
		TiendaIMPL copia = new TiendaIMPL ();
		
		try
		{
			copia = (TiendaIMPL) super.clone ();
		}
		
		catch (CloneNotSupportedException error)
		{
			System.out.println("No se ha podido clonar el objeto");
		}
		
		return copia;
	}
	
	//No tiene sentido hacer el compareTo en este caso.
	//public int compareTo ()
	//{
		//int resultado = 0;
		
		//if ()
		//{
			//resultado = 1;
		//}
		
		//else if ()
		//{
			//resultado = -1;
		//}
		//return resultado;
	//}
	//Fin Metodos añadidos
	
	
}//fin_clase
