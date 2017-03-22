package vestidosJaranasStyle;

import java.util.Objects;

/* Propiedades.
 * 		Básicas:			Disenio disenio			----------		Consultable / Modificable
 * 							int cantidad			----------		Consultable / Modificable
 * 		Derivadas:
 * 		Compartidas:
 * 
 * Getters y setters:
 * 
 * Disenio getDisenio ();
 * void setDisenio (Disenio disenio);
 * 
 * int getCantidad();
 * void setCantidad (int cantidad);
 * 
 * Criterio de comparación: Cantidad.
 * Criterio de igualdad: Cantidad.
 * 
 */

public class Ficha 
{
	private Disenio disenio;
	private int cantidad;
	
	//Constructores
	public Ficha ()
	{
		disenio = null;
		cantidad = 0;
	}
	
	public Ficha (Ficha ficha)
	{
		this.disenio = ficha.disenio;
		this.cantidad = ficha.cantidad;
	}
	
	public Ficha (Disenio disenio, int cantidad)
	{
		this.disenio = disenio;
		this.cantidad = cantidad;
	}
	//Fin Constructores
	
	//Getters y setters
	public Disenio getDisenio ()
	{
		return disenio;
	}
	
	public void setDisenio (Disenio disenio)
	{
		this.disenio = disenio;
	}
	
	public int getCantidad ()
	{
		return cantidad;
	}
	
	public void setCantidad (int cantidad)
	{
		this.cantidad = cantidad;
	}
	//Fin Getters y setters
	
	//Métodos añadidos
	@Override
	public String toString ()
	{
		return this.getCantidad()+", "+this.getDisenio();
	}
	
	@Override
	public boolean equals (Object objeto)
	{
		boolean resultado = false;
		
		if (objeto != null && objeto instanceof Ficha)
		{
			Ficha ficha = (Ficha) objeto;
			
			if (this.getCantidad() == ficha.getCantidad ())
			{
				resultado = true;
			}
		}
		
		return resultado;
	}
	
	@Override
	public int hashCode ()
	{
		return Objects.hash (this.getCantidad(), this.getDisenio());
	}
	
	@Override
	public Ficha clone ()
	{
		Ficha copia = null;
		
		try
		{
			copia = (Ficha) super.clone ();
		}
		
		catch (CloneNotSupportedException error)
		{
			System.out.println("No se ha podido clonar el objeto");
		}
		
		return copia;
	}
	
	public int compareTo (Ficha ficha)
	{
		int resultado = 0;
		
		if (this.getCantidad() > ficha.getCantidad())
		{
			resultado = 1;
		}
		
		else if (this.getCantidad() < ficha.getCantidad())
		{
			resultado = -1;
		}
		
		return resultado;
	}
	//Fin Métodos añadidos
}
