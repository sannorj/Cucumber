package myP2_pageObjects;

import java.time.Duration;
import java.util.ArrayList;
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

public class PnL_Monthly_EditCol_PageObject {
	
	private WebDriver driver;	
	private ConstantsReader configReader = new ConstantsReader();
	ArrayList<String> Headers;
	String headerName , headerYear , drpColVal1 ,drpYearValue1, drpColVal2 ,drpYearValue2, drpColVal3 ,drpYearValue3;
	boolean flag;
	
			
	public PnL_Monthly_EditCol_PageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		Headers = new ArrayList<>();
	}
	
	@FindBy(xpath = "//div[text()='Rooms available']")
	WebElement lblRoomAva;
	
	@FindBy(xpath = "//th[contains(@class,' sc-bCfvAP cCGURw css-164s97t')]/span")
	List <WebElement> header;
	
	@FindBy(xpath = "//button[@data-el='buttonFilter']")
	WebElement btnFilter;
	
	@FindBy(xpath = "//h3[text()='Edit Columns']")
	WebElement lblEdit;
	
	@FindBy(xpath = "//div[@id='mui-component-select-columns[0].dataType']")
	WebElement drpColumn1;
	
	@FindBy(xpath = "//input[@name='columns[0].dataType']")
	WebElement drpColumn1Value;
	
	@FindBy(xpath = "//div[@id='mui-component-select-columns[1].dataType']")
	WebElement drpColumn2;
	
	@FindBy(xpath = "//input[@name='columns[1].dataType']")
	WebElement drpColumn2Value;
	
	@FindBy(xpath = "//div[@id='mui-component-select-columns[2].dataType']")
	WebElement drpColumn3;
	
	@FindBy(xpath = "//input[@name='columns[2].dataType']")
	WebElement drpColumn3Value;
	
	@FindBy(xpath = "//div[@id='mui-component-select-columns[3].dataType']")
	WebElement drpColumn4;
	
	@FindBy(xpath = "//div[@id='mui-component-select-columns[4].dataType']")
	WebElement drpColumn5;
	
	@FindBy(xpath = "//div[@id='mui-component-select-columns[5].dataType']")
	WebElement drpColumn6;

	@FindBy(xpath = "//div[@id='mui-component-select-columns[0].yearOffest']")
	WebElement drpYear1;
	
	@FindBy(xpath = "//input[@name='columns[0].yearOffest']")
	WebElement drpYear1Value;
	
	@FindBy(xpath = "//div[@id='mui-component-select-columns[1].yearOffest']")
	WebElement drpYear2;
	
	@FindBy(xpath = "//input[@name='columns[1].yearOffest']")
	WebElement drpYear2Value;
	
	@FindBy(xpath = "//div[@id='mui-component-select-columns[2].yearOffest']")
	WebElement drpYear3;
	
	@FindBy(xpath = "//input[@name='columns[2].yearOffest']")
	WebElement drpYear3Value;
	
	@FindBy(xpath = "//div[@id='mui-component-select-columns[3].yearOffest']")
	WebElement drpYear4;
	
	@FindBy(xpath = "//div[@id='mui-component-select-columns[4].yearOffest']")
	WebElement drpYear5;
	
	@FindBy(xpath = "//div[@id='mui-component-select-columns[5].yearOffest']")
	WebElement drpYear6;
	
	@FindBy(xpath = "//button[@data-el='buttonFiltersApply']")
	WebElement btnApply;
	
	@FindBy(xpath = "//button[@data-el='buttonFiltersCancel']")
	WebElement btnClose ;
	
	@FindBy(xpath = "//ul[@role='listbox']//li")
	List <WebElement> listDrpValueSize;
	
	@FindBy(xpath = "//button//span[text()='Go']")
	WebElement btnGo;
	
	@FindBy(xpath = "//label[text()='Year']")
	List <WebElement> lstYear;
	
	
	
	public void clickOnEditFunc() throws InterruptedException {
		ElementUtils.waitForElementToDisplay(lblRoomAva, 100);
		Thread.sleep(2500);
		btnFilter.click();
		ElementUtils.waitForElementToDisplay(lblEdit, 100);
	}
	
	public boolean verifyEditDrawerFunc() {
		
		for(int i=0 ; i<header.size()-1 ; i++) {
			if(i != 2) {
				Headers.add(header.get(i).getText());
			}
		}
		
		drpColVal1=drpColumn1Value.getAttribute("value");
		drpYearValue1 =drpYear1.getText();
		
		drpColVal2=drpColumn2Value.getAttribute("value");
		drpYearValue2 =drpYear2.getText();
		
		drpColVal3=drpColumn3Value.getAttribute("value");
		drpYearValue3 =drpYear3.getText();
	
		
		WebElement lblEditColumns = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(lblEdit));
		return lblEditColumns.isDisplayed();
	}
	
	public boolean verifyFirstHeaderFunc() throws InterruptedException {

		btnClose.click();
		ElementUtils.waitForElementToHide(lblEdit, 100);
		Thread.sleep(4500);
		for (int i =0; i < header.size(); i++) {
			Thread.sleep(1500);
			Headers.add(header.get(i).getText());
		}
		
		
		headerName = Headers.get(0).split("-")[0].trim();
		headerYear = Headers.get(0).split("-")[1].strip();

		if (drpColVal1.equalsIgnoreCase(headerName) && drpYearValue1.equalsIgnoreCase(headerYear)) {
			flag = true;
		} else {
			flag = false;
		}
		return flag;

	}
	
    public boolean verifySecoundHeaderFunc() throws InterruptedException {
		
		headerName = Headers.get(1).split("-")[0].trim();
		headerYear =Headers.get(1).split("-")[1].strip();
		
		if (drpColVal2.equalsIgnoreCase(headerName) && drpYearValue2.equalsIgnoreCase(headerYear)) {
			flag = true;
		} else {
			flag = false;
		}
		return flag;
		
	}
    
    public boolean verifyThridHeaderFunc() throws InterruptedException {
		
  		headerName = Headers.get(2).split("-")[0].trim();
  		headerYear =Headers.get(2).split("-")[2].strip();
  		
  		if (drpColVal3.equalsIgnoreCase(headerName) && drpYearValue3.equalsIgnoreCase(headerYear)) {
			flag = true;
		} else {
			flag = false;
		}
		return flag;
  		
  	}
    
    public void addColumnFunc() throws InterruptedException {
    	
    	Thread.sleep(2000);
    	drpColumn4.click();
    	for (int i = 0; i < listDrpValueSize.size(); i++) {
			if (listDrpValueSize.get(i).getText().equalsIgnoreCase(configReader.getProp("PnLE_Column"))) {
				listDrpValueSize.get(i).click();
			}
		}
    	
    	Thread.sleep(2000);
    	
    	drpYear4.click();
    	for (int i = 0; i < listDrpValueSize.size(); i++) {
			if (listDrpValueSize.get(i).getText().equalsIgnoreCase(configReader.getProp("PnLE_Year"))) {
				listDrpValueSize.get(i).click();
			}
		}
    	Thread.sleep(2000);
    	btnApply.click();
    	ElementUtils.waitForElementToHide(lblEdit, 100);
    	
    	btnGo.click();
		ElementUtils.waitForElementToDisplay(lblRoomAva, 100);
    	
    	
    }
    
    public boolean verifyNewlyAddedColFunc() throws InterruptedException {
    	
    	for(int i=0 ; i<header.size()-1 ; i++) {
			if(i != 2 && i !=4) {
				Headers.add(header.get(i).getText());
			}
		}
    	headerName = Headers.get(3).split("-")[0].trim();
		headerYear =Headers.get(3).split("-")[1].strip();
		
		if (headerName.equalsIgnoreCase(configReader.getProp("PnLE_Column")) && headerYear.equalsIgnoreCase(configReader.getProp("PnLE_Year"))) {
			flag = true;
		} else {
			flag = false;
		}
		return flag;
    	
    }
    
    public void removeColumnFunc() throws InterruptedException {
    	
    	drpColumn4.click();
    	Thread.sleep(4000);
    	for (int i = 0; i < listDrpValueSize.size(); i++) {
			if (listDrpValueSize.get(i).getText().equalsIgnoreCase(configReader.getProp("PnLE_RemoveColumn"))) {
				listDrpValueSize.get(i).click();
			}
		}
    	
    	Thread.sleep(4000);
    	btnApply.click();
    	ElementUtils.waitForElementToHide(lblEdit, 100);
    	
    	btnGo.click();
		ElementUtils.waitForElementToDisplay(lblRoomAva, 100);
    	
    }
    
   public boolean verifyRemovedColFunc() throws InterruptedException {
		
		if (header.size()==5) {
			flag = true;
		} else {
			flag = false;
		}
		return flag;
    	
    }
   
	public boolean changeColumnFunc() throws InterruptedException {

		String[] a = configReader.getProp("PnLE_Column_1").split(",");
		String[] b = configReader.getProp("PnLE_Year_1").split(",");
		String[] c = configReader.getProp("PnLE_Column_2").split(",");
		String[] d = configReader.getProp("PnLE_Year_2").split(",");
		String[] e = configReader.getProp("PnLE_Column_3").split(",");
		String[] f = configReader.getProp("PnLE_Year_3").split(",");
		String[] g = configReader.getProp("PnLE_Column_4").split(",");
		String[] h = configReader.getProp("PnLE_Year_4").split(",");
		String[] i = configReader.getProp("PnLE_Column_5").split(",");
		String[] j = configReader.getProp("PnLE_Year_5").split(",");
		String[] k = configReader.getProp("PnLE_Column_6").split(",");
		String[] l = configReader.getProp("PnLE_Year_6").split(",");
		String headerName1 , headerYearl;
		
		/*Edit 1st column and year dropdown */
		for (int x = 0; x < lstYear.size(); x++) {
			
			clickOnEditFunc();
			
			String PnLE_Column_1 = a[x];
			String PnLE_Year_1 = b[x];
			drpColumn1.click();
			for (int n = 0; n < listDrpValueSize.size(); n++) {
				if (listDrpValueSize.get(n).getText().equalsIgnoreCase(PnLE_Column_1)) {
					listDrpValueSize.get(n).click();
				}
			}
			Thread.sleep(2000);
			drpYear1.click();
			for (int n = 0; n < listDrpValueSize.size(); n++) {
				if (listDrpValueSize.get(n).getText().equalsIgnoreCase(PnLE_Year_1)) {
					listDrpValueSize.get(n).click();
				}
			}
			Thread.sleep(2000);

			/*Edit 2nd column and year dropdown */
			String PnLE_Column_2 = c[x];
			String PnLE_Year_2 = d[x];
			drpColumn2.click();
			for (int n = 0; n < listDrpValueSize.size(); n++) {
				if (listDrpValueSize.get(n).getText().equalsIgnoreCase(PnLE_Column_2)) {
					listDrpValueSize.get(n).click();
				}
			}
			Thread.sleep(2000);
			drpYear2.click();
			for (int n = 0; n < listDrpValueSize.size(); n++) {
				if (listDrpValueSize.get(n).getText().equalsIgnoreCase(PnLE_Year_2)) {
					listDrpValueSize.get(n).click();
				}
			}
			Thread.sleep(2000);

			/*Edit 3rd column and year dropdown */
			String PnLE_Column_3 = e[x];
			String PnLE_Year_3 = f[x];
			drpColumn3.click();
			for (int n = 0; n < listDrpValueSize.size(); n++) {
				if (listDrpValueSize.get(n).getText().equalsIgnoreCase(PnLE_Column_3)) {
					listDrpValueSize.get(n).click();
				}
			}
			Thread.sleep(2000);
			drpYear3.click();
			for (int n = 0; n < listDrpValueSize.size(); n++) {
				if (listDrpValueSize.get(n).getText().equalsIgnoreCase(PnLE_Year_3)) {
					listDrpValueSize.get(n).click();
				}
			}
			Thread.sleep(2000);
			
			/*Edit 4th column and year dropdown */
			int drp4 = driver.findElements(By.xpath("//div[@id='mui-component-select-columns[3].dataType']")).size();
			if (drp4 > 0) {
				String PnLE_Column_4 = g[x];
				String PnLE_Year_4 = h[x];
				drpColumn4.click();
				for (int n = 0; n < listDrpValueSize.size(); n++) {
					if (listDrpValueSize.get(n).getText().equalsIgnoreCase(PnLE_Column_4)) {
						listDrpValueSize.get(n).click();
					}
				}
				Thread.sleep(2000);
				drpYear4.click();
				for (int n = 0; n < listDrpValueSize.size(); n++) {
					if (listDrpValueSize.get(n).getText().equalsIgnoreCase(PnLE_Year_4)) {
						listDrpValueSize.get(n).click();
					}
				}

			}
			Thread.sleep(2000);
			
			/*Edit 5th column and year dropdown */
			int drp5 = driver.findElements(By.xpath("//div[@id='mui-component-select-columns[4].dataType']")).size();
			if (drp5 > 0) {
				String PnLE_Column_5 = i[x];
				String PnLE_Year_5 = j[x];
				drpColumn4.click();
				for (int n = 0; n < listDrpValueSize.size(); n++) {
					if (listDrpValueSize.get(n).getText().equalsIgnoreCase(PnLE_Column_5)) {
						listDrpValueSize.get(n).click();
					}
				}
				Thread.sleep(2000);
				drpYear4.click();
				for (int n = 0; n < listDrpValueSize.size(); n++) {
					if (listDrpValueSize.get(n).getText().equalsIgnoreCase(PnLE_Year_5)) {
						listDrpValueSize.get(n).click();
					}
				}

			}
			Thread.sleep(2000);
			
			/*Edit 6th column and year dropdown */
			int drp6 = driver.findElements(By.xpath("//div[@id='mui-component-select-columns[5].dataType']")).size();
			if (drp6 > 0) {
				String PnLE_Column_6 = k[x];
				String PnLE_Year_6 = l[x];
				drpColumn4.click();
				for (int n = 0; n < listDrpValueSize.size(); n++) {
					if (listDrpValueSize.get(n).getText().equalsIgnoreCase(PnLE_Column_6)) {
						listDrpValueSize.get(n).click();
					}
				}
				Thread.sleep(2000);
				drpYear4.click();
				for (int n = 0; n < listDrpValueSize.size(); n++) {
					if (listDrpValueSize.get(n).getText().equalsIgnoreCase(PnLE_Year_6)) {
						listDrpValueSize.get(n).click();
					}
				}

			}
			Thread.sleep(2000);

			btnApply.click();
			ElementUtils.waitForElementToHide(lblEdit, 100);

			btnGo.click();
			ElementUtils.waitForElementToDisplay(lblRoomAva, 100);
			Thread.sleep(7000);
			Headers.clear();
			
			for (int n = 0; n < header.size(); n++) {
				Headers.add(header.get(n).getText());
			}
				    
			if(PnLE_Column_1.equalsIgnoreCase("FORECAST")|| PnLE_Column_1.equalsIgnoreCase("ACTUAL/FORECAST")) {
				headerName1 = Headers.get(0).split("-")[0].trim();
				headerYearl = Headers.get(0).split("-")[2].strip();
			}else {
				headerName1 = Headers.get(0).split("-")[0].trim();
				headerYearl = Headers.get(0).split("-")[1].strip();
			}
						
			if (headerName1.equalsIgnoreCase(PnLE_Column_1)&& headerYearl.equalsIgnoreCase(PnLE_Year_1)) {
				flag = true;
			} else {
				flag = false;
			}

		}
		return true;
	}
    

}
