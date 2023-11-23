package SnowFlake_step_definitions;

import dbConnection.SnowFlakeDBConnection;
import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import SnowFlake_pageObects.*;

public class dbConnection_StepDefinition {
	
	SnowFlakeDBConnection dbConnection = new SnowFlakeDBConnection(DriverFactory.getDriver());
	dbConnction_pageObject con = new dbConnction_pageObject(DriverFactory.getDriver());
	
	
	@Given("the application establishes the Snowflake connection to the database")
	public void the_application_establishes_the_snowflake_connection_to_the_database() throws Exception {
		SnowFlakeDBConnection.getConnection();
	}

	@When("Retrieve the RAW snowflake data from {string} for {string} {string} {string} {string}")
	public void retrieve_the_raw_snowflake_data_from_for(String string, String string2, String string3, String string4, String string5) {
		con.selectData(string, string2, string3, string4, string5);
	    
	}



}
