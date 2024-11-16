package Calender;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Calender2 {
	
	
	static void selectUserDate(WebDriver driver,String month, String date, String tarYear) {
		
		HashMap<String, String> hashMap = new HashMap<>();
		
		hashMap.put("1","January");
		hashMap.put("2","February");
		hashMap.put("3","March");
		hashMap.put("4","April");
		hashMap.put("5","May");
		hashMap.put("6","June");
		hashMap.put("7","July");
		hashMap.put("8","August");
		hashMap.put("9","September");
		hashMap.put("10","October");
		hashMap.put("11","November");
		hashMap.put("12","December");
		
		driver.findElement(By.xpath("//div[@class='react-date-picker__inputGroup']")).click();
		
		driver.findElement(By.xpath("//span[contains(@class,'react-calendar__navigation__label')]")).click();
		
		driver.findElement(By.xpath("//span[contains(@class,'react-calendar__navigation__label__labelText')]")).click();
		
		
		int intTarYear = Integer.parseInt(tarYear);
		
		while (true) {
			
			List<WebElement> yearList = driver.findElements(By.xpath("//button[contains(@class,'react-calendar__tile')]"));
			int minYear = Integer.parseInt(yearList.get(0).getText());
			int  maxYear = Integer.parseInt(yearList.get(yearList.size()-1).getText());
			
			if (intTarYear < minYear || intTarYear > maxYear) {
				if (intTarYear < minYear) {
					driver.findElement(By.xpath("//button[contains(@class,'react-calendar__navigation__prev-button')]")).click();
				}else {
					driver.findElement(By.xpath("//button[contains(@class,'react-calendar__navigation__next-button')]")).click();
				}
			}else {
				for (WebElement currYear : yearList) {
					if (currYear.getText().equals(tarYear)) {
						currYear.click();
						break;
					}
				}
				break;
			}
		}
		
		
		String tarMonth = hashMap.get(month);
		
		List<WebElement> monthList = driver.findElements(By.xpath("//button[contains(@class,'react-calendar__year-view__months__month')]"));
		
		for (WebElement currMonth : monthList) {
			if (currMonth.getText().equals(tarMonth)) {
				currMonth.click();
				break;
			}
		}
		
		List<WebElement> dayList = driver.findElements(By.xpath("//button[contains(@class,'react-calendar__month-view__days__day')]"));
		
		for (WebElement currDay : dayList) {
			if (currDay.getText().equals(date)) {
				currDay.click();
				break;
			}
		}
		
//		Verification :-
		
		String browserDisplayDate =  driver.findElement(By.xpath("//input[@name='date' and @type='date']")).getAttribute("value");
		
		
//		Date CrossCheck :-
		
		String arr[] = browserDisplayDate.split("[/-]");
		
		String browserYear = arr[0];
		String browserMonth = arr[1];
		String browserDate = arr[2];
		
		if (browserMonth.length() == 2 && month.length() == 1) {
			String updatedBrowserMonth = browserMonth.split("0")[1];
			browserMonth = updatedBrowserMonth;
		}
		
		if (browserDate.length() == 2 && date.length() == 1) {
			String updatedBrowserDate = browserDate.split("0")[1];
			browserDate = updatedBrowserDate;
		}
		
		
		if (browserYear.equals(tarYear) && browserMonth.equals(month) && browserDate.equals(date)) {
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
		}
	}
	

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		String month = "3";
		String date = "29";
		String tarYear = "2009";
		
		selectUserDate(driver, month, date, tarYear);
		
		Thread.sleep(2500);
		
		driver.close();
	}

}
