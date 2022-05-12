package myP2_step_definitions;

import static org.junit.Assert.assertTrue;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import myP2_pageObjects.TrendDashBoardToggleWidget_PageObjective;

public class TrendDashBoardToggleWidget_StepDefinition {
	private TrendDashBoardToggleWidget_PageObjective dashBoardPo = new TrendDashBoardToggleWidget_PageObjective(
			DriverFactory.getDriver());

	@When("I am expand the DashBoard section in Side Menu and navigate to trend dashboard")
	public void i_am_expand_the_dash_board_section_in_side_menu_and_navigate_to_trend_dashboard()
			throws InterruptedException {
		assertTrue(dashBoardPo.navigateToTrendDashboard());
	}

	@Then("i am changing all the widget state to on")
	public void i_am_changing_all_the_widget_state_to_on() throws InterruptedException {
		dashBoardPo.verifyAndChangeStateOnToggle();
	}

	@And("I am comparing all the available widgets are in correct order")
	public void i_am_comparing_all_the_available_widgets_are_in_correct_order() throws InterruptedException {
		assertTrue(dashBoardPo.verifyAllTheWidgets());
	}

	@Then("I turned off Some widgets")
	public void i_turned_off_some_widgets() throws InterruptedException {
		dashBoardPo.turnOffWidget();
	}

	@Then("Verifying the visibility of widgets on dashboard")
	public void Verifying_the_visibility_of_widgets_on_dashboard() throws InterruptedException {
		assertTrue(dashBoardPo.verifyTurnedOffWidgets());
	}

}
