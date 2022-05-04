package myP2_pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Dashboard_PrimaryDecimal_PageObjective {

	private WebDriver driver;
	String roomRevenue, roomAvailable;
	int masterDecimal, primaryDecimal;

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

	@FindBy(xpath = "//input[@name='date']")
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

	@FindBy(xpath = "	//button[@data-el='button-edit-Room Revenue ($)']")
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

	public boolean loadPageWithParameters(String grp, String property, String date) throws InterruptedException {

		WebElement homePage = new WebDriverWait(driver, Duration.ofSeconds(20))
				.until(ExpectedConditions.visibilityOf(header));

		if (homePage.isDisplayed()) {

			WebElement drpGroup = new WebDriverWait(driver, Duration.ofSeconds(5))
					.until(ExpectedConditions.visibilityOf(dropDownGroup));

			drpGroup.click();
			for (int i = 0; i < lstDropDowGroup.size(); i++) {
				if (lstDropDowGroup.get(i).getText().equalsIgnoreCase(grp)) {
					lstDropDowGroup.get(i).click();

				}
			}

			dropDownProperty.click();
			for (int i = 0; i < lstDropDowProperty.size(); i++) {
				if (lstDropDowProperty.get(i).getText().equalsIgnoreCase(property)) {
					lstDropDowProperty.get(i).click();

				}
			}

			txtDate.sendKeys(Keys.CONTROL + "a");
			txtDate.sendKeys(Keys.DELETE);
			txtDate.sendKeys(date);

			WebElement txtProperty = new WebDriverWait(driver, Duration.ofSeconds(15))
					.until(ExpectedConditions.visibilityOf(txtRowField));

			return txtProperty.isDisplayed();

		} else {
			return false;
		}

	}

	public void setupPrimaryDecimalValue(String value) throws InterruptedException {

		WebElement btnEdit = new WebDriverWait(driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.visibilityOf(btnEditColumn));

		btnEdit.click();

		WebElement drpDecimal = new WebDriverWait(driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.visibilityOf(dropDownDecimal));

		if (drpDecimal.isDisplayed()) {

			drpDecimal.click();

			Thread.sleep(2500);

			for (int i = 0; i < lstDropDownDecimal.size(); i++) {
				if (lstDropDownDecimal.get(i).getText().equalsIgnoreCase(value)) {
					lstDropDownDecimal.get(i).click();

					masterDecimal = Integer.parseInt(value);
				}
			}
		}

	}

	public boolean navigateToSetupPermenantDecimal() throws InterruptedException {

		Thread.sleep(15000);

		WebElement editRoomAvailable = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.visibilityOf(btnEditRoomAvailable));
		editRoomAvailable.click();

		Thread.sleep(5000);

		WebElement editPage = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.visibilityOf(editPageEle));
		return editPage.isDisplayed();

	}

	public void assignPermenantDecimal(String value) throws InterruptedException {
		Thread.sleep(3000);

		WebElement editDecimal = new WebDriverWait(driver, Duration.ofSeconds(35))
				.until(ExpectedConditions.visibilityOf(dropDownEditDecimal));

		editDecimal.click();

		for (int i = 0; i < lstdropDownEditDecimal.size(); i++) {
			if (lstdropDownEditDecimal.get(i).getText().equalsIgnoreCase(value)) {
				lstdropDownEditDecimal.get(i).click();

				primaryDecimal = Integer.parseInt(value);
			}
		}

		Thread.sleep(2000);
		btnSave.click();

	}

	public boolean navigateToSetupOverRideValue() throws InterruptedException {

		Thread.sleep(5000);

		WebElement editRoomRevenue = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.visibilityOf(btnEditRoomRevenue));
		editRoomRevenue.click();

		Thread.sleep(2500);

		WebElement editPage = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.visibilityOf(editPageEle));
		return editPage.isDisplayed();

	}

	public void assignOverrideDecimal() throws InterruptedException {
		Thread.sleep(2500);

		if (dropDownEditDecimal.isDisplayed()) {
			toggleButton.click();
		}
		
		dropDownMassterFeature.click();
		lstSwitch.get(0).click();

		Thread.sleep(2000);
		btnSave.click();

	}

	public void storeValues() throws InterruptedException {

		WebElement editPage = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.visibilityOf(txtRowField));

		if (editPage.isDisplayed()) {
			WebElement roomAvailableWE = new WebDriverWait(driver, Duration.ofSeconds(10))
					.until(ExpectedConditions.visibilityOf(txtRoomAvailable));

			roomAvailable = roomAvailableWE.getText();

			WebElement roomRevenueWE = new WebDriverWait(driver, Duration.ofSeconds(10))
					.until(ExpectedConditions.visibilityOf(txtRoomRevenue));

			roomRevenue = roomRevenueWE.getText();

			System.out.println("roomAvailable = " + roomAvailable + " roomRev = " + roomRevenue);

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

		return result;
	}

}
