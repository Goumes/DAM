public class TestSocio
{
		public static void main (String [] args)
		{
			Socio pepe = null;
			Socio juan = null;
			Socio copiaPepe = null;
			Sendero camino = null;
			Sendero sendero2 = null;
			try
			{
				camino = new Sendero ("BAJO", "Paseo por la montania", 30);
				sendero2 = new Sendero ("ALTO", "Paseo wapo wapo", 40);
			}
			catch (ExamenException error)
			{
				System.out.println("Vuelve a crear el sendero");
			}
			
			try
			{
				pepe = new Socio ("Pepe",camino, 75.5, 4);
				juan = new Socio ("Juan", camino, 67.5, 3);
			}
			
			catch (ExamenException error)
			{
				System.out.println("Vuelve a crear a los socios");
			}		
			//Prueba gettes, settes y toString
			System.out.println("----------------------------------");
			System.out.println("Get y set:");
			pepe.setApellidosNombre ("Pepe2");
			pepe.setPeso(45.4);
			pepe.setTipoActividad(sendero2);
			System.out.println(pepe.getApellidosNombre ());
			System.out.println(pepe.getPeso ());
			System.out.println(pepe.getTipoActividad ());
			
			System.out.println("----------------------------------");
			System.out.println("toString:");
			System.out.println(juan.toString ());
			//Fin Prueba Gettes, settes y toString
			
			//Prueba clone
			System.out.println("----------------------------------");
			System.out.println("clone:");
			copiaPepe = pepe.clone ();
			System.out.println(pepe);
			System.out.println(copiaPepe);
			//Fin Prueba clone
			
			//Prueba equals
			System.out.println("----------------------------------");
			System.out.println("equals:");
			System.out.println(pepe.equals (copiaPepe));
			System.out.println(juan.equals (copiaPepe));
			//Fin Prueba equals
			
			//Prueba hashCode
			System.out.println("----------------------------------");
			System.out.println("hashCode:");
			System.out.println(pepe.hashCode ());
			//Fin prueba hashCode
			
			//Prueba compareTo
			System.out.println("----------------------------------");
			System.out.println("compareTo:");
			System.out.println(pepe.compareTo (juan));
			System.out.println(juan.compareTo (pepe));
			System.out.println(copiaPepe.compareTo (pepe));
			//Fin Prueba compareTo
			
		}
}
