package myP2_pageObjects;

import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.ConstantsReader;
import utils.ElementUtils;

public class Smoke_Test_PageObject {

	String ColumnData[][] ;
	boolean flag;
	private WebDriver driver;
	private ConstantsReader configReader = new ConstantsReader();

	public Smoke_Test_PageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//button[@data-el='menuToggle']")
	WebElement mainMenuButton;
	
	@FindBy(xpath = "//div[text()='Reports']//ancestor::li")
	WebElement reports;

	@FindBy(xpath = "//div[text()='Revenue']//ancestor::li")
	WebElement reveneue;
	
	@FindBy(xpath = "//div[text()='Accounts Receivable']//ancestor::li")
	WebElement accountsrecv;
	
	@FindBy(xpath = "//div[text()='STR']//ancestor::li")
	WebElement str;
	
	@FindBy(xpath = "//a[contains(text(),'30/60/90')]//ancestor::li")
	WebElement RollcalReport;
	
	@FindBy(xpath = "//a[contains(text(),'AR Aging Dashboard (New)')]//ancestor::li")
	WebElement ARagingdashboard;
	
	@FindBy(xpath = "//a[contains(text(),'AR Aging Property (New)')]//ancestor::li")
	WebElement ARagingreport;
	
	@FindBy(xpath = "//a[contains(text(),'STR Report Default (New)')]//ancestor::li")
	WebElement strreport;
	
	@FindBy(xpath = "//div[text()='30/60/90 Rolling Month']//ancestor::li")
	WebElement menuRollingMonth;
	
	@FindBy(xpath = "//h1[text()='30/60/90 Rolling Month Report']")
	WebElement hlRollingMonthReport;
	
	@FindBy(xpath = "//div[@role='listbox']//li")
	List <WebElement> listDrpValueSize;
	
	@FindBy(xpath = "//input[@name='portfolio']")
	WebElement drpgroup;
	
	@FindBy(xpath = "//input[@name='hotelIds']")
	WebElement drpprope;
	
	@FindBy(xpath = "//input[@name='hotelId']")
	WebElement drppropd;
	
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
	
	@FindBy(xpath = "//h1[@data-el='pageName']")
	List <WebElement> listHeaders;
	
	@FindBy(xpath = "//input[@name='keyword']")
	WebElement txtSearch;
	
	@FindBy(xpath = "//*[@id='root']//table/tbody/tr/td[1]/div/div/div/div/div")
	List <WebElement> lstRows;
	
	@FindBy(xpath = "//*[@id='root']//table/tbody/tr[1]/td/div/div/div/div/div")
	List <WebElement> noOfColumns;
	
	@FindBy(xpath = "//div[@data-el='buttonSummary']")
	WebElement tabCalendarMonth;
	
	@FindBy(xpath = "//button//div[@data-el='buttonMapping']")
	WebElement ijmappingpage;
	
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
	
	
	public void sidebar1() throws InterruptedException {

		
		WebElement menu = new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(mainMenuButton));
		menu.click();
		/* mandatory pause */
		Thread.sleep(1500);
		WebElement reportsEle = new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(reports));
		reportsEle.click();
		WebElement reveneueele = new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(reveneue));
		reveneueele.click();

		WebElement strele = new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(str));
		strele.click();
	}

	public void strreportselet() {
		
		WebElement strreportelse = new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(strreport));
		strreportelse.click();
		}
	
public void ijmappingselect() {
	
	WebElement ijmappingele = new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(ijmappingpage));
	ijmappingele.click();
	}

public boolean parameterselection1 () throws InterruptedException {
	
	/* Select the appropriate Property value from the drop-down menu. */
	WebElement drpprop = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(drpprope));
	drpprop.click();

