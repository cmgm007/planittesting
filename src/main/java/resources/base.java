package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class base {
	
	public WebDriver driver;
	public Properties prop;
	
	public WebDriver initializeDriver() throws IOException {
		
		prop= new Properties();
		FileInputStream fis= new FileInputStream("C:\\Users\\malol\\eclipse-workspace\\ECommerce\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		
		String browserName= prop.getProperty("browser");
		String urlLink = prop.getProperty("url");	
		
		if (browserName.equals("chrome")) {
			//execute chromedriver
			System.setProperty("webdriver.chrome.driver", "C://Selenium WebDrivers//ChromeDriver//chromedriver.exe");
			driver= new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(urlLink);
			
		}else if (browserName.equals("firefox")){
			//execute firefoxdriver
			
		}else {
			//execute IE
		}
	
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
}
