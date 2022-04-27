package myP2_step_definitions;

import static org.junit.Assert.assertTrue;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import myP2_pageObjects.Dashboard_AddColumn_PageObjective;

public class Dashboard_AddColumn_StepDefinition {

	Dashboard_AddColumn_PageObjective dashboardPo = new Dashboard_AddColumn_PageObjective(DriverFactory.getDriver());

	@Then("I am navigate to Add column page")
	public void I_am_navigate_to_Add_column_page() throws InterruptedException {
		assertTrue(dashboardPo.navigateToAddColumn());
	}

	@And("I pass the Name {string} , KPI {string}")
	public void passing_name_and_kpi(String name, String kpi) throws InterruptedException {
		dashboardPo.setupNameAndKpi(name, kpi);
	}

	@And("I pass the AmountType {string} , Period {string}")
	public void passing_AmountType_and_Period(String amount, String period) throws InterruptedException {
		dashboardPo.setupAmountAndPeriod(amount, period);
	}
	
	@And("I setup the decimal value {string} and PerfomanceIndicator {string}")
	public void passing_Decimal_and_PerfomanceIndicator(String decimal, String Pi) throws InterruptedException {
		dashboardPo.setupDecimalAndPerfomance(decimal, Pi);
	}
	
	@Then("I Verify the newly added column")
	public void I_Verify_the_newly_added_column() throws InterruptedException {
		assertTrue(dashboardPo.verifySuccessMessage());
	}
	
	@And("I am navigate to Delete column page {string}")
	public void I_am_navigate_to_Delete_column_page(String columnName) throws InterruptedException {
		assertTrue(dashboardPo.navigateToDeleteColumn(columnName));
	}
	
	@And("I click the delete button and verify whether the column is deleted")
	public void I_click_the_delete_button_and_verify_whether_the_column_is_deleted() throws InterruptedException {
		assertTrue(dashboardPo.deleteColumn());
	}
	
	

}