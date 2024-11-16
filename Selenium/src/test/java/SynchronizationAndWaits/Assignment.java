package SynchronizationAndWaits;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Assignment {
	
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		
		String credentials[] = grabCredential(driver);
		String userName = credentials[0];
		String passWord = credentials[1];
		
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(userName); // filling out the userName
		
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(passWord); // filling out the passWord
		
		driver.findElement(By.xpath("//div[@class='form-check-inline']/label[2]/span[2]")).click(); // click on User Radio Button
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='modal-content']/div[contains(@class,'modal-footer')]/button[@id='okayBtn']")));
		
		driver.findElement(By.xpath("//div[@class='modal-content']/div[contains(@class,'modal-footer')]/button[@id='okayBtn']")).click(); // Click on "Okay" in Pop-up
		
		Select selectDropDown = new Select(driver.findElement(By.xpath("//select[@class='form-control']")));
		
		selectDropDown.selectByValue("consult"); // selecting "Consultant from DropDown"
		
		driver.findElement(By.xpath("//input[@id='terms']")).click(); // Clicking on CheckBox
		
		driver.findElement(By.xpath("//input[@id='signInBtn']")).click(); // Clicking on Sign-in Button
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='card-footer']/button")));
		
		List<WebElement> productList =  driver.findElements(By.xpath("//div[@class='card-footer']/button")); // capturing all the "Add" button
		
		addProductToList(productList); // Add items to shopping Cart
		
		String productHeadingHomePage[] = captureProductNameHomePage(driver); // captured Product Heading on the HomePage
		
		driver.findElement(By.xpath("//a[contains(text(),'Checkout')]")).click(); // Clicking on Checkout Button
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='media-body']/h4")));
		
		String productHeadingCheckOutPage[] = captureProductNameCheckOutPage(driver); // captured Product Heading on the CheckOutPage
		
//		We are checking if the items we added on the HomePage are present on the CheckOutPage
		
		boolean checkOutStatus = confirmCheckOut(productHeadingHomePage, productHeadingCheckOutPage);
		
		if (checkOutStatus) {
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
		}
		
		driver.close();
	}
	
	static String[] grabCredential(WebDriver driver) {
		String string = driver.findElement(By.xpath("//form[@id='login-form']/child::div[7]")).getText();
		String updatedString[] = string.split(" ");
		String userName = updatedString[2];
		String passWord = updatedString[updatedString.length-1];
		
		String updatedPassword = "";
		
		for (int i=0; i<passWord.length(); i++) {
			char currChar = passWord.charAt(i);
			int currASCII = (int)currChar;
			
			if ((currASCII >= 65 && currChar <= 90) || (currChar >= 97 && currChar <= 122)) { 
				updatedPassword += currChar;
			}
		}
		
		String ans[] = {userName,updatedPassword};
		return ans;
	}
	
	static void addProductToList(List<WebElement> productList) {
		
		for (WebElement currEle : productList) {
			currEle.click();
		}
	}
	
	static String[] captureProductNameHomePage(WebDriver driver) {
		
		List<WebElement> product =  driver.findElements(By.xpath("//h4[@class='card-title']"));
		
		ArrayList<String> productHeading = new ArrayList<>();
		
		for (WebElement currEle : product) {
			String currEleHeading = currEle.getText();
			productHeading.add(currEleHeading);
		}
		
		String productList[] = new String[productHeading.size()];
		
		for (int i=0; i<productHeading.size(); i++) {
			productList[i] = productHeading.get(i);
		}
		
		return productList;
	}

	static String[] captureProductNameCheckOutPage(WebDriver driver) {
		
		List<WebElement> productListCheckOut =  driver.findElements(By.xpath("//div[@class='media-body']/h4"));
		
		ArrayList<String> productHeading = new ArrayList<>();
		
		
		for (WebElement currEle : productListCheckOut) {
			String currEleHeading = currEle.getText();
			productHeading.add(currEleHeading);
		}
		
		String ans[] = new String[productHeading.size()];
		
		for (int i=0; i<productHeading.size(); i++) {
			ans[i] = productHeading.get(i);
		}
		
		return ans;
	}

	static boolean confirmCheckOut(String[] productHeadingHomePage, String[] productHeadingCheckOutPage) {
		
		if (productHeadingHomePage.length != productHeadingCheckOutPage.length) {
			return false;
		}
		
		HashSet<String> checkOutPageHeading = new HashSet<>();
		
		for (int i=0; i<productHeadingCheckOutPage.length; i++) {
			checkOutPageHeading.add(productHeadingCheckOutPage[i]);
		}
		
		for (int i=0; i<productHeadingHomePage.length; i++) {
			String currEleHeading = productHeadingHomePage[i];
			
			if (checkOutPageHeading.contains(currEleHeading)) {
				continue;
			}else {
				return false;
			}
			
		}
		
		return true;
	}

}
