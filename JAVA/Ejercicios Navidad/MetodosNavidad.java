/* MetodosNavidad */

public class MetodosNavidad
{
	/* Prototipo: int ordenAlfabeto (char caracter1, char caracter 2)
	 * Breve resumen: Subprograma que recibe dos carácteres del alfabeto y devuelve si el primero es anterior al segundo, 
	 * posterior o igual.
	 * Precondiciones: Los caracteres deben de ser proporcionados en minúsculas
	 * Entrada: dos caracteres
	 * Salida: un entero
	 * Entrada/Salida: ninguna
	 * Postcondiciones: 0 si el resultado es igual, -1 si es anterior, 1 si es posterior y 2 si el caracter no es del alfabeto.
	 * 
	 * Resguardo: public static int ordenAlfabeto (char caracter1, char caracter2)
	 * {
	 *  	System.out.println("Llamada al método ordenAlfabeto");
	 * 		System.out.println("Variables: "+caracter1+", "+caracter2);
	 * 		return (2);
	 * }
	 */
	public static int ordenAlfabeto (char caracter1, char caracter2)
	{
	 int resultado = 0;
	 boolean resultadoAlfabeto1 = true;
	 boolean resultadoAlfabeto2 = true;
		
	resultadoAlfabeto1 = MetodosPracticaSubprogramas.Alfabeto (caracter1);
	resultadoAlfabeto2 = MetodosPracticaSubprogramas.Alfabeto (caracter2);
	
	if (resultadoAlfabeto1 == false || resultadoAlfabeto2 == false)
	{
		resultado = 2; 
	}
	else
	{
		if (caracter1 > caracter2)
		{
			resultado = 1;
		}
		
		else if (caracter1 == caracter2)
		{
			resultado = 0;
		}
		
		else if (caracter1 < caracter2)
		{
			resultado = -1;
		}
	}
	return (resultado);
	}
	 //fin subprograma ordenAlfabeto
	 
	/* Prototipo: boolean esMayuscula (char caracter)
	 * Breve resumen: Una funcionalidad que distinga si una letra del alfabeto es mayúscula o no
	 * Precondiciones: ninguna
	 * Entrada: un caracter
	 * Salida: un booleano
	 * Entrada/Salida: ninguna
	 * Postcondiciones: VERDAD si es mayúscula, FALSO si no lo es.
	 * 
	 * Resguardo: public static boolean esMayuscula (char caracter)
	 * {
	 * 		System.out.println("Llamada al método esMayuscula");
	 * 		System.out.println("Variables: "+caracter);
	 * 		return (false);
	 * }
	 * 
	 * CORRECCIÓN
	 * 
	 * Prototipo: int esMayuscula (char caracter)
	 * Breve resumen: Una funcionalidad que distinga si una letra del alfabeto es mayúscula o no
	 * Precondiciones: ninguna
	 * Entrada: un caracter
	 * Salida: un entero
	 * Entrada/Salida: ninguna
	 * Postcondiciones: 1 si es mayúscula, -1 si no lo es y 0 si no es un caracter del alfabeto.
	 * 
	 * Resguardo: public static boolean esMayuscula (char caracter)
	 * {
	 * 		System.out.println("Llamada al método esMayuscula");
	 * 		System.out.println("Variables: "+caracter);
	 * 		return (1);
	 * }
	 */
	 
