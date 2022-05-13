package myP2_step_definitions;

import static org.junit.Assert.assertTrue;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import myP2_pageObjects.TrendDashBoardOrderWidget_PageObjective;

public class TrendDashBoardOrderWidget_StepDefinition {

	private TrendDashBoardOrderWidget_PageObjective dashBoardPo = new TrendDashBoardOrderWidget_PageObjective(
			DriverFactory.getDriver());

	@Then("I am storing all the ordered widget")
	public void i_am_storing_all_the_ordered_widget() throws InterruptedException {
		dashBoardPo.storeOrderedWidgets();
	}

	@And("verify whether the widgets are in the correct order")
	public void verify_whether_the_widgets_are_in_the_correct_order() throws InterruptedException {
		assertTrue(dashBoardPo.verifyOrderedWidgets());
	}
	
	@Then("I am re-arrange some widgets")
	public void i_am_re_arrange_some_widgets() throws InterruptedException {
		dashBoardPo.dragAndDrop();
	}

}
