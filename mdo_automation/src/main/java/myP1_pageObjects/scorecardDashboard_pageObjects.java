package myP1_pageObjects;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.ConfigReader;
import utils.ConstantsReader;

public class scorecardDashboard_pageObjects {
	private WebDriver driver;
	private ConstantsReader configReader = new ConstantsReader();

	public scorecardDashboard_pageObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='sidebar-header']")
	WebElement navigationLink;

	@FindBy(xpath = "//a//span[text()='Dashboard']")
	WebElement dashboardLink;

	@FindBy(xpath = "//a//span[contains(text(),'Scorecard')]")
	WebElement scorecardLink;

	@FindBy(xpath = "//h2[text()='Scorecard']")
	WebElement scorecardTitle;

	@FindBy(xpath = "//div[@id='s2id_ddlPeriod']//a")
	WebElement periodSelect;

	@FindBy(xpath = "//input[@id='s2id_autogen2_search']")
	WebElement periodSearch;

	@FindBy(xpath = "(//select[@class='form-control select2-offscreen'])[1]")
	WebElement propertyDropdown;

	@FindBy(xpath = "//input[@id='txtDate']")
	WebElement datePickerVal;

	@FindBy(xpath = "//button[@title='Search']")
	WebElement searchBtn;

	@FindBy(xpath = "//div[@id='sortablescorecard']//section//div[@class='panel-body']//div")
	WebElement isTblLoaded;

	@FindBy(xpath = "//div[@id='formAddChartBody']//section//div[@class='form-group']//div//div[contains(@class,'switch switch-sm switch-success')]//input")
	List<WebElement> chartsLst;

	@FindBy(xpath = "//div[@id='formAddChartBody']//section//div[@class='form-group']//div//div[contains(@class,'switch switch-sm switch-success')]//div[@class='ios-switch on']//following-sibling::input[1]")
	List<WebElement> enabledChartsLst;

	@FindBy(xpath = "//div[@id='sortablescorecard']//div//section")
	List<WebElement> viewChartsLst;

	public void navigateScorecard() {
		navigationLink.click();
		WebElement dashboardLinkView = new WebDriverWait(driver, Duration.ofSeconds(700))
				.until(ExpectedConditions.visibilityOf(dashboardLink));
		dashboardLinkView.click();
		WebElement scorecardLinkView = new WebDriverWait(driver, Duration.ofSeconds(700))
				.until(ExpectedConditions.visibilityOf(scorecardLink));
		scorecardLinkView.click();
		WebElement scorecardTitleView = new WebDriverWait(driver, Duration.ofSeconds(700))
				.until(ExpectedConditions.visibilityOf(scorecardTitle));
		WebElement isAllTblLoaded = new WebDriverWait(driver, Duration.ofSeconds(700))
				.until(ExpectedConditions.visibilityOf(isTblLoaded));
	}

	public void verifyDataLoaded() throws InterruptedException {
		Thread.sleep(7000);
		WebElement profitLbl = new WebDriverWait(driver, Duration.ofSeconds(700))
				.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath("//header[@class='panel-heading']//div[contains(text(),'Profitability To Plan')]")));
		periodSelect.click();
		WebElement periodOpt = new WebDriverWait(driver, Duration.ofSeconds(100)).until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@id='select2-drop']//ul//li//div[contains(text(),'"
						+ configReader.getMYP1Prop("Scorecard_PeriodOption") + "')]")));
		periodOpt.click();
		Thread.sleep(5000);
		Select drpHotel = new Select(propertyDropdown);
		Thread.sleep(5000);
		drpHotel.selectByVisibleText(configReader.getMYP1Prop("Scorecard_Hotel"));

		datePickerVal.sendKeys(Keys.CONTROL + "a");
		datePickerVal.sendKeys(Keys.DELETE);
		datePickerVal.sendKeys(configReader.getMYP1Prop("Scorecard_Date"));
		Thread.sleep(3000);
		searchBtn.click();
		Thread.sleep(7000);

	}

	public boolean verifyAllCardLoaded() throws InterruptedException {
		Thread.sleep(3000);
		if (enabledChartsLst.size() != viewChartsLst.size()) {
			System.out.println("All enabled cards not showing!!");
			return false;
		}
		boolean allVisibleChartView = true;
		for (int i = 0; i < enabledChartsLst.size(); i++) {
			String cardFullName = enabledChartsLst.get(i).getAttribute("name");
			String cardName = cardFullName.replace("Scorecard", "");
			System.out.println("cardId=" + cardName);
			boolean viewCards = false;

			viewCards = new WebDriverWait(driver, Duration.ofSeconds(100))
					.until(ExpectedConditions
							.visibilityOfElementLocated(By.xpath("//section[@id='panel-" + cardName + "']")))
					.isDisplayed();
			System.out.println("viewCards=" + viewCards);

			if (!viewCards) {
				return false;
			} else {
				allVisibleChartView = true;
			}

		}
		return allVisibleChartView;
	}

	public boolean IsCardsViews() {
		boolean isCardDisplayed = true;
		for (int i = 0; i < enabledChartsLst.size(); i++) {
			String cardFullName = enabledChartsLst.get(i).getAttribute("name");
			String cardName = cardFullName.replace("Scorecard", "");
			System.out.println("cardId=" + cardName);
			WebElement cardMinimize = new WebDriverWait(driver, Duration.ofSeconds(100))
					.until(ExpectedConditions.visibilityOfElementLocated(
							By.xpath("//div[@id='sortablescorecard']//div//section[@id='panel-" + cardName + "']//a")));
			cardMinimize.click();

//			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
//			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='sortablescorecard']//div//section[@id='" + cardName + "']//div[@class='panel-body']"))); 
//			
//			cardMinimize.click();
//
		 isCardDisplayed = new WebDriverWait(driver, Duration.ofSeconds(300)).until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//div[@id='sortablescorecard']//div//section[@id='panel-" + cardName +"' and @class='panel panel-primary panel-collapsed']//a"))).isDisplayed();
		 
		 if(!isCardDisplayed) {
			 isCardDisplayed = false;
		 }
		}
		return isCardDisplayed;
	}
	
}
