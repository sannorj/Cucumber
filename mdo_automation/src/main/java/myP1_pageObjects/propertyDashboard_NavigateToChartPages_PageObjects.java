package myP1_pageObjects;

import java.time.Duration;

//import java.time.Duration;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.util.Assert;

import utils.ConstantsReader;
import utils.ElementUtils;

public class propertyDashboard_NavigateToChartPages_PageObjects {

	private WebDriver driver;

	private ConstantsReader configReader = new ConstantsReader();

	public propertyDashboard_NavigateToChartPages_PageObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//section[@id='panel-RevenueBreakdowan']//a[@title='View Large']")
	WebElement viewLargeRevenueBreakdown;

	@FindBy(xpath = "//div[@class='modal-dialog']//h4[contains(text(),'Revenue Breakdown')]")
	WebElement revenueBreakdownChartModal;

	@FindBy(xpath = "//div[@id='revenueBreakdownLargeChartModal']//button[@class='close']")
	WebElement revenueBdChartMdlClose;

	@FindBy(xpath = "//section[@id='panel-RevenueBreakdowan']//a[@title='Go to detail']")
	WebElement revenueBreakdownGotoDetails;

	@FindBy(xpath = "//header[@class='page-header']//h2[text()='Revenue Breakdown']")
	WebElement revenueBreakdownPageHeader;

	@FindBy(xpath = "//section[@id='panel-RevenueBreakdownMarketSuite']//a[@title='Go to detail']")
	WebElement marketSuiteShopGotoDetails;

	@FindBy(xpath = "//section[@id='panel-TotalExpenseBreakdown']//a[@title='Go to detail']")
	WebElement totalExpenseBreakdownGotoDetails;

	@FindBy(xpath = "//header[@class='page-header']//h2[text()='Total Expense Breakdown']")
	WebElement totalExpenseBreakdownPageHeader;

	@FindBy(xpath = "//section[@id='panel-ExpenseBudgetDepartment']//a[@title='Go to detail']")
	WebElement expenseBudgetDepartmentGotoDetails;

	@FindBy(xpath = "//header[@class='page-header']//h2[text()='Expense Form Budget vs. Actuals']")
	WebElement expenseBudgetDepartmentPageHeader;

	@FindBy(xpath = "//section[@id='panel-ExpenseBudgetCategory']//a[@title='Go to detail']")
	WebElement expenseBudgetCategoryGotoDetails;

	@FindBy(xpath = "//header[@class='page-header']//h2[text()='Expense Form Budget vs. Actuals']")
	WebElement expenseBudgetCategoryPageHeader;

	@FindBy(xpath = "//section[@id='panel-CashWidget']//a[@title='Go to detail']")
	WebElement cashWidgetGotoDetails;

	@FindBy(xpath = "//header[@class='page-header']//h2[text()='Cash Management Analysis']")
	WebElement cashWidgetPageHeader;

	@FindBy(xpath = "//section[@id='panel-ARAgingWidget']//a[@title='Go to detail']")
	WebElement ARAgingWidgetGotoDetails;

	@FindBy(xpath = "//header[@class='page-header']//h2[text()='AR Aging Detail']")
	WebElement ARAgingWidgetPageHeader;

	@FindBy(xpath = "//section[@id='panel-LaborWidgetWrapper']//a[@title='Go to detail']")
	WebElement laborWidgetGotoDetails;

	@FindBy(xpath = "//header[@class='page-header']//h2[text()='Labor']")
	WebElement laborWidgetPageHeader;

	@FindBy(xpath = "//section[@id='panel-STRWidget']//a[@title='Go to detail']")
	WebElement STRWidgetGotoDetails;

	@FindBy(xpath = "//header[@class='page-header']//h2[text()='STR Report']")
	WebElement STRWidgetPageHeader;

	boolean cardAvailable = false;

	// Revenue Breakdown page

	public void clickViewLarge() throws InterruptedException {
		Thread.sleep(7000);
		WebElement viewChart = new WebDriverWait(driver, Duration.ofSeconds(100))
				.until(ExpectedConditions.visibilityOf(viewLargeRevenueBreakdown));
		if (viewChart.isDisplayed()) {
			cardAvailable = true;
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", viewLargeRevenueBreakdown);
		} else {
			cardAvailable = false;
			System.out.println("Revenue Breakdown Page Card is not enabled");
		}
	}

	public boolean checkRBDchartDisplayed() throws InterruptedException {
		if (cardAvailable) {
			boolean isdisplayed = ElementUtils.waitForElementToDisplay(revenueBreakdownChartModal, 100);
			revenueBdChartMdlClose.click();
			System.out.println("Revenue Breakdown Chart popup closed ");
			Thread.sleep(3000);
			return isdisplayed;
		} else {
			System.out.println("Revenue Breakdown Chard is not enabled to view Chart");
			return true;
		}
	}

