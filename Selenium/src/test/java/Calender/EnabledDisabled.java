package Calender;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class EnabledDisabled {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/#");
		driver.manage().window().maximize();
		
//		1. For Round-trip return date should be enabled :-
		
		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_rbtnl_Trip_1']")).click();
		
//		Validation :-
		
		String eleStyle = driver.findElement(By.xpath("//div[@id='Div1']")).getAttribute("style");
		
		System.out.println(eleStyle);
		
		String arr[] = eleStyle.split(" ");
		
		String opacity = arr[arr.length-1].split(";")[0];
		
		String opacityVal = opacity.trim();
		
		double checkPoint = Double.parseDouble(opacityVal);
		
		if (checkPoint == 1) {
			System.out.println("Enabled");
		} else {
			System.out.println("Disabled");
		}
	}

}
