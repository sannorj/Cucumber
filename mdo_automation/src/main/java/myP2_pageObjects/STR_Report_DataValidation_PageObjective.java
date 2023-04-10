package myP2_pageObjects;

import java.time.Duration;
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

public class STR_Report_DataValidation_PageObjective {

	private WebDriver driver;
	private ConstantsReader configReader = new ConstantsReader();

	public STR_Report_DataValidation_PageObjective(WebDriver driver) {
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

	@FindBy(xpath = "//label[text()='Date']//following::input")
	WebElement goButton;
	
	@FindBy(xpath = "//tbody//tr[2]/td[2]/div/div/div/div/div")
	WebElement firstCell;

	@FindBy(xpath = "//label[text()='Group']//following-sibling::div//input")
	WebElement group;

	@FindBy(xpath = "//label[text()='Property']//following-sibling::div//input")
	WebElement property;

	@FindBy(xpath = "//div[@role='listbox']//li")
	List<WebElement> lstDropDowGroup;

	@FindBy(xpath = "//div[@role='listbox']//li")
	List<WebElement> lstDropDowProperty;
	
	String firstCellValue=null;

	public void selectCurrentDate(String date) throws InterruptedException {
		selectDate(date);
	}

	public void selectWeekButton(String weekVal) throws InterruptedException {
		WebElement selectWeekBtn = new WebDriverWait(driver, Duration.ofSeconds(1000))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button/div[text()='"+weekVal+"']")));
		selectWeekBtn.click();
		Thread.sleep(3000);
	}

	public void storeCell() {
		firstCellValue=firstCell.getText();
		System.out.println("First cell value of 4 week = "+firstCellValue);
	}

	public boolean compareCellValues() throws InterruptedException {
		String secondVal=firstCell.getText();
		if (secondVal.equalsIgnoreCase(firstCellValue)) {
			System.out.println("Both 4 week & 52 week first values are equals ==== " + secondVal +" /// "+ firstCellValue);
			Thread.sleep(3000);
			return true;
		}else {
			System.out.println("Both 4 week & 52 week first values are not equals ==== " + secondVal +" /// "+ firstCellValue);
			Thread.sleep(3000);
			return false; 
		}
	}

	public boolean compareDifPropertyValues() throws InterruptedException {
		String secondVal=firstCell.getText();
		System.out.println(firstCell.isDisplayed());
		
		WebElement tableOverlay = new WebDriverWait(driver, Duration.ofSeconds(250))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-el='data-container-1']")));
		System.out.println(tableOverlay.getCssValue("opacity"));
		float tableOverlayVal=Float.parseFloat(tableOverlay.getCssValue("opacity"));
		if(1>tableOverlayVal) {
			System.out.println("Table view is Blurred.");
			Thread.sleep(3500);
			return true;
		}else {
			System.out.println("Table previous view is still display");
			Thread.sleep(3500);
			return false;
		}
	}

	public boolean selectOptions(String groupName, String propertyName) throws InterruptedException {
		boolean result = true;
		System.out.println("groupName=="+groupName);
		System.out.println("propertyName=="+propertyName);
		if(!"null".equals(groupName)) {
			WebElement drpGroup = new WebDriverWait(driver, Duration.ofSeconds(5000))
					.until(ExpectedConditions.visibilityOf(group));
			drpGroup.click();
			Thread.sleep(2500);
			for (int i = 0; i < lstDropDowGroup.size(); i++) {
				if (lstDropDowGroup.get(i).getText().contains(groupName)) {
					lstDropDowGroup.get(i).click();
				}
			}
			
			Thread.sleep(1500);
		}
		if(!"null".equals(propertyName)) {

			WebElement drpProperty = new WebDriverWait(driver, Duration.ofSeconds(5000))
					.until(ExpectedConditions.visibilityOf(property));
			drpProperty.click();
			Thread.sleep(2500);
			for (int i = 0; i < lstDropDowProperty.size(); i++) {
				if (lstDropDowProperty.get(i).getText().equalsIgnoreCase(propertyName)) {
					lstDropDowProperty.get(i).click();
				}
			}
		}
		return result;
	}

	public boolean slectLadingPageFilters(String groupName, String propertyName) throws InterruptedException {

		WebElement drpGroup = new WebDriverWait(driver, Duration.ofSeconds(5000))
				.until(ExpectedConditions.visibilityOf(group));

		drpGroup.click();
		Thread.sleep(2500);
		for (int i = 0; i < lstDropDowGroup.size(); i++) {
			if (lstDropDowGroup.get(i).getText().contains(groupName)) {
				lstDropDowGroup.get(i).click();
			}
		}

		Thread.sleep(1500);

		WebElement drpProperty = new WebDriverWait(driver, Duration.ofSeconds(5000))
				.until(ExpectedConditions.visibilityOf(property));
		drpProperty.click();
		Thread.sleep(2500);
		for (int i = 0; i < lstDropDowProperty.size(); i++) {
			if (lstDropDowProperty.get(i).getText().equalsIgnoreCase(propertyName)) {
				lstDropDowProperty.get(i).click();
			}
		}
		Thread.sleep(3000);
		return true;
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
			System.out.println("monthInnum="+monthInnum);

			int monthDiff = monthInnum - Integer.parseInt(dateForPicker[0]);
			System.out.println("monthDiff="+monthDiff);
			
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
	
}
