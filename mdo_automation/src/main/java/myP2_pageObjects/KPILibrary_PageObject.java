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

public class KPILibrary_PageObject {

	boolean flag;
	private WebDriver driver;
	private ConstantsReader configReader = new ConstantsReader();
	String kpiNameForValidate, kpiDescriptionForValidate;

	public KPILibrary_PageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[text()='KPI Library']//ancestor::li")
	WebElement kpiLibrary;

	@FindBy(xpath = "//h1[text()='KPI Library']")
	WebElement kpiLibraryPage;

	@FindBy(xpath = "//button[@data-el='buttonAdd']")
	WebElement btnAdd;

	@FindBy(xpath = "//h1[text()='Create New KPI']")
	WebElement addPage;

	@FindBy(xpath = "//div[@role='button'][@aria-haspopup='listbox']")
	WebElement drpDwonKpi;

	@FindBy(xpath = "//ul[@role='listbox']//li")
	List<WebElement> lstKpi;

	@FindBy(xpath = "//input[@name='kpiName']")
	WebElement txtname;

	@FindBy(xpath = "//textarea[@name='kpiDescription']")
	WebElement txtDescription;

	@FindBy(xpath = "//textarea[@name='kpiFormula']")
	WebElement txtFormula;

	@FindBy(xpath = "//button[@type='button']//span[text()='Test']")
	WebElement btnTest;

	@FindBy(xpath = "//p[text()='Formula is correct']")
	WebElement lblResult;

	@FindBy(xpath = "//button[@type='button'][@id='save']")
	WebElement btnSave;

	@FindBy(xpath = "//div[contains(text(),'Successfully created')]")
	WebElement msgSuccess;

	@FindBy(xpath = "//input[@name='keyword']")
	WebElement txtSearch;

	@FindBy(xpath = "//tbody//tr")
	List<WebElement> lstItem;

	@FindBy(xpath = "//tbody//tr[1]//td[6]")
	WebElement btnExpand;

	@FindBy(xpath = "//ul[@role='menu']//li[6]")
	WebElement btnDelete;
	
	@FindBy(xpath = "//ul[@role='menu']//li[4]")
	WebElement btnEdit;

	@FindBy(xpath = "//h3[text()='Remove KPI']")
	WebElement confirmMessage;

	@FindBy(xpath = "//button[@type='button']//span[text()='Remove']")
	WebElement btnConfirmDelete;

	@FindBy(xpath = "//div[contains(text(),'Deleted')]")
	WebElement lblDeletemsg;

	@FindBy(xpath = "//button[@data-el='undefined-button']//span[text()='GL Code']")
	WebElement btnAddGLCode;

	@FindBy(xpath = "//button[@data-el='undefined-button']//span[text()='KPI']")
	WebElement btnAddKpi;

	@FindBy(xpath = "//button[@data-el='buttonAddOperator']//span[text()='Operator']")
	WebElement btnAddOperator;

	@FindBy(xpath = "//ul[@role='menu']//li//span[text()='Add (+)']")
	WebElement Operator;

	@FindBy(xpath = "//p[text()='Select MDO GL Code']")
	WebElement lblGLcodeEntry;

	@FindBy(xpath = "//ul[@data-level='1']//li[1]")
	WebElement btnGLCode1;

	@FindBy(xpath = "//ul[@data-level='1']//li[2]")
	WebElement btnGLCode2;
	
	@FindBy(xpath = "//h1[contains(text(),'Edit')]")
	WebElement editkpiLibraryPage;

	public boolean navigateToKPILibrary() {
		WebElement kpiLibraryEle = new WebDriverWait(driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.visibilityOf(kpiLibrary));
		kpiLibraryEle.click();

		WebElement kpiLibraryPageEle = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.visibilityOf(kpiLibraryPage));

