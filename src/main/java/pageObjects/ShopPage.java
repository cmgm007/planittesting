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

public class ShopPage extends BasePage{
	private WebDriver driver;
    private WebDriverWait wait;
    
    
    public ShopPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    
    @FindBy (xpath="//h4[contains(text(), 'Stuffed Frog')]/../p/a")
    WebElement stuffFrogBuy;
    
    @FindBy (xpath="//h4[contains(text(), 'Fluffy Bunny')]/../p/a")
    WebElement fluffBunnyBuy;
    
    @FindBy (xpath="//h4[contains(text(), 'Valentine Bear')]/../p/a")
    WebElement valentineBearBuy;
    
    @FindBy (xpath="//a[@href='#/cart']")
    WebElement cart;
    
    public void buyMultipleStuffFrog(int quantity) {
    	for (int i=0; i < quantity; i++) {
    		waitToBecomeVisible(30, stuffFrogBuy);
        	click(stuffFrogBuy);
    	}
    }
    
    public void buyMultipleFluffyBunny(int quantity) {
    	for (int i=0; i < quantity; i++) {
    		waitToBecomeVisible(30, fluffBunnyBuy);
        	click(fluffBunnyBuy);
    	}
    }
    
    public void buyMultipleValentineBear(int quantity) {
    	for (int i=0; i < quantity; i++) {
    		waitToBecomeVisible(30, valentineBearBuy);
        	click(valentineBearBuy);
    	}
    }
    
    public void clickCart() {
    	 waitToBecomeVisible(30, cart);
         click(cart);
    }
  
}
