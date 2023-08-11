package myP2_pageObjects;

import java.time.Duration;
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

public class GLHierarchy_PageObject {

	String capturedModal;
	private WebDriver driver;
	private ConstantsReader configReader = new ConstantsReader();

	public GLHierarchy_PageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[@data-el='menuToggle']")
	WebElement mainMenuButton;

	@FindBy(xpath = "//div[text()='Configuration']//ancestor::li")
	WebElement configuration;

	@FindBy(xpath = "//div[text()='P&L Mapping']//ancestor::li")
	WebElement pnlMapping;

	@FindBy(xpath = "//div//a[text()='GL Hierarchy']//ancestor::li")
	WebElement glHierarchy;

	@FindBy(xpath = "//h1[text()='GL Hierarchy']")
	WebElement glHierarchyPage;

	@FindBy(xpath = "//button[@data-el='buttonAllOn']")
	WebElement btnAllon;

	@FindBy(xpath = "//div[text()='Successfully updated all statuses.']")
	WebElement lblSuccess;

	@FindBy(xpath = "//tr[@data-el='RMREV90']//button")
	WebElement btnRoomRevenue;

	@FindBy(xpath = "//tr[@data-el='RMREV50']//button")
	WebElement btnRoomRevenueBeforeOther;

	@FindBy(xpath = "//tr[@data-el='RMREV10']//button")
	WebElement btnRoomContracts;

	@FindBy(xpath = "//tr[@data-el='RMGOP01']//button")
	WebElement glParent;

	@FindBy(xpath = "//tr[@data-el='RMREV90']//button")
	WebElement glRoomRevenue;

	@FindBy(xpath = "//tr[@data-el='RMREV90']//td[4]//input[@type='checkbox']")
	WebElement btnParentCapturedValueToggle;

	@FindBy(xpath = "//tr[@data-el='RMREV50']//button")
	WebElement glRoomRevenueBeofreOther;

	@FindBy(xpath = "//tr[@data-el='RMREV50']//td[4]//label[@data-el='switchLabel']//span[@data-el = 'switch']")
	WebElement btnTopCapturedValueToggle;

	@FindBy(xpath = "//tr[@data-el='RMREV10']//button")
	WebElement glRoomContracts;

	@FindBy(xpath = "//tr[@data-el='RMREV01']//td[4]//input[@type='checkbox']")
	WebElement btnBottomCapturedValueToggle;

	@FindBy(xpath = "//h3[text() = 'Turn Off Parent GL Code?']")
	WebElement confirmTurnOff;

	@FindBy(xpath = "//button[@mdo_variant='alert']")
	WebElement btnConfirm;

	@FindBy(xpath = "//div[text()='Successfully updated status.']")
	WebElement lblTurnOffMessage;
	
	@FindBy(xpath = "//input[@name='hotelId']")
	WebElement dropDownProperty;

	@FindBy(xpath = "//ul[@role='listbox']//li")
	List<WebElement> lstDropDowProperty;

