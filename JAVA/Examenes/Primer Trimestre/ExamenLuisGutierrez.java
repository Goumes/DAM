import java.util.*;
import java.io.*;

public class ExamenLuisGutierrez{
	public static void main(String[]args){
		
		int opcion;
		char seguir;
		int numeroTriangulo;
		char caracterTriangulo;
		char eleccionManoJugador; // esta variable guarda la opcion del jugador en char, para hacer el juego mas ameno
		int manoJugador=0; //esta es la mano que ha elegido el jugador convertida a int para compararla con la generada aleatoriamente para la maquina
		int manoMaquina;
		int numeroJugadas;
		int contadorJugadas;
		int jugadasGanadasJugador=0; // no hace falta crear una variable para almacenar las jugadas perdidas ya que son las jugadas ganadas del oponente
		int jugadasGanadasMaquina=0;
		int jugadasEmpatadas=0; // ambos tendran siempre el mismo numero de jugadas empatadas
		
		Scanner teclado = new Scanner(System.in);
		Random aleatorio = new Random();
		
		//validar inicio del programa
		/* Estudio de bucle
		 * 	Bucle controlado por centinela
		 * 	Condicion de entrada: seguir sea distinto de 's' y de 'n'
		 * 	Condicion de salida: seguir sea igual a 's' o a 'n'
		 *  La VCB se inicializa en la primera iteracion y se actualiza al final de cada iteracion, dentro del cuerpo del bucle
		 * 	Repite el proceso de validacion del caracrter para iniciar el programa
		 */	
		do{
			System.out.println("Quiere iniciar el programa? s/n");
			seguir = Character.toLowerCase(teclado.next().charAt(0));
			if(seguir!='s' && seguir!='n'){
				System.out.println("Caracter incorrecto");
			}
		}while(seguir!='s' && seguir!='n');
		
		//si se quiere iniciar el programa (bucle estudiado en papel)
		while(seguir =='s'){
			
			//mostar menu
			do{
				System.out.println("\nElija la opcion que desee");
				System.out.println("1: Pintar triangulo");
				System.out.println("2: Numero apocaliptico");
				System.out.println("3: Juego de Nzhdeh");
				System.out.println("0: Salir");
				opcion = teclado.nextInt();
				if(opcion<0 || opcion>3){
					System.out.println("Opcion erronea");
				}
			}while(opcion<0 || opcion>3);
			
			switch(opcion){
				
				//Pintar Tiangulo
				case 1:
					System.out.println("\nHa elegido Pintar Triangulo\n");
					
					//validar tamaño triangulo
					/* Estudio de bucle
					* Bucle controlado por centinela
					* Condicion de entrada: numeroTriangulo sea menor que 1 o mayor que 9
					* Condicion de salida: numeroTriangulo sea mayor que 1 y menor que 9
					* La VCB se inicializa en la primera iteracion y se actualiza al final de cada iteracion, dentro del cuerpo del bucle
					* Repite el proceso de validacion del caracrter para el triangulo
					*/	
					do{
						System.out.println("Por favor, introduce el numero del tamaño del triangulo, entre 1 y 9");
						numeroTriangulo = teclado.nextInt();
						if(numeroTriangulo<1 || numeroTriangulo>9){
							System.out.println("Numero erroneo");
						}
					}while(numeroTriangulo<1 || numeroTriangulo>9);
					
					//validar caracter triangulo
					/* Estudio de bucle
					* Bucle controlado por centinela
					* Condicion de entrada: caracterTriangulo sea distinto de '*' y menor que 'a' o mayor que 'z'
					* Condicion de salida: caracterTriangulo sea igual a '*' o mayor que 'a' y menor que 'z'
					* La VCB se inicializa en la primera iteracion y se actualiza al final de cada iteracion, dentro del cuerpo del bucle
					* Repite el proceso de validacion del caracrter para el triangulo
					*/	
					do{
						System.out.println("Por favor, introduce el caracter con el que desea pintar el triangulo (* o letra)");
						caracterTriangulo=teclado.next().charAt(0);
						if(caracterTriangulo!='*' && (caracterTriangulo<'a' || caracterTriangulo>'z')){
							System.out.println("Caracter erroneo");
						}
					}while(caracterTriangulo!='*' && (caracterTriangulo<'a' || caracterTriangulo>'z'));
					System.out.println("Lo sentimos, esta opcion se encuentra en construccion");
				break;
				
				//Numero Apocaliptico
				case 2:
					System.out.println("\nHa elegido Numero Apocaliptico\n");
					System.out.println("Lo sentimos, esta opcion se encuentra en construccion");
				break;
				
				//Juego de Nzhdeh
				case 3:
					System.out.println("\nHa elegido Juego de Nzhdeh\n");
					
					//validar numero de jugadas
					/* Estudio de bucle
					* Bucle controlado por centinela
					* Condicion de entrada: numero de jugadas sea menor que 1
					* Condicion de salida: numero de jugadas sea mayor o igual a 1
					* La VCB se inicializa en la primera iteracion y se actualiza al final de cada iteracion, dentro del cuerpo del bucle
					* Repite el proceso de validacion del numero de jugadas de la partida
					*/	
					do{
						System.out.println("Introduce el numero de jugadas que quiere realizar");
						numeroJugadas = teclado.nextInt();
						if(numeroJugadas<1){
							System.out.println("El numero de jugadas debe ser positivo, de 1 a que te canses");
						}
					}while(numeroJugadas<1);
					
					//volvermos a poner las variables del juego a 0 por si el jugador quiere jugar otra partida
					jugadasGanadasJugador=0;
					jugadasGanadasMaquina=0;
					jugadasEmpatadas=0;
					
					//bucle para realizar todas las jugadas (estudiado en papel)
					for(contadorJugadas=1;contadorJugadas<=numeroJugadas;contadorJugadas++){
						
						//validar la mano del jugador
						/* Estudio de bucle
						* Bucle controlado por centinela
						* Condicion de entrada: eleccionManoJugador sea distinto de 'p' y de 'l' y de 's'
						* Condicion de salida: eleccionManoJugador sea igual a 'p' o a 'l' o a 's'
						* La VCB se inicializa en la primera iteracion y se actualiza al final de cada iteracion, dentro del cuerpo del bucle
						* Repite el proceso de validacion del caracter elegido para la mano del jugador
						*/	
						do{
							System.out.println("Elija la mano que desea: p para pierda, l para lagarto, s para Spock");
							eleccionManoJugador = Character.toLowerCase(teclado.next().charAt(0));
							if(eleccionManoJugador !='p' && eleccionManoJugador !='l' && eleccionManoJugador!='s'){
								System.out.println("Caracter erroneo, no intentes engañar a la maquina");
							}
						}while(eleccionManoJugador !='p' && eleccionManoJugador !='l' && eleccionManoJugador!='s');
						
						//convertimos la mano que ha elegido el jugador a int para compararla con la generada aleatoriamente para la maquina
						if(eleccionManoJugador=='p'){
							manoJugador=1;
						}else if(eleccionManoJugador=='l'){
							manoJugador=2;
						}else if(eleccionManoJugador =='s'){
							manoJugador=3;
						}
						
						//generamos la mano de la maquina
						manoMaquina = aleatorio.nextInt(3)+1;
						System.out.println("Jugada numero "+contadorJugadas);
						//comparamos ambas manos
						if((manoJugador == 1 && manoMaquina == 2) || (manoJugador == 2 && manoMaquina == 3) || (manoJugador==3 && manoMaquina==1)){
							System.out.println("Gana el jugador");
							jugadasGanadasJugador = jugadasGanadasJugador+1;
						}else if(manoJugador == manoMaquina){
							System.out.println("Empate");
							jugadasEmpatadas = jugadasEmpatadas+1;
						}else{
							System.out.println("Gana la maquina");
							jugadasGanadasMaquina = jugadasGanadasMaquina+1;
						}
					}
					
					//mostramos los resultados finales de la partida y el ganador final
					System.out.println("\nResultados de la partida:");
					System.out.println("El jugador ha ganado "+jugadasGanadasJugador+" manos");
					System.out.println("La maquina ha ganado "+jugadasGanadasMaquina+" manos");
					System.out.println("Han habido "+jugadasEmpatadas+" empates\n");
					
					if(jugadasGanadasJugador>jugadasGanadasMaquina){
						System.out.println("Gana el jugador, enhorabuena");
					}else if(jugadasGanadasJugador<jugadasGanadasMaquina){
						System.out.println("Gana la maquina, lo siento no puedes vencer a una maquina");
					}else{
						System.out.println("Habeis quedado empate");
					}
				break;
			}
			
			//validar reinicio del programa
			/* Estudio de bucle
			* Bucle controlado por centinela
			* Condicion de entrada: seguir sea distinto de 's' y de 'n'
			* Condicion de salida: seguir sea igual a 's' o a 'n'
			* La VCB se inicializa en la primera iteracion y se actualiza al final de cada iteracion, dentro del cuerpo del bucle
			* Repite el proceso de validacion del caracrter para reiniciar el programa
			*/	
			do{
				System.out.println("\nQuiere volver a iniciar el programa? s/n");
				seguir = Character.toLowerCase(teclado.next().charAt(0));
				if(seguir!='s' && seguir!='n'){
					System.out.println("Caracter incorrecto");
				}
			}while(seguir!='s' && seguir!='n');		
		}
	}
}
