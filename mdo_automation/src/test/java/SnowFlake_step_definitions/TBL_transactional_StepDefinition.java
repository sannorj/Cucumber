package SnowFlake_step_definitions;

import static org.junit.Assert.assertTrue;

import java.sql.SQLException;

import SnowFlake_pageObects.TBL_transactional_pageObject;
import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class TBL_transactional_StepDefinition {
	
	TBL_transactional_pageObject data = new TBL_transactional_pageObject(DriverFactory.getDriver());
	
	
	@Given("read the data from TBL_M3_CSV table where file name equals to {string}")
	public void read_the_data_from_tbl_m3_csv_table_where_file_name_equals_to(String fileName) throws SQLException, Exception {
		 data.readTBL_M3_CSVFunc(fileName);
	}

	@Given("read the data from tbl_transactional table  where hotel code equals to {string}")
	public void read_the_data_from_tbl_transactional_table_where_hotel_code_equals_to(String hotelCode) throws SQLException, Exception {
		data.readTBL_transactionalFunc(hotelCode);
	}
	
	@Then("the data in TBL_M3_CSV should match the data in tbl_transactional")
	public void the_data_in_tbl_m3_csv_should_match_the_data_in_tbl_transactional() throws SQLException, Exception {
	    assertTrue(data.verifydataFunc());
	}
	
	
	// 2 ============================================================================================================================
	

	
	@Given("reads the Credit data from TBL_M3_CSV table  where file name equals to {string} and GL Account equals to {string}")
	public void reads_the_credit_data_from_tbl_m3_csv_table_where_file_name_equals_to_and_gl_account_equals_to(String fileName, String ACCOUNT) throws SQLException, Exception {
		 data.readCreaditDataFunc(fileName, ACCOUNT);
	}

	@Given("reads the Debit data from TBL_M3_CSV table where GL Account equals to {string}")
	public void reads_the_debit_data_from_tbl_m3_csv_table_where_gl_account_equals_to(String string) throws SQLException, Exception {
		data.readDebitDataFunc(string);
	}


	@Then("verify that Credit and Debit signs are perfectly reflected on TBL_transition")
	public void verify_that_credit_and_debit_signs_are_perfectly_reflected_on_tbl_transition() throws SQLException, Exception {
		 assertTrue(data.compareDebitAmounts());
	}

	// 3 ============================================================================================================================
	
	@Given("reads the Company_Code and Property Code from TBL_M3_CSV table where file name equals to {string}")
	public void reads_the_company_code_and_property_code_from_tbl_m3_csv_table_where_file_name_equals_to(String string) {
		data.readCompanyPropertyCodeFunc(string);
	}
	
	@Given("gets the organization code from the file name where file name equals to {string}")
	public void gets_the_organization_code_from_the_file_name_where_file_name_equals_to(String string) {
		data.readOrgIDFunc(string);
	}

	@Then("the Hotel code in tbl_transactional table should display the correct combination of organization + company code + property code")
	public void the_hotel_code_in_tbl_transactional_table_should_display_the_correct_combination_of_organization_company_code_property_code() {
		data.combineCodesFunc();
	}
}
