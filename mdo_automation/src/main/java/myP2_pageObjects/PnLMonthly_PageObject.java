package myP2_pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ConstantsReader;

import java.awt.Robot;
import java.time.Duration;
import java.util.List;
import java.awt.event.KeyEvent;	



public class PnLMonthly_PageObject {
boolean flag;
private WebDriver driver;	
private ConstantsReader configReader = new ConstantsReader();

	public PnLMonthly_PageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		flag= false;
	}
	
	@FindBy(xpath = "//div[text()='P&L Monthly']//ancestor::li")
	WebElement pnlMonthly;
	
	@FindBy(xpath = "//div/label[text()='Group']//following-sibling::div/input[@name='portfolio-group']")
	WebElement drpGroup;
	
	@FindBy(xpath = "//div/label[text()='Property']//following-sibling::div/input[@name='portfolio-hotel']")
	WebElement drpProperty;
	
	@FindBy(xpath = "(//label[text()='View']//following::div)[2]")
	WebElement drpView;
	
	
	@FindBy(xpath = "//div/label[text()='Date']//following-sibling::div/input[@name='date']")
	WebElement txtDrp;
	
	@FindBy(xpath = "//button[@data-el='buttonGo']")
	WebElement btnGo;
	
	@FindBy(xpath = "//ul[@role='listbox']//li")
	List <WebElement>   listDrpValueSize;
	
	@FindBy(xpath = "//h1[text()='Profit & Loss Monthly Report']")
	WebElement pnlMonthlyPage;
	
	@FindBy(xpath = "//div[@class='MuiCollapse-container sc-iAKWXU lesjfG MuiCollapse-entered']//following-sibling::div/div")
	List <WebElement>   listStaticValues;
	
	@FindBy(xpath = "//input[@name='date']")
	WebElement txtDate;
	
	
	public boolean navigatePnLMonthlyPage() {
		WebElement pnlMonthEle = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(pnlMonthly));
		pnlMonthEle.click();
		
		WebElement pnlMothlyPageEle = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(pnlMonthlyPage));
		
		return pnlMothlyPageEle.isDisplayed();
		
	}
	
	public void selectParameters() {
		
		try {
			/* Select the appropriate Group value from the drop-down menu. */
			WebElement drpGroupEle = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(drpGroup));
			drpGroupEle.click();
			/* mandatory pause */
			Thread.sleep(1500);
			for (int i = 0; i < listDrpValueSize.size(); i++) {
				if (listDrpValueSize.get(i).getText().equalsIgnoreCase(configReader.getProp("Group"))) {
					listDrpValueSize.get(i).click();
				}
			}

			/*Select the appropriate property value from the drop-down menu  */
			WebElement drpPropertyEle = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(drpProperty));
			drpPropertyEle.click();
			/* mandatory pause */
			Thread.sleep(1500);
			for (int i = 0; i < listDrpValueSize.size(); i++) {
				if (listDrpValueSize.get(i).getText().equalsIgnoreCase(configReader.getProp("Propery"))) {
					listDrpValueSize.get(i).click();
				}
			}
			
			/*Select the Date  */
			txtDate.sendKeys(Keys.CONTROL + "a");
			txtDate.sendKeys(Keys.DELETE);
			//txtDate.clear();
			txtDate.sendKeys(configReader.getProp("Date"));
			
		
			/*Select the appropriate View value from the drop-down menu  */
			WebElement drpViewEle = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(drpView));
			drpViewEle.click();
			/* mandatory pause */
			Thread.sleep(1500);
			for (int i = 0; i < listDrpValueSize.size(); i++) {
				if (listDrpValueSize.get(i).getText().equalsIgnoreCase(configReader.getProp("View"))) {
					listDrpValueSize.get(i).click();
				}
			}
			
			/* Click on Go button */
			WebElement btnGO = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(btnGo));
			btnGO.click();

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	

	}
	
	
	public boolean verifyStaticSection() {
		try {
			Thread.sleep(2500);
			/* capture/go though the 5 static section   */
			for (int x = 0; x < 5; x++) {
				/* split and ready the data from property file   */
				String[] a = configReader.getProp("Static_Names").split(",");
				/* Get the 5 static section form property file  */
				for (int i = 0; i < a.length; i++) {
					String expected = a[i];
					String actual = listStaticValues.get(i).getText();
					if(actual.contains(expected)) {
						flag = true ;
					}else {
						flag =false ;
					}
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return flag;

	}
	
	
	

}
