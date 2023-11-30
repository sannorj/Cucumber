package myP2_step_definitions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import java.sql.SQLException;

import dbConnection.*;
import factory.DriverFactory;
import myP2_pageObjects.*;


public class dbTest_SnowFlake_StepDefinition {
	
	SnowFlakeDBConnection dbConnection = new SnowFlakeDBConnection(DriverFactory.getDriver());
	dbTest_SnowFlake_PageObject snowFlake = new dbTest_SnowFlake_PageObject(DriverFactory.getDriver());
	
	@Given("I have a SnowFlacke databse connection")
	public void i_have_a_snow_flacke_databse_connection() throws Exception {
		dbConnection.getConnection();
	}
	
	

	
	@When("I retrieve the RAW snowflake data from {string} for {string} {string} {string} {string}")
	public void i_retrieve_the_raw_snowflake_data_from_for(String table, String companyCode, String startDate, String endDate, String transType) throws SQLException, Exception {
		snowFlake.selectActualData(table, companyCode, startDate, endDate, transType);
	}
	
	
//	@When("I retrieve the RAW snowflake data from {string} {string} for {string} {string} {string} {string}")
//	public void i_retrieve_the_raw_snowflake_data_from_for(String schema ,String table, String companyCode, String startDate, String endDate, String transType) throws SQLException, Exception {
//		snowFlake.selectActualData(schema,table, companyCode, startDate, endDate, transType);
//	}
}
