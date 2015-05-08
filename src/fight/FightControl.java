package fight;

import game.Zufall;
import main.PlayObject;

import org.newdawn.slick.SlickException;

import player.Kreatur;

/*
 * Unterstützt die Klasse FightState. Hier werden die während des 
 * Kampfes gegebenen Befehle der Spieler bearbeitet
 */
public class FightControl {

	//private String ability;
	
	PlayObject ob = PlayObject.getInstance();
	
	/*public String getAbility(Species species) {
		switch (species) {
		case AQUA:
			ability = "Dreifach Biss";
			break;
		case HERBA:
			ability = "herbability";
			break;
		case LITUS:
			ability = "litability";
			break;
		default:
			break;
		}
		return ability;
	}*/
	
	public void befehl(Kreatur k, int a) throws SlickException {
		switch(a){
		case 0:
			if(Zufall.zufall(ob.player.hit, 400) >= Zufall.zufall(k.agi, 400)){
				k.setStarvationpoints(ob.player.dam - k.def);
			}
			//System.out.println(0);
			break;
		case 1:
			k.setStarvationpoints(ob.player.getAblity(ob.player, k, ob.player.abilist[a-1]));
			
			//System.out.println(1);
			break;
		case 2:
			k.setStarvationpoints(ob.player.getAblity(ob.player, k, ob.player.abilist[a-1]));
			
			//System.out.println(2);
			break;
		case 3:
			k.setStarvationpoints(ob.player.getAblity(ob.player, k, ob.player.abilist[a-1]));
			
			//System.out.println(3);
			break;
		}
	}
	
	
	public void befEn(Kreatur k, int a) throws SlickException {
		switch(a){
		case 0:
			/*if(Zufall.zufall(k.hit, 400) >= Zufall.zufall(ob.player.agi, 400)){
				ob.player.setStarvationpoints(k.dam - ob.player.def);
			}*/
			ob.player.setLifepointsN(k.dam - ob.player.def);
			
			System.out.println(0);
			break;
		case 1:
			//ob.player.setStarvationpoints(k.getAblity(k, ob.player, k.abilist[a-1]));
			ob.player.setStarvationpoints(k.getAblity(k, ob.player, "Doppelbiss"));
			
			
			System.out.println(1);
			break;
		case 2:
			//ob.player.setStarvationpoints(k.getAblity(k, ob.player, k.abilist[a-1]));
			ob.player.setStarvationpoints(k.getAblity(k, ob.player, "Knochenbrecher"));
			
			
			System.out.println(2);
			break;
		case 3:
			//ob.player.setStarvationpoints(k.getAblity(k, ob.player, k.abilist[a-1]));
			ob.player.setStarvationpoints(k.getAblity(k, ob.player, "Kehlbiss"));
			
			
			System.out.println(3);
			break;
		}
	}
	
}