		return kpiLibraryPageEle.isDisplayed();

	}

	public boolean navigateAddKPIPage() throws InterruptedException {

		Thread.sleep(5000);

		WebElement btnAddKpi = new WebDriverWait(driver, Duration.ofSeconds(50))
				.until(ExpectedConditions.visibilityOf(btnAdd));

		btnAddKpi.click();

		WebElement addPageEle = new WebDriverWait(driver, Duration.ofSeconds(25))
				.until(ExpectedConditions.visibilityOf(addPage));

		return addPageEle.isDisplayed();

	}

	public void selectParameters() throws InterruptedException {
		Thread.sleep(3000);

		WebElement drpdownKpi = new WebDriverWait(driver, Duration.ofSeconds(50))
				.until(ExpectedConditions.visibilityOf(drpDwonKpi));

		drpdownKpi.click();

		Thread.sleep(1500);

		for (int i = 0; i < lstKpi.size(); i++) {
			if (lstKpi.get(i).getText().equalsIgnoreCase(configReader.getProp("KpiType"))) {
				lstKpi.get(i).click();
			}
		}

		txtname.sendKeys(Keys.CONTROL + "a");
		txtname.sendKeys(Keys.DELETE);
		txtname.sendKeys(configReader.getProp("KPINameV"));

		txtDescription.sendKeys(Keys.CONTROL + "a");
		txtDescription.sendKeys(Keys.DELETE);
		txtDescription.sendKeys(configReader.getProp("KPIDescription"));

		Thread.sleep(2500);

	}

	public boolean verifyStaticFormula() throws InterruptedException {
		txtFormula.sendKeys(Keys.CONTROL + "a");
		txtFormula.sendKeys(Keys.DELETE);
		txtFormula.sendKeys(configReader.getProp("SampleFormula"));

		Thread.sleep(2500);

		btnTest.click();

		WebElement lblResultEle = new WebDriverWait(driver, Duration.ofSeconds(50))
				.until(ExpectedConditions.visibilityOf(lblResult));

		return lblResultEle.isDisplayed();

	}

	public boolean saveFormula() throws InterruptedException {

		btnSave.click();

		WebElement msgSuccessEle = new WebDriverWait(driver, Duration.ofSeconds(50))
				.until(ExpectedConditions.visibilityOf(msgSuccess));

		return msgSuccessEle.isDisplayed();
	}

	public boolean verifySavedFormula() throws InterruptedException {

		Thread.sleep(2500);

		WebElement txtSearchEle = new WebDriverWait(driver, Duration.ofSeconds(50))
				.until(ExpectedConditions.visibilityOf(txtSearch));

		txtSearchEle.isDisplayed();

		txtSearch.sendKeys(Keys.CONTROL + "a");
		txtSearch.sendKeys(Keys.DELETE);
		txtSearch.sendKeys(configReader.getProp("KPINameV"));

		Thread.sleep(2500);

		WebElement tmpName = driver.findElement(By.xpath("//tbody//tr[1]//td[1]"));
		WebElement tmpDescription = driver.findElement(By.xpath("//tbody//tr[1]//td[3]"));

		if (lstItem.size() > 0) {

			if (tmpName.getText().equalsIgnoreCase(configReader.getProp("KPINameV"))
					&& tmpDescription.getText().equalsIgnoreCase(configReader.getProp("KPIDescription"))) {
				flag = true;
			} else {
				flag = false;
			}
		} else {
			flag = false;
		}
		return flag;

	}

	public boolean searchKpiForDelete() throws InterruptedException {
		Thread.sleep(2000);

		txtSearch.sendKeys(Keys.CONTROL + "a");
		txtSearch.sendKeys(Keys.DELETE);
		txtSearch.sendKeys(configReader.getProp("KPINameV"));

		Thread.sleep(5000);

		if (lstItem.size() > 0) {
			WebElement btnExpandEle = new WebDriverWait(driver, Duration.ofSeconds(50))
					.until(ExpectedConditions.visibilityOf(btnExpand));

			btnExpandEle.click();

			WebElement btnDeleteEle = new WebDriverWait(driver, Duration.ofSeconds(50))
					.until(ExpectedConditions.visibilityOf(btnDelete));

			btnDeleteEle.click();

			Thread.sleep(1500);

			WebElement confirmMessageEle = new WebDriverWait(driver, Duration.ofSeconds(50))
					.until(ExpectedConditions.visibilityOf(confirmMessage));

			return confirmMessageEle.isDisplayed();

		} else {
			return false;
		}
	}

	public boolean confirmDelete() {

		WebElement btnConfirmDeleteEle = new WebDriverWait(driver, Duration.ofSeconds(50))
				.until(ExpectedConditions.visibilityOf(btnConfirmDelete));

		btnConfirmDeleteEle.click();

		WebElement lblDeletemsgEle = new WebDriverWait(driver, Duration.ofSeconds(50))
				.until(ExpectedConditions.visibilityOf(lblDeletemsg));

		return lblDeletemsgEle.isDisplayed();
	}

	public void selectParametersDynamically() throws InterruptedException {
		Thread.sleep(3000);

		WebElement drpdownKpi = new WebDriverWait(driver, Duration.ofSeconds(50))
				.until(ExpectedConditions.visibilityOf(drpDwonKpi));

		drpdownKpi.click();

		Thread.sleep(1500);

		for (int i = 0; i < lstKpi.size(); i++) {
			if (lstKpi.get(i).getText().equalsIgnoreCase(configReader.getProp("KpiTypeDynamic"))) {
				lstKpi.get(i).click();
			}
		}

		txtname.sendKeys(Keys.CONTROL + "a");
		txtname.sendKeys(Keys.DELETE);
		txtname.sendKeys(configReader.getProp("KPINameVDynamic"));

		txtDescription.sendKeys(Keys.CONTROL + "a");
		txtDescription.sendKeys(Keys.DELETE);
		txtDescription.sendKeys(configReader.getProp("KPIDescriptionDynamic"));

		Thread.sleep(2500);

	}

	public boolean createDynamicFormula() throws InterruptedException {

		btnAddGLCode.click();

		WebElement lblGLcodeEntryEle = new WebDriverWait(driver, Duration.ofSeconds(50))
				.until(ExpectedConditions.visibilityOf(lblGLcodeEntry));

		lblGLcodeEntryEle.isDisplayed();

		WebElement btnGLCode1Ele = new WebDriverWait(driver, Duration.ofSeconds(50))
				.until(ExpectedConditions.visibilityOf(btnGLCode1));

		btnGLCode1Ele.click();

		Thread.sleep(2500);

		btnAddOperator.click();

		Thread.sleep(1500);

		Operator.click();
		
		btnAddGLCode.click();

		lblGLcodeEntryEle.isDisplayed();

		WebElement btnGLCode2Ele = new WebDriverWait(driver, Duration.ofSeconds(50))
				.until(ExpectedConditions.visibilityOf(btnGLCode2));

		btnGLCode2Ele.click();

		btnTest.click();

		WebElement lblResultEle = new WebDriverWait(driver, Duration.ofSeconds(50))
				.until(ExpectedConditions.visibilityOf(lblResult));

		return lblResultEle.isDisplayed();

	}

	public boolean verifySavedDynamicFormula() throws InterruptedException {

		Thread.sleep(2500);

		WebElement txtSearchEle = new WebDriverWait(driver, Duration.ofSeconds(50))
				.until(ExpectedConditions.visibilityOf(txtSearch));

		txtSearchEle.isDisplayed();

		txtSearch.sendKeys(Keys.CONTROL + "a");
		txtSearch.sendKeys(Keys.DELETE);
		txtSearch.sendKeys(configReader.getProp("KPINameVDynamic"));

		Thread.sleep(2500);

		WebElement tmpName = driver.findElement(By.xpath("//tbody//tr[1]//td[1]"));
		WebElement tmpDescription = driver.findElement(By.xpath("//tbody//tr[1]//td[3]"));

		if (lstItem.size() > 0) {

			if (tmpName.getText().equalsIgnoreCase(configReader.getProp("KPINameVDynamic"))
					&& tmpDescription.getText().equalsIgnoreCase(configReader.getProp("KPIDescriptionDynamic"))) {
				flag = true;
			} else {
				flag = false;
			}
		} else {
			flag = false;
		}
		return flag;

	}
	
	public boolean searchKpiForEdit() throws InterruptedException {
		Thread.sleep(2000);

		txtSearch.sendKeys(Keys.CONTROL + "a");
		txtSearch.sendKeys(Keys.DELETE);
		txtSearch.sendKeys(configReader.getProp("KPINameVDynamic"));

		Thread.sleep(5000);

		if (lstItem.size() > 0) {
			WebElement btnExpandEle = new WebDriverWait(driver, Duration.ofSeconds(50))
					.until(ExpectedConditions.visibilityOf(btnExpand));

			btnExpandEle.click();

			WebElement btnEditEle = new WebDriverWait(driver, Duration.ofSeconds(50))
					.until(ExpectedConditions.visibilityOf(btnEdit));

			btnEditEle.click();

			Thread.sleep(1500);

			WebElement editkpiLibraryPageEle = new WebDriverWait(driver, Duration.ofSeconds(50))
					.until(ExpectedConditions.visibilityOf(editkpiLibraryPage));

			return editkpiLibraryPageEle.isDisplayed();
			

		} else {
			return false;
		}
	}
	
	public boolean editAndSaveFormula() throws InterruptedException
	{
		Thread.sleep(2500);
		
		txtname.sendKeys(Keys.CONTROL + "a");
		txtname.sendKeys(Keys.DELETE);
		txtname.sendKeys(configReader.getProp("KPINameVDynamic")+" Edited");

		txtDescription.sendKeys(Keys.CONTROL + "a");
		txtDescription.sendKeys(Keys.DELETE);
		txtDescription.sendKeys(configReader.getProp("KPIDescriptionDynamic")+" Edited");

		Thread.sleep(2500);
		
		btnTest.click();

		WebElement lblResultEle = new WebDriverWait(driver, Duration.ofSeconds(50))
				.until(ExpectedConditions.visibilityOf(lblResult));

		return lblResultEle.isDisplayed();
	}
	
	public boolean verifyEditedFormula() throws InterruptedException {

		Thread.sleep(2500);

		WebElement txtSearchEle = new WebDriverWait(driver, Duration.ofSeconds(50))
				.until(ExpectedConditions.visibilityOf(txtSearch));

		txtSearchEle.isDisplayed();

		txtSearch.sendKeys(Keys.CONTROL + "a");
		txtSearch.sendKeys(Keys.DELETE);
		txtSearch.sendKeys(configReader.getProp("KPINameVDynamic")+" Edited");

		Thread.sleep(2500);

		WebElement tmpName = driver.findElement(By.xpath("//tbody//tr[1]//td[1]"));
		WebElement tmpDescription = driver.findElement(By.xpath("//tbody//tr[1]//td[3]"));

		if (lstItem.size() > 0) {

			if (tmpName.getText().equalsIgnoreCase(configReader.getProp("KPINameVDynamic")+" Edited")
					&& tmpDescription.getText().equalsIgnoreCase(configReader.getProp("KPIDescriptionDynamic")+" Edited")) {
				flag = true;
			} else {
				flag = false;
			}
		} else {
			flag = false;
		}
		return flag;

	}
	
	public boolean searchDynamicEditedKpiForDelete() throws InterruptedException {
		Thread.sleep(2000);

		txtSearch.sendKeys(Keys.CONTROL + "a");
		txtSearch.sendKeys(Keys.DELETE);
		txtSearch.sendKeys(configReader.getProp("KPINameVDynamic")+" Edited");

		Thread.sleep(5000);

		if (lstItem.size() > 0) {
			WebElement btnExpandEle = new WebDriverWait(driver, Duration.ofSeconds(50))
					.until(ExpectedConditions.visibilityOf(btnExpand));

			btnExpandEle.click();

			WebElement btnDeleteEle = new WebDriverWait(driver, Duration.ofSeconds(50))
					.until(ExpectedConditions.visibilityOf(btnDelete));

			btnDeleteEle.click();

			Thread.sleep(1500);

			WebElement confirmMessageEle = new WebDriverWait(driver, Duration.ofSeconds(50))
					.until(ExpectedConditions.visibilityOf(confirmMessage));

			return confirmMessageEle.isDisplayed();

		} else {
			return false;
		}
	}

}
