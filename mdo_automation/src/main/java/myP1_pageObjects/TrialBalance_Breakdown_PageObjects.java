package myP1_pageObjects;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.ConstantsReader;

public class TrialBalance_Breakdown_PageObjects {

	WebDriver driver;
	private ConstantsReader configReader = new ConstantsReader();

	public TrialBalance_Breakdown_PageObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	@FindBy(xpath = "//div[@class='sidebar-header']")
	WebElement navigationLink;
	
	@FindBy(xpath = "//a//span[text()='Trial Balance']")
	WebElement TBLink;

	@FindBy(xpath = "//a//span[contains(text(),'TrialBalance BreakDown (Classic)')]")
	WebElement TBBreakDownLink;

	@FindBy(xpath = "//h2[text()='TrialBalance Breakdown']")
	WebElement TBBreakDownTitle;

	@FindBy(xpath = "//table/thead/tr/th[text()='Description']")
	WebElement TBisTblLoad;

	@FindBy(xpath = "(//select[@class='form-control select2-offscreen'])[1]")
	WebElement propertyDropdown;

	@FindBy(xpath = "//input[@id='txtDate']")
	WebElement datePickerVal;
	
	@FindBy(xpath = "//select[@id='ddlPeriod']")
	WebElement periodDropdown;
	
	@FindBy(xpath = "//input[@value='Update']")
	WebElement updateBtn;

	@FindBy(xpath = "//div[@id='tblTBContainer']//table/thead/tr/th")
	List<WebElement> lstHeader;
	
	@FindBy(xpath = "//div[@id='tblTBContainer']//table/tbody/tr[contains(@class,'Data') and not(contains(@class,'SuspenseData')) and not(contains(@class,'IgnoreData'))]")
	List<WebElement> lstRow;
	
	@FindBy(xpath = "//h5[text()='Has Amount:']//following::div[contains(@class,'ios-switch')][1]")
	WebElement hasAmountBtn;

	@FindBy(xpath = "//h5[text()='Has Stat:']//following::div[contains(@class,'ios-switch')][1]")
	WebElement hasStatBtn;

	@FindBy(xpath = "//h5[text()='Has GLCode:']//following::div[contains(@class,'ios-switch')][1]")
	WebElement hasGLCodeBtn;
	
	@FindBy(xpath = "//input[@id='btnAddRow']")
	WebElement addRowBtn;
	
	public void navigateTBBreakdown() {
		navigationLink.click();
		WebElement TBLinkView = new WebDriverWait(driver, Duration.ofSeconds(700))
				.until(ExpectedConditions.visibilityOf(TBLink));
		TBLinkView.click();
		WebElement TBBreakDownLinkView = new WebDriverWait(driver, Duration.ofSeconds(700))
				.until(ExpectedConditions.visibilityOf(TBBreakDownLink));
		TBBreakDownLinkView.click();
		WebElement TBBreakDownTitleView = new WebDriverWait(driver, Duration.ofSeconds(700))
				.until(ExpectedConditions.visibilityOf(TBBreakDownTitle));
		WebElement isAllTblLoaded = new WebDriverWait(driver, Duration.ofSeconds(700))
				.until(ExpectedConditions.visibilityOf(TBisTblLoad));
	}

	public void selectFilterOptions(String hotel, String period) throws InterruptedException {
		Thread.sleep(3000);
		WebElement hotelLoad = new WebDriverWait(driver, Duration.ofSeconds(700)).until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div/label[text()='Select Hotel:']//following::div/a/span")));
		
		Select drpHotel = new Select(propertyDropdown);
		WebElement waitHotelLoad = new WebDriverWait(driver, Duration.ofSeconds(100))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='ddlHotels']//option")));
		drpHotel.selectByVisibleText(hotel);

		System.out.println("hotel and period= "+hotel+"---"+period);
		
