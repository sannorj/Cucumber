package myP2_pageObjects;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ConstantsReader;
import java.time.Duration;
import java.util.List;



public class PnLMonthly_PageObject {
boolean flag;
double roundOffOcc;
double roundOffAdr;
double roundOffrevPar;
double roundOffTotalRevPar;
private WebDriver driver;	
private ConstantsReader configReader = new ConstantsReader();

	public PnLMonthly_PageObject(WebDriver driver) {
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
	
	@FindBy(xpath = "//h1[text()='Profit & Loss Monthly Report']")
	WebElement pnlMonthlyPage;
	
	@FindBy(xpath = "//*[@class='MuiTable-root']/tbody/tr")
	List <WebElement> listStaticValues;
	
	@FindBy(xpath = "//tr[@data-el]/td[1]")
	List <WebElement> listSection;
	
	@FindBy(xpath = "//input[@name='date']")
	WebElement txtDate;
		
	@FindBy(xpath = "//input[@name='nullRecords']")
	WebElement btnZeroValue;
	
	@FindBy(xpath = "//tr[@data-el='Occupancy']/td[3]")
	WebElement cellOccupancy;
	
	@FindBy(xpath = "//tr[@data-el='Rooms sold']/td[3]")
	WebElement cellCRoomSold;
	
	@FindBy(xpath = "//tr[@data-el='Rooms available']/td[3]")
	WebElement cellRoomsAvailable;
	
	@FindBy(xpath = "//tr[@data-el='RMREV90']/td[3]")
	WebElement cellTotalRoomsRevenue;
	
	@FindBy(xpath = "//tr[@data-el='ADR']/td[3]")
	WebElement cellAdr;
	
	@FindBy(xpath = "//tr[@data-el='REV-PAR']/td[3]")
	WebElement cellRevPar;
	
	@FindBy(xpath = "//tr[@data-el='Total Operating Revenue']/td[3]")
	WebElement cellTotalOperatingRevenue;
	
	@FindBy(xpath = "//tr[@data-el='Total REV-PAR']/td[3]")
	WebElement cellTotalRevPar;
	
	
	
	
	public boolean navigatePnLMonthlyPage() {
		
		WebElement pnlMonthEle = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(pnlMonthly));
		pnlMonthEle.click();
		
		WebElement pnlMothlyPageEle = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(pnlMonthlyPage));
		
