package examenProgramacion;

public class TestFecha 
{
	public static void main (String [] args)
	{
		Fecha fecha1 = null;
		Fecha fecha2 = null;
		Fecha fecha3 = null;
		
		try
		{
			fecha1 = new Fecha (12, 3, 2017);
			fecha3 = new Fecha ();
		
			//Prueba getters, setters y toString
			System.out.println("-----------------------");
			System.out.println("Prueba getDia:");
			System.out.println("-----------------------");
			System.out.println(fecha1.getDia());
			System.out.println("-----------------------");
			System.out.println("Prueba getMes:");
			System.out.println("-----------------------");
			System.out.println(	fecha1.getMes());
			System.out.println("-----------------------");
			System.out.println("Prueba getAnio:");
			System.out.println("-----------------------");
			System.out.println(fecha1.getAnio());
			System.out.println("-----------------------");
			System.out.println("Prueba setDia:");
			System.out.println("-----------------------");
			fecha1.setDia(1);
			System.out.println(fecha1.getDia());
			System.out.println("-----------------------");
			System.out.println("Prueba setMes:");
			System.out.println("-----------------------");
			fecha1.setMes(2);
			System.out.println(fecha1.getMes());
			System.out.println("-----------------------");
			System.out.println("Prueba setAnio:");
			System.out.println("-----------------------");
			fecha1.setAnio(3);
			System.out.println(fecha1.getAnio());
			
			System.out.println("-----------------------");
			System.out.println("Prueba toString");
			System.out.println(fecha1.toString());
			System.out.println("-----------------------");
			//Fin Prueba getters, setters y toString
			
			//Prueba clone
			System.out.println("Prueba clone:");
			fecha2 = fecha1.clone();
			System.out.println(fecha1.toString());
			System.out.println(fecha2.toString());
			System.out.println("-----------------------");
			//Fin Prueba clone
			
			//Prueba equals
			System.out.println("Prueba equals:");
			System.out.println(fecha1.equals(fecha2));
			System.out.println(fecha1.equals(fecha3));
			System.out.println("-----------------------");
			//Fin Prueba equals
			
			//Prueba hashCode
			System.out.println("Prueba hashCode:");
			System.out.println(fecha1.hashCode());
			System.out.println("-----------------------");
			//Fin Prueba hashCode
			
			//Prueba compareTo
			System.out.println("Prueba compareTo:");
			System.out.println(fecha1.compareTo(fecha3));
			System.out.println(fecha1.compareTo(fecha2));
			System.out.println(fecha3.compareTo(fecha1));
			System.out.println("-----------------------");
			//Fin Prueba hashCode
		}
		catch (ExamenException e)
		{
			System.out.println(e);
		}
	}
}
