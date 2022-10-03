package myP1_pageObjects;

import java.time.Duration;
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

public class scorecardDashboard_FilterOption_pageObjects {
	private WebDriver driver;
	private ConstantsReader configReader = new ConstantsReader();

	public scorecardDashboard_FilterOption_pageObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@id='formAddChartBody']//section//div[@class='form-group']//div//div[contains(@class,'switch switch-sm switch-success')]//div[@class='ios-switch on']//following-sibling::input[1]")
	List<WebElement> enabledChartsLst;

	public boolean verifyCardDataLoad() {
		boolean viewMonth = true;
		for (int i = 0; i < enabledChartsLst.size(); i++) {
			String cardFullName = enabledChartsLst.get(i).getAttribute("name");
			String cardName = cardFullName.replace("Scorecard", "");
			System.out.println("cardId=" + cardName);
			if (cardName.equalsIgnoreCase("STRWidget")) {
				viewMonth = new WebDriverWait(driver, Duration.ofSeconds(700)).until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//div[@id='sortablescorecard']//div//section[@id='panel-"
								+ cardName + "']//table//tbody//tr//td[text()='"
								+ configReader.getMYP1Prop("Scorecard_Month") + "']")))
						.isDisplayed();
				System.out.println("STR view month=" + viewMonth);
				if (!viewMonth)
					viewMonth = false;
			} else if (cardName.equalsIgnoreCase("ServiceWidget")) {
				viewMonth = new WebDriverWait(driver, Duration.ofSeconds(700)).until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//div[@id='sortablescorecard']//div//section[@id='panel-"
								+ cardName + "']//table//tbody//tr//td//b[text()='"
								+ configReader.getMYP1Prop("Scorecard_Month") + "']")))
						.isDisplayed();
				System.out.println("Service view month=" + viewMonth);
				if (!viewMonth)
					viewMonth = false;
			}
		}
		return viewMonth;
	}

	public boolean verifyWkMonthBtn() {
		boolean STRCardVisible = false;
		boolean allChartVisible = false;
		for (int i = 0; i < enabledChartsLst.size(); i++) {
			String cardFullName = enabledChartsLst.get(i).getAttribute("name");
			String cardName = cardFullName.replace("Scorecard", "");
			System.out.println("cardId=" + cardName);
			if (cardName.equalsIgnoreCase(configReader.getMYP1Prop("Scorecard_WkMonthCardId"))) {
				STRCardVisible = true;
			}
		}
		if (STRCardVisible) {
			WebElement weekBtn = driver
					.findElement(By.xpath("//h2[text()='" + configReader.getMYP1Prop("Scorecard_WkMonthCard")
							+ "']//preceding-sibling::div//b[text()='Week']"));
			try {
				JavascriptExecutor executor = (JavascriptExecutor) driver;
				executor.executeScript("arguments[0].click();", weekBtn);
			} catch (Exception e) {
				JavascriptExecutor executor = (JavascriptExecutor) driver;
				executor.executeScript("arguments[0].click();", weekBtn);
			}
//			weekBtn.click();
			boolean weekChartLoaded = new WebDriverWait(driver, Duration.ofSeconds(700))
					.until(ExpectedConditions.visibilityOfElementLocated(
							By.xpath("//h2[text()='" + configReader.getMYP1Prop("Scorecard_WkMonthCard")
									+ "']//preceding-sibling::div//following::div[@class='amcharts-main-div'][1]")))
					.isDisplayed();

			WebElement monthBtn = driver
					.findElement(By.xpath("//h2[text()='" + configReader.getMYP1Prop("Scorecard_WkMonthCard")
							+ "']//preceding-sibling::div//b[text()='Month']"));
			try {
				JavascriptExecutor executor = (JavascriptExecutor) driver;
				executor.executeScript("arguments[0].click();", monthBtn);
			} catch (Exception e) {
				JavascriptExecutor executor = (JavascriptExecutor) driver;
				executor.executeScript("arguments[0].click();", monthBtn);
			}
//			monthBtn.click();
			boolean monthChartLoaded = new WebDriverWait(driver, Duration.ofSeconds(700))
					.until(ExpectedConditions.visibilityOfElementLocated(
							By.xpath("//h2[text()='" + configReader.getMYP1Prop("Scorecard_WkMonthCard")
									+ "']//preceding-sibling::div//following::div[@class='amcharts-main-div'][1]")))
					.isDisplayed();
			if (weekChartLoaded == monthChartLoaded == true)
				allChartVisible = true;

			return allChartVisible;
		} else {
			System.out.println("card not visible!");
			return true;
		}
	}

}
