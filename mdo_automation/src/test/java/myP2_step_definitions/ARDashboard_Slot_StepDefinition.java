package myP2_step_definitions;

import static org.junit.Assert.assertTrue;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_scouse.An;
import myP2_pageObjects.ARDashboard_Slot_PageObject;

public class ARDashboard_Slot_StepDefinition {

	ARDashboard_Slot_PageObject ARpropertyPo = new ARDashboard_Slot_PageObject(DriverFactory.getDriver());

	@Then("Capture and Verify whether the distribution chart got all the values")
	public void Capture_and_Verify_whether_the_distribution_chart_got_all_the_values() throws InterruptedException {

		ARpropertyPo.captureDistributionSlotValues();
		assertTrue(ARpropertyPo.verifyDistributionSlotValues());
	}

	@Then("Capture and Verify whether the Graph chart got all the values")
	public void Capture_and_Verify_whether_the_Graph_chart_got_all_the_values() throws InterruptedException {

		ARpropertyPo.captureGrpahSlotValues();
		assertTrue(ARpropertyPo.verifyGrpahSlotValues());
	}

	@When("I Capture and store distribution values")
	public void I_Capture_and_store_distribution_values() throws InterruptedException {

		ARpropertyPo.captureAndStoreDistributionValues();
	}

	@Then("I Capture and store graph values")
	public void I_Capture_and_store_graph_values() throws InterruptedException {

		ARpropertyPo.captureAndStoreGrpahValues();
	}

	@And("I Sort and Compare both Graph and Distribution values")
	public void I_Compare_both_Graph_and_Distribution_values() throws InterruptedException {
		assertTrue(ARpropertyPo.sortAndCompareRates());
	}

}
