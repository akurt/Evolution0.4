package game;

import main.PlayObject;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/*
 * GameState stellt einen eigenen State dar. Dies ist eine GUI in der
 * der menschliche Spieler seine Kreatur verwalten kann.
 */
public class GameMenu extends BasicGameState{
	private int p = 0, pp = 0;
	private int[] position = new int[5];
	private int[] pposition = new int[4];
	
	PlayObject ob = PlayObject.getInstance();
	
	@Override
	public void init(GameContainer container, StateBasedGame state) throws SlickException {
		position[0] =  100;
		position[1] = 120;
		position[2] = 140;
		position[3] = 160;
		position[4] = 180;
		
		pposition[0] = 300;
		pposition[1] = 500;
		pposition[2] = 700;
		pposition[3] = 900;

		ob.init(container);
	}

	@Override
	public void render(GameContainer container, StateBasedGame state, Graphics g) throws SlickException {
		if(ob.player.skillpoints > 0){g.setColor(Color.white);}else{g.setColor(Color.red);}
		
		g.drawString("Stärke:", 300, 100);
		g.drawString("Konstitution:", 300, 120);
		g.drawString("Geschwindigkeit:", 300, 140);
		g.drawString("Beweglichkeit:", 300, 160);
		g.drawString("Instikt:", 300, 180);

		g.drawString(Integer.toString(ob.player.strength), 450, 100);
		g.drawString(Integer.toString(ob.player.constitution), 450, 120);
		g.drawString(Integer.toString(ob.player.speed), 450, 140);
		g.drawString(Integer.toString(ob.player.movement), 450, 160);
		g.drawString(Integer.toString(ob.player.instinct), 450, 180);

		if(ob.player.strength > 15){
			g.drawString("Doppelbiss", 500, 100);
		}
		if(ob.player.strength > 35){
			g.drawString("Knochenbrecher", 700, 100);
		}
		if(ob.player.strength > 70){
			g.drawString("Blutrausch", 900, 100);
		}
		if(ob.player.constitution > 15){
			g.drawString("Bodycheck", 500, 120);
		}
		if(ob.player.constitution > 35){
			g.drawString("Bodyslam", 700, 120);
		}
		if(ob.player.constitution > 70){
			g.drawString("Einigeln", 900, 120);
		}
		if(ob.player.speed > 15){
			g.drawString("Rammen", 500, 140);
		}
		if(ob.player.speed > 35){
			g.drawString("Hornstoss", 700, 140);
		}
		if(ob.player.speed > 70){
			g.drawString("Stampede", 900, 140);
		}
		if(ob.player.movement > 15){
			g.drawString("Quetscher", 500, 160);
		}
		if(ob.player.movement > 35){
			g.drawString("Lynchen", 700, 160);
		}
		if(ob.player.movement > 70){
			g.drawString("Konter", 900, 160);
		}
		if(ob.player.instinct > 15){
			g.drawString("Schwachpunkt", 500, 180);
		}
		if(ob.player.instinct > 35){
			g.drawString("Kehlbiss", 700, 180);
		}
		if(ob.player.instinct > 70){
			g.drawString("Neckbruch", 900, 180);
		}

		g.drawRect(pposition[pp], position[p], 200, 17);
		
		g.setColor(Color.white);
		g.fillRect(0, 100, 275, 250);
		
		g.drawRect(300, 300, 200, 100);
		g.drawString("Aktive Abilities", 300, 300);
		g.drawString(ob.player.abilist[0], 300, 320);
		g.drawString(ob.player.abilist[1], 300, 340);
		g.drawString(ob.player.abilist[2], 300, 360);
		ob.player.renderPosition(container, g);
		g.setColor(Color.black);
		
		g.drawString("Lebenspunktep:", 10, 100);
		g.drawString("Hungerpunkte:", 10, 120);
		g.drawString("Attacke:", 10, 140);
		g.drawString("Verteidigung", 10, 160);
		g.drawString("Trefferchance", 10, 180);
		g.drawString("Ausweichen", 10, 200);
		
		g.drawString(Integer.toString(ob.player.getLebenspunkte()) + "/" + Integer.toString(ob.player.Maxlp), 150, 100);
		g.drawString(Integer.toString(ob.player.getStarvationpoints()) + "/" + Integer.toString(ob.player.Maxsp), 150, 120);
		g.drawString(Integer.toString(ob.player.dam), 150, 140);
		g.drawString(Integer.toString(ob.player.def), 150, 160);
		g.drawString(Integer.toString(ob.player.hit), 150, 180);
		g.drawString(Integer.toString(ob.player.agi), 150, 200);
		
		g.drawString("Level:", 10, 220);
		g.drawString("Skillpoints:", 10, 240);
		g.drawString("EP:", 10, 260);
		g.drawString("Bis zum nächsten Level:", 10, 280);
		
		g.drawString(Integer.toString(ob.player.level), 150, 220);
		g.drawString(Integer.toString(ob.player.skillpoints), 150, 240);
		g.drawString(Integer.toString(ob.player.exp), 150, 260);
		g.drawString(Integer.toString(ob.player.exprang), 150, 280);
	}

