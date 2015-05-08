package map;

import org.newdawn.slick.Image;

import player.Species;

/*
 * Habitat Strand
 * Enthält Nahrungs- und Bewegungspunkte
 */
public class Strand extends Feld {

	public Strand() {
		super(Habitat.STRAND, "data/Strand.png");
	}
	
	public Image getBild() {
		return bild;
	}
	
	public int habitatLP(Species species) {
		switch (species) {
		case AQUA:
			nahrung = -1;
			break;
		case HERBA:
			nahrung = -1;
			break;
		case LITUS:
			nahrung = 0;
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
