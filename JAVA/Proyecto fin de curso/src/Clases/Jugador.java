/* Interfaz:
 * 
		Propiedades
			Básicas: 
				String nombre 		 		------------	Consultable / Modificable
				Int vida 	      	 		------------	Consultable / Modificable
				Double baseDmg		 		------------ 	Consultable / Modificable
				Double baseDef		 		------------ 	Consultable / Modificable
				Item Armadura		 		------------	Consultable / Modificable
				Arma armaEquipada    		------------ 	Consultable / Modificable
				Int oro		 	 			------------	Consultable / Modificable
				Inventario inventario 	 	------------	Consultable / Modificable
			Derivadas: 
				Double totalDmg		 		------------	Consultable
				Double totalDef		 		------------	Consultable
			Compartidas:

 * Fórmulas: 
 * 		totalDmg = Daño arma + baseDmg
 * 		totalDef = Armadura + baseDef
 * 
 * Getes y Setes: 
 *  
 * String getNombre ();
 * void setNombre (String nombre);
 * 
 * Int getVida();
 * void setVida (Int vida);
 * 
 * Double getBaseDmg ();
 * void setBaseDmg (double baseDmg);
 * 
 * Double getBaseDef ();
 * void setBaseDmg (double baseDef);
 * 
 * Item getArmadura ();
 * void setArmadura (Item Armadura);
 * 
 * Arma getArmaEquipada ();
 * void setArmaEquipada (Arma armaEquipada);
 * 
 * Int getOro ();
 * Void setOro (Int oro);
 * 
 * Inventario getInventario ();
 * void setInventario (Inventario inventario);
 * 
 * double getTotalDmg ();
 * 
 * double getTotalDef ();
 * 
 * 
 * Métodos añadidos: cambiarHabitacion
 * 
 * Restricciones:
 * 
 */
package Clases;

import java.io.Serializable;
import java.util.*;
 
public class Jugador implements Cloneable, Comparable <Jugador>, Serializable
{
	private static final long serialVersionUID = 1888313045729668467L;
	private String nombre;
	private int vida;
	private double baseDmg;
	private double baseDef;
	private Item armadura;
	private Arma armaEquipada;
	private int oro;
	private ObjetoIMPL [] inventario;
	
	//Constructores
	public Jugador ()
	{
		nombre = "";
		vida = 0;
		baseDmg = 0.0;
		baseDef = 0.0;
		armadura = new Item ();
		armaEquipada = new Arma ();
		oro = 0;
		inventario = null;
	}
	
	public Jugador (Jugador jugador)
	{
		this.nombre = jugador.nombre;
		this.vida = jugador.vida;
		this.baseDmg = jugador.baseDmg;
		this.baseDef = jugador.baseDef;
		this.armadura = jugador.armadura;
		this.armaEquipada = jugador.armaEquipada;
		this.oro = jugador.oro;
		this.inventario = jugador.inventario;
	}
	
	public Jugador (String nombre, int vida, double baseDmg, double baseDef,Item armadura, Arma armaEquipada, int oro, ObjetoIMPL [] inventario)
	{
		this.nombre = nombre;
		this.vida = vida;
		this.baseDmg = baseDmg;
		this.baseDef = baseDef;
		this.armadura = armadura;
		this.armaEquipada = armaEquipada;
		this.oro = oro;
		this.inventario = inventario;
	}
	//Fin Constructores
	
	//Getes y setes
	public String getNombre ()
	{
		return nombre;
	}
	
	public void setNombre (String nombre)
	{
		this.nombre = nombre;
	}
	
	public int getVida ()
	{
		return vida;
	}
	
	public void setVida (int vida)
	{
		this.vida = vida;
	}
	
	public double getBaseDmg ()
	{
		return baseDmg;
	}
	
	public void setBaseDmg (double baseDmg)
	{
		this.baseDmg = baseDmg;
	}
	
	public double getBaseDef ()
	{
		return baseDef;
	}
	
	public void setBaseDef (double baseDef)
	{
		this.baseDef = baseDef;
	}
	
	public Item getArmadura ()
	{
		return armadura;
	}
	
	public void setArmadura (Item armadura)
	{
		this.armadura = armadura;
	}
	
	public Arma getArmaEquipada ()
	{
		return armaEquipada;
	}
	
	public void setArmaEquipada (Arma armaEquipada)
	{
		this.armaEquipada = armaEquipada;
	}
	
	public int getOro ()
	{
		return oro;
	}
	
	public void setOro (int oro)
	{
		this.oro = oro;
	}
	
	public ObjetoIMPL [] getInventario ()
	{
		return inventario;
	}
	
	public void setInventario (ObjetoIMPL [] inventario)
	{
		this.inventario = inventario;
	}
	//Fin Getes y setes
	
	//Metodos Añadidos
	
	@Override
	public String toString ()
	{
		String s = (getNombre ()+
					","+getVida ()+
					","+getBaseDmg ()+
					","+getBaseDef ()+
					","+getArmadura ()+
					","+getArmaEquipada ()+
					","+getOro ());
		return s;
	}
	
	@Override
	public boolean equals (Object objeto)
	{
		boolean resultado = false;
		
		if (objeto != null && objeto instanceof Jugador)
		{
			Jugador jugador = (Jugador) objeto;
			
			if (this.getNombre().equals(jugador.getNombre())
				&& this.getVida () == jugador.getVida ()
				&& this.getBaseDmg () == jugador.getBaseDmg ()
				&& this.getBaseDef () == jugador.getBaseDef ()
				&& this.getArmadura().equals(jugador.getArmadura())
				&& this.getArmaEquipada().equals(jugador.armaEquipada)
				&& this.getOro() == jugador.getOro ()
				&& this.getInventario().equals (jugador.getInventario()))
			{
				resultado = true;
			}
		}
		return resultado;
	}
	
	@Override
	public int hashCode ()
	{
		return (Objects.hash (this.getNombre (), this.getVida (), this.getBaseDmg (), this.getBaseDef (), this.getArmadura (), this.getArmaEquipada (), this.getOro ()));
	}
	
	@Override
	public Jugador clone ()
	{
		Jugador copia = new Jugador ();
		
		try
		{
			copia = (Jugador) super.clone ();
		}
		
		catch (CloneNotSupportedException error)
		{
			System.out.println("No se ha podido clonar el objeto");
		}
		
		return (copia);
	} 
	
	//Criterio de comparacion: vida, baseDmg, baseDef
	public int compareTo (Jugador jugador)
	{
		int resultado = 0;
		
		if (this.getBaseDmg () > jugador.getBaseDmg ())
		{
			resultado = 1;
		}
		
		else if (this.getBaseDmg () < jugador.getBaseDmg ())
		{
			resultado = -1;
		}
		
		return (resultado);
	}
	
	/* Prototipo: void addInventario (ObjetoIMPL objeto)
	 * Breve comentario: Metodo que a�ade un ObjetoIMPL al array inventario
	 * Precondiciones: Ninguna
	 * Entradas: Un ObjetoIMPL
	 * Salidas: Ninguna
	 * Entradas/Salidas: Ninguna
	 * Postcondiciones: Ninguna
	 * 
	 * Resguardo: public void addInventario (ObjetoIMPL objeto)
		{
			System.out.println("Llamada al metodo addInventario");
		}
	 */
	public void addInventario (ObjetoIMPL objeto)
	{
		for (int i = 0; i < this.getInventario().length; i++)
		{
			if (this.getInventario() [i] == null)
			{
				this.getInventario() [i] = objeto;
			}
		}
		
	}
	//Fin addInventario
	
	//Fin Metodos Añadidos
}
