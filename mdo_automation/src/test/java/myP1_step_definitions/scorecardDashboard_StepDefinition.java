package myP1_step_definitions;

import static org.junit.Assert.assertTrue;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import myP1_pageObjects.scorecardDashboard_pageObjects;

public class scorecardDashboard_StepDefinition {
	scorecardDashboard_pageObjects dashboardScorecardPo = new scorecardDashboard_pageObjects(DriverFactory.getDriver());

	@When("Navigate to Scorecard page")
	public void navigate_to_scorecard_page() {
		dashboardScorecardPo.navigateScorecard();
	}

	@Then("Verify Scorecard data loaded")
	public void verify_scorecard_data_loaded() throws InterruptedException {
		dashboardScorecardPo.verifyDataLoaded();
	}

	@And("Verify All enebled cards loaded")
	public void verify_all_enebled_cards_loaded() throws InterruptedException {
		assertTrue(dashboardScorecardPo.verifyAllCardLoaded());
	}

	@When("Verify cards minimized")
	public void verify_cards_minimized() {
		assertTrue(dashboardScorecardPo.IsCardsViews());
	}
	
}
