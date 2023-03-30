package myP1_pageObjects;

import java.time.Duration;
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

public class portfolioDashboard_Edit_PageObjects {

	private WebDriver driver;
	private ConstantsReader configReader = new ConstantsReader();

	public portfolioDashboard_Edit_PageObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[@title='Edit']")
	WebElement editBtn;

	@FindBy(xpath = "//button[@title='Save']")
	WebElement saveBtn;

	@FindBy(xpath = "//a[@id='btnAddConsolidate']")
	WebElement addColBtn;

	@FindBy(xpath = "//input[@id='NoofCols']")
	WebElement noOfColTxt;

	@FindBy(xpath = "(//a[@title='Sort Ascending'])[1]")
	WebElement ascendingArrows;


	@FindBy(xpath = "//div[@id='modalAnim2']//button[text()='Confirm']")
	WebElement columnRmvConfirmBtn;

	static int currentNoOfCol;

	// Add Column
	public void clickEditBtn() {
		editBtn.click();
		WebElement waitForAddColBtnView = new WebDriverWait(driver, Duration.ofSeconds(700))
				.until(ExpectedConditions.visibilityOf(addColBtn));
		currentNoOfCol = driver.findElements(By.xpath("//table[@id='adminPortfolio']//th[contains(@class,'center')]")).size();
		System.out.println("cols="+ currentNoOfCol);
	}

	public void addColumn() {
		addColBtn.click();
		noOfColTxt.sendKeys(Keys.CONTROL + "a");
		noOfColTxt.sendKeys(Keys.DELETE);
		noOfColTxt.sendKeys("1");
		saveBtn.click();
		try {
			WebElement waitFortblView = new WebDriverWait(driver, Duration.ofSeconds(2000))
					.until(ExpectedConditions.visibilityOf(ascendingArrows));
		} catch (StaleElementReferenceException  ex) {
		}
	}

	public boolean verifyColAdded() {
		int currentNoOfColAfterAddedCol = driver
				.findElements(By.xpath("//table[@id='adminPortfolio']//th[contains(@class,'center')]")).size();

//		System.out.println("currentNoOfCol==" + currentNoOfCol);
//		System.out.println("currentNoOfColAfterAddedColl==" + currentNoOfColAfterAddedCol);

		if (currentNoOfColAfterAddedCol > currentNoOfCol) {
			System.out.println("Column added successfully!");
			return true;
		} else {
			System.out.println("Column not added!");
			return false;
		}
	}

	// Remove Column

	public void deleteColumn() throws InterruptedException {
		WebElement scroll_left = new WebDriverWait(driver, Duration.ofSeconds(700))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//th[last()])[1]")));	
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView()", scroll_left);
		Thread.sleep(3000);
		int currentCol = currentNoOfCol + 1;
		WebElement closeColBtn = driver.findElement(By.xpath("//th[@data-name='" + currentCol + "']//div//a"));
		WebElement waitcloseColBtnView = new WebDriverWait(driver, Duration.ofSeconds(1000))
				.until(ExpectedConditions.visibilityOf(closeColBtn));
		closeColBtn.click();
		saveBtn.click();
	}

	public void clickRemoveConfirm() throws InterruptedException {
		Thread.sleep(3000);
		WebElement waitcolumnRmvConfirmBtnView = new WebDriverWait(driver, Duration.ofSeconds(1000))
				.until(ExpectedConditions.visibilityOf(columnRmvConfirmBtn));
		columnRmvConfirmBtn.click();
		WebElement waitFortblView = new WebDriverWait(driver, Duration.ofSeconds(1000))
				.until(ExpectedConditions.visibilityOf(ascendingArrows));
	}
	
	public void clickEditToVerify() {
		editBtn.click();
		WebElement waitForAddColBtnView = new WebDriverWait(driver, Duration.ofSeconds(700))
				.until(ExpectedConditions.visibilityOf(addColBtn));
	}

	public boolean verifyColRemoved() {
		int currentNoOfColAfterAddedCol3 = driver
				.findElements(By.xpath("//table[@id='adminPortfolio']//th[contains(@class,'center')]")).size();
		if (currentNoOfColAfterAddedCol3 == currentNoOfCol) {
			System.out.println("Column removed successfully!");
			return true;
		} else {
			System.out.println("Column not removed!");
			return false;
		}
	}


}
