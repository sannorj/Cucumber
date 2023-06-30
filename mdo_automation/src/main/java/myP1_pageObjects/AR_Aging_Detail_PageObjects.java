package myP1_pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
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

	public void clickOnLink(String LinkName) throws InterruptedException {
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

	public boolean selectHotel() throws InterruptedException {
		hotelNameSelect.click();
		Thread.sleep(3000);
		for (int i = 0; i < lstDropDowHotel.size(); i++) {
			if (lstDropDowHotel.get(i).getText().equalsIgnoreCase(configReader.getMYP1Prop("AR_Aging_Detail_Hotel"))) {
				System.out.println("HOtel list item ===" + lstDropDowHotel.get(i).getText());
				lstDropDowHotel.get(i).click();
			}
		}
		return true;
	}

}
