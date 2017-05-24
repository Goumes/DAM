import java.util.GregorianCalendar;

public class Fecha {

	private int d,a;
	private String m;
	
	public Fecha(){
		GregorianCalendar gc=new GregorianCalendar();
		String c=gc.getTime().toString();
		String[] cs=c.split(" ");
		this.d =Integer.parseInt(cs[2]);
		this.m = cs[1];
		this.a=Integer.parseInt(cs[5]);
		
	}
	
	public Fecha(String d, String m, String a){
		
		this.d=Integer.parseInt(d);
		this.m=m;
		this.a=Integer.parseInt(a);
	}
	
	public String toString (){
		return d+"/"+m+"/"+a;
	}
	
}
