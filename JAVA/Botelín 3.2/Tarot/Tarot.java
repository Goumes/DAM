/* Nombre programa: Tarot
 * 
 * Análisis:Realizar un programa que lea una fecha de nacimiento de la forma día, mes, año, y dé como resultado el número de Tarot. 
 * El programa verificará si la fecha es correcta. El número de Tarot se haya sumando los números de la fecha de nacimiento y 
 * reduciéndolos a un único dígito. 
 * Por ejemplo, si su fecha de nacimiento es 20 de julio de 1984, el número de Tarot sería: 20 + 7+ 1984 = 2011 --> 2 + 0+ 1+1 = 4
 * Entrada: dia, mes, año
 * Salida: numero Tarot
 * Restricciones:El año debe ser positivo
 * Estudio Bucles: 
 * 1.Iniciar. Controlado por centinela, condición de salida ="n"
 * 
 * 
 * P.G.
 * Inicio
 * LeerValidarIniciar
 * Mientras QuieraIniciar
 * 		LeerValidarFecha
 * 		CalcularNumeroTarot
 * 		PrintTarot
 * 		LeerValidarReiniciar
 * Fin_Mientras
 * Fin
 */
import java.util.Scanner;
public class Tarot {
	public static void main (String[]args){
		Scanner teclado = new Scanner(System.in);
		char iniciar = ' ';
		int dia = ' ';
		int mes = ' ';
		int year = ' ';
		int tarot = ' ';
		boolean bisiesto = false;
		
		//LeerValidarIniciar
		do
		{
		System.out.println("Desea iniciar el programa? Y/N");
		iniciar = Character.toLowerCase(teclado.next().charAt(0));
		}
		while (iniciar!='y' && iniciar != 'n');
		//Fin LeerValidarIniciar
		
		//Mientras QuieraIniciar
		while (iniciar == 'y')
		{ 
		
			//LeerValidarFecha
			do
			{
				System.out.println("Introduzca el año");
				year = teclado.nextInt();
				if ((year % 400) == 0)
				{
					bisiesto = true;
				}
				else
				{
					if ((year % 4) == 0 && (year % 100) != 0 )
					{
						bisiesto = true;
					}
					else
					{
						bisiesto = false;
					}
				}
			}
			while (year < 0);
			do
			{
				System.out.println("Introduzca el mes");           
				mes = teclado.nextInt();
			}
			while (mes < 0 || mes > 12);
			
			boolean pasar = false;
			
			do
			{
				System.out.println("Introduzca el dia");
				dia = teclado.nextInt();
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
						pasar = true;
					}
					break;
					
					case 4:
					case 7:
					case 9:
					case 11:
					if (dia > 0 && dia <= 30)
					{
						pasar = true;
					}
					break;
					
					case 2:
					if (dia > 0 && dia <= 29 && bisiesto == true)
					{
						pasar = true;
					}
					if (dia > 0 && dia <= 28)
					{
						pasar = true;
					}
					
					break;
				}//fin_segun
			}
			while (pasar == false);
			//Fin LeerValidarFecha
			
			//CalcularNumeroTarot
			tarot = dia + mes + year;
			do
			{
			tarot = (tarot/10) + (tarot % 10);
			}
			while (tarot > 10);
			//Fin CalcularNumeroTarot
			
			//PrintTarot
			System.out.println("Su numero del Tarot es: "+tarot);
			//Fin PrintTarot
			
			//LeerValidarReiniciar
			do
			{
				System.out.println("Desea reiniciar el programa? Y/N");
				iniciar = Character.toLowerCase(teclado.next().charAt(0));
			}
			while (iniciar!='y' && iniciar != 'n');
			//Fin LeerValidarReiniciar
			
		}//Fin_Mientras
	}//fin_main
}//fin_pp
