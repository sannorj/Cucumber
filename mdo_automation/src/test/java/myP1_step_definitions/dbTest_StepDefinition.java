package myP1_step_definitions;

import dbConnection.DBConnection;
import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import myP1_pageObjects.dbTest_myp1_PageObject;

public class dbTest_StepDefinition {
	dbTest_myp1_PageObject db = new dbTest_myp1_PageObject(DriverFactory.getDriver());
	DBConnection dbConnection = new DBConnection();
	

	@When("I have a myp1 databse connection")
	public void I_have_a_myp1_databse_connection() throws Exception {
		DBConnection.getmyp1Connection();
	}
	
	@When("I retrieve the actual data list from the database and csv reports then compare it and add the values to an Excel sheet")
	public void i_retrieve_the_actual_data_list_from_the_database_and_csv_reports_then_compare_it_and_add_the_values_to_an_excel_sheet() {
	    db.compareCSVReportData();
	}

	@When("I retrieve the actual data list from the database and excel reports then compare it and add the values to an Excel sheet")
	public void i_retrieve_the_actual_data_list_from_the_database_and_excel_reports_then_compare_it_and_add_the_values_to_an_excel_sheet() {
	    db.compareExcelReportData();
	}

	@When("I retrieve the actual data list from the database and xml reports then compare it and add the values to an Excel sheet")
	public void i_retrieve_the_actual_data_list_from_the_database_and_xml_reports_then_compare_it_and_add_the_values_to_an_excel_sheet() {
	    db.compareXmlReportData();
	}

}
