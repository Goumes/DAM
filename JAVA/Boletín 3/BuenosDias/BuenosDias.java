/*BuenosDias
 * Análisis: Escribir un algoritmo que lea un instante de tiempo dado en horas y minutos y escriba como respuesta los mensajes 
 * "Buenos días", "Buenas tardes", "Buenas noches" de acuerdo con las siguientes reglas:
 * a) Es de día desde las 7:30 hasta las 14:00 horas
 * b) Es tarde desde las 14:01 hasta las 20:30 horas.
 * c) Es noche desde las 20:31 hasta las 7:29 horas
 * Entradas: hora, minutos
 * Salida: mensaje
 * Restricciones: La hora mínima es 00:00 y la hora máxima es 23:59. 
 * Las horas se encuentran en el rango de 0 a 23, y los minutos en el rango de 0 a 59.
 * 
 * 
 * P.G.
 * 
 * Inicio
 * 	DeclararVariables
 * 	LeerDatos
 * 	IdentificarHoraPrintRes
 * Fin
 */



//Inicio
import java.util.Scanner;
public class BuenosDias{
	public static void main(String[] args){
		
		//DeclararVariables
		int hora;
		int minutos;
		//Fin DeclararVariables
		
		//LeerDatos
		Scanner teclado = new Scanner (System.in);
		System.out.println ("Introduzca la hora deseada");
		hora = teclado.nextInt();
		System.out.println ("Introduzca los minutos");
		minutos = teclado.nextInt();
		//Fin LeerDatos
		
		//IdentificarHoraPrintRes
		if (hora >= 0 && hora <= 23 && minutos >= 0 && minutos <= 59)
		{
			if (hora >= 7 && hora <= 14)
			{
				if (hora == 7 && minutos >= 30)
				{
					System.out.println ("Buenos d\u00edas");
				}
				else
				{
					if (hora == 7 && minutos < 30)
					{
						System.out.println ("Buenas noches");
					}
					else
					{
						if (hora == 14 && minutos == 0)
						{
							System.out.println ("Buenos d\u00edas");
						}
						else
						{
							if (hora == 14 && minutos >0)
							{
								System.out.println ("Buenas tardes");
							}
							else
							{
								System.out.println ("Buenos d\u00edas");
							}
						}
					}
				} 
			}
			else
			{
				if (hora >= 14 && hora <= 20)
				{
					if (hora == 20 && minutos <= 30)
					{
						System.out.println("Buenas tardes");
					}
					else
					{
						if (hora == 20 && minutos > 30)
						{
								System.out.println ("Buenas noches");
						}
						else
						{
							System.out.println ("Buenas tardes");
						}
					}
				}
				else
				{
					System.out.println ("Buenas noches");
				}
			}
		}
		else
		{
			System.out.println ("Introduzca una hora v\u00e1lida");
		}
		//Fin IdentificadorHoraPrintRes
		
	}//fin_main
}//fin_pp
