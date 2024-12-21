package utilities;

public class GenerateRandomString {
	
	public static String getString() {
		
		String result = "";
		for (int i=0; i<8; i++) {
			int currASCII = 97 + (int)(Math.random() * (122-97 + 1));
			char currChar = (char)currASCII;
			result += currChar;
		}
		
		return result;
	}
	
	public static String getNumberString() {
		
		String result = "";
		for (int i=0; i<10; i++) {
			int currASCII = 48 + (int)(Math.random() * (57-48 + 1));
			char currChar = (char)currASCII;
			result += currChar;
		}
		
		return result;
	}

	public static String getAlphanumeric() {
		String result = getString() + getNumberString();
		return result;
	}
}
