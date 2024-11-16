package Day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CSSLocators {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demo.opencart.com/");
		
		driver.manage().window().maximize(); // maximize the browser window
		
//		tag.className
		
//		driver.findElement(By.cssSelector("input.form-control-lg")).sendKeys("Laptop"); // entering "Laptop" in the search box
		
//		tag[attribute='value']
		
//		driver.findElement(By.cssSelector("input[name='search']")).sendKeys("Bags");
		
//		tag.className[attribute='value']
		
		driver.findElement(By.cssSelector("input.form-control[name='search']")).sendKeys("Toffee");
		
		driver.findElement(By.cssSelector(".btn.btn-lg.btn-inverse.btn-block.dropdown-toggle")).click(); // via Selector Hub
	}

}
