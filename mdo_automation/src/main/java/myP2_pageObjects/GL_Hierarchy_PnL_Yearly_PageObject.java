package myP2_pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.ConstantsReader;
import utils.ElementUtils;

public class GL_Hierarchy_PnL_Yearly_PageObject {

	String capturedModal;
	private WebDriver driver;
	private ConstantsReader configReader = new ConstantsReader();

	public GL_Hierarchy_PnL_Yearly_PageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[@data-el='menuToggle']")
	WebElement mainMenuButton;

	@FindBy(xpath = "//div[text()='Configuration']//ancestor::li")
	WebElement configuration;

	@FindBy(xpath = "//div[text()='P&L Mapping']//ancestor::li")
	WebElement pnlMapping;

	@FindBy(xpath = "//div[text()='GL Hierarchy']//ancestor::li")
	WebElement glHierarchy;

	@FindBy(xpath = "//h1[text()='GL Hierarchy']")
	WebElement glHierarchyPage;

	@FindBy(xpath = "//button[@data-el='buttonAllOn']")
	WebElement btnAllon;

	@FindBy(xpath = "//div[text()='Successfully updated all statuses.']")
	WebElement lblSuccess;

	@FindBy(xpath = "//tr[@data-el='RMREV90']//button")
	WebElement btnRoomRevenue;

	@FindBy(xpath = "//tr[@data-el='RMREV60']//button")
	WebElement btnRoomRevenueBeforeOther;

	@FindBy(xpath = "//tr[@data-el='RMREV10']//button")
	WebElement btnRoomContracts;

	@FindBy(xpath = "//tr[@data-el='RMGOP01']//button")
	WebElement glParent;

	@FindBy(xpath = "//tr[@data-el='RMREV90']//button")
	WebElement glRoomRevenue;

	@FindBy(xpath = "//tr[@data-el='RMREV90']//td[4]//input[@type='checkbox']")
	WebElement btnParentCapturedValueToggle;

	@FindBy(xpath = "//tr[@data-el='RMREV60']//button")
	WebElement glRoomRevenueBeofreOther;

	@FindBy(xpath = "//tr[@data-el='RMREV60']//td[4]//input[@type='checkbox']")
	WebElement btnTopCapturedValueToggle;

	@FindBy(xpath = "//tr[@data-el='RMREV10']//button")
	WebElement glRoomContracts;

	@FindBy(xpath = "//tr[@data-el='RMREV10']//td[4]//input[@type='checkbox']")
	WebElement btnBottomCapturedValueToggle;

	@FindBy(xpath = "//h3[text() = 'Turn Off Parent GL Code?']")
	WebElement confirmTurnOff;

	@FindBy(xpath = "//button[@mdo_variant='alert']")
	WebElement btnConfirm;

	@FindBy(xpath = "//div[text()='Successfully updated status.']")
	WebElement lblTurnOffMessage;

