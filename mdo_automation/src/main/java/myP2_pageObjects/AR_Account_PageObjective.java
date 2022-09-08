package myP2_pageObjects;

import java.time.Duration;
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
import utils.ElementUtils;

public class AR_Account_PageObjective {
	private WebDriver driver;
	private ConstantsReader configReader = new ConstantsReader();
	double dataValues[][];
	double maxDataValue, outstandingRedVal, outstandingYellow;
	boolean flag;

	public AR_Account_PageObjective(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//button[@data-el='menuToggle']")
	WebElement selector;

	@FindBy(xpath = "//div[text()='Reports']//ancestor::li")
	WebElement reports;

	@FindBy(xpath = "//div[text()='Accounts Receivable']//ancestor::li")
	WebElement Ar;

	@FindBy(xpath = "//div[text()='AR Account']//ancestor::li")
	WebElement ArAccount;

	@FindBy(xpath = "//h1[text()='AR Account']")
	WebElement ArAccountPage;

	@FindBy(xpath = "//div[@data-el='appName']")
	WebElement header;

	@FindBy(xpath = "//input[@name='hotelClientAccountId']")
	WebElement dropDownAccount;

	@FindBy(xpath = "//ul[@role='listbox']//li")
	List<WebElement> lstDropDowAccount;

	@FindBy(xpath = "//div/label[text()='Date']//following-sibling::div/input[@placeholder='mm/dd/yyyy']")
	WebElement txtDate;

	@FindBy(xpath = "//th//span[@role='button']")
	WebElement txtRowField;

	@FindBy(xpath = "//button//span[text()='Go']")
	WebElement btnGo;

	@FindBy(xpath = "//div//h5")
	List<WebElement> chartHeader;

	@FindBy(xpath = "//tbody//tr")
	List<WebElement> dataRowCount;
	
	
	public boolean navigateToARAccountPage() {

		WebElement arArAccountCL = new WebDriverWait(driver, Duration.ofSeconds(50))
				.until(ExpectedConditions.visibilityOf(ArAccount));
		arArAccountCL.click();

		WebElement arArAccountPageCL = new WebDriverWait(driver, Duration.ofSeconds(50))
				.until(ExpectedConditions.visibilityOf(ArAccountPage));
		return arArAccountPageCL.isDisplayed();

	}
	
	public void loadPageWithParameters() throws InterruptedException {

		ElementUtils.waitForElementToDisplay(header, 100);

		WebElement drpAccount = new WebDriverWait(driver, Duration.ofSeconds(50))
				.until(ExpectedConditions.visibilityOf(dropDownAccount));

		drpAccount.click();
		Thread.sleep(2500);
		for (int i = 0; i < lstDropDowAccount.size(); i++) {
			if (lstDropDowAccount.get(i).getText().equalsIgnoreCase("All Accounts")) {
				lstDropDowAccount.get(i).click();

			}
		}
		
		txtDate.sendKeys(Keys.CONTROL + "a");
		txtDate.sendKeys(Keys.DELETE);
		txtDate.sendKeys(configReader.getProp("Date"));
		
		Thread.sleep(2500);

		
		drpAccount.click();
		Thread.sleep(2500);
		for (int i = 0; i < lstDropDowAccount.size(); i++) {
			if (lstDropDowAccount.get(i).getText().equalsIgnoreCase("All Accounts")) {
				lstDropDowAccount.get(i).click();

			}
		}
		
		

		

	}
	
	public boolean loadArAccountReport() throws InterruptedException {
		
		
		btnGo.click();

		WebElement txtProperty1 = new WebDriverWait(driver, Duration.ofSeconds(200))
				.until(ExpectedConditions.visibilityOf(txtRowField));

		Thread.sleep(2500);
		WebElement drpAccount = new WebDriverWait(driver, Duration.ofSeconds(100))
				.until(ExpectedConditions.visibilityOf(dropDownAccount));
		
		drpAccount.click();
		
		for (int i = 0; i < lstDropDowAccount.size(); i++) {
			if (lstDropDowAccount.get(i).getText().equalsIgnoreCase(configReader.getProp("Account_ARC"))) {
				lstDropDowAccount.get(i).click();

			}
		}
		
		btnGo.click();
		WebElement txtProperty = new WebDriverWait(driver, Duration.ofSeconds(100))
				.until(ExpectedConditions.visibilityOf(txtRowField));
		
		return txtProperty.isDisplayed();
	}
	
	
	
	public void storeAlltheAccountRecords() {
		dataValues = new double[dataRowCount.size() - 1][5];

		for (int i = 0; i < dataRowCount.size() - 1; i++) {
			for (int j = 2; j < 7; j++) {
				WebElement data = driver.findElement(By.xpath("//tbody//tr[" + (i + 1) + "]//td[" + j + "]"));

				dataValues[i][j - 2] = Double.parseDouble(
						data.getText().replace(",", "").replace("$", "").replace("(", "").replace(")", ""));

			}
		}

		for (int k = 0; k < dataValues[0].length; k++) {
			System.out.println(dataValues[0][k]);
		}
	}
	
	public double calulateArAccountMaxValue() {
		maxDataValue = 0;

		for (int i = 0; i < dataValues.length; i++) {
			for (int j = 0; j < dataValues[i].length; j++) {
				if (dataValues[i][j] > maxDataValue) {
					maxDataValue = dataValues[i][j];
				}
			}
		}
		System.out.println("ABC "+maxDataValue);
		return maxDataValue;
	}
	
	public boolean verifyArAccountRedOutstanding() {
		flag = true;
		outstandingRedVal = (maxDataValue * 0.75);

		for (int i = 0; i < dataRowCount.size() - 1; i++) {
			for (int j = 2; j < 7; j++) {
				WebElement data = driver.findElement(By.xpath("//tbody//tr[" + (i + 1) + "]//td[" + j + "]"));

				double tempDataValue = Double.parseDouble(
						data.getText().replace(",", "").replace("$", "").replace("(", "").replace(")", ""));

				if (tempDataValue > outstandingRedVal) {
					int coloredData = driver.findElements(By.xpath(
							"//tbody//tr[" + (i + 1) + "]//td[" + j + "][contains(@maxandmediumcolor,'#FFC1C1')]"))
							.size();

					if (coloredData > 0) {
						flag = true;
					} else {
						flag = false;
						System.out.println("row"+i+" col"+j+ " val"+tempDataValue);
						break;
						
						
					}
				}

			}

			if (!flag) {
				break;
			}
		}

		return flag;

	}
	
	public boolean verifyYellowOutstanding() {
		flag = true;
		outstandingRedVal = (maxDataValue * 0.74);
		outstandingYellow = (maxDataValue * 0.5);

		for (int i = 0; i < dataRowCount.size() - 1; i++) {
			for (int j = 2; j < 7; j++) {
				WebElement data = driver.findElement(By.xpath("//tbody//tr[" + (i + 1) + "]//td[" + j + "]"));

				double tempDataValue = Double.parseDouble(
						data.getText().replace(",", "").replace("$", "").replace("(", "").replace(")", ""));

				if (tempDataValue > outstandingYellow && tempDataValue < outstandingRedVal) {
					int coloredData = driver.findElements(By.xpath(
							"//tbody//tr[" + (i + 1) + "]//td[" + j + "][contains(@maxandmediumcolor,'#FFDD9F')]"))
							.size();

					if (coloredData > 0) {
						flag = true;
					} else {
						flag = false;
						System.out.println("row"+i+" col"+j+ " val"+tempDataValue);
						break;
						
						
					}
				}

			}

			if (!flag) {
				break;
			}
		}

		return flag;

	}
}
