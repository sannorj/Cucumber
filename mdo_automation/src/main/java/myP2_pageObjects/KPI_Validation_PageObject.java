package myP2_pageObjects;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.ConstantsReader;

public class KPI_Validation_PageObject {
	
	private WebDriver driver;
	private ConstantsReader configReader = new ConstantsReader();

	String CostValue_myP2 = null;
	Properties properties = new Properties();
	
	public KPI_Validation_PageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div//label[text() = 'Date'] /following-sibling::div//input")
	WebElement dateLast;
	
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
	
	@FindBy(xpath = "//div[contains(text(),'West Coast')]")
	WebElement hgEL;
	
	@FindBy(xpath = "//button[@title='Edit']")
	WebElement editBtn;
	
	@FindBy(xpath = "//button[@title='Add a Column']")
	WebElement addColumn;
	
	
	@FindBy(xpath = "//input[@name='name']")
	WebElement kpiName;

	@FindBy(xpath = "//input[@name='kpiId']")
	WebElement kpiID;

	@FindBy(xpath = "//li[text()='Rooms Available']")
	WebElement kpiIDValue;
	
	@FindBy(xpath = "//ul[@role='listbox']//li")
	List<WebElement> lstDropDowGroup;

	@FindBy(xpath = "//div[@id='mui-component-select-valueDataType']")
	WebElement amountType;

	@FindBy(xpath = "//li[text()='Actual']")
	WebElement actual;

	@FindBy(xpath = "//li[@data-value='BUDGET']")
	WebElement budget;

	@FindBy(xpath = "//li[@data-value='FORECAST']")
	WebElement forecast;

	@FindBy(xpath = "//button[@data-el=\"buttonSave\"]")
	WebElement addBtn;

	@FindBy(xpath = "//button[@data-el='buttonFinishCustomization']")
	WebElement iamDoneBtn;
	
	@FindBy(xpath = "//tbody[contains(@class,'MuiTableBody-root')]//tr[last()]//td[last()]//div[contains(@class,'sc-elYLMi')]")
	WebElement hgCost;
	
	@FindBy(xpath = "//div[@role='dialog']//h3[contains(text(),'Delete column')]")
	WebElement dialogBox;
	
	@FindBy(xpath = "//button[@mdo_variant='success']//span[text()='Ok']")
	WebElement btnDeleteConfirmation;
	
	
	
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
	
	
//	public void setDatemyP2() throws InterruptedException {
//
//		LocalDate today = LocalDate.now();
//		LocalDate passingDate = today.minusDays(2);
//
//		String[] dateForPicker = passingDate.toString().split("-");
//
//		dateLast.click();
//
//		int btnDatePickforLocal = driver.findElements(By.xpath("//div//label[text() = 'Date'] //following-sibling::div//button")).size();
//
//		if (btnDatePickforLocal > 0) {
//			btnDatePicker.click();
//		}
//
//		int status = driver.findElements(By.xpath("//div[@role='dialog']")).size();
//
//		if (status == 1) {
//
//			WebElement expandYear = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(btnExpandYear));
//			expandYear.click();
//
//			Thread.sleep(2500);
//
//			WebElement pickYear = driver.findElement(By.xpath("//div[contains(@class, 'PrivatePickersYear')]//button [contains(text(), '"
//							+ dateForPicker[0] + "')]"));
//			pickYear.click();
//			Thread.sleep(2500);
//
//			int monthInnum = getMonth();
//
//			int monthDiff = monthInnum - Integer.parseInt(dateForPicker[1]);
//
//			if (monthDiff > 0) {
//
//				for (int i = 0; i < monthDiff; i++) {
//					WebElement btnPrevious = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(btnPreviousMonth));
//					btnPrevious.click();
//					Thread.sleep(1500);
//
//				}
//				WebElement btnDate = driver.findElement(By.xpath(" //div[@role='row']//button[text() = '" + dateForPicker[2] + "']"));
//				btnDate.click();
//				validateOkCancelandClick();
//
//			}
//
//			else if (monthDiff < 0) {
//
//				for (int i = 0; i > monthDiff; i--) {
//					WebElement btnNext =new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(btnNextMonth));
//					btnNext.click();
//					Thread.sleep(1500);
//				}
//				WebElement btnDate = driver.findElement(By.xpath(" //div[@role='row']//button[text() = '" + dateForPicker[2] + "']"));
//				btnDate.click();
//				validateOkCancelandClick();
//			} else {
//				System.out.println("Dif1");
//				WebElement btnDate = driver.findElement(By.xpath(" //div[@role='row']//button[text() = '" + dateForPicker[2] + "']"));
//				btnDate.click();
//				validateOkCancelandClick();
//			}
//		} else {
//
//		}
//	}
	
	
	
