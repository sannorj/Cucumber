package SnowFlake_pageObects;

import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import dbConnection.SnowFlakeDBConnection;

public class dbConnction_pageObject {
	
	private Statement st;
	private ResultSet rs;
	String Actual, Base;
	SimpleDateFormat sdf;
	private WebDriver driver;

	public dbConnction_pageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

	public void selectData(String table, String companyCode, String startDate, String endDate, String transType) {
	    try {
	        System.setProperty("net.snowflake.client.log.loggerImpl", "net.snowflake.client.jdbc.internal.apache.log4j.Logger");

	        String query = "SELECT sum(amount) AS SUM_AMOUNT FROM " + table +
	                " WHERE COMPANY_CODE = '" + companyCode + "'" +
	                " AND post_date BETWEEN '" + startDate + "' AND '" + endDate + "'" +
	                " AND trans_type = '" + transType + "'";
	        
	        System.out.println("========================================================================================");
	        System.out.println("*                                                                                      *");
	        System.out.println("*                                                                                      *");
	        System.out.println("Query : " + query);
	        System.out.println("*                                                                                      *");
	        System.out.println("*                                                                                      *");
	        System.out.println("========================================================================================");

	        st = SnowFlakeDBConnection.getConnection().createStatement();
	        rs = st.executeQuery(query);

	        while (rs.next()) {
	            System.out.println("Actual data  : " + rs.getString("SUM_AMOUNT"));
	            Actual = rs.getString("SUM_AMOUNT");
	            System.out.println("================= Amount is =======" + Actual);
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	

	}

}
