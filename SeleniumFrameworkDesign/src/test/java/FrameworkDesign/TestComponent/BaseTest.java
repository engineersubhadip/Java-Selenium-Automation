package FrameworkDesign.TestComponent;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import FrameworkDesign.PageObjects.LandingPage;

public class BaseTest {
	public WebDriver driver;
	public LandingPage loginPage;
	
	public void initializeDriver() throws IOException {
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("K:\\Selenium Java Automation\\SeleniumFrameworkDesign\\src\\main\\java\\FrameworkDesign\\Resources\\GlobalData.properties");
		prop.load(fis);
		
		String browserName =  prop.getProperty("browser");
		
		if (browserName.toLowerCase().contains("chrome")) {
			driver = new ChromeDriver();
		}else if (browserName.toLowerCase().contains("firefox")) {
			driver = new FirefoxDriver();
		}else if (browserName.toLowerCase().contains("edge")) {
			driver = new EdgeDriver();
		}else {
			return ;
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@BeforeMethod(alwaysRun=true)
	public  void launchApp() throws IOException {
		
		initializeDriver();
		loginPage = new LandingPage(driver);
		loginPage.goTo();
	}
	
	@AfterMethod(alwaysRun=true)
	public void tearDown() {
		driver.quit();

	}

	public List<HashMap<String, String>> getJsonDatatoMap(String filePath) throws IOException {
		
//		Capturing the JSON data :-
		
		String jsonContent = FileUtils.readFileToString(new File(filePath), StandardCharsets.UTF_8);
		
//		Convert String to HashMap :- (jackson data bind)
		
		ObjectMapper mapper = new ObjectMapper();
		
		List<HashMap<String, String>> data =  mapper.readValue(jsonContent, new TypeReference<List<HashMap<String,String>>>(){});
		
		return data;
	}

}
