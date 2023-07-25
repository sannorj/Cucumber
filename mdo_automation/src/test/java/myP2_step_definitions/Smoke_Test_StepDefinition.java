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
	
	@When("select a Group and a date from the relevant dropdown fields")
	public void select_a_Group_and_a_date_from_the_relevant_dropdown_fields() throws InterruptedException {
		smoketestv.newparameterselection();

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
	
	@When("navigate to Add GL Code page")
	public void navigate_to_Add_GL_Code_page() throws InterruptedException {
		smoketestv.addglcodebtn();
	  
	}
	@When("navigate to Import page")
	public void navigate_to_Import_page() throws InterruptedException {
		smoketestv.clickimportbtn();
	  
	}
	
	@When("navigate to Copy page")
	public void navigate_to_Copy_page() throws InterruptedException {
		smoketestv.clickcopybtn();
	  
	}
	
	@When("click Cancel button")
	public void click_Cancel_button() throws InterruptedException {
		smoketestv.clickcancel();
	  
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
	@Then("PnL pages should be generated without errors")
	public void PnL_pages_should_be_generated_without_errors() throws InterruptedException {
		 assertTrue(smoketestv.clickingoandverifying21());
	}
	@Then("PnL comp should be generated without errors")
	public void PnL_comp_should_be_generated_without_errors() throws InterruptedException {
		 assertTrue(smoketestv.clickingoandverifying22());
	}
	@Then("GL code page should be generated without errors")
	public void GL_code_page_should_be_generated_without_errors() throws InterruptedException {
		 assertTrue(smoketestv.clickingoandverifying23());
	}
	@Then("Copy page should be generated without errors")
	public void Copy_page_should_be_generated_without_errors() throws InterruptedException {
		 assertTrue(smoketestv.clickingoandverifying24());
	}
	@Then("Import page should be generated without errors")
	public void Import_page_should_be_generated_without_errors() throws InterruptedException {
		 assertTrue(smoketestv.clickingoandverifying25());
	}
	@Then("pickup report should be generated without errors")
	public void pickup_report_should_be_generated_without_errors() throws InterruptedException {
		 assertTrue(smoketestv.clickingoandverifying26());
	}
	@Then("Guest Ledger should be generated without error")
	public void Guest_Ledger_should_be_generated_without_error() throws InterruptedException {
		 assertTrue(smoketestv.clickingoandverifying27());
	}
}
