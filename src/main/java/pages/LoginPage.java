package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver ldriver) {

		this.driver = ldriver;
	}

	@FindBy(xpath = "//input[@id='user_login']")
	WebElement username;

	@FindBy(xpath = "//input[@id='user_pass']")
	WebElement password;

	@FindBy(xpath = "//input[@id='wp-submit']")
	WebElement signinBtn;

	public void logintoDemosite(String uname, String pass) {

		username.sendKeys(uname);
		password.sendKeys(pass);
		signinBtn.click();
	}
}
