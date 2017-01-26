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


/*	Prototipo: char MinMay (char caracter)
 * 	Breve comentario de lo que realiza: 
 * 	Precondiciones: Un carácter en minúsculas 
 * 	Entradas: carácter 
 * 	Salidas: carácter  (Asignado nombre)
 *	Entradas/Salidas: carácter 
 *	Postcondiciones: Un carácter en mayúscula 
 * 
 * 
 * Resguardo: public static char MinMay (char caracter)
 * {
 *  	System.out.println("Llamada al método MinMay");
 * 		System.out.println("Variables: "+caracter);
 * }
 */

	public static char MinMay (char caracter)
	{
		char resultado = ' ';
		resultado = Character.toUpperCase(caracter);
		return resultado;
	}
//Fin subprograma MinMay

/*	Prototipo: boolean AnnoBisiesto (int numero)
 * 	Breve comentario de lo que realiza: 
 * 	Precondiciones: Ninguna
 * 	Entradas: entero
 *  Salidas: lógico (Asignado nombre)
 * 	Entradas/Salidas: Nada
 * 	Postcondiciones: VERDAD si el número es bisiesto y FALSO si no lo es.
 * 
 * 
 * Resguardo: public static boolean AnnoBisiesto (int numero)
 * {
 *  	System.out.println("Llamada al método AnnoBisiesto");
 * 		System.out.println("Variables: "+numero);
 * }
 */
 
	public static boolean AnnoBisiesto(int numero)
	{
		boolean resultado = false;
		
		if ((numero%4 == 0) && (numero%100 != 0))
		{
			resultado = true;
		}
		return resultado;
	}
	
//Fin subprograma AnnoBisiesto

/*	Prototipo: boolean digitoHex (char caracter)
 * 	Breve comentario de lo que realiza: Subprograma DigitoHex que diga si un carácter es un dígito hexadecimal
 * 	Precondiciones: 
 * 	Entradas: char caracter
 * 	Salidas: boolean
 * 	Entradas/Salidas:
 * 	Postcondiciones: verdad si el carácter es hexadecimal, y falso si no lo es.
 * 
 * 
 * Resguardo: public static boolean digitoHex (char caracter)
 * {
 *  	System.out.println("Llamada al método digitoHex");
 * 		System.out.println("Variables: "+caracter);
 * }
 */
	public static boolean digitoHex (char caracter)
	{
		boolean resultado = false;
		if ((caracter >= '0' && caracter <= '9') || (caracter >= 'a' && caracter <= 'f'))
		{
			resultado = true;
		}
		return (resultado);
	}
	 
//Fin subprograma DigitoHex

/* Prototipo: void Distancia (int Coordenada1, Coordenada2, Coordenada3, Coordenada4)
 * Breve comentario de lo que realiza: Subprograma que calcule la distancia entre dos puntos que se encuentran en el plano a partir de sus coordenadas.
 * Precondiciones: ninguna
 * Entradas: cuatro enteros
 * Salidas: ninguna
 * Entradas/Salidas: ninguna
 * Postcondiciones: ninguna
 * Resguardo: public static void Distancia (double numero1, double numero2, double numero3, double numero4)
	{
		System.out.println("Llamada al metodo Distancia");
		System.out.println("Variables: "+numero1+", "+numero2+", "+numero3+", "+numero4);
	}
 */ 
 
	public static void Distancia (double numero1, double numero2, double numero3, double numero4)
	{
		double resultado;
		resultado = Math.pow(Math.pow(numero2 - numero1, 2) + Math.pow(numero4 - numero3, 2), 0.5);
		System.out.println("La distancia entre los dos puntos es: "+resultado+ " unidades");
	}
	
 //Fin subprograma DigitoHex

