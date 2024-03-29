package myP1_pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.cache.Cache;

import utils.ConstantsReader;
import utils.ElementUtils;

public class propertyDashboard_EditFunctionality_PageObjects {

	WebDriver driver;

	private ConstantsReader configReader = new ConstantsReader();

	public propertyDashboard_EditFunctionality_PageObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[@id='btnEditDashboard']")
	WebElement editBtn;

	@FindBy(xpath = "//button[@id='btnAddChart']")
	WebElement addChartBtn;

	@FindBy(xpath = "//button[@id='btnSaveEditDashboard']")
	WebElement saveBtn;

	@FindBy(xpath = "//h4[text()='Add Chart']")
	WebElement AddChartModal;

	@FindBy(xpath = "//div[@id='addChartModal']//button[text()='Close']")
	WebElement closeAddChartModal;

	@FindBy(xpath = "//button[@id='btnsave']")
	WebElement SubmitModalBtn;

//	@FindBy(xpath = "(//th[@class='center num sorting_disabled']//select)[1]")
	@FindBy(xpath = "(//th[contains(@class,'center')]//select)[1]")
	WebElement dashboardTblColOptions;

	@FindBy(xpath = "//th[contains(@class,'center num sorting_disabled')]/span[not(@id)]")
	List<WebElement> dashboardTblColumns;

	@FindBy(xpath = "(//button[text()='Confirm'])[1]")
	WebElement removeConfirmBtn;

	@FindBy(xpath = "//a[@id='btnAdd']")
	WebElement addNewColumnBtn;

	@FindBy(xpath = "//input[@id='NoofCols_Detail']")
	WebElement noOfCols;

	// check Add Chart Functionality

	public void clickEdit() throws InterruptedException {
		WebElement editbtnView = new WebDriverWait(driver, Duration.ofSeconds(700))
				.until(ExpectedConditions.visibilityOf(editBtn));
		System.out.println("==View edit button==");
		Thread.sleep(2000);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", editbtnView);
		System.out.println("==clicked edit button==");
		int editButtonView = driver.findElements(By.xpath("//button[@id='btnEditDashboard']")).size();
		if(editButtonView>0) {
			WebElement refreshButton = driver.findElement(By.xpath("//button[@title='Refresh']"));
			refreshButton.click();
			Thread.sleep(3000);
			WebElement editbtnWait = new WebDriverWait(driver, Duration.ofSeconds(700))
					.until(ExpectedConditions.visibilityOf(editBtn));
			try {
				JavascriptExecutor exe = (JavascriptExecutor) driver;
				exe.executeScript("arguments[0].click();", editbtnView);
			} catch (Exception e) {
				JavascriptExecutor exe = (JavascriptExecutor) driver;
				exe.executeScript("arguments[0].click();", editbtnView);
			}
			
		}
		Thread.sleep(3000);
	}

	public void addChart() throws InterruptedException {
		WebElement addChartbtn = new WebDriverWait(driver, Duration.ofSeconds(500))
				.until(ExpectedConditions.visibilityOf(addChartBtn));
		addChartBtn.click();
	}

	public boolean verifyAddChartPopupDisplayed() {
		WebElement addChartModal = new WebDriverWait(driver, Duration.ofSeconds(500))
				.until(ExpectedConditions.visibilityOf(AddChartModal));
		if (addChartModal.isDisplayed()) {
			System.out.println("==Add Chart Modal Displayed==");
			return true;
		} else {
			System.out.println("==Add Chart Modal not Displayed==");
			return false;
		}
	}

