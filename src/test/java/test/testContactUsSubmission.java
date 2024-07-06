package test;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.ContactUsPage;
import pageObjects.HomePage;

public class testContactUsSubmission extends BaseTest{
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
	
	@Test (priority =2, dependsOnMethods="navigateToContactUs")
	public void fillUpRequiredFields() {
		contactUsPage.fillUpRequiredFieldForename("test user");
		contactUsPage.fillUpRequiredFieldEmail("testuser@email.com");
		contactUsPage.fillUpRequiredFieldMessage("test message");
		contactUsPage.clickSubmit();
		contactUsPage.checkSuccessMessage();
		System.out.println("message successfully submitted");
	}
}
