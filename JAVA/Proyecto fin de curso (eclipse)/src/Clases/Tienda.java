/*
Propiedades.
	Básicas: 	Item Objeto1			-----------    Consultable / Modificable
				Item Objeto2			-----------    Consultable / Modificable
				Item Objeto3			-----------    Consultable / Modificable
				Item Objeto4			-----------    Consultable / Modificable
				Boolean Disponibilidad	-----------    Consultable / Modificable
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
void setDisponibilidad (Boolean Disponibilidad);


Métodos añadidos:

Restricciones:


*/
package Clases;

import java.util.*;

public class Tienda implements Cloneable
{
	private Item objeto1;
	private Item objeto2;
	private Item objeto3;
	private Item objeto4;
	private boolean Disponibilidad;		//Esta variable indica si es posible generar una tienda en la mazmorra. Máximo una por mazmorra.
	
	//Constructores
	public Tienda ()
	{
		objeto1 = new Item ();
		objeto2 = new Item ();
		objeto3 = new Item ();
		objeto4 = new Item ();
		Disponibilidad = false;
	}
	
	public Tienda (Tienda tienda)
	{
		this.objeto1 = tienda.objeto1;
		this.objeto2 = tienda.objeto2;
		this.objeto3 = tienda.objeto3;
		this.objeto4 = tienda.objeto4;
		this.Disponibilidad = tienda.Disponibilidad;
	}
	
	public Tienda (Item objeto1, Item objeto2, Item objeto3, Item objeto4, boolean Disponibilidad)
	{
		this.objeto1 = objeto1;
		this.objeto2 = objeto2;
		this.objeto3 = objeto3;
		this.objeto4 = objeto4;
		this.Disponibilidad = Disponibilidad;
	}
	//Fin Constructores
	
	//Getes y setes
	public Item getObjeto1 ()
	{
		return objeto1;
	}
	
	public void setObjeto1 (Item objeto1)
	{
		this.objeto1 = objeto1;
	}
	
	public Item getObjeto2 ()
	{
		return objeto2;
	}
	
	public void setObjeto2 (Item objeto2)
	{
		this.objeto2 = objeto2;
	}
	
	public Item getObjeto3 ()
	{
		return objeto3;
	}
	
	public void setObjeto3 (Item objeto3)
	{
		this.objeto3 = objeto3;
	}
	
	public Item getObjeto4 ()
	{
		return objeto4;
	}
	
	public void setObjeto4 (Item objeto4)
	{
		this.objeto4 = objeto4;
	}
	
	public boolean getDisponibilidad ()
	{
		return Disponibilidad;
	}
	
	public void setDisponibilidad (boolean Disponibilidad)
	{
		this.Disponibilidad = Disponibilidad;
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
		
		if (objeto != null && objeto instanceof Tienda)
		{
			Tienda tienda = (Tienda) objeto;
			
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
	public Tienda clone ()
	{
		Tienda copia = new Tienda ();
		
		try
		{
			copia = (Tienda) super.clone ();
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