	public void removeChart() throws InterruptedException {
		WebElement removingPanel = driver.findElement(
				By.xpath("//div[@id='" + configReader.getMYP1Prop("Panel_switch_id") + "']//div[@class='ios-switch on']"));

		WebElement submitbtn = driver.findElement(By.xpath("//button[@id='btnsave']"));
		if (removingPanel.isDisplayed()) {
			removingPanel.click();
			WebElement waitforSwitchoff = new WebDriverWait(driver, Duration.ofSeconds(900))
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='"
							+ configReader.getMYP1Prop("Panel_switch_id") + "']//div[@class='ios-switch off']")));
			if (waitforSwitchoff.isDisplayed()) {
				submitbtn.click();
				System.out.println("swith disabled");
				Thread.sleep(7000);
			}
		} else {
			System.out.println("swith already disabled");
		}
	}

	public boolean verifyChartRemoved() throws InterruptedException {
		Thread.sleep(7000);
		boolean waitAddChartClose = new WebDriverWait(driver, Duration.ofSeconds(900))
				.until(ExpectedConditions.invisibilityOfElementLocated(
						By.xpath("//h4[text()='Add Chart']")));		
		Thread.sleep(7000);
		if (waitAddChartClose) {
			Thread.sleep(7000);
			int removingChart = driver
					.findElements(By.xpath("//a[@data-content='" + configReader.getMYP1Prop("Panel_switch_id") + "']")).size();
			Thread.sleep(3000);
			if (removingChart>0) {
				System.out.println("Chart not removed");
				return false;
			} else {
				System.out.println("Removed Chart Successfully!");
				return true;
			}
		} else {
			System.out.println("////////////");
			return false;
		}
	}

	// Re-Add removed Chart

	public void reSelectRemovedChart() throws InterruptedException {

		WebElement addingPanel = driver.findElement(
				By.xpath("//div[@id='" + configReader.getMYP1Prop("Panel_switch_id") + "']//div[@class='ios-switch off']"));

		if (addingPanel.isDisplayed()) {
			addingPanel.click();
			WebElement waitforSwitchon = new WebDriverWait(driver, Duration.ofSeconds(100))
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='"
							+ configReader.getMYP1Prop("Panel_switch_id") + "']//div[@class='ios-switch on']")));
			System.out.println("swith enabled");
		} else {
			System.out.println("swith already enabled");
		}
		SubmitModalBtn.click();

		Thread.sleep(7000);
	}

	public boolean verifyAddedChartIsLoaded() throws InterruptedException {
		Thread.sleep(7000);
		boolean waitAddChartClose = new WebDriverWait(driver, Duration.ofSeconds(100))
				.until(ExpectedConditions.invisibilityOfElementLocated(
						By.xpath("//h4[text()='Add Chart']")));

		int addingChart = driver
				.findElements(By.xpath("//a[@data-content='" + configReader.getMYP1Prop("Panel_switch_id") + "']")).size();
		
		Thread.sleep(7000);

		if (addingChart>0) {
			System.out.println("Chart Added Successfully!");
			return true;
		} else {
			System.out.println("Chart not Loaded");
			return false;
		}
	}

	// Edit table

	public void removeColumn() throws InterruptedException {
		Thread.sleep(7000);
		Thread.sleep(7000);
		WebElement scroll_left = new WebDriverWait(driver, Duration.ofSeconds(700))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//th[last()])[1]")));	
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		// Scroll Left
		jse.executeScript("arguments[0].scrollIntoView()", scroll_left);
		Thread.sleep(25000);
		
		WebElement removingCol = new WebDriverWait(driver, Duration.ofSeconds(700))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//th[last()])[1]/span[contains(text(),'"
						+ configReader.getMYP1Prop("Remove_Column") + "')]//following::a[@class='colRemove'][1]")));		
			
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", removingCol);
		saveBtn.click();
		Thread.sleep(7000);
	}

	public void enableRemoveConfirm() throws InterruptedException {
		Thread.sleep(7000);
		WebElement removeConfirm = new WebDriverWait(driver, Duration.ofSeconds(100))
				.until(ExpectedConditions.visibilityOf(removeConfirmBtn));
		if (removeConfirm.isDisplayed()) {
			removeConfirm.click();
			Thread.sleep(7000);
			System.out.println("==Column remove confirmed==");
		} else {
			System.out.println("==Remove confirmation Modal isn't Displayed==");
		}
	}

	public boolean verifyColRemoved() throws InterruptedException {
		Thread.sleep(7000);
		WebElement waitEditButtonPreview = new WebDriverWait(driver, Duration.ofSeconds(900))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='btnEditDashboard' and @style='display: inline-block;']")));
		
		for (int i = 0; i < dashboardTblColumns.size(); i++) {
			if (dashboardTblColumns.get(i).getText().equalsIgnoreCase(configReader.getMYP1Prop("Remove_Column"))) {
				System.out.println("==Column already exists ==");
				return false;
			}
		}
		System.out.println("==Column removed successfully==");
		Thread.sleep(7000);
		return true;
	}

	public void addNewColumn() throws InterruptedException {
		Thread.sleep(7000);
		Thread.sleep(3000);
		WebElement addNewColBtn = new WebDriverWait(driver, Duration.ofSeconds(500))
				.until(ExpectedConditions.visibilityOf(addNewColumnBtn));

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", addNewColBtn);
		
		noOfCols.sendKeys(Keys.CONTROL + "a");
		noOfCols.sendKeys(Keys.DELETE);
		noOfCols.sendKeys("1");
		WebElement saveButton = new WebDriverWait(driver, Duration.ofSeconds(500))
				.until(ExpectedConditions.visibilityOf(saveBtn));
		JavascriptExecutor exe = (JavascriptExecutor) driver;
		exe.executeScript("arguments[0].click();", saveButton);
		
		System.out.println("==New Column Added==");
		Thread.sleep(7000);
		boolean waitSaveBtnInvisible = new WebDriverWait(driver, Duration.ofSeconds(900))
		.until(ExpectedConditions.invisibilityOfElementLocated(
				By.xpath("//button[@id='btnSaveEditDashboard']")));
		Thread.sleep(5000);
	}

	public void selectColumn() throws InterruptedException {
		Thread.sleep(7000);
		int noOfCol=(dashboardTblColumns.size())-1;
		System.out.println("====noofcols===="+dashboardTblColumns.size());
		System.out.println("====col class no===="+noOfCol);
		List<WebElement> removingCol = driver.findElements(By
				.xpath("(//select[@id='ddlCols"+ noOfCol + "'])[1]//option"));

		WebElement waitToViewAddChart = new WebDriverWait(driver, Duration.ofSeconds(500))
				.until(ExpectedConditions.visibilityOf(saveBtn));
		
		for (int i = 0; i < removingCol.size(); i++) {
			if (removingCol.get(i).getText().equalsIgnoreCase(configReader.getMYP1Prop("Remove_Column"))) {
				System.out.println("add tags list item ===" + removingCol.get(i).getText());
				removingCol.get(i).click();
			}
		}
		System.out.println("after removing column");
		Thread.sleep(7000);
		saveBtn.click();
		try {
			WebElement waitTablePreview = new WebDriverWait(driver, Duration.ofSeconds(900))
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//td[text()='Total Property'])[1]")));
		} catch (Exception e) {
			WebElement waitTablePreview = new WebDriverWait(driver, Duration.ofSeconds(900))
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//td[text()='Total Property'])[1]")));
		}
		Thread.sleep(7000);
		System.out.println("save button clicked");
	}

	public boolean verifyColAdded() throws InterruptedException {
		Thread.sleep(7000);
		WebElement waitTablePreview = new WebDriverWait(driver, Duration.ofSeconds(900))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'DTFC_LeftBodyLiner')]/table/tbody/tr/td[text()='Total Property']")));
		WebElement editbtnView = new WebDriverWait(driver, Duration.ofSeconds(700))
				.until(ExpectedConditions.visibilityOf(editBtn));
		System.out.println("==View edit button==");
		Thread.sleep(2000);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", editbtnView);
		int noOfCol=dashboardTblColumns.size();
		System.out.println(noOfCol);
		System.out.println("no of col== "+noOfCol);
		for (int i = 1; i <= noOfCol; i++) {
			System.out.println(dashboardTblColumns.get(i)+" =====================");
			if (dashboardTblColumns.get(i).getText().equalsIgnoreCase(configReader.getMYP1Prop("Remove_Column"))) {
				System.out.println("==Column added successfully==");
				return true;
			}
		}
		System.out.println("==Column not exists ==");
		return false;
	}

	// Close individual chart

	public void removeSelectedChart() {
		WebElement removingChart = driver
				.findElement(By.xpath("//a[@data-content='" + configReader.getMYP1Prop("Panel_switch_id") + "']"));
		removingChart.click();
		saveBtn.click();
	}

}
