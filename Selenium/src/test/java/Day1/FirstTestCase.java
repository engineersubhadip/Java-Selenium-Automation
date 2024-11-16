package Day1;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;

/*
 1) Launch browser (chrome)
2) Open URL  https://demo.opencart.com/
3) Validate title should be "Your Store"
"
4) close page
 */

public class FirstTestCase {

	public static void main(String[] args) {
//		1. Launch Chrome Browser :-
		
//		Approach 1 :-
//		ChromeDriver driver = new ChromeDriver();
		
//		Approach 2 :- (Best Approach)
		WebDriver driver = new ChromeDriver();
//		This is the best approach since inside, driver object we can plug-in multiple objects
		
//		2. Open URL :-
		
		driver.get("https://demo.opencart.com/");

		
//		3. Capture title of WebPage :-
		
		String webPageTitle = driver.getTitle();
		
		if (webPageTitle.equals("Your Store") == true) {
			System.out.println("Test Passed");
		} else  {
			System.out.println("Test Failed");
		}
		
//		4. Closing the browser :-
		
		driver.quit();
	}

}