	public boolean selectDate() throws InterruptedException {
		boolean flag = false;
		String[] dateForPicker = configReader.getProp("KPI_Date").split("/");
		dateLast.click();

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
					WebElement btnPrevious = new WebDriverWait(driver, Duration.ofSeconds(10))
							.until(ExpectedConditions.visibilityOf(btnPreviousMonth));

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



	public void navigateToAddColumn() throws InterruptedException {

		WebElement firstRow = new WebDriverWait(driver, Duration.ofSeconds(150)).until(ExpectedConditions.visibilityOf(hgEL));

		firstRow.isDisplayed();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
		wait.until(ExpectedConditions.elementToBeClickable(editBtn));
		try {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", editBtn);
		} catch (Exception e) {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].c6lick();", editBtn);
			executor.executeScript("arguments[0].click();", editBtn);
		}

		WebElement firstRowCheck = new WebDriverWait(driver, Duration.ofSeconds(150)).until(ExpectedConditions.visibilityOf(hgEL));

		firstRowCheck.isDisplayed();

		Thread.sleep(3000);
		try {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", addColumn);
		} catch (Exception e) {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", addColumn);
		}
		Thread.sleep(2000);
	}
	
	
	public void addKPImyp2(String kpi) throws InterruptedException {
		String kpi_Name = "Auto";
		Random random = new Random();
		char randomizedCharacter = (char) (random.nextInt(26) + 'a');
		String newKPIName = kpi_Name + "_" + randomizedCharacter;
		Thread.sleep(2000);

		try {
			Thread.sleep(2000);
			kpiName.sendKeys(kpi + " Automation");
		} catch (Exception e) {
			System.out.println("Falied to set KPI name");
		}

		try {
			Thread.sleep(2000);
			kpiID.sendKeys(kpi);
		} catch (Exception e) {
			System.out.println("Falied to search kpi name");
		}

		try {
			Thread.sleep(2000);
			for (int i = 0; i < lstDropDowGroup.size(); i++) {
				if (lstDropDowGroup.get(i).getText().equalsIgnoreCase(kpi)) {
					lstDropDowGroup.get(i).click();
				}
			}
		} catch (Exception e) {
			System.out.println("Falied to add kpi name from dropdown");
		}

		try {
			Thread.sleep(2000);
			amountType.click();
		} catch (Exception e) {
			System.out.println("Falied to select amount type");
		}

		try {
			Thread.sleep(2000);
			actual.click();
		} catch (Exception e) {
			System.out.println("Falied to select amount type");
		}

		try {
			Thread.sleep(2000);
			addBtn.click();
		} catch (Exception e) {
			System.out.println("Falied to click Add button");
		}

		try {
			Thread.sleep(5000);
			// iamDoneBtn.click();
		} catch (Exception e) {
			System.out.println("Falied to click I am Done button");
		}
		Thread.sleep(5000);
	}
	
	
	public void setmyP2KPIPortfolio(String kpi) throws InterruptedException {
		Thread.sleep(2000);

		WebElement firstRow = new WebDriverWait(driver, Duration.ofSeconds(150)).until(ExpectedConditions.visibilityOf(hgEL));
		firstRow.isDisplayed();
		CostValue_myP2 = hgCost.getText();

		try (OutputStream outputStream = new FileOutputStream("./src/test/resources/configurations/myP2CommonKPI.properties")) {
			properties.setProperty(kpi.replaceAll("\\s", "_") + "_myP2", CostValue_myP2);
			properties.store(outputStream, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deletmyp2KPI(String kpi) throws InterruptedException {

		try {
			Thread.sleep(3000);
			WebElement firstRowCheck = new WebDriverWait(driver, Duration.ofSeconds(150)).until(ExpectedConditions.visibilityOf(hgEL));
			firstRowCheck.isDisplayed();

			WebElement btnDelete = driver.findElement(By.xpath("//button[@data-el='button-delete-" + (kpi + " Automation") + "']"));

			btnDelete.click();

			WebElement dialogBoxEle = new WebDriverWait(driver, Duration.ofSeconds(100)).until(ExpectedConditions.visibilityOf(dialogBox));

			dialogBoxEle.isDisplayed();

			WebElement btnOkEle = new WebDriverWait(driver, Duration.ofSeconds(100)).until(ExpectedConditions.visibilityOf(btnDeleteConfirmation));

			btnOkEle.click();

		} catch (Exception e) {
			System.out.println("Delete Column Fail ");
		}

		try {
			WebElement firstRow = new WebDriverWait(driver, Duration.ofSeconds(150)).until(ExpectedConditions.visibilityOf(hgEL));
			firstRow.isDisplayed();

			Thread.sleep(5000);
			iamDoneBtn.click();
			WebElement firstRowCheck = new WebDriverWait(driver, Duration.ofSeconds(150)).until(ExpectedConditions.visibilityOf(hgEL));
			firstRowCheck.isDisplayed();

		} catch (Exception e) {
			System.out.println("I am done fail ");
		}
		Thread.sleep(3000);
	}
	
	
	public boolean verifyKPIPortfolio(String myP1, String myP2, String myP3) throws FileNotFoundException, IOException {
		boolean result = false;
		properties.load(new FileInputStream("./src/test/resources/configurations/myP2CommonKPI.properties"));

		String myp1Name = myP1.replaceAll("\\s", "_") + "_myP2";
		String myp2Name = myP2.replaceAll("\\s", "_") + "_myP2";
		String myp3Name = myP3.replaceAll("\\s", "_") + "_myP2";

		String myP3_Occupancy = properties.getProperty(myp3Name).replaceAll(",", "").replaceAll("\\$", "").replaceAll("%","");
		String myP2_RoomsAvailable = properties.getProperty(myp2Name).replaceAll(",", "").replaceAll("\\$", "").replaceAll("%","");
		String myP1_RoomSold = properties.getProperty(myp1Name).replaceAll(",", "").replaceAll("\\$", "").replaceAll("%","");

		System.out.println("===============================");
		System.out.println("myP2 = " + myP1 + " = " + myP1_RoomSold);
		System.out.println("myP2 = " + myP2 + " = " + myP2_RoomsAvailable);
		System.out.println("myP2 = " + myP3 + " = " + myP3_Occupancy);
		
		Double status =Double.parseDouble(myP1_RoomSold) / Double.parseDouble(myP2_RoomsAvailable);
		System.out.println("status = " + status);
		
		Double status1 = (Double.parseDouble(myP3_Occupancy));
		System.out.println("status1 = " + status1);
		
		System.out.println("===============================");

		if (Double.parseDouble(myP1_RoomSold) / (Double.parseDouble(myP2_RoomsAvailable))==(Double.parseDouble(myP3_Occupancy))) {
			result = true;
		}
		
		try (OutputStream outputStream = new FileOutputStream("./src/test/resources/configurations/myP2CommonKPI.properties")) {
			properties.clear();
			properties.store(outputStream, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	
}
