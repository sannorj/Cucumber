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

public class Dashboard_PrimaryDecimal_PageObjective {

	private WebDriver driver;
	String roomRevenue, roomAvailable;
	int masterDecimal, primaryDecimal;
	private ConstantsReader configReader = new ConstantsReader();

	public Dashboard_PrimaryDecimal_PageObjective(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@data-el='appName']")
	WebElement header;

	@FindBy(xpath = "//input[@name='porfolio-group']")
	WebElement dropDownGroup;

	@FindBy(xpath = "//ul[@role='listbox']//li")
	List<WebElement> lstDropDowGroup;

	@FindBy(xpath = "//input[@name='porfolio-hotel']")
	WebElement dropDownProperty;

	@FindBy(xpath = "//ul[@role='listbox']//li")
	List<WebElement> lstDropDowProperty;

	@FindBy(xpath = "//div//label[text() = 'Date'] /following-sibling::div//input")
	WebElement txtDate;

	@FindBy(xpath = "//tbody//tr[@data-el='0']//td")
	List<WebElement> lstRowValues;

	@FindBy(xpath = "//tbody//tr[@data-el='0']//td[1]//div[text()]")
	WebElement txtRowField;

	@FindBy(xpath = "//button[@data-el='buttonCustomizeTable']")
	WebElement btnEditColumn;

	@FindBy(xpath = "//div[@id='mui-component-select-selectorDecimalValue']")
	WebElement dropDownDecimal;

	@FindBy(xpath = "//ul[@role='listbox']//li")
	List<WebElement> lstDropDownDecimal;

	@FindBy(xpath = "//button[@data-el='button-edit-Rooms Available']")
	WebElement btnEditRoomAvailable;

	@FindBy(xpath = "//button[@data-el='button-edit-Room Revenue ($)']")
	WebElement btnEditRoomRevenue;

	@FindBy(xpath = "//input[@name='overrideDecimalMaster']")
	WebElement toggleButton;

	@FindBy(xpath = "//div[text()='Edit Column']")
	WebElement editPageEle;

	@FindBy(xpath = "//div[@id='mui-component-select-valueDecimals']")
	WebElement dropDownEditDecimal;

	@FindBy(xpath = "//ul[@role='listbox']//li")
	List<WebElement> lstdropDownEditDecimal;

	@FindBy(xpath = "//button[@data-el='buttonSave']")
	WebElement btnSave;

	@FindBy(xpath = "//div[@id='mui-component-select-performanceIndicatorMasterOverride']")
	WebElement dropDownMassterFeature;

	@FindBy(xpath = "//ul[@role='listbox']//li")
	List<WebElement> lstSwitch;

	@FindBy(xpath = "//tbody//tr[@data-el='0']//td[3]")
	WebElement txtRoomAvailable;

	@FindBy(xpath = "//tbody//tr[@data-el='0']//td[6]")
	WebElement txtRoomRevenue;

	@FindBy(xpath = "//button[@data-el='button-drag-Rooms Available']")
	WebElement btnToggleWidgets;

	@FindBy(xpath = "//div//h5") //// div[text()='Occupancy']
	List<WebElement> lstHeaders;

	@FindBy(xpath = "//h1[text()='Select Widgets to View']")
	WebElement togglePage;
	
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

	public boolean loadPageWithParameters() throws InterruptedException {

		boolean flag = false;
		
		WebElement homePage = new WebDriverWait(driver, Duration.ofSeconds(20))
				.until(ExpectedConditions.visibilityOf(header));

		if (homePage.isDisplayed()) {

			WebElement drpGroup = new WebDriverWait(driver, Duration.ofSeconds(15))
					.until(ExpectedConditions.visibilityOf(dropDownGroup));

			drpGroup.click();
			for (int i = 0; i < lstDropDowGroup.size(); i++) {
				if (lstDropDowGroup.get(i).getText().equalsIgnoreCase(configReader.getProp("Group"))) {
					lstDropDowGroup.get(i).click();

				}
			}

			dropDownProperty.click();
			Thread.sleep(2500);
			lstDropDowProperty.get(1).click();

			selectDate();

			WebElement txtProperty = new WebDriverWait(driver, Duration.ofSeconds(35))
					.until(ExpectedConditions.visibilityOf(txtRowField));

			return txtProperty.isDisplayed();

		} else {
			return false;
		}

	}

