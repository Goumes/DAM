/* Prototipo: void Linea (char caracter, int entero)
 * Breve comentario de lo que realiza: Subprograma que teniendo como parámetros un carácter y un número, 
 * imprima una línea con tantas veces el carácter como indique el número. 
 * Precondiciones: el entero es mayor que 0
 * Entradas: 1 char y  1 entero
 * Salidas: Nada
 * Entradas/Salidas: Nada
 * Postcondiciones: Ninguna
 * 
 * 
 * 
 * Resguardo:
 *  
 * public static void Linea (int numero, char caracter)
 * {
 *  	System.out.println("Llamada al metodo Linea");
 * 		System.out.println("Variables: "+numero+", "+caracter);
 * }
 */
public class MetodosPracticaSubprogramas
{
	
	public static void Linea (int numero, char caracter)
	{
			for (int contador = 0; contador < numero; contador++)
			{
				System.out.print(caracter);
			}
			System.out.println();
		}
//Fin subprograma Linea

/*	Prototipo: boolean Par (int numero)
 * 	Breve comentario de lo que realiza: 
 * 	Precondiciones: Ninguna
 * 	Entradas: entero
 * 	Salidas: lógico
 * 	Entradas/Salidas: Nada
 * 	Postcondiciones: VERDAD si el número es par y FALSO si no lo es.
 * 
 * 
 * Resguardo: public static boolean Par (int numero)
 * {
 * 		System.out.println("Llamada al método Par");
 * 		System.out.println("Variables: "+numero);
 * }
 */
 
	public static boolean Par (int numero)
	{
		boolean resultado;
		if (numero%2 == 0)
		{
			resultado = true;
		}
		else
		{
			resultado = false;
		}
		return (resultado);
	}
//Fin subprograma Par
}
