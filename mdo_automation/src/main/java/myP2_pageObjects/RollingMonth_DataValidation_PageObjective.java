package myP2_pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ConstantsReader;

public class RollingMonth_DataValidation_PageObjective {

	private WebDriver driver;
	private ConstantsReader configReader = new ConstantsReader();

	public RollingMonth_DataValidation_PageObjective(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[text()='Please select your filters and click the Go button']")
	WebElement emptyPage;
	
	public boolean verifyDataNotView() {
		return emptyPage.isDisplayed();
	}

}
