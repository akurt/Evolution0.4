package fight;

import main.PlayObject;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import player.Enemy;
import player.Kreatur;

/*
 * Diese Klasse ist für die Darstellung der Kampfoberfläche zuständig
 * Hier werden auch die Tastatureingaben des Spielers während des
 * Kampfes abgefangen
 */
public class FightState extends BasicGameState{
	
	private FightControl fightcontrol;
	
	private boolean playerMove = false;
	private boolean firstMove = true;
	
	private Input input;
	
	private int  a = 0;
	private int[] position = {440, 480, 520, 560};
	
	PlayObject ob = PlayObject.getInstance();
	
	@Override
	public void init(GameContainer container, StateBasedGame state) throws SlickException {
		ob.init(container);
		fightcontrol = new FightControl();
	}

	@Override
	public void render(GameContainer container, StateBasedGame state, Graphics g) throws SlickException {
		//ob.fight.zeichnenFight();
		ob.fight.zeichnenFight(ob.map.getHabitat(ob.player.getPosX(), ob.player.getPosY()));
		
		ob.player.render(g);
		//ob.kreall.get(0).render(g);
		
		if (ob.player.isStartFight()) {
			//ob.player.render(g);
			g.drawString(Integer.toString(ob.player.getLebenspunkte()), 20, 400);
			g.fillRect(50, 400, ob.player.getLebenspunkte(), 10);
			g.drawString("Angriff", 20, position[0]);
			g.drawString(ob.player.abilist[0], 20, position[1]);
			g.drawString(ob.player.abilist[1], 20, position[2]);
			g.drawString(ob.player.abilist[2], 20, position[3]);
			g.drawRect(15, position[a], 150, 17);
		} else {
			//ob.player.render(g);
			g.drawString(Integer.toString(ob.player.getLebenspunkte()), 520, 400);
			g.fillRect(550, 400, ob.player.getLebenspunkte(), 10);
			g.drawString("Angriff", 520, position[0]);
			g.drawString(ob.player.abilist[0], 520, position[1]);
			g.drawString(ob.player.abilist[1], 520, position[2]);
			g.drawString(ob.player.abilist[2], 520, position[3]);
			g.drawRect(515, position[a], 150, 17);
		}
		
		/*
		 * Stellt Enemy dar
		 */
		for (Enemy e: ob.enemall) {
			if (e.isHasFight()) {
				e.render(g);
				/*
				 * Figur links
				 */
				if (e.isStartFight()) {
					g.drawString(Integer.toString(e.getLebenspunkte()), 20, 400);
					g.fillRect(50, 400, e.getLebenspunkte(), 10);
					
					if (ob.player.instinct >= 20) {
						g.drawString(Integer.toString(e.getLebenspunkte())+"/"+Integer.toString(e.Maxlp), 20, 420);
						g.drawString(Integer.toString(e.getStarvationpoints())+"/"+Integer.toString(e.Maxsp), 20, 440);
						
						if (ob.player.instinct >= 50) {
							g.drawString("Angriff", 80, position[0]);
							g.drawString(e.abilist[0], 80, 460);
							g.drawString(e.abilist[1], 80, 480);
							g.drawString(e.abilist[2], 80, 500);
							
							if (ob.player.instinct >= 75) {
								g.drawString("Str:" + Integer.toString(e.strength), 220, 430);
								g.drawString("Con:" + Integer.toString(e.constitution), 220, 450);
								g.drawString("Spe:" + Integer.toString(e.speed), 220, 470);
								g.drawString("Mov:" + Integer.toString(e.movement), 220, 490);
								g.drawString("Ins:" + Integer.toString(e.instinct), 220, 510);
							}
						}
					}
					/*
					 * Figur rechts
					 */
				} else {
					g.drawString(Integer.toString(e.getLebenspunkte()), 520, 400);
					g.fillRect(550, 400, e.getLebenspunkte(), 10);
					
					if (ob.player.instinct >= 20) {
						g.drawString(Integer.toString(e.getLebenspunkte())+"/"+Integer.toString(e.Maxlp), 520, 420);
						g.drawString(Integer.toString(e.getStarvationpoints())+"/"+Integer.toString(e.Maxsp), 520, 440);
						
						if (ob.player.instinct >= 50) {
							g.drawString("Angriff", 580, position[0]);
							g.drawString(e.abilist[0], 580, 460);
							g.drawString(e.abilist[1], 580, 480);
							g.drawString(e.abilist[2], 580, 500);
							
							if (ob.player.instinct >= 75) {
								g.drawString("Str:" + Integer.toString(e.strength), 720, 430);
								g.drawString("Con:" + Integer.toString(e.constitution), 720, 450);
								g.drawString("Spe:" + Integer.toString(e.speed), 720, 470);
								g.drawString("Mov:" + Integer.toString(e.movement), 720, 490);
								g.drawString("Ins:" + Integer.toString(e.instinct), 720, 510);
							}
						}
					}	
				}	
			}	
		}
	}

	@Override
	public void update(GameContainer container, StateBasedGame state, int delta) throws SlickException {
		input = container.getInput();
		
		for (Kreatur kr: ob.kreall) {
			if (kr.getLebenspunkte() <= 0 && kr.isHasFight()) {
				ob.gamecontrol.setFight(false);
				state.enterState(5);
			}
		}
		
		/*
		 * Zug Spieler
		 */
		if (ob.player.isStartFight() && firstMove) {
			playerMove = true;
			firstMove = false;
		}
		
		if (playerMove) {
			if(input.isKeyPressed(Input.KEY_UP)){
				if (a == 0) {
					a = 3;
				} else {
					a--;
				}
			} else if (input.isKeyPressed(Input.KEY_DOWN)) {
				if (a == 3) {
					a = 0;
				} else {
					a++;
				}
			} else if (input.isKeyPressed(Input.KEY_ENTER)) {	
				for (Enemy en: ob.enemall) {
					if (en.isHasFight()) {
						fightcontrol.befehl(en, a);
					}
				}
				playerMove = false;
			}
		} else {
			/*
			 * Zug Gegner
			 */
			for(Enemy en : ob.enemall){
				if(en.isHasFight()){
					if((en.getLebenspunkte() *100 / en.Maxlp) < 75){
						fightcontrol.befEn(en, 1);
					}else{
						fightcontrol.befEn(en,  0);
					}
				}
			}
			playerMove = true;
			
		}
		
	}

	@Override
	public int getID() {
		return 6;
	}
	
}
