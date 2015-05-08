package resources;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

import player.Species;

/*
 * Ressourcen enthält die Attribute die von den Nahrungsressourcen verwendet werden.
 * Die Klassen Fisch, Fleisch, Fruechte, Getreide sind von ihr abgeleitet
 */
public class Ressourcen {

	protected int posRX, posRY;
	protected Resources resource;
	protected int nahrung;
	protected Image rImage;
	protected int id;
	public int nr;
	
	public Ressourcen(int posRX, int posRY, Resources res , int id) {
		this.posRX = posRX;
		this.posRY = posRY;
		this.resource = res;
		this.id = id;
	}
	
	public void render(Graphics g) {
		rImage.draw(this.getPosRX(), this.getPosRY(), 20, 20);
	}
	
	public int getPosRX() {
		return posRX;
	}
	
	public void setPosRX(int posRX) {
		this.posRX = posRX;
	}
	
	public int getPosRY() {
		return posRY;
	}
	
	public void setPosRY(int posRY) {
		this.posRY = posRY;
	}
	
	public Resources getResource() {
		return resource;
	}
	
	public void setResource(Resources resource) {
		this.resource = resource;
	}
	public int getID(){
		return id;
	}
	
	public int getNR(){
		return nr;
	}
	
	/*
	 * Gibt Nahrungspunkte an spezifische Spezies zurück
	 */
	public int getLP(Species s){
		int nahrung = 0;
		switch(resource){
		case FISCH:
			switch (s) {
			case AQUA:
				nahrung = 10;
				break;

			case HERBA:
				nahrung = 0;
				break;
			case LITUS:
				nahrung = 5;
				break;
			default:
				nahrung =5;
				break;
			}
			break;
		case FLEISCH:
			switch (s) {
			case AQUA:
				nahrung = 10;
				break;
			case HERBA:
				nahrung = 0;
				break;
			case LITUS:
				nahrung = 5;
				break;
			default:
				nahrung = 5;
				break;
			}
			break;
		case FRUECHTE:
			switch (s) {
			case AQUA:
				nahrung = 0;
				break;

			case HERBA:
				nahrung = 10;
				break;
			case LITUS:
				nahrung = 5;
				break;
			default:
				nahrung = 5;
				break;
			}
			break;
		case GETREIDE:
			switch (s) {
			case AQUA:
				nahrung = 0;
				break;

			case HERBA:
				nahrung = 10;
				break;
			case LITUS:
				nahrung = 5;
				break;
			default:
				nahrung = 5;
				break;
			}
			break;
		default:
			switch (s) {
			case AQUA:
				nahrung = 5;
				break;

			case HERBA:
				nahrung = 5;
				break;
			case LITUS:
				nahrung = 5;
				break;
			default:
				nahrung = 5;
				break;
			}
			break;
		}
		return nahrung;
	}
}