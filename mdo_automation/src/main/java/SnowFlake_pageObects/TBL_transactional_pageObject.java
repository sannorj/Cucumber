package SnowFlake_pageObects;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import dbConnection.SnowFlakeDBConnection;

public class TBL_transactional_pageObject {
	
	private WebDriver driver;
	private Statement st;
	ResultSet resultSet1,resultSet2;
	List<String[]> array1 , array2;
	private ResultSet rs;
	String  creditAmount,debitAmount,extractedCode;
	String actualDataSet1,actualDataSet11 , actualDataSet12,COMPANY_CODE,PROPERTY_CODE,GL_ACCOUNT,POST_DATE;
	String fileNameGloble ,fileNameGloble2;
	int count ;
	
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

	public void readTBL_M3_CSVFunc(String fileName) throws SQLException, Exception {

	    String readTBL_M3_CSVFunc_query = "SELECT post_date, gl_account FROM RAW.GL.TBL_M3_CSV WHERE FILE_NAME like '"+fileName+"' ";
	    fileNameGloble = fileName; 

	    st = SnowFlakeDBConnection.getConnection().createStatement();
	    resultSet1 = st.executeQuery(readTBL_M3_CSVFunc_query);
	    
	    System.out.println("================================================================================================================================================================");
		   System.out.println("*                                                                                                                                                              *");
		   System.out.println("*                                                                                                                                                              *");
	   	   System.out.println("Query : " +readTBL_M3_CSVFunc_query);
	   	   System.out.println("*                                                                                                                                                              *");
	   	   System.out.println("*                                                                                                                                                              *");
	   	   System.out.println("=================================================================================================================================================================");

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

	public void readTBL_transactionalFunc(String hotelCode) throws SQLException, Exception {
		
		
		String readTBL_transactionalFunc_query = "select * from RAW.GL.TBL_M3_CSV where FILE_NAME like '"+fileNameGloble+"'";
		 
		   System.out.println("================================================================================================================================================================");
		   System.out.println("*                                                                                                                                                              *");
		   System.out.println("*                                                                                                                                                              *");
	   	   System.out.println("Query : " + readTBL_transactionalFunc_query);
	   	   System.out.println("*                                                                                                                                                              *");
	   	   System.out.println("*                                                                                                                                                              *");
	   	   System.out.println("=================================================================================================================================================================");
	   	  
	   	  
		    st = SnowFlakeDBConnection.getConnection().createStatement();
	        rs = st.executeQuery(readTBL_transactionalFunc_query);

	        while (rs.next()) {
	        	 actualDataSet11 = rs.getString("GL_ACCOUNT");      	
	        	 actualDataSet12 = rs.getString("POST_DATE");	
	        	 actualDataSet1 = rs.getString("COMPANY_CODE");
	        	          
	        }

//	    String readTBL_transactionalFunc_query2 = "select post_date , account_code from fact.gl.tbl_transactional where hotel_code = '"+hotelCode+"' and post_date = '"+actualDataSet12+"'";
	        
	        
	        String readTBL_transactionalFunc_query2 =   "SELECT post_date , account_code FROM fact.gl.tbl_transactional WHERE account_code IN "
	        													               + "(SELECT gl_account FROM RAW.GL.TBL_M3_CSV WHERE FILE_NAME LIKE '"+fileNameGloble+"')\n"
	        											+ "AND hotel_code = '"+hotelCode+"' AND POST_DATE = '"+actualDataSet12+"'";
	        
	    System.out.println("================================================================================================================================================================");
		   System.out.println("*                                                                                                                                                              *");
		   System.out.println("*                                                                                                                                                              *");
	   	   System.out.println("Query : " +readTBL_transactionalFunc_query2);
	   	   System.out.println("*                                                                                                                                                              *");
	   	   System.out.println("*                                                                                                                                                              *");
	   	   System.out.println("=================================================================================================================================================================");

	    st = SnowFlakeDBConnection.getConnection().createStatement();
	    resultSet2 = st.executeQuery(readTBL_transactionalFunc_query2);

	     array2 = resultSetToArray1(resultSet2);

	    System.out.println("==========array2============");
	    for (String[] row1 : array2) {
	        System.out.println(Arrays.toString(row1));
	       
	    }
	    
	    
	}

	
	public boolean verifydataFunc() throws SQLException, Exception {
   
	   boolean flag = false ;

	    for (int i =0 ; i < array1.size(); i++) {
	        if (Arrays.toString(array1.get(i)).equals(Arrays.toString(array2.get(i)))) {
		        flag= true;
		    } else {
		        flag= false;
		    }
	    }
		return flag;	    
	    
	}
	
	
	
	public void readCreaditDataFunc(String fileName , String ACCOUNT) throws SQLException, Exception {
		
		try {
	        System.setProperty("net.snowflake.client.log.loggerImpl", "net.snowflake.client.jdbc.internal.apache.log4j.Logger");
		    String readCreaditDataFunc_query = "select * from RAW.GL.TBL_M3_CSV where FILE_NAME like '"+fileName+"' and trans_type = 'C' and GL_ACCOUNT = '"+ACCOUNT+"' ";
		    
		    fileNameGloble2=fileName;
		 
		   System.out.println("================================================================================================================================================================");
		   System.out.println("*                                                                                                                                                              *");
		   System.out.println("*                                                                                                                                                              *");
	   	   System.out.println("readCreaditDataFunc_query : " +readCreaditDataFunc_query);
	   	   System.out.println("*                                                                                                                                                              *");
	   	   System.out.println("*                                                                                                                                                              *");
	   	   System.out.println("=================================================================================================================================================================");
	   	  
	   	  
		    st = SnowFlakeDBConnection.getConnection().createStatement();
	        rs = st.executeQuery(readCreaditDataFunc_query);

	        while (rs.next()) {
	        	 actualDataSet11 = rs.getString("GL_ACCOUNT");      	
	        	 actualDataSet12 = rs.getString("POST_DATE");	
	        	 actualDataSet1 = rs.getString("COMPANY_CODE");
	        	          
	        }
	        
	        
	        String readCreaditDataFunc_query2 ="select AMOUNT from fact.gl.tbl_transactional where account_code in ('"+actualDataSet11+"') and hotel_code = 'T00-368' and post_date = '"+actualDataSet12+"';";
	        
	        System.out.println("================================================================================================================================================================");
			   System.out.println("*                                                                                                                                                              *");
			   System.out.println("*                                                                                                                                                              *");
		   	   System.out.println("readCreaditDataFunc_query2 : " + readCreaditDataFunc_query2);
		   	   System.out.println("*                                                                                                                                                              *");
		   	   System.out.println("*                                                                                                                                                              *");
		   	   System.out.println("=================================================================================================================================================================");
		   	
		   	st = SnowFlakeDBConnection.getConnection().createStatement();
	        rs = st.executeQuery(readCreaditDataFunc_query2);
		   	while (rs.next()) {
	  
	            creditAmount = rs.getString("AMOUNT");
	            System.out.println("================= creditAmount Amount is =======" + creditAmount);
	        }  
		   	   
		}catch (Exception e) {
	        e.printStackTrace();
		
	}
	
	}
	

	
     public void readDebitDataFunc(String account) throws SQLException, Exception {
		
		try {
	        System.setProperty("net.snowflake.client.log.loggerImpl", "net.snowflake.client.jdbc.internal.apache.log4j.Logger");
		    String readDebitDataFunc_query = "select * from RAW.GL.TBL_M3_CSV where FILE_NAME like '"+fileNameGloble2+"' and trans_type = 'D' and GL_ACCOUNT = '"+account+"' ";
		 
		   System.out.println("================================================================================================================================================================");
		   System.out.println("*                                                                                                                                                              *");
		   System.out.println("*                                                                                                                                                              *");
	   	   System.out.println("readDebitDataFunc_query : " + readDebitDataFunc_query);
	   	   System.out.println("*                                                                                                                                                              *");
	   	   System.out.println("*                                                                                                                                                              *");
	   	   System.out.println("=================================================================================================================================================================");
	   	  
	   	  
		    st = SnowFlakeDBConnection.getConnection().createStatement();
	        rs = st.executeQuery(readDebitDataFunc_query);

	        while (rs.next()) {
	        	 actualDataSet11 = rs.getString("GL_ACCOUNT");      	
	        	 actualDataSet12 = rs.getString("POST_DATE");	
	        	 actualDataSet1 = rs.getString("COMPANY_CODE");
	        	          
	        }
	        
	        
	        String readDebitDataFunc_query2 ="select AMOUNT from fact.gl.tbl_transactional where account_code in ('"+actualDataSet11+"') and hotel_code = 'T00-368' and post_date = '"+actualDataSet12+"';";
	        
	        System.out.println("================================================================================================================================================================");
			   System.out.println("*                                                                                                                                                              *");
			   System.out.println("*                                                                                                                                                              *");
		   	   System.out.println("Query : " + readDebitDataFunc_query2);
		   	   System.out.println("*                                                                                                                                                              *");
		   	   System.out.println("*                                                                                                                                                              *");
		   	   System.out.println("=================================================================================================================================================================");
		   	
		   	st = SnowFlakeDBConnection.getConnection().createStatement();
	        rs = st.executeQuery(readDebitDataFunc_query2);
		   	while (rs.next()) {
	  
		   		debitAmount = rs.getString("AMOUNT");
	            System.out.println("================= debitAmount Amount is =======" + debitAmount);
	        }  
		   	   
		}catch (Exception e) {
	        e.printStackTrace();
		
	}
	
     }
	
     
     
     
     public boolean compareDebitAmounts() throws SQLException, Exception {

  	    double debitAmountValue = Double.parseDouble(debitAmount);
    	    boolean isDebitAmountPostive = debitAmountValue > 0;
    	    
    	    double creditAmountValue = Double.parseDouble(creditAmount);
    	    boolean isCreditNegative = creditAmountValue < 0;

    	    if (isDebitAmountPostive & isCreditNegative ) {
    	        return true;
    	    } else {
    	        return false;
    	    }
    	}

     
     
     
     public void readCompanyPropertyCodeFunc(String fileName) {
    	 
    	 
    		try {
    	        System.setProperty("net.snowflake.client.log.loggerImpl", "net.snowflake.client.jdbc.internal.apache.log4j.Logger");
    		    String readCompanyPropertyCodeFunc_query = "select * from RAW.GL.TBL_M3_CSV where FILE_NAME like '"+fileName+"' limit 1";
    		  
    		   System.out.println("================================================================================================================================================================");
    		   System.out.println("*                                                                                                                                                              *");
    		   System.out.println("*                                                                                                                                                              *");
    	   	   System.out.println("readCompanyPropertyCodeFunc_query : " +readCompanyPropertyCodeFunc_query);
    	   	   System.out.println("*                                                                                                                                                              *");
    	   	   System.out.println("*                                                                                                                                                              *");
    	   	   System.out.println("=================================================================================================================================================================");
    	   	  
    	   	  
    		    st = SnowFlakeDBConnection.getConnection().createStatement();
    	        rs = st.executeQuery(readCompanyPropertyCodeFunc_query);

    	        while (rs.next()) {
    	        	 PROPERTY_CODE = rs.getString("PROPERTY_CODE");      	
    	        	 COMPANY_CODE = rs.getString("COMPANY_CODE");
    	        	 GL_ACCOUNT = rs.getString("GL_ACCOUNT");
    	        	 POST_DATE = rs.getString("POST_DATE");
    	        	          
    	        }
    	   	   
    		}catch (Exception e) {
    	        e.printStackTrace();
    		
    	}
    	 
    	 
     }
     
     public void readOrgIDFunc(String Filename) {
    	 
    	 String inputString = Filename;
         String patternString = "([A-Za-z0-9]+)\\s*-"; 

         Pattern pattern = Pattern.compile(patternString);
         Matcher matcher = pattern.matcher(inputString);

         if (matcher.find()) {
             extractedCode = matcher.group(1);
             System.out.println("Extracted Code: " + extractedCode);
         } else {
             System.out.println("Code not found in the given string.");
         }
    	 
     }
     
     public boolean combineCodesFunc() {
    	 
    	  StringBuilder result = new StringBuilder();

          if (extractedCode != null && !extractedCode.isEmpty()) {
              result.append(extractedCode);
          }

          if (COMPANY_CODE != null && !COMPANY_CODE.isEmpty()) {
              result.append("-").append(COMPANY_CODE);
          }

          if (PROPERTY_CODE != null && !PROPERTY_CODE.isEmpty()) {
              result.append("-").append(PROPERTY_CODE);
          }

          System.out.println("=========result========="+result);
          
          
          try {
  	        System.setProperty("net.snowflake.client.log.loggerImpl", "net.snowflake.client.jdbc.internal.apache.log4j.Logger");
  		    String combineCodesFunc_query = "select count(Hotel_code) as COUNT from fact.gl.tbl_transactional where account_code in ('"+GL_ACCOUNT+"')\n"
  		    		+ "and hotel_code = '"+result+"' and post_date = '"+POST_DATE+"'";
  		 
  		   System.out.println("================================================================================================================================================================");
  		   System.out.println("*                                                                                                                                                              *");
  		   System.out.println("*                                                                                                                                                              *");
  	   	   System.out.println("combineCodesFunc_query : " +combineCodesFunc_query);
  	   	   System.out.println("*                                                                                                                                                              *");
  	   	   System.out.println("*                                                                                                                                                              *");
  	   	   System.out.println("=================================================================================================================================================================");
  	   	  
  	   	  
  		    st = SnowFlakeDBConnection.getConnection().createStatement();
  	        rs = st.executeQuery(combineCodesFunc_query);

  	        while (rs.next()) {
  	        	 count = rs.getInt("COUNT");      	
  	        	 
  	        }
  	   	   
  		}catch (Exception e) {
  	        e.printStackTrace();
  		
  	}    
          
       if (count==1) {
  	        return true;
  	    } else {
  	        return false;
  	    }
          
          
  	 
     }

}
