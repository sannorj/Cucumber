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

public class PnL_SuppressZero_PageObject {
	
	private WebDriver driver;	
	private ConstantsReader configReader = new ConstantsReader();

		public PnL_SuppressZero_PageObject(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(xpath = "//div[text()='P&L Monthly']//ancestor::li")
		WebElement pnlMonthly;
		
		@FindBy(xpath = "//div/input[@name='portfolio-group']")
		WebElement drpGroup;
		
		@FindBy(xpath = "//div/input[@name='portfolio-hotel']")
		WebElement drpProperty;
		
		@FindBy(xpath = "(//label[text()='View']//following::div)[2]")
		WebElement drpView;
		
		@FindBy(xpath = "//div/label[text()='Date']//following-sibling::div/input[@name='date']")
		WebElement txtDrp;
		
		@FindBy(xpath = "//button//span[text()='Go']")
		WebElement btnGo;
		
		@FindBy(xpath = "//ul[@role='listbox']//li")
		List <WebElement> listDrpValueSize;
		
//		@FindBy(xpath = "//input[@name='date']")
//		WebElement txtDate;
		
		@FindBy(xpath = "//label[text()='Date']//parent::div//input")
		WebElement txtDate;
			
		@FindBy(xpath = "//input[@name='nullRecords']")
		WebElement btnZeroValue;
		
		@FindBy(xpath = "//div[text()='Rooms available']")
		WebElement lblRoomAva;
		
	
	 public void selectParameters() throws InterruptedException {

		   Thread.sleep(4500);
		   
			if (drpGroup.isEnabled()) {
				/* Select the appropriate Group value from the drop-down menu. */
				WebElement drpGroupEle = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(drpGroup));
				drpGroupEle.click();

				ExpectedConditions.visibilityOf(listDrpValueSize.get(0));
				for (int i = 0; i < listDrpValueSize.size(); i++) {
					if (listDrpValueSize.get(i).getText().equalsIgnoreCase(configReader.getProp("SZ_Group"))) {
						listDrpValueSize.get(i).click();
					}
				}
			}

			if (drpProperty.isEnabled()) {
				WebElement drpPropertyEle = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(drpProperty));
				drpPropertyEle.click();

				ExpectedConditions.visibilityOf(listDrpValueSize.get(1));
				for (int i = 0; i < listDrpValueSize.size(); i++) {
					if (listDrpValueSize.get(i).getText().equalsIgnoreCase(configReader.getProp("SZ_Propery"))) {
						listDrpValueSize.get(i).click();
					}
				}
			}

				txtDate.sendKeys(Keys.CONTROL + "a");
				txtDate.sendKeys(Keys.DELETE);
				txtDate.sendKeys(configReader.getProp("SZ_Date"));
				Thread.sleep(1500);

				WebElement drpViewEle = new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(drpView));
				drpViewEle.click();
				Thread.sleep(3500);

				for (int i = 0; i < listDrpValueSize.size(); i++) {
					if (listDrpValueSize.get(i).getText().equalsIgnoreCase(configReader.getProp("SZ_View"))) {
						ExpectedConditions.visibilityOf(listDrpValueSize.get(0));
						listDrpValueSize.get(i).click();
					}
				}
			
				Thread.sleep(3500);
				WebElement btnGO = new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(btnGo));
				btnGO.click();
				
				
		}

	 
		public boolean SuppressRowFunc() throws InterruptedException {
			Thread.sleep(4000);
			boolean flag = true;
			int row = driver.findElements(By.xpath("//div[text()='Total Rooms Revenue']")).size();
				if (row==0) {
					flag = true;
				} else {
					flag = false;
				}
			return flag;
		}


	 public void clickOnSuppressZeroFunc() throws InterruptedException {
		 
		 int GO = driver.findElements(By.xpath("//button//span[text()='Go']")).size();
			if (GO==1) {
				btnGo.click();
				Thread.sleep(3500);
			} 
		 /* mandatory pause */
			ElementUtils.waitForElementToDisplay(lblRoomAva, 100);
			btnZeroValue.click();
	 }
	 
	 public boolean displayRowFunc() throws InterruptedException {
			Thread.sleep(4000);
			boolean flag = true;
			int row = driver.findElements(By.xpath("//div[text()='Total Rooms Revenue']")).size();
				if (row==1) {
					flag = true;
				} else {
					flag = false;
				}
			return flag;
		}
	 
}
