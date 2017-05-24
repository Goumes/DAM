package examenProgramacion;

public interface UnidadSalida 
{
	public abstract int getIdentificador ();
	
	public abstract String getNombreFabricante ();
	
	public abstract int getNumeroSerie ();
	
	public abstract int getUnidades ();
	public abstract void setUnidades (int unidades) throws ExamenException;
	
	public abstract double getPrecio ();
	public abstract void setPrecio (double precio) throws ExamenException;
	
	
}
