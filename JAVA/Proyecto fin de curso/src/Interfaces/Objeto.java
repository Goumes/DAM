package Interfaces;
/* Propiedades:
 * 
 * 		Basicas: 				String nombre		-----------		Consultable / Modificable
 * 								int precio		----------- 	Consultable / Modificable
 * 		Derivadas:
 * 		Compartidas:
 * 
 * 
 * String getNombre ();
 * void setNombre (String nombre);
 * 
 * int getPrecio ();
 * void setPrecio (int precio);
 * 
 * Metodos añadidos: Ninguno
 * 
 * Criterio de comparación : precio
 */

import Exceptions.JuegoException;

public interface Objeto 
{
	String getNombre ();
	void setNombre (String nombre) throws JuegoException;
	
	int getPrecio ();
	void setPrecio (int precio) throws JuegoException;
}
