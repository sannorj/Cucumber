package myP2_step_definitions;

import static org.junit.Assert.assertTrue;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import myP2_pageObjects.Dashboard_OrderColumn_PageObjective;

public class Dashboard_OrderColumn_StepDefinition {

	Dashboard_OrderColumn_PageObjective dashboardPo = new Dashboard_OrderColumn_PageObjective(DriverFactory.getDriver());

	
	@And("I am navigate to order column page")
	public void i_am_navigate_to_order_column_page() throws InterruptedException {
		assertTrue(dashboardPo.navigateToOrderColumn());
	}
	
	@Then("I am storing all the columns")
	public void i_am_storing_the_columns() throws InterruptedException {
		dashboardPo.storeOrderedColumns();
	}
	
	@And("I am verifying the ordered columns are in correct order")
	public void i_am_verifying_the_ordered_columns_are_in_correct_order() throws InterruptedException {
		assertTrue(dashboardPo.verifyOrderedColumns());
	}
}
