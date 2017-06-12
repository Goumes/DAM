package Interfaces;

import Clases.ItemIMPL;

/*
Propiedades.
	BÃ¡sicas: 
				String Nombre		------------	Consultable / Modificable
				Int Vida			------------	Consultable / Modificable
				Item dropItem		------------	Consultable / Modificable
				Int dropDinero		------------	Consultable / Modificable
				int Dmg				------------	Consultable / Modificable
				int Def				------------	Consultable / Modificable
				Int Nivel			------------	Consultable / Modificable
				boolean Jefe		------------ 	Consultable / Modificable
	Derivadas:
	Compartidas:

FÃ³rmulas:

Getes y Setes: 
string getNombre ();
void setNombre (string Nombre);

Int getVida ();
void setVida (Int Vida); 

int getDmg ();
void setDmg (int Dmg);

int getDef ();
void setDef (int Def);

Item getDropItem ();
void setDropItem (Item dropItem);

Int getDropDinero ();
void setDropDinero (Int dropDinero);

Int getNivel ();
void setNivel (Int Nivel);

boolean getJefe ();
void setJefe (boolean jefe);



Métodos añadidos: imprimirEnemigo

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
	
	boolean getJefe ();
	void setJefe (boolean jefe);
}
