package Clases;

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

public class Partida implements Cloneable
{
	private Mazmorra mazmorra;
	private Jugador jugador;
	
	//Constructores
	public Partida ()
	{
		mazmorra = new Mazmorra ();
		jugador = new Jugador ();
	}
	
	public Partida (Partida partida)
	{
		this.mazmorra = partida.mazmorra;
		this.jugador = partida.jugador;
	}
	
	public Partida (Mazmorra mazmorra, Jugador jugador)
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
	
	public Jugador getJugador ()
	{
		return jugador;
	}
	
	public void setJugador (Jugador jugador)
	{
		this.jugador = jugador;
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
