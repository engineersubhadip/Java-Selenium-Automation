package JavascriptExecutor;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().setSize(new Dimension(1440,900));
		driver.manage().window().maximize();
		
		driver.get("https://testautomationpractice.blogspot.com/");
		
//		SendKeys via JavascriptExecutor :-
		
		WebElement name = driver.findElement(By.xpath("//input[@id='name']"));
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		js.executeScript("arguments[0].setAttribute('value','Subhadip')", name);
		
//		Click via JavascriptExecutor :-
		
		WebElement male = driver.findElement(By.id("male"));
		
		js.executeScript("arguments[0].click()", male);
		
		/*
//		Scrolling the Page :-
		
		js.executeScript("window.scrollTo(0,1400)");
		System.out.println(js.executeScript("return window.pageYOffset")); // to print 1400
		*/
		
//		Scroll upto a particular Element :-
//		1. Capture which element you want to scroll to :-
		WebElement targetEle = driver.findElement(By.xpath("//h2[text()='Upload Files']"));
		js.executeScript("arguments[0].scrollIntoView()",targetEle);
		System.out.println(js.executeScript("return window.pageYOffset"));
		
//		2. Scroll till the bottom of the Page :-
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		System.out.println(js.executeScript("return window.pageYOffset"));
	}

}
