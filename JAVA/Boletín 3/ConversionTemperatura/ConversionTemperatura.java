/* Nombre programa: ConversionTemperatura
 * Análisis: Realizar un algoritmo que cambie una temperatura dada en Kelvin a Fahrenheit y viceversa.
 * Fórmulas: ºKelvin = ((ºFahrenheit - 32)/1,8) + 273,15
 * 			 ºFahrenheit = ((ºKelvin - 273,15)*1,8) + 32
 * Entradas: kelvin, fahrenheit
 * Salidas: kelvin, fahrenheit
 * Restricciones:
 * Bucle Iniciar tipo indicador, condición de salida = 'n'.
 * Bucle ValidarIniciar tipo centinela, condición de salida = 'y' || 'n'.
 * Bucle ValidarTemperatura tipo indicador, condición de salida = temperatura correcta.
 * P.G
 * 
 * Inicio
 * LeerValidarIniciar
 * Mientras QuieraIniciar
 * 		LeerValidarTemperatura
 * 		ConvertirTemperaturaPrintRes
 * 		LeerValidarReiniciar
 * Fin_mientras
 * Fin
 * 
 * 
 */
 
 //Inicio
 
 import java.util.*;
 public class ConversionTemperatura{
	 public static void main (String[] args){
		double kelvin = 0;
		double fahrenheit = 0;
		char medida=' ';
		char iniciar=' ';
		Scanner teclado = new Scanner (System.in);
		
		//LeerValidarIniciar
		while (iniciar != 'y' && iniciar != 'n')
		{
		System.out.println("Desea inciar el programa?: Y/N");
		iniciar = Character.toLowerCase(teclado.next().charAt(0));
		}
		//Fin LeerValidarIniciar 
		
		//Mientras QuieraIniciar
		while (iniciar == 'y')
		{
			//LeerValidarTemperatura
			System.out.println("Desea introducir los datos en Kelvin o Fahrenheit?");
			medida = Character.toLowerCase (teclado.next().charAt(0));
			while (medida != 'k' && medida != 'f')
			{
			System.out.println("Error. Desea introducir los datos en Kelvin o Fahrenheit?");
			medida = Character.toLowerCase (teclado.next().charAt(0));
			}//fin_mientras2
		
			//Fin LeerValidarTemperatura
		
			//ConvertirTemperaturaPrintRes
			 if (medida == 'k')
			{
				System.out.println("Introduzca la temperatura deseada:");
				kelvin = teclado.nextDouble();
				fahrenheit = ((kelvin - 273.15)*1.8) + 32;
				System.out.println("La temperatura en grados fahrenheit es: "+fahrenheit);
			}
			if (medida == 'f')
			{
				System.out.println("Introduzca la temperatura deseada:");
				fahrenheit = teclado.nextDouble();
				kelvin = ((fahrenheit - 32)/18) + 273.15;
				System.out.println("La temperatura en grados kelvin es: "+kelvin);
			}
			//Fin ConvertirTemperaturaPrintRes
			
			//LeerValidarReiniciar
			System.out.println("Desea reinciar el programa?: Y/N");
			iniciar = Character.toLowerCase (teclado.next().charAt(0));
			while (iniciar != 'y' && iniciar != 'n')
			{
			System.out.println("Desea reiniciar el programa?: Y/N");
			iniciar = Character.toLowerCase(teclado.next().charAt(0));
			}
			//LeerValidarReiniciar
		
		}//fin_mientras
	 }//fin_main
 }//fin_pp
 
