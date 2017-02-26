package proyectoPrincipal;

import java.util.Objects;

/* Propiedades.
 * 		Básicas:		boolean Color 			----------			Consultable / Modificable
 * 						String Tipo			----------			Consultable / Modificable
 * 		Derivadas:
 * 		Compartidas:
 * 
 * Restricciones: Las piezas sólo pueden ser del tipo: Rey, Dama, Torre, Alfil, Caballo, Peon.
 * 
 * Criterio de comparación: El tipo y el color de la pieza.
 * Criterio de igualdad: El tipo y el color de la pieza.
 */

public class Pieza implements Cloneable, Comparable <Pieza>
{
	private boolean Color;
	private String Tipo;
	
	//Constructores
	public Pieza ()
	{
		Color = true;
		Tipo = "Peon";
	}
	
	public Pieza (Pieza pieza)
	{
		this.Color = pieza.Color;
		this.Tipo = pieza.Tipo;
	}
	
	public Pieza (boolean Color, String Tipo) throws ExceptionAjedrez
	{
		if (Tipo != "Rey" 
			&& Tipo != "Dama"
			&& Tipo != "Torre"
			&& Tipo != "Alfil"
			&& Tipo != "Caballo"
			&& Tipo != "Peon")
		{
			throw new ExceptionAjedrez ("Error. No se ha podido crear esta pieza.");
		}
		else
		{
			this.Tipo = Tipo;
		}
		
		this.Color = Color;
	}
	//Fin Constructores
	
	//Getters y setters
	public boolean getColor ()
	{
		return Color;
	}
	
	public void setColor (boolean Color)
	{
		this.Color = Color;
	}
	
	public String getTipo ()
	{
		return Tipo;
	}
	
	public void setTipo (String Tipo) throws ExceptionAjedrez
	{
		if (Tipo != "Rey" 
				&& Tipo != "Dama"
				&& Tipo != "Torre"
				&& Tipo != "Alfil"
				&& Tipo != "Caballo"
				&& Tipo != "Peon")
			{
				throw new ExceptionAjedrez ("Error. No se ha podido definir este Tipo.");
			}
			else
			{
				this.Tipo = Tipo;
			}
	}
	//Fin Getters y setters
	
	//Metodos añadidos
	@Override
	public String toString ()
	{
		String s = ""+this.getColor()+", "+this.getTipo(); 
		return s;
	}
	
	@Override
	public boolean equals (Object objeto)
	{
		boolean resultado = false;
		
		if (objeto != null && objeto instanceof Pieza)
		{
			Pieza pieza = (Pieza) objeto;
			if (this.getColor() == pieza.getColor()
				&& this.getTipo().equals (pieza.getTipo()))
			{
				resultado = true;
			}
		}
		return resultado;
	}
	
	@Override
	public int hashCode ()
	{
		return Objects.hash (this.getColor(), this.getTipo());
	}
	
	@Override
	public Pieza clone ()
	{
		Pieza copia = null;
		
		try
		{
			copia = (Pieza) super.clone ();
			copia.Tipo = (String) this.getTipo();
		}
		
		catch (CloneNotSupportedException error)
		{
			System.out.println("No se ha podido clonar el objeto");
		}
		
		return copia;
	}
	
	public int compareTo (Pieza pieza)
	{
		int resultado = 0;
		
		if (((Boolean) (this.getColor())).compareTo((Boolean) (pieza.getColor())) == 1		//Casteo el boolean a su clase de envoltura para poder usar el compareTo de Boolean.
			&& this.getTipo().compareTo(pieza.getTipo()) == 1)
		{
			resultado = 1;
		}
		
		else if (((Boolean) (this.getColor())).compareTo((Boolean) (pieza.getColor())) == -1
				&& this.getTipo().compareTo(pieza.getTipo()) == -1)
		{
			resultado = -1;
		}
		return resultado;
	}
	//Fin Metodos añadidos
	
	
}//Fin_clase