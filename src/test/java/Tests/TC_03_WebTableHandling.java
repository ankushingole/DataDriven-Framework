package Tests;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import excelLib.Xls_Reader;

public class TC_03_WebTableHandling {

	WebDriver driver;

	@Test
	public void readWebtableData(){
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("https://www.w3schools.com/html/html_tables.asp");

		String before_xpath_Company ="//table[@id='customers']/tbody/tr[";
		String after_xpath_Company="]/td[1]";

		String before_xpath_Contacts ="//table[@id='customers']/tbody/tr[";
		String after_xpath_Contacts="]/td[2]";

		List<WebElement>rows=driver.findElements(By.xpath("//table[@id='customers']//tr"));
		System.out.println("Total rows are: "+(rows.size()-1));
		int rowCount = rows.size();

		//Using Excel Utility
		Xls_Reader reader = new Xls_Reader("D:\\Workspace\\DataDrivenFramework\\testdata\\testdata.xlsx");

		//adding new sheet, rows and columns to the excel file
		if(!reader.isSheetExist("TableData")){
			reader.addSheet("TableData");
			reader.addColumn("TableData", "Company");
			reader.addColumn("TableData", "Contact");
		}
		

		//iterating using for loop
		for (int i = 2; i <=rowCount; i++) {

			String actual_Xpath_Company=before_xpath_Company+i+after_xpath_Company;
			String CompanyName=driver.findElement(By.xpath(actual_Xpath_Company)).getText();
			System.out.println(CompanyName);
			reader.setCellData("TableData", "Company", i, CompanyName);

			String actual_Xpath_Contacts=before_xpath_Contacts+i+after_xpath_Contacts;
			String ContactName=driver.findElement(By.xpath(actual_Xpath_Contacts)).getText();
			System.out.println(ContactName);
			reader.setCellData("TableData", "Contact", i, ContactName);

		}

	}
}
