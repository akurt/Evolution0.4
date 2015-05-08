package main;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/*
 * StartMenu ist ein eigener State und wird nach Starten des Spiels
 * automatisch aufgerufen. Von hier aus kann das Spiel gestartet oder
 * gleich wieder abgebrochen werden.
 */
public class StartMenu extends BasicGameState {

	private int p = 0;
	private int[] position = new int[2];
	
	private Input input;
	
	@Override
	public void init(GameContainer container, StateBasedGame state) throws SlickException {
		position[0] =  100;
		position[1] = 120;
		input = container.getInput();
	}

	@Override
	public void render(GameContainer container, StateBasedGame state, Graphics g) throws SlickException {
		g.drawString("Evolution", 200, 50);
		g.drawString("1. Start Spiel", 200, 100);
		g.drawString("2. Quit", 200, 120);
		g.drawRect(200, position[p], 200, 17);
	}

	@Override
	public void update(GameContainer container, StateBasedGame state, int delta) throws SlickException {
		if (input.isKeyPressed(Input.KEY_UP)) {
			if (p == 0) {
				p = 1;
			} else {
				p--;
			}
		} else if (input.isKeyPressed(Input.KEY_DOWN)) {
			if (p == 1) {
				p = 0;
			} else {
				p++;
			}
		} else if (input.isKeyPressed(Input.KEY_ENTER)) {
			switch(p){
			case 0:
				try {
					state.getState(1).init(container, state);
					state.enterState(5);
				} catch (SlickException e) {
					e.printStackTrace();
				}
				break;
			case 1:
				container.exit();
				break;
				default:
					break;
			}
		}
		
	}

	@Override
	public int getID() {
		return 0;
	}

}
