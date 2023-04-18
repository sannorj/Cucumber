package myP1_pageObjects;

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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.ConstantsReader;

public class laborDashboard_PageObjects {

	private WebDriver driver;
	private ConstantsReader configReader = new ConstantsReader();
	public laborDashboard_PageObjects(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//div[@class='sidebar-header']")
	WebElement navigationLink;

	@FindBy(xpath = "//a//span[text()='Dashboard']")
	WebElement dashboardLink;

	@FindBy(xpath = "//a//span[contains(text(),'Labor (Classic)')]")
	WebElement laborLink;

	@FindBy(xpath = "//h2[text()='Labor']")
	WebElement laborTitle;

	@FindBy(xpath = "(//select[@class='form-control select2-offscreen'])[1]")
	WebElement propertyDropdown;

	@FindBy(xpath = "//input[@id='txtDate']")
	WebElement datePickerVal;

	@FindBy(xpath = "//button[@title='Search']")
	WebElement searchBtn;

	@FindBy(xpath = "//header[@class='panel-heading portlet-handler']")
	List<WebElement> panelLst;
	
	
	public boolean navigateLabor() {
		navigationLink.click();
		WebElement dashboardLinkView = new WebDriverWait(driver, Duration.ofSeconds(700))
				.until(ExpectedConditions.visibilityOf(dashboardLink));
		dashboardLinkView.click();
		WebElement trendsLinkView = new WebDriverWait(driver, Duration.ofSeconds(700))
				.until(ExpectedConditions.visibilityOf(laborLink));
		trendsLinkView.click();
		WebElement trendsTitleView = new WebDriverWait(driver, Duration.ofSeconds(700))
				.until(ExpectedConditions.visibilityOf(laborTitle));
		return trendsTitleView.isDisplayed();
	}


	public void selectOptions(String string) throws InterruptedException {
		Thread.sleep(7000);
		WebElement panelLoad = new WebDriverWait(driver, Duration.ofSeconds(700)).until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//header[@class='panel-heading portlet-handler']")));
		
		Select drpHotel = new Select(propertyDropdown);
		WebElement waitHotelLoad = new WebDriverWait(driver, Duration.ofSeconds(100))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='ddlHotels']//option")));
		drpHotel.selectByVisibleText(string);

		datePickerVal.sendKeys(Keys.CONTROL + "a");
		datePickerVal.sendKeys(Keys.DELETE);
		datePickerVal.sendKeys(configReader.getMYP1Prop("Labor_Date"));
		Thread.sleep(3000);
	}


	public void loadData() throws InterruptedException {
		searchBtn.click();
		Thread.sleep(3000);
		WebElement panelView = new WebDriverWait(driver, Duration.ofSeconds(700)).until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@class='panel-body']")));
	}


	public void verifyCards() throws InterruptedException {
		Thread.sleep(3000);
		System.out.println("panelLst.size()==="+panelLst.size());
		for (int i = 0; i < panelLst.size(); i++) {
			int val = i + 1;
//			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebElement cardMinimize = new WebDriverWait(driver, Duration.ofSeconds(700))
					.until(ExpectedConditions.visibilityOfElementLocated(
							By.xpath("(//header[@class='panel-heading portlet-handler']//div[@class='panel-actions']//a[contains(@class,'panel-action panel-action-toggle')])["
									+ val + "]")));
//			js.executeScript("arguments[0].scrollIntoView();", cardMinimize);
			Thread.sleep(3000);
			System.out.println("(//header[@class='panel-heading portlet-handler']//div[@class='panel-actions'])["+ val + "]");
			try {
				JavascriptExecutor executor = (JavascriptExecutor) driver;
				executor.executeScript("arguments[0].click();", cardMinimize);
			} catch (Exception e) {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].scrollIntoView();", cardMinimize);
				JavascriptExecutor executor = (JavascriptExecutor) driver;
				executor.executeScript("arguments[0].click();", cardMinimize);
			}
			Thread.sleep(2000);
			WebElement viewChartCollapsed = new WebDriverWait(driver, Duration.ofSeconds(700))
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
							"//header[@class='panel-heading portlet-handler']//ancestor::section[@class='panel panel-primary panel-collapsed']")));
			cardMinimize.click();
			Thread.sleep(3000);
			
		}
	}


	public void verifyHrMinButton(String string) {
		WebElement minuteBtn = new WebDriverWait(driver, Duration.ofSeconds(700))
				.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath("//h2[contains(text(),'"+ string +"Hours)')]//ancestor::header//b[text()='Minute']")));
		if(minuteBtn.isDisplayed()) {
			minuteBtn.click();
			WebElement minuteTableView = new WebDriverWait(driver, Duration.ofSeconds(700))
				.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath("(//h2[contains(text(),'"+ string +"Minutes)')]//following::table/thead)[1]")));
		}
		
		WebElement hourBtn = new WebDriverWait(driver, Duration.ofSeconds(700))
				.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath("//h2[contains(text(),'"+ string +"Minutes)')]//ancestor::header//b[text()='Hour']")));
		if(hourBtn.isDisplayed()) {
			hourBtn.click();
			WebElement hourTableView = new WebDriverWait(driver, Duration.ofSeconds(700))
				.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath("(//h2[contains(text(),'"+ string +"Hours)')]//following::table/thead)[1]")));
		}
	}


	public boolean payrollPageView(String string) throws InterruptedException {
		WebElement gotodetailsLink = new WebDriverWait(driver, Duration.ofSeconds(700))
				.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath("//h2[contains(text(),'"+ string +"')]//ancestor::header//a[@title='Go to detail']")));
		if(gotodetailsLink.isDisplayed()) {
			gotodetailsLink.click();
			Thread.sleep(3000);
			String currentTab = driver.getWindowHandle();
			for (String tab : driver.getWindowHandles()) {
			    if (!tab.equals(currentTab)) {
			        driver.switchTo().window(tab); 
			    }       
			}
			boolean pageView = new WebDriverWait(driver, Duration.ofSeconds(700))
				.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath("(//header/h2[text()='"+ string +"'])[1]"))).isDisplayed();
			return pageView;
		}else {
			System.out.println(string+" panel not available!");
			return true;
		}
	}

}
