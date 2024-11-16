package Miscellaneous;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SSL_Check {

	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
		
//		Handle SSL Alerts :-
		options.setAcceptInsecureCerts(true);
		
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://expired.badssl.com/");
		System.out.println(driver.getTitle());
		
	}

}
