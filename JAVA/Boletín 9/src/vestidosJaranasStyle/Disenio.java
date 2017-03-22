package vestidosJaranasStyle;

import java.util.Objects;

/* Propiedades.
 * 		Básicas:			int codDisenio			----------		Consultable / Modificable
 * 							double precio			----------		Consultable / Modificable
 * 		Derivadas:
 * 		Compartidas:
 * 
 * Getters y setters:
 * 
 * int getCodDisenio ();
 * void setCodDisenio (int codDisenio);
 * 
 * double getPrecio();
 * void setPrecio (double precio);
 * 
 * Criterio de comparación: codDisenio.
 * Criterio de igualdad: codDisenio.
 * 
 * Restricciones. El codDisenio son 3 dígitos enteros positivos.
 * 
 */

//HashMap para hacer este ejercicio.

public class Disenio 
{
	private int codDisenio;
	private double precio;
	
	//Constructores
	public Disenio ()
	{
		codDisenio = 0;
		precio = 0.0;
	}
	
	public Disenio (Disenio disenio)
	{
		this.codDisenio = disenio.codDisenio;
		this.precio = disenio.precio;
	}
	
	public Disenio (int codDisenio, double precio) throws JaranasStyleException
	{
		if (codDisenio < 0 || codDisenio > 999)
		{
			throw new JaranasStyleException ("El codDisenio debe ser de tres digitos y positivo.");
		}
		else
		{
			this.codDisenio = codDisenio;
			this.precio = precio;
		}
	}
	//Fin Constructores
	
	//Getters y setters
	public int getCodDisenio ()
	{
		return codDisenio;
	}
	
	public void setCodDisenio (int codDisenio) throws JaranasStyleException
	{
		if (codDisenio < 0 || codDisenio > 999)
		{
			throw new JaranasStyleException ("El codDisenio debe ser de tres digitos y positivo.");
		}
		else
		{
			this.codDisenio = codDisenio;
		}
	}
	
	public double getPrecio ()
	{
		return precio;
	}
	
	public void setPrecio (double precio)
	{
		this.precio = precio;
	}
	//Fin Getters y setters
	
	//Métodos añadidos
	@Override
	public String toString ()
	{
		return this.getCodDisenio ()+","+this.getPrecio ();
	}
	
	@Override
	public boolean equals (Object objeto)
	{
		boolean resultado = false;
		
		if (objeto != null && objeto instanceof Disenio)
		{
			Disenio disenio = (Disenio) objeto;
			
			if (this.getCodDisenio () == disenio.getCodDisenio ())
			{
				resultado = true;
			}
		}
		
		return resultado;
	}
	
	@Override
	public int hashCode ()
	{
		return Objects.hash(this.getCodDisenio(), this.getPrecio());
	}
	
	@Override
	public Disenio clone ()
	{
		Disenio copia = null;
		
		try
		{
			copia = (Disenio) super.clone ();
		}
		
		catch (CloneNotSupportedException error)
		{
			System.out.println("No se ha podido clonar el objeto.");
		}
		
		return copia;
	}
	
	public int compareTo (Disenio disenio)
	{
		int resultado = 0;
		
		if (this.getCodDisenio () > disenio.getCodDisenio ())
		{
			resultado = 1;
		}
		
		else if (this.getCodDisenio () < disenio.getCodDisenio ())
		{
			resultado = -1;
		}
		
		return resultado;
	}
	//Fin Métodos añadidos
	
}
