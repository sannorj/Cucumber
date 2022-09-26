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

public class Guest_Ledger_PageObject {
	
	String ColumnData[][] ;
	private WebDriver driver;
	private ConstantsReader configReader = new ConstantsReader();

	public Guest_Ledger_PageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//button[@data-el='menuToggle']")
	WebElement mainMenuButton;
	
	@FindBy(xpath = "//div[text()='Guest Ledger']//ancestor::li")
	WebElement menuGuestLedger;
	
	@FindBy(xpath = "//h1[text()='Guest Ledger']")
	WebElement h1GuestLedger;
	
	@FindBy(xpath = "(//div/input[contains(@class, 'MuiInputBase-inputAdornedEnd')])[1]")
	WebElement drpOrg;
	
	@FindBy(xpath = "//div/input[contains(@name, 'hotelGroupId')]")
	WebElement drpGroup;
	
	@FindBy(xpath = "//ul[@role='listbox']//li")
	List <WebElement> listDrpValueSize;
	
	@FindBy(xpath = "//ul//li[@role='option']")
	List <WebElement> listDrp2ValueSize;
	
	
	@FindBy(xpath = "//span[text()='MARSHA-Cd']")
	WebElement lblMARSHA;
	
	@FindBy(xpath = "//button[@data-el='buttonOpenFilters']")
	WebElement btnFilter;
	
	@FindBy(xpath = "//button[@data-el='buttonResetFilters']")
	WebElement btnReset;
	
	@FindBy(xpath = "//div[text()='Filters']")
	WebElement lblFilters;
	
	@FindBy(xpath = "//span[text()='Filters']")
	WebElement lblbtnMainfilter;
	
	@FindBy(xpath = "//input[@name='hotelCode']")
	WebElement drpMARSHA;
	
	@FindBy(xpath = "//input[@name='roomType']")
	WebElement drpType;
	
	@FindBy(xpath = "//input[@name='groupCode']")
	WebElement drpFilterGroup;
	
	@FindBy(xpath = "//input[@name='settlementCode']")
	WebElement drpFilterDB;
	
	@FindBy(xpath = "//input[@name='settlementType']/../div")
	WebElement drpFilterSettlementType;
	
	@FindBy(xpath = "//input[@name='folio']")
	WebElement drpFilterFolio;
	
	@FindBy(xpath = "//label[text()='Arrival']//parent::div//input")
	WebElement drpFilterArrivalDate;
	
	@FindBy(xpath = "//label[text()='Departure']//parent::div//input")
	WebElement drpFilterDepartureDate;
	
	@FindBy(xpath = "//input[@name='numberOfNight']")
	WebElement drpFilterNONight;
	
	@FindBy(xpath = "//input[@name='outstandingAmountOperator']/../div")
	WebElement drpOutstandingAmount;
	
	@FindBy(xpath = "//input[@name='outstandingAmount']")
	WebElement txtOutstandingAmount;
	
	@FindBy(xpath = "//input[@name='authorizedLimitOperator']/../div")
	WebElement drpLimit;
	
	@FindBy(xpath = "//input[@name='authorizedLimitAmount']")
	WebElement txtlimit;
	
	@FindBy(xpath = "//button[@data-el='buttonSave']")
	WebElement btnApply;

	@FindBy(xpath = "//*[@id='root']//table/tbody/tr/td[1]/div/div/div/div/div")
	List <WebElement> listMARSHARows;
	
	@FindBy(xpath = "//*[@id='root']//table/tbody/tr/td[4]/div/div/div/div/div")
	List <WebElement> listType;
	
	@FindBy(xpath = "//*[@id='root']//table/tbody/tr/td[7]/div/div/div/div/div")
	List <WebElement> listGroup;
	
	@FindBy(xpath = "//*[@id='root']//table/tbody/tr/td[8]/div/div/div/div/div")
	List <WebElement> listArrDt;
	
	@FindBy(xpath = "//*[@id='root']//table/tbody/tr/td[9]/div/div/div/div/div")
	List <WebElement> listNt;
	
