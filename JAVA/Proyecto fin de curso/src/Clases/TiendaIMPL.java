package Clases;

import java.io.Serializable;
import java.util.*;

import Exceptions.JuegoException;
import Interfaces.Tienda;

public class TiendaIMPL implements Cloneable, Serializable, Tienda
{
	private static final long serialVersionUID = -9063051013414155572L;
	private ItemIMPL objeto1;
	private ItemIMPL objeto2;
	private ItemIMPL objeto3;
	private ArmaIMPL objeto4;
	private boolean disponibilidad;		//Esta variable indica si es posible generar una tienda en la mazmorra. MÃ¡ximo una por mazmorra.
	
	//Constructores
	public TiendaIMPL ()
	{
		objeto1 = new ItemIMPL ();
		objeto2 = new ItemIMPL ();
		objeto3 = new ItemIMPL ();
		objeto4 = new ArmaIMPL ();
		disponibilidad = false;
	}
	
	public TiendaIMPL (TiendaIMPL tienda)
	{
		this.objeto1 = tienda.objeto1;
		this.objeto2 = tienda.objeto2;
		this.objeto3 = tienda.objeto3;
		this.objeto4 = tienda.objeto4;
		this.disponibilidad = tienda.disponibilidad;
	}
	
	public TiendaIMPL (ItemIMPL objeto1, ItemIMPL objeto2, ItemIMPL objeto3, ArmaIMPL objeto4, boolean disponibilidad)
	{
		this.objeto1 = objeto1;
		this.objeto2 = objeto2;
		this.objeto3 = objeto3;
		this.objeto4 = objeto4;
		this.disponibilidad = disponibilidad;
	}
	//Fin Constructores
	
	//Getes y setes
	public ItemIMPL getObjeto1 ()
	{
		return objeto1;
	}
	
	public void setObjeto1 (ItemIMPL objeto1)
	{
		this.objeto1 = objeto1;
	}
	
	public ItemIMPL getObjeto2 ()
	{
		return objeto2;
	}
	
	public void setObjeto2 (ItemIMPL objeto2)
	{
		this.objeto2 = objeto2;
	}
	
	public ItemIMPL getObjeto3 ()
	{
		return objeto3;
	}
	
	public void setObjeto3 (ItemIMPL objeto3)
	{
		this.objeto3 = objeto3;
	}
	
	public ArmaIMPL getObjeto4 ()
	{
		return objeto4;
	}
	
	public void setObjeto4 (ArmaIMPL objeto4)
	{
		this.objeto4 = objeto4;
	}
	
	public boolean getDisponibilidad ()
	{
		return disponibilidad;
	}
	
	public void setDisponibilidad (boolean disponibilidad)
	{
		this.disponibilidad = disponibilidad;
	}
	
	
	public String getObjeto1Nombre() 
	{
		return objeto1.getNombre();
	}

	public void setObjeto1Nombre(String nombre) throws JuegoException
	{
		objeto1.setNombre(nombre);
	}

	public double getObjeto1Precio() 
	{
		return objeto1.getPrecio();
	}

	public void setObjeto1Precio(double precio) throws JuegoException
	{
		objeto1.setPrecio(precio);
	}

	public double getObjeto1ModificadorDmg() 
	{
		return objeto1.getModificadorDmg();
	}

	public void setObjeto1ModificadorDmg(double modificadorDmg) 
	{
		objeto1.setModificadorDmg(modificadorDmg);
	}

	public double getObjeto1ModificadorDef() 
	{
		return objeto1.getModificadorDef();
	}

	public void setObjeto1ModificadorDef(double modificadorDef) 
	{
		objeto1.setModificadorDef(modificadorDef);
	}

	public double getObjeto1Duracion() 
	{
		return objeto1.getDuracion();
	}

	public void setObjeto1Duracion(double duracion) 
	{
		objeto1.setDuracion(duracion);
	}

	public String getObjeto1Efecto() 
	{
		return objeto1.getEfecto();
	}

	public void setObjeto1Efecto(String efecto) 
	{
		objeto1.setEfecto(efecto);
	}
	
	public String getObjeto2Nombre() 
	{
		return objeto2.getNombre();
	}

	public void setObjeto2Nombre(String nombre) throws JuegoException
	{
		objeto2.setNombre(nombre);
	}

	public double getObjeto2Precio() 
	{
		return objeto2.getPrecio();
	}

	public void setObjeto2Precio(double precio) throws JuegoException
	{
		objeto2.setPrecio(precio);
	}

	public double getObjeto2ModificadorDmg() 
	{
		return objeto2.getModificadorDmg();
	}

	public void setObjeto2ModificadorDmg(double modificadorDmg) 
	{
		objeto2.setModificadorDmg(modificadorDmg);
	}

	public double getObjeto2ModificadorDef() 
	{
		return objeto2.getModificadorDef();
	}

	public void setObjeto2ModificadorDef(double modificadorDef) 
	{
		objeto2.setModificadorDef(modificadorDef);
	}

	public double getObjeto2Duracion() 
	{
		return objeto2.getDuracion();
	}

	public void setObjeto2Duracion(double duracion) 
	{
		objeto2.setDuracion(duracion);
	}

	public String getObjeto2Efecto() 
	{
		return objeto2.getEfecto();
	}

	public void setObjeto2Efecto(String efecto) 
	{
		objeto2.setEfecto(efecto);
	}
	
	public String getObjeto3Nombre() 
	{
		return objeto3.getNombre();
	}

