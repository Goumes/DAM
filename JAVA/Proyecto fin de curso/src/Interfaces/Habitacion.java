package Interfaces;
/*
Propiedades.
	Básicas: 	Tienda Shop		----------	Consultable / Modificable
				Enemigo Enemy	----------	Consultable / Modificable
				Cofre Chest		----------	Consultable / Modificable
				char Entrada	----------	Consultable / Modificable
				char Salida		----------	Consultable / Modificable
	Derivadas:
	Compartidas:

Fórmulas:

Getes y Setes: 

Tienda getShop ();
void setShop (Tienda shop);
 
Enemigo getEnemy ();
void setEnemy (Enemigo enemy);
 
Cofre getChest ();
void setChest (Cofre chest);

char getEntrada();
void setEntrada (char entrada)
 
char getSalida();
void setSalida (char salida)

Métodos añadidos:

Restricciones:
 */
public interface Habitacion 
{
	char getEntrada ();
	void setEntrada (char entrada);
	
	char getSalida ();
	void setSalida (char salida);
}
