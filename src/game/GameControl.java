package game;

import java.util.ArrayList;

import org.newdawn.slick.SlickException;

import player.Enemy;
import player.Kreatur;
import player.Species;
import resources.Ressourcen;
import main.PlayObject;
import map.Habitat;

/*
 * GameControl ist eine unterstützende Logik hinter
 * der Weltkarte. Hier werden die Bewegungen der Spieler
 * kontrolliert sowie die Auswirkungen der Felder (Habitate) auf
 * die Spezies. Die Klasse prüft Kollisionen zwischen Kreaturen 
 * und Ressourcen.
 */
public class GameControl {

	private ArrayList<Integer> ax;
	private ArrayList<Integer> ay;
	private int pm[][];
	
	private Direction direction;

	private boolean fight = false;
	
	PlayObject ob = PlayObject.getInstance();
	
	public GameControl() {
		pm = ob.map.getPositionMap();
	}
	
	public boolean isFight() {
		return fight;
	}
	
	/*
	 * ruft Karte zu jeweiliger Epoche ab
	 */
	public void getPM() {
		pm = ob.map.getPositionMap();
	}
	
	/*
	 * positioniert Kreaturen nach Epochenwechsel neu
	 */
	public void posKreatur(Kreatur k) {
		Species s = k.getSpecies();
		int f = 0;
		switch (s) {
		case AQUA:
			f = 0;
			break;
		case HERBA:
			f = 4;
			break;
		case LITUS:
			f = 2;
			break;
		default:
			break;
		}
		ax = new ArrayList<Integer>();
		ay = new ArrayList<Integer>();
		for (int i = 0; i < pm.length; i++) {
			for (int j = 0; j < pm.length; j++) {
				if (pm[i][j] == f) {
					ax.add(i);
					ay.add(j);
				}
			}
		}
		int z = Zufall.zufall(0, ax.size()-1);
		k.setPosY(ax.get(z) * 20);
		k.setPosX(ay.get(z) * 20);
	}
	
	/*
	 * setzt fest, dass alle Kreaturen keinen Kampf haben
	 */
	public void setFight(boolean fight) {
		this.fight = fight;
		for (Kreatur kr: ob.kreall) {
			kr.setHasFight(false);
			kr.setStartFight(false);
		}
	}
	
	/*
	 * prüft ob zwei Kreaturen auf demselben Feld sind
	 */
	public void fightCheck(Kreatur kr) {
		if (kr.getLebenspunkte() > 0) {
			int n = ob.kreall.size();
			for (int i = 0; i < n - 1; i++) {
				for (int j = i + 1; j < n; j++) {
					if (((ob.kreall.get(i).getPosX()) == ob.kreall.get(j).getPosX()) && ((ob.kreall.get(i).getPosY() == ob.kreall.get(j).getPosY()))) {
						
						if (ob.kreall.get(i).isPlayer() || ob.kreall.get(j).isPlayer()) {
							ob.kreall.get(i).setHasFight(true);
							ob.kreall.get(j).setHasFight(true);
							kr.setStartFight(true);
							try {
								ob.kreall.get(i).iFight();
								ob.kreall.get(j).iFight();
							} catch (SlickException e) {
								e.printStackTrace();
							}
							ob.fight.setHabitat(ob.map.getHabitat(kr.getPosX(), kr.getPosY()));
							fight = true;
						} else {
							if (ob.kreall.get(i).getLebenspunkte() >= ob.kreall.get(j).getLebenspunkte()) {
								ob.kreall.get(j).setLebP0(-10);
							} else {
								ob.kreall.get(i).setLebP0(-10);
							}
						}
						
						/*ob.kreall.get(i).setHasFight(true);
						ob.kreall.get(j).setHasFight(true);
						kr.setStartFight(true);
						try {
							ob.kreall.get(i).iFight();
							ob.kreall.get(j).iFight();
						} catch (SlickException e) {
							e.printStackTrace();
						}
						ob.fight.setHabitat(ob.map.getHabitat(kr.getPosX(), kr.getPosY()));
						fight = true;*/
					}
				}
			}
		}
	}
	
