package myP2_pageObjects;

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

import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class PnLMonthly_PageObject {
	boolean flag;
	double roundOffOcc;
	double roundOffAdr;
	double roundOffrevPar;
	double roundOffTotalRevPar;
	private WebDriver driver;
	private ConstantsReader configReader = new ConstantsReader();

	public PnLMonthly_PageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div//a[contains(text(),'P&L Monthly')]//ancestor::li")
	WebElement pnlMonthly;

	@FindBy(xpath = "//div/input[@name='portfolio-group']")
	WebElement drpGroup;

	@FindBy(xpath = "//div/input[@name='portfolio-hotel']")
	WebElement drpProperty;

	@FindBy(xpath = "//div[@data-el='dropdownGenericSelector']")
	WebElement drpView;

	@FindBy(xpath = "//div/label[text()='Date']//following-sibling::div/input[@name='date']")
	WebElement txtDrp;

	@FindBy(xpath = "//button//span[text()='Go']")
	WebElement btnGo;

	@FindBy(xpath = "(//div/button[@title='Go']/span)[2]")
	WebElement btnGo1;

	@FindBy(xpath = "//button[@title='Refresh']")
	WebElement btnRefresh;

	@FindBy(xpath = "//div[@role='listbox']//li")
	List<WebElement> listDrpValueSize;
	
	@FindBy(xpath = "//ul[@role='listbox']//li")
	List<WebElement> listDrpSize;

	@FindBy(xpath = "//h1[text()='Profit & Loss Monthly Report']")
	WebElement pnlMonthlyPage;

	@FindBy(xpath = "//tbody/tr")
	List<WebElement> listStaticValues;

	@FindBy(xpath = "//tr[@data-el]/td[1]")
	List<WebElement> listSection;

	@FindBy(xpath = "//h3[text()='Loading...']")
	WebElement lblLoading;

	@FindBy(xpath = "//div//label[text() = 'Date'] /following-sibling::div//input")
	WebElement txtDate;

	@FindBy(xpath = "//input[@name='nullRecords']")
	WebElement btnZeroValue;

	@FindBy(xpath = "//tr[@data-el='Occupancy']/td[3]")
	WebElement cellOccupancy;

	@FindBy(xpath = "//tr[@data-el='Rooms sold']/td[3]")
	WebElement cellCRoomSold;

	@FindBy(xpath = "//tr[@data-el='Rooms available']/td[3]")
	WebElement cellRoomsAvailable;

	@FindBy(xpath = "//tr[@data-el='RMREV90']/td[3]")
	WebElement cellTotalRoomsRevenue;

	@FindBy(xpath = "//tr[@data-el='ADR']/td[3]")
	WebElement cellAdr;

	@FindBy(xpath = "//tr[@data-el='REV-PAR']/td[3]")
	WebElement cellRevPar;

	@FindBy(xpath = "//tr[@data-el='Total Operating Revenue']/td[3]")
	WebElement cellTotalOperatingRevenue;

	@FindBy(xpath = "//tr[@data-el='Total REV-PAR']/td[3]")
	WebElement cellTotalRevPar;

	@FindBy(xpath = "//div[text()='Rooms available']")
	WebElement lblRoomAva;

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

	@FindBy(xpath = "//div[@id='mui-component-select-columns[0].dataType']")
	WebElement drpColumn1;

	@FindBy(xpath = "//input[@name='columns[0].dataType']")
	WebElement drpColumn1Value;

	@FindBy(xpath = "//div[@id='mui-component-select-columns[0].yearOffest']")
	WebElement drpYear1;

	@FindBy(xpath = "//input[@name='columns[0].yearOffest']")
	WebElement drpYear1Value;

	public boolean navigatePnLMonthlyPage() throws InterruptedException {

		WebElement pnlMonthEle = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.visibilityOf(pnlMonthly));
		pnlMonthEle.click();

		Thread.sleep(3500);

		WebElement pnlMothlyPageEle = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.visibilityOf(pnlMonthlyPage));
		return pnlMothlyPageEle.isDisplayed();

	}

	public void selectParameters() throws InterruptedException {

		Thread.sleep(10000);

		if (drpGroup.isEnabled()) {
			/* Select the appropriate Group value from the drop-down menu. */
			WebElement drpGroupEle = new WebDriverWait(driver, Duration.ofSeconds(50))
					.until(ExpectedConditions.visibilityOf(drpGroup));
			drpGroupEle.click();

			ExpectedConditions.visibilityOf(listDrpValueSize.get(0));
			for (int i = 0; i < listDrpValueSize.size(); i++) {
				if (listDrpValueSize.get(i).getText().equalsIgnoreCase(configReader.getProp("Group"))) {
					listDrpValueSize.get(i).click();
				}
			}
		}

		Thread.sleep(5000);
		if (drpProperty.isEnabled()) {
			WebElement drpPropertyEle = new WebDriverWait(driver, Duration.ofSeconds(50))
					.until(ExpectedConditions.visibilityOf(drpProperty));
			drpPropertyEle.click();

			ExpectedConditions.visibilityOf(listDrpValueSize.get(1));
			for (int i = 0; i < listDrpValueSize.size(); i++) {
				if (listDrpValueSize.get(i).getText().equalsIgnoreCase(configReader.getProp("Propery"))) {
					listDrpValueSize.get(i).click();
				}
			}
		}
		Thread.sleep(4000);
		
		selectDate();

		Thread.sleep(2500);
		
		WebElement drpViewEle = new WebDriverWait(driver, Duration.ofSeconds(30))
				.until(ExpectedConditions.visibilityOf(drpView));
		
		drpViewEle.click();

		Thread.sleep(1500);

		List<WebElement> listDrpValueView = new WebDriverWait(driver, Duration.ofSeconds(50))
				.until(ExpectedConditions.visibilityOfAllElements(listDrpSize));

		for (int i = 0; i < listDrpSize.size(); i++) {
			if (listDrpSize.get(i).getText().equalsIgnoreCase(configReader.getProp("View"))) {
				ExpectedConditions.visibilityOf(listDrpSize.get(0));
				listDrpSize.get(i).click();
			}
		}

		Thread.sleep(4500);
		WebElement btnGO = new WebDriverWait(driver, Duration.ofSeconds(60))
				.until(ExpectedConditions.visibilityOf(btnGo));
		btnGO.click();

		ElementUtils.waitForElementToDisplay(lblRoomAva, 100);
		btnZeroValue.click();
	}

	public boolean verifyStaticSection() throws InterruptedException {

		Thread.sleep(7500);
		/* capture/go though the 5 static section */
		for (int x = 0; x < 5; x++) {
			/* split and ready the data from property file */
			String[] a = configReader.getProp("Static_Names").split(",");
			/* Get the 5 static section form property file */
			for (int i = 0; i < 5; i++) {
				String expected = a[i];
				String actual = listStaticValues.get(i).getAttribute("data-el");
				if (actual.contains(expected)) {
					flag = true;
				} else {
					flag = false;
				}
			}

		}
		return flag;

	}

	public void occupancyCalFunc() {

		WebElement RoomSold = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.visibilityOf(cellCRoomSold));
		double RoomSoldValue = Double.parseDouble(RoomSold.getText().replaceAll(",", ""));

		WebElement RoomsAvailable = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.visibilityOf(cellRoomsAvailable));
		double RoomsAvailableValue = Double.parseDouble(RoomsAvailable.getText().replaceAll(",", ""));

		/* Calculate the Occupancy value */
		double x = RoomSoldValue / RoomsAvailableValue * 100;
		roundOffOcc = Math.round(x * 100.0) / 100.0;

	}

	public boolean verifyOccCalculationFunc() {

		WebElement OccValue = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.visibilityOf(cellOccupancy));
		double Occupancy = Double.parseDouble(OccValue.getText().replace("%", ""));

		/* Verify the calculated and captured values are same. */
		if (Occupancy == roundOffOcc) {
			return true;
		} else {
			return false;
		}
	}

	public void adrCalFunc() {

		WebElement TotalRoomsRevenue = new WebDriverWait(driver, Duration.ofSeconds(100))
				.until(ExpectedConditions.visibilityOf(cellTotalRoomsRevenue));
		double TotalRoomsRevenueValue = Double
				.parseDouble(TotalRoomsRevenue.getText().replaceAll(",", "").replaceAll("\\$", ""));

		WebElement RoomSold = new WebDriverWait(driver, Duration.ofSeconds(25))
				.until(ExpectedConditions.visibilityOf(cellCRoomSold));
		double RoomSoldValue = Double.parseDouble(RoomSold.getText().replaceAll(",", ""));

		double x = TotalRoomsRevenueValue / RoomSoldValue;
		roundOffAdr = Math.round(x * 100.0) / 100.0;

	}

	public boolean verifyAdrCalculationFunc() {

		WebElement adr = new WebDriverWait(driver, Duration.ofSeconds(25))
				.until(ExpectedConditions.visibilityOf(cellAdr));
		double adrValue = Double.parseDouble(adr.getText().replace(",", "").replaceAll("\\$", ""));
		if (roundOffAdr == adrValue) {
			return true;
		} else {
			return false;
		}
	}

	public void revParCalFunc() {

		WebElement TotalRoomsRevenue = new WebDriverWait(driver, Duration.ofSeconds(25))
				.until(ExpectedConditions.visibilityOf(cellTotalRoomsRevenue));
		double TotalRoomsRevenueValue = Double
				.parseDouble(TotalRoomsRevenue.getText().replaceAll(",", "").replaceAll("\\$", ""));

		WebElement RoomsAvailable = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.visibilityOf(cellRoomsAvailable));
		double RoomsAvailableValue = Double.parseDouble(RoomsAvailable.getText().replaceAll(",", ""));

		double x = TotalRoomsRevenueValue / RoomsAvailableValue;
		roundOffrevPar = Math.round(x * 100.0) / 100.0;

	}

	public boolean verifyRevParCalculationFunc() {

		WebElement revPar = new WebDriverWait(driver, Duration.ofSeconds(25))
				.until(ExpectedConditions.visibilityOf(cellRevPar));
		double revParValue = Double.parseDouble(revPar.getText().replace(",", "").replaceAll("\\$", ""));

		/* Verify the calculated and captured values are same. */
		if (roundOffrevPar == revParValue) {
			return true;
		} else {
			return false;
		}
	}

	public void totalRevParCalFunc() {

		ExpectedConditions.visibilityOf(listSection.get(1));
		WebElement TotalOperatingRevenue = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.visibilityOf(cellTotalOperatingRevenue));
		double TotalOperatingRevenueValue = Double
				.parseDouble(TotalOperatingRevenue.getText().replaceAll(",", "").replaceAll("\\$", ""));

		WebElement RoomsAvailable = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.visibilityOf(cellRoomsAvailable));
		double RoomsAvailableValue = Double.parseDouble(RoomsAvailable.getText().replaceAll(",", ""));

		/* Calculate the Occupancy value */
		double x = TotalOperatingRevenueValue / RoomsAvailableValue;
		roundOffTotalRevPar = Math.round(x * 100.0) / 100.0;

	}

	public boolean verifyTotalRevParCalculationFunc() {

		/* Capture the revPar Value from page */
		WebElement totalRevPar = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.visibilityOf(cellTotalRevPar));
		double revParValue = Double.parseDouble(totalRevPar.getText().replace(",", "").replaceAll("\\$", ""));

		/* Verify the calculated and captured values are same. */
		if (roundOffTotalRevPar == revParValue) {
			return true;
		} else {
			return false;
		}
	}

	public boolean verifyOwnersViewSection() {

		ExpectedConditions.visibilityOf(listSection.get(1));
		for (int x = 0; x < listStaticValues.size(); x++) {
			/* split and ready the data from property file */
			String[] a = configReader.getProp("Owner_Section").split(",");
			for (int i = 0; i < a.length; i++) {
				String expected = a[i];
				String actual = listSection.get(x).getText();
				if (actual.contains(expected)) {
					flag = true;
				} else {
					flag = false;
				}
			}
		}
		return flag;
	}

	public void selectOperatorView() throws InterruptedException {

		Thread.sleep(5000);
		WebElement drpViewEle = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.visibilityOf(drpView));
		drpViewEle.click();

		Thread.sleep(4000);
		try {
			for (int i = 0; i < listDrpSize.size(); i++) {
				if (listDrpSize.get(i).getText().equalsIgnoreCase(configReader.getProp("OperatorView"))) {
					listDrpSize.get(i).click();
				}
			}
		} catch (StaleElementReferenceException e) {
			for (int i = 0; i < listDrpSize.size(); i++) {
				if (listDrpSize.get(i).getText().equalsIgnoreCase(configReader.getProp("OperatorView"))) {
					listDrpSize.get(i).click();
				}
			}
		}

		Thread.sleep(4000);
		btnGo.click();
		ElementUtils.waitForElementToDisplay(lblRoomAva, 150);
		Thread.sleep(5000);
	}

	public boolean verifyOperatorSection() {

		try {
			/* mandatory pause */
			Thread.sleep(1500);
			for (int x = 0; x < listStaticValues.size(); x++) {
				/* split and ready the data from property file */
				String[] a = configReader.getProp("Operator_Section").split(",");
				for (int i = 0; i < a.length; i++) {
					String expected = a[i];
					String actual = listSection.get(x).getText();
					if (actual.contains(expected)) {
						flag = true;
					} else {
						flag = false;
					}
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return flag;

	}

	public void selectRooRevenueDetailView() throws InterruptedException {

		WebElement drpViewEle = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.visibilityOf(drpView));
		drpViewEle.click();

		Thread.sleep(6500);
		try {
			for (int i = 0; i < listDrpSize.size(); i++) {
				if (listDrpSize.get(i).getText().equalsIgnoreCase(configReader.getProp("RoomRevenueDetail"))) {
					listDrpSize.get(i).click();
				}
			}
		} catch (StaleElementReferenceException e) {
			for (int i = 0; i < listDrpSize.size(); i++) {
				if (listDrpSize.get(i).getText().equalsIgnoreCase(configReader.getProp("RoomRevenueDetail"))) {
					listDrpSize.get(i).click();
				}
			}
		}

		Thread.sleep(6000);
		btnGo.click();
		Thread.sleep(20000);
		ElementUtils.waitForElementToDisplay(lblRoomAva, 150);

	}

	public boolean verifyRoomRevenueDetailSection() throws InterruptedException {

		Thread.sleep(1500);
		for (int x = 0; x < listStaticValues.size(); x++) {
			/* split and ready the data from property file */
			String[] a = configReader.getProp("RoomRevenueDetail_Section").split(",");
			for (int i = 0; i < a.length; i++) {

				String expected = a[i];
				String actual = listSection.get(x).getText();
				if (actual.contains(expected)) {
					flag = true;
				} else {
					flag = false;
				}
			}
		}
		return flag;
	}

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
		String[] dateForPicker = configReader.getProp("PnLNewDate").split("/");

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

	/**************** Smoke ***********************/

	public void clickOnViewDrpFunc() throws InterruptedException {

		Thread.sleep(8500);
		WebElement drpViewEle = new WebDriverWait(driver, Duration.ofSeconds(30))
				.until(ExpectedConditions.visibilityOf(drpView));
		drpViewEle.click();
		Thread.sleep(3500);

	}

	public boolean verifyViewdrpFunc() throws InterruptedException {

		Thread.sleep(4000);
		ExpectedConditions.visibilityOf(listDrpSize.get(1));
		for (int x = 0; x < listDrpSize.size(); x++) {
			/* split and ready the data from property file */
			String[] a = configReader.getProp("PnL_view_values").split(",");
			String actual = listDrpSize.get(x).getText();

			String expected = a[x];

			if (expected.contains(actual)) {
				flag = true;
			} else {
				flag = false;
			}
		}

		Thread.sleep(6000);
		try {
			for (int i = 0; i < listDrpSize.size(); i++) {
				if (listDrpSize.get(i).getText().equalsIgnoreCase(configReader.getProp("View"))) {
					ExpectedConditions.visibilityOf(listDrpSize.get(0));
					listDrpSize.get(i).click();
				}
			}
		} catch (StaleElementReferenceException e) {
			for (int i = 0; i < listDrpSize.size(); i++) {
				if (listDrpSize.get(i).getText().equalsIgnoreCase(configReader.getProp("View"))) {
					ExpectedConditions.visibilityOf(listDrpSize.get(0));
					listDrpSize.get(i).click();
				}
			}
		}

		Thread.sleep(6500);
		int Org = driver.findElements(By.xpath("//button[@title='Refresh']")).size();

		if (Org > 0) {
			Thread.sleep(3500);
			WebElement Refresh = new WebDriverWait(driver, Duration.ofSeconds(30))
					.until(ExpectedConditions.visibilityOf(btnRefresh));
			Refresh.click();
			Thread.sleep(4000);
			ElementUtils.waitForElementToDisplay(lblRoomAva, 100);
		} else {
			Thread.sleep(3500);
			WebElement GO = new WebDriverWait(driver, Duration.ofSeconds(30))
					.until(ExpectedConditions.visibilityOf(btnGo));
			GO.click();
			Thread.sleep(4000);
			ElementUtils.waitForElementToDisplay(lblRoomAva, 100);
		}
		return flag;
	}

	public boolean verifyCucstomCol1drpFunc() throws InterruptedException {

		ElementUtils.waitForElementToDisplay(lblRoomAva, 100);

		Thread.sleep(4000);
		drpColumn1.click();
		Thread.sleep(6000);

		ExpectedConditions.visibilityOf(listDrpSize.get(1));
		for (int x = 0; x < listDrpSize.size(); x++) {
			/* split and ready the data from property file */
			String[] a = configReader.getProp("Custom_col1").split(",");
			String expected = a[x];
			String actual = listDrpSize.get(x).getText();
			if (actual.contains(expected)) {
				flag = true;
			} else {
				flag = false;
			}

		}
		Thread.sleep(6000);

		try {
			for (int i = 0; i < listDrpSize.size(); i++) {
				if (listDrpSize.get(i).getText().equalsIgnoreCase(configReader.getProp("PnLE_Column"))) {
					listDrpSize.get(i).click();
				}
			}
		} catch (StaleElementReferenceException e) {
			for (int i = 0; i < listDrpSize.size(); i++) {
				if (listDrpSize.get(i).getText().equalsIgnoreCase(configReader.getProp("PnLE_Column"))) {
					listDrpSize.get(i).click();
				}
			}
		}

		Thread.sleep(2000);
		return flag;
	}

	public boolean verifyCucstomYeardrpFunc() throws InterruptedException {

		Thread.sleep(4000);
		drpYear1.click();
		Thread.sleep(8000);
		int y = listDrpValueSize.size();

		if (y < 0) {
			drpYear1.click();
			Thread.sleep(8000);
			ExpectedConditions.visibilityOf(listDrpSize.get(1));
			for (int x = 0; x < listDrpSize.size(); x++) {
				/* split and ready the data from property file */
				String[] a = configReader.getProp("Custom_Year").split(",");
				String expected = a[x];
				String actual = listDrpSize.get(x).getText();
				if (actual.contains(expected)) {
					flag = true;
				} else {
					flag = false;
				}
			}

			try {
				for (int i = 0; i < listDrpSize.size(); i++) {
					if (listDrpSize.get(i).getText().equalsIgnoreCase(configReader.getProp("PnLE_Year"))) {
						listDrpSize.get(i).click();
					}
				}
			} catch (StaleElementReferenceException e) {
				for (int i = 0; i < listDrpSize.size(); i++) {
					if (listDrpSize.get(i).getText().equalsIgnoreCase(configReader.getProp("PnLE_Year"))) {
						listDrpSize.get(i).click();
					}
				}
			}

			Thread.sleep(2000);
		} else {
			ExpectedConditions.visibilityOf(listDrpSize.get(1));
			for (int x = 0; x < listDrpSize.size(); x++) {
				/* split and ready the data from property file */
				String[] a = configReader.getProp("Custom_Year").split(",");
				String expected = a[x];
				String actual = listDrpSize.get(x).getText();
				if (actual.contains(expected)) {
					flag = true;
				} else {
					flag = false;
				}
			}

			try {
				for (int i = 0; i < listDrpSize.size(); i++) {
					if (listDrpSize.get(i).getText().equalsIgnoreCase(configReader.getProp("PnLE_Year"))) {
						listDrpSize.get(i).click();
					}
				}
			} catch (StaleElementReferenceException e) {
				for (int i = 0; i < listDrpSize.size(); i++) {
					if (listDrpSize.get(i).getText().equalsIgnoreCase(configReader.getProp("PnLE_Year"))) {
						listDrpSize.get(i).click();
					}
				}
			}

			Thread.sleep(2000);
		}

		return flag;
	}

}
