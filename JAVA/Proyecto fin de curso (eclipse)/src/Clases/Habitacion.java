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
package Clases;

import java.util.*;
import java.lang.*;
public class Habitacion
{
	private Tienda shop;
	private Enemigo enemy;
	//private Cofre chest;
	private char Entrada;
	private char Salida;
	
	//Constructores
	public Habitacion ()
	{
		shop = new Tienda ();
		enemy = new Enemigo ();
		Entrada = ' ';
		Salida = ' ';
	}
	
	public Habitacion (Habitacion habitacion)
	{
		this.shop = habitacion.shop;
		this.enemy = habitacion.enemy;
		this.Entrada = habitacion.Entrada;
		this.Salida = habitacion.Salida;
	}
	
	public Habitacion (Tienda shop, Enemigo enemy, char Entrada, char Salida)
	{
		this.shop = shop;
		this.enemy = enemy;
		this.Entrada = Entrada;
		this.Salida = Salida;
	}
	//Fin Constructores
	
	//Getters y setters
	public Tienda getShop ()
	{
		return shop;
	}
	
	public void setShop (Tienda shop)
	{
		this.shop = shop;
	}
	
	public Enemigo getEnemy ()
	{
		return enemy;
	}
	
	public void setEnemy (Enemigo enemy)
	{
		this.enemy = enemy;
	}
	
	public char getEntrada ()
	{
		return Entrada;
	}
	
	public void setEntrada (char Entrada)
	{
		this.Entrada = Entrada;
	}
	
	public char getSalida ()
	{
		return Salida;
	}
	
	public void setSalida (char Salida)
	{
		this.Salida = Salida;
	}
	//Fin Getters y setters
	
	//Metodos añadidos
	
	@Override
	public String toString ()
	{
		String s = ("shop: "+getShop ()+
					", enemy: "+getEnemy ()+
					", Entrada: "+getEntrada ()+
					", Salida: "+getSalida ());
		return s;
	}
	
	//Criterio de igualdad: Todos los atributos
	@Override
	public boolean equals (Object objeto)
	{
		boolean resultado = false;
		
		if (objeto != null && objeto instanceof Habitacion)
		{
			Habitacion habitacion = (Habitacion) objeto;
			
			if (this.getShop () == habitacion.getShop ()
				&& this.getEnemy () == habitacion.getEnemy ()
				&& this.getEntrada () == habitacion.getEntrada ()
				&& this.getSalida () == habitacion.getSalida ())
			{
				resultado = true;
			}
		}
		return resultado;
	}
	
	@Override
	public int hashCode ()
	{
		return (Objects.hash (this.getShop (), this.getEnemy (), this.getEntrada (), this.getSalida ()));
	}
	
	@Override
	public Habitacion clone ()
	{
		Habitacion copia = new Habitacion ();
		
		try
		{
			copia = (Habitacion) super.clone ();
			copia.shop = shop.clone ();
			copia.enemy = enemy.clone ();
			
		}
		
		catch (CloneNotSupportedException error)
		{
			System.out.println("No se ha podido clonar el objeto");
		}
		
		return copia;
	}
	
	//Criterio de comparación: 
	/* public int compareTo ()
	{
		int resultado = 0;
		
		if ()
		{
			resultado = 1;
		}
		
		else if ()
		{
			resultado = -1;
		}
		
		
		return resultado;
	} */
	//Fin Metodos añadidos
}//fin_clase
