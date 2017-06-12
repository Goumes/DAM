package Interfaces;
/*
Propiedades.
	Básicas: 	Tienda Shop			----------	Consultable / Modificable
				Enemigo Enemy		----------	Consultable / Modificable
				Cofre Chest			----------	Consultable / Modificable
				boolean jugador		----------	Consultable / Modificable
				boolean salida		----------	Consultable / Modificable
				boolean entrada		----------	Consultable / Modificable
				boolean arriba		----------	Consultable / Modificable
				boolean abajo		----------	Consultable / Modificable
				boolean izquierda	----------	Consultable / Modificable
				boolean derecha		----------	Consultable / Modificable
				boolean visitada	----------	Consultable / Modificable
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
 
boolean getSalida();
void setSalida (boolean salida)

boolean getEntrada();
void setEntrada (boolean entrada)

boolean getArriba();
void setArriba (boolean arriba)

boolean getAbajo();
void setAbajo (boolean abajo)

boolean getIzquierda();
void setIzquierda (boolean izquierda)

boolean getDerecha();
void setDerecha (boolean derecha)

Métodos añadidos:

Restricciones:
 */
public interface Habitacion 
{	
	boolean getSalida ();
	void setSalida (boolean salida);
	
	boolean getEntrada();
	void setEntrada (boolean entrada);

	boolean getArriba();
	void setArriba (boolean arriba);

	boolean getAbajo();
	void setAbajo (boolean abajo);

	boolean getIzquierda();
	void setIzquierda (boolean izquierda);

	boolean getDerecha();
	void setDerecha (boolean derecha);
}
