package game;

import java.util.Random;

/*
 * Unterst�tzt die Spielsteuerung. Die Methode zufall gibt eine Zahl zur�ck,
 * die zwischen den beiden als Parametern �bergebenen Integer-Werten liegt.
 */
public class Zufall {

	private static final Random RANDOM = new Random(System.currentTimeMillis());;

	  public static int zufall(int min, int max)
	  {
	    return Math.abs(RANDOM.nextInt() % (max + 1 - min)) + min;
	  }
	
}
