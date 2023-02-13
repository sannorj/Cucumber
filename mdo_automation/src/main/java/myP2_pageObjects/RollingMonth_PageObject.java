package myP2_pageObjects;

import java.math.BigDecimal;
import java.time.Duration;
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

import com.google.common.math.BigDecimalMath;

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
	
	@FindBy(xpath = "//div[contains(text(),'30/60/90')]//ancestor::li")
	WebElement RollcalReport;
	
	@FindBy(xpath = "//div[text()='30/60/90 Rolling Month']//ancestor::li")
	WebElement menuRollingMonth;
	
	@FindBy(xpath = "//h1[text()='30/60/90 Rolling Month Report']")
	WebElement hlRollingMonthReport;
	
	@FindBy(xpath = "//div[@role='listbox']//li")
	List <WebElement> listDrpValueSize;
	
	@FindBy(xpath = "//div/input[contains(@name, 'portfolio-group')]")
	WebElement drpgroup;
	
	
	@FindBy(xpath = "//label[text()='Date']//parent::div//input")
	WebElement txtDate;

	
	@FindBy(xpath = "//input[@type='tel']")
	WebElement txtDate1;
	
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

	@FindBy(xpath = "//div[@role='presentation']//button[contains(@aria-label, 'calendar view is open, switch to year view')]")
	WebElement btnExpandYear;

	@FindBy(xpath = "//div[contains(@class, 'MuiPickersArrowSwitcher')]//button[@title='Previous month']")
	WebElement btnPreviousMonth;

	@FindBy(xpath = "//div[contains(@class, 'MuiPickersArrowSwitcher')]//button[@title='Next month']")
	WebElement btnNextMonth;
	
	@FindBy(xpath = "//div[@data-el='buttonMapping']")
	WebElement tabRollingMonth;
	
	
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
		String[] dateForPicker = configReader.getProp("RM_Date").split("/");
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

	
	public void expandReportFunc() throws InterruptedException {

			WebElement menu = new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(mainMenuButton));
			menu.click();
			/* mandatory pause */
			Thread.sleep(1500);

			WebElement reportsEle = new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(reports));
			reportsEle.click();

			WebElement revenueEle = new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(reveneue));
			revenueEle.click();

			WebElement cRollcalReportEle = new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(RollcalReport));
			cRollcalReportEle.click();

	}

	public boolean navigateRollingMonthPage() {

		WebElement menuRollingMonthEle = new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(tabRollingMonth));
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
		
		Thread.sleep(4000);	
		selectDate();
		Thread.sleep(4000);	
		
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

		System.out.println("gr:"+group+" dt"+date+" aa"+configReader.getProp("RM_Group")+" bb"+configReader.getProp("CM_Date"));
		
		if (group.equals(configReader.getProp("RM_Group")) && date.equals(configReader.getProp("CM_Date1"))) {
			flag = true;
		} else {
			flag = false;
		}
		return flag;

	}
	
	public boolean verifySumFunc() throws InterruptedException {
		Thread.sleep(1500);
		List<WebElement> headerColumn = driver.findElements(By.xpath("//th/span[@role='button']"));
		for (int p = 0; p < headerColumn.size() - 1; p++) {
			int y = p + 2;
			System.out.println("===============y = p + 2=========="+y);
			if((p + 1) % 3 != 0) {
				List<WebElement> valuecells = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//tbody//tr//td[" + y + "]")));
				String expected = driver.findElement(By.xpath("//table/tbody/tr[last()]/td[" + y + "]")).getText().replaceAll("[$,]", "");
				double expectedtotal = Double.parseDouble(expected);
				double totalvalue = 0;
				
				for (int i = 0; i < valuecells.size() - 1; i++) {
					String actual = valuecells.get(i).getText().replaceAll("[$,]", "");
					double actualvalue = Double.parseDouble(actual);
					totalvalue += actualvalue;

					
				}
				
				double value = expectedtotal;
				String expectedtotalValue = String.format("%.2f", value);
				double expectedtotalValuedecimalNumber = Double.parseDouble(expectedtotalValue);
				int expectedtotalValuewholeNumber = (int) Math.round(expectedtotalValuedecimalNumber);
					
				double roundValue = Math.round(totalvalue * 100.0) / 100.0;
				double value1 = roundValue;
				String SumedValue = String.format("%.2f", value1);
				double SumedValueecimalNumber = Double.parseDouble(SumedValue);
				int SumedValuewholeNumber = (int) Math.round(SumedValueecimalNumber);
				
				System.out.println("==========SumedValue=================="+SumedValue);
				System.out.println("=======expectedtotalValue============="+expectedtotalValue);
				
				if (SumedValuewholeNumber== expectedtotalValuewholeNumber) {
					flag = true;		
				}else {
					flag = false;
				}
			
			}
			
		}
		
		return flag;
	}
}
