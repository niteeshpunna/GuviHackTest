package Utilities;

import java.util.Date;
import java.text.SimpleDateFormat;

import org.testng.ITestContext;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport {
	
	public static ExtentSparkReporter sparkReporter;
	public static ExtentReports extent;
	public ExtentTest test;

	//String repName;

	public static ExtentReports getExtentReport() {
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());// time stamp
		String repName = "Test-Report-" + timeStamp + ".html";
		String path = System.getProperty("user.dir")+"\\reports\\"+ repName;

		sparkReporter = new ExtentSparkReporter(path);// specify location of the report

		sparkReporter.config().setDocumentTitle("CURA Healthcare Automation Report"); // Title of report
		sparkReporter.config().setReportName("CURA Healthcare Functional Testing"); // name of the report
		sparkReporter.config().setTheme(Theme.DARK);

		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Application", "CURA Healthcare");
		extent.setSystemInfo("Module", "Admin");
		extent.setSystemInfo("Sub Module", "Customers");
		extent.setSystemInfo("Operating System", System.getProperty("os.name"));
		extent.setSystemInfo("User Name", System.getProperty("user.name"));
		extent.setSystemInfo("Environemnt", "QA");
		
		return extent;
	}


}
