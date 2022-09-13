package myP1_pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.ConstantsReader;

public class portfolioDashboard_SearchVal_PageObjects {
	
	private WebDriver driver;
	private ConstantsReader configReader = new ConstantsReader();

	public portfolioDashboard_SearchVal_PageObjects(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@name='adminPortfolioSearch']")
	WebElement searchInput;

	public void addVal() {
		searchInput.sendKeys(Keys.CONTROL + "a");
		searchInput.sendKeys(Keys.DELETE);
		searchInput.sendKeys(configReader.getMYP1Prop("Portfolio_SearchVal"));
	}

	public boolean searchVal() throws InterruptedException {
		Thread.sleep(5000);
		boolean isRowVisible = driver.findElement(By.xpath("//table[@id='adminPortfolio']//tbody//tr[not(contains(@style,'display: none;') or contains(@class,'hidden'))][1]")).isDisplayed();
		System.out.println("Filtered rows Visible=="+isRowVisible);
		if(!isRowVisible) {
			System.out.println("Similar rows not available!");
			return true;
		}
		String ele = driver.findElement(By.xpath("//table[@id='adminPortfolio']//tbody//tr[not(contains(@style,'display: none;') or contains(@class,'hidden'))][1]")).getAttribute("textContent");
		
		String searchVal=configReader.getMYP1Prop("Portfolio_SearchVal");
		if (ele.contains(searchVal)) {
			System.out.println("Search value is filtered!");
			return true;
		}else {

			System.out.println("Values not filtered!");
			return false;
		}
		
	}

	
	

}
