import java.io.*;
import java.util.*;

public class CreacionFichero {
	
	/*cabecera: public static void cargarFichero () 
	 * descripcion: procedimiento que guardara tantas personas como se introduzcan por teclado en el fichero
	 * fichero Pantalolas.txt
	 * */

	public static void cargarFichero () {
	  
		Pantalla p=null;
		char r=' ';
		Scanner lector =new Scanner(System.in);
		try {
		FileWriter escritor= new FileWriter(new File("Pantallas.txt"),true);
	
	 do{
		 
		 
		 p=crearPantalla();
		 
		 escritor.write(p.toString());
		 
		 
		 System.out.println("Desea introducir nuevos productos(S/N)");
		 r=lector.nextLine().charAt(0);
		 
	 }while (r=='S' || r=='s');// mejor hacer un subprograma de validar ... etc etc... 
		
	  
	 escritor.close();
	  
	   }catch(IOException e){}

	}
	
	/*cabecera: public static Pantalla crearPantalla()
	 * descripcion: funcion que devolvera un objeto pantalla ,
	 *  con los datos tomasdos de teclado para cada campo
	 *  salidas:  un objeto Pantalla
	 *  postcondiciones: ninguna, el objeto tendra los atributos introducidos por teclado
	 * */
	public static Pantalla crearPantalla(){
		Pantalla p=null;
		String nombreF;
		int numS,uni,precio,res;
		TipoTecnologia tipo;
		int d,a;
		String m;
		Scanner teclado= new Scanner(System.in); 
		System.out.println("Introduzca el nombre del fabricante");
		nombreF=teclado.nextLine();
		System.out.println("Introduzca el numero de serie");
		numS=Integer.parseInt(teclado.nextLine());
		System.out.println("Introduzca el numero de unidades");
		uni=Integer.parseInt(teclado.nextLine());
		System.out.println("Introduzca el precio de cada unidad");
		precio=Integer.parseInt(teclado.nextLine());
		System.out.println("Introduzca la resolucion de la pantalla");
		res=Integer.parseInt(teclado.nextLine());
		System.out.println("Introduzca el tipo de tecnologia (1->LCD  2->LED  3 ->OLED)");
		switch (Integer.parseInt(teclado.nextLine())){
		case 1:
			tipo=TipoTecnologia.LCD;
			break;
		case 2: 
			tipo=TipoTecnologia.LED;
			break;
		case 3: 
			tipo=TipoTecnologia.OLED;
			break;
		default: 
			tipo=TipoTecnologia.LED;
		
		}
		System.out.println("Introduzca la fecha de favricacion:");
		System.out.println("Introduzca el dia:");
		d=Integer.parseInt(teclado.nextLine());
		System.out.println("Introduzca el mes :(3 primeros caractereres de mes)");
		m=teclado.nextLine();
		System.out.println("Introduzca el año");
		a=Integer.parseInt(teclado.nextLine());
		
		p=new Pantalla(nombreF,numS,uni,precio,res,tipo,new Fecha(Integer.toString(d),m,Integer.toString(a)));
		
		return p;
	}
	
	/*cabecera: public static void mostrarFichero()
	 * descripcion: procedimiento que mostrara por pantalla todos los objetos pantallas que se encuentren el fichero 
	 * Pantallas.txt
	 * */
	
	public static void mostrarFichero(){
		try {
			Scanner sc=new Scanner(new File("Pantallas.txt"));
		
		
			while(sc.hasNext()){
				
				System.out.println(sc.nextLine());
				
			}
		
		
		
		
			sc.close();
		
		} catch (FileNotFoundException e) {}
		
		
	}
	
	/*cabecera: public static ArrayList<Pantalla> obtenerPantallas
	 * descripcion: funcion que devolvera todas las Pantallas leidas del fichero "Pantallas.txt"
	 * salidas: una lista con todos los objetos pantalla
	 * postcondiciones: ninguna
	 * */
	public static ArrayList<Pantalla> obtenerPantallas(){// hacer constructor por cadena en la clase para simplificar el codigop de este metodo
		return new ArrayList<Pantalla>();
	}
	
	/*cabecera: public static void ordenar()
	 * descripcion: metodo que ordenara el fichero segun el orden natural de las pantallas
	 * */
	public static void ordenar(){
		(obtenerPantallas()).sort(null);
	}

}
