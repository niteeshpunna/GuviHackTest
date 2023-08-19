package pageObjects;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class MyAccountPage extends BasePage{

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id="btn-book-appointment")
	WebElement bookAppointmentButton;
	
	@FindBy(id="combo_facility")
	WebElement FacilityDropdown;
	
	@FindBy(id="radio_program_medicare")
	WebElement MedicareButton;
	
	@FindBy(id="txt_visit_date")
	WebElement date;
	
	@FindBy(xpath="//textarea")
	WebElement comments;
	
	
	
	public void clickBookAppointmentButton() {
		bookAppointmentButton.click();
	}
	
	public void enterComments(String str) {
		comments.sendKeys(str);
	}
	
	public void enterDate(String str) {
		date.sendKeys(str);
	}
	
	public void selectMedicareButton() {
		MedicareButton.click();
	}
	
	public void selectHongKongFacilty() {
		Select dd = new Select(FacilityDropdown);
		dd.selectByValue("");
	}
	
	public void selectHongkongFacilty() {
		Select dd = new Select(FacilityDropdown);
		dd.selectByValue("Hongkong CURA Healthcare Center");
	}
	
	public void selectSeoulFacility() {
		Select dd = new Select(FacilityDropdown);
		dd.selectByValue("Seoul CURA Healthcare Center");
	}
	
	public void verifySuccessfulLigin() {
		assertTrue(bookAppointmentButton.isDisplayed());
	}
	
	
}
