package Clases;

import java.io.Serializable;
import java.util.*;

import Exceptions.JuegoException;
import Interfaces.Cofre;
import Interfaces.Habitacion;

public class HabitacionIMPL implements Serializable, Habitacion
{
	private static final long serialVersionUID = 7059421015933648577L;
	private TiendaIMPL shop;
	private EnemigoIMPL enemy;
	private CofreIMPL cofre;
	private JugadorIMPL jugador;
	private boolean salida;
	private boolean arriba;
	private boolean abajo;
	private boolean izquierda;
	private boolean derecha;
	private boolean visitada;
	
	//Constructores
	public HabitacionIMPL ()
	{
		shop = new TiendaIMPL ();
		enemy = new EnemigoIMPL ();
		cofre = new CofreIMPL ();
		jugador = new JugadorIMPL ();
		salida = false;
		arriba = false;
		abajo = false;
		izquierda = false;
		derecha = false;
		visitada = false;
	}
	
	public HabitacionIMPL (HabitacionIMPL habitacion)
	{
		this.shop = habitacion.shop;
		this.enemy = habitacion.enemy;
		this.cofre = habitacion.cofre;
		this.jugador = habitacion.jugador;
		this.salida = habitacion.salida;
		this.arriba = habitacion.arriba;
		this.abajo = habitacion.abajo;
		this.izquierda = habitacion.izquierda;
		this.derecha = habitacion.derecha;
		this.visitada = habitacion.visitada;
	}
	
	public HabitacionIMPL (TiendaIMPL shop, EnemigoIMPL enemy, CofreIMPL cofre, JugadorIMPL jugador, 
							boolean salida, boolean arriba, boolean abajo, boolean izquierda, boolean derecha, 
							boolean visitada)
	{
		this.shop = shop;
		this.enemy = enemy;
		this.cofre = cofre;
		this.jugador = jugador;
		this.salida = salida;
		this.arriba = arriba;
		this.abajo = abajo;
		this.izquierda = izquierda;
		this.derecha = derecha;
		this.visitada = visitada;
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
	
	public JugadorIMPL getJugador ()
	{
		return jugador;
	}
	
	public void setJugador (JugadorIMPL jugador)
	{
		this.jugador = jugador;
	}
	
	public boolean getSalida ()
	{
		return salida;
	}
	
	public void setSalida (boolean Salida)
	{
		this.salida = Salida;
	}
	
	public boolean getArriba ()
	{
		return arriba;
	}
	
	public void setArriba (boolean arriba)
	{
		this.arriba = arriba;
	}
	
	public boolean getAbajo ()
	{
		return abajo;
	}
	
	public void setAbajo (boolean abajo)
	{
		this.abajo = abajo;
	}
	
	public boolean getIzquierda ()
	{
		return izquierda;
	}
	
	public void setIzquierda (boolean izquierda)
	{
		this.izquierda = izquierda;
	}
	
	public boolean getDerecha ()
	{
		return derecha;
	}
	
	public void setDerecha (boolean derecha)
	{
		this.derecha = derecha;
	}
	
	public boolean getVisitada ()
	{
		return visitada;
	}
	
	public void setVisitada (boolean visitada)
	{
		this.visitada = visitada;
	}
	
	public ItemIMPL getShopObjeto1() 
	{
		return shop.getObjeto1();
	}

	public void setShopObjeto1(ItemIMPL objeto1) 
	{
		shop.setObjeto1(objeto1);
	}

	public ItemIMPL getShopObjeto2() 
	{
		return shop.getObjeto2();
	}

	public void setShopObjeto2(ItemIMPL objeto2) 
	{
		shop.setObjeto2(objeto2);
	}

	public ItemIMPL getShopObjeto3() 
	{
		return shop.getObjeto3();
	}

	public void setShopObjeto3(ItemIMPL objeto3) 
	{
		shop.setObjeto3(objeto3);
	}

	public ArmaIMPL getShopObjeto4() 
	{
		return shop.getObjeto4();
	}

	public void setShopObjeto4(ArmaIMPL objeto4) 
	{
		shop.setObjeto4(objeto4);
	}

	public boolean getShopDisponibilidad() 
	{
		return shop.getDisponibilidad();
	}

	public void setShopDisponibilidad(boolean disponibilidad) 
	{
		shop.setDisponibilidad(disponibilidad);
	}

	public double getEnemyDmg() 
	{
		return enemy.getDmg();
	}

	public void setEnemyDmg(double dmg) 
	{
		enemy.setDmg(dmg);
	}

	public double getEnemyDef() 
	{
		return enemy.getDef();
	}

	public void setEnemyDef(double def) 
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
		return enemy.getDropItemModificadorDmg();
	}

	public void setModificadorDmg(double modificadorDmg) 
	{
		enemy.setDropItemModificadorDmg(modificadorDmg);
	}

	public double getModificadorDef() 
	{
		return enemy.getDropItemModificadorDef();
	}

	public void setModificadorDef(double modificadorDef) 
	{
		enemy.setDropItemModificadorDef(modificadorDef);
	}

	public double getDuracion() 
	{
		return enemy.getDropItemDuracion();
	}

	public void setDuracion(double duracion) 
	{
		enemy.setDropItemDuracion(duracion);
	}

	public String getEfecto() 
	{
		return enemy.getDropItemEfecto();
	}

	public void setEfecto(String efecto) 
	{
		enemy.setDropItemEfecto(efecto);
	}

	public double getCofreValor() 
	{
		return cofre.getValor();
	}

	public void setCofreValor(double valor) 
	{
		cofre.setValor(valor);
	}

	public ObjetoIMPL getCofreDrop() 
	{
		return cofre.getDrop();
	}

	public void setCofreDrop(ObjetoIMPL drop) 
	{
		cofre.setDrop(drop);
	}

	public String getCofreNombre() 
	{
		return cofre.getNombre();
	}

	public void setCofreNombre(String nombre) throws JuegoException
	{
		cofre.setNombre(nombre);
	}

	public double getCofrePrecio() 
	{
		return cofre.getDropPrecio();
	}

	public void setCofrePrecio(double precio) throws JuegoException
	{
		cofre.setDropPrecio(precio);
	}
	//Fin Getters y setters
	
	//Metodos añadidos
	
	@Override
	public String toString ()
	{
		String s = (getShop ().toString()+
					","+getEnemy ().toString()+
					","+getCofre ().toString()+
					","+getJugador ().toString()+
					","+getSalida ()+
					","+getArriba ()+
					","+getAbajo ()+
					","+getIzquierda ()+
					","+getDerecha ()+
					","+getVisitada ());
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
				&& this.getJugador ().equals(habitacion.getJugador ())
				&& this.getSalida () == habitacion.getSalida ()
				&& this.getArriba() == habitacion.getArriba ()
				&& this.getAbajo () == habitacion.getAbajo ()
				&& this.getIzquierda () == habitacion.getIzquierda()
				&& this.getDerecha() == habitacion.getDerecha()
				&& this.getVisitada () == habitacion.getVisitada())
			{
				resultado = true;
			}
		}
		return resultado;
	}
	
	@Override
	public int hashCode ()
	{
		return (Objects.hash (this.getShop (), this.getEnemy (), this.getCofre(), this.getJugador (), 
				this.getSalida (), this.getArriba(), this.getAbajo(), this.getIzquierda(), this.getDerecha(), 
				this.getVisitada()));
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
	//Fin Metodos añadidos
}//fin_clase
