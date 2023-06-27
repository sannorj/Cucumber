package myP1_pageObjects;

import java.text.DecimalFormat;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.ConstantsReader;

public class StatsbyDateRange_PageObjects {
	private WebDriver driver;
	private ConstantsReader configReader = new ConstantsReader();

	public StatsbyDateRange_PageObjects(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[text()='Stats by Date Range']")
	WebElement StatsbyDRbtn;

	@FindBy(xpath = "//h2[text()='Stats by Date Range']")
	WebElement StatsbyDRpageTitle;

	@FindBy(xpath = "//div[@id='s2id_ddlHotels']/a")
	WebElement hotelNameSelect;

	@FindBy(xpath = "//ul[@id='select2-results-1']//li//div")
	List<WebElement> lstDropDowHotel;
	
	@FindBy(xpath = "//table[@id='datatable-ajax']/thead/tr/th")
	List<WebElement> lstHeaders;
	
	@FindBy(xpath = "//table[@id='datatable-ajax']/tbody/tr")
	List<WebElement> lstRows;
	
	@FindBy(xpath = "//input[@id='txtStartDate']")
	WebElement startDateDatePicker;
	
	@FindBy(xpath = "//input[@id='txtEndDate']")
	WebElement endDateDatePicker;
	
	@FindBy(xpath = "//h5[text()='Select Hotel:']//following::div/a")
	WebElement selectHotel;
	
	@FindBy(xpath = "//input[@value='Update']")
	WebElement updateBtn;
	
	public void NavigateToStatbyDR() {
		StatsbyDRbtn.click();
		WebElement statByDRTitleView = new WebDriverWait(driver, Duration.ofSeconds(700)).until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//h2[text()='Stats by Date Range']")));
	}

	public boolean dataAvailableDiffDays() throws InterruptedException {
		WebElement statByDRTitleView = new WebDriverWait(driver, Duration.ofSeconds(700)).until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//h2[text()='Stats by Date Range']")));
		WebElement statByDRTableView = new WebDriverWait(driver, Duration.ofSeconds(700)).until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//table/tbody/tr")));
		hotelNameSelect.click();
		Thread.sleep(3000);
		for (int i = 0; i < lstDropDowHotel.size(); i++) {
			if (lstDropDowHotel.get(i).getText().equalsIgnoreCase(configReader.getMYP1Prop("StatbyDR_Hotel"))) {
				System.out.println("User Name list item ===" + lstDropDowHotel.get(i).getText());
				lstDropDowHotel.get(i).click();
			}
		}
		Thread.sleep(3000);
		startDateDatePicker.sendKeys(Keys.CONTROL + "a");
		startDateDatePicker.sendKeys(Keys.DELETE);
		startDateDatePicker.sendKeys(configReader.getMYP1Prop("StatbyDR_Start_date"));
		Thread.sleep(3000);
		endDateDatePicker.sendKeys(Keys.CONTROL + "a");
		endDateDatePicker.sendKeys(Keys.DELETE);
		endDateDatePicker.sendKeys(configReader.getMYP1Prop("StatbyDR_End_date"));
		Thread.sleep(3000);
		
		try {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", updateBtn);
		} catch (Exception e) {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", updateBtn);
		}
		Boolean waitToLoadTblData = new WebDriverWait(driver, Duration.ofSeconds(700)).until(ExpectedConditions
				.invisibilityOfElementLocated(By.xpath("//div[@class='dataTables_processing panel panel-default' and @style='display: block;']")));
		
		WebElement tableLoadView = new WebDriverWait(driver, Duration.ofSeconds(700)).until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//table/tbody/tr")));
		
		int noOfTableRows = driver.findElements(By.xpath("//table/tbody/tr")).size();
		if(noOfTableRows>0) {
			System.out.println("table has data when different dates filtered!");
		}else {
			System.out.println("table has no data loaded when different dates filtered!");
		}
		return true;
	}

	public boolean dataAvailableEqualDays() throws InterruptedException {
		hotelNameSelect.click();
		Thread.sleep(3000);
		for (int i = 0; i < lstDropDowHotel.size(); i++) {
			if (lstDropDowHotel.get(i).getText().equalsIgnoreCase(configReader.getMYP1Prop("StatbyDR_Hotel"))) {
				System.out.println("User Name list item ===" + lstDropDowHotel.get(i).getText());
				lstDropDowHotel.get(i).click();
			}
		}
		Thread.sleep(3000);
		startDateDatePicker.sendKeys(Keys.CONTROL + "a");
		startDateDatePicker.sendKeys(Keys.DELETE);
		startDateDatePicker.sendKeys(configReader.getMYP1Prop("StatbyDR_End_date"));
		Thread.sleep(3000);
		endDateDatePicker.sendKeys(Keys.CONTROL + "a");
		endDateDatePicker.sendKeys(Keys.DELETE);
		endDateDatePicker.sendKeys(configReader.getMYP1Prop("StatbyDR_End_date"));
		Thread.sleep(3000);
		
		try {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", updateBtn);
		} catch (Exception e) {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", updateBtn);
		}
		Boolean waitToLoadTblData = new WebDriverWait(driver, Duration.ofSeconds(700)).until(ExpectedConditions
				.invisibilityOfElementLocated(By.xpath("//div[@class='dataTables_processing panel panel-default' and @style='display: block;']")));
		
		WebElement tableLoadView = new WebDriverWait(driver, Duration.ofSeconds(700)).until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//table/tbody/tr")));
		
		int noOfTableRows = driver.findElements(By.xpath("//table/tbody/tr")).size();
		if(noOfTableRows>0) {
			System.out.println("table has data when same date filtered!");
		}else {
			System.out.println("table has no data loaded when same date filtered!");
		}
		return true;
	}

	public boolean calculateOccAvgOfRows() throws InterruptedException {
		DecimalFormat df = new DecimalFormat("0.00");
		df.setGroupingUsed(true);
		df.setGroupingSize(3);
		df.setMaximumFractionDigits(2);
		int rowId=0;
		for (int i = 0; i < lstHeaders.size(); i++) {
			if (lstHeaders.get(i).getText().equalsIgnoreCase(configReader.getMYP1Prop("StatbyDR_Occ_Val"))) {
				rowId=i+1;
			}
		}
		int rowList=lstRows.size();
		float SumofAllRows=0;
		System.out.println("rowList="+rowList);
		Thread.sleep(4000);
		int rows=rowList-1;
		for (int i = 0; i < rows; i++) {
			int row=i+1;
			String tableLoadView = new WebDriverWait(driver, Duration.ofSeconds(700)).until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//table/tbody/tr["+row+"]/td["+rowId+"]"))).getText();
			System.out.println(i+"Occ =="+tableLoadView);
			SumofAllRows=SumofAllRows+ Float.parseFloat(tableLoadView);
		}
		float avgRowTotal=SumofAllRows/rows;
		System.out.println("Average of all occ rows="+avgRowTotal);
		String currentTotalValue = new WebDriverWait(driver, Duration.ofSeconds(700)).until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//table/tbody/tr[last()]/td["+rowId+"]"))).getText();
		float currentTotalView=Float.parseFloat(currentTotalValue);
		String ActualValue = df.format(avgRowTotal);
		String VisibleValue = df.format(currentTotalView);
		System.out.println("calculated averge value= "+ActualValue);
		System.out.println("Current view averge value= "+VisibleValue);
		if (ActualValue.equals(VisibleValue)) {
			return true;
		}else {
			System.out.println("Occ average value isn't correct");
			return false;
		}
	}

	public boolean calculateAdrAvgOfRows() {
		DecimalFormat df = new DecimalFormat("0.00");
		df.setGroupingUsed(true);
		df.setGroupingSize(3);
		df.setMaximumFractionDigits(2);
		int rowId=0;
		for (int i = 0; i < lstHeaders.size(); i++) {
			if (lstHeaders.get(i).getText().equalsIgnoreCase(configReader.getMYP1Prop("StatbyDR_ADR_Val"))) {
				rowId=i+1;
			}
		}
		int rowList=lstRows.size();
		float SumofAllRows=0;
		int rows=rowList-1;
		for (int i = 0; i < rows; i++) {
			int row=i+1;
			String tableLoadView = new WebDriverWait(driver, Duration.ofSeconds(700)).until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//table/tbody/tr["+row+"]/td["+rowId+"]"))).getText();
			System.out.println(i+"Adr =="+tableLoadView);
			SumofAllRows=SumofAllRows+ Float.parseFloat(tableLoadView);
		}
		float avgRowTotal=SumofAllRows/rows;
		System.out.println("Average of all ADR rows="+avgRowTotal);
		String currentTotalValue = new WebDriverWait(driver, Duration.ofSeconds(700)).until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//table/tbody/tr[last()]/td["+rowId+"]"))).getText();
		float currentTotalView=Float.parseFloat(currentTotalValue);
		String ActualValue = df.format(avgRowTotal);
		String VisibleValue = df.format(currentTotalView);
		System.out.println("calculated averge value= "+ActualValue);
		System.out.println("Current view averge value= "+VisibleValue);
		if (ActualValue.equals(VisibleValue)) {
			return true;
		}else {
			System.out.println("ADR average value isn't correct");
			return false;
		}
	}

	public boolean calculateRevPARAvgOfRows() throws InterruptedException {
		DecimalFormat df = new DecimalFormat("0.00");
		df.setGroupingUsed(true);
		df.setGroupingSize(3);
		df.setMaximumFractionDigits(2);
		int rowId=0;
		for (int i = 0; i < lstHeaders.size(); i++) {
			if (lstHeaders.get(i).getText().equalsIgnoreCase(configReader.getMYP1Prop("StatbyDR_RevPAR_Val"))) {
				rowId=i+1;
			}
		}
		int rowList=lstRows.size();
		float SumofAllRows=0;
		System.out.println("rowList="+rowList);
		Thread.sleep(4000);
		int rows=rowList-1;
		for (int i = 0; i < rows; i++) {
			int row=i+1;
			String tableLoadView = new WebDriverWait(driver, Duration.ofSeconds(700)).until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//table/tbody/tr["+row+"]/td["+rowId+"]"))).getText();
			System.out.println(i+"RevPAR =="+tableLoadView);
			SumofAllRows=SumofAllRows+ Float.parseFloat(tableLoadView);
		}
		float avgRowTotal=SumofAllRows/rows;
		System.out.println("Average of all RevPAR rows="+avgRowTotal);
		String currentTotalValue = new WebDriverWait(driver, Duration.ofSeconds(700)).until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//table/tbody/tr[last()]/td["+rowId+"]"))).getText();
		float currentTotalView=Float.parseFloat(currentTotalValue);
		String ActualValue = df.format(avgRowTotal);
		String VisibleValue = df.format(currentTotalView);
		System.out.println("calculated averge value= "+ActualValue);
		System.out.println("Current view averge value= "+VisibleValue);
		if (ActualValue.equals(VisibleValue)) {
			return true;
		}else {
			System.out.println("RevPAR average value isn't correct");
			return false;
		}
	}

	public boolean calculateRoomRevenueTotalOfRows() throws InterruptedException {
		DecimalFormat df = new DecimalFormat("0.00");
		df.setGroupingUsed(true);
		df.setGroupingSize(3);
		df.setMaximumFractionDigits(2);
		int rowId=0;
		for (int i = 0; i < lstHeaders.size(); i++) {
			if (lstHeaders.get(i).getText().equalsIgnoreCase(configReader.getMYP1Prop("StatbyDR_RoomRevenue_Val"))) {
				rowId=i+1;
			}
		}
		int rowList=lstRows.size();
		float SumofAllRows=0;
		System.out.println("rowList="+rowList);
		Thread.sleep(4000);
		int rows=rowList-1;
		for (int i = 0; i < rows; i++) {
			int row=i+1;
			String tableLoadView = new WebDriverWait(driver, Duration.ofSeconds(700)).until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//table/tbody/tr["+row+"]/td["+rowId+"]"))).getText();
			System.out.println(i+" Room Revenue =="+tableLoadView);
			SumofAllRows=SumofAllRows+ Float.parseFloat(tableLoadView);
		}
		System.out.println("Sum of all Room Revenue rows="+SumofAllRows);
		String currentTotalValue = new WebDriverWait(driver, Duration.ofSeconds(700)).until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//table/tbody/tr[last()]/td["+rowId+"]"))).getText();
		float currentTotalView=Float.parseFloat(currentTotalValue);
		String ActualValue = df.format(SumofAllRows);
		String VisibleValue = df.format(currentTotalView);
		System.out.println("calculated total value= "+ActualValue);
		System.out.println("Current view total value= "+VisibleValue);
		if (ActualValue.equals(VisibleValue)) {
			return true;
		}else {
			System.out.println("Room Revenue Total value isn't correct");
			return false;
		}
	}

	public boolean calculateRoomSoldTotalOfRows() throws InterruptedException {
		DecimalFormat df = new DecimalFormat("0.00");
		df.setGroupingUsed(true);
		df.setGroupingSize(3);
		df.setMaximumFractionDigits(2);
		int rowId=0;
		for (int i = 0; i < lstHeaders.size(); i++) {
			if (lstHeaders.get(i).getText().equalsIgnoreCase(configReader.getMYP1Prop("StatbyDR_RoomSold_Val"))) {
				rowId=i+1;
			}
		}
		int rowList=lstRows.size();
		float SumofAllRows=0;
		System.out.println("rowList="+rowList);
		Thread.sleep(4000);
		int rows=rowList-1;
		for (int i = 0; i < rows; i++) {
			int row=i+1;
			String tableLoadView = new WebDriverWait(driver, Duration.ofSeconds(700)).until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//table/tbody/tr["+row+"]/td["+rowId+"]"))).getText();
			System.out.println(i+" Room Sold =="+tableLoadView);
			SumofAllRows=SumofAllRows+ Float.parseFloat(tableLoadView);
		}
		System.out.println("Sum of all Room Sold rows="+SumofAllRows);
		String currentTotalValue = new WebDriverWait(driver, Duration.ofSeconds(700)).until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//table/tbody/tr[last()]/td["+rowId+"]"))).getText();
		float currentTotalView=Float.parseFloat(currentTotalValue);
		String ActualValue = df.format(SumofAllRows);
		String VisibleValue = df.format(currentTotalView);
		System.out.println("calculated total value= "+ActualValue);
		System.out.println("Current view total value= "+VisibleValue);
		if (ActualValue.equals(VisibleValue)) {
			return true;
		}else {
			System.out.println("Room Sold Total value isn't correct");
			return false;
		}
	}
}
