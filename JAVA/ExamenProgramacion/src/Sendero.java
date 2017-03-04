/* Propiedades
 * 		Básicas: 				String Nivel				----------			Consultable / Modificable
 * 									String Nombre 		----------			Consultable / Modificable
 * 									int Duracion			----------			Consutlable / Modificable
 * 		Derivadas:
 * 		Compartidas:
 * 
 * Getters y setters:
 * 
 * String getNivel ();
 * void setNivel (String Nivel);
 * 
 * String getNombre ();
 * void setNombre (String Nombre);
 * 
 * int Duracion ();
 * void setDuracion (int Duacion);
 * 
 * Restricciones: El nivel sólo puede ser BAJO, MEDIO o ALTO. La duracion debe ser positiva.
 * 
 * Orden natural: Duracion.
 * Criterio de igualdad: Duracion.
 * Representación como cadena: Nivel, Nombre, Duracion (separados por comas)
 * hashCode en función de todos los atributos.
 * 
 */
import java.util.*;

public class Sendero
{
	private String Nivel;
	private String Nombre;
	private int Duracion;
	
	//Constructores
	public Sendero () //Por defecto
	{
		 Nivel = "";
		 Nombre = "";
		 Duracion = 1;
	}
	
	public Sendero (Sendero sendero) //De copia
	{
		this.Nivel = sendero.Nivel;
		this.Nombre = sendero.Nombre;
		this.Duracion = sendero.Duracion;
	}
	
	public Sendero (String Nivel, String Nombre, int Duracion) throws ExamenException //Con parametros
	{
		if (Nivel != "ALTO" && Nivel != "MEDIO" && Nivel != "BAJO")
		{
			throw new ExamenException ("El nivel debe ser ALTO, MEDIO, o BAJO");
		}
		else
		{
			this.Nivel = Nivel;
		}
		
		if (Duracion < 1)
		{
			throw new ExamenException ("La duracion debe ser positiva y mayor que 0");
		}
		else
		{
			this.Duracion = Duracion;
		}
		
		this.Nombre = Nombre;
	}
	//Fin Constructores
	
	//Getters y setters
	public String getNivel ()
	{
		return Nivel;
	}
	
	public void setNivel (String nivel) throws ExamenException
	{
		if (Nivel != "ALTO" && Nivel != "MEDIO" && Nivel != "BAJO")
		{
			throw new ExamenException ("El nivel debe ser ALTO, MEDIO, o BAJO");
		}
		else
		{
			this.Nivel = Nivel;
		}
	}
	
	public String getNombre ()
	{
		return Nombre;
	}
	
	public void setNombre (String Nombre)
	{
		this.Nombre = Nombre;
	}
	
	public int getDuracion ()
	{
		return Duracion;
	}
	
	public void setDuracion (int Duracion) throws ExamenException
	{
		if (Duracion < 1)
		{
			throw new ExamenException ("La duracion debe ser positiva y mayor que 0");
		}
		else
		{
			this.Duracion = Duracion;
		}
	}
	//Fin Getters y setters
	
	//Metodos añadidos
	@Override
	public String toString ()
	{
		String s = this.getNivel () + "," +this.getNombre () + "," +this.getDuracion ();
		return s;
	}
	
	@Override
	public boolean equals (Object objeto)
	{
		boolean resultado = false;
		
		if (objeto != null & objeto instanceof Sendero)
		{
			Sendero sendero = (Sendero) objeto;
			if (this.getDuracion () == sendero.getDuracion () )
			{
				resultado = true;
			}
		}
		return resultado;
	}
	
	@Override
	public int hashCode ()
	{
		//A mano cambiaría el criterio a por sólo el nivel, y lo escribiría así: return (this.getNivel * 43214); Considero que el metodo hash de Objects es más apropiado.
		return (Objects.hash (this.getNivel (), this.getNombre (), this.getDuracion ()));
	}
	
	@Override
	public Sendero clone ()
	{
		Sendero copia = null;
		
		try
		{
			copia = (Sendero) super.clone ();
		}
		
		catch (CloneNotSupportedException error)
		{
			System.out.println("No se ha podido clonar el objeto");
		}
		
		return copia;
	}
	
	public int compareTo (Sendero sendero)
	{
		int resultado = 0;
		
		if (this.getDuracion () > sendero.getDuracion ())
		{
			resultado = 1;
		}
		
		else if (this.getDuracion () < sendero.getDuracion ())
		{
			resultado = -1;
		}
		
		return resultado;
	}
	//Fin Metodos añadidos
}
