package pageObjects;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id="txt-username")
	WebElement username;
	
	@FindBy(id="txt-password")
	WebElement password;
	
	@FindBy(id="btn-login")
	WebElement loginbutton;
	
	@FindBy(xpath="//p[@class='lead']")
	WebElement loginscreen;
	
	@FindBy(xpath="//p[@class='lead text-danger']")
	WebElement errormessage;
	
	public void enterUsername(String str) {
		username.sendKeys(str);
	}
	
	public void enterPassword(String str) {
		password.sendKeys(str);
	}
	
	public void clickLogin() {
		loginbutton.click();
	}
	
	public void verifyLoginScreen() {
		assertEquals(loginscreen.getText(),"Please login to make appointment.");
	}
	
	public void verifyErrorMessage() {
		assertTrue(errormessage.isDisplayed());
	}

}
