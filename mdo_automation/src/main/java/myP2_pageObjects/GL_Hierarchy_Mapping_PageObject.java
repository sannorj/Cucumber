package myP2_pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.ConstantsReader;
import utils.ElementUtils;

public class GL_Hierarchy_Mapping_PageObject {
	
	boolean flag;
	private WebDriver driver;
	private ConstantsReader configReader = new ConstantsReader();

	public GL_Hierarchy_Mapping_PageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@role='listbox']//li")
	List <WebElement> listDrpValueSize;
	
	@FindBy(xpath = "//div/input[contains(@name, 'hotelId')]")
	WebElement drpProperty;
	
	@FindBy(xpath = "//th[text()='Display Name']")
	WebElement lblDisplyName;
	
	@FindBy(xpath = "//tr[@data-el]/td[1]")
	List<WebElement> listSection;
	
	@FindBy(xpath = "//tbody/tr")
	List<WebElement> listStaticValues;
	
	@FindBy(xpath = "(//button[@data-el='buttonAdd'])[1]")
	WebElement btnAddGlcode;
	
	@FindBy(xpath = "//h1[text()='Select GL Codes']")
	WebElement h1PopUpHeader;
	
	@FindBy(xpath = "//button[@title='Save']")
	WebElement btnSave;
	
	@FindBy(xpath = "(//button[@data-el='buttonAdd']/div//following-sibling::span)[1]")
	WebElement btnManageGLlbl;
	
	@FindBy(xpath = "//*[local-name()='svg' and @data-testid='CancelIcon']/*[local-name()='path']/..")
	List<WebElement> listGlcode;
	
	
	public void selectParametersFunc() throws InterruptedException {

		/* Select the appropriate Property value from the drop-down menu. */
		Thread.sleep(5000);
		WebElement drpGroupEle = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(drpProperty));
		drpGroupEle.click();
		ExpectedConditions.visibilityOf(listDrpValueSize.get(0));
		for (int i = 0; i < listDrpValueSize.size(); i++) {
			if (listDrpValueSize.get(i).getText().equalsIgnoreCase(configReader.getProp("GL_Map_Property"))) {
				listDrpValueSize.get(i).click();
			}
		}
		
		ElementUtils.waitForElementToDisplay(lblDisplyName, 100);
	}
	
	public boolean verifyMDOGlCodeFunc() {

		for (int x = 0; x < listStaticValues.size(); x++) {
			/* split and ready the data from property file */
			String[] a = configReader.getProp("GL_Map_MDO_Codes").split(",");
			for (int i = 0; i < a.length; i++) {
				String expected = a[i];
				String actual = listSection.get(x).getText();
				if (actual.contains(expected)) {
					flag = true;
				} else {
					flag = false;
				}
			}
		}
		return flag;
	}
	
	public boolean clcickAddGlCodeFunc() throws InterruptedException {

		String ManageGLCodelbl = btnManageGLlbl.getText();
		if (ManageGLCodelbl.equals("GL Codes")) {
			WebElement btnAddGlcodeEle = new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(btnAddGlcode));
			btnAddGlcodeEle.click();

			Thread.sleep(1500);
			WebElement h1PopUpHeaderEle = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(h1PopUpHeader));
			return h1PopUpHeaderEle.isDisplayed();

		} else {
			WebElement btnAddGlcodeEle = new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(btnAddGlcode));
			btnAddGlcodeEle.click();

			Thread.sleep(5000);
			int x = driver.findElements(By.xpath("//*[local-name()='svg' and @data-testid='CancelIcon']/*[local-name()='path']")).size();
			for (int i = 0; i < x; i++) {
				Thread.sleep(2000); 
				driver.findElement(By.xpath("(//*[local-name()='svg' and @data-testid='CancelIcon']/*[local-name()='path']/..)[1]")).click();	
				Thread.sleep(2000);
			}

			btnSave.click();
			Thread.sleep(2000);

			WebElement btnAddGlcodee = new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(btnAddGlcode));
			btnAddGlcodee.click();

			Thread.sleep(1500);
			WebElement h1PopUpHeaderEle = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(h1PopUpHeader));
			return h1PopUpHeaderEle.isDisplayed();

		}

	}
	
	public void selectSingleGlcodeFunc() throws InterruptedException {
	
		Thread.sleep(5000);
	
		WebElement singleGlEle= driver.findElement(By.xpath("//span[contains(text(),'"+configReader.getProp("GL_Map_S_Gl_code")+"')]/..//span/input"));
		singleGlEle.click();
		Thread.sleep(2000);
		
		btnSave.click();
		Thread.sleep(2000);
	}
	
	public boolean verifyAddLebelFunc() throws InterruptedException {

		Thread.sleep(2000);
		String ManageGLCodelbl = btnManageGLlbl.getText();

		if (ManageGLCodelbl.equals("Manage GL Codes")) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean clcickAddGlbuttonFunc() throws InterruptedException {

		
			WebElement btnAddGlcodeEle = new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(btnAddGlcode));
			btnAddGlcodeEle.click();

			Thread.sleep(1500);
			WebElement h1PopUpHeaderEle = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(h1PopUpHeader));
			return h1PopUpHeaderEle.isDisplayed();
		}
	
	public void RemoveSingleGlcodeFunc() throws InterruptedException {
		
		Thread.sleep(5000);
	
		
		int x = driver.findElements(By.xpath("//*[local-name()='svg' and @data-testid='CancelIcon']/*[local-name()='path']")).size();
		for (int i = 0; i < x; i++) {
			Thread.sleep(2000); 
			driver.findElement(By.xpath("(//*[local-name()='svg' and @data-testid='CancelIcon']/*[local-name()='path']/..)[1]")).click();	
			Thread.sleep(2000);
		}
		
		btnSave.click();
		Thread.sleep(2000);
	}
	
	
	public boolean verifyManageLebelFunc() throws InterruptedException {

		Thread.sleep(2000);
		String ManageGLCodelbl = btnManageGLlbl.getText();

		if (ManageGLCodelbl.equals("GL Codes")) {
			return true;
		} else {
			return false;
		}
	}
	
	public void selectMultipleGlcodeFunc() throws InterruptedException {
		
		Thread.sleep(5000);
		String[] a = configReader.getProp("GL_Map_M_Gl_code").split(",");
		
		for (int i = 0; i < a.length; i++) {
			String expected = a[i];
			WebElement singleGlEle= driver.findElement(By.xpath("//span[contains(text(),'"+expected+"')]/..//span/input"));
			singleGlEle.click();
			Thread.sleep(2000);
		}	
		btnSave.click();
		Thread.sleep(2000);
	}

}
