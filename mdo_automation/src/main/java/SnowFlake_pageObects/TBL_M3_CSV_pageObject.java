package SnowFlake_pageObects;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import dbConnection.SnowFlakeDBConnection;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;


public class TBL_M3_CSV_pageObject {
	
	private WebDriver driver;
	String csvColumn1,csvColumn2,csvColumn3,csvColumn4,csvColumn5,csvColumn6,csvColumn7,csvColumn8,csvColumn9,csvColumn10,csvColumn11,csvColumn12,csvColumn13,csvColumn14,csvColumn15;
	private Statement st;
	private ResultSet rs;
	int  noOfCOUNT;
    List<String> dataList = new ArrayList<>();
    List<String> CSVdataList = new ArrayList<>();
    int rowCount ,CSVrowCount  = 0;

	public TBL_M3_CSV_pageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void readCSVFileFunc() {

		  String csvFilePath = "src/test/resources/SnowFlake_RawData/T00 - GL Post Date Added 2023_02_01_081301.csv";
		   try (
		            FileReader reader = new FileReader(csvFilePath);
		            CSVParser csvParser = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(reader);
		        ) {
		            
		            // Iterate through CSV records
		            for (CSVRecord csvRecord : csvParser) {
		                // Ignore the first row (header)
		                if (csvRecord.getRecordNumber() > 1) {
		                     csvColumn1 = csvRecord.get("CompanyCode");
		                     csvColumn2 = csvRecord.get("CompanyName");
		                     csvColumn3 = csvRecord.get("PropertyCode");
		                     csvColumn4 = csvRecord.get("PropertyName");
		                     csvColumn5 = csvRecord.get("BatchID");
		                     csvColumn6 = csvRecord.get("BatchType");
		                     csvColumn7 = csvRecord.get("TransType");
		                     csvColumn8 = csvRecord.get("VendorID");
		                     csvColumn9 = csvRecord.get("InvoiceNo");
		                     csvColumn10 = csvRecord.get("InvoiceDate");
		                     csvColumn11 = csvRecord.get("GLAccount");
		                     csvColumn12 = csvRecord.get("PostDate");
		                     csvColumn13 = csvRecord.get("Description");
		                     csvColumn14 = csvRecord.get("Reference");
		                     csvColumn15 = csvRecord.get("Amount");
		                    
		                     
		                     CSVdataList.add(csvColumn1 = csvColumn1.trim().isEmpty() ? "null" : csvColumn1);
			                    CSVdataList.add(csvColumn2 = csvColumn2.trim().isEmpty() ? "null" : csvColumn2);
			                    CSVdataList.add(csvColumn3 = csvColumn3.trim().isEmpty() ? "null" : csvColumn3);
			                    CSVdataList.add(csvColumn4 = csvColumn4.trim().isEmpty() ? "null" : csvColumn4);
			                    CSVdataList.add(csvColumn5 = csvColumn5.trim().isEmpty() ? "null" : csvColumn5);
			                    CSVdataList.add(csvColumn6 = csvColumn6.trim().isEmpty() ? "null" : csvColumn6);
			                    CSVdataList.add(csvColumn7 = csvColumn7.trim().isEmpty() ? "null" : csvColumn7);
			                    CSVdataList.add(csvColumn8 = csvColumn8.trim().isEmpty() ? "null" : csvColumn8);
			                    CSVdataList.add(csvColumn9 = csvColumn9.trim().isEmpty() ? "null" : csvColumn9);
			                    CSVdataList.add(csvColumn10 = csvColumn10.trim().isEmpty() ? "null" : csvColumn10);
			                    CSVdataList.add(csvColumn11 = csvColumn11.trim().isEmpty()? "null" : csvColumn11);
			                    CSVdataList.add(csvColumn12 = csvColumn12.trim().isEmpty() ? "null" : csvColumn12);
			                    CSVdataList.add(csvColumn13 = csvColumn13.trim().isEmpty() ? "null" : csvColumn13);
			                    CSVdataList.add(csvColumn14 = csvColumn14.trim().isEmpty() ? "null" : csvColumn14);
			                    CSVdataList.add(csvColumn15= csvColumn15.trim().isEmpty() ? "null" : csvColumn15);
			                    
                 
		                    
		          
		    	        	System.out.println("=============CSVdataList============"+CSVdataList);
		    	        	
		    	        	
		                    CSVdataList.add(csvColumn1);

		                   

		                }
		            }

		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		
	}
	
	
	public void readDBdataFunc() throws SQLException, Exception {
		

		
		try {
	        System.setProperty("net.snowflake.client.log.loggerImpl", "net.snowflake.client.jdbc.internal.apache.log4j.Logger");
		 String query = "\n"
		 		+ "SELECT company_code,company_name,property_code,property_name,batch_id,batch_type,trans_type,vendor_id,invoice_no,invoice_date,GL_ACCOUNT,post_date,description,reference,amount\n"
		 		+ "FROM RAW.GL.TBL_M3_CSV WHERE\n"
		 		+ "company_code = "+csvColumn1+" and \n"
		 		+ "company_name = '"+csvColumn2+"' and\n"
		 		+ "batch_id = '"+csvColumn5+"' and \n"
		 		+ "GL_ACCOUNT = "+csvColumn11+" and \n"
		 		+ "FILE_NAME LIKE '%T00%'";
		 
		 System.out.println("Query : " + query);
		 st = SnowFlakeDBConnection.getConnection().createStatement();
	        rs = st.executeQuery(query);

	        while (rs.next()) {
	        	String actualDataSet1 = rs.getString("COMPANY_CODE");
	        	String actualDataSet2 = rs.getString("COMPANY_NAME");
	        	String actualDataSet3 = rs.getString("PROPERTY_CODE");
	        	String actualDataSet4 = rs.getString("PROPERTY_NAME");
	        	String actualDataSet5 = rs.getString("BATCH_ID");
	        	String actualDataSet6 = rs.getString("BATCH_TYPE");
	        	String actualDataSet7 = rs.getString("TRANS_TYPE");
	        	String actualDataSet8 = rs.getString("VENDOR_ID");
	        	String actualDataSet9 = rs.getString("INVOICE_NO");
	        	String actualDataSet10 = rs.getString("INVOICE_DATE");
	        	String actualDataSet11 = rs.getString("GL_ACCOUNT");
	        	String actualDataSet12 = rs.getString("POST_DATE");
	        	String actualDataSet13 = rs.getString("DESCRIPTION");
	        	String actualDataSet14 = rs.getString("REFERENCE");
	        	String actualDataSet15= rs.getString("AMOUNT");
	        	
	        	
	        	
	        	dataList.add(actualDataSet1 = actualDataSet1== null ? "null" : actualDataSet1 );
	        	dataList.add(actualDataSet2 = actualDataSet2== null ? "null" : actualDataSet2 );
	        	dataList.add(actualDataSet3 = actualDataSet3== null ? "null" : actualDataSet3 );
	        	dataList.add(actualDataSet4 = actualDataSet4== null ? "null" : actualDataSet4 );
	        	dataList.add(actualDataSet5 = actualDataSet5== null ? "null" : actualDataSet5 );
	        	dataList.add(actualDataSet6 = actualDataSet6== null ? "null" : actualDataSet6 );
	        	dataList.add(actualDataSet7 = actualDataSet7== null ? "null" : actualDataSet7 );
	        	dataList.add(actualDataSet8 = actualDataSet8== null ? "null" : actualDataSet8 );
	        	dataList.add(actualDataSet9 = actualDataSet9== null ? "null" : actualDataSet9 );
	        	dataList.add(actualDataSet10 = actualDataSet10== null ? "null" : actualDataSet10 );
	        	dataList.add(actualDataSet11 = actualDataSet11== null ? "null" : actualDataSet11 );
	        	dataList.add(actualDataSet12 = actualDataSet12== null ? "null" : actualDataSet12 );
	        	dataList.add(actualDataSet13 = actualDataSet13== null ? "null" : actualDataSet13 );
	        	dataList.add(actualDataSet14 = actualDataSet14== null ? "null" : actualDataSet14 );
	        	dataList.add(actualDataSet15 = actualDataSet15== null ? "null" : actualDataSet15 );
	        	
	        	
	        			
	        			
	        	System.out.println("=============dataList============"+dataList);
	           
	        }
		}catch (Exception e) {
	        e.printStackTrace();
		
	}
	}
	
	
	public boolean verifyCSVdbFunc() {
		
		boolean results = false;
		
		for (int i = 0 ; i<dataList.size() ; i++) {
			if(CSVdataList.get(i).contains(dataList.get(i))) {
				System.out.println("=======CSVdataList.get(i)======"+CSVdataList.get(i)+"======dataList.get(i)============"+dataList.get(i));
				results= true;
			}else {
				System.out.println("=======CSVdataList.get(i)======"+CSVdataList.get(i)+"======dataList.get(i)============"+dataList.get(i));
				results = false;
				break;
			}
		}
		return results;
		
	}
	
	
	
     public void countCSVRowFunc() {
		
		String csvFilePath = "src/test/resources/SnowFlake_RawData/T00 - GL Post Date Added 2023_02_01_081301.csv";
		
		
        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
            // Skip the header row
            br.readLine();

            // Count the remaining rows
            while (br.readLine() != null) {
                rowCount++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        CSVrowCount = rowCount-1;
        System.out.println("Row count: " + CSVrowCount);
		
	}
     
     
     
     public void countDBRowFunc() throws SQLException, Exception {
 		
    	 String query = "\n"
 		 		+ "SELECT count(GL_ACCOUNT) AS COUNT\n"
 		 		+ "FROM RAW.GL.TBL_M3_CSV WHERE\n"
 		 		+ "FILE_NAME LIKE '%T00%'";
    	 
    	  System.out.println("Query : " + query);
 		 
 		 st = SnowFlakeDBConnection.getConnection().createStatement();
 	        rs = st.executeQuery(query);

 	        while (rs.next()) {
 	         
 	            noOfCOUNT = rs.getInt("COUNT");
 	            
 	           System.out.println("DB count : " +noOfCOUNT);
 	        }
 		
 	}
	
	
     public boolean verifyCountOfCSVdbFunc() {
    	 
    	 if(noOfCOUNT==CSVrowCount)
    	 {
    		 return true;
    	 }else {
    		 return false;
    	 }
    	 
     }
     
     
     
     
     
     
     
}
