package myP2_step_definitions;

import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.util.Date;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import myP2_pageObjects.KPIComparison_PrimaryD_PnLY_PageObjective;

public class KPIComparison_PrimaryD_PnLY_StepDefinition {

	KPIComparison_PrimaryD_PnLY_PageObjective PDnPnLYCompare = new KPIComparison_PrimaryD_PnLY_PageObjective(DriverFactory.getDriver());
	
	@Then("Verify KPI list available in Primary Dashboard page")
	public void verify_kpi_list_available_in_primary_dashboard_page() throws ParseException, InterruptedException {
		assertTrue(PDnPnLYCompare.VerifyKPIAvailble());
	}
	
	@Then("Store all the KPI values of months for {string} property in {string}")
	public void store_all_the_kpi_values_of_months_for_property_in(String string,String string2) throws ParseException, InterruptedException {
		PDnPnLYCompare.storePrimaryDKPI(string,string2);
	}

	@And("Select Year as {string}")
	public void select_year_as(String string) throws InterruptedException {
		PDnPnLYCompare.selectYear(string);
	}
	
	@And("Verify all KPIs available in PnLY report")
	public void verify_all_kpis_available_in_pnly_report() throws InterruptedException {
		assertTrue(PDnPnLYCompare.verifyKPIinPnL());
	}

	@Then("Compare dashboard KPI with PnL KPI and return the result of each month")
	public void compare_dashboard_kpi_with_pn_l_kpi_and_return_the_result_of_each_month() throws InterruptedException {
		assertTrue(PDnPnLYCompare.compareKPI()); 
	}
}
