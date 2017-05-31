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

import java.io.Serializable;
import java.util.*;

public class Habitacion implements Serializable
{
	private static final long serialVersionUID = 7059421015933648577L;
	private Tienda shop;
	private Enemigo enemy;
	//private Cofre chest;
	private char entrada;
	private char salida;
	
	//Constructores
	public Habitacion ()
	{
		shop = new Tienda ();
		enemy = new Enemigo ();
		entrada = ' ';
		salida = ' ';
	}
	
	public Habitacion (Habitacion habitacion)
	{
		this.shop = habitacion.shop;
		this.enemy = habitacion.enemy;
		this.entrada = habitacion.entrada;
		this.salida = habitacion.salida;
	}
	
	public Habitacion (Tienda shop, Enemigo enemy, char entrada, char salida)
	{
		this.shop = shop;
		this.enemy = enemy;
		this.entrada = entrada;
		this.salida = salida;
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
		return entrada;
	}
	
	public void setEntrada (char Entrada)
	{
		this.entrada = Entrada;
	}
	
	public char getSalida ()
	{
		return salida;
	}
	
	public void setSalida (char Salida)
	{
		this.salida = Salida;
	}
	//Fin Getters y setters
	
	//Metodos añadidos
	
	@Override
	public String toString ()
	{
		String s = (getShop ()+
					","+getEnemy ()+
					","+getEntrada ()+
					","+getSalida ());
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
			
			if (this.getShop ().equals(habitacion.getShop ())
				&& this.getEnemy ().equals(habitacion.getEnemy ())
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
