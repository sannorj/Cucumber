package myP2_pageObjects;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ConstantsReader;

public class ARDashboard_Slot_PageObject {
	private WebDriver driver;
	private ConstantsReader configReader = new ConstantsReader();
	boolean flag;
	String[] arrayDays = { "30 Days", "60 Days", "90 Days", "120 Days", "120+ Days" };
	String[] dashBoardDistributionDays;
	String[] dashBoardGrpahDays;
	ArrayList<String> distributionSlot;
	ArrayList<String> graphSlot;

	public ARDashboard_Slot_PageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		distributionSlot = new ArrayList<>();
		graphSlot = new ArrayList<>();
	}

	@FindBy(xpath = "//div[@data-el='chartCard'][2]//div//*[local-name()='text' and @overflow='hidden']")
	List<WebElement> lstchartValueDistributionDaySlots;

	@FindBy(xpath = "//div[@data-el='chartCard'][1]//div//*[local-name()='g' and @transform='translate(-19,10)' or @transform='translate(-22,10)' or @transform='translate(-24.5,10)' or @transform='translate(-25,10)']//*[local-name()='tspan']")
	List<WebElement> lstchartValueGrpahDaySlots;

	@FindBy(xpath = "//div[@data-el='chartCard'][2]//div//*[local-name()='text' and @y='13.333333969116211' or @y='14']")
	List<WebElement> lstDistributionRate;

	@FindBy(xpath = "//div[@data-el='chartCard'][1]//div//*[local-name()='text' and @overflow='hidden']//*[local-name()='tspan']")
	List<WebElement> lstGraphRate;

	public void captureDistributionSlotValues() throws InterruptedException {
		Thread.sleep(5000);

		System.out.println("Distribution Slot Size : " + lstchartValueDistributionDaySlots.size());

		Thread.sleep(5000);

		dashBoardDistributionDays = new String[lstchartValueDistributionDaySlots.size()];

		for (int i = 0; i < lstchartValueDistributionDaySlots.size(); i++) {

			dashBoardDistributionDays[i] = lstchartValueDistributionDaySlots.get(i).getText();
			// System.out.println("Values : " + chartValueDaySlots.get(i).getText());
		}

	}

	public boolean verifyDistributionSlotValues() {
		flag = false;

		for (int i = 0; i < arrayDays.length; i++) {

			System.out.println("Actual Distribution : " + arrayDays[i] + " Expected Distribution: "
					+ dashBoardDistributionDays[i]);

			if (arrayDays[i].equals(dashBoardDistributionDays[i])) {
				flag = true;
			} else {
				flag = false;
				break;
			}
		}

		return flag;
	}

	public void captureGrpahSlotValues() throws InterruptedException {
		Thread.sleep(5000);

		System.out.println("Grpah Y Axis Size : " + lstchartValueGrpahDaySlots.size());

		Thread.sleep(5000);

		dashBoardGrpahDays = new String[lstchartValueGrpahDaySlots.size()];

		for (int i = 0; i < lstchartValueGrpahDaySlots.size(); i++) {

			dashBoardGrpahDays[i] = lstchartValueGrpahDaySlots.get(i).getText();
		}

	}

	public boolean verifyGrpahSlotValues() {
		flag = false;

		for (int i = 0; i < arrayDays.length; i++) {

			System.out.println("Actual Graph: " + arrayDays[i] + " Expected Grpah: " + dashBoardGrpahDays[i]);

			if (arrayDays[i].equals(dashBoardGrpahDays[i])) {
				flag = true;
			} else {
				flag = false;
				break;
			}
		}

		return flag;
	}

	public void captureAndStoreDistributionValues() throws InterruptedException {

		Thread.sleep(5000);
		
		for (int i = 0; i < lstDistributionRate.size(); i++) {

			distributionSlot.add(lstDistributionRate.get(i).getText().replace("%", ""));
		}

		// for sout and print
		for (int i = 0; i < distributionSlot.size(); i++) {

			System.out.println("Before sort distribution rate :" + distributionSlot.get(i));
		}
	}

	public void captureAndStoreGrpahValues() {

		for (int i = 0; i < lstGraphRate.size(); i++) {

			graphSlot.add(lstGraphRate.get(i).getText().replace("%", ""));
		}

		// for sout and print
		for (int i = 0; i < graphSlot.size(); i++) {

			System.out.println("Before sort grpah rate :" + graphSlot.get(i));
		}
	}

	public boolean sortAndCompareRates() {

		Collections.sort(distributionSlot);
		Collections.sort(graphSlot);

		flag = false;

		System.out.println("Size of distributionSlot :"+distributionSlot.size());
		System.out.println("Size of graphSlot :"+graphSlot.size());
		
		if (distributionSlot.size() == graphSlot.size()) {
			for (int i = 0; i < distributionSlot.size(); i++) {

				System.out.println("After sort grpah rate :" + graphSlot.get(i));
				System.out.println("After sort distribution rate :" + distributionSlot.get(i));

				if (distributionSlot.get(i).equals(graphSlot.get(i))) {
					flag = true;
				} else {
					flag = false;
					break;

				}

			}
		}
		
		return flag;

	}

}
