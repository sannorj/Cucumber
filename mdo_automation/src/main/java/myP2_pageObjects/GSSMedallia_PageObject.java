package myP2_pageObjects;

import java.time.Duration;
import java.util.ArrayList;
//import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.ConstantsReader;

//import com.google.j2objc.annotations.Property;

//import utils.ConfigReader;

public class GSSMedallia_PageObject {
	private WebDriver driver;
	ArrayList<String> propertyList = new ArrayList<>();
	boolean flag;
	private ConstantsReader configReader = new ConstantsReader();


	public GSSMedallia_PageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		flag = false;

		propertyList.add("Overall Score");
		propertyList.add("Breakfast/F&B Presentation");
		propertyList.add("Breakfast/F&B Variety of Choices");
		propertyList.add("Accuracy of Charges");
		propertyList.add("Staff Face Coverings % Yes");
		propertyList.add("Guestroom Decor");
		propertyList.add("Guestroom Smell");
		propertyList.add("Check-in");
		propertyList.add("Service");
		propertyList.add("Service Quality");

	}

	@FindBy(xpath = "//button[@data-el='menuToggle']")
	WebElement selector;

	@FindBy(xpath = "//div[text()='Reports']//ancestor::li")
	WebElement reports;

	@FindBy(xpath = "//div[text()='Guest Satisfaction']//ancestor::li")
	WebElement gss;

	@FindBy(xpath = "//div[text()='GSS Medallia']//ancestor::li")
	WebElement gssMedallia;

	@FindBy(xpath = "//h1[text()='GSS Medallia']")
	WebElement gssMedalliaPage;

	@FindBy(xpath = "//input[@id='mui-19851']")
	WebElement drpProperty;

	@FindBy(xpath = "//div[@id='mui-component-select-year']")
	WebElement drpYear;

	@FindBy(xpath = "//li[@data-value='%s']")
	WebElement listOfNumbers;
	
	@FindBy(xpath = "//div[@id='mui-component-select-year']")
	WebElement dropDownMedalliaYear;

	@FindBy(xpath = "//ul[@role='listbox']//li")
	List<WebElement> lstDropDownMedalliaYear;

	@FindBy(xpath = "//button[@data-el='buttonGo']")
	WebElement btnGo;

	@FindBy(xpath = "//input[@name='keyword']")
	WebElement txtSearch;

	@FindBy(xpath = "//th[@index=0]")
	WebElement tableProperty;

	@FindBy(xpath = "//td//input")
	List<WebElement> priorityDropdown;

	@FindBy(xpath = "//div[@role='button']")
	List<WebElement> priorityDropdownrB;

	@FindBy(xpath = "//li[@data-value=\'0\']")
	WebElement drpValue;

	@FindBy(xpath = "//li[@data-value]")
	List<WebElement> lstdrpValue;

	@FindBy(xpath = "//ul[@role=\'listbox\']")
	WebElement lstPriority;

	@FindBy(xpath = "//span[text()='Survey Responses']")
	WebElement surveyResponses;

	// Propert Dropdown List
	@FindBy(xpath = "//li[@role='option']")
	WebElement lstProperty;

	// error message
	@FindBy(xpath = "//div[@class='MuiAlert-icon']")
	WebElement msgError;

	public void expandGuestSatisfaction() {
		WebElement menu = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.visibilityOf(selector));
		menu.click();

		WebElement reportsEx = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.visibilityOf(reports));
		reportsEx.click();

		WebElement guestSatisfaction = new WebDriverWait(driver, Duration.ofSeconds(30))
				.until(ExpectedConditions.visibilityOf(gss));
		guestSatisfaction.click();

	}

	public boolean navigateToGssMedalliaPage() {

		WebElement gssMedalliaCL = new WebDriverWait(driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.visibilityOf(gssMedallia));
		gssMedalliaCL.click();

		WebElement gssMedalliaPageCL = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.visibilityOf(gssMedalliaPage));
		return gssMedalliaPageCL.isDisplayed();

	}
	
	public boolean loadMedalliaReport(String Keyword) {
		WebElement gssMedalliaPageCL = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.visibilityOf(gssMedalliaPage));

		gssMedalliaPageCL.isDisplayed();
		
		dropDownMedalliaYear.click();
		for(int i=0; i<lstDropDownMedalliaYear.size(); i++) {
			if(lstDropDownMedalliaYear.get(i).getText().equals(Keyword))
			{
				lstDropDownMedalliaYear.get(i).click();
				btnGo.click();
			}
		}
		
		WebElement homePage = new WebDriverWait(driver, Duration.ofSeconds(20))
				.until(ExpectedConditions.visibilityOf(tableProperty));
		return homePage.isDisplayed();
	}
	

	public boolean loadMedalliaReport() {
		WebElement gssMedalliaPageCL = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.visibilityOf(gssMedalliaPage));

		gssMedalliaPageCL.isDisplayed();
		
		dropDownMedalliaYear.click();
		for(int i=0; i<lstDropDownMedalliaYear.size(); i++) {
			if(lstDropDownMedalliaYear.get(i).getText().equals(configReader.getProp("MedalliaYear")))
			{
				lstDropDownMedalliaYear.get(i).click();
				btnGo.click();
			}
		}
		
		WebElement homePage = new WebDriverWait(driver, Duration.ofSeconds(50))
				.until(ExpectedConditions.visibilityOf(tableProperty));
		return homePage.isDisplayed();
	}

	public void setPriorityZero() throws InterruptedException {
		WebElement property = new WebDriverWait(driver, Duration.ofSeconds(50))
				.until(ExpectedConditions.visibilityOf(tableProperty));

		if (property.isDisplayed()) {

			for (int i = 1; i < priorityDropdownrB.size(); i++) {
				if (!priorityDropdownrB.get(i).getText().equals("0")) {
					priorityDropdownrB.get(i).click();

					WebElement DrpValue = new WebDriverWait(driver, Duration.ofSeconds(15))
							.until(ExpectedConditions.visibilityOf((WebElement) drpValue));

					DrpValue.isDisplayed();

					Thread.sleep(2500);
					lstdrpValue.get(0).click();

					Thread.sleep(1500);

				}
			}

		}

	}

	public void Search() throws InterruptedException {
		for (int i = 0; i < propertyList.size(); i++) {

			txtSearch.sendKeys(propertyList.get(i));
			Thread.sleep(2000);
			// WebElement response = new WebDriverWait(driver, Duration.ofSeconds(20))
			// .until(ExpectedConditions.visibilityOf((WebElement) surveyResponses));

			// if (response.isDisplayed()) {
			if (priorityDropdownrB.get(1).getText().equals("0")) {
				priorityDropdownrB.get(1).click();

				WebElement DrpValue = new WebDriverWait(driver, Duration.ofSeconds(15))
						.until(ExpectedConditions.visibilityOf((WebElement) drpValue));

				DrpValue.isDisplayed();

				lstdrpValue.get(i + 1).click();
				// txtSearch.sendKeys("");
				Thread.sleep(2000);

			}
			txtSearch.sendKeys(Keys.CONTROL + "a");
			txtSearch.sendKeys(Keys.DELETE);

			// }

		}

	}

	public boolean assignExistingPriority() {
		try {

			int count = 0;
			int index = 0;

			WebElement property = new WebDriverWait(driver, Duration.ofSeconds(15))
					.until(ExpectedConditions.visibilityOf(tableProperty));

			if (property.isDisplayed()) {
				for (int i = 1; i < priorityDropdownrB.size(); i++) {
					if (!priorityDropdownrB.get(i).getText().equals("1")) {

						count++;
						index = i;
					}
				}

				if (count > 0) {
					priorityDropdownrB.get(index).click();
					Thread.sleep(1500);

					WebElement DrpValue = new WebDriverWait(driver, Duration.ofSeconds(15))
							.until(ExpectedConditions.visibilityOf((WebElement) drpValue));

					DrpValue.isDisplayed();

					lstdrpValue.get(1).click();

					Thread.sleep(2500);

					WebElement errorMsg = new WebDriverWait(driver, Duration.ofSeconds(15))
							.until(ExpectedConditions.visibilityOf(msgError));

					flag = errorMsg.isDisplayed();

				} else {
					flag = false;
				}

			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return flag;
	}

}
