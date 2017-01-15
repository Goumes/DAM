/* Interfaz:
 * 
 *	Propiedades:
 * 
 * 			Básicas:	Diagonal1 			------- tipo Double ------- Consultable / Modificable
 * 						Diagonal2			------- tipo Double ------- Consultable / Modificable
 * 
 * 			Derivadas:	Area			------- tipo Double ------- Consultable
 * 						Perimetro		------- tipo Double ------- Consultable
 * 						Lado			------- tipo Double ------- Consultable
 * 
 * 			Compartidas: X
 * 
 * Fórmulas: Area = (Diagonal1 * Diagonal2)/2
 * 			Perimetro = 4 * Lado
 * 			Lado = RAIZ² ((Diagonal1/2)² + (Diagonal2/2)²)
 * 
 * Restricciones: Todos los números deben ser positivos y mayores que 0.
 * 
 * 		Double getDiagonal1 ();
 * 		void setDiagonal1 (Double Diagonal1)
 * 
 * 		Double getDiagonal2 ();
 * 		void setDiagonal2 (Double Diagonal2)
 * 
 * 		Double getArea ();
 * 
 * 		Double getPerimetro ();
 * 
 * 		Double getLado ();
 */
import java.util.*;
import java.lang.*;
 
public class Rombo
{
	//Atributos
	private double Diagonal1;
	private double Diagonal2;
	//fin Atributos
	
	//Constructores
	
	public Rombo ()
	{
		Diagonal1 = 0.0;
		Diagonal2 = 0.0;
	}
	
	/* Copia */
	
	public Rombo (Rombo rombo) //¿Se usan las variables de este constructor en el resto de métodos?
	{
		this.Diagonal1 = rombo.Diagonal1;
		this.Diagonal2 = rombo.Diagonal2;
	}
	
	public Rombo (double Diagonal1, double Diagonal2)
	{
		this.Diagonal1 = Diagonal1;
		this.Diagonal2 = Diagonal2;
	}
	//Fin Constructores
	
	//Métodos añadidos
	public String toString ()
	{
		System.out.println("Variables del rombo: ");
		String s = ("Diagonal 1: "+Diagonal1+" Diagonal 2: "+Diagonal2);
		return s;
	}
	//Fin Métodos añadidos
	
	//getes y setes
	public double getDiagonal1 ()
	{
		return Diagonal1;
	}
	
	public void setDiagonal1 (double Diagonal1)
	{
		this.Diagonal1 = Diagonal1;
	}
	
	public double getDiagonal2 ()
	{
		return Diagonal2;
	}
	
	public void setDiagonal2 (double Diagonal2)
	{
		this.Diagonal2 = Diagonal2;
	}
	
	public double getArea ()
	{
		double Area = (Diagonal1 * Diagonal2)/2;
		return Area;
	}
	
	public double getPerimetro ()
	{
		Rombo rombo = new Rombo (Diagonal1, Diagonal2);
		double Perimetro = rombo.getLado () * 4;
		return Perimetro;
	}
	
	public double getLado ()
	{
		double Lado = Math.sqrt (Math.pow(Diagonal1/2,2) + Math.pow(Diagonal2/2,2));
		return Lado;
	}
	//fin getes y setes
 
}//fin_pp
