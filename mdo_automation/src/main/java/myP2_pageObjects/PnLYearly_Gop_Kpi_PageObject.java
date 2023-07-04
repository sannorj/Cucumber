package myP2_pageObjects;

import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.ConstantsReader;
import utils.ElementUtils;

public class PnLYearly_Gop_Kpi_PageObject {

	private WebDriver driver;
	private ConstantsReader configReader = new ConstantsReader();

	public PnLYearly_Gop_Kpi_PageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(xpath = "//input[@name='portfolio-group']")
	WebElement dropDownGroup;
	
	@FindBy(xpath = "//input[@name='porfolio']")
	WebElement dropDownGrpPc;

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

	@FindBy(xpath = "//label[@data-el='switchDisableNullRecordsLabel']")
	WebElement btnZeroValue;
	
	@FindBy(xpath = "//button[@data-el='buttonGo']")
	WebElement goButton;
	
	@FindBy(xpath = "//div[contains(text(),'GOP Flow Thru')]")
	WebElement gopHeader1;
	
	@FindBy(xpath = "//div[contains(text(),'GOP Margin')]")
	WebElement gopHeader2;
	
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

	@FindBy(xpath = "//div[@id='mui-component-select-columns[0].dataType']")
	WebElement drpColumn1;

	@FindBy(xpath = "//input[@name='columns[0].dataType']")
	WebElement drpColumn1Value;

	@FindBy(xpath = "//div[@id='mui-component-select-columns[0].yearOffest']")
	WebElement drpYear1;

	@FindBy(xpath = "//input[@name='columns[0].yearOffest']")
	WebElement drpYear1Value;
	
	@FindBy(xpath = "//div//label[text() = 'Date'] /following-sibling::div//input")
	WebElement txtDate;

	@FindBy(xpath = "//th[text()='Name']")
	WebElement monthlyHeader;

	@FindBy(xpath = "//span[text()='Name']")
	WebElement propertyComparisonHeader;
	
	public void verifyGopKpi() throws InterruptedException {
		
		Thread.sleep(3000);
		
		if (goButton.isEnabled()) {
			WebElement goButtonEle = new WebDriverWait(driver, Duration.ofSeconds(10))
					.until(ExpectedConditions.visibilityOf(goButton));
			goButtonEle.click();
			
			}
			
		Thread.sleep(10000);
		
		WebElement monthlyHeaderEle = new WebDriverWait(driver, Duration.ofSeconds(25)).until(ExpectedConditions.visibilityOf(monthlyHeader));
		monthlyHeaderEle.isDisplayed();
		
		Thread.sleep(5000);
		
		WebElement element = driver.findElement(By.xpath("//div[contains(text(),'GOP Flow Thru')]"));
		element.isDisplayed();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        
        Thread.sleep(5000);

		WebElement gopHeaderEle1 = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(gopHeader1));
		gopHeaderEle1.isDisplayed();
		
		Thread.sleep(3000);
		
