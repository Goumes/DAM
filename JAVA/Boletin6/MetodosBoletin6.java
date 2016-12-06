public class MetodosBoletin6
{
/*
 * NECESIDADES: entero
 * DEVOLUCIONES: entero
 * NECESIDADES/DEVOLUCIONES: ninguna
 * RESTRICCIONES: el entero debe ser positivo
 * 
 * Prototipo: int sumaAcumulada (int numero)
 * Breve comentario de lo que realiza: programa que suma todos los numeros anteriores al introducido
 * Precondiciones: el numero entero debe ser positivo
 * Entradas: entero
 * Salidas: entero
 * Entradas/Salidas: ninguna
 * Postcondiciones: un entero

Resguardo:

	public static int sumaAcumulada (int numero)
	{
		System.out.println("Llamada al metodo sumaAcumulada");
		System.out.println("Variables: "+numero);
		return (-1);
	}
*/

	public static int sumaAcumulada (int numero)
	{
		int resultado = 0;
		if (numero == 0)
		{
			resultado = 0;
		}
		else
		{
			resultado = numero + sumaAcumulada (numero - 1);
		}
		return (resultado);
	}
//fin subprograma sumaAcumulada
}//fin_pp
