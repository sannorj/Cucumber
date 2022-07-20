package myP2_pageObjects;

import java.time.Duration;
import java.util.Arrays;
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

public class Sales_Mapping_PageObjective {

	private WebDriver driver;

	private ConstantsReader configReader = new ConstantsReader();

	public Sales_Mapping_PageObjective(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[text()='AR Mapping']//ancestor::li")
	WebElement ARMapping;

	@FindBy(xpath = "//h1[text()='Sales Mapping']")
	WebElement navigatedSalesMappingPage;

	@FindBy(xpath = "//button//span//div[text()='Sales Mapping']")
	WebElement SalesMappingBtn;

	@FindBy(xpath = "//ul[@role='listbox']//li")
	List<WebElement> lstDropDowGroup;

	@FindBy(xpath = "//ul[@role='listbox']//li")
	List<WebElement> lstDropDowProperty;

	@FindBy(xpath = "//input[@name='portfolio-group']")
	WebElement group;

	@FindBy(xpath = "//input[@name='portfolio-hotel']")
	WebElement property;

	@FindBy(xpath = "//input[@name='keyword']")
	WebElement search;

	@FindBy(xpath = "//span[text()='Go']")
	WebElement goButton;

	@FindBy(xpath = "//button[@data-el='buttonGo']")
	WebElement btnRefresh;
	
	@FindBy(xpath = "//ul[@role='listbox']//li")
	List<WebElement> lstDropDowMappingTolst;

	String mulAccounts = configReader.getProp("Sales_BulkAccounts");
	List<String> mulAccountList = Arrays.asList(mulAccounts.split(","));

	@FindBy(xpath = "//button[@data-el='buttonMapTo']")
	WebElement buttonMapTo;

	@FindBy(xpath = "//div[@class='sc-jtJlRs kajoKa']//input")
	WebElement popupSearch;

	@FindBy(xpath = "//ul[@role='listbox']//li")
	List<WebElement> lstDropDowPopupAcc;

	@FindBy(xpath = "//button[@mdo_variant='success']")
	WebElement saveBtn;

	@FindBy(xpath = "//ul[@role='listbox']//li")
	List<WebElement> lstDropDowSalesManager;

	@FindBy(xpath = "//ul[@role='listbox']//li")
	List<WebElement> lstDropDowManagementStatus;

	public boolean landSalesMapping() throws InterruptedException {
		WebElement ARMappingEle = new WebDriverWait(driver, Duration.ofSeconds(20))
				.until(ExpectedConditions.visibilityOf(ARMapping));
		ARMappingEle.click();
		Thread.sleep(1500);
		SalesMappingBtn.click();
		WebElement SalesMappingPage = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.visibilityOf(navigatedSalesMappingPage));
		return SalesMappingPage.isDisplayed();
	}

	public void setOptions() throws InterruptedException {

		ElementUtils.waitForElementToDisplay(navigatedSalesMappingPage, 100);

		WebElement drpGroup = new WebDriverWait(driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.visibilityOf(group));

		drpGroup.click();
		Thread.sleep(2500);
		for (int i = 0; i < lstDropDowGroup.size(); i++) {
			if (lstDropDowGroup.get(i).getText().equalsIgnoreCase(configReader.getProp("Sales_Group"))) {
				lstDropDowGroup.get(i).click();

			}
		}

		Thread.sleep(1500);

		WebElement drpProperty = new WebDriverWait(driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.visibilityOf(property));
		drpProperty.click();
		Thread.sleep(2500);
		for (int i = 0; i < lstDropDowProperty.size(); i++) {
			if (lstDropDowProperty.get(i).getText().equalsIgnoreCase(configReader.getProp("Sales_Property"))) {
				lstDropDowProperty.get(i).click();

			}
		}
		goButton.click();
		Thread.sleep(2500);
//		btnRefresh.click();
//		Thread.sleep(7000);
	}

/////////////////Verify the search option functionality

