package myP2_pageObjects;

import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
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
	
	@FindBy(xpath = "//a[text()='Account Management']//ancestor::li")
	WebElement AccountManagementmenu;
	
	@FindBy(xpath = "//h1[text()='30/60/90 Rolling Month Report']")
	WebElement hlRollingMonthReport;
	
	@FindBy(xpath = "//div[@role='listbox']//li")
	List <WebElement> listDrpValueSize;
	
	@FindBy(xpath = "//input[@name='portfolio']")
	WebElement drpgroup;
	
	@FindBy(xpath = "//input[@name='portfolio-group']")
	WebElement newdrpgroup;
	
	@FindBy(xpath = "//input[@name='hotelIds']")
	WebElement drpprope;
	
	@FindBy(xpath = "//input[@name='hotelId']")
	WebElement drppropd;
	
	@FindBy(xpath = "//input[@name='porfolio']")
	WebElement groupdrp;
	
	@FindBy(xpath = "//tr//th//span[text()='Property']")
	WebElement getproperty;
	
	@FindBy(xpath = "//tr//th//span[text()='Account Name']")
	WebElement actname;
	
	@FindBy(xpath = "//tr//th//span[text()='Week 1']")
	WebElement weeklbl;
	
	@FindBy(xpath = "//tr//th//span[text()='Date']")
	WebElement Datelbl;
	
	@FindBy(xpath = "//tr//th//span[text()='Source Account']")
	WebElement sourceacclbl;
	
	@FindBy(xpath = "//table//thead//tr//th[text()='GL Code']")
	WebElement glcodelbl;
	
	@FindBy(xpath = "//table//thead//tr//th[text()='MDO GL Code']")
	WebElement mdoglcodelbl;
	
	@FindBy(xpath = "//table//thead//tr//th[text()='Description']")
	WebElement descrplbl;
	
	@FindBy(xpath = "//table//thead//tr//th[text()='Report Name']")
	WebElement reprtnmelbl;
	
	@FindBy(xpath = "//table//thead//tr//th//span[text()='Account Name']")
	WebElement actnamelbl;
	
	@FindBy(xpath = "//table//thead//tr//th[text()='First Name']")
	WebElement firstnamelbl;
	
	@FindBy(xpath = "//table//thead//tr//th[text()='Daily Activity']")
	WebElement dailyactlbl;
	
	@FindBy(xpath = "//table//thead//tr//th//span[text()='MARSHA-Cd']")
	WebElement MARSHAlbl;
	
	@FindBy(xpath = "//tbody//tr//td//div[text()='ADR']")
	WebElement ADRlbl;
	
	@FindBy(xpath = "//div//span[text()='ADR']")
	WebElement ADRlbl2;
	
	@FindBy(xpath = "//div//label[text()='GL Code']")
	WebElement GLCodelbl;
	
	@FindBy(xpath = "//div//label[text()='Copy From']")
	WebElement copyfrmlbl;
	
	@FindBy(xpath = "//div//p[text()='FILE UPLOADER']")
	WebElement fileuploadlbl;
	
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
	
	@FindBy(xpath = "//button[@type='button']//span[text()='Go']")
	WebElement Gobutton;
	
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

public void accmangmentselect() {
	
	WebElement accmangmentele = new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(AccountManagementmenu));
	accmangmentele.click();
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
	
public boolean newparameterselection() throws InterruptedException {
		
		/* Select the appropriate Property value from the drop-down menu. */
		WebElement newgroupele = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(newdrpgroup));
		newgroupele.click();
	
	Thread.sleep(2000);
		
		ExpectedConditions.visibilityOf(listDrpValueSize.get(0));
		for (int i = 0; i < listDrpValueSize.size(); i++) {
			if (listDrpValueSize.get(i).getText().equalsIgnoreCase(configReader.getProp("PnL_groups"))) {
				listDrpValueSize.get(i).click();
			}
		}
		
		Thread.sleep(4000);
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

			WebElement expandYear = new WebDriverWait(driver, Duration.ofSeconds(50))
					.until(ExpectedConditions.visibilityOf(btnExpandYear));
			expandYear.click();
			Thread.sleep(5000);

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
		
		ElementUtils.waitForElementToDisplay(Gobutton, 100);
		Gobutton.click();
		Thread.sleep(2000);
		  
	}
	