	public void clickRBDgotoDetails() throws InterruptedException {
		WebElement viewChart = new WebDriverWait(driver, Duration.ofSeconds(700))
				.until(ExpectedConditions.visibilityOf(revenueBreakdownGotoDetails));
		if (viewChart.isDisplayed()) {
			cardAvailable = true;
			System.out.println("revenueBreakdownGotoDetails" + cardAvailable);
			revenueBreakdownGotoDetails.click();
			System.out.println("clicked");
		} else {
			cardAvailable = false;
			System.out.println("Revenue Breakdown Page Card is not enabled");
		}
	}

	public boolean RBDpageIsDisplayed() throws InterruptedException {
		if (cardAvailable) {
			WebElement RBDPageHeader = new WebDriverWait(driver, Duration.ofSeconds(50))
					.until(ExpectedConditions.visibilityOf(revenueBreakdownPageHeader));
			System.out.println("Navigate to Revenue Breakdown page: " + RBDPageHeader.isDisplayed());
			return RBDPageHeader.isDisplayed();
		} else {
			System.out.println("Revenue Breakdown Card is not enabled to navigate to page");
			return true;
		}
	}

	// Market/Suite shop Page
	public void clickMarketSuiteShopGotoDetails() {
		WebElement viewChart = new WebDriverWait(driver, Duration.ofSeconds(700))
				.until(ExpectedConditions.visibilityOf(marketSuiteShopGotoDetails));
		if (viewChart.isDisplayed()) {
			cardAvailable = true;
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", marketSuiteShopGotoDetails);
		} else {
			cardAvailable = false;
			System.out.println("Market/Suite shop Page Card is not awailable");
		}
	}

	public boolean marketSuiteShopIsDisplayed() throws InterruptedException {
		Thread.sleep(7000);
		WebElement RBDPageHeader = new WebDriverWait(driver, Duration.ofSeconds(900))
				.until(ExpectedConditions.visibilityOf(revenueBreakdownPageHeader));
		System.out.println("Navigate to Market/Suite shop page: " + RBDPageHeader.isDisplayed());
		return RBDPageHeader.isDisplayed();
	}

	// Total Expense Breakdown Page

	public void totalExpenseBreakdownGotoDetails() throws InterruptedException {
		WebElement viewChart = new WebDriverWait(driver, Duration.ofSeconds(700))
				.until(ExpectedConditions.visibilityOf(totalExpenseBreakdownGotoDetails));
		if (viewChart.isDisplayed()) {
			cardAvailable = true;
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", totalExpenseBreakdownGotoDetails);
		} else {
			cardAvailable = false;
			System.out.println("Total Expense Breakdown Page Card is not awailable");
		}
	}

	public boolean totalExpenseBreakdownIsDisplayed() throws InterruptedException {
		if (cardAvailable) {
			WebElement totalExpenseBreakdownPgHeader = new WebDriverWait(driver, Duration.ofSeconds(500))
					.until(ExpectedConditions.visibilityOf(totalExpenseBreakdownPageHeader));
			System.out.println("Navigate to Total Expense Breakdown Page: " + totalExpenseBreakdownPgHeader.isDisplayed());
			return totalExpenseBreakdownPgHeader.isDisplayed();
		} else {
			System.out.println("Total Expense Breakdown Card is not enabled to navigate to page");
			return true;
		}
	}

	// Expense vs Budget By Department

	public void expensevsBudgetByDepartmentGotoDetails() {
		WebElement viewChart = new WebDriverWait(driver, Duration.ofSeconds(700))
				.until(ExpectedConditions.visibilityOf(expenseBudgetDepartmentGotoDetails));
		if (viewChart.isDisplayed()) {
			cardAvailable = true;
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", expenseBudgetDepartmentGotoDetails);
		} else {
			cardAvailable = false;
			System.out.println("Expense vs Budget By Department Page Card is not awailable");
		}
	}

	public boolean expensevsBudgetByDepartmentIsDisplayed() throws InterruptedException {
		if (cardAvailable) {
			WebElement expensevsBudgetByDepartmentPgHeader = new WebDriverWait(driver, Duration.ofSeconds(50))
					.until(ExpectedConditions.visibilityOf(expenseBudgetDepartmentPageHeader));
			System.out.println("Navigate to Expense vs Budget By Department Page: "
					+ expensevsBudgetByDepartmentPgHeader.isDisplayed());
			return expensevsBudgetByDepartmentPgHeader.isDisplayed();
		} else {
			System.out.println("Expense vs Budget By Department Card is not enabled to navigate to page");
			return true;
		}
	}

	// Expense vs Budget By Category Page

	public void expensevsBudgetByCategoryGotoDetails() throws InterruptedException {
		WebElement viewChart = new WebDriverWait(driver, Duration.ofSeconds(700))
				.until(ExpectedConditions.visibilityOf(expenseBudgetCategoryGotoDetails));
		if (viewChart.isDisplayed()) {
			cardAvailable = true;
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", expenseBudgetCategoryGotoDetails);
		} else {
			cardAvailable = false;
			System.out.println("Expense vs Budget By Category Page Card is not awailable");
		}
	}

