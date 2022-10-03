package myP1_step_definitions;

import static org.junit.Assert.assertTrue;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import myP1_pageObjects.scorecardDashboard_Edit_pageObjects;

public class scorecardDashboard_Edit_StepDefinition {
	scorecardDashboard_Edit_pageObjects dashboardEdit = new scorecardDashboard_Edit_pageObjects(
			DriverFactory.getDriver());

	@Given("Click on edit button")
	public void click_on_edit_button() {
		dashboardEdit.clickEdit();
	}

	@And("Close card")
	public void close_card() {
		dashboardEdit.closeCard();
	}

	@When("Click confirm close button")
	public void click_confirm_close_button() throws InterruptedException {
		dashboardEdit.confirmClick();
	}

	@Then("Verify card closed")
	public void verify_card_closed() {
		assertTrue(dashboardEdit.verifyCardClosed());
	}

	@And("Disable selected card")
	public void disable_selected_card() throws InterruptedException {
		dashboardEdit.disableCard();
	}

	@When("Verify card disabled")
	public void verify_card_disabled() {
		assertTrue(dashboardEdit.verifyCardDisabled());
	}

	@And("Enable closed cards")
	public void enable_closed_cards() throws InterruptedException {
		dashboardEdit.enableCloseCards();
	}

	@When("Verify cards available")
	public void verify_cards_available() {
		assertTrue(dashboardEdit.verifyCardsAvailable());
	}
	
}
