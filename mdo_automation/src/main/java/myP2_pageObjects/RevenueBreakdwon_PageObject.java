package myP2_pageObjects;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.ConstantsReader;
import utils.ElementUtils;

public class RevenueBreakdwon_PageObject {
	private WebDriver driver;
	ArrayList<String> propertyList = new ArrayList<>();
	boolean flag;
	private ConstantsReader configReader = new ConstantsReader();

	public RevenueBreakdwon_PageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		flag = false;
	}

	@FindBy(xpath = "//div[text()='Reports']//ancestor::li")
	WebElement reports;

	@FindBy(xpath = "//div[text()='Revenue']//ancestor::li")
	WebElement revenueBreakdown;

	@FindBy(xpath = "//div[text()='Revenue Breakdown']//ancestor::li")
	WebElement revenueBreakdownPage;

	@FindBy(xpath = "//tbody//tr[1]//td[1]")
	WebElement txtRowField;

	@FindBy(xpath = "//div[@data-el='appName']")
	WebElement header;

	@FindBy(xpath = "//input[@name='hotelId']")
	WebElement dropDownProperty;

	@FindBy(xpath = "//ul[@role='listbox']//li")
	List<WebElement> lstDropDowProperty;

	@FindBy(xpath = "//h1[text()='Revenue Breakdown Report']")
	WebElement RevenuePage;

	@FindBy(xpath = "//input[@name='period']")
	WebElement dropDownPeriod;

	@FindBy(xpath = "//ul[@role='listbox']//li")
	List<WebElement> lstDropDownPeriod;

	@FindBy(xpath = "//input[@name='mdoGlCodeBreakdownReportId']")
	WebElement dropDownCategory;

	@FindBy(xpath = "//ul[@role='listbox']//li")
	List<WebElement> lstDropDownCategory;

	@FindBy(xpath = "//div/label[text() = 'Date'] //following-sibling::div//button[@type='button']")
	WebElement btnDatePicker;

	@FindBy(xpath = "//div[@role='dialog']")
	WebElement divCalender;

	@FindBy(xpath = "//div[@role='presentation']//buttona")
	WebElement btnExpandYear;

	@FindBy(xpath = "//div[contains(@class, 'MuiPickersArrowSwitcher')]//button[@title='Previous month']")
	WebElement btnPreviousMonth;

	@FindBy(xpath = "//div[contains(@class, 'MuiPickersArrowSwitcher')]//button[@title='Next month']")
	WebElement btnNextMonth;

	@FindBy(xpath = "//button//span[text()='God']")
	WebElement btnGo;

	@FindBy(xpath = "//button[@data-el='menuToggle']")
	WebElement selector;
	
	@FindBy(xpath = "//div//label[text() = 'Date'] /following-sibling::div//input")
	WebElement txtDate;
	
	public void expandRevenue() throws InterruptedException {

		WebElement menu = new WebDriverWait(driver, Duration.ofSeconds(50))
				.until(ExpectedConditions.visibilityOf(selector));
		menu.click();
		
		WebElement reportsEle = new WebDriverWait(driver, Duration.ofSeconds(25))
				.until(ExpectedConditions.visibilityOf(reports));
		reportsEle.click();

		WebElement revenueBreakdownEle = new WebDriverWait(driver, Duration.ofSeconds(25))
				.until(ExpectedConditions.visibilityOf(revenueBreakdown));
		
		revenueBreakdownEle.click();

	}

	public boolean navigateToRevenueBreakDown() throws InterruptedException {

		Thread.sleep(3500);

		WebElement revenueBreakdownPageEle = new WebDriverWait(driver, Duration.ofSeconds(25))
				.until(ExpectedConditions.visibilityOf(revenueBreakdownPage));
		revenueBreakdownPageEle.click();

		WebElement RevenuePageEle = new WebDriverWait(driver, Duration.ofSeconds(25))
				.until(ExpectedConditions.visibilityOf(RevenuePage));
		return RevenuePageEle.isDisplayed();

	}

	public boolean loadReportWithParameters() throws InterruptedException {

		
		WebElement drpProperty = new WebDriverWait(driver, Duration.ofSeconds(50))
				.until(ExpectedConditions.visibilityOf(dropDownProperty));

		drpProperty.click();
		for (int i = 0; i < lstDropDowProperty.size(); i++) {
			if (lstDropDowProperty.get(i).getText().equalsIgnoreCase(configReader.getProp("revenueProperty"))) {
				lstDropDowProperty.get(i).click();

			}
		}
		Thread.sleep(1500);
		boolean status = selectDate();

		return status;

	}

	public int getMonth() {
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int month = cal.get(Calendar.MONTH);

		return month + 1;
	}

	public boolean selectDate() throws InterruptedException {
		boolean flag = false;
		String[] dateForPicker = configReader.getProp("revenueDate").split("/");

		txtDate.click();
		
		int status = driver.findElements(By.xpath("//div[@role='dialog']")).size();

		if (status == 1) {
			WebElement expandYear = new WebDriverWait(driver, Duration.ofSeconds(10))
					.until(ExpectedConditions.visibilityOf(btnExpandYear));
			expandYear.click();

			Thread.sleep(2500);

			WebElement pickYear = driver
					.findElement(By.xpath("//div[contains(@class, 'PrivatePickersYear')]//button [contains(text(), '"
							+ dateForPicker[2] + "')]"));

			pickYear.click();

			int monthInnum = getMonth();

			int monthDiff = monthInnum - Integer.parseInt(dateForPicker[0]);

			if (monthDiff > 0) {
				for (int i = 0; i < monthDiff; i++) {
					WebElement btnPrevious = new WebDriverWait(driver, Duration.ofSeconds(10))
							.until(ExpectedConditions.visibilityOf(btnPreviousMonth));

					btnPrevious.click();
					Thread.sleep(1500);

				}
				WebElement btnDate = driver
						.findElement(By.xpath(" //div[@role='cell']//button[text() = '" + dateForPicker[1] + "']"));

				btnDate.click();
				flag = true;
			}

			else if (monthDiff < 0) {
				for (int i = 0; i > monthDiff; i--) {
					WebElement btnNext = new WebDriverWait(driver, Duration.ofSeconds(10))
							.until(ExpectedConditions.visibilityOf(btnNextMonth));

					btnNext.click();
					Thread.sleep(1500);

				}
				WebElement btnDate = driver
						.findElement(By.xpath(" //div[@role='cell']//button[text() = '" + dateForPicker[1] + "']"));

				btnDate.click();
				flag = true;

			}

			else {
				WebElement btnDate = driver
						.findElement(By.xpath(" //div[@role='cell']//button[text() = '" + dateForPicker[1] + "']"));

				btnDate.click();
				flag = true;
			}

		} else {
			flag = false;
		}

		return flag;

	}

	public boolean loadRevenueReport() {

		btnGo.click();

		WebElement txtProperty = new WebDriverWait(driver, Duration.ofSeconds(40))
				.until(ExpectedConditions.visibilityOf(txtRowField));

		return txtProperty.isDisplayed();
	}

}
