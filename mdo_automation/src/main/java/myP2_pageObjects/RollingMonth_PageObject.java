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
import utils.ElementUtils;

public class RollingMonth_PageObject {
	
	String ColumnData[][] ;
	boolean flag;
	private WebDriver driver;
	private ConstantsReader configReader = new ConstantsReader();

	public RollingMonth_PageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//button[@data-el='menuToggle']")
	WebElement mainMenuButton;
	
	@FindBy(xpath = "//div[text()='Reports']//ancestor::li")
	WebElement reports;

	@FindBy(xpath = "//div[text()='Revenue']//ancestor::li")
	WebElement reveneue;
	
	@FindBy(xpath = "//div[text()='30/60/90']//ancestor::li")
	WebElement RollingCalendarReport;
	
	@FindBy(xpath = "//div[text()='30/60/90 Rolling Month']//ancestor::li")
	WebElement menuRollingMonth;
	
	@FindBy(xpath = "//h1[text()='30/60/90 Rolling Month Report']")
	WebElement hlRollingMonthReport;
	
	@FindBy(xpath = "//ul[@role='listbox']//li")
	List <WebElement> listDrpValueSize;
	
	@FindBy(xpath = "//div/input[contains(@name, 'portfolio-group')]")
	WebElement drpgroup;
	
	
	@FindBy(xpath = "//label[text()='Date']//parent::div//input")
	WebElement txtDate;
	
//	@FindBy(xpath = "//input[@type='tel']")
//	WebElement txtDate;

	
	@FindBy(xpath = "//span[text()='Go']//parent::button")
	WebElement btnGo;
	
	@FindBy(xpath = "//span[text()='Property']")
	WebElement lblProperty;
	
	@FindBy(xpath = "//span[text()='Property']")
	List <WebElement> lstHeaders ;
	
	
	@FindBy(xpath = "//th[contains(@class,'MuiTableCell-head')]//span")
	List <WebElement> listHeaders;
	
	@FindBy(xpath = "//input[@name='keyword']")
	WebElement txtSearch;
	
	@FindBy(xpath = "//*[@id='root']//table/tbody/tr/td[1]/div/div/div/div/div")
	List <WebElement> lstRows;
	
	@FindBy(xpath = "//*[@id='root']//table/tbody/tr[1]/td/div/div/div/div/div")
	List <WebElement> noOfColumns;
	
	@FindBy(xpath = "//div[@data-el='buttonSummary']")
	WebElement tabCalendarMonth;
	
	@FindBy(xpath = "//div//label[text() = 'Date'] //following-sibling::div//button")
	WebElement btnDatePicker;

	@FindBy(xpath = "//div[@role='dialog']")
	WebElement divCalender;

	@FindBy(xpath = "//div[@role='presentation']//button")
	WebElement btnExpandYear;

	@FindBy(xpath = "//div[contains(@class, 'MuiPickersArrowSwitcher')]//button[@title='Previous month']")
	WebElement btnPreviousMonth;

	@FindBy(xpath = "//div[contains(@class, 'MuiPickersArrowSwitcher')]//button[@title='Next month']")
	WebElement btnNextMonth;
	
	public void expandReportFunc() throws InterruptedException {

			WebElement menu = new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(mainMenuButton));
			menu.click();
			/* mandatory pause */
			Thread.sleep(1500);

