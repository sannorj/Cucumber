package myP1_pageObjects;

import java.time.*;
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

public class propertyDashboard_AddComment_PageObjects {

	private WebDriver driver;
	private ConstantsReader configReader = new ConstantsReader();

	public propertyDashboard_AddComment_PageObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[@title='Refresh']")
	WebElement btnRefresh;

	@FindBy(xpath = "//input[@id='btnAddComment']")
	WebElement btnAddComment;

	@FindBy(xpath = "//form[@id='formAddComment']//h4[text()='Add Comments']")
	WebElement addCommentPopupHeading;

	@FindBy(xpath = "//div[@id='s2id_ddlTagsSelect']")
	WebElement selectAddTags;

	@FindBy(xpath = "//ul[@class='select2-result-sub']//li//div")
	List<WebElement> lstDropDowAddTags;

	@FindBy(xpath = "//div[@id='s2id_ddlUsersTagsSelect']")
	WebElement selectTagUsers;

	@FindBy(xpath = "//ul[@class='select2-result-sub']//li//div")
	List<WebElement> lstDropDowTagUsers;

	@FindBy(xpath = "//textarea[@id='txtCommentDescription']")
	WebElement fillComment;

	@FindBy(xpath = "//button[@id='submitAddComment']")
	WebElement addCommentSubmitBtn;

	@FindBy(xpath = "//form[@id='formAddComment']//button[text()='Close']")
	WebElement addCommentCloseBtn;

	@FindBy(xpath = "//div[@id='divCommentsuccess']")
	WebElement CommentSuccess;

	@FindBy(xpath = "//div[@id='formAddCommentBody']//a[@id='alnkallComments']")
	WebElement viewPastComments;

	@FindBy(xpath = "//h2[text()='View Comments']")
	WebElement viewCommentsPage;

	@FindBy(xpath = "//div[@id='datatable-comment-container_filter']//input")
	WebElement viewCommentsPageSearch;

	@FindBy(xpath = "//table[@id='datatable-comment-container']//tbody//tr")
	List<WebElement> viewCommentsPageTblraw;

	public void clickAddComment() throws InterruptedException {
		WebElement waittoBtnAddComment = new WebDriverWait(driver, Duration.ofSeconds(700))
				.until(ExpectedConditions.visibilityOf(btnAddComment));
		waittoBtnAddComment.click();
	}

	public boolean verifyCommentPopup() {
		WebElement AddCommentPopup = new WebDriverWait(driver, Duration.ofSeconds(100))
				.until(ExpectedConditions.visibilityOf(addCommentPopupHeading));
		boolean AddCommentPopupFlag = AddCommentPopup.isDisplayed();
		System.out.println("Add Comment popup is displayed: " + AddCommentPopupFlag);
		return AddCommentPopupFlag;
	}

