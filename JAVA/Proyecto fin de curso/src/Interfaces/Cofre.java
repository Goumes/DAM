package Interfaces;

import Clases.ObjetoIMPL;

/* Propiedades.
 * 		Basicas: 		double valor		----------		Consultable / Modificable
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
	double getValor ();
	void setValor (double valor);
}
