package Interfaces;
/*
Propiedades.
	Básicas:	int modificadorDmg		-----------		Consultable / Modificable
				int modificadorDef		-----------		Consultable / Modificable
				boolean duracion		-----------		Consultable / Modificable
				String efecto			-----------		Consultable / Modificable
	Derivadas:
	Compartidas:

Fórmulas:

Getes y Setes: 

int getModificadorDmg();
void setModificadorDmg (int modificadorDmg);

int getModificadorDef();
void setModificadorDef (int modificadorDef);

boolean getDuracion ();
void setDuracion (boolean duracion);

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
