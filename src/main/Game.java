package main;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/*
 * Game ist ein eigener State und das Schlussmenu des Games
 * Hierhin kommt man automatisch, wenn das Spiel zu Ende ist
 */
public class Game extends BasicGameState {

	private int p = 1;
	private int[] position = new int[2];
	private Input input;
	
	PlayObject ob = PlayObject.getInstance();
	
	@Override
	public void init(GameContainer container, StateBasedGame state) throws SlickException {
		position[0] =  100;
		position[1] = 120;
		input = container.getInput();
	}

	@Override
	public void render(GameContainer container, StateBasedGame state, Graphics g) throws SlickException {
		g.drawString("Ende", 200, 50);
		g.drawString("Enter: Beenden", 200, 120);
		g.drawRect(200, position[p], 200, 17);
		
		if (ob.player.getLebenspunkte() <= 0) {
			g.drawString("Verloren", 200, 220);
		} else {
			g.drawString("Gewonnen", 200, 220);
		}
	}

	@Override
	public void update(GameContainer container, StateBasedGame state, int delta) throws SlickException {
		if (input.isKeyPressed(Input.KEY_ENTER)) {
			container.exit();
		}
	}

	@Override
	public int getID() {
		return 1;
	}

}
