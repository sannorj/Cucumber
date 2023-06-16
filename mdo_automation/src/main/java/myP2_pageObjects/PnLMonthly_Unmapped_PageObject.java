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

import utils.ConstantsReader;
import utils.ElementUtils;

public class PnLMonthly_Unmapped_PageObject {
	
	private WebDriver driver;
	private ConstantsReader configReader = new ConstantsReader();
	boolean flag;

	public PnLMonthly_Unmapped_PageObject(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//button[@data-el='buttonViewUnmapped']")
	WebElement pnlUnmappedButt;

	@FindBy(xpath = "//h1[text()='Profit & Loss Monthly Report']")
	WebElement verifyUnmappedPage;

	@FindBy(xpath = "//div[@data-el='selectorHotelInput']")
	WebElement propertyDropdown;

	@FindBy(xpath = "//div[@data-el='selectorYear']")
	WebElement yearDropdown;

	@FindBy(xpath = "//div[@data-el='dropdownPnLUnmappedSelector']")
	WebElement unmappedSelectorDropdown;
	
	@FindBy(xpath = "//div[@role='listbox']//li")
	List<WebElement> listDrpValueSize;
	
	@FindBy(xpath = "//ul[@role='listbox']//li")
	List<WebElement> listDrpValueSize2;
	
	@FindBy(xpath = "//button[@data-el='buttonGo']")
	WebElement goButton;

	
	public void selectPnLunmappedOpt() throws InterruptedException {

		Thread.sleep(5000);

		if (pnlUnmappedButt.isEnabled()) {
			WebElement pnlUnmappedButtEle = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(pnlUnmappedButt));
			pnlUnmappedButtEle.click();
			
		}

		Thread.sleep(3000);

	}
	
	
	public void verifyPnLunmappedPage() throws InterruptedException {

		Thread.sleep(2000);

		WebElement verifyUnmappedPageEle = driver.findElement(By.xpath("//h1[text()='Profit & Loss Unmapped']"));
		ElementUtils.waitForElementToDisplay(verifyUnmappedPageEle, 100);

		Thread.sleep(5000);

	}
	
	
	public void missingPropertyGlFunc() throws InterruptedException {

		Thread.sleep(3000);

		if (propertyDropdown.isEnabled()) {
			WebElement propertyDropdownEle = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(propertyDropdown));
			propertyDropdownEle.click();

			// ExpectedConditions.visibilityOf(listDrpValueSize.get(0));
			for (int i = 0; i < listDrpValueSize.size(); i++) {
				if (listDrpValueSize.get(i).getText().equalsIgnoreCase(configReader.getProp("PnLunmapped_property_1"))) {
					listDrpValueSize.get(i).click();
				}
			}
		}

		Thread.sleep(5000);
		
		if (yearDropdown.isEnabled()) {
			WebElement yearDropdownEle = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(yearDropdown));
			yearDropdownEle.click();
			
			
			if (listDrpValueSize2.size()>0) {
				// ExpectedConditions.visibilityOf(listDrpValueSize.get(0));
				for (int n = 0; n < listDrpValueSize2.size(); n++) {
					if (listDrpValueSize2.get(n).getText().equalsIgnoreCase(configReader.getProp("PnLunmapped_year_1"))) {
						listDrpValueSize2.get(n).click();
					}
				}
				
			}else{
				Thread.sleep(3000);
				
				WebElement yearDropdownEle1 = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(yearDropdown));
				yearDropdownEle1.click();
				
