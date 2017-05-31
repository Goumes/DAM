package Clases;

import java.io.Serializable;
import java.util.*;

import Interfaces.Cofre;
import Interfaces.Habitacion;

public class HabitacionIMPL implements Serializable, Habitacion
{
	private static final long serialVersionUID = 7059421015933648577L;
	private TiendaIMPL shop;
	private EnemigoIMPL enemy;
	private CofreIMPL cofre;
	private char entrada;
	private char salida;
	
	//Constructores
	public HabitacionIMPL ()
	{
		shop = new TiendaIMPL ();
		enemy = new EnemigoIMPL ();
		cofre = new CofreIMPL ();
		entrada = ' ';
		salida = ' ';
	}
	
	public HabitacionIMPL (HabitacionIMPL habitacion)
	{
		this.shop = habitacion.shop;
		this.enemy = habitacion.enemy;
		this.cofre = habitacion.cofre;
		this.entrada = habitacion.entrada;
		this.salida = habitacion.salida;
	}
	
	public HabitacionIMPL (TiendaIMPL shop, EnemigoIMPL enemy, CofreIMPL cofre, char entrada, char salida)
	{
		this.shop = shop;
		this.enemy = enemy;
		this.cofre = cofre;
		this.entrada = entrada;
		this.salida = salida;
	}
	//Fin Constructores
	
	//Getters y setters
	public TiendaIMPL getShop ()
	{
		return shop;
	}
	
	public void setShop (TiendaIMPL shop)
	{
		this.shop = shop;
	}
	
	public EnemigoIMPL getEnemy ()
	{
		return enemy;
	}
	
	public void setEnemy (EnemigoIMPL enemy)
	{
		this.enemy = enemy;
	}
	
	public CofreIMPL getCofre ()
	{
		return cofre;
	}
	
	public void setCofreIMPL (CofreIMPL cofre)
	{
		this.cofre = cofre;
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
	
	public ItemIMPL getObjeto1() 
	{
		return shop.getObjeto1();
	}

	public void setObjeto1(ItemIMPL objeto1) 
	{
		shop.setObjeto1(objeto1);
	}

	public ItemIMPL getObjeto2() 
	{
		return shop.getObjeto2();
	}

	public void setObjeto2(ItemIMPL objeto2) 
	{
		shop.setObjeto2(objeto2);
	}

	public ItemIMPL getObjeto3() 
	{
		return shop.getObjeto3();
	}

	public void setObjeto3(ItemIMPL objeto3) 
	{
		shop.setObjeto3(objeto3);
	}

	public ItemIMPL getObjeto4() 
	{
		return shop.getObjeto4();
	}

	public void setObjeto4(ItemIMPL objeto4) 
	{
		shop.setObjeto4(objeto4);
	}

	public boolean getDisponibilidad() 
	{
		return shop.getDisponibilidad();
	}

	public void setDisponibilidad(boolean disponibilidad) 
	{
		shop.setDisponibilidad(disponibilidad);
	}

	public double getDmg() 
	{
		return enemy.getDmg();
	}

	public void setDmg(double dmg) 
	{
		enemy.setDmg(dmg);
	}

	public double getDef() 
	{
		return enemy.getDef();
	}

	public void setDef(double def) 
	{
		enemy.setDef(def);
	}

	public ItemIMPL getDropItem() 
	{
		return enemy.getDropItem();
	}

	public void setDropItem(ItemIMPL dropItem) 
	{
		enemy.setDropItem(dropItem);
	}

	public int getDropDinero() 
	{
		return enemy.getDropDinero();
	}

	public void setDropDinero(int dropDinero) 
	{
		enemy.setDropDinero(dropDinero);
	}

	public int getNivel() 
	{
		return enemy.getNivel();
	}

	public void setNivel(int nivel) 
	{
		enemy.setNivel(nivel);
	}

	public double getModificadorDmg() 
	{
		return enemy.getModificadorDmg();
	}

	public void setModificadorDmg(double modificadorDmg) 
	{
		enemy.setModificadorDmg(modificadorDmg);
	}

	public double getModificadorDef() 
	{
		return enemy.getModificadorDef();
	}

	public void setModificadorDef(double modificadorDef) 
	{
		enemy.setModificadorDef(modificadorDef);
	}

	public double getDuracion() 
	{
		return enemy.getDuracion();
	}

	public void setDuracion(double duracion) 
	{
		enemy.setDuracion(duracion);
	}

	public String getEfecto() 
	{
		return enemy.getEfecto();
	}

	public void setEfecto(String efecto) 
	{
		enemy.setEfecto(efecto);
	}

	public double getValor() 
	{
		return cofre.getValor();
	}

	public void setValor(double valor) 
	{
		cofre.setValor(valor);
	}

	public ObjetoIMPL getDrop() 
	{
		return cofre.getDrop();
	}

	public void setDrop(ObjetoIMPL drop) 
	{
		cofre.setDrop(drop);
	}

	public String getNombre() 
	{
		return cofre.getNombre();
	}

	public void setNombre(String nombre) 
	{
		cofre.setNombre(nombre);
	}

	public double getPrecio() 
	{
		return cofre.getPrecio();
	}

	public void setPrecio(double precio) 
	{
		cofre.setPrecio(precio);
	}
	//Fin Getters y setters
	
	//Metodos añadidos
	
	@Override
	public String toString ()
	{
		String s = (getShop ().toString()+
					","+getEnemy ().toString()+
					","+getCofre ().toString()+
					","+getEntrada ()+
					","+getSalida ());
		return s;
	}
	
	//Criterio de igualdad: Todos los atributos
	@Override
	public boolean equals (Object objeto)
	{
		boolean resultado = false;
		
		if (objeto != null && objeto instanceof HabitacionIMPL)
		{
			HabitacionIMPL habitacion = (HabitacionIMPL) objeto;
			
			if (this.getShop ().equals(habitacion.getShop ())
				&& this.getEnemy ().equals(habitacion.getEnemy ())
				&& this.getCofre ().equals(habitacion.getCofre())
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
		return (Objects.hash (this.getShop (), this.getEnemy (), this.getCofre(), this.getEntrada (), this.getSalida ()));
	}
	
	@Override
	public HabitacionIMPL clone ()
	{
		HabitacionIMPL copia = new HabitacionIMPL ();
		
		try
		{
			copia = (HabitacionIMPL) super.clone ();
			
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
