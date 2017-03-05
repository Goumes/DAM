/* Nombre del programa: GestionSocios
 * Entradas: Un socio, caracteres para iniciar y elegir opcion
 * Salidas: mensajes
 * Restricciones: Ninguna
 * 
 * P.G.
 * Inicio
 * 	PrintLeerValidarIniciar
 * 	Mientras quiera Iniciar
 * 			Introducir Socio
 * 			Mientras QuieraIntroducir
 * 				LeerValidarSocio
 * 				GastoCaloriasSocios
	 * 			PrintGastoCalorias
	 * 			ContarNivel
	 * 			LeerValidarReiniciarSocio
	 * 		Fin_Mientras2
 * 			PreguntarActividadParticular
 * 			Si QuieroActividadParticular
 * 					LeerValidarActividad
 * 					segun (actividad)
 * 						caso 1: Nivel bajo
 * 						caso 2: Nivel medio
 * 						caso 3: Nivel alto
 * 					fin_segun
 * 			Fin_Si
 * 			LeerValidarReiniciar
 * 	Fin_mientras
 * Fin
 * 
 */
import java.util.*;
import java.io.*;

public class GestionSocios
{
	public static void main (String [] args) throws IOException
	{
		Scanner teclado = new Scanner (System.in);
		Calculadora calculadora = new Calculadora ();
		InputStreamReader flujo = new InputStreamReader (System.in);
		BufferedReader tecladoString = new BufferedReader (flujo);
		char Iniciar = ' ';
		char Introducir = ' ' ;
		char Actividad = ' ' ;
		int opcion = 0;
		int contadorBAJO = 0;
		int contadorMEDIO = 0;
		int contadorALTO = 0;
		double Calorias = 0.0;
		//PrintLeerValidarIniciar
		do
		{
			System.out.println("Desea ejecutar el programa? S/N");
			Iniciar = Character.toLowerCase (teclado.next().charAt(0));
		}
		while (Iniciar != 's' && Iniciar != 'n');
		//Fin PrintLeerValidarIniciar
		
		while (Iniciar == 's') 
		{
				//IntroducirSocio
				do
				{
					System.out.println("Desea introducir un socio? S/N");
					Introducir = Character.toLowerCase (teclado.next().charAt(0));
				}
				while (Introducir != 's' && Introducir != 'n');
				//Fin IntroducirSocio
				
						while (Introducir == 's')
						{
						
							//LeerValidarSocio
							Socio socio1 = new Socio ();
							Sendero sendero1 = new Sendero ();
							
							System.out.println("Introduzca su Nombre y Apellidos");
							socio1.setApellidosNombre (tecladoString.readLine());
							
							do
							{
								try
								{
								System.out.println("Introduzca la intensidad de la actividad a realizar (BAJO, MEDIO o ALTO)");
								sendero1.setNivel (tecladoString.readLine());
								}
								catch (ExamenException error)
								{
									System.out.println("Error, el nivel sólo puede ser ALTO, MEDIO o BAJO");
								}
							}
							while (sendero1.getNivel () != "BAJO" && sendero1.getNivel () != "MEDIO" && sendero1.getNivel () != "ALTO");
							
							System.out.println("Introduzca el nombre del recorrido");
							sendero1.setNombre (tecladoString.readLine());
							
							System.out.println("Introduzca la duracion del recorrido");
							try
							{
								sendero1.setDuracion (teclado.nextInt());
							}
							catch (ExamenException error)
							{
								System.out.println("La duracion es erronea");
							}
							
							socio1.setTipoActividad (sendero1);
							
							System.out.println("Introduzca el peso del usuario (Con decimales)");
							socio1.setPeso (teclado.nextDouble());
						//Fin LeerValidarSocios
						
						//GastoCaloriasSocios
						calculadora.setDuracion(sendero1.getDuracion());
						calculadora.setNivelActividad(sendero1.getNivel());
						calculadora.setPeso(socio1.getPeso());
						Calorias = calculadora.calculoCalorias();
						//Fin GastoCaloriasSocios
						
						//PrintGastoCalorias
						System.out.println(Calorias);
						//Fin PrintGastoCalorias
						
						//ContarNivel
						if (socio1.getTipoActividad ().getNivel () == "BAJO")
						{
							contadorBAJO++;
						}
						else if (socio1.getTipoActividad ().getNivel () == "MEDIO")
						{
							contadorMEDIO++;
						}
						
						else if (socio1.getTipoActividad ().getNivel () == "ALTO")
						{
							contadorALTO++;
						}
						//Fin ContarNivel
						
						//LeerValidarReiniciarSocio
						do
						{
							System.out.println("Desea volver a  introducir un socio? S/N");
							Introducir = Character.toLowerCase (teclado.next().charAt(0));
						}
						while (Introducir != 's' && Introducir != 'n');
						//Fin LeerValidarReiniciarSocio
						
				}//Fin_Mientras2
				
				//PreguntarActividadParticular
				do
				{
					System.out.println("Desea saber cuantos socios han realizado una actividad en particular? S/N");
					Actividad = Character.toLowerCase (teclado.next().charAt(0));
				}
				while (Actividad != 's' && Actividad != 'n');
				//Si QuieroActividadParticular
				if (Actividad == 's')
				{
						//LeerValidarActividad
						do
						{
							System.out.println("1. Nivel bajo");
							System.out.println("2. Nivel medio");
							System.out.println("3. Nivel alto");
							opcion = teclado.nextInt ();
						}
						while (opcion < 1 || opcion > 3);
						//Fin LeerValidarActividad
						
						//segun (actividad)
						switch (opcion)
						{
							//caso 1: Nivel bajo
							case 1:
							System.out.println("Este tipo de actividad se ha realizado: "+contadorBAJO+" veces."); 
							break;
							//Fin caso1
							//caso 2: Nivel medio
							case 2:
							System.out.println("Este tipo de actividad se ha realizado: "+contadorMEDIO+" veces."); 
							break;
							//Fin caso2
							//caso 3: Nivel alto
							case 3:
							System.out.println("Este tipo de actividad se ha realizado: "+contadorALTO+" veces."); 
							break;
							//Fin caso3
					}//fin_segun
				}//Fin_Si
				//LeerValidarReiniciar
				do
				{
					System.out.println("Desea volver a ejecutar el programa? S/N");
					Iniciar = Character.toLowerCase (teclado.next().charAt(0));
				}
				while (Iniciar != 's' && Iniciar != 'n');
				//Fin LeerValidarReiniciar
		}//Fin_mientras
	}//fin_main
}//fin_clase GestionSocios
