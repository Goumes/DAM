package Interfaces;
/* Interfaz:
 * 
		Propiedades
			Básicas: 
				String nombre 		 		------------	Consultable / Modificable
				Int vida 	      	 		------------	Consultable / Modificable
				Double baseDmg		 		------------ 	Consultable / Modificable
				Double baseDef		 		------------ 	Consultable / Modificable
				Item Armadura		 		------------	Consultable / Modificable
				Arma armaEquipada    		------------ 	Consultable / Modificable
				Int oro		 	 			------------	Consultable / Modificable
				Inventario inventario 	 	------------	Consultable / Modificable
			Derivadas: 
				Double totalDmg		 		------------	Consultable
				Double totalDef		 		------------	Consultable
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
 * Métodos añadidos: cambiarHabitacion
 * 
 * Restricciones:
 * 
 */
public interface Jugador 
{
	String getNombre ();
	 void setNombre (String nombre);
	 
	 int getVida();
	 void setVida (int vida);
	 
	 double getBaseDmg ();
	 void setBaseDmg (double baseDmg);
	 
	 double getBaseDef ();
	 void setBaseDef (double baseDef);
 
	 int getOro ();
	 void setOro (int oro);
	 double getTotalDmg ();
	 
	 double getTotalDef ();
}
