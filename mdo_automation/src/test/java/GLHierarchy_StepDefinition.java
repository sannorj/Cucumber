import static org.junit.Assert.assertTrue;

import factory.DriverFactory;
import io.cucumber.java.en.*;
import myP2_pageObjects.GLHierarchy_PageObject;

public class GLHierarchy_StepDefinition {

	GLHierarchy_PageObject GLHpo = new GLHierarchy_PageObject(DriverFactory.getDriver());

	@Given("I am expand the configuration option in Side Menu")
	public void I_am_expand_the_configuration_option_in_Side_Menu() {
		GLHpo.expandConfigurations();
	}

	@Given("I am navigate to GL Hierarchy page")
	public void i_am_navigate_to_gl_hierarchy_page() {
		assertTrue(GLHpo.navigateToGLHierarchy());
	}

	@Then("Click the All On button")
	public void click_the_all_on_button() throws InterruptedException {
		GLHpo.clickAllOnToggle();
	}

	@Then("Verify whether the function worked properly")
	public void verify_whether_the_function_worked_properly() {

		assertTrue(GLHpo.verifyAllOnFunction());
	}
//=============================================================Bottom Child=============================================================================

	@Given("I am expanding the bottom child value of Total Room revenue")
	public void i_am_expanding_the_child_value_of_total_room_revenue() throws InterruptedException {
		assertTrue(GLHpo.captureBottomChildModal());
	}

	@Then("Verify the captured bottom modal GL hierarchy and turn off the modal")
	public void Verify_the_captured_bottom_modal_GL_hierarchy_and_turn_off_the_modal() throws InterruptedException {

		assertTrue(GLHpo.turnOffBottomCapturedModal());

	}

	@And("Verify the bottom child modal is not visible in the report")
	public void Verify_the_bottom_child_modal_is_not_visible_in_the_report() throws InterruptedException {

		assertTrue(GLHpo.validateTurnedOffBottomModalinPnLMonth());
	}

//=============================================================Top Child=============================================================================	
	@Given("I am expanding the top child value of Total Room revenue")
	public void i_am_expanding_the_top_child_value_of_total_room_revenue() throws InterruptedException {
		assertTrue(GLHpo.captureTopChildModal());
	}

	@Then("Verify the captured top modal GL hierarchy and turn off the modal")
	public void Verify_the_captured_top_modal_GL_hierarchy_and_turn_off_the_modal() throws InterruptedException {
		assertTrue(GLHpo.turnOffTopCapturedModal());
	}

	@And("Verify the top child modal is not visible in the report")
	public void Verify_the_top_child_modal_is_not_visible_in_the_report() throws InterruptedException {
		assertTrue(GLHpo.validateTurnedOffTopModalinPnLMonth());
	}

//=============================================================Parent=============================================================================	
	@Given("I am expanding the parent value of Total Room revenue")
	public void i_am_expanding_the_parent_value_of_total_room_revenue() throws InterruptedException {
		assertTrue(GLHpo.captureParentModal());
	}

	@Then("Verify the captured parent modal GL hierarchy and turn off the modal")
	public void Verify_the_captured_parent_modal_GL_hierarchy_and_turn_off_the_modal() throws InterruptedException {
		assertTrue(GLHpo.turnOffParentCapturedModal());
	}

	@And("Verify the parent modal is not visible in the report")
	public void Verify_the_parent_modal_is_not_visible_in_the_report() throws InterruptedException {
		assertTrue(GLHpo.validateTurnedOffParentModalinPnLMonth());
	}

}