/*	Prototipo: boolean Alfabeto (char caracter)
 * 	Breve comentario de lo que realiza: 
 * 	Precondiciones: Ninguna
 * 	Entradas: carácter 
 * 	Salidas: lógico (Asignado a nombre)
 * 	Entradas/Salidas: Nada
 * 	Postcondiciones: VERDAD si el carácter pertenece al alfabeto español y FALSO sino.
 * 
 * 
 * Resguardo: public static boolean Alfabeto (char caracter)
 * {
 *  	System.out.println("Llamada al método Alfabeto");
 * 		System.out.println("Variables: "+caracter);
 * }
 */

	public static boolean Alfabeto (char caracter)
	{
		boolean resultado = false;
		
		if ((caracter >= 'a' && caracter <= 'z') || (caracter >= 'A' && caracter <= 'Z'))
		{
				resultado = true;
		}
		return resultado;
	}
//Fin subprograma Alfabeto

/*Prototipo: real conversorMedidas (real unidad)
 * Breve comentario de lo que realiza: Subprograma para pasar una medida en hectáreas y áreas a metros cuadrados.
 * Precondiciones: Real positivo
 * Entradas: real unidad
 * Salidas: real unidad (asignado al nombre)
 * Entradas/Salidas: ninguna
 * Postcondiciones: real unidad en metros cuadrados
 * Resguardo: public static double conversorMedidas (double unidad)
	{
		System.out.println("Llamada al metodo conversorMedidas");
		System.out.println("Variables: "+unidad);
		return (-1);
 */
 
	public static double conversorMedidas (double unidad)
	{
		double resultado;
		resultado = unidad * 100;
		return (resultado);
	}
 //Fin subprograma conversorMedidas

/* Prototipo: boolean Primo (real numero)
 * Breve comentario de lo que realiza: Subprograma para calcular si un número es o no primo.
 * Precondiciones: ninguna
 * Entradas: real numero
 * Salidas: boolean
 * Entradas/Salidas: ninguna 
 * Postcondiciones: VERDAD si el número es primo, FALSO sino.
 * public static boolean Compuesto (double numero)
	{
			System.out.println("Llamada al metodo Primo");
			System.out.println("Variables: "+numero);
			return (false);
	}
 */
	public static boolean Primo (double numero)
	{
		boolean resultado = true;
		
		if (numero <= 1)
		{
			resultado = false;
		}
		else
		{
			for (int contador = 2; numero > contador; contador++)
			{
				if (numero%contador == 0)
					{
						resultado = false;
					}
			}
		}
		return (resultado);
	}
 
 //Fin subprograma Primo
 
/* Prototipo: real Pendiente (real parametro1, real parametro2, real parametro3, real parametro4)
 * Breve comentario de lo que realiza: Subprograma que teniendo como parámetros las coordenadas cartesianas de dos puntos en el plano calcule la pendiente de la recta que definen.
 * Precondiciones: Ninguna
 * Entradas: real parametro1, real parametro2, real parametro3, real parametro4
 * Salidas: real pendiente
 * Entradas/Salidas: ninguna
 * Postcondiciones: Un número real
 */
	public static double Pendiente (double parametro1, double parametro2, double parametro3, double parametro4)
	{
		System.out.println("Llamada al metodo pendiente");
		System.out.println("Varibles: "+parametro1+", "+parametro2+", "+parametro3+", "+parametro4);
		System.out.print("Devolucion: ");
		return (-1);
	}
 //Fin subprograma Pendiente

