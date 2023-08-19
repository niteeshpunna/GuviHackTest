package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.baseClass;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;

public class TC_01_ValidLogin extends baseClass{
	
	@Test
	public void testValidLogin() {
		
		try {
			//Create object to HomePage
			//WebDriver driver;
			HomePage hp = new HomePage(driver);
			
			hp.clickMenuOptions(); //Click on Menu Options
			hp.clickLogin();
			Thread.sleep(2000);
			
			LoginPage lp = new LoginPage(driver);
			lp.verifyLoginScreen();
			Thread.sleep(2000);
			lp.enterUsername(rb.getString("validusername"));
			lp.enterPassword(rb.getString("validpassword"));
			lp.clickLogin();
			Thread.sleep(2000);
			
			MyAccountPage map = new MyAccountPage(driver);
			
			map.verifySuccessfulLigin();
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}


}
