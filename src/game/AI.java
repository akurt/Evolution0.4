package game;

import java.util.ArrayList;
import java.util.Collections;

import main.PlayObject;
import map.Habitat;
import map.Map;
import player.Species;
import resources.Resources;

/*
 * Enthält die künstliche Intelligenz. Enemy überprüft ob er Ressourcen in
 * seiner Reichweite hat und kann sich auf diese Bewegen.
 * Vor dem Bewegen wird geprüft, ob sich Kreatur auf Feld bewegen kann
 */
public class AI {
	
	private ArrayList<Direction> randomDir;
	private Direction dir;
	private Map map;
	
	PlayObject ob = PlayObject.getInstance();
	
	public AI(Map map) {
		this.map = map;
	}

	/*
	 * Prüft ob Spezies Feld betreten kann
	 */
	public boolean moveTry(int px, int py, Species s) {
		if ((px < 0 || px > 580) || (py < 0 || py > 380)) {
			return false;
		}
		switch (s) {
		case AQUA:
			if ((map.getHabitat(px, py) == Habitat.MEER)) {
				return true;
			} else {
				return false;
			}
		case HERBA:
			if ((map.getHabitat(px, py) == Habitat.SAVANNE) || (map.getHabitat(px, py) == Habitat.WIESE) || (map.getHabitat(px, py) == Habitat.WALD)) {
				return true;
			} else {
				return false;
			}
		case LITUS:
			if ((map.getHabitat(px, py) == Habitat.MEER) || (map.getHabitat(px, py) == Habitat.SUMPF) || (map.getHabitat(px, py) == Habitat.WIESE) || (map.getHabitat(px, py) == Habitat.SAVANNE) || (map.getHabitat(px, py) == Habitat.STRAND)) {
				return true;
			} else {
				return false;
			}
		default:
			return false;
		}
	}
	
	/*
	 * Zufällige Richtungsauswahl
	 */
	public Direction randomMove(int px, int py, Species species) {
		randomDir = new ArrayList<Direction>();
		//nord
		if (moveTry(px, py - 20, species)) randomDir.add(Direction.NORTH);
		//ost
		if (moveTry(px + 20, py, species)) randomDir.add(Direction.EAST);
		//süd
		if (moveTry(px, py + 20, species)) randomDir.add(Direction.SOUTH);
		//west
		if (moveTry(px - 20, py, species)) randomDir.add(Direction.WEST);
		
		Collections.shuffle(randomDir);
		dir = randomDir.get(0);
		return dir;
	}
	
	/*
	 * Prüft ob Ressourcen in Umgebung vorhanden
	 */
	public boolean controlFood(int px, int py){
		boolean found = false;
		Resources[] laufen = {	map.getFood(px, py-5),
								map.getFood(px, py-4),
								map.getFood(px-1, py-3), map.getFood(px, py-3),   map.getFood(px+1, py-3),
								map.getFood(px-2, py-2), map.getFood(px-1, py-2), map.getFood(px, py-2),   map.getFood(px+1, py-2), map.getFood(px+2, py-2),
								map.getFood(px-3, py-1), map.getFood(px-2, py-1), map.getFood(px-1, py-1), map.getFood(px, py-1),   map.getFood(px+1, py-1), map.getFood(px+2, py-1), map.getFood(px+3, py-1),
								map.getFood(px-4, py),   map.getFood(px-3, py),   map.getFood(px-2, py),   map.getFood(px-1, py),   map.getFood(px, py),     map.getFood(px+1, py),   map.getFood(px+2, py), map.getFood(px+3, py), map.getFood(px+4, py),
								map.getFood(px-3, py+1), map.getFood(px-2, py+1), map.getFood(px-1, py+1), map.getFood(px, py+1),   map.getFood(px+1, py+1), map.getFood(px+2, py+1), map.getFood(px+3, py+1),
								map.getFood(px-2, py+2), map.getFood(px-1, py+2), map.getFood(px, py+2),   map.getFood(px+1, py+2), map.getFood(px+2, py+2),
								map.getFood(px-1, py+3), map.getFood(px, py+3),   map.getFood(px+1, py+3),
								map.getFood(px, py+4), 
								map.getFood(px, py+5) 
		};
		
		for(Resources r : laufen){
			if(r != Resources.LEER){		
				found = true;
			}
		}
		return found;
	}
	
