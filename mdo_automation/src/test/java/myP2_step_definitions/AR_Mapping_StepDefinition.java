package myP2_step_definitions;

import static org.junit.Assert.assertTrue;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import myP2_pageObjects.AR_Mapping_PageObjective;

public class AR_Mapping_StepDefinition {

	AR_Mapping_PageObjective ARmappingPo = new AR_Mapping_PageObjective(DriverFactory.getDriver());

	@Then("I am expand the Accounts Mapping option under Configuration section in Side Menu")
	public void i_am_expand_the_accounts_mapping_option_under_configuration_section_in_side_menu() {
		ARmappingPo.expandAccountsMapping();
	}

	@And("I am navigate to AR Mapping page")
	public void i_am_navigate_to_ar_mapping_page() throws InterruptedException {
		assertTrue(ARmappingPo.navigateToMappingPage());
	}

	@When("I select the Group and Property then loading AR Mapping report with Go button")
	public void i_select_the_group_and_property_then_loading_ar_mapping_report_with_go_button()
			throws InterruptedException {
		ARmappingPo.setProperties();
	}

	@Given("Fill an account name in the list to search space and click on go buttton")
	public void fill_an_account_name_in_the_list_to_search_space_and_click_on_go_buttton() throws InterruptedException {
		ARmappingPo.searchOption();
	}

	@And("Verify whether the serched option is filtered")
	public void verify_whether_the_serched_option_is_filtered() {
		assertTrue(ARmappingPo.searchOptionFilled());
	}

	@Given("I am selecting the unmapped account and map it to selected account")
	public void i_am_selecting_the_unmapped_account_and_map_it_to_selected_account() throws InterruptedException {
		ARmappingPo.singleMapping();
	}

	@And("Verify whether the selected account mapped")
	public void verify_whether_the_selected_account_mapped() throws InterruptedException {
		assertTrue(ARmappingPo.accountIsSelected());
	}

	@Then("Remove mapped account again and verify whether the account removed")
	public void remove_mapped_account_again_and_verify_whether_the_account_removed() throws InterruptedException {
		assertTrue(ARmappingPo.removeMappedAccount());
	}

	@Given("I am selecting the few bullet icons to select randome accounts and Click on Bulk Action::Map To button")
	public void i_am_selecting_the_few_bullet_icons_to_select_randome_accounts_and_click_on_bulk_action_map_to_button()
			throws InterruptedException {
		ARmappingPo.selectFewAccounts();
	}

	@And("Select an account then click on save button")
	public void select_an_account_then_click_on_save_button() throws InterruptedException {
		ARmappingPo.selectAccountFromPopup();
	}

	@Then("Verify whether the accounts successfully changed")
	public void verify_whether_the_accounts_successfully_changed() throws InterruptedException {
		assertTrue(ARmappingPo.verifyAccountsChanged());
	}

	@And("Remove mapped account again")
	public void remove_mapped_account_again() throws InterruptedException {
		ARmappingPo.removeMappedBulkAcc();
	}

	@Then("Verify whether the removed account is successfully removed")
	public void verify_whether_the_removed_account_is_successfully_removed() throws InterruptedException {
		assertTrue(ARmappingPo.verifyAllAccRemoved());
	}

	@Given("Selects filters as {string} and {string} in the initial page")
	public void selects_filters_as_and_in_the_initial_page(String string, String string2) throws InterruptedException {
		ARmappingPo.selectDropdownInMain(string,string2);
	}

	@Given("Click on the Menu bar")
	public void click_on_the_menu_bar() throws InterruptedException {
		ARmappingPo.clckMenu();
	}

	@When("Expand the {string} menu")
	public void expand_the_menu(String string) throws InterruptedException {
		ARmappingPo.clckConfigurationMenu(string);
	}

	@Then("Expand the {string} menu option")
	public void expand_the_menu_option(String string) throws InterruptedException {
		ARmappingPo.clckAccountsMappingMenu(string);
	}

	@Then("Select the {string} option")
	public void select_the_option(String string) throws InterruptedException {
		ARmappingPo.clckARMappingMenu(string);
	}

	@Given("Check the header of the navigated page {string}")
	public void check_the_header_of_the_navigated_page(String string) {
		assertTrue(ARmappingPo.verifyARMapping(string));
	}

	@Given("Verify Group was selected as {string} and Property was selected as {string}")
	public void verify_group_was_selected_as_and_property_was_selected_as(String string, String string2) throws InterruptedException {
		assertTrue(ARmappingPo.verifyDropdown(string,string2));
	}

	@When("Click on the Go button")
	public void click_on_the_go_button() throws InterruptedException {
		ARmappingPo.clckGoBtn();
	}

	@Then("Verify all the Properties filtered according to selected {string} Property")
	public void verify_all_the_properties_filtered_according_to_selected_property(String string) {
		assertTrue(ARmappingPo.verifyPropertiesFiltered(string));
	}

	@Then("Verify all check box are loaded")
	public void verify_all_check_box_are_loaded() {
		assertTrue(ARmappingPo.verifyCheckBoxLoaded());
	}

	@Given("Verify mapping dropdown under the Mapped To header")
	public void verify_mapping_dropdown_under_the_Mapped_To_header() {
		assertTrue(ARmappingPo.verifyMappedTo());
	}

	@And("Verify remove Mapping link under the Actions header")
	public void verify_remove_Mapping_link_under_the_Actions_header() {
		assertTrue(ARmappingPo.verifyRemoveMapping());
	}
	
	
	@And("Click on the Menu bar and navigate to primary dashboard")
	public void Click_on_the_Menu_bar_and_navigate_to_primary_dashboard() throws InterruptedException {
		ARmappingPo.navigateToPrimaryDashboard();
	}

	
}
