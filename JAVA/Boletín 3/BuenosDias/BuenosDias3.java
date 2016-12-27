/*Nombre del programa: BuenosDias2
 * Análisis: Escribir un algoritmo que lea un instante de tiempo dado en horas y minutos y escriba como respuesta los mensajes 
 * "Buenos días", "Buenas tardes", "Buenas noches" de acuerdo con las siguientes reglas:
 * a) Es de día desde las 7:30 hasta las 14:00 horas
 * b) Es tarde desde las 14:01 hasta las 20:30 horas.
 * c) Es noche desde las 20:31 hasta las 7:29 horas
 * Bucle Iniciar tipo centinela, condición de salida = 'n'.
 * Bucle ValidarIniciar tipo centinela, condición de salida = 'y' || 'n'.
 * Bucle ValidarHora tipo centinela, condición de salida = hora correcta.
 * Entradas: hora, minutos
 * Salida: mensaje
 * Restricciones: La hora mínima es 00:00 y la hora máxima es 23:59. 
 * Las horas se encuentran en el rango de 0 a 23, y los minutos en el rango de 0 a 59.
 * 
 * 
 * P.G.
 * 
 * Inicio
 * 	LeerValidarIniciar
 * 	Mientras QuieraIniciar
 * 		LeerValidarHora
 * 		IdentificarHoraPrintRes
 * 		LeerValidarReiniciar
 * Fin_mientras
 * Fin
 * 
 * NO ES NECESARIO EL DE SEGUNDO NIVEL EN ESTE CASO.
 * 
 * P.G.Nv2

 * LeerValidarHora
 * 	IntroducirHora
 * 	Mientras HoraIncorrecta
 * 		VolverIntroducirHora
 * 	Fin_mientras
 */

//CORREGIR. ES PREFERENTE HACER PRIMERO EL ERROR EN EL IF, Y EN EL ELSE DESARROLLAR EL CÓDIGO.

//Inicio
import java.util.Scanner;
public class BuenosDias3{
	public static void main(String[] args){
		int hora;
		int minutos;
		char iniciar = ' ';
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
			//LeerValidarHora
			
				//Introduzca la hora
			System.out.println ("Introduzca la hora deseada");
			hora = teclado.nextInt();
			System.out.println ("Introduzca los minutos");
			minutos = teclado.nextInt();
				//Fin Introduzca la hora
				
				//Mientras HoraIncorrecta
			while (hora < 0 || hora > 23 || minutos < 0 || minutos > 59)
			{
				//Fin Mientras HoraIncorrecta
				
				//Volver a introducir la hora
				System.out.println ("Error. Introduzca la hora deseada");
				hora = teclado.nextInt();
				System.out.println ("Introduzca los minutos");
				minutos = teclado.nextInt();
				//Fin Volver a introducir la hora
				
			}//fin_mientras2
			
			//Fin LeerValidarHora
			
			//IdentificarHoraPrintRes
			if ((hora == 7 && minutos >= 30) ||(hora >= 8 && hora <= 13)|| (hora == 14 && minutos == 0))
			{
				System.out.println("Buenos d\u00edas");
			}
			else
			{
				if ((hora == 14 && minutos >= 1)||(hora >= 15 && hora <= 19)||(hora == 20 && minutos <= 30))
				{
					System.out.println("Buenas tardes");
				}
				else
				{
					System.out.println("Buenas noches");
				}
			}
			
			//Fin IdentificarHoraPrintRes
		
			//LeerValidarReiniciar
			System.out.println("Desea reinciar el programa?: Y/N");
			iniciar = Character.toLowerCase (teclado.next().charAt(0));
			while (iniciar != 'y' && iniciar != 'n')
			{
			System.out.println("Desea inciar el programa?: Y/N");
			iniciar = Character.toLowerCase(teclado.next().charAt(0));
			}
			//LeerValidarReiniciar
				
		}//fin_mientras
	}//fin_main
}//fin_pp
//Fin
