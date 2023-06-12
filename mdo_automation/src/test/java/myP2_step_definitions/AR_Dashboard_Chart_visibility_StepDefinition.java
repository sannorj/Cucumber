package myP2_step_definitions;

import static org.junit.Assert.assertTrue;

import factory.DriverFactory;
import io.cucumber.java.en.*;
import myP2_pageObjects.AR_Dashboard_Chart_visibility_PageObject;


public class AR_Dashboard_Chart_visibility_StepDefinition {
	
	AR_Dashboard_Chart_visibility_PageObject ARdashboardCV = new AR_Dashboard_Chart_visibility_PageObject(DriverFactory.getDriver());
	
	
	@When("User checking if a specific column in the AR dashboard report has a total greater than zero")
	public void user_checking_if_a_specific_column_in_the_ar_dashboard_report_has_a_total_greater_than_zero() throws InterruptedException {

		ARdashboardCV.checkTotValue();
	}

	@Then("System navigate to the Primary Dashboard page and verify Primary Dashboard page header")
	public void system_navigate_to_the_primary_dashboard_page_and_verify_primary_dashboard_page_header() throws InterruptedException {

		assertTrue(ARdashboardCV.navigateToPrimaryDashboard());
	}

	@Then("Check group dropdown field and date field on Primary Dashboard page")
	public void check_group_dropdown_field_and_date_field_on_primary_dashboard_page() throws InterruptedException {

		ARdashboardCV.checkGroupAndDate();
	}

	@Then("Validate if the AR widget correctly displays the corresponding charts")
	public void validate_if_the_ar_widget_correctly_displays_the_corresponding_charts() throws InterruptedException {
		
		assertTrue(ARdashboardCV.checkWidgetChart());
	}

}
