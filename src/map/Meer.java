package map;

import org.newdawn.slick.Image;

import player.Species;

/*
 * Habitat Meer
 * Enthält Nahrungs- und Bewegungspunkte
 */
public class Meer extends Feld {

	public Meer() {
		super(Habitat.MEER, "data/Wasser.png");
	}
	
	public Image getBild() {
		return bild;
	}
	
	public int habitatLP(Species species) {
		switch (species) {
		case AQUA:
			nahrung = 0;
			break;
		case HERBA:
			nahrung = -5;
			break;
		case LITUS:
			nahrung = -1;
			break;
		default:
			nahrung = 0;
			break;
		}
		return nahrung;
	}
	
	public float getBewegung(Species species) {
		switch (species) {
		case AQUA:
			steps = 1f;
			break;
		case HERBA:
			steps = 0f;
			break;
		case LITUS:
			steps = 1f;
			break;
		default:
			steps = 0f;
			break;
		}
		return steps;
	}
	
}
