package myP2_step_definitions;

import static org.junit.Assert.assertTrue;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import myP2_pageObjects.Dashboard_DrowpdownValidation_PageObject;
import myP2_pageObjects.Dashboard_PrimaryDecimal_PageObjective;

public class Dashboard_DrowpdownValidation_StepDefinition {

	private Dashboard_DrowpdownValidation_PageObject dashBoardPo = new Dashboard_DrowpdownValidation_PageObject(
			DriverFactory.getDriver());

	@And("I click the edit column icon")
	public void I_click_edit_column_icon() throws InterruptedException {
		dashBoardPo.clickEdit();
	}

	@When("I am storing group and property dropdown values")
	public void I_am_storing_group_and_property_dropdown_values() throws InterruptedException {
		dashBoardPo.validateAndStoreDropdownValues();
	}
	
	@When("I am storing dashboard grid values")
	public void I_am_storing_dashboard_grid_values() throws InterruptedException {
		dashBoardPo.storeDashBoardGridValues();
	}
	
	@And("I am comparing stored groups and properties")
	public void I_am_comparing_stored_groups_and_properties() throws InterruptedException {
		assertTrue(dashBoardPo.compareStoredGroupsAndProperties());
	}
	
	
	
	
}
