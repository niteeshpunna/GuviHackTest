package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.baseClass;
import pageObjects.HomePage;
import pageObjects.LoginPage;

public class TC_02_InvalidLogin extends baseClass{
	
	//Invalid username with valid password
	@Test(priority=1)
	public void testInvalidUsername() {
		try {
		HomePage hp = new HomePage(driver);
		
		hp.clickMenuOptions(); //Click on Menu Options
		hp.clickLogin();
		Thread.sleep(2000);
		
		LoginPage lp = new LoginPage(driver);
		lp.verifyLoginScreen();
		Thread.sleep(2000);
		
		lp.enterUsername("Guvi");//Invalid username
		lp.enterPassword(rb.getString("validpassword"));
		lp.clickLogin();
		Thread.sleep(2000);
		
		lp.verifyErrorMessage();
		}
		catch(Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

	//Invalid password
	@Test(priority=2)
	public void testInvalidPassword() {
		try {
		HomePage hp = new HomePage(driver);
		
		hp.clickMenuOptions(); //Click on Menu Options
		hp.clickLogin();
		Thread.sleep(2000);
		
		LoginPage lp = new LoginPage(driver);
		lp.verifyLoginScreen();
		Thread.sleep(2000);
		
		lp.enterUsername(rb.getString("validusername"));
		lp.enterPassword("Guvi@123");//Invalid password
		lp.clickLogin();
		Thread.sleep(2000);
		
		lp.verifyErrorMessage();
		}
		catch(Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

	//Empty username & password
	@Test(priority=3)
	public void testInvalidUsernamePassword() {
		try {
		HomePage hp = new HomePage(driver);
		
		hp.clickMenuOptions(); //Click on Menu Options
		hp.clickLogin();
		Thread.sleep(2000);
		
		LoginPage lp = new LoginPage(driver);
		lp.verifyLoginScreen();
		Thread.sleep(2000);
		
		lp.enterUsername("");
		lp.enterPassword("");//Invalid password
		lp.clickLogin();
		Thread.sleep(2000);
		
		lp.verifyErrorMessage();
		}
		catch(Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
}
