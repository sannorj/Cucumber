package myP1_pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.ConstantsReader;
import utils.ElementUtils;

public class portfolioDashboard_DayMonthYearVerify_PageObjects {
	
	private WebDriver driver;
	private ConstantsReader configReader = new ConstantsReader();

	public portfolioDashboard_DayMonthYearVerify_PageObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@id='aMonth']")
	WebElement monthBtn;

	@FindBy(xpath = "//a[@id='aYear']")
	WebElement yearBtn;

	@FindBy(xpath = "//h2[text()='Dashboard']")
	WebElement DashboardHeading;
	

	public void clickMonthBtn() throws InterruptedException {
		try {
			monthBtn.click();
		} catch (TimeoutException e) {
//			System.out.println("errorrrrrrrrrrrr"+ e);
		}
	}

	public boolean navigateToMonthPg() {
		WebElement weekHeading = new WebDriverWait(driver, Duration.ofSeconds(700))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Week')]")));
		System.out.println("Month Page Landed!");
		return true;
	}

	public void clickYearBtn() {
		yearBtn.click();
	}

	public boolean navigateToYearPg() {
		WebElement YearPageView = new WebDriverWait(driver, Duration.ofSeconds(700))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='January']")));
		System.out.println("Year Page Landed!");
		return true;
	}
	

}
