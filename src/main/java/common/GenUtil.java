package common;
/**
 * 
 */

/**
 * @author nitinthite
 *
 */
public class GenUtil {
	
	public static class Randomizer {
	    public static int generate(int min,int max) {
	        return min + (int)(Math.random() * ((max - min) + 1));
	    }
	}

}
