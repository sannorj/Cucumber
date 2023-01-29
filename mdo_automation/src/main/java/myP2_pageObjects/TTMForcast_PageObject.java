package myP2_pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ConfigReader;
import utils.ConstantsReader;

public class TTMForcast_PageObject {

	private WebDriver driver;
	private ConstantsReader configReader = new ConstantsReader();
	ArrayList<Double> lstForcast, lstTTMForcast;

	public TTMForcast_PageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		lstForcast = new ArrayList<>();
		lstTTMForcast = new ArrayList<>();
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

	@FindBy(xpath = "//div[@role='listbox']//li")
	List<WebElement> lstDropDownGroup;

	@FindBy(xpath = "//input[@name='portfolio-hotel']")
	WebElement dropDownHotel;

	@FindBy(xpath = "//div[@role='listbox']//li")
	List<WebElement> lstDropDownHotel;

	@FindBy(xpath = "//div[@id='mui-component-select-selectedYear']")
	WebElement dropDownPeriod;

	@FindBy(xpath = "//div[@role='listbox']//li")
	List<WebElement> lstDropDownPeriod;

	@FindBy(xpath = "//div[@id='mui-component-select-customViewId']")
	WebElement dropDownView;

	@FindBy(xpath = "//div[@role='listbox']//li")
	List<WebElement> lstDropDownView;

	@FindBy(xpath = "//button[@data-el='buttonGo']")
	WebElement btnGo;

	@FindBy(xpath = "//div[text()='Rooms available']")
	WebElement lblRoomAva;

	@FindBy(xpath = "//th//span[contains(text(),'TTM Actual')]")
	WebElement ttmHeader;

	@FindBy(xpath = "//h3[text()='Edit Columns']")
	WebElement lblEdit;

	@FindBy(xpath = "//button[@data-el='buttonFilter']")
	WebElement btnFilter;

	@FindBy(xpath = "//tr[@class='MuiTableRow-root MuiTableRow-head']//th[@freezecolumns='0']")
	List<WebElement> lstReportMonthHeader;

	@FindBy(xpath = "//tbody//tr[1]//td")
	List<WebElement> lstForcastYear;

	@FindBy(xpath = "//tbody//tr[1]//td")
	List<WebElement> lstForcastTTM;

	public void passParameteres() {

		try {
			dropDownGroup.click();
			Thread.sleep(1500);
			for (int i = 0; i < lstDropDownGroup.size(); i++) {
				if (lstDropDownGroup.get(i).getText().equalsIgnoreCase(configReader.getProp("TTMGroup"))) {
					lstDropDownGroup.get(i).click();

				}
			}

			dropDownHotel.click();
			Thread.sleep(1500);
			for (int i = 0; i < lstDropDownHotel.size(); i++) {
				if (lstDropDownHotel.get(i).getText().equalsIgnoreCase(configReader.getProp("TTMProperty"))) {
					lstDropDownHotel.get(i).click();

				}
			}

			dropDownPeriod.click();
			Thread.sleep(2000);
			lstDropDownPeriod.get(1).click();

			dropDownView.click();
			for (int i = 0; i < lstDropDownView.size(); i++) {
				if (lstDropDownView.get(i).getText().equalsIgnoreCase(configReader.getProp("TTMView"))) {
					lstDropDownView.get(i).click();

				}
			}

		} catch (

		Exception e) {
			e.printStackTrace();
		}
	}

	public void storeactualForcastData() {
		for (int i = 0; i < 6; i++) {

			WebElement forcastData = driver.findElement(By.xpath("//tbody//tr[" + (i + 1) + "]//td[" + 16 + "]"));

			lstForcast.add(Double
					.parseDouble(forcastData.getText().replaceAll(",", "").replaceAll("\\$", "").replaceAll("%", "")));

		}
		
		for (int i = 0; i < 6; i++)
		{
			System.out.println("AAA"+lstForcast.get(i));
		}
	}

	public void storeTTMForcastData() {
		for (int i = 0; i < 6; i++) {

			WebElement forcastData = driver.findElement(By.xpath("//tbody//tr[" + (i + 1) + "]//td[" + 16 + "]"));

			lstTTMForcast.add(Double
					.parseDouble(forcastData.getText().replaceAll(",", "").replaceAll("\\$", "").replaceAll("%", "")));

		}
		for (int i = 0; i < 6; i++)
		{
			System.out.println("BBB"+lstTTMForcast.get(i));
		}
	}

	public boolean compareForcastData() {
		boolean flag = false;

		for (int i = 0; i < lstTTMForcast.size(); i++) {

			if (lstTTMForcast.get(i) == lstTTMForcast.get(i)) {
				flag = true;
			} else {
				flag = false;
				break;
			}
		}
		return flag;
	}
}
