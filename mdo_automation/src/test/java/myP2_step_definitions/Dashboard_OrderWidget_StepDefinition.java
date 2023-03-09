package myP2_step_definitions;

import static org.junit.Assert.assertTrue;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import myP2_pageObjects.Dashboard_OrderWidget_PageObjective;

public class Dashboard_OrderWidget_StepDefinition {
	Dashboard_OrderWidget_PageObjective dashboardPo = new Dashboard_OrderWidget_PageObjective(
			DriverFactory.getDriver());

	@Then("I Am navigate to order widget page by clicking OrderWidget Icon")
	public void i_am_navigate_to_order_widget_page_by_clicking_order_widget_icon() throws InterruptedException {

		assertTrue(dashboardPo.navigateToOrderWidget());
	}
	
	@Then("I am getting all the ordered widget")
	public void i_am_getting_all_the_ordered_widget() throws InterruptedException {
	 dashboardPo.storeOrderedWidgets();
	}
	
	@And("I am verify with widgets with the dashboard")
	public void i_am_verify_with_widgets_with_the_dashboard() throws InterruptedException {
		assertTrue(dashboardPo.verifyOrderedWidgets());
	}
	
	@And("Select the property")
	public void Select_the_property_as() throws InterruptedException {
		dashboardPo.selectProperty();
	}

	@And("I drag and drop the data")
	public void i_drag_and_drop_the_data() throws InterruptedException {
	//	dashboardPo.dragAndDrop();
	}
	
	
}
