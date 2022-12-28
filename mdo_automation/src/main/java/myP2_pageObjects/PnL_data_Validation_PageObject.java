package myP2_pageObjects;


import java.time.Duration;
import java.util.ArrayList;
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

public class PnL_data_Validation_PageObject {
	
	
	private WebDriver driver;	
	private ConstantsReader configReader = new ConstantsReader();
	List<String> all_elements_text ,all_ComparisionElements_text ,all_YearlyElements_text ;
	boolean flag;
	 
	public PnL_data_Validation_PageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		all_elements_text=new ArrayList<>();
		all_ComparisionElements_text =new ArrayList<>();
		all_YearlyElements_text =new ArrayList<>();
		
	}
	
	@FindBy(xpath = "//div[contains(text(),'P&L Monthly')]//ancestor::li")
	WebElement pnlMonthly;

	@FindBy(xpath = "//div/label[text()='Group']//following-sibling::div/input[@value='All groups']")
	WebElement drpGroup;

	@FindBy(xpath = "//div/input[@name='portfolio-hotel']")
	WebElement drpProperty;

	@FindBy(xpath = "(//label[text()='View']//following::div)[2]")
	WebElement drpView;

	@FindBy(xpath = "//div/label[text()='Date']//following-sibling::div/input[@name='date']")
	WebElement txtDrp;

	@FindBy(xpath = "//button//span[text()='Go']")
	WebElement btnGo;
	
	@FindBy(xpath = "//ul[@role='listbox']//li")
	List<WebElement> listDrpValueSize;
	
	@FindBy(xpath = "//input[@name='nullRecords']")
	WebElement btnZeroValue;
	
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
	
	@FindBy(xpath = "//div//label[text() = 'Date'] /following-sibling::div//input")
	WebElement txtDate;
	
	@FindBy(xpath = "//table/tbody/tr/td[count(//table/thead/tr/th[.='$columnName']/preceding-sibling::th)+3]")
	List<WebElement> lstFirstCol;
	
	@FindBy(xpath = "//table/tbody/tr/td[count(//table/thead/tr/th[.='$columnName']/preceding-sibling::th)+27]")
	List<WebElement> lstTotalCol;
	
	@FindBy(xpath = "//table/tbody/tr/td[count(//table/thead/tr/th[.='$columnName']/preceding-sibling::th)+4]")
	List<WebElement> lstFebCol;
	
	
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
		String[] dateForPicker = configReader.getProp("PnL_date").split("/");

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
	
	
	public void selectParametersFunc(String grp, String property) throws InterruptedException {

		Thread.sleep(4500);
		Thread.sleep(4500);
		Thread.sleep(4500);

		if (drpGroup.isEnabled()) {
			/* Select the appropriate Group value from the drop-down menu. */
			WebElement drpGroupEle = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(drpGroup));
			drpGroupEle.click();

			ExpectedConditions.visibilityOf(listDrpValueSize.get(0));
			for (int i = 0; i < listDrpValueSize.size(); i++) {
				if (listDrpValueSize.get(i).getText().equalsIgnoreCase(grp)) {
					listDrpValueSize.get(i).click();
				}
			}
		}

		int Property = driver.findElements(By.xpath("//div/input[@name='portfolio-hotel']")).size();
		if (Property > 0) {
			WebElement drpPropertyEle = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(drpProperty));
			drpPropertyEle.click();

			Thread.sleep(6500);
			for (int i = 0; i < listDrpValueSize.size(); i++) {
				if (listDrpValueSize.get(i).getText().equalsIgnoreCase(property)) {
					listDrpValueSize.get(i).click();
				}
			}
		}
		Thread.sleep(20000);

		int date = driver.findElements(By.xpath("//div//label[text() = 'Date'] /following-sibling::div//input")).size();
		if (date > 0) {
			selectDate();
		}

		Thread.sleep(1500);
		WebElement drpViewEle = new WebDriverWait(driver, Duration.ofSeconds(30))
				.until(ExpectedConditions.visibilityOf(drpView));
		drpViewEle.click();
		Thread.sleep(6500);

		for (int i = 0; i < listDrpValueSize.size(); i++) {
			if (listDrpValueSize.get(i).getText().equalsIgnoreCase(configReader.getProp("View"))) {
				ExpectedConditions.visibilityOf(listDrpValueSize.get(0));
				listDrpValueSize.get(i).click();
			}
		}

		Thread.sleep(3500);
		WebElement btnGO = new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(btnGo));
		btnGO.click();

		ElementUtils.waitForElementToDisplay(lblRoomAva, 100);
		btnZeroValue.click();
	}
	
	public void storeMonthlyValuesFunc() throws InterruptedException {

		ElementUtils.waitForElementToDisplay(lblRoomAva, 100);
		btnZeroValue.click();
		
		Thread.sleep(3500);

	    for(int i=0; i<lstFirstCol.size(); i++){
	        all_elements_text.add(lstFirstCol.get(i).getText());
	        System.out.println("========Monthly======"+all_elements_text);
	    }
	}
	
	public void storeComparisionValuesFunc() throws InterruptedException {
		
		Thread.sleep(6500);
		WebElement btnGO = new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(btnGo));
		btnGO.click();
		Thread.sleep(3500);

	    for(int x=0; x<lstTotalCol.size(); x++){
	    	all_ComparisionElements_text.add(lstTotalCol.get(x).getText());
	    	System.out.println("========com======"+all_ComparisionElements_text);
	    }
	    Thread.sleep(3500);
	}
	
	public boolean verifyMonthValueFunc() throws InterruptedException {
		if (all_elements_text.equals(all_ComparisionElements_text)) {
			flag = true;
		} else {
			flag = false;
		}
		Thread.sleep(3500);
		return flag;
		
	}
	
	public void storeYearlyValuesFunc() throws InterruptedException {
		Thread.sleep(3500);

	    for(int x=0; x<lstFebCol.size(); x++){
	    	all_YearlyElements_text.add(lstFebCol.get(x).getText());
	        System.out.println(lstFebCol.get(x).getText());
	    }
	    Thread.sleep(3500);
	}
	
	public boolean verifyYearlyValueFunc() throws InterruptedException {
	    if (all_elements_text.equals(all_YearlyElements_text)) {
			flag = true;
		} else {
			flag = false;
		}
		return flag;
		
	}

}
