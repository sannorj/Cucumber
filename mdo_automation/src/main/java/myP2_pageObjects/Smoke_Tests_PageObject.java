package myP2_pageObjects;

import java.text.DecimalFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Calendar;
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

import utils.ConstantsReader;
import utils.ElementUtils;

public class Smoke_Tests_PageObject {

	private WebDriver driver;
	private ConstantsReader configReader = new ConstantsReader();
	boolean flag;

	public Smoke_Tests_PageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath = "//span[text()='Groups']")
	WebElement groupHeader;
	
	@FindBy(xpath = "//button[@title='Add Comment']")
	WebElement btnAddComment;
	
	@FindBy(xpath = "//div/input[@name='hotelId']")
	WebElement drpHotelDrp;
	
	@FindBy(xpath = "//button[@data-el='buttonXCancel']")
	WebElement closeButton;
	
	@FindBy(xpath = "//button[@data-el='buttonClose']")
	WebElement closeButt;
	
	@FindBy(xpath = "//div/input[@name='porfolio-hotel']")
	WebElement drpProperty;
	
	@FindBy(xpath = "//div[@role='listbox']//li")
	List<WebElement> listDrpValueSize;
	
	@FindBy(xpath = "//div[text()='Property']")
	WebElement lblProperty;
	
	@FindBy(xpath = "//button[@data-el='buttonComments']")
	WebElement btnMainComment;
	
	@FindBy(xpath = "//h1[text()='Comments']")
	WebElement titleComment;
	
	@FindBy(xpath = "//button[@data-el='buttonFinishCustomization']")
	WebElement imDoneButton;
	
	@FindBy(xpath = "//button[@data-el='buttonCopyDashboardSettings']")
	WebElement copyDashButton;
	
	@FindBy(xpath = "//div[text()='Copy Dashboard Settings']")
	WebElement copyDash;
	
	@FindBy(xpath = "//div[@data-el='chartCardTitleDiv']")
	WebElement widgetsHeader;
	
	@FindBy(xpath = "//button[@data-el='buttonCommissions']")
	WebElement commissionsCal;
	
	@FindBy(xpath = "//h1[text()='Commissions Calculator']")
	WebElement commissionsCalHeader;
	
	@FindBy(xpath = "//span[text()='Cancel']")
	WebElement cancelButt;
	
	@FindBy(xpath = "//button[@data-el='buttonOpenFilters']")
	WebElement filterOptButt;
	
	@FindBy(xpath = "//div[text()='Filters']")
	WebElement verifyFilterHeader;
	
	
	public void verifyPrimaryDashHeader() throws InterruptedException {

		Thread.sleep(3000);
		
		WebElement drpPropertyEle = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(drpProperty));
		drpPropertyEle.click();

		for (int i = 0; i < listDrpValueSize.size(); i++) {
			if (listDrpValueSize.get(i).getText().equalsIgnoreCase(configReader.getProp("Verify_Primary_Dash_header_All"))) {
				listDrpValueSize.get(i).click();
			}
		}

		Thread.sleep(5000);

		WebElement groupHeaderEle = new WebDriverWait(driver, Duration.ofSeconds(25)).until(ExpectedConditions.visibilityOf(groupHeader));
		groupHeaderEle.isDisplayed();

	}
	
	public boolean verifyAddCommentSection() throws InterruptedException {
		
		Thread.sleep(3000);
		
		WebElement drpPropertyEle = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(drpProperty));
		drpPropertyEle.click();

		for (int i = 0; i < listDrpValueSize.size(); i++) {
			if (listDrpValueSize.get(i).getText().equalsIgnoreCase(configReader.getProp("Verify_Add_Comment_section"))) {
				listDrpValueSize.get(i).click();
			}
		}

		Thread.sleep(5000);
		
		WebElement btnAddCommentEle = new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(btnAddComment));
		btnAddCommentEle.click();
		
		Thread.sleep(2000);
		
		WebElement drpHotelDrpEle = new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(drpHotelDrp));
		String hotel = drpHotelDrpEle.getAttribute("value");
		
		if(hotel.equals(configReader.getProp("Verify_Add_Comment_section")) ) {
			
			Thread.sleep(2000);
			
			WebElement closeButt = new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(closeButton));
			closeButt.click();
			
			Thread.sleep(5000);
			
			return true;
		}else {
			return false;
		}
		
	}
	
	public void viewCommentsSection() throws InterruptedException {

		Thread.sleep(2500);
		ElementUtils.waitForElementToDisplay(lblProperty, 100);
		WebElement btnMainCommentEle = new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(btnMainComment));
		btnMainCommentEle.click();

		/* waiting for Comment title to visible */
		ElementUtils.waitForElementToDisplay(titleComment, 100);
		
		Thread.sleep(3000);
		
		WebElement imDoneButtEle = new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(imDoneButton));
		imDoneButtEle.click();
		
		Thread.sleep(5000);

	}
	
	public void clickCloseButt() throws InterruptedException {
		
		Thread.sleep(2000);
			
		WebElement closeButtEle = new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(closeButt));
		closeButtEle.click();
			
		Thread.sleep(5000);
		
	}
	
	public void copyDashboard() throws InterruptedException {

		Thread.sleep(3000);
		
		WebElement copyDashButtonElement = new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(copyDashButton));
		copyDashButtonElement.click();
		
		Thread.sleep(3000);

		WebElement copyDashboardEle = new WebDriverWait(driver, Duration.ofSeconds(25)).until(ExpectedConditions.visibilityOf(copyDash));
		copyDashboardEle.isDisplayed();
		
		Thread.sleep(2000);
		
		WebElement closeButt = new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(closeButton));
		closeButt.click();
		
		Thread.sleep(5000);

	}
	
	public void verifyTdWidgetsHeader() throws InterruptedException {

		Thread.sleep(5000);

		WebElement widgetsHeaderEle = new WebDriverWait(driver, Duration.ofSeconds(25)).until(ExpectedConditions.visibilityOf(widgetsHeader));
		widgetsHeaderEle.isDisplayed();

	}
	
	public void verifyCommissionsCal() throws InterruptedException {

		Thread.sleep(5000);

		if (commissionsCal.isEnabled()) {
			WebElement commissionsCalEle = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(commissionsCal));
			commissionsCalEle.click();
			
		}

		Thread.sleep(3000);

		WebElement commissionsCalHeaderEle = new WebDriverWait(driver, Duration.ofSeconds(25)).until(ExpectedConditions.visibilityOf(commissionsCalHeader));
		commissionsCalHeaderEle.isDisplayed();
		
		Thread.sleep(3000);
		
		WebElement closeButt = new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(closeButton));
		closeButt.click();
		
	}
	
	public void cancelButtClick() throws InterruptedException {
		
		Thread.sleep(2000);
		
		WebElement cancelButtEle = new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(cancelButt));
		cancelButtEle.click();
		
		Thread.sleep(5000);

	}
	
	public void verifyFilterOpt() throws InterruptedException {

		Thread.sleep(5000);

		if (filterOptButt.isEnabled()) {
			WebElement filterOptButtEle = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(filterOptButt));
			filterOptButtEle.click();
		}

		Thread.sleep(3000);

		WebElement verifyFilterHeaderEle = new WebDriverWait(driver, Duration.ofSeconds(25)).until(ExpectedConditions.visibilityOf(verifyFilterHeader));
		verifyFilterHeaderEle.isDisplayed();
		
		Thread.sleep(3000);
		
	}

	

}