			WebElement reportsEle = new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(reports));
			reportsEle.click();

			WebElement revenueEle = new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(reveneue));
			revenueEle.click();

			WebElement pickUpReportsEle = new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(RollingCalendarReport));
			pickUpReportsEle.click();	

	}

	public boolean navigateRollingMonthPage() {

		WebElement menuRollingMonthEle = new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(menuRollingMonth));
		menuRollingMonthEle.click();

		WebElement hlRollingMonth = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(hlRollingMonthReport));
		return hlRollingMonth.isDisplayed();

	}
	
	public int getMonth() {
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int month = cal.get(Calendar.MONTH);
		return month + 1;
	}
	public boolean selectDate() throws InterruptedException {
		boolean flag = false;
		String [] dateForPicker = configReader.getProp("RM_Date").split("/");
		
		WebElement datePicker = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(btnDatePicker));
		datePicker.click();
		Thread.sleep(2500);
		int status = driver.findElements(By.xpath("//div[@role='dialog']")).size();
		if (status == 1) {
			WebElement expandYear = new WebDriverWait(driver, Duration.ofSeconds(10))
					.until(ExpectedConditions.visibilityOf(btnExpandYear));
			expandYear.click();
			Thread.sleep(2500);
			WebElement pickYear = driver.findElement(By
					.xpath("//div[contains(@class, 'PrivatePickersYear')]//button [contains(text(), '" + dateForPicker[2] + "')]"));
			pickYear.click();
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
				flag = true;
			}
			else {
				WebElement btnDate = driver
						.findElement(By.xpath(" //div[@role='cell']//button[text() = '" + dateForPicker[1] + "']"));
				btnDate.click();
				flag = true;
			}
			
		}
		else
		{
			flag = false;
		}
		return flag;
	}
	
	
	
	
	public void selectParametersFunc() throws InterruptedException {
		
		/* Select the appropriate Property value from the drop-down menu. */
		WebElement drpgroupEle = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(drpgroup));
		drpgroupEle.click();
		
		ExpectedConditions.visibilityOf(listDrpValueSize.get(0));
		for (int i = 0; i < listDrpValueSize.size(); i++) {
			if (listDrpValueSize.get(i).getText().equalsIgnoreCase(configReader.getProp("RM_Group"))) {
				listDrpValueSize.get(i).click();
			}
		}
		
		Thread.sleep(4000);

	//	drpgroup.sendKeys(Keys.TAB);
//		Thread.sleep(4000);
//		txtDate.sendKeys(Keys.CONTROL + "a");
//		txtDate.sendKeys(Keys.DELETE);
//		txtDate.sendKeys(configReader.getProp("RM_Date"));
//		Thread.sleep(2000);
		
		selectDate();
		
		btnGo.click();
		Thread.sleep(1000);
		ElementUtils.waitForElementToDisplay(lblProperty, 100);
		
		
	}
	
	
	public boolean verifyHeaders() throws InterruptedException {

		Thread.sleep(7500);
		for (int x = 0; x < 5; x++) {
			/* split and ready the data from property file */
			String[] a = configReader.getProp("RM_Headers").split(",");
			for (int i = 0; i < 5; i++) {
				String expected = a[i];
				String actual = listHeaders.get(i+1).getText();
				if (actual.contains(expected)) {
					flag = true;
				} else {
					flag = false;
				}
			}

		}
		return flag;

	}
	
	public void inputSearchParameterFunc() throws InterruptedException {
		
		ElementUtils.waitForElementToDisplay(lblProperty, 100);
		txtSearch.sendKeys(configReader.getProp("RM_Search"));
		Thread.sleep(4000);
		
	}
	
	public boolean verifySearchedParameterFunc() throws InterruptedException {
		
		int columnCount;
		boolean flag = true;
		ColumnData = new String[lstRows.size()][noOfColumns.size()];

		for (int x = 0; x < lstRows.size(); x++) {
			for (int t = 0; t < noOfColumns.size(); t++) {
				WebElement no = driver.findElement(By.xpath("//*[@id='root']//table/tbody/tr[" + (x + 1) + "]/td[" + (t + 1) + "]/div/div/div/div/div"));
				ColumnData[x][t] = no.getText();

			}
		}

		for (int x = 0; x < ColumnData.length; x++) {
			columnCount = 0;
			for (int t = 0; t < ColumnData[x].length; t++) {
				String expected = configReader.getProp("RM_Search");
				if (ColumnData[x][t].contains(expected)) {
					flag = true;
					columnCount++;
					break;
				} else {
					flag = false;
				}
			}
			return flag;
		}
		return flag;

	}
	
	public void navigateToCalendarMonth() throws InterruptedException {
		tabCalendarMonth.click();
		ElementUtils.waitForElementToDisplay(lblProperty, 100);

	}
	
	public boolean verifyParametesFunc() throws InterruptedException {

		String group = drpgroup.getAttribute("value");
		String date = txtDate.getAttribute("value");

		if (group.equals(configReader.getProp("RM_Group")) && date.equals(configReader.getProp("RM_Date"))) {
			flag = true;
		} else {
			flag = false;
		}
		return flag;

	}
	
}
