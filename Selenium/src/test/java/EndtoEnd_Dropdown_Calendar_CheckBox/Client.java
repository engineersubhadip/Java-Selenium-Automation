package EndtoEnd_Dropdown_Calendar_CheckBox;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Client {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/#");
		driver.manage().window().maximize();
		Thread.sleep(1500);
		
//		Selecting City from Departure Dropdown :- (Correct)
			
		WebElement departure = driver.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_originStation1_CTXT']"));
		departure.click();
		
		Thread.sleep(1500);
		
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_originStation1_CTNR']  //a[@text='Delhi (DEL)']")).click();
		
		
//		Selecting Arrival City :- (Correct)
		
		Thread.sleep(1500);
		
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@text='Chennai (MAA)']")).click();
		
		
//		Selecting current date :- (Correct)
		
		Thread.sleep(1500);
		
		driver.findElement(By.xpath("//td[contains(@class,'ui-datepicker-today')]")).click();
		
//		Selecting the Friends and Family CheckBox :- (Correct)
		
		Thread.sleep(1500);
		
		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_chk_friendsandfamily']")).click();
		
		
//		Selecting Passenger count dropdown :-
		
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//div[@id='divpaxinfo']")).click();
		
		
//		Adult Plus button :- (Correct)
		
		
		Thread.sleep(1200);
		
		WebElement plusBtn = driver.findElement(By.xpath("//span[@id='hrefIncAdt']"));
		
		for (int i=0; i<2; i++) { // clicking on 2 more adults
			Thread.sleep(750);
			plusBtn.click();
		}
		
		Thread.sleep(750);
		
		driver.findElement(By.xpath("//span[@id='hrefIncChd']")).click();
		
		driver.findElement(By.xpath("//input[@id='btnclosepaxoption']")).click(); // clicking on Done button
		
		
//		Validating return date is disabled via UI :-
		
		String stylePart =  driver.findElement(By.xpath("//div[@id='Div1' and @class='picker-second']")).getAttribute("style");
		
		String opacity[] = stylePart.split(" ");
		
		String opVal = opacity[opacity.length-1];
		
		if (opVal.contains("0.5")) {
			System.out.println("Disabled");
			Assert.assertTrue(true);
		} else {
			System.out.println("Enabled");
			Assert.assertTrue(false);
		}
		
//		Clicking on Search Button :-
		
		driver.findElement(By.xpath("//input[@name='ctl00$mainContent$btn_FindFlights' and @type='submit']")).click();
		
	}

}
