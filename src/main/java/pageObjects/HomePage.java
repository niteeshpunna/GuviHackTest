package pageObjects;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	//Identify Elements on HomePagege
	
		//Make appointment
		@FindBy(id="btn-make-appointment")
		WebElement makeAppoitmnent;
		
		@FindBy(id="menu-toggle")
		WebElement menuoptions;  
		
		@FindBy(xpath="//a[.='Login']")
		WebElement login; 
		
		public void verifyLoginDisplayed() {
			assertTrue(login.isDisplayed());
		}

		//Creating action methods for above elements
		public void clickMakeAppointment() {
			makeAppoitmnent.click();
		}
		
		public void clickMenuOptions() {
			menuoptions.click();
		}
		
		public void clickLogin() {
			login.click();
		}


}
