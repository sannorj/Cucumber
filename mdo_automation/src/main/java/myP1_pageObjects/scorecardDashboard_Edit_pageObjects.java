package myP1_pageObjects;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.ConstantsReader;

public class scorecardDashboard_Edit_pageObjects {
	private WebDriver driver;
	private ConstantsReader configReader = new ConstantsReader();

	public scorecardDashboard_Edit_pageObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[@title='Edit']")
	WebElement editBtn;

	@FindBy(xpath = "//div[@id='modalAnim']//button[text()='Confirm']")
	WebElement closeConfirmBtn;

	@FindBy(xpath = "//div[@id='formAddChartBody']//section//div[@class='form-group']//div//div[contains(@class,'switch switch-sm switch-success')]//div[@class='ios-switch on']//following-sibling::input[1]")
	List<WebElement> enabledChartsLst;

	@FindBy(xpath = "//div[@id='formAddChartBody']//section//div[@class='form-group']//div//div[contains(@class,'switch switch-sm switch-success')]//div[@class='ios-switch off']//following-sibling::input[1]")
	List<WebElement> disabledChartsLst;

	@FindBy(xpath = "//div[@id='formAddChartBody']//button[text()='Submit']")
	WebElement addChartSubmitBtn;

	public void clickEdit() {
		editBtn.click();
	}

	public void closeCard() {
		WebElement cardCloseBtn = driver.findElement(By.xpath("//h2[text()='"
				+ configReader.getMYP1Prop("Scorecard_closeCard") + "']//preceding-sibling::div//a[@title='Close']"));
		try {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", cardCloseBtn);
		} catch (Exception e) {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", cardCloseBtn);
		}
	}

	public void confirmClick() throws InterruptedException {
		closeConfirmBtn.click();
		Thread.sleep(3000);
	}

	public boolean verifyCardClosed() {
		WebElement monthChartLoaded = new WebDriverWait(driver, Duration.ofSeconds(700))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='sortablescorecard']")));
		boolean isCardNotEnabled = true;
		for (int i = 0; i < enabledChartsLst.size(); i++) {
			String cardFullName = enabledChartsLst.get(i).getAttribute("name");
			String cardName = cardFullName.replace("Scorecard", "");
			if (cardName.equalsIgnoreCase(configReader.getMYP1Prop("Scorecard_closeCardId"))) {
				System.out.println("card can view=" + cardName);
				isCardNotEnabled = false;
			}
		}

		boolean isCardVisibel = new WebDriverWait(driver, Duration.ofSeconds(50))
				.until(ExpectedConditions.invisibilityOfElementLocated(
						By.xpath("//section[@id='panel-" + configReader.getMYP1Prop("Scorecard_closeCardId") + "']")));

		if (!isCardVisibel)
			isCardNotEnabled = false;

		return isCardNotEnabled;
	}

	public void disableCard() throws InterruptedException {
		WebElement updateSettingsBtn = new WebDriverWait(driver, Duration.ofSeconds(700))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@title='Update Settings']")));
		updateSettingsBtn.click();
		System.out.println("*****************");
		Thread.sleep(3000);
		WebElement disableSwitch = new WebDriverWait(driver, Duration.ofSeconds(700))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='Scorecard"
						+ configReader.getMYP1Prop("Scorecard_disableCardId") + "']//preceding-sibling::div")));
		disableSwitch.click();
		System.out.println("ccccccccccccccccccccccccccccccc");
		addChartSubmitBtn.click();
		System.out.println("kkkkkkkkkkkkkkkkkkkk");
		Thread.sleep(3000);
	}

	public boolean verifyCardDisabled() {
		WebElement monthChartLoaded = new WebDriverWait(driver, Duration.ofSeconds(700))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='sortablescorecard']")));
		boolean isCardNotEnabled = true;
		for (int i = 0; i < enabledChartsLst.size(); i++) {
			String cardFullName = enabledChartsLst.get(i).getAttribute("name");
			String cardName = cardFullName.replace("Scorecard", "");
			if (cardName.equalsIgnoreCase(configReader.getMYP1Prop("Scorecard_disableCardId"))) {
				System.out.println("card can view=" + cardName);
				isCardNotEnabled = false;
			}
		}

		boolean isCardVisibel = new WebDriverWait(driver, Duration.ofSeconds(20)).ignoring(NoSuchElementException.class)
				.until(ExpectedConditions.invisibilityOfElementLocated(By
						.xpath("//section[@id='panel-" + configReader.getMYP1Prop("Scorecard_disableCardId") + "']")));

		if (!isCardVisibel)
			isCardNotEnabled = false;

		return isCardNotEnabled;
	}

	public void enableCloseCards() throws InterruptedException {
		Thread.sleep(7000);
		WebElement updateSettingsBtn = new WebDriverWait(driver, Duration.ofSeconds(700))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@title='Update Settings']")));
		Thread.sleep(5000);
		updateSettingsBtn.click();
		System.out.println("disabledChartsListsize" + disabledChartsLst.size());
//		boolean isCardNotEnabled=true;
//		for (int i = 0; i < disabledChartsLst.size(); i++) {
//			String cardFullName = disabledChartsLst.get(i).getAttribute("name");
//			String cardName = cardFullName.replace("Scorecard", "");
//			System.out.println("cardName="+cardName);
//			System.out.println("cardName="+disabledChartsLst.get(i));
//			
//			System.out.println(disabledChartsLst.size());
//			if(i<disabledChartsLst.size())
//				continue;
//			Thread.sleep(3000);
//		}
		WebElement enableSwitchcloseCard = new WebDriverWait(driver, Duration.ofSeconds(700))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='Scorecard"
						+ configReader.getMYP1Prop("Scorecard_closeCardId") + "']//preceding-sibling::div")));
		enableSwitchcloseCard.click();

		WebElement enableSwitchdisableCard = new WebDriverWait(driver, Duration.ofSeconds(700))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='Scorecard"
						+ configReader.getMYP1Prop("Scorecard_disableCardId") + "']//preceding-sibling::div")));
		enableSwitchdisableCard.click();

		addChartSubmitBtn.click();
		Thread.sleep(3000);
	}

	public boolean verifyCardsAvailable() {
		WebElement monthChartLoaded = new WebDriverWait(driver, Duration.ofSeconds(700))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='sortablescorecard']")));
		boolean isCardVisible = false;
		for (int i = 0; i < enabledChartsLst.size(); i++) {
			String cardFullName = enabledChartsLst.get(i).getAttribute("name");
			String cardName = cardFullName.replace("Scorecard", "");
			if (cardName.equalsIgnoreCase(configReader.getMYP1Prop("Scorecard_disableCardId"))) {
				System.out.println("card can view=" + cardName);
				isCardVisible = true;
			} else if (cardName.equalsIgnoreCase(configReader.getMYP1Prop("Scorecard_closeCardId"))) {
				System.out.println("card can view=" + cardName);
				isCardVisible = true;
			}
		}
		return isCardVisible;
	}

}
