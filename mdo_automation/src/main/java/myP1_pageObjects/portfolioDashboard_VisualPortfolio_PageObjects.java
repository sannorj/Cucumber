package myP1_pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.ConstantsReader;

public class portfolioDashboard_VisualPortfolio_PageObjects {
	
	private WebDriver driver;
	private ConstantsReader configReader = new ConstantsReader();
	
	public portfolioDashboard_VisualPortfolio_PageObjects(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}


	@FindBy(xpath = "//a[@id='alinkvisportfolio']")
	WebElement visualPortfolioBtn;

	@FindBy(xpath = "//h2[text()='Visual Portfolio']")
	WebElement visualPortfolioPg;
	
	public void clickVisualPortfolioBtn() {
		visualPortfolioBtn.click();
	}

	public boolean landToVPpage() {
		WebElement waittoBtnAddComment = new WebDriverWait(driver, Duration.ofSeconds(700))
				.until(ExpectedConditions.visibilityOf(visualPortfolioPg));
		return true;
	}

}
