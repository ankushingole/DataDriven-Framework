package Utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactory {


	public static WebDriver startApp(WebDriver driver, String browserName, String appURL) {

		if(browserName.equalsIgnoreCase("Chrome")) {

			driver= new ChromeDriver();

		}else if (browserName.equalsIgnoreCase("ff")) {

			driver = new FirefoxDriver();

		}else if (browserName.equalsIgnoreCase("Edge")) {

			driver= new EdgeDriver();
		}
		else if (browserName.equalsIgnoreCase("IE")) {

			driver= new InternetExplorerDriver();
		}
		else {
			System.out.println("No browsers available");

		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.get(appURL);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}



	public static void quitApp(WebDriver driver) {

		driver.quit();
	}

}
