package myP2_step_definitions;

import static org.junit.Assert.assertTrue;
import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import myP2_pageObjects.CalendarMonth__PageObject;
import myP2_pageObjects.RollingMonth_PageObject;

public class CalendarMonth_StepDefinition {
	
	private CalendarMonth__PageObject calenderMonth =new CalendarMonth__PageObject(DriverFactory.getDriver());
	private RollingMonth_PageObject rollingMonth =new RollingMonth_PageObject(DriverFactory.getDriver());
	
	@Given("Expand the Calendar Month Report option under Reports section in Side Menu")
	public void expand_the_calendar_month_report_option_under_reports_section_in_side_menu() throws InterruptedException {
		calenderMonth.expandReportFunc();
	}

	@Given("Navigate to Calendar Month Report page")
	public void navigate_to_calendar_month_report_page() {
		 assertTrue(calenderMonth.navigateCalMonthPage());
	}

	@Then("Calendar Month Headers should be loaded on the page.")
	public void calendar_month_headers_should_be_loaded_on_the_page() throws InterruptedException {
		 assertTrue(calenderMonth.verifyHeaders());
	}
	
	@When("User inputs a parameter in the Calender Month search field")
	public void user_inputs_a_parameter_in_the_calender_month_search_field() throws InterruptedException {
		rollingMonth.selectParametersFunc();
		calenderMonth.inputSearchParameterFunc();
	    
	}

	@Then("Table should load the results on Calender Month Page")
	public void table_should_load_the_results_on_calender_month_page() throws InterruptedException {
		assertTrue(calenderMonth.verifySearchedParameterFunc());
	}

	@When("User navigates to the Rolling Month Report")
	public void user_navigates_to_the_rolling_month_report() throws InterruptedException {
		rollingMonth.selectParametersFunc();
		calenderMonth.navigateToRollingMonth();
	}

	@Then("The Calendar Month Report parameters should match the Rolling Month Report.")
	public void the_calendar_month_report_parameters_should_match_the_rolling_month_report() throws InterruptedException {
		assertTrue(rollingMonth.verifyParametesFunc());
	}


}
