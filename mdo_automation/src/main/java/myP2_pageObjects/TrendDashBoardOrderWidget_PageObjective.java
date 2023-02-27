package myP2_pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.ConstantsReader;

public class TrendDashBoardOrderWidget_PageObjective {
	private WebDriver driver;
	private ConstantsReader configReader = new ConstantsReader();
	String[] widget;
	String[] dashBoardWidgets;

	public TrendDashBoardOrderWidget_PageObjective(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//button[@data-el='menuToggle']")
	WebElement selector;

	@FindBy(xpath = "//div[text()='Dashboard']//ancestor::li")
	WebElement dashBoard;

	@FindBy(xpath = "//div[text()='Trends Dashboard']//ancestor::li")
	WebElement trendDashboard;

	@FindBy(xpath = "//h1[text()='Trends Dashboard']")
	WebElement trendDashboardPage;

	@FindBy(xpath = "//div[@role='button']")
	List<WebElement> lstWidgetNames;

	@FindBy(xpath = "//button[@data-el='buttonSave']")
	WebElement btnSave;

	@FindBy(xpath = "//div[@data-el='data-container-1']//div[@elevation='3']//h5")
	List<WebElement> listDasBoardHeaders;

	public void storeOrderedWidgets() throws InterruptedException {
		Thread.sleep(2500);

		widget = new String[lstWidgetNames.size()];

		for (int i = 0; i < widget.length; i++) {

			widget[i] = lstWidgetNames.get(i).getText();

		}

		WebElement Save = new WebDriverWait(driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.visibilityOf(btnSave));

		Save.click();

		Thread.sleep(2500);

		dashBoardWidgets = new String[listDasBoardHeaders.size()];

		for (int i = 0; i < dashBoardWidgets.length; i++) {

			dashBoardWidgets[i] = listDasBoardHeaders.get(i).getText();

		}
	}

	public boolean verifyOrderedWidgets() throws InterruptedException {

		boolean flag = true;

		if (widget.length == dashBoardWidgets.length) {

			for (int i = 1; i < widget.length; i++) {

				if (widget[i].equalsIgnoreCase(dashBoardWidgets[i])) {
					flag = true;
				} else {
					flag = false;
				}
			}

		} else {
			flag = false;
		}

		return flag;

	}

	public void dragAndDrop() throws InterruptedException {
		try {
			Thread.sleep(2500);

			WebElement from = driver.findElement(By.xpath("(//div[@role='button'])[1]"));
			WebElement to = driver.findElement(By.xpath("(//div[@role='button'])[2]"));

			new Actions(driver).moveToElement(from).pause(Duration.ofSeconds(1)).clickAndHold(from)
					.pause(Duration.ofSeconds(1)).moveByOffset(1, 0).moveToElement(to).moveByOffset(1, 0)
					.pause(Duration.ofSeconds(1)).release().perform();

			Thread.sleep(5000);
		} catch (Exception e) {
		}

	}
}
