import java.util.Objects;

/* Propiedades.
 * 		Básicas:		int Duracion				----------		Consultable / Modificable
	 					String nivelActividad		----------		Consultable / Modificable
	 					double Peso					----------		Consultable / Modificable
 * 		Derivadas:	
 * 		Compartidas:
 * 
 * Restricciones: Ninguna
 * 
 * Getters y setters:
 * 
 * int getDuracion ();
 * void setDuracion (int Duracion);
 * 
 * String getNivelActividad ();
 * void setNivelActividad (String nivelActividad);
 * 
 * double getPeso ();
 * void setPeso (double Peso);
 * 
 * Criterio de igualdad: Duracion y nivelActividad
 * Criterio de Comparación: Duracion y nivelActividad
 * 
 * Metodos añadidos: calculoCalorias
 */
public class Calculadora implements Cloneable, Comparable <Calculadora>
{
	private int Duracion;
	private String nivelActividad;
	private double Peso;
	
	//Constructores
	public Calculadora ()
	{
		Duracion = 0;
		nivelActividad = "";
		Peso = 0.0;
	}
	
	public Calculadora (Calculadora calculadora)
	{
		this.Duracion = calculadora.Duracion;
		this.nivelActividad = calculadora.nivelActividad;
		this.Peso = calculadora.Peso;
	}
	
	public Calculadora (int Duracion, String nivelActividad, double Peso) throws ExamenException
	{
		if ((nivelActividad.equals("ALTO") == false && nivelActividad.equals ("MEDIO") == false && nivelActividad.equals("BAJO") == false) 
			&& (Duracion < 1))
		{
			throw new ExamenException ("Error no se ha podido crear el objeto");
		}
		else
		{
			this.Duracion = Duracion;
			this.nivelActividad = nivelActividad;
			this.Peso = Peso;
		}
	}
	//Fin Constructores
	
	//Getters y setters
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
	
	public String getNivelActividad ()
	{
		return nivelActividad;
	}
	
	public void setNivelActividad (String nivelActividad) throws ExamenException
	{
		if (nivelActividad.equals("ALTO") == true || nivelActividad.equals ("MEDIO") == true || nivelActividad.equals("BAJO") == true)
		{
			this.nivelActividad = nivelActividad;
		}
		else
		{
			
			throw new ExamenException ("El nivel debe ser ALTO, MEDIO, o BAJO");
		}
	}
	
	public double getPeso ()
	{
		return Peso;
	}
	
	public void setPeso (double Peso)
	{
		this.Peso = Peso;
	}
	//Fin Getters y setters
	
	//Metodos añadidos
	
	@Override
	public String toString ()
	{
		String s = this.getDuracion()+","+this.getNivelActividad()+","+this.getPeso();
		return s;
	}
	
	@Override
	public boolean equals (Object objeto)
	{
		boolean resultado = false;
		
		if (objeto != null && objeto instanceof Calculadora)
		{
			Calculadora calculadora = (Calculadora) objeto; 
			{
				if (this.getDuracion() == calculadora.getDuracion()
					&& this.getNivelActividad() == calculadora.getNivelActividad())
				{
					resultado = true;
				}
			}
		}
		
		return resultado;
	}
	
	@Override
	public int hashCode ()
	{
		return (Objects.hash(this.getDuracion(), this.getNivelActividad(), this.getPeso()));
	}
	
	@Override
	public Calculadora clone ()
	{
		Calculadora copia = null;
		
		try
		{
			copia = (Calculadora) super.clone ();
		}
		
		catch (CloneNotSupportedException error)
		{
			System.out.println("No se ha podido clonar el objeto");
		}
		
		return copia;
	}
	
	public int compareTo (Calculadora calculadora)
	{
		int resultado = 0;
		
		if (this.getDuracion() > calculadora.getDuracion ()
			&& this.getNivelActividad().compareTo(calculadora.getNivelActividad()) > 0)
		{
			resultado = 1;
		}
		
		else if (this.getDuracion() < calculadora.getDuracion ()
				&& this.getNivelActividad().compareTo(calculadora.getNivelActividad()) < 0)
		{
			resultado = -1;
		}
		
		return resultado;
	}
	
	/* Prototipo: double calculoCalorias ()
	 * Breve comentario: Subrograma que calcula el gasto de calorÃ­as en funciÃ³n del peso del socio, 
	 * el tipo de actividad que realiza (sendero), y la duracion de la actividad. 
	 * Precondiciones: Ninguna
	 * Entradas: Ninguna
	 * Salidas: Un double
	 * Entradas/Salidas: Ninguna
	 * Postcondiciones: Un double indicando las calorÃ­as gastadas.
	 * 
	 * Resguardo: public double calculoCalorias ()
		{
			System.out.println("Llamada al metodo calculoCalorias");
			return (-1.0);
		}
	 */
	public double calculoCalorias ()
	{
		double resultado = 0.0;
		
		double CTE = 0.0;
		
		if (this.getNivelActividad ().equals("ALTO") == true)
		{
			CTE = 0.35;
		}
		
		else if (this.getNivelActividad().equals("MEDIO") == true)
		{
			CTE = 0.25;
		}
		
		else if (this.getNivelActividad().equals("BAJO"))
		{
			CTE = 0.15;
		}
		
		resultado = CTE * this.getDuracion () * this.getPeso();
		
		return resultado;
	}
	//Fin calculoCalorias
	
	//Fin Metodos añadidos
}//Fin_clase Calculadora
