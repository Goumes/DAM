package Clases;

import java.io.Serializable;
import java.util.*;

import Exceptions.JuegoException;
import Interfaces.Jugador;
 
public class JugadorIMPL implements Cloneable, Comparable <JugadorIMPL>, Serializable, Jugador
{
	private static final long serialVersionUID = 1888313045729668467L;
	private String nombre;
	private int vida;
	private int baseDmg;
	private int baseDef;
	private ItemIMPL armadura;
	private ArmaIMPL armaEquipada;
	private int oro;
	private ObjetoIMPL [] inventario;
	
	//Constructores
	public JugadorIMPL ()
	{
		nombre = "";
		vida = 0;
		baseDmg = 0;
		baseDef = 0;
		armadura = new ItemIMPL ();
		armaEquipada = new ArmaIMPL ();
		oro = 0;
		inventario = new ObjetoIMPL [] {};
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
	
	public JugadorIMPL (String nombre, int vida, int baseDmg, int baseDef,ItemIMPL armadura, ArmaIMPL armaEquipada, int oro, ObjetoIMPL [] inventario) throws JuegoException
	{
		if ((nombre.equals(null) || nombre.equals(""))
			|| (vida < 1 )
			|| (baseDmg < 0)
			|| (baseDef < 0)
			|| (oro < 0))
		{
			if (nombre.equals(null) || nombre.equals(""))
			{
				throw new JuegoException ("El nombre no debe estar vacío");
			}
			
			else if (vida < 1) 
			{
				throw new JuegoException ("La vida no puede ser 0 o menor que 0");
			}
			
			else if (baseDmg < 0) 
			{
				throw new JuegoException ("El daño base no puede ser menor que 0");
			}
			
			else if (baseDef < 0) 
			{
				throw new JuegoException ("La defensa base no puede ser menor que 0");
			}
			
			else if (oro < 0) 
			{
				throw new JuegoException ("El oro no puede ser menor que 0");
			}
		}
		else
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
	}
	//Fin Constructores
	
	//Getes y setes
	public String getNombre ()
	{
		return nombre;
	}
	
	public void setNombre (String nombre) throws JuegoException
	{
		if (nombre.equals(null) || nombre.equals(""))
		{
			throw new JuegoException ("El nombre no debe estar vacío");
		}
		else
		{
			this.nombre = nombre;
		}
	}
	
	public int getVida ()
	{
		return vida;
	}
	
	public void setVida (int vida) throws JuegoException
	{
		if (vida < 0)
		{
			throw new JuegoException ("La vida no puede ser menor a 0");
		}
		else
		{
			this.vida = vida;
		}
	}
	
	public int getBaseDmg ()
	{
		return baseDmg;
	}
	
	public void setBaseDmg (int baseDmg) throws JuegoException
	{
		if (baseDmg < 0)
		{
			throw new JuegoException ("El daño base no puede ser menor a 0");
		}
		else
		{
			this.baseDmg = baseDmg;
		}
	}
	
	public int getBaseDef ()
	{
		return baseDef;
	}
	
	public void setBaseDef (int baseDef) throws JuegoException
	{
		if (baseDef < 0)
		{
			throw new JuegoException ("La defensa base no puede ser menor a 0");
		}
		else
		{
			this.baseDef = baseDef;
		}
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
	
	public void setOro (int oro) throws JuegoException
	{
		if (oro < 0)
		{
			throw new JuegoException ("El oro no puede ser menor a 0");
		}
		else
		{
			this.oro = oro;
		}
	}
	
	public ObjetoIMPL [] getInventario ()
	{
		return inventario;
	}
	
	public void setInventario (ObjetoIMPL [] inventario)
	{
		this.inventario = inventario;
	}
	
	public int getTotalDmg ()
	{
		return (baseDmg + armaEquipada.getDmg());
	}
	
	public int getTotalDef ()
	{
		return (baseDef + armadura.getModificadorDef());
	}
	

	public int getArmaduraModificadorDmg() 
	{
		return armadura.getModificadorDmg();
	}

	public void setArmaduraModificadorDmg(int modificadorDmg) 
	{
		armadura.setModificadorDmg(modificadorDmg);
	}

	public int getArmaduraModificadorDef() 
	{
		return armadura.getModificadorDef();
	}

	public void setArmaduraModificadorDef(int modificadorDef) 
	{
		armadura.setModificadorDef(modificadorDef);
	}

	public boolean getArmaduraDuracion() 
	{
		return armadura.getDuracion();
	}

	public void setArmaduraDuracion(boolean duracion) 
	{
		armadura.setDuracion(duracion);
	}

	public String getArmaduraEfecto() 
	{
		return armadura.getEfecto();
	}

	public void setArmaduraEfecto(String efecto) 
	{
		armadura.setEfecto(efecto);
	}
	
	public int getArmaduraPrecio ()
	{
		return armadura.getPrecio();
	}
	
	public void setArmaduraPrecio (int precio) throws JuegoException
	{
		armadura.setPrecio(precio);
	}

	public int getArmaEquipadaDmg() 
	{
		return armaEquipada.getDmg();
	}

	public void setArmaEquipadaDmg(int dmg) 
	{
		armaEquipada.setDmg(dmg);
	}
	
	public int getArmaEquipadaPrecio ()
	{
		return armaEquipada.getPrecio();
	}
	
	public void setArmaEquipadaPrecio (int precio)
	{
		armaEquipada.setPrecio(precio);
	}
	//Fin Getes y setes
	
	//Metodos AÃ±adidos
	
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
	
	/* Prototipo: void imprimirJugador
	 * Breve comentario: Metodo dedicado a imprimir un jugador
	 * Precondiciones: Ninguna
	 * Entradas: Ninguna
	 * Salidas: Ninguna
	 * Entradas/Salidas: Ninguna
	 * Postcondiciones: Ninguna
	 * 
	 * Resguardo: public void imprimirJugador ()
	 * {
	 * 		System.out.println("imprimirJugador");
	 * }
	 */
	public void imprimirJugador ()
	{
		Object [][] tabla = new String[2][5];
		tabla[0] = new String[] { "| Nombre", "| Vida", "| Daño Base", "| Defensa base", "| Riqueza" };
		tabla[1] = new String[] {"| " + this.getNombre(), "| " + String.valueOf (this.getVida ()), "| " + String.valueOf (this.getBaseDmg()), 
								"| " + String.valueOf (this.getBaseDef ()), "| " + String.valueOf (this.getOro ())  };

		for (Object[] fila : tabla) 
		{
			System.out.format("%-20s%-20s%-20s%-20s%-20s\n", fila);
		}
		
		System.out.println();
		/*
		int longitudVida = String.valueOf(this.getVida ()).length();
		int longitudDmg = String.valueOf(1000).length();
		int longitudDef = String.valueOf(1000).length();
		int longitudOro = String.valueOf(1000).length();
		
		System.out.println(" _______________________________________________________________________________________________________________________");
		System.out.println("|                               |                |                      |                       |                       |");
		System.out.println("|            Nombre             |      Vida      |       Daño base      |      Defensa base     |         Riqueza       |");
		System.out.println("|_______________________________|________________|______________________|_______________________|_______________________|");
		System.out.println("|                               |                |                      |                       |                       |");

		if (longitudDmg == 2)
		{
			System.out.println("|                               |                |          "+this.getBaseDmg ()+"          |                       |                       |");
		}

		else if (longitudDmg == 3)
		{
			System.out.println("|                               |                |         "+this.getBaseDmg ()+"          |                       |                       |");
		}
		
		else if (longitudDmg == 4)
		{
			System.out.println("|                               |                |         "+this.getBaseDmg ()+"         |                       |                       |");
		}
		
		
		if (longitudVida == 3)
		{
			System.out.println("|                               |      "+this.getVida()+"       |                      |                       |                       |");
		}
		
		else if (longitudVida == 4)
		{
			System.out.println("|                               |      "+this.getVida()+"      |                      |                       |                       |");
		}
		
		System.out.println("|_______________________________|________________|______________________|_______________________|_______________________|");
		System.out.println();
		*/
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
				&& this.getOro() == jugador.getOro ())
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
	 * Breve comentario: Metodo que añade un ObjetoIMPL al array inventario
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
	
	//Fin Metodos AÃ±adidos
}
