/*
 * 
 */
 
public class MetodosModificacionesNumeros
{
	/* Prototipo: int sumarDigitos (int numero)
	 * Análisis: Método que nos permita sumar los dígitos de un número
	 * Precondiciones: ninguna
	 * Entradas: un entero
	 * Salidas: un entero
	 * Postcondiciones: entero resultado de la suma de los digitos
	 *
	 * Resguardo: public static int sumarDigitos (int numero)
	 {
		System.out.println("Llamada al método sumarDigitos");
		System.out.println("Variables: "+numero);
		return (-1); 
	 }
	 */
	public static int sumarDigitos (int numero)
	{
		int resultado = 0;
		
		while (numero >= 10)
		{
			resultado = (numero%10) + resultado;
			numero = numero/10;
		}
		
		resultado = numero + resultado;
		
		return (resultado); 
	}
	 //Fin subprograma invertirDigitos
	 
	 /* Prototipo: int contarDigitos (int numero)
	 * Análisis: Método que nos permita contar los dígitos de un número
	 * Precondiciones: ninguna
	 * Entradas: un entero
	 * Salidas: un entero
	 * Postcondiciones: entero resultado de la cuenta de los digitos
	 *
	 * Resguardo: public static int contarDigitos (int numero)
	 {
		 System.out.println("Llamada al metodo contarDigitos");
		 System.out.println("Variables: "+numero);
		 return (-1);
	 }
	 */
	 
	 public static int contarDigitos (int numero)
	 {
		 int contador = 1;
		 while (numero >= 10)
		 {
			 numero = numero/10;
			 contador++;
		 }
		 
		 return (contador);
	 }
	 //Fin subprograma contarDigitos
	 
	 /* Prototipo: int invertirDigitos (int numero)
	 * Análisis: Método que nos permita invertir los dígitos de un número
	 * Precondiciones: ninguna
	 * Entradas: un entero
	 * Salidas: un entero
	 * Postcondiciones: entero resultado de la inversión de los digitos
	 *
	 * Resguardo: public static int invertirDigitos (int numero)
	 {
		 System.out.println("Llamada al metodo invertirDigitos");
		 System.out.println("Variables: "+numero);
		 return (-1);
	 }
	 */
	 
	 public static int invertirDigitos (int numero)
	 {
		 int resultado = 0;
		 int numeroContar = 0;
		 
		 numeroContar = MetodosModificacionesNumeros.contarDigitos (numero);
		 
		 for (int contador = (int) Math.pow (10, (numeroContar-1)); numero >= 10; contador= contador/10)
		 {
			resultado = (numero%10)*contador + resultado;
			numero = numero/10;
		 }
		 
		 resultado = numero + resultado;
		 
		 return (resultado);	
	 }
	 //Fin Subprograma invertirDigitos
}//fin_pp