	public static int esMayuscula (char caracter)
	{
		int resultado = 1;
		boolean resultadoAlfabeto = true;
		
		resultadoAlfabeto = MetodosPracticaSubprogramas.Alfabeto (caracter);
		
		if (resultadoAlfabeto == false)
		{
			resultado = 0;
		}
		
		else if (caracter < 'A' || caracter > 'Z')
		{
			 resultado = -1;
		}
		return (resultado);
	}
	 //fin subprograma esMayuscula
	 
	 
	/* Prototipo: int esMinuscula (char caracter)
	 * Breve resumen: Una funcionalidad que distinga si una letra del alfabeto es minúscula o no
	 * Precondiciones: ninguna
	 * Entrada: un caracter
	 * Salida: un entero
	 * Entrada/Salida: ninguna
	 * Postcondiciones: 1 si es minúscula, -1 si no lo es y 0 si no es un caracter del alfabeto.
	 * 
	 * Resguardo: public static boolean esMayuscula (char caracter)
	 * {
	 * 		System.out.println("Llamada al método esMinuscula");
	 * 		System.out.println("Variables: "+caracter);
	 * 		return (1);
	 * }
	 */
	public static int esMinuscula (char caracter)
	{
		int resultado = 1;
		boolean resultadoAlfabeto = true;
		
		resultadoAlfabeto = MetodosPracticaSubprogramas.Alfabeto (caracter);
		
		if (resultadoAlfabeto == false)
		{
			resultado = 0;
		}
		
		else if (caracter < 'a' || caracter > 'z')
		{
			 resultado = -1;
		}
		return (resultado);
	}
	 //fin subprograma esMinuscula
	 
	/* Prototipo: int rangoDigito (int numero)
	 * Breve resumen: Una funcionalidad que distinga si un dígito está entre 0 y 9 o no
	 * Precondiciones: ninguna
	 * Entrada: un entero
	 * Salida: un booleano
	 * Entrada/Salida: ninguna
	 * Postcondiciones: TRUE si está en el rango deseado y FALSE sino.
	 * 
	 * Resguardo: public static boolean rangoDigito (int numero)
	 * {
	 * 		System.out.println("Llamada al método rangoDigito");
	 * 		System.out.println("Variables: "+numero);
	 * 		return (false);
	 * }
	 */
	public static boolean rangoDigito (int numero)
	{
		boolean resultado = true;
		
		if (numero < 0 || numero > 9)
		{
			resultado = false;
		}
		return (resultado);
	}
	 //fin subprograma rangoDigito
	 
	/* Prototipo: boolean simboloPuntuacion (char caracter)
	 * Breve resumen: Una funcionalidad que distinga si un caracter es un símbolo de puntuación o no
	 * Precondiciones: ninguna
	 * Entrada: un caracter
	 * Salida: un booleano
	 * Entrada/Salida: ninguna
	 * Postcondiciones: TRUE si es un símbolo de puntuación y FALSE sino.
	 * 
	 * Resguardo: public static boolean simboloPuntuacion (char caracter)
	 * {
	 * 		System.out.println("Llamada al método simboloPuntuacion");
	 * 		System.out.println("Variables: "+caracter);
	 * 		return (false);
	 * }
	 */
	public static boolean simboloPuntuacion (char caracter)
	{
		boolean resultado = false;
		
		if (caracter == ',' || caracter == '.' || caracter == ';' || caracter == ':' || caracter == 168 || caracter == '?' || caracter == '!' || caracter == 173) //No he puesto los rangos en ASCII porque cada signo estaba separado.
		{
			resultado = true;
		}
		
		return (resultado);
	}
	 //fin subprograma simboloPuntuacion
	 
	/* Prototipo: boolean Compuesto (int numero)
	 * Breve resumen: Subprograma que diga si un número es compuesto o no. Compuesto es todo número natural
	 * mayor que 1 que no es primo.
	 * Precondiciones: ninguna
	 * Entradas: un entero
	 * Salidas: un booleano
	 * Entradas/Salidas: ninguna
	 * Postcondiciones: VERDAD si el numero es compuesto, FALSO sino.
	 * Resguardo: public static boolean Compuesto (int numero)
	 {
		System.out.println("Llamada al método Compuesto");
		System.out.println("Variables: "+numero);
		return (false);
	 }
	 */
	public static boolean Compuesto (int numero)
	{
		boolean resultado = false;
		boolean resultadoPrimo = false;
		
		resultadoPrimo = MetodosPracticaSubprogramas.Primo (numero);
		
		if (resultadoPrimo == false && numero > 1)
		{
			resultado = true;
		}
		
		return (resultado);
	}
	 //Fin subprograma Compuesto
	 
