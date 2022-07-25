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

import de.erichseifert.vectorgraphics2d.VectorHints.Key;
import utils.ConstantsReader;
import utils.ElementUtils;


public class Account_Sales_Manager_PageObjective {
	
	private WebDriver driver;	
	private ConstantsReader configReader = new ConstantsReader();
	String ColumnData[][] ;
	
	public Account_Sales_Manager_PageObjective(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath = "//div[text()='Accounts Mapping']//ancestor::li")
	WebElement accountsMapping;
	
	@FindBy(xpath = "//div[text()='Sales Managers']//ancestor::li")
	WebElement salesManagers;

	@FindBy(xpath = "//h1[text()='Account Sales Managers']")
	WebElement accountSalesManagers;
	
	@FindBy(xpath = "//button[@data-el='buttonAdd']")
	WebElement btnAdd;
	
	@FindBy(xpath = "//input[@name='firstName']")
	WebElement txtFName;
	
	@FindBy(xpath = "//input[@name='lastName']")
	WebElement txtLName;
	
	@FindBy(xpath = "//input[@name='phone']")
	WebElement txtphone;
	
	@FindBy(xpath = "//input[@name='email']")
	WebElement txtemail;
	
	@FindBy(xpath = "//input[@name='address1']")
	WebElement txtaddress1;
	
	@FindBy(xpath = "//input[@name='address2']")
	WebElement txtaddress2;
	
	@FindBy(xpath = "//input[@name='city']")
	WebElement txtcity;
	
	@FindBy(xpath = "//input[@name='state']")
	WebElement txtstate;
	
	@FindBy(xpath = "//span[text()='Save']/ancestor::button")
	WebElement btnSave;
	
	@FindBy(xpath = "//*[@id='root']//table/tbody/tr/td[1]/div/div/div/div/div")
	List <WebElement> lstRows;
	
	@FindBy(xpath = "//*[@id='root']//table/tbody/tr[1]/td/div/div/div/div/div")
	List <WebElement> noOfColumns;
	
	@FindBy(xpath = "//span[@data-el='linkActionsEdit']")
	WebElement btnEdit;
	
	@FindBy(xpath = "//span[@data-el='linkActionsRemove']")
	WebElement btnRemove;
	
	@FindBy(xpath = "//span[text()='Confirm']/ancestor::button")
	WebElement btnConfirm;
	
	@FindBy(xpath = "//h3[text()='Remove Account']")
	WebElement lblRemoveAccount;
	
	@FindBy(xpath = "//button[@data-el='menuToggle']")
	WebElement mainMenuButton;
	
	@FindBy(xpath = "//div[text()='Configuration']//ancestor::li")
	WebElement configuration;
	
	
	public boolean navigateToSalesManager() throws InterruptedException {
		WebElement accountsMappingEle = new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(accountsMapping));
		accountsMappingEle.click();

