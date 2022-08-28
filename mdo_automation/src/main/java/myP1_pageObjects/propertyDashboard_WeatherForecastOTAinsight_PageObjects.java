package myP1_pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.ConstantsReader;

public class propertyDashboard_WeatherForecastOTAinsight_PageObjects {

	WebDriver driver;
	private ConstantsReader configReader = new ConstantsReader();

	public propertyDashboard_WeatherForecastOTAinsight_PageObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//section[@id='panel-WeatherWidget']")
	WebElement WeatherWidget;

	@FindBy(xpath = "//b[@id='aCelsius']")
	WebElement celsiusBtn;

	@FindBy(xpath = "//b[@id='afahrenheit']")
	WebElement fahrenheitBtn;

	@FindBy(xpath = "//div[@class='divCelsius show']")
	WebElement celsiusLoaded;

	@FindBy(xpath = "//div[@class='divfahrenheit show']")
	WebElement fahrenheitLoaded;

	@FindBy(xpath = "//section[@id='panel-OTAchart']")
	WebElement OTAinsightChart;

	@FindBy(xpath = "//section[@id='panel-OTAchart']//b[text()='Table']")
	WebElement OTAtbl;

	@FindBy(xpath = "//section[@id='panel-OTAchart']//b[text()='Chart']")
	WebElement OTAchart;

	@FindBy(xpath = "//div[@id='OTATableChart' and @style='display: block;']")
	WebElement OTAtblDisplay;

	@FindBy(xpath = "//div[@id='am-OTAChart' and contains(@style,'display: block;')]")
	WebElement OTAchartDisplay;

	@FindBy(xpath = "//section[@id='panel-OTAchart']//a[@title='Go to detail']")
	WebElement OTAchartGotoDetails;

	@FindBy(xpath = "//header[@class='page-header']//h2[text()='OTAInsight Detail']")
	WebElement OTAchartPageHeader;

	boolean cardAvailable = false;

	public boolean IsWeatherForecastLoadedInCelsius() throws InterruptedException {
		Thread.sleep(7000);
		WebElement viewChart = new WebDriverWait(driver, Duration.ofSeconds(50))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@id='panel-WeatherWidget']")));
		if (viewChart.isDisplayed()) {
			WebElement waitWeatherContainerLoaded = new WebDriverWait(driver, Duration.ofSeconds(100))
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='divWeatherContainer']")));
			cardAvailable = true;
			if (waitWeatherContainerLoaded.isDisplayed())
				celsiusBtn.click();
			Thread.sleep(2000);
			WebElement waitcelsiusLoaded = new WebDriverWait(driver, Duration.ofSeconds(50))
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='divCelsius show']")));
			if (waitcelsiusLoaded.isDisplayed())
				return true;
			else
				return false;
		} else {
			cardAvailable = false;
			System.out.println("Weather Forecast Card is not awailable");
			return true;
		}
	}

	public boolean IsWeatherForecastLoadedInFahrenheit() throws InterruptedException {
		WebElement viewChart = new WebDriverWait(driver, Duration.ofSeconds(50))
				.until(ExpectedConditions.visibilityOf(WeatherWidget));
		if (viewChart.isDisplayed()) {
			cardAvailable = true;
			fahrenheitBtn.click();
			Thread.sleep(2000);
			if (fahrenheitLoaded.isDisplayed())
				return true;
			else
				return false;
		} else {
			cardAvailable = false;
			System.out.println("Weather Forecast Card is not awailable");
			return true;
		}
	}

	// OTA Insight

	public boolean isOTAInsightTblLoaded() throws InterruptedException {
		WebElement viewTbl = new WebDriverWait(driver, Duration.ofSeconds(50))
				.until(ExpectedConditions.visibilityOf(OTAinsightChart));
		if (viewTbl.isDisplayed()) {
			cardAvailable = true;
			OTAtbl.click();
			OTAchart.click();
			OTAtbl.click();
			Thread.sleep(2000);
			if (OTAtblDisplay.isDisplayed())
				return true;
			else
				return false;
		} else {
			cardAvailable = false;
			System.out.println("OTA Insight Card is not awailable");
			return true;
		}
	}

	public boolean isOTAInsightChartLoaded() throws InterruptedException {
		WebElement viewChart = new WebDriverWait(driver, Duration.ofSeconds(50))
				.until(ExpectedConditions.visibilityOf(OTAinsightChart));
		if (viewChart.isDisplayed()) {
			cardAvailable = true;
			OTAchart.click();
			Thread.sleep(2000);
			if (OTAchartDisplay.isDisplayed()) {
				return true;
			} else {
				return false;
			}
		} else {
			cardAvailable = false;
			System.out.println("OTA Insight Card is not awailable");
			return true;
		}
	}

	public void clickOTAinsightgotoDetails() {
		WebElement viewChart = new WebDriverWait(driver, Duration.ofSeconds(50))
				.until(ExpectedConditions.visibilityOf(OTAinsightChart));
		if (viewChart.isDisplayed()) {
			cardAvailable = true;
			OTAchartGotoDetails.click();
		} else {
			cardAvailable = false;
			System.out.println("OTA Insight Card is not awailable");
		}
	}

	public boolean OTAinsightDisplayed() {
		if (cardAvailable) {
			WebElement OTAchartPgHeader = new WebDriverWait(driver, Duration.ofSeconds(50))
					.until(ExpectedConditions.visibilityOf(OTAchartPageHeader));
			System.out.println("Navigate to OTAInsight Detail Page: " + OTAchartPgHeader.isDisplayed());
			return OTAchartPgHeader.isDisplayed();
		} else {
			System.out.println("OTA Insight Card is not enabled to navigate to page");
			return true;
		}
	}

}
