package Actions;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ChildWindows {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		
		driver.findElement(By.xpath("//a[@class='blinkingText']")).click();
		
		Set<String> windowHandle =  driver.getWindowHandles(); // all window handles of the browser
		String currWindowHandle =  driver.getWindowHandle(); // get current window handle(of the Parent Window)
		
		for (String currEle : windowHandle) {
			if (currEle.equals(currWindowHandle)) {
				continue;
			}else {
				driver.switchTo().window(currEle); // swtiching to child window
				break;
			}
		}
		
//		Confirming we are inside the Child window by hovering over a dropdown
		
		Actions a = new Actions(driver);
		
		a.moveToElement(driver.findElement(By.xpath("//a[@class='dropdown-toggle']"))).build().perform();
		
//		Capturing the user Email :-
		
		String userEmail = driver.findElement(By.xpath("//a[contains(text(),'mentor')]")).getText();
		
		driver.close(); // closing the child window
		
//		driver.switchTo().window(currWindowHandle);
		
		Thread.sleep(3000);
		
		a.moveToElement(driver.findElement(By.xpath("//body"))).contextClick().build().perform();
		
		System.out.println("userEmail "+userEmail);
	}

}