		WebElement salesManagersEle = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(salesManagers));
		salesManagersEle.click();
		
		ElementUtils.waitForElementToDisplay(accountSalesManagers, 100);
		WebElement accountSalesManagersEle = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(accountSalesManagers));
		return accountSalesManagersEle.isDisplayed();

	}
	
	public void expandConfigurations() {

		try {
			WebElement menu = new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(mainMenuButton));
			menu.click();

			Thread.sleep(1500);

			WebElement configurationEle = new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(configuration));
			configurationEle.click();

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
	
	public void clickAddbutton() throws InterruptedException {
		
		btnAdd.click();
		Thread.sleep(1000);
		
	}
	
	public void entertDetails() throws InterruptedException {
		
		txtFName.sendKeys(configReader.getProp("ASM_FirstName"));
		txtLName.sendKeys(configReader.getProp("ASM_LastName"));
		txtphone.sendKeys(configReader.getProp("ASM_PhoneNumber"));
		txtemail.sendKeys(configReader.getProp("ASM_Email"));
		txtaddress1.sendKeys(configReader.getProp("ASM_Address1"));
		txtaddress2.sendKeys(configReader.getProp("ASM_Address2"));
		txtcity.sendKeys(configReader.getProp("ASM_City"));
		txtstate.sendKeys(configReader.getProp("ASM_Province"));
		Thread.sleep(2500);
		btnSave.click();
		
		ElementUtils.waitForElementToDisplay(accountSalesManagers, 100);
		
	}
	
	public boolean verifyAddedRecord() throws InterruptedException {
		
		Thread.sleep(6500);
		txtFName.sendKeys(configReader.getProp("ASM_FirstName"));
		Thread.sleep(6500);
		int columnCount;
		boolean flag = true;
		ColumnData = new String[lstRows.size()][noOfColumns.size()];

		for (int x = 0; x < lstRows.size(); x++) {
			for (int t = 0; t < noOfColumns.size(); t++) {
				WebElement no = driver.findElement(By.xpath("//*[@id='root']//table/tbody/tr[1]/td[1]/div/div/div/div/div"));
				ColumnData[x][t] = no.getText();

			}
		}

		for (int x = 0; x < ColumnData.length; x++) {
			columnCount = 0;
			for (int t = 0; t < ColumnData[x].length; t++) {
				String expected = configReader.getProp("ASM_FirstName");
				if (ColumnData[x][t].contains(expected)) {
					flag = true;
					columnCount++;
					break;
				} else {
					flag = false;
				}
			}
			return flag;
		}
		return flag;
		
	}
	
   public void clickEditbutton() throws InterruptedException {
		
	    Thread.sleep(6500);
		txtFName.sendKeys(configReader.getProp("ASM_FirstName"));
		Thread.sleep(4500);
		btnEdit.click();
		
	}
   
   public void changeFirstName() throws InterruptedException {
	    Thread.sleep(4500);
	    txtFName.sendKeys(Keys.CONTROL + "a");
	    txtFName.sendKeys(Keys.DELETE);
	    txtFName.sendKeys(configReader.getProp("ASM_EditFirstName"));
		Thread.sleep(2500);
		btnSave.click();
		ElementUtils.waitForElementToDisplay(accountSalesManagers, 100);
   }
   
	public boolean verifyEditedRecord() throws InterruptedException {
		
		Thread.sleep(6500);
		txtFName.sendKeys(configReader.getProp("ASM_EditFirstName"));
		Thread.sleep(6500);
		int columnCount;
		boolean flag = true;
		ColumnData = new String[lstRows.size()][noOfColumns.size()];

		for (int x = 0; x < lstRows.size(); x++) {
			for (int t = 0; t < noOfColumns.size(); t++) {
				WebElement no = driver.findElement(By.xpath("//*[@id='root']//table/tbody/tr[1]/td[1]/div/div/div/div/div"));
				ColumnData[x][t] = no.getText();

			}
		}

		for (int x = 0; x < ColumnData.length; x++) {
			columnCount = 0;
			for (int t = 0; t < ColumnData[x].length; t++) {
				String expected = configReader.getProp("ASM_EditFirstName");
				if (ColumnData[x][t].contains(expected)) {
					flag = true;
					columnCount++;
					break;
				} else {
					flag = false;
				}
			}
			return flag;
		}
		return flag;
		
	}
	
	public boolean clickRemovebutton() throws InterruptedException {

		Thread.sleep(6500);
		txtFName.sendKeys(configReader.getProp("ASM_EditFirstName"));
		Thread.sleep(4500);
		btnRemove.click();

		WebElement lblRemoveAccountEle = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(lblRemoveAccount));
		return lblRemoveAccountEle.isDisplayed();
	}
	
	public boolean removeAccount() throws InterruptedException {

		btnConfirm.click();
		
		txtFName.sendKeys(Keys.CONTROL + "a");
		txtFName.sendKeys(Keys.DELETE);
		txtFName.sendKeys(configReader.getProp("ASM_EditFirstName"));

		int x = lstRows.size();
		if (x > 0) {
			return true;
		} else {
			return false;
		}
	}

}
