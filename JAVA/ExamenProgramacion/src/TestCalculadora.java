
public class TestCalculadora 
{
	public static void main (String [] args)
	{
		Calculadora calculadora = new Calculadora ();
		Calculadora calculadoraCopia = null;
		Calculadora calculadora2 = new Calculadora ();
		
			//Prueba Getters, Setters y toString
			System.out.println("----------------------------------");
			System.out.println("Getters y setters:");
			try
			{
				calculadora.setDuracion(50);
				calculadora.setNivelActividad("ALTO");
			}
			catch (ExamenException error)
			{
				System.out.println("Error, no se ha podido utilizar este set.");
			}
			calculadora.setPeso (45.4);
			System.out.println(calculadora.getDuracion());
			System.out.println(calculadora.getNivelActividad());
			System.out.println(calculadora.getPeso());
			
			System.out.println("----------------------------------");
			System.out.println("toString:");
			System.out.println(calculadora.toString());
			//Fin Prueba Getters, Setters y toString
			
			//Prueba clone
			System.out.println("----------------------------------");
			System.out.println("Clone:");
			calculadoraCopia = calculadora.clone();
			
			System.out.println(calculadoraCopia);
			//Fin Prueba clone
			
			//Prueba equals
			System.out.println("----------------------------------");
			System.out.println("equals:");
			System.out.println(calculadora.equals(calculadoraCopia));
			System.out.println(calculadora2.equals(calculadoraCopia));
			//Fin Prueba equals
			
			//Prueba hashCode
			System.out.println("----------------------------------");
			System.out.println("hashCode:");
			System.out.println(calculadora.hashCode());
			//Fin Prueba hashCode
			
			//Prueba compareTo
			System.out.println("----------------------------------");
			System.out.println("compareTo:");
			System.out.println(calculadora.compareTo(calculadora2));
			System.out.println(calculadora.compareTo(calculadora));
			System.out.println(calculadora2.compareTo(calculadora));
			//Fin Prueba compareTo
			
			//Prueba calculoCalorias
			System.out.println("----------------------------------");
			System.out.println("calculoCalorias:");
			System.out.println(calculadora.calculoCalorias());
			//Fin Prueba calculoCalorias
	}
}
