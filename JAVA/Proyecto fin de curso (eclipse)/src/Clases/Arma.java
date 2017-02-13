/* 
 * Propiedades.
	 * Básicas: 	String Nombre 	-----------	Consultable / Modificable
 * 					double Dmg		-----------	Consultable / Modificable
 * 					Int Precio		-----------	Consultable / Modificable
			
 * Derivadas:
 * Compartidas:

 * Fórmulas:

 * Getes y Setes: 

 * String getNombre ();
 * void setNombre (String Nombre);

 * Double getDmg ();
 * void setDmg (double Dmg);

 * Int getPrecio ();
 * void setPrecio (int Precio);


 * Métodos añadidos:

 * Restricciones:
 */
package Clases;
public class Arma implements Cloneable, Comparable <Arma>
{
	private String Nombre;
	private double Dmg;
	private int Precio;
	
	//Constructores
	
	public Arma ()
	{
		Nombre = "";
		Dmg = 0;
		Precio = 0;
	}
	
	public Arma (Arma arma)
	{
		this.Nombre = arma.Nombre;
		this.Dmg = arma.Dmg;
		this.Precio = arma.Precio;
	}
	
	public Arma (String Nombre, double Dmg, int Precio)
	{
		this.Nombre = Nombre;
		this.Dmg = Dmg;
		this.Precio = Precio;
	}
	
	//Fin Constructores
	
	//Getes y setes
	
	public String getNombre ()
	{
		return Nombre;
	}
	
	public void setNombre (String Nombre)
	{
		this.Nombre = Nombre;
	}
	
	public double getDmg ()
	{
		return Dmg;
	}
	
	public void setDmg (double Dmg)
	{
		this.Dmg = Dmg;
	}
	
	public int getPrecio ()
	{
		return Precio;
	}
	
	public void setPrecio (int Precio)
	{
		this.Precio = Precio;
	}
	
	//Fin Getes y setes
	
	//Metodos añadidos
	
	@Override
	public String toString ()
	{
		String s = "Nombre: "+getNombre ()+
					", Dmg: "+getDmg ()+
					", Precio: "+getPrecio ();
		return s;
	}
	
	//Criterio de igualdad: Propiedades iguales
	@Override
	public boolean equals (Object objeto)
	{
		boolean resultado = false;
		
		if (objeto != null && objeto instanceof Arma)
		{
			Arma arma = (Arma) objeto;
			
			if (this.getNombre ().equals (arma.getNombre ()) 
				&& this.getDmg () == arma.getDmg ()
				&& this.getPrecio () == arma.getPrecio ())
			{
				resultado = true;
			}
		}
		
		return (resultado);
	}
	
	@Override
	public int hashCode ()
	{
		//return (Objects.hash (this.Nombre, this.Dmg, this.Precio));
		return (int)(getPrecio() * 623/getDmg ());
	}
	
	@Override
	public Arma clone ()
	{
		Arma copia = new Arma ();
		
		try
		{
			copia = (Arma) super.clone ();
		}
		
		catch (CloneNotSupportedException error)
		{
			System.out.println("No se ha podido clonar el objeto");
		}
		return (copia);
	}
	
	//Criterio de comparación: Precio
	public int compareTo (Arma arma)
	{
		int resultado = 0;
		
		
		if (this.getPrecio () > arma.getPrecio () )
		{
			resultado = 1;
		}
		
		else if (this.getPrecio () < arma.getPrecio ())
		{
			resultado = -1;
		}
		
		return (resultado);
	}
	//Fin Metodos Añadidos
		
}//fin_pp
