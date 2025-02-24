package DynamicTable;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Client {
	
	static int getCPUCol(List<WebElement> list) {
		for (int i=0; i<list.size(); i++) {
			String currValue = list.get(i).getText();
			if (currValue.equals("CPU")) {
				return i;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		// How to handle Dynamic Table :-
		
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().setSize(new Dimension(1440,900));
		driver.manage().window().maximize();
		
		driver.get("https://practice.expandtesting.com/dynamic-table");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		List<WebElement> tableHead = driver.findElements(By.xpath("//div[@id='table-description']/following-sibling::div //table/thead //th"));
		List<WebElement> tableBody = driver.findElements(By.xpath("//div[@id='table-description']/following-sibling::div //table/tbody //tr"));
		
		WebElement tarWebElement = null;
		boolean status = false;
		
		for (int i=0; i<tableBody.size(); i++) {
			WebElement currEle = tableBody.get(i);
			List<WebElement> listTD = currEle.findElements(By.xpath("./td"));
			for (int j=0; j<listTD.size(); j++) {
				String currValue = listTD.get(j).getText();
				if (currValue.equals("Chrome")) {
					tarWebElement = currEle;
					status = true;
					break;
				}
			}
			if (status) {
				break;
			}
		}
		
		int tarIDX = getCPUCol(tableHead);
		tarIDX += 1;
		String cpuUsage = tarWebElement.findElement(By.xpath("./td["+tarIDX+"]")).getText();
		
		String expCPUUsage = driver.findElement(By.id("chrome-cpu")).getText();
		String expAns = expCPUUsage.split(":")[1].trim();
		String actualAns = cpuUsage.trim();
		
		Assert.assertEquals(expAns, actualAns);
	}

}
