package myP2_pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.ConstantsReader;

public class STR_Report_DataValidation_PageObjective {

	private WebDriver driver;
	private ConstantsReader configReader = new ConstantsReader();

	public STR_Report_DataValidation_PageObjective(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//label[text()='Date']//following::input")
	WebElement goButton;
	
	@FindBy(xpath = "//tbody//tr[2]/td[2]/div/div/div/div/div")
	WebElement firstCell;

	@FindBy(xpath = "//label[text()='Group']//following-sibling::div//input")
	WebElement group;

	@FindBy(xpath = "//label[text()='Property']//following-sibling::div//input")
	WebElement property;

	@FindBy(xpath = "//ul[@role='listbox']//li")
	List<WebElement> lstDropDowGroup;

	@FindBy(xpath = "//ul[@role='listbox']//li")
	List<WebElement> lstDropDowProperty;
	
	String firstCellValue=null;

	public void selectDate(String date) {
		goButton.sendKeys(Keys.CONTROL + "a");
		goButton.sendKeys(Keys.DELETE);
		goButton.sendKeys(date);
	}

	public void selectWeekButton(String weekVal) throws InterruptedException {
		WebElement selectWeekBtn = new WebDriverWait(driver, Duration.ofSeconds(1000))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button/div[text()='"+weekVal+"']")));
		selectWeekBtn.click();
		Thread.sleep(3000);
	}

	public void storeCell() {
		firstCellValue=firstCell.getText();
		System.out.println("First cell value of 4 week = "+firstCellValue);
	}

	public boolean compareCellValues() throws InterruptedException {
		String secondVal=firstCell.getText();
		if (secondVal.equalsIgnoreCase(firstCellValue)) {
			System.out.println("Both 4 week & 52 week first values are equals ==== " + secondVal +" /// "+ firstCellValue);
			Thread.sleep(3000);
			return true;
		}else {
			System.out.println("Both 4 week & 52 week first values are not equals ==== " + secondVal +" /// "+ firstCellValue);
			Thread.sleep(3000);
			return false; 
		}
	}

	public boolean compareDifPropertyValues() throws InterruptedException {
		String secondVal=firstCell.getText();
		System.out.println(firstCell.isDisplayed());
		
		WebElement tableOverlay = new WebDriverWait(driver, Duration.ofSeconds(1000))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-el='data-container']")));
		System.out.println(tableOverlay.getCssValue("opacity"));
		float tableOverlayVal=Float.parseFloat(tableOverlay.getCssValue("opacity"));
		if(1>tableOverlayVal) {
			System.out.println("Table view is Blurred.");
			Thread.sleep(3500);
			return true;
		}else {
			System.out.println("Table previous view is still display");
			Thread.sleep(3500);
			return false;
		}
	}

	public boolean selectOptions(String groupName, String propertyName) throws InterruptedException {
		boolean result = true;
		System.out.println("groupName=="+groupName);
		System.out.println("propertyName=="+propertyName);
		if(!"null".equals(groupName)) {
			WebElement drpGroup = new WebDriverWait(driver, Duration.ofSeconds(5000))
					.until(ExpectedConditions.visibilityOf(group));
//			String group = drpGroup.getAttribute("value");
//			System.out.println(group);
//			Thread.sleep(2500);
//			if (!group.contains(groupName)) {
//				result = false;
//			}
			drpGroup.click();
			Thread.sleep(2500);
			for (int i = 0; i < lstDropDowGroup.size(); i++) {
				if (lstDropDowGroup.get(i).getText().contains(groupName)) {
					lstDropDowGroup.get(i).click();
				}
			}
			
			Thread.sleep(1500);
		}
		if(!"null".equals(propertyName)) {
//			WebElement drpProperty = new WebDriverWait(driver, Duration.ofSeconds(5000))
//					.until(ExpectedConditions.visibilityOf(property));
//			String property = drpProperty.getAttribute("value");
//			System.out.println(property);
//			Thread.sleep(2500);
//			if (!property.equalsIgnoreCase(propertyName)) {
//				result = false;
//			}

			WebElement drpProperty = new WebDriverWait(driver, Duration.ofSeconds(5000))
					.until(ExpectedConditions.visibilityOf(property));
			drpProperty.click();
			Thread.sleep(2500);
			for (int i = 0; i < lstDropDowProperty.size(); i++) {
				if (lstDropDowProperty.get(i).getText().equalsIgnoreCase(propertyName)) {
					lstDropDowProperty.get(i).click();
				}
			}
		}
		return result;
	}

	public boolean slectLadingPageFilters(String groupName, String propertyName) throws InterruptedException {

		WebElement drpGroup = new WebDriverWait(driver, Duration.ofSeconds(5000))
				.until(ExpectedConditions.visibilityOf(group));

		drpGroup.click();
		Thread.sleep(2500);
		for (int i = 0; i < lstDropDowGroup.size(); i++) {
			if (lstDropDowGroup.get(i).getText().contains(groupName)) {
				lstDropDowGroup.get(i).click();
			}
		}

		Thread.sleep(1500);

		WebElement drpProperty = new WebDriverWait(driver, Duration.ofSeconds(5000))
				.until(ExpectedConditions.visibilityOf(property));
		drpProperty.click();
		Thread.sleep(2500);
		for (int i = 0; i < lstDropDowProperty.size(); i++) {
			if (lstDropDowProperty.get(i).getText().equalsIgnoreCase(propertyName)) {
				lstDropDowProperty.get(i).click();
			}
		}
		Thread.sleep(3000);
		return true;
		
	}
	
}