	/* Prototipo: boolean Perfecto (int numero)
	 * Breve resumen: Subprograma que diga si un numero es perfecto.
	 * Perfecto es todo número natural que es igual a la suma de sus divisores propios. 
	 * Precondiciones: ninguna
	 * Entradas: un entero
	 * Salidas: un booleano
	 * Entradas/Salidas: ninguna
	 * Postcondiciones: VERDAD si es perfecto, FALSO sino.
	 * 
	 * Resguardo: public static boolean Perfecto (int numero)
	 * {
	 * 	System.out.println("Llamada al metodo Perfecto");
	 * 	System.out.println("Variables: "+numero);
	 * 	return (false);
	 * }
	 */
	public static boolean Perfecto (int numero)
	{
		boolean resultado = false;
		int acumulador = 0;
		
		for (int contador = 1; numero > contador; contador++)
		{
			if (numero%contador == 0)
			{
				acumulador = contador + acumulador;
			}
		}
		
		if (acumulador == numero)
		{
			resultado = true;
		}
		
		return (resultado);
	}
	  //fin subprograma Perfecto
	  
	/* Prototipo: boolean Semiperfecto (int numero)
	 * Breve resumen: Subprograma que diga si un numero es semiperfecto.
	 * Semiperfecto es todo número natural que es igual a la suma de algunos de sus divisores propios. 
	 * Precondiciones: ninguna
	 * Entradas: un entero
	 * Salidas: un booleano
	 * Entradas/Salidas: ninguna
	 * Postcondiciones: VERDAD si es semiperfecto, FALSO sino.
	 * 
	 * Resguardo: public static boolean Semiperfecto (int numero)
	 * {
	 * 	System.out.println("Llamada al metodo Semiperfecto");
	 * 	System.out.println("Variables: "+numero);
	 * 	return (false);
	 * }
	 */
	public static boolean Semiperfecto (int numero)
	{
		boolean resultado = false;
		int acumulador = numero;
		
		for (int contador = numero-1; contador > 0; contador--)
		{
			if (numero%contador == 0)
			{
				acumulador = acumulador - contador;
				if (acumulador < 0)
				{
					acumulador = acumulador + contador;
				}
				else if (acumulador == 0)
				{
					resultado = true;
				}
			}
		}
		
		return (resultado);
	}
	 //Fin subprograma Semiperfecto
	 
	/* Prototipo: boolean numeroFriki (int numero)
	 * Breve resumen: Subprograma que indica si un numero es friki. Un numero es friki si sus dígitos suman 13 
	 * y además son múltiplos de 3.
	 * Precondiciones: ninguna
	 * Entradas: un entero
	 * Salidas: un booleano
	 * Entradas/Salidas: ninguna
	 * Postcondiciones: VERDAD si el numero es friki, FALSO sino.
	 * 
	 * Resguardo: public static boolean numeroFriki (int numero)
	 {
		System.out.println("Llamada al metodo numeroFriki");
		System.out.println("Variables: "+numero);
		return (false);
	 }
	 */
	public static boolean numeroFriki (int numero)
	{
		boolean resultado = false;
		int resultadoSuma = 0;
		int contador = 0;
		
		resultadoSuma = MetodosModificacionesNumeros.sumarDigitos (numero);
		
		while (numero >= 10)
		{
			numero = (numero - (numero%10))/10;
			if (numero % 10 == 3)
			{
				contador++;
			}
		}
		if (numero % 3 == 0)
		{
			contador++;
		}
		
		else if (resultadoSuma == 13 && contador == resultadoSuma) 
		{
			resultado = true;
		}
		
		return (resultado);
	}

	//fin subprograma numeroFriki
	 
