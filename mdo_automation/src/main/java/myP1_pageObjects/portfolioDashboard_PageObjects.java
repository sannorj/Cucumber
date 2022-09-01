package myP1_pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class portfolioDashboard_PageObjects {
	
	private WebDriver driver;
	public portfolioDashboard_PageObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//i[@class='fa fa-bars'])[2]")
	WebElement sideBarMenue;
	
	@FindBy(xpath = "//span[text()='Dashboard']//ancestor::a")
	WebElement dashboardMenue;
	
	
	@FindBy(xpath = "//span[text()=' Portfolio']//ancestor::a")
	WebElement PortfolioMenue;
	
	@FindBy(xpath = "//h2[text()='Portfolio Dashboardd']")
	WebElement PortfolioHeader;
	
	public void navigateToDashboard() {
		WebElement sidebar = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.visibilityOf(sideBarMenue)); 
		try {
			sidebar.click();
			Thread.sleep(3000);
			dashboardMenue.click();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public boolean navigateToPortfolio() throws InterruptedException {
		boolean result = false;
		WebElement portfolio = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.visibilityOf(PortfolioMenue));
			portfolio.click();
			Thread.sleep(5000);
			if(PortfolioHeader.isDisplayed()) {
				result = true;
			}
		return result;
	}

}
