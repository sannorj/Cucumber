package myP1_pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.ConstantsReader;

public class portfolioDashboard_PageObjects {

	private WebDriver driver;

	private ConstantsReader configReader = new ConstantsReader();

	public portfolioDashboard_PageObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//i[@class='fa fa-bars'])[2]")
	WebElement sideBarMenue;

	@FindBy(xpath = "//span[text()='Dashboard']//ancestor::a")
	WebElement dashboardMenue;

	@FindBy(xpath = "//span[text()=' Portfolio']//ancestor::a")
	WebElement PortfolioMenue;

	@FindBy(xpath = "//h2[text()='Portfolio Dashboard']")
	WebElement PortfolioHeader;

	@FindBy(xpath = "//input[@id='txtDate']")
	WebElement selectDate;

	@FindBy(xpath = "//button[@id='btnSearch']")
	WebElement searchToDate;

	@FindBy(xpath = "//span[contains(text(),'Hotel Name')]")
	WebElement hotelNameHeader;

	@FindBy(xpath = "//label[contains(text(),'User Name:')]")
	WebElement userNameLbl;

	@FindBy(xpath = "//a[@title='Sort Ascending']")
	WebElement sortImg;

	@FindBy(xpath = "//div[@id='s2id_ddlUserList']")
	WebElement userNameSelect;

	@FindBy(xpath = "//input[@id='s2id_autogen2_search']")
	WebElement userNameInput;

	@FindBy(xpath = "//ul[@id='select2-results-2']//li")
	List<WebElement> lstDropDowUserNames;

	@FindBy(xpath = "//select[@id='ddlAdminPortfolio']")
	WebElement periodSelect;

	@FindBy(xpath = "(//a[@title='Sort Ascending'])[2]")
	WebElement sortAscending;

	@FindBy(xpath = "(//a[@title='Sort Descending'])[2]")
	WebElement sortDescending;
	
	@FindBy(xpath = "//select[@id='ddlDetailPage']")
	WebElement selectDropDow;
	
	@FindBy(xpath = "//button[@id='btnSearchDetailPage']")
	WebElement goToSummaryBtn;


//	public void navigateToDashboard() {
//		WebElement sidebar = new WebDriverWait(driver, Duration.ofSeconds(10))
//				.until(ExpectedConditions.visibilityOf(sideBarMenue));
//		try {
//			sidebar.click();
//			Thread.sleep(3000);
//			dashboardMenue.click();
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//	}
//
//	public boolean navigateToPortfolio() throws InterruptedException {
//		boolean result = false;
//		WebElement portfolio = new WebDriverWait(driver, Duration.ofSeconds(10))
//				.until(ExpectedConditions.visibilityOf(PortfolioMenue));
//		portfolio.click();
//		System.out.println("5555555555555555555");
//		WebElement selectDateView = new WebDriverWait(driver, Duration.ofSeconds(100))
//				.until(ExpectedConditions.visibilityOf(selectDate));
//		System.out.println("????????????????????");
//		selectDateView.sendKeys(Keys.CONTROL + "a");
//		selectDateView.sendKeys(Keys.DELETE);
//		selectDateView.sendKeys(configReader.getMYP1Prop("date_href_val"));
//		System.out.println("**************************");
//		searchToDate.click();
//		
//		Thread.sleep(5000);
//		if (PortfolioHeader.isDisplayed()) {
//			result = true;
//		}
//
//		return result;
//	}

	public boolean checkDataLoaded() throws InterruptedException {
		boolean result = false;
		WebElement userName = new WebDriverWait(driver, Duration.ofSeconds(700))
				.until(ExpectedConditions.visibilityOf(userNameLbl));
		WebElement selectDateView = new WebDriverWait(driver, Duration.ofSeconds(100))
				.until(ExpectedConditions.visibilityOf(selectDate));

		selectDate.sendKeys(Keys.CONTROL + "a");
		selectDate.sendKeys(Keys.DELETE);
		selectDate.sendKeys(configReader.getMYP1Prop("date_href_val"));
		searchToDate.click();
		Thread.sleep(5000);

		WebElement hotelName = new WebDriverWait(driver, Duration.ofSeconds(700))
				.until(ExpectedConditions.visibilityOf(hotelNameHeader));
		if (hotelName.isDisplayed()) {
			result = true;
		}
		if (userName.isDisplayed()) {
			result = true;
		}
		if (sortImg.isDisplayed()) {
			result = true;
		}
		return result;
	}

	public boolean filterUserName() {
		userNameSelect.click();
		userNameInput.sendKeys(Keys.CONTROL + "a");
		userNameInput.sendKeys(Keys.DELETE);
		userNameInput.sendKeys(configReader.getMYP1Prop("Portfolio_UserName"));
		for (int i = 0; i < lstDropDowUserNames.size(); i++) {
			if (lstDropDowUserNames.get(i).getText().equalsIgnoreCase(configReader.getMYP1Prop("Portfolio_UserName"))) {
				System.out.println("User Name list item ===" + lstDropDowUserNames.get(i).getText());
				lstDropDowUserNames.get(i).click();
				return true;
			}
		}
		return false;
	}