	@FindBy(xpath = "//*[@id='root']//table/tbody/tr/td[10]/div/div/div/div/div")
	List <WebElement> listDepart;
	
	@FindBy(xpath = "//*[@id='root']//table/tbody/tr/td[11]/div/div/div/div/div")
	List <WebElement> listFolio;
	
	@FindBy(xpath = "//*[@id='root']//table/tbody/tr/td[12]/div/div/div/div/div")
	List <WebElement> listDB;
	
	@FindBy(xpath = "//*[@id='root']//table/tbody/tr/td[13]/div/div/div/div/div")
	List <WebElement> listST;

	@FindBy(xpath = "//*[@id='root']//table/tbody/tr/td[14]/div/div/div/div/div")
	List <WebElement> listOutstdg;
	
	@FindBy(xpath = "//*[@id='root']//table/tbody/tr/td[15]/div/div/div/div/div")
	List <WebElement> listLimit;
	
	@FindBy(xpath = "//input[@name='keyword']")
	WebElement txtSearch;
	
	@FindBy(xpath = "//*[@id='root']/div[1]//table/tbody/tr")
	List <WebElement> noOfRows;
	
	@FindBy(xpath = "//*[@id='root']/div[1]//table/tbody/tr/td/div/div/div/div/div")
	List <WebElement> noOfCells;
	
	@FindBy(xpath = "//button[@data-el='buttonCancel']")
	WebElement btnReset1;
	
	@FindBy(xpath = "//*[@id='root']//table/tbody/tr[1]/td/div/div/div/div/div")
	List <WebElement> noOfColumns;
	
//	@FindBy(xpath = "//div/input[@name='latestDate']")
//	WebElement txtDate;
	
	@FindBy(xpath = "//label[text()='Date']//parent::div//input")
	WebElement txtDate;
	
	@FindBy(xpath = "//button[@title='Refresh']")
	WebElement btnGo;
	
	@FindBy(xpath = "//div[text()='myPerspective 2.0']")
	WebElement lblmyP2;
	
	
	
	
	public boolean navigateGuestLedgerFunc() throws InterruptedException {
		
		WebElement menu = new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(mainMenuButton));
		menu.click();
		
		/* mandatory pause */
		Thread.sleep(1500);
		
