package myP2_pageObjects;

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

public class PickUpReport_EdiColumn_PageObject {

	private WebDriver driver;
	private ConstantsReader configReader = new ConstantsReader();
	ArrayList<String> columnName;
	ArrayList<String> offColumnName;

	public PickUpReport_EdiColumn_PageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		columnName = new ArrayList<>();
		offColumnName = new ArrayList<>();

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

	@FindBy(xpath = "//button[@data-el='buttonSettings']")
	WebElement btnEditColumn;

	@FindBy(xpath = "//div[text() = 'Settings']")
	WebElement settingPage;

	@FindBy(xpath = "//div//h3[text() = 'Occupancy']/following-sibling::div//label[@class='sc-bjUoiL ebTZpj']")
	List<WebElement> listColumn;

	@FindBy(xpath = "//button[@type='button']//span[text() = 'Apply']")
	WebElement btnApply;
	
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

	// th[@freezecolumns='0']

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
	
	
	public boolean navigateToEditColumn() {
		WebElement btnEdit = new WebDriverWait(driver, Duration.ofSeconds(50))
				.until(ExpectedConditions.visibilityOf(btnEditColumn));
		btnEdit.click();

		WebElement pageSetting = new WebDriverWait(driver, Duration.ofSeconds(50))
				.until(ExpectedConditions.visibilityOf(settingPage));
		return pageSetting.isDisplayed();
	}

	public void loadReport() {
		try {
			selectBusinessDate();

			Thread.sleep(5000);

			selectStartDate();

			Thread.sleep(5000);

			selectEndDate();

			Thread.sleep(5000);

			btngo.click();

			Thread.sleep(2500);

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public void switchOnAllTheColumns() throws InterruptedException {
		for (int i = 0; i < listColumn.size(); i++) {

			columnName.add(listColumn.get(i).getText()); //

		}

		for (int i = 0; i < columnName.size(); i++) {

			int status = driver
					.findElements(By.xpath("//div//h3[text() = 'Occupancy']/following-sibling::div//label[@label ='"
							+ columnName.get(i) + "']//span[contains(@class,'Mui-checked')]"))
					.size();

			if (status == 0) {
				
				WebElement btnSwitch = driver
						.findElement(By.xpath("//div//h3[text() = 'Occupancy']/following-sibling::div//label[@label ='"
								+ columnName.get(i) + "']"));
				
				

				btnSwitch.click();
				Thread.sleep(1500);
			}
		}

		btnApply.click();
		Thread.sleep(3000);

	}
	
	public void switchOffSomeColumns() throws InterruptedException {
		for (int i = 0; i < listColumn.size(); i++) {

			columnName.add(listColumn.get(i).getText());

		}

		for (int i = 0; i < columnName.size(); i++) {

			if(i==0 || i==2)
			{
				int status = driver
						.findElements(By.xpath("//div//h3[text() = 'Occupancy']/following-sibling::div//label[@label ='"
								+ columnName.get(i) + "']//span[contains(@class,'Mui-checked')]"))
						.size();

				if (status == 1) {
					System.out.println("AA" + columnName.get(i));
					WebElement btnSwitch = driver
							.findElement(By.xpath("//div//h3[text() = 'Occupancy']/following-sibling::div//label[@label ='"
									+ columnName.get(i) + "']"));
					offColumnName.add(btnSwitch.getText());
					btnSwitch.click();
					Thread.sleep(1500);
					
				}
			}
			
		}

		btnApply.click();
		Thread.sleep(3000);
		
		

	}

}
