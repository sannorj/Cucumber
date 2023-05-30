package myP2_pageObjects;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ConstantsReader;
import utils.ElementUtils;

public class AR_Dashboard_LinkProperty_PageObject {
	
	private WebDriver driver;
	private ConstantsReader configReader = new ConstantsReader();
	boolean flag;
	ArrayList<String> firstArray;
	ArrayList<String> secondArray;
	
	
	public AR_Dashboard_LinkProperty_PageObject(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		firstArray = new ArrayList<>();
		secondArray = new ArrayList<>();
		
	}
	
	
	@FindBy(xpath = "//div[@data-el='appName']")
	WebElement header;

	@FindBy(xpath = "//input[@name='portfolio']")
	WebElement dropDownGroup;

	@FindBy(xpath = "//div[@role='listbox']//li")
	List<WebElement> lstDropDowGroup;
	
	@FindBy(xpath = "//tbody//tr//td[1]")
	List<WebElement> columnRaws;
	
	
	public void verifyGroupDropdown() throws InterruptedException {
		
		Thread.sleep(5000);

		ElementUtils.waitForElementToDisplay(header, 100);
		
		Thread.sleep(3000);

		WebElement drpGroup = new WebDriverWait(driver, Duration.ofSeconds(50))
				.until(ExpectedConditions.visibilityOf(dropDownGroup));

		drpGroup.click();
		for (int i = 0; i < lstDropDowGroup.size(); i++) {
			if (lstDropDowGroup.get(i).getText().equalsIgnoreCase(configReader.getProp("AR_dashBoard_GrpDropdown"))) {
				lstDropDowGroup.get(i).click();

			}
		}
		
		Thread.sleep(3000);

	}
	
	
	public void selectLinkPropertyValue() throws InterruptedException {

		Thread.sleep(2000);
		
		WebElement clickLinkActionEle = driver.findElement(By.xpath("//span[@data-el='linkActionsCNMTS']"));
			ElementUtils.waitForElementToDisplay(clickLinkActionEle, 100);
			
			clickLinkActionEle.click();
			
		
		Thread.sleep(3000);

	}
	
	public void verifyArPropertyPageHader() throws InterruptedException {

		Thread.sleep(2000);
		
		WebElement verifyArPropertyPageHaderEle = driver.findElement(By.xpath("//h1[contains(text(),'AR Aging Property')]"));
			ElementUtils.waitForElementToDisplay(verifyArPropertyPageHaderEle, 100);
			
		Thread.sleep(3000);

	}

	public void checkPropertyAndDate() throws InterruptedException {

		Thread.sleep(2000);
		
		WebElement checkPropertyValue = driver.findElement(By.xpath("//input[@name='hotelIds']"));
			ElementUtils.waitForElementToDisplay(checkPropertyValue, 100);
		
		Thread.sleep(2000);
			
		if (checkPropertyValue.getText().equalsIgnoreCase(configReader.getProp("AR_dashBoard_PropertyValue"))) {
			
			WebElement propertyValue = driver.findElement(By.xpath("//input[@value='" + configReader.getProp("AR_dashBoard_PropertyValue") + "']"));
			ElementUtils.waitForElementToDisplay(propertyValue, 100);

		}
			
		Thread.sleep(3000);
		
		WebElement checkDateValue = driver.findElement(By.xpath("//input[@type='tel']"));
		ElementUtils.waitForElementToDisplay(checkDateValue, 100);
		
		Thread.sleep(2000);
		
		if (checkDateValue.getText().equalsIgnoreCase(configReader.getProp("revenueDate"))) {
			
			WebElement dateValue = driver.findElement(By.xpath("//input[@value='" + configReader.getProp("revenueDate") + "']"));
			ElementUtils.waitForElementToDisplay(dateValue, 100);

		}
		
		Thread.sleep(3000);

	}
	
	public void clickGoButton() throws InterruptedException {

		Thread.sleep(2000);
		
		WebElement clickGoButtonEle = driver.findElement(By.xpath("//span[text()='Go']"));
			ElementUtils.waitForElementToDisplay(clickGoButtonEle, 100);
			
			clickGoButtonEle.click();
			
		Thread.sleep(3000);

	}
	
	public void saveValueToFirstArray() throws InterruptedException {

	
		Thread.sleep(5000);
		
		for (int x = 1; x <= columnRaws.size(); x++) {
			
			WebElement columnTextEle = driver.findElement(By.xpath("(//tbody//tr//td[1])["+ x +"]"));
			ElementUtils.waitForElementToDisplay(columnTextEle, 1000);
		
			firstArray.add(columnTextEle.getText());

			Thread.sleep(3000);
	
		}
	}
	
	public void saveValueToSecondArray() throws InterruptedException {

		
		Thread.sleep(5000);
		
		for (int y = 1; y <= columnRaws.size(); y++) {
			
			WebElement columnTextEle = driver.findElement(By.xpath("(//tbody//tr//td[1])["+ y +"]"));
			ElementUtils.waitForElementToDisplay(columnTextEle, 1000);
		
			secondArray.add(columnTextEle.getText());

			Thread.sleep(3000);
	
		}
	}
	
	
	public boolean comparingTwoRecArrays() throws InterruptedException {

		boolean flag = true;

		try {
			for (int i = 0; i <= firstArray.size(); i++) {

				String firstArrayVal = firstArray.get(i);
				String secondArrayVal = secondArray.get(i);

				if (firstArrayVal.equalsIgnoreCase(secondArrayVal)) {

					System.out.println("PASS");
					System.out.println(firstArray.get(i) + " <<<--////Pass////-->>> " + secondArray.get(i));

				} else {
					flag = false;
					System.out.println("Fail");
					System.out.println(firstArray.get(i) + " <<<--////fail////-->>> " + secondArray.get(i));

					//break;
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
		
	}
	
	
}
