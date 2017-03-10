package proyectoPrincipal;

import java.util.Objects;
import java.util.Random;

/* Propiedades.
 * 		Básicas:		boolean Color 			----------			Consultable / Modificable
 * 						String Nombre			----------			Consultable / Modificable
 * 		Derivadas:
 * 		Compartidas:
 * 
 * Restricciones: Ninguna
 * 
 * Criterio de comparación: El color del tablero.
 * Criterio de igualdad: El color del tablero.
 * 
 * Metodos añadidos: elegirColor
 */

public class Jugador implements Cloneable
{
	private boolean Color;
	private String Nombre;
	
	//Constructores
	public Jugador ()
	{
		Color = false;
		Nombre = "";
	}
	
	public Jugador (Jugador jugador)
	{
		this.Color = jugador.Color;
		this.Nombre = jugador.Nombre;
	}
	
	public Jugador (boolean Color, String Nombre)
	{
		this.Color = Color;
		this.Nombre = Nombre;
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
	
	public String getNombre()
	{
		return Nombre;
	}
	
	public void setNombre (String Nombre)
	{
		this.Nombre = Nombre;
	}
	//Fin Getters y setters
	
	//Metodos añadidos
	@Override
	public String toString ()
	{
		String s = this.getNombre() +", " +this.getColor();
		return s;
	}
	
	@Override
	public boolean equals (Object objeto)
	{
		boolean resultado = false;
		
		if (objeto != null && objeto instanceof Jugador)
		{
			Jugador jugador = (Jugador) objeto;
			if (this.getColor() == jugador.getColor ())
			{
				resultado = true;
			}
		}
		return resultado;
	}
	
	@Override
	public int hashCode ()
	{
		return Objects.hash(this.getColor(), this.getNombre());
	}
	
	@Override
	public Jugador clone ()
	{
		Jugador copia = null;
		
		try
		{
			copia = (Jugador) super.clone ();
		}
		
		catch (CloneNotSupportedException error)
		{
			System.out.println("No se ha podido clonar el objeto");
		}
		
		return copia;
	}
	
	public int compareTo (Jugador jugador)
	{
		int resultado = 0;
		
		if (this.getColor() == true && jugador.getColor() == false)
		{
			resultado = 1;
		}
		
		else if (this.getColor() == false && jugador.getColor() == true)
		{
			resultado = -1;
		}
		
		return resultado;
	}
	
	/* Prototipo: Jugador elegirColor ()
	 * Breve comentario: Funcionalidad que elige el color para un jugador de forma aleatoria.
	 * Precondiciones: Ninguna
	 * Entradas: Ninguna
	 * Salidas: Jugador
	 * Entradas/Salidas: Ninguna
	 * Postcondiciones: El atributo Color definido para un jugador.
	 * 
	 * Resguardo: 	public Jugador elegirColor ()
		{
			System.out.println("Llamada al metodo elegirColor");
			return jugador;
		}
	 */
	public Jugador elegirColor ()
	{
		Random aleatorio = new Random ();
		boolean resultado = false;
		int numeroAleatorio = aleatorio.nextInt(2) + 1;
		
		if (numeroAleatorio == 2)
		{
			resultado = true;
		}
		
		this.setColor(resultado);
		
		return this;
	}
	//Fin elegirColor
	
	//Fin Metodos añadidos
}
