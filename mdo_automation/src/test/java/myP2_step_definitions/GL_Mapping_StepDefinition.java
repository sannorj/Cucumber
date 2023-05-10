package myP2_step_definitions;

import static org.junit.Assert.assertTrue;
import factory.DriverFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import myP2_pageObjects.GL_Mapping_PageObjective;



public class GL_Mapping_StepDefinition {
	
	private GL_Mapping_PageObjective glMapping = new GL_Mapping_PageObjective(DriverFactory.getDriver());
	
	
	@Then("I am navigate to GL Mapping page")
	public void i_am_navigate_to_gl_mapping_page() {
		assertTrue(glMapping.navigateToGLMapping()); 
	}
	
	@Then("User selecting a Single property from the property dropdown and check records in table")
	public void User_selecting_a_Single_property_from_the_property_dropdown_and_check_records_in_table() throws InterruptedException {
		glMapping.selectingSingleProperty(); 
	}

	@When("The user clicks the Add button and confirms that the Add GL Code page is visible")
	public void the_user_clicks_the_add_button_and_confirms_that_the_add_gl_code_page_is_visible() throws InterruptedException {
		assertTrue(glMapping.clickAddButt()); 
	}

	@Then("User creates a new GL Code and save it")
	public void user_creates_a_new_gl_code_and_save_it() throws InterruptedException {
		glMapping.createNewGlCode(); 
	}
	
	@Then("User search the new GL Code using the search bar and confirms that gl code is visible on the table")
	public void user_search_the_new_gl_code_using_the_search_bar_and_confirms_that_gl_code_is_visible_on_the_table() throws InterruptedException {
		assertTrue(glMapping.verifySavedGl()); 
	}
	
	@Then("The user clicks the Edit button and confirms that the Edit GL Code page is visible")
	public void the_user_clicks_the_edit_button_and_confirms_that_the_edit_gl_code_page_is_visible() throws InterruptedException {
		assertTrue(glMapping.clickEditButt()); 
	}

	@Then("User edit the specific GL Code and save it")
	public void user_edit_the_specific_gl_code_and_save_it() throws InterruptedException {
		glMapping.editGlCode(); 
	}

	@Then("User search the edited GL Code using the search bar and confirms that gl code is visible on the table")
	public void user_search_the_edited_gl_code_using_the_search_bar_and_confirms_that_gl_code_is_visible_on_the_table() throws InterruptedException {
		assertTrue(glMapping.verifyEditedGl()); 
	}
	
	@Then("The user clicks the delete button and confirms that the delete GL Code page is visible")
	public void the_user_clicks_the_delete_button_and_confirms_that_the_delete_gl_code_page_is_visible() throws InterruptedException {
		assertTrue(glMapping.clickDeleteButt()); 
	}

	@Then("User successfully delete the specific GL Code")
	public void user_successfully_delete_the_specific_gl_code() throws InterruptedException {
		glMapping.dleteGl(); 
	}


}
