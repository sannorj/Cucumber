package myP2_step_definitions;

import static org.junit.Assert.assertTrue;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import myP2_pageObjects.Sales_Mapping_PageObjective;

public class Sales_Mapping_StepDefinition {

	Sales_Mapping_PageObjective SalesmappingPo = new Sales_Mapping_PageObjective(DriverFactory.getDriver());

	@And("I am navigate to Sales Mapping page through the AR Mapping page")
	public void i_am_navigate_to_sales_mapping_page_through_the_ar_mapping_page() throws InterruptedException {
		SalesmappingPo.landSalesMapping();
	}

	@When("I select the Group and Property then loading Sales Mapping report with Go button")
	public void i_select_the_group_and_property_then_loading_sales_mapping_report_with_go_button()
			throws InterruptedException {
		SalesmappingPo.setOptions();
	}

	@Given("Fill an account name in the list to search space and click on go buttton in SalesMapping")
	public void fill_an_account_name_in_the_list_to_search_space_and_click_on_go_buttton_in_SalesMapping()
			throws InterruptedException {
		SalesmappingPo.searchOptionInSales();
	}

	@And("Verify whether the serched option is filtered in SalesMapping")
	public void verify_whether_the_serched_option_is_filtered_in_SalesMapping() {
		assertTrue(SalesmappingPo.searchOptionFilledInSales());
	}

	@Given("I am selecting the unmapped account and map it to selected account in SalesMapping")
	public void i_am_selecting_the_unmapped_account_and_map_it_to_selected_account_in_sales_mapping()
			throws InterruptedException {
		SalesmappingPo.mapSingleAcc();
	}

	@And("Verify whether the selected account mapped in SalesMapping")
	public void verify_whether_the_selected_account_mapped_in_sales_mapping() throws InterruptedException {
		assertTrue(SalesmappingPo.checkAccountMapped());
	}

	@Then("Remove mapped account again and verify whether the account removed in SalesMapping")
	public void remove_mapped_account_again_and_verify_whether_the_account_removed_in_sales_mapping()
			throws InterruptedException {
		assertTrue(SalesmappingPo.verifyRemoved());
	}

	@Given("I am selecting the few bullet icons in salesMapping to select randome accounts and Click on Bulk Action::Map To button")
	public void i_am_selecting_the_few_bullet_icons_in_sales_mapping_to_select_randome_accounts_and_click_on_bulk_action_map_to_button()
			throws InterruptedException {
		SalesmappingPo.slectAccounts();
	}

	@And("Select an salesMapping account then click on save button")
	public void select_an_sales_mapping_account_then_click_on_save_button() {
		SalesmappingPo.selectMappedToAcc();
	}

	@Then("Verify whether the MappedTo accounts successfully changed")
	public void verify_whether_the_mapped_to_accounts_successfully_changed() throws InterruptedException {
		assertTrue(SalesmappingPo.verifyAccChanged());
	}

	@And("Remove mappedTo accounts again")
	public void remove_mapped_to_accounts_again() throws InterruptedException {
		SalesmappingPo.removeAccounts();
	}

	@Then("Verify whether the removed accounts successfully removed")
	public void verify_whether_the_removed_accounts_successfully_removed() throws InterruptedException {
		assertTrue(SalesmappingPo.verifyAccRemoved());
	}

	@Given("I am selecting a Sales Manager option and Verify successfully changed")
	public void i_am_selecting_a_sales_manager_option_and_verify_successfully_changed() throws InterruptedException {
		assertTrue(SalesmappingPo.selectSalesManager());
	}

	@And("Remove selected Sales Manager and Verify successfully removed")
	public void remove_selected_sales_manager_and_verify_successfully_removed() throws InterruptedException {
		assertTrue(SalesmappingPo.removeSalesManager());
	}

	@Then("I am selecting a Management Status option and Verify successfully changed")
	public void i_am_selecting_a_management_status_option_and_verify_successfully_changed() throws InterruptedException {
		assertTrue(SalesmappingPo.selectManagementStatus());
	}

	@When("Remove selected Management Status and Verify successfully removed")
	public void remove_selected_management_status_and_verify_successfully_removed() throws InterruptedException {
		assertTrue(SalesmappingPo.removeManagementStatus());
	}
	
	@Given("Select the {string} menu option")
	public void select_the_menu_option(String string) throws InterruptedException {
		assertTrue(SalesmappingPo.selectSubMenu(string));
	}
	
	@When("Navigate to {string} page")
	public void navigate_to_page(String string) {
		assertTrue(SalesmappingPo.navigateSalesMapping(string));
	}

	@When("Verify manager dropdown under the Sales Manager header")
	public void verify_manager_dropdown_under_the_sales_manager_header() {
		assertTrue(SalesmappingPo.verifyManagerDropdown());
	}

	@Then("Verify managed dropdown under the Managed header")
	public void verify_managed_dropdown_under_the_managed_header() {
		assertTrue(SalesmappingPo.verifyManagedDropdown());
	}
	
	

}
