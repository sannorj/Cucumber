package myP2_step_definitions;

import static org.junit.Assert.assertTrue;

import factory.DriverFactory;
import io.cucumber.java.en.Then;
import myP2_pageObjects.PnL_Yearly_PDashBoard_data_PageObject;

public class PnL_Yearly_PDashBoard_data_StepDefinition {
	
	PnL_Yearly_PDashBoard_data_PageObject PnLToDashBoard = new PnL_Yearly_PDashBoard_data_PageObject(DriverFactory.getDriver());
	
	@Then("Store the Static values for month of March")
	public void store_the_static_values_for_month_of_march() throws InterruptedException {
		PnLToDashBoard.StorePnLStaticValueFunc();
	}

	@Then("Navigate to the Primary Dashboard Page")
	public void navigate_to_the_primary_dashboard_page() throws InterruptedException {
		 PnLToDashBoard.navigateToPrimaryDashBoardFunc();
	}

	@Then("Select the group,property and Correct Date")
	public void select_the_group_property_and_correct_date() throws InterruptedException {
		PnLToDashBoard.selectDate();
	}

	@Then("Store the standard KPI values")
	public void store_the_standard_kpi_values() throws InterruptedException {
		PnLToDashBoard.StorePrimarydashBoardStaticValueFunc();
	}

	@Then("Verify whether the P&L Yearly and Primary Dashboard figures are equal")
	public void verify_whether_the_p_l_yearly_and_primary_dashboard_figures_are_equal() throws InterruptedException {
		assertTrue(PnLToDashBoard.verifyStaticKPIFunc());
	}
	
	@Then("Store the Operating Revenue values for month of March")
	public void store_the_operating_revenue_values_for_month_of_march() throws InterruptedException {
		PnLToDashBoard.StorePnLRevenueValueFunc();
	}

	@Then("Store the Operating Revenue KPI values")
	public void store_the_operating_revenue_kpi_values() throws InterruptedException {
		PnLToDashBoard.StorePrimarydashBoardRevenueValueFunc();
	}

	@Then("Verify whether the P&L Yearly and Primary Dashboard Operating Revenue figures are equal")
	public void verify_whether_the_p_l_yearly_and_primary_dashboard_operating_revenue_figures_are_equal() throws InterruptedException {
		 assertTrue(PnLToDashBoard.verifyRevenueKPIFunc());
	}


	@Then("Store the Departmental expenses values for month of March")
	public void store_the_departmental_expenses_values_for_month_of_march() throws InterruptedException {
		PnLToDashBoard.StorePnLExpensesValueFunc();
	}

	@Then("Store the Departmental expenses KPI values")
	public void store_the_departmental_expenses_kpi_values() throws InterruptedException {
		PnLToDashBoard.StorePrimarydashBoardExpensesValueFunc();
	}

	@Then("Verify whether the P&L Yearly and Primary Dashboard Departmental Expenses figures are equal")
	public void verify_whether_the_p_l_yearly_and_primary_dashboard_departmental_expenses_figures_are_equal() throws InterruptedException {
		assertTrue(PnLToDashBoard.verifyExpensesKPIFunc());
	}

}
