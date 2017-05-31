package Interfaces;
/*
Propiedades.
	Básicas:	Double modificadorDmg	-----------		Consultable / Modificable
				Double modificadorDef	-----------		Consultable / Modificable
				Double duracion			-----------		Consultable / Modificable
				String efecto			-----------		Consultable / Modificable
	Derivadas:
	Compartidas:

Fórmulas:

Getes y Setes: 

double getModificadorDmg();
void setModificadorDmg (double modificadorDmg);

double getModificadorDef();
void setModificadorDef (double modificadorDef);

double getDuracion ();
void setDuracion (doublé duracion);

String getEfecto ();
void setEfecto (String efecto);


Métodos añadidos:

Restricciones:

 */
public interface Item 
{
	double getModificadorDmg ();
	void setModificadorDmg (double modificadorDmg);
	
	double getModificadorDef ();
	void setModificadorDef (double modificadorDef);
	
	double getDuracion ();
	void setDuracion (double duracion);
	
	String getEfecto ();
	void setEfecto (String efecto);
}
