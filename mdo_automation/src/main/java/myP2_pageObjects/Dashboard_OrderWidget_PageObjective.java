package myP2_pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.ConfigReader;

public class Dashboard_OrderWidget_PageObjective {
	private WebDriver driver;
	ConfigReader c = new ConfigReader();
	String[] widget;
	String[] dashBoardWidgets;

	public Dashboard_OrderWidget_PageObjective(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//button[@data-el='buttonOrderWidgets']//span[text()='Order Widgets']")
	WebElement btnOrderButton;

	@FindBy(xpath = "//h1[@data-el='pageName']")
	WebElement orderWidgetPageEle;

	@FindBy(xpath = "//div[@data-rbd-draggable-context-id='0']")
	List<WebElement> lstWidgetNames;

	@FindBy(xpath = "//button[@data-el='buttonSave']")
	WebElement btnSave;

	@FindBy(xpath = "//div[@data-el='data-container']//div[@elevation='3']//h5")
	List<WebElement> listDasBoardHeaders;

	public boolean navigateToOrderWidget() throws InterruptedException {

		WebElement btnEdit = new WebDriverWait(driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.visibilityOf(btnOrderButton));

		btnEdit.click();

		Thread.sleep(2000);

		WebElement togglePage = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.visibilityOf(orderWidgetPageEle));

		return togglePage.isDisplayed();
	}

	public void storeOrderedWidgets() throws InterruptedException {
		Thread.sleep(2500);

		widget = new String[lstWidgetNames.size()];

		for (int i = 0; i < widget.length; i++) {
			if (i == 0) {
				widget[i] = lstWidgetNames.get(i).getText().split("/")[0];
			} else {
				widget[i] = lstWidgetNames.get(i).getText();
			}

		}

		WebElement Save = new WebDriverWait(driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.visibilityOf(btnSave));

		Save.click();

		Thread.sleep(5000);

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
			Thread.sleep(2500);

			WebElement from = driver.findElement(By.xpath("(//div[@role='button'])[1]"));
			WebElement to = driver.findElement(By.xpath("(//div[@role='button'])[2]"));

			new Actions(driver).moveToElement(from).pause(Duration.ofSeconds(1)).clickAndHold(from)
					.pause(Duration.ofSeconds(1)).moveByOffset(1, 0).moveToElement(to).moveByOffset(1, 0)
					.pause(Duration.ofSeconds(1)).release().perform();

			Thread.sleep(5000);
		}

	}
}
