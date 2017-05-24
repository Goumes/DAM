package examenProgramacion;

import java.io.Serializable;
import java.util.Objects;

/* Propiedades.
 * 		Basicas: 		int resolucion			----------	Consultable / Modificable
						String tipoTecnologia 	----------	Consultable / Modificable
						Fecha fecha 			----------	Consultable /Modificable
 *		Derivadas:
 * 		Compartidas:
 * 
 * Getters y setters:
 * int getResolucion ();
 * void setResolucion (int resolucion);
 * 
 * String getTipoTecnologia ();
 * void setTipoTecnologia (String Tecnologia);
 * 
 * Fecha getFecha ():
 * void setFecha (Fecha fecha);
 * 
 * Representacion como cadena : Todos los atributos
 */

public class Pantalla extends UnidadSalidaIMPL implements Serializable
{
	private static final long serialVersionUID = -9215244625640014540L;
	private int resolucion;
	private String tipoTecnologia;
	private Fecha fecha;
	
	//Constructores
	public Pantalla ()
	{
		super ();
		resolucion = 0;
		tipoTecnologia = "";
		fecha = new Fecha ();
	}
	
	public Pantalla (Pantalla pantalla)
	{
		this.resolucion = pantalla.resolucion;
		this.tipoTecnologia = pantalla.tipoTecnologia;
		this.fecha = pantalla.fecha;
	}
	
	public Pantalla (String nombreFabricante, int numeroSerie, int unidades, double precio, int resolucion, String tipoTecnologia, Fecha fecha) throws ExamenException
	{
		super (nombreFabricante, numeroSerie, unidades, precio);
	/*	
		if (resolucion < 0
			|| (!tipoTecnologia.equals("LED") && !tipoTecnologia.equals("LCD") && !tipoTecnologia.equals("OLED")))
		{
			throw new ExamenException ("No se ha podido crear el objeto Pantalla");
		}
		else
		{*/
			this.resolucion = resolucion;
			this.tipoTecnologia = tipoTecnologia;
			this.fecha = fecha;
		//}
		//No he metido excepciones aquí porque el super debe ser lo primero de un constructor, y no me da tiempo a cambiarlo
	}
	//Fin Constructores
	
	//Getters y setters
	public int getResolucion ()
	{
		return resolucion;
	}
	
	public void setResolucion (int resolucion)
	{
		this.resolucion = resolucion;
	}
	
	public String getTipoTecnologia ()
	{
		return tipoTecnologia;
	}
	
	public void setTipoTecnologia (String tipoTecnologia)
	{
		this.tipoTecnologia = tipoTecnologia;
	}
	
	public Fecha getFecha ()
	{
		return fecha;
	}
	
	public void setFecha (Fecha fecha)
	{
		this.fecha = fecha;
	}
	//Fin Getters y setters
	
	//Metodos añadidos
	public String toString ()
	{
		return (super.toString() + "," + this.getResolucion() + "," +this.getTipoTecnologia() + "," + this.getFecha().toString());
	}
	
	public int hashCode ()
	{
		return (super.hashCode() + Objects.hash( this.getResolucion(), this.getTipoTecnologia(), this.getFecha()));
	}
	//Fin Metodos añadidos
}
