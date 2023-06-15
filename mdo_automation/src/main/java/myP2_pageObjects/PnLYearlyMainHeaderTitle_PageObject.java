package myP2_pageObjects;

import java.time.Duration;
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

public class PnLYearlyMainHeaderTitle_PageObject {

	private WebDriver driver;
	private ConstantsReader configReader = new ConstantsReader();

	public PnLYearlyMainHeaderTitle_PageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@id='mui-component-select-columns[0].dataType']")
	WebElement drpColumn1;

	@FindBy(xpath = "//div[@id='mui-component-select-columns[0].yearOffest']")
	WebElement drpYear1;

	@FindBy(xpath = "//h3[text()='Edit Columnss']")
	WebElement lblEdit;

	@FindBy(xpath = "//ul[@role='listbox']//li")
	List<WebElement> lstDropDownGroup;

	@FindBy(xpath = "//button[@data-el='buttonFiltersApply']")
	WebElement btnApply;

	@FindBy(xpath = "//div[text()='Rooms available']")
	WebElement lblRoomAva;

	@FindBy(xpath = "//div[@id='mui-component-select-customViewId']")
	WebElement dropDownView;

	@FindBy(xpath = "//ul[@role='listbox']//li")
	List<WebElement> lstDropDownView;

	public void selectDropdownParameters(String column1, String year) throws InterruptedException {

		WebElement ediColumnEle = new WebDriverWait(driver, Duration.ofSeconds(50))
				.until(ExpectedConditions.visibilityOf(lblEdit));

		ediColumnEle.isDisplayed();

		WebElement drpColumn = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.visibilityOf(drpColumn1));

		drpColumn.click();

		Thread.sleep(2500);

		for (int i = 0; i < lstDropDownGroup.size(); i++) {
			if (lstDropDownGroup.get(i).getText().equalsIgnoreCase(column1)) {
				lstDropDownGroup.get(i).click();

			}
		}

		Thread.sleep(2500);

		WebElement drpYear = new WebDriverWait(driver, Duration.ofSeconds(50))
				.until(ExpectedConditions.visibilityOf(drpYear1));

		drpYear.click();

		Thread.sleep(2500);

		for (int i = 0; i < lstDropDownGroup.size(); i++) {
			if (lstDropDownGroup.get(i).getText().equalsIgnoreCase(year)) {
				lstDropDownGroup.get(i).click();

			}
		}

		Thread.sleep(2500);

		WebElement btnApplyEle = new WebDriverWait(driver, Duration.ofSeconds(50))
				.until(ExpectedConditions.visibilityOf(btnApply));

		btnApplyEle.click();

		Thread.sleep(5000);
	}

	public boolean verifyActualMainHeader(String column, String year) throws InterruptedException {

		ElementUtils.waitForElementToDisplay(lblRoomAva, 100);

		int status = 0;
		String param = column + " " + year + " ";
		String forecastParam = year + " " + column + " ";

		if (column.equalsIgnoreCase("Actual") || column.equalsIgnoreCase("Budget")) {
			
			System.out.print("Header :"+column);
			status = driver.findElements(By.xpath("//th//span[contains(text(),'" + param + "(Jan - Dec)')]")).size();

		} else if (column.equalsIgnoreCase("Forecast")) {
			
			System.out.print("Header :"+column);
			status = driver.findElements(By.xpath("//th//span[contains(text(),'" + forecastParam + "- 1')]")).size();

		}

		if (status == 1) {
			return true;
		} else {
			return false;
		}
	}

	public void changeTheView(String view) throws InterruptedException {
		dropDownView.click();

		Thread.sleep(5000);

		for (int i = 0; i < lstDropDownView.size(); i++) {
			if (lstDropDownView.get(i).getText().equalsIgnoreCase(view)) {
				lstDropDownView.get(i).click();

			}
		}
		Thread.sleep(4500);
	}
}
