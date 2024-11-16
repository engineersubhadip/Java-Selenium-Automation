package Day5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XPathAxes {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.opencart.com/");
		driver.manage().window().maximize();
		
//		In the current view, count the number of products whose price > 120
		
		int count = driver.findElements(By.xpath("//span[@class='price-new' and number(substring-after(.,'$')) > 120]")).size();
		System.out.println("Total Element Count : "+count);
	}

}
