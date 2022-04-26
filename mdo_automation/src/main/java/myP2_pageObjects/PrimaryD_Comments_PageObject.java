package myP2_pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.ConstantsReader;
import utils.ElementUtils;

public class PrimaryD_Comments_PageObject {
	
	private WebDriver driver;	
	private ConstantsReader configReader = new ConstantsReader();
	boolean flag;
	
	public PrimaryD_Comments_PageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath = "//div/input[contains(@name, 'porfolio-group')]")
	WebElement drpGroup;
	
	@FindBy(xpath = "//ul[@role='listbox']//li")
	List <WebElement> listDrpValueSize;
	
	@FindBy(xpath = "//input[@name='date']")
	WebElement txtDate;
	
	@FindBy(xpath = "//input[@name='startDate']")
	WebElement txtStartDate;
	
	@FindBy(xpath = "//input[@name='endDate']")
	WebElement txtEndDate;
	
	@FindBy(xpath = "//div/input[@name='porfolio-hotel']")
	WebElement drpProperty;
	
	@FindBy(xpath = "//button[@title='Add Comment']")
	WebElement btnAddComment;
	
	@FindBy(xpath = "//div/input[@name='hotelId']")
	WebElement drpHotelDrp;
	
	@FindBy(xpath = "//div/input[@name='kpiId']")
	WebElement drpKpi;
	
	@FindBy(xpath = "//textarea[@name='message']")
	WebElement txtCommentBox;
	
	@FindBy(xpath = "//th[text()='Property']")
	WebElement lblProperty;
	
	@FindBy(xpath = "//th[text()='Groups']")
	WebElement lblGroup;
	
	@FindBy(xpath = "//button[@class='MuiButtonBase-root MuiButton-root MuiButton-text sc-gKXOVf llAzkm tbutton']")
	WebElement btnSubmit;
	
	@FindBy(xpath = "//div[@class='sc-hKMtZM MgHPv']")
	WebElement btnMainComment;
	
	@FindBy(xpath = "//span[text()='Comment']")
	WebElement titleComment;
	
	@FindBy(xpath = "//label[@class='sc-bjUoiL nDYYA']")
	WebElement lblCommenttxt;
	
	

	public void selectParameters() throws InterruptedException {

		ElementUtils.waitForElementToDisplay(lblGroup, 100);

		if (drpGroup.isEnabled()) {
			/* Select the appropriate Group value from the drop-down menu. */
			WebElement drpGroupEle = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(drpGroup));
			drpGroupEle.click();

			ExpectedConditions.visibilityOf(listDrpValueSize.get(0));
			for (int i = 0; i < listDrpValueSize.size(); i++) {
				if (listDrpValueSize.get(i).getText().equalsIgnoreCase(configReader.getProp("Group"))) {
					listDrpValueSize.get(i).click();
				}
			}
		}

		ElementUtils.waitForElementToDisplay(lblGroup, 100);

		if (drpProperty.isEnabled()) {
			WebElement drpPropertyEle = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(drpProperty));
			drpPropertyEle.click();

			ExpectedConditions.visibilityOf(listDrpValueSize.get(1));
			for (int i = 0; i < listDrpValueSize.size(); i++) {
				if (listDrpValueSize.get(i).getText().equalsIgnoreCase(configReader.getProp("Propery"))) {
					listDrpValueSize.get(i).click();
				}
			}
		}
		ElementUtils.waitForElementToDisplay(lblProperty, 100);

		txtDate.sendKeys(Keys.CONTROL + "a");
		txtDate.sendKeys(Keys.DELETE);
		txtDate.sendKeys(configReader.getProp("Date"));

		ElementUtils.waitForElementToDisplay(lblProperty, 100);

	}
	
	public boolean clickAddIconFunc() {
		
		WebElement btnAddCommentEle = new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(btnAddComment));
		btnAddCommentEle.click();
		
		WebElement drpHotelDrpEle = new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(drpHotelDrp));
		String hotel = drpHotelDrpEle.getAttribute("value");
		
		if(hotel.equals(configReader.getProp("Propery")) ) {
			return true;
		}else {
			return false;
		}
		
	}
	
	
	public void inputCommentParametersFunc() throws InterruptedException {
		
		ElementUtils.waitForElementToDisplay(drpKpi, 100);
		drpKpi.click();
		drpKpi.sendKeys(configReader.getProp("Kpi"));
		ExpectedConditions.visibilityOf(listDrpValueSize.get(1));
		for (int i = 0; i < listDrpValueSize.size(); i++) {
			if (listDrpValueSize.get(i).getText().equalsIgnoreCase(configReader.getProp("Kpi"))) {
				Thread.sleep(1000);
				listDrpValueSize.get(i).click();
			}
		}
		
		WebElement txtStartDateEle = new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(txtStartDate));
		txtStartDateEle.click();
		txtStartDateEle.sendKeys(Keys.CONTROL + "a");
		txtStartDateEle.sendKeys(Keys.DELETE);
		txtStartDateEle.sendKeys(configReader.getProp("Date"));
		
	    WebElement txtEndDateEle = new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(txtEndDate));
		txtEndDateEle.click();
		txtEndDateEle.sendKeys(Keys.CONTROL + "a");
		txtEndDateEle.sendKeys(Keys.DELETE);
		txtEndDateEle.sendKeys(configReader.getProp("Date"));
		
		WebElement txtCommentBoxeEle = new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(txtCommentBox));
		txtCommentBoxeEle.sendKeys(configReader.getProp("Comment"));
	
		WebElement btnSubmitEle = new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(btnSubmit));
		btnSubmitEle.click();
		ElementUtils.waitForElementToHide(btnSubmitEle, 100);
		
	}
	
	
	public boolean verifyNewlyAddedcommentFunc() throws InterruptedException {
		
		Thread.sleep(2500);
		WebElement btnMainCommentEle = new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(btnMainComment));
		btnMainCommentEle.click();
		
		/* waiting for Comment title to visible  */
		ElementUtils.waitForElementToDisplay(titleComment, 100);
		String CommentContext =lblCommenttxt.getAttribute("label");
		
		if(CommentContext.equals(configReader.getProp("Comment")) ) {
			return true;
		}else {
			return false;
		}
		
	}

}
