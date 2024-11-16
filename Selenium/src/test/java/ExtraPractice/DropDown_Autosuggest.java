package ExtraPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DropDown_Autosuggest {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//span[@class='commonModal__close']")).click();
		
		Thread.sleep(1200);
		
		driver.findElement(By.xpath("//input[@id='fromCity']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[contains(@class,'searchCity')] //input[contains(@class,'react-autosuggest__input--open')]")).sendKeys("Lon");
		Thread.sleep(1500);
		
		List<WebElement> departureCityList =  driver.findElements(By.xpath("//li[@class='react-autosuggest__suggestion']"));
		
		for (int i=0; i<departureCityList.size(); i++) {
			WebElement currCity = departureCityList.get(i);
			if (currCity.getText().contains("Gatwick")) {
				currCity.click();
				break;
			}
		}
		
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//input[@id='toCity']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[contains(@class,'searchToCity')] //input[contains(@class,'react-autosuggest__input--open')]")).sendKeys("Ber");
		Thread.sleep(1500);
		
		List<WebElement> arrivalCityList =  driver.findElements(By.xpath("//li[@class='react-autosuggest__suggestion']"));
		
		for (int i=0; i<arrivalCityList.size(); i++) {
			WebElement currCity = arrivalCityList.get(i);
			if (currCity.getText().contains("Schonefeld")) {
				currCity.click();
				break;
			}
		}
		
	}

}
