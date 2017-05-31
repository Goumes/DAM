package Clases;

import java.io.Serializable;
import java.util.Objects;

/* Propiedades.
 * 		Basicas:			Mazmorra mazmorra		----------		CONSULTABLE / MODIFICABLE
 * 							Jugador jugador 		----------		CONSULTABLE / MODIFICABLE
 * 							
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
 */

public class PartidaIMPL implements Cloneable, Serializable
{
	private static final long serialVersionUID = 4877091961554436191L;
	private MazmorraIMPL mazmorra;
	private JugadorIMPL jugador;
	
	//Constructores
	public PartidaIMPL ()
	{
		mazmorra = new MazmorraIMPL ();
		jugador = new JugadorIMPL ();
	}
	
	public PartidaIMPL (PartidaIMPL partida)
	{
		this.mazmorra = partida.mazmorra;
		this.jugador = partida.jugador;
	}
	
	public PartidaIMPL (MazmorraIMPL mazmorra, JugadorIMPL jugador)
	{
		this.mazmorra = mazmorra;
		this.jugador = jugador;
	}
	//Fin Constructores
	
	//Getters y setters
	public MazmorraIMPL getMazmorra ()
	{
		return mazmorra;
	}
	
	public void setMazmorra (MazmorraIMPL mazmorra)
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

	public void setJugadorNombre(String nombre) 
	{
		jugador.setNombre(nombre);
	}

	public int getJugadorVida() 
	{
		return jugador.getVida();
	}

	public void setJugadorVida(int vida) 
	{
		jugador.setVida(vida);
	}

	public double getJugadorBaseDmg() 
	{
		return jugador.getBaseDmg();
	}

	public void setJugadorBaseDmg(double baseDmg) 
	{
		jugador.setBaseDmg(baseDmg);
	}

	public double getJugadorBaseDef() 
	{
		return jugador.getBaseDef();
	}

	public void setJugadorBaseDef(double baseDef) 
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

	public void setJugadorOro(int oro) 
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

	public void setJugadorArmaduraPrecio(double precio) 
	{
		jugador.setArmaduraPrecio(precio);
	}

	public double getJugadorDmg() 
	{
		return jugador.getBaseDmg();
	}

	public void setJugadorDmg(double dmg) 
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
	
	@Override
	public boolean equals (Object object)
	{
		boolean resultado = false;
		
		if (object != null && object instanceof PartidaIMPL)
		{
			PartidaIMPL partida = (PartidaIMPL) object;
			
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
	public PartidaIMPL clone ()
	{
		PartidaIMPL copia = null;
		
		try
		{
			copia = (PartidaIMPL) super.clone();
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
