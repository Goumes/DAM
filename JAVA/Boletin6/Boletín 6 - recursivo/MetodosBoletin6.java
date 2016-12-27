public class MetodosBoletin6
{
/* Prototipo: int sumaAcumulada (int numero)
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
		//Modelo iterativo
		int resultado = 0;
		
		for (int contador = 0; contador <= numero; contador++)
		{
			resultado = contador + resultado;
		}
		return (resultado);
		
		/* Modelo recursivo
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
		*/
	}
//fin subprograma sumaAcumulada

/* NECESIDADES: un entero
 * DEVOLUCIONES: un entero
 * NECESIDADES/DEVOLUCIONES: ninguna
 * RESTRICCIONES: ninguna
 * 
 * Prototipo:
 * Precondiciones:
 * Entradas:
 * Salidas:
 * Entradas/Salidas:
 * Postcondiciones
 */
 
}//fin_pp
