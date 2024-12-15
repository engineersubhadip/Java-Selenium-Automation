package NewTab;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class Client {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		
//		1. Create a new Tab :-
		
		driver.switchTo().newWindow(WindowType.TAB); // by doing so, the browser will be switched and the control also will be there 
		
//		2. Hit the new URL :-
		
		driver.get("https://www.amazon.com/"); // currently the driver is focused here
	}

}
