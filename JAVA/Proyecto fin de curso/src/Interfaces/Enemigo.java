package Interfaces;

import Clases.ItemIMPL;

/*
Propiedades.
	BÃ¡sicas: 
				String Nombre		------------	Consultable / Modificable
				Int Vida			------------	Consultable / Modificable
				Item dropItem		------------	Consultable / Modificable
				Int dropDinero		------------	Consultable / Modificable
				int Dmg			------------	Consultable / Modificable
				int Def			------------	Consultable / Modificable
				Int Nivel			------------	Consultable / Modificable
	Derivadas:
	Compartidas:

FÃ³rmulas:

Getes y Setes: 
string getNombre ();
void setNombre (string Nombre);

Int getVida ();
void setVida (Int Vida); 

Double getDmg ();
void setDmg (double Dmg);

Double getDef ();
void setDef (double Def);

Item getDropItem ();
void setDropItem (Item dropItem);

Int getDropDinero ();
void setDropDinero (Int dropDinero);

Int getNivel ();
void setNivel (Int Nivel);



Métodos añadidos:

Restricciones:
*/

public interface Enemigo 
{
	String getNombre ();
	void setNombre (String nombre);
	
	int getVida ();
	void setVida (int vida);
	
	int getDmg ();
	void setDmg (int dmg);
	
	int getDef ();
	void setDef (int def);
	
	int getDropDinero ();
	void setDropDinero (int dinero);
	
	int getNivel ();
	void setNivel (int nivel);
}
