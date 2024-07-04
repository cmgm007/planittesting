package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class HomePage extends BasePage{

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//a[@href='#/home']")
    WebElement home;

    @FindBy(xpath = "//a[@href='#/contact']")
    WebElement contactUs;

    @FindBy(xpath = "//a[@href='#/shop']")
    WebElement shop;

    @FindBy(xpath = "//a[@href='#/cart']")
    WebElement cart;

    public HomePage(WebDriver driver) {
        super(driver);  // Call the constructor of BasePage
        PageFactory.initElements(driver, this);
    }

    public void navigateTocontactUs() {
        waitToBecomeVisible(30, contactUs);
        click(contactUs);
    }
    
    public void navigateToShopPage() {
    	waitToBecomeVisible(30, shop);
    	click(shop);
    }
}