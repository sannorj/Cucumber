package myP2_pageObjects;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.ConstantsReader;
import utils.ElementUtils;

public class AR_Mapping_PageObjective {

	private WebDriver driver;

	private ConstantsReader configReader = new ConstantsReader();

	public AR_Mapping_PageObjective(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[@data-el='menuToggle']")
	WebElement mainMenuButton;

	@FindBy(xpath = "//div[text()='Configuration']//ancestor::li")
	WebElement configuration;

	@FindBy(xpath = "//div[text()='Accounts Mapping']//ancestor::li")
	WebElement accountsMapping;

	@FindBy(xpath = "//a[text()='AR Mapping']//ancestor::li")
	WebElement ARMapping;

	@FindBy(xpath = "//h1[text()='AR Mapping']")
	WebElement navigatedARMappingPage;

	@FindBy(xpath = "//div[@role='listbox']//li")
	List<WebElement> lstDropDowGroup;

	@FindBy(xpath = "//div[@role='listbox']//li")
	List<WebElement> lstDropDowProperty;

	@FindBy(xpath = "//label[text()='Group']//following-sibling::div//input")
	WebElement group;

	@FindBy(xpath = "//label[text()='Property']//following-sibling::div//input")
	WebElement property;

	@FindBy(xpath = "//input[@name='keyword']")
	WebElement search;

	@FindBy(xpath = "//span[text()='Go']")
	WebElement goButton;

	@FindBy(xpath = "//span[text()='Source Account']")
	WebElement checkSourceAccount;

	@FindBy(xpath = "//div[@role='listbox']//li")
	List<WebElement> lstDropDowMappingTolst;

	String mulAccounts = configReader.getProp("AR_BulkAccounts");
	List<String> mulAccountList = Arrays.asList(mulAccounts.split(","));

	@FindBy(xpath = "//button[@data-el='buttonMapTo']")
	WebElement buttonMapTo;

	@FindBy(xpath = "(//label[text() = 'Search'])[2]/following-sibling::div//input") 
	WebElement popupSearch;

	@FindBy(xpath = "//div[@role='listbox']//li")
	List<WebElement> lstDropDowPopupAcc;

	@FindBy(xpath = "//button[@mdo_variant='success']")
	WebElement saveBtn;
	
	@FindBy(xpath = "//div[text()='Dashboard']//ancestor::li")
	WebElement dashboard;

	@FindBy(xpath = "//a[text()='Primary Dashboard (New)']//ancestor::li")
	WebElement primaryDashboard;

	public void expandAccountsMapping() {

		try {
			WebElement menu = new WebDriverWait(driver, Duration.ofSeconds(20))
					.until(ExpectedConditions.visibilityOf(mainMenuButton));
			menu.click();

			Thread.sleep(1500);

			WebElement configurationEle = new WebDriverWait(driver, Duration.ofSeconds(20))
					.until(ExpectedConditions.visibilityOf(configuration));
			configurationEle.click();

			WebElement accountsMappingEle = new WebDriverWait(driver, Duration.ofSeconds(20))
					.until(ExpectedConditions.visibilityOf(accountsMapping));
			accountsMappingEle.click();

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public boolean navigateToMappingPage() throws InterruptedException {

		WebElement ARMappingEle = new WebDriverWait(driver, Duration.ofSeconds(20))
				.until(ExpectedConditions.visibilityOf(ARMapping));
		ARMappingEle.click();
		Thread.sleep(1500);
		WebElement ARMappingPage = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.visibilityOf(navigatedARMappingPage));
		return ARMappingPage.isDisplayed();

	}

	public void setProperties() throws InterruptedException {

		ElementUtils.waitForElementToDisplay(navigatedARMappingPage, 200);

		WebElement drpGroup = new WebDriverWait(driver, Duration.ofSeconds(25))
				.until(ExpectedConditions.visibilityOf(group));

		drpGroup.click();
		Thread.sleep(2500);
		for (int i = 0; i < lstDropDowGroup.size(); i++) {
			if (lstDropDowGroup.get(i).getText().contains(configReader.getProp("AR_Group"))) {
				lstDropDowGroup.get(i).click();

			}
		}

		Thread.sleep(1500);

		WebElement drpProperty = new WebDriverWait(driver, Duration.ofSeconds(25))
				.until(ExpectedConditions.visibilityOf(property));
		drpProperty.click();
		Thread.sleep(2500);
		for (int i = 0; i < lstDropDowProperty.size(); i++) {
			if (lstDropDowProperty.get(i).getText().equalsIgnoreCase(configReader.getProp("AR_Property"))) {
				lstDropDowProperty.get(i).click();

			}
		}
		goButton.click();
		Thread.sleep(2500);
	}

	/* Verify the search option functionality */

	public void searchOption() throws InterruptedException {
		Thread.sleep(2000);
		search.sendKeys(Keys.CONTROL + "a");
		search.sendKeys(Keys.DELETE);
		search.sendKeys(configReader.getProp("AR_Search"));
		Thread.sleep(3000);
	}

	public boolean searchOptionFilled() {
		WebElement searchValue = driver.findElement(
				By.xpath("//div[contains(text(),'" + configReader.getProp("AR_Search") + "')]//parent::div"));

		WebElement ARMappingPage = new WebDriverWait(driver, Duration.ofSeconds(30))
				.until(ExpectedConditions.visibilityOf(searchValue));
		System.out.println("search value is diaplayed ======= " + ARMappingPage.isDisplayed());
		return ARMappingPage.isDisplayed();
	}
	

	/* Verify Single mapping Functionality */

	public void singleMapping() throws InterruptedException {
		Thread.sleep(2000);
		search.sendKeys(Keys.CONTROL + "a");
		search.sendKeys(Keys.DELETE);
		System.out.println("Search button clear");

		Thread.sleep(2000);

		WebElement singleCheck = new WebDriverWait(driver, Duration.ofSeconds(200)).until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[text()='" + configReader.getProp("AR_SingleAccount")
						+ "']//ancestor::td//following-sibling::td[@index='3']")));
		singleCheck.click();
		Thread.sleep(5000);
		for (int i = 0; i < lstDropDowMappingTolst.size(); i++) {
			System.out.println(lstDropDowMappingTolst.get(i).getText() + "**************");
			if (lstDropDowMappingTolst.get(i).getText().equalsIgnoreCase(configReader.getProp("AR_MappedTo"))) {
				lstDropDowMappingTolst.get(i).click();
			}
		}
		Thread.sleep(6000);
		System.out.println("check single Account");
		WebElement WaitTODataLoad = new WebDriverWait(driver, Duration.ofSeconds(200)).until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Source Account')]")));

	}

