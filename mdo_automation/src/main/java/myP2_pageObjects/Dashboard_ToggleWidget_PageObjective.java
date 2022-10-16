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

public class Dashboard_ToggleWidget_PageObjective {

	private WebDriver driver;
	ConfigReader c = new ConfigReader();
	ArrayList<String> widgetName;
	ArrayList<String> turnedOffWidgets;

	public Dashboard_ToggleWidget_PageObjective(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		widgetName = new ArrayList<String>();
		turnedOffWidgets = new ArrayList<String>();

	}

	@FindBy(xpath = "//button[@data-el='buttonOrderWidgets']//span[text()='Toggle Widgets']")
	WebElement btnToggleButton;

	@FindBy(xpath = "//h1[@data-el='pageName']")
	WebElement toggleWidgetPageEle;

	@FindBy(xpath = "//tbody//tr")
	List<WebElement> listWidgets;

	@FindBy(xpath = "//tr[1]//td//span[contains(@class,'Mui-checked')]")
	List<WebElement> lstToggleButton;

	@FindBy(xpath = "//button[@data-el='buttonSave']")
	WebElement btnSave;

	@FindBy(xpath = "//div[@data-el='data-container']//div[@elevation='3']//h5")
	List<WebElement> headers;

	@FindBy(xpath = "//input[@name='keyword']")
	WebElement txtSearch;

	public boolean navigateToToggleWidget() throws InterruptedException {

		WebElement btnEdit = new WebDriverWait(driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.visibilityOf(btnToggleButton));

		btnEdit.click();

		Thread.sleep(2000);

		WebElement togglePage = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.visibilityOf(toggleWidgetPageEle));

		return togglePage.isDisplayed();
	}

	public void verifyAndChangeStateOnToggle() throws InterruptedException {

		for (int i = 0; i < listWidgets.size(); i++) {

			WebElement widName = driver.findElement(By.xpath("//tr[" + (i + 1) + "]//td[" + 1 + "]"));
			if (i == 0) {
				widgetName.add(widName.getText().split("/")[0]);
			} else {
				widgetName.add(widName.getText());
			}

			int status = driver
					.findElements(By.xpath("//tr[" + (i + 1) + "]//td//span[contains(@class,'Mui-checked')]")).size();

			if (status == 0) {

				WebElement btnSwitch = driver
						.findElement(By.xpath("//tr[" + (i + 1) + "]//td//input[@type='checkbox']"));

				btnSwitch.click();
				Thread.sleep(500);
			}

		}

		WebElement Save = new WebDriverWait(driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.visibilityOf(btnSave));

		Save.click();

	}

	public boolean verifyAllTheWidgets() throws InterruptedException {

		Thread.sleep(5000);

		if (widgetName.size() == headers.size()) {

			return true;
		} else {
			return false;
		}

	}

	public void turnOffWidget(String W1, String W2, String W3) throws InterruptedException {
		Thread.sleep(4000);
		txtSearch.sendKeys(Keys.CONTROL + "a");
		txtSearch.sendKeys(Keys.DELETE);
		txtSearch.sendKeys(W1);
		Thread.sleep(3000);

		if (listWidgets.size() > 0) {
			WebElement btnSwitch = driver.findElement(By.xpath("//tr[" + 1 + "]//td//input[@type='checkbox']"));
			WebElement widName = driver.findElement(By.xpath("//tr[" + (1) + "]//td[" + 1 + "]"));

			turnedOffWidgets.add(widName.getText());
			btnSwitch.click();
			Thread.sleep(500);
		}

		txtSearch.sendKeys(Keys.CONTROL + "a");
		txtSearch.sendKeys(Keys.DELETE);
		txtSearch.sendKeys(W2);
		Thread.sleep(500);

		if (listWidgets.size() > 0) {
			WebElement btnSwitch = driver.findElement(By.xpath("//tr[" + 1 + "]//td//input[@type='checkbox']"));
			WebElement widName = driver.findElement(By.xpath("//tr[" + (1) + "]//td[" + 1 + "]"));

			turnedOffWidgets.add(widName.getText());
			btnSwitch.click();
			Thread.sleep(500);
		}

		txtSearch.sendKeys(Keys.CONTROL + "a");
		txtSearch.sendKeys(Keys.DELETE);
		txtSearch.sendKeys(W3);
		Thread.sleep(500);

		if (listWidgets.size() > 0) {
			WebElement btnSwitch = driver.findElement(By.xpath("//tr[" + 1 + "]//td//input[@type='checkbox']"));
			WebElement widName = driver.findElement(By.xpath("//tr[" + (1) + "]//td[" + 1 + "]"));

			turnedOffWidgets.add(widName.getText());
			btnSwitch.click();
			Thread.sleep(500);
		}

		txtSearch.sendKeys(Keys.CONTROL + "a");
		txtSearch.sendKeys(Keys.DELETE);

		WebElement Save = new WebDriverWait(driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.visibilityOf(btnSave));

		Save.click();
		Thread.sleep(2500);

	}

	public boolean verifyTurnedOffWidgets() throws InterruptedException {
		boolean flag = true;

		Thread.sleep(2500);

		for (int i = 1; i < headers.size(); i++) {

			if (!headers.get(i).getText().equalsIgnoreCase(turnedOffWidgets.get(0))
					|| !headers.get(i).getText().equalsIgnoreCase(turnedOffWidgets.get(1))
					|| !headers.get(i).getText().equalsIgnoreCase(turnedOffWidgets.get(2))) {
				flag = true;

			} else {
				flag = false;
				break;
			}

		}

		return flag;
	}

}
