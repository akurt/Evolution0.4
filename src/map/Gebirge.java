package map;

import org.newdawn.slick.Image;

import player.Species;

/*
 * Habitat Gebirge
 * Enthält Nahrungs- und Bewegungspunkte
 */
public class Gebirge extends Feld {

	public Gebirge() {
		super(Habitat.GEBIRGE, "data/Gebirge.png");
	}
	
	public Image getBild() {
		return bild;
	}
	
	public int habitatLP(Species species) {
		switch (species) {
		case AQUA:
			nahrung = -10;
			break;
		case HERBA:
			nahrung = -3;
			break;
		case LITUS:
			nahrung = -5;
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
