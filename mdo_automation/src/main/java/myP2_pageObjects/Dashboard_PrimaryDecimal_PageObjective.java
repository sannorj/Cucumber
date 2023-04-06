package myP2_pageObjects;

import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

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

	@FindBy(xpath = "//div[@role='listbox']//li")
	List<WebElement> lstDropDowGroup;

	@FindBy(xpath = "//input[@name='porfolio-hotel']")
	WebElement dropDownProperty;

	@FindBy(xpath = "//div[@role='listbox']//li")
	List<WebElement> lstDropDowProperty;

	@FindBy(xpath = "//div//label[text() = 'Date'] /following-sibling::div//input")
	WebElement txtDate;

	@FindBy(xpath = "//tbody//tr[@data-el='0']//td")
	List<WebElement> lstRowValues;

	@FindBy(xpath = "//div[text()='Property']")
	WebElement txtRowField;

	@FindBy(xpath = "//th[text()='Property']")
	WebElement txtProperty;

	@FindBy(xpath = "//button[@data-el='buttonCustomizeTable']")
	WebElement btnEditColumn;

	@FindBy(xpath = "//div[@id='mui-component-select-selectorDecimalValue']")
	WebElement dropDownDecimal;

	@FindBy(xpath = "//ul[@role='listbox']//li")
	List<WebElement> lstDropDownDecimal;

	@FindBy(xpath = "//button[@data-el='button-edit-Rooms Available Decimal Validation']")
	WebElement btnEditRoomAvailable;

	@FindBy(xpath = "//button[@data-el='button-edit-Total Room Revenue Decimal Validation']")
	WebElement btnEditRoomRevenue;

	@FindBy(xpath = "//input[@name='overrideDecimalMaster']")
	WebElement toggleButton;

	@FindBy(xpath = "//div[text()='Edit Column']")
	WebElement editPageEle;

	@FindBy(xpath = "//div[text()='Add Column']")
	WebElement addPageEle;

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

	@FindBy(xpath = "//tbody//tr[@data-el='0']//td[4]")
	WebElement txtRoomAvailable;

	@FindBy(xpath = "//tbody//tr[@data-el='0']//td[5]")
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

	@FindBy(xpath = "//input[@name='name']")
	WebElement kpiName;

	@FindBy(xpath = "//input[@name='kpiId']")
	WebElement kpiID;

	@FindBy(xpath = "//div[@id='mui-component-select-valueDataType']")
	WebElement amountType;

	@FindBy(xpath = "//li[text()='Actual']")
	WebElement actual;

	@FindBy(xpath = "//button[@data-el=\"buttonSave\"]")
	WebElement addBtn;

	@FindBy(xpath = "//button[@data-el='buttonFinishCustomization']")
	WebElement iamDoneBtn;

	@FindBy(xpath = "//button[@title='Add a Column']")
	WebElement btnAddColumn;

	@FindBy(xpath = "//label[@data-el='Switch-overrideDecimalMasterLabel']//span[@data-el='Switch-overrideDecimalMaster']")
	WebElement checBoxOverride;

	@FindBy(xpath = "//button[@data-el='button-delete-Rooms Available Decimal Validation']")
	WebElement btnDeleteRoomAvailable;

	@FindBy(xpath = "//button[@mdo_variant='success']//span[text()='Ok']")
	WebElement btnDeleteConfirmation;

	@FindBy(xpath = "//div[@role='dialog']//h3[contains(text(),'Delete column')]")
	WebElement dialogBox;

	@FindBy(xpath = "(//button[@mdo_variant='success'])[2]")
	WebElement myP2_btnOk;

	@FindBy(xpath = "//thead//tr[2]//th//span")
	List<WebElement> lstColumnHeaders;

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

	public boolean loadPageWithParameters() throws InterruptedException {

		boolean flag = false;

		WebElement homePage = new WebDriverWait(driver, Duration.ofSeconds(20))
				.until(ExpectedConditions.visibilityOf(header));

		if (homePage.isDisplayed()) {

			WebElement drpGroup = new WebDriverWait(driver, Duration.ofSeconds(15))
					.until(ExpectedConditions.visibilityOf(dropDownGroup));

			drpGroup.click();
			Thread.sleep(5000);
			for (int i = 0; i < lstDropDowGroup.size(); i++) {
				if (lstDropDowGroup.get(i).getText().equalsIgnoreCase(configReader.getProp("Group"))) {
					lstDropDowGroup.get(i).click();

				}
			}
			Thread.sleep(5000);
			dropDownProperty.click();

			Thread.sleep(7500);
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

		Thread.sleep(5000);

		for (int i = 0; i < lstDropDownDecimal.size(); i++) {
			if (lstDropDownDecimal.get(i).getText().equalsIgnoreCase(value)) {
				lstDropDownDecimal.get(i).click();

				masterDecimal = Integer.parseInt(value);
			}
		}

	}

	public boolean navigateToSetupPermenantDecimal() throws InterruptedException {

		Thread.sleep(10000);

		/*
		 * int sizeOfAddingColumn = driver .findElements(By.
		 * xpath("//button[@data-el='button-edit-Rooms Available Decimal Validation']"))
		 * .size();
		 * 
		 * System.out.println("Total room available column " + sizeOfAddingColumn);
		 * 
		 * if (sizeOfAddingColumn == 0) { addColumn("Rooms Available"); }
		 */

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

		int status = driver.findElements(By.xpath(
				"//label[@data-el='Switch-overrideDecimalMasterLabel']//span[@data-el='Switch-overrideDecimalMaster'][contains(@class,'Mui-checked')]"))
				.size();
		if (status == 0) {

			WebElement overrideCheckBox = driver.findElement(By.xpath(
					"//label[@data-el='Switch-overrideDecimalMasterLabel']//span[@data-el='Switch-overrideDecimalMaster']"));

			overrideCheckBox.click();

			WebElement editDecimal = new WebDriverWait(driver, Duration.ofSeconds(35))
					.until(ExpectedConditions.visibilityOf(dropDownEditDecimal));

			editDecimal.click();

			Thread.sleep(5000);

			for (int i = 0; i < lstdropDownEditDecimal.size(); i++) {
				if (lstdropDownEditDecimal.get(i).getText().equalsIgnoreCase(value)) {
					lstdropDownEditDecimal.get(i).click();

					primaryDecimal = Integer.parseInt(value);
				}
			}

		} else {
			WebElement editDecimal = new WebDriverWait(driver, Duration.ofSeconds(35))
					.until(ExpectedConditions.visibilityOf(dropDownEditDecimal));

			editDecimal.click();

			Thread.sleep(5000);

			for (int i = 0; i < lstdropDownEditDecimal.size(); i++) {
				if (lstdropDownEditDecimal.get(i).getText().equalsIgnoreCase(value)) {
					lstdropDownEditDecimal.get(i).click();

					primaryDecimal = Integer.parseInt(value);
				}
			}
		}

		Thread.sleep(4000);
		btnSave.click();

	}

	public boolean navigateToSetupOverRideValue() throws InterruptedException {

		Thread.sleep(4000);

		int sizeOfAddingColumn = driver
				.findElements(By.xpath("//button[@data-el='button-edit-Total Room Revenue Decimal Validation']"))
				.size();

		System.out.println("Total room revenue column " + sizeOfAddingColumn);

		if (sizeOfAddingColumn == 0) {
			addColumn("Total Room Revenue");
		}

		WebElement editRoomRevenue = new WebDriverWait(driver, Duration.ofSeconds(25))
				.until(ExpectedConditions.visibilityOf(btnEditRoomRevenue));
		editRoomRevenue.click();
		Thread.sleep(2500);

		WebElement editPage = new WebDriverWait(driver, Duration.ofSeconds(20))
				.until(ExpectedConditions.visibilityOf(editPageEle));
		return editPage.isDisplayed();

	}

	public void assignOverrideDecimal() throws InterruptedException {
		Thread.sleep(10000);

		int status = driver.findElements(By.xpath("//div[@id='mui-component-select-valueDecimals']")).size();
		if (status == 1) {
			toggleButton.click();
		}

		dropDownMassterFeature.click();
		Thread.sleep(5000);
		lstSwitch.get(0).click();

		Thread.sleep(5000);
		btnSave.click();

	}

	public void storeValues() throws InterruptedException {

		Thread.sleep(4500);

		int indexOfColumnRoomAvialable = 0;
		int indexOfColumnRoomRevenue = 0;

		WebElement editPage = new WebDriverWait(driver, Duration.ofSeconds(120))
				.until(ExpectedConditions.visibilityOf(txtProperty));

		editPage.isDisplayed();

		for (int i = 0; i < lstColumnHeaders.size(); i++) {
			if (lstColumnHeaders.get(i).getText().equalsIgnoreCase("Rooms Available Decimal Validation")) {
				indexOfColumnRoomAvialable = i + 4;
				System.out.println("Column available = " + i + " And index" + indexOfColumnRoomAvialable);
			}

			if (lstColumnHeaders.get(i).getText().equalsIgnoreCase("Total Room Revenue Decimal Validation")) {
				indexOfColumnRoomRevenue = i + 4;
				System.out.println("Column revenue = " + i + " And index" + indexOfColumnRoomRevenue);
			}
		}

		WebElement roomAvailableWE = driver
				.findElement(By.xpath("//tbody//tr[@data-el='0']//td[" + indexOfColumnRoomAvialable + "]"));

		roomAvailable = roomAvailableWE.getText();

		WebElement roomRevenueWE = driver
				.findElement(By.xpath("//tbody//tr[@data-el='0']//td[" + indexOfColumnRoomRevenue + "]"));

		roomRevenue = roomRevenueWE.getText();

		System.out.println("roomAvailable = " + roomAvailable + " roomRev = " + roomRevenue);

		/*String roomAvailablespl[] = roomAvailable.split("\\.");
		String roomRevenuespl[] = roomRevenue.split("\\.");

		for (int i = 0; i < roomAvailablespl.length; i++) {
			System.out.println("AA" + roomAvailablespl[i]);
		}

		for (int i = 0; i < roomRevenuespl.length; i++) {
			System.out.println("BB" + roomRevenuespl[i]);
		}*/
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

	public void addColumn(String kpi) {
		try {

			WebElement btnAddcol = new WebDriverWait(driver, Duration.ofSeconds(20))
					.until(ExpectedConditions.visibilityOf(btnAddColumn));
			btnAddcol.click();

			WebElement lblAddPageEle = new WebDriverWait(driver, Duration.ofSeconds(60))
					.until(ExpectedConditions.visibilityOf(addPageEle));

			lblAddPageEle.isDisplayed();

			Thread.sleep(2000);

			WebElement txtKpiname = new WebDriverWait(driver, Duration.ofSeconds(20))
					.until(ExpectedConditions.visibilityOf(kpiName));
			txtKpiname.click();

			txtKpiname.sendKeys(kpi + " Decimal Validation");

			Thread.sleep(2500);

			WebElement drpKpiId = new WebDriverWait(driver, Duration.ofSeconds(20))
					.until(ExpectedConditions.visibilityOf(kpiID));
			drpKpiId.click();

			drpKpiId.sendKeys(kpi);

			Thread.sleep(2000);

			for (int i = 0; i < lstDropDowGroup.size(); i++) {
				if (lstDropDowGroup.get(i).getText().equalsIgnoreCase(kpi)) {
					lstDropDowGroup.get(i).click();
				}
			}

			Thread.sleep(2000);

			WebElement drpAmountType = new WebDriverWait(driver, Duration.ofSeconds(20))
					.until(ExpectedConditions.visibilityOf(amountType));
			drpAmountType.click();

			Thread.sleep(2000);

			WebElement lstBtnActual = new WebDriverWait(driver, Duration.ofSeconds(20))
					.until(ExpectedConditions.visibilityOf(actual));
			lstBtnActual.click();

			Thread.sleep(2000);

			WebElement chkOverride = new WebDriverWait(driver, Duration.ofSeconds(20))
					.until(ExpectedConditions.visibilityOf(checBoxOverride));
			chkOverride.click();

			WebElement btnAdd = new WebDriverWait(driver, Duration.ofSeconds(20))
					.until(ExpectedConditions.visibilityOf(addBtn));
			btnAdd.click();

		} catch (Exception e) {
			System.out.println("Falied to set KPI name");
			e.printStackTrace();
		}

	}

	public void deleteColumnIfExist(String columnName) throws InterruptedException {
		Thread.sleep(10000);

		int sizeOfAddingColumn = driver
				.findElements(By.xpath("//button[@data-el='button-delete-" + columnName + " Decimal Validation']"))
				.size();

		if (sizeOfAddingColumn == 1) {
			WebElement btnDelete = driver
					.findElement(By.xpath("//button[@data-el='button-delete-" + columnName + " Decimal Validation']"));

			btnDelete.click();

			Thread.sleep(2500);

			WebElement dialogBoxEle = new WebDriverWait(driver, Duration.ofSeconds(100))
					.until(ExpectedConditions.visibilityOf(dialogBox));

			dialogBoxEle.isDisplayed();

			Thread.sleep(2500);

			WebElement btnOkEle = new WebDriverWait(driver, Duration.ofSeconds(100))
					.until(ExpectedConditions.visibilityOf(btnDeleteConfirmation));

			btnOkEle.click();

			Thread.sleep(10000);

		}

	}

}
