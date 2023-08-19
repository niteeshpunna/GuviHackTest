package Listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Base.baseClass;
import Utilities.ExtentReport;
import Utilities.utility;

public class Listeners extends baseClass implements ITestListener {

	ExtentReports extent=ExtentReport.getExtentReport();
	public ExtentTest test;
	
	@Override
	public void onTestStart(ITestResult result) {
		test=extent.createTest(result.getName());
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.PASS, "Test Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.FAIL, "Test Failed");
		test.log(Status.FAIL, result.getThrowable().getMessage());
		
		try {
		String imgPath = new utility().captureScreenshot(result.getName());
				
		/* As we are creating new Object to basClass, driver instances will be done two times
		 * So we need to add static to webdriver in baseClass*/
		 
		test.addScreenCaptureFromPath(imgPath);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.SKIP, "Test Skipped");
		test.log(Status.SKIP, result.getThrowable().getMessage());
	}

	@Override
	public void onFinish(ITestContext testContext) {
		extent.flush();
	}
}
