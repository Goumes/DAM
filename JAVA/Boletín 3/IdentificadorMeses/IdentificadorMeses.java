/*IdentificadorMeses
 * Análisis: Diseñar un algoritmo que lea de teclado un número entre 1 y 12 pinte en pantalla el mes del año que le corresponde.
 * Entradas: numero
 * Salidas: mes del año
 * Restricciones: debe ser un número entre el 1 y el 12 obligatoriamente y tiene que ser entero.
 * 
 * P.G.
 * 
 * Inicio
 * 	DeclararVariables
 * 	LeerDatos
 * 	DiferenciarMesPrintRes
 * Fin
*/


//Inicio
import java.util.Scanner;
public class IdentificadorMeses{
	public static void main(String[] args){
	//Declarar variables
	int numero;
	//LeerDatos
	Scanner teclado = new Scanner (System.in);
	System.out.println("Introduzca un n\u00famero entero entre 1 y 12");
	numero = teclado.nextInt();
	//DiferenciarMesPrintRes
	if (numero >= 1 && numero <= 12)
		{
			if (numero == 1)
			{
				System.out.println("Enero");
			}
			else
			{
				if (numero == 2)
				{
					System.out.println("Febrero");
				}
				else
				{
					if (numero == 3)
					{
						System.out.println("Marzo");
					}
					else
					{
						if (numero == 4)
						{
							System.out.println("Abril");
						}
						else
						{
							if (numero == 5)
							{
								System.out.println("Mayo");
							}
							else
							{
								if (numero == 6)
								{
									System.out.println("Junio");
								}
								else
								{
									if (numero == 7)
									{
										System.out.println("Julio");
									}
									else
									{
										if (numero == 8)
										{
											System.out.println("Agosto");
										}
										else
										{
											if (numero == 9)
											{
												System.out.println("Septiembre");
											}
											else
											{
												if (numero == 10)
												{
													System.out.println("Octubre");
												}
												else
												{
													if (numero == 11)
													{
														System.out.println("Noviembre");
													}
													else
													{
														System.out.println("Diciembre");
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
	else
		{
			System.out.println("Error. Introduzca un n\u00famero entero entre 1 y 12");
		}
	}//fin_main
}//fin_pp
