package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageObjects.ContactUsPage;
import pageObjects.HomePage;


public class testContactUs extends BaseTest {
	
	private HomePage homePage;
	private ContactUsPage contactUsPage;
	
	
	@BeforeClass
	public void BeforeClass () {
		homePage = new HomePage(driver);
		contactUsPage = new ContactUsPage(driver);
	}

	@Test (priority = 1)
	public void navigateToContactUs() {
		Reporter.log("navigate to contact us");
		homePage.navigateTocontactUs();
		Reporter.log("navigated to contact us page");
		Assert.assertTrue(driver.getCurrentUrl().contains("contact"), "Contact us page not opened");
	}
	
	@Test (priority = 2, dependsOnMethods ="navigateToContactUs")
	public void verifyErrorMessages() {
		Reporter.log("click submit button", true);
		contactUsPage.clickSubmit();
		Reporter.log("clicked submit button", true);
		
		contactUsPage.errorMessagesAreDisplayed();
		Reporter.log("error messages are displayed", true);
		
	}
	
	@Test (priority =3, dependsOnMethods="verifyErrorMessages")
	public void fillUpRequiredFields() {
		contactUsPage.fillUpRequiredFieldForename("test user");
		contactUsPage.fillUpRequiredFieldEmail("testuser@email.com");
		contactUsPage.fillUpRequiredFieldMessage("test message");
		
		contactUsPage.errorMessagesAreNotDisplayed();
		Reporter.log("error messages are not displayed", true);
	}
}