				for (int n = 0; n < listDrpValueSize2.size(); n++) {
					if (listDrpValueSize2.get(n).getText()
							.equalsIgnoreCase(configReader.getProp("PnLunmapped_year_1"))) {
						listDrpValueSize2.get(n).click();
					}
				}
				
			}

			
		}
		
		Thread.sleep(8000);
		
		if (unmappedSelectorDropdown.isEnabled()) {
			WebElement unmappedSelectorDropdownEle = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(unmappedSelectorDropdown));
			unmappedSelectorDropdownEle.click();

			// ExpectedConditions.visibilityOf(listDrpValueSize.get(0));
			for (int k = 0; k < listDrpValueSize2.size(); k++) {
				if (listDrpValueSize2.get(k).getText().equalsIgnoreCase(configReader.getProp("PnLunmapped_selector_1"))) {
					listDrpValueSize2.get(k).click();
				}
			}
		}
		
		Thread.sleep(3000);
		
		if (goButton.isEnabled()) {
			WebElement goButtonEle = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(goButton));
			goButtonEle.click();
			
			}
			
		Thread.sleep(5000);

	}
	
	
	public void glNotInCoaFunc() throws InterruptedException {

		Thread.sleep(3000);

		if (propertyDropdown.isEnabled()) {
			WebElement propertyDropdownEle = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(propertyDropdown));
			propertyDropdownEle.click();

			// ExpectedConditions.visibilityOf(listDrpValueSize.get(0));
			for (int i = 0; i < listDrpValueSize.size(); i++) {
				if (listDrpValueSize.get(i).getText().equalsIgnoreCase(configReader.getProp("PnLunmapped_property_2"))) {
					listDrpValueSize.get(i).click();
				}
			}
		}

		Thread.sleep(3000);
		
		if (yearDropdown.isEnabled()) {
			WebElement yearDropdownEle = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(yearDropdown));
			yearDropdownEle.click();

			// ExpectedConditions.visibilityOf(listDrpValueSize.get(0));
			for (int n = 0; n < listDrpValueSize2.size(); n++) {
				if (listDrpValueSize2.get(n).getText().equalsIgnoreCase(configReader.getProp("PnLunmapped_year_2"))) {
					listDrpValueSize2.get(n).click();
				}
			}
		}
		
		Thread.sleep(3000);
		
		if (unmappedSelectorDropdown.isEnabled()) {
			WebElement unmappedSelectorDropdownEle = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(unmappedSelectorDropdown));
			unmappedSelectorDropdownEle.click();

			// ExpectedConditions.visibilityOf(listDrpValueSize.get(0));
			for (int k = 0; k < listDrpValueSize2.size(); k++) {
				if (listDrpValueSize2.get(k).getText().equalsIgnoreCase(configReader.getProp("PnLunmapped_selector_2"))) {
					listDrpValueSize2.get(k).click();
				}
			}
		}
		
		Thread.sleep(3000);
		
		if (goButton.isEnabled()) {
			WebElement goButtonEle = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(goButton));
			goButtonEle.click();
			
			}
			
		Thread.sleep(5000);

	}
	
	
	public void glNotMappedFunc() throws InterruptedException {

		Thread.sleep(3000);

		if (propertyDropdown.isEnabled()) {
			WebElement propertyDropdownEle = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(propertyDropdown));
			propertyDropdownEle.click();

			// ExpectedConditions.visibilityOf(listDrpValueSize.get(0));
			for (int i = 0; i < listDrpValueSize.size(); i++) {
				if (listDrpValueSize.get(i).getText().equalsIgnoreCase(configReader.getProp("PnLunmapped_property_3"))) {
					listDrpValueSize.get(i).click();
				}
			}
		}

		Thread.sleep(3000);
		
		if (yearDropdown.isEnabled()) {
			WebElement yearDropdownEle = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(yearDropdown));
			yearDropdownEle.click();

			// ExpectedConditions.visibilityOf(listDrpValueSize.get(0));
			for (int n = 0; n < listDrpValueSize2.size(); n++) {
				if (listDrpValueSize2.get(n).getText().equalsIgnoreCase(configReader.getProp("PnLunmapped_year_3"))) {
					listDrpValueSize2.get(n).click();
				}
			}
		}
		
		Thread.sleep(3000);
		
		if (unmappedSelectorDropdown.isEnabled()) {
			WebElement unmappedSelectorDropdownEle = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(unmappedSelectorDropdown));
			unmappedSelectorDropdownEle.click();

			// ExpectedConditions.visibilityOf(listDrpValueSize.get(0));
			for (int k = 0; k < listDrpValueSize2.size(); k++) {
				if (listDrpValueSize2.get(k).getText().equalsIgnoreCase(configReader.getProp("PnLunmapped_selector_3"))) {
					listDrpValueSize2.get(k).click();
				}
			}
		}
		
		Thread.sleep(3000);
		
		if (goButton.isEnabled()) {
			WebElement goButtonEle = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(goButton));
			goButtonEle.click();
			
			}
			
		Thread.sleep(5000);
	}
	
	
	public void verifyTableHader() throws InterruptedException {

		Thread.sleep(2000);
		
		int hader = driver.findElements(By.xpath("//th[text()='Description']")).size();
		
		if (hader == 1) {
			flag = true;
			WebElement verifyTableHaderEle = driver.findElement(By.xpath("//th[text()='Description']"));
			ElementUtils.waitForElementToDisplay(verifyTableHaderEle, 100);
			
			Thread.sleep(3000);
			
		} else {
			
			WebElement noDataMessage = driver.findElement(By.xpath("//div[@data-el='noDataToShow']"));
			ElementUtils.waitForElementToDisplay(noDataMessage, 100);
		}

		Thread.sleep(3000);

	}
	

}
