package Interfaces;

import Clases.ObjetoIMPL;

/* Propiedades.
 * 		Basicas: 		int valor		----------		Consultable / Modificable
 * 						ObjetoIMPL drop			----------		Consultable / Modificable
 * 		Derivadas:
 * 		Compartidas:
 * 
 * Getters y setters:
 * double getValor ();
 * void setValor (double valor);
 * 
 * ObjetoIMPL getDrop ();
 * void setDrop (ObjetoIMPL drop);
 * 
 */

public interface Cofre 
{
	int getValor ();
	void setValor (int valor);
}
