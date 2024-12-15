package NewTab;

/*
 * The parent window handle is the one which you get, when we first do driver.get().
 * Lets say even if we open new tabs using .switchTo() and then capture the window handles {The driver focus will be here due to switchTo()}
 * The parent window {index->0} is still at the one which we got when we first did driver.get().
 */

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
