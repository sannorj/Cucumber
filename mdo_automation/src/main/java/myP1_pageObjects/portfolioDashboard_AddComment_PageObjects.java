package myP1_pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.ConstantsReader;

public class portfolioDashboard_AddComment_PageObjects {
	private WebDriver driver;
	private ConstantsReader configReader = new ConstantsReader();

	public portfolioDashboard_AddComment_PageObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@id='btnAddCommentportfolio']")
	WebElement addCommentBtn;
	
	@FindBy(xpath = "//form[@id='formAddComment_1']")
	WebElement addCommentFrm;

	@FindBy(xpath = "//div[@id='formAddCommentBody']//a[@id='alnkallComments']")
	WebElement viewPastComments;

	@FindBy(xpath = "//div[@id='s2id_ddlHotelsComments_1']")
	WebElement selectHotel;
	
	@FindBy(xpath = "//select[@id='ddlHotelsComments_1']")
	WebElement selectHotelOpt;
	
	@FindBy(xpath = "//span[@id='select2-chosen-4']")
	WebElement hotelName;
	
	@FindBy(xpath = "//select[@id='ddlHotelsComments_1']//option")
	WebElement hotelNameOpt;

	@FindBy(xpath = "//select[@id='ddlHotelsComments_1']//option[2]")
	WebElement hotelOptView;

//	@FindBy(xpath = "//form[@id='formAddComment_1']//h4[text()='Add Comments']")
//	WebElement addCommentLbl;
	
	
	
	public boolean clickAddComment() {
		addCommentBtn.click();
		return true;
	}

	public boolean verifyAddCommentPopup() throws InterruptedException {
		WebElement addCommentFrmView = new WebDriverWait(driver, Duration.ofSeconds(100))
				.until(ExpectedConditions.visibilityOf(addCommentFrm));
		if(addCommentFrmView.isDisplayed())
			return true;
		else
			return false;
	}
	
	public boolean selectHotel() throws InterruptedException {
		WebElement hotelNameoptView = new WebDriverWait(driver, Duration.ofSeconds(700))
				.until(ExpectedConditions.visibilityOf(hotelOptView));
		selectHotel.click();
		Select HotelSelectOpt = new Select(selectHotelOpt);
		HotelSelectOpt.selectByVisibleText(configReader.getMYP1Prop("Property_dashboard_hotel"));
		
		WebElement hotelNameView = new WebDriverWait(driver, Duration.ofSeconds(100))
				.until(ExpectedConditions.visibilityOf(hotelName));
		Thread.sleep(7000);
		if (hotelNameView.isDisplayed()) {
			return true;
		}else {
			return false;
		}
		
	}

	public void clickViewPastComment() throws InterruptedException {
		addCommentBtn.click();
		viewPastComments.click();
		Thread.sleep(3000);
	}


}
