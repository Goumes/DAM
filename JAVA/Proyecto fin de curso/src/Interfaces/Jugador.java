package Interfaces;

import Exceptions.JuegoException;

/* Interfaz:
 * 
		Propiedades
			Básicas: 
				String nombre 		 		------------	Consultable / Modificable
				Int vida 	      	 		------------	Consultable / Modificable
				int vidaTotal				------------	Consultable / Modificable
				int baseDmg		 			------------ 	Consultable / Modificable
				int baseDef		 			------------ 	Consultable / Modificable
				Item Armadura		 		------------	Consultable / Modificable
				Arma armaEquipada    		------------ 	Consultable / Modificable
				Int oro		 	 			------------	Consultable / Modificable
				Inventario inventario 	 	------------	Consultable / Modificable
			Derivadas: 
				int totalDmg		 		------------	Consultable
				int totalDef		 		------------	Consultable
			Compartidas:

 * Fórmulas: 
 * 		totalDmg = Daño arma + baseDmg
 * 		totalDef = Armadura + baseDef
 * 
 * Getes y Setes: 
 *  
 * String getNombre ();
 * void setNombre (String nombre);
 * 
 * Int getVida();
 * void setVida (Int vida);
 * 
 * int getVidaTotal();
 * void setVidaTotal (int vidaTotal);
 * 
 * Double getBaseDmg ();
 * void setBaseDmg (double baseDmg);
 * 
 * Double getBaseDef ();
 * void setBaseDmg (double baseDef);
 * 
 * Item getArmadura ();
 * void setArmadura (Item Armadura);
 * 
 * Arma getArmaEquipada ();
 * void setArmaEquipada (Arma armaEquipada);
 * 
 * Int getOro ();
 * Void setOro (Int oro);
 * 
 * Inventario getInventario ();
 * void setInventario (Inventario inventario);
 * 
 * double getTotalDmg ();
 * 
 * double getTotalDef ();
 * 
 * 
 * Métodos añadidos: imprimirJugador (), imprimirJugadorCombate (), addInventario (), removeInventario ()
 * 
 * Restricciones:
 * 
 */
public interface Jugador 
{
	String getNombre ();
	 void setNombre (String nombre) throws JuegoException;
	 
	 int getVida();
	 void setVida (int vida) throws JuegoException;
	 
	 int getVidaTotal();
	 void setVidaTotal (int vidaTotal) throws JuegoException;
	 
	 int getBaseDmg ();
	 void setBaseDmg (int baseDmg) throws JuegoException;
	 
	 int getBaseDef ();
	 void setBaseDef (int baseDef) throws JuegoException;
 
	 int getOro ();
	 void setOro (int oro) throws JuegoException;
	 
	 int getTotalDmg ();
	 
	 int getTotalDef ();
}
