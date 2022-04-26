package myP2_step_definitions;

import static org.junit.Assert.assertTrue;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import myP2_pageObjects.Dashboard_PrimaryDecimal_PageObjective;
import myP2_pageObjects.PnLYearly_PageObject;

public class Dashboard_PrimaryDecimal_StepDefinition {

	private Dashboard_PrimaryDecimal_PageObjective dashBoardPo = new Dashboard_PrimaryDecimal_PageObjective(DriverFactory.getDriver());

	@When("I select the group {string} , property {string} , Date {string}")
	public void select_the_parameteres(String grp, String property, String date) throws InterruptedException {
		assertTrue(dashBoardPo.loadPageWithParameters(grp, property, date));
	}

	@And("I click the edit column icon {string}")
	public void I_click_the_edit_column_icon(String string) throws InterruptedException {
		dashBoardPo.setupPrimaryDecimalValue(string);
	}

	@Then("I click the Setting icon on Rooms Available")
	public void I_click_the_Setting_icon_on_Rooms_Available() throws InterruptedException {
		assertTrue(dashBoardPo.navigateToSetupPermenantDecimal());
	}

	@And("I am assigning decimal values {string}")
	public void I_am_assigning_decimal_values(String string) throws InterruptedException {
		dashBoardPo.assignPermenantDecimal(string);
	}

	@And("I click the Setting icon on Rooms Revenue")
	public void I_click_the_Setting_icon_on_Rooms_Revenue() throws InterruptedException {
		assertTrue(dashBoardPo.navigateToSetupOverRideValue());
	}

	@And("I am Overriding the Primary decimal values")
	public void I_am_Overriding_the_Primary_decimal_values() throws InterruptedException {
		dashBoardPo.assignOverrideDecimal();
	}

	@And("I am storing the Room Availble and Rooms Revenue Values")
	public void I_am_storing_the_Room_Availble_and_Rooms_Revenue_Values() throws InterruptedException {
		dashBoardPo.storeValues();
	}

	@And("I am comparing decimal values")
	public void I_am_comparing_decimal_values() throws InterruptedException {
		assertTrue(dashBoardPo.comparingDecimalValue());
		;
	}

}
