package DragAndDrop;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DragAndDrop {

	private static String getCountry(String city) {
		if (city.equalsIgnoreCase("Washington")) {
			return "United States";
		} else if (city.equalsIgnoreCase("Copenhagen")) {
			return "Denmark";
		} else if (city.equalsIgnoreCase("Seoul")) {
			return "South Korea";
		} else if (city.equalsIgnoreCase("Rome")) {
			return "Italy";
		} else if (city.equalsIgnoreCase("Madrid")) {
			return "Spain";
		} else if (city.equalsIgnoreCase("Oslo")) {
			return "Norway";
		} else {
			return "Sweden";
		}
	}

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().setSize(new Dimension(1440, 900));
		driver.manage().window().maximize();

		driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@class='dragableBox' and contains(@id,'box')]")));
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'dragableBoxRight')]")));

		List<WebElement> cities = driver.findElements(By.xpath("//div[@class='dragableBox' and contains(@id,'box')]"));
		List<WebElement> countries = driver.findElements(By.xpath("//div[contains(@class,'dragableBoxRight')]"));

		Actions a = new Actions(driver);

		for (int i = 0; i < cities.size(); i++) {
			String currCity = cities.get(i).getText();
			String currCountry = getCountry(currCity);
			WebElement tarCountry = null;
			for (int j = 0; j < countries.size(); j++) {
				String runCountry = countries.get(j).getText();
				if (currCountry.equalsIgnoreCase(runCountry)) {
					tarCountry = countries.get(j);
					break;
				}
			}
			a.dragAndDrop(cities.get(i), tarCountry).build().perform();
			Thread.sleep(200);
		}
	}

}
