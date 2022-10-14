package myP2_pageObjects;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.ConfigReader;
import utils.ConstantsReader;

public class TrendDashBoardToggleWidget_PageObjective {
	private WebDriver driver;
	private ConstantsReader configReader = new ConstantsReader();
	String widgetName[];
	ArrayList<String> turnedOffWidgets;

	public TrendDashBoardToggleWidget_PageObjective(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		turnedOffWidgets = new ArrayList<>();
	}

	@FindBy(xpath = "//button[@data-el='menuToggle']")
	WebElement selector;

	@FindBy(xpath = "//div[text()='Dashboard']//ancestor::li")
	WebElement dashBoard;

	@FindBy(xpath = "//div[contains(text(),'Trends Dashboard')]//ancestor::li")
	WebElement trendDashboard;

	@FindBy(xpath = "//h1[text()='Trends Dashboard']")
	WebElement trendDashboardPage;

	@FindBy(xpath = "//tbody//tr")
	List<WebElement> listWidgets;

	@FindBy(xpath = "//button[@data-el='buttonSave']")
	WebElement btnSave;

	@FindBy(xpath = "//div[@data-el='data-container']//div[@elevation='3']//h5")
	List<WebElement> headers;

	@FindBy(xpath = "//input[@name='keyword']")
	WebElement txtSearch;

	public boolean navigateToTrendDashboard() throws InterruptedException {
		WebElement menu = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(selector));
		menu.click();

		WebElement dash = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(dashBoard));
		dash.click();

		WebElement trendDashboardEle = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(trendDashboard));
		trendDashboardEle.click();

		Thread.sleep(2500);
		return trendDashboardPage.isDisplayed();

	}

	public void verifyAndChangeStateOnToggle() throws InterruptedException {

		widgetName = new String[listWidgets.size()];

		for (int i = 0; i < widgetName.length; i++) {

			WebElement widName = driver.findElement(By.xpath("//tr[" + (i + 1) + "]//td[" + 1 + "]"));
			widgetName[i] = widName.getText();

			int status = driver.findElements(By.xpath("//tr[" + (i + 1) + "]//td//span[contains(@class,'Mui-checked')]")).size();

			if (status == 0) {

				WebElement btnSwitch = driver.findElement(By.xpath("//tr[" + (i + 1) + "]//td//input[@type='checkbox']"));

				btnSwitch.click();
				Thread.sleep(500);
			}

		}

		WebElement Save = new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(btnSave));
		Save.click();

	}

	public boolean verifyAllTheWidgets() throws InterruptedException {

		Thread.sleep(5000);

		if (widgetName.length == headers.size()) {
			return true;
		} else {
			return false;
		}

	}

	public void turnOffWidget() throws InterruptedException {

		String widgetsToTurnOff = configReader.getProp("Widget_Name");
		String listWidgetToTurnOff[] = widgetsToTurnOff.split("-");

		for (int i = 0; i < listWidgetToTurnOff.length; i++) {
			txtSearch.sendKeys(Keys.CONTROL + "a");
			txtSearch.sendKeys(Keys.DELETE);
			txtSearch.sendKeys(listWidgetToTurnOff[i]);
			Thread.sleep(500);

			if (listWidgets.size() > 0) {
				WebElement btnSwitch = driver.findElement(By.xpath("//tr[" + 1 + "]//td//input[@type='checkbox']"));
				WebElement widName = driver.findElement(By.xpath("//tr[" + (1) + "]//td[" + 1 + "]"));

				turnedOffWidgets.add(widName.getText());
				btnSwitch.click();
				Thread.sleep(500);
			}
		}

		WebElement Save = new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(btnSave));

		Save.click();
		Thread.sleep(2500);

	}

	public boolean verifyTurnedOffWidgets() throws InterruptedException {
		boolean flag = true;

		Thread.sleep(2500);

		for (int i = 0; i < headers.size(); i++) {

			for (int j = 0; j < turnedOffWidgets.size(); j++) {
				if (headers.get(i).getText().equals(turnedOffWidgets.get(j))) {
					flag = false;
					break;
				} else {
					flag = true;
				}
			}

		}

		return flag;
	}

}
