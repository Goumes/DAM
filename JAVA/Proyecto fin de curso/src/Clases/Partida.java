package Clases;

import java.io.Serializable;
import java.util.Objects;

import Exceptions.JuegoException;

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

	public double getJugadorBaseDmg() 
	{
		return jugador.getBaseDmg();
	}

	public void setJugadorBaseDmg(double baseDmg) throws JuegoException
	{
		jugador.setBaseDmg(baseDmg);
	}

	public double getJugadorBaseDef() 
	{
		return jugador.getBaseDef();
	}

	public void setJugadorBaseDef(double baseDef) throws JuegoException
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

	public ObjetoIMPL[] getJugadorInventario() 
	{
		return jugador.getInventario();
	}

	public void setJugadorInventario(ObjetoIMPL[] inventario) 
	{
		jugador.setInventario(inventario);
	}

	public double getJugadorModificadorDmg() 
	{
		return jugador.getArmaduraModificadorDmg();
	}

	public void setJugadorModificadorDmg(double modificadorDmg) 
	{
		jugador.setArmaduraModificadorDmg(modificadorDmg);
	}

	public double getJugadorModificadorDef() 
	{
		return jugador.getArmaduraModificadorDef();
	}

	public void setJugadorModificadorDef(double modificadorDef) 
	{
		jugador.setArmaduraModificadorDef(modificadorDef);
	}

	public double getJugadorDuracion() 
	{
		return jugador.getArmaduraDuracion();
	}

	public void setJugadorDuracion(double duracion) 
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

	public double getJugadorArmaduraPrecio() 
	{
		return jugador.getArmaduraPrecio();
	}

	public void setJugadorArmaduraPrecio(double precio) throws JuegoException
	{
		jugador.setArmaduraPrecio(precio);
	}

	public double getJugadorDmg() 
	{
		return jugador.getBaseDmg();
	}

	public void setJugadorDmg(double dmg) throws JuegoException
	{
		jugador.setBaseDmg(dmg);
	}

	public double getJugadorArmaPrecio() 
	{
		return jugador.getArmaEquipadaPrecio();
	}

	public void setJugadorArmaPrecio(double precio) 
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
