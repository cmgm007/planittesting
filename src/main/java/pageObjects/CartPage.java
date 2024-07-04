package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class CartPage extends BasePage {
    private WebDriver driver;
    private WebDriverWait wait;

    private double stuffedFrogPrice = 10.99;
    private double fluffyBunnyPrice = 9.99;
    private double valentineBearPrice = 14.99;

    public CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//td[contains(text(), 'Stuffed Frog')]//..//td//input/../preceding-sibling::td[contains(text(), '$')]")
    WebElement stuffedFrogActualPrice;

    @FindBy(xpath = "//td[contains(text(), 'Fluffy Bunny')]//..//td//input/../preceding-sibling::td[contains(text(), '$')]")
    WebElement fluffyBunnyActualPrice;

    @FindBy(xpath = "//td[contains(text(), 'Valentine Bear')]//..//td//input/../preceding-sibling::td[contains(text(), '$')]")
    WebElement valentineBearActualPrice;

    @FindBy(xpath = "//td[contains(text(), 'Stuffed Frog')]//..//td//input")
    WebElement stuffedFrogQuantity;

    @FindBy(xpath = "//td[contains(text(), 'Fluffy Bunny')]//..//td//input")
    WebElement fluffyBunnyQuantity;

    @FindBy(xpath = "//td[contains(text(), 'Valentine Bear')]//..//td//input")
    WebElement valentineBearQuantity;

    @FindBy(xpath = "//td[contains(text(), 'Stuffed Frog')]//..//td//input/../following-sibling::td[contains(text(), '$')]")
    WebElement stuffedFrogSubTotal;

    @FindBy(xpath = "//td[contains(text(), 'Fluffy Bunny')]//..//td//input/../following-sibling::td[contains(text(), '$')]")
    WebElement fluffyBunnySubTotal;

    @FindBy(xpath = "//td[contains(text(), 'Valentine Bear')]//..//td//input/../following-sibling::td[contains(text(), '$')]")
    WebElement valentineBearSubTotal;

    @FindBy(xpath = "//strong")
    WebElement total;

    public void checkStuffedFrogActualPrice() {
        waitToBecomeVisible(30, stuffedFrogActualPrice);
        String getActualPrice = stuffedFrogActualPrice.getText();
        String numericActualStuffedFrogPrice = getActualPrice.replaceAll("[^0-9.]", "");
        double actualStuffedFrogPrice = Double.parseDouble(numericActualStuffedFrogPrice);
        Assert.assertEquals(actualStuffedFrogPrice, stuffedFrogPrice, "Actual stuffed frog price is incorrect");
        Reporter.log("Actual stuffed frog price is correct " + actualStuffedFrogPrice ,true);
    }

    public void checkFluffyBunnyActualPrice() {
        waitToBecomeVisible(30, fluffyBunnyActualPrice);
        String getActualPrice = fluffyBunnyActualPrice.getText();
        String numericActualFluffyBunnyPrice = getActualPrice.replaceAll("[^0-9.]", "");
        double actualFluffyBunnyPrice = Double.parseDouble(numericActualFluffyBunnyPrice);
        Assert.assertEquals(actualFluffyBunnyPrice, fluffyBunnyPrice, "Actual fluffy bunny price is incorrect");
        Reporter.log("Actual fluffy bunny price is correct " + actualFluffyBunnyPrice ,true);
    }

    public void checkValentineBearActualPrice() {
        waitToBecomeVisible(30, valentineBearActualPrice);
        String getActualPrice = valentineBearActualPrice.getText();
        String numericActualValentineBearPrice = getActualPrice.replaceAll("[^0-9.]", "");
        double actualValentineBearPrice = Double.parseDouble(numericActualValentineBearPrice);
        Assert.assertEquals(actualValentineBearPrice, valentineBearPrice, "Actual valentine bear price is incorrect");
        Reporter.log("Actual valentine bear price is correct " + actualValentineBearPrice ,true);
    }

    public double calculateStuffedFrogSubTotal() {
        waitToBecomeVisible(30, stuffedFrogQuantity);
        int stuffedFrogQty = getQuantity(stuffedFrogQuantity);
        return stuffedFrogQty * stuffedFrogPrice;
    }

    public double calculateFluffyBunnySubTotal() {
        waitToBecomeVisible(30, fluffyBunnyQuantity);
        int fluffyBunnyQty = getQuantity(fluffyBunnyQuantity);
        return fluffyBunnyQty * fluffyBunnyPrice;
    }

    public double calculateValentineBearSubTotal() {
        waitToBecomeVisible(30, valentineBearQuantity);
        int valentineBearQty = getQuantity(valentineBearQuantity);
        return valentineBearQty * valentineBearPrice;
    }
    
    public void checkStuffedFrogActualSubTotal() {
    	waitToBecomeVisible(30, stuffedFrogSubTotal);
        String getActualSubTotal= stuffedFrogSubTotal.getText();
        String numericActualStuffedFrogSubTotal = getActualSubTotal.replaceAll("[^0-9.]", "");
        double actualStuffedFrogSubTotal = Double.parseDouble(numericActualStuffedFrogSubTotal);
        Assert.assertEquals(actualStuffedFrogSubTotal, calculateStuffedFrogSubTotal(), "Actual stuffed frog subtotal is incorrect");
        Reporter.log("Actual stuffed frog subtotal is correct " + actualStuffedFrogSubTotal ,true);
    }
    
    public void checkFluffyBunnyActualSubTotal() {
    	waitToBecomeVisible(30, fluffyBunnySubTotal);
        String getActualSubTotal= fluffyBunnySubTotal.getText();
        String numericActualFluffyBunnySubTotal = getActualSubTotal.replaceAll("[^0-9.]", "");
        double actualFluffyBunnySubTotal = Double.parseDouble(numericActualFluffyBunnySubTotal);
        Assert.assertEquals(actualFluffyBunnySubTotal, calculateFluffyBunnySubTotal(), "Actual fluffy bunny subtotal is incorrect");
        Reporter.log("Actual fluffy bunny subtotal is correct " + actualFluffyBunnySubTotal ,true);
    }
    
    public void checkValentineBearActualSubTotal() {
    	waitToBecomeVisible(30, valentineBearSubTotal);
        String getActualSubTotal= valentineBearSubTotal.getText();
        String numericActualValentineBearSubTotal = getActualSubTotal.replaceAll("[^0-9.]", "");
        double actualValentineBearSubTotal = Double.parseDouble(numericActualValentineBearSubTotal);
        Assert.assertEquals(actualValentineBearSubTotal, calculateValentineBearSubTotal(), "Actual valentine bear subtotal is incorrect");
        Reporter.log("Actual valentine bear subtotal is correct " + actualValentineBearSubTotal ,true);
    }

    public double calculateTotal() {
        return calculateStuffedFrogSubTotal() + calculateFluffyBunnySubTotal() + calculateValentineBearSubTotal();
    }

    public void checkTotal() {
        waitToBecomeVisible(30, total);
        String getTotalText = total.getText().trim();
        String numericTotal = getTotalText.replaceAll("[^0-9.]", "");
        double actualTotal = Double.parseDouble(numericTotal);
        double expectedTotal = calculateTotal();
        Assert.assertEquals(actualTotal, expectedTotal, "Total amount is incorrect");
        Reporter.log("correct total amount " + actualTotal ,true);
    }

    private int getQuantity(WebElement element) {
        String quantityStr = element.getAttribute("value");
        return quantityStr != null && !quantityStr.isEmpty() ? Integer.parseInt(quantityStr) : 0;
    }
}
