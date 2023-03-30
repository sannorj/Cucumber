package myP2_step_definitions;

import static org.junit.Assert.assertTrue;
import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import myP2_pageObjects.Dashboard_WidgetsCalculator_PageObject;


public class Dashboard_WidgetsCalculator_StepDefinition {
	
	private Dashboard_WidgetsCalculator_PageObject widgetsCalculator = new Dashboard_WidgetsCalculator_PageObject(DriverFactory.getDriver());

	@When("User select Insignia Hospitality Group from the group dropdown")
	public void user_select_insignia_hospitality_group_from_the_group_dropdown() throws InterruptedException {
		widgetsCalculator.selectGroup(); 
	}

	@Then("User select All properties in property dropdown section")
	public void user_select_all_properties_in_property_dropdown_section() throws InterruptedException {
		widgetsCalculator.selectProperty();
	}
	
	@Then("Check and Verify the widgets order")
	public void Check_and_Verify_the_widgets_order() throws InterruptedException {
		//widgetsCalculator.verifyWidgetsOrder(); 
	}

	@Then("User setup a specific date")
	public void user_setup_a_specific_date() throws InterruptedException {
		assertTrue(widgetsCalculator.selectSpecificDate()); 
	}
	
	@Then("User set up By Property Period dropdown value")
	public void user_set_up_by_property_period_dropdown_value() throws InterruptedException {
		widgetsCalculator.selectByPropertyPeriod(); 
	}

	@Then("User add a new Occupancy column")
	public void user_add_a_new_occupancy_column() throws InterruptedException {
		widgetsCalculator.addNewRecord(); 
	}

	@Then("User change the Amount type in occupancy editing column and get the Portfolio Total values and store in to an array")
	public void user_change_the_amount_type_in_occupancy_editing_column_and_get_the_portfolio_total_values_and_store_in_to_an_array() throws InterruptedException {
		widgetsCalculator.editAmountTypeAndCaptureRec(); 
	}

	@Then("User change date to the last year")
	public void user_change_date_to_the_last_year() throws InterruptedException {
		assertTrue(widgetsCalculator.selectLastYearDate()); 
	}

	@Then("User capture the Records By the Year")
	public void user_capture_the_records_by_the_year() throws InterruptedException {
		widgetsCalculator.captureRecByYear(); 
	}

	@Then("User change date to the spcific past year")
	public void user_change_date_to_the_spcific_past_year() throws InterruptedException {
		assertTrue(widgetsCalculator.selectOldYearDate()); 
	}
	
	@Then("User setup the first specific date")
	public void User_setup_the_first_specific_date() throws InterruptedException {
		assertTrue(widgetsCalculator.selectSpecificDateFirst()); 
	}
	
	@Then("User select MTD value from the occupancy widget period dropdown")
	public void user_select_mtd_value_from_the_occupancy_widget_period_dropdown() throws InterruptedException {
		widgetsCalculator.selectOccupancyPeriod(); 
	}

	@Then("User capture the Records from graph and save it in an array")
	public void user_capture_the_records_from_graph_and_save_it_in_an_array() throws InterruptedException {
		widgetsCalculator.captureRecInGraph(); 
	}
	
	@Then("User comparing the two arrays")
	public void user_comparing_the_two_arrays() {
		assertTrue(widgetsCalculator.comparingTwoRecArrays()); 
	}
	
	@Then("User delete the occupancy column")
	public void User_delete_the_occupancy_column() throws InterruptedException {
		widgetsCalculator.deleteColumn(); 
	}
	
	@Then("User add a new ADR column")
	public void user_add_a_new_ADR_column() throws InterruptedException {
		widgetsCalculator.addNewAdrRecord(); 
	}

	@Then("User change the Amount type in ADR editing column and get the Portfolio Total values and store in to an array")
	public void user_change_the_amount_type_in_ADR_editing_column_and_get_the_portfolio_total_values_and_store_in_to_an_array() throws InterruptedException {
		widgetsCalculator.editAmountTypeAndCaptureRecADR(); 
	}
	
