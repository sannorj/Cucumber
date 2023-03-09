package myP2_pageObjects;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
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

public class PickUpReport_TotalComparison_PageObject {

	private static final String String = null;
	private WebDriver driver;
	private ConstantsReader configReader = new ConstantsReader();
	ArrayList<String> actualTotArray;
	ArrayList<String> otbTotArray;
	ArrayList<String> grandTotArray;
	ArrayList<String> newMeanArray;

	public PickUpReport_TotalComparison_PageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		actualTotArray = new ArrayList<>();
		otbTotArray = new ArrayList<>();
		grandTotArray = new ArrayList<>();
		newMeanArray = new ArrayList<>();

	}

	@FindBy(xpath = "//button[@data-el='menuToggle']")
	WebElement mainMenuButton;

	@FindBy(xpath = "//div[text()='Reports']//ancestor::li")
	WebElement reports;

	@FindBy(xpath = "//div[text()='Revenue']//ancestor::li")
	WebElement reveneue;

	@FindBy(xpath = "//div[text()='Pickup Reports']//ancestor::li")
	WebElement pickUpReports;

	@FindBy(xpath = "//div[text()='Pickup Report']//ancestor::li")
	WebElement pickUpReportPage;

	@FindBy(xpath = "//h1[text()='Pickup Report']")
	WebElement navigatedReportPage;

	@FindBy(xpath = "//div//label[text() = 'Business Date'] /following-sibling::div//input")
	WebElement txtBusinessDate;

	@FindBy(xpath = "//div//label[text() = 'Start Date'] /following-sibling::div//input")
	WebElement txtStartDate;

	@FindBy(xpath = "//div//label[text() = 'End Date'] /following-sibling::div//input")
	WebElement txtEndDate;

	@FindBy(xpath = "//button[@data-el='buttonGo']")
	WebElement btngo;

	@FindBy(xpath = "//button[@data-el='buttonSettings']")
	WebElement btnEditColumn;

	@FindBy(xpath = "//div[text() = 'Settings']")
	WebElement settingPage;
	
	@FindBy(xpath = "//b[text()='Actual Total']//ancestor::tr//td")
	List<WebElement> actualValuesList;

	@FindBy(xpath = "//b[text()='OTB Total']//ancestor::tr//td")
	List<WebElement> otbValuesList;
	
	@FindBy(xpath = "//b[text()='OTB Total']//ancestor::tr//td")
	List<WebElement> grandValuesList;

	@FindBy(xpath = "//button[@type='button']//span[text() = 'Apply']")
	WebElement btnApply;
	
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
	
	@FindBy(xpath = "//div//label[text() = 'Business Date'] //following-sibling::div//button")
	WebElement btnBusinessDatePicker;

	@FindBy(xpath = "//div//label[text() = 'Start Date'] //following-sibling::div//button")
	WebElement btnStartDatePicker;

	@FindBy(xpath = "//div//label[text() = 'End Date'] //following-sibling::div//button")
	WebElement btnEndDatePicker;


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

	public boolean BusinessDate() throws InterruptedException {
		boolean flag = false;
		String[] dateForPicker = configReader.getProp("pickupBusinessDate").split("/");

		txtBusinessDate.click();

		int btnDatePickforLocal = driver.findElements(By.xpath("//div//label[text() = 'Business Date'] //following-sibling::div//button")).size();

		if (btnDatePickforLocal > 0) {
			btnBusinessDatePicker.click();
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
	
	public boolean secondBusinessDate() throws InterruptedException {
		boolean flag = false;
		String[] dateForPicker = configReader.getProp("pickupSecondBusinessDate").split("/");

		txtBusinessDate.click();

		int btnDatePickforLocal = driver.findElements(By.xpath("//div//label[text() = 'Business Date'] //following-sibling::div//button")).size();

		if (btnDatePickforLocal > 0) {
			btnBusinessDatePicker.click();
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
	
	public boolean startDate() throws InterruptedException {
		boolean flag = false;
		String[] dateForPicker = configReader.getProp("pickupStartDate").split("/");

		Thread.sleep(5000);
		
		txtStartDate.click();

		int btnDatePickforLocal = driver.findElements(By.xpath("//div//label[text() = 'Start Date'] //following-sibling::div//button")).size();

		if (btnDatePickforLocal > 0) {
			btnStartDatePicker.click();
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
	
	public boolean endDate() throws InterruptedException {
		boolean flag = false;
		String[] dateForPicker = configReader.getProp("pickupEndDate").split("/");

		Thread.sleep(5000);
		
		txtEndDate.click();

		int btnDatePickforLocal = driver.findElements(By.xpath("//div//label[text() = 'End Date'] //following-sibling::div//button")).size();

		if (btnDatePickforLocal > 0) {
			btnEndDatePicker.click();
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
	
	public void loadSpecificDatesReport() {
		try {
			Thread.sleep(5000);
			BusinessDate();
			startDate();
			Thread.sleep(5000);
			endDate();

			btngo.click();

			Thread.sleep(5000);

		} catch (Exception e) {

			e.printStackTrace();
		}

	}
	
	public void loadSecondSpecificDatesReport() {
		try {
			
			Thread.sleep(5000);
			secondBusinessDate();
			startDate();
			endDate();

			btngo.click();

			Thread.sleep(5000);

		} catch (Exception e) {

			e.printStackTrace();
		}

	}
	
	public void actualTotalArray() throws InterruptedException {
		for (int i = 2; i <= actualValuesList.size(); i++) {
			
			WebElement secondSpecificValue = driver
					.findElement(By.xpath("(//b[text()='Actual Total']//ancestor::tr//td//b)["+i+"]"));

			actualTotArray.add(secondSpecificValue.getText());

		}

	}
	
	public void otbTotalArray() throws InterruptedException {
		for (int i = 2; i <= otbValuesList.size(); i++) {
			
			WebElement specificValue = driver
					.findElement(By.xpath("(//b[text()='OTB Total']//ancestor::tr//td//b)["+i+"]"));

			otbTotArray.add(specificValue.getText());

		}

	}
	
	public void grandTotalArray() throws InterruptedException {
		
		for (int i = 2; i <= grandValuesList.size(); i++) {
			
			WebElement specificValue2 = driver
					.findElement(By.xpath("(//b[text()='Grand Total']//ancestor::tr//td//b)["+i+"]"));

			grandTotArray.add(specificValue2.getText());

		}

	}

	public void meanArray() throws InterruptedException {
		
		DecimalFormat df = new DecimalFormat("0.00");
		df.setMaximumFractionDigits(2);
		
		for (int i = 0; i < actualTotArray.size(); i++) {
			
			String actualV = actualTotArray.get(i).replace(",", "").replace("%", "");
			String otbV = otbTotArray.get(i).replace(",", "").replace("%", "");
			
			float floatActual = Float.parseFloat(actualV);
			float floatOtb = Float.parseFloat(otbV);
			
	        float sum;
	        float mean;
			
			sum = floatActual + floatOtb ;
			mean = sum / 2;
			
			String stringMeanValue = df.format(mean);
			          
			System.out.println("mean Value : " + mean);
			
			newMeanArray.add(stringMeanValue);

		}

	}
	
	public boolean comparingTwoArrays() {
		
		boolean flag = true;
		
		try {
			for (int i = 0; i < otbTotArray.size(); i++) {

				String currentOtbVal=otbTotArray.get(i);
				String currentGrandVal=grandTotArray.get(i);
						
				if(currentOtbVal.equalsIgnoreCase(currentGrandVal)) {
					
					System.out.println("PASS");
					System.out.println(otbTotArray.get(i) +" <<<--////Pass////-->>> "+grandTotArray.get(i));
					
				}else {
					flag=false;
					System.out.println("Fail");
					System.out.println(otbTotArray.get(i) +" <<<--////fail////-->>> "+grandTotArray.get(i));
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
		
	}
	
	//skip first 3 column
	public boolean comparingWithMeanArray() {
		
		boolean flag = true;
		
		try {
			DecimalFormat df = new DecimalFormat("0.00");
			df.setMaximumFractionDigits(2);
			
			for (int i = 3; i < actualTotArray.size(); i++) {

				String newmeanVal=newMeanArray.get(i);
				String meanGrandVal=grandTotArray.get(i).replace(",", "").replace("%", "");
				
				float floatMeanGrandVal = Float.parseFloat(meanGrandVal);
				String meanGrandValDf = df.format(floatMeanGrandVal);
						
				if(newmeanVal.equalsIgnoreCase(meanGrandValDf)) {
					
					System.out.println("PASS");
					System.out.println(newMeanArray.get(i) +" <<<--pass-->>> "+meanGrandValDf);
					
				}else {
					flag=false;
					System.out.println(newMeanArray.get(i) +" <<<--fail-->>> "+meanGrandValDf);
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
		
	}
	
}
