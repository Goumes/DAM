/* Propiedades.
 * 		Básicas:		int Dia				----------		Consultable / Modificable
 * 						int Mes				----------		Consultable / Modificable
 * 						int Anio			----------		Consultable / Modificable
 * 						boolean Bisiesto	----------		Consultable / Modificable
 * 		Derivadas:
 * 		Compartidas:
 * 
 * Fórmulas:
 * 
 * Getters y setters:
 * 
 * int getDia ();
 * void setDia (int Dia);
 * 
 * int getMes ();
 * void setMest (int Mes);
 * 
 * int getAnio ();
 * void setAnio (int Anio);
 * 
 * boolean getBisiesto ();
 * void setBisiesto (boolean Bisiesto);
 * 
 * Métodos añadidos: validarFecha, diasTranscurridos, compararFecha, incrementarFecha, decrementarFecha (uno o varios días)
 * 
 * Restricciones: Dependiendo del mes un día no puede ser mayor que 28, 29, 30 o 31. Los días deben ser mínimo 1. Los meses deben estar entre 1 y 12. Un año no puede ser negativo.
 */
import java.util.*;
import java.lang.*;
import java.io.*;

public class Fecha implements Cloneable//, Comparable <Fecha>
{
	private int Dia;
	private int Mes;
	private int Anio;
	private boolean Bisiesto;
	
	//Constructores
	public Fecha () //Por defecto
	{
		this.Dia = 0;
		this.Mes = 0;
		this.Anio = 0;
		this.Bisiesto = false;
	}
	
	public Fecha (Fecha fecha) //De copia
	{
		this.Dia = fecha.Dia;
		this.Mes = fecha.Mes;
		this.Anio = fecha.Anio;
		this.Bisiesto = fecha.Bisiesto;
	}
	
	public Fecha (int Dia, int Mes, int Anio, boolean Bisiesto) //Con parametros
	{
		this.Dia = Dia;
		this.Mes = Mes;
		this.Anio = Anio;
		this.Bisiesto = Bisiesto;
	}
	//Fin Constructores
	
	//Getters y setters
	public int getDia ()
	{
		return Dia;
	}
	
	public void setDia (int Dia)
	{
		this.Dia = Dia;
	}
	
	public int getMes ()
	{
		return Mes;
	}
	
	public void setMes (int Mes)
	{
		this.Mes = Mes;
	}
	
	public int getAnio ()
	{
		return Anio;
	}
	
	public void setAnio (int Anio)
	{
		this.Anio = Anio;
	}
	
	public boolean getBisiesto ()
	{
		return Bisiesto;
	}
	
	public void setBisiesto (boolean Bisiesto)
	{
		this.Bisiesto = Bisiesto;
	}
	//Fin Getters y setters
	
	//Metodos añadidos
	@Override
	public String toString ()
	{
		String s = ("Dia: "+this.getDia ()+
					"\nMes: "+this.getMes ()+
					"\nAnio: "+this.getAnio ()+
					"\nBisiesto: "+this.getBisiesto ());
		return s;
	}
	
	//Criterio de igualación: El dia, mes y año.
	@Override
	public boolean equals (Object objeto)
	{
		boolean resultado = false;
		
		if (objeto != null && objeto instanceof Fecha)
		{
			Fecha fecha = (Fecha) objeto;
			
			if (this.getDia () == fecha.getDia ()
				&& this.getMes () == fecha.getMes ()
				&& this.getAnio () == fecha.getAnio ())
			{
				resultado = true;
			}
		}
		
		return resultado;
	}
	
	@Override
	public int hashCode ()
	{
		return Objects.hash (this.getDia (), this.getMes (), this.getAnio (), this.getBisiesto ());
	}
	
	@Override
	public Fecha clone ()
	{
		Fecha copia = new Fecha ();
		
		try
		{
			copia = (Fecha) super.clone ();
		}
		
		catch (CloneNotSupportedException error)
		{
			System.out.println("No se ha podido clonar el objeto");
		}
		
		return copia;
	}
	
	//Criterio de comparación: Dia, mes y año.
	//public int compareTo (Fecha fecha)
	//{
		//int resultado = 0;
		
		//if (this,getDia ())
		//{
			//resultado = 1;
		//}
		
		//else if ()
		//{
			//resultado = -1;
		//}
		//return resultado;
	//}
	
	/* Prototipo: boolean validarFecha ()
	 * Breve comentario de lo que realiza: Valida una fecha
	 * Precondiciones: Ninguna
	 * Entradas: Ninguna
	 * Salidas: Un booleano
	 * Entradas/Salidas: Ninguna
	 * Postcondiciones: TRUE si la fecha es válida, FALSE sino.
	 * 
	 * Resguardo: public boolean validarFecha ()
		{
			boolean resultado = false;
			
			System.out.println("Llamada al metodo validarFecha");
			
			return resultado;
		}
	 */
	public boolean validarFecha ()
	{
		boolean resultado = false;
		
		if (this.getAnio () > 0)
		{
			if (this.getMes () > 0 && this.getMes () <= 12)
			{
					switch (this.getMes())
					{
						case 1:
						case 3:
						case 5:
						case 7:
						case 8:
						case 10:
						case 12:
						
						if (this.getDia () > 0 && this.getDia () < 32)
						{
							resultado = true;
						}
						break;
						
						case 4:
						case 6:
						case 9:
						case 11:
						
						if (this.getDia () > 0 && this.getDia () < 31)
						{
							resultado = true;
						}
						break;
						
						case 2:
						
						if (this.getBisiesto () == true)
						{
							if (this.getDia () > 0 && this.getDia () < 30)
							{
								resultado = true;
							}
						}
						
						else
						{
							if (this.getDia () > 0 && this.getDia () < 29)
							{
								resultado = true;
							}
						}
						
					}
			}
		}
		
		return resultado;
	}
	
	/* Prototipo: int compararFecha ()
	 * 
	 */
	//Fin Metodos añadidos
}
