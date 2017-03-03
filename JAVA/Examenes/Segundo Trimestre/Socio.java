/* Propiedades.
 * 		Básicas:			int Identificador							----------			Consultable
 * 								String apellidosNombre				----------			Consultable / Modificable
 * 								Sendero tipoActividad					----------			Consultable / Modificable
 * 								double Peso								----------			Consultable / Modificable
 * 								int Categoria								----------			Consultable
 * 		Derivadas:		X
 * 		Compartidas:	X
 * 
 * Getters y setters:
 * 
 * int getIdentificador ();
 * 
 * String getApellidosNombre ();
 * void setApellidosNombre (String apellidosNombre)
 * 
 * Sendero getTipoActividad ();
 * void setTipoActividad (Sendero tipoActividad)
 * 
 * double getPeso ();
 * void setPeso (double Peso);
 * 
 * int getCategoria ();
 * 
 * Orden natural: Por identificador.
 * Criterio de igualdad: El identificador
 * Representación como cadena: identificador, tipo de actividad (separados por comas)
 * Codigo hash en función de Identificador y el hashCode de apellidosNombre
 * 
 * Restricciones: Identificador debe ser positivo. Categoria debe estar entre 1 y 5 (incluidos)
 * 
 * Metodos añadidos: Ninguno aparte de los útiles generales.
 */
import java.util.*;

public class Socio implements Cloneable, Comparable <Socio>
{
		private int Identificador = 0;
		private String apellidosNombre;		//He cambiado el nombre de las variables de "ApellidosNombre" a "apellidosNombre" para seguir con el standard de Java"
		private Sendero tipoActividad;			//Igual que con apellidosNombre
		private double Peso;
		private int Categoria;
		
		//Constructores
		public Socio () //Por defecto
		{
			Identificador++;
			apellidosNombre = "";
			tipoActividad = new Sendero ();
			Peso = 0.0;
			Categoria = 1;
		}
		
		public Socio (Socio socio) //De copia
		{
			this.Identificador = socio.Identificador;
			this.apellidosNombre = socio.apellidosNombre;
			this.tipoActividad = socio.tipoActividad;
			this.Peso = socio.Peso;
			this.Categoria = socio.Categoria;
		}
		
		public Socio (String apellidosNombre, Sendero tipoActividad, double Peso, int Categoria) throws ExamenException //Con parametros
		{
			this.apellidosNombre = apellidosNombre;
			this.tipoActividad = tipoActividad;
			this.Peso = Peso;
			
			if (Categoria < 1 || Categoria > 5)
			{
				throw new ExamenException ("Error. La categoria debe estar entre 1 y 5");
			}
			
			else
			{
				this.Categoria = Categoria;
			}
		}
		//Fin Constructores
		
		//Getters y setters
		public int getIdentificador ()
		{
			return Identificador;
		}
		
		public String getApellidosNombre ()
		{
			return apellidosNombre;
		}
		
		public void setApellidosNombre (String apellidosNombre)
		{
			this.apellidosNombre = apellidosNombre;
		}
		
		public Sendero getTipoActividad ()
		{
			return tipoActividad;
		}
		
		public void setTipoActividad (Sendero tipoActividad)
		{
			this.tipoActividad = tipoActividad;
		}
		
		public double getPeso ()
		{
			return Peso;
		}
		
		public void setPeso (double Peso)
		{
			this.Peso = Peso;
		}
		
		public int getCategoria ()
		{
			return Categoria;
		}
		//Fin Getters y setters
		
		//Metodos añadidos
		@Override
		public String toString ()
		{
			String s = this.getIdentificador () + ","+this.getTipoActividad ();
			return s;
		}
		
		@Override
		public boolean equals (Object objeto)
		{
			boolean resultado = false;
			
			if (objeto != null && objeto instanceof Socio)
			{
				Socio socio = (Socio) objeto;
				
				if (this.getIdentificador () == socio.getIdentificador ())
				{
					resultado = true;
				}
			}
			
			return resultado;
		}
		
		@Override
		public int hashCode ()
		{
			return (Objects.hash (this.getApellidosNombre ())); //Utilizo el metodo hash de la clase Objects porque considero que es mejor que una implementación
																								//personal. En cuyo caso sería una simple operación para generar números distintos.
		}
		
		@Override
		public Socio clone ()
		{
			Socio copia = null;
			
			try
			{
				copia = (Socio) super.clone ();
				copia.tipoActividad = tipoActividad.clone(); //En profudidad
			}
			
			catch (CloneNotSupportedException error)
			{
				System.out.println("No se ha podido clonar el objeto");
			}
			
			return copia;
		}
		
		public int compareTo (Socio socio) //Todos salen 0 porque el identificador no se aumenta con cada objeto creado.
		{
			int resultado = 0;
			
			if (this.getIdentificador () > socio.getIdentificador ())
			{
				resultado = 1;
			}
			
			else if (this.getIdentificador () < socio.getIdentificador ())
			{
				resultado = -1;
			}
			
			return resultado;
		}
		//Fin Metodos añadidos
}//fin clase_Socio
