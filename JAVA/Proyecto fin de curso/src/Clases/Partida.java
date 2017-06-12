package Clases;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

import Exceptions.JuegoException;

/* Propiedades
 * 		Basicas:		Mazmorra mazmorra		---------	Consultable / Modificable
 * 						JugadorIMPL jugador		----------	Consultable / Modificable
 * 		Derivadas:
 * 		Compartidas:
 * 
 * Getters y setters:
 * 
 * Mazmorra getMazmorra ();
 * void setMazmorra (Mazmorra mazmorra); 
 * 
 * Jugador getJugador ();
 * void setJugador (Jugador jugador);
 * 
 */
public class Partida implements Cloneable, Serializable
{
	private static final long serialVersionUID = 4877091961554436191L;
	private Mazmorra mazmorra;
	private JugadorIMPL jugador;
	
	//Constructores
	public Partida ()
	{
		mazmorra = new Mazmorra ();
		jugador = new JugadorIMPL ();
	}
	
	public Partida (Partida partida)
	{
		this.mazmorra = partida.mazmorra;
		this.jugador = partida.jugador;
	}
	
	public Partida (Mazmorra mazmorra, JugadorIMPL jugador)
	{
		this.mazmorra = mazmorra;
		this.jugador = jugador;
	}
	//Fin Constructores
	
	//Getters y setters
	public Mazmorra getMazmorra ()
	{
		return mazmorra;
	}
	
	public void setMazmorra (Mazmorra mazmorra)
	{
		this.mazmorra = mazmorra;
	}
	
	public JugadorIMPL getJugador ()
	{
		return jugador;
	}
	
	public void setJugador (JugadorIMPL jugador)
	{
		this.jugador = jugador;
	}
	
	public String getNombre() 
	{
		return jugador.getNombre();
	}

	public void setJugadorNombre(String nombre) throws JuegoException
	{
		jugador.setNombre(nombre);
	}

	public int getJugadorVida() 
	{
		return jugador.getVida();
	}

	public void setJugadorVida(int vida) throws JuegoException
	{
		jugador.setVida(vida);
	}

	public int getJugadorBaseDmg() 
	{
		return jugador.getBaseDmg();
	}

	public void setJugadorBaseDmg(int baseDmg) throws JuegoException
	{
		jugador.setBaseDmg(baseDmg);
	}

	public int getJugadorBaseDef() 
	{
		return jugador.getBaseDef();
	}

	public void setJugadorBaseDef(int baseDef) throws JuegoException
	{
		jugador.setBaseDef(baseDef);
	}

	public ItemIMPL getJugadorArmadura() 
	{
		return jugador.getArmadura();
	}

	public void setJugadorArmadura(ItemIMPL armadura) 
	{
		jugador.setArmadura(armadura);
	}

	public ArmaIMPL getJugadorArmaEquipada() 
	{
		return jugador.getArmaEquipada();
	}

	public void setJugadorArmaEquipada(ArmaIMPL armaEquipada) 
	{
		jugador.setArmaEquipada(armaEquipada);
	}

	public int getJugadorOro() 
	{
		return jugador.getOro();
	}

	public void setJugadorOro(int oro) throws JuegoException
	{
		jugador.setOro(oro);
	}

	public ArrayList <ObjetoIMPL> getJugadorInventario() 
	{
		return jugador.getInventario();
	}

	public void setJugadorInventario(ArrayList <ObjetoIMPL>  inventario) 
	{
		jugador.setInventario(inventario);
	}

	public int getJugadorModificadorDmg() 
	{
		return jugador.getArmaduraModificadorDmg();
	}

	public void setJugadorModificadorDmg(int modificadorDmg) 
	{
		jugador.setArmaduraModificadorDmg(modificadorDmg);
	}

	public int getJugadorModificadorDef() 
	{
		return jugador.getArmaduraModificadorDef();
	}

	public void setJugadorModificadorDef(int modificadorDef) 
	{
		jugador.setArmaduraModificadorDef(modificadorDef);
	}

	public boolean getJugadorDuracion() 
	{
		return jugador.getArmaduraDuracion();
	}

	public void setJugadorDuracion(boolean duracion) 
	{
		jugador.setArmaduraDuracion(duracion);
	}

	public String getJugadorEfecto() 
	{
		return jugador.getArmaduraEfecto();
	}

	public void setJugadorEfecto(String efecto) 
	{
		jugador.setArmaduraEfecto(efecto);
	}

	public int getJugadorArmaduraPrecio() 
	{
		return jugador.getArmaduraPrecio();
	}

	public void setJugadorArmaduraPrecio(int precio) throws JuegoException
	{
		jugador.setArmaduraPrecio(precio);
	}

	public int getJugadorDmg() 
	{
		return jugador.getBaseDmg();
	}

	public void setJugadorDmg(int dmg) throws JuegoException
	{
		jugador.setBaseDmg(dmg);
	}

	public int getJugadorArmaPrecio() 
	{
		return jugador.getArmaEquipadaPrecio();
	}

	public void setJugadorArmaPrecio(int precio) 
	{
		jugador.setArmaEquipadaPrecio(precio);
	}
	//Fin Getters y setters
	
	//Metodos añadidos
	@Override
	public String toString ()
	{
		return (this.getJugador().toString()+","+this.getMazmorra().toString());
	}
	
	public void imprimirJugador() 
	{
		jugador.imprimirJugador();
	}

	@Override
	public boolean equals (Object object)
	{
		boolean resultado = false;
		
		if (object != null && object instanceof Partida)
		{
			Partida partida = (Partida) object;
			
			if (this.getJugador().equals(partida.getJugador())
				&& this.getMazmorra().equals(partida.getMazmorra()))
			{
				resultado = true;
			}
		}
		
		return resultado;
	}
	
	@Override
	public int hashCode ()
	{
		return (Objects.hash(this.getJugador(), this.getMazmorra()));
	}
	
	@Override /* Hecho en profundidad porque en superficie no tiene sentido */
	public Partida clone ()
	{
		Partida copia = null;
		
		try
		{
			copia = (Partida) super.clone();
			this.jugador = copia.getJugador();
			this.mazmorra = copia.getMazmorra();
		}
		
		catch (CloneNotSupportedException e)
		{
			System.out.println(e);
		}
		
		return copia;
	}
	//Fin Metodos añadidos
}