	public boolean accountIsSelected() throws InterruptedException {
		Thread.sleep(4000);
		WebElement singleCheckSelectedValueView = new WebDriverWait(driver, Duration.ofSeconds(200))
				.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//div[text()='" + configReader.getProp("AR_SingleAccount")
								+ "']//ancestor::td//following-sibling::td[@index='3']//child::input")));

		String singleCheckSelectedValue = driver
				.findElement(By.xpath("//div[text()='" + configReader.getProp("AR_SingleAccount")
						+ "']//ancestor::td//following-sibling::td[@index='3']//child::input"))
				.getAttribute("value");

		Thread.sleep(5000);
		String MappedAccountVal = configReader.getProp("AR_MappedTo");

		Thread.sleep(3000);

		if (MappedAccountVal.equalsIgnoreCase(singleCheckSelectedValue)) {
			System.out.println("The expected mappedaccount is same as actual single mapped account --- "
					+ singleCheckSelectedValue);
			return true;
		} else {
			System.out.println("The expected mappedaccount doesn't match the actual single mapped account --- "
					+ singleCheckSelectedValue);
			return false;
		}
	}

	public boolean removeMappedAccount() throws InterruptedException {
		Thread.sleep(3000);
		WebElement singleRemovebtn = driver.findElement(By.xpath("//div[text()='"
				+ configReader.getProp("AR_SingleAccount") + "']//ancestor::td//following-sibling::td[@index='4']"));
		Thread.sleep(6000);
		singleRemovebtn.click();

		Thread.sleep(3000);

		String currentValueOfRemovedAcc = driver
				.findElement(By.xpath("//div[text()='" + configReader.getProp("AR_SingleAccount")
						+ "']//ancestor::td//following-sibling::td[@index='3']//child::input"))
				.getAttribute("value");

		Thread.sleep(6000);
		String defaultMappedToValue = configReader.getProp("Default_mappedTo");

		if (defaultMappedToValue.equalsIgnoreCase(currentValueOfRemovedAcc)) {
			System.out.println("removed account is same to default value --- " + currentValueOfRemovedAcc);
			return true;
		} else {
			System.out.println("removed account doesn't match the default value  --- " + currentValueOfRemovedAcc);
			return false;
		}
	}

	/* Verify bulk mapping Functionality */

	public void selectFewAccounts() throws InterruptedException {
		Thread.sleep(7500);
		for (int i = 0; i < mulAccountList.size(); i++) {
			WebElement e = driver.findElement(By.xpath("//div[text()='" + mulAccountList.get(i)
					+ "']//ancestor::td//preceding-sibling::td[@index='0']//input"));
			e.click();
			Thread.sleep(7500);
			System.out.println("clicked bullet icon: " + mulAccountList.get(i));
		}
		buttonMapTo.click();
	}

	public void selectAccountFromPopup() throws InterruptedException {
		Thread.sleep(5000);
		popupSearch.click();
		for (int i = 0; i < lstDropDowPopupAcc.size(); i++) {
			if (lstDropDowPopupAcc.get(i).getText().equalsIgnoreCase(configReader.getProp("AR_MappedTo"))) {
				lstDropDowPopupAcc.get(i).click();
			}
		}
		saveBtn.click();
	}

	public boolean verifyAccountsChanged() throws InterruptedException {
		Thread.sleep(12000);
		boolean flag = true;
		for (int i = 0; i < mulAccountList.size(); i++) {

			String currentValueOfAcc = driver
					.findElement(By.xpath("//div[text()='" + mulAccountList.get(i)
							+ "']//ancestor::td//following-sibling::td[@index='3']//child::input"))
					.getAttribute("value");
			Thread.sleep(4000);
			String mappedAccount = configReader.getProp("AR_MappedTo");

			if (mappedAccount.equalsIgnoreCase(currentValueOfAcc)) {
				System.out.println("current account is same to added account value --- " + currentValueOfAcc);
			} else {
				System.out.println("current account doesn't match the added account value  --- " + currentValueOfAcc);
				flag = false;
			}
		}
		return flag;
	}

	public void removeMappedBulkAcc() throws InterruptedException {

		for (int i = 0; i < mulAccountList.size(); i++) {
			WebElement removebtn = driver.findElement(By.xpath(
					"//div[text()='" + mulAccountList.get(i) + "']//ancestor::td//following-sibling::td[@index='4']"));
			Thread.sleep(5000);
			removebtn.click();
			Thread.sleep(11500);
		}
	}

	public boolean verifyAllAccRemoved() throws InterruptedException {
		Thread.sleep(8000);
		boolean flag = true;
		for (int i = 0; i < mulAccountList.size(); i++) {

			String currentValueOfAcc = driver
					.findElement(By.xpath("//div[text()='" + mulAccountList.get(i)
							+ "']//ancestor::td//following-sibling::td[@index='3']//child::input"))
					.getAttribute("value");
			Thread.sleep(4000);
			String defaultAcc = configReader.getProp("Default_mappedTo");

			if (defaultAcc.equalsIgnoreCase(currentValueOfAcc)) {
				System.out.println("current account is successfully removed ==== " + currentValueOfAcc);
			} else {
				System.out.println("current account doesn't match the default account value  === " + currentValueOfAcc);
				flag = false;
			}
		}
		return flag;
	}

	// ** Smoke Testing **//

	public void selectDropdownInMain(String groupName, String propertyName) throws InterruptedException {

		WebElement drpGroup = new WebDriverWait(driver, Duration.ofSeconds(200))
				.until(ExpectedConditions.visibilityOf(group));

		drpGroup.click();
		Thread.sleep(2500);
		for (int i = 0; i < lstDropDowGroup.size(); i++) {
			if (lstDropDowGroup.get(i).getText().contains(groupName)) {
				lstDropDowGroup.get(i).click();
			}
		}
		Thread.sleep(1500);

		WebElement drpProperty = new WebDriverWait(driver, Duration.ofSeconds(200))
				.until(ExpectedConditions.visibilityOf(property));
		drpProperty.click();
		Thread.sleep(2500);
		for (int i = 0; i < lstDropDowProperty.size(); i++) {
			if (lstDropDowProperty.get(i).getText().equalsIgnoreCase(propertyName)) {
				lstDropDowProperty.get(i).click();
			}
		}
		WebElement propertyDataView = new WebDriverWait(driver, Duration.ofSeconds(200))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Property']")));
	}

	public void clckMenu() throws InterruptedException {
		mainMenuButton.click();
		Thread.sleep(3000);
	}
	
	//navigate to primary dash board when background got execution part in feature
	public void navigateToPrimaryDashboard() throws InterruptedException {
		mainMenuButton.click();
		
		WebElement btnDashboard = new WebDriverWait(driver, Duration.ofSeconds(50))
				.until(ExpectedConditions.visibilityOf(dashboard));
		
		btnDashboard.click();
		
		Thread.sleep(1500);
		
		WebElement waitPrimaryDashboard = new WebDriverWait(driver, Duration.ofSeconds(100))
				.until(ExpectedConditions.visibilityOf(primaryDashboard));
	
		waitPrimaryDashboard.click();
		
		Thread.sleep(5000);
	}
	
	public void clckConfigurationMenu(String mainMenu) throws InterruptedException{
		WebElement configuration = new WebDriverWait(driver, Duration.ofSeconds(200))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='"+mainMenu+"']//ancestor::li")));
		configuration.click();
		Thread.sleep(3000);
	}

	public void clckAccountsMappingMenu(String subMenu) throws InterruptedException {
		WebElement accountsMappingLink = new WebDriverWait(driver, Duration.ofSeconds(200))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='"+subMenu+"']//ancestor::li")));
		accountsMappingLink.click();
		Thread.sleep(3000);
	}

	public void clckARMappingMenu(String targetPage) throws InterruptedException {
		WebElement targetPageLink = new WebDriverWait(driver, Duration.ofSeconds(200))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='"+targetPage+"']//ancestor::li")));
		targetPageLink.click();
		Thread.sleep(3000);
	}

	public boolean verifyARMapping(String pageName) {
		boolean ARMappingPageLoad = new WebDriverWait(driver, Duration.ofSeconds(200))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='"+pageName+"']")))
				.isDisplayed();
		return ARMappingPageLoad;
	}

	public boolean verifyDropdown(String groupName, String propertyName) throws InterruptedException {
		boolean result = true;
		System.out.println("groupName="+groupName);
		System.out.println("propertyName="+propertyName);
		if(!"null".equals(groupName)) {
			WebElement drpGroup = new WebDriverWait(driver, Duration.ofSeconds(200))
					.until(ExpectedConditions.visibilityOf(group));
			String group = drpGroup.getAttribute("value");
			System.out.println(group);
			Thread.sleep(2500);
			if (!group.equalsIgnoreCase(groupName)) {
				result = false;
			}
			Thread.sleep(1500);
		}
		if(!"null".equals(propertyName)) {
			WebElement drpProperty = new WebDriverWait(driver, Duration.ofSeconds(200))
					.until(ExpectedConditions.visibilityOf(property));
			String property = drpProperty.getAttribute("value");
			System.out.println(property);
			Thread.sleep(2500);
			if (!property.equalsIgnoreCase(propertyName)) {
				result = false;
			}
		}
		return result;
	}

	public void clckGoBtn() throws InterruptedException {
		goButton.click();
		Thread.sleep(10000);
	}

	public boolean verifyPropertiesFiltered(String propertyName) {
		String propertyColIndexVal = new WebDriverWait(driver, Duration.ofSeconds(200))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Property']//parent::th")))
				.getAttribute("index");
		List<WebElement> propertyCellValues = driver.findElements(
				By.xpath("//td[@index='" + propertyColIndexVal + "']//div[text()='" + propertyName + "']"));
		boolean result = true;
		for (int i = 0; i < propertyCellValues.size(); i++) {
			if (!propertyCellValues.get(i).getText().equalsIgnoreCase(propertyName)) {
				result = false;
			}
		}
		return result;
	}

	public boolean verifyCheckBoxLoaded() {
		int noOfRaws = driver.findElements(By.xpath("//tr")).size();
		int CKboxCells = driver.findElements(By.xpath("//td[@index='0']//input[@type='checkbox']")).size();
		boolean result;
		if ((noOfRaws - 1) == CKboxCells) {
			result = true;
		} else {
			result = false;
		}
		return result;
	}

	public boolean verifyMappedTo() {
		int CKboxCells = driver.findElements(By.xpath("//td[@index='0']//input[@type='checkbox']")).size();
		String mappedToHeader = driver.findElement(By.xpath("//span[text()='Mapped To']//ancestor::th")).getAttribute("index");
		int mappedToRaws = driver.findElements(By.xpath("//td[@index='"+mappedToHeader+"']//input")).size();
		boolean result;
		if (CKboxCells == mappedToRaws) {
			result = true;
		} else {
			result = false;
		}
		return result;
	}

	public boolean verifyRemoveMapping() {
		int CKboxCells = driver.findElements(By.xpath("//td[@index='0']//input[@type='checkbox']")).size();
		String actionsHeader = driver.findElement(By.xpath("//th[text()='Actions']")).getAttribute("index");
		int actionsRaws = driver.findElements(By.xpath("//td[@index='"+actionsHeader+"']//span[text()='Remove Mapping']")).size();
		boolean result;
		if (CKboxCells == actionsRaws) {
			result = true;
		} else {
			result = false;
		}
		return result;
	}

	 

}