		return pnlMothlyPageEle.isDisplayed();
		
	}
	
   public void selectParameters() throws InterruptedException {
		
			/* Select the appropriate Group value from the drop-down menu. */
			WebElement drpGroupEle = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(drpGroup));
			drpGroupEle.click();
			
			ExpectedConditions.visibilityOf(listDrpValueSize.get(0));
			for (int i = 0; i < listDrpValueSize.size(); i++) {
				if (listDrpValueSize.get(i).getText().equalsIgnoreCase(configReader.getProp("Group"))) {
					listDrpValueSize.get(i).click();
				}
			}

			WebElement drpPropertyEle = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(drpProperty));
			drpPropertyEle.click();
			
			ExpectedConditions.visibilityOf(listDrpValueSize.get(1));
			for (int i = 0; i < listDrpValueSize.size(); i++) {
				if (listDrpValueSize.get(i).getText().equalsIgnoreCase(configReader.getProp("Propery"))) {
					listDrpValueSize.get(i).click();
				}
			}

			txtDate.sendKeys(Keys.CONTROL + "a");
			txtDate.sendKeys(Keys.DELETE);
			txtDate.sendKeys(configReader.getProp("Date"));

			WebElement drpViewEle = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(drpView));
			drpViewEle.click();

		
			ExpectedConditions.visibilityOf(listDrpValueSize.get(0));
			for (int i = 0; i < listDrpValueSize.size(); i++) {
				if (listDrpValueSize.get(i).getText().equalsIgnoreCase(configReader.getProp("View"))) {
					ExpectedConditions.visibilityOf(listDrpValueSize.get(0));
					listDrpValueSize.get(i).click();
				}
			}
		
			ExpectedConditions.invisibilityOf(listDrpValueSize.get(0));
			WebElement btnGO = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(btnGo));
			btnGO.click();
			
			/* mandatory pause */
			Thread.sleep(2500);
			btnZeroValue.click();
	}
		
	public boolean verifyStaticSection() {

			ExpectedConditions.visibilityOf(listSection.get(1));
			/* capture/go though the 5 static section */
			for (int x = 0; x < 5; x++) {
				/* split and ready the data from property file */
				String[] a = configReader.getProp("Static_Names").split(",");
				/* Get the 5 static section form property file */
				for (int i = 0; i < a.length; i++) {
					String expected = a[i];
					String actual = listStaticValues.get(i).getText();
					if (actual.contains(expected)) {
						flag = true;
					} else {
						flag = false;
					}
				}
			}
		return flag;

	}
	
	public void occupancyCalFunc() {

			WebElement RoomSold = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(cellCRoomSold));
			double RoomSoldValue = Double.parseDouble(RoomSold.getText().replaceAll(",", ""));

			WebElement RoomsAvailable = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(cellRoomsAvailable));
			double RoomsAvailableValue = Double.parseDouble(RoomsAvailable.getText().replaceAll(",", ""));

			/* Calculate the Occupancy value */
			double x = RoomSoldValue / RoomsAvailableValue * 100;
			roundOffOcc = Math.round(x * 100.0) / 100.0;
	}
	
	public boolean verifyOccCalculationFunc() {

		WebElement OccValue = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(cellOccupancy));
		double Occupancy = Double.parseDouble(OccValue.getText().replace("%", ""));

		/* Verify the calculated and captured values are same. */
		if (Occupancy == roundOffOcc) {
			return true;
		} else {
			return false;
		}

	}
	
	public void adrCalFunc() {

			WebElement TotalRoomsRevenue = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(cellTotalRoomsRevenue));
			double TotalRoomsRevenueValue = Double.parseDouble(TotalRoomsRevenue.getText().replaceAll(",", "").replaceAll("\\$", ""));

			WebElement RoomSold = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(cellCRoomSold));
			double RoomSoldValue = Double.parseDouble(RoomSold.getText().replaceAll(",", ""));

			double x = TotalRoomsRevenueValue / RoomSoldValue * 100;
			roundOffAdr = Math.round(x * 100.0) / 100.0;

	}

	public boolean verifyAdrCalculationFunc() {
		
		WebElement adr = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(cellAdr));
		double adrValue = Double.parseDouble(adr.getText().replace(",", "").replaceAll("\\$", ""));

		if (roundOffAdr == adrValue) {
			return true;
		} else {
			return false;
		}

	}
	
	public void revParCalFunc() {

			WebElement TotalRoomsRevenue = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(cellTotalRoomsRevenue));
			double TotalRoomsRevenueValue = Double.parseDouble(TotalRoomsRevenue.getText().replaceAll(",", "").replaceAll("\\$", ""));

			WebElement RoomsAvailable = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(cellRoomsAvailable));
			double RoomsAvailableValue = Double.parseDouble(RoomsAvailable.getText().replaceAll(",", ""));

			double x = TotalRoomsRevenueValue / RoomsAvailableValue * 100;
			roundOffrevPar = Math.round(x * 100.0) / 100.0;

	}
	
	public boolean verifyRevParCalculationFunc() {
		
		WebElement revPar = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(cellRevPar));
		double revParValue = Double.parseDouble(revPar.getText().replace(",", "").replaceAll("\\$", ""));

		/* Verify the calculated and captured values are same. */
		if (roundOffrevPar == revParValue) {
			return true;
		} else {
			return false;
		}

	}
	
	public void totalRevParCalFunc() {
		
		    ExpectedConditions.visibilityOf(listSection.get(1));
			WebElement TotalOperatingRevenue = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(cellTotalOperatingRevenue));
			double TotalOperatingRevenueValue = Double.parseDouble(TotalOperatingRevenue.getText().replaceAll(",", "").replaceAll("\\$", ""));

			WebElement RoomsAvailable = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(cellRoomsAvailable));
			double RoomsAvailableValue = Double.parseDouble(RoomsAvailable.getText().replaceAll(",", ""));

			/* Calculate the Occupancy value */
			double x = TotalOperatingRevenueValue / RoomsAvailableValue * 100;
			roundOffTotalRevPar = Math.round(x * 100.0) / 100.0;
	}
	
	
	public boolean verifyTotalRevParCalculationFunc() {
		
		/* Capture the revPar Value from page */
		WebElement totalRevPar = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(cellTotalRevPar));
		double revParValue = Double.parseDouble(totalRevPar.getText().replace(",", "").replaceAll("\\$", ""));

		/* Verify the calculated and captured values are same. */
		if (roundOffTotalRevPar == revParValue) {
			return true;
		} else {
			return false;
		}

	}
	
	public boolean verifyOwnersViewSection() {
		
			ExpectedConditions.visibilityOf(listSection.get(1));
			for (int x = 0; x < listStaticValues.size(); x++) {
				/* split and ready the data from property file */
				String[] a = configReader.getProp("Owner_Section").split(",");
				for (int i = 0; i < a.length; i++) {
					String expected = a[i];
					String actual = listSection.get(x).getText();
					if (actual.contains(expected)) {
						flag = true;
					} else {
						flag = false;
					}
				}
			}
		return flag;

	}

	public void selectOperatorView() {

		WebElement drpViewEle = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(drpView));
		drpViewEle.click();

		ExpectedConditions.visibilityOf(listDrpValueSize.get(0));
		for (int i = 0; i < listDrpValueSize.size(); i++) {
			if (listDrpValueSize.get(i).getText().equalsIgnoreCase(configReader.getProp("OperatorView"))) {
				listDrpValueSize.get(i).click();
			}
		}
		WebElement btnGO = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(btnGo));
		btnGO.click();

	}
	
	public boolean verifyOperatorSection() {
		
		try {
			/* mandatory pause */
			Thread.sleep(1500);
			ExpectedConditions.visibilityOf(listSection.get(1));
			for (int x = 0; x < listStaticValues.size(); x++) {
				/* split and ready the data from property file */
				String[] a = configReader.getProp("Operator_Section").split(",");
				for (int i = 0; i < a.length; i++) {
					
					String expected = a[i];
					String actual = listSection.get(x).getText();
					if (actual.contains(expected)) {
						flag = true;
					} else {
						flag = false;
					}
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	return flag;

}
	
	public void selectRooRevenueDetailView() {	
		
		WebElement drpViewEle = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(drpView));
		drpViewEle.click();
		
		ExpectedConditions.visibilityOf(listDrpValueSize.get(0));
		for (int i = 0; i < listDrpValueSize.size(); i++) {
			if (listDrpValueSize.get(i).getText().equalsIgnoreCase(configReader.getProp("RoomRevenueDetail"))) {
				listDrpValueSize.get(i).click();
			}
		}
		WebElement btnGO = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(btnGo));
		btnGO.click();
		
	}
	
	public boolean verifyRoomRevenueDetailSection() {
		
		try {
			/* mandatory pause */
			Thread.sleep(1500);
			ExpectedConditions.visibilityOf(listSection.get(1));
			for (int x = 0; x < listStaticValues.size(); x++) {
				/* split and ready the data from property file */
				String[] a = configReader.getProp("RoomRevenueDetail_Section").split(",");
				for (int i = 0; i < a.length; i++) {

					String expected = a[i];
					String actual = listSection.get(x).getText();
					if (actual.contains(expected)) {
						flag = true;
					} else {
						flag = false;
					}
				}
			}
		} catch (InterruptedException e) {
		}
		return flag;
	}
	
}