	/*
	 * Intelligente Richtungsauswahl, sucht nach Ressourcen
	 */
	public Direction searchFood(int px, int py, Species species){
		
		Resources[] laufen = {	map.getFood(px, py-5),
								map.getFood(px, py-4),
								map.getFood(px-1, py-3), map.getFood(px, py-3),   map.getFood(px+1, py-3),
								map.getFood(px-2, py-2), map.getFood(px-1, py-2), map.getFood(px, py-2),   map.getFood(px+1, py-2), map.getFood(px+2, py-2),
								map.getFood(px-3, py-1), map.getFood(px-2, py-1), map.getFood(px-1, py-1), map.getFood(px, py-1),   map.getFood(px+1, py-1), map.getFood(px+2, py-1), map.getFood(px+3, py-1),
								map.getFood(px-4, py),   map.getFood(px-3, py),   map.getFood(px-2, py),   map.getFood(px-1, py),   map.getFood(px, py),     map.getFood(px+1, py),   map.getFood(px+2, py), map.getFood(px+3, py), map.getFood(px+4, py),
								map.getFood(px-3, py+1), map.getFood(px-2, py+1), map.getFood(px-1, py+1), map.getFood(px, py+1),   map.getFood(px+1, py+1), map.getFood(px+2, py+1), map.getFood(px+3, py+1),
								map.getFood(px-2, py+2), map.getFood(px-1, py+2), map.getFood(px, py+2),   map.getFood(px+1, py+2), map.getFood(px+2, py+2),
								map.getFood(px-1, py+3), map.getFood(px, py+3),   map.getFood(px+1, py+3),
								map.getFood(px, py+4), 
								map.getFood(px, py+5) 
		};
		
			if(laufen[0] != Resources.LEER || laufen[1] != Resources.LEER ||laufen[2] != Resources.LEER ||laufen[3] != Resources.LEER || laufen[4] != Resources.LEER ||laufen[5] != Resources.LEER 
					||laufen[6] != Resources.LEER ||laufen[7] != Resources.LEER || laufen[8] != Resources.LEER || laufen[9] != Resources.LEER || laufen[12] != Resources.LEER 
					|| laufen[13] != Resources.LEER || laufen[14] != Resources.LEER){
				if(moveTry(px, py - 20, species)){
					return dir = Direction.NORTH;
				}
			}
			if(laufen[10] != Resources.LEER || laufen[11] != Resources.LEER || laufen[17] != Resources.LEER || laufen[18] != Resources.LEER || laufen[19] != Resources.LEER 
					|| laufen[20] != Resources.LEER || laufen[26] != Resources.LEER || laufen[27] != Resources.LEER){
				if(moveTry(px - 20, py, species)){
					return dir = Direction.WEST;
				}
			}
			if(laufen[15] != Resources.LEER || laufen[16] != Resources.LEER || laufen[22] != Resources.LEER || laufen[23] != Resources.LEER || laufen[24] != Resources.LEER 
					|| laufen[25] != Resources.LEER || laufen[31] != Resources.LEER || laufen[32] != Resources.LEER ){
				if(moveTry(px + 20, py, species)){
					return dir = Direction.EAST;
				}
			}
			if(laufen[28] != Resources.LEER || laufen[29] != Resources.LEER || laufen[30] != Resources.LEER || laufen[33] != Resources.LEER || laufen[34] != Resources.LEER || laufen[35] != Resources.LEER 
					|| laufen[36] != Resources.LEER || laufen[37] != Resources.LEER || laufen[38] != Resources.LEER || laufen[39] != Resources.LEER || laufen[40] != Resources.LEER 
					|| laufen[41] != Resources.LEER || laufen[42] != Resources.LEER ){
				if(moveTry(px, py + 20, species)){
					return dir = Direction.SOUTH;
				}
			}
		return dir;
	}
	
}
