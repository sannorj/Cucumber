package myP1_pageObjects;

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

public class scorecardDashboard_AddComment_pageObjects {

	private WebDriver driver;
	private ConstantsReader configReader = new ConstantsReader();

	public scorecardDashboard_AddComment_pageObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@id='divCommentsuccess']")
	WebElement CommentSuccess;

	@FindBy(xpath = "//div[@id='s2id_ddlTagsSelect']")
	WebElement selectAddTags;

	@FindBy(xpath = "//ul[@class='select2-result-sub']//li//div")
	List<WebElement> lstDropDowAddTags;

	@FindBy(xpath = "//textarea[@id='txtCommentDescription']")
	WebElement fillComment;

	@FindBy(xpath = "//button[@id='submitAddComment']")
	WebElement addCommentSubmitBtn;

	@FindBy(xpath = "//form[@id='formAddComment']//button[text()='Close']")
	WebElement addCommentCloseBtn;

	@FindBy(xpath = "//div[@id='formAddCommentBody']//a[@id='alnkallComments']")
	WebElement viewPastComments;

	@FindBy(xpath = "//input[@id='btnAddComment']")
	WebElement btnAddComment;

	public boolean verifySubmitted() {
		WebElement submitSuccessMsg = new WebDriverWait(driver, Duration.ofSeconds(700))
				.until(ExpectedConditions.visibilityOf(CommentSuccess));
		boolean isDataSubmitted = submitSuccessMsg.isDisplayed();
		System.out.println("Your Comment added successfully.==" + isDataSubmitted);
		return isDataSubmitted;
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
		Thread.sleep(3000);
		fillComment.sendKeys(Keys.CONTROL + "a");
		fillComment.sendKeys(Keys.DELETE);
		fillComment.sendKeys(configReader.getMYP1Prop("Add_comment_CommentVal"));
		Thread.sleep(3000);
	}

	public void clickViewPastComment() throws InterruptedException {
		Thread.sleep(3000);
		btnAddComment.click();
		Thread.sleep(3000);
		viewPastComments.click();
		Thread.sleep(3000);
	}
	
}
