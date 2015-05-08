package player;

import java.util.Arrays;
import game.Direction;
import map.Habitat;
import map.Map;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

/*
 * Diese Klasse enthält die Attribute, die Player und Enemy gemeinsam haben
 * Sie enthält Methoden für Bewegung und Kampf
 * Die Klassen Player und Enemy sind von Kreatur abgeleitet
 */
public class Kreatur {

	/*
	 * public-Attribute müssen für das Package fight offen sein
	 */
	public int level = 1;
	public int exp = 0;
	public int exprang = 30;
	public int skillpoints = 0;
	
	public int waypoints = 1;
	
	public String[] abilist = new String[3];
	protected int posX, posY;
	protected float steps;
	public int Maxlp, Maxsp, strength, constitution, speed, movement, instinct, dam, def, hit, agi, Rang;
	protected int lebenspunkte, ap, sp ;
	protected boolean hasFight;
	protected boolean startFight;
	protected Species species;
	protected boolean isPlayer;
	
	protected Animation sprite , up, down, left, right, spriteS, special;
	protected SpriteSheet movmentUp, movmentDown, movmentLeft, movmentRight, specialL, specialR;
	
	protected Map map;
	protected KreaturPics kpics;
	
	public Kreatur(int posX, int posY, float steps, boolean hasFight, boolean startFight, Species species, boolean isPlayer, int str,  int con, int spe, int mov, int ins) {
		this.posX = posX;
		this.posY = posY;
		this.steps = steps;
		this.hasFight = hasFight;
		this.startFight = startFight;
		this.species = species;
		this.isPlayer = isPlayer;
		this.map = new Map();
		this.kpics = new KreaturPics();
		this.strength = str;
		this.constitution = con;
		this.speed = spe;
		this.movement = mov;
		this.instinct = ins;
		this.updateAttribute();
		this.lebenspunkte = Maxlp;
		this.sp = Maxsp;
		
		this.checkSteps();
		
	}
	
	/*
	 * bestimmt welches Sprite gerendert wird
	 */
	public void render(Graphics g) {
		if ((hasFight == true) && (startFight == true)) {
			sprite.draw(0, 250, 200, 100);			// position linkes FightSprite
		} else if (hasFight == true) {
			sprite.draw(500, 250, 200, 100);		// position rechtes FightSprite
		}
		if (hasFight == false) {
			sprite.draw(this.getPosX(), this.getPosY(), 20, 20);	// Sprite für Weltkarte
		}
	}
	
	/*
	 * gibt Habitat auf das sich Spieler bewegen will zurück
	 */
	public Habitat move(int dx, int dy) {
		this.posX += dx;
		this.posY += dy;
		return map.getHabitat(posX, posY);
	}
	
	/*
	 * gibt bei Bewegung auf Weltkarte Sprite für entsprechende Richtung aus
	 */
	public void setSprite(Direction dir) throws SlickException {
		
		/*if (hasFight == false) {
			if (dir == Direction.NORTH) {
				sprite = up;
			} else if (dir == Direction.SOUTH) {
				sprite = down;
			} else if (dir == Direction.WEST) {
				sprite = left;
			} else if (dir == Direction.EAST) {
				sprite = right;
			}
		}*/
		
		if (dir == Direction.NORTH) {
			sprite = kpics.chosePic(species, setRang(), Direction.NORTH);
		} else if (dir == Direction.SOUTH) {
			sprite = kpics.chosePic(species, setRang(), Direction.SOUTH);
		} else if (dir == Direction.WEST) {
			sprite = kpics.chosePic(species, setRang(), Direction.WEST);
		} else if (dir == Direction.EAST) {
			sprite = kpics.chosePic(species, setRang(), Direction.EAST);
		}
	}
	
	/*
	 * gibt bei Kampf Sprite für linke / rechte Seite aus
	 */
	public void iFight() throws SlickException {
		
		if (startFight == true) {
			sprite = kpics.fightPic(species, MostPoints(), setRang(), Direction.EAST);
			//System.out.println("east");
		} else {
			sprite = kpics.fightPic(species, MostPoints(), setRang(), Direction.WEST);	
			//System.out.println("west");
		}
	}
	
	/*
	 * setzt nach Kampf Sprite auf Weltkartenformat zurück
	 */
	public void iMap() throws SlickException {
		sprite = kpics.chosePic(species, setRang(),Direction.EAST);
	}
	
