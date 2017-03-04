/* Clase gestora del programa principal. He decidido hacerlo así ya que esta operación no se 
 * utilizará en muchos programas aparte del que nos atañe.
 * El método es static porque no quiero que sea necesario crear un objeto de esta clase para usarlo.
 */
public class Calculadora 
{
	/* Prototipo: double calculoCalorias (Socio socio)
	 * Breve comentario: Subrograma que calcula el gasto de calorías en función del peso del socio, 
	 * el tipo de actividad que realiza (sendero), y la duracion de la actividad. 
	 * Precondiciones: Ninguna
	 * Entradas: Un Socio
	 * Salidas: un double
	 * Entradas/Salidas: Ninguna
	 * Postcondiciones: Un double indicando las calorías gastadas.
	 * 
	 * Resguardo: public static double calculoCalorias (Socio socio)
		{
			System.out.println("Llamada al metodo calculoCalorias");
			System.out.println("Variables: "+socio);
			return (-1.0);
		}
	 */
	public static double calculoCalorias (Socio socio)
	{
		double resultado = 0.0;
		
		double CTE = 0.0;
		
		if (socio.getTipoActividad ().getNivel () == "ALTO")
		{
			CTE = 0.35;
		}
		
		else if (socio.getTipoActividad ().getNivel () == "MEDIO")
		{
			CTE = 0.25;
		}
		
		else if (socio.getTipoActividad ().getNivel () == "BAJO")
		{
			CTE = 0.15;
		}
		
		resultado = CTE * socio.getTipoActividad ().getDuracion () * socio.getPeso ();
		
		return resultado;
	}
}//Fin_clase Calculadora
