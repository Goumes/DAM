/*
Propiedades.
	Básicas: 
				String Nombre		------------	Consultable / Modificable
				Int Vida			------------	Consultable / Modificable
				Item dropItem		------------	Consultable / Modificable
				Int dropDinero		------------	Consultable / Modificable
				Double Dmg			------------	Consultable / Modificable
				Double Def			------------	Consultable / Modificable
				Int Nivel			------------	Consultable / Modificable
	Derivadas:
	Compartidas:

Fórmulas:

Getes y Setes: 
string getNombre ();
void setNombre (string Nombre);

Int getVida ();
void setVida (Int Vida); 

Double getDmg ();
void setDmg (double Dmg);

Double getDef ();
void setDef (double Def);

Item getDropItem ();
void setDropItem (Item dropItem);

Int getDropDinero ();
void setDropDinero (Int dropDinero);

Int getNivel ();
void setNivel (Int Nivel);



Métodos añadidos:

Restricciones:
*/
package Clases;
import java.lang.*;
import java.util.*;

public class Enemigo implements Cloneable, Comparable <Enemigo>
{
	//Propiedades
	private String Nombre;
	private int Vida;
	private double Dmg;
	private double Def;
	private Item dropItem;
	private int dropDinero;
	private int Nivel;
	//Fin Propiedades
	
	//Constructores
	public Enemigo ()
	{
		Nombre = "";
		Vida = 0;
		Dmg = 0.0;
		Def = 0.0;
		dropItem = new Item ();
		dropDinero = 0;
		Nivel = 0;
	}
	
	public Enemigo (Enemigo enemigo)
	{
		this.Nombre = enemigo.Nombre;
		this.Vida = enemigo.Vida;
		this.Dmg = enemigo.Dmg;
		this.Def = enemigo.Def;
		this.dropItem = enemigo.dropItem;
		this.dropDinero = enemigo.dropDinero;
		this.Nivel = enemigo.Nivel;
	}
	
	public Enemigo (String Nombre, int Vida, double Dmg, double Def, Item dropItem, int dropDinero, int Nivel)
	{
		this.Nombre = Nombre;
		this.Vida = Vida;
		this.Dmg = Dmg;
		this.Def = Def;
		this.dropItem = dropItem;
		this.dropDinero = dropDinero;
		this.Nivel = Nivel;
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
	
	public int getVida ()
	{
		return Vida;
	}
	
	public void setVida (int Vida)
	{
		this.Vida = Vida;
	}
	
	public double getDmg ()
	{
		return Dmg;
	}
	
	public void setDmg (double Dmg)
	{
		this.Dmg = Dmg;
	}
	
	public double getDef ()
	{
		return Def;
	}
	
	public void setDef (double Def)
	{
		this.Def = Def;
	}
	
	public Item getDropItem ()
	{
		return dropItem;
	}
	
	public void setDropItem (Item dropItem)
	{
		this.dropItem = dropItem;
	}
	
	public int getDropDinero ()
	{
		return dropDinero;
	}
	
	public void setDropDinero (int dropDinero)
	{
		this.dropDinero = dropDinero;
	}
	
	public int getNivel ()
	{
		return Nivel;
	}
	
	public void setNivel (int Nivel)
	{
		this.Nivel = Nivel;
	}
	//Fin Getes y setes
	
	//Metodos añadidos
	@Override
	public String toString()
	{
		String s = (getNombre ()+
					","+getVida ()+
					","+getDmg ()+
					","+getDef ()+
					","+getDropItem ()+
					","+getDropDinero ()+
					","+getNivel ());
		return s;
	}
	
	//Criterio de igualdad: Todas las propiedades del objeto.
	@Override
	public boolean equals (Object objeto)
	{
		boolean resultado = false;
		
		if (objeto != null && objeto instanceof Enemigo)
		{
			Enemigo enemigo = (Enemigo) objeto;
			
			if (this.getNombre ().equals (enemigo.getNombre ())
				&& this.getVida () == enemigo.getVida () 
				&& this.getDmg () == enemigo.getDmg ()
				&& this.getDef () == enemigo.getDef ()
				&& this.getDropItem ().equals (enemigo.getDropItem ()) 
				&& this.getDropDinero () == enemigo.getDropDinero ()
				&& this.getNivel () == enemigo.getNivel ())
			{
				resultado = true;
			}
		}
		
		return resultado;
	}
	
	@Override
	public int hashCode ()
	{
		//return (Objects.hash (Nombre, Vida, Dmg, Def, dropItem, dropDinero, Nivel));
		return (int)((Math.pow (this.getDef (), this.getDropDinero ())) * this.getDmg ());
	}
	
	@Override
	public Enemigo clone ()
	{
		Enemigo copia = new Enemigo ();
		
		try
		{
			copia = (Enemigo) super.clone ();
		}
		
		catch (CloneNotSupportedException error)
		{
			System.out.println("No se ha podido clonar el objeto");
		}
		
		return copia;
	}
	
	//Criterio de comparación: Nivel
	public int compareTo (Enemigo enemigo)
	{
		int resultado = 0;
		
		if (this.getNivel () > enemigo.getNivel ())
		{
			resultado = 1;
		}
		
		else if (this.getNivel () < enemigo.getNivel ())
		{
			resultado = -1;
		}
		
		return resultado;
	}
	//Fin Metodos añadidos
	
}//fin_clase
