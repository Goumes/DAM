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
	Habitacion [] [] mapa;
	
	//Constructores
	public Mazmorra ()
	{
		mapa = new Habitacion [][] {};
	}
	
	public Mazmorra (Mazmorra mazmorra)
	{
		this.mapa = mazmorra.mapa;
	}
	
	public Mazmorra (Habitacion [][] mapa) throws JuegoException
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
	public Habitacion [] [] getMapa ()
	{
		return mapa;
	}
	
	public void setMapa (Habitacion [][] mapa) throws JuegoException
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
	
	
	/* Prototipo: generarMazmorraAleatoria ()
	 * Breve comentario: Metodo dedicado a la generación aleatoria de la mazmorra
	 * Precondiciones: Ninguna
	 * Entradas: Ninguna
	 * Salidas: Ninguna
	 * Entradas/Salidas: Ninguna
	 * Postcondiciones: Ninguna
	 * 
	 * Resguardo: public void generarMazmorraAleatoria ()
		{
			System.out.println("Llamada al metodo generarMazmorraAleatoria");
		}
	 */
	public void generarMazmorraAleatoria ()
	{
		 
	}
	//Fin generarMazmorraAleatoria
	
	//Fin Metodos añadidos
	
}
