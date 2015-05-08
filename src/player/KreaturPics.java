package player;

import game.Direction;

import org.newdawn.slick.Animation;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

/*
 * Klasse zur Verwaltung der Bilder der verschiedenen Kreaturen.
 * Die Bilder werden je nach Bewegung / Richtung bzw. Weltkarte
 * oder Kampf aufgerufen
 */
public class KreaturPics {

	private Animation sprite, up, down, left, right, norm, att1, att2, att3, att4;
	private SpriteSheet movmentUp, movmentDown, movmentLeft, movmentRight, actionnormal, action1, action2, action3, action4;
	
	public Animation chosePic(Species species, int i, Direction dir) throws SlickException {
		String speci, rang;
		
		
		switch(species){
		case AQUA:
			switch(i){
			case 1:
				movmentUp = new SpriteSheet("data/Kreatur/Wasser/1/UP.png", 50, 50);
				movmentDown = new SpriteSheet("data/Kreatur/Wasser/1/DOWN.png", 50, 50);
				movmentLeft = new SpriteSheet("data/Kreatur/Wasser/1/LEFT.png", 50, 50);
				movmentRight = new SpriteSheet("data/Kreatur/Wasser/1/RIGHT.png", 50, 50);
				break;
			case 2:
				movmentUp = new SpriteSheet("data/Kreatur/Wasser/2/UP.png", 50, 50);
				movmentDown = new SpriteSheet("data/Kreatur/Wasser/2/DOWN.png", 50, 50);
				movmentLeft = new SpriteSheet("data/Kreatur/Wasser/2/LEFT.png", 50, 50);
				movmentRight = new SpriteSheet("data/Kreatur/Wasser/2/RIGHT.png", 50, 50);
				break;
			case 3:
				movmentUp = new SpriteSheet("data/Kreatur/Wasser/3/UP.png", 50, 50);
				movmentDown = new SpriteSheet("data/Kreatur/Wasser/3/DOWN.png", 50, 50);
				movmentLeft = new SpriteSheet("data/Kreatur/Wasser/3/LEFT.png", 50, 50);
				movmentRight = new SpriteSheet("data/Kreatur/Wasser/3/RIGHT.png", 50, 50);
				break;
			default:
				movmentUp = new SpriteSheet("data/Kreatur/Wasser/1/UP.png", 50, 50);
				movmentDown = new SpriteSheet("data/Kreatur/Wasser/1/DOWN.png", 50, 50);
				movmentLeft = new SpriteSheet("data/Kreatur/Wasser/1/LEFT.png", 50, 50);
				movmentRight = new SpriteSheet("data/Kreatur/Wasser/1/RIGHT.png", 50, 50);
				break;
			}
			break;
		case HERBA:
			switch(i){
			case 1:
				movmentUp = new SpriteSheet("data/Kreatur/Land/1/UP.png", 50, 50);
				movmentDown = new SpriteSheet("data/Kreatur/Land/1/DOWN.png", 50, 50);
				movmentLeft = new SpriteSheet("data/Kreatur/Land/1/LEFT.png", 50, 50);
				movmentRight = new SpriteSheet("data/Kreatur/Land/1/RIGHT.png", 50, 50);
				break;
			case 2:
				movmentUp = new SpriteSheet("data/Kreatur/Land/2/UP.png", 50, 50);
				movmentDown = new SpriteSheet("data/Kreatur/Land/2/DOWN.png", 50, 50);
				movmentLeft = new SpriteSheet("data/Kreatur/Land/2/LEFT.png", 50, 50);
				movmentRight = new SpriteSheet("data/Kreatur/Land/2/RIGHT.png", 50, 50);
				break;
			case 3:
				movmentUp = new SpriteSheet("data/Kreatur/Land/3/UP.png", 50, 50);
				movmentDown = new SpriteSheet("data/Kreatur/Land/3/DOWN.png", 50, 50);
				movmentLeft = new SpriteSheet("data/Kreatur/Land/3/LEFT.png", 50, 50);
				movmentRight = new SpriteSheet("data/Kreatur/Land/3/RIGHT.png", 50, 50);
				break;
			default:
				movmentUp = new SpriteSheet("data/Kreatur/Land/1/UP.png", 50, 50);
				movmentDown = new SpriteSheet("data/Kreatur/Land/1/DOWN.png", 50, 50);
				movmentLeft = new SpriteSheet("data/Kreatur/Land/1/LEFT.png", 50, 50);
				movmentRight = new SpriteSheet("data/Kreatur/Land/1/RIGHT.png", 50, 50);
				break;
			}
			break;
		case LITUS:
			switch(i){
			case 1:
				movmentUp = new SpriteSheet("data/Kreatur/Amphibisch/1/UP.png", 50, 50);
				movmentDown = new SpriteSheet("data/Kreatur/Amphibisch/1/DOWN.png", 50, 50);
				movmentLeft = new SpriteSheet("data/Kreatur/Amphibisch/1/LEFT.png", 50, 50);
				movmentRight = new SpriteSheet("data/Kreatur/Amphibisch/1/RIGHT.png", 50, 50);
				break;
			case 2:
				movmentUp = new SpriteSheet("data/Kreatur/Amphibisch/2/UP.png", 50, 50);
				movmentDown = new SpriteSheet("data/Kreatur/Amphibisch/2/DOWN.png", 50, 50);
				movmentLeft = new SpriteSheet("data/Kreatur/Amphibisch/2/LEFT.png", 50, 50);
				movmentRight = new SpriteSheet("data/Kreatur/Amphibisch/2/RIGHT.png", 50, 50);
				break;
			case 3:
				movmentUp = new SpriteSheet("data/Kreatur/Amphibisch/3/UP.png", 50, 50);
				movmentDown = new SpriteSheet("data/Kreatur/Amphibisch/3/DOWN.png", 50, 50);
				movmentLeft = new SpriteSheet("data/Kreatur/Amphibisch/3/LEFT.png", 50, 50);
				movmentRight = new SpriteSheet("data/Kreatur/Amphibisch/3/RIGHT.png", 50, 50);
				break;
			default:
				movmentUp = new SpriteSheet("data/Kreatur/Amphibisch/1/UP.png", 50, 50);
				movmentDown = new SpriteSheet("data/Kreatur/Amphibisch/1/DOWN.png", 50, 50);
				movmentLeft = new SpriteSheet("data/Kreatur/Amphibisch/1/LEFT.png", 50, 50);
				movmentRight = new SpriteSheet("data/Kreatur/Amphibisch/1/RIGHT.png", 50, 50);
				break;
			}
			break;
		default:
			switch(i){
			case 1:
				movmentUp = new SpriteSheet("data/Kreatur/Land/1/UP.png", 50, 50);
				movmentDown = new SpriteSheet("data/Kreatur/Land/1/DOWN.png", 50, 50);
				movmentLeft = new SpriteSheet("data/Kreatur/Land/1/LEFT.png", 50, 50);
				movmentRight = new SpriteSheet("data/Kreatur/Land/1/RIGHT.png", 50, 50);
				break;
			case 2:
				movmentUp = new SpriteSheet("data/Kreatur/Land/1/UP.png", 50, 50);
				movmentDown = new SpriteSheet("data/Kreatur/Land/1/DOWN.png", 50, 50);
				movmentLeft = new SpriteSheet("data/Kreatur/Land/1/LEFT.png", 50, 50);
				movmentRight = new SpriteSheet("data/Kreatur/Land/1/RIGHT.png", 50, 50);
				break;
			case 3:
				movmentUp = new SpriteSheet("data/Kreatur/Land/1/UP.png", 50, 50);
				movmentDown = new SpriteSheet("data/Kreatur/Land/1/DOWN.png", 50, 50);
				movmentLeft = new SpriteSheet("data/Kreatur/Land/1/LEFT.png", 50, 50);
				movmentRight = new SpriteSheet("data/Kreatur/Land/1/RIGHT.png", 50, 50);
				break;
			default:
				movmentUp = new SpriteSheet("data/Kreatur/Land/1/UP.png", 50, 50);
				movmentDown = new SpriteSheet("data/Kreatur/Land/1/DOWN.png", 50, 50);
				movmentLeft = new SpriteSheet("data/Kreatur/Land/1/LEFT.png", 50, 50);
				movmentRight = new SpriteSheet("data/Kreatur/Land/1/RIGHT.png", 50, 50);
				break;
			}
			break;
		}

			
		
		up = new Animation(movmentUp, 200);
		down = new Animation(movmentDown, 200);
		left = new Animation(movmentLeft, 200);
		right = new Animation(movmentRight, 200);
		
		if (dir == Direction.NORTH) sprite = up;
		if (dir == Direction.EAST) sprite = right;
		if (dir == Direction.SOUTH) sprite = down;
		if (dir == Direction.WEST) sprite = left;
		
		return sprite;
		
	}
	
