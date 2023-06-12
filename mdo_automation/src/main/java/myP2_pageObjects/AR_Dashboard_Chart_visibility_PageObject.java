package myP2_pageObjects;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ConstantsReader;
import utils.ElementUtils;

public class AR_Dashboard_Chart_visibility_PageObject {
	
	private WebDriver driver;
	private ConstantsReader configReader = new ConstantsReader();
	boolean flag;
	String OrginalTotStringValue;
	String OrginalGraphStringValue;
	int totIntegerValue;
	double roundOffTotVal;
	
	public AR_Dashboard_Chart_visibility_PageObject(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath = "//button[@data-el='menuToggle']")
	WebElement selector;
	
	@FindBy(xpath = "//div[text()='Dashboard']//ancestor::li")
	WebElement dashBoard;

	@FindBy(xpath = "//a[contains(text(),'Primary Dashboard (New)')]//ancestor::li")
	WebElement primaryDashboard;

	@FindBy(xpath = "//h1[contains(text(),'Primary Dashboard')]")
	WebElement primaryDashboardPage;
	
	@FindBy(xpath = "//tbody//tr[last()]//td//span[text()='Totals']")
	WebElement totalEle;

	@FindBy(xpath = "//tbody//tr[last()]//td[4]")
	WebElement totRawThirdValue;
	
	@FindBy(xpath = "//div[text()='AR Aging Widget']")
	WebElement dashWidget;
	
	
	public void checkTotValue() throws InterruptedException {
		
		Thread.sleep(5000);

		ElementUtils.waitForElementToDisplay(totalEle, 100);
		
		Thread.sleep(3000);

		WebElement totRawThirdValEle = new WebDriverWait(driver, Duration.ofSeconds(50))
				.until(ExpectedConditions.visibilityOf(totRawThirdValue));
		
		OrginalTotStringValue = totRawThirdValEle.getText();
		
		String totStringValue = totRawThirdValEle.getText().replaceAll("\\$", "").replaceAll(",", "");
		double totDoubleValue = Double.parseDouble(totStringValue);
		roundOffTotVal = Math.round(totDoubleValue);
		totIntegerValue = Double.valueOf(roundOffTotVal).intValue();

		if (totIntegerValue > 0) {
			
			System.out.println( "Total greater than zero. The value is : " + totIntegerValue);
			
		}
		else{
			
			System.out.println( "Total less than or equal to zero. The value is : " + totIntegerValue);
			
		}
		
		Thread.sleep(3000);

	}
	
	
	public boolean navigateToPrimaryDashboard() throws InterruptedException {

		Thread.sleep(2000);
		
		WebElement menu = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(selector));
		menu.click();
		
		WebElement dash = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(dashBoard));
		dash.click();

		WebElement primaryDashboardEle = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(primaryDashboard));
		primaryDashboardEle.click();

		Thread.sleep(5000);
		return primaryDashboardPage.isDisplayed();

	}

	public void checkGroupAndDate() throws InterruptedException {

		Thread.sleep(2000);
			
		WebElement checkGroupValue = new WebDriverWait(driver, Duration.ofSeconds(100))
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='porfolio-group']")));
			
		checkGroupValue.isDisplayed();
		
		Thread.sleep(2000);
			
		if (checkGroupValue.getText().equalsIgnoreCase(configReader.getProp("AR_dashBoard_GrpDropdown"))) {
			
			WebElement groupValue = new WebDriverWait(driver, Duration.ofSeconds(400))
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value='" + configReader.getProp("AR_dashBoard_GrpDropdown") + "']")));
			
			groupValue.isDisplayed();

		}
			
		Thread.sleep(3000);
		
		
		WebElement checkDateValue = new WebDriverWait(driver, Duration.ofSeconds(100))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div//label[text() = 'Date'] /following-sibling::div//input")));
		
		checkDateValue.isDisplayed();
		
		Thread.sleep(2000);
		
		if (checkDateValue.getText().equalsIgnoreCase(configReader.getProp("revenueDate"))) {
			
			WebElement dateValue = new WebDriverWait(driver, Duration.ofSeconds(100))
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value='" + configReader.getProp("revenueDate") + "']")));
			
			dateValue.isDisplayed();

		}
		
		Thread.sleep(3000);

	}
	
	public boolean checkWidgetChart() throws InterruptedException {
		
		boolean flag = false;

		Thread.sleep(2000);

		ElementUtils.waitForElementToDisplay(dashWidget, 250);
		
		Thread.sleep(2000);
		
		WebElement element = driver.findElement(By.xpath("//div[text()='" + configReader.getProp("AR_Aging_Widget_chart") + "']"));
		element.isDisplayed();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
		
		Thread.sleep(2000);
		
		try {
			if (totIntegerValue > 0) {
			
				flag = true;
				
				Thread.sleep(3000);
			
				WebElement graphThirdValue = new WebDriverWait(driver, Duration.ofSeconds(250))
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[text()='" + configReader.getProp("AR_Aging_Widget_chart") + "']/ancestor::div[@data-el='chartCard']//*[local-name()='svg' and @role='group']//*[local-name()='tspan'])[3]")));
			
				graphThirdValue.isDisplayed();
				
				OrginalGraphStringValue = graphThirdValue.getText();
			
				Thread.sleep(3000);
				
				try {
					if (OrginalTotStringValue.equalsIgnoreCase(OrginalGraphStringValue)) {
						
						Thread.sleep(3000);
					
						flag = true;
					
						System.out.println("Total value greater than zero and equal to the Graph value       <<<--//// Pass ////-->>>");

					}
					else {
					
						flag = false;
						System.out.println("Total value greater than zero and NOT equal to the Graph value       <<<--//// Fail ////-->>>");
					}
					
				}catch (Exception e) {
					flag = false;
				
					e.printStackTrace();
				}
				
			
			}
			else{
			
				Thread.sleep(3000);
			
				WebElement graphNoData = new WebDriverWait(driver, Duration.ofSeconds(100))
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='" + configReader.getProp("AR_Aging_Widget_chart") + "']/ancestor::div[@data-el='chartCard']//div[@data-el='noDataToShow']")));
			
				graphNoData.isDisplayed();
			
				System.out.println("Total less than or equal to zero and displaying NO DATA messege in dashboard widget.");
			
			}
		
		}catch (Exception e) {
			flag = false;
			
			e.printStackTrace();
		}
		return flag;
		

	}
	
}
