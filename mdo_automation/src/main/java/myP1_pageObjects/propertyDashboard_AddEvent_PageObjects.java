package myP1_pageObjects;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

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

public class propertyDashboard_AddEvent_PageObjects {

	WebDriver driver;
	private ConstantsReader configReader = new ConstantsReader();

	public propertyDashboard_AddEvent_PageObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='btnAddEvent']")
	WebElement btnAddEvent;

	@FindBy(xpath = "//form[@id='formAddEvent']//h4[text()='Add Event']")
	WebElement addEventPopupHeading;

	@FindBy(xpath = "//input[@id='txtEventName']")
	WebElement addEventName;

	@FindBy(xpath = "//textarea[@id='txtDescription']")
	WebElement addEventDescription;

	@FindBy(xpath = "//input[@id='txtEventDate']")
	WebElement addEventStartDate;

	@FindBy(xpath = "//select[@id='ddlTimeZoneList']")
	WebElement addEventTimeZone;

	@FindBy(xpath = "//select[@id='ddlTimeZoneList']//option")
	List<WebElement> lstDropDowAddEventTimeZone;

	@FindBy(xpath = "//label[text()='Repeat']//following-sibling::div//div//div[@class='ios-switch off']")
	WebElement addEventRepeatOff;

	@FindBy(xpath = "//label[text()='Repeat']//following-sibling::div//div//div[@class='ios-switch on']")
	WebElement addEventRepeatOn;
	
	@FindBy(xpath = "//label[text()='Repeat']//following-sibling::div//div//div[@class='ios-switch']")
	WebElement addEventRepeat;

	@FindBy(xpath = "//select[@id='ddlRepeatList']")
	WebElement addEventRepeats;

	@FindBy(xpath = "//select[@id='ddlRepeatList']//option")
	List<WebElement> lstDropDowAddEventRepeats;

	@FindBy(xpath = "//select[@id='ddlRepeatEveryList']")
	WebElement addEventRepeatEvery;

	@FindBy(xpath = "//select[@id='ddlRepeatEveryList']//option")
	List<WebElement> lstDropDowAddEventRepeatEvery;

	@FindBy(xpath = "//input[@id='txtEventEndDate']")
	WebElement addEventEndDate;

	@FindBy(xpath = "//button[@id='submitAddEvent']")
	WebElement addEventSubmitBtn;

	@FindBy(xpath = "//div[@id='formDisplayEventBody']//button[text()='Close']")
	WebElement addEventCloseBtn;

	@FindBy(xpath = "//div[@id='divEventsuccess']")
	WebElement CommentSuccess;

	@FindBy(xpath = "//div[@id='formDisplayEventBody']")
	WebElement formDisplayEventBody;

	@FindBy(xpath = "//div[@id='formDisplayEventBody']//div//h3")
	List<WebElement> lstDropDowDisplayAddedEvent;

	@FindBy(xpath = "//div[@id='formDisplayEventBody']//div//a[@class='alnkdeleteevent']")
	List<WebElement> formDisplayDeleteLinks;
	
	@FindBy(xpath = "//button[@class='btn btn-primary modal-confirmEvent']")
	WebElement eventDeleteConfirmBtn;

	@FindBy(xpath = "//a[@class='alinkDisplayEvent']")
	WebElement calendarIcon;

	List<String> addedEvents = Arrays.asList(configReader.getMYP1Prop("Add_Event_Name"),
			configReader.getMYP1Prop("Add_Event_NameRepeat"));

	public void clickAddEvent() throws InterruptedException {
		Thread.sleep(7000);
		btnAddEvent.click();
	}

	public boolean verifyAddEventLoaded() throws InterruptedException {
		Thread.sleep(1000);
		WebElement AddEventPopup = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.visibilityOf(addEventPopupHeading));
		boolean AddEventPopupFlag = AddEventPopup.isDisplayed();
		System.out.println("Add Event popup is displayed: " + AddEventPopupFlag);
		return AddEventPopupFlag;
	}

	public void fillFormDataWithoutRepeat() {
		addEventName.sendKeys(Keys.CONTROL + "a");
		addEventName.sendKeys(Keys.DELETE);
		addEventName.sendKeys(configReader.getMYP1Prop("Add_Event_Name"));

		addEventDescription.sendKeys(Keys.CONTROL + "a");
		addEventDescription.sendKeys(Keys.DELETE);
		addEventDescription.sendKeys(configReader.getMYP1Prop("Add_Event_Description"));

		addEventStartDate.sendKeys(Keys.CONTROL + "a");
		addEventStartDate.sendKeys(Keys.DELETE);
		addEventStartDate.sendKeys(configReader.getMYP1Prop("Add_Event_StartDate"));

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", addEventTimeZone);
		for (int i = 0; i < lstDropDowAddEventTimeZone.size(); i++) {
			if (lstDropDowAddEventTimeZone.get(i).getText()
					.equalsIgnoreCase(configReader.getMYP1Prop("Add_Event_TimeZone"))) {
				System.out.println("Time Zone list item ===" + lstDropDowAddEventTimeZone.get(i).getText());
				lstDropDowAddEventTimeZone.get(i).click();
			}
		}
		
	}

	public void clickNotRepeatSubmit() {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", addEventSubmitBtn);
	}

	public boolean verifyNotRepeatSubmitted() {
		WebElement submitSuccessMsg = new WebDriverWait(driver, Duration.ofSeconds(700))
				.until(ExpectedConditions.visibilityOf(CommentSuccess));
		boolean isDataSubmitted = submitSuccessMsg.isDisplayed();
		System.out.println("Your Event added successfully.==" + isDataSubmitted);
		return isDataSubmitted;
	}

	public void fillAllDataWithRepeat() throws InterruptedException {

		addEventName.sendKeys(Keys.CONTROL + "a");
		addEventName.sendKeys(Keys.DELETE);
		addEventName.sendKeys(configReader.getMYP1Prop("Add_Event_NameRepeat"));

		addEventDescription.sendKeys(Keys.CONTROL + "a");
		addEventDescription.sendKeys(Keys.DELETE);
		addEventDescription.sendKeys(configReader.getMYP1Prop("Add_Event_DescriptionRepeat"));

		addEventStartDate.sendKeys(Keys.CONTROL + "a");
		addEventStartDate.sendKeys(Keys.DELETE);
		addEventStartDate.sendKeys(configReader.getMYP1Prop("Add_Event_StartDateRepeat"));

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", addEventTimeZone);
		for (int i = 0; i < lstDropDowAddEventTimeZone.size(); i++) {
			if (lstDropDowAddEventTimeZone.get(i).getText()
					.equalsIgnoreCase(configReader.getMYP1Prop("Add_Event_TimeZone"))) {
				System.out.println("Time Zones list item ===" + lstDropDowAddEventTimeZone.get(i).getText());
				lstDropDowAddEventTimeZone.get(i).click();
			}
		}
		addEventRepeat.click();

		JavascriptExecutor executorEventRepeats = (JavascriptExecutor) driver;
		executorEventRepeats.executeScript("arguments[0].click();", addEventRepeats);
		for (int i = 0; i < lstDropDowAddEventRepeats.size(); i++) {
			if (lstDropDowAddEventRepeats.get(i).getText()
					.equalsIgnoreCase(configReader.getMYP1Prop("Add_Event_RepeatOption"))) {
				System.out.println("Repeats list item ===" + lstDropDowAddEventRepeats.get(i).getText());
				lstDropDowAddEventRepeats.get(i).click();
			}
		}

		addEventRepeatEvery.click();
		for (int i = 0; i < lstDropDowAddEventRepeatEvery.size(); i++) {
			if (lstDropDowAddEventRepeatEvery.get(i).getText()
					.equalsIgnoreCase(configReader.getMYP1Prop("Add_Event_RepeatEvery"))) {
				System.out.println("Repeat Every list item ===" + lstDropDowAddEventRepeatEvery.get(i).getText());
				lstDropDowAddEventRepeatEvery.get(i).click();
			}
		}

		addEventEndDate.sendKeys(Keys.CONTROL + "a");
		addEventEndDate.sendKeys(Keys.DELETE);
		addEventEndDate.sendKeys(configReader.getMYP1Prop("Add_Event_EndDate"));
		Thread.sleep(7000);

	}

	public boolean verifyRepeatedDataSubmitted() throws InterruptedException {
		WebElement submitSuccessMsg = new WebDriverWait(driver, Duration.ofSeconds(700))
				.until(ExpectedConditions.visibilityOf(CommentSuccess));
		boolean isDataSubmitted = submitSuccessMsg.isDisplayed();
		System.out.println("Your Event added successfully.==" + isDataSubmitted);
		return isDataSubmitted;
	}

	public boolean verifyAddedEventPopup() throws InterruptedException {
		Thread.sleep(5000);
		WebElement waitFormDisplayEventBody = new WebDriverWait(driver, Duration.ofSeconds(1000))
				.until(ExpectedConditions.visibilityOf(formDisplayEventBody));
		if (waitFormDisplayEventBody.isDisplayed()) {
			boolean formDataAvailable = true;
			for (int i = 0; i < lstDropDowDisplayAddedEvent.size(); i++) {
				if (!addedEvents.contains(lstDropDowDisplayAddedEvent.get(i).getText())) {
					formDataAvailable = false;
					System.out.println(lstDropDowDisplayAddedEvent.get(i).getText() + "- not showing");
				}
			}
			return formDataAvailable;
		} else {
			System.out.println("Added Event Popup is not showing");
			return false;
		}
	}

	public boolean checkCalendarEvent() throws InterruptedException {
		addEventCloseBtn.click();
		System.out.println("closed the popup");
		Thread.sleep(3000);
		WebElement waitViewCalender = new WebDriverWait(driver, Duration.ofSeconds(1000))
				.until(ExpectedConditions.visibilityOf(calendarIcon));
		waitViewCalender.click();
		System.out.println("calender icon clicked");
		Thread.sleep(3000);
		WebElement waitformDisplayEventBody = new WebDriverWait(driver, Duration.ofSeconds(1000))
				.until(ExpectedConditions.visibilityOf(formDisplayEventBody));
		System.out.println("**************");
		if (waitformDisplayEventBody.isDisplayed()) {
			System.out.println("Added Event Popup is showing");
			return true;
		} else {
			System.out.println("Added Event Popup is not showing when calender click");
			return false;
		}
	}

	public void deleteEvents() throws InterruptedException {
		if(calendarIcon.isDisplayed()) {
			JavascriptExecutor executorcalendarIcon = (JavascriptExecutor) driver;
			executorcalendarIcon.executeScript("arguments[0].click();", calendarIcon);
			Thread.sleep(3000);
			int NoOflstDropDowDisplayAddedEvent=lstDropDowDisplayAddedEvent.size();
			for (int i = 0; i < NoOflstDropDowDisplayAddedEvent; i++) {
				if(addedEvents.contains(lstDropDowDisplayAddedEvent.get(i).getText())) {
					formDisplayDeleteLinks.get(i).click();
					Thread.sleep(2000);
					eventDeleteConfirmBtn.click();
					System.out.println(lstDropDowDisplayAddedEvent.get(i).getText()+"- deleted");
					if(i!=NoOflstDropDowDisplayAddedEvent) {
						Thread.sleep(5000);
						WebElement EventPopup = new WebDriverWait(driver, Duration.ofSeconds(1000))
							.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='formDisplayEventBody']")));
					}
				}
			}
			Thread.sleep(7000);
		}else {
			System.out.println("Calender icon is not showing");
		}
	}

	public boolean checkEventsDeleted() throws InterruptedException {			
		int EventPopup = driver.findElements(By.xpath("//div[@id='formDisplayEventBody']")).size();
		if(EventPopup>0) {
			Thread.sleep(3500);
//		WebElement calendarDisplayed = new WebDriverWait(driver, Duration.ofSeconds(700))
//				.until(ExpectedConditions.visibilityOf(calendarIcon));
//		calendarDisplayed.click();
//			Thread.sleep(2500);
			String Add_Event_Name = configReader.getMYP1Prop("Add_Event_Name");
			boolean firstEventDeleted=false;
			for (int i = 0; i < lstDropDowDisplayAddedEvent.size(); i++) {
				if (Add_Event_Name.equalsIgnoreCase(lstDropDowDisplayAddedEvent.get(i).getText())) {
					System.out.println(lstDropDowDisplayAddedEvent.get(i).getText() + "- deleted");
					firstEventDeleted= false;
				}else {
					firstEventDeleted= true;
				}
			}
			WebElement viewAdd_Event_NameRepeat = new WebDriverWait(driver, Duration.ofSeconds(100))
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='formDisplayEventBody']//div//h3[text()='"+ configReader.getMYP1Prop("Add_Event_NameRepeat")+"]//following::div//a[@class='alnkdeleteevent']")));
			viewAdd_Event_NameRepeat.click();
			System.out.println("Add_Event_NameRepeat also deleted!");
			return firstEventDeleted;
		}else {
			System.out.println("All Events deleted!");
			return true;
		}
	}

}
