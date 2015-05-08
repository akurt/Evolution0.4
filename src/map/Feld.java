package map;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/*
 * Vererbt an die Habitatsfelder. Dient zum Darstellen der einzelnen
 * Felder auf der Weltkarte.
 */
public class Feld {

	protected Habitat habitat;
	protected Image bild;
	protected int nahrung;
	protected float steps;
	
	public Feld(Habitat habitat, String bild) {
		this.habitat = habitat;
		try {
			this.bild = new Image(bild);
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}

	public Habitat getHabitat() {
		return habitat;
	}
	
	public void setHabitat(Habitat habitat) {
		this.habitat = habitat;
	}
	
	
	
}
