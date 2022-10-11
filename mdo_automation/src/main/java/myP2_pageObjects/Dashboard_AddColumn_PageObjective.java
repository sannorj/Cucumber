package myP2_pageObjects;

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

import com.github.dockerjava.api.model.Config;

import utils.ConfigReader;
import utils.ConstantsReader;

public class Dashboard_AddColumn_PageObjective {
	private WebDriver driver;
	ConfigReader c = new ConfigReader();
	private ConstantsReader configReader = new ConstantsReader();

	public Dashboard_AddColumn_PageObjective(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[@data-el='buttonCustomizeTable']")
	WebElement btnEditColumn;

	@FindBy(xpath = "//button[@data-el='buttonAddAColumn']")
	WebElement btnAddColumn;

	@FindBy(xpath = "//div[text()='Add Column']")
	WebElement lblAddColumn;

	@FindBy(xpath = "//input[@name='name']")
	WebElement txtName;

	@FindBy(xpath = "//input[@name='kpiId']")
	WebElement txtKpiId;

	@FindBy(xpath = "//ul[@role='listbox']//li")
	List<WebElement> lstKpi;

	@FindBy(xpath = "//div[@id='mui-component-select-valueDataType']")
	WebElement btnAmount;

	@FindBy(xpath = "//ul[@role='listbox']//li")
	List<WebElement> lstAmount;

	@FindBy(xpath = "//div[@id='mui-component-select-valueDateOffsetType']")
	WebElement btnPeriod;

	@FindBy(xpath = "//ul[@role='listbox']//li")
	List<WebElement> lstPeriod;

	@FindBy(xpath = "//input[@name='overrideDecimalMaster']")
	WebElement toggleDecimalMaster;

	@FindBy(xpath = "//div[@id='mui-component-select-valueDecimals']")
	WebElement btnDecimal;

	@FindBy(xpath = "//ul[@role='listbox']//li")
	List<WebElement> lstDecimal;

	@FindBy(xpath = "//div[@id='mui-component-select-performanceIndicatorMasterOverride']")
	WebElement btnPerfomanceIndicator;

	@FindBy(xpath = "//ul[@role='listbox']//li")
	List<WebElement> lstPerfomanceIndicator;

	@FindBy(xpath = "//div[@role='alert']")
	WebElement lblSuccess;

	@FindBy(xpath = "//button[@data-el='buttonSave']")
	WebElement btnSave;

	@FindBy(xpath = "//div[@role='dialog']")
	WebElement dialogBox;

	@FindBy(xpath = "//button[@mdo_variant='success']//span[text()='Ok']")
	WebElement btnOk;

	@FindBy(xpath = "//div[@class='MuiAlert-message']")
	WebElement alertDelete;

	public boolean navigateToAddColumn() throws InterruptedException {

		WebElement btnEdit = new WebDriverWait(driver, Duration.ofSeconds(25))
				.until(ExpectedConditions.visibilityOf(btnEditColumn));

		btnEdit.click();

		WebElement btnAdd = new WebDriverWait(driver, Duration.ofSeconds(25))
				.until(ExpectedConditions.visibilityOf(btnAddColumn));

		btnAdd.click();
		Thread.sleep(2500);

		WebElement lblAdd = new WebDriverWait(driver, Duration.ofSeconds(25))
				.until(ExpectedConditions.visibilityOf(lblAddColumn));

		return lblAdd.isDisplayed();
	}

	public void setupNameAndKpi() throws InterruptedException {

		txtName.sendKeys(Keys.CONTROL + "a");
		txtName.sendKeys(Keys.DELETE);
		txtName.sendKeys(configReader.getProp("NameAddColumn"));

		txtKpiId.click();

		for (int i = 0; i < lstKpi.size(); i++) {
			if (lstKpi.get(i).getText().equalsIgnoreCase(configReader.getProp("KPIAddColumn"))) {
				lstKpi.get(i).click();

			}
		}

	}

	public void setupAmountAndPeriod() throws InterruptedException {

		btnAmount.click();
		for (int i = 0; i < lstAmount.size(); i++) {
			if (lstAmount.get(i).getText().equalsIgnoreCase(configReader.getProp("AmountTypeAddColumn"))) {
				lstAmount.get(i).click();
			}
		}
		btnPeriod.click();
		lstPeriod.get(1).click();
	}

	public void setupDecimalAndPerfomance() throws InterruptedException {

		toggleDecimalMaster.click();

		btnDecimal.click();
		Thread.sleep(4000);
		lstDecimal.get(2).click();

		Thread.sleep(4000);
		btnPerfomanceIndicator.click();
		lstPerfomanceIndicator.get(1).click();
	}

	public boolean verifySuccessMessage() throws InterruptedException {
		WebElement Save = new WebDriverWait(driver, Duration.ofSeconds(25))
				.until(ExpectedConditions.visibilityOf(btnSave));

		Thread.sleep(2500);

		Save.click();

		WebElement Success = new WebDriverWait(driver, Duration.ofSeconds(25))
				.until(ExpectedConditions.visibilityOf(lblSuccess));

		System.out.println(Success.getText());

		return Success.isDisplayed();

	}

	public boolean navigateToDeleteColumn() throws InterruptedException {

		WebElement btnEdit = new WebDriverWait(driver, Duration.ofSeconds(25))
				.until(ExpectedConditions.visibilityOf(btnEditColumn));

		btnEdit.click();

		Thread.sleep(10000);

		WebElement tst = driver.findElement(
				By.xpath("//button[@data-el='button-delete-" + configReader.getProp("NameAddColumn") + "']"));
		WebElement btnDelete = new WebDriverWait(driver, Duration.ofSeconds(25))
				.until(ExpectedConditions.visibilityOf(tst));

		btnDelete.click();
		Thread.sleep(2000);

		WebElement dialogBoxEle = new WebDriverWait(driver, Duration.ofSeconds(25))
				.until(ExpectedConditions.visibilityOf(dialogBox));

		return dialogBoxEle.isDisplayed();
	}

	public boolean deleteColumn() throws InterruptedException {

		Thread.sleep(5000);

		WebElement dialogBoxEle = new WebDriverWait(driver, Duration.ofSeconds(25))
				.until(ExpectedConditions.visibilityOf(dialogBox));

		if (dialogBoxEle.isDisplayed()) {
			WebElement btnOkEle = new WebDriverWait(driver, Duration.ofSeconds(25))
					.until(ExpectedConditions.visibilityOf(btnOk));

			btnOkEle.click();

			return true;
		} else {
			return false;
		}
	}

}
