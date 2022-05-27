package myP2_pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.ElementUtils;

public class PnLYearly_PageObject {

	private WebDriver driver;
	double roomAvailable[], roomSold[], occupancy[], ADR[], revPar[], totalRevpar[], totalRoomRevenue[],
			totalOperatingRevenue[];
	double occupancyCalc[], adrCalc[], revParCalc[], totalRevParCalc[];

	public PnLYearly_PageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[@data-el='menuToggle']")
	WebElement mainMenuButton;

	@FindBy(xpath = "//div[text()='Reports']//ancestor::li")
	WebElement reports;

	@FindBy(xpath = "//div[text()='P&L Statements']//ancestor::li")
	WebElement pnlStatement;

	@FindBy(xpath = "//div[text()='P&L Yearly']//ancestor::li")
	WebElement pnlYearly;

	@FindBy(xpath = "//h1[text()='Profit & Loss Yearly Report']")
	WebElement pnlYearlyPage;

	@FindBy(xpath = "//input[@name='portfolio-group']")
	WebElement dropDownGroup;

	@FindBy(xpath = "//ul[@role='listbox']//li")
	List<WebElement> lstDropDownGroup;

	@FindBy(xpath = "//input[@name='portfolio-hotel']")
	WebElement dropDownHotel;

	@FindBy(xpath = "//ul[@role='listbox']//li")
	List<WebElement> lstDropDownHotel;

	@FindBy(xpath = "//div[@id='mui-component-select-year']")
	WebElement dropDownPeriod;

	@FindBy(xpath = "//ul[@role='listbox']//li")
	List<WebElement> lstDropDownPeriod;

	@FindBy(xpath = "//div[@id='mui-component-select-customViewId']")
	WebElement dropDownView;

	@FindBy(xpath = "//ul[@role='listbox']//li")
	List<WebElement> lstDropDownView;

	@FindBy(xpath = "//button[@data-el='buttonGo']")
	WebElement btnGo;

	@FindBy(xpath = "//label[@data-el='labelswitchDisableNullRecords']")
	WebElement btnZeroValue;

	@FindBy(xpath = "//div[@data-el='data-container']//tbody//tr[1]//td")
	List<WebElement> lstRoomAvailable;

	@FindBy(xpath = "//div[@data-el='data-container']//tbody//tr[2]//td")
	List<WebElement> lstRoomSold;

	@FindBy(xpath = "//div[@data-el='data-container']//tbody//tr[3]//td")
	List<WebElement> lstOccupancy;

	@FindBy(xpath = "//div[@data-el='data-container']//tbody//tr[4]//td")
	List<WebElement> lstAdr;

	@FindBy(xpath = "//div[@data-el='data-container']//tbody//tr[5]//td")
	List<WebElement> lstRevPar;

	@FindBy(xpath = "//div[@data-el='data-container']//tbody//tr[6]//td")
	List<WebElement> lstTotalRevPar;

	@FindBy(xpath = "//tr[@data-el='RMREV90']//td")
	List<WebElement> lstTotalRoomRevenue;

	@FindBy(xpath = "//tr[@data-el='Total Operating Revenue']//td")
	List<WebElement> lstTotalOperatingRevenue;
	
	@FindBy(xpath = "//div[text()='Rooms available']")
	WebElement lblRoomAva;

