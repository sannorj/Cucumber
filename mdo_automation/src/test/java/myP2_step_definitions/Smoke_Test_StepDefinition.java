package myP2_step_definitions;

import static org.junit.Assert.assertTrue;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import myP2_pageObjects.RollingMonth_DataValidation_PageObjective;
import myP2_pageObjects.RollingMonth_PageObject;
import myP2_pageObjects.Smoke_Test_PageObject;

public class Smoke_Test_StepDefinition {
	
	private Smoke_Test_PageObject smoketestv = new Smoke_Test_PageObject(DriverFactory.getDriver());
	
	@Given("click on the sidebar menu and expand Report and afterwards expand Revenue and STR")
	public void click_on_the_sidebar_menu_and_expand_Report_and_afterwards_expand_Revenue_and_STR() throws InterruptedException {
		smoketestv.sidebar1();
	}
	@Given("Navigate to the Income Journal Mapping page")
	public void Navigate_to_the_Income_Journal_Mapping_page() throws InterruptedException {
		smoketestv.ijmappingselect();
	}
	
	@Given("I navigate to Account Management page")
	public void I_navigate_to_Account_Management_page() throws InterruptedException {
		smoketestv.accmangmentselect();
	}
	
	@Then("click on STR Report")
	public void click_on_STR_Report() {
		smoketestv.strreportselet();
	}

	@When("select Report and date from the relevant dropdowns")
	public void select_report_and_date_from_the_relevant_dropdowns() throws InterruptedException {
		smoketestv.parameterselection1();

	}
	
	
	@When("select Report and date from the relevant dropdown")
	public void select_report_and_date_from_the_relevant_dropdown() throws InterruptedException {
		smoketestv.parameterselection2();

	}


	@Then("AR report should be generated without errors")
	public void ar_report_should_be_generated_without_errors() throws InterruptedException {
		 assertTrue(smoketestv.clickingoandverifying1());

	}
	
	@Then("STR report should be generated without errors")
	public void STR_report_should_be_generated_without_errors() throws InterruptedException {
		 assertTrue(smoketestv.clickingoandverifying11());

	}
	
	@When("select Group and date from the relevant dropdowns")
	public void select_group_and_date_from_the_relevant_dropdowns()  throws InterruptedException {
		smoketestv.parameterselection();
	}
	
	@When("click the GO button")
	public void click_the_go_button() throws InterruptedException {
		smoketestv.clickingGobtn();
	  
	}

	@Then("report should be generated without errors")
	public void report_should_be_generated_without_errors() throws InterruptedException {
		 assertTrue(smoketestv.clickingoandverifying());
	}
	@Then("Revenue Breakdown report should be generated without errors")
	public void Revenue_Breakdown_report_should_be_generated_without_errors() throws InterruptedException {
		 assertTrue(smoketestv.clickingoandverifying12());
	}
	@Then("AR mapping report should be generated without errors")
	public void AR_mapping_report_should_be_generated_without_errors() throws InterruptedException {
		 assertTrue(smoketestv.clickingoandverifying13());
	}
	@Then("Sales mapping report should be generated without errors")
	public void Sales_mapping_report_should_be_generated_without_errors() throws InterruptedException {
		 assertTrue(smoketestv.clickingoandverifying14());
	}
	@Then("GL mapping report should be generated without errors")
	public void GL_mapping_report_should_be_generated_without_errors() throws InterruptedException {
		 assertTrue(smoketestv.clickingoandverifying15());
	}
	
	@Then("GL Hierarchy report should be generated without errors")
	public void GL_Hierarchy_mapping_report_should_be_generated_without_errors() throws InterruptedException {
		 assertTrue(smoketestv.clickingoandverifying16());
	}
	
	@Then("IJ report should be generated without errors")
	public void IJ_report_should_be_generated_without_errors() throws InterruptedException {
		 assertTrue(smoketestv.clickingoandverifying17());
	}
	@Then("IJ mapping report should be generated without errors")
	public void IJ_mapping_report_should_be_generated_without_errors() throws InterruptedException {
		 assertTrue(smoketestv.clickingoandverifying18());
	}
	@Then("Account Management report should be generated without errors")
	public void Account_Management_report_should_be_generated_without_errors() throws InterruptedException {
		 assertTrue(smoketestv.clickingoandverifying19());
	}

	@Then("Account Sales Managers should be generated without errors")
	public void Account_Sales_Managers_should_be_generated_without_errors() throws InterruptedException {
		 assertTrue(smoketestv.clickingoandverifying20());
	}
}
