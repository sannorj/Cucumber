package myP1_step_definitions;

import static org.junit.Assert.assertTrue;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import myP1_pageObjects.portfolioDashboard_SearchVal_PageObjects;

public class portfolioDashboard_SearchVal_StepDefinition {

	portfolioDashboard_SearchVal_PageObjects dashboardSearchOpt = new portfolioDashboard_SearchVal_PageObjects(DriverFactory.getDriver());
	
	@Given("add search value to search box")
	public void add_search_value_to_search_box() {
		dashboardSearchOpt.addVal();
	}

	@When("Verify table data filtering to search keyword")
	public void verify_table_data_filtering_to_search_keyword() throws InterruptedException {
		assertTrue(dashboardSearchOpt.searchVal());
	}
}
