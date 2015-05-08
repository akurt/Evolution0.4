package resources;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/*
 * Klasse Fruechte ist von Ressourcen abgeleitet
 * enthält Bild mit Nahrungssymbol
 */
public class Fruechte extends Ressourcen {

	public Fruechte(int posRX, int posRY, Resources res, int i) {
		super(posRX, posRY, res, i);
		nr= 3;
	}

	public void init(GameContainer container) throws SlickException {
		rImage = new Image("data/Fruits.png");
	}
	
}