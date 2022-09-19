package myP2_step_definitions;

import static org.junit.Assert.assertTrue;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import myP2_pageObjects.GSSMedallia_PageObject;

public class GSSMedalia_StepDefinition {

	private GSSMedallia_PageObject gssMedalliaPo =new GSSMedallia_PageObject(DriverFactory.getDriver());

	@Given("I am expand the Guest Satisfaction option under Reports section in Side Menu")
	public void I_am_expand_the_Guest_Satisfaction_option_under_Reports_section_in_Side_Menu() {
		gssMedalliaPo.expandGuestSatisfaction();
	}
	
	@Then("I am navigate to GSS Medallia page")
	public void I_am_navigate_to_GSS_Medallia_page() {
		assertTrue(gssMedalliaPo.navigateToGssMedalliaPage());
	}
	
	@And("I am Loading the Medalliah Report with GO button {string}")
	public void  I_am_Loading_the_Medalliah_Report_with_GO_Button(String string) {
		assertTrue(gssMedalliaPo.loadMedalliaReport(string));
	}
	
	@And("I am Loading the Medalliah Report with GO button")
	public void  I_am_Loading_the_Medalliah_Report_with_GO_Button() {
		assertTrue(gssMedalliaPo.loadMedalliaReport());
	}
	
	
	@Then("I am Assinging the 0 as priority for all the priority dropDown")
	public void I_am_Assinging_the_0_as_priority_for_all_the_priority_dropDown() throws InterruptedException {
		gssMedalliaPo.setPriorityZero();
	}
	
	@And("Assinging all the priority values by searching property one by one")
	public void  Assinging_all_the_priority_values_by_searching_property_one_by_one() throws InterruptedException {
		gssMedalliaPo.Search();
	}
	@And("I am Assinging the existing priority value for the priority dropDown")
	public void  I_am_Assinging_the_existing_priority_value_for_the_priority_dropDown() throws InterruptedException {
		assertTrue(gssMedalliaPo.assignExistingPriority());
	}
	

	
}
