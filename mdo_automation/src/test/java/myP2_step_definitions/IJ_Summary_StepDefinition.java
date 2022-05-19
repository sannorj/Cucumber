package myP2_step_definitions;

import static org.junit.Assert.assertTrue;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import myP2_pageObjects.IJ_Summary_PageObject;


public class IJ_Summary_StepDefinition {
	
	private IJ_Summary_PageObject IJSummary = new IJ_Summary_PageObject(DriverFactory.getDriver());
	
	@Given("In the Side Menu, expand the IJ section.")
	public void in_the_side_menu_expand_the_ij_section() throws InterruptedException {
		IJSummary.expandForms();
	}
	
	@Given("Go to the Income Journal Summary")
	public void go_to_the_income_journal_summary() throws InterruptedException {
		IJSummary.navigateIJSummaryFunc();
	}

	@Given("Select the Property , Period , Date and Click on GO button")
	public void select_the_property_period_date_and_click_on_go_button() throws InterruptedException {
		IJSummary.selectParametersFunc();
	}

	@When("User clicks Add icon in to left coner on ij summary page")
	public void user_clicks_add_icon_in_to_left_coner_on_ij_summary_pagge() throws InterruptedException {
		IJSummary.clickOnAddIconFunc();
	}
	
	@When("User fills up all required fields and click on save button.")
	public void user_fills_up_all_required_fields_and_click_on_save_button() throws InterruptedException {
		IJSummary.addRowFunc();
	}

	@When("The newly added Income Journal Summary  should be visible on the home page.")
	public void The_newly_added_Income_Journal_Summary_should_be_visible_on_the_page() throws InterruptedException {
		IJSummary.selectParametersFunc();
		assertTrue(IJSummary.verifyAddedRowFunc());
		
	}


}
