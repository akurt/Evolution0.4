package resources;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/*
 * Klasse Fleisch ist von Ressourcen abgeleitet
 * enthält Bild mit Nahrungssymbol
 */
public class Fleisch extends Ressourcen {

	public Fleisch(int posRX, int posRY, Resources res, int i) {
		super(posRX, posRY, res, i);
		nr = 2;
	}

	public void init(GameContainer container) throws SlickException {
		rImage = new Image("data/Fleisch.png");
	}
		
}
