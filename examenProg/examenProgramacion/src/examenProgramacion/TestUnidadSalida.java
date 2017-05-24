package examenProgramacion;

public class TestUnidadSalida 
{
	public static void main (String [] args)
	{
		UnidadSalidaIMPL us1 = null;
		UnidadSalidaIMPL us2 = null;
		UnidadSalidaIMPL us3 = null;
		
		try
		{
			us1 = new UnidadSalidaIMPL ("fabricanteGenerico", 3, 20, 24.5);
			us3 = new UnidadSalidaIMPL ();
		
			//Prueba getters, setters y toString
			System.out.println("-----------------------");
			System.out.println("Prueba getIdentificador:");
			System.out.println("-----------------------");
			System.out.println(us1.getIdentificador());
			System.out.println(us3.getIdentificador());
			System.out.println("-----------------------");
			System.out.println("Prueba getNombreFabricante:");
			System.out.println("-----------------------");
			System.out.println(	us1.getNombreFabricante());
			System.out.println("-----------------------");
			System.out.println("Prueba getNumeroSerie:");
			System.out.println("-----------------------");
			System.out.println(us1.getNumeroSerie());
			System.out.println("-----------------------");
			System.out.println("Prueba getPrecio:");
			System.out.println("-----------------------");
			System.out.println(us1.getPrecio());
			System.out.println("-----------------------");
			System.out.println("Prueba getUnidades:");
			System.out.println("-----------------------");
			System.out.println(us1.getUnidades());
			System.out.println("-----------------------");
			System.out.println("Prueba setUnidades:");
			System.out.println("-----------------------");
			us1.setUnidades(70);
			System.out.println(us1.getUnidades());
			System.out.println("-----------------------");
			System.out.println("Prueba setPrecio:");
			System.out.println("-----------------------");
			us1.setPrecio(99.9);
			System.out.println(us1.getPrecio());
			
			System.out.println("-----------------------");
			System.out.println("Prueba toString");
			System.out.println(us1.toString());
			System.out.println("-----------------------");
			//Fin Prueba getters, setters y toString
			
			//Prueba clone
			System.out.println("Prueba clone:");
			us2 = us1.clone();
			System.out.println(us1.toString());
			System.out.println(us2.toString());
			System.out.println("-----------------------");
			//Fin Prueba clone
			
			//Prueba equals
			System.out.println("Prueba equals:");
			System.out.println(us1.equals(us2));
			System.out.println(us1.equals(us3));
			System.out.println("-----------------------");
			//Fin Prueba equals
			
			//Prueba hashCode
			System.out.println("Prueba hashCode:");
			System.out.println(us1.hashCode());
			System.out.println("-----------------------");
			//Fin Prueba hashCode
			
			//Prueba compareTo
			System.out.println("Prueba compareTo:");
			System.out.println(us1.compareTo(us3));
			System.out.println(us1.compareTo(us2));
			System.out.println(us3.compareTo(us1));
			System.out.println("-----------------------");
			//Fin Prueba hashCode
		}
		catch (ExamenException e)
		{
			System.out.println(e);
		}
	}
}
