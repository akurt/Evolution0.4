package game;

import java.util.Random;

/*
 * Unterstützt die Spielsteuerung. Die Methode zufall gibt eine Zahl zurück,
 * die zwischen den beiden als Parametern übergebenen Integer-Werten liegt.
 */
public class Zufall {

	private static final Random RANDOM = new Random(System.currentTimeMillis());;

	  public static int zufall(int min, int max)
	  {
	    return Math.abs(RANDOM.nextInt() % (max + 1 - min)) + min;
	  }
	
}
