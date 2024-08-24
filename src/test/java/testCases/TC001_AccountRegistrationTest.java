package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;

public class TC001_AccountRegistrationTest extends BaseClass {
	
	@Test
	public void verify_account_registration()
	{
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickRegister();
		
		
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
		regpage.setFirstName("John");
		regpage.setLastName("Doe");
		regpage.setPhone("1234567890");
		regpage.setEmail(p.getProperty("email"));
		regpage.setPassword(p.getProperty("password"));
		regpage.setConfPassword(p.getProperty("password"));
		regpage.setPrivacyPolicy();
		regpage.clickContinue();
		
		
		String confmsg=regpage.getConfirmationMessage();
		Assert.assertEquals(confmsg, "Your Account Has Been Created!");
		
		
	}
	
	
	

	
	

}
