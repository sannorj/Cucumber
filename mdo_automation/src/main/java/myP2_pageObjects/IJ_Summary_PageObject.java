package myP2_pageObjects;

import java.time.Duration;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
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

public class IJ_Summary_PageObject {

	private WebDriver driver;
	private ConstantsReader configReader = new ConstantsReader();

	public IJ_Summary_PageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[@data-el='menuToggle']")
	WebElement mainMenuButton;

	@FindBy(xpath = "//div[text()='Income Journal']//ancestor::li")
	WebElement menuIJ;

	@FindBy(xpath = "//a[contains(text(),'Summary (New)')]//ancestor::li")
	WebElement subMenuIJSummary;

	@FindBy(xpath = "//h1[contains(text(),'Summary (New)')]")
	WebElement h1IncomeJournalSummary;

	@FindBy(xpath = "//div/input[contains(@name, 'hotelId')]")
	WebElement drpProperty;

	@FindBy(xpath = "//div[@role='listbox']//li")
	List<WebElement> listDrpValueSize;
	
	@FindBy(xpath = "//ul[@role='listbox']//li")
	List<WebElement> listDrpPeriod;

	@FindBy(xpath = "//div[@data-el='selectorIJPeriod']")
	WebElement drpPeriod;

	@FindBy(xpath = "//label[text()='Date']//parent::div//input")
	WebElement txtDate;

	@FindBy(xpath = "//button//span[text()='Go']")
	WebElement btnGo;

	@FindBy(xpath = "//div[text()='Total Revenue']")
	WebElement lblTotalRevenue;

	@FindBy(xpath = "//button[@data-el='buttonDropdownIJActions']")
	WebElement option;

	@FindBy(xpath = "(//li[@role='menuitem'])[4]")
	WebElement addOption;

	@FindBy(xpath = "//p[text()='Total:']")
	WebElement lblTotal;

	@FindBy(xpath = "//input[@name='description']")
	WebElement txtDescription;

	@FindBy(xpath = "//div[@data-el='selectorPmsType']")
	WebElement drpPMStype;

	@FindBy(xpath = "//input[@name='amount']")
	WebElement txtAmount;

	@FindBy(xpath = "//input[@name='amountAdjustment']")
	WebElement txtAdjustment;

	@FindBy(xpath = "//input[@name='hmgGlCode']")
	WebElement drpGlCode;

	@FindBy(xpath = "//span[text()='Save']//parent::button")
	WebElement btnSave;

	@FindBy(xpath = "//div[text()='Total Revenue']/../../button[@class='sc-bZnhIo jzTzWP']")
	WebElement expandIcon;

	@FindBy(xpath = "//div[@class='sc-cTQhss cONwqk']//div[@class='sc-btIRyd biWwqa']")
	List<WebElement> lstAddedValue;

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

	String descriptionAllList = configReader.getProp("IJ_DescriptionList");
	List<String> descriptionList = Arrays.asList(descriptionAllList.split(","));

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
		String[] dateForPicker = configReader.getProp("IJ_Date").split("/");

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

	public void expandForms() {

		try {
			WebElement menu = new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(mainMenuButton));
			menu.click();

			/* mandatory pause */
			Thread.sleep(1500);

			WebElement reportsEle = new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(menuIJ));
			reportsEle.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public boolean navigateIJSummaryFunc() throws InterruptedException {

		WebElement pnlStatementEle = new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(subMenuIJSummary));
		pnlStatementEle.click();

		ElementUtils.waitForElementToDisplay(h1IncomeJournalSummary, 100);

