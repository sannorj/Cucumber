package myP2_pageObjects;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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

	@FindBy(xpath = "//div[contains(text(),'Pickup Reports')]//ancestor::li")
	WebElement pickUpReports;

	@FindBy(xpath = "//div/a[contains(text(),'Pickup Report (New)')]//ancestor::li")
	WebElement pickUpReportPage;

	@FindBy(xpath = "//h1[text()='Pickup Report']")
	WebElement navigatedReportPage;

	@FindBy(xpath = "//div//label[text() = 'Business Date'] /following-sibling::div//input")
	WebElement txtBusinessDate;

	@FindBy(xpath = "//div//label[text() = 'Start Date'] /following-sibling::div//input")
	WebElement txtStartDate;

	@FindBy(xpath = "//div//label[text() = 'End Date'] /following-sibling::div//input")
	WebElement txtEndDate;

	@FindBy(xpath = "//button[@data-el='buttonGo']")
	WebElement btngo;

	@FindBy(xpath = "//*[@id='root']//table/tbody/tr/td[1]")
	List<WebElement> allData;

	@FindBy(xpath = "//div//label[text() = 'Business Date'] //following-sibling::div//button")
	WebElement btnBusinessDatePicker;

	@FindBy(xpath = "//div//label[text() = 'Start Date'] //following-sibling::div//button")
	WebElement btnStartDatePicker;

	@FindBy(xpath = "//div//label[text() = 'End Date'] //following-sibling::div//button")
	WebElement btnEndDatePicker;

	@FindBy(xpath = "//div[@role='dialog']")
	WebElement divCalender;

	@FindBy(xpath = "//div[@role='presentation']//button[contains(@aria-label, 'calendar view is open, switch to year view')]")
	WebElement btnExpandYear;

	@FindBy(xpath = "//div[contains(@class, 'MuiPickersArrowSwitcher')]//button[@title='Previous month']")
	WebElement btnPreviousMonth;

	@FindBy(xpath = "//div[contains(@class, 'MuiPickersArrowSwitcher')]//button[@title='Next month']")
	WebElement btnNextMonth;

	public int getMonth() {
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int month = cal.get(Calendar.MONTH);

		return month + 1;
	}

	public void validateOkCancelandClick() {
		int btnStatus = driver.findElements(By.xpath("//button[text()='OK']")).size();

		if (btnStatus > 0) {
			WebElement btnOk = driver.findElement(By.xpath("//button[text()='OK']"));
			btnOk.click();
		}

	}

	public void selectBusinessDate() throws InterruptedException {

		String[] dateForPicker = (configReader.getProp("businessDate") + "/" + configReader.getProp("businessYear"))
				.split("/");

		txtBusinessDate.click();

		int btnDatePickforLocal = driver
				.findElements(By.xpath("//div//label[text() = 'Business Date'] //following-sibling::div//button"))
				.size();

		if (btnDatePickforLocal > 0) {
			btnBusinessDatePicker.click();
		}

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

			Thread.sleep(2500);

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
						.findElement(By.xpath(" //div[@role='row']//button[text() = '" + dateForPicker[1] + "']"));

				btnDate.click();

				validateOkCancelandClick();
			}

			else if (monthDiff < 0) {
				for (int i = 0; i > monthDiff; i--) {
					WebElement btnNext = new WebDriverWait(driver, Duration.ofSeconds(10))
							.until(ExpectedConditions.visibilityOf(btnNextMonth));

					btnNext.click();
					Thread.sleep(1500);
				}

				WebElement btnDate = driver
						.findElement(By.xpath(" //div[@role='row']//button[text() = '" + dateForPicker[1] + "']"));

				btnDate.click();

				validateOkCancelandClick();
			}

			else {
				WebElement btnDate = driver
						.findElement(By.xpath(" //div[@role='row']//button[text() = '" + dateForPicker[1] + "']"));

				btnDate.click();

				validateOkCancelandClick();
			}

		}
	}

	public void selectStartDate() throws InterruptedException {
		String[] dateForPicker = (configReader.getProp("startDate") + "/" + configReader.getProp("businessYear"))
				.split("/");

		txtStartDate.click();

		int btnDatePickforLocal = driver
				.findElements(By.xpath("//div//label[text() = 'Start Date'] //following-sibling::div//button")).size();

		if (btnDatePickforLocal > 0) {
			btnStartDatePicker.click();
		}

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

			Thread.sleep(2500);

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
						.findElement(By.xpath(" //div[@role='row']//button[text() = '" + dateForPicker[1] + "']"));

				btnDate.click();

				validateOkCancelandClick();
			}

			else if (monthDiff < 0) {
				for (int i = 0; i > monthDiff; i--) {
					WebElement btnNext = new WebDriverWait(driver, Duration.ofSeconds(10))
							.until(ExpectedConditions.visibilityOf(btnNextMonth));

					btnNext.click();
					Thread.sleep(1500);
				}

				WebElement btnDate = driver
						.findElement(By.xpath(" //div[@role='row']//button[text() = '" + dateForPicker[1] + "']"));

				btnDate.click();

				validateOkCancelandClick();
			}

			else {
				WebElement btnDate = driver
						.findElement(By.xpath(" //div[@role='row']//button[text() = '" + dateForPicker[1] + "']"));

				btnDate.click();

				validateOkCancelandClick();
			}

		}

	}

	public void selectEndDate() throws InterruptedException {
		String[] dateForPicker = (configReader.getProp("endDate") + "/" + configReader.getProp("businessYear"))
				.split("/");

		txtEndDate.click();

		int btnDatePickforLocal = driver
				.findElements(By.xpath("//div//label[text() = 'End Date'] //following-sibling::div//button")).size();

		if (btnDatePickforLocal > 0) {
			btnEndDatePicker.click();
		}

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

			Thread.sleep(2500);

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
						.findElement(By.xpath(" //div[@role='row']//button[text() = '" + dateForPicker[1] + "']"));

				btnDate.click();

				validateOkCancelandClick();
			}

			else if (monthDiff < 0) {
				for (int i = 0; i > monthDiff; i--) {
					WebElement btnNext = new WebDriverWait(driver, Duration.ofSeconds(10))
							.until(ExpectedConditions.visibilityOf(btnNextMonth));

					btnNext.click();
					Thread.sleep(1500);
				}

				WebElement btnDate = driver
						.findElement(By.xpath(" //div[@role='row']//button[text() = '" + dateForPicker[1] + "']"));

				btnDate.click();

				validateOkCancelandClick();
			}

			else {
				WebElement btnDate = driver
						.findElement(By.xpath(" //div[@role='row']//button[text() = '" + dateForPicker[1] + "']"));

				btnDate.click();

				validateOkCancelandClick();
			}

		}

	}

	public void expandPickupReport() {

		try {
			WebElement menu = new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(mainMenuButton));
			menu.click();
			Thread.sleep(1500);

			WebElement reportsEle = new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(reports));
			reportsEle.click();

			WebElement revenueEle = new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(reveneue));
			revenueEle.click();

			WebElement pickUpReportsEle = new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(pickUpReports));
			pickUpReportsEle.click();

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public boolean navigatePickupReportPage() {

		WebElement pickUpReportPageEle = new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(pickUpReportPage));
		pickUpReportPageEle.click();

		WebElement pickupPage = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(navigatedReportPage));
		return pickupPage.isDisplayed();

	}

	public void storeAlltheActualData() {
		try {
			selectBusinessDate();

			Thread.sleep(5000);

			selectStartDate();

			Thread.sleep(5000);

			selectEndDate();

			Thread.sleep(5000);

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
			Date formattedBusinessDate = StartDateformatter
					.parse(configReader.getProp("businessDate") + "/" + configReader.getProp("businessYear"));
			Date formattedStartDate = BusinessDateformatter
					.parse(configReader.getProp("startDate") + "/" + configReader.getProp("businessYear"));

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
