package myP2_step_definitions;

import static org.junit.Assert.assertTrue;

import factory.DriverFactory;
import io.cucumber.java.en.*;
import myP2_pageObjects.AR_Dashboard_LinkProperty_PageObject;


public class AR_Dashboard_LinkProperty_StepDefinition {
	
	AR_Dashboard_LinkProperty_PageObject ARdashboardLP = new AR_Dashboard_LinkProperty_PageObject(DriverFactory.getDriver());
	
	
	@When("I select the group Value from the group dropdown section")
	public void i_select_the_group_value_from_the_group_dropdown_section() throws InterruptedException {
		ARdashboardLP.verifyGroupDropdown();
	}

	@When("user click on the CNMTS Property hyper-link action on AR dashboard table")
	public void user_click_on_the_cnmts_property_hyper_link_action_on_ar_dashboard_table() throws InterruptedException {
		ARdashboardLP.selectLinkPropertyValue();
	}

	@Then("user verify AR Property page header")
	public void user_verify_ar_property_page_header() throws InterruptedException {
		ARdashboardLP.verifyArPropertyPageHader();
	}

	@Then("Check Property dropdown field and date field on AR Property page")
	public void check_property_dropdown_field_and_date_field_on_ar_property_page() throws InterruptedException {
		ARdashboardLP.checkPropertyAndDate();
	}

	@Then("Observe the column values for a specific Property and save it in to the array")
	public void observe_the_column_values_for_a_specific_property_and_save_it_in_to_the_array() throws InterruptedException {
		ARdashboardLP.saveValueToFirstArray();
	}

	@Then("User click GO button")
	public void user_click_go_button() throws InterruptedException {
		ARdashboardLP.clickGoButton();
	}

	@Then("Observe the column values for the second time and save it in to the new array")
	public void observe_the_column_values_for_the_second_time_and_save_it_in_to_the_new_array() throws InterruptedException {
		ARdashboardLP.saveValueToSecondArray();
	}

	@Then("User compares the two arrays to check whether they are equal")
	public void user_compares_the_two_arrays_to_check_whether_they_are_equal() throws InterruptedException {
		assertTrue(ARdashboardLP.comparingTwoRecArrays());
	} 


}
