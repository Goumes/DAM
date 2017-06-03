package Clases;

import java.io.Serializable;
import java.util.Objects;

import Exceptions.JuegoException;
import Interfaces.Habitacion;

/* Propiedades:
 * 		Basicas:	Habitacion [] [] mapa		----------		Consultable/Modificable
 * 		Derivadas:
 * 		Compartidas:
 * 
 * Getters y setters:
 * 
 * Habitacion [] [] getMapa ();
 * void setMapa (Habitacion [] [] mapa);
 * 
 * Metodos añadidos:
 * 
 * generarMazmorraAleatoria ();
 */

public class Mazmorra implements Serializable, Cloneable
{
	private static final long serialVersionUID = 5099384049691550127L;
	HabitacionIMPL [] [] mapa;
	
	//Constructores
	public Mazmorra ()
	{
		mapa = new HabitacionIMPL [][] {};
	}
	
	public Mazmorra (Mazmorra mazmorra)
	{
		this.mapa = mazmorra.mapa;
	}
	
	public Mazmorra (HabitacionIMPL [][] mapa) throws JuegoException
	{
		if ((mapa.length == 5) && (mapa [0].length == 5))
		{
			this.mapa = mapa;
		}
		else
		{
			throw new JuegoException ("Error, el tablero debe ser de 5 x 5");
		}
	}
	//Fin Constructores
	
	//Getters y setters
	public HabitacionIMPL [] [] getMapa ()
	{
		return mapa;
	}
	
	public void setMapa (HabitacionIMPL [][] mapa) throws JuegoException
	{
		if ((mapa.length == 5) && (mapa [0].length == 5))
		{
			this.mapa = mapa;
		}
		else
		{
			throw new JuegoException ("Error, el tablero debe ser de 5 x 5");
		}
	}
	//Fin Getters y setters
	
	//Metodos añadidos
	@Override
	public boolean equals (Object objeto)
	{
		boolean resultado = false;
		
		if (objeto != null && objeto instanceof Mazmorra)
		{
			Mazmorra mazmorra = (Mazmorra) objeto;
			
			if (this.getMapa ().length == mazmorra.getMapa ().length)
			{
				resultado = true;
			}
		}
		
		return resultado;
	}
	
	@Override
	public int hashCode ()
	{
		return (Objects.hash ((Object [])this.getMapa()));
	}
	
	//Fin Metodos añadidos
	
}
