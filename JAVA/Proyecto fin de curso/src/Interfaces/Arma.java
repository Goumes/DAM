package Interfaces;

/* 
 * Propiedades.
	 * Básicas: 	String Nombre 	-----------	Consultable / Modificable
 * 					double Dmg		-----------	Consultable / Modificable
 * 					double Precio		-----------	Consultable / Modificable
			
 * Derivadas:
 * Compartidas:

 * Fórmulas:

 * Getes y Setes: 

 * String getNombre ();
 * void setNombre (String Nombre);

 * Double getDmg ();
 * void setDmg (double Dmg);

 * double getPrecio ();
 * void setPrecio (double Precio);


 * Métodos añadidos:

 * Restricciones:
 */

public interface Arma 
{
	String getNombre ();
	void setNombre (String nombre);
	
	int getDmg ();
	void setDmg (int dmg);
	
	int getPrecio ();
	void setPrecio (int precio);
}
