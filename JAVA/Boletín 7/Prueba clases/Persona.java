/* Interfaz:
 * 
 *	Propiedades:
 * 
 * 			Básicas:	DNI 			------- tipo String ------- Consultable / Modificable
 * 						Nombre 			------- tipo String ------- Consultable / Modificable
 * 						Apellidos 		------- tipo String ------- Consultable / Modificable
 * 						Sueldo Base 	------- tipo Double ------- Consultable / Modificable
 * 						IRPF 			------- tipo Double ------- Consultable / Modificable
 * 
 * 			Derivadas:	Sueldo			------- tipo Double ------- Consultable
 * 
 * 			Compartidas:
 * 
 * Fórmula: Sueldo = Sueldo base - (Sueldo base * IRPF)
 * 
 * Restricciones: Todos los números deben ser positivos ó 0. El DNI debe tener 8 números y una letra válida.
 * 
 * 		String getDNI ();
 * 		void setDNI (String DNI)
 * 
 * 		String getNombre ();
 * 		void setNombre (String Nombre)
 * 
 * 		String getApellidos ();
 * 		void setApellidos (String Apellidos)
 * 
 * 		Double getSueldoBase ();
 * 		void setSueldoBase(Double sueldoBase);
 * 
 * 		Double getIRPF ();
 * 		void setIRPF (Double IRPF);
 * 
 * 		Double getSueldo ();
 */
 import java.util.*;
 
public class Persona
{
	//Atributos
	private String DNI;
	private String Nombre;
	private String Apellidos;
	private double sueldoBase;
	private double IRPF;
	//Fin Atributos
	
	//Constructores
	public Persona ()
	{
		DNI = " ";
		Nombre = " ";
		Apellidos = " ";
		sueldoBase = 0.0;
		IRPF = 0.0;
	}
	
	/* copia */
	public Persona (Persona persona)
	{
		this.DNI = persona.DNI;
		this.Nombre = persona.Nombre;
		this.Apellidos = persona.Apellidos;
		this.sueldoBase = persona.sueldoBase;
		this.IRPF = persona.IRPF;
	}
	
	public Persona (String DNI, String Nombre, String Apellidos, double sueldoBase, double IRPF)
	{
		this.DNI = DNI;
		this.Nombre = Nombre;
		this.Apellidos = Apellidos;
		this.sueldoBase = sueldoBase;
		this.IRPF = IRPF;
	}
	//Fin Constructores
	
	//Métodos añadidos
	public String toString ()
	{
		System.out.println("Atributos : ");
		String s = ("DNI: "+DNI+", Nombre: "+Nombre+", Apellidos: "+Apellidos+", Sueldo base: "+sueldoBase+", IRPF: "+IRPF);
		return s;
	}
	//Fin Métodos añadidos
	
	
	//Getes y setes
	public String getDNI ()
	{
		return DNI;
	}
	
	public void setDNI (String DNI)
	{
		this.DNI = DNI;
	}
	
	public String getNombre ()
	{
		return Nombre;
	}
	
	public void setNombre (String Nombre)
	{
		this.Nombre = Nombre;
	}
	
	public String getApellidos ()
	{
		return Apellidos;
	}
	
	public void setApellidos (String Apellidos)
	{
		this.Apellidos = Apellidos;
	}
	
	public double getSueldoBase ()
	{
		return sueldoBase;
	}
	
	public void setSueldoBase (double sueldoBase)
	{
		this.sueldoBase = sueldoBase;
	}
	
	public Double getIRPF ()
	{
		return IRPF;
	}
	
	public void setIRPF (Double IRPF)
	{
		this.IRPF = IRPF;
	}
	
	public Double getSueldo ()
	{
		double Sueldo = sueldoBase - (sueldoBase * IRPF);
		return Sueldo;
	}
	//Fin Geter y setes
}
