package myP2_step_definitions;

import static org.junit.Assert.assertTrue;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import myP2_pageObjects.Guest_Ledger_PageObject;


public class GuestLedger_StepDefinition {
	
	private Guest_Ledger_PageObject GuestLedger = new Guest_Ledger_PageObject(DriverFactory.getDriver());
	
	@Given("go to the Guest Ledger")
	public void go_to_the_guest_ledger() throws InterruptedException {
	assertTrue(GuestLedger.navigateGuestLedgerFunc());
	}
	
	@Given("Select the organization as {string}")
	public void selest_the_organization_as(String org) throws InterruptedException {
		GuestLedger.selectOrgFunc(org);
	}


	@Given("Select the Group")
	public void select_the_group() throws InterruptedException {
		GuestLedger.selectParametersFunc();
	}

	@When("User Click on  Filter option")
	public void user_click_on_filter_option() throws InterruptedException {
		GuestLedger.clickOnFilterFunc();
	}

	@When("User selects the Marsha Code from the filter options")
	public void user_selects_the_marsha_code_from_the_filter_options() throws InterruptedException {
		GuestLedger.filterByMarshaCodeFunc();
	}

	@Then("Records should be filtered based on the Marsha Code")
	public void records_should_be_filtered_based_on_the_marsha_code() throws InterruptedException {
	    assertTrue(GuestLedger.verifyMarshadataFunc());
	}

	@Then("User selects the Type from the filter options after clicking the reset button.")
	public void user_selects_the_type_from_the_filter_options_after_clicking_the_reset_button() throws InterruptedException {
		GuestLedger.filterByTypeFunc();
	}

	@Then("Records should be filtered based on the Type")
	public void records_should_be_filtered_based_on_the_type() throws InterruptedException {
		assertTrue(GuestLedger.verifyTypedataFunc());
	}

	@Then("User selects the Group from the filter options after clicking the reset button.")
	public void user_selects_the_group_from_the_filter_options_after_clicking_the_reset_button() throws InterruptedException {
		GuestLedger.filterByGroupFunc();
	}

	@Then("Records should be filtered based on the Group")
	public void records_should_be_filtered_based_on_the_group() throws InterruptedException {
		assertTrue(GuestLedger.verifyGroupdataFunc());
	}

	@Then("User selects the D\\/B Code from the filter options after clicking the reset button.")
	public void user_selects_the_d_b_code_from_the_filter_options_after_clicking_the_reset_button() throws InterruptedException {
		GuestLedger.filterByDBCodeFunc();
	}

	@Then("Records should be filtered based on the D\\/B Code")
	public void records_should_be_filtered_based_on_the_d_b_code() throws InterruptedException {
		assertTrue(GuestLedger.verifyDBCodedataFunc());
	}

	@Then("User selects the Settlement type from the filter options after clicking the reset button.")
	public void user_selects_the_settlement_type_from_the_filter_options_after_clicking_the_reset_button() throws InterruptedException {
		GuestLedger.filterBySTFunc();
	}

	@Then("Records should be filtered based on the Settlement type")
	public void records_should_be_filtered_based_on_the_settlement_type() throws InterruptedException {
		assertTrue(GuestLedger.verifySTdataFunc());
	}

	@Then("User selects the Folio from the filter options after clicking the reset button.")
	public void user_selects_the_folio_from_the_filter_options_after_clicking_the_reset_button() throws InterruptedException {
		GuestLedger.filterByFolioFunc();
	}

	@Then("Records should be filtered based on the Folio")
	public void records_should_be_filtered_based_on_the_folio() throws InterruptedException {
		assertTrue(GuestLedger.verifyFolioDataFunc());
	}

	@Then("User selects the Arrival date from the filter options after clicking the reset button.")
	public void user_selects_the_arrival_date_from_the_filter_options_after_clicking_the_reset_button() throws InterruptedException {
		GuestLedger.filterByArrDateFunc();
	}

	@Then("Records should be filtered based on the Arrival date")
	public void records_should_be_filtered_based_on_the_arrival_date() throws InterruptedException {
		assertTrue(GuestLedger.verifyArrDateFunc());
	}

	@Then("User selects the Departure date from the filter options after clicking the reset button.")
	public void user_selects_the_departure_date_from_the_filter_options_after_clicking_the_reset_button() throws InterruptedException {
		GuestLedger.filterByDepDateFunc();
	}

	@Then("Records should be filtered based on the Departure date")
	public void records_should_be_filtered_based_on_the_departure_date() throws InterruptedException {
		assertTrue(GuestLedger.verifyDepDateFunc());
	}

	@Then("User enters OutStanding amount")
	public void user_enters_out_standing_amount() throws InterruptedException {
		GuestLedger.filterByOutStandGreaterFunc();
	}

	@Then("Records should be filtered based on the OutStanding amount")
	public void records_should_be_filtered_based_on_the_out_standing_amount() throws InterruptedException {
		assertTrue(GuestLedger.verifyOutStandGreater());
	}

	@Then("User enters Limit amount from the filter options")
	public void user_enters_limit_amount_from_the_filter_options() throws InterruptedException {
		GuestLedger.filterByLimitAmountFunc();
	}

	@Then("Records should be filtered based on the Limit amount")
	public void records_should_be_filtered_based_on_the_limit_amount() throws InterruptedException {
		assertTrue(GuestLedger.verifyLimitAmount());
	}
	
	@When("User inputs a parameter in the search field")
	public void user_inputs_a_parameter_in_the_search_field() throws InterruptedException {
		GuestLedger.inputSearchParameterFunc();
	}

	@Then("Table should load the results")
	public void table_should_load_the_results() throws InterruptedException {
		assertTrue(GuestLedger.verifySearchedParameterFunc());
	}



}
