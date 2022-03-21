package myP2_pageObjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PnLYearly_PageObject {
	
	private WebDriver driver;	
	
	public PnLYearly_PageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//button[@data-el='menuToggle']")
	WebElement mainMenuButton;
	
	@FindBy(xpath = "//div[text()='Reports']//ancestor::li")
	WebElement reports;
	
	@FindBy(xpath = "//div[text()='P&L Statements']//ancestor::li")
	WebElement pnlStatement;
	
	@FindBy(xpath = "//div[text()='P&L Yearly']//ancestor::li")
	WebElement pnlYearly;
	
	@FindBy(xpath = "//h1[text()='Profit & Loss Yearly Report']")
	WebElement pnlYearlyPage;
	
	public void expandPnLStatement() {
		WebElement menu = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.visibilityOf(mainMenuButton));
		menu.click();
		
		WebElement reportsEle = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.visibilityOf(reports));
		reportsEle.click();
		
		WebElement pnlStatementEle = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.visibilityOf(pnlStatement));
		pnlStatementEle.click();

	}
	
	public boolean navigatePnLYearlyPage() {
		WebElement pnlYearlyEle = new WebDriverWait(driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.visibilityOf(pnlYearly));
		pnlYearlyEle.click();
		
		WebElement pnlYearlyPageEle = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.visibilityOf(pnlYearlyPage));
		return pnlYearlyPageEle.isDisplayed();
		
	}

}
