
public class TestSendero 
{
	public static void main (String [] args)
	{
		Sendero camino = null;
		Sendero camino2 = null;
		Sendero caminoCopia = null;
		try
		{
			camino = new Sendero ("BAJO", "Paseo por la montania", 30);
			camino2 = new Sendero ("MEDIO", "Skydiving", 20);
		}
		catch (ExamenException error)
		{
			System.out.println("Vuelve a crear el sendero");
		}
		
		//Prueba Getters, Setters y toString
		System.out.println("----------------------------------");
		System.out.println("Getters y setters:");
		try
		{
			camino.setDuracion(50);
			camino.setNivel("ALTO");
		}
		catch (ExamenException error)
		{
			System.out.println("Error al crear el sendero.");
		}
		camino.setNombre("Carrera a contrareloj cuesta abajo por una montaña");
		System.out.println(camino.getDuracion());
		System.out.println(camino.getNivel());
		System.out.println(camino.getNombre());
		
		System.out.println("----------------------------------");
		System.out.println("toString:");
		System.out.println(camino.toString());
		//Fin Prueba Getters, Setters y toString
		
		//Prueba clone
		System.out.println("----------------------------------");
		System.out.println("Clone:");
		caminoCopia = camino.clone();
		
		System.out.println(caminoCopia);
		//Fin Prueba clone
		
		//Prueba equals
		System.out.println("----------------------------------");
		System.out.println("equals:");
		System.out.println(camino.equals(caminoCopia));
		System.out.println(camino2.equals(caminoCopia));
		//Fin Prueba equals
		
		//Prueba hashCode
		System.out.println("----------------------------------");
		System.out.println("hashCode:");
		System.out.println(camino.hashCode());
		//Fin Prueba hashCode
		
		//Prueba compareTo
		System.out.println("----------------------------------");
		System.out.println("compareTo:");
		System.out.println(camino.compareTo(camino2));
		System.out.println(camino.compareTo(camino));
		System.out.println(camino2.compareTo(camino));
		//Fin Prueba compareTo
	}
}
