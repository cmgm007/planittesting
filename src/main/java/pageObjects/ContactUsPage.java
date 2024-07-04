package pageObjects;

import java.util.List;
import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class ContactUsPage extends BasePage{
	private WebDriver driver;
    private WebDriverWait wait;
    
    List<By> locators = Arrays.asList(
    	
    	By.xpath("//span[contains(text(), 'Forename is required')]"),
    	By.xpath("//span[contains(text(), 'Email is required')]"),
    	By.xpath("//span[contains(text(), 'Message is required')]")
	);
   
    @FindBy(xpath = "//a[@class='btn-contact btn btn-primary']")
    WebElement submitButton;
    
    @FindBy(xpath ="//input[@id='forename']")
    WebElement forenameTextBox;
    
    @FindBy(xpath ="//input[@id='email']")
    WebElement emailTextBox;
    
    @FindBy(xpath ="//textarea")
    WebElement messageTextArea;
    
    @FindBy(xpath="//div[@class='alert alert-success']")
    WebElement successMessage;
    
    
    public ContactUsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    
    public void clickSubmit() {
    	waitToBecomeVisible(30, submitButton);
    	click(submitButton);
    }
    
    // Method to check if a group of elements are found
    public boolean areElementsFound(List<By> locators) {
        for (By locator : locators) {
            if (!isElementDisplayed(locator)) {
                return false;
            }
        }
        return true;
    }

    // Method to check if a group of elements are not found
    public boolean areElementsNotFound(List<By> locators) {
        for (By locator : locators) {
            if (isElementDisplayed(locator)) {
                return false;
            }
        }
        return true;
    }
    
    public void errorMessagesAreDisplayed() {
    	Reporter.log("checking if the following elements are displayed");
    	Assert.assertTrue(areElementsFound(locators), "all elements are found");
    	
    }
    
    public void errorMessagesAreNotDisplayed() {
    	Reporter.log("checking if the following elements are not displayed");
    	Assert.assertTrue(areElementsNotFound(locators), "all elements are not found");
    }
    
    public void fillUpRequiredFieldForename(String text) {
    	waitToBecomeVisible(30, forenameTextBox);
    	sendKey(forenameTextBox, text);
    }
    
    public void fillUpRequiredFieldEmail(String text) {
    	waitToBecomeVisible(30, emailTextBox);
    	sendKey(emailTextBox, text);
    }
    
    public void fillUpRequiredFieldMessage(String text) {
    	waitToBecomeVisible(30, messageTextArea);
    	sendKey(messageTextArea, text);
    }
    
    public void checkSuccessMessage() {
    	waitToBecomeVisible(30, successMessage);
    	successMessage.isDisplayed();
    }
}
