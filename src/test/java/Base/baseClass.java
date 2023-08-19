package Base;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.ResourceBundle;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class baseClass {
	
	public static WebDriver driver;
	
	public ResourceBundle rb;
	
	@BeforeMethod
	@Parameters("browser")
	public void launchBrowser(String br) {
		
		rb = ResourceBundle.getBundle("data");
		if(br.equals("chrome")) {
			driver = new ChromeDriver();
			}
			else if(br.equals("edge")) {
				driver = new EdgeDriver();
			}
			else if(br.equals("firefox")){
				driver = new FirefoxDriver();
			}
		
		driver.get(rb.getString("url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		//Verify the page title, ensuring that landed on correct webpage or not
				try {
					Thread.sleep(2000);
					assertEquals(driver.getTitle(),"CURA Healthcare Service");
				}catch(Exception e) {
					e.printStackTrace();
				}
		
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}

}