	@Then("User capture the ADR Records By the Year")
	public void user_capture_the_ADR_records_by_the_year() throws InterruptedException {
		widgetsCalculator.captureRecByYearADR(); 
	}
	
	@Then("User select MTD value from the ADR widget period dropdown")
	public void user_select_mtd_value_from_the_ADR_widget_period_dropdown() throws InterruptedException {
		widgetsCalculator.selectADRPeriod(); 
	}

	@Then("User capture the ADR Records from graph and save it in an array")
	public void user_capture_the_ADR_records_from_graph_and_save_it_in_an_array() throws InterruptedException {
		widgetsCalculator.captureRecInGraphADR(); 
	}
	
	@Then("User comparing the two arrays ADR")
	public void user_comparing_the_two_arrays_ADR() {
		assertTrue(widgetsCalculator.comparingTwoRecArraysADR()); 
	}
	
	@Then("User delete the ADR column")
	public void User_delete_the_ADR_column() throws InterruptedException {
		widgetsCalculator.deleteColumnADR(); 
	}
	
	@Then("User setup a specific date ADR")
	public void user_setup_a_specific_date_ADR() throws InterruptedException {
		assertTrue(widgetsCalculator.selectSpecificDateADR()); 
	}
	
	@Then("User setup the first specific date ADR")
	public void User_setup_the_first_specific_date_ADR() throws InterruptedException {
		assertTrue(widgetsCalculator.selectSpecificDateFirstADR()); 
	}
	
	@Then("User change date to the last year ADR")
	public void user_change_date_to_the_last_year_ADR() throws InterruptedException {
		assertTrue(widgetsCalculator.selectLastYearDateADR()); 
	}
	
	@Then("User add a new RevPAR column")
	public void user_add_a_new_RevPAR_column() throws InterruptedException {
		widgetsCalculator.addNewRevPARRecord(); 
	}

	@Then("User change the Amount type in RevPAR editing column and get the Portfolio Total values and store in to an array")
	public void user_change_the_amount_type_in_RevPAR_editing_column_and_get_the_portfolio_total_values_and_store_in_to_an_array() throws InterruptedException {
		widgetsCalculator.editAmountTypeAndCaptureRecRevPAR(); 
	}
	
	@Then("User capture the RevPAR Records By the Year")
	public void user_capture_the_RevPAR_records_by_the_year() throws InterruptedException {
		widgetsCalculator.captureRecByYearRevPAR(); 
	}
	
	@Then("User select MTD value from the RevPAR widget period dropdown")
	public void user_select_mtd_value_from_the_RevPAR_widget_period_dropdown() throws InterruptedException {
		widgetsCalculator.selectRevPARPeriod(); 
	}

	@Then("User capture the RevPAR Records from graph and save it in an array")
	public void user_capture_the_RevPAR_records_from_graph_and_save_it_in_an_array() throws InterruptedException {
		widgetsCalculator.captureRecInGraphRevPAR(); 
	}
	
	@Then("User comparing the two arrays RevPAR")
	public void user_comparing_the_two_arrays_RevPAR() {
		assertTrue(widgetsCalculator.comparingTwoRecArraysRevPAR()); 
	}
	
	@Then("User delete the RevPAR column")
	public void User_delete_the_RevPAR_column() throws InterruptedException {
		widgetsCalculator.deleteColumnRevPAR(); 
	}
	
	@Then("User setup a specific date RevPAR")
	public void user_setup_a_specific_date_RevPAR() throws InterruptedException {
		assertTrue(widgetsCalculator.selectSpecificDateRevPAR()); 
	}
	
	@Then("User setup the first specific date RevPAR")
	public void User_setup_the_first_specific_date_RevPAR() throws InterruptedException {
		assertTrue(widgetsCalculator.selectSpecificDateFirstRevPAR()); 
	}
	
	@Then("User change date to the last year RevPAR")
	public void user_change_date_to_the_last_year_RevPAR() throws InterruptedException {
		assertTrue(widgetsCalculator.selectLastYearDateRevPAR()); 
	}
	
}