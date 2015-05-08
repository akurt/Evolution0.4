package main;

import fight.FightState;
import game.GameMenu;
import game.MapControl;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
/*
 * Klasse Main enth�lt Methode main die States werden hinzugef�gt,
 * der State StartMenu wird aufgerufen
 */
public class Main extends StateBasedGame {

	public Main(String name) {
		super(name);
	}

	/*
	 * States hinzuf�gen, GameMenu aufrufen
	 */
	@Override
	public void initStatesList(GameContainer container) throws SlickException {
		addState(new StartMenu());
		addState(new Game());
		addState(new MapControl());
		addState(new FightState());
		addState(new GameMenu());
		enterState(0);
	}

	public static void main(String[] args) {
		AppGameContainer appgc;
		try {
			appgc=new AppGameContainer(new Main("Evolution"));
			appgc.setDisplayMode(1000, 800, false);
			appgc.setTargetFrameRate(60);
			appgc.start();
		} catch(SlickException e) {
			e.printStackTrace();
		}
	}
	
}
