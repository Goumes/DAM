package examenProgramacion;

import java.io.Serializable;
import java.util.Objects;

/* Propiedades.
 * 		Basicas: 		int Identificador			----------	Consultable
 * 						String nombreFabricante 	----------	Consultable
 * 						int numeroSerie				----------	Consultable
 * 						int unidades				----------	Consultable / Modificable
 * 						double precio 				----------	Consultable / Modificable
 * 		Derivadas:
 * 		Compartidas:
 * 
 * Getters y setters:
 * 
 * int getIdentificador ();
 * String getNombreFabricante ();
 * int getNumeroSerie ();
 * int getUnidades ();
 * void setUnidades (int unidades);
 * double getPrecio ();
 * void setPrecio (double precio);
 * 
 * Orden natural: por nombre de fabricante y numero de serie.
 * Criterio de igualdad: dos unidades de salida son iguales si tienen igual el nombre del fabricante
 * y el número de serie.
 * Representación como cadena: todos los atributos.
 */

public class UnidadSalidaIMPL implements UnidadSalida, Cloneable, Comparable <UnidadSalidaIMPL>, Serializable
{
	private static final long serialVersionUID = -6891503140472668123L;
	public static int contadorIdentificador;
	public int identificador;
	private String nombreFabricante;
	private int numeroSerie;
	private int unidades;
	private double precio;
	
	//Constructores
	public UnidadSalidaIMPL ()
	{
		identificador = contadorIdentificador;
		nombreFabricante = "";
		numeroSerie = 0;
		unidades = 0;
		precio = 0.0;
		contadorIdentificador++;
	}
	
	public UnidadSalidaIMPL (UnidadSalidaIMPL us)
	{
		identificador = contadorIdentificador;
		this.nombreFabricante = us.nombreFabricante;
		this.numeroSerie = us.numeroSerie;
		this.unidades = us.unidades;
		this.precio = us.precio;
		contadorIdentificador++;
	}
	
	public UnidadSalidaIMPL (String nombreFabricante, int numeroSerie, int unidades, double precio) throws ExamenException
	{
		if (nombreFabricante.equals("") || nombreFabricante.equals(null)
				|| numeroSerie < 0
				|| unidades < 0
				|| precio < 0.0)
		{
			if (nombreFabricante.equals("") || nombreFabricante.equals(null))
			{
				throw new ExamenException ("El campo nombreFabricante no puede estar vacio");
			}
			
			else if (numeroSerie < 0)
			{
				throw new ExamenException ("El numeroSerie debe ser positivo");
			}
			
			else if (unidades < 0)
			{
				throw new ExamenException ("El numero de unidades debe ser positivo");
			}
			
			else if (precio < 0.0)
			{
				throw new ExamenException ("El precio debe ser positivo");
			}
			
		}
		
		else
		{
			identificador = contadorIdentificador;
			this.nombreFabricante = nombreFabricante;
			this.numeroSerie = numeroSerie;
			this.unidades = unidades;
			this.precio = precio;
			contadorIdentificador++;
		}
	}
	//Fin Constructores
	
	//Getters y setters
	public int getIdentificador ()
	{
		return identificador;
	}
	
	public String getNombreFabricante ()
	{
		return nombreFabricante;
	}
	
	public int getNumeroSerie ()
	{
		return numeroSerie;
	}
	
	public int getUnidades ()
	{
		return unidades;
	}
	
	public void setUnidades (int unidades) throws ExamenException
	{
		if (unidades < 0)
		{
			throw new ExamenException ("El numero de unidades debe ser positivo");
		}
		else
		{
			this.unidades = unidades;
		}
	}
	
	public double getPrecio ()
	{
		return precio;
	}
	
	public void setPrecio (double precio) throws ExamenException
	{
		if (precio < 0.0)
		{
			throw new ExamenException ("El precio debe ser positivo");
		}
		else
		{
			this.precio = precio;
		}
	}
	//Fin Getters y setters
	
	//Metodos añadidos
	@Override
	public boolean equals (Object objeto)
	{
		boolean resultado = false;
		
		if (objeto != null && objeto instanceof UnidadSalidaIMPL)
		{
			UnidadSalidaIMPL us = (UnidadSalidaIMPL) objeto;
			if (this.getNombreFabricante().equals(us.getNombreFabricante ())
				&& this.getNumeroSerie() == us.getNumeroSerie())
			{
				resultado = true;
			}
		}
		
		return resultado;
	}
	
	@Override
	public String toString ()
	{
		return (this.getIdentificador () + "," 
				+ this.getNombreFabricante() + ","
				+ this.getNumeroSerie() + ","
				+ this.getPrecio() + ","
				+ this.getUnidades());
	}
	
	@Override
	public int hashCode ()
	{
		return (Objects.hash(this.getIdentificador(), this.getNombreFabricante(), this.getNumeroSerie(),
				this.getPrecio(), this.getUnidades()));
	}
	
	@Override
	public UnidadSalidaIMPL clone ()
	{
		UnidadSalidaIMPL copia = null;
		
		try
		{
			copia = (UnidadSalidaIMPL) super.clone ();
		}
		
		catch (CloneNotSupportedException e)
		{
			System.out.println("No se ha podido clonar el objeto");
		}
		
		return copia;
	}
	
	public int compareTo (UnidadSalidaIMPL us)
	{
		int resultado = 0;
		
		if (this.getNombreFabricante ().compareTo(us.getNombreFabricante ()) > 0
			&& this.getNumeroSerie () > us.getNumeroSerie ())
		{
			resultado = 1;
		}
		
		else if (this.getNombreFabricante ().compareTo(us.getNombreFabricante ()) < 0
				&& this.getNumeroSerie () < us.getNumeroSerie ())
		{
			resultado = -1;
		}
		
		return resultado;
	}
	//Fin Metodos añadidos
}
