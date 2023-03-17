package myP1_pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.ConstantsReader;

public class propertyDashboard_LinksVerify_PageObjects {

	private WebDriver driver;
	private ConstantsReader configReader = new ConstantsReader();

	public propertyDashboard_LinksVerify_PageObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@id='alnkRoomRevenueSummary']")
	WebElement StatsByDateRangeLink;

	@FindBy(xpath = "//h2[@id='heading-title']")
	WebElement StatsByDateRangeHeading;

	@FindBy(xpath = "//a[@id='alnkSTRReport']")
	WebElement alnkSTRReportLink;

	@FindBy(xpath = "//h2[@id='heading-title']")
	WebElement alnkSTRReportHeading;

	@FindBy(xpath = "//a[@id='alnkPickupReport']")
	WebElement alnkPickupReportLink;

	@FindBy(xpath = "//h2[@id='heading-title']")
	WebElement alnkPickupReportHeading;

	@FindBy(xpath = "//a[@id='alnkLabor']")
	WebElement alnkLaborLink;

	@FindBy(xpath = "//h2[@id='heading-title']")
	WebElement alnkLaborHeading;

	@FindBy(xpath = "//button[@id='btnDownloadVD']")
	WebElement downloadBtn;

	public boolean verifyStatsByDateRange() throws InterruptedException {
		WebElement MainPage = new WebDriverWait(driver, Duration.ofSeconds(500))
				.until(ExpectedConditions.visibilityOf(alnkSTRReportLink));
		StatsByDateRangeLink.click();
		WebElement StatsByDateRangePage = new WebDriverWait(driver, Duration.ofSeconds(500))
				.until(ExpectedConditions.visibilityOf(StatsByDateRangeHeading));
		boolean StatsByDateRangeFlag = StatsByDateRangePage.isDisplayed();
		System.out.println("Stats By Date Range Page is displayed: " + StatsByDateRangeFlag);
		return StatsByDateRangeFlag;
	}

	public boolean verifySTRreport() throws InterruptedException {
		WebElement MainPage = new WebDriverWait(driver, Duration.ofSeconds(500))
				.until(ExpectedConditions.visibilityOf(alnkSTRReportLink));
		alnkSTRReportLink.click();
		WebElement STRReportPage = new WebDriverWait(driver, Duration.ofSeconds(500))
				.until(ExpectedConditions.visibilityOf(alnkSTRReportHeading));
		boolean STRReportPageFlag = STRReportPage.isDisplayed();
		System.out.println("STRReport Page is displayed: " + STRReportPageFlag);
		return STRReportPageFlag;
	}

	public boolean verifyPickUpReport() throws InterruptedException {
		WebElement MainPage = new WebDriverWait(driver, Duration.ofSeconds(500))
				.until(ExpectedConditions.visibilityOf(alnkPickupReportLink));
		alnkPickupReportLink.click();
		WebElement PickupReportPage = new WebDriverWait(driver, Duration.ofSeconds(500))
				.until(ExpectedConditions.visibilityOf(alnkPickupReportHeading));
		boolean PickupReportPageFlag = PickupReportPage.isDisplayed();
		System.out.println("Pick Up Report Page is displayed: " + PickupReportPageFlag);
		return PickupReportPageFlag;
	}

	public boolean verifyLaborReport() throws InterruptedException {
		WebElement MainPage = new WebDriverWait(driver, Duration.ofSeconds(500))
				.until(ExpectedConditions.visibilityOf(alnkLaborLink));
		alnkLaborLink.click();
		WebElement LaborDashboardPage = new WebDriverWait(driver, Duration.ofSeconds(500))
				.until(ExpectedConditions.visibilityOf(alnkLaborHeading));
		boolean LaborDashboardFlag = LaborDashboardPage.isDisplayed();
		System.out.println("Labour Dashboard Page is displayed: " + LaborDashboardFlag);
		return LaborDashboardFlag;
	}


}