	public void setObjeto3Nombre(String nombre) throws JuegoException
	{
		objeto3.setNombre(nombre);
	}

	public double getObjeto3Precio() 
	{
		return objeto3.getPrecio();
	}

	public void setObjeto3Precio(double precio) throws JuegoException
	{
		objeto3.setPrecio(precio);
	}

	public double getObjeto3ModificadorDmg() 
	{
		return objeto3.getModificadorDmg();
	}

	public void setObjeto3ModificadorDmg(double modificadorDmg) 
	{
		objeto3.setModificadorDmg(modificadorDmg);
	}

	public double getObjeto3ModificadorDef() 
	{
		return objeto3.getModificadorDef();
	}

	public void setObjeto3ModificadorDef(double modificadorDef) 
	{
		objeto3.setModificadorDef(modificadorDef);
	}

	public double getObjeto3Duracion() 
	{
		return objeto3.getDuracion();
	}

	public void setObjeto3Duracion(double duracion) 
	{
		objeto3.setDuracion(duracion);
	}

	public String getObjeto3Efecto() 
	{
		return objeto3.getEfecto();
	}

	public void setObjeto3Efecto(String efecto) 
	{
		objeto3.setEfecto(efecto);
	}
	
	public String getObjeto4Nombre() 
	{
		return objeto4.getNombre();
	}

	public void setObjeto4Nombre(String nombre) throws JuegoException
	{
		objeto4.setNombre(nombre);
	}

	public double getObjeto4Precio() 
	{
		return objeto4.getPrecio();
	}

	public void setObjeto4Precio(double precio) throws JuegoException
	{
		objeto4.setPrecio(precio);
	}

	public double getObjeto4Dmg() 
	{
		return objeto4.getDmg();
	}

	public void setObjeto4Dmg(double dmg) 
	{
		objeto4.setDmg(dmg);
	}

	
	//Fin Getes y setes
	
	//Metodos añadidos
	@Override
	public String toString ()
	{
		String s =(getObjeto1 ()+
					","+getObjeto2 ()+
					","+getObjeto3 ()+
					","+getObjeto4 ()+
					","+getDisponibilidad ());
		return s;
	}
	
	//Criterio de igualdad: Todos los atributos
	@Override
	public boolean equals (Object objeto)
	{
		boolean resultado = false;
		
		if (objeto != null && objeto instanceof TiendaIMPL)
		{
			TiendaIMPL tienda = (TiendaIMPL) objeto;
			
			if (this.getObjeto1 ().equals (tienda.getObjeto1 ()) 
				&& this.getObjeto2 ().equals (tienda.getObjeto2 ())
				&& this.getObjeto3 ().equals (tienda.getObjeto3 ())
				&& this.getObjeto4 ().equals (tienda.getObjeto4 ())
				&& this.getDisponibilidad () == tienda.getDisponibilidad ())
			{
				resultado = true;
			}
		}
		
		return resultado;
	}
	
	@Override
	public int hashCode ()		//Preguntar si esto es correcto
	{			
		return (Objects.hash (this.getObjeto1 (), this.getObjeto2 (), this.getObjeto3 (), this.getObjeto4 (), getDisponibilidad ()));
	}
	
	@Override
	public TiendaIMPL clone ()
	{
		TiendaIMPL copia = new TiendaIMPL ();
		
		try
		{
			copia = (TiendaIMPL) super.clone ();
		}
		
		catch (CloneNotSupportedException error)
		{
			System.out.println("No se ha podido clonar el objeto");
		}
		
		return copia;
	}
	
	/* Prototipo: generarTiendaAleatoria ()
	 * Breve comentario: Metodo dedicado a la generación aleatoria de la tienda
	 * Precondiciones: Ninguna
	 * Entradas: Ninguna
	 * Salidas: Ninguna
	 * Entradas/Salidas: Ninguna
	 * Postcondiciones: Ninguna
	 * 
	 * Resguardo: public void generarTiendaAleatoria ()
		{
			System.out.println("Llamada al metodo generarTiendaAleatoria");
		}
	 */
	public void generarTiendaAleatoria ()
	{
		 Random aleatorio = new Random ();
		 int numero = 0;
		 ItemIMPL item = null;
		 ArmaIMPL arma = null;
		 int contador = 0;
		 
		 while (this.getObjeto1().equals(new ItemIMPL ())
				 || this.getObjeto2().equals(new ItemIMPL ())
				 || this.getObjeto3().equals(new ItemIMPL ()))
		 {
		 
			 numero = aleatorio.nextInt (15) + 1;
			 item = itemAleatorio (numero);
			 
			 if (contador == 0)
			 {
				 this.setObjeto1(item);
			 }
			 
			 else if (contador == 1)
			 {
				 this.setObjeto2(item);
			 }
			 
			 else
			 {
				 this.setObjeto3(item);
			 }
			 
			 contador++;
		 }
		 
		 numero = aleatorio.nextInt (15) + 1;
		 arma = armaAleatoria (numero);
		
	}
	//Fin generarTiendaAleatoria

	//No tiene sentido hacer el compareTo en este caso.
	//public int compareTo ()
	//{
		//int resultado = 0;
		
		//if ()
		//{
			//resultado = 1;
		//}
		
		//else if ()
		//{
			//resultado = -1;
		//}
		//return resultado;
	//}
	//Fin Metodos aÃ±adidos
	
	
}//fin_clase
