package examenProgramacion;

public class TestPantalla 
{
	public static void main (String [] args)
	{
		Pantalla p1 = null;
		Pantalla p2 = null;
		Pantalla p3 = null;
		
		try
		{
			p1 = new Pantalla ("fabricanteGenerico", 3, 20, 24.5, 1920, "LED", new Fecha (1,2,3));
			p3 = new Pantalla ();
		
			//Prueba getters, setters y toString
			System.out.println("-----------------------");
			System.out.println("Prueba getResolucion:");
			System.out.println("-----------------------");
			System.out.println(p1.getResolucion());
			System.out.println("-----------------------");
			System.out.println("Prueba getTipoTecnologia:");
			System.out.println("-----------------------");
			System.out.println(	p1.getTipoTecnologia());
			System.out.println("-----------------------");
			System.out.println("Prueba getFecha:");
			System.out.println("-----------------------");
			System.out.println(p1.getFecha());
			System.out.println("-----------------------");
			System.out.println("Prueba setResolucion ():");
			System.out.println("-----------------------");
			p1.setResolucion(3);
			System.out.println(p1.getResolucion());
			System.out.println("-----------------------");
			System.out.println("Prueba setTipoTecnologia ():");
			System.out.println("-----------------------");
			p1.setTipoTecnologia("LCD");
			System.out.println(p1.getTipoTecnologia());
			System.out.println("-----------------------");
			System.out.println("Prueba setFecha ():");
			System.out.println("-----------------------");
			p1.setFecha(new Fecha (24, 5, 2017));
			System.out.println(p1.getFecha());
			
			System.out.println("-----------------------");
			System.out.println("Prueba toString");
			System.out.println(p1.toString());
			System.out.println("-----------------------");
			//Fin Prueba getters, setters y toString

			//Prueba hashCode
			System.out.println("Prueba hashCode:");
			System.out.println(p1.hashCode());
			System.out.println("-----------------------");
			//Fin Prueba hashCode
		}
		catch (ExamenException e)
		{
			System.out.println(e);
		}
	}
}