	public boolean expensevsBudgetByCategoryIsDisplayed() throws InterruptedException {
		if (cardAvailable) {
			WebElement expenseBudgetCategoryPgHeader = new WebDriverWait(driver, Duration.ofSeconds(50))
					.until(ExpectedConditions.visibilityOf(expenseBudgetCategoryPageHeader));
			System.out.println(
					"Navigate to Expense vs Budget By Category Page: " + expenseBudgetCategoryPgHeader.isDisplayed());
			return expenseBudgetCategoryPgHeader.isDisplayed();
		} else {
			System.out.println("Expense vs Budget By Category Card is not enabled to navigate to page");
			return true;
		}
	}

	// Cash Collecting Widget Page

	public void cashWidgetGotoDetails() {
		WebElement viewChart = new WebDriverWait(driver, Duration.ofSeconds(700))
				.until(ExpectedConditions.visibilityOf(cashWidgetGotoDetails));
		if (viewChart.isDisplayed()) {
			cardAvailable = true;
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", cashWidgetGotoDetails);
		} else {
			cardAvailable = false;
			System.out.println("Cash Collecting Widget Page Card is not awailable");
		}
	}

	public boolean cashWidgetIsDisplayed() throws InterruptedException {
		if (cardAvailable) {
			WebElement cashWidgetPgHeader = new WebDriverWait(driver, Duration.ofSeconds(50))
					.until(ExpectedConditions.visibilityOf(cashWidgetPageHeader));
			System.out.println("Navigate to Cash Collecting Widget Page: " + cashWidgetPgHeader.isDisplayed());
			return cashWidgetPgHeader.isDisplayed();
		} else {
			System.out.println("Cash Collecting Widget Card is not enabled to navigate to page");
			return true;
		}
	}

	// AR Aging Detail Page

	public void ARAgingWidgetGotoDetails() {
		WebElement viewChart = new WebDriverWait(driver, Duration.ofSeconds(700))
				.until(ExpectedConditions.visibilityOf(ARAgingWidgetGotoDetails));
		if (viewChart.isDisplayed()) {
			cardAvailable = true;
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", ARAgingWidgetGotoDetails);
		} else {
			cardAvailable = false;
			System.out.println("AR Aging Detail Page Card is not awailable");
		}
	}

	public boolean ARAgingWidgetIsDisplayed() throws InterruptedException {
		if (cardAvailable) {
			WebElement ARAgingWidgetPgHeader = new WebDriverWait(driver, Duration.ofSeconds(50))
					.until(ExpectedConditions.visibilityOf(ARAgingWidgetPageHeader));
			System.out.println("Navigate to AR Aging Detail Page: " + ARAgingWidgetPgHeader.isDisplayed());
			return ARAgingWidgetPgHeader.isDisplayed();
		} else {
			System.out.println("AR Aging Detail Card is not enabled to navigate to page");
			return true;
		}
	}

	// Labor Widget Page

	public void LaborWidgetGotoDetails() {
		WebElement viewChart = new WebDriverWait(driver, Duration.ofSeconds(700))
				.until(ExpectedConditions.visibilityOf(laborWidgetGotoDetails));
		if (viewChart.isDisplayed()) {
			cardAvailable = true;
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", laborWidgetGotoDetails);
		} else {
			cardAvailable = false;
			System.out.println("Labor Widget Page Card is not awailable");
		}
	}

	public boolean LaborWidgetIsDisplayed() {
		if (cardAvailable) {
			WebElement laborWidgetPgHeader = new WebDriverWait(driver, Duration.ofSeconds(50))
					.until(ExpectedConditions.visibilityOf(laborWidgetPageHeader));
			System.out.println("Navigate to Labor Widget Page: " + laborWidgetPgHeader.isDisplayed());
			return laborWidgetPgHeader.isDisplayed();
		} else {
			System.out.println("Labor Widget Card is not enabled to navigate to page");
			return true;
		}
	}

	// STR Report Page

	public void STRWidgetGotoDetails() {
		WebElement viewChart = new WebDriverWait(driver, Duration.ofSeconds(700))
				.until(ExpectedConditions.visibilityOf(STRWidgetGotoDetails));
		if (viewChart.isDisplayed()) {
			cardAvailable = true;
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", STRWidgetGotoDetails);
		} else {
			cardAvailable = false;
			System.out.println("STR Report Page Card is not awailable");
		}
	}

	public boolean STRWidgetIsDisplayed() {
		if (cardAvailable) {
			WebElement STRWidgetPgHeader = new WebDriverWait(driver, Duration.ofSeconds(50))
					.until(ExpectedConditions.visibilityOf(STRWidgetPageHeader));
			System.out.println("Navigate to STR Report Page: " + STRWidgetPgHeader.isDisplayed());
			return STRWidgetPgHeader.isDisplayed();
		} else {
			System.out.println("STR Report Card is not enabled to navigate to page");
			return true;
		}
	}

}
