/*
Propiedades.
	Básicas: 	Jugador Player		-----------	Consultable / Modificable
				Enemigo Enemy		-----------	Consultable / Modificable
				Ataque Ability1		-----------	Consultable / Modificable
				Ataque Ability2		-----------	Consultable / Modificable
				Ataque Ability3		-----------	Consultable / Modificable
				Boolean Huir		-----------	Consultable / Modificable

	Derivadas: 	Double dmgInfligido	-----------	Consultable
				Double dmgRecibido	-----------	Consultable

	Compartidas:	



	Fórmulas:	dmgInfligido = Player.getDmg () + Ability1 – Enemy.getDef ();
				dmgInfligido = Player.getDmg () + Ability2 – Enemy.getDef ();
				dmgInfligido = Player.getDmg () + Ability3 – Enemy.getDef ();

				dmgRecibido = Enemy.getDmg () + Ability1 – Player.getDef ();
				dmgRecibido = Enemy.getDmg () + Ability2 – Player.getDef ();
				dmgRecibido = Enemy.getDmg () + Ability3 – Player.getDef ();







Getes y Setes: 

Jugador getPlayer ();
void setPlayer (Jugador Player);

Enemigo getEnemy ();
void setEnemy (Enemigo Enemy);

Ataque getAbility1 ();
void setAbility1 (Ataque Ability1);

Ataque getAbility2 ();
void setAbility2 (Ataque Ability2);

Ataque getAbility3 ();
void setAbility3 (Ataque Ability3);

Boolean getHuir ();
void setHuir (Boolean Huir);

Double getDmgInfligido ();

Double getDmgRecibido ();



Métodos añadidos:

Restricciones:


*/

public class Batalla
{
	private Jugador Player;
	private Enemigo Enemy;
	private boolean Huir;
}//fin_clase
