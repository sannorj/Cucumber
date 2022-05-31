package myP2_step_definitions;

import static org.junit.Assert.assertTrue;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import myP2_pageObjects.GSSPriority_PageObjective;

public class GSSPriority_StepDefinition {
	private GSSPriority_PageObjective gssPriorityPo = new GSSPriority_PageObjective(DriverFactory.getDriver());

	
	@Then("I am navigate to GSS Priority page")
	public void I_am_navigate_to_GSS_Priority_page() {
		assertTrue(gssPriorityPo.navigateToGssPriorityPage());
	}
	@And("I select the group,period, quantity")
	public void I_select_the_group() {
		gssPriorityPo.passParameteres();
	}
	@Then("I am Loading the Priority Report with GO button")
	public void  I_am_Loading_the_Priority_Report_with_GO_button() throws InterruptedException {
		assertTrue(gssPriorityPo.loadPriorityReport());
	}
	@And("I am navigate medallia page to set priority")
	public void I_am_navigate_medallia_page_to_set_priority() throws InterruptedException
	{
		gssPriorityPo.navigateToMedallia();
	}
	@Then("I am search for group and assign priotiy 1")
	public void I_am_search_for_group_and_assign_priotiy_1() throws InterruptedException
	{
		gssPriorityPo.setPriority();
	}
	@Then("I select the group,period, quantity and Property")
	public void I_select_the_group_period_quantity_and_Property() throws InterruptedException
	{
		gssPriorityPo.passParameteresWithProperty();;
	}
	
	@Then("I am Calculating values")
	public void I_am_Calculating_values() throws InterruptedException
	{
		gssPriorityPo.calculateValues();
	}
	@And("I am Comparing values")
	public void I_am_Comparing_values() throws InterruptedException
	{
		assertTrue(gssPriorityPo.comparingValues());
	}
	
	
	
}
