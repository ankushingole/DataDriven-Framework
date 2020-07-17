package base;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Utilities.BrowserFactory;
import Utilities.ConfigDataProvider;
import Utilities.ExcelDataProvider;
import actions.Actions;

public class BaseClass {

	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	public ExtentReports report;
	public ExtentTest logger;

	@BeforeSuite
	public void setUPExcel() {
		Reporter.log("All Settings are getting ready", true);
		
		excel = new ExcelDataProvider();
		config = new ConfigDataProvider();

		ExtentHtmlReporter reporter = new ExtentHtmlReporter(new File("./Reports/Demosite.html"));
		report = new ExtentReports();
		report.attachReporter(reporter);
		
		Reporter.log("Settings done and Tests can be running", true);
	}

	@BeforeClass
	public void setUp() {
		
		Reporter.log("Trying to start browser", true);

		driver = BrowserFactory.startApp(driver, config.getBrowser(), config.getQaURL());
		Reporter.log("Browser and Appliction is up and running", true);
	}

	@AfterClass
	public void closeBrowser() {

		BrowserFactory.quitApp(driver);
	}

	@AfterMethod
	public void getFailedTestSS(ITestResult result) throws IOException {
		
		Reporter.log("Test is about to End", true);
		
		if (result.getStatus() == ITestResult.FAILURE) {

			// Actions.getScreenshot(driver);
			logger.fail("Test failed",
					MediaEntityBuilder.createScreenCaptureFromPath(Actions.getScreenshot(driver)).build());

		} else if (result.getStatus() == ITestResult.SUCCESS) {

			logger.pass("Test passed",
					MediaEntityBuilder.createScreenCaptureFromPath(Actions.getScreenshot(driver)).build());
		}
		report.flush();
		Reporter.log("Test Completed and Reports generated", true);
	}

}