	/* Propotipo: int mensajeGraciosillo (int numero)
	 * Breve resumen: Subprograma que reciba un dígito e imprima una frase que rime con el numero del 0 al 9.
	 * Precondiciones: ninguna
	 * Entradas: un entero
	 * Salidas: un entero
	 * Entradas/Salidas: ninguna
	 * Postcondiciones: Devuelve un -1 si el numero recibido no está entre 0 y 9, y devuelve 0 si es correcto.
	 * 
	 * Resguardo:
	 */
	public static int mensajeGraciosillo (int numero)
	{
		int resultado = 0;
		
		if (numero < 0 && numero > 9)
		{
			resultado = -1;
		}
		else
		{
			switch (numero)
			{
				case 0:
				System.out.println("Este programa esta hecho con esmero");
				break;
				
				case 1:
				System.out.println("No conozco a ningun villavicenciuno");
				break;
				
				case 2:
				System.out.println("#Perezos");
				break;
				
				case 3:
				System.out.println("#Perezres");
				break;
				
				case 4:
				System.out.println("#Perezuatro");
				break;
				
				case 5:
				System.out.println("Lo siento, no estoy autorizado a responder a esta rima.");
				break;
				
				case 6:
				System.out.println("#Perezeis (No murais pls)");
				break;
				
				case 7:
				System.out.println("#Pereziete");
				break;
				
				case 8:
				System.out.println("#Pereziocho");
				break;
				
				case 9:
				System.out.println("#Perezueve");
				break;
				
			}
		}
		return (resultado);
	}
	//fin subprograma mensajeGraciosillo
	
	/* Prototipo: boolean primoProbable (int numero)
	 * Breve resumen: Subprograma que indica si un numero es primo probable. Es primo probable todo el cual que no se sabe si
	 * es primo o no, pero que verifica alguna condición que verifican todos los numeros primos.
	 * Precondiciones: ninguna
	 * Entradas: un entero
	 * Salidas: un booleano
	 * Entradas/Salidas: ninguna
	 * Postcondiciones: VERDAD si es primo probable, FALSO sino.
	 * 
	 * Resguardo:public static boolean primoProbable (int numero)
	 {
		System.out.println("Llamada al metodo primoProbable");
		System.out.println("Variables: "+numero);
		return (false);
	 }
	 */
	public static boolean primoProbable (int numero)
	{
		boolean resultado = false;
		
		//POR ACABAR PORQUE ME DA PEREZA HACER ESTE EJERCICIO AHORA
		
		return (resultado);
	}
	//fin subprograma primoProbable
	
	/* Prototipo: int compararFechas (int dia1, int dia2, int mes1, int mes2, int agno1, int agno2)
	 * Breve resumen: Sean dos fechas expresadas por dia1, mes1, agno1 y dia2, mes2, agno2; subprograma que devuelva si la primera
	 * fecha es igual, anterior o posterior a la segunda.
	 * Precondiciones: ninguna
	 * Entradas: seis enteros
	 * Salidas: un entero
	 * Entradas/Salidas: ninguna
	 * Postcondiciones: devuelve 0 si la primera fecha es igual a la segunda, -1 anterior, 1 posterior, 2 si la primera fecha 
	 * es errónea y 3 si la segunda fecha es erronea.
	 * 
	 * Resguardo:	public static int compararFechas (int dia1, int mes1, int agno1, int dia2, int mes2, int agno2)
	 {
		System.out.println("Llamada al metodo compararFechas");
		System.out.println("Variables:");
		System.out.println("Dia 1: "+dia1+", Mes 1: "+mes1+", Anno 1: "+agno1);
		System.out.println("Dia 2: "+dia2+", Mes 2: "+mes2+", Anno 2: "+agno2);
		return (3);
	 }
	 */
	public static int compararFechas (int dia1, int mes1, int agno1, int dia2, int mes2, int agno2)
	{
		int resultado = 0;
		boolean fecha1 = false;
		boolean fecha2 = false;
		
		fecha1 = MetodosPracticaSubprogramas.validarFecha (dia1, mes1, agno1);
		fecha2 = MetodosPracticaSubprogramas.validarFecha (dia2, mes2, agno2);
		
		if (fecha1 == false)
		{
			resultado = 2;
		}		
		
		else if (fecha2 == false)
		{
			resultado = 3;
		}
		
		else
		{
			if (agno1 > agno2 || (agno1 == agno2 && mes1 > mes2) || (agno1 == agno2 && mes1 == mes2 && dia1 > dia2))
			{
				resultado = 1;
			}
			
			else if(agno1 == agno2 && mes1 == mes2 && dia1 == dia2)
			{
				resultado = 0;
			}
			else
			{
				resultado = -1;
			}
		}
		return (resultado);
	}
	//fin subprograma compararFechas
	
