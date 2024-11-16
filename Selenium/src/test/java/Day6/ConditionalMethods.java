package Day6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ConditionalMethods {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/register");
		driver.manage().window().maximize();
		
		Thread.sleep(5000);
		
//		isDisplayed() :- Returns if the WebElement is displayed/not
		boolean logoStatus = driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']")).isDisplayed();
		System.out.println("Logo Display Status : "+logoStatus);
		
//		isEnabled() :- Check if a particular WebElement(i/p box, dropdown, radio btn, check box NOT Static Element) enabled or not ?
		boolean searchStoreStatus = driver.findElement(By.xpath("//form[@id = 'small-search-box-form']/child::input")).isEnabled();
		System.out.println("Is Input Box Enabled ? "+searchStoreStatus);

		//		Subpart :- if the 'searchStoreStatus' is enabled we should type 'toffee'
		if (searchStoreStatus) {
			driver.findElement(By.xpath("//form[@id = 'small-search-box-form']/child::input")).sendKeys("toffee");
		}
		
		
//		Capture the Register Heading :-
		String registerHeading = driver.findElement(By.xpath("//div[@class='page-title']/child::h1")).getText();
		System.out.println("Register heading is : "+registerHeading);
		
//		isSelected() :- Check whether the WebElement is selected or not
		boolean maleRadioBtnStatus = driver.findElement(By.xpath("//span[@class='male']/child::input[@id='gender-male']")).isSelected();
		boolean femaleRadiobtnStatus = driver.findElement(By.xpath("//span[@class='female']/child::input[@id='gender-female']")).isSelected();
		
		System.out.println("Is male radio button selected ? "+maleRadioBtnStatus);
		System.out.println("Is female radio button selected ? "+femaleRadiobtnStatus);
		
//		We will now click on the male radio button and again check the status :-
		driver.findElement(By.xpath("//span[@class='male']/child::input[@id='gender-male']")).click();
		boolean updatedMaleRadioBtn = driver.findElement(By.xpath("//span[@class='male']/child::input[@id='gender-male']")).isSelected();
		boolean updatedFemaleRadioBtn = driver.findElement(By.xpath("//span[@class='female']/child::input[@id='gender-female']")).isSelected();
		
		System.out.println("Updated male radio button selected status : "+ updatedMaleRadioBtn);
		System.out.println("Updated female radio button selected status : "+ updatedFemaleRadioBtn);
		
//		For CheckBox ;-
		boolean newsLetterStatus = driver.findElement(By.xpath("//div[@class='inputs']/child::input[@id='Newsletter']")).isSelected();
		System.out.println("Are you opting for newsletter ? "+newsLetterStatus);
		
		
		driver.quit();
	}

}
