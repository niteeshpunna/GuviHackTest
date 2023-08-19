package TestCases;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.baseClass;
import pageObjects.ConfirmAppointmentPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;

public class TC_05_SuccessfulLogout extends baseClass{
	
	@Test
	public void testSuccessfulLogout() {
	
	try {
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
				
				map.selectHongkongFacilty();
				map.selectMedicareButton();
				map.enterDate(rb.getString("visitdate"));
				map.enterComments(rb.getString("textcomments"));
				map.clickBookAppointmentButton();
				Thread.sleep(2000);
				
				ConfirmAppointmentPage cap = new ConfirmAppointmentPage(driver);
				//Verify the visit date
				assertEquals(cap.getDate(),rb.getString("visitdate"));
				Thread.sleep(2000);
				//Verify the comments
				assertEquals(cap.getComments(),rb.getString("textcomments"));
				Thread.sleep(2000);
				
				
				//Navigate to menu options
				cap.clickMenuOptions();
				cap.clickLogout();
				
				
				//After Logout verify the login option visible
				hp.clickMenuOptions();
				hp.verifyLoginDisplayed();
				

				}
			catch(Exception e) {
				e.printStackTrace();
				Assert.fail();
			}
	}
}

