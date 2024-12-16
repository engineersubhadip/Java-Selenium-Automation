package DatePickers_Calenders;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PickRandomDate {

	static void selectDate(WebDriver driver, String year, String month, String day) {

		int userYear = Integer.parseInt(year);
		int userDay = Integer.parseInt(day);

		HashMap<String, Integer> monthMapper = new HashMap<>();
		monthMapper.put("January", 1);
		monthMapper.put("February", 2);
		monthMapper.put("March", 3);
		monthMapper.put("April", 4);
		monthMapper.put("May", 5);
		monthMapper.put("June", 6);
		monthMapper.put("July", 7);
		monthMapper.put("August", 8);
		monthMapper.put("September", 9);
		monthMapper.put("October", 10);
		monthMapper.put("November", 11);
		monthMapper.put("December", 12);

		while (true) {
			int currYear = Integer.parseInt(
					driver.findElement(By.xpath("(//div[@class='ui-datepicker-title'] //span)[2]")).getText());
			WebElement prevBtn = driver.findElement(By.xpath("//a[contains(@class,'ui-datepicker-prev')] //span"));
			WebElement nextBtn = driver.findElement(By.xpath("//a[contains(@class,'ui-datepicker-next')] //span"));

			if (userYear < currYear) {
				prevBtn.click();
			} else if (userYear > currYear) {
				nextBtn.click();
			} else {
				String currMonth = driver.findElement(By.xpath("(//div[@class='ui-datepicker-title'] //span)[1]"))
						.getText();
				int currMonthVal = monthMapper.get(currMonth);
				int userMonthVal = monthMapper.get(month);

				if (userMonthVal < currMonthVal) {
					prevBtn.click();
				} else if (userMonthVal > currMonthVal) {
					nextBtn.click();
				} else {
					break;
				}
			}
		}

		List<WebElement> days = driver.findElements(By.xpath("//tbody //tr //td //a"));

		days.stream().filter(currEle -> {
			try {
				int currDay = Integer.parseInt(currEle.getText());
				if (currDay == userDay) {
					return true;
				} else {
					return false;
				}
			} catch (Exception e) {
				return false;
			}
		}).forEach(currEle -> currEle.click());

		driver.switchTo().defaultContent();
	}

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://jqueryui.com/datepicker/");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait.until(ExpectedConditions.titleContains("Datepicker | jQuery UI"));

		WebElement frameEle = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));

		driver.switchTo().frame(frameEle);

		WebElement dateField = driver.findElement(By.xpath("//input[@id='datepicker']"));
		dateField.click(); // -> Date Picker Field is now visible

		selectDate(driver, "1994", "May", "29");

//		driver.quit();
	}

}
