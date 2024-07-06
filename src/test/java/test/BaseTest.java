package test;

import java.awt.Dimension;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.*;

public abstract class BaseTest {
	public static WebDriver driver;
	
	@BeforeTest
	public void beforeTest () {
		
		String driverPath ="C:\\Users\\malol\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverPath);
		
		//Initialize WebDriver
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://jupiter.cloud.planittesting.com/");
	}
	
	@AfterTest
	public void afterTesT() {
		if(driver!=null) {
			driver.quit();
		}
	}
	
}
