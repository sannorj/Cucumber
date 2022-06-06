package myP2_step_definitions;

import static org.junit.Assert.assertTrue;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import myP2_pageObjects.AR_Property_PageObjective;

public class AR_Property_StepDefinition {

	AR_Property_PageObjective ARpropertyPo = new AR_Property_PageObjective(DriverFactory.getDriver());
	
	@Then("I am navigate to AR Property page")
	public void I_am_navigate_to_AR_Property_page() {
		assertTrue(ARpropertyPo.navigateToARPropertyPage());
	}
	
	@When("I select the property and Date")
	public void i_select_the_property_and_date() throws InterruptedException {
		ARpropertyPo.loadPageWithParameters();
	}
	
	@Then("I am loading ar property report with Go button")
	public void i_am_loading_ar_report_with_go_button() {
		assertTrue(ARpropertyPo.loadArPropertyReport());
	}
	
	@Given("I am storing all the property values")
	public void i_am_storing_all_the_property_values() {
		ARpropertyPo.storeAllthePropertyRecords();
	}
	
	@And("I am sorting all the property values")
	public void i_am_sorting_all_the_property_values() {

		ARpropertyPo.calulateArPropertyMaxValue();
	}
	
	@And("Verify whether the AR Property RED Outstanding values are correctly highlighted")
	public void verify_whether_the_AR_Property_RED_Outstanding_values_are_correctly_highlighted() {
		assertTrue(ARpropertyPo.verifyArPropertyRedOutstanding());
	}
	
	@And("Verify whether the AR Property YELLOW Outstanding values are correctly highlighted")
	public void verify_whether_the_AR_Property_YELLOW_Outstanding_values_are_correctly_highlighted() {
		assertTrue(ARpropertyPo.verifyArPropertyRedOutstanding());
	}
}