	public Animation fightPic(Species species,String wert, int i,  Direction dir) throws SlickException {
		//System.out.println(species + " " + wert + " " + i);
		switch (species) {
		case AQUA:
			switch(wert){
			case "Str":
				switch(i){
				case 1:
					actionnormal = new SpriteSheet("data/Kreatur/Wasser/strength/1/Normal.png", 100, 50);
					break;
				case 2:
					actionnormal = new SpriteSheet("data/Kreatur/Wasser/strength/2/Normal.png", 100, 50);
					break;
				case 3:
					actionnormal = new SpriteSheet("data/Kreatur/Wasser/strength/3/Normal.png", 100, 50);
					break;
				}
				break;
			case "Con":
				switch(i){
				case 1:
					actionnormal = new SpriteSheet("data/Kreatur/Wasser/constitution/1/Normal.png", 100, 50);
					break;
				case 2:
					actionnormal = new SpriteSheet("data/Kreatur/Wasser/constitution/2/Normal.png", 100, 50);
					break;
				case 3:
					actionnormal = new SpriteSheet("data/Kreatur/Wasser/constitution/3/Normal.png", 100, 50);
					break;
				}
				break;
			case "Spe":
				switch(i){
				case 1:
					actionnormal = new SpriteSheet("data/Kreatur/Wasser/speed/1/Normal.png", 100, 50);
					break;
				case 2:
					actionnormal = new SpriteSheet("data/Kreatur/Wasser/speed/2/Normal.png", 100, 50);
					break;
				case 3:
					actionnormal = new SpriteSheet("data/Kreatur/Wasser/speed/3/Normal.png", 100, 50);
					break;
				}
				break;
			case "Mov":
				switch(i){
				case 1:
					actionnormal = new SpriteSheet("data/Kreatur/Wasser/movment/1/Normal.png", 100, 50);
					break;
				case 2:
					actionnormal = new SpriteSheet("data/Kreatur/Wasser/movment/2/Normal.png", 100, 50);
					break;
				case 3:
					actionnormal = new SpriteSheet("data/Kreatur/Wasser/movment/3/Normal.png", 100, 50);
					break;
				}
				break;
			case "Ins":
				switch(i){
				case 1:
					actionnormal = new SpriteSheet("data/Kreatur/Wasser/instict/1/Normal.png", 100, 50);
					break;
				case 2:
					actionnormal = new SpriteSheet("data/Kreatur/Wasser/instict/2/Normal.png", 100, 50);
					break;
				case 3:
					actionnormal = new SpriteSheet("data/Kreatur/Wasser/instict/3/Normal.png", 100, 50);
					break;
				}
				break;
			}
			break;
		case HERBA:
			switch(wert){
			case "Str":
				switch(i){
				case 1:
					actionnormal = new SpriteSheet("data/Kreatur/Land/strength/1/Normal.png", 100, 50);
					break;
				case 2:
					actionnormal = new SpriteSheet("data/Kreatur/Land/strength/2/Normal.png", 100, 50);
					break;
				case 3:
					actionnormal = new SpriteSheet("data/Kreatur/Land/strength/3/Normal.png", 100, 50);
					break;
				}
				break;
			case "Con":
				switch(i){
				case 1:
					actionnormal = new SpriteSheet("data/Kreatur/Land/constitution/1/Normal.png", 100, 50);
					break;
				case 2:
					actionnormal = new SpriteSheet("data/Kreatur/Land/constitution/2/Normal.png", 100, 50);
					break;
				case 3:
					actionnormal = new SpriteSheet("data/Kreatur/Land/constitution/3/Normal.png", 100, 50);
					break;
				}
				break;
			case "Spe":
				switch(i){
				case 1:
					actionnormal = new SpriteSheet("data/Kreatur/Land/speed/1/Normal.png", 100, 50);
					break;
				case 2:
					actionnormal = new SpriteSheet("data/Kreatur/Land/speed/2/Normal.png", 100, 50);
					break;
				case 3:
					actionnormal = new SpriteSheet("data/Kreatur/Land/speed/3/Normal.png", 100, 50);
					break;
				}
				break;
			case "Mov":
				switch(i){
				case 1:
					actionnormal = new SpriteSheet("data/Kreatur/Land/movment/1/Normal.png", 100, 50);
					break;
				case 2:
					actionnormal = new SpriteSheet("data/Kreatur/Land/movment/2/Normal.png", 100, 50);
					break;
				case 3:
					actionnormal = new SpriteSheet("data/Kreatur/Land/movment/3/Normal.png", 100, 50);
					break;
				}
				break;
			case "Ins":
				switch(i){
				case 1:
					actionnormal = new SpriteSheet("data/Kreatur/Land/instict/1/Normal.png", 100, 50);
					break;
				case 2:
					actionnormal = new SpriteSheet("data/Kreatur/Land/instict/2/Normal.png", 100, 50);
					break;
				case 3:
					actionnormal = new SpriteSheet("data/Kreatur/Land/instict/3/Normal.png", 100, 50);
					break;
				}
				break;
			}
			break;
		case LITUS:
			switch(wert){
			case "Str":
				switch(i){
				case 1:
					actionnormal = new SpriteSheet("data/Kreatur/Amphibisch/strength/1/Normal.png", 100, 50);
					//System.out.println("change");
					break;
				case 2:
					actionnormal = new SpriteSheet("data/Kreatur/Amphibisch/strength/2/Normal.png", 100, 50);
					break;
				case 3:
					actionnormal = new SpriteSheet("data/Kreatur/Amphibisch/strength/3/Normal.png", 100, 50);
					break;
				}
				break;
			case "Con":
				switch(i){
				case 1:
					actionnormal = new SpriteSheet("data/Kreatur/Amphibisch/constitution/1/Normal.png", 100, 50);
					break;
				case 2:
					actionnormal = new SpriteSheet("data/Kreatur/Amphibisch/constitution/2/Normal.png", 100, 50);
					break;
				case 3:
					actionnormal = new SpriteSheet("data/Kreatur/Amphibisch/constitution/3/Normal.png", 100, 50);
					break;
				}
				break;
			case "Spe":
				switch(i){
				case 1:
					actionnormal = new SpriteSheet("data/Kreatur/Amphibisch/speed/1/Normal.png", 100, 50);
					break;
				case 2:
					actionnormal = new SpriteSheet("data/Kreatur/Amphibisch/speed/2/Normal.png", 100, 50);
					break;
				case 3:
					actionnormal = new SpriteSheet("data/Kreatur/Amphibisch/speed/3/Normal.png", 100, 50);
					break;
				}
				break;
			case "Mov":
				switch(i){
				case 1:
					actionnormal = new SpriteSheet("data/Kreatur/Amphibisch/movment/1/Normal.png", 100, 50);
					break;
				case 2:
					actionnormal = new SpriteSheet("data/Kreatur/Amphibisch/movment/2/Normal.png", 100, 50);
					break;
				case 3:
					actionnormal = new SpriteSheet("data/Kreatur/Amphibisch/movment/3/Normal.png", 100, 50);
					break;
				}
				break;
			case "Ins":
				switch(i){
				case 1:
					actionnormal = new SpriteSheet("data/Kreatur/Amphibisch/instict/1/Normal.png", 100, 50);
					break;
				case 2:
					actionnormal = new SpriteSheet("data/Kreatur/Amphibisch/instict/2/Normal.png", 100, 50);
					break;
				case 3:
					actionnormal = new SpriteSheet("data/Kreatur/Amphibisch/instict/3/Normal.png", 100, 50);
					break;
				}
				break;
			}
			break;
		
		}
		norm = new Animation(actionnormal, 200);
		sprite = norm;
		
		return sprite;	
	}
	
}
