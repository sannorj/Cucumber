package myP2_pageObjects;

import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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

public class PnLComparison_PageObject {

	private WebDriver driver;
	private ConstantsReader configReader = new ConstantsReader();

	public PnLComparison_PageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[contains(text(),'P&L Property Comparison Report (New)')]//ancestor::li")
	WebElement pnlPropertyComparison;

	@FindBy(xpath = "//h1[text()='Profit & Loss Property Comparison']")
	WebElement pnlPropertyComparisonPage;

	@FindBy(xpath = "//div/input[contains(@name, 'porfolio')]")
	WebElement drpGroup;

	@FindBy(xpath = "//div[@role='listbox']//li")
	List<WebElement> listDrpValueSize;

	@FindBy(xpath = "//ul[@role='listbox']//li")
	List<WebElement> listDrpView;

	@FindBy(xpath = "//div//label[text() = 'Date'] /following-sibling::div//input")
	WebElement txtDate;

	@FindBy(xpath = "//div[@data-el='dropdownGenericSelector']")
	WebElement drpView;

	@FindBy(xpath = "//button//span[text()='Go']")
	WebElement btnGo;

	@FindBy(xpath = "//tr[@data-el]/td[1]")
	List<WebElement> listSection;

	@FindBy(xpath = "//input[@name='nullRecords']")
	WebElement btnZeroValue;

	@FindBy(xpath = "//h3[text()='Loading...']")
	WebElement lblLoading;

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

	public boolean navigatePnLComparison() throws InterruptedException {

		WebElement pnlPropertyComparisonEle = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(pnlPropertyComparison));
		pnlPropertyComparisonEle.click();

		Thread.sleep(6500);
		WebElement pnlComparisonPageEle = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(pnlPropertyComparisonPage));
		return pnlComparisonPageEle.isDisplayed();

	}

	public void selectParameters() throws InterruptedException {

		Thread.sleep(5000);
		if (drpGroup.isEnabled()) {
			/* Select the appropriate Group value from the drop-down menu. */
			WebElement drpGroupEle = new WebDriverWait(driver, Duration.ofSeconds(25)).until(ExpectedConditions.visibilityOf(drpGroup));
			drpGroupEle.click();

			ExpectedConditions.visibilityOf(listDrpValueSize.get(0));
			for (int i = 0; i < listDrpValueSize.size(); i++) {
				if (listDrpValueSize.get(i).getText().equalsIgnoreCase(configReader.getProp("Group"))) {
					listDrpValueSize.get(i).click();
				}
			}
		}
		Thread.sleep(6500);
		selectDate();

		Thread.sleep(6500);
		WebElement drpViewEle = new WebDriverWait(driver, Duration.ofSeconds(60)).until(ExpectedConditions.visibilityOf(drpView));
		drpViewEle.click();

		Thread.sleep(4000);

		try {
			for (int i = 0; i < listDrpView.size(); i++) {
				if (listDrpView.get(i).getText().equalsIgnoreCase(configReader.getProp("View"))) {
					listDrpView.get(i).click();
				}
			}
		} catch (StaleElementReferenceException e) {
			for (int i = 0; i < listDrpView.size(); i++) {
				if (listDrpView.get(i).getText().equalsIgnoreCase(configReader.getProp("View"))) {
					listDrpView.get(i).click();
				}
			}
		}

		Thread.sleep(4500);
		WebElement btnGO = new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(btnGo));
		btnGO.click();

		Thread.sleep(5000);
		ElementUtils.waitForElementToDisplay(lblRoomAva, 100);
		Thread.sleep(3500);
		btnZeroValue.click();

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

		int btnDatePickforLocal = driver.findElements(By.xpath("//div//label[text() = 'Date'] //following-sibling::div//button")).size();

		if (btnDatePickforLocal > 0) {
			btnDatePicker.click();
		}

		int status = driver.findElements(By.xpath("//div[@role='dialog']")).size();

		if (status == 1) {

			WebElement expandYear = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(btnExpandYear));
			expandYear.click();
			Thread.sleep(2500);

			WebElement pickYear = driver.findElement(By.xpath("//div[contains(@class, 'PrivatePickersYear')]//button [contains(text(), '"+ dateForPicker[2] + "')]"));

			pickYear.click();
			Thread.sleep(2500);

			int monthInnum = getMonth();
			int monthDiff = monthInnum - Integer.parseInt(dateForPicker[0]);

			if (monthDiff > 0) {
				for (int i = 0; i < monthDiff; i++) {
					WebElement btnPrevious = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(btnPreviousMonth));

					Thread.sleep(4000);
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

					Thread.sleep(4000);
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

}
