package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class ConfirmAppointmentPage extends BasePage{

	public ConfirmAppointmentPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//p[@id='facility']")
	WebElement faciltyname;
	
	@FindBy(id="program")
	WebElement HealthcareProgram;
	
	@FindBy(id="visit_date")
	WebElement visitdate;
	
	@FindBy(id="comment")
	WebElement comment;
	
	@FindBy(xpath="//a[@class='btn btn-default']")
	WebElement gotohomepage;
	
	@FindBy(id="menu-toggle")
	WebElement menuOptions;
	
	@FindBy(xpath="//a[.='History']")
	WebElement history;
	
	@FindBy(xpath="//h2")
	WebElement historypage;
	
	@FindBy(xpath="//a[.='Logout']")
	WebElement logout;
	
	public void clickLogout() {
		logout.click();
	}
	
	public String getHistoryPageMessage() {
		return historypage.getText();
	}
	
	public void clickHistory() {
		history.click();
	}
	
	public void clickMenuOptions() {
		menuOptions.click();
	}
	
	
	public String getDate() {
		return visitdate.getText();
	}
	
	public String getComments() {
		return comment.getText();
	}
	
	
		

}
