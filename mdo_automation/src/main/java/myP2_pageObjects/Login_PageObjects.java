package myP2_pageObjects;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import utils.ConfigReader;

public class Login_PageObjects {
	private WebDriver driver;
	private ConfigReader configReader = new ConfigReader();
	
	public Login_PageObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[contains(@src,'/logo.png')]")
	WebElement logo;

	@FindBy(xpath = "//input[@id='email']")
	WebElement username;

	@FindBy(xpath = "//input[@id='password']")
	WebElement password;

	@FindBy(xpath = "//button[@id='btn-login']")
	WebElement loginButton;

	@FindBy(xpath = "//a[@id='idDoNotRemember']")
	WebElement passwordReset;

	@FindBy(xpath = "//div[@data-el='appName']")
	WebElement header;

	public void launchURLAndLogin() {
		String env = configReader.getProp("environment");
		if (env.toLowerCase().equals("dev")) {
			driver.get(configReader.getProp("dev_myp2URL"));

			WebElement LoginLogo = new WebDriverWait(driver, Duration.ofSeconds(20))
					.until(ExpectedConditions.visibilityOf(logo));

			LoginLogo.isDisplayed();
			username.sendKeys(configReader.getProp("dev_userName"));
			password.sendKeys(configReader.getProp("dev_password"));
			passwordReset.isDisplayed();
			loginButton.click();

		} else if (env.toLowerCase().equals("uat")) {
			driver.get(configReader.getProp("uat_myp2URL"));

			WebElement LoginLogo = new WebDriverWait(driver, Duration.ofSeconds(20))
					.until(ExpectedConditions.visibilityOf(logo));

			LoginLogo.isDisplayed();

			username.sendKeys(configReader.getProp("uat_userName"));
			password.sendKeys(configReader.getProp("uat_password"));
			passwordReset.isDisplayed();
			loginButton.click();
		}
	}

	public boolean navigateHomePage() {
		WebElement homePage = new WebDriverWait(driver, Duration.ofSeconds(20))
				.until(ExpectedConditions.visibilityOf(header));
		return homePage.isDisplayed();
	}
}
