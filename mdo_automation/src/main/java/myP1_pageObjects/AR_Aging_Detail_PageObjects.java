package myP1_pageObjects;

import java.text.DecimalFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

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

public class AR_Aging_Detail_PageObjects {
	private WebDriver driver;
	private ConstantsReader configReader = new ConstantsReader();

	public AR_Aging_Detail_PageObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@id='s2id_ddlHotels']/a")
	WebElement hotelNameSelect;

	@FindBy(xpath = "//ul[@id='select2-results-1']//li//div")
	List<WebElement> lstDropDowHotel;
	
	@FindBy(xpath = "//div[@class='sidebar-header']")
	WebElement navigationLink;

	@FindBy(xpath = "//a//span[text()='Reports']")
	WebElement reportLink;

	@FindBy(xpath = "//input[@id='txtDate']")
	WebElement currentDate;

	@FindBy(xpath = "//input[@value='Update']")
	WebElement updateBtn;

	@FindBy(xpath = "//div[@id='datatable-araging-containerForCompanyPortfolio']//div[@class='dataTables_scrollFoot']//tfoot//td[contains(@class,'right')]")
	List<WebElement> lstTotalColValues;

	@FindBy(xpath = "//div[@id='datatable-araging-containerForCompanyPortfolio']//div[@class='dataTables_scrollBody']//tbody//tr")
	List<WebElement> lstRaws;

	public void clickOnLink(String LinkName) throws InterruptedException {
		navigationLink.click();
		WebElement LinkNameView = new WebDriverWait(driver, Duration.ofSeconds(700)).until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//aside[@id='sidebar-left']//nav//ul/li//span[text()='"+LinkName+"']")));
		LinkNameView.click();
		Thread.sleep(3000);
	}

	public boolean navigateToARAging() {
		WebElement LinkNameView = new WebDriverWait(driver, Duration.ofSeconds(700)).until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//header/h2[text()='AR Aging Detail']")));
		return true;
	}

	public void selectHotel() throws InterruptedException {
		WebElement waitLoadHotelList = new WebDriverWait(driver, Duration.ofSeconds(700)).until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//a//span[text()=' Sleep Inn & Suites Lakeside']")));
		Thread.sleep(3000);
		hotelNameSelect.click();
		Thread.sleep(3000);
		try {
			for (int i = 0; i < lstDropDowHotel.size(); i++) {
				if (lstDropDowHotel.get(i).getText().equalsIgnoreCase(configReader.getMYP1Prop("AR_Aging_Detail_Hotel"))) {
					System.out.println("HOtel list item ===" + lstDropDowHotel.get(i).getText());
					lstDropDowHotel.get(i).click();
				}
			}
		} catch (Exception e) {
			System.out.println("Hotel not filtered!");
		}
	}

	public void selectSelectBy() throws InterruptedException {
		WebElement WaitHotelView = new WebDriverWait(driver, Duration.ofSeconds(700)).until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//table/thead/tr/th/span[contains(text(),'Hotel Name')]")));
		Thread.sleep(3000);		try {
			Select selectByOptions = new Select(driver.findElement(By.xpath("//select[@id='ddlSelectBy']")));
			selectByOptions.selectByVisibleText(configReader.getMYP1Prop("AR_Aging_Detail_SelectBy"));
		} catch (Exception e) {
			System.out.println("SelectBy not filtered!");
		}
		Thread.sleep(3000);
	}

	public void selectCurrentDate() throws InterruptedException {
		Thread.sleep(3000);	
		currentDate.sendKeys(Keys.CONTROL + "a");
		currentDate.sendKeys(Keys.DELETE);
		currentDate.sendKeys(configReader.getMYP1Prop("AR_Aging_Detail_Date"));
		Thread.sleep(3000);
	}

	public void clickUpdate() throws InterruptedException {
		Thread.sleep(3000);	
		try {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", updateBtn);
		} catch (Exception e) {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", updateBtn);
		}
		Thread.sleep(5000);	
	}

	public boolean calculateColTot() {
		
		DecimalFormat df = new DecimalFormat("0");
		Boolean valueisEqual=true;
		
		for (int i = 0; i < lstTotalColValues.size(); i++) {
			int col=i+1;
			System.out.println(lstTotalColValues.get(i));
			String currentTotVal=lstTotalColValues.get(i).getText().replaceAll(",", "");
			System.out.println("*****************==="+currentTotVal);
			float currentTotalvalue=Float.parseFloat(currentTotVal);
			
			float calculatedTotalVal=0;
			for (int q = 0; q < lstRaws.size(); q++) {
				int raw=q+1;
				String currentVal = new WebDriverWait(driver, Duration.ofSeconds(700)).until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//div[@id='datatable-araging-containerForCompanyPortfolio']//div[@class='dataTables_scrollBody']//tbody//tr["+raw+"]//td[contains(@class,'right')]["+col+"]"))).getText();
				float currentCellvalue=Float.parseFloat(currentVal.replaceAll(",", ""));
				calculatedTotalVal=calculatedTotalVal+currentCellvalue;
				System.out.println("current cell value of "+raw+" raw = "+currentVal);
			}
			String calculatedTotalValue = df.format(calculatedTotalVal);
			System.out.println("calculated total value===="+calculatedTotalValue);
			System.out.println("");
			String currentTotValString = df.format(currentTotalvalue);
			System.out.println("current total value of "+col+" column==== "+currentTotValString);
			System.out.println("=============================");
			if(currentTotValString.equals(calculatedTotalValue)) {
				System.out.println("trueee");
			}else {
				System.out.println("falseee");
				valueisEqual=false;
			}
		}
		return valueisEqual;
		
	}

	public boolean calculateRawAgeTot() {

		DecimalFormat df = new DecimalFormat("0");
		Boolean valueisEqual=true;
		
		for (int i = 0; i < lstRaws.size(); i++) {
			int raw=i+1;
			String currentTotalVal = new WebDriverWait(driver, Duration.ofSeconds(700)).until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("(//table[@id='datatable-ajax-3']//tbody/tr/td[@data-label='Total'])["+raw+"]"))).getText();
			float currentTotalvalue=Float.parseFloat(currentTotalVal);
			System.out.println("current total value of "+raw+" raw==== "+currentTotalVal);
			
			float calculatedTot=0;
			List<WebElement> currentVals =  driver.findElements(By.xpath("//table[@id='datatable-ajax-3']//tbody/tr["+raw+"]/td[contains(@data-label,'Due_')]"));
			for (int q = 0; q < currentVals.size(); q++) {
				int col=q+1;
				String currentVal=currentVals.get(q).getText().replaceAll(",", "");
				System.out.println(col+" col=== "+currentVal);
				float currentrawTotalvalue=Float.parseFloat(currentVal);
				calculatedTot=calculatedTot+currentrawTotalvalue;
			}
			String calculatedTotalValue = df.format(calculatedTot);
			System.out.println("Total calculated val === "+calculatedTotalValue);

			String currentTotalValString = df.format(currentTotalvalue);
			System.out.println("current total value of "+raw+" raw==== "+currentTotalValString);
			if(currentTotalValString.equals(calculatedTotalValue)) {
				System.out.println("trueee");
			}else {
				System.out.println("falseee");
				valueisEqual=false;
			}
			System.out.println("=============================");
			System.out.println("");
		}
		return valueisEqual;
	}

	public boolean calculateTotalAR() {

		DecimalFormat df = new DecimalFormat("0");
		Boolean valueisEqual=true;
		
		for (int i = 0; i < lstRaws.size(); i++) {
			int raw=i+1;
			String currentTotalARVal = new WebDriverWait(driver, Duration.ofSeconds(700)).until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("(//table[@id='datatable-ajax-3']//tbody/tr/td[@data-label='TotalAR'])["+raw+"]"))).getText().replaceAll(",", "");
			float currentTotalARvalue=Float.parseFloat(currentTotalARVal);
			
			float calculatedTot=0;
			String TotalValue =  new WebDriverWait(driver, Duration.ofSeconds(700)).until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//table[@id='datatable-ajax-3']//tbody/tr["+raw+"]/td[@data-label='Total']"))).getText().replaceAll(",", "");
			
			String HouseledgerValue =  new WebDriverWait(driver, Duration.ofSeconds(700)).until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//table[@id='datatable-ajax-3']//tbody/tr["+raw+"]/td[@data-label='Houseledger']"))).getText().replaceAll(",", "");
			
			String AdvDepositValue =  new WebDriverWait(driver, Duration.ofSeconds(700)).until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//table[@id='datatable-ajax-3']//tbody/tr["+raw+"]/td[@data-label='AdvDeposit']"))).getText().replaceAll(",", "");
			
			float currentTotalValue=Float.parseFloat(TotalValue);
			float currentHouseledgerValue=Float.parseFloat(HouseledgerValue);
			float currentAdvDepositValue=Float.parseFloat(AdvDepositValue);
			float calculatedTotAR=currentTotalValue+currentHouseledgerValue+currentAdvDepositValue;
			
			String calculatedTotalARValue = df.format(calculatedTotAR);
			System.out.println("Total calculated AR val === "+calculatedTotalARValue);
			String currentTotalARValString = df.format(currentTotalARvalue);
			System.out.println("current total AR value of "+raw+" raw==== "+currentTotalARVal);
			
			if(currentTotalARValString.equals(calculatedTotalARValue)) {
				System.out.println("trueee");
			}else {
				System.out.println("falseee");
				valueisEqual=false;
			}
			System.out.println("=============================");
			System.out.println("");
		}
		return valueisEqual;
	}

	public void clickAddComment() {
		// TODO Auto-generated method stub
		
	}

}