	public void setupPrimaryDecimalValue(String value) throws InterruptedException {

		WebElement btnEdit = new WebDriverWait(driver, Duration.ofSeconds(25))
				.until(ExpectedConditions.visibilityOf(btnEditColumn));

		btnEdit.click();

		WebElement drpDecimal = new WebDriverWait(driver, Duration.ofSeconds(25))
				.until(ExpectedConditions.visibilityOf(dropDownDecimal));

		drpDecimal.isDisplayed();

		drpDecimal.click();

		Thread.sleep(2500);

		for (int i = 0; i < lstDropDownDecimal.size(); i++) {
			if (lstDropDownDecimal.get(i).getText().equalsIgnoreCase(value)) {
				lstDropDownDecimal.get(i).click();

				masterDecimal = Integer.parseInt(value);
			}
		}

	}

	public boolean navigateToSetupPermenantDecimal() throws InterruptedException {

		Thread.sleep(10000);

		WebElement editRoomAvailable = new WebDriverWait(driver, Duration.ofSeconds(20))
				.until(ExpectedConditions.visibilityOf(btnEditRoomAvailable));
		editRoomAvailable.click();

		Thread.sleep(6500);

		WebElement editPage = new WebDriverWait(driver, Duration.ofSeconds(20))
				.until(ExpectedConditions.visibilityOf(editPageEle));
		return editPage.isDisplayed();

	}

	public void assignPermenantDecimal(String value) throws InterruptedException {
		Thread.sleep(5000);

		WebElement editDecimal = new WebDriverWait(driver, Duration.ofSeconds(35))
				.until(ExpectedConditions.visibilityOf(dropDownEditDecimal));

		editDecimal.click();

		for (int i = 0; i < lstdropDownEditDecimal.size(); i++) {
			if (lstdropDownEditDecimal.get(i).getText().equalsIgnoreCase(value)) {
				lstdropDownEditDecimal.get(i).click();

				primaryDecimal = Integer.parseInt(value);
			}
		}

		Thread.sleep(3500);
		btnSave.click();

	}

	public boolean navigateToSetupOverRideValue() throws InterruptedException {

		Thread.sleep(4000);

		WebElement editRoomRevenue = new WebDriverWait(driver, Duration.ofSeconds(25))
				.until(ExpectedConditions.visibilityOf(btnEditRoomRevenue));
		editRoomRevenue.click();
		System.out.print("AAAA");
		Thread.sleep(2500);

		WebElement editPage = new WebDriverWait(driver, Duration.ofSeconds(20))
				.until(ExpectedConditions.visibilityOf(editPageEle));
		return editPage.isDisplayed();

	}

	public void assignOverrideDecimal() throws InterruptedException {
		Thread.sleep(10000);

		int status = driver
				.findElements(By.xpath("//div[@id='mui-component-select-valueDecimals']")).size();
		if(status == 1)
		{
			toggleButton.click();
		}
		

		dropDownMassterFeature.click();
		lstSwitch.get(0).click();

		Thread.sleep(2000);
		btnSave.click();

	}

	public void storeValues() throws InterruptedException {

		WebElement editPage = new WebDriverWait(driver, Duration.ofSeconds(20))
				.until(ExpectedConditions.visibilityOf(txtRowField));

		if (editPage.isDisplayed()) {
			WebElement roomAvailableWE = new WebDriverWait(driver, Duration.ofSeconds(20))
					.until(ExpectedConditions.visibilityOf(txtRoomAvailable));

			roomAvailable = roomAvailableWE.getText();

			WebElement roomRevenueWE = new WebDriverWait(driver, Duration.ofSeconds(20))
					.until(ExpectedConditions.visibilityOf(txtRoomRevenue));

			roomRevenue = roomRevenueWE.getText();

			//System.out.println("roomAvailable = " + roomAvailable + " roomRev = " + roomRevenue);

			String roomAvailablespl[] = roomAvailable.split("\\.");
			String roomRevenuespl[] = roomRevenue.split("\\.");

			for (int i = 0; i < roomAvailablespl.length; i++) {
				System.out.println("AA" + roomAvailablespl[i]);
			}

			for (int i = 0; i < roomRevenuespl.length; i++) {
				System.out.println("BB" + roomRevenuespl[i]);
			}
		}

	}

	public boolean comparingDecimalValue() throws InterruptedException {

		String roomAvailablespl[] = roomAvailable.split(".");
		String roomRevenuespl[] = roomRevenue.split(".");
		boolean result = false;

		if (roomAvailablespl.length > 1 && roomAvailablespl.length > 1) {
			if (roomAvailablespl[1].length() == primaryDecimal && roomRevenuespl[1].length() == masterDecimal) {
				result = true;
			} else {
				result = false;
			}
		} else {
			result = false;
		}

		return true;
	}

}