		WebElement gopHeaderEle2 = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(gopHeader2));
		gopHeaderEle2.isDisplayed();

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
		String[] dateForPicker = configReader.getProp("pnl_Gop_Kpi_Date").split("/");

		txtDate.click();

		int btnDatePickforLocal = driver.findElements(By.xpath("//div//label[text() = 'Date'] //following-sibling::div//button")).size();

		if (btnDatePickforLocal > 0) {
			btnDatePicker.click();
		}

		int status = driver.findElements(By.xpath("//div[@role='dialog']")).size();

		if (status == 1) {

			WebElement expandYear = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(btnExpandYear));
			Thread.sleep(1500);
			expandYear.click();
			Thread.sleep(2500);

			WebElement pickYear = driver.findElement(By.xpath("//div[contains(@class, 'PrivatePickersYear')]//button [contains(text(), '"+ dateForPicker[2] + "')]"));

			Thread.sleep(1500);
			pickYear.click();
			Thread.sleep(2500);

			int monthInnum = getMonth();
			int monthDiff = monthInnum - Integer.parseInt(dateForPicker[0]);

			if (monthDiff > 0) {
				for (int i = 0; i < monthDiff; i++) {
					WebElement btnPrevious = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(btnPreviousMonth));

					Thread.sleep(3000);
					btnPrevious.click();
					Thread.sleep(1500);

				}
				WebElement btnDate = driver.findElement(By.xpath(" //div[@role='row']//button[text() = '" + dateForPicker[1] + "']"));
				Thread.sleep(1500);
				btnDate.click();
				Thread.sleep(1500);
				validateOkCancelandClick();

				flag = true;
			}

			else if (monthDiff < 0) {
				for (int i = 0; i > monthDiff; i--) {
					WebElement btnNext = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(btnNextMonth));

					Thread.sleep(3000);
					btnNext.click();
					Thread.sleep(1500);
				}

				WebElement btnDate = driver.findElement(By.xpath(" //div[@role='row']//button[text() = '" + dateForPicker[1] + "']"));
				Thread.sleep(1500);
				btnDate.click();
				validateOkCancelandClick();

				flag = true;
			}

			else {
				WebElement btnDate = driver.findElement(By.xpath(" //div[@role='row']//button[text() = '" + dateForPicker[1] + "']"));
				Thread.sleep(1500);
				btnDate.click();
				validateOkCancelandClick();

				flag = true;
			}

		} else {
			flag = false;
		}

		return flag;

	}

	public boolean verifyParametersAndGopNotVisi(String grp, String property, String view) throws InterruptedException {
		
		boolean flag = false;
		
		Thread.sleep(4500);
		try {
			dropDownGroup.click();
			for (int i = 0; i < lstDropDownGroup.size(); i++) {
				if (lstDropDownGroup.get(i).getText().equalsIgnoreCase(grp)) {
					lstDropDownGroup.get(i).click();

				}
			}

			Thread.sleep(5000);
			
			dropDownHotel.click();
			for (int j = 0; j < lstDropDownHotel.size(); j++) {
				if (lstDropDownHotel.get(j).getText().equalsIgnoreCase(property)) {
					lstDropDownHotel.get(j).click();

				}
			}

			Thread.sleep(5000);
			
			selectDate();
			
			Thread.sleep(10000);

			dropDownView.click();
			
			Thread.sleep(5000);
			
			int gopKpiEle = driver.findElements(By.xpath("//li[contains(text(),'GOP KPI View')]")).size();

			if (gopKpiEle > 0) {
				
				System.out.println("GOP KPI dropdown value can not be visible in P&L Monthly page View dropdown section... <<< Fail >>>");
				
				flag = false;
			}
			
			Thread.sleep(3000);
			
			for (int x = 0; x < lstDropDownView.size(); x++) {
				if (lstDropDownView.get(x).getText().equalsIgnoreCase(view)) {
					lstDropDownView.get(x).click();
					flag = true;

				}
			}
			Thread.sleep(5000);

		} catch (Exception e) {
			flag = false;
			e.printStackTrace();
		}
		return flag;
		
	}

	public void clickGoButt() throws InterruptedException {

		Thread.sleep(3000);
		
		WebElement btonGo = new WebDriverWait(driver, Duration.ofSeconds(25)).until(ExpectedConditions.visibilityOf(goButton));
		btonGo.click();
		
		Thread.sleep(3000);
	}
	
	public boolean verifyPnlMheader() throws InterruptedException {
		
		boolean flag = true;

		Thread.sleep(3000);
		
		WebElement monthlyHeaderEle = new WebDriverWait(driver, Duration.ofSeconds(25)).until(ExpectedConditions.visibilityOf(monthlyHeader));
		monthlyHeaderEle.isDisplayed();
		
		Thread.sleep(5000);
		
		int gopKpiElem1 = driver.findElements(By.xpath("//div[contains(text(),'GOP Flow Thru')]")).size();

		if (gopKpiElem1 > 0) {
			
			System.out.println("GOP Flow Thru, value can not be visible in P&L Monthly Report... <<< Fail >>>");
			flag = false;
			
		}	
		
		Thread.sleep(3000);
		
		int gopKpiElem2 = driver.findElements(By.xpath("//div[contains(text(),'GOP Margin')]")).size();

		if (gopKpiElem2 > 0) {
			
			System.out.println("GOP Margin, value can not be visible in P&L Monthly Report... <<< Fail >>>");
			
			flag = false;
		}
		
		return flag;
		
	}
	
	public boolean verifyParameterAndGopNotVisible(String Group, String View) throws InterruptedException {
		
		boolean flag = false;
		
		Thread.sleep(4500);
		try {
			dropDownGrpPc.click();
			for (int i = 0; i < lstDropDownGroup.size(); i++) {
				if (lstDropDownGroup.get(i).getText().equalsIgnoreCase(Group)) {
					lstDropDownGroup.get(i).click();

				}
			}

			Thread.sleep(5000);
			
			selectDate();
			
			Thread.sleep(10000);

			dropDownView.click();
			
			Thread.sleep(5000);
			
			int gopKpiEle = driver.findElements(By.xpath("//li[contains(text(),'GOP KPI View')]")).size();

			if (gopKpiEle > 0) {
				
				System.out.println("GOP KPI dropdown value can not be visible in P&L Property Comparison page View dropdown section... <<< Fail >>>");
				
				flag = false;
			}
			
			Thread.sleep(3000);
			
			for (int x = 0; x < lstDropDownView.size(); x++) {
				if (lstDropDownView.get(x).getText().equalsIgnoreCase(View)) {
					lstDropDownView.get(x).click();
					flag = true;

				}
			}
			Thread.sleep(5000);

		} catch (Exception e) {
			flag = false;
			e.printStackTrace();
		}
		return flag;
		
	}
	
	public boolean verifyPnlPCheader() throws InterruptedException {
		
		boolean flag = true;

		Thread.sleep(3000);
		
		WebElement pcHeaderEle = new WebDriverWait(driver, Duration.ofSeconds(25)).until(ExpectedConditions.visibilityOf(propertyComparisonHeader));
		pcHeaderEle.isDisplayed();
		
		Thread.sleep(5000);
		
		int gopKpiElem1 = driver.findElements(By.xpath("//div[contains(text(),'GOP Flow Thru')]")).size();

		if (gopKpiElem1 > 0) {
			
			System.out.println("GOP Flow Thru, value can not be visible in P&L Property Comparison Report... <<< Fail >>>");
			flag = false;
			
		}	
		
		Thread.sleep(3000);
		
		int gopKpiElem2 = driver.findElements(By.xpath("//div[contains(text(),'GOP Margin')]")).size();

		if (gopKpiElem2 > 0) {
			
			System.out.println("GOP Margin, value can not be visible in P&L Property Comparison Report... <<< Fail >>>");
			flag = false;
		}
		return flag;
	}
	
}
