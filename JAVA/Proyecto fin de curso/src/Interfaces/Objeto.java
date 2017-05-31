package Interfaces;
/* Propiedades:
 * 
 * 		Basicas: 				String nombre		-----------		Consultable / Modificable
 * 								double precio		----------- 	Consultable / Modificable
 * 		Derivadas:
 * 		Compartidas:
 * 
 * 
 * String getNombre ();
 * void setNombre (String nombre);
 * 
 * double getPrecio ();
 * void setPrecio (double precio);
 * 
 * Metodos añadidos: Ninguno
 * 
 * Criterio de comparación : precio
 */

public interface Objeto 
{
	String getNombre ();
	void setNombre (String nombre);
	
	double getPrecio ();
	void setPrecio (double precio);
}
