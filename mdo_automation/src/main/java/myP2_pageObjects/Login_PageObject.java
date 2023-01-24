package myP2_pageObjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.ConfigReader;
import utils.ElementUtils;

public class Login_PageObject {
	private WebDriver driver;
	private ConfigReader configReader = new ConfigReader();

	public Login_PageObject(WebDriver driver) {
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

	@FindBy(xpath = "//h1[text()='Primary Dashboard']")
	WebElement lblPrimary;

	public void launchURLAndLogin() throws InterruptedException {
		String environmentJenkin = System.getProperty("environment");
		String env = configReader.getProp("environment");
		System.out.println("environmentJenkin : " + environmentJenkin);
		System.out.println("env : " + env);
		String myEnv = null;
		if (environmentJenkin != null) {
			myEnv = environmentJenkin;
		} else {
			myEnv = env;
		}

		if (myEnv.toLowerCase().equals("dev")) {
			Thread.sleep(5000);
			driver.get(configReader.getProp("dev_myp2URL"));

			WebElement LoginLogo = new WebDriverWait(driver, Duration.ofSeconds(20))
					.until(ExpectedConditions.visibilityOf(logo));

			LoginLogo.isDisplayed();
			Thread.sleep(5000);
			username.sendKeys(configReader.getProp("dev_userName"));
			password.sendKeys(configReader.getProp("dev_password"));
			passwordReset.isDisplayed();
			Thread.sleep(12000);
			// loginButton.click();
			try {
				JavascriptExecutor executor = (JavascriptExecutor) driver;
				executor.executeScript("arguments[0].click();", loginButton);
			} catch (Exception e) {
				JavascriptExecutor executor = (JavascriptExecutor) driver;
				executor.executeScript("arguments[0].click();", loginButton);
			}

		} else if (myEnv.toLowerCase().equals("uat")) {
			driver.get(configReader.getProp("uat_myp2URL"));
			Thread.sleep(12000);
			WebElement LoginLogo = new WebDriverWait(driver, Duration.ofSeconds(20))
					.until(ExpectedConditions.visibilityOf(logo));

			LoginLogo.isDisplayed();

			username.sendKeys(configReader.getProp("uat_userName"));
			password.sendKeys(configReader.getProp("uat_password"));
			passwordReset.isDisplayed();
			// loginButton.click();
			try {
				JavascriptExecutor executor = (JavascriptExecutor) driver;
				executor.executeScript("arguments[0].click();", loginButton);
			} catch (Exception e) {
				JavascriptExecutor executor = (JavascriptExecutor) driver;
				executor.executeScript("arguments[0].click();", loginButton);
			}
		}
		/*
		 * if(environmentJenkin != null) { if
		 * (environmentJenkin.toLowerCase().equals("dev")) {
		 * driver.get(configReader.getProp("dev_myp2URL"));
		 * 
		 * WebElement LoginLogo = new WebDriverWait(driver, Duration.ofSeconds(20))
		 * .until(ExpectedConditions.visibilityOf(logo));
		 * 
		 * LoginLogo.isDisplayed();
		 * username.sendKeys(configReader.getProp("dev_userName"));
		 * password.sendKeys(configReader.getProp("dev_password"));
		 * passwordReset.isDisplayed(); loginButton.click();
		 * 
		 * } else if (environmentJenkin.toLowerCase().equals("uat")) {
		 * driver.get(configReader.getProp("uat_myp2URL"));
		 * 
		 * WebElement LoginLogo = new WebDriverWait(driver, Duration.ofSeconds(20))
		 * .until(ExpectedConditions.visibilityOf(logo));
		 * 
		 * LoginLogo.isDisplayed();
		 * 
		 * username.sendKeys(configReader.getProp("uat_userName"));
		 * password.sendKeys(configReader.getProp("uat_password"));
		 * passwordReset.isDisplayed(); loginButton.click(); } }else { if
		 * (env.toLowerCase().equals("dev")) {
		 * driver.get(configReader.getProp("dev_myp2URL"));
		 * 
		 * WebElement LoginLogo = new WebDriverWait(driver, Duration.ofSeconds(20))
		 * .until(ExpectedConditions.visibilityOf(logo));
		 * 
		 * LoginLogo.isDisplayed();
		 * username.sendKeys(configReader.getProp("dev_userName"));
		 * password.sendKeys(configReader.getProp("dev_password"));
		 * passwordReset.isDisplayed(); loginButton.click();
		 * 
		 * } else if (env.toLowerCase().equals("uat")) {
		 * driver.get(configReader.getProp("uat_myp2URL"));
		 * 
		 * WebElement LoginLogo = new WebDriverWait(driver, Duration.ofSeconds(20))
		 * .until(ExpectedConditions.visibilityOf(logo));
		 * 
		 * LoginLogo.isDisplayed();
		 * 
		 * username.sendKeys(configReader.getProp("uat_userName"));
		 * password.sendKeys(configReader.getProp("uat_password"));
		 * passwordReset.isDisplayed(); loginButton.click(); } }
		 */
	}

	public boolean navigateHomePage() throws InterruptedException {
		Thread.sleep(15000);
		WebElement homePage = new WebDriverWait(driver, Duration.ofSeconds(300)).until(ExpectedConditions.visibilityOf(header));
		return homePage.isDisplayed();
	}
}
