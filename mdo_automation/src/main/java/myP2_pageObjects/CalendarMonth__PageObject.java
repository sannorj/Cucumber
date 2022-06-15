package myP2_pageObjects;

import java.time.Duration;
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

public class CalendarMonth__PageObject {
	
	String ColumnData[][] ;
	boolean flag;
	private WebDriver driver;
	private ConstantsReader configReader = new ConstantsReader();

	public CalendarMonth__PageObject(WebDriver driver) {
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
	
	@FindBy(xpath = "//div[text()='30/60/90 Calendar Month']//ancestor::li")
	WebElement menuCalendarMonth;
	
	@FindBy(xpath = "//h1[text()='30/60/90 Calendar Month Report']")
	WebElement hlCalendarMonthReport;
	
	@FindBy(xpath = "//th[@class='MuiTableCell-root MuiTableCell-head sc-bBXxYQ dgldxD MuiTableCell-alignCenter']/span")
	List <WebElement> listHeaders;
	
	@FindBy(xpath = "//input[@name='keyword']")
	WebElement txtSearch;
	
	@FindBy(xpath = "//span[text()='Property']")
	WebElement lblProperty;
	
	@FindBy(xpath = "//*[@id='root']//table/tbody/tr/td[1]/div/div/div/div/div")
	List <WebElement> lstRows;
	
	@FindBy(xpath = "//*[@id='root']//table/tbody/tr[1]/td/div/div/div/div/div")
	List <WebElement> noOfColumns;
	
	@FindBy(xpath = "//div[@data-el='buttonMapping']")
	WebElement tabRollingMonth;

	public void expandReportFunc() throws InterruptedException {

		WebElement menu = new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(mainMenuButton));
		menu.click();
		/* mandatory pause */
		Thread.sleep(1500);

		WebElement reportsEle = new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(reports));
		reportsEle.click();

		WebElement revenueEle = new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(reveneue));
		revenueEle.click();

		WebElement calendarMonthReportsEle = new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(RollingCalendarReport));
		calendarMonthReportsEle.click();	

	}
	
	public boolean navigateCalMonthPage() {

		WebElement menuCalendarMonthEle = new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(menuCalendarMonth));
		menuCalendarMonthEle.click();

		WebElement hlCalendarMonth = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(hlCalendarMonthReport));
		return hlCalendarMonth.isDisplayed();

	}
	
	public boolean verifyHeaders() throws InterruptedException {

		Thread.sleep(7500);
		for (int x = 0; x < 5; x++) {
			/* split and ready the data from property file */
			String[] a = configReader.getProp("CM_Headers").split(",");
			for (int i = 0; i < a.length; i++) {
				String expected = a[i];
				String actual = listHeaders.get(i).getText();
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
		txtSearch.sendKeys(configReader.getProp("CM_Search"));
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
				String expected = configReader.getProp("CM_Search");
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
     
     public void navigateToRollingMonth() throws InterruptedException {
    	 tabRollingMonth.click();
 		ElementUtils.waitForElementToDisplay(lblProperty, 100);

 	}
     

	
}