	public void searchOptionInSales() throws InterruptedException {
		Thread.sleep(2000);
		search.sendKeys(Keys.CONTROL + "a");
		search.sendKeys(Keys.DELETE);
		search.sendKeys(configReader.getProp("Sales_Search"));
		Thread.sleep(3000);
	}

	public boolean searchOptionFilledInSales() {
		WebElement searchValue = driver.findElement(By.xpath("//div[contains(text(),'"
				+ configReader.getProp("Sales_Search") + "')]//parent::div[@class='sc-jOrMOR cCkmMG']"));

		WebElement ARMappingPage = new WebDriverWait(driver, Duration.ofSeconds(30))
				.until(ExpectedConditions.visibilityOf(searchValue));
		System.out.println("search value is diaplayed ======= " + ARMappingPage.isDisplayed());
		return ARMappingPage.isDisplayed();
	}

////////////////////Verify Single mapping Functionality

	public void mapSingleAcc() throws InterruptedException {
		Thread.sleep(2000);
		search.sendKeys(Keys.CONTROL + "a");
		search.sendKeys(Keys.DELETE);
		System.out.println("Search button clear");

		Thread.sleep(2000);

		WebElement singleCheck = driver.findElement(By.xpath("//div[text()='"
				+ configReader.getProp("Sales_SingleAccount") + "']//ancestor::td//following-sibling::td[@index='3']"));
		singleCheck.click();
		Thread.sleep(2000);
		for (int i = 0; i < lstDropDowMappingTolst.size(); i++) {
			if (lstDropDowMappingTolst.get(i).getText().equalsIgnoreCase(configReader.getProp("Sales_MappedTo"))) {
				lstDropDowMappingTolst.get(i).click();
			}
		}
		Thread.sleep(3500);
		System.out.println("check single Account");
	}

