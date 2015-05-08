package map;

import org.newdawn.slick.Image;

import player.Species;

/*
 * Habitat Wiese
 * Enthält Nahrungs- und Bewegungspunkte
 */
public class Wiese extends Feld {

	public Wiese() {
		super(Habitat.WIESE, "data/Wiese.png");
	}
	
	public Image getBild() {
		return bild;
	}
	
	public int habitatLP(Species species) {
		switch (species) {
		case AQUA:
			nahrung = -5;
			break;
		case HERBA:
			nahrung = 0;
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
			steps = 0f;
			break;
		case HERBA:
			steps = 0.5f;
			break;
		case LITUS:
			steps = 2f;
			break;
		default:
			steps = 0f;
			break;
		}
		return steps;
	}
	
}
