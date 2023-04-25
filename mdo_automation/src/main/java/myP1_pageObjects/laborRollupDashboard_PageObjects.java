package myP1_pageObjects;

import java.text.DecimalFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.ConstantsReader;

public class laborRollupDashboard_PageObjects {
	
	private WebDriver driver;
	private ConstantsReader configReader = new ConstantsReader();
//	ArrayList<String> turnOffWidgets;

	public laborRollupDashboard_PageObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
//		turnOffWidgets = new ArrayList<String>();
	}
	

	@FindBy(xpath = "//div[@class='sidebar-header']")
	WebElement navigationLink;

	@FindBy(xpath = "//a//span[text()='Reports']")
	WebElement reportLink;
	
	@FindBy(xpath = "//a//span[text()='Labor Report']")
	WebElement laborReportLink;

	@FindBy(xpath = "//a//span[contains(text(),'Labor RollUp')]")
	WebElement laborRollupLink;

	@FindBy(xpath = "//h2[text()='Labor Rollup']")
	WebElement laborRollupTitle;
	
	@FindBy(xpath = "//div[@id='s2id_ddlPeriod']")
	WebElement periodSelect;
	
	@FindBy(xpath = "//select[@id='ddlPeriod']")
	WebElement periodDropdown;

	@FindBy(xpath = "(//select[@class='form-control select2-offscreen'])[1]")
	WebElement groupHotelDropdown;

	@FindBy(xpath = "//input[@id='txtDate']")
	WebElement datePickerVal;

	@FindBy(xpath = "//button[@title='Search']")
	WebElement searchBtn;

	@FindBy(xpath = "//b[text()='Actual']")
	WebElement actualBtn;

	@FindBy(xpath = "//b[text()='POR']")
	WebElement PORBtn;

	@FindBy(xpath = "//input[@placeholder='Search']")
	WebElement searchInput;
	
	@FindBy(xpath = "//table[@id='LaborActualTable']//tbody/tr")
	List<WebElement> actualTblRows;
	
	@FindBy(xpath = "//div[@id='LaborPOR']//table//tbody//tr")
	List<WebElement> porTblRows;
	
	@FindBy(xpath = "//div[@id='LaborPOR']//input[@placeholder='Search']")
	WebElement porSearchInput;

	String disableCols=configReader.getMYP1Prop("Labor_Rollup_ActualDisableCols");
	List<String> mulColList=Arrays.asList(disableCols.split(","));
	
	String disablePORCols=configReader.getMYP1Prop("Labor_Rollup_PORDisableCols");
	List<String> mulPORColList=Arrays.asList(disablePORCols.split(","));
	
	@FindBy(xpath = "//button[text()='Submit']")
	WebElement submitBtn;
	
	@FindBy(xpath = "//button[@id='btnEditDashboard']")
	WebElement editBtn;
	
	@FindBy(xpath = "//button[@id='btnAddChart']")
	WebElement addColBtn;
	
	@FindBy(xpath = "//div[@class='modal-body']//div[@class='ios-switch']")
	List<WebElement> offSwitchList;
	
	public void navigatetoLaborRollup() {
		navigationLink.click();
		WebElement reportLinkView = new WebDriverWait(driver, Duration.ofSeconds(700))
				.until(ExpectedConditions.visibilityOf(reportLink));
		reportLinkView.click();
		
		WebElement laborReportLinkView = new WebDriverWait(driver, Duration.ofSeconds(700))
				.until(ExpectedConditions.visibilityOf(laborReportLink));
		laborReportLinkView.click();
		
		WebElement laborRollupLinkView = new WebDriverWait(driver, Duration.ofSeconds(700))
				.until(ExpectedConditions.visibilityOf(laborRollupLink));
		laborRollupLinkView.click();
		
		WebElement laborRollupTitleView = new WebDriverWait(driver, Duration.ofSeconds(700))
				.until(ExpectedConditions.visibilityOf(laborRollupTitle));
	}


	public void loadData(String hotelGroup, String period) throws InterruptedException {
		Thread.sleep(3000);
		WebElement panelLoad = new WebDriverWait(driver, Duration.ofSeconds(700)).until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//section//b[text()='Actual']")));
		Select drpPeriod = new Select(periodDropdown);
		WebElement waitPeriodLoad = new WebDriverWait(driver, Duration.ofSeconds(100))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='ddlPeriod']//option")));
		drpPeriod.selectByVisibleText(period);
		
		Thread.sleep(3000);
		Select drpHotel = new Select(groupHotelDropdown);
		WebElement waitHotelLoad = new WebDriverWait(driver, Duration.ofSeconds(100))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='ddlHotels']//option")));
		drpHotel.selectByVisibleText(hotelGroup);

		datePickerVal.sendKeys(Keys.CONTROL + "a");
		datePickerVal.sendKeys(Keys.DELETE);
		datePickerVal.sendKeys(configReader.getMYP1Prop("Labor_Rollup_Date"));
		Thread.sleep(3000);
		searchBtn.click();
		Thread.sleep(7000);
	}

	////////////////////////////// Actual button functions
	
	public void verifyActual() {
		WebElement searchTblLoad = new WebDriverWait(driver, Duration.ofSeconds(700)).until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//section//b[text()='Actual']")));
		actualBtn.click();
		WebElement actualTblLoad = new WebDriverWait(driver, Duration.ofSeconds(700)).until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//th[text()='Department Name'])[1]")));
	}

	public void enableAllColumns() throws InterruptedException {
		Thread.sleep(3000);
		if(offSwitchList.size()>0) {
			editBtn.click();
			Thread.sleep(3000);
			addColBtn.click();
			Thread.sleep(3000);
			for (int i = 0; i < offSwitchList.size(); i++) {
				offSwitchList.get(i).click();
			}
			submitBtn.click();
			Thread.sleep(3000);
		}
		WebElement tblLoad = new WebDriverWait(driver, Duration.ofSeconds(700)).until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//section//b[text()='Actual']")));
	}
	
	public boolean actualTotal() {
		WebElement actualTblLoad = new WebDriverWait(driver, Duration.ofSeconds(700)).until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//th[text()='Hotel Name'])[1]")));
		float totFirstCol=0;
		float totSecondCol=0;
		for (int i = 0; i < actualTblRows.size(); i++) {	
			int val=i+1;
			WebElement firstColValue = driver.findElement(By.xpath("//table[@id='LaborActualTable']//tbody/tr["+val+"]/td[2]"));
			float colVal1=Float.parseFloat(firstColValue.getText().replace(",", ""));
			System.out.println("1st col val==="+colVal1);
			totFirstCol =totFirstCol+colVal1;
			System.out.println("*******************==="+totFirstCol);
			WebElement secondColValue = driver.findElement(By.xpath("//table[@id='LaborActualTable']//tbody/tr["+val+"]/td[3]"));
			float colVal2=Float.parseFloat(secondColValue.getText().replace(",", ""));
			System.out.println("2nd col val==="+colVal2);
			totSecondCol =totSecondCol+colVal2;
			System.out.println("*******************==="+totSecondCol);
		}
		
		float FirstColTotalVal=Float.parseFloat(driver.findElement(By.xpath("//table[@id='LaborActualTable']//tfoot/tr/td[2]")).getText().replace(",", ""));
		float SecondColTotalVal=Float.parseFloat(driver.findElement(By.xpath("//table[@id='LaborActualTable']//tfoot/tr/td[3]")).getText().replace(",", ""));
		System.out.println("1st val==="+FirstColTotalVal);
		System.out.println("2nd val==="+SecondColTotalVal);
		
		System.out.println("1st tot val==="+totFirstCol);
		System.out.println("2nd tot val==="+totSecondCol);

		int calFirst = Math.round(totFirstCol);
		int calSecond = Math.round(totSecondCol);
		int viewTotFirst = Math.round(FirstColTotalVal);
		int viewTotSecond = Math.round(SecondColTotalVal);
		
		if(viewTotFirst==calFirst && viewTotSecond==calSecond) {
			return true;
		}else {
			return false;
		}
	}


	public boolean verifyActualDataSorted() throws InterruptedException {
		//check ascending Value
		WebElement FirstColAscending=driver.findElement(By.xpath("(//div[@class='dataTables_scrollHeadInner']/table//tr)[3]//th[contains(@aria-label,'activate to sort column ascending')][1]"));
		FirstColAscending.click();
		Thread.sleep(3000);
		float ascendingVal=0;
		for (int i = 0; i < actualTblRows.size(); i++) {
			int val=i+1;
			WebElement firstColValue = driver.findElement(By.xpath("((//div[@class='dataTables_scrollBody']/table)[1]/tbody/tr/td[2])["+val+"]"));
			float ascendingColVal1=Float.parseFloat(firstColValue.getText().replace(",", ""));
			System.out.println("ascending 1st col val==="+ascendingColVal1);
			if(ascendingColVal1<ascendingVal)
				return false;
			ascendingVal =ascendingColVal1;
		}
		//check descending Value
		WebElement FirstColDescending=driver.findElement(By.xpath("(//div[@class='dataTables_scrollHeadInner']/table//tr)[3]//th[contains(@aria-label,'activate to sort column descending')][1]"));
		FirstColDescending.click();
		Thread.sleep(3000);
		float descendingVal=0;
		for (int i = 0; i < actualTblRows.size(); i++) {
			int val=i+1;
			WebElement firstColValue = driver.findElement(By.xpath("((//div[@class='dataTables_scrollBody']/table)[1]/tbody/tr/td[2])["+val+"]"));
			float descendingColVal1=Float.parseFloat(firstColValue.getText().replace(",", ""));
			System.out.println("descending 1st col val==="+descendingColVal1);
			if(i==0) {
				descendingVal = descendingColVal1;
			}
			else if(descendingColVal1>descendingVal) {
				return false;
			}
			descendingVal =descendingColVal1;
		}
		return true;
	}


	public boolean verifyActualSearchVal() {
		searchInput.sendKeys(Keys.CONTROL + "a");
		searchInput.sendKeys(Keys.DELETE);
		searchInput.sendKeys(configReader.getMYP1Prop("Labor_Rollup_SearchValActual"));
		
		boolean searchHotelNames = new WebDriverWait(driver, Duration.ofSeconds(700)).until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@id='LaborActual']//div[@class='DTFC_LeftBodyLiner']//td//a[contains(text(),'"+configReader.getMYP1Prop("Labor_Rollup_SearchValActual")+"')]"))).isDisplayed();
		
		return searchHotelNames;
	}

	
	/////////////////////////////////// Labor Rollup POR

	public void verifyPOR() {

		WebElement searchTblLoad = new WebDriverWait(driver, Duration.ofSeconds(700)).until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//label[contains(text(),'Search:')]")));
		PORBtn.click();
		WebElement actualTblLoad = new WebDriverWait(driver, Duration.ofSeconds(700)).until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@id='LaborPOR']//td[contains(text(),'Total')]")));
	}


	public boolean porTotal() {
		WebElement actualTblLoad = new WebDriverWait(driver, Duration.ofSeconds(700)).until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@id='LaborPOR']//td[contains(text(),'Total')]")));
		float totFirstCol=0;
		float totSecondCol=0;
		for (int i = 0; i < porTblRows.size(); i++) {	
			int val=i+1;
			WebElement firstColValue = driver.findElement(By.xpath("(//div[@id='LaborPOR']//table//tbody//tr/td[2])["+val+"]"));
			float colVal1=Float.parseFloat(firstColValue.getText().replace(",", ""));
			System.out.println("1st col val==="+colVal1);
			totFirstCol =totFirstCol+colVal1;
			System.out.println("*******************==="+totFirstCol);
			WebElement secondColValue = driver.findElement(By.xpath("(//div[@id='LaborPOR']//table//tbody//tr/td[3])["+val+"]"));
			float colVal2=Float.parseFloat(secondColValue.getText().replace(",", ""));
			System.out.println("2nd col val==="+colVal2);
			totSecondCol =totSecondCol+colVal2;
			System.out.println("*******************==="+totSecondCol);
		}
		
		float FirstColTotalVal=Float.parseFloat(driver.findElement(By.xpath("//div[@id='LaborPOR']//div[@class='dataTables_scrollFoot']//tfoot//td[2]")).getText().replace(",", ""));
		float SecondColTotalVal=Float.parseFloat(driver.findElement(By.xpath("//div[@id='LaborPOR']//div[@class='dataTables_scrollFoot']//tfoot//td[3]")).getText().replace(",", ""));
		System.out.println("1st val==="+FirstColTotalVal);
		System.out.println("2nd val==="+SecondColTotalVal);
		
		System.out.println("1st tot val==="+totFirstCol);
		System.out.println("2nd tot val==="+totSecondCol);

		int calFirst = Math.round(totFirstCol);
		int calSecond = Math.round(totSecondCol);
		int viewTotFirst = Math.round(FirstColTotalVal);
		int viewTotSecond = Math.round(SecondColTotalVal);
		
		if(viewTotFirst==calFirst && viewTotSecond==calSecond) {
			return true;
		}else {
			return false;
		}
	}


	public boolean verifyPorDataSorted() throws InterruptedException {
		//check ascending Value
		WebElement FirstColAscending=driver.findElement(By.xpath("(//div[@id='LaborPOR']//tr[@class='secondRow']//th//following-sibling::th[contains(@aria-label,'activate to sort column ascending')])[1]"));
		FirstColAscending.click();
		Thread.sleep(3000);
		float ascendingVal=0;
		for (int i = 0; i < porTblRows.size(); i++) {
			int val=i+1;
			WebElement firstColValue = driver.findElement(By.xpath("(//div[@id='LaborPOR']//table//tbody//tr//td[2])["+val+"]"));
			float ascendingColVal1=Float.parseFloat(firstColValue.getText().replace(",", ""));
			System.out.println("ascending 1st col val==="+ascendingColVal1);
			if(ascendingColVal1<ascendingVal)
				return false;
			ascendingVal =ascendingColVal1;
		}
		//check descending Value
		WebElement FirstColDescending=driver.findElement(By.xpath("(//div[@id='LaborPOR']//tr[@class='secondRow']//th//following-sibling::th[contains(@aria-label,'activate to sort column descending')])[1]"));
		FirstColDescending.click();
		Thread.sleep(3000);
		float descendingVal=0;
		for (int i = 0; i < porTblRows.size(); i++) {
			int val=i+1;
			WebElement firstColValue = driver.findElement(By.xpath("(//div[@id='LaborPOR']//table//tbody//tr//td[2])["+val+"]"));
			float descendingColVal1=Float.parseFloat(firstColValue.getText().replace(",", ""));
			System.out.println("descending 1st col val==="+descendingColVal1);
			if(i==0) {
				descendingVal = descendingColVal1;
			}
			else if(descendingColVal1>descendingVal) {
				return false;
			}
			descendingVal =descendingColVal1;
		}
		return true;
	}


	public boolean verifyPorSearchVal() {
		porSearchInput.sendKeys(Keys.CONTROL + "a");
		porSearchInput.sendKeys(Keys.DELETE);
		porSearchInput.sendKeys(configReader.getMYP1Prop("Labor_Rollup_SearchValPOR"));
		
		boolean searchHotelNames = new WebDriverWait(driver, Duration.ofSeconds(700)).until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@id='LaborPOR']//div[@class='dataTables_scrollBody']//tbody//td/a[contains(text(),'"+configReader.getMYP1Prop("Labor_Rollup_SearchValPOR")+"')]"))).isDisplayed();
		
		return searchHotelNames;
	}

	
	///////////////////// Labor Rollup Edit functionality
	
	
	public void disableCols() throws InterruptedException {
		WebElement searchTblLoad = new WebDriverWait(driver, Duration.ofSeconds(700)).until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//section//b[text()='Actual']")));
		editBtn.click();
		Thread.sleep(2000);
		addColBtn.click();
		Thread.sleep(2500);
		WebElement editLRSettingsModal = new WebDriverWait(driver, Duration.ofSeconds(700)).until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//h4[text()='Edit Labor RollUp Settings']")));
		for (int i = 0; i < mulColList.size(); i++) {
			String turnOffWidget=mulColList.get(i).split("/")[0];
//			String turnOffColumn=mulColList.get(i).split("/")[1];
			WebElement firstColValue = driver.findElement(By.xpath("//label[text()='"+turnOffWidget+"']//following-sibling::div//div[@class='ios-switch on']"));
			firstColValue.click();
		}
		submitBtn.click();
		Thread.sleep(3000);
		
	}


	public boolean verifyColsDisabled() throws InterruptedException {
		Thread.sleep(6000);
		WebElement tblLoad = new WebDriverWait(driver, Duration.ofSeconds(700)).until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//section//b[text()='Actual']")));
		for (int i = 0; i < mulColList.size(); i++) {
			String turnOffColumn=mulColList.get(i).split("/")[1];
			try {
				boolean firstColValue = driver.findElement(By.xpath("//div[@id='LaborActual']//div[@class='dataTables_scrollHead']//tr[@class='secondRow'][1]//th[text()='"+turnOffColumn+"']")).isDisplayed();
				if(firstColValue) {
					System.out.println(turnOffColumn+" is not disabled!");
					return false;
				}
			} catch (NoSuchElementException e) {
				System.out.println("NoSuchElementException occoured*********************8");
			}			
		}
		for (int i = 0; i < mulPORColList.size(); i++) {
			String turnOffColumn=mulPORColList.get(i).split("/")[1];
			PORBtn.click();
			Thread.sleep(3000);
			try {
				boolean firstColValue = driver.findElement(By.xpath("//div[@id='LaborPOR']//tr[@class='secondRow']//th[text()='"+turnOffColumn+"']")).isDisplayed();
				if(firstColValue) {
					System.out.println(turnOffColumn+" is not disabled!");
					return false;
				}
			} catch (NoSuchElementException e) {
				System.out.println("NoSuchElementException occoureddddddddddddd");
			}
			
		}
		return true;
	}


	public void enableColumns() throws InterruptedException {
		editBtn.click();
		Thread.sleep(2000);
		addColBtn.click();
		Thread.sleep(2500);
		WebElement editLRSettingsModal = new WebDriverWait(driver, Duration.ofSeconds(700)).until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//h4[text()='Edit Labor RollUp Settings']")));
		for (int i = 0; i < mulColList.size(); i++) {
			String turnOffWidget=mulColList.get(i).split("/")[0];
			WebElement firstColValue = driver.findElement(By.xpath("//div[@class='ios-switch']"));
			firstColValue.click();
		}
		submitBtn.click();
		Thread.sleep(3000);
	}


	public boolean verifyColEnabled() throws InterruptedException {
		WebElement tblLoad = new WebDriverWait(driver, Duration.ofSeconds(700)).until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//section//b[text()='Actual']")));
		Thread.sleep(6000);
		for (int i = 0; i < mulColList.size(); i++) {
			String turnOffColumn=mulColList.get(i).split("/")[1];
				boolean firstColValue = driver.findElement(By.xpath("//div[@id='LaborActual']//div[@class='dataTables_scrollHead']//tr[@class='secondRow'][1]//th[text()='"+turnOffColumn+"']")).isDisplayed();
				if(!firstColValue) {
					System.out.println(turnOffColumn+" is not display!");
					return false;
				}	
		}
		for (int i = 0; i < mulPORColList.size(); i++) {
			String turnOffColumn=mulPORColList.get(i).split("/")[1];
			PORBtn.click();
			Thread.sleep(3000);
			WebElement tblPorLoad = new WebDriverWait(driver, Duration.ofSeconds(700)).until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//div[@id='LaborPOR']//input[@placeholder='Search']")));
				boolean firstColValue = driver.findElement(By.xpath("//div[@id='LaborPOR']//tr[@class='secondRow']//th[text()='"+turnOffColumn+"']")).isDisplayed();
				if(!firstColValue) {
					System.out.println(turnOffColumn+" is not display!");
					return false;
				}
		}
		return true;
	}





}
