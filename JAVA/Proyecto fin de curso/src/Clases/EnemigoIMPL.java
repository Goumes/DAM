package Clases;

import java.io.Serializable;
import java.util.*;

import Exceptions.JuegoException;
import Interfaces.Enemigo;

public class EnemigoIMPL implements Cloneable, Comparable <EnemigoIMPL>, Serializable, Enemigo
{
	private static final long serialVersionUID = 2100044698054182393L;
	//Propiedades
	private String nombre;
	private int vida;
	private double dmg;
	private double def;
	private ItemIMPL dropItem;
	private int dropDinero;
	private int nivel;
	private boolean jefe;
	//Fin Propiedades
	
	//Constructores
	public EnemigoIMPL ()
	{
		nombre = "";
		vida = 0;
		dmg = 0.0;
		def = 0.0;
		dropItem = new ItemIMPL ();
		dropDinero = 0;
		nivel = 0;
		jefe = false;
	}
	
	public EnemigoIMPL (EnemigoIMPL enemigo)
	{
		this.nombre = enemigo.nombre;
		this.vida = enemigo.vida;
		this.dmg = enemigo.dmg;
		this.def = enemigo.def;
		this.dropItem = enemigo.dropItem;
		this.dropDinero = enemigo.dropDinero;
		this.nivel = enemigo.nivel;
		this.jefe = enemigo.jefe;
	}
	
	public EnemigoIMPL (String nombre, int vida, double dmg, double def, ItemIMPL dropItem, int dropDinero, int nivel, boolean jefe)
	{
		this.nombre = nombre;
		this.vida = vida;
		this.dmg = dmg;
		this.def = def;
		this.dropItem = dropItem;
		this.dropDinero = dropDinero;
		this.nivel = nivel;
		this.jefe = jefe;
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
	
	public ItemIMPL getDropItem ()
	{
		return dropItem;
	}
	
	public void setDropItem (ItemIMPL dropItem)
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
	
	public boolean getJefe ()
	{
		return jefe;
	}
	
	public void setJefe (boolean jefe)
	{
		this.jefe = jefe;
	}
	
	public int getDropItemPrecio() 
	{
		return dropItem.getPrecio();
	}

	public void setDropItemPrecio(int precio) throws JuegoException
	{
		dropItem.setPrecio(precio);
	}

	public int getDropItemModificadorDmg() 
	{
		return dropItem.getModificadorDmg();
	}

	public void setDropItemModificadorDmg(int modificadorDmg) 
	{
		dropItem.setModificadorDmg(modificadorDmg);
	}

	public int getDropItemModificadorDef() 
	{
		return dropItem.getModificadorDef();
	}

	public void setDropItemModificadorDef(int modificadorDef) 
	{
		dropItem.setModificadorDef(modificadorDef);
	}

	public boolean getDropItemDuracion() 
	{
		return dropItem.getDuracion();
	}

	public void setDropItemDuracion(boolean duracion) 
	{
		dropItem.setDuracion(duracion);
	}

	public String getDropItemEfecto() 
	{
		return dropItem.getEfecto();
	}

	public void setDropItemEfecto(String efecto) 
	{
		dropItem.setEfecto(efecto);
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
		
		if (objeto != null && objeto instanceof EnemigoIMPL)
		{
			EnemigoIMPL enemigo = (EnemigoIMPL) objeto;
			
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
	public EnemigoIMPL clone ()
	{
		EnemigoIMPL copia = new EnemigoIMPL ();
		
		try
		{
			copia = (EnemigoIMPL) super.clone ();
		}
		
		catch (CloneNotSupportedException error)
		{
			System.out.println("No se ha podido clonar el objeto");
		}
		
		return copia;
	}
	
	//Criterio de comparación: Nivel
	public int compareTo (EnemigoIMPL enemigo)
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
