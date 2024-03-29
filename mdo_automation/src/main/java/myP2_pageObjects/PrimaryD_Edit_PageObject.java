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

import utils.ConstantsReader;
import utils.ElementUtils;

public class PrimaryD_Edit_PageObject {
	
	private WebDriver driver;	
	private ConstantsReader configReader = new ConstantsReader();
	boolean flag;
	
	public PrimaryD_Edit_PageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath = "//button[@data-el='buttonCustomizeTable']")
	WebElement btnEditTable;

	@FindBy(xpath = "(//button[contains(@data-el,'button-edit')])[1]")
	WebElement btnEditColumn;
	
//	@FindBy(xpath = "(//button[@class='sc-djvmMF ewtrKB'])[5]")
//	WebElement btnEditColumn;
	
	
	@FindBy(xpath = "//div[text()='Edit Column']")
	WebElement lblEditColumn;
	
	@FindBy(xpath = "//input[@name='name']")
	WebElement txtName;
	
	@FindBy(xpath = "//input[@name='kpiId']")
	WebElement drpkpi;
	
	@FindBy(xpath = "//div[@id='mui-component-select-valueDataType']")
	WebElement drpAmountType;
	
	@FindBy(xpath = "//div[@id='mui-component-select-valueDateOffsetType']")
	WebElement drpValueDateOffsetType;
	
	@FindBy(xpath = "//input[@name='year']")
	WebElement drpYear;

	@FindBy(xpath = "//span[@data-el='Switch-overrideDecimalMaster']")
	WebElement btnoverrideDecimalMaster;
	
	@FindBy(xpath = "//div[@id='mui-component-select-performanceIndicatorMasterOverride']")
	WebElement drpPerformanceIndicatorMasterOverride;
	
	@FindBy(xpath = "//button[@data-el='buttonSave']")
	WebElement btnSave;
	
	@FindBy(xpath = "//div[@role='listbox']//li")
	List <WebElement> listDrpValueSize;
	
	@FindBy(xpath = "//ul[@role='listbox']//li")
	List <WebElement> listAmountType;
	
	@FindBy(xpath = "//button[@data-el='buttonFinishCustomization']")
	WebElement btnImDone;
	
	@FindBy(xpath = "//th[text()='Property']")
	WebElement lblProperty;
		
	@FindBy(xpath = "(//div[contains(@class, 'MuiDataGrid-columnHeaderTitle css-cc8tf1')])[4]")
	WebElement lblEditedColumnHeader;

	@FindBy(xpath = "//div/input[contains(@name, 'porfolio-group')]")
	WebElement drpGroup;
	
	@FindBy(xpath = "//div/input[@name='porfolio-hotel']")
	WebElement drpProperty;
	
	@FindBy(xpath = "//button[text()='By Revenue']")
	WebElement tabByRevenue;
	
	@FindBy(xpath = "//div//b[text()='Portfolio Total']")
	WebElement lblTotal;
	
	public void selectParameters() throws InterruptedException {

		Thread.sleep(5000);
		
		if (drpGroup.isEnabled()) {
			/* Select the appropriate Group value from the drop-down menu. */
			WebElement drpGroupEle = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(drpGroup));
			drpGroupEle.click();

			ExpectedConditions.visibilityOf(listDrpValueSize.get(0));
			for (int i = 0; i < listDrpValueSize.size(); i++) {
				if (listDrpValueSize.get(i).getText().equalsIgnoreCase(configReader.getProp("Group"))) {
					listDrpValueSize.get(i).click();
				}
			}
		}

		Thread.sleep(5000);

		if (drpProperty.isEnabled()) {
			WebElement drpPropertyEle = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(drpProperty));
			drpPropertyEle.click();

			ExpectedConditions.visibilityOf(listDrpValueSize.get(1));
			for (int i = 0; i < listDrpValueSize.size(); i++) {
				if (listDrpValueSize.get(i).getText().equalsIgnoreCase(configReader.getProp("Propery"))) {
					listDrpValueSize.get(i).click();
				}
			}
		}
		ElementUtils.waitForElementToDisplay(lblProperty, 100);


	}
	
	
	public void clickOnEdit() throws InterruptedException {
		btnEditTable.click();
		ElementUtils.waitForElementToDisplay(btnEditColumn, 80);
		
	}
	
	public boolean verifyEditMode()  {
		
		if(btnEditColumn.isDisplayed()) {
			return true;
		}else {
			return false;
		}
		
	}
	
	public void clickOnEditColumn() throws InterruptedException  {
		
		Thread.sleep(1500);
		btnEditColumn.click();
		
		ElementUtils.waitForElementToDisplay(lblEditColumn, 100);
		
		if(txtName.isDisplayed()) {
			Thread.sleep(3500);
			txtName.sendKeys(Keys.CONTROL + "a");
			txtName.sendKeys(Keys.DELETE);
			txtName.sendKeys(configReader.getProp("Column_Name"));
			Thread.sleep(1000);
		}
		Thread.sleep(3500);
		int kpi =driver.findElements(By.xpath("//input[@name='kpiId']")).size();
		if(kpi>0) {
			drpkpi.sendKeys(Keys.CONTROL + "a");
			drpkpi.sendKeys(Keys.DELETE);
			drpkpi.sendKeys(configReader.getProp("Kpi"));
			
			ExpectedConditions.visibilityOf(listDrpValueSize.get(1));
			for (int i = 0; i < listDrpValueSize.size(); i++) {
				if (listDrpValueSize.get(i).getText().equalsIgnoreCase(configReader.getProp("Kpi"))) {
					listDrpValueSize.get(i).click();
					Thread.sleep(2000);
				}
			}
		}
		
		int amountType =driver.findElements(By.xpath("//div[@id='mui-component-select-valueDataType']")).size();
		if(amountType>0) {
			drpAmountType.click();
			ElementUtils.waitForElementToDisplay(listAmountType.get(1), 100);
			for (int i = 0; i < listAmountType.size(); i++) {
				if (listAmountType.get(i).getText().equalsIgnoreCase(configReader.getProp("Amount_Type"))) {
					Thread.sleep(4000);
					listAmountType.get(i).click();
					Thread.sleep(2000);
				}
			}
		}
		
		int valueDateOffsetType =driver.findElements(By.xpath("//div[@id='mui-component-select-valueDateOffsetType']")).size();
		if(valueDateOffsetType>0) {
			drpValueDateOffsetType.click();
			ExpectedConditions.visibilityOf(listAmountType.get(0));
			for (int i = 0; i < listAmountType.size(); i++) {
				if (listAmountType.get(i).getText().equalsIgnoreCase(configReader.getProp("Period"))) {
					listAmountType.get(i).click();
					Thread.sleep(2000);
				}
			}
		}
		
		int overrideDecimalMaster =driver.findElements(By.xpath("//span[@data-el='Switch-overrideDecimalMaster']")).size();
		if(overrideDecimalMaster>0)  {
			btnoverrideDecimalMaster.click();
		}
		
		int PerformanceIndicator =driver.findElements(By.xpath("//div[@id='mui-component-select-performanceIndicatorMasterOverride']")).size();
		if(PerformanceIndicator<0) {
			drpPerformanceIndicatorMasterOverride.click();
			ExpectedConditions.visibilityOf(listAmountType.get(0));
			for (int i = 0; i < listAmountType.size(); i++) {
				if (listAmountType.get(i).getText().equalsIgnoreCase(configReader.getProp("Porformance"))) {
					listAmountType.get(i).click();
					Thread.sleep(2000);
				}
			}
			
		}	
	}
	
	public void clickOnSave() throws InterruptedException {
		WebElement btnSaveEle = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(btnSave));
		btnSaveEle.click();
		Thread.sleep(5000);
		
		int Property =driver.findElements(By.xpath("//th[text()='Property']")).size();
		
		if (Property==1) {
			ElementUtils.waitForElementToDisplay(lblProperty, 30);
		} else {
			ElementUtils.waitForElementToDisplay(lblTotal, 30);
		}
		
		WebElement btnImDoneEle = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(btnImDone));
		btnImDoneEle.click();
	}
	
	public boolean verifyEditedColumn() throws InterruptedException  {
	
		Thread.sleep(3500);
		
		int Property =driver.findElements(By.xpath("//div[text()='Property']")).size();
		if (Property==1) {
			ElementUtils.waitForElementToDisplay(lblProperty, 30);
		} else {
			ElementUtils.waitForElementToDisplay(lblTotal, 30);
		}
		
		String EditedColumnHeader = lblEditedColumnHeader.getText();
		if (EditedColumnHeader.equals(configReader.getProp("Column_Name"))) {
			return true;
		} else {
			return false;
		}
		
	}
	
	public void clickOnEditOnByRevenue() throws InterruptedException {
		
		tabByRevenue.click();
		ElementUtils.waitForElementToDisplay(lblTotal, 50);
		
		btnEditTable.click();
		ElementUtils.waitForElementToDisplay(btnEditColumn,50);
		
	} 

}
