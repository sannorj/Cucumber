package myP2_pageObjects;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.ConstantsReader;

public class PickUpReport_EdiColumn_PageObject {

	private WebDriver driver;
	private ConstantsReader configReader = new ConstantsReader();
	ArrayList<String> columnName;
	ArrayList<String> offColumnName;

	public PickUpReport_EdiColumn_PageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		columnName = new ArrayList<>();
		offColumnName = new ArrayList<>();

	}

	@FindBy(xpath = "//button[@data-el='menuToggle']")
	WebElement mainMenuButton;

	@FindBy(xpath = "//div[text()='Reports']//ancestor::li")
	WebElement reports;

	@FindBy(xpath = "//div[text()='Revenue']//ancestor::li")
	WebElement reveneue;

	@FindBy(xpath = "//div[text()='Pickup Reports']//ancestor::li")
	WebElement pickUpReports;

	@FindBy(xpath = "//div[text()='Pickup Report']//ancestor::li")
	WebElement pickUpReportPage;

	@FindBy(xpath = "//h1[text()='Pickup Report']")
	WebElement navigatedReportPage;

	@FindBy(xpath = "//input[@name='businessDate']")
	WebElement txtBusinessDate;

	@FindBy(xpath = "//input[@name='startDate']")
	WebElement txtStartDate;

	@FindBy(xpath = "//input[@name='endDate']")
	WebElement txtEndDate;

	@FindBy(xpath = "//button[@data-el='buttonGo']")
	WebElement btngo;

	@FindBy(xpath = "//*[@id='root']//table/tbody/tr/td[1]")
	List<WebElement> allData;

	@FindBy(xpath = "//button[@data-el='buttonSettings']")
	WebElement btnEditColumn;

	@FindBy(xpath = "//div[text() = 'Settings']")
	WebElement settingPage;

	@FindBy(xpath = "//div//h3[text() = 'Occupancy']/following-sibling::div//label[@class='sc-bjUoiL ebTZpj']")
	List<WebElement> listColumn;

	@FindBy(xpath = "//button[@type='button']//span[text() = 'Apply']")
	WebElement btnApply;

	// th[@freezecolumns='0']

	public boolean navigateToEditColumn() {
		WebElement btnEdit = new WebDriverWait(driver, Duration.ofSeconds(50))
				.until(ExpectedConditions.visibilityOf(btnEditColumn));
		btnEdit.click();

		WebElement pageSetting = new WebDriverWait(driver, Duration.ofSeconds(50))
				.until(ExpectedConditions.visibilityOf(settingPage));
		return pageSetting.isDisplayed();
	}

	public void loadReport() {
		try {
			txtBusinessDate.sendKeys(Keys.CONTROL + "a");
			txtBusinessDate.sendKeys(Keys.DELETE);
			txtBusinessDate.sendKeys(configReader.getProp("businessDate") + "/" + configReader.getProp("businessYear"));

			txtStartDate.sendKeys(Keys.CONTROL + "a");
			txtStartDate.sendKeys(Keys.DELETE);
			txtStartDate.sendKeys(configReader.getProp("startDate") + "/" + configReader.getProp("businessYear"));

			txtEndDate.sendKeys(Keys.CONTROL + "a");
			txtEndDate.sendKeys(Keys.DELETE);
			txtEndDate.sendKeys(configReader.getProp("endDate") + "/" + configReader.getProp("businessYear"));

			btngo.click();

			Thread.sleep(5000);

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public void switchOnAllTheColumns() throws InterruptedException {
		for (int i = 0; i < listColumn.size(); i++) {

			columnName.add(listColumn.get(i).getText());

		}

		for (int i = 0; i < columnName.size(); i++) {

			int status = driver
					.findElements(By.xpath("//div//h3[text() = 'Occupancy']/following-sibling::div//label[@label ='"
							+ columnName.get(i) + "']//span[contains(@class,'Mui-checked')]"))
					.size();

			if (status == 0) {
				
				WebElement btnSwitch = driver
						.findElement(By.xpath("//div//h3[text() = 'Occupancy']/following-sibling::div//label[@label ='"
								+ columnName.get(i) + "']"));
				
				

				btnSwitch.click();
				Thread.sleep(1500);
			}
		}

		btnApply.click();
		Thread.sleep(3000);

	}
	
	public void switchOffSomeColumns() throws InterruptedException {
		for (int i = 0; i < listColumn.size(); i++) {

			columnName.add(listColumn.get(i).getText());

		}

		for (int i = 0; i < columnName.size(); i++) {

			if(i==0 || i==2)
			{
				int status = driver
						.findElements(By.xpath("//div//h3[text() = 'Occupancy']/following-sibling::div//label[@label ='"
								+ columnName.get(i) + "']//span[contains(@class,'Mui-checked')]"))
						.size();

				if (status == 1) {
					System.out.println("AA" + columnName.get(i));
					WebElement btnSwitch = driver
							.findElement(By.xpath("//div//h3[text() = 'Occupancy']/following-sibling::div//label[@label ='"
									+ columnName.get(i) + "']"));
					offColumnName.add(btnSwitch.getText());
					btnSwitch.click();
					Thread.sleep(1500);
					
				}
			}
			
		}

		btnApply.click();
		Thread.sleep(3000);
		
		

	}

}