public void addglcodebtn() throws InterruptedException {
		
		WebElement addcdebtn = new WebDriverWait(driver, Duration.ofSeconds(100))
		.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-el='buttonAdd']")));
		addcdebtn.click();
		Thread.sleep(2000);
		  
	}

public void clickcopybtn() throws InterruptedException {
	
	WebElement copybtn = new WebDriverWait(driver, Duration.ofSeconds(100))
	.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-el='buttonCopy']")));
	copybtn.click();
	Thread.sleep(2000);
	  
}

public void clickimportbtn() throws InterruptedException {
	
	WebElement importbtn = new WebDriverWait(driver, Duration.ofSeconds(100))
	.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@title='Import']")));
	importbtn.click();
	Thread.sleep(2000);
	  
}

public void clickcancel() throws InterruptedException {
	
	WebElement cancelbtn = new WebDriverWait(driver, Duration.ofSeconds(100))
	.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-el='buttonCancel']")));
	cancelbtn.click();
	Thread.sleep(2000);
	  
}

		
	public boolean clickingoandverifying() throws InterruptedException {
		
		ElementUtils.waitForElementToDisplay(getproperty, 40);
		String actual = getproperty.getText();
		String expected = "Property";
		if (actual.contains(expected)) {
					flag = true;
				} else {
					flag = false;
				}
			

		
		return flag;
	}

public boolean clickingoandverifying1 () throws InterruptedException {
		
		ElementUtils.waitForElementToDisplay(actname, 40);
		String actual = actname.getText();
		String expected = "Account Name";
		if (actual.contains(expected)) {
					flag = true;
				} else {
					flag = false;
				}
			

		
		return flag;
	}

public boolean clickingoandverifying11 () throws InterruptedException {
	
	ElementUtils.waitForElementToDisplay(weeklbl, 40);
	String actual = weeklbl.getText();
	String expected = "Week 1";
	if (actual.contains(expected)) {
				flag = true;
			} else {
				flag = false;
			}
		

	
	return flag;
}

public boolean clickingoandverifying12 () throws InterruptedException {
	
	ElementUtils.waitForElementToDisplay(Datelbl, 40);
	String actual = Datelbl.getText();
	String expected = "Date";
	if (actual.contains(expected)) {
				flag = true;
			} else {
				flag = false;
			}
		

	
	return flag;
}

public boolean clickingoandverifying13 () throws InterruptedException {
	
	ElementUtils.waitForElementToDisplay(sourceacclbl, 40);
	String actual = sourceacclbl.getText();
	String expected = "Source Account";
	if (actual.contains(expected)) {
				flag = true;
			} else {
				flag = false;
			}
		

	
	return flag;
}

public boolean clickingoandverifying14 () throws InterruptedException {
	
	ElementUtils.waitForElementToDisplay(sourceacclbl, 40);
	String actual = sourceacclbl.getText();
	String expected = "Source Account";
	if (actual.contains(expected)) {
				flag = true;
			} else {
				flag = false;
			}
		

	
	return flag;
}

public boolean clickingoandverifying15 () throws InterruptedException {
	
	ElementUtils.waitForElementToDisplay(glcodelbl, 40);
	String actual = glcodelbl.getText();
	String expected = "GL Code";
	if (actual.contains(expected)) {
				flag = true;
			} else {
				flag = false;
			}
		

	
	return flag;
}

public boolean clickingoandverifying16 () throws InterruptedException {
	
	ElementUtils.waitForElementToDisplay(mdoglcodelbl, 40);
	String actual = mdoglcodelbl.getText();
	String expected = "MDO GL Code";
	if (actual.contains(expected)) {
				flag = true;
			} else {
				flag = false;
			}
		

	
	return flag;
}

