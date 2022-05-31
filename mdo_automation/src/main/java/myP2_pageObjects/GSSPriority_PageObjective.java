package myP2_pageObjects;

import java.text.DecimalFormat;
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

public class GSSPriority_PageObjective {

	private WebDriver driver;
	double sampleValuesMedallia[], samplePropertValueMedalliah[];
	String dtSplit[];
	String date, propertyNameMedalia, propertyPriority, grpName, propertyName;
	double varianceMedallia, benchMarkMedallia, totalMedallia, cpPrioritySample, cpPriorityValue;
	WebElement sampleSize, sampleValuePriorityOne;
	DecimalFormat df;
	private ConstantsReader configReader = new ConstantsReader();

	public GSSPriority_PageObjective(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		date = "04/06/2021";
		dtSplit = date.split("/");
		df = new DecimalFormat("0.00");

	}

	@FindBy(xpath = "//div[text()='GSS By Priority']//ancestor::li")
	WebElement gssPriority;

	@FindBy(xpath = "//h1[text()='GSS By Priority']")
	WebElement gssPriorityPage;

	@FindBy(xpath = "//input[@name='portfolio']")
	WebElement dropDownGroup;

	@FindBy(xpath = "//ul[@role='listbox']//li")
	List<WebElement> lstDropDownGroup;

	@FindBy(xpath = "//div[@id='mui-component-select-period']")
	WebElement dropDownPeriod;

	@FindBy(xpath = "//ul[@role='listbox']//li")
	List<WebElement> lstDropDownPeriod;

	@FindBy(xpath = "//input[@name='date']")
	WebElement txtDate;

	@FindBy(xpath = "//div[@id='mui-component-select-priorityQty']")
	WebElement dropDownPriorityQuantity;

	@FindBy(xpath = "//ul[@role='listbox']//li")
	List<WebElement> lstDropDownPriorityQuantity;

	@FindBy(xpath = "//button[@data-el='buttonGo']")
	WebElement btnGo;

	@FindBy(xpath = "//tbody//tr")
	List<WebElement> reportData;

	@FindBy(xpath = "//input[@name='keyword']")
	WebElement txtSearch;

	@FindBy(xpath = "//span[text()='Survey Responses']")
	WebElement lblResponse;

	@FindBy(xpath = "//tbody//tr[@data-el='0']//td[3]")
	WebElement btnSetPriority;

	@FindBy(xpath = "//h1[text()='GSS Medallia']")
	WebElement gssMedalliaPage;

	@FindBy(xpath = "//div[@id='mui-component-select-year']")
	WebElement dropDownMedalliaYear;

	@FindBy(xpath = "//ul[@role='listbox']//li")
	List<WebElement> lstDropDownMedalliaYear;

	@FindBy(xpath = "//tbody//tr[@data-el='00000000-0000-0000-0000-00000001563f']//td")
	List<WebElement> sampleSizeRow;

	@FindBy(xpath = "//tbody//tr[1]//td")
	List<WebElement> propertyValuesMedallia;

	@FindBy(xpath = "//td//input//preceding-sibling::div[@role='button']")
	List<WebElement> listOfPriorityDropdownMedallia;

	@FindBy(xpath = "//li[@data-value]")
	List<WebElement> lstDropDownValues;

	@FindBy(xpath = "//input[@name='showDescription']")
	WebElement buttonShowDescription;

