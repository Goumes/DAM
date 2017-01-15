public class conductorPersona
{
	public static void main (String[]args)
	{
		Persona persona = new Persona ("77925651H", "Alejandro", "Gomez Olivera", 800.0, 40.0);
		
		System.out.println(persona.toString ());
		System.out.println(persona.getSueldo ());
	}//fin_main
}//fin_pp
