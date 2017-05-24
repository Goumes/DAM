import java.util.GregorianCalendar;

public class Test {

	public static void main(String[] args) {
		GregorianCalendar gc=new GregorianCalendar();
		

		Pantalla p=new Pantalla();
		/*System.out.println(p.toString());
		p.setPrecio(150);
		p.setUnidades(200);
		p.setResolucion(10);
		p.setTipoTec(TipoTecnologia.LED);
		System.out.println(p.toString());*/
		//p=CreacionFichero.crearPantalla();
		//System.out.println(p.toString());
		//CreacionFichero.cargarFichero();
		CreacionFichero.mostrarFichero();
		
	}

}
