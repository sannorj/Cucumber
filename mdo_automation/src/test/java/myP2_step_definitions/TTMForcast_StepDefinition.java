package myP2_step_definitions;

import static org.junit.Assert.assertTrue;

import factory.DriverFactory;
import io.cucumber.java.en.Then;
import myP2_pageObjects.*;

public class TTMForcast_StepDefinition {

	TTMForcast_PageObject TTMPo = new TTMForcast_PageObject(DriverFactory.getDriver());
	
	
	@Then("I select the group,property,view in TTM")
	public void I_select_the_group_property_viewin_TTM() {
		TTMPo.passParameteres();
	}
	
	@Then("I am storing the TTM forcast data")
	public void I_am_storing_the_TTM_forcast_data() {
		TTMPo.storeTTMForcastData();
	}
	
	@Then("I am storing the actual forcast data")
	public void I_am_storing_the_actual_forcast_data() {
		TTMPo.storeactualForcastData();
	}
	@Then("I compare the stored forcast data")
	public void I_compare_the_stored_forcast_data() {
		assertTrue(TTMPo.compareForcastData());
	}
	
}
