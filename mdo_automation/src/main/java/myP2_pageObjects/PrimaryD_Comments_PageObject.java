package myP2_pageObjects;

import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
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
	
	@FindBy(xpath = "//div[@role='listbox']//li")
	List <WebElement> listDrpValueSize;
	
	@FindBy(xpath = "//ul[@role='listbox']//li")
	List <WebElement> listCommentDrp;
	
	@FindBy(xpath = "//label[text()='Date']//parent::div//input")
	WebElement txtDate;
	
	@FindBy(xpath = "//label[text()='From Date']//parent::div//input")
	WebElement txtStartDate;
	
	@FindBy(xpath = "//label[text()='To Date']//parent::div//input")
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
	
	@FindBy(xpath = "//div[text()='Property']")
	WebElement lblProperty;
	
	@FindBy(xpath = "//th[text()='Groups']")
	WebElement lblGroup;
	
	@FindBy(xpath = "//span[text()='Submit']//parent::button[contains(@class, 'MuiButton-root MuiButton-text')]")
	WebElement btnSubmit;

	@FindBy(xpath = "//button[@data-el='buttonComments']")
	WebElement btnMainComment;
	
	@FindBy(xpath = "//h1[text()='Comments']")
	WebElement titleComment;
	
	@FindBy(xpath = "(//div[@data-el='mainLayoutCardContainer']/div/div/div/label)[2]")
	WebElement lblCommenttxt;
	
	@FindBy(xpath = "//span[@data-el='linkActionsView All Comments']")
	WebElement btnViewAllComment;
	
	@FindBy(xpath = "(//label[@class='sc-bjUoiL nDYYA'])[1]")
	WebElement lblLatestComment;
	
	@FindBy(xpath = "//h1[text()='Comments']")
	WebElement lblAllCommentsHeader;
	
	@FindBy(xpath = "//div/input[@name='hotelId']")
	WebElement drpViewAllCommentProperty;
	
	@FindBy(xpath = "(//input[@name='reply'])[1]")
	WebElement txtReplyBox;
	
	@FindBy(xpath = "(//div[contains(text(),'BSB - Feature of a')])[1]")
	WebElement lblFirstReplyComment;
	
	@FindBy(xpath = "(//button[@data-el='buttonSubmitReply'])[1]")
	WebElement btnReplySubmint;
	
	@FindBy(xpath = "(//label[@class='sc-bjUoiL gyZfAO'])[1]")
	WebElement lblReplyUser;
	
	@FindBy(xpath = "(//label[@class='sc-bjUoiL ebTZpj'])[1]")
	WebElement lblReplyProperty;
	
	@FindBy(xpath = "//div[@id='mui-component-select-commentStatusId']")
	WebElement drpStatus;
	
	@FindBy(xpath = "(//label[@label='Resolve'])[1]")
	WebElement btnResolve;
	
	@FindBy(xpath = "(//label[@label='Mark Active'])[1]")
	WebElement btnActive;
	
	@FindBy(xpath = "(//label[@label='Mark Active'])[1]")
	WebElement btnMarkActive;
	
	@FindBy(xpath = "//div//label[text() = 'Date'] //following-sibling::div//button")
	WebElement btnDatePicker;

	@FindBy(xpath = "//div[@role='dialog']")
	WebElement divCalender;

	@FindBy(xpath = "//div[@role='presentation']//button[contains(@aria-label, 'calendar view is open, switch to year view')]")
	WebElement btnExpandYear;

	@FindBy(xpath = "//div[contains(@class, 'MuiPickersArrowSwitcher')]//button[@title='Previous month']")
	WebElement btnPreviousMonth;

	@FindBy(xpath = "//div[contains(@class, 'MuiPickersArrowSwitcher')]//button[@title='Next month']")
	WebElement btnNextMonth;
	
	
	public int getMonth() {
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int month = cal.get(Calendar.MONTH);

		return month + 1;
	}

	public void validateOkCancelandClick() {
		int btnStatus = driver.findElements(By.xpath("//button[text()='OK']")).size();

		if (btnStatus > 0) {
			WebElement btnOk = driver.findElement(By.xpath("//button[text()='OK']"));
			btnOk.click();
		}

	}

	public boolean selectDate() throws InterruptedException {
		boolean flag = false;
		String[] dateForPicker = configReader.getProp("Date").split("/");

		txtDate.click();

		int btnDatePickforLocal = driver.findElements(By.xpath("//div//label[text() = 'Date'] //following-sibling::div//button")).size();

		if (btnDatePickforLocal > 0) {
			btnDatePicker.click();
		}

		int status = driver.findElements(By.xpath("//div[@role='dialog']")).size();

		if (status == 1) {

			WebElement expandYear = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(btnExpandYear));
			expandYear.click();

			Thread.sleep(2500);

			WebElement pickYear = driver.findElement(By.xpath("//div[contains(@class, 'PrivatePickersYear')]//button [contains(text(), '"+ dateForPicker[2] + "')]"));
			pickYear.click();
			Thread.sleep(2500);

			int monthInnum = getMonth();

			int monthDiff = monthInnum - Integer.parseInt(dateForPicker[0]);

			if (monthDiff > 0) {
				for (int i = 0; i < monthDiff; i++) {
					WebElement btnPrevious = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(btnPreviousMonth));

					btnPrevious.click();
					Thread.sleep(1500);

				}
				WebElement btnDate = driver.findElement(By.xpath(" //div[@role='row']//button[text() = '" + dateForPicker[1] + "']"));
				btnDate.click();
				validateOkCancelandClick();

				flag = true;
			}

			else if (monthDiff < 0) {
				for (int i = 0; i > monthDiff; i--) {
					WebElement btnNext = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(btnNextMonth));

					btnNext.click();
					Thread.sleep(1500);
				}
				
				WebElement btnDate = driver.findElement(By.xpath(" //div[@role='row']//button[text() = '" + dateForPicker[1] + "']"));
				btnDate.click();
				validateOkCancelandClick();
				
				flag = true;
			}

			else {
				WebElement btnDate = driver.findElement(By.xpath(" //div[@role='row']//button[text() = '" + dateForPicker[1] + "']"));
				btnDate.click();
				validateOkCancelandClick();
				
				flag = true;
			}

		} else {
			flag = false;
		}

		return flag;

	}
	
	
	public void selectParameters() throws InterruptedException {

		Thread.sleep(5000);
		
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

		Thread.sleep(5000);

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
		selectDate();
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
		Thread.sleep(5000);
		drpKpi.sendKeys(configReader.getProp("Kpi"));
		
		ExpectedConditions.visibilityOf(listCommentDrp.get(0));
		
		for (int i = 0; i < listCommentDrp.size(); i++) {
			if (listCommentDrp.get(i).getText().equalsIgnoreCase(configReader.getProp("Kpi"))) {
				Thread.sleep(1000);
				listCommentDrp.get(i).click();
			}
		}
		
		
		WebElement txtCommentBoxeEle = new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(txtCommentBox));
		txtCommentBoxeEle.sendKeys(configReader.getProp("Comment"));
	
		WebElement btnSubmitEle = new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(btnSubmit));
		btnSubmitEle.click();
		ElementUtils.waitForElementToHide(btnSubmitEle, 100);
		
	}
	
	
	public boolean verifyNewlyAddedcommentFunc() throws InterruptedException {

		Thread.sleep(2500);
		ElementUtils.waitForElementToDisplay(lblProperty, 100);
		WebElement btnMainCommentEle = new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(btnMainComment));
		btnMainCommentEle.click();

		/* waiting for Comment title to visible */
		ElementUtils.waitForElementToDisplay(titleComment, 100);
		Thread.sleep(15000);
		String CommentContext = lblCommenttxt.getAttribute("label");

		if (CommentContext.equals(configReader.getProp("Comment"))) {
			return true;
		} else {
			return false;
		}

	}
	
	public boolean clickOnAllCommentsFunc() throws InterruptedException {
	
		/* Click on view comment icon next to the searched single property   */
		Thread.sleep(3000);
		ElementUtils.waitForElementToDisplay(lblProperty, 100);
		WebElement btnMainCommentEle = new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(btnMainComment));
		btnMainCommentEle.click();

		Thread.sleep(5000);
		/* Click on view All comment linked-label in Comment model   */
		ElementUtils.waitForElementToDisplay(btnViewAllComment, 100);
		btnViewAllComment.click();

		Thread.sleep(5000);
		String LatestComment = lblLatestComment.getAttribute("label");
		String drpProperty = drpViewAllCommentProperty.getAttribute("value");
		if (LatestComment.equals(configReader.getProp("Comment"))&& drpProperty.equals(configReader.getProp("Propery"))) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean AddReplyFunc() throws InterruptedException {

		txtReplyBox.sendKeys(configReader.getProp("Reply_Comment"));

		ExpectedConditions.elementToBeClickable(btnReplySubmint);
		btnReplySubmint.click();

		Thread.sleep(2000);
		WebElement lblReplyComment = driver.findElement(By.xpath("(//div[contains(text(),'"+configReader.getProp("Reply_Comment")+"')])[1]"));
		String lblRComment = lblReplyComment.getText();
		if (lblRComment.equals(configReader.getProp("Reply_Comment"))) {
			return true;
		} else {
			return false;
		}

	}
	
	public boolean verifyRepliedUserDetailsFunc() throws InterruptedException {
		
		String user = lblReplyUser.getAttribute("label");
		String property = lblReplyProperty.getAttribute("label");
		if (user.equals(configReader.getLoginProp("dev_userName")) &&  property.equals(configReader.getProp("Propery"))) {
			return true;
		} else {
			return false;
		}
		
	}
	
	public boolean MarkAsResolvedFunc() {

		String resolvedStatus = drpStatus.getText();
		if (resolvedStatus.equals(configReader.getProp("Active_Status"))) {
			btnResolve.click();
			ExpectedConditions.invisibilityOf(lblLatestComment);
			return true;
		} else {
			return false;
		}
	}
	
	public boolean verifyResolvedCommentFunc() throws InterruptedException {
		drpStatus.click();
		ElementUtils.waitForElementToDisplay(listDrpValueSize.get(1), 100);
		Thread.sleep(4500);
		for (int i = 0; i < listDrpValueSize.size(); i++) {
			if (listDrpValueSize.get(i).getText().equalsIgnoreCase(configReader.getProp("Resolved_Comments"))) {
				listDrpValueSize.get(i).click();
			}
		}
		ElementUtils.waitForElementToDisplay(lblLatestComment, 100);
		String LatestComment = lblLatestComment.getAttribute("label");
		if (LatestComment.equals(configReader.getProp("Comment"))) {
			return true;
		} else {
			return false;
		}
		
	}
	
	public boolean MarkAsActivateFunc() {

		String resolvedStatus = drpStatus.getText();
		if (resolvedStatus.equals(configReader.getProp("Resolved_Comments"))) {
			btnActive.click();
			ExpectedConditions.invisibilityOf(lblLatestComment);
			return true;
		} else {
			return false;
		}
	}

	public boolean verifyActivatedCommentFunc() throws InterruptedException {
		drpStatus.click();
		ElementUtils.waitForElementToDisplay(listDrpValueSize.get(1), 100);
		for (int i = 0; i < listDrpValueSize.size(); i++) {
			if (listDrpValueSize.get(i).getText().equalsIgnoreCase(configReader.getProp("Active_Status"))) {
				listDrpValueSize.get(i).click();
			}
		}
		ElementUtils.waitForElementToDisplay(lblLatestComment, 100);
		String LatestComment = lblLatestComment.getAttribute("label");
		Thread.sleep(2000);
		if (LatestComment.equals(configReader.getProp("Comment"))) {
			return true;
		} else {
			return false;
		}

	}
   	
	
}
