package myP2_step_definitions;

import static org.junit.Assert.assertTrue;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import myP2_pageObjects.GSSByMonth_PageObject;

public class GSSByMonth_StepDefinition {

	private GSSByMonth_PageObject gssMonthPo = new GSSByMonth_PageObject(DriverFactory.getDriver());

	@Then("I am Assinging the 0 as priority for priority which is equal to 1")
	public void I_am_Assinging_the_0_as_priority_for_priority_which_is_equal_to_1() throws InterruptedException {
		gssMonthPo.setPriorityZero();
	}

	@Then("I am navigate to GSS By Month page")
	public void I_am_navigate_to_GSS_By_Month_page() {
		assertTrue(gssMonthPo.navigateToGssMonthPage());
	}

	@And("Loading the Month Report with GO button")
	public void Loading_the_Month_Report_with_GO_button() throws InterruptedException {
		assertTrue(gssMonthPo.loadMonthReport());
	}

	@And("I click the SetPriority button {string}")
	public void I_click_the_SetPriority_button(String string) throws InterruptedException {
		gssMonthPo.setPriority(string);
	}

	@Then("I set the 1st priority {string}")
	public void i_set_the_1st_priority(String string) {
		gssMonthPo.setPriorityOne(string);

	}
	@And("I am Validating the priority values {string}")
	public void I_am_Validating_the_priority_values(String string) throws InterruptedException {
		gssMonthPo.validatePriority(string);
	}
	@And("Finally I am Comparing the values")
	public void Finally_I_am_Comparing_the_values() throws InterruptedException {
		assertTrue(gssMonthPo.compareValues());
	}
	
}
