package actions;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

//Screenshots, alerts, frames, windows

public class Actions {

	public static String getScreenshot(WebDriver driver) {

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		String screenshotPath = System.getProperty("user.dir") + "/Screenshots/Demosite_" + getCurrentDateTime()
				+ ".png";

		try {

			FileHandler.copy(src, new File(screenshotPath));
			System.out.println("Screenshot captured");

		} catch (IOException e) {

			System.out.println("Unable to capture Screenshot file" + e.getMessage());
		}

		return screenshotPath;
	}

	public static String getCurrentDateTime() {

		DateFormat customformat = new SimpleDateFormat("MM_DD_YYYY_HH_MM_SS");
		Date currentDate = new Date();

		return customformat.format(currentDate);
	}

}
