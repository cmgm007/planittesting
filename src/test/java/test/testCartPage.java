package test;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.CartPage;
import pageObjects.ContactUsPage;
import pageObjects.HomePage;
import pageObjects.ShopPage;

public class testCartPage extends BaseTest{
	private HomePage homePage;
	private ShopPage shopPage;
	private CartPage cartPage;
	
	@BeforeClass
	public void BeforeClass () {
		homePage = new HomePage(driver);
		shopPage = new ShopPage(driver);
		cartPage = new CartPage(driver);
	}

	@Test (priority = 1)
	public void navigateToShop() {
		Reporter.log("navigate to contact us");
		homePage.navigateToShopPage();
		Reporter.log("navigated to shop page");
	}
	
	@Test (priority = 2, dependsOnMethods="navigateToShop")
	public void addProductsToCart() {
		shopPage.buyMultipleStuffFrog(2);
		shopPage.buyMultipleFluffyBunny(5);
		shopPage.buyMultipleValentineBear(3);
		shopPage.clickCart();
		Reporter.log("multiple products added to cart", true);
	}
	
	@Test(priority = 3, dependsOnMethods="addProductsToCart")
	public void checkActualPrices() {
		cartPage.checkStuffedFrogActualPrice();
		cartPage.checkFluffyBunnyActualPrice();
		cartPage.checkValentineBearActualPrice();
	}
	
	@Test(priority = 4, dependsOnMethods="addProductsToCart")
	public void checkActualSubTotals() {
		cartPage.checkStuffedFrogActualSubTotal();
		cartPage.checkFluffyBunnyActualSubTotal();
		cartPage.checkValentineBearActualSubTotal();
	}
	
	@Test (priority = 5, dependsOnMethods="checkActualSubTotals")
	public void computeTotalPrice() {
		cartPage.checkTotal();
	}

}