	@Override
	public void update(GameContainer container, StateBasedGame state, int delta) throws SlickException {
		ob.player.iMap();
		if (ob.input.isKeyPressed(Input.KEY_UP)) {
			if (p == 0) {
				p = 4;
			} else {
				p--;
			}
		} else if (ob.input.isKeyPressed(Input.KEY_DOWN)) {
			if (p == 4) {
				p = 0;
			} else {
				p++;
			}
		}else if(ob.input.isKeyPressed(Input.KEY_LEFT)){
			if(pp == 0){
				pp = 3;
			}else{
				pp--;
			}
			
		}else if(ob.input.isKeyPressed(Input.KEY_RIGHT)){
			if(pp == 3){
				pp = 0;
			}else{
				pp++;
			}
		}else if(ob.input.isKeyPressed(Input.KEY_ESCAPE)){
			state.enterState(5);
		}else if (ob.input.isKeyPressed(Input.KEY_ENTER)) {
			switch(pp){
			case 0:
				switch(p){
				case 0:
					if(ob.player.skillpoints > 0){
					ob.player.strength += 1;
					ob.player.skillpoints -= 1;
					ob.player.updateAttribute();
					}
					break;
				case 1:
					if(ob.player.skillpoints > 0){
					ob.player.constitution += 1;
					ob.player.skillpoints -= 1;
					ob.player.updateAttribute();
					}
					break;
				case 2:
					if(ob.player.skillpoints > 0){
					ob.player.speed += 1;
					ob.player.skillpoints -= 1;
					ob.player.updateAttribute();
					}
					break;
				case 3:
					if(ob.player.skillpoints > 0){
					ob.player.movement += 1;
					ob.player.skillpoints -= 1;
					ob.player.updateAttribute();
					}
					break;
				case 4:
					if(ob.player.skillpoints > 0){
					ob.player.instinct+= 1;
					ob.player.skillpoints -= 1;
					ob.player.updateAttribute();
					}
					break;
				}
				break;
			case 1:
				switch(p){
				case 0:
					if(ob.player.strength > 15){
						ob.player.abilist[0] = "Doppelbiss";
					}
					break;
				case 1:
					if(ob.player.constitution > 15){
						ob.player.abilist[0] = "Bodycheck";
					}
					break;
				case 2:
					if(ob.player.speed > 15){
						ob.player.abilist[0] = "Rammen";
					}
					break;
				case 3:
					if(ob.player.movement > 15){
						ob.player.abilist[0] = "Quetscher";
					}
					break;
				case 4:
					if(ob.player.instinct > 15){
						ob.player.abilist[0] = "Schwachpunkt";
					}
					break;
				}
				break;
			case 2:
				switch(p){
				case 0:
					if(ob.player.strength > 35){
						ob.player.abilist[1] = "Knochenbrecher";
					}
					break;
				case 1:
					if(ob.player.constitution > 35){
						ob.player.abilist[1] = "Bodyslam";
					}
					break;
				case 2:
					if(ob.player.speed > 35){
						ob.player.abilist[1] = "Hornstoss";
					}
					break;
				case 3:
					if(ob.player.movement > 35){
						ob.player.abilist[1] = "Lynchen";
					}
					break;
				case 4:
					if(ob.player.instinct > 35){
						ob.player.abilist[1] = "Kehlbiss";
					}
					break;
				}
				break;
			case 3:
				switch(p){
				case 0:
					if(ob.player.strength > 70){
						ob.player.abilist[2] = "Blutrausch";
					}
					break;
				case 1:
					if(ob.player.constitution > 70){
						ob.player.abilist[2] = "Einigeln";
					}
					break;
				case 2:
					if(ob.player.speed > 70){
						ob.player.abilist[2] = "Stampede";
					}
					break;
				case 3:
					if(ob.player.movement > 70){
						ob.player.abilist[2] = "Konter";
					}
					break;
				case 4:
					if(ob.player.instinct > 70){
						ob.player.abilist[2] = "Neckbruch";
					}
					break;
				}
				break;
			}
		}
	}

	@Override
	public int getID() {
		return 7;
	}

}
