package myP2_pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ConstantsReader;

public class PnlTTM_PageObject {

	private WebDriver driver;
	private ConstantsReader configReader = new ConstantsReader();

	public PnlTTM_PageObject(WebDriver driver) {
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

	@FindBy(xpath = "//div[@id='mui-component-select-selectedYear']")
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

	@FindBy(xpath = "//th//span[contains(text(),'TTM Actual')]")
	WebElement ttmHeader;

	public void passParameteres(String grp, String property, String view) {

		try {
			dropDownGroup.click();
			Thread.sleep(1500);
			for (int i = 0; i < lstDropDownGroup.size(); i++) {
				if (lstDropDownGroup.get(i).getText().equalsIgnoreCase(grp)) {
					lstDropDownGroup.get(i).click();

				}
			}

			dropDownHotel.click();
			Thread.sleep(1500);
			for (int i = 0; i < lstDropDownHotel.size(); i++) {
				if (lstDropDownHotel.get(i).getText().equalsIgnoreCase(property)) {
					lstDropDownHotel.get(i).click();

				}
			}

			dropDownPeriod.click();
			Thread.sleep(2000);
			lstDropDownPeriod.get(0).click();

			dropDownView.click();
			for (int i = 0; i < lstDropDownView.size(); i++) {
				if (lstDropDownView.get(i).getText().equalsIgnoreCase(view)) {
					lstDropDownView.get(i).click();

				}
			}

		} catch (

		Exception e) {
			e.printStackTrace();
		}
	}

	public boolean verifyTTMHeader() {
		int status = driver.findElements(By.xpath("//th//span[contains(text(),'TTM Actual')]")).size();

		if (status > 0) {
			return true;
		} else {
			return false;
		}
	}

}
