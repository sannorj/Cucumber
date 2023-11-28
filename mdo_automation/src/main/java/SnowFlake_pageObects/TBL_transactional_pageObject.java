package SnowFlake_pageObects;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import dbConnection.SnowFlakeDBConnection;

public class TBL_transactional_pageObject {
	
	private WebDriver driver;
	private Statement st;
	 ResultSet resultSet1,resultSet2;
	 List<String[]> array1 , array2;
	
	public TBL_transactional_pageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	private static List<String[]> resultSetToArray(ResultSet resultSet) throws SQLException {
	    List<String[]> resultArray = new ArrayList<>();

	    while (resultSet.next()) {
	        String postDate = resultSet.getString("POST_DATE");
	        String account = resultSet.getString("GL_ACCOUNT");
	        
	        String[] row = {postDate, account};
	        resultArray.add(row);
	    }

	    return resultArray;
	}

	public void readTBL_M3_CSVFunc() throws SQLException, Exception {

	    String query1 = "SELECT post_date, gl_account FROM RAW.GL.TBL_M3_CSV WHERE FILE_NAME LIKE '%T00%'";

	    st = SnowFlakeDBConnection.getConnection().createStatement();
	    resultSet1 = st.executeQuery(query1);

	    array1 = resultSetToArray(resultSet1);

	    System.out.println("==========array1============");
	    for (String[] row : array1) {
	        System.out.println(Arrays.toString(row));
	    }
	    
	    
	}
	
	private static List<String[]> resultSetToArray1(ResultSet resultSet1) throws SQLException {
	    List<String[]> resultArray1 = new ArrayList<>();

	    while (resultSet1.next()) {
	        String postDate = resultSet1.getString("POST_DATE");
	        String account = resultSet1.getString("ACCOUNT_CODE");
	        
	        String[] row1 = {postDate, account};
	        resultArray1.add(row1);
	    }

	    return resultArray1;
	}

	public void readTBL_transactionalFunc() throws SQLException, Exception {

	    String query1 = "select post_date , account_code from fact.gl.tbl_transactional where hotel_code = 'T00-368' and post_date = '2022-08-22';";

	    st = SnowFlakeDBConnection.getConnection().createStatement();
	    resultSet2 = st.executeQuery(query1);

	     array2 = resultSetToArray1(resultSet2);

	    System.out.println("==========array2============");
	    for (String[] row1 : array2) {
	        System.out.println(Arrays.toString(row1));
	       
	    }
	    
	    
	}

	
	public boolean verifyFunc() throws SQLException, Exception {
	    readTBL_M3_CSVFunc(); // This method populates array1
	    readTBL_transactionalFunc(); // This method populates array2
	    
	   boolean flag = false ;

	    for (int i =0 ; i < array1.size(); i++) {
	        if (Arrays.toString(array1.get(i)).equals(Arrays.toString(array2.get(i)))) {
		        System.out.println("Arrays are equal");
		        flag= true;
		    } else {
		        System.out.println("Arrays are not equal");
		        flag= false;
		    }
	    }
		return flag;	    
	    
	}

	

}
