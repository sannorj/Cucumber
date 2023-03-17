package myP1_pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.ConstantsReader;

public class propertyDashboard_DayMonthYearVerify_PageObjects {

	WebDriver driver;
	private ConstantsReader configReader = new ConstantsReader();

	public propertyDashboard_DayMonthYearVerify_PageObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@id='aMonth']")
	WebElement monthBtn;

	@FindBy(xpath = "//a[@id='aYear']")
	WebElement yearBtn;

	@FindBy(xpath = "//select[@id='divMonth']")
	WebElement selectMonth;

	@FindBy(xpath = "//select[@id='divYear']")
	WebElement selectYear;

	@FindBy(xpath = "(//select[@class='form-control select2-offscreen'])[1]")
	WebElement propertyDropdown;

	@FindBy(xpath = "//div[contains(text(),'Sunday')]")
	WebElement monthList;

	@FindBy(xpath = "//button[@id='btnSearch']")
	WebElement searchBtn;

	@FindBy(xpath = "//a[@class='alinkAddEvent']")
	WebElement selectAddEvent;

	@FindBy(xpath = "//h4[text()='Add Event']")
	WebElement checkAddEventPopup;

	@FindBy(xpath = "//form[@id='formAddEvent']//button[@class='close']")
	WebElement closeAddEvent;

	public void clickMonth() {
		monthBtn.click();
		WebElement monthPageLoad = new WebDriverWait(driver, Duration.ofSeconds(500))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Week')]")));
	}

	public void searchSelectedMonthYear() throws InterruptedException {
		Thread.sleep(7000);
		Select drpMonth = new Select(selectMonth);
		drpMonth.selectByVisibleText(configReader.getMYP1Prop("Selected_month"));

		Select drpYear = new Select(selectYear);
		drpYear.selectByVisibleText(configReader.getMYP1Prop("Selected_year"));
		Thread.sleep(10000);
		WebElement propertyDB = new WebDriverWait(driver, Duration.ofSeconds(700))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='select2-chosen-1']")));
//		propertyDB.click();
		Thread.sleep(10000);
		Thread.sleep(5000);
		Select drpHotel = new Select(propertyDropdown);
		Thread.sleep(10000);
		drpHotel.selectByVisibleText(configReader.getMYP1Prop("Property_dashboard_hotel"));
		Thread.sleep(2000);
		searchBtn.click();
		Thread.sleep(7000);

		WebElement monthPageLoad = new WebDriverWait(driver, Duration.ofSeconds(500))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Week')]")));
		System.out.println("Month Page Loaded");

	}

	public boolean checkAddEventPopupLoaded() {
		selectAddEvent.click();
		WebElement viewAddEvent = new WebDriverWait(driver, Duration.ofSeconds(50))
				.until(ExpectedConditions.visibilityOf(checkAddEventPopup));
		if (viewAddEvent.isDisplayed()) {
			System.out.println("Add Event popup is visible");
			return true;
		} else {
			System.out.println("Add Event popup is not visible");
			return false;
		}
	}

	public void clickSeletedDate() throws InterruptedException {
		closeAddEvent.click();
		Thread.sleep(7000);
		Thread.sleep(7000);
		WebElement seletedDate = driver.findElement(By.xpath("//div[@id='div" + configReader.getMYP1Prop("date_href_val")
				+ "']//div[contains(text(),'" + configReader.getMYP1Prop("Selected_date") + "')]"));
		seletedDate.click();
	}

	public boolean verifyNavigateToSelectedDate() throws InterruptedException {
		Thread.sleep(7000);
		WebElement hotelLst = new WebDriverWait(driver, Duration.ofSeconds(50))
				.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath("//span[text()='" + configReader.getMYP1Prop("Property_dashboard_hotel") + "']")));

		WebElement datePageLoaded = new WebDriverWait(driver, Duration.ofSeconds(50))
				.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath("//span[text()='" + configReader.getMYP1Prop("date_href_val") + "']")));
		if (datePageLoaded.isDisplayed()) {
			System.out.println("Navigate to Date Page");
			return true;
		} else {
			System.out.println("Not Landed to Date Page");
			return false;
		}
	}

	public void clickYear() {
		yearBtn.click();
	}

	public void searchSelectedYear() throws InterruptedException {

		Select drpYear = new Select(selectYear);
		drpYear.selectByVisibleText(configReader.getMYP1Prop("Selected_year"));

		WebElement propertyDB = new WebDriverWait(driver, Duration.ofSeconds(700))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='select2-chosen-1']")));
		Thread.sleep(10000);
		Thread.sleep(5000);
		Select drpHotel = new Select(propertyDropdown);
		Thread.sleep(10000);
		drpHotel.selectByVisibleText(configReader.getMYP1Prop("Property_dashboard_hotel"));
		Thread.sleep(2000);
		searchBtn.click();
		Thread.sleep(7000);

		WebElement yearPageLoad = new WebDriverWait(driver, Duration.ofSeconds(50))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='January']")));
		System.out.println("Year Page Loaded");
	}

	public void clickOnSelectedMonth() throws InterruptedException {
		WebElement seletedMonth = driver.findElement(
				By.xpath("//label[text()='" + configReader.getMYP1Prop("Selected_month") + "']//following::div"));
		seletedMonth.click();
	}

	public boolean verifyNavigateToSelectedMonth() throws InterruptedException {
		Thread.sleep(7000);
		WebElement monthPageLoad = new WebDriverWait(driver, Duration.ofSeconds(50))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Week')]")));
		if (monthPageLoad.isDisplayed()) {
			System.out.println("Month Page Loaded");
			return true;
		} else {
			System.out.println("Month Page not Loading");
			return false;
		}
	}

}
