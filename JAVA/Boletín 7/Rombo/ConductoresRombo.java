public class ConductoresRombo 
{
	
	public static void main (String[] args) 
	{
		Rombo rombo = new Rombo (8.0, 3.0);
		System.out.println("---------------------");
		System.out.println(rombo.toString ());
		System.out.println("---------------------");
		System.out.println("Cambio de variables: ");
		rombo.setDiagonal1 (5.0);
		rombo.setDiagonal2 (10.0);
		System.out.println("---------------------");
		System.out.println(rombo.toString ());
		System.out.println("---------------------");
		System.out.println("Atributos derivados: ");
		System.out.println("---------------------");
		System.out.println("Lado: "+rombo.getLado ());
		System.out.println("Area: "+rombo.getArea ());
		System.out.println("Perimetro: "+rombo.getPerimetro ());
		System.out.println("---------------------");
	}
}

