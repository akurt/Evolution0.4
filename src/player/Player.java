package player;

import game.Direction;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

/*
 * Dies ist die Klasse des menschlichen Spielers. Sie ist von Kreatur abgeleitet.
 */
public class Player extends Kreatur {
	public int level = 1;
	public int exp = 0;
	public int exprang = 30;
	public int skillpoints = 100;
	
	public String[] abilist = {"---", "---", "---"};
	
	public Player(int posX, int posY, float steps,  boolean hasFight, boolean startFight, Species species, boolean isPlayer, int str, int con, int spe, int mov ,int ins) {
		super(posX, posY, steps,  hasFight, startFight, species, isPlayer, str, con, spe, mov, ins);
	}
	
	public void init(GameContainer container) throws SlickException {
		up = kpics.chosePic(species, setRang(),Direction.NORTH);
		down = kpics.chosePic(species, setRang(),Direction.SOUTH);
		left = kpics.chosePic(species, setRang(),Direction.WEST);
		right = kpics.chosePic(species, setRang(),Direction.EAST);
		
		sprite = right;
	}
	
	public void renderPosition (GameContainer container, Graphics g){
		g.fillRect(25, 25, 50, 50);
		this.sprite.draw(25, 25, 50, 50);
		
	}
	public void waycheck(){
		if(this.speed >= 10){
			this.waypoints = 2;
		}
		if(this.speed >= 20){
			this.waypoints = 3;
		}
		if(this.speed >= 30){
			this.waypoints = 4;
		}
		if(this.speed >= 40){
			this.waypoints = 5; 
		}
		if(this.speed >= 50){
			this.waypoints = 6; 
		}
		if(this.speed >= 60){
			this.waypoints = 7; 
		}
		if(this.speed >= 70){
			this.waypoints = 8; 
		}
		if(this.speed >= 80){
			this.waypoints = 9; 
		}
		if(this.speed >= 90){
			this.waypoints = 10; 
		}
		if(this.speed >= 100){
			this.waypoints = 11; 
		}
	}
	
	public void levelcheck(){
		if(exp >= exprang){
			level += 1;
			skillpoints += 1;
			exp = exp % exprang;
			exprang += exprang *0.5;
			waycheck();
		}
	}
	
}
