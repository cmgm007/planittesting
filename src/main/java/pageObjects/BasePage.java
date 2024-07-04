package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public abstract class BasePage {

    protected WebDriver driver;
    private WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(new DefaultElementLocatorFactory(driver), this);
    }

    protected void sleep(long timeMilliseconds) {
        try {
            Thread.sleep(timeMilliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void click(WebElement element) {
        element.click();
    }

    public void clear(WebElement element) {
        element.clear();
    }

    public void sendKey(WebElement element, String text) {
        element.sendKeys(text);
    }

    public void waitToBecomeVisible(long timeSeconds, WebElement element) {
        try {
            WebDriverWait customWait = new WebDriverWait(driver, Duration.ofSeconds(timeSeconds));
            customWait.until(ExpectedConditions.visibilityOf(element));
        } catch (StaleElementReferenceException e) {
            Reporter.log("StaleElementReferenceException");
            Assert.fail("WebElement no longer exists");
        } catch (TimeoutException e1) {
            Reporter.log("TimeoutException");
            Assert.fail("WebElement not found in " + timeSeconds + " seconds: " + e1);
        } catch (NoSuchElementException e2) {
            Reporter.log("NoSuchElementException");
            Assert.fail("Unable to locate element");
        }
    }
    
    public void elementIsDisplayed(WebElement element) {
    	element.isDisplayed();
    }
    
    public boolean isElementDisplayed(By webElements) {
    	try {
    		WebElement element = driver.findElement(webElements);
    		return element.isDisplayed();
    	} catch (NoSuchElementException e) {
    		return false;
    	}
    }
    
    
    
}