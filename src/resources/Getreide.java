package resources;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/*
 * Klasse Getreide ist von Ressourcen abgeleitet
 * enthält Bild mit Nahrungssymbol
 */
public class Getreide extends Ressourcen {

	public Getreide(int posRX, int posRY, Resources res, int i) {
		super(posRX, posRY, res, i);
		nr = 4;
	}

	// kann entfernt werden?
	/*public void render(Graphics g) {
		rImage.draw(this.getPosRX(), this.getPosRY(), 20, 20);
	}*/
	
	public void init(GameContainer container) throws SlickException {
		rImage = new Image("data/Getreide.png");
	}
	
	
	/*public int getLP(Species s) {
		
		switch (s) {
		case AQUA:
			nahrung = 0;
			break;

		case HERBA:
			nahrung = 10;
			break;
		case LITUS:
			nahrung = 5;
			break;
		default:
			break;
		}
		
		return nahrung;
		
	}*/
	
}