Thread.sleep(2000);
	
	ExpectedConditions.visibilityOf(listDrpValueSize.get(0));
	for (int i = 0; i < listDrpValueSize.size(); i++) {
		if (listDrpValueSize.get(i).getText().equalsIgnoreCase(configReader.getProp("AR_Property"))) {
			listDrpValueSize.get(i).click();
		}
	}
	
	Thread.sleep(2000);
	boolean flag = false;
	String[] dateForPicker = configReader.getProp("revenueDate").split("/");
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
				WebElement btnPrevious = new WebDriverWait(driver, Duration.ofSeconds(10))
						.until(ExpectedConditions.visibilityOf(btnPreviousMonth));

				btnPrevious.click();
				Thread.sleep(1500);

			}
			WebElement btnDate = driver
					.findElement(By.xpath(" //div[@role='row']//button[text() = '" + dateForPicker[1] + "']"));
			btnDate.click();
			validateOkCancelandClick();
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
					.findElement(By.xpath(" //div[@role='row']//button[text() = '" + dateForPicker[1] + "']"));
			btnDate.click();
			validateOkCancelandClick();

			flag = true;
		}

		else {
			WebElement btnDate = driver
					.findElement(By.xpath(" //div[@role='row']//button[text() = '" + dateForPicker[1] + "']"));
			btnDate.click();
			validateOkCancelandClick();

			flag = true;
		}

	} else {
		flag = false;
	}
	

	return flag;

}

public boolean parameterselection2 () throws InterruptedException {
	
	/* Select the appropriate Property value from the drop-down menu */
	WebElement drpprop1 = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(drppropd));
	drpprop1.click();

Thread.sleep(2000);
	
	ExpectedConditions.visibilityOf(listDrpValueSize.get(0));
	for (int i = 0; i < listDrpValueSize.size(); i++) {
		if (listDrpValueSize.get(i).getText().equalsIgnoreCase(configReader.getProp("AR_Property"))) {
			listDrpValueSize.get(i).click();
		}
	}
	
	Thread.sleep(2000);
	boolean flag = false;
	String[] dateForPicker = configReader.getProp("revenueDate").split("/");
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
				WebElement btnPrevious = new WebDriverWait(driver, Duration.ofSeconds(10))
						.until(ExpectedConditions.visibilityOf(btnPreviousMonth));

				btnPrevious.click();
				Thread.sleep(1500);

			}
			WebElement btnDate = driver
					.findElement(By.xpath(" //div[@role='row']//button[text() = '" + dateForPicker[1] + "']"));
			btnDate.click();
			validateOkCancelandClick();
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
					.findElement(By.xpath(" //div[@role='row']//button[text() = '" + dateForPicker[1] + "']"));
			btnDate.click();
			validateOkCancelandClick();

			flag = true;
		}

		else {
			WebElement btnDate = driver
					.findElement(By.xpath(" //div[@role='row']//button[text() = '" + dateForPicker[1] + "']"));
			btnDate.click();
			validateOkCancelandClick();

			flag = true;
		}

	} else {
		flag = false;
	}
	

	return flag;

}
	
	public boolean parameterselection() throws InterruptedException {
		
		/* Select the appropriate Property value from the drop-down menu. */
		WebElement drpgroupEle = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(drpgroup));
		drpgroupEle.click();
	
	Thread.sleep(2000);
		
		ExpectedConditions.visibilityOf(listDrpValueSize.get(0));
		for (int i = 0; i < listDrpValueSize.size(); i++) {
			if (listDrpValueSize.get(i).getText().equalsIgnoreCase(configReader.getProp("AR_Dashboard_grpdrop"))) {
				listDrpValueSize.get(i).click();
			}
		}
		
		Thread.sleep(2000);
		boolean flag = false;
		String[] dateForPicker = configReader.getProp("revenueDate").split("/");
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
					WebElement btnPrevious = new WebDriverWait(driver, Duration.ofSeconds(10))
							.until(ExpectedConditions.visibilityOf(btnPreviousMonth));

					btnPrevious.click();
					Thread.sleep(1500);

				}
				WebElement btnDate = driver
						.findElement(By.xpath(" //div[@role='row']//button[text() = '" + dateForPicker[1] + "']"));
				btnDate.click();
				validateOkCancelandClick();
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
						.findElement(By.xpath(" //div[@role='row']//button[text() = '" + dateForPicker[1] + "']"));
				btnDate.click();
				validateOkCancelandClick();

				flag = true;
			}

			else {
				WebElement btnDate = driver
						.findElement(By.xpath(" //div[@role='row']//button[text() = '" + dateForPicker[1] + "']"));
				btnDate.click();
				validateOkCancelandClick();

				flag = true;
			}

		} else {
			flag = false;
		}
		

		return flag;

	}
	
	public void clickingGobtn() throws InterruptedException {
		
		Thread.sleep(2000);
		WebElement gobtn = new WebDriverWait(driver, Duration.ofSeconds(100))
		.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='button']//span[text()='Go']")));
		gobtn.click();
		Thread.sleep(2000);
		  
	}
		
	public boolean clickingoandverifying() throws InterruptedException {
		
		Thread.sleep(12000);
		Thread.sleep(12000);
		String actuall = driver.findElement(By.xpath("//tr//th//span[text()='Property']")).getText();
		String expectedd = "Property";
		if (actuall.contains(expectedd)) {
					flag = true;
				} else {
					flag = false;
				}
			

		
		return flag;
	}

