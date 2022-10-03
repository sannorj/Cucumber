package myP2_pageObjects;

import java.time.Duration;
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
import utils.ElementUtils;

public class AR_Property_PageObjective {
	private WebDriver driver;
	private ConstantsReader configReader = new ConstantsReader();
	double dataValues[][];
	double maxDataValue, outstandingRedVal, outstandingYellow;
	boolean flag;

	public AR_Property_PageObjective(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[@data-el='menuToggle']")
	WebElement selector;

	@FindBy(xpath = "//div[text()='Reports']//ancestor::li")
	WebElement reports;

	@FindBy(xpath = "//div[text()='Accounts Receivable']//ancestor::li")
	WebElement Ar;

	@FindBy(xpath = "//div[text()='AR Property']//ancestor::li")
	WebElement ArProperty;

	@FindBy(xpath = "//h1[text()='AR Property']")
	WebElement ArPropertyPage;

	@FindBy(xpath = "//div[@data-el='appName']")
	WebElement header;

	@FindBy(xpath = "//input[@name='hotelIds']")
	WebElement dropDownProperty;

	@FindBy(xpath = "//ul[@role='listbox']//li")
	List<WebElement> lstDropDowProperty;

	@FindBy(xpath = "//div/label[text()='Date']//following-sibling::div/input")
	WebElement txtDate;

	@FindBy(xpath = "//th//span[@role='button']")
	WebElement txtRowField;

	@FindBy(xpath = "//button//span[text()='Go']")
	WebElement btnGo;

	@FindBy(xpath = "//div//h5")
	List<WebElement> chartHeader;

	@FindBy(xpath = "//tbody//tr")
	List<WebElement> dataRowCount;
	
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

		return month + 1;
	}

	public void validateOkCancelandClick() {
		int btnStatus = driver.findElements(By.xpath("//button[text()='OK']")).size();

		if (btnStatus > 0) {
			WebElement btnOk = driver.findElement(By.xpath("//button[text()='OK']"));
			btnOk.click();
		}

	}

	public boolean selectDate() throws InterruptedException {
		boolean flag = false;
		String[] dateForPicker = configReader.getProp("revenueDate").split("/");

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
						.findElement(By.xpath(" //div[@role='cell']//button[text() = '" + dateForPicker[1] + "']"));

				btnDate.click();

				validateOkCancelandClick();
				
				flag = true;
			}

			else {
				WebElement btnDate = driver
						.findElement(By.xpath(" //div[@role='cell']//button[text() = '" + dateForPicker[1] + "']"));

				btnDate.click();
				
				validateOkCancelandClick();
				
				flag = true;
			}

		} else {
			flag = false;
		}

		return flag;

	}

	public boolean navigateToARPropertyPage() {

		WebElement arDashBoardCL = new WebDriverWait(driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.visibilityOf(ArProperty));
		arDashBoardCL.click();

		WebElement arDashBoardPageCL = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.visibilityOf(ArPropertyPage));
		return arDashBoardPageCL.isDisplayed();

	}

	public void loadPageWithParameters() throws InterruptedException {

		ElementUtils.waitForElementToDisplay(header, 100);

		WebElement drpGroup = new WebDriverWait(driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.visibilityOf(dropDownProperty));

		drpGroup.click();
		for (int i = 0; i < lstDropDowProperty.size(); i++) {
			if (lstDropDowProperty.get(i).getText().equalsIgnoreCase(configReader.getProp("Propery"))) {
				lstDropDowProperty.get(i).click();

			}
		}
		
		

	}

	public boolean loadArPropertyReport() {

		btnGo.click();

		WebElement txtProperty = new WebDriverWait(driver, Duration.ofSeconds(150))
				.until(ExpectedConditions.visibilityOf(txtRowField));

		return txtProperty.isDisplayed();
	}

	public void storeAllthePropertyRecords() {
		dataValues = new double[dataRowCount.size() - 1][5];

		for (int i = 0; i < dataRowCount.size() - 1; i++) {
			for (int j = 3; j < 8; j++) {
				WebElement data = driver.findElement(By.xpath("//tbody//tr[" + (i + 1) + "]//td[" + j + "]"));

				dataValues[i][j - 3] = Double.parseDouble(
						data.getText().replace(",", "").replace("$", "").replace("(", "").replace(")", ""));

			}
		}

		for (int k = 0; k < dataValues[0].length; k++) {
			System.out.println(dataValues[0][k]);
		}
	}

	public double calulateArPropertyMaxValue() {
		maxDataValue = 0;

		for (int i = 0; i < dataValues.length; i++) {
			for (int j = 0; j < dataValues[i].length; j++) {
				if (dataValues[i][j] > maxDataValue) {
					maxDataValue = dataValues[i][j];
				}
			}
		}
		System.out.println("Max"+maxDataValue);
		return maxDataValue;
	}
	
	public boolean verifyArPropertyRedOutstanding() {
		flag = true;
		outstandingRedVal = (maxDataValue * 0.75);

		for (int i = 0; i < dataRowCount.size() - 1; i++) {
			for (int j = 3; j < 8; j++) {
				WebElement data = driver.findElement(By.xpath("//tbody//tr[" + (i + 1) + "]//td[" + j + "]"));

				double tempDataValue = Double.parseDouble(
						data.getText().replace(",", "").replace("$", "").replace("(", "").replace(")", ""));

				if (tempDataValue > outstandingRedVal) {
					int coloredData = driver.findElements(By.xpath(
							"//tbody//tr[" + (i + 1) + "]//td[" + j + "][contains(@maxandmediumcolor,'#FFC1C1')]"))
							.size();

					if (coloredData > 0) {
						flag = true;
					} else {
						flag = false;
						System.out.println("row"+i+" col"+j+ " val"+tempDataValue);
						break;
						
						
					}
				}

			}

			if (!flag) {
				break;
			}
		}

		return flag;

	}
	
	public boolean verifyYellowOutstanding() {
		flag = true;
		outstandingRedVal = (maxDataValue * 0.74);
		outstandingYellow = (maxDataValue * 0.5);

		for (int i = 0; i < dataRowCount.size() - 1; i++) {
			for (int j = 2; j < 7; j++) {
				WebElement data = driver.findElement(By.xpath("//tbody//tr[" + (i + 1) + "]//td[" + j + "]"));

				double tempDataValue = Double.parseDouble(
						data.getText().replace(",", "").replace("$", "").replace("(", "").replace(")", ""));

				if (tempDataValue > outstandingYellow && tempDataValue < outstandingRedVal) {
					int coloredData = driver.findElements(By.xpath(
							"//tbody//tr[" + (i + 1) + "]//td[" + j + "][contains(@maxandmediumcolor,'#FFDD9F')]"))
							.size();

					if (coloredData > 0) {
						flag = true;
					} else {
						flag = false;
						System.out.println("row"+i+" col"+j+ " val"+tempDataValue);
						break;
						
						
					}
				}

			}

			if (!flag) {
				break;
			}
		}

		return flag;

	}

}
