import java.util.*;
public class ConductoresMetodosNavidad
{
	public static void main (String[]args)
	{
		Scanner teclado = new Scanner (System.in);
		char pruebaCaracter = ' '; //Declaré estas variables para usarlas en caso de prueba de lectura como con el caracter '¡'.
		int pruebaNumero = 0;
		int contadorFriki;
		
		//Conductores ordenAlfabeto
			//System.out.println(MetodosNavidad.ordenAlfabeto ('a','d'));
			//System.out.println(MetodosNavidad.ordenAlfabeto ('a','a'));
			//System.out.println(MetodosNavidad.ordenAlfabeto ('d','a'));
			//System.out.println(MetodosNavidad.ordenAlfabeto (',','d'));
		//Fin Conductores ordenAlfabeto
		
		//Conductores esMayuscula
			//System.out.println(MetodosNavidad.esMayuscula ('a'));
			//System.out.println(MetodosNavidad.esMayuscula ('z'));
			//System.out.println(MetodosNavidad.esMayuscula ('A'));
			//System.out.println(MetodosNavidad.esMayuscula ('Z'));
			//System.out.println(MetodosNavidad.esMayuscula ('^'));
		//Fin Conductores esMayuscula
		
		//Conductores esMinuscula
			//System.out.println(MetodosNavidad.esMinuscula ('a'));
			//System.out.println(MetodosNavidad.esMinuscula ('z'));
			//System.out.println(MetodosNavidad.esMinuscula ('A'));
			//System.out.println(MetodosNavidad.esMinuscula ('Z'));
			//System.out.println(MetodosNavidad.esMinuscula ('^'));
		//Fin Conductores esMinuscula
		
		//Conductores rangoDigito
			//System.out.println(MetodosNavidad.rangoDigito (0));
			//System.out.println(MetodosNavidad.rangoDigito (9));
			//System.out.println(MetodosNavidad.rangoDigito (-1));
		//Fin Conductores rangoDigito
		
		//Conductores simboloPuntuacion
			//System.out.println(MetodosNavidad.simboloPuntuacion ('.'));
			//System.out.println(MetodosNavidad.simboloPuntuacion ('?'));
			//System.out.println(MetodosNavidad.simboloPuntuacion ((char)173)); //Por alguna razón no me pilla el símbolo '¡' directamente.
			//System.out.println(MetodosNavidad.simboloPuntuacion ('d'));
		//Fin Conductores simboloPuntuacion
		
		//Conductores Compuesto
			//System.out.println(MetodosNavidad.Compuesto (4));
			//System.out.println(MetodosNavidad.Compuesto (3));
			//System.out.println(MetodosNavidad.Compuesto (1));
		//Fin Conductores Compuesto
		
		//Conductores Perfecto
			//System.out.println(MetodosNavidad.Perfecto (28));
			//System.out.println(MetodosNavidad.Perfecto (496));
			//System.out.println(MetodosNavidad.Perfecto (8128));
			//System.out.println(MetodosNavidad.Perfecto (4324));
		//Fin Conductores Perfecto
		
		//Conductores Semiperfecto
			//System.out.println(MetodosNavidad.Semiperfecto (2000));
			//System.out.println(MetodosNavidad.Semiperfecto (18));
			//System.out.println(MetodosNavidad.Semiperfecto (24));
			//System.out.println(MetodosNavidad.Semiperfecto (5));
			//System.out.println(MetodosNavidad.Semiperfecto (1));
		//Fin Conductores Semiperfecto
		
		//Conductores numeroFriki
		//for (contadorFriki = 0; contadorFriki < 10000; contadorFriki++)
		//{
			//System.out.println(MetodosNavidad.numeroFriki (contadorFriki));
		//}
		//Fin Conductores numeroFriki
		
		//Conductores mensajeGraciosillo
			//MetodosNavidad.mensajeGraciosillo (5);
		//Fin Conductores mensajeGraciosillo
		
		//Conductores PrimoProbable
		//for (int contador = 0; contador < 10000; contador++)
		//{
		//	System.out.println(MetodosNavidad.primoProbable (9));
	//	}
		//Fin Conductores Primoprobable
		
		//Conductores compararFechas
			//System.out.println(MetodosNavidad.compararFechas (29, 12, 2016, 31, 12, 2016)); //menor
			//System.out.println(MetodosNavidad.compararFechas (29, 12, 2016, 29, 12, 2016)); //igual
			//System.out.println(MetodosNavidad.compararFechas (29, 12, 2016, 28, 10, 1996)); //mayor
			//System.out.println(MetodosNavidad.compararFechas (33, 5, 1997, 32, 12, 2016)); //primera fecha erronea
			//System.out.println(MetodosNavidad.compararFechas (29, 12, 2016, 32, 12, 2016)); //segunda fecha erronea
		//Fin Conductores compararFechas
		
		//Conductores conv24hAmPm
			//System.out.println(MetodosNavidad.conv24hAmPm (15, 30));
			//System.out.println(MetodosNavidad.conv24hAmPm (3, 30));
			//System.out.println(MetodosNavidad.conv24hAmPm (23, 59));
			//System.out.println(MetodosNavidad.conv24hAmPm (0, 1));
			//System.out.println(MetodosNavidad.conv24hAmPm (25, 22));
		//Fin Conductores conv24hAmPm
		
		//Conductores diasTranscurridos
			//System.out.println(MetodosNavidad.diasTranscurridos (22, 12, 2016, 31, 12, 2016));
			//System.out.println(MetodosNavidad.diasTranscurridos (22, 8, 2016, 22, 12, 2015));
			//System.out.println(MetodosNavidad.diasTranscurridos (22, 12, 2012, 30, 03, 2016));
		//Fin Conductores diasTranscurridos
		
		//Conductores relojArena
			//System.out.println(MetodosNavidad.relojArena (7, 'D')); //impar dentro rango
			//System.out.println(MetodosNavidad.relojArena (1, '*')); //limite inferior
			System.out.println(MetodosNavidad.relojArena (15, 'X')); //limite superior
			//System.out.println(MetodosNavidad.relojArena (8, '*')); //par
			//System.out.println(MetodosNavidad.relojArena (17, '*')); //impar fuera rango
		//Fin Conductores relojArena
		
		//String prueba = " ";
		//prueba = teclado.next();
		//System.out.println(prueba);
	}//fin_main
}//fin_pp
