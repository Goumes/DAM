package Interfaces;

/* 
 * Propiedades.
	 * Básicas: 	String Nombre 	-----------	Consultable / Modificable
 * 					int Dmg			-----------	Consultable / Modificable
 * 					int Precio		-----------	Consultable / Modificable
			
 * Derivadas:
 * Compartidas:

 * Fórmulas:

 * Getes y Setes: 

 * String getNombre ();
 * void setNombre (String Nombre);

 * int getDmg ();
 * void setDmg (int Dmg);

 * dintouble getPrecio ();
 * void setPrecio (int Precio);


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