public boolean clickingoandverifying1 () throws InterruptedException {
		
		Thread.sleep(12000);
		Thread.sleep(8000);
		String actual = driver.findElement(By.xpath("//tr//th//span[text()='Account Name']")).getText();
		String expected = "Account Name";
		if (actual.contains(expected)) {
					flag = true;
				} else {
					flag = false;
				}
			

		
		return flag;
	}

public boolean clickingoandverifying11 () throws InterruptedException {
	
	Thread.sleep(12000);
	Thread.sleep(8000);
	String actual = driver.findElement(By.xpath("//tr//th//span[text()='Week 1']")).getText();
	String expected = "Week 1";
	if (actual.contains(expected)) {
				flag = true;
			} else {
				flag = false;
			}
		

	
	return flag;
}

public boolean clickingoandverifying12 () throws InterruptedException {
	
	Thread.sleep(12000);
	Thread.sleep(8000);
	String actual = driver.findElement(By.xpath("//tr//th//span[text()='Date']")).getText();
	String expected = "Date";
	if (actual.contains(expected)) {
				flag = true;
			} else {
				flag = false;
			}
		

	
	return flag;
}

public boolean clickingoandverifying13 () throws InterruptedException {
	
	Thread.sleep(12000);
	Thread.sleep(8000);
	String actual = driver.findElement(By.xpath("//tr//th//span[text()='Source Account']")).getText();
	String expected = "Source Account";
	if (actual.contains(expected)) {
				flag = true;
			} else {
				flag = false;
			}
		

	
	return flag;
}

public boolean clickingoandverifying14 () throws InterruptedException {
	
	Thread.sleep(12000);
	Thread.sleep(8000);
	String actual = driver.findElement(By.xpath("//tr//th//span[text()='Source Account']")).getText();
	String expected = "Source Account";
	if (actual.contains(expected)) {
				flag = true;
			} else {
				flag = false;
			}
		

	
	return flag;
}

public boolean clickingoandverifying15 () throws InterruptedException {
	
	Thread.sleep(12000);
	Thread.sleep(8000);
	String actual = driver.findElement(By.xpath("//table//thead//tr//th[text()='GL Code']")).getText();
	String expected = "GL Code";
	if (actual.contains(expected)) {
				flag = true;
			} else {
				flag = false;
			}
		

	
	return flag;
}

public boolean clickingoandverifying16 () throws InterruptedException {
	
	Thread.sleep(12000);
	Thread.sleep(8000);
	String actual = driver.findElement(By.xpath("//table//thead//tr//th[text()='MDO GL Code']")).getText();
	String expected = "MDO GL Code";
	if (actual.contains(expected)) {
				flag = true;
			} else {
				flag = false;
			}
		

	
	return flag;
}

public boolean clickingoandverifying17 () throws InterruptedException {
	
	Thread.sleep(12000);
	Thread.sleep(8000);
	String actual = driver.findElement(By.xpath("//table//thead//tr//th[text()='Description']")).getText();
	String expected = "Description";
			if (actual.contains(expected)) {
				flag = true;
			} else {
				flag = false;
			}
		

	
	return flag;
}

public boolean clickingoandverifying18 () throws InterruptedException {
	
	Thread.sleep(12000);
	Thread.sleep(8000);
	String actual = driver.findElement(By.xpath("//table//thead//tr//th[text()='Report Name']")).getText();
	String expected = "Report Name";
			if (actual.contains(expected)) {
				flag = true;
			} else {
				flag = false;
			}
		

	
	return flag;
}
	}
	


