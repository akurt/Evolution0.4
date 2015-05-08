package main;

import java.util.ArrayList;
import java.util.Collections;

import fight.FightMap;
import fight.FightState;
import game.AI;
import game.GameControl;
import map.Gebirge;
import map.Map;
import map.Meer;
import map.Savanne;
import map.Strand;
import map.Sumpf;
import map.Wald;
import map.Wiese;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

import player.Enemy;
import player.Kreatur;
import player.Player;
import player.Species;
import resources.Fisch;
import resources.Fleisch;
import resources.Fruechte;
import resources.Getreide;
import resources.Resources;
import resources.Ressourcen;

/*
 * In dieser Klasse werden die Objekte initialisiert die überall zur Verfügung stehen müssen
 */
public class PlayObject {

	private static PlayObject instance = null;
	
	public PlayObject() {
		
	}
	
	public static PlayObject getInstance() {
		if (instance == null) {
			instance = new PlayObject();
		}
		return instance;
	}
	
	public int counter = 0;
	
	public ArrayList<Kreatur> kreall;
	public ArrayList<Enemy> enemall;
	public ArrayList<Ressourcen> nahrung;
	
	public Input input;
	
	public Gebirge gebirge;
	public Meer meer;
	public Savanne savanne;
	public Strand strand;
	public Sumpf sumpf;
	public Wald wald;
	public Wiese wiese;
	
	public Fisch fisch0;
	public Fleisch fleisch0;
	public Fruechte fruechte0;
	public Getreide getreide0;
	
	public Map map;
	
	public Player player;
	
	public Enemy aqua;
	public Enemy terra;
	
	public AI ai;
	public GameControl gamecontrol;
	
	public FightMap fight;
	public FightState fstate;
	
	public void init (GameContainer container) throws SlickException {
		
		gebirge = new Gebirge();
		meer = new Meer();
		savanne = new Savanne();
		strand = new Strand();
		sumpf = new Sumpf();
		wald = new Wald();
		wiese = new Wiese();
		
		map = new Map(meer, savanne, sumpf, wiese, gebirge, strand, wald);
		
		fisch0 = new Fisch(0, 80, Resources.FISCH, 0);
		fleisch0 = new Fleisch(200, 80, Resources.FLEISCH, 0);
		fruechte0 = new Fruechte(300, 80, Resources.FRUECHTE, 0);
		getreide0 = new Getreide(400, 80, Resources.GETREIDE, 0);
		
		player = new Player(0, 0, 3, false, false, Species.LITUS, true, 10, 10, 10, 10, 10);
		aqua = new Enemy(0, 120, 3, false, false, Species.AQUA, false,  10, 15, 25, 15, 5, "Doppelbiss", "Knochenbrecher", "---");
		terra = new Enemy(60, 120, 3, false, false, Species.HERBA, false,  15, 25, 15, 15, 5,"---", "---", "---");
		
		kreall = new ArrayList<>();
		Collections.addAll(kreall, player, aqua, terra);
		enemall = new ArrayList<>();
		Collections.addAll(enemall, aqua, terra);
		nahrung = new ArrayList<>();
		Collections.addAll(nahrung, fleisch0, fisch0, fruechte0, getreide0);
		
		fisch0.init(container);
		fleisch0.init(container);
		fruechte0.init(container);
		getreide0.init(container);
		
		player.init(container);
		aqua.init(container);
		terra.init(container);
		
		ai = new AI(map);
		gamecontrol = new GameControl();
		
		fight = new FightMap();
		fstate = new FightState();
		
	}
	
	
	// für was?
	public static  void SetBack(){
		instance = null;
		
	}
	
}
