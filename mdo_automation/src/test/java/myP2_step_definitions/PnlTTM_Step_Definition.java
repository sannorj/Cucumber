package myP2_step_definitions;

import static org.junit.Assert.assertTrue;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import myP2_pageObjects.PnlTTM_PageObject;

public class PnlTTM_Step_Definition {
	PnlTTM_PageObject PnLTTMPo = new PnlTTM_PageObject(DriverFactory.getDriver());

	@And("I select the group,property,view")
	public void I_select_the_group() {
		PnLTTMPo.passParameteres();
	}

	@Then("Verify whether the header load according to TTM selected")
	public void verify_whether_the_header_load_according_to_ttm_selected() {
		assertTrue(PnLTTMPo.verifyTTMHeader());
	}

	@Then("I am navigate to PnL Yearly Edit Column")
	public void I_am_navigate_to_PnL_Yearly_Edit_Column() throws InterruptedException {
		PnLTTMPo.navigateToEditColumn();
	}

	@Then("Verify whether the year drodwon disabled")
	public void Verify_whether_the_year_drodwon_disabled() throws InterruptedException {
		assertTrue(PnLTTMPo.verifyDisabledColumn());
	}

	@Then("I am validating the month header")
	public void I_am_validating_the_month_header() throws InterruptedException {
		PnLTTMPo.storeReportMonthHeader();
	}

}
