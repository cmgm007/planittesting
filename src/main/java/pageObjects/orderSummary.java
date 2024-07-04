package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class orderSummary {
	public WebDriver driver;
	
	By placeOrder = By.xpath("//app-order-summary/mat-card/div[2]/mat-card/button/span");
	By totalPrice = By.xpath("//app-order-completion/mat-card/div[2]/mat-table/mat-footer-row/mat-footer-cell[4]/table/tr[4]/td");
	
	public orderSummary(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	
	public WebElement getPlaceOrder() {
		
		return driver.findElement(placeOrder);
	}
	
	public WebElement getTotalPrice() {
		
		return driver.findElement(totalPrice);
	}
	
}
