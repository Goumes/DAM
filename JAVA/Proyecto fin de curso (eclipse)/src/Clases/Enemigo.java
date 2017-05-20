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

import java.util.*;

public class Enemigo implements Cloneable, Comparable <Enemigo>
{
	//Propiedades
	private String nombre;
	private int vida;
	private double dmg;
	private double def;
	private Item dropItem;
	private int dropDinero;
	private int nivel;
	//Fin Propiedades
	
	//Constructores
	public Enemigo ()
	{
		nombre = "";
		vida = 0;
		dmg = 0.0;
		def = 0.0;
		dropItem = new Item ();
		dropDinero = 0;
		nivel = 0;
	}
	
	public Enemigo (Enemigo enemigo)
	{
		this.nombre = enemigo.nombre;
		this.vida = enemigo.vida;
		this.dmg = enemigo.dmg;
		this.def = enemigo.def;
		this.dropItem = enemigo.dropItem;
		this.dropDinero = enemigo.dropDinero;
		this.nivel = enemigo.nivel;
	}
	
	public Enemigo (String nombre, int vida, double dmg, double def, Item dropItem, int dropDinero, int nivel)
	{
		this.nombre = nombre;
		this.vida = vida;
		this.dmg = dmg;
		this.def = def;
		this.dropItem = dropItem;
		this.dropDinero = dropDinero;
		this.nivel = nivel;
	}
	//Fin Constructores
	
	//Getes y setes
	public String getNombre ()
	{
		return nombre;
	}
	
	public void setNombre (String Nombre)
	{
		this.nombre = Nombre;
	}
	
	public int getVida ()
	{
		return vida;
	}
	
	public void setVida (int vida)
	{
		this.vida = vida;
	}
	
	public double getDmg ()
	{
		return dmg;
	}
	
	public void setDmg (double dmg)
	{
		this.dmg = dmg;
	}
	
	public double getDef ()
	{
		return def;
	}
	
	public void setDef (double def)
	{
		this.def = def;
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
		return nivel;
	}
	
	public void setNivel (int nivel)
	{
		this.nivel = nivel;
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
		return (Objects.hash(this.getNombre(), this.getVida(), this.getDmg (), this.getDef (), this.getDropItem(), this.getDropDinero(), this.getNivel()));
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
