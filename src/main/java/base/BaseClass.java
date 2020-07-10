package base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import Utilities.ExcelDataProvider;

public class BaseClass {

	public WebDriver driver;
	public ExcelDataProvider excel1;

	@BeforeSuite
	public void setUPExcel(){
		excel1 = new ExcelDataProvider();
	}

	@BeforeMethod
	public void setUp() {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterMethod
	public void closeBrowser() {

		driver.quit();
	}

}
