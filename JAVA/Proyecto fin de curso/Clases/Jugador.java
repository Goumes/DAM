/* Interfaz:
 * 
		Propiedades
			Básicas: 
				String Nombre 		 		------------	Consultable / Modificable
				Int Vida 	      	 		------------	Consultable / Modificable
				Double baseDmg		 		------------ 	Consultable / Modificable
				Double baseDef		 		------------ 	Consultable / Modificable
				Item Armadura		 		------------	Consultable / Modificable
				Arma armaEquipada    		------------ 	Consultable / Modificable
				Int Oro		 	 			------------	Consultable / Modificable
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
 * void setNombre (String Nombre);
 * 
 * Int getVida();
 * void setVida (Int Vida);
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
 * Void setOro (Int Oro);
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
 import java.lang.*;
 import java.util.*;
 
public class Jugador implements Cloneable, Comparable <Jugador>
{
	private String Nombre;
	private int Vida;
	private double baseDmg;
	private double baseDef;
	private Item armadura;
	private Arma armaEquipada;
	private int Oro;
	/* private Inventario inventario */
	
	//Constructores
	public Jugador ()
	{
		Nombre = "";
		Vida = 0;
		baseDmg = 0.0;
		baseDef = 0.0;
		armadura = new Item ();
		armaEquipada = new Arma ();
		Oro = 0;
	}
	
	public Jugador (Jugador jugador)
	{
		this.Nombre = jugador.Nombre;
		this.Vida = jugador.Vida;
		this.baseDmg = jugador.baseDmg;
		this.baseDef = jugador.baseDef;
		this.armadura = jugador.armadura;
		this.armaEquipada = jugador.armaEquipada;
		this.Oro = Oro;
	}
	
	public Jugador (String Nombre, int Vida, double baseDmg, double baseDef,Item armadura, Arma armaEquipada, int Oro)
	{
		this.Nombre = Nombre;
		this.Vida = Vida;
		this.baseDmg = baseDmg;
		this.baseDef = baseDef;
		this.armadura = armadura;
		this.armaEquipada = armaEquipada;
		this.Oro = Oro;
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
	
	public void setArmadura (Item Armadura)
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
		return Oro;
	}
	
	public void setOro (int Oro)
	{
		this.Oro = Oro;
	}
	//Fin Getes y setes
	
	//Metodos Añadidos
	
	@Override
	public String toString ()
	{
		String s = ("Nombre: "+getNombre ()+
					", Vida: "+getVida ()+
					", baseDmg: "+getBaseDmg ()+
					", baseDef: "+getBaseDef ()+
					", armadura: "+getArmadura ()+
					", armaEquipada: "+getArmaEquipada ()+
					", Oro: "+getOro ());
		return s;
	}
	
	//Criterio de igualdad: baseDmg, baseDef, Nombre, Vida, armadura, armaEquipada, Oro
	@Override
	public boolean equals (Object objeto)
	{
		boolean resultado = false;
		
		if (objeto != null && objeto instanceof Jugador)
		{
			Jugador jugador = (Jugador) objeto;
			
			if (this.Nombre.equals (jugador.getNombre ()) 
				&& this.getVida () == jugador.getVida ()
				&& this.getBaseDmg () == jugador.getBaseDmg ()
				&& this.getBaseDef () == jugador.getBaseDef ()
				&& this.armadura.equals (jugador.getArmadura ())
				&& this.armaEquipada.equals (jugador.getArmaEquipada ())
				&& this.getOro () == getOro ())
			{
				resultado = true;
			}
		}
		return resultado;
	}
	
	@Override
	public int hashCode ()
	{
		return (Objects.hash (getNombre (), getVida (), getBaseDmg (), getBaseDef (), getArmadura (), getArmaEquipada (), getOro ()));
	}
	
	@Override
	public Jugador clone ()
	{
		Jugador copia = new Jugador ();
		
		try
		{
		copia = (Jugador) super.clone ();
		copia.armaEquipada = armaEquipada.clone ();
		copia.armadura = armadura.clone ();
		}
		
		catch (CloneNotSupportedException error)
		{
			System.out.println("No se ha podido clonar el objeto");
		}
		
		return (copia);
	} 
	
	//Criterio de comparación: baseDmg
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
	
	//Fin Metodos Añadidos
}