		WebElement h1IJSummary = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(h1IncomeJournalSummary));
		return h1IJSummary.isDisplayed();

	}

	public void selectParametersFunc() throws InterruptedException {

		/* Select the appropriate Property value from the drop-down menu. */
		Thread.sleep(5000);
		WebElement drpGroupEle = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.visibilityOf(drpProperty));
		drpGroupEle.click();
		ExpectedConditions.visibilityOf(listDrpValueSize.get(0));
		for (int i = 0; i < listDrpValueSize.size(); i++) {
			if (listDrpValueSize.get(i).getText().equalsIgnoreCase(configReader.getProp("IJ_Propery"))) {
				listDrpValueSize.get(i).click();
			}
		}

		Thread.sleep(5000);
		
		/* Select the appropriate Property value from the drop-down menu. */
		WebElement drpPeriodEle = new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(drpPeriod));
		drpPeriodEle.click();
		
		Thread.sleep(3000);
		
		for (int i = 0; i < listDrpPeriod.size(); i++) {
			if (listDrpPeriod.get(i).getText().equalsIgnoreCase(configReader.getProp("IJ_Period"))) {
				listDrpPeriod.get(i).click();
			}
		}
		Thread.sleep(3000);
		selectDate();
		Thread.sleep(1000);

		btnGo.click();
		Thread.sleep(1000);
		ElementUtils.waitForElementToDisplay(lblTotalRevenue, 100);

	}
	
	public void selectParameterAfterPageLoad() throws InterruptedException {
		

		/* Select the appropriate Property value from the drop-down menu. */
		Thread.sleep(5000);
		WebElement drpGroupEle = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.visibilityOf(drpProperty));
		drpGroupEle.click();
		ExpectedConditions.visibilityOf(listDrpValueSize.get(0));
		for (int i = 0; i < listDrpValueSize.size(); i++) {
			if (listDrpValueSize.get(i).getText().equalsIgnoreCase(configReader.getProp("IJ_Propery"))) {
				listDrpValueSize.get(i).click();
			}
		}

		/* Select the appropriate Property value from the drop-down menu. */
		WebElement drpPeriodEle = new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(drpPeriod));
		drpPeriodEle.click();
		
		Thread.sleep(3000);
		
		for (int i = 0; i < listDrpPeriod.size(); i++) {
			if (listDrpPeriod.get(i).getText().equalsIgnoreCase(configReader.getProp("IJ_Period"))) {
				listDrpPeriod.get(i).click();
			}
		}
		Thread.sleep(3000);
		//selectDate();
		Thread.sleep(1000);

		btnGo.click();
		Thread.sleep(1000);
		ElementUtils.waitForElementToDisplay(lblTotalRevenue, 100);
	}

	public boolean clickOnAddIconFunc() throws InterruptedException {

		option.click();
		Thread.sleep(1000);

		addOption.click();
		ElementUtils.waitForElementToDisplay(lblTotal, 100);
		return lblTotal.isDisplayed();

	}

	public void addRowFunc() throws InterruptedException {

		/* enter the IJ_Description */
		txtDescription.sendKeys(configReader.getProp("IJ_Description"));

		Thread.sleep(5000);
		/* Select the appropriate PMS Type from the drop-down menu. */
		WebElement drpPMStypeEle = new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(drpPMStype));
		drpPMStypeEle.click();
		
		Thread.sleep(3500);
		
		for (int i = 0; i < listDrpPeriod.size(); i++) {
			if (listDrpPeriod.get(i).getText().equalsIgnoreCase(configReader.getProp("IJ_PMSType"))) {
				listDrpPeriod.get(i).click();
			}
		}
		Thread.sleep(4500);

		/* enter the Amount */
		WebElement txtAmountEle = new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(txtAmount));
		txtAmountEle.click();
		txtAmount.sendKeys(configReader.getProp("IJ_Amount"));

		Thread.sleep(3500);
		
		/* enter the adjustment */
		txtAdjustment.sendKeys(configReader.getProp("IJ_adjustment"));

		/* Select the appropriate GL code from the drop-down menu. */
		WebElement drpGlCodeEle = new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(drpGlCode));
		drpGlCodeEle.click();
		
		Thread.sleep(3000);
		
		for (int i = 0; i < listDrpValueSize.size(); i++) {
			if (listDrpValueSize.get(i).getText().equalsIgnoreCase(configReader.getProp("IJ_GLCode"))) {
				listDrpValueSize.get(i).click();
			}
		}

		btnSave.click();
		ElementUtils.waitForElementToDisplay(lblTotalRevenue, 100);
		Thread.sleep(6000);

	}

	public boolean verifyAddedRowFunc() throws InterruptedException {

		/* expand the icon */
		WebElement expandIcon = driver.findElement(By.xpath("//div[text()='" + "Total "+ (configReader.getProp("IJ_PMSType")) + "']/../../button"));
		expandIcon.click();
		Thread.sleep(1500);

		boolean flag = true;
		for (int x = 0; x < lstAddedValue.size(); x++) {
			String value = lstAddedValue.get(x).getText();
			if (value.equals(configReader.getProp("IJ_Description"))) {
				flag = true;
			} else {
				flag = false;
			}

		}
		return flag;
	}

	public boolean verifyDescription() {
		boolean rawExist = true;
		for (int i = 0; i < descriptionList.size(); i++) {
			System.out.println(descriptionList.get(i));
			int rawVisible = driver.findElements(By.xpath("//table/tbody/tr/td[1]//div[text()='" + descriptionList.get(i) + "']")).size();
			if (rawVisible < 1)
				rawExist = false;
		}
		return rawExist;
	}

}
