//Conductores
public class ConductoresPracticaSubprogramas
{
	public static void main (String[]args)
	{
		MetodosPracticaSubprogramas.Linea(4, 'a');
		System.out.println(MetodosPracticaSubprogramas.Par(4)); 
		System.out.println(MetodosPracticaSubprogramas.MinMay('a')); 
		System.out.println(MetodosPracticaSubprogramas.AnnoBisiesto(4));
		System.out.println(MetodosPracticaSubprogramas.digitoHex('2'));
		System.out.println(MetodosPracticaSubprogramas.Alfabeto('f'));
		MetodosPracticaSubprogramas.ecuacionSegundoGrado(1, -5, 6); 
		MetodosPracticaSubprogramas.Distancia (1, 2, 3, 4);
		System.out.println(MetodosPracticaSubprogramas.conversorMedidas (5));
	}
}
