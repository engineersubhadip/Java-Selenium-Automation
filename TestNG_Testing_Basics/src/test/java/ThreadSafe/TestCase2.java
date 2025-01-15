package ThreadSafe;

import java.time.Duration;

import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class TestCase2 extends Parent {
	@Test
	public void captureTitle() {
		
		driver = new EdgeDriver();
		setDriver(driver);
		driver = getDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.bing.com/?toWww=1&redig=87F8EB3292C644C5BDA77B1CE4259FA4");

		String result = driver.getTitle();
		System.out.println(result);
	}
	
	@AfterClass
	public void tearDown() {
		tLocal.remove();
		driver.quit();
	}
}
