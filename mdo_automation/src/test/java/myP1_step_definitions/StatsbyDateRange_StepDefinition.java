package myP1_step_definitions;

import static org.junit.Assert.assertTrue;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import myP1_pageObjects.StatsbyDateRange_PageObjects;

public class StatsbyDateRange_StepDefinition {

StatsbyDateRange_PageObjects StatbyDRPo = new StatsbyDateRange_PageObjects(DriverFactory.getDriver());


	@Then("Navigate to Stats by Date Range Page")
	public void navigate_to_stats_by_date_range_page() {
	    StatbyDRPo.NavigateToStatbyDR();
	}

	@Given("Select different dates and verify data availability in table")
	public void select_different_dates_and_verify_data_availability_in_table() throws InterruptedException {
		assertTrue(StatbyDRPo.dataAvailableDiffDays());
	}
	
	@And("Select equal dates and verify data availability in table")
	public void select_equal_dates_and_verify_data_availability_in_table() throws InterruptedException {
		assertTrue(StatbyDRPo.dataAvailableEqualDays());
	}

	@Given("Verify Occ total values show the average of all rows")
	public void verify_occ_total_values_show_the_average_of_all_rows() throws InterruptedException {
		assertTrue(StatbyDRPo.calculateOccAvgOfRows());
	}
	
	@Given("Verify ADR total values show the average of all rows")
	public void verify_adr_total_values_show_the_average_of_all_rows() {
		assertTrue(StatbyDRPo.calculateAdrAvgOfRows());
	}
	
	@Given("Verify RevPAR total values show the average of all rows")
	public void verify_rev_par_total_values_show_the_average_of_all_rows() throws InterruptedException {
		assertTrue(StatbyDRPo.calculateRevPARAvgOfRows());
	}
	
	@When("Verify Room Revenue values show total values of all the rows")
	public void verify_room_revenue_values_show_total_values_of_all_the_rows() throws InterruptedException {
		assertTrue(StatbyDRPo.calculateRoomRevenueTotalOfRows());
	}
	
	@When("Verify Room Sold values show total values of all the rows")
	public void verify_room_sold_values_show_total_values_of_all_the_rows() throws InterruptedException {
		assertTrue(StatbyDRPo.calculateRoomSoldTotalOfRows());
	}

}