	/* Prototipo: void conv24hAmPm (int hora, int minutos, int resHora, int resMinutos)
	 * Breve resumen: Programa que lea una hora en formato 24 horas y la pase a formato AM/PM.
	 * Precondiciones: ninguna
	 * Entradas: ninguna
	 * Salidas: ninguna
	 * Entradas/Salidas: dos enteros
	 * Postcondiciones: ninguna
	 * 
	 * Resguardo: 	public static void conv24hAmPm (int hora, int minutos, int resHora, int resMinutos)
	{
		System.out.println("Llamada al metodo conv24hAmPm");
		System.out.println("Variables: "+hora+", "+minutos);
		//no se como poner el return en un resguardo por referencia
	}
	* 
	* 
	* COMO NO SABEMOS DEVOLVER POR REFERENCIA EN JAVA, TENDRÉ QUE ADAPTARLO A ASIGNADO AL NOMBRE.
	* 
	* Prototipo: int conv24hAmPm (int hora, int minutos)
	* Breve resumen: Programa que lea una hora en formato 24 horas y la pase a formato AM/PM.
	* Precondiciones: ninguna
	* Entradas: dos enteros
	* Salidas: un entero
	* Entradas/Salidas:
	* Postcondiciones: 0 si se ha convertido sin problemas, 1 si la hora introducida es inválida.
	* 
	* Resguardo: public static int conv24hAmPm (int hora, int minutos)
	{
		System.out.println("Llamada al metodo conv24hAmPm");
		System.out.println("Variables: "+hora+", "+minutos);
		return (1);
	}
	*/
	public static int conv24hAmPm (int hora, int minutos)
	{
		boolean resultadoValidar = false;
		int resultado = 0;
		
		resultadoValidar = MetodosPracticaSubprogramas.validarHora (hora, minutos);
		
		if (resultadoValidar == false)
		{
			resultado = 1;
		}
		
		else
		{
			if (hora <= 12)
			{
				System.out.println ("Son las: "+hora+":"+minutos+" AM");
			}
			else
			{
				switch (hora)
				{
				
				case 13:
				
				hora = 1;
				
				break;
				
				case 14:
				
				hora = 2;
				
				break;
				
				case 15:
				
				hora = 3;
				
				break;
				
				case 16:
				
				hora = 4;
				
				break;
				
				case 17:
				
				hora = 5;
				
				break;
				
				case 18:
				
				hora = 6;
				
				break;
				
				case 19:
				
				hora = 7;
				
				break;
				
				case 20:
				
				hora = 8;
				
				break;
				
				case 21:
				
				hora = 9;
				
				break;
				
				case 22:
				
				hora = 10;
				
				break;
				
				case 23:
				
				hora = 11;
				
				break;
				
				case 24:
				
				hora = 12;
				
				break;
				}//fin_segun
			System.out.println("Son las: "+hora+":"+minutos+" PM");
			}
		}
		
		return (resultado);
	}
	//fin subprograma conv24hAmPm
	
