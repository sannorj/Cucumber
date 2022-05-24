package myP2_pageObjects;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.ConstantsReader;

public class PickupReport_PageObjective {
	private WebDriver driver;
	ArrayList<Date> actualValues;
	String businessYear, businessDate, startDate, endDate;
	private ConstantsReader configReader = new ConstantsReader();

	public PickupReport_PageObjective(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		actualValues = new ArrayList<Date>();
		businessYear = "2022";
		startDate = "02/01";
		startDate = "02/21";
		endDate = "02/28";

	}

	@FindBy(xpath = "//button[@data-el='menuToggle']")
	WebElement mainMenuButton;

	@FindBy(xpath = "//div[text()='Reports']//ancestor::li")
	WebElement reports;

	@FindBy(xpath = "//div[text()='Revenue']//ancestor::li")
	WebElement reveneue;

	@FindBy(xpath = "//div[text()='Pickup Reports']//ancestor::li")
	WebElement pickUpReports;

	@FindBy(xpath = "//div[text()='Pickup Report']//ancestor::li")
	WebElement pickUpReportPage;

	@FindBy(xpath = "//h1[text()='Pickup Report']")
	WebElement navigatedReportPage;

	@FindBy(xpath = "//input[@name='businessDate']")
	WebElement txtBusinessDate;

	@FindBy(xpath = "//input[@name='startDate']")
	WebElement txtStartDate;

	@FindBy(xpath = "//input[@name='endDate']")
	WebElement txtEndDate;

	@FindBy(xpath = "//button[@data-el='buttonGo']")
	WebElement btngo;

	@FindBy(xpath = "//*[@id='root']//table/tbody/tr/td[1]")
	List<WebElement> allData;

	public void expandPickupReport() {

		try {
			WebElement menu = new WebDriverWait(driver, Duration.ofSeconds(20))
					.until(ExpectedConditions.visibilityOf(mainMenuButton));
			menu.click();
			/* mandatory pause */
			Thread.sleep(1500);

			WebElement reportsEle = new WebDriverWait(driver, Duration.ofSeconds(20))
					.until(ExpectedConditions.visibilityOf(reports));
			reportsEle.click();

			WebElement revenueEle = new WebDriverWait(driver, Duration.ofSeconds(20))
					.until(ExpectedConditions.visibilityOf(reveneue));
			revenueEle.click();

			WebElement pickUpReportsEle = new WebDriverWait(driver, Duration.ofSeconds(20))
					.until(ExpectedConditions.visibilityOf(pickUpReports));
			pickUpReportsEle.click();

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public boolean navigatePickupReportPage() {

		WebElement pickUpReportPageEle = new WebDriverWait(driver, Duration.ofSeconds(20))
				.until(ExpectedConditions.visibilityOf(pickUpReportPage));
		pickUpReportPageEle.click();

		WebElement pickupPage = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.visibilityOf(navigatedReportPage));
		return pickupPage.isDisplayed();

	}

	public void storeAlltheActualData() {
		try {
			txtBusinessDate.sendKeys(Keys.CONTROL + "a");
			txtBusinessDate.sendKeys(Keys.DELETE);
			txtBusinessDate.sendKeys(configReader.getProp("businessDate") + "/" + configReader.getProp("businessYear"));

			txtStartDate.sendKeys(Keys.CONTROL + "a");
			txtStartDate.sendKeys(Keys.DELETE);
			txtStartDate.sendKeys(configReader.getProp("startDate") + "/" + configReader.getProp("businessYear"));

			txtEndDate.sendKeys(Keys.CONTROL + "a");
			txtEndDate.sendKeys(Keys.DELETE);
			txtEndDate.sendKeys(configReader.getProp("endDate") + "/" + configReader.getProp("businessYear"));

			btngo.click();

			Thread.sleep(2500);

			SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
			for (int i = 0; i < allData.size(); i++) {
				if (allData.get(i).getText().contains(configReader.getProp("businessYear"))) {
					Date formattedActualDate = formatter.parse(allData.get(i).getText().replace(" ", "-"));

					actualValues.add(formattedActualDate);
				}

			}

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public boolean compareDates() {

		boolean flag = true;
		SimpleDateFormat BusinessDateformatter = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat StartDateformatter = new SimpleDateFormat("dd/MM/yyyy");

		try {
			Date formattedBusinessDate = StartDateformatter.parse(configReader.getProp("startDate")+"/"+configReader.getProp("businessYear"));
			Date formattedStartDate = BusinessDateformatter.parse(configReader.getProp("businessDate")+"/"+configReader.getProp("businessYear"));

			if (actualValues.get(0).compareTo(formattedStartDate) == 0
					|| actualValues.get(0).compareTo(formattedStartDate) > 0) {
				if (actualValues.get(actualValues.size() - 1).compareTo(formattedBusinessDate) == 0
						|| actualValues.get(actualValues.size() - 1).compareTo(formattedBusinessDate) < 0) {

					flag = true;
				} else {
					flag = false;
				}

			} else {
				flag = false;
			}

		} catch (ParseException e) {
			e.printStackTrace();
		}
		return flag;

	}
}
