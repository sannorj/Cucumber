package myP1_pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.ConfigReader;

public class myP1_LoginPage_Objects {
	private WebDriver driver;
	private ConfigReader configReader = new ConfigReader();
	
	public myP1_LoginPage_Objects(WebDriver driver) {
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

	@FindBy(xpath = "//a[contains(text(),'remember your password?')]")
	WebElement passwordReset;

	@FindBy(xpath = "(//img[@alt='mydigitaloffice logo'])[2]")
	WebElement header;
	
	@FindBy(xpath = "//button[contains(text(),'Advanced')]")
	WebElement advancedBtn;
	
	@FindBy(xpath = "//a[@id='proceed-link']")
	WebElement processLink;

	public void launchURLAndLogin() {
		String environmentJenkin = System.getProperty("environment");
		String env = configReader.getMYP1Prop("environment");
		String myEnv = null;
		if(environmentJenkin != null) {
			//myEnv = environmentJenkin;
			myEnv = env;
		}else {
			myEnv = env;
		}
		
		if (myEnv.toLowerCase().equals("uat")) {
			driver.get(configReader.getMYP1Prop("uat_myp1URL"));
			acceptUnAuthorized();
			WebElement LoginLogo = new WebDriverWait(driver, Duration.ofSeconds(20))
					.until(ExpectedConditions.visibilityOf(logo));

			LoginLogo.isDisplayed();
			username.sendKeys(configReader.getMYP1Prop("uat_userName"));
			password.sendKeys(configReader.getMYP1Prop("uat_password"));
			passwordReset.isDisplayed();
			loginButton.click();

		} else {
			System.out.println("Provide avalid environment name");
		}
	}

	public boolean navigateHomePage() {
		WebElement homePage = new WebDriverWait(driver, Duration.ofSeconds(20))
				.until(ExpectedConditions.visibilityOf(header));
		return homePage.isDisplayed();
	}
	
	public void acceptUnAuthorized() {
		try {
			Thread.sleep(5000);
			advancedBtn.click();
			Thread.sleep(2000);
			processLink.click();
			Thread.sleep(8000);
		} catch (Exception e) {
			System.out.println("Not showing - Your connection isn't private page");
		}
	}
}
