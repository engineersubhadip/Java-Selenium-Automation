package CaptureDate;

import java.text.SimpleDateFormat;
import java.util.Date;

public class HowToCaptureCurrentDateandTime {

	public static void main(String[] args) {
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
		Date dt = new Date();
		String currDateTime = df.format(dt);
		
		System.out.println(currDateTime);
	}

}
