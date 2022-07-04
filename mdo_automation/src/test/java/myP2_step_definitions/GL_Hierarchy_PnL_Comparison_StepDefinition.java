package myP2_step_definitions;

import static org.junit.Assert.assertTrue;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import myP2_pageObjects.GL_Hierarchy_PnL_Comparison_PageObject;

public class GL_Hierarchy_PnL_Comparison_StepDefinition {

	GL_Hierarchy_PnL_Comparison_PageObject glPnlComparisonPo = new GL_Hierarchy_PnL_Comparison_PageObject(
			DriverFactory.getDriver());

	@Given("I am expanding the bottom child value of Total Room revenue in PnL Comparison")
	public void I_am_expanding_the_bottom_child_value_of_Total_Room_revenue_in_PnL_Comparison()
			throws InterruptedException {
		assertTrue(glPnlComparisonPo.captureBottomChildModal());
	}

	@Then("Verify the captured bottom modal in PnL Comparison with GL hierarchy and turn off the modal")
	public void Verify_the_captured_bottom_modal_in_PnL_Comparison_with_GL_hierarchy_and_turn_off_the_modal()
			throws InterruptedException {

		assertTrue(glPnlComparisonPo.turnOffBottomCapturedModal());

	}

	@And("Verify the bottom child modal is not visible in the Pnl comparison report")
	public void Verify_the_bottom_child_modal_is_not_visible_in_the_Pnl_comparison_report()
			throws InterruptedException {

		assertTrue(glPnlComparisonPo.validateTurnedOffBottomModalinPnLComparison());
	}
//---------------------------------------------------------Top CHild-------------------------------------------------------------------------------------	
	@Given("I am expanding the top child value of Total Room revenue in PnL Comparison")
	public void I_am_expanding_the_top_child_value_of_Total_Room_revenue_in_PnL_Comparison()
			throws InterruptedException {
		assertTrue(glPnlComparisonPo.captureTopChildModal());
	}

	@Then("Verify the captured top modal in PnL Comparison with GL hierarchy and turn off the modal")
	public void Verify_the_captured_top_modal_in_PnL_Comparison_with_GL_hierarchy_and_turn_off_the_modal()
			throws InterruptedException {

		assertTrue(glPnlComparisonPo.turnOffTopCapturedModal());

	}

	@And("Verify the top child modal is not visible in the Pnl comparison report")
	public void Verify_the_top_child_modal_is_not_visible_in_the_Pnl_comparison_report()
			throws InterruptedException {

		assertTrue(glPnlComparisonPo.validateTurnedOffTopModalinPnLComparison());
	}
	//--------------------------------------------------------Parent-------------------------------------------------------------------------------------	
		@Given("I am expanding the parent value of Total Room revenue in PnL Comparison")
		public void I_am_expanding_the_parent_value_of_Total_Room_revenue_in_PnL_Comparison()
				throws InterruptedException {
			assertTrue(glPnlComparisonPo.captureParentModal());
		}

		@Then("Verify the captured parent modal in PnL Comparison with GL hierarchy and turn off the modal")
		public void Verify_the_captured_parent_modal_in_PnL_Comparison_with_GL_hierarchy_and_turn_off_the_modal()
				throws InterruptedException {

			assertTrue(glPnlComparisonPo.turnOffParentCapturedModal());

		}

		@And("Verify the parent modal is not visible in the Pnl comparison report")
		public void Verify_the_parent_modal_is_not_visible_in_the_Pnl_comparison_report()
				throws InterruptedException {

			assertTrue(glPnlComparisonPo.validateTurnedOffParentModalinPnLComparison());
		}	
	
	
}