	public boolean filterPeriod() {
		Select periodSelectOpt = new Select(periodSelect);
		periodSelectOpt.selectByVisibleText(configReader.getMYP1Prop("Portfolio_PeriodYTD"));

		WebElement hotelNameHeaderView = new WebDriverWait(driver, Duration.ofSeconds(1000))
				.until(ExpectedConditions.visibilityOf(hotelNameHeader));

		if (hotelNameHeaderView.isDisplayed()) {
			return true;
		}
		return false;
	}

	public boolean rowExpand() throws InterruptedException {
		WebElement HotelGrp = driver.findElement(By.xpath("//table[@id='adminPortfolio']//tr/td[text()='"
				+ configReader.getMYP1Prop("Portfolio_HotelGrp") + "']"));
		int HotelNamesHidden = driver.findElements(By.xpath("(//table[@id='adminPortfolio']//tr/td[text()='" + configReader.getMYP1Prop("Portfolio_HotelGrp")
						+ "']//ancestor::tr//following-sibling::tr[contains(@class,'hidden')])[1]")).size();
		
//		System.out.println("**************"+HotelNamesHidden);
		
		if (HotelGrp.isDisplayed()) {
			List<WebElement> lstDropDowHotelNames = driver.findElements(By.xpath("//table[@id='adminPortfolio']//tr/td[text()='" + configReader.getMYP1Prop("Portfolio_HotelGrp")
							+ "']//ancestor::tr//following-sibling::tr[contains(@class,'odd')]//td//a"));
			if (1>HotelNamesHidden) {
				HotelGrp.click();
			}
			Thread.sleep(5000);

			for (int i = 0; i < lstDropDowHotelNames.size(); i++) {
				if (lstDropDowHotelNames.get(i).getText().equalsIgnoreCase(configReader.getMYP1Prop("Portfolio_Hotel"))) {
				System.out.println("Hotel Name list item ===" + lstDropDowHotelNames.get(i).getText());
					return true;
				}
			}
		}
		return false;
	}

	public boolean isTblDataSort() throws InterruptedException {
		sortAscending.click();
		Thread.sleep(7000);
		float val=0;
		boolean isAscending=false;
		for (int i = 1; i < 4; i++) {
			String sortValues = driver.findElement(By.xpath("(//table[@id='adminPortfolio']//tr/td[text()='" + configReader.getMYP1Prop("Portfolio_HotelGrp")
						+ "']//ancestor::tr//following-sibling::tr[contains(@class,'odd')]/td[3]/span)["+i+"]")).getAttribute("innerText");
			System.out.println(Float.parseFloat(sortValues));
			if(i==1) {
				try{
					val=Float.parseFloat(sortValues);
				} catch(NumberFormatException ex){ 
					ex.printStackTrace();
				}
			}else {
				if(val<Float.parseFloat(sortValues)) {
					isAscending= true;
					System.out.println("current values sorted to Ascending"+sortValues);
				}
				else {
					isAscending=false;
					System.out.println("current values not sorted to Ascending order"+sortValues);
				}
			}
		}
		
		sortDescending.click();
		Thread.sleep(7000);
		float valD=0;
		boolean isDescending=false;
		for (int i = 1; i < 4; i++) {
			String sortValues = driver.findElement(By.xpath("(//table[@id='adminPortfolio']//tr/td[text()='" + configReader.getMYP1Prop("Portfolio_HotelGrp")
						+ "']//ancestor::tr//following-sibling::tr[contains(@class,'odd')]/td[3]/span)["+i+"]")).getAttribute("innerText");
			if(i==1) {
				try{
					valD=Float.parseFloat(sortValues);
				} catch(NumberFormatException ex){ 
					// handle your exception
				}
			}else {
				if(valD>Float.parseFloat(sortValues)) {
					isDescending= true;
					System.out.println("current values sorted to Descending"+sortValues);
				}
				else {
					isDescending=false;
					System.out.println("current values not sorted to Descending order"+sortValues);
				}
			}
		}
		if(isAscending=isDescending=true) {
			return true;
		}else {
			return false;
		}
	}

	public boolean goToSummaryPage() {
		Select selectOpt = new Select(selectDropDow);
		selectOpt.selectByVisibleText(configReader.getMYP1Prop("Portfolio_SelectOpt"));
		goToSummaryBtn.click();
		String currentTab = driver.getWindowHandle();
		for (String tab : driver.getWindowHandles()) {
		    if (!tab.equals(currentTab)) {
		        driver.switchTo().window(tab); 
		    }       
		}
		WebElement SelectedPageHeader = driver.findElement(By.xpath("//h2[text()='" + configReader.getMYP1Prop("Portfolio_SelectedPageHeader")+ "']"));
		WebElement ViewSelectPage = new WebDriverWait(driver, Duration.ofSeconds(100))
				.until(ExpectedConditions.visibilityOf(SelectedPageHeader));
		boolean isViewSelectPage = ViewSelectPage.isDisplayed();
		System.out.println("View Select Page is displayed: " + isViewSelectPage);
		return isViewSelectPage;
	}

}