	public void iMap2(Species s, int c, Direction dir) throws SlickException {
		sprite = kpics.chosePic(s, c, dir);
	}
	
	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}
	
	public int getPosY() {
		return posY;
	}
	
	public void setPosY(int posY) {
		this.posY = posY;
	}
	
	public float getSteps() {
		return steps;
	}
	
	public void setSteps(float steps) {
		this.steps = steps;
	}

	public void changeSteps(float steps) {
		this.steps -= steps;
	}
	
	public Species getSpecies() {
		return species;
	}
	
	public void setSpecies(Species species) {
		this.species = species;
	}
	
	public int getLebenspunkte() {
		return lebenspunkte;
	}
	
	public void setLebP0(int lebenspunkte) {
		this.lebenspunkte = lebenspunkte;
	}
	
	public void setLebenpunkte(int lebenspunkte){
		if((this.lebenspunkte + lebenspunkte) >= this.Maxlp){
			this.lebenspunkte = this.Maxlp;
		}else{
			this.lebenspunkte += lebenspunkte;
		}
	}
	
	public int getStarvationpoints() {
		return sp;
	}
	
	/*
	 * setzt Starvation- und Lebenspunkte fest
	 */
	public void setStarvationpoints(int starvationpoints) {
		if(this.lebenspunkte == this.Maxlp){
			if((this.sp + starvationpoints) >= this.Maxsp){
				this.sp = this.Maxsp;
			}else if((this.sp + starvationpoints) <= 0){
				this.sp = 0;
				this.setLebenpunkte(starvationpoints);
			}else{
				this.sp += starvationpoints;
			}
		}else{
				this.setLebenpunkte(starvationpoints);
		}
	}
	public void setLifepointsN(int lifepoints){
		this.lebenspunkte -= lifepoints;
	}
	
	public boolean isHasFight() {
		return hasFight;
	}
	
	public void setHasFight(boolean hasFight) {
		this.hasFight = hasFight;
	}
	
	public boolean isStartFight() {
		return startFight;
	}
	
	public void setStartFight(boolean startFight) {
		this.startFight = startFight;
	}
	
	public boolean isPlayer() {
		return isPlayer;
	}
	
	public void setPlayer(boolean isPlayer) {
		this.isPlayer = isPlayer;
	}
	
	
	public void updateAttribute(){
		this.Maxlp = (1*this.strength)+(2* this.constitution)+(1*this.speed)+(2*this.movement)+(1*this.instinct);
		this.Maxsp = (4*this.instinct);
		
		this.dam = (3*this.strength)+(1*this.constitution);
		this.def = (1*this.strength)+(2*this.constitution);
		this.hit = (3*this.speed)+(1*this.movement);
		this.agi = (1*this.speed)+(2*this.movement);
		}
	
	public void levelcheck(){
		if(exp >= exprang){
			level += 1;
			skillpoints += 1;
			exp = exp % exprang;
			exprang += exprang *0.5;
		}
	}
	
	public String MostPoints(){
		String b = "Ins";
		int[] a = {this.strength, this.constitution, this.speed, this.movement, this.instinct};
		Arrays.sort(a);
		
		if(a[4] == this.strength){
			b = "Str";
		}else if(a[4] == this.constitution){
			b = "Con";
		}else if(a[4] == this.speed){
			b = "Spe";
		}else if(a[4] == this.movement){
			b = "Mov";
		}else if(a[4] == this.instinct){
			b = "Ins";
		}
		
		
		return b;
	}
	
	public int setRang(){
		int[] a = {this.strength, this.constitution, this.speed, this.movement, this.instinct};
		
		Arrays.sort(a);
		
		if(a[4] > 33){
			if(a[4] > 66){
				return 3;
			}
			return 2;
		}
		return 1;
	}

	
	/*
	 * zuweisen von Spezialfähigkeiten für Kampf
	 */
	public int getAblity(Kreatur a, Kreatur d, String r){
		int dS = 0;
		switch(r){
		case "Doppelbiss":
			dS = (a.dam *2 )- d.def;
			break;
		case "Bodycheck":
			dS = (a.def*2)-d.def;
			break;
		case "Rammen":
			dS = (int) ((a.dam * (a.speed * 0.01)) - d.def); 
			break;
		case "Quetscher":
			dS = (int) ((a.dam * (a.movement * 0.01)) - d.def);
			break;
		case "Schwachpunkt":
			dS = (int) (a.dam - ( d.def *0.75));
			break;
		case "Knochenbrecher":
			dS = (a.dam * 3) - d.def;
			break;
		case "Bodyslam":
			dS = (a.def * 3) - d.def;
			break;
		case "Hornstoss":
			dS = (int) ((a.dam * (a.speed * 0.5)) - d.def);
			break;
		case "Lynchen":
			dS = (int) ((a.dam * (a.movement * 0.5)) - d.def);
			break;
		case "Kehlbiss":
			dS = (int) (a.dam - (d.def * 0.5));
			break;
		case "Blutrausch":
			dS = (a.dam * (a.Maxlp/a.lebenspunkte) ) - d.def;
			break;
		case "Einigeln":
			dS = (a.def * ((a.lebenspunkte / a.Maxlp)*10))-d.dam;
			break;
		case "Stampede":
			dS = (int) ((a.dam * (a.speed*0.5)) - d.def);
			break;
		case "Konter":
			dS = (int) ((a.dam * (a.movement*0.5)) - d.def);
			break;
		case "Neckbruch":
			dS = a.dam; 
			break;
		}
		
		return dS*=-1;
	}
	
	public void checkSteps(){
		if(this.speed >= 0){
			this.steps = 1;
		}
		if(this.speed >= 10){
			this.steps = 2;
		}
		if(this.speed >= 20){
			this.steps = 3;
		}
		if(this.speed >= 30){
			this.steps = 4;
		}
		if(this.speed >= 40){
			this.steps = 5; 
		}
		if(this.speed >= 50){
			this.steps = 6; 
		}
		if(this.speed >= 60){
			this.steps = 7; 
		}
		if(this.speed >= 70){
			this.steps = 8; 
		}
		if(this.speed >= 80){
			this.steps = 9; 
		}
		if(this.speed >= 90){
			this.steps = 10; 
		}
		if(this.speed >= 100){
			this.steps = 11; 
		}
	
	
	}
}
