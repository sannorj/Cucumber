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

	@Then("I am verify whether the edit column dropdown count in one")
	public void I_am_verify_whether_the_edit_column_dropdown_count_in_one() throws InterruptedException {
		assertTrue(PnLTTMPo.verifyColumnDropdownCount());
	}
	
	@Then("I am Verify whether the month selected as previous month")
	public void I_am_Verify_whether_the_month_selected_as_previous_month() throws InterruptedException {
		assertTrue(PnLTTMPo.verifySelectedMonth());
	}

	@Then("I am validating the month header")
	public void I_am_validating_the_month_header() throws InterruptedException {
		PnLTTMPo.storeReportMonthHeader();
	}

	@And("Select {string} option")
	public void select_option(String string) throws InterruptedException {
		PnLTTMPo.selectYear(string);
	}

}