public boolean clickingoandverifying17 () throws InterruptedException {
	
	ElementUtils.waitForElementToDisplay(descrplbl, 40);
	String actual = descrplbl.getText();
	String expected = "Description";
			if (actual.contains(expected)) {
				flag = true;
			} else {
				flag = false;
			}
		

	
	return flag;
}

public boolean clickingoandverifying18 () throws InterruptedException {
	
	ElementUtils.waitForElementToDisplay(reprtnmelbl, 40);
	String actual = reprtnmelbl.getText();
	String expected = "Report Name";
			if (actual.contains(expected)) {
				flag = true;
			} else {
				flag = false;
			}
		

	
	return flag;
}

public boolean clickingoandverifying19 () throws InterruptedException {
	
	ElementUtils.waitForElementToDisplay(actnamelbl, 40);
	String actual = actnamelbl.getText();
	String expected = "Account Name";
			if (actual.contains(expected)) {
				flag = true;
			} else {
				flag = false;
			}
		

	
	return flag;
}
public boolean clickingoandverifying20 () throws InterruptedException {
	
	ElementUtils.waitForElementToDisplay(firstnamelbl, 40);
	String actual = firstnamelbl.getText();
	String expected = "First Name";
			if (actual.contains(expected)) {
				flag = true;
			} else {
				flag = false;
			}
		

	
	return flag;
}
public boolean clickingoandverifying21 () throws InterruptedException {
	
	ElementUtils.waitForElementToDisplay(ADRlbl, 40);
	String actual = ADRlbl.getText();
	String expected = "ADR";
			if (actual.contains(expected)) {
				flag = true;
			} else {
				flag = false;
			}
		

	
	return flag;
}
public boolean clickingoandverifying22 () throws InterruptedException {
	
	ElementUtils.waitForElementToDisplay(ADRlbl2, 40);
	String actual = ADRlbl2.getText();
	String expected = "ADR";
			if (actual.contains(expected)) {
				flag = true;
			} else {
				flag = false;
			}
		

	
	return flag;
}
public boolean clickingoandverifying23 () throws InterruptedException {
	
	ElementUtils.waitForElementToDisplay(GLCodelbl, 40);
	String actual = GLCodelbl.getText();
	String expected = "GL Code";
			if (actual.contains(expected)) {
				flag = true;
			} else {
				flag = false;
			}
		

	
	return flag;
}
public boolean clickingoandverifying24 () throws InterruptedException {
	
	ElementUtils.waitForElementToDisplay(copyfrmlbl, 40);
	String actual = copyfrmlbl.getText();
	String expected = "Copy From";
			if (actual.contains(expected)) {
				flag = true;
			} else {
				flag = false;
			}
		

	
	return flag;
}
public boolean clickingoandverifying25 () throws InterruptedException {
	
	ElementUtils.waitForElementToDisplay(fileuploadlbl, 40);
	String actual = fileuploadlbl.getText();
	String expected = "FILE UPLOADER";
			if (actual.contains(expected)) {
				flag = true;
			} else {
				flag = false;
			}
		

	
	return flag;
}
public boolean clickingoandverifying26 () throws InterruptedException {
	
	ElementUtils.waitForElementToDisplay(dailyactlbl, 40);
	String actual = dailyactlbl.getText();
	String expected = "Daily Activity";
			if (actual.contains(expected)) {
				flag = true;
			} else {
				flag = false;
			}
		

	
	return flag;
}

public boolean clickingoandverifying27 () throws InterruptedException {
	
	ElementUtils.waitForElementToDisplay(MARSHAlbl, 40);
	String actual = MARSHAlbl.getText();
	String expected = "MARSHA-Cd";
			if (actual.contains(expected)) {
				flag = true;
			} else {
				flag = false;
			}
		

	return flag;
}
	}