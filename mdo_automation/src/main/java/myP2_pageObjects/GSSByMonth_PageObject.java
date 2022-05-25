package myP2_pageObjects;

import java.time.Duration;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.ElementUtils;

public class GSSByMonth_PageObject {
	private WebDriver driver;
	double sampleSizeMedallia, benchMarkMedallia, varianceMedallia, sampleSizeMonth, totalMonth, varianceMonth,
			benchMarkMonth;
	double valuesMedallia[];
	double valuesMonth[];
	String propertyNameMedalia, propertyNameMonth;
	boolean result = false;

	public GSSByMonth_PageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		valuesMedallia = new double[15];

	}

	@FindBy(xpath = "//th[text()='Property']")
	WebElement lblProperty;

	@FindBy(xpath = "//th[@index=0]")
	WebElement tableProperty;

	@FindBy(xpath = "//td//input//preceding-sibling::div[@role='button']")
	List<WebElement> listOfPriorityDropdown;

	@FindBy(xpath = "//li[@data-value=\'0\']")
	WebElement dropDownValues;

	@FindBy(xpath = "//li[@data-value]")
	List<WebElement> lstDropDownValues;

	@FindBy(xpath = "//div[text()='GSS By Month']//ancestor::li")
	WebElement gssMonth;

	@FindBy(xpath = "//h1[text()='GSS By Month']")
	WebElement gssMonthPage;

	@FindBy(xpath = "//input[@name='date']")
	WebElement txtDate;

	@FindBy(xpath = "//div[@data-el='inputDate']")
	WebElement txtDateText;

	@FindBy(xpath = "//button[@data-el='buttonGo']")
	WebElement btnGo;

	@FindBy(xpath = "//input[@name='keyword']")
	WebElement txtSearch;

	@FindBy(xpath = "//tr[@data-el]")
	List<WebElement> tableRows;

	@FindBy(xpath = "//h1[text()='GSS Medallia']")
	WebElement gssMedalliaPage;

	@FindBy(xpath = "//input[@name='hotelId']")
	WebElement hotelId;

	@FindBy(xpath = "//tbody//tr[@data-el='00000000-0000-0000-0000-000000028d7f']//td")
	List<WebElement> sampleValues;

	@FindBy(xpath = "//tbody//tr[1]//td")
	List<WebElement> propertyValues;

	public void setPriorityZero() throws InterruptedException {

		ElementUtils.waitForElementToDisplay(lblProperty, 100);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "");

		for (int i = 0; i < listOfPriorityDropdown.size(); i++) {
			if (listOfPriorityDropdown.get(i).getText().equals("1")) {
				listOfPriorityDropdown.get(i).click();

				WebElement DrpValue = new WebDriverWait(driver, Duration.ofSeconds(1))
						.until(ExpectedConditions.visibilityOf((WebElement) dropDownValues));

				DrpValue.isDisplayed();

				lstDropDownValues.get(0).click();

				Thread.sleep(1500);

			}
		}

	}

	public boolean navigateToGssMonthPage() {

		WebElement gssMonthCL = new WebDriverWait(driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.visibilityOf(gssMonth));
		gssMonthCL.click();

		WebElement gssMonthPageCL = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.visibilityOf(gssMonthPage));
		return gssMonthPageCL.isDisplayed();

	}

	public boolean loadMonthReport() throws InterruptedException {
		WebElement gssMonthPageCL = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.visibilityOf(gssMonthPage));

		gssMonthPageCL.isDisplayed();

		txtDate.sendKeys(Keys.CONTROL + "a");
		txtDate.sendKeys(Keys.DELETE);
		txtDate.sendKeys("04/05/2022");
		Thread.sleep(1500);
		btnGo.click();

		WebElement homePage = new WebDriverWait(driver, Duration.ofSeconds(20))
				.until(ExpectedConditions.visibilityOf(tableProperty));
		return homePage.isDisplayed();
	}

	public void setPriority(String keyword) throws InterruptedException {
		txtSearch.sendKeys(Keys.CONTROL + "a");
		txtSearch.sendKeys(Keys.DELETE);
		txtSearch.sendKeys(keyword);

		WebElement homePage = new WebDriverWait(driver, Duration.ofSeconds(20))
				.until(ExpectedConditions.visibilityOf(tableProperty));

		if (homePage.isDisplayed()) {
			WebElement btn = driver.findElement(By.xpath("//tr[@data-el='0']//td[@index='1']"));

			btn.click();

			ElementUtils.waitForElementToDisplay(gssMedalliaPage, 100);

			btnGo.click();
			ElementUtils.waitForElementToDisplay(lblProperty, 100);

		}

	}

	public void setPriorityOne(String searchText) {

		try {
			ElementUtils.waitForElementToDisplay(lblProperty, 100);

			sampleSizeMedallia = Double.parseDouble(sampleValues.get(13).getText().replaceAll(",", ""));

			txtSearch.sendKeys(searchText);
			
			Thread.sleep(5000);
			btnGo.click();
			listOfPriorityDropdown.get(0).click();
			lstDropDownValues.get(0).click();
			Thread.sleep(5000);
			
			propertyNameMedalia = propertyValues.get(0).getText();
			benchMarkMedallia = Double.parseDouble(propertyValues.get(14).getText().replaceAll(",", ""));
			varianceMedallia = Double.parseDouble(propertyValues.get(15).getText().replaceAll(",", ""));

			for (int i = 0; i < valuesMedallia.length; i++) {

				valuesMedallia[i] = Double.parseDouble(propertyValues.get(i + 1).getText());
			}
			Thread.sleep(2000);

			listOfPriorityDropdown.get(0).click();
			Thread.sleep(2000);
			lstDropDownValues.get(1).click();
			Thread.sleep(3000);

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public void validatePriority(String keyword) throws InterruptedException {

		txtDate.sendKeys(Keys.CONTROL + "a");
		txtDate.sendKeys(Keys.DELETE);
		txtDate.sendKeys("04/05/2022");

		txtSearch.sendKeys(Keys.CONTROL + "a");
		txtSearch.sendKeys(Keys.DELETE);
		txtSearch.sendKeys(keyword);

		btnGo.click();

		ElementUtils.waitForElementToDisplay(lblProperty, 100);

		valuesMonth = new double[propertyValues.size() - 6];

		propertyNameMonth = propertyValues.get(1).getText();

		if (propertyNameMedalia.equalsIgnoreCase(propertyNameMonth)) {
			sampleSizeMonth = Double.parseDouble(propertyValues.get(2).getText().replaceAll(",", ""));
			totalMonth = Double
					.parseDouble(propertyValues.get(propertyValues.size() - 3).getText().replaceAll(",", ""));
			benchMarkMonth = Double
					.parseDouble(propertyValues.get(propertyValues.size() - 2).getText().replaceAll(",", ""));
			varianceMonth = Double
					.parseDouble(propertyValues.get(propertyValues.size() - 1).getText().replaceAll(",", ""));

			System.out.println("M " + valuesMonth.length + "," + propertyNameMonth + propertyNameMedalia+ " size " + sampleSizeMonth
					+ " total " + totalMonth + " bench " + benchMarkMonth + " vari " + varianceMonth);

			for (int i = 0; i < valuesMonth.length; i++) {

				valuesMonth[i] = Double.parseDouble(propertyValues.get(i + 3).getText());
			}

		}

	}

	public boolean compareValues() {

		if (sampleSizeMedallia == sampleSizeMonth && benchMarkMedallia == benchMarkMonth
				&& varianceMedallia == varianceMonth) {
			for (int i = 0; i < valuesMonth.length; i++) {
				if (valuesMonth[i] == valuesMedallia[i]) {
					result = true;
				} else {
					result = false;
					break;
				}
			}

		} else {
			result = false;
		}

		return result;
	}

}
