
public class UnidadSalida {
	
	private static int acumulador=0;
	private int identificador;//consultable
	private String nombreFabricante;//consultable
	private int numeroSerie; //consultable
	private int unidades; //consultable modificable
	private double precio;//consultable modificable
	
	
	public UnidadSalida(){
		
		identificador=acumulador +1;
		nombreFabricante =" ";
		numeroSerie=0;
		unidades=0;
		precio=0.0;
		acumulador+=2;
	}
	
	public UnidadSalida(String cadena){
		
	}
	
	public UnidadSalida(String nombreFabricante,int numeroSerie, int unidades,double precio){
		
		this();
		this.identificador=++acumulador;
		this.nombreFabricante=nombreFabricante;
		this.numeroSerie=numeroSerie;
		this.unidades=unidades;
		this.precio=precio;
	}
	
	//metodos consultores
	
	public int getIdentificador(){return this.identificador;}
	public String getNombreF(){return this.nombreFabricante;}
	public int getNumeroSerie(){return this.numeroSerie;}
	public int getUnidades(){return this.unidades;}
	public double getPrecio(){return this.precio;}
	
	//metodos modificadores
	

	public void setUnidades(int n){this.unidades=n;}
	public void setPrecio(double p){this.precio=p;}
	
	
	//metodos heredados
	public String toString(){
		return identificador+","+nombreFabricante+","+numeroSerie+","+unidades+","+precio;
	}	
	
	public int compareTo(UnidadSalida us){
		return (us.nombreFabricante.compareTo(this.nombreFabricante)==0)?(us.numeroSerie>this.numeroSerie)?1:(us.numeroSerie<this.numeroSerie)?-1:0:us.nombreFabricante.compareTo(this.nombreFabricante);
	}
	
	public boolean equals(Object us){
		boolean resultado=false;
		
		if(us!=null && us instanceof UnidadSalida){
			us=(UnidadSalida)us;
			if(((UnidadSalida) us).getNombreF()==this.getNombreF() && ((UnidadSalida) us).getNumeroSerie()==this.getNumeroSerie())
				resultado=true;
		}
		
		
		return resultado;
	}
	

}
