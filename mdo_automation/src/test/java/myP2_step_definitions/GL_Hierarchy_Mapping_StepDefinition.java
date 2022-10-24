package myP2_step_definitions;

import static org.junit.Assert.assertTrue;

import factory.DriverFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import myP2_pageObjects.GL_Hierarchy_Mapping_PageObject;

public class GL_Hierarchy_Mapping_StepDefinition {
	
	
	GL_Hierarchy_Mapping_PageObject glMapping = new GL_Hierarchy_Mapping_PageObject(DriverFactory.getDriver());
	
	@When("user selects the property form property dropdown")
	public void user_selects_the_property_form_property_dropdown() throws InterruptedException {
		glMapping.selectParametersFunc();
	}

	@Then("based on the property page should load the MDO gl codes")
	public void based_on_the_propert_page_should_load_the_mdo_gl_codes() {
		assertTrue(glMapping.verifyMDOGlCodeFunc());
	}

	@Then("clicks on the add GL Codes button from the UI")
	public void clicks_on_the_add_gl_codes_button_from_the_ui() throws InterruptedException {
		assertTrue(glMapping.clcickAddGlCodeFunc());
	}

	@Then("select one single available hmg gl code from the pop-up and click on save button")
	public void select_one_single_available_hmg_gl_code_from_the_pop_up_and_click_on_save_button() throws InterruptedException {
		glMapping.selectSingleGlcodeFunc();
	}

	@Then("Add GL Codes text should change to Manage GL Codes")
	public void add_gl_codes_text_should_change_to_manage_gl_codes() throws InterruptedException {
		glMapping.verifyAddLebelFunc();
	}

	@Then("clicks on the Manage GL Codes button from the UI")
	public void clicks_on_the_manage_gl_codes_button_from_the_ui() throws InterruptedException {
		assertTrue(glMapping.clcickAddGlbuttonFunc());
	}

	@Then("Remove the all mapped hmg GL codes")
	public void remove_the_all_mapped_hmg_gl_codes() throws InterruptedException {
		glMapping.RemoveSingleGlcodeFunc();
	}

	@Then("Manage GL Codes GL Codes text should change to Add GL Codes")
	public void manage_gl_codes_gl_codes_text_should_change_to_add_gl_codes() throws InterruptedException {
		assertTrue(glMapping.verifyManageLebelFunc());
	}
	
	
	@Then("select one multiple available hmg gl code from the pop-up and click on save button")
	public void select_one_multiple_available_hmg_gl_code_from_the_pop_up_and_click_on_save_button() throws InterruptedException {
		glMapping.selectMultipleGlcodeFunc();
	}

}
