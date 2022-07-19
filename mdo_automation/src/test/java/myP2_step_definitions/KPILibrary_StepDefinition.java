package myP2_step_definitions;

import static org.junit.Assert.assertTrue;

import factory.DriverFactory;
import io.cucumber.java.en.*;
import myP2_pageObjects.*;

public class KPILibrary_StepDefinition {
	KPILibrary_PageObject kpiPO = new KPILibrary_PageObject(DriverFactory.getDriver());

	@When("System navigate to KPI Library page")

	public void System_navigate_to_KPI_Library_page() throws InterruptedException {
		assertTrue(kpiPO.navigateToKPILibrary());
	}

	@Given("I am navigate to Add kpi page")
	public void i_am_navigate_to_add_kpi_page() throws InterruptedException {
		assertTrue(kpiPO.navigateAddKPIPage());
	}

	@And("i select the KPIType,Name,Description")
	public void i_select_the_kpi_type_name_description() throws InterruptedException {
		kpiPO.selectParameters();
	}

	@When("I am assigning a static formula")
	public void I_am_assigning_a_formula() throws InterruptedException {
		assertTrue(kpiPO.verifyStaticFormula());
	}

	@Then("I save the formula")
	public void I_save_the_formula() throws InterruptedException {
		assertTrue(kpiPO.saveFormula());
	}

	@And("Verify whether the saved formula is available")
	public void Verify_whether_the_saved_formula_is_available() throws InterruptedException {
		assertTrue(kpiPO.verifySavedFormula());
	}

	@Given("i am searching kpi for delelte")
	public void i_am_searching_kpi_for_delelte() throws InterruptedException {
		assertTrue(kpiPO.searchKpiForDelete());
	}

	@Then("i expand the functions and delete the KPI")
	public void i_expand_the_functions_and_press_delete() throws InterruptedException {
		assertTrue(kpiPO.confirmDelete());

	}

	@Then("i select the KPIType,Name,Description Dynamicaly")
	public void i_select_the_KPIType_Name_Description_Dynamicaly() throws InterruptedException {
		kpiPO.selectParametersDynamically();

	}

	@And("I am assigning a Dynamic formula")
	public void I_am_assigning_a_Dynamic_formula() throws InterruptedException {
		assertTrue(kpiPO.createDynamicFormula());

	}
	
	@And("Verify whether the saved dynamic formula is available")
	public void Verify_whether_the_saved_dynamic_formula_is_available() throws InterruptedException {
		assertTrue(kpiPO.verifySavedDynamicFormula());
	}
	
	@Given("i am searching kpi for edit")
	public void i_am_searching_kpi_for_edit() throws InterruptedException {
		assertTrue(kpiPO.searchKpiForEdit());
	}
	
	@When("i expand the functions and edit the KPI")
	public void i_expand_the_functions_and_edit_the_KPI() throws InterruptedException {
		assertTrue(kpiPO.editAndSaveFormula());
		assertTrue(kpiPO.saveFormula());
	}
	
	@And("i save the edited KPI and verify")
	public void i_save_the_edited_KPI_and_verify() throws InterruptedException {
		assertTrue(kpiPO.verifyEditedFormula());
	}
	
	@Given("i am searching dynamic edited kpi for delelte")
	public void i_am_searching_dynamic_kpi_for_delelte() throws InterruptedException {
		assertTrue(kpiPO.searchDynamicEditedKpiForDelete());
	}

	@Then("i expand the functions and delete the dynamic KPI")
	public void i_expand_the_functions_and_press_dynamic_delete() throws InterruptedException {
		assertTrue(kpiPO.confirmDelete());

	}
   

}
