package myP1_pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.ConstantsReader;

public class trendsDashboard_PageObjects {

	private WebDriver driver;
	private ConstantsReader configReader = new ConstantsReader();

	public trendsDashboard_PageObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='sidebar-header']")
	WebElement navigationLink;

	@FindBy(xpath = "//a//span[text()='Dashboard']")
	WebElement dashboardLink;

	@FindBy(xpath = "//a//span[contains(text(),'Trends')]")
	WebElement trendsLink;

	@FindBy(xpath = "//h2[text()='Trends']")
	WebElement trendsTitle;

	@FindBy(xpath = "//div[@id='s2id_ddlYTDRollingRevenue']")
	WebElement periodSelect;

	@FindBy(xpath = "(//select[@class='form-control select2-offscreen'])[1]")
	WebElement propertyDropdown;

	@FindBy(xpath = "//input[@id='txtDate']")
	WebElement datePickerVal;

	@FindBy(xpath = "//button[@title='Search']")
	WebElement searchBtn;

	@FindBy(xpath = "//header[@class='panel-heading portlet-handler']")
	List<WebElement> panelLst;

	public void navigateTrends() {
		navigationLink.click();
		WebElement dashboardLinkView = new WebDriverWait(driver, Duration.ofSeconds(700))
				.until(ExpectedConditions.visibilityOf(dashboardLink));
		dashboardLinkView.click();
		WebElement trendsLinkView = new WebDriverWait(driver, Duration.ofSeconds(700))
				.until(ExpectedConditions.visibilityOf(trendsLink));
		trendsLinkView.click();
		WebElement trendsTitleView = new WebDriverWait(driver, Duration.ofSeconds(700))
				.until(ExpectedConditions.visibilityOf(trendsTitle));
	}

	public boolean filterData() throws InterruptedException {
		Thread.sleep(7000);
		WebElement panelLoad = new WebDriverWait(driver, Duration.ofSeconds(700)).until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//header[@class='panel-heading portlet-handler']")));
		periodSelect.click();
		WebElement periodOpt = new WebDriverWait(driver, Duration.ofSeconds(100)).until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//select[@id='ddlYTDRollingRevenue']//option[text()='"
						+ configReader.getMYP1Prop("Trends_PeriodOption") + "']")));
		periodOpt.click();
		Thread.sleep(3000);
		Select drpHotel = new Select(propertyDropdown);
		WebElement waitHotelLoad = new WebDriverWait(driver, Duration.ofSeconds(100))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='ddlHotels']//option")));
//		Thread.sleep(5000);
		drpHotel.selectByVisibleText(configReader.getMYP1Prop("Trends_Hotel"));

		datePickerVal.sendKeys(Keys.CONTROL + "a");
		datePickerVal.sendKeys(Keys.DELETE);
		datePickerVal.sendKeys(configReader.getMYP1Prop("Trends_Date"));
		Thread.sleep(3000);
		searchBtn.click();
		Thread.sleep(7000);
		return true;
	}

	public void verifyCards() throws InterruptedException {
		for (int i = 0; i < panelLst.size(); i++) {
			int val = i + 1;
			WebElement cardMinimize = new WebDriverWait(driver, Duration.ofSeconds(700))
					.until(ExpectedConditions.visibilityOfElementLocated(
							By.xpath("(//header[@class='panel-heading portlet-handler']//div[@class='panel-actions'])["
									+ val + "]")));
			cardMinimize.click();
			WebElement viewChartCollapsed = new WebDriverWait(driver, Duration.ofSeconds(700))
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
							"//header[@class='panel-heading portlet-handler']//ancestor::section[@class='panel panel-primary panel-collapsed']")));
			WebElement cardFullName = new WebDriverWait(driver, Duration.ofSeconds(700))
					.until(ExpectedConditions.visibilityOfElementLocated(
							By.xpath("(//header[@class='panel-heading portlet-handler']//a[@title='View Large'])[" + val
									+ "]")));
			cardFullName.click();
			Thread.sleep(3000);
			WebElement viewChart = new WebDriverWait(driver, Duration.ofSeconds(700))
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
							"(//header[@class='panel-heading portlet-handler']//following::div[@class='modal-dialog']//div[@class='modal-body panel-body'])["
									+ val + "]")));
			Thread.sleep(3000);
			WebElement closeBtn = new WebDriverWait(driver, Duration.ofSeconds(700))
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
							"(//header[@class='panel-heading portlet-handler']//following::div[@class='modal-dialog']//button[@class='close'])["
									+ val + "]")));
			closeBtn.click();
		}
	}

}
