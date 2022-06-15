package myP1_pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class propertyDashboard_PageObjects {
	
	private WebDriver driver;
	public propertyDashboard_PageObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[text()='Property']//ancestor::a")
	WebElement propertyMenue;
	
	@FindBy(xpath = "//h2[text()='Portfolio Dashboard']")
	WebElement propertyHeader;
	
	@FindBy(xpath = "(//select[@class='form-control select2-offscreen'])[1]")
	WebElement propertyDropdown;
	
	@FindBy(xpath = "//button[@id='btnSearch']")
	WebElement searchBTN;
	
	@FindBy(xpath = "//h2[text()='Occupancy']")
	WebElement propertyDashboardPage;
	
	@FindBy(xpath = "//a[@id='alnkrevenueBreakdown']")
	WebElement revenueBreakdownLink;
	
	@FindBy(xpath = "(//h2[text()='Revenue Breakdown'])[2]")
	WebElement revenueBreakdownHeader;
	
	public boolean navigateToProperty() throws InterruptedException {
		boolean result = false;
		WebElement portfolio = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.visibilityOf(propertyMenue));
			portfolio.click();
			Thread.sleep(5000);
			if(propertyHeader.isDisplayed()) {
				result = true;
			}
			return result;
	}
	
	public void selectPropertyValues() throws InterruptedException {
		Thread.sleep(10000);
		Select drpHotel = new Select(propertyDropdown);
		drpHotel.selectByVisibleText("24 North");
		Thread.sleep(3000);
		try {
			searchBTN.click();
		} catch (Exception e) {
			System.out.println(e);
		}
		Thread.sleep(8000);
	}
	
	public boolean navigateToPropertyDashboard() {
		boolean result = false;
		if(propertyDashboardPage.isDisplayed()) {
			result = true;
		}
		return result;
	}
	
	public void navigateToRevenueBreakdown() throws InterruptedException {
		Thread.sleep(10000);
		revenueBreakdownLink.click();
	}
	
	public boolean verifyToPropertyDashboard() {
		boolean result = false;
		if(revenueBreakdownHeader.isDisplayed()) {
			result = true;
		}
		return result;
	}

}
