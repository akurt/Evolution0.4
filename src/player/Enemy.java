package player;

import game.Direction;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;

/*
 * Dies ist die Klasse der künstlichen Spieler. Sie ist von Kreatur abgeleitet.
 */
public class Enemy extends Kreatur {

	public Enemy(int posX, int posY, float steps,  boolean hasFight, boolean startFight, Species species, boolean isPlayer , int str, int con, int spe, int mov ,int ins, String s1, String s2, String s3) {
		super(posX, posY, steps, hasFight, startFight, species, isPlayer, str, con, spe, mov, ins);
		abilist[0] = s1;
		abilist[1] = s2;
		abilist[2] = s3;
	}
	
	public void init(GameContainer container) throws SlickException {
		up = kpics.chosePic(species, setRang(),Direction.NORTH);
		down = kpics.chosePic(species, setRang(),Direction.SOUTH);
		left = kpics.chosePic(species, setRang(),Direction.WEST);
		right = kpics.chosePic(species, setRang(),Direction.EAST);
		sprite = right;
	}

}
