package myP2_pageObjects;

import java.time.Duration;
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
		
		/* Select the appropriate From date  from Date picker */
		
		Thread.sleep(3000);
//		txtDate.sendKeys(Keys.CONTROL + "a");
//		txtDate.sendKeys(Keys.DELETE);
		txtDate.sendKeys(Keys.CONTROL + "a");
	//	txtDate.sendKeys(Keys.BACK_SPACE);
		Thread.sleep(3000);
		txtDate.sendKeys(configReader.getProp("RM_Date"));
		System.out.println("=====dateeeeeeeee====== "+configReader.getProp("RM_Date"));
		Thread.sleep(2000);
		
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
