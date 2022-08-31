package myP2_pageObjects;

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
import utils.ElementUtils;

public class PnLComparison_PageObject {

	private WebDriver driver;
	private ConstantsReader configReader = new ConstantsReader();

	public PnLComparison_PageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[text()='P&L Property Comparison']//ancestor::li")
	WebElement pnlPropertyComparison;

	@FindBy(xpath = "//h1[text()='Profit & Loss Property Comparison']")
	WebElement pnlPropertyComparisonPage;

	@FindBy(xpath = "//div/input[contains(@name, 'porfolio')]")
	WebElement drpGroup;

	@FindBy(xpath = "//ul[@role='listbox']//li")
	List<WebElement> listDrpValueSize;

	@FindBy(xpath = "//input[contains(@placeholder,'mm/dd/yyyy')]")
	WebElement txtDate;

	@FindBy(xpath = "(//label[text()='View']//following::div)[2]")
	WebElement drpView;

	@FindBy(xpath = "//button//span[text()='Go']")
	WebElement btnGo;

	@FindBy(xpath = "//tr[@data-el]/td[1]")
	List<WebElement> listSection;

	@FindBy(xpath = "//input[@name='nullRecords']")
	WebElement btnZeroValue;

	@FindBy(xpath = "//h3[text()='Loading...']")
	WebElement lblLoading;

	@FindBy(xpath = "//div[text()='Rooms available']")
	WebElement lblRoomAva;

	public boolean navigatePnLComparison() {

		WebElement pnlPropertyComparisonEle = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.visibilityOf(pnlPropertyComparison));
		pnlPropertyComparisonEle.click();

		WebElement pnlComparisonPageEle = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.visibilityOf(pnlPropertyComparisonPage));

		return pnlComparisonPageEle.isDisplayed();

	}

	public void selectParameters() throws InterruptedException {

		if (drpGroup.isEnabled()) {
			/* Select the appropriate Group value from the drop-down menu. */
			WebElement drpGroupEle = new WebDriverWait(driver, Duration.ofSeconds(10))
					.until(ExpectedConditions.visibilityOf(drpGroup));
			drpGroupEle.click();

			ExpectedConditions.visibilityOf(listDrpValueSize.get(0));
			for (int i = 0; i < listDrpValueSize.size(); i++) {
				if (listDrpValueSize.get(i).getText().equalsIgnoreCase(configReader.getProp("Group"))) {
					listDrpValueSize.get(i).click();
				}
			}
		}
		WebElement txtDte = new WebDriverWait(driver, Duration.ofSeconds(100))
				.until(ExpectedConditions.visibilityOf(txtDate));
		
		txtDate.sendKeys(Keys.CONTROL + "a");
		txtDate.sendKeys(Keys.DELETE);
		txtDate.sendKeys(configReader.getProp("Date"));

		WebElement drpViewEle = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.visibilityOf(drpView));
		drpViewEle.click();

		Thread.sleep(5000);

		ExpectedConditions.visibilityOf(listDrpValueSize.get(0));

		for (int i = 0; i < listDrpValueSize.size(); i++) {
			if (listDrpValueSize.get(i).getText().equalsIgnoreCase(configReader.getProp("View"))) {
				listDrpValueSize.get(i).click();
			}
		}

		WebElement btnGO = new WebDriverWait(driver, Duration.ofSeconds(20))
				.until(ExpectedConditions.visibilityOf(btnGo));
		btnGO.click();
		Thread.sleep(10000);
		ElementUtils.waitForElementToDisplay(lblRoomAva, 100);
		Thread.sleep(4500);
		btnZeroValue.click();

	}

}
