
public class Pantalla extends UnidadSalida{

	private int resolucion;
	private TipoTecnologia tipoTecnologia;
	private Fecha fecha;
	
	public Pantalla(){
		super();
		this.resolucion=0;
		this.tipoTecnologia=TipoTecnologia.LED;
		this.fecha=new Fecha();
		
	}
	
	public Pantalla(String nombreF,int numS, int unidades, int precio, int resolucion, TipoTecnologia tipo, Fecha f){
		
		super(nombreF,numS,unidades,precio);
	
		this.resolucion=resolucion;
		this.tipoTecnologia=tipo;
		this.fecha=f;
	}
	
	//metodos modificadores
	public void setResolucion(int r){this.resolucion=r;}
	public void setTipoTec(TipoTecnologia t){this.tipoTecnologia=t;}
	public void setFecha(Fecha f){this.fecha=f;}
	
	//metodos consultores
	public int getResolucion(){return this.resolucion;}
	public TipoTecnologia getTipoTec(){return this.tipoTecnologia;}
	public Fecha getFecha(){return this.fecha;}
	
	public String toString(){
		
		return super.toString()+","+resolucion+","+(String)this.tipoTecnologia.name()+","+fecha.toString();
	}
}