	public void expandPnLStatement() {

		try {
			WebElement menu = new WebDriverWait(driver, Duration.ofSeconds(20))
					.until(ExpectedConditions.visibilityOf(mainMenuButton));
			menu.click();
			/* mandatory pause */
			Thread.sleep(1500);

			WebElement reportsEle = new WebDriverWait(driver, Duration.ofSeconds(20))
					.until(ExpectedConditions.visibilityOf(reports));
			reportsEle.click();

			WebElement pnlStatementEle = new WebDriverWait(driver, Duration.ofSeconds(20))
					.until(ExpectedConditions.visibilityOf(pnlStatement));
			pnlStatementEle.click();

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public boolean navigatePnLYearlyPage() {
		WebElement pnlYearlyEle = new WebDriverWait(driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.visibilityOf(pnlYearly));
		pnlYearlyEle.click();

		WebElement pnlYearlyPageEle = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.visibilityOf(pnlYearlyPage));
		return pnlYearlyPageEle.isDisplayed();

	}

	public void passParameteres(String grp, String property, String year, String view) {

		try {
			dropDownGroup.click();
			for (int i = 0; i < lstDropDownGroup.size(); i++) {
				if (lstDropDownGroup.get(i).getText().equalsIgnoreCase(grp)) {
					lstDropDownGroup.get(i).click();

				}
			}

			dropDownHotel.click();
			for (int i = 0; i < lstDropDownHotel.size(); i++) {
				if (lstDropDownHotel.get(i).getText().equalsIgnoreCase(property)) {
					lstDropDownHotel.get(i).click();

				}
			}

			dropDownPeriod.click();
			Thread.sleep(1000);
			for (int i = 0; i < lstDropDownPeriod.size(); i++) {
				if (lstDropDownPeriod.get(i).getText().equals(year)) {
					lstDropDownPeriod.get(i).click();

				}
			}

			dropDownView.click();
			for (int i = 0; i < lstDropDownView.size(); i++) {
				if (lstDropDownView.get(i).getText().equalsIgnoreCase(view)) {
					lstDropDownView.get(i).click();

				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void loadPriorityReport() throws InterruptedException {

		btnGo.click();

		ElementUtils.waitForElementToDisplay(lblRoomAva, 200);
		btnZeroValue.click();
		Thread.sleep(3000);
	

		
		

	}

	public void assignValues() throws InterruptedException {

		Thread.sleep(7500);
		
		roomAvailable = new double[lstRoomAvailable.size() - 2];
		roomSold = new double[lstRoomSold.size() - 2];
		occupancy = new double[lstOccupancy.size() - 2];
		ADR = new double[lstAdr.size() - 2];
		revPar = new double[lstRevPar.size() - 2];
		totalRevpar = new double[lstTotalRevPar.size() - 2];
		totalRoomRevenue = new double[lstTotalRoomRevenue.size() - 2];
		totalOperatingRevenue = new double[lstTotalOperatingRevenue.size() - 2];

		for (int i = 0; i < lstRoomAvailable.size() - 2; i++) {
			roomAvailable[i] = Double
					.parseDouble(lstRoomAvailable.get(i + 2).getText().replaceAll(",", "").replaceAll("\\$", ""));
		}

		for (int i = 0; i < lstRoomSold.size() - 2; i++) {
			roomSold[i] = Double
					.parseDouble(lstRoomSold.get(i + 2).getText().replaceAll(",", "").replaceAll("\\$", ""));
		}

		for (int i = 0; i < lstOccupancy.size() - 2; i++) {
			occupancy[i] = Double.parseDouble(
					lstOccupancy.get(i + 2).getText().replaceAll(",", "").replaceAll("\\$", "").replaceAll("%", ""));
		}

		for (int i = 0; i < lstAdr.size() - 2; i++) {
			ADR[i] = Double.parseDouble(
					lstAdr.get(i + 2).getText().replaceAll(",", "").replaceAll("\\$", "").replaceAll("%", ""));
		}

		for (int i = 0; i < lstRevPar.size() - 2; i++) {
			revPar[i] = Double.parseDouble(
					lstRevPar.get(i + 2).getText().replaceAll(",", "").replaceAll("\\$", "").replaceAll("%", ""));
		}

		for (int i = 0; i < lstTotalRevPar.size() - 2; i++) {
			totalRevpar[i] = Double.parseDouble(lstTotalRevPar.get(i + 2).getText().replaceAll(",", "")
					.replaceAll("\\$", "").replaceAll("%", "").replaceAll("\\(", "").replaceAll("\\)", ""));
		}
		for (int i = 0; i < lstTotalRoomRevenue.size() - 2; i++) {
			totalRoomRevenue[i] = Double.parseDouble(lstTotalRoomRevenue.get(i + 2).getText().replaceAll(",", "")
					.replaceAll("\\$", "").replaceAll("%", "").replaceAll("\\(", "").replaceAll("\\)", ""));
		}
		for (int i = 0; i < lstTotalOperatingRevenue.size() - 2; i++) {
			totalOperatingRevenue[i] = Double
					.parseDouble(lstTotalOperatingRevenue.get(i + 2).getText().replaceAll(",", "").replaceAll("\\$", "")
							.replaceAll("%", "").replaceAll("\\(", "").replaceAll("\\)", ""));
		}

	}

	public void occupancyCalFunc() {
		occupancyCalc = new double[15];

		for (int i = 0; i < 15; i++) {

			if (roomSold[i] > 0 && roomAvailable[i] > 0) {
				occupancyCalc[i] = (roomSold[i] / roomAvailable[i] * 100);
			} else {
				occupancyCalc[i] = 0.00;
			}

		}

		for (int i = 0; i < 15; i++) {
			occupancyCalc[i] = Math.round(occupancyCalc[i] * 100.0) / 100.0;

		}

	}

	public boolean verifyOccCalculationFunc() {

		boolean flag = false;

		for (int i = 0; i < occupancyCalc.length; i++) {
			if (occupancy[i] == occupancyCalc[i]) {
				flag = true;
			} else {
				flag = false;
				break;
			}
		}
		return flag;

	}

	public void adrCalFunc() {
		adrCalc = new double[15];

		for (int i = 0; i < 15; i++) {

			if (roomSold[i] > 0 && totalRoomRevenue[i] > 0) {
				adrCalc[i] = (totalRoomRevenue[i] / roomSold[i]);
			} else {
				adrCalc[i] = 0.00;
			}

		}

		for (int i = 0; i < 15; i++) {
			adrCalc[i] = Math.round(adrCalc[i] * 100.0) / 100.0;

		}

	}

	public boolean verifyAdrCalculationFunc() {

		boolean flag = false;

		for (int i = 0; i < adrCalc.length; i++) {
			if (ADR[i] == adrCalc[i]) {
				flag = true;
			} else {
				flag = false;
				break;
			}
		}
		return flag;

	}

	public void revParCalFunc() {
		revParCalc = new double[15];

		for (int i = 0; i < 15; i++) {

			if (totalRoomRevenue[i] > 0 && roomAvailable[i] > 0) {
				revParCalc[i] = (totalRoomRevenue[i] / roomAvailable[i]);
			} else {
				revParCalc[i] = 0.00;
			}

		}

		for (int i = 0; i < 15; i++) {
			revParCalc[i] = Math.round(revParCalc[i] * 100.0) / 100.0;

		}

	}

	public boolean verifyrevParCalculationFunc() {

		boolean flag = false;

		for (int i = 0; i < revParCalc.length; i++) {
			if (revPar[i] == revParCalc[i]) {
				flag = true;
			} else {
				flag = false;
				break;
			}
		}
		return flag;

	}

	public void totalRevParCalFunc() {
		totalRevParCalc = new double[15];

		for (int i = 0; i < 15; i++) {

			if (totalOperatingRevenue[i] > 0 && roomAvailable[i] > 0) {
				totalRevParCalc[i] = (totalOperatingRevenue[i] / roomAvailable[i]);
			} else {
				totalRevParCalc[i] = 0.00;
			}

		}

		for (int i = 0; i < 15; i++) {
			totalRevParCalc[i] = Math.round(totalRevParCalc[i] * 100.0) / 100.0;

		}

		for (int i = 0; i < totalRevParCalc.length; i++) {
			System.out.println("ade" + totalRevParCalc[i] + ",");

		}
		for (int i = 0; i < totalOperatingRevenue.length; i++) {
			System.out.println("ADR" + totalOperatingRevenue[i] + ",");

		}

	}

	public boolean verifyTotalrevParCalculationFunc() {

		boolean flag = false;

		for (int i = 0; i < totalRevParCalc.length; i++) {
			if (totalRevpar[i] == totalRevParCalc[i]) {
				flag = true;
			} else {
				flag = false;
				break;
			}
		}
		return flag;

	}

}
