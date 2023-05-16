package myP2_pageObjects;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.apache.commons.compress.harmony.pack200.NewAttribute.PassAttribute;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.ConstantsReader;

public class KPIComparison_PrimaryD_PnLY_PageObjective {

	private WebDriver driver;
	private ConstantsReader configReader = new ConstantsReader();

	Properties properties = new Properties();
	
	public KPIComparison_PrimaryD_PnLY_PageObjective(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div//label[text() = 'Date'] /following-sibling::div//input")
	WebElement txtDate;

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

	@FindBy(xpath = "//div[@data-el='selectorYear']")
	WebElement yearDropDown;

	@FindBy(xpath = "//ul[@role='listbox']//li")
	List<WebElement> lstDropDowYear;
	
	@FindBy(xpath = "//button[@title='Edit']")
	WebElement editBtn;
	
	@FindBy(xpath = "//span[contains(text(),'Alohilani Resort Waikiki Beach')]")
	WebElement hgELBeforeEdit;
	
	@FindBy(xpath = "//div[@id='mui-component-select-selectorDecimalValue']")
	WebElement btnOverrideDecimal;
	
	@FindBy(xpath = "//ul[@role='listbox']//li")
	List<WebElement> lstDecimal;
	
	@FindBy(xpath = "//button[@data-el='buttonFinishCustomization']")
	WebElement iamDoneBtn;

	@FindBy(xpath = "//div[contains(text(),'Alohilani Resort Waikiki Beach')]")
	WebElement hgEL;

	String KPIs=configReader.getProp("KPI_List");
	List<String> KPI_List=Arrays.asList(KPIs.split(","));
	
	
	ArrayList<String> PrimaryD_KPI_List = new ArrayList<String>();
	ArrayList<String> PrimaryD_KPIValues_List = new ArrayList<String>();
	ArrayList<Integer> PrimaryD_KPIMonth_List = new ArrayList<Integer>();


	public boolean VerifyKPIAvailble() throws InterruptedException {
		Thread.sleep(3000);
		System.out.println("These KPI not exist in Primary Dashboard Page =");
		boolean flag = true;
		for (int i = 0; i < KPI_List.size(); i++) {
			String currentKPI= KPI_List.get(i);
			int columnIndex=driver.findElements(By.xpath("//div[@aria-label='"+currentKPI+"']")).size();
			if (1>columnIndex) {
				flag=false;
				System.out.println(currentKPI);
			} 
		}
		return flag;
	}
	
	public void storePrimaryDKPI(String property,String Date) throws ParseException, InterruptedException {
		
		changeDecimal();
		
		Thread.sleep(3000);
		System.out.println("KPI size== "+KPI_List.size());
		String currentDate=Date;
		for (int i = 0; i <= 11; i++) {
			System.out.println(i);
			String nextdate=getNextDate(currentDate);
			Thread.sleep(2000);
			selectDate(currentDate);
			currentDate=nextdate;
			Thread.sleep(3000);
			int month=i+1;
			storeKPIs(property,month);
		}
	}
	
	private void storeKPIs(String property,int month) throws InterruptedException {
		for (int i = 0; i < KPI_List.size(); i++) {
			String currentKPI= KPI_List.get(i);
			Thread.sleep(5000);
			String columnIndex=driver.findElement(By.xpath("//div[@aria-label='"+currentKPI+"']")).getAttribute("data-field");
			String currentVal=driver.findElement(By.xpath("//button//span[text()='"+property+"']//following::div//div[@data-field='"+columnIndex+"']")).getText();
			
			PrimaryD_KPI_List.add(currentKPI);
			PrimaryD_KPIValues_List.add(currentVal);
			PrimaryD_KPIMonth_List.add(month);
			System.out.println(currentKPI+"/"+currentVal+"/"+month);
		}
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
	
	public boolean selectDate(String date) throws InterruptedException {
		boolean flag = false;
		String[] dateForPicker = date.split("/");

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

			String currentSelectedDate=txtDate.getAttribute("value"); //get no of month from current selected date
			String[] currentDP = currentSelectedDate.split("/");
			int monthInnum = Integer.parseInt(currentDP[0]);

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
	
	public static String getNextDate(String date2) throws ParseException {
		System.out.println("date:="+date2);
		
		DateFormat userDateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date date = userDateFormat.parse(date2);
		
	    Calendar c =Calendar.getInstance();
	    c.setTime(date);
	    c.add(Calendar.MONTH, 1);
	    c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
	    Date nextDate = c.getTime();
		String datettt = userDateFormat.format(nextDate);
		System.out.println("**********************");
	    return datettt;
	    
	}

	public void selectYear(String year) throws InterruptedException {
		WebElement yearVisible = new WebDriverWait(driver, Duration.ofSeconds(5000))
				.until(ExpectedConditions.visibilityOf(yearDropDown));
		yearVisible.click();
		Thread.sleep(4500);
		for (int i = 0; i < (lstDropDowYear.size()-1); i++) {
			System.out.println("Year==="+lstDropDowYear.get(i).getText());
			if (lstDropDowYear.get(i).getText().contains(year)) {
				lstDropDowYear.get(i).click();
				Thread.sleep(3500);
			}
		}
		Thread.sleep(3500);
	}

	public boolean verifyKPIinPnL() throws InterruptedException {
		WebElement waitToDataLoad = new WebDriverWait(driver, Duration.ofSeconds(250))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//th[text()='Name']")));
		
		waitToDataLoad.isDisplayed();
		
		WebElement switchDisableNullRecords = new WebDriverWait(driver, Duration.ofSeconds(250))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@data-el='switchDisableNullRecords']")));
		
		switchDisableNullRecords.click();
		
		Thread.sleep(3500);
		
		System.out.println("These KPI not exist in Profit & Loss Yearly Report Page =");
		
		boolean flag = true;
		for (int i = 0; i < KPI_List.size(); i++) {
			String currentKPI= KPI_List.get(i);
			int columnIndex=driver.findElements(By.xpath("//div[text()='"+currentKPI+"']")).size();
			if (1>columnIndex) {
				flag=false;
				System.out.println(currentKPI);
				Thread.sleep(10000);
			} 
		}
		return flag;
	}
	
	public boolean compareKPI() throws InterruptedException {
		Thread.sleep(3000);
		WebElement waitToDataLoad = new WebDriverWait(driver, Duration.ofSeconds(1000))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//th[text()='Name']")));
		System.out.println("*********************************");
		System.out.println("KPI Values Comparison");
		System.out.println("*********************************");
		System.out.println("");
		boolean flag=true;
		for (int i = 0; i < PrimaryD_KPI_List.size(); i++) {
			int cuurentMonth=PrimaryD_KPIMonth_List.get(i);
			int indexVal=cuurentMonth+1;
			WebElement PnLY_KPIVal = driver.findElement(By.xpath("//div[text()='"+PrimaryD_KPI_List.get(i)+"']//following::td[@index='"+indexVal+"'][1]"));
			String currentKPIValue=PnLY_KPIVal.getText();
			if (!currentKPIValue.equalsIgnoreCase(PrimaryD_KPIValues_List.get(i))){
				
				System.out.println("These values are not equal");
				System.out.println("KPI= "+PrimaryD_KPI_List.get(i));
				System.out.println("Month= "+cuurentMonth);
				System.out.println("Primary Dashboard Value= "+PrimaryD_KPIValues_List.get(i));
				System.out.println("PnL Value= "+currentKPIValue);
				flag = false;
			}
		}
		return flag;
	}
	
	public void changeDecimal() throws InterruptedException
	{
		WebElement firstRow = new WebDriverWait(driver, Duration.ofSeconds(50))
				.until(ExpectedConditions.visibilityOf(hgELBeforeEdit));

		firstRow.isDisplayed();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		wait.until(ExpectedConditions.elementToBeClickable(editBtn));
		
		try {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", editBtn);
		} catch (Exception e) {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].c6lick();", editBtn);
			executor.executeScript("arguments[0].click();", editBtn);
		}

		WebElement firstRowCheck = new WebDriverWait(driver, Duration.ofSeconds(150))
				.until(ExpectedConditions.visibilityOf(hgEL));

		firstRowCheck.isDisplayed();
		
		WebElement btnDecimal = new WebDriverWait(driver, Duration.ofSeconds(50))
				.until(ExpectedConditions.visibilityOf(btnOverrideDecimal));

		btnDecimal.click();

		Thread.sleep(2500);

		lstDecimal.get(2).click();
		
		Thread.sleep(2500);
		
		WebElement btnDone = new WebDriverWait(driver, Duration.ofSeconds(50))
				.until(ExpectedConditions.visibilityOf(iamDoneBtn));

		btnDone.click();
		
		Thread.sleep(2500);
	}


}
