/**CalcularAbsolutoInverso
*Realizar un algoritmo que lea un dato de teclado y calcule su inverso y su valor absoluto. 
*Considerar el caso especial del valor 0 mostrando el mensaje de error correspondiente.
*Entradas: numero
*Salidas: inverso, absoluto
*Restricciones: distinguir entre != ó == que 0


*P.G

*Inicio
*	LeerDatos
*	CalcularInversoAbsolutoPrintRes
*Fin
*/



//AÑADIR EXECPCIÓN SI SE INTRODUCE UNA LETRA

//Inicio
import java.util.Scanner;
public class CalcularAbsolutoInverso{
	public static void main(String[] args)
	{
	//LeerDatos
	double numero;
	double inverso = 0;
	double absoluto = 0;
	Scanner teclado = new Scanner (System.in);
	System.out.println("Introduzca un numero");
	numero = teclado.nextInt();
	//CalcularInversoAbsolutoPrintRes
	if (numero!=0)
		{
		inverso = 1/numero;
		if (numero>0)
			{
			absoluto = numero;
			}
			System.out.println("absoluto = "+absoluto);
			System.out.println("inverso = "+inverso);
			}
		else
		{
			absoluto = -(numero);
			System.out.println("Error. No se puede calcular");	
		}
//Fin
	}//fin_main
}//fin_pp
