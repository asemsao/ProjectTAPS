package adins.ace.taps.module;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import adins.ace.taps.configuration.App;

public class GeneratePassword {
	private static final String ALPHA_CAPS  = App.getConfiguration("ALPHA_CAPS");
    private static final String ALPHA   = App.getConfiguration("ALPHA");
    private static final String NUM     = App.getConfiguration("NUM");
    
    public static char[] generatePswd() {
    	 int noOfCAPSAlpha = Integer.parseInt(App.getConfiguration("password_noOfCAPSAlpha"));
         int noOfDigits = Integer.parseInt(App.getConfiguration("password_noOfDigits"));
         int minLen = Integer.parseInt(App.getConfiguration("password_length"));
        if( (noOfCAPSAlpha + noOfDigits) > minLen )
            throw new IllegalArgumentException
            ("Min. Length should be atleast sum of (CAPS, DIGITS, SPL CHARS) Length!");
        Random rnd = new Random();
        int len = minLen;
        char[] pswd = new char[len];
        int index = 0;
        for (int i = 0; i < noOfCAPSAlpha; i++) {
            index = getNextIndex(rnd, len, pswd);
            pswd[index] = ALPHA_CAPS.charAt(rnd.nextInt(ALPHA_CAPS.length()));
        }
        for (int i = 0; i < noOfDigits; i++) {
            index = getNextIndex(rnd, len, pswd);
            pswd[index] = NUM.charAt(rnd.nextInt(NUM.length()));
        }
        for(int i = 0; i < len; i++) {
            if(pswd[i] == 0) {
                pswd[i] = ALPHA.charAt(rnd.nextInt(ALPHA.length()));
            }
        }
        return pswd;
    }
 
    private static int getNextIndex(Random rnd, int len, char[] pswd) {
        int index = rnd.nextInt(len);
        while(pswd[index = rnd.nextInt(len)] != 0);
        return index;
    }    
}
