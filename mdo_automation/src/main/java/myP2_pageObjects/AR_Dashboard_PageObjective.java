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
import utils.DatePicker;
import utils.ElementUtils;

public class AR_Dashboard_PageObjective {

	private WebDriver driver;
	private ConstantsReader configReader = new ConstantsReader();
	double dataValues[][];
	double maxDataValue, outstandingRedVal, outstandingYellow;
	boolean flag;

	public AR_Dashboard_PageObjective(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[@data-el='menuToggle']")
	WebElement selector;

	@FindBy(xpath = "//div[text()='Reports']//ancestor::li")
	WebElement reports;

	@FindBy(xpath = "//div[text()='Accounts Receivable']//ancestor::li")
	WebElement Ar;

	@FindBy(xpath = "//a[contains(text(),'AR Aging Dashboard')]//ancestor::li")
	WebElement ArDashboard;

	@FindBy(xpath = "//h1[text()='AR Aging Dashboard (New)']")
	WebElement ArDashboardPage;

	@FindBy(xpath = "//div[@data-el='appName']")
	WebElement header;

	@FindBy(xpath = "//input[@name='portfolio']")
	WebElement dropDownGroup;

	@FindBy(xpath = "//ul[@role='listbox']//li")
	List<WebElement> lstDropDowGroup;

	@FindBy(xpath = "//div//label[text() = 'Date'] /following-sibling::div//input")
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
		int btnDatePickforLocal = driver.findElements(By.xpath("//div//label[text() = 'Date'] //following-sibling::div//button")).size();

		if (btnDatePickforLocal > 0) {
			btnDatePicker.click();
		}

		int status = driver.findElements(By.xpath("//div[@role='dialog']")).size();

		if (status == 1) {

			WebElement expandYear = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(btnExpandYear));
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
					WebElement btnPrevious = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(btnPreviousMonth));

					btnPrevious.click();
					Thread.sleep(1500);

				}
				WebElement btnDate = driver.findElement(By.xpath(" //div[@role='row']//button[text() = '" + dateForPicker[1] + "']"));
				btnDate.click();
				validateOkCancelandClick();
				flag = true;
			}

			else if (monthDiff < 0) {
				for (int i = 0; i > monthDiff; i--) {
					WebElement btnNext = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(btnNextMonth));

					btnNext.click();
					Thread.sleep(1500);
				}
				
				WebElement btnDate = driver.findElement(By.xpath(" //div[@role='row']//button[text() = '" + dateForPicker[1] + "']"));
				btnDate.click();
				validateOkCancelandClick();
				
				flag = true;
			}

			else {
				WebElement btnDate = driver.findElement(By.xpath(" //div[@role='row']//button[text() = '" + dateForPicker[1] + "']"));
				btnDate.click();		
				validateOkCancelandClick();
				
				flag = true;
			}

		} else {
			flag = false;
		}

		return flag;

	}

	public void expandAccountRecievable() {
		WebElement menu = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(selector));
		menu.click();

		WebElement reportsEx = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(reports));
		reportsEx.click();

		WebElement accountRecievable = new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(Ar));
		accountRecievable.click();

	}

	public boolean navigateToARDahsboardPage() {

		WebElement arDashBoardCL = new WebDriverWait(driver, Duration.ofSeconds(50)).until(ExpectedConditions.visibilityOf(ArDashboard));
		arDashBoardCL.click();

		WebElement arDashBoardPageCL = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(ArDashboardPage));
		return arDashBoardPageCL.isDisplayed();

	}

	public void loadPageWithParameters() throws InterruptedException {

		ElementUtils.waitForElementToDisplay(header, 100);

		WebElement drpGroup = new WebDriverWait(driver, Duration.ofSeconds(50))
				.until(ExpectedConditions.visibilityOf(dropDownGroup));

		drpGroup.click();
		for (int i = 0; i < lstDropDowGroup.size(); i++) {
			if (lstDropDowGroup.get(i).getText().equalsIgnoreCase(configReader.getProp("AR_dashBoard"))) {
				lstDropDowGroup.get(i).click();

			}
		}

	}

	public boolean loadArReport() {

		btnGo.click();

		WebElement txtProperty = new WebDriverWait(driver, Duration.ofSeconds(40))
				.until(ExpectedConditions.visibilityOf(txtRowField));

		return txtProperty.isDisplayed();
	}

	public void turnOnShowChart() {
		try {
			int chartStatus = driver
					.findElements(
							By.xpath("//label[@data-el='switchShowChartsLabel']//span[contains(@class,'Mui-checked')]"))
					.size();

			if (chartStatus == 0) {
				WebElement showChart = driver
						.findElement(By.xpath("//label[@data-el='switchShowChartsLabel']//input[@type='checkbox']"));

				showChart.click();

				Thread.sleep(2800);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public boolean verifyShowChart() {
		if (chartHeader.size() > 0) {
			return true;
		} else {
			return false;
		}
	}

	public void storeAlltheRecords() {
		dataValues = new double[dataRowCount.size() - 1][5];

		for (int i = 0; i < dataRowCount.size() - 1; i++) {
			for (int j = 2; j < 7; j++) {
				WebElement data = driver.findElement(By.xpath("//tbody//tr[" + (i + 1) + "]//td[" + j + "]"));

				dataValues[i][j - 2] = Double.parseDouble(
						data.getText().replace(",", "").replace("$", "").replace("(", "").replace(")", ""));

			}
		}

		txtDate.isDisplayed();

		for (int k = 0; k < dataValues[0].length; k++) {
			System.out.println(dataValues[0][k]);
		}
	}

	public double calulateMaxValue() {
		maxDataValue = 0;

		for (int i = 0; i < dataValues.length; i++) {
			for (int j = 0; j < dataValues[i].length; j++) {
				if (dataValues[i][j] > maxDataValue) {
					maxDataValue = dataValues[i][j];
				}
			}
		}
		return maxDataValue;
	}

	public void turnOnShowAtRisk() {
		try {
			int chartStatus = driver
					.findElements(
							By.xpath("//label[@data-el='switchShowAtRiskLabel']//span[contains(@class,'Mui-checked')]"))
					.size();

			if (chartStatus == 0) {
				WebElement showChart = driver
						.findElement(By.xpath("//label[@data-el='switchShowAtRiskLabel']//input[@type='checkbox']"));

				showChart.click();

				Thread.sleep(2800);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public boolean verifyRedOutstanding() {
		flag = false;
		outstandingRedVal = (maxDataValue * 0.75);

		for (int i = 0; i < dataRowCount.size() - 1; i++) {
			for (int j = 2; j < 7; j++) {
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
						System.out.println("row" + i + " col" + j + " val" + tempDataValue);
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
		flag = false;
		outstandingRedVal = (maxDataValue * 0.75);
		outstandingYellow = (maxDataValue * 0.5);

		System.out.println("Max" + maxDataValue+ " Red"+outstandingRedVal);

		System.out.println("Yel" + outstandingYellow+ " Red"+outstandingRedVal);
		
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
						System.out.println("row" + i + " col" + j + " val" + tempDataValue);
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
