package myP2_pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ConstantsReader;
import utils.ElementUtils;

public class PnL_Comparison_EditCol_PageObject {
	
	private WebDriver driver;	
	private ConstantsReader configReader = new ConstantsReader();
	ArrayList<String> Headers ,SUBHeader;
	String headerName , headerYear , drpColVal2 ,drpYearValue2, drpColVal3 ,drpYearValue3;
	boolean flag;
	
			
	public PnL_Comparison_EditCol_PageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		Headers = new ArrayList<>();
		SUBHeader = new ArrayList<>();
		
	}
	


	@FindBy(xpath = "//th[contains(@class,' sc-bCfvAP cCGURw css-164s97t')]/span")
	List<WebElement> header;
	
	@FindBy(xpath = "//th[contains(@class,'sc-gYbzsP eIjwFz css-164s97t')]")
	List<WebElement> subHeader;

	@FindBy(xpath = "//div[text()='Rooms available']")
	WebElement lblRoomAva;
	
	@FindBy(xpath = "//h3[text()='Edit Columns']")
	WebElement lblEdit;
	
	@FindBy(xpath = "//button[@data-el='buttonFilter']")
	WebElement btnFilter;
	
	@FindBy(xpath = "//input[@name='columns[1].dataType']")
	WebElement drpColumn2Value;
	
	@FindBy(xpath = "//div[@id='mui-component-select-columns[1].yearOffest']")
	WebElement drpYear2;
	
	@FindBy(xpath = "//button[@data-el='buttonFiltersCancel']")
	WebElement btnClose ;
	
	@FindBy(xpath = "//div[@id='mui-component-select-columns[2].dataType']")
	WebElement drpColumn3;
	
	@FindBy(xpath = "//div[@id='mui-component-select-columns[2].yearOffest']")
	WebElement drpYear3;
	
	@FindBy(xpath = "//ul[@role='listbox']//li")
	List <WebElement> listDrpValueSize;
	
	@FindBy(xpath = "//button[@data-el='buttonFiltersApply']")
	WebElement btnApply;
	
	@FindBy(xpath = "//button//span[text()='Go']")
	WebElement btnGo;
	
	
	public boolean verifySecoundHeaderFunc() throws InterruptedException {

		ElementUtils.waitForElementToDisplay(lblRoomAva, 100);
		btnFilter.click();
		ElementUtils.waitForElementToDisplay(lblEdit, 100);

		drpColVal2 = drpColumn2Value.getAttribute("value");
		drpYearValue2 = drpYear2.getText();
		System.out.println("======drpYearValue2======"+drpYearValue2);
		
		btnClose.click();
		ElementUtils.waitForElementToHide(lblEdit, 100);

		for (int i = 0; i < header.size(); i++) {
			Headers.add(header.get(i).getText());
			
		}
		System.out.println("======Headers======"+Headers);
		
		for (int i = 0; i < subHeader.size(); i++) {
			SUBHeader.add(subHeader.get(i).getText());
		}
		System.out.println("======SUBHeader======"+SUBHeader);
		
		headerName = SUBHeader.get(4).split("-")[0].trim();
		headerYear = Headers.get(1).split("-")[1].strip();
		
		System.out.println("======drpColVal2======"+drpColVal2+"=========headerName========="+headerName);
		System.out.println("======drpYearValue2======"+drpYearValue2+"=========headerYear========="+headerYear);
		if (drpColVal2.equalsIgnoreCase(headerName) && drpYearValue2.equalsIgnoreCase(headerYear)) {
			flag = true;
		} else {
			flag = false;
		}
		return flag;

	}
	
	 public void addColumnFunc() throws InterruptedException {
	    	
	    	drpColumn3.click();
	    	for (int i = 0; i < listDrpValueSize.size(); i++) {
				if (listDrpValueSize.get(i).getText().equalsIgnoreCase(configReader.getProp("PnLE_Column"))) {
					listDrpValueSize.get(i).click();
				}
			}
	    	
	    	Thread.sleep(5000);
	    	drpYear3.click();
	    	for (int i = 0; i < listDrpValueSize.size(); i++) {
				if (listDrpValueSize.get(i).getText().equalsIgnoreCase(configReader.getProp("PnLE_Year"))) {
					listDrpValueSize.get(i).click();
				}
			}
	    	Thread.sleep(4000);
	    	btnApply.click();
	    	ElementUtils.waitForElementToHide(lblEdit, 100);
	    	
	    	btnGo.click();
			ElementUtils.waitForElementToDisplay(lblRoomAva, 100);
	    	
	    }
	    
	    public boolean verifyNewlyAddedColFunc() throws InterruptedException {
	    	
			for (int i = 0; i < header.size(); i++) {
				Headers.add(header.get(i).getText());
			}

			for (int i = 0; i < subHeader.size(); i++) {
				SUBHeader.add(subHeader.get(i).getText());
			}
			
			headerName = SUBHeader.get(6).split("-")[0].trim();
			headerYear = Headers.get(2).split("-")[1].strip();
			
			if (headerName.equalsIgnoreCase(configReader.getProp("PnLE_Column")) && headerYear.equalsIgnoreCase(configReader.getProp("PnLE_Year"))) {
				flag = true;
			} else {
				flag = false;
			}
			return flag;
	    	
	    }
	    
	    public void removeColumnFunc() throws InterruptedException {
	    	
	    	drpColumn3.click();
	    	Thread.sleep(5000);
	    	for (int i = 0; i < listDrpValueSize.size(); i++) {
				if (listDrpValueSize.get(i).getText().equalsIgnoreCase(configReader.getProp("PnLE_RemoveColumn"))) {
					listDrpValueSize.get(i).click();
				}
			}
	    	
	    	Thread.sleep(2000);
	    	btnApply.click();
	    	ElementUtils.waitForElementToHide(lblEdit, 100);
	    	
	    	btnGo.click();
			ElementUtils.waitForElementToDisplay(lblRoomAva, 100);
	    	
	    }
	    
	   public boolean verifyRemovedColFunc() throws InterruptedException {
			
			if (header.size()==2) {
				flag = true;
			} else {
				flag = false;
			}
			return flag;
	    	
	    }

}
