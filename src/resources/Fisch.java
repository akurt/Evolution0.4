package resources;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/*
 * Klasse Fisch ist von Ressourcen abgeleitet
 * enthält Bild mit Nahrungssymbol
 */
public class Fisch extends Ressourcen {

	public Fisch(int posRX, int posRY, Resources res, int i) {
		super(posRX, posRY, res, i);
		nr = 1;
	}

	public void init(GameContainer container) throws SlickException {
		rImage = new Image("data/Fisch.png");
	}
	
}