	public boolean checkAccountMapped() throws InterruptedException {
		Thread.sleep(3000);
		String singleCheckSelectedValue = driver
				.findElement(By.xpath("//div[text()='" + configReader.getProp("Sales_SingleAccount")
						+ "']//ancestor::td//following-sibling::td[@index='3']//child::input"))
				.getAttribute("value");
		Thread.sleep(3000);
		String MappedAccountVal = configReader.getProp("Sales_MappedTo");

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

	public boolean verifyRemoved() throws InterruptedException {
//		Thread.sleep(3000);
		WebElement singleRemovebtn = driver.findElement(By.xpath("//div[text()='"
				+ configReader.getProp("Sales_SingleAccount") + "']//ancestor::td//following-sibling::td[@index='6']"));
		Thread.sleep(5000);
		singleRemovebtn.click();

		Thread.sleep(4000);

		String currentValueOfRemovedAcc = driver
				.findElement(By.xpath("//div[text()='" + configReader.getProp("Sales_SingleAccount")
						+ "']//ancestor::td//following-sibling::td[@index='3']//child::input"))
				.getAttribute("value");

		Thread.sleep(6000);
		String defaultMappedToValue = configReader.getProp("Sales_Default_mappedTo");

		if (defaultMappedToValue.equalsIgnoreCase(currentValueOfRemovedAcc)) {
			System.out.println("removed account is same to default value === " + currentValueOfRemovedAcc);
			return true;
		} else {
			System.out.println("removed account doesn't match the default value  === " + currentValueOfRemovedAcc);
			return false;
		}
	}

	//////////////////// Verify bulk mapping Functionality

	public void slectAccounts() throws InterruptedException {
		Thread.sleep(5000);
		for (int i = 0; i < mulAccountList.size(); i++) {
			WebElement e = driver.findElement(By.xpath("//div[text()='" + mulAccountList.get(i)
					+ "']//ancestor::td//preceding-sibling::td[@index='0']//input"));
			e.click();
			Thread.sleep(4000);
			System.out.println("clicked bullet icon: " + mulAccountList.get(i));
		}
		buttonMapTo.click();
	}

	public void selectMappedToAcc() {
		popupSearch.click();
		for (int i = 0; i < lstDropDowPopupAcc.size(); i++) {
			if (lstDropDowPopupAcc.get(i).getText().equalsIgnoreCase(configReader.getProp("Sales_MappedTo"))) {
				lstDropDowPopupAcc.get(i).click();
			}
		}
		saveBtn.click();
	}

	public boolean verifyAccChanged() throws InterruptedException {
		Thread.sleep(6000);
		boolean flag = true;
		for (int i = 0; i < mulAccountList.size(); i++) {

			String currentValueOfAcc = driver
					.findElement(By.xpath("//div[text()='" + mulAccountList.get(i)
							+ "']//ancestor::td//following-sibling::td[@index='3']//child::input"))
					.getAttribute("value");
			Thread.sleep(4000);
			String mappedAccount = configReader.getProp("Sales_MappedTo");

			if (mappedAccount.equalsIgnoreCase(currentValueOfAcc)) {
				System.out.println("current account is same to added account value --- " + currentValueOfAcc);
			} else {
				System.out.println("current account doesn't match the added account value  --- " + currentValueOfAcc);
				flag = false;
			}
		}
		return flag;
	}

	public void removeAccounts() throws InterruptedException {
		for (int i = 0; i < mulAccountList.size(); i++) {
			WebElement removebtn = driver.findElement(By.xpath(
					"//div[text()='" + mulAccountList.get(i) + "']//ancestor::td//following-sibling::td[@index='6']"));
			Thread.sleep(3000);
			removebtn.click();
			Thread.sleep(3000);
		}
	}

	public boolean verifyAccRemoved() throws InterruptedException {
		Thread.sleep(4000);
		boolean flag = true;
		for (int i = 0; i < mulAccountList.size(); i++) {

			String currentValueOfAcc = driver
					.findElement(By.xpath("//div[text()='" + mulAccountList.get(i)
							+ "']//ancestor::td//following-sibling::td[@index='3']//child::input"))
					.getAttribute("value");
			Thread.sleep(4000);
			String defaultAcc = configReader.getProp("Sales_Default_mappedTo");

			if (defaultAcc.equalsIgnoreCase(currentValueOfAcc)) {
				System.out.println("current account is successfully removed ==== " + currentValueOfAcc);
			} else {
				System.out.println("current account doesn't match the default account value  === " + currentValueOfAcc);
				flag = false;
			}
		}
		return flag;
	}

	public boolean selectSalesManager() throws InterruptedException {
		WebElement salesManager = driver
				.findElement(By.xpath("//div[text()='" + configReader.getProp("Sales_SingleAccount")
						+ "']//ancestor::td//following-sibling::td[@index='4']//child::input//following-sibling::div//button"));
		Thread.sleep(7000);
		salesManager.click();

		for (int i = 0; i < lstDropDowSalesManager.size(); i++) {
			if (lstDropDowSalesManager.get(i).getText().equalsIgnoreCase(configReader.getProp("Sales_Manager"))) {
				lstDropDowSalesManager.get(i).click();
				System.out.println("oooooooooo"+ lstDropDowSalesManager.get(i).getText());
			}
		}
		Thread.sleep(4000);
		String selectedSalesManager = driver
				.findElement(By.xpath("//div[text()='" + configReader.getProp("Sales_SingleAccount")
						+ "']//ancestor::td//following-sibling::td[@index='4']//child::input"))
				.getAttribute("value");
		Thread.sleep(4000);
		String salesManagerVal=configReader.getProp("Sales_Manager");
		
		System.out.println("############################# ==== " + salesManagerVal);//Keri Walker

		if (salesManagerVal.equalsIgnoreCase(selectedSalesManager)) {
			System.out.println("sales manager successfully changed ==== " + selectedSalesManager);//Map Sales Manager
			return true;
		} else {
			System.out.println("sales manager doesn't updated  === " + selectedSalesManager);
			return false;
		}
	}

	public boolean removeSalesManager() throws InterruptedException {
		WebElement salesManager = driver
				.findElement(By.xpath("//div[text()='" + configReader.getProp("Sales_SingleAccount")
						+ "']//ancestor::td//following-sibling::td[@index='4']//child::input//following-sibling::div//button"));
		salesManager.click();
		Thread.sleep(4000);
		for (int i = 0; i < lstDropDowSalesManager.size(); i++) {
			if (lstDropDowSalesManager.get(i).getText().equalsIgnoreCase(configReader.getProp("default_Sales_Manager"))) {
				lstDropDowSalesManager.get(i).click();
			}
		}
		String currentSalesManager = driver
				.findElement(By.xpath("//div[text()='" + configReader.getProp("Sales_SingleAccount")
						+ "']//ancestor::td//following-sibling::td[@index='4']//child::input"))
				.getAttribute("value");
		Thread.sleep(4000);
		String defaultSalesManager = configReader.getProp("default_Sales_Manager");

		if (defaultSalesManager.equalsIgnoreCase(currentSalesManager)) {
			System.out.println("current Sales Manager is successfully removed ==== " + currentSalesManager);
			return true;
		} else {
			System.out.println("current Sales Manager doesn't match with default value ==== " + currentSalesManager);
			return false;
		}
	}

	public boolean selectManagementStatus() throws InterruptedException {
		WebElement managementStatus = driver
				.findElement(By.xpath("//div[text()='" + configReader.getProp("Sales_SingleAccount")
						+ "']//ancestor::td//following-sibling::td[@index='5']//child::input//following-sibling::div//button"));
		Thread.sleep(4000);
		managementStatus.click();

		for (int i = 0; i < lstDropDowManagementStatus.size(); i++) {
			if (lstDropDowManagementStatus.get(i).getText().equalsIgnoreCase(configReader.getProp("Management_Status"))) {
				lstDropDowManagementStatus.get(i).click();
				System.out.println("Management Status::::"+ lstDropDowManagementStatus.get(i).getText());
			}
		}
		Thread.sleep(4000);
		String selectedManagementStatus = driver
				.findElement(By.xpath("//div[text()='" + configReader.getProp("Sales_SingleAccount")
						+ "']//ancestor::td//following-sibling::td[@index='5']//child::input"))
				.getAttribute("value");
		Thread.sleep(4000);
		String managementStatusVal=configReader.getProp("Management_Status");
		
		System.out.println("Management Status value expect to select ==== " + managementStatusVal);

		if (managementStatusVal.equalsIgnoreCase(selectedManagementStatus)) {
			System.out.println("Management Status successfully changed ==== " + selectedManagementStatus);
			return true;
		} else {
			System.out.println("Management Status doesn't updated  === " + selectedManagementStatus);
			return false;
		}
	}

	public boolean removeManagementStatus() throws InterruptedException {
		WebElement managementStatus = driver
				.findElement(By.xpath("//div[text()='" + configReader.getProp("Sales_SingleAccount")
						+ "']//ancestor::td//following-sibling::td[@index='5']//child::input//following-sibling::div//button"));
		managementStatus.click();
		Thread.sleep(4000);
		for (int i = 0; i < lstDropDowManagementStatus.size(); i++) {
			if (lstDropDowManagementStatus.get(i).getText().equalsIgnoreCase(configReader.getProp("default_Management_Status"))) {
				lstDropDowManagementStatus.get(i).click();
			}
		}

		String currentManagementStatus = driver
				.findElement(By.xpath("//div[text()='" + configReader.getProp("Sales_SingleAccount")
						+ "']//ancestor::td//following-sibling::td[@index='5']//child::input"))
				.getAttribute("value");
		Thread.sleep(4000);
		String defaultManagementStatus = configReader.getProp("default_Management_Status");

		if (defaultManagementStatus.equalsIgnoreCase(currentManagementStatus)) {
			System.out.println("current Management Status is successfully removed ==== " + currentManagementStatus);
			return true;
		} else {
			System.out.println("current Management Status doesn't match with default value ==== " + currentManagementStatus);
			return false;
		}
	}

}
