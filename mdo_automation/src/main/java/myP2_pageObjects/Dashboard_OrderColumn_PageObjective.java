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

import utils.ConfigReader;

public class Dashboard_OrderColumn_PageObjective {
	private WebDriver driver;
	ConfigReader c = new ConfigReader();
	String[] column;
	String[] dashBoardColumns;

	public Dashboard_OrderColumn_PageObjective(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[@data-el='buttonCustomizeTable']")
	WebElement btnEditColumn;

	@FindBy(xpath = "//button[@data-el='buttonOrderColumn']")
	WebElement btnOrderColumn;

	@FindBy(xpath = "//h1[@data-el='pageName']")
	WebElement orderWidgetPageEle;

	@FindBy(xpath = "//div[@role='button']")
	List<WebElement> lstColumnNames;

	@FindBy(xpath = "//button[@data-el='buttonSave']")
	WebElement btnSave;

	@FindBy(xpath = "//thead//tr[2]//th")
	List<WebElement> listDasBoardColumn;

	public boolean navigateToOrderColumn() throws InterruptedException {

		WebElement btnEdit = new WebDriverWait(driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.visibilityOf(btnEditColumn));

		btnEdit.click();

		Thread.sleep(10000);

		int status = driver.findElements(By.xpath("//thead//tr")).size();

		if (status > 0) {
			WebElement btnOrder = new WebDriverWait(driver, Duration.ofSeconds(5))
					.until(ExpectedConditions.visibilityOf(btnOrderColumn));

			btnOrder.click();

			Thread.sleep(2000);

			WebElement togglePage = new WebDriverWait(driver, Duration.ofSeconds(10))
					.until(ExpectedConditions.visibilityOf(orderWidgetPageEle));

			return togglePage.isDisplayed();
		} else {
			return false;
		}

	}

	public void storeOrderedColumns() throws InterruptedException {
		Thread.sleep(2500);

		column = new String[lstColumnNames.size()];

		for (int i = 0; i < column.length; i++) {

			column[i] = lstColumnNames.get(i).getText();

		}

		WebElement Save = new WebDriverWait(driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.visibilityOf(btnSave));

		Save.click();

		Thread.sleep(10000);

		dashBoardColumns = new String[listDasBoardColumn.size() - 3];

		for (int i = 0; i < dashBoardColumns.length; i++) {

			dashBoardColumns[i] = listDasBoardColumn.get(i + 3).getText();

		}

	}
	
	public boolean verifyOrderedColumns() throws InterruptedException {

		boolean flag = true;

		if (column.length == dashBoardColumns.length) {

			for (int i = 1; i < column.length; i++) {

				if (column[i].equalsIgnoreCase(dashBoardColumns[i])) {
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

}