	/*
	 * prüft ob eine verbrauchte Ressource auf ein neues Feld gesetzt werden kann
	 */
	public void positionTest(Kreatur k, Ressourcen r) {
		int h = 0;
		switch (r.getResource()) {
		case FISCH:
			k.setStarvationpoints(r.getLP(k.getSpecies()));
			h = 0;
			break;
		case FLEISCH:
			k.setStarvationpoints(r.getLP(k.getSpecies()));
			h = 3;
			break;
		case FRUECHTE:
			k.setStarvationpoints(r.getLP(k.getSpecies()));
			h = 4;
			break;
		case GETREIDE:
			k.setStarvationpoints(r.getLP(k.getSpecies()));
			h = 4;
			break;
		default:
			break;
		}
		ob.counter += 15;
		ob.player.exp += 5;
		ob.player.levelcheck();
		
		ax = new ArrayList<Integer>();
		ay = new ArrayList<Integer>();
		
		for (int i = 0; i < pm.length; i++) {
			for (int j = 0; j < pm.length; j++) {
				if (pm[i][j] == h) {
					ax.add(i);
					ay.add(j);
				}
			}
		}
		int z = Zufall.zufall(0, ax.size()-1);
		r.setPosRY(ax.get(z) * 20);
		r.setPosRX(ay.get(z) * 20);
	}
	
	/*
	 * Prüft ob eine Kreatur auf einem Ressourcenfeld steht
	 */
	public void resCheck(Kreatur kr) {
		for(Ressourcen r: ob.nahrung){
			if ((kr.getPosX() == r.getPosRX()) && (kr.getPosY() == r.getPosRY()) && (kr.getLebenspunkte() > 0)) {
				positionTest(kr, r);
			}
		}
	}
	
	/*
	 * Feld (Habitat) wirkt sich auf Nahrung, Bewegungspunkte aus
	 */
	public void getFromHabitat(Habitat h, Kreatur k) {
		int n = 0;
		float d = 0f;
		
		switch (h) {
		case MEER:
			n = ob.meer.habitatLP(k.getSpecies());
			d = ob.meer.getBewegung(k.getSpecies());
			break;
		case SAVANNE:
			n = ob.savanne.habitatLP(k.getSpecies());
			d = ob.savanne.getBewegung(k.getSpecies());
			break;
		case SUMPF:
			n = ob.sumpf.habitatLP(k.getSpecies());
			d = ob.sumpf.getBewegung(k.getSpecies());
			break;
		case WIESE:
			n = ob.wiese.habitatLP(k.getSpecies());
			d = ob.wiese.getBewegung(k.getSpecies());
			break;
		case GEBIRGE:
			n = ob.gebirge.habitatLP(k.getSpecies());
			d = ob.gebirge.getBewegung(k.getSpecies());
			break;
		case STRAND:
			n = ob.strand.habitatLP(k.getSpecies());
			d = ob.strand.getBewegung(k.getSpecies());
			break;
		case WALD:
			n = ob.wald.habitatLP(k.getSpecies());
			d = ob.wald.getBewegung(k.getSpecies());
			break;
		default:
			break;
		}
		k.setStarvationpoints(n);
		k.changeSteps(d);
	}
	
	/*
	 * prüft, ob Enemy Feld betreten darf
	 * ruft getFromHabitat, fightCheck, resCheck auf
	 */
	public void moveControl() {
		for (Enemy e: ob.enemall) {
			if (e.getLebenspunkte() > 0) {
				while (e.getSteps() > 0f) {
					if(ob.ai.controlFood(e.getPosX(), e.getPosY())){
						direction = ob.ai.searchFood(e.getPosX(), e.getPosY(), e.getSpecies());
					} else {
						direction = ob.ai.randomMove(e.getPosX(), e.getPosY(), e.getSpecies());
					}
					switch (direction) {
						case NORTH:
							getFromHabitat(e.move(0, -20), e);
							fightCheck(e);
							resCheck(e);
							break;
						case EAST:
							getFromHabitat(e.move(20, 0), e);
							fightCheck(e);
							resCheck(e);
							break;
						case SOUTH:
							getFromHabitat(e.move(0, 20), e);
							fightCheck(e);
							resCheck(e);
							break;
						case WEST:
							getFromHabitat(e.move(-20, 0), e);
							fightCheck(e);
							resCheck(e);
							break;
						default:
							e.move(0, 0);
							break;
					}
				}
			} 
		}
		for (Kreatur k: ob.kreall) {
			k.checkSteps();
		}
	}
	
	/*
	 * Bewegung Spieler
	 */
	public void movePlayer(int px, int py) {
		getFromHabitat(ob.player.move(px, py), ob.player);
		fightCheck(ob.player);
		resCheck(ob.player);
	}

}
