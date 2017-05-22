
public class PuntoIMPL implements Punto
{
	private Double x;
	private Double y;
	private static Punto origen = new PuntoIMPL ();
	
	
	public PuntoIMPL ()
	{
		x = 0.0;
		y = 0.0;
	}
	
	@Override
	public Double getX()
	{
		// TODO Auto-generated method stub
		return x;
	}

	@Override
	public Double getY()
	{
		// TODO Auto-generated method stub
		return y;
	}

	@Override
	public void setX(Double x1)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void setY(Double y1)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public Punto getOrigen()
	{
		// TODO Auto-generated method stub
		return origen;
	}

	public static void main (String [] args)
	{
		PuntoIMPL punto = null;
		
		punto = new PuntoIMPL ();
		
		System.out.println(punto.getOrigen().getX());
		System.out.println(punto.getOrigen().getY());
	}
}
