/* EcuacionSegundoGrado
 * Análisis: Realizar un algoritmo que resuelva una ecuación de segundo grado.
 * Fórmula: -b+-RAIZ(b²-4*a*c)/(2*a) considerando como expresión de la ecuación a*x²+b*x+c = 0
 * Entrada: coeficientes ecuacion
 * Salida: resultado1, resultado2
 * Restricciones: a != 0, (b² - 4*a*c) >= 0
 * 
 * P.G.
 * 
 * Inicio
 * Desea iniciar el programa?
 * Mientras QuieraIniciar
 * 		LeerCoeficientes
 * 		HacerOperacionPrintRes
 * 		Desea reiniciar el programa?
 * Fin_mientras
 * Fin
*/

//Inicio
import java.util.Scanner;
import java.lang.Math;
public class EcuacionSegundoGrado{
	public static void main(String[] args){
		double a;
		double b;
		double c;
		double resultado1 = 0;
		double resultado2 = 0;
		char iniciar = ' ';
		Scanner teclado = new Scanner (System.in);
		
		//Desea iniciar el programa?
		System.out.println("Desea iniciar el programa? Y/N");
		iniciar = Character.toLowerCase(teclado.next().charAt(0));
		//Fin Desea iniciar el programa?
		
		//Mientras QuieraIniciar
		while(iniciar == 'y')
		{
			//Fin Mientras QuieraIniciar
			
			//LeerCoeficientes
			System.out.println ("Introduzca los coeficientes de la ecuaci\u00f3n");
			a = teclado.nextInt();
			b = teclado.nextInt();
			c = teclado.nextInt();
			//Fin LeerCoeficientes
			
			//HacerOperacionPrintRes
			if (a != 0)
				{
					if (b*b-(4*a*c)>= 0)
						{
							resultado1 = (-(b) + Math.pow(b*b-(4*a*c),0.5))/(2*a);
							resultado2 = (-(b) - Math.pow(b*b-(4*a*c),0.5))/(2*a);
							System.out.println ("x1= "+resultado1);
							System.out.println ("x2= "+resultado2);
						}
					else
						{
							System.out.println ("No se puede realizar esta operaci\u00f3n, introduzca unos datos v\u00e1lidos.");
						}
				}
			else
				{
					System.out.println ("Introduzca un coeficiente 'a' distinto de 0.");
				}
			//Fin HacerOperacionPrintRes
			
			//Desea reiniciar el programa?
			System.out.println("Desea iniciar el programa? Y/N");
			iniciar = Character.toLowerCase(teclado.next().charAt(0));
			//Fin Desea reiniciar el programa?
			
		}//fin_mientras
	}//fin_main
}//fin_pp
