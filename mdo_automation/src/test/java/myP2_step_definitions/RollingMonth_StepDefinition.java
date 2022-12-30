package myP2_step_definitions;

import static org.junit.Assert.assertTrue;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import myP2_pageObjects.RollingMonth_DataValidation_PageObjective;
import myP2_pageObjects.RollingMonth_PageObject;

public class RollingMonth_StepDefinition {
	
	private RollingMonth_PageObject rollingMonth =new RollingMonth_PageObject(DriverFactory.getDriver());
	private RollingMonth_DataValidation_PageObjective rollingMonth_DV =new RollingMonth_DataValidation_PageObjective(DriverFactory.getDriver());

	@Given("Expand the Rolling Month Report option under Reports section in Side Menu")
	public void expand_the_rolling_month_report_option_under_reports_section_in_side_menu() throws InterruptedException {
		rollingMonth.expandReportFunc();
	}

	@Given("Navigate to Rolling Month Report page")
	public void navigate_to_rolling_month_report_page() {
	   assertTrue(rollingMonth.navigateRollingMonthPage());
	}

	@When("User selects the Group and date")
	public void user_selects_the_group_and_date() throws InterruptedException {
		rollingMonth.selectParametersFunc();
	}

	@Then("Default Rolling Month Headers should be loaded on the page.")
	public void default_rolling_month_headers_should_be_loaded_on_the_page() throws InterruptedException {
		 assertTrue(rollingMonth.verifyHeaders());
	}
	
	@When("User inputs a parameter in the Rolling Month search field")
	public void user_inputs_a_parameter_in_the_rolling_month_search_field() throws InterruptedException {
		rollingMonth.selectParametersFunc();
		rollingMonth.inputSearchParameterFunc();
	}
	
	@Then("Table should load the results on Rolling Month Page")
	public void table_should_load_the_results_on_rolling_month_page() throws InterruptedException {
		assertTrue(rollingMonth.verifySearchedParameterFunc());
	}
	
	@When("User navigates to the Calendar Month Report")
	public void user_navigates_to_the_calendar_month_report() throws InterruptedException {
		rollingMonth.selectParametersFunc();
		rollingMonth.navigateToCalendarMonth();
	}

	@Then("The Rolling Month Report parameters should match the Calendar Month Report.")
	public void the_rolling_month_report_parameters_should_match_the_calendar_month_report() throws InterruptedException {
		assertTrue(rollingMonth.verifyParametesFunc());
	}

	@Then("Verify data not loaded")
	public void verify_data_not_loaded() throws InterruptedException {
		assertTrue(rollingMonth_DV.verifyDataNotView());
	}


	
}