		WebElement pnlStatementEle = new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(menuGuestLedger));
		pnlStatementEle.click();
		
		ElementUtils.waitForElementToDisplay(h1GuestLedger, 100);
		return h1GuestLedger.isDisplayed();

	}
	
	public void selectOrgFunc(String org) throws InterruptedException {
		
		
		Thread.sleep(5000);
		int Org = driver.findElements(By.xpath("(//div/input[contains(@class, 'MuiInputBase-inputAdornedEnd')])[1]")).size();
		if (Org > 0) {
			/* Select the appropriate Group value from the drop-down menu. */
			WebElement drpGroupEle = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(drpOrg));
			drpGroupEle.click();

			ExpectedConditions.visibilityOf(listDrpValueSize.get(0));
			for (int i = 0; i < listDrpValueSize.size(); i++) {
				if (listDrpValueSize.get(i).getText().equalsIgnoreCase(org)) {
					listDrpValueSize.get(i).click();
				}
			}	
		Thread.sleep(8000);
		ElementUtils.waitForElementToDisplay(lblmyP2, 100);
		WebElement lblGrp = driver.findElement(By.xpath("//label[contains(text(),'Group')]"));
		ElementUtils.waitForElementToDisplay(lblGrp, 100);
		Thread.sleep(3500);
	}
	}
	
	public void selectParametersFunc() throws InterruptedException {

		ElementUtils.waitForElementToDisplay(lblMARSHA, 100);

		if (drpGroup.isEnabled()) {
			/* Select the appropriate Group value from the drop-down menu. */
			WebElement drpGroupEle = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(drpGroup));
			drpGroupEle.click();

			ExpectedConditions.visibilityOf(listDrpValueSize.get(0));
			for (int i = 0; i < listDrpValueSize.size(); i++) {
				if (listDrpValueSize.get(i).getText().equalsIgnoreCase(configReader.getProp("Ledger_Group"))) {
					listDrpValueSize.get(i).click();
				}
			}
		}
		
		/* Select the appropriate From date  from Date picker */
		Thread.sleep(3000);
		txtDate.sendKeys(Keys.CONTROL + "a");
		txtDate.sendKeys(Keys.DELETE);
		txtDate.sendKeys(configReader.getProp("Ledger_Date"));
		Thread.sleep(1000);
		
		btnGo.click();
		Thread.sleep(1000);
		ElementUtils.waitForElementToDisplay(lblMARSHA, 100);
		
	}
	
	public void clickOnFilterFunc() throws InterruptedException {
		
		btnFilter.click();
		ElementUtils.waitForElementToDisplay(lblFilters, 100);
		
	}
	
	
	public void filterByMarshaCodeFunc() throws InterruptedException {

		/* Select the appropriate Group value from the drop-down menu. */
		WebElement drpMARSHAEle = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(drpMARSHA));
		drpMARSHAEle.click();
		Thread.sleep(5000);
		drpMARSHA.sendKeys(configReader.getProp("Ledger_MARSHA"));
	
		Thread.sleep(1500);
		for (int i = 0; i < listDrpValueSize.size(); i++) {
			if (listDrpValueSize.get(i).getText().equalsIgnoreCase(configReader.getProp("Ledger_MARSHA"))) {
				listDrpValueSize.get(i).click();
			}
		}

		btnApply.click();
		ElementUtils.waitForElementToHide(lblFilters, 100);

	}
	
	public boolean verifyMarshadataFunc() throws InterruptedException {
		Thread.sleep(2000);
		boolean flag = true;
		for (int x = 0; x < listMARSHARows.size(); x++) {
			String value = listMARSHARows.get(x).getText();
			if (value.equals(configReader.getProp("Ledger_MARSHA")) || value.equals("")) {
				flag = true;
			} else {
				flag = false;
			}
		}
		return flag;
	}

	public void filterByTypeFunc() throws InterruptedException {

		Thread.sleep(1500);
		btnReset.click();
		ElementUtils.waitForElementToDisplay(lblMARSHA, 100);

		btnFilter.click();
		ElementUtils.waitForElementToDisplay(lblFilters, 100);

		/* Select the appropriate Group value from the drop-down menu. */
		WebElement drpTypeEle = new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(drpType));
		drpTypeEle.click();
		drpTypeEle.sendKeys(configReader.getProp("Ledger_Type"));

		Thread.sleep(1500);
		for (int i = 0; i < listDrpValueSize.size(); i++) {
			if (listDrpValueSize.get(i).getText().equalsIgnoreCase(configReader.getProp("Ledger_Type"))) {
				listDrpValueSize.get(i).click();
			}
		}

		btnApply.click();
		ElementUtils.waitForElementToHide(lblFilters, 100);

	}
	
	public boolean verifyTypedataFunc() throws InterruptedException {
		Thread.sleep(4000);
		boolean flag = true;
		for (int x = 0; x < listType.size(); x++) {
			String value = listType.get(x).getText();
			if (value.equals(configReader.getProp("Ledger_Type")) || value.equals("")) {
				flag = true;
			} else {
				flag = false;
			}
		}
		return flag;
	}
	
	public void filterByGroupFunc() throws InterruptedException {

		Thread.sleep(1500);
		btnReset.click();
		//ElementUtils.waitForElementToDisplay(lblbtnMainfilter, 100);
		ElementUtils.waitForElementToDisplay(lblMARSHA, 100);

		btnFilter.click();
		ElementUtils.waitForElementToDisplay(lblFilters, 100);
		
		/* Select the appropriate Group value from the drop-down menu. */
		WebElement drpFilterGroupEle = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(drpFilterGroup));
		drpFilterGroupEle.click();
		drpFilterGroupEle.sendKeys(configReader.getProp("Ledger_FGroup"));
		Thread.sleep(4000);
		
		for (int i = 0; i < listDrp2ValueSize.size(); i++) {
			if (listDrp2ValueSize.get(i).getText().equalsIgnoreCase(configReader.getProp("Ledger_FGroup"))) {	
				listDrp2ValueSize.get(i).click();
				Thread.sleep(1500);
			}
		}

		btnApply.click();
		ElementUtils.waitForElementToHide(lblFilters, 100);

	}
	
	public boolean verifyGroupdataFunc() throws InterruptedException {
		Thread.sleep(4000);
		boolean flag = true;
		for (int x = 0; x < listGroup.size(); x++) {
			String value = listGroup.get(x).getText();
			if (value.equals(configReader.getProp("Ledger_FGroup")) || value.equals("")) {
				flag = true;
			} else {
				flag = false;
			}
		}
		return flag;
	}
	
	public void filterByDBCodeFunc() throws InterruptedException {

		Thread.sleep(1500);
		btnReset.click();
		ElementUtils.waitForElementToDisplay(lblMARSHA, 100);

		btnFilter.click();
		ElementUtils.waitForElementToDisplay(lblFilters, 100);

		/* Select the appropriate Group value from the drop-down menu. */
		WebElement drpDBEle = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(drpFilterDB));
		drpDBEle.click();
		drpDBEle.sendKeys(configReader.getProp("Ledger_DB"));

		Thread.sleep(2000);
		for (int i = 0; i < listDrp2ValueSize.size(); i++) {
			if (listDrp2ValueSize.get(i).getText().equalsIgnoreCase(configReader.getProp("Ledger_DB"))) {
				listDrp2ValueSize.get(i).click();
			}
		}

		btnApply.click();
		ElementUtils.waitForElementToHide(lblFilters, 100);

	}
	
	public boolean verifyDBCodedataFunc() throws InterruptedException {
		Thread.sleep(4000);
		boolean flag = true;
		for (int x = 0; x < listDB.size(); x++) {
			String value = listDB.get(x).getText();
			if (value.equals(configReader.getProp("Ledger_DB")) || value.equals("")) {
				flag = true;
			} else {
				flag = false;
			}
		}
		return flag;
	}
	
	public void filterBySTFunc() throws InterruptedException {

		Thread.sleep(2500);
		btnReset.click();
		ElementUtils.waitForElementToDisplay(lblMARSHA, 100);

		btnFilter.click();
		ElementUtils.waitForElementToDisplay(lblFilters, 100);

		/* Select the appropriate Group value from the drop-down menu. */
		WebElement drpSTEle = new WebDriverWait(driver, Duration.ofSeconds(50)).until(ExpectedConditions.visibilityOf(drpFilterSettlementType));
		drpSTEle.click();

		Thread.sleep(8000);
		for (int i = 0; i < listDrpValueSize.size(); i++) {
			if (listDrpValueSize.get(i).getAttribute("data-value").equalsIgnoreCase(configReader.getProp("Ledger_ST"))) {
				listDrpValueSize.get(i).click();
			}
		}

		Thread.sleep(3000);
		btnApply.click();
		ElementUtils.waitForElementToHide(lblFilters, 100);

	}
	
	public boolean verifySTdataFunc() throws InterruptedException {
		Thread.sleep(4000);
		boolean flag = true;
		for (int x = 0; x < listST.size(); x++) {
			String value = listST.get(x).getText();
			if (value.equals(configReader.getProp("Ledger_ST")) || value.equals("")) {
				flag = true;
			} else {
				flag = false;
			}
		}
		return flag;
	}
	
	public void filterByFolioFunc() throws InterruptedException {

		Thread.sleep(1500);
		btnReset.click();
		ElementUtils.waitForElementToDisplay(lblMARSHA, 100);

		btnFilter.click();
		ElementUtils.waitForElementToDisplay(lblFilters, 100);
		Thread.sleep(3000);

		/* Select the appropriate Group value from the drop-down menu. */
		WebElement drpFolioEle = new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(drpFilterFolio));
		drpFolioEle.click();
		drpFolioEle.sendKeys(configReader.getProp("Ledger_Folio"));

		Thread.sleep(6000);
		for (int i = 0; i < listDrp2ValueSize.size(); i++) {
			if (listDrp2ValueSize.get(i).getText().equalsIgnoreCase(configReader.getProp("Ledger_Folio"))) {
				listDrp2ValueSize.get(i).click();
			}
		}

		btnApply.click();
		ElementUtils.waitForElementToHide(lblFilters, 100);

	}
	
	public boolean verifyFolioDataFunc() throws InterruptedException {
		Thread.sleep(4000);
		boolean flag = true;
		for (int x = 0; x < listFolio.size(); x++) {
			String value = listFolio.get(x).getText();
			if (value.equals(configReader.getProp("Ledger_Folio")) || value.equals("")) {
				flag = true;
			} else {
				flag = false;
			}
		}
		return flag;
	}
	
	public void filterByArrDateFunc() throws InterruptedException {

		Thread.sleep(1500);
		btnReset.click();
		ElementUtils.waitForElementToDisplay(lblMARSHA, 100);

		btnFilter.click();
		ElementUtils.waitForElementToDisplay(lblFilters, 100);

		/* Select the appropriate ARR-Date value from the drop-down menu. */
//		WebElement drpFilterArrivalDateEle = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(drpFilterArrivalDate));
//		drpFilterArrivalDateEle.click();
		
		drpFilterArrivalDate.sendKeys(configReader.getProp("Ledger_ArrDate"));

		btnApply.click();
		ElementUtils.waitForElementToHide(lblFilters, 100);

	}
	
	public boolean verifyArrDateFunc() throws InterruptedException {
		Thread.sleep(2000);
		boolean flag = true;
		for (int x = 0; x < listArrDt.size(); x++) {
			String value = listArrDt.get(x).getText();
			if (value.equals(configReader.getProp("Ledger_ArrDate")) || value.equals("")) {
				flag = true;
			} else {
				flag = false;
			}
		}
		return flag;
	}
	
	public void filterByDepDateFunc() throws InterruptedException {

		Thread.sleep(1500);
		btnReset.click();
		ElementUtils.waitForElementToDisplay(lblMARSHA, 100);

		btnFilter.click();
		ElementUtils.waitForElementToDisplay(lblFilters, 100);

		/* Select the appropriate Group value from the drop-down menu. */
//		WebElement drpFilterDepartureDateEle = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(drpFilterDepartureDate));
//		drpFilterDepartureDateEle.click();

		drpFilterDepartureDate.sendKeys(configReader.getProp("Ledger_Depdate")); 
		btnApply.click();
		ElementUtils.waitForElementToHide(lblFilters, 100);

	}

	public boolean verifyDepDateFunc() throws InterruptedException {
		Thread.sleep(2000);
		boolean flag = true;
		for (int x = 0; x < listDepart.size(); x++) {
			String value = listDepart.get(x).getText();
			if (value.equals(configReader.getProp("Ledger_Depdate")) || value.equals("")) {
				flag = true;
			} else {
				flag = false;
			}
		}
		return flag;
	}
	
	public void filterByOutStandGreaterFunc() throws InterruptedException {

		Thread.sleep(1500);
		btnReset.click();
		ElementUtils.waitForElementToDisplay(lblMARSHA, 100);

		btnFilter.click();
		ElementUtils.waitForElementToDisplay(lblFilters, 100);

		/* Select the appropriate Group value from the drop-down menu. */
		WebElement drpOutstandingEle = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(drpOutstandingAmount));
		drpOutstandingEle.click();

		Thread.sleep(4500);
		for (int i = 0; i < listDrpValueSize.size(); i++) {
			if (listDrpValueSize.get(i).getAttribute("data-value").equalsIgnoreCase(configReader.getProp("drpGreaterstanding"))) {
				listDrpValueSize.get(i).click();
			}
		}
		txtOutstandingAmount.click();
		txtOutstandingAmount.sendKeys(configReader.getProp("Ledger_OutStanding"));

		btnApply.click();
		ElementUtils.waitForElementToHide(lblFilters, 100);

	}
	
	public boolean verifyOutStandGreater() throws InterruptedException {
		Thread.sleep(2000);
		boolean flag = true;
		ElementUtils.waitForElementToDisplay(lblMARSHA, 100);
		for (int x = 0; x < listOutstdg.size(); x++) {
			double value = Double.parseDouble(listOutstdg.get(x).getText().replaceAll(",", "").replaceAll("\\$", ""));
			double value2 = Double.parseDouble(configReader.getProp("Ledger_OutStanding"));
			if (value == value2 || value > value2 || listOutstdg.get(x).getText() == "") {
				flag = true;
			} else {
				flag = false;
			}
		}
		return flag;
	}	
	
	public void filterByLimitAmountFunc() throws InterruptedException {

		Thread.sleep(1500);
		btnReset.click();
		ElementUtils.waitForElementToDisplay(lblMARSHA, 100);

		btnFilter.click();
		ElementUtils.waitForElementToDisplay(lblFilters, 100);

		/* Select the appropriate Group value from the drop-down menu. */
		WebElement drpLimitEle = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(drpLimit));
		drpLimitEle.click();

		Thread.sleep(4500);
		for (int i = 0; i < listDrpValueSize.size(); i++) {
			if (listDrpValueSize.get(i).getAttribute("data-value").equalsIgnoreCase(configReader.getProp("drplimit"))) {
				listDrpValueSize.get(i).click();
			}
		}
		txtlimit.click();
		txtlimit.sendKeys(configReader.getProp("Ledger_Limit"));

		btnApply.click();
		ElementUtils.waitForElementToHide(lblFilters, 100);

	}
	
	public boolean verifyLimitAmount() throws InterruptedException {
		Thread.sleep(2000);
		boolean flag = true;
		ElementUtils.waitForElementToDisplay(lblMARSHA, 100);
		for (int x = 0; x < listLimit.size(); x++) {
			double value = Double.parseDouble(listLimit.get(x).getText().replaceAll(",", "").replaceAll("\\$", ""));
			double value2 = Double.parseDouble(configReader.getProp("Ledger_Limit"));
			if (value == value2 || value > value2 || listLimit.get(x).getText() == "") {
				flag = true;
			} else {
				flag = false;
			}
		}
		return flag;
	}
	
	public void inputSearchParameterFunc() throws InterruptedException {
		
		ElementUtils.waitForElementToDisplay(lblMARSHA, 100);
		txtSearch.sendKeys(configReader.getProp("Ledger_Search"));
		txtSearch.sendKeys(Keys.BACK_SPACE);
		Thread.sleep(4000);
		
	}
	
	public boolean verifySearchedParameterFunc() throws InterruptedException {
		
		int columnCount;
		boolean flag = true;
		ColumnData = new String[listMARSHARows.size()][noOfColumns.size()];

		for (int x = 0; x < listMARSHARows.size(); x++) {
			for (int t = 0; t < noOfColumns.size(); t++) {
				WebElement no = driver.findElement(By.xpath("//*[@id='root']//table/tbody/tr[" + (x + 1) + "]/td[" + (t + 1) + "]/div/div/div/div/div"));
				ColumnData[x][t] = no.getText();

			}
		}

		for (int x = 0; x < ColumnData.length; x++) {
			columnCount = 0;
			for (int t = 0; t < ColumnData[x].length; t++) {
				if (ColumnData[x][t].equalsIgnoreCase("SZWS")) {
					flag = true;
					columnCount++;
					break;
				} else {
					flag = false;
				}
			}
		}
		return flag;

	}
	
	
	
}
