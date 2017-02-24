package ejercicio3;

import java.util.Objects;

/* Propiedades.
 * 		Básicas: 
 * 					int [] Asientos		----------		Consultable
 * 		Derivadas:
 * 		Compartidas:
 * 
 * Getters y setters:
 * 
 * int [] getAsientos ();
 * 
 * Criterio de igualdad: Asientos
 * Criterio de comparación:	Asientos
 * Criterio de hashCode: Todos los atributos
 * 
 * Metodos añadidos: asignarAsiento
 * 
 */

public class Vuelo 
{
	private int [] Asientos;
	
	//Constructores
	public Vuelo () 
	{
		Asientos = new int [20];
		
		for (int i = 0; i < 20; i++)
		{
			Asientos [i] = 0;
		}
	}
	
	public Vuelo (Vuelo vuelo)
	{
		this.Asientos = vuelo.Asientos;
	}
	
	public Vuelo (int [] Asientos) throws ExceptionVuelo
	{
		if (Asientos.length != 20)
		{
			throw new ExceptionVuelo ("El numero de asientos debe ser 20"); //Debatir si es necesario ya que todos serán de 20.
		}
		
		else
		{
			this.Asientos = Asientos;
		}
	}
	//Fin Constructores
	
	//Getters y setters
	public int [] getAsientos ()
	{
		return Asientos;
	}
	//Fin Getters y setters
	
	//Metodos añadidos
	@Override
	public String toString ()
	{
		String s = ""+this.getAsientos();
		return s;
	}
	
	@Override
	public boolean equals (Object objeto)
	{
		boolean resultado = false;
		
		if (objeto != null && objeto instanceof Vuelo)
		{
			Vuelo vuelo = (Vuelo) objeto;
			if (this.getAsientos ().equals (vuelo.getAsientos()))
			{
				resultado = true;
			}
		}
		
		return resultado;
	}
	
	@Override
	public int hashCode ()
	{
		return Objects.hash(this.getAsientos());
	}
	
	@Override
	public Vuelo clone ()
	{
		Vuelo copia = new Vuelo ();
		
		try
		{
			copia = (Vuelo) super.clone();
		}
		catch (CloneNotSupportedException error)
		{
			System.out.println("No se ha podido clonar el objeto");
		}
		return copia;
	}
	
	/*
	public int compareTo (Vuelo vuelo)
	{
		int resultado = 0;
		
		if (this.getAsientos() > vuelo.getAsientos())
		{
			resultado = 1;
		}
		
		else if ()
		{
			resultado = -1;
		}
	}
	*/
	
	/* Prototipo: int [] asignarAsiento (boolean fumador, int [] array)
	 * Breve comentario: Programa que asigne un asiento dependiendo de si son fumadores o no.
	 * Precondiciones: Un array de enteros de 20 posiciones.
	 * Entradas: Un booleano
	 * Salidas: Un entero
	 * Entradas/Salidas: Ninguna
	 * Postcondiciones: El array con un asiento asignado más o igual en caso de que no haya asientos.
	 * Dependiendo de los asientos disponibles, se devolverá: 0 si no hay ningún asiento, 1 si se ha asignado
	 * correctamente, -1 si no hay asientos en la categoría fumadores, -2 si no hay asientos en la categoría
	 * no fumadores.
	 * 
	 * Resguardo: public int [] asignarAsiento (boolean fumador, int [] array)
		{
			System.out.println("Llamada al metodo asignarAsiento");
			System.out.println("Variables: "+fumador);
			
			return array;
		}
	 */
	//Fin asignarAsiento
	public int asignarAsiento (boolean fumador)
	{
		int Asignacion = 1;
		boolean asientoFumador = true;
		boolean asientoNoFumador = true;
		
		if (fumador == true)
		{
			for (int i = 0; i < 15; i++)
			{
				if (Asientos [i] == 0)
				{
					this.Asientos [i] = 1;
				}
				
				else
				{
					asientoFumador = false;
				}
			}
		}
		
		else
		{
			for (int i = 0; i < 15; i++)
			{
				if (Asientos [i] == 0)
				{
					this.Asientos [i] = 1;
				}
				
				else
				{
					asientoNoFumador = false;
				}
			}
		}
		
		if (asientoFumador == false && asientoNoFumador == false)
		{
			Asignacion = 0;
		}
		
		else
		{
			if (asientoFumador == false)
			{
				Asignacion = -1;
			}
			
			else if (asientoNoFumador == false)
			{
				Asignacion = -2;
			}
		}
		return Asignacion;
	}
	//Fin Metodos añadidos
}//fin_clase