package myP2_step_definitions;

import static org.junit.Assert.assertTrue;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import myP2_pageObjects.PnlTTM_PageObject;

public class PnlTTM_Step_Definition {
	PnlTTM_PageObject PnLTTMPo = new PnlTTM_PageObject(DriverFactory.getDriver());

	@And("I select the group {string} , property {string} , view {string}")
	public void I_select_the_group(String grp, String property, String view) {
		PnLTTMPo.passParameteres(grp, property, view);
	}

	@Then("Verify whether the header load according to TTM selected")
	public void verify_whether_the_header_load_according_to_ttm_selected() {
		assertTrue(PnLTTMPo.verifyTTMHeader());
	}

}
