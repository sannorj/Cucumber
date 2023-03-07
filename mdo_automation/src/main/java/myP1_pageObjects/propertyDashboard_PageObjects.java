package myP1_pageObjects;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.ConstantsReader;

public class propertyDashboard_PageObjects {

	private WebDriver driver;
	private ConstantsReader configReader = new ConstantsReader();

	public propertyDashboard_PageObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()='Property']//ancestor::a")
	WebElement propertyMenue;

	@FindBy(xpath = "//h2[text()='Portfolio Dashboard']")
	WebElement propertyHeader;

	@FindBy(xpath = "(//select[@class='form-control select2-offscreen'])[1]")
	WebElement propertyDropdown;

	@FindBy(xpath = "//button[@id='btnSearch']")
	WebElement searchBTN;

	@FindBy(xpath = "//h2[text()='Property Dashboard']")
	WebElement propertyDashboardPage;

	@FindBy(xpath = "(//tr[@id='tablerow']//span[@class='spnCurrentDate'])[1]")
	WebElement tblCurrentDate;

	@FindBy(xpath = "//input[@id='txtDate']")
	WebElement datePickerVal;

	@FindBy(xpath = "//div[@class='DTFC_ScrollWrapper']")
	WebElement propertyDashboardTable;

	@FindBy(xpath = "//form[@id='formAddEvent']//button[@class='close']")
	WebElement closeAddEventModal;
	
	public boolean navigateToProperty() throws InterruptedException {
		boolean result = false;
		WebElement portfolio = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.visibilityOf(propertyMenue));
		portfolio.click();
		WebElement propertyHeaderView = new WebDriverWait(driver, Duration.ofSeconds(100))
				.until(ExpectedConditions.visibilityOf(propertyHeader));
		if (propertyHeaderView.isDisplayed()) {
			System.out.println("==navigateToProperty==");
			Thread.sleep(7000);
			result = true;
		}
		return result;
	}

	public void selectPropertyValues() throws InterruptedException {
//		Thread.sleep(7000);
		Thread.sleep(100);
		WebElement propertyDB = new WebDriverWait(driver, Duration.ofSeconds(1000))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='select2-chosen-1']")));
		WebElement waitForViewPeriod = new WebDriverWait(driver, Duration.ofSeconds(1000))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[contains(text(),'Period')]")));
		System.out.println("==property dropdown view==");
		Thread.sleep(7000);
		Select drpHotel = new Select(propertyDropdown);
		Thread.sleep(3000);
		drpHotel.selectByVisibleText(configReader.getMYP1Prop("Property_dashboard_hotel"));
		Thread.sleep(3000);
		try {
			searchBTN.click();
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("==selectPropertyValues==");
		Thread.sleep(8000);
	}

	public boolean navigateToPropertyDashboard() throws InterruptedException {
		boolean result = false;
		WebElement waitpropertyDashboardPage = new WebDriverWait(driver, Duration.ofSeconds(900))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='Property Dashboard']")));
		System.out.println("===navigate to property db page===");
		if (waitpropertyDashboardPage.isDisplayed()) {
			System.out.println("==navigateToPropertyDashboard==");
			result = true;
		}
		Thread.sleep(6000);
		if(closeAddEventModal.isDisplayed()) {
			closeAddEventModal.click();
		}
		datePickerVal.sendKeys(Keys.CONTROL + "a");
		datePickerVal.sendKeys(Keys.DELETE);
		datePickerVal.sendKeys(configReader.getMYP1Prop("date_href_val"));
		Thread.sleep(6000);
		searchBTN.click();

		return result;
	}

	public boolean verifyDataLoadTODate() throws InterruptedException {
		WebElement RoomSalesLoaded = new WebDriverWait(driver, Duration.ofSeconds(900))
				.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath("(//table//tr//td[text()='Room Sales'])[1]")));

		WebElement dateHrefVal = new WebDriverWait(driver, Duration.ofSeconds(900))
				.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath("//a[@id='alnkRoomRevenueSummary' and contains(@href,'" + configReader.getMYP1Prop("date_href_val") + "')]")));

		Thread.sleep(3000);

		if (dateHrefVal.isDisplayed()) {
			System.out.println("==verifyDataLoadTODate==");
			return true;
		} else {
			System.out.println("==verifyDataLoadTODate return false==");
			return false;
		}

	}

	public boolean verifyTableLoaded() throws InterruptedException {
		Thread.sleep(7000);
		boolean tableDisplay = propertyDashboardTable.isDisplayed();
		System.out.println("Table displayed==" + tableDisplay);
		return tableDisplay;
	}

	public void checkAllChartsLoaded() throws InterruptedException {

		WebElement allChartsLoaded = new WebDriverWait(driver, Duration.ofSeconds(50))
				.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath("//div[@class='chart-data-selector ready']//h2[@class='panel-title']")));

		List<String> addChartList = driver
				.findElements(By.xpath("//div[@id='addChartModal']//div[@class='switch switch-sm switch-success']"))
				.stream().map(panel -> panel.getAttribute("id")).collect(Collectors.toList());

		Thread.sleep(7000);

		List<String> addedChartList = driver
				.findElements(By.xpath("//section[@class='panel panel-primary']//a[@title='Close']")).stream()
				.map(chart -> chart.getAttribute("data-content")).collect(Collectors.toList());

		for (int i = 0; i < addChartList.size(); i++) {
			if (!addedChartList.contains(addChartList.get(i))) {
				String currentChartMenuOption = driver
						.findElement(By.xpath(
								"//div[@id='" + addChartList.get(i) + "']//parent::div//preceding-sibling::label"))
						.getAttribute("innerText");
				System.out.println("The Panel not visible in the Dashboard page: " + currentChartMenuOption);

			}
		}
	}

}