	// ===============================================Bottom Child
	// Scenario================================================================
	public boolean captureBottomChildModal() throws InterruptedException {
		Thread.sleep(5000);

		WebElement btnRoomRev = new WebDriverWait(driver, Duration.ofSeconds(100))
				.until(ExpectedConditions.visibilityOf(btnRoomRevenue));

		Thread.sleep(2000);

		btnRoomRev.click();

		WebElement btnRoomRevBeofreOther = new WebDriverWait(driver, Duration.ofSeconds(100))
				.until(ExpectedConditions.visibilityOf(btnRoomRevenueBeforeOther));

		btnRoomRevBeofreOther.click();

		int status = driver.findElements(By.xpath("//tr[@data-el='RMREV10']")).size();

		if (status == 1) {
			WebElement totalRoomCntract = driver.findElement(By.xpath("//tr[@data-el='RMREV10']//td[1]"));
			capturedModal = totalRoomCntract.getText();

			System.out.print("AAA" + capturedModal);

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

		String txtCapturedValue = driver.findElement(By.xpath("//tr[@data-el='RMREV10']//td[3]")).getText();

		System.out.print("AA" + txtCapturedValue + " BB" + capturedModal);
		if (capturedModal.equalsIgnoreCase(txtCapturedValue)) {

			btnBottomCapturedValueToggle.click();

			ElementUtils.waitForElementToDisplay(confirmTurnOff, 100);

			btnConfirm.click();

			WebElement lblSuccessmsg = new WebDriverWait(driver, Duration.ofSeconds(25))
					.until(ExpectedConditions.visibilityOf(lblTurnOffMessage));

			return lblSuccessmsg.isDisplayed();

		} else {
			return false;
		}

	}

	public boolean validateTurnedOffBottomModalinPnLYearly() {
		WebElement btnRoomRev = new WebDriverWait(driver, Duration.ofSeconds(100))
				.until(ExpectedConditions.visibilityOf(btnRoomRevenue));

		btnRoomRev.click();

		WebElement btnRoomRevBeofreOther = new WebDriverWait(driver, Duration.ofSeconds(100))
				.until(ExpectedConditions.visibilityOf(btnRoomRevenueBeforeOther));

		btnRoomRevBeofreOther.click();

		int status = driver.findElements(By.xpath("//tr[@data-el='RMREV10']")).size();

		if (status == 0) {
			return true;
		} else {
			return false;
		}
	}
	// ===============================================Top Child Scenario
	// =========================================================================================

	public boolean captureTopChildModal() throws InterruptedException {
		Thread.sleep(5000);

		WebElement btnRoomRev = new WebDriverWait(driver, Duration.ofSeconds(100))
				.until(ExpectedConditions.visibilityOf(btnRoomRevenue));

		btnRoomRev.click();

		int status = driver.findElements(By.xpath("//tr[@data-el='RMREV60']")).size();

		if (status == 1) {
			WebElement totalRoomRevBefore = driver.findElement(By.xpath("//tr[@data-el='RMREV60']//td[1]"));
			capturedModal = totalRoomRevBefore.getText();

			System.out.print("AAA" + capturedModal);

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

		WebElement glRoomRev = new WebDriverWait(driver, Duration.ofSeconds(25))
				.until(ExpectedConditions.visibilityOf(glRoomRevenue));

		glRoomRev.click();

		String txtCapturedValue = driver.findElement(By.xpath("//tr[@data-el='RMREV60']//td[3]")).getText();

		System.out.print("AA" + txtCapturedValue + " BB" + capturedModal);
		if (capturedModal.equalsIgnoreCase(txtCapturedValue)) {

			btnTopCapturedValueToggle.click();

			ElementUtils.waitForElementToDisplay(confirmTurnOff, 100);

			btnConfirm.click();

			WebElement lblSuccessmsg = new WebDriverWait(driver, Duration.ofSeconds(25))
					.until(ExpectedConditions.visibilityOf(lblTurnOffMessage));

			return lblSuccessmsg.isDisplayed();

		} else {
			return false;
		}

	}

	public boolean validateTurnedOffTopModalinPnLYearly() {
		WebElement btnRoomRev = new WebDriverWait(driver, Duration.ofSeconds(100))
				.until(ExpectedConditions.visibilityOf(btnRoomRevenue));

		btnRoomRev.click();

		int status = driver.findElements(By.xpath("//tr[@data-el='RMREV60']")).size();

		if (status == 0) {
			return true;
		} else {
			return false;
		}
	}

	// ================================================Parent
	// Scenario==================================================================================

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

		String txtCapturedValue = driver.findElement(By.xpath("//tr[@data-el='RMREV90']//td[3]")).getText();

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

	public boolean validateTurnedOffParentModalinPnLYearly() {

		int status = driver.findElements(By.xpath("//tr[@data-el='RMREV90']")).size();
		System.out.println("AA" + status);
		if (status == 0) {
			return true;
		} else {
			return false;
		}
	}

}