		Select drpPeriod = new Select(periodDropdown);
		WebElement waitPeriodLoad = new WebDriverWait(driver, Duration.ofSeconds(100))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='ddlPeriod']//option")));
		drpPeriod.selectByVisibleText(period);
		
		datePickerVal.sendKeys(Keys.CONTROL + "a");
		datePickerVal.sendKeys(Keys.DELETE);
		datePickerVal.sendKeys(configReader.getMYP1Prop("TB_Breakdown_Date"));

		updateBtn.click();
		Thread.sleep(3000);
	}

	public void updateData() {
		WebElement waitToLoadTblData = new WebDriverWait(driver, Duration.ofSeconds(700)).until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@id='tblTBContainer']//table/tbody/tr[5]")));
	}

	public boolean comapareDescriptionType(String description, String type) {
		boolean isColumnsTypeEqual=true;
		int typeHeaderColPosition=0;
		int descriptionHColPos=0;
		for (int i = 0; i < lstHeader.size(); i++) {
			System.out.println(i+"--"+lstHeader.get(i).getText());
			if (type.equals(lstHeader.get(i).getText())) {
				typeHeaderColPosition =i+1;
    		}
			else if (description.equals(lstHeader.get(i).getText())) {
				descriptionHColPos =i+1;
    		}
		}
		for (int i = 0; i < lstRow.size(); i++) {
			int row=i+1;
			int IsViewType = driver.findElements(By.xpath("//div[@id='tblTBContainer']//table/tbody/tr[contains(@class,'Data')]["+row+"]/td["+typeHeaderColPosition+"]")).size();
			System.out.println("IsViewType="+IsViewType);
			if (IsViewType>0) {
				WebElement TypeHeaderCol = new WebDriverWait(driver, Duration.ofSeconds(700)).until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//div[@id='tblTBContainer']//table/tbody/tr[contains(@class,'Data')]["+row+"]/td["+typeHeaderColPosition+"]")));
				WebElement DescriptionHeaderCol = new WebDriverWait(driver, Duration.ofSeconds(700)).until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//div[@id='tblTBContainer']//table/tbody/tr[contains(@class,'Data')]["+row+"]/td["+descriptionHColPos+"]")));
				String typeCurrentVal=TypeHeaderCol.getText();
				System.out.println("type current value=="+typeCurrentVal);
				String descriptionCurrentVal=DescriptionHeaderCol.getText();
				if(typeCurrentVal != "" && typeCurrentVal != "---") {
					if(descriptionCurrentVal.contains(typeCurrentVal)) {
						isColumnsTypeEqual = true; 
					}else {
						System.out.println("false==="+typeCurrentVal+"--"+descriptionCurrentVal);
						isColumnsTypeEqual=false;
					}
				}
			}
		}
		return isColumnsTypeEqual;
	}

	public boolean comapareDisplayDescriptionType(String displayDescription, String type) {
		boolean isColumnsTypeEqual=true;
		int typeHeaderColPosition=0;
		int displayDiscriptionHColPos=0;
		for (int i = 0; i < lstHeader.size(); i++) {
			System.out.println(i+"--"+lstHeader.get(i).getText());
			if (type.equals(lstHeader.get(i).getText())) {
				typeHeaderColPosition =i+1;
    		}
			else if (displayDescription.equals(lstHeader.get(i).getText())) {
				displayDiscriptionHColPos =i+1;
    		}
		}
		for (int i = 0; i < lstRow.size(); i++) {
			int row=i+1;
			if (driver.findElements(By.xpath("//div[@id='tblTBContainer']//table/tbody/tr[contains(@class,'Data')]["+row+"]/td["+typeHeaderColPosition+"]")).size()>0) {
				WebElement TypeHeaderCol = new WebDriverWait(driver, Duration.ofSeconds(700)).until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//div[@id='tblTBContainer']//table/tbody/tr[contains(@class,'Data')]["+row+"]/td["+typeHeaderColPosition+"]")));
				WebElement DisplayDescriptionHeaderCol = new WebDriverWait(driver, Duration.ofSeconds(700)).until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//div[@id='tblTBContainer']//table/tbody/tr[contains(@class,'Data')]["+row+"]/td["+displayDiscriptionHColPos+"]")));
				String typeCurrentVal=TypeHeaderCol.getText();
				System.out.println("Type current value=** "+typeCurrentVal);
				String displayDescriptionCurrentVal=DisplayDescriptionHeaderCol.getText();
				if(typeCurrentVal != "" && typeCurrentVal != "---") {
					System.out.println("typeCurrentVal--------"+typeCurrentVal);
					if(displayDescriptionCurrentVal.contains(typeCurrentVal)) {
						isColumnsTypeEqual = true; 
					}else {
						System.out.println("false==="+typeCurrentVal+"--"+displayDescriptionCurrentVal);
						isColumnsTypeEqual=false;
					}
				}
			}
		}
		return isColumnsTypeEqual;
	}

	public boolean verifyHasAmount(String amount) throws InterruptedException {
		if(driver.findElements(By.xpath("//h5[text()='Has Amount:']//following::div[@class='ios-switch on'][1]")).size()>1) {
			hasAmountBtn.click();
		}
		if(driver.findElements(By.xpath("//h5[text()='Has Stat:']//following::div[@class='ios-switch on'][1]")).size()>1) {
			hasStatBtn.click();		
		}
		if(driver.findElements(By.xpath("//h5[text()='Has GLCode:']//following::div[@class='ios-switch on'][1]")).size()>1) {
			hasGLCodeBtn.click();
		}
		
		hasAmountBtn.click();
		System.out.println("hasAmountBtn clicked");
		updateBtn.click();
		System.out.println("updateBtn clicked");
		Thread.sleep(3000);
		Boolean waitToLoadTblData = new WebDriverWait(driver, Duration.ofSeconds(700)).until(ExpectedConditions
				.invisibilityOfElementLocated(By.xpath("//div[@class='ajax-loader-full-screen' and @style='display: block;']")));
		System.out.println("table loaded");
		boolean isColumnsAmountNotZero=true;
		int amountHColPos=0;
		if(waitToLoadTblData) {
			for (int i = 0; i < lstHeader.size(); i++) {
				System.out.println(i+"--"+lstHeader.get(i).getText());
				if (amount.equals(lstHeader.get(i).getText())) {
					amountHColPos =i+1;
	    		}
			}
			System.out.println("lstRow.size()=="+lstRow.size());
			for (int x = 0; x < lstRow.size(); x++) {
				int row=x+1;
				if (driver.findElements(By.xpath("//div[@id='tblTBContainer']//table/tbody/tr[not(contains(@class,'hidden'))]["+row+"]/td["+amountHColPos+"]")).size()>0) {
					WebElement AmountHeaderCol = new WebDriverWait(driver, Duration.ofSeconds(700)).until(ExpectedConditions
							.visibilityOfElementLocated(By.xpath("//div[@id='tblTBContainer']//table/tbody/tr[not(contains(@class,'hidden'))]["+row+"]/td["+amountHColPos+"]")));
					String AmountCurrentVal=AmountHeaderCol.getText().replaceAll(",", "");
					System.out.println("Amount current Value====="+AmountCurrentVal);
					if(!AmountCurrentVal.equals("---")) {
						System.out.println("//div[@id='tblTBContainer']//table/tbody/tr[not(contains(@class,'hidden'))]["+row+"]/td["+amountHColPos+"]");
						Float Amount = Float.parseFloat(AmountCurrentVal);
						System.out.println("current amount="+Amount);
						if(Amount==0) {
							System.out.println("amount zero");
							isColumnsAmountNotZero=false;
						}
					}
				}
			}
		}
		return isColumnsAmountNotZero;
		
	}

	public boolean verifyCreditDebit() throws InterruptedException {
		if(driver.findElements(By.xpath("//h5[text()='Has Amount:']//following::div[@class='ios-switch on'][1]")).size()>1) {
			hasAmountBtn.click();
		}
		if(driver.findElements(By.xpath("//h5[text()='Has Stat:']//following::div[@class='ios-switch on'][1]")).size()>1) {
			hasStatBtn.click();		
		}
		if(driver.findElements(By.xpath("//h5[text()='Has GLCode:']//following::div[@class='ios-switch on'][1]")).size()>1) {
			hasGLCodeBtn.click();
		}
		
		hasAmountBtn.click();
		System.out.println("hasAmountBtn clicked");
		updateBtn.click();
		System.out.println("updateBtn clicked");
		Thread.sleep(3000);
		Boolean waitToLoadTblData = new WebDriverWait(driver, Duration.ofSeconds(700)).until(ExpectedConditions
				.invisibilityOfElementLocated(By.xpath("//div[@class='ajax-loader-full-screen' and @style='display: block;']")));
		System.out.println("table loaded");
		
		boolean isAmountColNotEqual=true;
		boolean isAdjAmountColNotEqual=true;
		boolean isTotAmountColNotEqual=true;
		boolean isAllColNotEqual=true;

		if(waitToLoadTblData) {
			String creditAmountColValue = new WebDriverWait(driver, Duration.ofSeconds(700)).until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//div[@id='tblTBContainer']//table/tbody/tr[@class='CreditSubTotal']/td[6]"))).getText();
	
			String debitAmountColValue = new WebDriverWait(driver, Duration.ofSeconds(700)).until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//div[@id='tblTBContainer']//table/tbody/tr[@class='DebitSubTotal']/td[6]"))).getText();
			if (!creditAmountColValue.equals(debitAmountColValue)) {
				isAmountColNotEqual = false;
				System.out.println("isAmountColNotEqual="+isAmountColNotEqual);
			}
	
			String creditAdjAmountColValue = new WebDriverWait(driver, Duration.ofSeconds(700)).until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//div[@id='tblTBContainer']//table/tbody/tr[@class='CreditSubTotal']/td[7]"))).getText();
	
			String debitAdjAmountColValue = new WebDriverWait(driver, Duration.ofSeconds(700)).until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//div[@id='tblTBContainer']//table/tbody/tr[@class='DebitSubTotal']/td[7]"))).getText();
			if (!creditAdjAmountColValue.equals(debitAdjAmountColValue)) {
				isAdjAmountColNotEqual = false;
				System.out.println("isAdjAmountColNotEqual="+isAdjAmountColNotEqual);
			}
	
			String creditTotAmountColValue = new WebDriverWait(driver, Duration.ofSeconds(700)).until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//div[@id='tblTBContainer']//table/tbody/tr[@class='CreditSubTotal']/td[8]"))).getText();
	
			String debitTotAmountColValue = new WebDriverWait(driver, Duration.ofSeconds(700)).until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//div[@id='tblTBContainer']//table/tbody/tr[@class='DebitSubTotal']/td[8]"))).getText();
			if (!creditTotAmountColValue.equals(debitTotAmountColValue)) {
				isTotAmountColNotEqual = false;
				System.out.println("isTotAmountColNotEqual="+isTotAmountColNotEqual);
			}
			if(isAmountColNotEqual==false || isAdjAmountColNotEqual==false ||isTotAmountColNotEqual==false) {
				isAllColNotEqual = false;
			}
		}
		return isAllColNotEqual;
	}

	public boolean verifyHasStatFilter(String stat) throws InterruptedException {

		if(driver.findElements(By.xpath("//h5[text()='Has Amount:']//following::div[@class='ios-switch on'][1]")).size()>1) {
			hasAmountBtn.click();
		}
		if(driver.findElements(By.xpath("//h5[text()='Has Stat:']//following::div[@class='ios-switch on'][1]")).size()>1) {
			hasStatBtn.click();		
		}
		if(driver.findElements(By.xpath("//h5[text()='Has GLCode:']//following::div[@class='ios-switch on'][1]")).size()>1) {
			hasGLCodeBtn.click();
		}
		
		hasStatBtn.click();
		System.out.println("hasStatBtn clicked");
		updateBtn.click();
		System.out.println("updatebtn clicked");
		Thread.sleep(3000);
		Boolean waitToLoadTblData = new WebDriverWait(driver, Duration.ofSeconds(700)).until(ExpectedConditions
				.invisibilityOfElementLocated(By.xpath("//div[@class='ajax-loader-full-screen' and @style='display: block;']")));
		System.out.println("table loaded");
		
		boolean isColumnsAmountNotZero=true;
		int statHColPos=0;
		if(waitToLoadTblData) {
			for (int i = 0; i < lstHeader.size(); i++) {
				System.out.println(i+"--"+lstHeader.get(i).getText());
				if (stat.equals(lstHeader.get(i).getText())) {
					statHColPos =i+1;
	    		}
			}
			
			System.out.println("lstRow.size()=="+lstRow.size());
			for (int x = 0; x < lstRow.size(); x++) {
				int row=x+1;
				if (driver.findElements(By.xpath("//div[@id='tblTBContainer']//table/tbody/tr[not(contains(@class,'hidden'))]["+row+"]/td["+statHColPos+"]")).size()>0) {
					WebElement AmountHeaderCol = new WebDriverWait(driver, Duration.ofSeconds(700)).until(ExpectedConditions
							.visibilityOfElementLocated(By.xpath("//div[@id='tblTBContainer']//table/tbody/tr[not(contains(@class,'hidden'))]["+row+"]/td["+statHColPos+"]")));
					String AmountCurrentVal=AmountHeaderCol.getText().replaceAll(",", "");
					System.out.println("Stat current Value====="+AmountCurrentVal);
					if(!AmountCurrentVal.equals("---")) {
						Float Amount = Float.parseFloat(AmountCurrentVal);
						System.out.println("Stat amount="+Amount);
						if(Amount==0) {
							System.out.println("Stat value zero");
							isColumnsAmountNotZero=false;
						}
					}
				}
			}
		}
		return isColumnsAmountNotZero;
	}

	public boolean verifyGLCodeFilter(String gLCode) throws InterruptedException {

		if(driver.findElements(By.xpath("//h5[text()='Has Amount:']//following::div[@class='ios-switch on'][1]")).size()>1) {
			hasAmountBtn.click();
		}
		if(driver.findElements(By.xpath("//h5[text()='Has Stat:']//following::div[@class='ios-switch on'][1]")).size()>1) {
			hasStatBtn.click();		
		}
		if(driver.findElements(By.xpath("//h5[text()='Has GLCode:']//following::div[@class='ios-switch on'][1]")).size()>1) {
			hasGLCodeBtn.click();
		}
		
		hasGLCodeBtn.click();
		System.out.println("hasGLCodeBtn clicked");
		updateBtn.click();
		System.out.println("updatebtn clicked");
		Thread.sleep(3000);
		Boolean waitToLoadTblData = new WebDriverWait(driver, Duration.ofSeconds(700)).until(ExpectedConditions
				.invisibilityOfElementLocated(By.xpath("//div[@class='ajax-loader-full-screen' and @style='display: block;']")));
		System.out.println("table loaded");
		
		boolean isColumnsAmountNotZero=true;
		int GLCodeHColPos=0;
		if(waitToLoadTblData) {
			for (int i = 0; i < lstHeader.size(); i++) {
				System.out.println(i+"--"+lstHeader.get(i).getText());
				if (gLCode.equals(lstHeader.get(i).getText())) {
					GLCodeHColPos =i+1;
	    		}
			}
			
			System.out.println("lstRow.size()=="+lstRow.size());
			for (int x = 0; x < lstRow.size(); x++) {
				int row=x+1;
				if (driver.findElements(By.xpath("//div[@id='tblTBContainer']//table/tbody/tr[not(contains(@class,'hidden'))]["+row+"]/td["+GLCodeHColPos+"]")).size()>0) {
					WebElement AmountHeaderCol = new WebDriverWait(driver, Duration.ofSeconds(700)).until(ExpectedConditions
							.visibilityOfElementLocated(By.xpath("//div[@id='tblTBContainer']//table/tbody/tr[not(contains(@class,'hidden'))]["+row+"]/td["+GLCodeHColPos+"]")));
					String AmountCurrentVal=AmountHeaderCol.getText();
					if(!AmountCurrentVal.equals("---")) {
						System.out.println("Stat amount="+AmountCurrentVal);
						if(AmountCurrentVal=="000000") {
							System.out.println("Stat value zero");
							isColumnsAmountNotZero=false;
						}
					}
				}
			}
		}
		return isColumnsAmountNotZero;
	}

	public boolean TBModelView() throws InterruptedException {
		Thread.sleep(3000);
		boolean inputValuesLoaded=true;
		Boolean waitToLoadTblData = new WebDriverWait(driver, Duration.ofSeconds(700)).until(ExpectedConditions
				.invisibilityOfElementLocated(By.xpath("//div[@class='ajax-loader-full-screen' and @style='display: block;']")));
		System.out.println("table loaded");
		WebElement editIcon = new WebDriverWait(driver, Duration.ofSeconds(700)).until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//div[@id='tblTBContainer']//table/tbody/tr[contains(@class,'Data') and not(contains(@class,'SuspenseData')) and not(contains(@class,'IgnoreData'))]/td/a/i[@class='fa fa-pencil'])[1]")));

		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", editIcon);
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", editIcon);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", editIcon);
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", editIcon);
		}
		System.out.println("edit icon clicked");

		WebElement editTBModelView = new WebDriverWait(driver, Duration.ofSeconds(700)).until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@class='modal-dialog']//h4[text()='Edit TrailBalance']")));
		Thread.sleep(3000);
		
		WebElement DisplayPMSCodeView = new WebDriverWait(driver, Duration.ofSeconds(700)).until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//label[text()='Display PMSCode']//following-sibling::div/div")));
		DisplayPMSCodeView.click();
		Thread.sleep(2000);
		List<WebElement> PMSCodeList = driver.findElements(By.xpath("//label[text()='Display PMSCode']//following-sibling::div/select/option"));
		if (2>PMSCodeList.size()) {
			inputValuesLoaded=false;
		}
		PMSCodeList.get(1).click();
		
		WebElement TypeView = new WebDriverWait(driver, Duration.ofSeconds(700)).until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//label[text()='Type']//following-sibling::div/div")));
		try {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", TypeView);
		} catch (Exception e) {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", TypeView);
		}
		Thread.sleep(2000);
		List<WebElement> TypeList = driver.findElements(By.xpath("//label[text()='Type']//following-sibling::div/select/option"));
		if (2>TypeList.size()) {
			inputValuesLoaded=false;
		}
		TypeList.get(1).click();
		
		
		WebElement GLAccountView = new WebDriverWait(driver, Duration.ofSeconds(700)).until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//label[text()='GL Account']//following-sibling::div/div")));
		try {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", GLAccountView);
		} catch (Exception e) {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", GLAccountView);
		}
		Thread.sleep(2000);
		List<WebElement> GLAccountList = driver.findElements(By.xpath("//label[text()='GL Account']//following-sibling::div/select/option"));
		if (2>GLAccountList.size()) {
			inputValuesLoaded=false;
		}
		
		return inputValuesLoaded;
	}

	public boolean closeModel() {
		try {

			WebElement closeBtn = new WebDriverWait(driver, Duration.ofSeconds(700)).until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("(//div[@class='modal-dialog']//button[text()='Close'])[1]")));
			closeBtn.click();
			return true;
		} catch (Exception e) {
			System.out.println("Close model btn not clicked");
			return false;
		}
	}

	public void addRow() throws InterruptedException {
		Thread.sleep(3000);
		Boolean waitToLoadTblData = new WebDriverWait(driver, Duration.ofSeconds(700)).until(ExpectedConditions
				.invisibilityOfElementLocated(By.xpath("//div[@class='ajax-loader-full-screen' and @style='display: block;']")));
		System.out.println("table loaded");
		addRowBtn.click();

		WebElement txtDescription = new WebDriverWait(driver, Duration.ofSeconds(700)).until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//table//input[@name='Description']")));
		txtDescription.sendKeys(Keys.CONTROL + "a");
		txtDescription.sendKeys(Keys.DELETE);
		txtDescription.sendKeys("test description");

		WebElement txtDisplayDescription = new WebDriverWait(driver, Duration.ofSeconds(700)).until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//table//input[@name='DisplayDescription']")));
		txtDisplayDescription.sendKeys(Keys.CONTROL + "a");
		txtDisplayDescription.sendKeys(Keys.DELETE);
		txtDisplayDescription.sendKeys("test Display Description");

		List<WebElement> selectTypeList = driver.findElements(By.xpath("//table//select[@name='PMSType']//option"));
		
		for (int i = 0; i < selectTypeList.size(); i++) {
			if (selectTypeList.get(i).getText().equalsIgnoreCase("Stat")) {
				System.out.println("Type list item ===" + selectTypeList.get(i).getText());
				selectTypeList.get(i).click();
			}
		}
		WebElement GLCodeSelect = new WebDriverWait(driver, Duration.ofSeconds(700)).until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//table//select[@name='GLCode']//option")));
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", GLCodeSelect);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", GLCodeSelect);
		}
		
		List<WebElement> GLCodeList = driver.findElements(By.xpath("//table//select[@name='GLCode']//option"));
		GLCodeList.get(1).click();
		WebElement saveBtn = new WebDriverWait(driver, Duration.ofSeconds(700)).until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//td//a[@id='btnSaveTB']")));
		saveBtn.click();
		
		Thread.sleep(3000);
		Boolean waitsaveTblData = new WebDriverWait(driver, Duration.ofSeconds(700)).until(ExpectedConditions
				.invisibilityOfElementLocated(By.xpath("//div[@class='ajax-loader-full-screen' and @style='display: block;']")));
		
	}

	public boolean verifyRowAdded() throws InterruptedException {
		Thread.sleep(3000);
		Boolean waitsaveTblData = new WebDriverWait(driver, Duration.ofSeconds(700)).until(ExpectedConditions
				.invisibilityOfElementLocated(By.xpath("//div[@class='ajax-loader-full-screen' and @style='display: block;']")));
		
		int isRowAvailable =driver.findElements(By.xpath("//tr//td[text()='test description']")).size();
		if(isRowAvailable>0) {
			System.out.println("newly added row is available!");
			return true;
		}
		else {
			System.out.println("newly added row is not available!");
			return false;
		}
	}

	public boolean deleteAddedRow() throws InterruptedException {
		Thread.sleep(3000);
		WebElement deleteBtn = new WebDriverWait(driver, Duration.ofSeconds(700)).until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//tr//td[text()='test description']//following::td/a[@title='Delete'])[1]")));
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", deleteBtn);
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", deleteBtn);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", deleteBtn);
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", deleteBtn);
		}
		
		Thread.sleep(1500);
		WebElement deleteModelYesBtn = new WebDriverWait(driver, Duration.ofSeconds(700)).until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@role='dialog']//h4[text()='Delete']//following::button[text()='Yes']")));
		deleteModelYesBtn.click();
		
		Thread.sleep(3000);
		Boolean waitdeleteTblData = new WebDriverWait(driver, Duration.ofSeconds(700)).until(ExpectedConditions
				.invisibilityOfElementLocated(By.xpath("//div[@class='ajax-loader-full-screen' and @style='display: block;']")));
		return true;
	}

	public boolean verifyRowDeleted() throws InterruptedException {
		Thread.sleep(3000);
		updateBtn.click();
		Thread.sleep(3000);
		Boolean waitdeleteTblData = new WebDriverWait(driver, Duration.ofSeconds(700)).until(ExpectedConditions
				.invisibilityOfElementLocated(By.xpath("//div[@class='ajax-loader-full-screen' and @style='display: block;']")));
		int isRowAvailable =driver.findElements(By.xpath("//tr//td[text()='test description']")).size();
		if(isRowAvailable>0) {
			System.out.println("newly added not deleted!");
			return false;
		}
		else {
			System.out.println("newly added is already deleted!");
			return true;
		}
	}
}
