package myP2_pageObjects;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.ConstantsReader;
import utils.ElementUtils;

public class PnlTTM_PageObject {

	private WebDriver driver;
	private ConstantsReader configReader = new ConstantsReader();
	ArrayList<String> monthList, reportMonth;

	public PnlTTM_PageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		monthList = new ArrayList<>();
		reportMonth = new ArrayList<>();
		storeMonth();
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

	@FindBy(xpath = "//ul[@role='listbox']//li")
	List<WebElement> lstDropDownPeriod;

	@FindBy(xpath = "//div[@id='mui-component-select-customViewId']")
	WebElement dropDownView;

	@FindBy(xpath = "//ul[@role='listbox']//li")
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

	@FindBy(xpath = "//div[@data-el='dropdown']")
	WebElement drpColumn1;

	@FindBy(xpath = "//div[@data-el='selectorColumnMonth0']")
	WebElement drpSelectorMonth;

	@FindBy(xpath = "(//tr[2])[1]//th[@freezecolumns='0']")
	List<WebElement> lstReportMonthHeader;
	// --------//tr[@class='MuiTableRow-root
	// MuiTableRow-head']//th[@freezecolumns='0']---------------//

	public void passParameteres() {

		try {
			Thread.sleep(5000);

			dropDownGroup.click();
			Thread.sleep(5000);
			for (int i = 0; i < lstDropDownGroup.size(); i++) {
				if (lstDropDownGroup.get(i).getText().equalsIgnoreCase(configReader.getProp("TTMGroup"))) {
					lstDropDownGroup.get(i).click();

				}
			}

			Thread.sleep(5000);

			dropDownHotel.click();
			Thread.sleep(7500);

			for (int i = 0; i < lstDropDownHotel.size(); i++) {
				if (lstDropDownHotel.get(i).getText().equalsIgnoreCase(configReader.getProp("TTMProperty"))) {
					lstDropDownHotel.get(i).click();

				}
			}
			Thread.sleep(7500);

			dropDownPeriod.click();
			Thread.sleep(7500);
			lstDropDownPeriod.get(0).click();
			Thread.sleep(7500);

			dropDownView.click();
			Thread.sleep(7500);

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

	public boolean verifyTTMHeader() {
		int status = driver.findElements(By.xpath("//th//span[contains(text(),'TTM Actual')]")).size();

		if (status > 0) {
			return true;
		} else {
			return false;
		}
	}

	public void navigateToEditColumn() throws InterruptedException {
		ElementUtils.waitForElementToDisplay(lblRoomAva, 100);
		btnFilter.click();
		ElementUtils.waitForElementToDisplay(lblEdit, 100);
	}

	public boolean verifyColumnDropdownCount() throws InterruptedException {

		Thread.sleep(2500);
		int status = driver.findElements(By.xpath("//div[@data-el='dropdown']")).size();

		if (status == 1) {
			return true;
		} else {
			return false;
		}

	}

	public boolean verifyColumnDropdownValue() throws InterruptedException {

		Thread.sleep(2500);
		WebElement columnDropDown1 = new WebDriverWait(driver, Duration.ofSeconds(20))
				.until(ExpectedConditions.visibilityOf(drpColumn1));

		columnDropDown1.click();

		Thread.sleep(3500);

		int status = driver.findElements(By.xpath("//ul[@role='listbox']//li")).size();

		if (status == 1) {
			return true;
		} else {
			return false;
		}

	}

	public void storeMonth() {
		for (int i = 0; i < 12; i++) {
			SimpleDateFormat format = new SimpleDateFormat("MMM yyyy");
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.MONTH, -i);
			monthList.add(format.format(cal.getTime()).toString());
		}

	}

	public boolean storeReportMonthHeader() throws InterruptedException {
		Thread.sleep(2500);
		boolean status = false;

		for (int i = lstReportMonthHeader.size() - 5; i > 0; i--) {
			reportMonth.add(lstReportMonthHeader.get(i + 2).getText());
		}

		for (int i = 0; i < monthList.size(); i++) {
			System.out.println("A" + monthList.get(i));
		}

		for (int i = 0; i < reportMonth.size(); i++) {
			System.out.println("B" + reportMonth.get(i));
		}

		for (int i = 0; i < 12; i++) {
			if (monthList.get(i).equalsIgnoreCase(reportMonth.get(i))) {
				status = true;
			} else {
				status = false;
				break;
			}
		}
		return status;

	}

	public void selectYear(String yearOption) throws InterruptedException {
		WebElement yearOptions = driver.findElement(
				By.xpath("//label[text()='Year']//following::div[@data-el='selectorYear']/div[@role='button']"));
		yearOptions.click();
		
		Thread.sleep(7500);
		
		WebElement yearOptionclick = driver.findElement(By.xpath("//div[@role='listbox']//li[text()='TTM']"));
		yearOptionclick.click();
		Thread.sleep(2500);
	}

	public boolean verifySelectedMonth() throws InterruptedException {
		ElementUtils.waitForElementToDisplay(lblEdit, 100);

		String tempPeriousMonth = getPreviousMonth();

		WebElement selectorMonth = new WebDriverWait(driver, Duration.ofSeconds(20))
				.until(ExpectedConditions.visibilityOf(drpSelectorMonth));

		String dropDownMonthValue = selectorMonth.getText();
		System.out.println("Application month is :" + tempPeriousMonth);

		if (dropDownMonthValue.equalsIgnoreCase(tempPeriousMonth)) {
			return true;
		} else {
			return false;
		}
	}
	
	public String getPreviousMonth()
	{
		LocalDate now = LocalDate.now(); // 2015-11-24
		LocalDate earlier = now.minusMonths(1); // 2015-10-24

		String tempPeriousMonth = earlier.getMonth().toString();
		System.out.println("Previous month is :" + tempPeriousMonth);
		
		return tempPeriousMonth;
	}

}