	public void FillData() throws InterruptedException {
		selectAddTags.click();
		Thread.sleep(2000);
		for (int i = 0; i < lstDropDowAddTags.size(); i++) {
			if (lstDropDowAddTags.get(i).getText().equalsIgnoreCase(configReader.getProp("Add_comment_Tags"))) {
				System.out.println("add tags list item ===" + lstDropDowAddTags.get(i).getText());
				lstDropDowAddTags.get(i).click();
			}
		}
		selectTagUsers.click();
		Thread.sleep(2000);

		for (int i = 0; i < lstDropDowTagUsers.size(); i++) {
			if (lstDropDowTagUsers.get(i).getText().equalsIgnoreCase(configReader.getProp("Add_comment_TagUsers"))) {
				System.out.println("Tag Users list item ===" + lstDropDowTagUsers.get(i).getText());
				lstDropDowTagUsers.get(i).click();
			}
		}
		Thread.sleep(3000);
		fillComment.sendKeys(Keys.CONTROL + "a");
		fillComment.sendKeys(Keys.DELETE);
		fillComment.sendKeys(configReader.getProp("Add_comment_CommentVal"));
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
		if (isDataSubmitted) {
			addCommentCloseBtn.click();
			btnRefresh.click();
			Thread.sleep(7000);
			WebElement viewComments = new WebDriverWait(driver, Duration.ofSeconds(100))
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='"+ configReader.getProp("Comment_added_panel")+ "']//following::div//div[@class='row no-gutters']//div[@class='row no-gutters']//div//div")));
			if (viewComments.isDisplayed()) {
			List<WebElement> addedCommentsList = driver.findElements(By.xpath("//h2[text()='"+ configReader.getProp("Comment_added_panel")+ "']//following::div//div[@class='row no-gutters']//div[@class='row no-gutters']//div//div"));

			Thread.sleep(3000);
			for (int i = 0; i < addedCommentsList.size(); i++) {
				if (addedCommentsList.get(i).getText()
						.equalsIgnoreCase(configReader.getProp("Add_comment_CommentVal"))) {
					System.out.println("Resently added comment : " + addedCommentsList.get(i).getText());
				}
			}
			}
		}
		return isDataSubmitted;
	}

	public void clickViewPastComment() throws InterruptedException {
		btnAddComment.click();
		viewPastComments.click();
		Thread.sleep(3000);
	}

	public boolean navigateViewCommentPage() {
		String currentTab = driver.getWindowHandle();
		for (String tab : driver.getWindowHandles()) {
		    if (!tab.equals(currentTab)) {
		        driver.switchTo().window(tab); 
		    }       
		}
		WebElement ViewCommentPage = new WebDriverWait(driver, Duration.ofSeconds(100))
				.until(ExpectedConditions.visibilityOf(viewCommentsPage));
		boolean isViewCommentPage = ViewCommentPage.isDisplayed();
		System.out.println("View Comments Page is displayed: " + isViewCommentPage);
		return isViewCommentPage;
	}

	public boolean checkSubmittedData() throws InterruptedException {
		viewCommentsPageSearch.sendKeys(Keys.CONTROL + "a");
		viewCommentsPageSearch.sendKeys(Keys.DELETE);
		viewCommentsPageSearch.sendKeys(configReader.getProp("Add_comment_CommentVal"));

		for (int i = 1; i <= viewCommentsPageTblraw.size(); i++) {
			boolean addedCommentIsExist = false;
			Thread.sleep(3000);
			String user = driver
					.findElement(By.xpath("(//table[@id='datatable-comment-container']//tbody//tr)[" + i + "]//td[1]"))
					.getText();

			String hotelName = driver
					.findElement(By.xpath("(//table[@id='datatable-comment-container']//tbody//tr)[" + i + "]//td[2]"))
					.getText();

			String tags = driver
					.findElement(
							By.xpath("(//table[@id='datatable-comment-container']//tbody//tr)[" + i + "]//td[4]//span"))
					.getText();

			String comments = driver
					.findElement(By.xpath("(//table[@id='datatable-comment-container']//tbody//tr)[" + i + "]//td[5]"))
					.getText();
			Thread.sleep(3000);

			String userPropVal = configReader.getProp("View_comment_user");

			String hotelNamePropVal = configReader.getProp("Property_dashboard_hotel");

			String tagsPropVal = configReader.getProp("Add_comment_Tags");

			String commentsPropVal = configReader.getProp("Add_comment_CommentVal");

			if (userPropVal.equalsIgnoreCase(user)) {
				System.out.println("User column value is equal to ==== " + user);
				addedCommentIsExist = true;
			}
			if (hotelNamePropVal.equalsIgnoreCase(hotelName)) {
				System.out.println("Hotel Name column value is equal to ==== " + hotelName);
				addedCommentIsExist = true;
			}
			if (tagsPropVal.equalsIgnoreCase(tags)) {
				System.out.println("Tags column value is equal to ==== " + tags);
				addedCommentIsExist = true;
			}
			if (commentsPropVal.equalsIgnoreCase(comments)) {
				System.out.println("Comments column value is equal to ==== " + comments);
				addedCommentIsExist = true;
			}
			if (addedCommentIsExist)
				return true;
		}
		return false;

	}
}
