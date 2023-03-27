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

public class Dashboard_DrowpdownValidation_PageObject {

	private WebDriver driver;
	private ConstantsReader configReader = new ConstantsReader();
	ArrayList<String> lstGroup, lstProperty, DashboardGroup, DasboardProperty;
	int Status; // =1 more groups =2 no group (only all)
	boolean flag;

	public Dashboard_DrowpdownValidation_PageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		lstGroup = new ArrayList<>();
		lstProperty = new ArrayList<>();
		DashboardGroup = new ArrayList<>();
		DasboardProperty = new ArrayList<>();
	}

	@FindBy(xpath = "//input[@name='porfolio-group']")
	WebElement dropDownGroup;

	@FindBy(xpath = "//div[@role='listbox']//li")
	List<WebElement> lstDropDowGroup;

	@FindBy(xpath = "//input[@name='porfolio-hotel']")
	WebElement dropDownProperty;

	@FindBy(xpath = "//div[@role='listbox']//li")
	List<WebElement> lstDropDowProperty;

	@FindBy(xpath = "//th[text()='Property']")
	WebElement lblProperty;

	@FindBy(xpath = "//th[text()='Groups']")
	WebElement lblGroups;

	@FindBy(xpath = "//button[@data-el='buttonCustomizeTable']")
	WebElement btnEditColumn;

	@FindBy(xpath = "//tr//td[1]//div[@class='sc-hlLBRy cQScgL']")
	List<WebElement> lstDashBoardValues;

	public void clickEdit() throws InterruptedException {
		WebElement btnEdit = new WebDriverWait(driver, Duration.ofSeconds(25))
				.until(ExpectedConditions.visibilityOf(btnEditColumn));

		btnEdit.click();

		WebElement drpGroup = new WebDriverWait(driver, Duration.ofSeconds(60))
				.until(ExpectedConditions.visibilityOf(dropDownGroup));

		drpGroup.click();

		if (lstDropDowGroup.size() == 1) {
			Status = 1;
			ElementUtils.waitForElementToDisplay(lblProperty, 60);
		} else {
			Status = 2;
			ElementUtils.waitForElementToDisplay(lblGroups, 60);
		}

		lstDropDowGroup.get(0).click();
	}

	public void validateAndStoreDropdownValues() throws InterruptedException {

		if (Status == 1) {

			System.out.println("Group = 1");
			ElementUtils.waitForElementToDisplay(lblProperty, 60);
			loadProeprty();
		}

		else if (Status == 2) {

			System.out.println("Group = >");
			ElementUtils.waitForElementToDisplay(lblGroups, 60);
			loadGroups();
		}

	}

	public void storeDashBoardGridValues() throws InterruptedException {
		if (Status == 1) {
			ElementUtils.waitForElementToDisplay(lblProperty, 60);
			for (int i = 0; i < lstDashBoardValues.size() - 1; i++) {
				DasboardProperty.add(lstDashBoardValues.get(i).getText());
			}

			for (int i = 0; i < DasboardProperty.size(); i++) {
				System.out.println("Dashboard Property = " + (i + 1) + ": " + DasboardProperty.get(i));
			}

		} else {
			ElementUtils.waitForElementToDisplay(lblGroups, 60);
			for (int i = 0; i < lstDashBoardValues.size() - 1; i++) {
				DashboardGroup.add(lstDashBoardValues.get(i).getText());
			}

			for (int i = 0; i < DashboardGroup.size(); i++) {
				System.out.println("Dashboard Groups = " + (i + 1) + ": " + DashboardGroup.get(i));
			}
		}
	}

	public void loadGroups() throws InterruptedException {

		Thread.sleep(2500);

		WebElement drpGroup = new WebDriverWait(driver, Duration.ofSeconds(60))
				.until(ExpectedConditions.visibilityOf(dropDownGroup));

		drpGroup.click();

		for (int i = 1; i < lstDropDowGroup.size(); i++) {
			lstGroup.add(lstDropDowGroup.get(i).getText());
		}

		System.out.println("Groups " + lstGroup.size());

		for (int i = 0; i < lstGroup.size(); i++) {

			System.out.println("G" + (i + 1) + " :" + lstGroup.get(i));
		}

		lstDropDowGroup.get(0).click();

	}

	public void loadProeprty() throws InterruptedException {

		Thread.sleep(2500);

		WebElement drpProperty = new WebDriverWait(driver, Duration.ofSeconds(25))
				.until(ExpectedConditions.visibilityOf(dropDownProperty));

		drpProperty.click();

		for (int i = 1; i < lstDropDowProperty.size(); i++) {
			lstProperty.add(lstDropDowProperty.get(i).getText());
		}

		System.out.println("Properties = " + lstProperty.size());

		for (int i = 0; i < lstProperty.size(); i++) {

			System.out.println("P " + (i + 1) + ":" + lstProperty.get(i));
		}

		lstDropDowProperty.get(0).click();
	}

	public boolean compareStoredGroupsAndProperties() {
		flag = false;

		if (Status == 1) {
			return compareProperty();
		} else {
			return compareGroups();
		}
	}

	public boolean compareProperty() {
		int falseCount = 0;

		for (int i = 0; i < DasboardProperty.size(); i++) {
			if (DasboardProperty.get(i).equals(lstProperty.get(i))) {
				flag = true;

			} else {
				flag = false;
				falseCount += 1;

			}

			System.out.println("==========================================");
			System.out.println("Dashboard prop : " + DasboardProperty.get(i));
			System.out.println("Dropdown  prop : " + lstProperty.get(i));
			System.out.println("Result :" + flag);
		}

		if (falseCount == 0) {
			return true;
		} else {
			return false;
		}
	}

	public boolean compareGroups() {
		int falseCount = 0;

		for (int i = 0; i < DashboardGroup.size(); i++) {
			if (DashboardGroup.get(i).equals(lstGroup.get(i))) {
				flag = true;

			} else {
				flag = false;
				falseCount += 1;

			}

			System.out.println("==========================================");
			System.out.println("Dashboard Grp : " + DashboardGroup.get(i));
			System.out.println("Dropdown  Grp : " + lstGroup.get(i));
			System.out.println("Result :" + flag);
		}

		if (falseCount == 0) {
			return true;
		} else {
			return false;
		}
	}

}
