package vestidosJaranasStyle;

/* Propiedades.
 * 		Basicas:			int codDisenio		----------		Consultable / Modificable
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
 * Criterio de comparacion: codDisenio.
 * Criterio de igualdad: codDisenio.
 * 
 * Restricciones. El codDisenio son 3 digitos enteros positivos.
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
	
	public Disenio (int codDisenio, double precio)
	{
		this.codDisenio = codDisenio;
		this.precio = precio;
	}
	//Fin Constructores
	
	//Getters y setters
	public int getCodDisenio ()
	{
		return codDisenio;
	}
	
	public void setCodDisenio (int codDisenio)
	{
		this.codDisenio = codDisenio;
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
	
	//Metodos añadidos
	@Override
	public String toString ()
	{
		return this.getCodDisenio ()+","+this.getPrecio ();
	}
	//Fin Metodos añadidos
	
}