/*	Prototipo: void EcuacionSegundoGrado (real1, real2, real3, resultado1, resultado2)
 * 	Breve comentario de lo que realiza: Resuelve una ecuación de segundo grado.
 * 	Precondiciones: El primer valor debe ser mayor o igual que cero
 * 	Entradas: tres reales
 * 	Salidas: dos reales (Por referencia)
 * 	Entradas/Salidas: Dos reales 
 * 	Postcondiciones: real  resultado1 y real resultado2
 * 
 * 
 * (Como no podemos hacer todavía salida una salida múltiple en java, lo haré con prints)
 * 
 * Prototipo: void EcuacionSegundoGrado (real1, real2, real3)
 * 	Breve comentario de lo que realiza: Resuelve una ecuación de segundo grado.
 * 	Precondiciones: El primer valor debe ser distinto que cero
 * 	Entradas: tres reales
 * 	Salidas: nada
 * 	Entradas/Salidas: nada
 * 	Postcondiciones:
 * 
 * 
 * 
 * Resguardo: void ecuacionSegundoGrado (double numero1, double numero2, double numero3)
 * {
 *  	System.out.println("Llamada al método ecuacionSegundoGrado");
 * 		System.out.println("Variables: "+numero1+", "+numero2+", "+numero3);
 * }
 */
	
	public static void ecuacionSegundoGrado (double numero1, double numero2, double numero3)
	{
		double resultado1;
		double resultado2; 
		
		if (numero2*numero2-(4*numero1*numero3)>= 0)
			{
				resultado1 = (-(numero2) + Math.pow(numero2*numero2-(4*numero1*numero3),0.5))/(2*numero1);
				resultado2 = (-(numero2) - Math.pow(numero2*numero2-(4*numero1*numero3),0.5))/(2*numero1);
				System.out.println ("x1= "+resultado1);
				System.out.println ("x2= "+resultado2);
			}
		else
			{
				System.out.println ("Esta ecuaci\u00f3n no se puede calcular");
			}
	}
 
 //Fin subprograma EcuacionSegundoGrado
 
 /* Prototipo: boolean validarFecha (int dia, int mes, int agno)
  * Breve resumen: Programa para validar que la fecha introducida sea correcta
  * Precondiciones: ninguna
  * Entradas: tres enteros
  * Salidas: un booleano
  * Entradas/Salidas: ninguna
  * Postcondiciones: VERDAD si la fecha es correcta, FALSO sino.
  * 
  * Resguardo: public static boolean validarFecha (int dia, int mes, int agno)
  {
	System.out.println("Llamada al metodo validarFecha");
	System.out.println("Variables: "+dia+", "+mes+", "+agno);
	return (false);
  }
  
  */
public static boolean validarFecha (int dia, int mes, int agno)
{
	boolean resultado = false;
	boolean diaC = false; //diaC - dia check, comprueba si el dia es correcto
	boolean mesC = false;
	boolean agnoC = false;
	boolean bisiesto = false;
	
	bisiesto = MetodosPracticaSubprogramas.AnnoBisiesto (agno);
	
	if (agno >= 0)
	{
		agnoC = true;
	}
	if (mes >= 1 && mes <= 12)
	{
		mesC = true;
	}
	switch (mes)
	{
		case 1: 
		case 3:
		case 5: 
		case 6:
		case 8:
		case 10:
		case 12:
		if (dia > 0 && dia <= 31)
		{
			diaC = true;
		}
		break;
		
		case 4:
		case 7:
		case 9:
		case 11:
		if (dia > 0 && dia <= 30)
		{
			diaC = true;
		}
		break;
		
		case 2:
		if (dia > 0 && dia <= 29 && bisiesto == true)
		{
			diaC = true;
		}
		if (dia > 0 && dia <= 28)
		{
			diaC = true;
		}
		
		break;
	}//fin_segun
	
	if (diaC == true && mesC == true && agnoC == true)
	{
		resultado = true;
	}
	return (resultado);
}
  //fin subprograma validarFecha
  
/* Prototipo: boolean validarHora (int hora, int minutos)
 * Breve descripcion: Valida la hora en formato 24h.
 * Precondiciones: ninguna
 * Entradas: dos enteros
 * Salidas: un booleano 
 * Entradas/Salidas: ninguna
 * Postcondiciones: VERDAD si la hora es correcta, FALSO sino.
 * 
 * Resguardo: public static boolean validarHora (int hora, int minutos)
 {
	System.out.println("Llamada al metodo validarHora");
	System.out.println("Variables: "+hora+", "+minutos);
	return (false);
 }
*/
public static boolean validarHora (int hora, int minutos)
{
	boolean resultado = true;
	
	if (hora < 0 || hora > 23 || minutos < 0 || minutos > 59)
	{
		resultado = false;
	}
	
	return (resultado);
}
   //fin subprograma validarHora
}//fin_pp
