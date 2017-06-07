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
	int getModificadorDmg ();
	void setModificadorDmg (int modificadorDmg);
	
	int getModificadorDef ();
	void setModificadorDef (int modificadorDef);
	
	int getModificadorVida ();
	void setModificadorVida (int modificadorVida);
	
	boolean getDuracion ();
	void setDuracion (boolean duracion);
	
	String getEfecto ();
	void setEfecto (String efecto);
}