	/* Prototipo: int diasTranscurridos (int dia1, int mes1, int agno1, int dia2, int mes2, int agno2)
	 * Breve comentario: Recibir dos fechas dadas por dia, mes y año y calcular los dias transcurridos entre ambas.
	 * Precondiciones: ninguna
	 * Entradas: seis enteros
	 * Salidas: un entero
	 * Entradas/Salidas: ninguna
	 * Postcondiciones: -1 si la primera fecha es incorrecta, 0 si la segunda fecha es incorrecta y cualquier otro entero
	 * que indique los días transcurridos entre ambas.
	 * 
	 * Resguardo: public static int diasTranscurridos (int dia1, int mes1, int agno1, int dia2, int mes2, int agno2)
	{
			System.out.println("Llamada al metodo diasTranscurridos");
			System.out.println("Variables:");
			System.out.println("Dia 1: "+dia1+", Mes 1: "+mes1+", Anno 1: "+agno1);
			System.out.println("Dia 2: "+dia2+", Mes 2: "+mes2+", Anno 2: "+agno2);
			return (-1);
	}
	 */
	public static int diasTranscurridos (int dia1, int mes1, int agno1, int dia2, int mes2, int agno2)
	{
			int resultado = -1;
			boolean fecha1 = false;
			boolean fecha2 = false;
			
			fecha1 = MetodosPracticaSubprogramas.validarFecha (dia1, mes1, agno1);
			fecha2 = MetodosPracticaSubprogramas.validarFecha (dia2, mes2, agno2);
			
			if (fecha2 == false)
			{
				resultado = 0;
			}
			
			else if (fecha1 == true && fecha2 == true)
			{
				
			}
			return (resultado);
			
			//POR ACABAR
	}
	 
	//fin subprograma
	
	
	/* Prototipo: int relojArena (int numero, char caracter)
	 * Breve comentario: Subprograma que dibuje un reloj de arena con un caracter y un numero a elegir por el usuario.
	 * Precondiciones: ninguna
	 * Entradas: un entero y un caracter
	 * Salidas: un entero
	 * Entradas/Salidas: ninguna
	 * Postcondiciones: devuelve -1 si el numero es incorrecto (no impar entre 1 y 15), y 0 si es correcto.
	 * 
	 * Resguardo: public static int relojArena (int numero, char caracter)
	{
		System.out.println("Llamada al metodo relojArena");
		System.out.println("Variables: "+numero+", "+caracter);
		return (-1);
	}
	 */
	public static int relojArena (int numero, char caracter)
	{
		int resultado = -1;
		int acumulador = 0;
		int espacio = 0;
		
		if (numero >= 1 && numero <= 15 && numero%2 != 0)
		{
			acumulador = numero;
			
			//parte superior
			while (acumulador > 1)
			{
				for (int contadorEspacio = 0; espacio > contadorEspacio; contadorEspacio++)
				{
					System.out.print(" ");
				}
				for (int contador = acumulador; contador > 1; contador--)
				{
					System.out.print(caracter);
				}
				
				acumulador = acumulador - 2;
				
				System.out.println(caracter);
				
				espacio++;
			}
			//fin parte superior
			
			//caracter central
			for (int contadorEspacio = 0; espacio > contadorEspacio; contadorEspacio++)
			{
				System.out.print(" ");
			}
			System.out.println(caracter);
			//fin caracter central
			
			//parte inferior
			while (acumulador < numero)
			{
				acumulador = acumulador + 2;
				espacio--;
				
				for (int contadorEspacio = 0 ; contadorEspacio < espacio ;contadorEspacio++)
				{
					System.out.print(" ");
				}
				
				for (int contador = 1; contador < acumulador; contador++)
				{
					System.out.print(caracter);
				}
				
				System.out.println(caracter);
				
			}
			//fin parte inferior
			
			resultado = 0;
		}
		
		return (resultado);
	}
	//fin subprograma
	
	/* Prototipo: public static boolean isSpaceChar (char ch)
	 * Breve comentario: Determines if the specified character is a Unicode space character. 
	 * A character is considered to be a space character if and only if it is specified to be a space character by the Unicode Standard. 
	 * This method returns true if the character's general category type is any of the following:
			SPACE_SEPARATOR
			LINE_SEPARATOR
			PARAGRAPH_SEPARATOR
	 * Precondiciones: Ninguna
	 * Entradas: ch - the character to be tested.
	 * Salidas: Un booleano
	 * Entradas/Salidas: Ninguna
	 * Postcondiciones: true if the character is a space character; false otherwise.
	 * 
	 * Resguardo: public static boolean isSpaceChar (char ch)
		{
			System.out.println("Llamada al método isSpaceChar");
			System.out.println("Variables: "+ch);
			return (false);
		}
	//fin 
	 */
	public static boolean isSpaceChar (char ch)
	{
		boolean resultado = false;
		if (ch == '\u0020' || ch == '\u00A0' || ch == '\u1680' || ch == '\u200A' || ch == '\u202F' || ch == '\u205F' || ch == '\u3000' || ch == '\u2028' || ch == '\u2029' || (ch > '\u2000' && ch < '\u2009'))
		{
			resultado = true;
		}
		return (resultado);
	}
	//fin subprograma isSpaceChar
	
