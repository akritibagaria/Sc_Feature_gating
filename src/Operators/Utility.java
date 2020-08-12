package Operators;

import java.util.regex.Pattern;

public class Utility {
    
	public static boolean isNumeric(String strNum) {
	    Pattern numericPattern = Pattern.compile("-?\\d+(\\.\\d+)?");
	    if (strNum == null) {
	        return false; 
	    }
	    return numericPattern.matcher(strNum).matches();
	}
}
