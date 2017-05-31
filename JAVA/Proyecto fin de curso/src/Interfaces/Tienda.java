package Interfaces;
/*
Propiedades.
	Básicas: 	Item Objeto1			-----------    Consultable / Modificable
				Item Objeto2			-----------    Consultable / Modificable
				Item Objeto3			-----------    Consultable / Modificable
				Item Objeto4			-----------    Consultable / Modificable
				Boolean disponibilidad	-----------    Consultable / Modificable
	Derivadas:
	Compartidas:

Fórmulas:

Getes y Setes: 

Item getObjeto1 ();
void setObjeto1 (Item Objeto1);

Item getObjeto2 ();
void setObjeto2 (Item Objeto2);

Item getObjeto3 ();
void setObjeto3 (Item Objeto3);

Item getObjeto4 ();
void setObjeto4 (Item Objeto4);

Boolean getDisponibilidad ();
void setDisponibilidad (Boolean disponibilidad);


Métodos añadidos:

Restricciones:


*/
public interface Tienda 
{
	boolean getDisponibilidad ();
	void setDisponibilidad (boolean disponibilidad);
}
