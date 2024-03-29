package myP2_pageObjects;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.ConstantsReader;
import utils.ElementUtils;

public class Dashboard_WidgetsCalculator_PageObject {

	private WebDriver driver;
	private ConstantsReader configReader = new ConstantsReader();
	boolean flag;
	ArrayList<String> byProTableArray;
	ArrayList<String> occWidgetArray;
	ArrayList<String> adrByProTableArray;
	ArrayList<String> adrWidgetArray;
	ArrayList<String> revParByProTableArray;
	ArrayList<String> revParWidgetArray;

	public Dashboard_WidgetsCalculator_PageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		byProTableArray = new ArrayList<>();
		occWidgetArray = new ArrayList<>();
		adrByProTableArray = new ArrayList<>();
		adrWidgetArray = new ArrayList<>();
		revParByProTableArray = new ArrayList<>();
		revParWidgetArray = new ArrayList<>();

	}

	@FindBy(xpath = "//span[text()='Order Widgets']")
	WebElement orderWidgetButt;

	@FindBy(xpath = "//div[2]/li//div[text()='Occupancy']")
	WebElement orderOfOccWidget;

	@FindBy(xpath = "//div[3]/li//div[text()='ADR (Average Daily Rate)']")
	WebElement orderOfAdrWidget;

	@FindBy(xpath = "//div[4]/li//div[text()='RevPAR (Revenue Per Available Room)']")
	WebElement orderOfRevParWidget;

	@FindBy(xpath = "//button[@data-el='buttonCustomizeTable']/ancestor::div[4]//div[@data-el='selectorPeriod']")
	WebElement byPropertyWidgetPeriod;

	@FindBy(xpath = "//div[text()='Occupancy']/ancestor::div[4]//div[@data-el='selectorPeriod']")
	WebElement occupancyPeriodDropdown;

	@FindBy(xpath = "//div[text()='ADR (Average Daily Rate)']/ancestor::div[4]//div[@data-el='selectorPeriod']")
	WebElement adrPeriodDropdown;

	@FindBy(xpath = "//div[text()='RevPAR (Revenue Per Available Room)']/ancestor::div[4]//div[@data-el='selectorPeriod']")
	WebElement revParPeriodDropdown;

	@FindBy(xpath = "//button[@data-el='buttonCustomizeTable']")
	WebElement editBtt;

	@FindBy(xpath = "(//button[@data-el='button-edit-Occupancy_Test'])[last()]")
	WebElement lastEditButton;

	@FindBy(xpath = "(//button[@data-el='button-edit-ADR_Test'])[last()]")
	WebElement lastEditButtonADR;

	@FindBy(xpath = "(//button[@data-el='button-edit-RevPAR_Test'])[last()]")
	WebElement lastEditButtonRevPar;

	@FindBy(xpath = "(//button[@data-el='button-delete-Occupancy_Test'])[last()]")
	WebElement lastDeleteButton;

	@FindBy(xpath = "(//button[@data-el='button-delete-ADR_Test'])[last()]")
	WebElement lastDeleteButtonADR;

	@FindBy(xpath = "(//button[@data-el='button-delete-RevPAR_Test'])[last()]")
	WebElement lastDeleteButtonRevPar;

	@FindBy(xpath = "//div[text()='Edit Column']")
	WebElement verifyEditColum;

	@FindBy(xpath = "//h3[contains(text(),'Delete column')]")
	WebElement verifydeleteColum;

	@FindBy(xpath = "//button[@data-el='buttonSave']")
	WebElement saveBtt;

	@FindBy(xpath = "//button[@data-el='buttonCancel']")
	WebElement btnCancel;

	@FindBy(xpath = "//span[text()='Ok']")
	WebElement okButt;

	@FindBy(xpath = "//div[@class='MuiAlert-message css-1xsto0d']")
	WebElement popupMsgDisplay;

	@FindBy(xpath = "//button[@data-el='buttonFinishCustomization']")
	WebElement imDoneButt;

	@FindBy(xpath = "//th[last()]//span[text()='Occupancy_Test']")
	WebElement occupancyHeader;

	@FindBy(xpath = "//th[last()]//span[text()='ADR_Test']")
	WebElement adrHeader;

	@FindBy(xpath = "//th[last()]//span[text()='RevPAR_Test']")
	WebElement revParHeader;

	@FindBy(xpath = "//div[@data-el='chartCardTitleDiv']//div[text()='Occupancy']")
	WebElement occupancyWidgetHeader;

	@FindBy(xpath = "//div[@data-el='chartCardTitleDiv']//div[contains(text(),'ADR (Average Daily Rate)')]")
	WebElement adrWidgetHeader;

	@FindBy(xpath = "//div[@data-el='chartCardTitleDiv']//div[contains(text(),'RevPAR (Revenue Per Available Room)')]")
	WebElement revParWidgetHeader;

	@FindBy(xpath = "//button[@data-el='buttonAddAColumn']")
	WebElement addColumnBtt;

	@FindBy(xpath = "//div[@data-el='InputField-name']")
	WebElement addName;

	@FindBy(xpath = "//div[@data-el=' KpiDropdown-kpiIdInput']")
	WebElement addKpi;

	@FindBy(xpath = "//div[@data-el='GenericSelector-valueDataType']")
	WebElement addAmountType;

	@FindBy(xpath = "//input[@name='name']")
	WebElement addNameText;

	@FindBy(xpath = "//input[@name='kpiId']")
	WebElement addKpiText;

	@FindBy(xpath = "//div/input[@name='porfolio-hotel']")
	WebElement drpProperty;

	@FindBy(xpath = "//div/input[contains(@name, 'porfolio-group')]")
	WebElement drpGroup;

	@FindBy(xpath = "//div[@role='listbox']//li")
	List<WebElement> listDrpValueSize;

	@FindBy(xpath = "//ul[@role='listbox']//li")
	List<WebElement> drpValueListSize;

	@FindBy(xpath = "//div//label[text() = 'Date'] /following-sibling::div//input")
	WebElement txtDate;

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

	@FindBy(xpath = "//button[@title='Edit']")
	WebElement editBtn;

	@FindBy(xpath = "//div[contains(text(),'CNMTS')]")
	WebElement insigniaEL;

	@FindBy(xpath = "//div[@role='dialog']//h3[contains(text(),'Delete column')]")
	WebElement dialogBox;

	@FindBy(xpath = "//button[@mdo_variant='success']//span[text()='Ok']")
	WebElement btnDeleteConfirmation;

	public void verifyWidgetsOrder() throws InterruptedException {

		Thread.sleep(3000);

		WebElement orderWidgetButton = new WebDriverWait(driver, Duration.ofSeconds(50)).until(ExpectedConditions.visibilityOf(orderWidgetButt));
		orderWidgetButton.click();

		Thread.sleep(3000);
		WebElement occWidgetOrder = new WebDriverWait(driver, Duration.ofSeconds(50)).until(ExpectedConditions.visibilityOf(orderOfOccWidget));
		occWidgetOrder.isDisplayed();
		Thread.sleep(3000);

		WebElement adrWidgetOrder = new WebDriverWait(driver, Duration.ofSeconds(50)).until(ExpectedConditions.visibilityOf(orderOfAdrWidget));
		adrWidgetOrder.isDisplayed();
		Thread.sleep(3000);

		WebElement revParWidgetOrder = new WebDriverWait(driver, Duration.ofSeconds(50)).until(ExpectedConditions.visibilityOf(orderOfRevParWidget));
		revParWidgetOrder.isDisplayed();
		Thread.sleep(3000);

		WebElement clickSaveBtt = new WebDriverWait(driver, Duration.ofSeconds(50)).until(ExpectedConditions.visibilityOf(saveBtt));
		clickSaveBtt.click();
		Thread.sleep(3000);

	}

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

	public boolean selectSpecificDate() throws InterruptedException {
		boolean flag = false;
		String[] dateForPicker = configReader.getProp("widgetsCal_Specific_Date").split("/");

		txtDate.click();

		int btnDatePickforLocal = driver
				.findElements(By.xpath("//div//label[text() = 'Date'] //following-sibling::div//button")).size();

		if (btnDatePickforLocal > 0) {
			btnDatePicker.click();
		}

		int status = driver.findElements(By.xpath("//div[@role='dialog']")).size();

		if (status == 1) {
			WebElement expandYear = new WebDriverWait(driver, Duration.ofSeconds(10))
					.until(ExpectedConditions.visibilityOf(btnExpandYear));
			expandYear.click();

			Thread.sleep(2500);
			WebElement pickYear = driver
					.findElement(By.xpath("//div[contains(@class, 'PrivatePickersYear')]//button [contains(text(), '"
							+ dateForPicker[2] + "')]"));

			pickYear.click();
			Thread.sleep(2500);
			int monthInnum = getMonth();
			int monthDiff = monthInnum - Integer.parseInt(dateForPicker[0]);

			if (monthDiff > 0) {
				for (int i = 0; i < monthDiff; i++) {
					WebElement btnPrevious = new WebDriverWait(driver, Duration.ofSeconds(10))
							.until(ExpectedConditions.visibilityOf(btnPreviousMonth));
					btnPrevious.click();
					Thread.sleep(1500);

				}
				WebElement btnDate = driver
						.findElement(By.xpath(" //div[@role='row']//button[text() = '" + dateForPicker[1] + "']"));
				btnDate.click();
				validateOkCancelandClick();
				flag = true;
			}

			else if (monthDiff < 0) {
				for (int i = 0; i > monthDiff; i--) {
					WebElement btnNext = new WebDriverWait(driver, Duration.ofSeconds(10))
							.until(ExpectedConditions.visibilityOf(btnNextMonth));
					btnNext.click();
					Thread.sleep(1500);
				}
				WebElement btnDate = driver
						.findElement(By.xpath(" //div[@role='row']//button[text() = '" + dateForPicker[1] + "']"));
				btnDate.click();
				validateOkCancelandClick();

				flag = true;
			}

			else {
				WebElement btnDate = driver
						.findElement(By.xpath(" //div[@role='row']//button[text() = '" + dateForPicker[1] + "']"));
				btnDate.click();
				validateOkCancelandClick();
				flag = true;
			}

		} else {
			flag = false;
		}

		return flag;

	}

	public boolean selectSpecificDateFirst() throws InterruptedException {
		boolean flag = false;
		String[] dateForPicker = configReader.getProp("widgetsCal_Specific_Date").split("/");

		txtDate.click();

		int btnDatePickforLocal = driver
				.findElements(By.xpath("//div//label[text() = 'Date'] //following-sibling::div//button")).size();

		if (btnDatePickforLocal > 0) {
			btnDatePicker.click();
		}

		int status = driver.findElements(By.xpath("//div[@role='dialog']")).size();

		if (status == 1) {
			WebElement expandYear = new WebDriverWait(driver, Duration.ofSeconds(10))
					.until(ExpectedConditions.visibilityOf(btnExpandYear));
			expandYear.click();

			Thread.sleep(2500);
			WebElement pickYear = driver
					.findElement(By.xpath("//div[contains(@class, 'PrivatePickersYear')]//button [contains(text(), '"
							+ dateForPicker[2] + "')]"));

			pickYear.click();
			Thread.sleep(5000);

			int btnStatus = driver.findElements(By.xpath("//button[text()='OK']")).size();

			if (btnStatus > 0) {
				WebElement btnOk = driver.findElement(By.xpath("//button[text()='OK']"));
				btnOk.click();
			} else {
				txtDate.click();
			}

			flag = true;

		} else {
			flag = false;
		}

		return flag;

	}

	public boolean selectLastYearDate() throws InterruptedException {
		boolean flag = false;
		String[] dateForPicker = configReader.getProp("widgetsCal_Last_Year_Date").split("/");

		txtDate.click();

		int btnDatePickforLocal = driver
				.findElements(By.xpath("//div//label[text() = 'Date'] //following-sibling::div//button")).size();

		if (btnDatePickforLocal > 0) {
			btnDatePicker.click();
		}

		int status = driver.findElements(By.xpath("//div[@role='dialog']")).size();

		if (status == 1) {
			WebElement expandYear = new WebDriverWait(driver, Duration.ofSeconds(10))
					.until(ExpectedConditions.visibilityOf(btnExpandYear));
			expandYear.click();

			Thread.sleep(2500);
			WebElement pickYear = driver
					.findElement(By.xpath("//div[contains(@class, 'PrivatePickersYear')]//button [contains(text(), '"
							+ dateForPicker[2] + "')]"));

			pickYear.click();
			Thread.sleep(5000);

			int btnStatus = driver.findElements(By.xpath("//button[text()='OK']")).size();

			if (btnStatus > 0) {
				WebElement btnOk = driver.findElement(By.xpath("//button[text()='OK']"));
				btnOk.click();
			} else {
				txtDate.click();
			}

			flag = true;

		} else {
			flag = false;
		}

		return flag;

	}

	public boolean selectOldYearDate() throws InterruptedException {
		boolean flag = false;
		String[] dateForPicker = configReader.getProp("widgetsCal_Year19_Date").split("/");

		txtDate.click();

		int btnDatePickforLocal = driver
				.findElements(By.xpath("//div//label[text() = 'Date'] //following-sibling::div//button")).size();

		if (btnDatePickforLocal > 0) {
			btnDatePicker.click();
		}

		int status = driver.findElements(By.xpath("//div[@role='dialog']")).size();

		if (status == 1) {
			WebElement expandYear = new WebDriverWait(driver, Duration.ofSeconds(10))
					.until(ExpectedConditions.visibilityOf(btnExpandYear));
			expandYear.click();

			Thread.sleep(2500);
			WebElement pickYear = driver
					.findElement(By.xpath("//div[contains(@class, 'PrivatePickersYear')]//button [contains(text(), '"
							+ dateForPicker[2] + "')]"));

			pickYear.click();
			Thread.sleep(5000);

			int btnStatus = driver.findElements(By.xpath("//button[text()='OK']")).size();

			if (btnStatus > 0) {
				WebElement btnOk = driver.findElement(By.xpath("//button[text()='OK']"));
				btnOk.click();
			} else {
				txtDate.click();
			}

			flag = true;

		} else {
			flag = false;
		}

		return flag;

	}

	public void selectGroup() throws InterruptedException {

		Thread.sleep(5000);

		WebElement drpGroupEle = new WebDriverWait(driver, Duration.ofSeconds(50)).until(ExpectedConditions.visibilityOf(drpGroup));
		drpGroupEle.click();

		Thread.sleep(5000);
		for (int i = 0; i < listDrpValueSize.size(); i++) {
			if (listDrpValueSize.get(i).getText().equalsIgnoreCase(configReader.getProp("widgetsCal_Group"))) {
				listDrpValueSize.get(i).click();
			}
		}

	}

	public void selectProperty() throws InterruptedException {

		Thread.sleep(5000);

		WebElement drpPropertyEle = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(drpProperty));
		drpPropertyEle.click();

		for (int i = 0; i < listDrpValueSize.size(); i++) {
			if (listDrpValueSize.get(i).getText().equalsIgnoreCase(configReader.getProp("widgetsCal_All_Property"))) {
				listDrpValueSize.get(i).click();
			}
		}

		Thread.sleep(5000);

	}

	public void selectByPropertyPeriod() throws InterruptedException {

		Thread.sleep(5000);

		WebElement byPropertyPeriodW = new WebDriverWait(driver, Duration.ofSeconds(25)).until(ExpectedConditions.visibilityOf(byPropertyWidgetPeriod));
		byPropertyPeriodW.isDisplayed();

	}

	public void selectOccupancyPeriod() throws InterruptedException {

		Thread.sleep(3000);

		if (occupancyWidgetHeader.isEnabled()) {
			WebElement occupancyWidget = new WebDriverWait(driver, Duration.ofSeconds(50)).until(ExpectedConditions.visibilityOf(occupancyWidgetHeader));
			occupancyWidget.isDisplayed();
		}

		Thread.sleep(5000);

		if (occupancyPeriodDropdown.isEnabled()) {
			WebElement occupancyPeriod = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(occupancyPeriodDropdown));
			occupancyPeriod.click();

			Thread.sleep(5000);
			for (int i = 0; i < drpValueListSize.size(); i++) {
				if (drpValueListSize.get(i).getText().equalsIgnoreCase(configReader.getProp("widgetsCal_MTD"))) {
					drpValueListSize.get(i).click();
				}
			}
		}

	}

	public void addNewRecord() throws InterruptedException {

		Thread.sleep(3000);

		deleteColumnIfExist("Occupancy_Test");

		WebElement clickAddColumnBtt = new WebDriverWait(driver, Duration.ofSeconds(25)).until(ExpectedConditions.visibilityOf(addColumnBtt));
		clickAddColumnBtt.click();

		Thread.sleep(3000);
		WebElement addNameFeildClick = new WebDriverWait(driver, Duration.ofSeconds(25)).until(ExpectedConditions.visibilityOf(addName));
		addNameFeildClick.click();

		addNameText.sendKeys(Keys.CONTROL + "a");
		addNameText.sendKeys(Keys.DELETE);
		addNameText.sendKeys(configReader.getProp("widgetsCal_Add_Name"));

		Thread.sleep(3000);

		WebElement addKpiFeildClick = new WebDriverWait(driver, Duration.ofSeconds(25)).until(ExpectedConditions.visibilityOf(addKpi));
		addKpiFeildClick.click();

		addKpiText.sendKeys(Keys.CONTROL + "a");
		addKpiText.sendKeys(Keys.DELETE);
		addKpiText.sendKeys(configReader.getProp("widgetsCal_Add_Kpi"));
		try {
			for (int r = 0; r < listDrpValueSize.size(); r++) {
				if (listDrpValueSize.get(r).getText().equalsIgnoreCase(configReader.getProp("widgetsCal_Add_Kpi"))) {
					listDrpValueSize.get(r).click();
				}
			}
		}catch(StaleElementReferenceException e) {
			for (int r = 0; r < listDrpValueSize.size(); r++) {
				if (listDrpValueSize.get(r).getText().equalsIgnoreCase(configReader.getProp("widgetsCal_Add_Kpi"))) {
					listDrpValueSize.get(r).click();
				}
			}
		}

		Thread.sleep(3000);
		WebElement addAmountTypeFeildClick = new WebDriverWait(driver, Duration.ofSeconds(25)).until(ExpectedConditions.visibilityOf(addAmountType));
		addAmountTypeFeildClick.click();

		Thread.sleep(3000);
		try {
			for (int s = 0; s < drpValueListSize.size(); s++) {
				if (drpValueListSize.get(s).getText().equalsIgnoreCase(configReader.getProp("widgetsCal_Add_ACTUAL"))) {
					drpValueListSize.get(s).click();
				}
			}
		}catch(StaleElementReferenceException e) {
			for (int s = 0; s < drpValueListSize.size(); s++) {
				if (drpValueListSize.get(s).getText().equalsIgnoreCase(configReader.getProp("widgetsCal_Add_ACTUAL"))) {
					drpValueListSize.get(s).click();
				}
			}
		}

		Thread.sleep(3000);

		try {
			WebElement clickSaveBtt = new WebDriverWait(driver, Duration.ofSeconds(25)).until(ExpectedConditions.visibilityOf(saveBtt));
			clickSaveBtt.click();

			WebElement popupMessage = new WebDriverWait(driver, Duration.ofSeconds(25)).until(ExpectedConditions.visibilityOf(popupMsgDisplay));
			popupMessage.isDisplayed();
			
		} catch (Exception e) {
			WebElement buttonCancel = new WebDriverWait(driver, Duration.ofSeconds(25)).until(ExpectedConditions.visibilityOf(btnCancel));
			buttonCancel.click();
		}

		WebElement occupancyTableHeader = new WebDriverWait(driver, Duration.ofSeconds(25)).until(ExpectedConditions.visibilityOf(occupancyHeader));
		occupancyTableHeader.isDisplayed();
	}

	public void editAmountTypeAndCaptureRec() throws InterruptedException {

		for (int i = 0; i < 3; i++) {

			Thread.sleep(3000);

			if (lastEditButton.isEnabled()) {
				WebElement lstEditBtt = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(lastEditButton));
				lstEditBtt.click();
			}

			Thread.sleep(3000);

			if (verifyEditColum.isEnabled()) {
				WebElement checkEditColumn = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(verifyEditColum));
				checkEditColumn.isDisplayed();
			}

			Thread.sleep(3000);

			WebElement addAmountTypeFeildClick = new WebDriverWait(driver, Duration.ofSeconds(25)).until(ExpectedConditions.visibilityOf(addAmountType));
			addAmountTypeFeildClick.click();

			drpValueListSize.get(i).click();

			Thread.sleep(3000);

			WebElement clickSaveBtt = new WebDriverWait(driver, Duration.ofSeconds(25)).until(ExpectedConditions.visibilityOf(saveBtt));
			clickSaveBtt.click();

			WebElement popupMessage = new WebDriverWait(driver, Duration.ofSeconds(25)).until(ExpectedConditions.visibilityOf(popupMsgDisplay));
			popupMessage.isDisplayed();
			
			Thread.sleep(15000);
			WebElement occupancyPortfolioTotal = driver.findElement(By.xpath("//table//tr[last()]//td[count(//table//th[.='Occupancy_Test']/preceding-sibling::*)+1]"));
			byProTableArray.add(occupancyPortfolioTotal.getText());

		}

	}

	public void captureRecByYear() throws InterruptedException {

		Thread.sleep(5000);
		if (lastEditButton.isEnabled()) {
			WebElement lstEditBtt = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(lastEditButton));
			lstEditBtt.click();
		}

		Thread.sleep(3000);
		if (verifyEditColum.isEnabled()) {
			WebElement checkEditColumn = new WebDriverWait(driver, Duration.ofSeconds(25)).until(ExpectedConditions.visibilityOf(verifyEditColum));
			checkEditColumn.isDisplayed();
		}

		Thread.sleep(3000);

		WebElement addAmountTypeFeildClick = new WebDriverWait(driver, Duration.ofSeconds(25)).until(ExpectedConditions.visibilityOf(addAmountType));
		addAmountTypeFeildClick.click();
		
		try {
			for (int s = 0; s < drpValueListSize.size(); s++) {
				if (drpValueListSize.get(s).getText().equalsIgnoreCase(configReader.getProp("widgetsCal_Add_ACTUAL"))) {
					drpValueListSize.get(s).click();
				}
			}
		}catch(StaleElementReferenceException e) {
			for (int s = 0; s < drpValueListSize.size(); s++) {
				if (drpValueListSize.get(s).getText().equalsIgnoreCase(configReader.getProp("widgetsCal_Add_ACTUAL"))) {
					drpValueListSize.get(s).click();
				}
			}
		}
		Thread.sleep(3000);

		WebElement clickSaveBtt = new WebDriverWait(driver, Duration.ofSeconds(25)).until(ExpectedConditions.visibilityOf(saveBtt));
		clickSaveBtt.click();

		WebElement popupMessage = new WebDriverWait(driver, Duration.ofSeconds(25)).until(ExpectedConditions.visibilityOf(popupMsgDisplay));
		popupMessage.isDisplayed();
		Thread.sleep(15000);

		WebElement occupancyPortfolioTotal = driver.findElement(By.xpath("//table//tr[last()]//td[count(//table//th[.='Occupancy_Test']/preceding-sibling::*)+1]"));
		byProTableArray.add(occupancyPortfolioTotal.getText());

	}

	public void captureRecInGraph() throws InterruptedException {

		Thread.sleep(3000);

		if (occupancyWidgetHeader.isEnabled()) {
			WebElement occupancyWidget = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(occupancyWidgetHeader));
			occupancyWidget.isDisplayed();
		}

		Thread.sleep(5000);

		WebElement actualVal = driver.findElement(By.xpath("(//*[local-name()='svg' and @role='group']//*[local-name()='tspan'])[1]"));
		ElementUtils.waitForElementToDisplay(actualVal, 1000);
		occWidgetArray.add(actualVal.getText());

		Thread.sleep(5000);

		WebElement budgetVal = driver.findElement(By.xpath("(//*[local-name()='svg' and @role='group']//*[local-name()='tspan'])[4]"));
		ElementUtils.waitForElementToDisplay(budgetVal, 100);
		occWidgetArray.add(budgetVal.getText());

		Thread.sleep(5000);

		WebElement forecastVal = driver.findElement(By.xpath("(//*[local-name()='svg' and @role='group']//*[local-name()='tspan'])[5]"));
		ElementUtils.waitForElementToDisplay(forecastVal, 100);
		occWidgetArray.add(forecastVal.getText());

		Thread.sleep(5000);

		WebElement lastYearVal = driver.findElement(By.xpath("(//*[local-name()='svg' and @role='group']//*[local-name()='tspan'])[2]"));
		ElementUtils.waitForElementToDisplay(lastYearVal, 100);
		occWidgetArray.add(lastYearVal.getText());

		Thread.sleep(5000);

		WebElement pastYearVal = driver.findElement(By.xpath("(//*[local-name()='svg' and @role='group']//*[local-name()='tspan'])[3]"));
		ElementUtils.waitForElementToDisplay(pastYearVal, 100);
		occWidgetArray.add(pastYearVal.getText());

	}

	public boolean comparingTwoRecArrays() {

		boolean flag = true;

		try {
			for (int i = 0; i < byProTableArray.size(); i++) {

				String byProTableVal = byProTableArray.get(i).replace("%", "");
				String occWidgetVal = occWidgetArray.get(i).replace("%", "");

				if (byProTableVal.equalsIgnoreCase(occWidgetVal)) {

					System.out.println("PASS");
					System.out.println(byProTableArray.get(i) + " <<<--////Pass////-->>> " + occWidgetArray.get(i));

				} else {
					flag = false;
					System.out.println("Fail");
					System.out.println(byProTableArray.get(i) + " <<<--////fail////-->>> " + occWidgetArray.get(i));

					break;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;

	}

	public void deleteColumn() throws InterruptedException {

		Thread.sleep(3000);

		if (lastDeleteButton.isEnabled()) {
			WebElement lastDeleteBut = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(lastDeleteButton));
			lastDeleteBut.click();
		}

		Thread.sleep(3000);

		if (verifydeleteColum.isEnabled()) {
			WebElement verifydeleteHeader = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(verifydeleteColum));
			verifydeleteHeader.isDisplayed();
		}

		Thread.sleep(3000);

		WebElement okBut = new WebDriverWait(driver, Duration.ofSeconds(25)).until(ExpectedConditions.visibilityOf(okButt));
		okBut.click();

		WebElement popupMessage = new WebDriverWait(driver, Duration.ofSeconds(25)).until(ExpectedConditions.visibilityOf(popupMsgDisplay));
		popupMessage.isDisplayed();
		Thread.sleep(3000);

		if (imDoneButt.isEnabled()) {
			WebElement imDoneButton = new WebDriverWait(driver, Duration.ofSeconds(100)).until(ExpectedConditions.visibilityOf(imDoneButt));
			imDoneButton.isDisplayed();
		}

	}

	
	
	public void selectADRPeriod() throws InterruptedException {

		Thread.sleep(3000);
		if (adrWidgetHeader.isEnabled()) {
			WebElement adrWidget = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(adrWidgetHeader));
			adrWidget.isDisplayed();
		}

		Thread.sleep(5000);
		if (adrPeriodDropdown.isEnabled()) {
			WebElement adrPeriod = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(adrPeriodDropdown));
			adrPeriod.click();

			Thread.sleep(5000);
			for (int i = 0; i < drpValueListSize.size(); i++) {
				if (drpValueListSize.get(i).getText().equalsIgnoreCase(configReader.getProp("widgetsCal_MTD"))) {
					drpValueListSize.get(i).click();
				}
			}
		}

	}

	public void addNewAdrRecord() throws InterruptedException {

		Thread.sleep(3000);
		deleteColumnIfExist("ADR_Test");
		Thread.sleep(5000);

		WebElement clickAddColumnBtt = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(addColumnBtt));
		clickAddColumnBtt.click();

		Thread.sleep(3000);
		WebElement addNameFeildClick = new WebDriverWait(driver, Duration.ofSeconds(25)).until(ExpectedConditions.visibilityOf(addName));
		addNameFeildClick.click();

		addNameText.sendKeys(Keys.CONTROL + "a");
		addNameText.sendKeys(Keys.DELETE);
		addNameText.sendKeys(configReader.getProp("widgetsCal_Add_ADR_Name"));

		Thread.sleep(3000);
		WebElement addKpiFeildClick = new WebDriverWait(driver, Duration.ofSeconds(25)).until(ExpectedConditions.visibilityOf(addKpi));
		addKpiFeildClick.click();

		addKpiText.sendKeys(Keys.CONTROL + "a");
		addKpiText.sendKeys(Keys.DELETE);
		addKpiText.sendKeys(configReader.getProp("widgetsCal_Add_ADR_Kpi"));
		
		try {
			for (int r = 0; r < listDrpValueSize.size(); r++) {
				if (listDrpValueSize.get(r).getText().equalsIgnoreCase(configReader.getProp("widgetsCal_Add_ADR_Kpi"))) {
					listDrpValueSize.get(r).click();
				}
			}
		}catch(StaleElementReferenceException e) {
			for (int r = 0; r < listDrpValueSize.size(); r++) {
				if (listDrpValueSize.get(r).getText().equalsIgnoreCase(configReader.getProp("widgetsCal_Add_ADR_Kpi"))) {
					listDrpValueSize.get(r).click();
				}
			}
		}

		Thread.sleep(3000);
		WebElement addAmountTypeFeildClick = new WebDriverWait(driver, Duration.ofSeconds(25)).until(ExpectedConditions.visibilityOf(addAmountType));
		addAmountTypeFeildClick.click();

		Thread.sleep(3000);
		try {
			for (int s = 0; s < drpValueListSize.size(); s++) {
				if (drpValueListSize.get(s).getText().equalsIgnoreCase(configReader.getProp("widgetsCal_Add_ACTUAL"))) {
					drpValueListSize.get(s).click();
				}
			}
		}catch(StaleElementReferenceException e) {
			for (int s = 0; s < drpValueListSize.size(); s++) {
				if (drpValueListSize.get(s).getText().equalsIgnoreCase(configReader.getProp("widgetsCal_Add_ACTUAL"))) {
					drpValueListSize.get(s).click();
				}
			}
		}
		
		Thread.sleep(3000);

		try {
			WebElement clickSaveBtt = new WebDriverWait(driver, Duration.ofSeconds(25)).until(ExpectedConditions.visibilityOf(saveBtt));
			clickSaveBtt.click();

			WebElement popupMessage = new WebDriverWait(driver, Duration.ofSeconds(25)).until(ExpectedConditions.visibilityOf(popupMsgDisplay));
			popupMessage.isDisplayed();
			
		} catch (Exception e) {
			WebElement buttonCancel = new WebDriverWait(driver, Duration.ofSeconds(25)).until(ExpectedConditions.visibilityOf(btnCancel));
			buttonCancel.click();
		}

		Thread.sleep(3000);
		if (imDoneButt.isEnabled()) {
			WebElement imDoneButton = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(imDoneButt));
			imDoneButton.isDisplayed();
		}

		WebElement adrTableHeader = new WebDriverWait(driver, Duration.ofSeconds(50)).until(ExpectedConditions.visibilityOf(adrHeader));
		adrTableHeader.isDisplayed();
	}

	public void editAmountTypeAndCaptureRecADR() throws InterruptedException {

		for (int i = 0; i < 3; i++) {

			Thread.sleep(3000);
			if (lastEditButtonADR.isEnabled()) {
				WebElement lstEditBttADR = new WebDriverWait(driver, Duration.ofSeconds(25)).until(ExpectedConditions.visibilityOf(lastEditButtonADR));
				lstEditBttADR.click();
			}

			Thread.sleep(3000);
			if (verifyEditColum.isEnabled()) {
				WebElement checkEditColumn = new WebDriverWait(driver, Duration.ofSeconds(25)).until(ExpectedConditions.visibilityOf(verifyEditColum));
				checkEditColumn.isDisplayed();
			}

			Thread.sleep(3000);
			WebElement addAmountTypeFeildClick = new WebDriverWait(driver, Duration.ofSeconds(25)).until(ExpectedConditions.visibilityOf(addAmountType));
			addAmountTypeFeildClick.click();

			Thread.sleep(3000);
			drpValueListSize.get(i).click();
			
			Thread.sleep(3000);

			WebElement clickSaveBtt = new WebDriverWait(driver, Duration.ofSeconds(25)).until(ExpectedConditions.visibilityOf(saveBtt));
			clickSaveBtt.click();

			WebElement popupMessage = new WebDriverWait(driver, Duration.ofSeconds(25)).until(ExpectedConditions.visibilityOf(popupMsgDisplay));
			popupMessage.isDisplayed();
			
			Thread.sleep(15000);

			WebElement adrPortfolioTotal = driver.findElement(By.xpath("//table//tr[last()]//td[count(//table//th[.='ADR_Test']/preceding-sibling::*)+1]"));
			adrByProTableArray.add(adrPortfolioTotal.getText());

		}

	}

	public void captureRecByYearADR() throws InterruptedException {

		Thread.sleep(5000);

		if (lastEditButtonADR.isEnabled()) {
			WebElement lstEditBttADR = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(lastEditButtonADR));
			lstEditBttADR.click();
		}

		Thread.sleep(3000);

		if (verifyEditColum.isEnabled()) {
			WebElement checkEditColumn = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(verifyEditColum));
			checkEditColumn.isDisplayed();
		}

		Thread.sleep(3000);

		WebElement addAmountTypeFeildClick = new WebDriverWait(driver, Duration.ofSeconds(25)).until(ExpectedConditions.visibilityOf(addAmountType));
		addAmountTypeFeildClick.click();

		try {
			for (int s = 0; s < drpValueListSize.size(); s++) {
				if (drpValueListSize.get(s).getText().equalsIgnoreCase(configReader.getProp("widgetsCal_Add_ACTUAL"))) {
					drpValueListSize.get(s).click();
				}
			}
		}catch(StaleElementReferenceException e) {
			for (int s = 0; s < drpValueListSize.size(); s++) {
				if (drpValueListSize.get(s).getText().equalsIgnoreCase(configReader.getProp("widgetsCal_Add_ACTUAL"))) {
					drpValueListSize.get(s).click();
				}
			}
		}

		Thread.sleep(3000);

		WebElement clickSaveBtt = new WebDriverWait(driver, Duration.ofSeconds(25)).until(ExpectedConditions.visibilityOf(saveBtt));
		clickSaveBtt.click();

		WebElement popupMessage = new WebDriverWait(driver, Duration.ofSeconds(25)).until(ExpectedConditions.visibilityOf(popupMsgDisplay));
		popupMessage.isDisplayed();
		Thread.sleep(15000);

		WebElement adrPortfolioTotal = driver.findElement(By.xpath("//table//tr[last()]//td[count(//table//th[.='ADR_Test']/preceding-sibling::*)+1]"));
		adrByProTableArray.add(adrPortfolioTotal.getText());

	}

	public void captureRecInGraphADR() throws InterruptedException {

		Thread.sleep(3000);
		if (adrWidgetHeader.isEnabled()) {
			WebElement adrWidget = new WebDriverWait(driver, Duration.ofSeconds(25)).until(ExpectedConditions.visibilityOf(adrWidgetHeader));
			adrWidget.isDisplayed();
		}

		Thread.sleep(5000);

		WebElement actualVal = driver.findElement(By.xpath("(//div[3]//*[local-name()='svg' and @role='group']//*[local-name()='tspan'])[1]"));
		ElementUtils.waitForElementToDisplay(actualVal, 100);
		adrWidgetArray.add(actualVal.getText());

		Thread.sleep(5000);

		WebElement budgetVal = driver.findElement(By.xpath("(//div[3]//*[local-name()='svg' and @role='group']//*[local-name()='tspan'])[4]"));
		ElementUtils.waitForElementToDisplay(budgetVal, 100);
		adrWidgetArray.add(budgetVal.getText());

		Thread.sleep(5000);

		WebElement forecastVal = driver.findElement(By.xpath("(//div[3]//*[local-name()='svg' and @role='group']//*[local-name()='tspan'])[5]"));
		ElementUtils.waitForElementToDisplay(forecastVal, 100);
		adrWidgetArray.add(forecastVal.getText());

		Thread.sleep(5000);

		WebElement lastYearVal = driver.findElement(By.xpath("(//div[3]//*[local-name()='svg' and @role='group']//*[local-name()='tspan'])[2]"));
		ElementUtils.waitForElementToDisplay(lastYearVal, 100);
		adrWidgetArray.add(lastYearVal.getText());

		Thread.sleep(5000);

		WebElement pastYearVal = driver.findElement(By.xpath("(//div[3]//*[local-name()='svg' and @role='group']//*[local-name()='tspan'])[3]"));
		ElementUtils.waitForElementToDisplay(pastYearVal, 100);
		adrWidgetArray.add(pastYearVal.getText());

	}

	public boolean comparingTwoRecArraysADR() {

		boolean flag = true;

		try {
			for (int i = 0; i < adrByProTableArray.size(); i++) {

				String adrByProTableVal = adrByProTableArray.get(i).replace("%", "");
				String adrWidgetVal = adrWidgetArray.get(i).replace("%", "");

				if (adrByProTableVal.equalsIgnoreCase(adrWidgetVal)) {

					System.out.println("PASS");
					System.out.println(adrByProTableArray.get(i) + " <<<--////Pass////-->>> " + adrWidgetArray.get(i));

				} else {
					flag = false;
					System.out.println("Fail");
					System.out.println(adrByProTableArray.get(i) + " <<<--////fail////-->>> " + adrWidgetArray.get(i));

				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;

	}

	public void deleteColumnADR() throws InterruptedException {

		Thread.sleep(3000);
		WebElement lastDeleteButADR = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(lastDeleteButtonADR));
		lastDeleteButADR.click();

		Thread.sleep(3000);
		WebElement verifydeleteHeader = new WebDriverWait(driver, Duration.ofSeconds(25)).until(ExpectedConditions.visibilityOf(verifydeleteColum));
		verifydeleteHeader.isDisplayed();

		Thread.sleep(3000);
		WebElement okBut = new WebDriverWait(driver, Duration.ofSeconds(25)).until(ExpectedConditions.visibilityOf(okButt));
		okBut.click();

		WebElement popupMessage = new WebDriverWait(driver, Duration.ofSeconds(25)).until(ExpectedConditions.visibilityOf(popupMsgDisplay));
		popupMessage.isDisplayed();
		Thread.sleep(3000);

		WebElement imDoneButton = new WebDriverWait(driver, Duration.ofSeconds(25)).until(ExpectedConditions.visibilityOf(imDoneButt));
		imDoneButton.isDisplayed();

	}

	public boolean selectSpecificDateADR() throws InterruptedException {
		boolean flag = false;
		String[] dateForPicker = configReader.getProp("widgetsCal_Specific_Date_ADR").split("/");

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

	public boolean selectSpecificDateFirstADR() throws InterruptedException {
		boolean flag = false;
		String[] dateForPicker = configReader.getProp("widgetsCal_Specific_Date_ADR").split("/");

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
			Thread.sleep(5000);

			int btnStatus = driver.findElements(By.xpath("//button[text()='OK']")).size();

			if (btnStatus > 0) {
				WebElement btnOk = driver.findElement(By.xpath("//button[text()='OK']"));
				btnOk.click();
			} else {
				txtDate.click();
			}

			flag = true;

		} else {
			flag = false;
		}

		return flag;

	}

	public boolean selectLastYearDateADR() throws InterruptedException {
		boolean flag = false;
		String[] dateForPicker = configReader.getProp("widgetsCal_Last_Year_Date_ADR").split("/");

		int datePickerReClickToClose = driver
				.findElements(By.xpath("//div//label[text() = 'Date'] /following-sibling::div//input")).size();

		if (datePickerReClickToClose > 0) {
			txtDate.click();
		}

		int btnDatePickforLocal = driver
				.findElements(By.xpath("//div//label[text() = 'Date'] //following-sibling::div//button")).size();

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
			Thread.sleep(5000);

			int btnStatus = driver.findElements(By.xpath("//button[text()='OK']")).size();

			if (btnStatus > 0) {
				WebElement btnOk = driver.findElement(By.xpath("//button[text()='OK']"));
				btnOk.click();
			} else {
				txtDate.click();
			}

			flag = true;

		} else {
			flag = false;
		}

		return flag;

	}

	
	
	
	public void selectRevPARPeriod() throws InterruptedException {

		Thread.sleep(3000);

		if (revParWidgetHeader.isEnabled()) {
			WebElement revParWidget = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(revParWidgetHeader));
			revParWidget.isDisplayed();
		}

		Thread.sleep(5000);

		if (revParPeriodDropdown.isEnabled()) {
			WebElement revParPeriod = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(revParPeriodDropdown));
			revParPeriod.click();

			for (int i = 0; i < drpValueListSize.size(); i++) {
				if (drpValueListSize.get(i).getText().equalsIgnoreCase(configReader.getProp("widgetsCal_MTD"))) {
					drpValueListSize.get(i).click();
				}
			}
		}

	}

	public void addNewRevPARRecord() throws InterruptedException {

		Thread.sleep(3000);
		deleteColumnIfExist("RevPAR_Test");
		Thread.sleep(5000);

		WebElement clickAddColumnBtt = new WebDriverWait(driver, Duration.ofSeconds(25)).until(ExpectedConditions.visibilityOf(addColumnBtt));
		clickAddColumnBtt.click();

		Thread.sleep(3000);
		WebElement addNameFeildClick = new WebDriverWait(driver, Duration.ofSeconds(25)).until(ExpectedConditions.visibilityOf(addName));
		addNameFeildClick.click();

		addNameText.sendKeys(Keys.CONTROL + "a");
		addNameText.sendKeys(Keys.DELETE);
		addNameText.sendKeys(configReader.getProp("widgetsCal_Add_RevPAR_Name"));

		Thread.sleep(3000);
		WebElement addKpiFeildClick = new WebDriverWait(driver, Duration.ofSeconds(25)).until(ExpectedConditions.visibilityOf(addKpi));
		addKpiFeildClick.click();

		addKpiText.sendKeys(Keys.CONTROL + "a");
		addKpiText.sendKeys(Keys.DELETE);
		addKpiText.sendKeys(configReader.getProp("widgetsCal_Add_RevPAR_Kpi"));

		try {
			for (int r = 0; r < listDrpValueSize.size(); r++) {
				if (listDrpValueSize.get(r).getText().equalsIgnoreCase(configReader.getProp("widgetsCal_Add_RevPAR_Kpi"))) {
					listDrpValueSize.get(r).click();
				}
			}
		}catch(StaleElementReferenceException e) {
			for (int r = 0; r < listDrpValueSize.size(); r++) {
				if (listDrpValueSize.get(r).getText().equalsIgnoreCase(configReader.getProp("widgetsCal_Add_RevPAR_Kpi"))) {
					listDrpValueSize.get(r).click();
				}
			}
		}

		Thread.sleep(3000);
		WebElement addAmountTypeFeildClick = new WebDriverWait(driver, Duration.ofSeconds(25)).until(ExpectedConditions.visibilityOf(addAmountType));
		addAmountTypeFeildClick.click();

		Thread.sleep(3000);
		try {
			for (int s = 0; s < drpValueListSize.size(); s++) {
				if (drpValueListSize.get(s).getText().equalsIgnoreCase(configReader.getProp("widgetsCal_Add_ACTUAL"))) {
					drpValueListSize.get(s).click();
				}
			}
		}catch(StaleElementReferenceException e) {
			for (int s = 0; s < drpValueListSize.size(); s++) {
				if (drpValueListSize.get(s).getText().equalsIgnoreCase(configReader.getProp("widgetsCal_Add_ACTUAL"))) {
					drpValueListSize.get(s).click();
				}
			}
		}

		Thread.sleep(3000);

		try {
			WebElement clickSaveBtt = new WebDriverWait(driver, Duration.ofSeconds(25)).until(ExpectedConditions.visibilityOf(saveBtt));
			clickSaveBtt.click();

			WebElement popupMessage = new WebDriverWait(driver, Duration.ofSeconds(25)).until(ExpectedConditions.visibilityOf(popupMsgDisplay));
			popupMessage.isDisplayed();
			
		} catch (Exception e) {
			WebElement buttonCancel = new WebDriverWait(driver, Duration.ofSeconds(25)).until(ExpectedConditions.visibilityOf(btnCancel));
			buttonCancel.click();
		}

		WebElement revParTableHeader = new WebDriverWait(driver, Duration.ofSeconds(100)).until(ExpectedConditions.visibilityOf(revParHeader));
		revParTableHeader.isDisplayed();
	}

	public void editAmountTypeAndCaptureRecRevPAR() throws InterruptedException {

		for (int i = 0; i < 3; i++) {

			Thread.sleep(3000);
			if (lastEditButtonRevPar.isEnabled()) {
				WebElement lstEditBttRevPar = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(lastEditButtonRevPar));
				lstEditBttRevPar.click();
			}

			Thread.sleep(3000);
			if (verifyEditColum.isEnabled()) {
				WebElement checkEditColumn = new WebDriverWait(driver, Duration.ofSeconds(25)).until(ExpectedConditions.visibilityOf(verifyEditColum));
				checkEditColumn.isDisplayed();
			}

			Thread.sleep(3000);
			WebElement addAmountTypeFeildClick = new WebDriverWait(driver, Duration.ofSeconds(25)).until(ExpectedConditions.visibilityOf(addAmountType));
			addAmountTypeFeildClick.click();

			Thread.sleep(3000);
			drpValueListSize.get(i).click();
			Thread.sleep(3000);

			WebElement clickSaveBtt = new WebDriverWait(driver, Duration.ofSeconds(25)).until(ExpectedConditions.visibilityOf(saveBtt));
			clickSaveBtt.click();

			WebElement popupMessage = new WebDriverWait(driver, Duration.ofSeconds(25)).until(ExpectedConditions.visibilityOf(popupMsgDisplay));
			popupMessage.isDisplayed();
			
			Thread.sleep(15000);
			WebElement revParPortfolioTotal = driver.findElement(By.xpath("//table//tr[last()]//td[count(//table//th[.='RevPAR_Test']/preceding-sibling::*)+1]"));
			revParByProTableArray.add(revParPortfolioTotal.getText());

		}

	}

	public void captureRecByYearRevPAR() throws InterruptedException {

		Thread.sleep(5000);
		if (lastEditButtonRevPar.isEnabled()) {
			WebElement lstEditBttRevPar = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(lastEditButtonRevPar));
			lstEditBttRevPar.click();
		}

		Thread.sleep(3000);
		if (verifyEditColum.isEnabled()) {
			WebElement checkEditColumn = new WebDriverWait(driver, Duration.ofSeconds(50)).until(ExpectedConditions.visibilityOf(verifyEditColum));
			checkEditColumn.isDisplayed();
		}

		Thread.sleep(3000);
		WebElement addAmountTypeFeildClick = new WebDriverWait(driver, Duration.ofSeconds(25)).until(ExpectedConditions.visibilityOf(addAmountType));
		addAmountTypeFeildClick.click();
		try {
			for (int s = 0; s < drpValueListSize.size(); s++) {
				if (drpValueListSize.get(s).getText().equalsIgnoreCase(configReader.getProp("widgetsCal_Add_ACTUAL"))) {
					drpValueListSize.get(s).click();
				}
			}
		}catch(StaleElementReferenceException e) {
			for (int s = 0; s < drpValueListSize.size(); s++) {
				if (drpValueListSize.get(s).getText().equalsIgnoreCase(configReader.getProp("widgetsCal_Add_ACTUAL"))) {
					drpValueListSize.get(s).click();
				}
			}
		}

		Thread.sleep(3000);
		WebElement clickSaveBtt = new WebDriverWait(driver, Duration.ofSeconds(25)).until(ExpectedConditions.visibilityOf(saveBtt));
		clickSaveBtt.click();

		WebElement popupMessage = new WebDriverWait(driver, Duration.ofSeconds(25)).until(ExpectedConditions.visibilityOf(popupMsgDisplay));
		popupMessage.isDisplayed();
		
		Thread.sleep(15000);
		WebElement revParPortfolioTotal = driver.findElement(By.xpath("//table//tr[last()]//td[count(//table//th[.='RevPAR_Test']/preceding-sibling::*)+1]"));
		revParByProTableArray.add(revParPortfolioTotal.getText());

	}

	public void captureRecInGraphRevPAR() throws InterruptedException {

		Thread.sleep(3000);

		if (revParWidgetHeader.isEnabled()) {
			WebElement revParWidget = new WebDriverWait(driver, Duration.ofSeconds(25)).until(ExpectedConditions.visibilityOf(revParWidgetHeader));
			revParWidget.isDisplayed();
		}

		Thread.sleep(5000);

		WebElement actualVal = driver.findElement(By.xpath("(//div[4]//*[local-name()='svg' and @role='group']//*[local-name()='tspan'])[1]"));
		ElementUtils.waitForElementToDisplay(actualVal, 100);
		revParWidgetArray.add(actualVal.getText());

		Thread.sleep(5000);

		WebElement budgetVal = driver.findElement(By.xpath("(//div[4]//*[local-name()='svg' and @role='group']//*[local-name()='tspan'])[4]"));
		ElementUtils.waitForElementToDisplay(budgetVal, 100);
		revParWidgetArray.add(budgetVal.getText());

		Thread.sleep(5000);

		WebElement forecastVal = driver.findElement(By.xpath("(//div[4]//*[local-name()='svg' and @role='group']//*[local-name()='tspan'])[5]"));
		ElementUtils.waitForElementToDisplay(forecastVal, 100);
		revParWidgetArray.add(forecastVal.getText());

		Thread.sleep(5000);

		WebElement lastYearVal = driver.findElement(By.xpath("(//div[4]//*[local-name()='svg' and @role='group']//*[local-name()='tspan'])[2]"));
		ElementUtils.waitForElementToDisplay(lastYearVal, 100);
		revParWidgetArray.add(lastYearVal.getText());

		Thread.sleep(5000);

		WebElement pastYearVal = driver.findElement(By.xpath("(//div[4]//*[local-name()='svg' and @role='group']//*[local-name()='tspan'])[3]"));
		ElementUtils.waitForElementToDisplay(pastYearVal, 100);
		revParWidgetArray.add(pastYearVal.getText());

	}

	public boolean comparingTwoRecArraysRevPAR() {

		boolean flag = true;

		try {
			for (int i = 0; i < revParByProTableArray.size(); i++) {

				String revParByProTableVal = revParByProTableArray.get(i).replace("%", "");
				String revParWidgetVal = revParWidgetArray.get(i).replace("%", "");

				if (revParByProTableVal.equalsIgnoreCase(revParWidgetVal)) {

					System.out.println("PASS");
					System.out.println(
							revParByProTableArray.get(i) + " <<<--////Pass////-->>> " + revParWidgetArray.get(i));

				} else {
					flag = false;
					System.out.println("Fail");
					System.out.println(
							revParByProTableArray.get(i) + " <<<--////fail////-->>> " + revParWidgetArray.get(i));

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;

	}

	public void deleteColumnRevPAR() throws InterruptedException {

		Thread.sleep(3000);

		if (lastDeleteButtonRevPar.isEnabled()) {
			WebElement lastDeleteButRevPar = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(lastDeleteButtonRevPar));
			lastDeleteButRevPar.click();
		}

		Thread.sleep(3000);

		if (verifydeleteColum.isEnabled()) {
			WebElement verifydeleteHeader = new WebDriverWait(driver, Duration.ofSeconds(25)).until(ExpectedConditions.visibilityOf(verifydeleteColum));
			verifydeleteHeader.isDisplayed();
		}

		Thread.sleep(3000);

		WebElement okBut = new WebDriverWait(driver, Duration.ofSeconds(25)).until(ExpectedConditions.visibilityOf(okButt));
		okBut.click();

		WebElement popupMessage = new WebDriverWait(driver, Duration.ofSeconds(25)).until(ExpectedConditions.visibilityOf(popupMsgDisplay));
		popupMessage.isDisplayed();
		Thread.sleep(3000);

		if (imDoneButt.isEnabled()) {
			WebElement imDoneButton = new WebDriverWait(driver, Duration.ofSeconds(25)).until(ExpectedConditions.visibilityOf(imDoneButt));
			imDoneButton.isDisplayed();
		}

	}

	public boolean selectSpecificDateRevPAR() throws InterruptedException {
		boolean flag = false;
		String[] dateForPicker = configReader.getProp("widgetsCal_Specific_Date_RevPAR").split("/");

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

	public boolean selectSpecificDateFirstRevPAR() throws InterruptedException {
		boolean flag = false;
		String[] dateForPicker = configReader.getProp("widgetsCal_Specific_Date_RevPAR").split("/");

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
			Thread.sleep(5000);

			int datePickerReClickToClose = driver.findElements(By.xpath("//div//label[text() = 'Date'] /following-sibling::div//input")).size();

			int btnStatus = driver.findElements(By.xpath("//button[text()='OK']")).size();

			if (btnStatus > 0) {
				WebElement btnOk = driver.findElement(By.xpath("//button[text()='OK']"));
				btnOk.click();
			} else {
				txtDate.click();
			}

			flag = true;

		} else {
			flag = false;
		}

		return flag;

	}

	public boolean selectLastYearDateRevPAR() throws InterruptedException {
		boolean flag = false;
		String[] dateForPicker = configReader.getProp("widgetsCal_Last_Year_Date_RevPAR").split("/");

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
			Thread.sleep(5000);

			int btnStatus = driver.findElements(By.xpath("//button[text()='OK']")).size();

			if (btnStatus > 0) {
				WebElement btnOk = driver.findElement(By.xpath("//button[text()='OK']"));
				btnOk.click();
			} else {
				txtDate.click();
			}

			flag = true;

		} else {
			flag = false;
		}

		return flag;

	}

	public void deleteColumnIfExist(String columnName) throws InterruptedException {
		Thread.sleep(10000);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
		wait.until(ExpectedConditions.elementToBeClickable(editBtn));
		try {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", editBtn);
		} catch (Exception e) {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", editBtn);
			executor.executeScript("arguments[0].click();", editBtn);
		}

		WebElement insigniaELView = new WebDriverWait(driver, Duration.ofSeconds(150)).until(ExpectedConditions.visibilityOf(insigniaEL));
		insigniaELView.isDisplayed();

		int sizeOfAddingColumn = driver.findElements(By.xpath("//button[@data-el='button-delete-" + columnName + "']")).size();

		System.out.println("size of column is " + sizeOfAddingColumn);

		if (sizeOfAddingColumn == 1) {
			WebElement btnDelete = driver.findElement(By.xpath("//button[@data-el='button-delete-" + columnName + "']"));

			btnDelete.click();

			Thread.sleep(2500);
			WebElement dialogBoxEle = new WebDriverWait(driver, Duration.ofSeconds(100)).until(ExpectedConditions.visibilityOf(dialogBox));
			dialogBoxEle.isDisplayed();

			Thread.sleep(2500);

			WebElement btnOkEle = new WebDriverWait(driver, Duration.ofSeconds(100)).until(ExpectedConditions.visibilityOf(btnDeleteConfirmation));
			btnOkEle.click();
			
			Thread.sleep(2000);

			WebElement insigniaELViewRe = new WebDriverWait(driver, Duration.ofSeconds(300)).until(ExpectedConditions.visibilityOf(insigniaEL));
			insigniaELViewRe.isDisplayed();

			Thread.sleep(10000);

		}

	}

}
