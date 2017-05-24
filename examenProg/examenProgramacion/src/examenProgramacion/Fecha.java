package examenProgramacion;

import java.io.Serializable;
import java.util.Objects;

/* Propiedades.
 * 		Basicas: 		int dia			----------	Consultable / Modificable
						int mes 		----------	Consultable / Modificable
						int anio 		----------	Consultable / Modificable
 *		Derivadas:
 * 		Compartidas:
 * 
 * Getters y setters:
 * int getDia ();
 * void setDia (int dia);
 * 
 * int getMes ();
 * void setMes (int mes);
 * 
 * int getAnio ();
 * void setAnio (int anio);
 * 
 * Representacion como cadena : Todos los atributos
 */

public class Fecha implements Cloneable, Comparable <Fecha>, Serializable
{
	private static final long serialVersionUID = -6656459640412755683L;
	private int dia;
	private int mes;
	private int anio;
	
	//Constructores
	public Fecha ()
	{
		dia = 0;
		mes = 0;
		anio = 0;
	}
	
	public Fecha (Fecha fecha)
	{
		this.dia = fecha.dia;
		this.mes = fecha.mes;
		this.anio = fecha.anio;
	}
	
	public Fecha (int dia, int mes, int anio) throws ExamenException
	{
		if (dia < 0 || dia > 31
			|| mes < 0 || mes > 12)
		{
			throw new ExamenException ("La fecha no es valida");
		}
		
		else
		{
			this.dia = dia;
			this.mes = mes;
			this.anio = anio;
		}
	}
	
	//Getters y setters
	public int getDia ()
	{
		return dia;
	}
	
	public void setDia (int dia) throws ExamenException
	{
		if (dia < 0 || dia > 31)
		{
			throw new ExamenException ("El dia no es valido");
		}
		
		else
		{
			this.dia = dia;
		}
		
	}
	
	public int getMes ()
	{
		return mes;
	}
	
	public void setMes (int mes) throws ExamenException
	{
		if (mes < 0 || mes > 12)
		{
			throw new ExamenException ("El mes no es valido");
		}
		
		else
		{
			this.mes = mes;
		}
	}
	
	public int getAnio ()
	{
		return anio;
	}
	
	public void setAnio (int anio)
	{
		this.anio = anio;
	}
	
	//Fin Getters y setters
	
	//Metodos añadidos
	@Override
	public boolean equals (Object objeto)
	{
		boolean resultado = false;
		
		if (objeto != null && objeto instanceof Fecha)
		{
			Fecha fecha = (Fecha) objeto;
			if (this.getDia() == fecha.getDia()
				&& this.getMes() == fecha.getMes()
				&& this.getAnio() == fecha.getAnio())
			{
				resultado = true;
			}
		}
		
		return resultado;
	}
	
	public String toString ()
	{
		return (this.getDia() +","+ this.getMes() +","+ this.getAnio());
	}
	
	@Override
	public int hashCode ()
	{
		return (Objects.hash(this.getDia(), this.getMes(), this.getAnio()));
	}
	
	@Override
	public Fecha clone ()
	{
		Fecha copia = null;
		
		try
		{
			copia = (Fecha) super.clone ();
		}
		
		catch (CloneNotSupportedException e)
		{
			System.out.println("No se ha podido clonar el objeto");
		}
		
		return copia;
	}
	
	public int compareTo (Fecha fecha)
	{
		int resultado = 0;
		
		if ((this.getAnio() > fecha.getAnio())
			|| (this.getAnio() == fecha.getAnio() && this.getMes() > fecha.getMes())
			|| (this.getAnio() == fecha.getAnio() && this.getMes() == fecha.getMes() && this.getDia() > fecha.getDia()))
		{
			resultado = 1;
		}
		
		else if ((this.getAnio() < fecha.getAnio())
				|| (this.getAnio() == fecha.getAnio() && this.getMes() < fecha.getMes())
				|| (this.getAnio() == fecha.getAnio() && this.getMes() == fecha.getMes() && this.getDia() < fecha.getDia()))
		{
			resultado = -1;
		}
		
		return resultado;
	}
	//Fin Metodos añadidos
	
	//Fin Constructores
}
