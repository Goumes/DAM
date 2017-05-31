package Interfaces;
/*
Propiedades.
	Básicas: 	Tienda Shop		----------	Consultable / Modificable
				Enemigo Enemy	----------	Consultable / Modificable
				Cofre Chest		----------	Consultable / Modificable
				boolean Entrada	----------	Consultable / Modificable
				boolean Salida		----------	Consultable / Modificable
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

boolean getEntrada();
void setEntrada (boolean entrada)
 
boolean getSalida();
void setSalida (boolean salida)

Métodos añadidos:

Restricciones:
 */
public interface Habitacion 
{
	boolean getEntrada ();
	void setEntrada (boolean entrada);
	
	boolean getSalida ();
	void setSalida (boolean salida);
}
