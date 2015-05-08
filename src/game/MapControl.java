package game;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import player.Enemy;
import player.Kreatur;
import resources.Ressourcen;
import main.PlayObject;
/*
 * Diese Klasse kontrolliert die Grafik der Weltkarte
 * die Methode update fängt die Tastatureingaben zum 
 * Bewegen des Spielers ab
 */
public class MapControl extends BasicGameState {

	private int runde = 0;
	
	PlayObject ob = PlayObject.getInstance();
	
	@Override
	public void init(GameContainer container, StateBasedGame state) throws SlickException {
		ob.init(container);
	}

	@Override
	public void render(GameContainer container,StateBasedGame state,  Graphics g) throws SlickException {
		ob.map.zeichnen();
		
		/*
		 * Ressourcen & Kreaturen zeichnen
		 */
		for (Ressourcen r: ob.nahrung) {
			r.render(g);
		}
		
		for (Kreatur k: ob.kreall) {
			if (k.getLebenspunkte() > 0) {
				k.render(g);
			}
		}
		
		g.setColor(Color.white);
		g.drawString("Lebenspunkte: " + " " + ob.player.getLebenspunkte() + "/" + ob.player.Maxlp , 50, 420);
		g.drawString("Hungerpunkte: " + " " + ob.player.getStarvationpoints() + "/" + ob.player.Maxsp, 50, 440);
		
		
	}
	
	public void output() {
		
		System.out.println(ob.player.getSpecies() + " " + ob.player.getPosX() + " " + ob.player.getPosY() + " " + ob.player.isHasFight() + " " + ob.player.isStartFight() + " " + ob.player.getLebenspunkte() + " " + ob.player.getSteps() + " " + ob.player.speed);
		System.out.println(ob.aqua.getSpecies() + " " + ob.aqua.getPosX() + " " + ob.aqua.getPosY() + " " + ob.aqua.isHasFight() + " " + ob.aqua.isStartFight() + " " + ob.aqua.getLebenspunkte() + " " + ob.aqua.getSteps() + " " + ob.aqua.speed);
		System.out.println(ob.terra.getSpecies() + " " + ob.terra.getPosX() + " " + ob.terra.getPosY() + " " + ob.terra.isHasFight() + " " + ob.terra.isStartFight() + " " + ob.terra.getLebenspunkte() + " " + ob.terra.getSteps()  + " " + ob.terra.speed);
		
	}
	
	@Override
	public void update(GameContainer container,StateBasedGame state, int delta) throws SlickException {
		//ob.player.iMap();
		
		ob.input = container.getInput();
		setFoodUpdate();
		 
		/*
		 * feststellen, ob player noch im Spiel
		 */
		if (ob.player.getLebenspunkte() <= 0) {
			state.enterState(1);
		}
		
		/*
		 * feststellen, ob aktive Feinde vorhanden
		 */
		boolean enActiv = false;
		for (Enemy enem: ob.enemall) {
			if (enem.getLebenspunkte() >= 0) {
				enActiv = true;
				break;
			}
		}
		if (enActiv == false) {
			state.enterState(1);
		}
		
		if(ob.input.isKeyPressed(Input.KEY_ESCAPE)){
			state.enterState(7);
		}
		
		/*
		 * Bewegung auf Weltkarte mit Pfeiltasten
		 */
		if (!ob.gamecontrol.isFight()) {
			if (ob.player.getSteps() > 0f) {
				if (ob.input.isKeyPressed(Input.KEY_UP)) {
					ob.player.setSprite(Direction.NORTH);
					if (ob.ai.moveTry(ob.player.getPosX(), ob.player.getPosY() - 20, ob.player.getSpecies())) {
						ob.gamecontrol.movePlayer(0, -20);
					}
					//output();
				} else if (ob.input.isKeyPressed(Input.KEY_DOWN)) {
					ob.player.setSprite(Direction.SOUTH);
					if (ob.ai.moveTry(ob.player.getPosX(), ob.player.getPosY() + 20, ob.player.getSpecies())) {
						ob.gamecontrol.movePlayer(0, 20);
					}
					//output();
				} else if (ob.input.isKeyPressed(Input.KEY_LEFT)) {
					ob.player.setSprite(Direction.WEST);
					if (ob.ai.moveTry(ob.player.getPosX() - 20, ob.player.getPosY(), ob.player.getSpecies())) {
						ob.gamecontrol.movePlayer(-20, 0);
					}
					//output();
				} else if (ob.input.isKeyPressed(Input.KEY_RIGHT)) {
					ob.player.setSprite(Direction.EAST);
					if (ob.ai.moveTry(ob.player.getPosX() + 20, ob.player.getPosY(), ob.player.getSpecies())) {
						ob.gamecontrol.movePlayer(20, 0);
					}
					//output();
				}
			} else {
				/*
				 * Enemy am Zug
				 */
				ob.gamecontrol.moveControl();
				
				/*
				 * Rundenzahl erhöhen, Epoche anpassen
				 */
				runde += 1;
				if (runde == 25) {
					ob.map.setEpoche(2);
					ob.gamecontrol.getPM();
					for (Kreatur k: ob.kreall) {
						ob.gamecontrol.posKreatur(k);
					}
					
				}
				
				if (runde == 50) {
					ob.map.setEpoche(3);
					ob.gamecontrol.getPM();
					for (Kreatur k: ob.kreall) {
						ob.gamecontrol.posKreatur(k);
					}
				}
				
				if (runde == 75) {
					ob.map.setEpoche(4);
					ob.gamecontrol.getPM();
					for (Kreatur k: ob.kreall) {
						ob.gamecontrol.posKreatur(k);
					}
				}
			}
		} else {
			state.enterState(6);
		}
	}

	/*
	 * Methode zu positionieren von Ressourcen
	 * zurücksetzen der FoodMap
	 * und neu positionierte Ressourcen auf FoodMap setzen
	 */
	public void setFoodUpdate(){
		ob.map.setBackFood();
		for(Ressourcen r: ob.nahrung){
			ob.map.setFoodMap(r.getPosRX(), r.getPosRY(), r.getNR());
		}
	}
	

	@Override
	public int getID() {
		return 5;
	}
	

}