		/* Prototipo: public static boolean isSpaceChar (int ch)
	 * Breve comentario: Determines if the specified character is a Unicode space character. 
	 * A character is considered to be a space character if and only if it is specified to be a space character by the Unicode Standard. 
	 * This method returns true if the character's general category type is any of the following:
			SPACE_SEPARATOR
			LINE_SEPARATOR
			PARAGRAPH_SEPARATOR
	 * Precondiciones: Ninguna
	 * Entradas: codePoint - the character (Unicode code point) to be tested.
	 * Salidas: Un booleano
	 * Entradas/Salidas: Ninguna
	 * Postcondiciones: true if the character is a space character; false otherwise.
	 * 
	 * Resguardo: public static boolean isSpaceChar (int codePoint)
		{
			System.out.println("Llamada al método isSpaceChar");
			System.out.println("Variables: "+codePoint);
			return (false);
		}
	//fin 
	 */
	public static boolean isSpaceChar (int codePoint)
	{
		boolean resultado = false;
		if (codePoint == '\u0020' || codePoint  == '\u00A0' || codePoint  == '\u1680' || codePoint  == '\u200A' || codePoint  == '\u202F' || codePoint  == '\u205F' || codePoint  == '\u3000' || codePoint  == '\u2028' || codePoint  == '\u2029' || (codePoint  > '\u2000' && codePoint  < '\u2009'))
		{
			resultado = true;
		}
		return (resultado);
	}
	//fin subprograma isSpaceChar
	
	/* Prototipo: public static boolean isWhitespace(char ch)
	 * Breve comentario:Determines if the specified character is white space according to Java. 
	 * A character is a Java whitespace character if and only if it satisfies one of the following criteria:
			It is a Unicode space character (SPACE_SEPARATOR, LINE_SEPARATOR, or PARAGRAPH_SEPARATOR) but is not also a non-breaking space ('\u00A0', '\u2007', '\u202F').
			It is '\t', U+0009 HORIZONTAL TABULATION.
			It is '\n', U+000A LINE FEED.
			It is '\u000B', U+000B VERTICAL TABULATION.
			It is '\f', U+000C FORM FEED.
			It is '\r', U+000D CARRIAGE RETURN.
			It is '\u001C', U+001C FILE SEPARATOR.
			It is '\u001D', U+001D GROUP SEPARATOR.
			It is '\u001E', U+001E RECORD SEPARATOR.
			It is '\u001F', U+001F UNIT SEPARATOR.
	 * Precondiciones: Ninguna
	 * Entradas: ch - the character to be tested.
	 * Salidas: Un booleano
	 * Entradas/Salidas: Ninguna
	 * Postcondiciones: true if the character is a Java whitespace character; false otherwise
	 * 
	 * Resguardo: public static boolean isWhitespace(char ch)
		{
			System.out.println("Llamada al metodo isWhitespace");
			System.out.println("Variables: "+ch);
			return (false);
		}
	 */
	public static boolean isWhitespace(char ch)
	{
		boolean resultado = false;
		
		if (ch == '\u00A0' || ch == '\u2007' || ch == '\u202F' ||ch == '\t' ||ch == '\n' || ch == '\u000B' || ch == '\f' || ch == '\r' ||ch == '\u001C' || ch == '\u001D' || ch == '\u001E' || ch == '\u001F')
		{
			resultado = true;
		}

		return (resultado);
	}
	//fin subprograma isWhitespace
}//fin_pp