	public void expandConfigurations() {

		try {
			WebElement menu = new WebDriverWait(driver, Duration.ofSeconds(20))
					.until(ExpectedConditions.visibilityOf(mainMenuButton));
			menu.click();

			Thread.sleep(1500);

			WebElement configurationEle = new WebDriverWait(driver, Duration.ofSeconds(20))
					.until(ExpectedConditions.visibilityOf(configuration));
			configurationEle.click();

			WebElement pnlMappingEle = new WebDriverWait(driver, Duration.ofSeconds(20))
					.until(ExpectedConditions.visibilityOf(pnlMapping));
			pnlMappingEle.click();

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public boolean navigateToGLHierarchy() {
		WebElement glHierarchyEle = new WebDriverWait(driver, Duration.ofSeconds(25))
				.until(ExpectedConditions.visibilityOf(glHierarchy));
		glHierarchyEle.click();

		WebElement glHierarchyPageEle = new WebDriverWait(driver, Duration.ofSeconds(25))
				.until(ExpectedConditions.visibilityOf(glHierarchyPage));
		
		return glHierarchyPageEle.isDisplayed();

	}

	public void clickAllOnToggle() throws InterruptedException {
		WebElement btnOn = new WebDriverWait(driver, Duration.ofSeconds(50))
				.until(ExpectedConditions.visibilityOf(btnAllon));

		btnOn.click();
	}

	public boolean verifyAllOnFunction() {
		WebElement succesLabel = new WebDriverWait(driver, Duration.ofSeconds(100))
				.until(ExpectedConditions.visibilityOf(lblSuccess));

		return succesLabel.isDisplayed();
	}

//===============================================Bottom Child Scenario================================================================
	public boolean captureBottomChildModal() throws InterruptedException {
		Thread.sleep(5000);

		WebElement btnRoomRev = new WebDriverWait(driver, Duration.ofSeconds(100))
				.until(ExpectedConditions.visibilityOf(btnRoomRevenue));

		btnRoomRev.click();

		WebElement btnRoomRevBeofreOther = new WebDriverWait(driver, Duration.ofSeconds(100))
				.until(ExpectedConditions.visibilityOf(btnRoomRevenueBeforeOther));

		btnRoomRevBeofreOther.click();

		int status = driver.findElements(By.xpath("//tr[@data-el='RMREV01']")).size();

		if (status == 1) {
			WebElement totalRoomCntract = driver.findElement(By.xpath("(//tr[@data-el='RMREV01']//td[1]//div)[last()]"));
			capturedModal = totalRoomCntract.getText();

			System.out.print("AAA  " + capturedModal);

			return true;
		} else {
			return false;
		}
	}

	public boolean turnOffBottomCapturedModal() throws InterruptedException {
		Thread.sleep(5000);

		WebElement glParentButton = new WebDriverWait(driver, Duration.ofSeconds(100))
				.until(ExpectedConditions.visibilityOf(glParent));

		glParentButton.click();

		WebElement glRoomRev = new WebDriverWait(driver, Duration.ofSeconds(25))
				.until(ExpectedConditions.visibilityOf(glRoomRevenue));

		glRoomRev.click();

		WebElement glRoomRevBeofreOther = new WebDriverWait(driver, Duration.ofSeconds(25))
				.until(ExpectedConditions.visibilityOf(glRoomRevenueBeofreOther));

		glRoomRevBeofreOther.click();

		String txtCapturedValue = driver.findElement(By.xpath("//tr[@data-el='RMREV01']//td[2]")).getText();

		System.out.println("AA" + txtCapturedValue + " BB" + capturedModal);
		if (capturedModal.equalsIgnoreCase(txtCapturedValue)) {

			btnBottomCapturedValueToggle.click();

//			ElementUtils.waitForElementToDisplay(confirmTurnOff, 100);

//			btnConfirm.click();

			WebElement lblSuccessmsg = new WebDriverWait(driver, Duration.ofSeconds(25))
					.until(ExpectedConditions.visibilityOf(lblTurnOffMessage));

			return lblSuccessmsg.isDisplayed();

		} else {
			return false;
		}

	}

	public boolean validateTurnedOffBottomModalinPnLMonth() throws InterruptedException {
		WebElement btnRoomRev = new WebDriverWait(driver, Duration.ofSeconds(100))
				.until(ExpectedConditions.visibilityOf(btnRoomRevenue));

		btnRoomRev.click();

		WebElement btnRoomRevBeofreOther = new WebDriverWait(driver, Duration.ofSeconds(100))
				.until(ExpectedConditions.visibilityOf(btnRoomRevenueBeforeOther));

		btnRoomRevBeofreOther.click();
		
		Thread.sleep(3000);

		int status = driver.findElements(By.xpath("//tr[@data-el='RMREV01']")).size();
		

		if (status == 0) {
			return true;
		} else {
			return false;
		}
	}
//===============================================Top Child Scenario =========================================================================================	

	public boolean captureTopChildModal() throws InterruptedException {
		Thread.sleep(5000);

		WebElement btnRoomRev = new WebDriverWait(driver, Duration.ofSeconds(100))
				.until(ExpectedConditions.visibilityOf(btnRoomRevenue));

		btnRoomRev.click();

		int status = driver.findElements(By.xpath("//tr[@data-el='RMREV50']")).size();

		if (status == 1) {
			WebElement totalRoomRevBefore = driver.findElement(By.xpath("//tr[@data-el='RMREV50']//td[1]"));
			capturedModal = totalRoomRevBefore.getText();

			System.out.println("AAA  " + capturedModal);

			return true;
		} else {
			return false;
		}
	}

	public boolean turnOffTopCapturedModal() throws InterruptedException {
		Thread.sleep(5000);

		WebElement glParentButton = new WebDriverWait(driver, Duration.ofSeconds(100))
				.until(ExpectedConditions.visibilityOf(glParent));

		glParentButton.click();

		WebElement glRoomRev = new WebDriverWait(driver, Duration.ofSeconds(90))
				.until(ExpectedConditions.visibilityOf(glRoomRevenue));

		glRoomRev.click();

		String txtCapturedValue = driver.findElement(By.xpath("//tr[@data-el='RMREV50']//td[2]")).getText();

		System.out.println("AA " + txtCapturedValue + " BB " + capturedModal);
		if (capturedModal.equalsIgnoreCase(txtCapturedValue)) {

			
			WebElement btnTopCapturedValueToggleEle = new WebDriverWait(driver, Duration.ofSeconds(25))
					.until(ExpectedConditions.visibilityOf(btnTopCapturedValueToggle));
			
			btnTopCapturedValueToggleEle.click();

			ElementUtils.waitForElementToDisplay(confirmTurnOff, 100);

			WebElement btnConfirmEle = new WebDriverWait(driver, Duration.ofSeconds(25))
					.until(ExpectedConditions.visibilityOf(btnConfirm));
			
			btnConfirmEle.click();

			WebElement lblSuccessmsg = new WebDriverWait(driver, Duration.ofSeconds(25))
					.until(ExpectedConditions.visibilityOf(lblTurnOffMessage));

			return lblSuccessmsg.isDisplayed();

		} else {
			return false;
		}

	}

	public boolean validateTurnedOffTopModalinPnLMonth() {
		WebElement btnRoomRev = new WebDriverWait(driver, Duration.ofSeconds(100))
				.until(ExpectedConditions.visibilityOf(btnRoomRevenue));

		btnRoomRev.click();

		int status = driver.findElements(By.xpath("//tr[@data-el='RMREV50']")).size();

		if (status == 0) {
			return true;
		} else {
			return false;
		}
	}

	// ===============================================Top parent Scenario
	// =========================================================================================

	public boolean captureParentModal() throws InterruptedException {
		Thread.sleep(5000);

		WebElement btnRoomRev = new WebDriverWait(driver, Duration.ofSeconds(100))
				.until(ExpectedConditions.visibilityOf(btnRoomRevenue));

		int status = driver.findElements(By.xpath("//tr[@data-el='RMREV90']")).size();

		if (status == 1) {
			WebElement totalRoomRevBefore = driver.findElement(By.xpath("//tr[@data-el='RMREV90']//td[1]"));
			capturedModal = totalRoomRevBefore.getText();

			System.out.print("AAA" + capturedModal);

			return true;
		} else {
			return false;
		}
	}

	public boolean turnOffParentCapturedModal() throws InterruptedException {
		Thread.sleep(5000);

		WebElement glParentButton = new WebDriverWait(driver, Duration.ofSeconds(100))
				.until(ExpectedConditions.visibilityOf(glParent));

		glParentButton.click();

		String txtCapturedValue = driver.findElement(By.xpath("//tr[@data-el='RMREV90']//td[2]")).getText();

		
		if (capturedModal.equalsIgnoreCase(txtCapturedValue)) {

			btnParentCapturedValueToggle.click();

			ElementUtils.waitForElementToDisplay(confirmTurnOff, 100);

			btnConfirm.click();

			WebElement lblSuccessmsg = new WebDriverWait(driver, Duration.ofSeconds(25))
					.until(ExpectedConditions.visibilityOf(lblTurnOffMessage));

			return lblSuccessmsg.isDisplayed();

		} else {
			return false;
		}

	}

	public boolean validateTurnedOffParentModalinPnLMonth() {

		int status = driver.findElements(By.xpath("//tr[@data-el='RMREV90']")).size();

		if (status == 0) {
			return true;
		} else {
			return false;
		}
	}

}
