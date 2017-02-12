public class testFecha
{
	public static void main (String [] args)
	{
		Fecha pepe = new Fecha (28, 2, 2016, true);
		
		System.out.println(pepe.validarFecha ());
		
		
		System.out.println(pepe.toString ());
	}//fin_main
}//fin_testFecha
