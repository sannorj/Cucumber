package myP2_step_definitions;

import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.io.IOException;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import myP2_pageObjects.KPI_Validation_PageObject;

public class KPI_Validation_StepDefinition {
	
	private KPI_Validation_PageObject KPIValidation = new KPI_Validation_PageObject(DriverFactory.getDriver());
	@Given("I change the date HG")
	public void i_change_the_date_hg() throws InterruptedException {
		KPIValidation.selectDate();
	}

	@Then("I navigate to the Add Column cart HG")
	public void i_navigate_to_the_add_column_cart_hg() throws InterruptedException {
		KPIValidation.navigateToAddColumn();
	}

	@Then("I add {string} kpi HG")
	public void i_add_kpi_hg(String kpi) throws InterruptedException {
		KPIValidation.addKPImyp2(kpi);
	}

	@Then("I get {string} value HG")
	public void i_get_value_hg(String string) throws InterruptedException {
		KPIValidation.setmyP2KPIPortfolio(string);
	}

	@Then("I delete added {string} cloumn HG")
	public void i_delete_added_cloumn_hg(String delete) throws InterruptedException {
		KPIValidation.deletmyp2KPI(delete);
	}

	@Given("I am verifying {string} divided by {string} calculated value is matching with  {string}")
	public void i_am_verifying_divided_by_calculated_value_is_matching_with(String string, String string2, String string3) throws FileNotFoundException, IOException {
	    assertTrue(KPIValidation.verifyKPIPortfolio(string, string2, string3));
	}

}
