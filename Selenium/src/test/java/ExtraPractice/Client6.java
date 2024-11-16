package ExtraPractice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Client6 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/?tag=googmantxtmob170-21&ascsubtag=_k_Cj0KCQjw7Py4BhCbARIsAMMx-_LG-WM16e5Z2hjnX2RKjSb0VRnyLIsF9hu7LACH6SE7aJL45d1bHHkaAsqXEALw_wcB_k_");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		Actions a = new Actions(driver);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='twotabsearchtextbox']")));
		
		a.moveToElement(driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"))).click().build().perform();
		
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Toff");
		
//		driver.findElement(By.xpath("//div[@id='nav-flyout-searchAjax']"));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='nav-flyout-searchAjax']/child::div[@class='autocomplete-results-container'] //div[@class='s-suggestion-container']")));
		
//		Thread.sleep(2000);
		
		List<WebElement> suggestion = driver.findElements(By.xpath("//div[@id='nav-flyout-searchAjax']/child::div[@class='autocomplete-results-container'] //div[@class='s-suggestion-container']"));
		
		System.out.println(suggestion.size());
		
		for (WebElement currEle : suggestion) {
			if (currEle.getText().contains("tiffin box")) {
				System.out.println("Inside This");
				currEle.click();
				break;
			}
		}
		
		Thread.sleep(2000);
		
		driver.close();
	}

}
