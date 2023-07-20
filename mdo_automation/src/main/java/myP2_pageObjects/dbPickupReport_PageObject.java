package myP2_pageObjects;

import java.sql.ResultSet;
import java.sql.Statement;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.text.DecimalFormat;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import dbConnection.DBConnection;
import utils.ConstantsReader;


public class dbPickupReport_PageObject {
	private WebDriver driver;
	private Statement st;
	private ResultSet rs;
	String Actual,DBroundedAmount,TotalRev;
	 
	private ConstantsReader configReader = new ConstantsReader();
	
	

	public dbPickupReport_PageObject(WebDriver driver) {
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

	@FindBy(xpath = "//div//label[text() = 'Business Date'] //following-sibling::div//button")
	WebElement btnBusinessDatePicker;

	@FindBy(xpath = "//div//label[text() = 'Start Date'] //following-sibling::div//button")
	WebElement btnStartDatePicker;

	@FindBy(xpath = "//div//label[text() = 'End Date'] //following-sibling::div//button")
	WebElement btnEndDatePicker;

	@FindBy(xpath = "//div//label[text() = 'Business Date'] /following-sibling::div//input")
	WebElement txtBusinessDate;

	@FindBy(xpath = "//div//label[text() = 'Start Date'] /following-sibling::div//input")
	WebElement txtStartDate;

	@FindBy(xpath = "//div//label[text() = 'End Date'] /following-sibling::div//input")
	WebElement txtEndDate;
	
	@FindBy(xpath = "//input[@name='portfolio-hotel']")
	WebElement dropDownProperty;
	
	@FindBy(xpath = "//div[@role='listbox']//li")
	List<WebElement> lstDropDowGroup;
	
	@FindBy(xpath = "//button[@data-el='buttonGo']")
	WebElement btngo;
	
	@FindBy(xpath = "((//table[1]/tbody[1]/tr)[9]/td)[4]")
	WebElement cellActualREV;
	
	
	
	
	public void  selectDBdata(String table ,String hotelId,  String StartDate , String EndDate ,String mdoglcode , String hre   ) {
		
		
		try {
			
		String query = "SELECT sum(sum_amount) as sum_amount FROM "+table+"  WHERE  hotel_id = "+hotelId+"  AND date BETWEEN  '"+StartDate+"' AND '"+EndDate+"' AND mdo_gl_code = '"+mdoglcode+"' AND hre_type_id = '"+hre+"' and  removed_at is null "	;
		System.out.println("Query : " + query);	
		st = DBConnection.getConnection().createStatement();
		rs = st.executeQuery(query);

		while (rs.next()) {
		
			Actual = rs.getString("sum_amount");
			
			   // Convert the string value to a numeric type 
            double amount = Double.parseDouble(Actual);

            // Create a DecimalFormat object with the pattern "0.00" to round off to two decimal places
            DecimalFormat decimalFormat = new DecimalFormat("0.00");

            // Use the format method to round off the numeric value to two decimal places
             DBroundedAmount = decimalFormat.format(amount);
         	

		}
			
			
			}catch (Exception e) {
			e.printStackTrace();
			
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

	
	public boolean BusinessDate() throws InterruptedException {
		boolean flag = false;
		String[] dateForPicker = configReader.getProp("dbpickupBusinessDate").split("/");

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
	
	
	public boolean endDate() throws InterruptedException {
		boolean flag = false;
		String[] dateForPicker = configReader.getProp("dbpickupEndDate").split("/");

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
	
	
	
	
	public boolean startDate() throws InterruptedException {
		boolean flag = false;
		String[] dateForPicker = configReader.getProp("dbpickupStartDate").split("/");

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
	
	
	
	
	
	public void loadSpecificDatesReport() {
		try {
			
			
			Thread.sleep(5000);
			
			WebElement drpProperty = new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOf(dropDownProperty));
			drpProperty.click();
			Thread.sleep(5000);
			
			for (int i = 0; i < lstDropDowGroup.size(); i++) {
				if (lstDropDowGroup.get(i).getText().equalsIgnoreCase(configReader.getProp("PickupProperty"))) {
					lstDropDowGroup.get(i).click();

				}
			}
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
	
	
	public void storePickuptotalRev() throws InterruptedException {
		Thread.sleep(5000);
		
		WebElement totalActualREV = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(cellActualREV));
		TotalRev =  totalActualREV.getText().replaceAll(",", "").replaceAll("\\$", "");
	    System.out.println("==========TotalRev=======" +TotalRev);
		
		
		
	}
	
	
	public boolean veriyPickUpdata() {
		boolean result = false;
		
		System.out.println("==========TotalRev=======" +TotalRev +"=========roundedAmount========="+DBroundedAmount);
		if (TotalRev.equals(DBroundedAmount)) {
					result = true;
				} else {
					result = false;
				}

			

		return result;
	}
	
	
	

}
