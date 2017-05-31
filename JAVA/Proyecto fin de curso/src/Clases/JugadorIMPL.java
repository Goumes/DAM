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
 
public class JugadorIMPL implements Cloneable, Comparable <JugadorIMPL>, Serializable
{
	private static final long serialVersionUID = 1888313045729668467L;
	private String nombre;
	private int vida;
	private double baseDmg;
	private double baseDef;
	private ItemIMPL armadura;
	private ArmaIMPL armaEquipada;
	private int oro;
	private ObjetoIMPL [] inventario;
	
	//Constructores
	public JugadorIMPL ()
	{
		nombre = "";
		vida = 0;
		baseDmg = 0.0;
		baseDef = 0.0;
		armadura = new ItemIMPL ();
		armaEquipada = new ArmaIMPL ();
		oro = 0;
		inventario = null;
	}
	
	public JugadorIMPL (JugadorIMPL jugador)
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
	
	public JugadorIMPL (String nombre, int vida, double baseDmg, double baseDef,ItemIMPL armadura, ArmaIMPL armaEquipada, int oro, ObjetoIMPL [] inventario)
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
	
	public ItemIMPL getArmadura ()
	{
		return armadura;
	}
	
	public void setArmadura (ItemIMPL armadura)
	{
		this.armadura = armadura;
	}
	
	public ArmaIMPL getArmaEquipada ()
	{
		return armaEquipada;
	}
	
	public void setArmaEquipada (ArmaIMPL armaEquipada)
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
	

	public double getModificadorDmg() 
	{
		return armadura.getModificadorDmg();
	}

	public void setModificadorDmg(double modificadorDmg) 
	{
		armadura.setModificadorDmg(modificadorDmg);
	}

	public double getModificadorDef() 
	{
		return armadura.getModificadorDef();
	}

	public void setModificadorDef(double modificadorDef) 
	{
		armadura.setModificadorDef(modificadorDef);
	}

	public double getDuracion() 
	{
		return armadura.getDuracion();
	}

	public void setDuracion(double duracion) 
	{
		armadura.setDuracion(duracion);
	}

	public String getEfecto() 
	{
		return armadura.getEfecto();
	}

	public void setEfecto(String efecto) 
	{
		armadura.setEfecto(efecto);
	}
	
	public double getPrecioArmadura ()
	{
		return armadura.getPrecio();
	}
	
	public void setPrecioArmadura (double precio)
	{
		armadura.setPrecio(precio);
	}

	public double getDmg() 
	{
		return armaEquipada.getDmg();
	}

	public void setDmg(double dmg) 
	{
		armaEquipada.setDmg(dmg);
	}
	
	public double getPrecioArma ()
	{
		return armaEquipada.getPrecio();
	}
	
	public void setPrecioArma (double precio)
	{
		armaEquipada.setPrecio(precio);
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
		
		if (objeto != null && objeto instanceof JugadorIMPL)
		{
			JugadorIMPL jugador = (JugadorIMPL) objeto;
			
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
	public JugadorIMPL clone ()
	{
		JugadorIMPL copia = new JugadorIMPL ();
		
		try
		{
			copia = (JugadorIMPL) super.clone ();
		}
		
		catch (CloneNotSupportedException error)
		{
			System.out.println("No se ha podido clonar el objeto");
		}
		
		return (copia);
	} 
	
	//Criterio de comparacion: vida, baseDmg, baseDef
	public int compareTo (JugadorIMPL jugador)
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
