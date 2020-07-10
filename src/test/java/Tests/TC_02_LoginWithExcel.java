package Tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseClass;

public class TC_02_LoginWithExcel extends BaseClass {

	@Test(dataProvider = "TestData1")
	public void loginToApp(String uname, String pass) {

		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.findElement(By.id("txtUsername")).sendKeys(uname);
		driver.findElement(By.id("txtPassword")).sendKeys(pass);
		driver.findElement(By.id("btnLogin")).click();

		Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"));
		System.out.println("User is able to Login to App-- Test Case is Passed");
	}

	@DataProvider(name = "TestData1")
	public Object[][] passData() {

		return new Object[][] {

				{ "admin", "admin" }, { "akola", "akola" }, { "admin", "admin123" } };
	}
}
