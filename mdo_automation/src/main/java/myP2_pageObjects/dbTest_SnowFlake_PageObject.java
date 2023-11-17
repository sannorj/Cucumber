package myP2_pageObjects;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import dbConnection.DBConnection;
import dbConnection.SnowFlakeDBConnection;
import utils.ConstantsReader;

public class dbTest_SnowFlake_PageObject {
	
	
	private Statement st;
	private ResultSet rs;
	String Actual, Base;
	SimpleDateFormat sdf;
	private WebDriver driver;

	public dbTest_SnowFlake_PageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

	
//	public void selectActualData(String table, String companyCode, String startDate, String endDate, String transType) throws SQLException, Exception {
//	    try {
//	        // Set the search_path to the desired schema
//	       
//
////	        String query = "SELECT sum(amount) FROM " + table +
////	                " WHERE COMPANY_CODE = '" + companyCode + "'" +
////	                " AND post_date BETWEEN '" + startDate + "' AND '" + endDate + "'" +
////	                " AND trans_type = '" + transType + "'";
//	        
//	        
//	        String query = "SELECT sum(amount) FROM " + table +
//	                " WHERE COMPANY_CODE = '" + companyCode + "'" +
//	                " AND post_date BETWEEN '" + startDate + "' AND '" + endDate + "'" +
//	                " AND trans_type = '" + transType + "'";
//
//
//	        System.out.println("Query : " + query);
//	        
//	        
//	        st = SnowFlakeDBConnection.getSnowFlakeConnection().createStatement();
//	        rs = st.executeQuery(query);
//	        
//	  
//
//	        while (rs.next()) {
//	            System.out.println("Actual data  : " + rs.getString("sum(amount)"));
//	            Actual = rs.getString("sum(amount)");
//	            System.out.println("=11111111======="+Actual);
//	        }
//
//	    } catch (SQLException e) {
//	        e.printStackTrace();
//	    }
//	}


	public void selectActualData(String table, String companyCode, String startDate, String endDate, String transType) {
	    try {
	        System.setProperty("net.snowflake.client.log.loggerImpl", "net.snowflake.client.jdbc.internal.apache.log4j.Logger");

	        String query = "SELECT sum(amount) AS SUM_AMOUNT FROM " + table +
	                " WHERE COMPANY_CODE = '" + companyCode + "'" +
	                " AND post_date BETWEEN '" + startDate + "' AND '" + endDate + "'" +
	                " AND trans_type = '" + transType + "'";
	        System.out.println("Query : " + query);

	        st = SnowFlakeDBConnection.getConnection().createStatement();
	        rs = st.executeQuery(query);

	        while (rs.next()) {
	            System.out.println("Actual data  : " + rs.getString("SUM_AMOUNT"));
	            Actual = rs.getString("SUM_AMOUNT");
	            System.out.println("=11111111=======" + Actual);
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	

	}

	}


	
	    
	


	


	
