package Tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.LoginPage;

public class LoginPageTest extends BaseClass {

	LoginPage loginPage;

	@Test(priority = 1)
	public void loginApp() {
		logger = report.createTest("Login to Demosite");    //using TestNG logger

		loginPage = PageFactory.initElements(driver, LoginPage.class);
		logger.info("Starting application");

		loginPage.logintoDemosite(excel.getStringData("Demosite_login_data", 0, 0),
				excel.getStringData("Demosite_login_data", 0, 1));
		logger.pass("Test is successful");
	}

	/*
	 * @Test(priority = 2) public void logout() {
	 * 
	 * logger = report.createTest("Logout"); logger.fail("Test is failed"); }
	 */
}
