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
	public void i_am_selecting_the_few_bullet_icons_to_select_randome_accounts_and_click_on_bulk_action_map_to_button() throws InterruptedException {
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

}
