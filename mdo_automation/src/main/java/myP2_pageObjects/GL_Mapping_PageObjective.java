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
import utils.ElementUtils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GL_Mapping_PageObjective {
	
	private WebDriver driver;	
	private ConstantsReader configReader = new ConstantsReader();
	boolean flag;
	
	public GL_Mapping_PageObjective(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath = "//div[@data-el='selectorHotel']")
	WebElement drpProperty;
	
	@FindBy(xpath = "//div/a[text()='GL Mapping']//ancestor::li")
	WebElement glMapping;

	@FindBy(xpath = "//h1[text()='GL Mapping']")
	WebElement glMappingPage;
	
	@FindBy(xpath = "//button[@data-el='buttonAdd']")
	WebElement glCodeAddBt;
	
	@FindBy(xpath = "//h1[text()='Add GL Code']")
	WebElement addGlCodePage;
	
	@FindBy(xpath = "//th[text()='GL Code']")
	WebElement GLCodeHeader;
	
	@FindBy(xpath = "//div[text()='CNMTS']")
	WebElement propertyTextDisplay;
	
	@FindBy(xpath = "//div[@data-el='InputField-hmgGlCode']")
	WebElement glCodeFeild;
	
	@FindBy(xpath = "//input[@name='hmgGlCode']")
	WebElement glCodeText;

	@FindBy(xpath = "//div[@data-el='InputField-displayName']")
	WebElement DisplayNameFeild;
	
	@FindBy(xpath = "//input[@name='displayName']")
	WebElement DisplayNameText;
	
	@FindBy(xpath = "//input[@name='mdoGlCode']")
	WebElement mdoGLTextF;
	
	@FindBy(xpath = "//div//label[text() = 'MDO GL Code']//following-sibling::div[contains(@class, 'MuiInputBase-adornedEnd')]")
	WebElement MDOGLCodeDropDown;
	
	@FindBy(xpath = "//div[@role='listbox']//li")
	List <WebElement> listDrpValueSize;
	
	@FindBy(xpath = "//button[@data-el='buttonSave']")
	WebElement saveButton;
	
	@FindBy(xpath = "//div[@class='MuiAlert-message css-1xsto0d']")
	WebElement popupMsgDisplay;
	
	@FindBy(xpath = "//div[@data-el='searchInput']")
	WebElement SearchFeild;
	
	@FindBy(xpath = "//input[@name='keyword']")
	WebElement txtSearch;
	
	@FindBy(xpath = "//tbody//tr")
	List<WebElement> lstItem;
	
	@FindBy(xpath = "//div[1]/a//div[contains(@class, 'sc-gKPRtg caTOlm')]")
	WebElement glCodeEditBt;
	
	@FindBy(xpath = "//h1[text()='Edit GL Code']")
	WebElement editGlCodePage;
	
	@FindBy(xpath = "//div[2]/a//div[contains(@class, 'sc-gKPRtg caTOlm')]")
	WebElement glCodeDeleteBt;
	
	@FindBy(xpath = "//h3[contains(text(), 'Delete GL code')]")
	WebElement deleteGlCodePag;
	
	@FindBy(xpath = "//span[text()='Ok']")
	WebElement deleteBt;
	
	@FindBy(xpath = "//th[text()='GL Code']")
	WebElement lblGLCode;
	
	
	public boolean navigateToGLMapping() {
		
		WebElement glMappingEle = new WebDriverWait(driver, Duration.ofSeconds(25)).until(ExpectedConditions.visibilityOf(glMapping));
		glMappingEle.click();

		WebElement glMappingPageEle = new WebDriverWait(driver, Duration.ofSeconds(25)).until(ExpectedConditions.visibilityOf(glMappingPage));
		return glMappingPageEle.isDisplayed();

	}
	
	public void selectingSingleProperty() throws InterruptedException {
		
		Thread.sleep(5000);
		
		WebElement elelblGLCode = new WebDriverWait(driver, Duration.ofSeconds(50)).until(ExpectedConditions.visibilityOf(lblGLCode));
		elelblGLCode.isDisplayed();

		if (drpProperty.isEnabled()) {
			WebElement drpPropertyEle = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(drpProperty));
			drpPropertyEle.click();

			ExpectedConditions.visibilityOf(listDrpValueSize.get(0));
			for (int i = 0; i < listDrpValueSize.size(); i++) {
				if (listDrpValueSize.get(i).getText().equalsIgnoreCase(configReader.getProp("byRev_Single_Property"))) {
					listDrpValueSize.get(i).click();
				}
			}
		}
		
		Thread.sleep(3000);

		WebElement elelblGLCodeHeader = new WebDriverWait(driver, Duration.ofSeconds(50)).until(ExpectedConditions.visibilityOf(lblGLCode));
		elelblGLCodeHeader.isDisplayed();
		
		Thread.sleep(3000);

	}
	
	public boolean clickAddButt() throws InterruptedException {
		
		Thread.sleep(5000);
		
		WebElement eleGLCodeH = new WebDriverWait(driver, Duration.ofSeconds(50)).until(ExpectedConditions.visibilityOf(GLCodeHeader));
		eleGLCodeH.isDisplayed();
		
		
		if (glCodeAddBt.isEnabled()) {
			WebElement addButt = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(glCodeAddBt));
			addButt.click();
		}
		
		WebElement AddGlCodePageEle = new WebDriverWait(driver, Duration.ofSeconds(25)).until(ExpectedConditions.visibilityOf(addGlCodePage));
		return AddGlCodePageEle.isDisplayed();
		
	}

	public void createNewGlCode() throws InterruptedException {

		Thread.sleep(2000);
		
		WebElement propertyText = new WebDriverWait(driver, Duration.ofSeconds(25)).until(ExpectedConditions.visibilityOf(propertyTextDisplay));
		ElementUtils.waitForElementToDisplay(propertyText, 1000);
		
		WebElement glCodeFeildClick = new WebDriverWait(driver, Duration.ofSeconds(25)).until(ExpectedConditions.visibilityOf(glCodeFeild));
		glCodeFeildClick.click();
		
		glCodeText.sendKeys(Keys.CONTROL + "a");
		glCodeText.sendKeys(Keys.DELETE);
		glCodeText.sendKeys(configReader.getProp("GL_Code_No"));
		
		Thread.sleep(2000);
		
		WebElement DisplayNameFeildClick = new WebDriverWait(driver, Duration.ofSeconds(25)).until(ExpectedConditions.visibilityOf(DisplayNameFeild));
		DisplayNameFeildClick.click();
		
		DisplayNameText.sendKeys(Keys.CONTROL + "a");
		DisplayNameText.sendKeys(Keys.DELETE);
		DisplayNameText.sendKeys(configReader.getProp("Display_Name"));
		
		Thread.sleep(2000);
		
		if (MDOGLCodeDropDown.isEnabled()) {
			WebElement MDOGLCodeE = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(MDOGLCodeDropDown));
			MDOGLCodeE.click();
			
			Thread.sleep(5000);
			
			mdoGLTextF.sendKeys(Keys.CONTROL + "a");
			mdoGLTextF.sendKeys(Keys.DELETE);
			mdoGLTextF.sendKeys(configReader.getProp("mdoGLCode_GLM"));
			//mdoGLTextF.sendKeys(Keys.ARROW_DOWN);
			//mdoGLTextF.sendKeys(Keys.ENTER);
			
			listDrpValueSize.get(0).click();
		}
		
		Thread.sleep(15000);
		
		WebElement saveB = new WebDriverWait(driver, Duration.ofSeconds(25)).until(ExpectedConditions.visibilityOf(saveButton));
		saveB.click();
		
		Thread.sleep(7500);		
		ElementUtils.waitForElementContentToDisplay(glMappingPage, 25);
	}
	
	
	public boolean verifySavedGl() throws InterruptedException {

		Thread.sleep(3500);
		
		WebElement searchEle = new WebDriverWait(driver, Duration.ofSeconds(25)).until(ExpectedConditions.visibilityOf(SearchFeild));
		searchEle.isDisplayed();
		searchEle.click();

		txtSearch.sendKeys(Keys.CONTROL + "a");
		txtSearch.sendKeys(Keys.DELETE);
		txtSearch.sendKeys(configReader.getProp("GL_Code_No"));

		Thread.sleep(2500);

		WebElement GlNo = driver.findElement(By.xpath("//tbody//tr[1]//td[1]"));
		WebElement disName = driver.findElement(By.xpath("//tbody//tr[1]//td[2]"));

		if (lstItem.size() > 0) {

			if (GlNo.getText().equalsIgnoreCase(configReader.getProp("GL_Code_No"))
					&& disName.getText().equalsIgnoreCase(configReader.getProp("Display_Name"))) {
				flag = true;
			} else {
				flag = false;
			}
		} else {
			flag = false;
		}
		return flag;

	}
	
	public boolean clickEditButt() throws InterruptedException {
		
		Thread.sleep(5000);
		
		if (glCodeEditBt.isEnabled()) {
			WebElement editButt = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(glCodeEditBt));
			editButt.click();
		}
		
		WebElement editGlCodePageEle = new WebDriverWait(driver, Duration.ofSeconds(25)).until(ExpectedConditions.visibilityOf(editGlCodePage));
		return editGlCodePageEle.isDisplayed();
		
	}
	
	public void editGlCode() throws InterruptedException {

		Thread.sleep(5000);
		
		WebElement glCodeFeildClick = new WebDriverWait(driver, Duration.ofSeconds(25)).until(ExpectedConditions.visibilityOf(glCodeFeild));
		glCodeFeildClick.click();
		
		glCodeText.sendKeys(Keys.CONTROL + "a");
		glCodeText.sendKeys(Keys.DELETE);
		glCodeText.sendKeys(configReader.getProp("Update_GL_Code_No"));
		
		Thread.sleep(2000);
		
		WebElement DisplayNameFeildClick = new WebDriverWait(driver, Duration.ofSeconds(25)).until(ExpectedConditions.visibilityOf(DisplayNameFeild));
		DisplayNameFeildClick.click();
		
		DisplayNameText.sendKeys(Keys.CONTROL + "a");
		DisplayNameText.sendKeys(Keys.DELETE);
		DisplayNameText.sendKeys(configReader.getProp("Update_Display_Name"));
		
		Thread.sleep(5000);
		
		WebElement saveB = new WebDriverWait(driver, Duration.ofSeconds(25)).until(ExpectedConditions.visibilityOf(saveButton));
		saveB.click();
		
		
	}
	
	public boolean verifyEditedGl() throws InterruptedException {

		Thread.sleep(3500);
		
		WebElement GLCodeH = new WebDriverWait(driver, Duration.ofSeconds(25)).until(ExpectedConditions.visibilityOf(GLCodeHeader));
		GLCodeH.isDisplayed();
		
		WebElement searchEle = new WebDriverWait(driver, Duration.ofSeconds(25)).until(ExpectedConditions.visibilityOf(SearchFeild));
		searchEle.isDisplayed();
		searchEle.click();

		txtSearch.sendKeys(Keys.CONTROL + "a");
		txtSearch.sendKeys(Keys.DELETE);
		txtSearch.sendKeys(configReader.getProp("Update_GL_Code_No"));

		Thread.sleep(2500);

		WebElement GlNo = driver.findElement(By.xpath("//tbody//tr[1]//td[1]"));
		WebElement disName = driver.findElement(By.xpath("//tbody//tr[1]//td[2]"));

		if (lstItem.size() > 0) {

			if (GlNo.getText().equalsIgnoreCase(configReader.getProp("Update_GL_Code_No"))
					&& disName.getText().equalsIgnoreCase(configReader.getProp("Update_Display_Name"))) {
				flag = true;
			} else {
				flag = false;
			}
		} else {
			flag = false;
		}
		return flag;

	}
	
	public boolean clickDeleteButt() throws InterruptedException {
		
		Thread.sleep(5000);
		
		if (glCodeDeleteBt.isEnabled()) {
			WebElement deleteButt = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(glCodeDeleteBt));
			deleteButt.click();
		}
		
		WebElement deleteGlCodePageEle = new WebDriverWait(driver, Duration.ofSeconds(25)).until(ExpectedConditions.visibilityOf(deleteGlCodePag));
		return deleteGlCodePageEle.isDisplayed();
		
	}
	
	public void dleteGl() throws InterruptedException {
		
		Thread.sleep(5000);
		
		if (deleteBt.isEnabled()) {
			WebElement deleteGlBut = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(deleteBt));
			deleteGlBut.click();
		}
		
		Thread.sleep(3500);
		
		WebElement searchEle = new WebDriverWait(driver, Duration.ofSeconds(25)).until(ExpectedConditions.visibilityOf(SearchFeild));
		searchEle.isDisplayed();
		searchEle.click();

		txtSearch.sendKeys(Keys.CONTROL + "a");
		txtSearch.sendKeys(Keys.DELETE);

		Thread.sleep(3500);

		
	}

}
