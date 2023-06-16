package myP2_step_definitions;

import static org.junit.Assert.assertTrue;

import factory.DriverFactory;
import io.cucumber.java.en.Then;
import myP2_pageObjects.PnLYearly_Gop_Kpi_PageObject;

public class PnLYearly_Gop_Kpi_StepDefinition {

	private PnLYearly_Gop_Kpi_PageObject pnlYearlyGopKpi = new PnLYearly_Gop_Kpi_PageObject(DriverFactory.getDriver());

	@Then("I clicks GO button and confirm if the sections, GOP Flow Thru Prior Year Actuals & GOP Margin sections are visible in the P&L Yearly report")
	public void I_clicks_GO_button_and_confirm_if_the_sections_gop_flow_thru_prior_year_actuals_gop_margin_sections_are_visible_in_the_p_l_yearly_report() throws InterruptedException {
		pnlYearlyGopKpi.verifyGopKpi();
	}

	@Then("I select the group {string} , property {string} , specific date , view {string} and confirm GOP KPI View section is not visible in view dropdown")
	public void i_select_the_group_property_specific_date_view_and_confirm_gop_kpi_view_section_is_not_visible_in_view_dropdown(String group, String property, String view) throws InterruptedException {
		assertTrue(pnlYearlyGopKpi.verifyParametersAndGopNotVisi(group, property, view));
	}

	@Then("I clicks GO button")
	public void i_clicks_go_button() throws InterruptedException {
		pnlYearlyGopKpi.clickGoButt();
	}

	@Then("confirm if the sections, GOP Flow Thru Prior Year Actuals & GOP Margin sections are not visible in the PnL Monthly report")
	public void confirm_if_the_sections_gop_flow_thru_prior_year_actuals_gop_margin_sections_are_not_visible_in_the_PnL_Monthly_report() throws InterruptedException {
		assertTrue(pnlYearlyGopKpi.verifyPnlMheader());
	}
	
	@Then("I select the group {string} , specific date , view {string} and confirm GOP KPI View section is not visible in view dropdown")
	public void i_select_the_group_specific_date_view_and_confirm_gop_kpi_view_section_is_not_visible_in_view_dropdown(String Group, String View) throws InterruptedException {
		assertTrue(pnlYearlyGopKpi.verifyParameterAndGopNotVisible(Group, View));
	}
	
	@Then("confirm if the sections, GOP Flow Thru Prior Year Actuals & GOP Margin sections are not visible in the PnL Property Comparison report")
	public void confirm_if_the_sections_gop_flow_thru_prior_year_actuals_gop_margin_sections_are_not_visible_in_the_PnL_Property_Comparison_report() throws InterruptedException {
		assertTrue(pnlYearlyGopKpi.verifyPnlPCheader());
	}
	
	
}
