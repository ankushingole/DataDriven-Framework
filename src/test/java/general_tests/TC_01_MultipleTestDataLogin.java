package general_tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseClass;

public class TC_01_MultipleTestDataLogin extends BaseClass {

	@Test(dataProvider = "TestData")
	public void loginToApp(String uname, String pass) {

		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.findElement(By.id("txtUsername")).sendKeys(uname);
		driver.findElement(By.id("txtPassword")).sendKeys(pass);
		driver.findElement(By.id("btnLogin")).click();

		Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"));
		System.out.println("User is able to Login to App-- Test Case is Passed");

	}

	@DataProvider(name = "TestData")
	public Object[][] passData() {

		Object[][] data = new Object[3][2];
		data[0][0] = "Admin";
		data[0][1] = "admin123";

		data[1][0] = "Admin";
		data[1][1] = "adin2ieh";

		data[2][0] = "asdf";
		data[2][1] = "sjdfsj";

		return data;

	}

}
