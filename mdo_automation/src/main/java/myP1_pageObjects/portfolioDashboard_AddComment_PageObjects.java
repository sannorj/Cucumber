package myP1_pageObjects;

import java.time.Duration;
import java.util.List;

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

	@FindBy(xpath = "//button[@title='Refresh']")
	WebElement btnRefresh;

//	@FindBy(xpath = "//form[@id='formAddComment_1']//h4[text()='Add Comments']")
//	WebElement addCommentLbl;

	@FindBy(xpath = "//div[@id='s2id_ddlTagsSelect_1']")
	WebElement selectAddTags;

	@FindBy(xpath = "//ul[@class='select2-result-sub']//li//div")
	List<WebElement> lstDropDowAddTags;

	@FindBy(xpath = "//div[@id='s2id_ddlUsersTagsSelect_1']")
	WebElement selectTagUsers;

	@FindBy(xpath = "//ul[@class='select2-result-sub']//li//div")
	List<WebElement> lstDropDowTagUsers;

	@FindBy(xpath = "//textarea[@id='txtCommentDescription_1']")
	WebElement fillComment;

	@FindBy(xpath = "//button[@id='submitAddComment_1']")
	WebElement addCommentSubmitBtn;

	@FindBy(xpath = "//div[@id='divCommentsuccess_1']")
	WebElement CommentSuccess;

	@FindBy(xpath = "//form[@id='formAddComment']//button[text()='Close']")
	WebElement addCommentCloseBtn;
	
	@FindBy(xpath = "//div[@id='formAddCommentBody_1']//a[@id='alnkallComments']")
	WebElement viewPastComments;
	
	
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
	
	public void FillData() throws InterruptedException {
		Thread.sleep(2000);
		selectAddTags.click();
		Thread.sleep(2000);
		for (int i = 0; i < lstDropDowAddTags.size(); i++) {
			if (lstDropDowAddTags.get(i).getText().equalsIgnoreCase(configReader.getMYP1Prop("Add_comment_Tags"))) {
				System.out.println("add tags list item ===" + lstDropDowAddTags.get(i).getText());
				lstDropDowAddTags.get(i).click();
			}
		}
		Thread.sleep(5000);
		System.out.println(lstDropDowTagUsers.size());
		selectTagUsers.click();

		for (int i = 0; i < lstDropDowTagUsers.size(); i++) {
			if (lstDropDowTagUsers.get(i).getText().equalsIgnoreCase(configReader.getMYP1Prop("Add_comment_TagUsers"))) {
				System.out.println("Tag Users list item ===" + lstDropDowTagUsers.get(i).getText());
				lstDropDowTagUsers.get(i).click();
			}
		}
		Thread.sleep(3000);
		fillComment.sendKeys(Keys.CONTROL + "a");
		fillComment.sendKeys(Keys.DELETE);
		fillComment.sendKeys(configReader.getMYP1Prop("Add_comment_CommentVal"));
		Thread.sleep(3000);
	}

	public void clickAddCommentSubmit() throws InterruptedException {
		addCommentSubmitBtn.click();
		Thread.sleep(3000);
	}
	public boolean dataIsSubmited() throws InterruptedException {
		WebElement submitSuccessMsg = new WebDriverWait(driver, Duration.ofSeconds(700))
				.until(ExpectedConditions.visibilityOf(CommentSuccess));
		boolean isDataSubmitted = submitSuccessMsg.isDisplayed();
		System.out.println("Your Comment added successfully.==" + isDataSubmitted);
		return isDataSubmitted;
	}

	public void clickViewPastComment() throws InterruptedException {
		addCommentBtn.click();
		viewPastComments.click();
		Thread.sleep(3000);
	}


}
