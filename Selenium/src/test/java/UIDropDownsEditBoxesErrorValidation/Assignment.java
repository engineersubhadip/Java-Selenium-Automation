package UIDropDownsEditBoxesErrorValidation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.manage().window().maximize();
		
		Thread.sleep(1200);
		
//		1. Filling out Name :-
		
		WebElement nameField = driver.findElement(By.xpath("//input[contains(@class,'form-control ng-untouched') and @name='name']"));
		nameField.click();
		nameField.sendKeys("Rituparna");
		
//		2. Filling out Email :-
		
		Thread.sleep(1200);
		
		WebElement emailField = driver.findElement(By.xpath("//input[contains(@class,'form-control ng-untouched') and @name='email']"));
		emailField.click();
		emailField.sendKeys("dasnandita56@gmail.com");
		
//		3. Filling out password :-
		
		Thread.sleep(1200);
		
		WebElement passwordField = driver.findElement(By.xpath("//input[@id='exampleInputPassword1']"));
		passwordField.click();
		passwordField.sendKeys("25121990");
		
//		4. Clicking the checkbox :-
		
		Thread.sleep(1200);
		
		driver.findElement(By.id("exampleCheck1")).click();
		
//		5. Select Gender dropdown :-
		
		Thread.sleep(1200);
		
		
		Select genderDropDown = new Select(driver.findElement(By.id("exampleFormControlSelect1")));
		
		genderDropDown.selectByIndex(1);
		
//		6. Select Student Radio Button :-
		
		Thread.sleep(1200);
		
		driver.findElement(By.id("inlineRadio1")).click();
		
//		Check Entrepreneur Option is disabled :-
		
		Thread.sleep(1200);
		
		boolean entrpreneurBtnStatus = driver.findElement(By.xpath("//input[@id='inlineRadio3']")).isEnabled();
		
		System.out.println("Is it enabled ? "+entrpreneurBtnStatus);
		
//		7. Select date from Calendar :-
		
		Thread.sleep(1200);
		
		WebElement dob = driver.findElement(By.xpath("//input[@name='bday']"));
		dob.click();
		Thread.sleep(500);
		dob.sendKeys("5");
		Thread.sleep(500);
		dob.sendKeys("12");
		Thread.sleep(500);
		dob.sendKeys("1990");
		
//		8. Clicking the Submit button :-
		
		Thread.sleep(1200);
		
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
//		Capturing the Success Message :-
		
		Thread.sleep(1200);
		
		String message =  driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).getText();
		
		System.out.println(message);
	}

}
