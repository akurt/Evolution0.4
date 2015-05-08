package fight;

import map.Habitat;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/*
 * FightMap stellt den Hintergrund während des Kampfmodus statt.
 * Der Hintergrund wird durch das Habitatsfeld auf dem der Kampf stattfindet
 * dargestellt
 */
public class FightMap {

	private Image gebirge;
	private Image seaF;
	private Image savanne;
	private Image strand;
	private Image sumpf;
	private Image wald;
	private Image wiese;
	
	private Habitat habitat;

	public FightMap() {
		try {
			this.gebirge = new Image("data/Gebirge_Kampf.png");
			this.seaF = new Image("data/SeaF.png");
			this.savanne = new Image("data/Savanne_Kampf.png");
			this.strand = new Image("data/Strand_Kampf.png");
			this.sumpf = new Image("data/Savanne_Kampf.png");
			this.wald = new Image("data/Wald_Kampf.png");
			this.wiese = new Image("data/Wiese_Kampf.png");
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * Zeichnet Hintergrundbild
	 */
	public void zeichnenFight(Habitat habitat) {
		switch (habitat) {
		case GEBIRGE:
			gebirge.draw(0, 0, 720, 360);
			break;
		case MEER:
			seaF.draw(0, 0, 720, 360);
			break;
		case SAVANNE:
			savanne.draw(0, 0, 720, 360);
			break;
		case STRAND:
			strand.draw(0, 0, 720, 360);
			break;
		case SUMPF:
			sumpf.draw(0, 0, 720, 360);
			break;
		case WALD:
			wald.draw(0, 0, 720, 360);
			break;
		case WIESE:
			wiese.draw(0, 0, 720, 360);
			break;
		default:
			savanne.draw(0, 0, 720, 360);
			break;
		}
	}
	
	public Habitat getHabitat() {
		return habitat;
	}
	
	public void setHabitat(Habitat habitat) {
		this.habitat = habitat;
	}
	
}
