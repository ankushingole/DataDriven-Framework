package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver ldriver) {

		this.driver = ldriver;
	}

	@FindBy(xpath = "//input[@id='txtUsername']")
	WebElement username;

	@FindBy(xpath = "//input[@id='txtPassword']")
	WebElement password;

	@FindBy(xpath = "//input[@id='btnLogin']")
	WebElement signinBtn;

	public void logintoDemosite(String uname, String pass) {

		username.sendKeys(uname);
		password.sendKeys(pass);
		signinBtn.click();
	}
}
