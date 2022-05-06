package myP2_step_definitions;

import static org.junit.Assert.assertTrue;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import myP2_pageObjects.Dashboard_AddColumn_PageObjective;
import myP2_pageObjects.Dashboard_ToggleWidget_PageObjective;

public class Dashboard_ToggleWidget_StepDefinition {

	Dashboard_ToggleWidget_PageObjective dashboardPo = new Dashboard_ToggleWidget_PageObjective(
			DriverFactory.getDriver());

	@Then("I Am navigate to toggle widget page by clicking ToggleWidget Icon")
	public void I_Am_navigate_to_toggle_widget_page_by_clicking_ToggleWidget_Icon() throws InterruptedException {
		assertTrue(dashboardPo.navigateToToggleWidget());
	}

	@And("I turn on all the widgets")
	public void i_turn_on_all_the_widgets_and_verify_whthere_all_the_widgets_are_available()
			throws InterruptedException {
		dashboardPo.verifyAndChangeStateOnToggle();
	}

	@And("verify whthere all the widgets are available")
	public void verify_whthere_all_the_widgets_are_available() throws InterruptedException {
		assertTrue(dashboardPo.verifyAllTheWidgets());
	}

	@Then("I search for {string} , {string} , {string} and turned off")
	public void i_search_for_and_turned_off(String string, String string2, String string3) throws InterruptedException {
		dashboardPo.turnOffWidget(string, string2, string3);
	}
	
	@And("Verify whethere turned of widgets are not visible in the dashboard")
	public void verify_whethere_turned_of_widgets_are_not_visible_in_the_dashboard() throws InterruptedException {
	    assertTrue(dashboardPo.verifyTurnedOffWidgets());
	}

}
