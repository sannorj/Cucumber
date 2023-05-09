package myP1_step_definitions;

import static org.junit.Assert.assertTrue;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import myP1_pageObjects.laborDashboard_Edit_PageObjects;

public class laborDashboard_Edit_StepDefinition {
	
	laborDashboard_Edit_PageObjects dashboardLaborEdit = new laborDashboard_Edit_PageObjects(DriverFactory.getDriver());
	
	@When("Desable card from add chart")
	public void desable_card_from_add_chart() throws InterruptedException {
		dashboardLaborEdit.desableCard();
	}

	@And("Verify card desable")
	public void verify_card_desable() throws InterruptedException {
		assertTrue(dashboardLaborEdit.verifyCardDesable());
	}
	
	@Then("Enable card again")
	public void enable_card_again() throws InterruptedException {
		dashboardLaborEdit.enableCard();
	}

	@And("Verify card enable")
	public void verify_card_enable() throws InterruptedException {
		assertTrue(dashboardLaborEdit.verifyCardEnable());
	}
}
