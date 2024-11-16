package Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsDemo {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/?tag=googmantxtmob170-21&ascsubtag=_k_Cj0KCQjw7Py4BhCbARIsAMMx-_LG-WM16e5Z2hjnX2RKjSb0VRnyLIsF9hu7LACH6SE7aJL45d1bHHkaAsqXEALw_wcB_k_");
		
//		Requirement is to hover our mouse over the Hello&Sign-in button to get the dropdown :-
		
		Actions a = new Actions(driver);
		
		a.moveToElement(driver.findElement(By.xpath("//a[@id='nav-link-accountList']"))).build().perform(); // .build() means the step is ready to execute but wont execute, unless you invoke .perform()
		
//		Enter Capital Letter word inside search Box :-
		
//		a.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("school bag").build().perform();
	
//		Double Click on the text entered in the text Box :-
		
		a.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("school bag").doubleClick().build().perform();
	
//		After I hover our mouse over the Hello&Sign-in button I want to right Click :-
		
		a.moveToElement(driver.findElement(By.xpath("//a[@id='nav-link-accountList']"))).contextClick().build().perform();
		
	
	}

}