	public boolean navigateToGssPriorityPage() {

		WebElement gssPriorityCL = new WebDriverWait(driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.visibilityOf(gssPriority));
		gssPriorityCL.click();
		WebElement gssPriorityPageCL = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.visibilityOf(gssPriorityPage));
		return gssPriorityPageCL.isDisplayed();

	}

	public void passParameteres() {

		try {
			dropDownGroup.click();
			for (int i = 0; i < lstDropDownGroup.size(); i++) {
				if (lstDropDownGroup.get(i).getText().equalsIgnoreCase(configReader.getProp("Group"))) {
					lstDropDownGroup.get(i).click();

				}
			}

			dropDownPeriod.click();
			for (int i = 0; i < lstDropDownPeriod.size(); i++) {
				if (lstDropDownPeriod.get(i).getText().equalsIgnoreCase(configReader.getProp("PeriodPriority"))) {
					lstDropDownGroup.get(i).click();

				}
			}

			txtDate.sendKeys(Keys.CONTROL + "a");
			txtDate.sendKeys(Keys.DELETE);
			txtDate.sendKeys(date);

			dropDownPriorityQuantity.click();
			for (int i = 0; i < lstDropDownPriorityQuantity.size(); i++) {
				if (lstDropDownPriorityQuantity.get(i).getText().equalsIgnoreCase(configReader.getProp("QuantityMedallia"))) {
					lstDropDownPriorityQuantity.get(i).click();

				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean loadPriorityReport() throws InterruptedException {

		btnGo.click();
		Thread.sleep(15000);
		if (reportData.size() > 0) {

			return true;
		} else {
			return false;
		}

	}

	public void navigateToMedallia() throws InterruptedException {

		txtSearch.sendKeys(Keys.CONTROL + "a");
		txtSearch.sendKeys(Keys.DELETE);
		txtSearch.sendKeys(configReader.getProp("PriorityGroup"));

		Thread.sleep(2500);

		if (reportData.size() > 0) {
			WebElement btnPriority = new WebDriverWait(driver, Duration.ofSeconds(5))
					.until(ExpectedConditions.visibilityOf(btnSetPriority));

			grpName = configReader.getProp("PriorityGroup");

			if (btnPriority.getText().equalsIgnoreCase("Set Priority")) {

				btnPriority.click();

				WebElement gssMedalliaPageCL = new WebDriverWait(driver, Duration.ofSeconds(10))
						.until(ExpectedConditions.visibilityOf(gssMedalliaPage));

				gssMedalliaPageCL.isDisplayed();
				
				if (dropDownMedalliaYear.getText().equalsIgnoreCase(dtSplit[2])) {
					btnGo.click();

				} else {
					dropDownMedalliaYear.click();
					for (int i = 0; i < lstDropDownMedalliaYear.size(); i++) {
						if (lstDropDownMedalliaYear.get(i).getText().equalsIgnoreCase(dtSplit[2])) {
							lstDropDownMedalliaYear.get(i).click();

							btnGo.click();

						}
					}
				}

				Thread.sleep(2000);

				if (reportData.size() > 0) {
					sampleValuesMedallia = new double[sampleSizeRow.size() - 2];
					
					for (int i = 0; i < sampleValuesMedallia.length; i++) {
						sampleValuesMedallia[i] = Double
								.parseDouble(sampleSizeRow.get(i + 1).getText().replaceAll(",", ""));
					}

				}

			}

		}

	}

	public void setPriority() throws InterruptedException {

		txtSearch.sendKeys(Keys.CONTROL + "a");
		txtSearch.sendKeys(Keys.DELETE);
		txtSearch.sendKeys(configReader.getProp("PriorityProperty"));

		Thread.sleep(3500);

		if (reportData.size() > 0) {

			propertyNameMedalia = propertyValuesMedallia.get(0).getText();
			totalMedallia = Double.parseDouble(propertyValuesMedallia.get(13).getText().replaceAll(",", ""));
			benchMarkMedallia = Double.parseDouble(propertyValuesMedallia.get(14).getText().replaceAll(",", ""));
			varianceMedallia = Double.parseDouble(propertyValuesMedallia.get(15).getText().replaceAll(",", ""));

			samplePropertValueMedalliah = new double[propertyValuesMedallia.size() - 5];

			for (int i = 0; i < samplePropertValueMedalliah.length; i++) {
				samplePropertValueMedalliah[i] = Double
						.parseDouble(propertyValuesMedallia.get(i + 1).getText().replaceAll(",", ""));
			}

			listOfPriorityDropdownMedallia.get(0).click();
			lstDropDownValues.get(1).click();

			propertyName = configReader.getProp("PriorityProperty");;
			Thread.sleep(2500);

		}
	}

	public void passParameteresWithProperty() {

		try {
			dropDownGroup.click();
			for (int i = 0; i < lstDropDownGroup.size(); i++) {
				if (lstDropDownGroup.get(i).getText().equalsIgnoreCase(configReader.getProp("Group"))) {
					lstDropDownGroup.get(i).click();

				}
			}

			dropDownPeriod.click();
			for (int i = 0; i < lstDropDownPeriod.size(); i++) {
				if (lstDropDownPeriod.get(i).getText().equalsIgnoreCase(configReader.getProp("PeriodPriority"))) {
					lstDropDownGroup.get(i).click();

				}
			}

			txtDate.sendKeys(Keys.CONTROL + "a");
			txtDate.sendKeys(Keys.DELETE);
			txtDate.sendKeys(date);

			dropDownPriorityQuantity.click();
			for (int i = 0; i < lstDropDownPriorityQuantity.size(); i++) {
				if (lstDropDownPriorityQuantity.get(i).getText().equalsIgnoreCase(configReader.getProp("QuantityMedallia"))) {
					lstDropDownPriorityQuantity.get(i).click();

				}
			}
			Thread.sleep(2500);
			
			txtSearch.sendKeys(Keys.CONTROL + "a");
			txtSearch.sendKeys(Keys.DELETE);
			txtSearch.sendKeys(configReader.getProp("PriorityGroup"));
			
		
			Thread.sleep(2500);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void calculateValues() throws InterruptedException {

		txtSearch.sendKeys(Keys.CONTROL + "a");
		txtSearch.sendKeys(Keys.DELETE);
		txtSearch.sendKeys(configReader.getProp("PriorityGroup"));

		if (reportData.size() > 0) {

			WebElement btnPriority = new WebDriverWait(driver, Duration.ofSeconds(5))
					.until(ExpectedConditions.visibilityOf(btnSetPriority));
			System.out.print("");
			if (!btnPriority.getText().equalsIgnoreCase("Set Priority")) {

				sampleSize = driver.findElement(By.xpath("//tbody//tr[1]//td[2]"));
				sampleValuePriorityOne = driver.findElement(By.xpath("//tbody//tr[1]//td[3]"));
				
				if (dropDownPeriod.getText().equalsIgnoreCase("MTD")) {
					cpPrioritySample = sampleValuesMedallia[Integer.parseInt(dtSplit[0]) - 1];
					cpPriorityValue = samplePropertValueMedalliah[Integer.parseInt(dtSplit[0]) - 1];
				} else if (dropDownPeriod.getText().equalsIgnoreCase("YTD")) {

					for (int j = 0; j <= Integer.parseInt(dtSplit[0]) - 1; j++) {
						
						cpPrioritySample += sampleValuesMedallia[j];
						cpPriorityValue += samplePropertValueMedalliah[j];
					}
				} else if (dropDownPeriod.getText().equalsIgnoreCase("Wave 1")) {

					for (int j = 0; j < 6; j++) {
						
						cpPrioritySample += sampleValuesMedallia[j];
						cpPriorityValue += samplePropertValueMedalliah[j];
					}
				} else if (dropDownPeriod.getText().equalsIgnoreCase("Wave 2")) {

					for (int j = 6; j < 12; j++) {
						
						cpPrioritySample += sampleValuesMedallia[j];
						cpPriorityValue += samplePropertValueMedalliah[j];
					}
				}

				cpPrioritySample = Double.parseDouble(df.format(cpPrioritySample));
				cpPriorityValue = Double.parseDouble(df.format(cpPriorityValue));

			}
		}

	}

	public boolean comparingValues() {

		if (cpPrioritySample == Double.parseDouble(sampleSize.getText().toString())
				&& cpPriorityValue == Double.parseDouble(sampleValuePriorityOne.getText().toString())) {

			return true;
		} else {
			return false;

		}

	}

}
