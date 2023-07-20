package myP2_pageObjects;

import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.ConstantsReader;
import utils.ElementUtils;

public class PnLYearlyMainHeaderTitle_PageObject {

	private WebDriver driver;
	private ConstantsReader configReader = new ConstantsReader();

	public PnLYearlyMainHeaderTitle_PageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@id='mui-component-select-columns[0].dataType']")
	WebElement drpColumn1;

	@FindBy(xpath = "//div[@id='mui-component-select-columns[0].yearOffest']")
	WebElement drpYear1;

	@FindBy(xpath = "//h3[text()='Edit Columns']")
	WebElement lblEdit;

	@FindBy(xpath = "//ul[@role='listbox']//li")
	List<WebElement> lstDropDownGroup;

	@FindBy(xpath = "//button[@data-el='buttonFiltersApply']")
	WebElement btnApply;

	@FindBy(xpath = "//div[text()='Rooms available']")
	WebElement lblRoomAva;

	@FindBy(xpath = "//div[@id='mui-component-select-customViewId']")
	WebElement dropDownView;

	@FindBy(xpath = "//ul[@role='listbox']//li")
	List<WebElement> lstDropDownView;

	@FindBy(xpath = "//div//label[text() = 'Date'] /following-sibling::div//input")
	WebElement txtDate;

	@FindBy(xpath = "//div//label[text() = 'Date'] //following-sibling::div//button")
	WebElement btnDatePicker;

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

		System.out.print("Date : " + txtDate.getText().toString());

		return month + 1;

	}

	public void validateOkCancelandClick() {
		int btnStatus = driver.findElements(By.xpath("//button[text()='OK']")).size();

		if (btnStatus > 0) {
			WebElement btnOk = driver.findElement(By.xpath("//button[text()='OK']"));
			btnOk.click();
		}

	}

	public boolean datePicker(String date) throws InterruptedException {
		boolean flag = false;
		String[] dateForPicker = date.split("/");

		txtDate.click();

		int btnDatePickforLocal = driver
				.findElements(By.xpath("//div//label[text() = 'Date'] //following-sibling::div//button")).size();

		if (btnDatePickforLocal > 0) {
			btnDatePicker.click();
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

			System.out.println("Month IN nUM" + monthInnum + " DIF: " + monthDiff);

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
						.findElement(By.xpath(" //div[@role='row']//button[text() = '" + dateForPicker[1] + "']"));
				btnDate.click();
				validateOkCancelandClick();

				flag = true;
			}

			else {
				WebElement btnDate = driver
						.findElement(By.xpath(" //div[@role='row']//button[text() = '" + dateForPicker[1] + "']"));
				btnDate.click();
				validateOkCancelandClick();
				flag = true;
			}

		} else {
			flag = false;
		}

		return flag;

	}

	public void selectDropdownParameters(String column1, String year) throws InterruptedException {

		WebElement ediColumnEle = new WebDriverWait(driver, Duration.ofSeconds(50))
				.until(ExpectedConditions.visibilityOf(lblEdit));

		ediColumnEle.isDisplayed();

		WebElement drpColumn = new WebDriverWait(driver, Duration.ofSeconds(50))
				.until(ExpectedConditions.visibilityOf(drpColumn1));

		drpColumn.click();

		Thread.sleep(2500);

		try {
			for (int i = 0; i < lstDropDownGroup.size(); i++) {
				if (lstDropDownGroup.get(i).getText().equalsIgnoreCase(column1)) {
					lstDropDownGroup.get(i).click();

				}
			}
		} catch (StaleElementReferenceException e) {
			for (int i = 0; i < lstDropDownGroup.size(); i++) {
				if (lstDropDownGroup.get(i).getText().equalsIgnoreCase(column1)) {
					lstDropDownGroup.get(i).click();

				}
			}
		}

		Thread.sleep(2500);

		if (column1.equalsIgnoreCase("ACTUAL/FORECAST")) {
			datePicker(year);

		} else {

			WebElement drpYear = new WebDriverWait(driver, Duration.ofSeconds(50))
					.until(ExpectedConditions.visibilityOf(drpYear1));

			drpYear.click();

			Thread.sleep(2500);

			try {
				for (int i = 0; i < lstDropDownGroup.size(); i++) {
					if (lstDropDownGroup.get(i).getText().equalsIgnoreCase(year)) {
						lstDropDownGroup.get(i).click();

					}
				}
			} catch (StaleElementReferenceException e) {
				for (int i = 0; i < lstDropDownGroup.size(); i++) {
					if (lstDropDownGroup.get(i).getText().equalsIgnoreCase(year)) {
						lstDropDownGroup.get(i).click();

					}
				}
			}
			
			catch (IndexOutOfBoundsException e) {
				
				drpYear.click();
				
				for (int i = 0; i < lstDropDownGroup.size(); i++) {
					if (lstDropDownGroup.get(i).getText().equalsIgnoreCase(year)) {
						lstDropDownGroup.get(i).click();

					}
				}
			}

			Thread.sleep(2500);
		}
		WebElement btnApplyEle = new WebDriverWait(driver, Duration.ofSeconds(50))
				.until(ExpectedConditions.visibilityOf(btnApply));

		btnApplyEle.click();

		Thread.sleep(5000);

	}

	public boolean verifyActualMainHeader(String column, String year) throws InterruptedException {

		ElementUtils.waitForElementToDisplay(lblRoomAva, 100);

		int status = 0;
		String param = column + " " + year + " ";
		String forecastParam = year + " " + column + " ";

		if (column.equalsIgnoreCase("Actual") || column.equalsIgnoreCase("Budget")) {

			System.out.print("Header :" + column);
			status = driver.findElements(By.xpath("//th//span[contains(text(),'" + param + "(Jan - Dec)')]")).size();

		} else if (column.equalsIgnoreCase("Forecast")) {

			System.out.print("Header :" + column);
			status = driver.findElements(By.xpath("//th//span[contains(text(),'" + forecastParam + "- 1')]")).size();

		} else {
			System.out.print("Header :" + column);
			status = driver.findElements(By.xpath("//th//span[contains(text(),'Actual 2023 (Jan 1st  - Feb 28th')]"))
					.size();
		}

		if (status == 1) {
			return true;
		} else {
			return false;
		}
	}

	public void changeTheView(String view) throws InterruptedException {

		WebElement drpView = new WebDriverWait(driver, Duration.ofSeconds(50))
				.until(ExpectedConditions.visibilityOf(dropDownView));

		drpView.click();

		Thread.sleep(5000);

		try {
			for (int i = 0; i < lstDropDownView.size(); i++) {
				if (lstDropDownView.get(i).getText().equalsIgnoreCase(view)) {
					lstDropDownView.get(i).click();

				}
			}
		} catch (StaleElementReferenceException e) {
			for (int i = 0; i < lstDropDownView.size(); i++) {
				if (lstDropDownView.get(i).getText().equalsIgnoreCase(view)) {
					lstDropDownView.get(i).click();

				}
			}

		}

		catch (IndexOutOfBoundsException e) {
			
			drpView.click();
			
			for (int i = 0; i < lstDropDownView.size(); i++) {
				if (lstDropDownView.get(i).getText().equalsIgnoreCase(view)) {
					lstDropDownView.get(i).click();

				}
			}
		}

		Thread.sleep(4500);
	}

	public void selectDropdownParametersForActualForecast(String column1, String year) throws InterruptedException {

		WebElement ediColumnEle = new WebDriverWait(driver, Duration.ofSeconds(50))
				.until(ExpectedConditions.visibilityOf(lblEdit));

		ediColumnEle.isDisplayed();

		WebElement drpColumn = new WebDriverWait(driver, Duration.ofSeconds(50))
				.until(ExpectedConditions.visibilityOf(drpColumn1));

		drpColumn.click();

		Thread.sleep(2500);

		try {
			for (int i = 0; i < lstDropDownGroup.size(); i++) {
				if (lstDropDownGroup.get(i).getText().equalsIgnoreCase(column1)) {
					lstDropDownGroup.get(i).click();

				}
			}
		} catch (StaleElementReferenceException e) {
			for (int i = 0; i < lstDropDownGroup.size(); i++) {
				if (lstDropDownGroup.get(i).getText().equalsIgnoreCase(column1)) {
					lstDropDownGroup.get(i).click();

				}
			}
		}

		Thread.sleep(2500);

		WebElement btnApplyEle = new WebDriverWait(driver, Duration.ofSeconds(50))
				.until(ExpectedConditions.visibilityOf(btnApply));

		btnApplyEle.click();

		Thread.sleep(5000);

	}
}
