package SnowFlake_pageObects;

import java.io.FileReader;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileNotFoundException;

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
	int  noOfCOUNT,FileCount;
	double sum_amount;
	 double totalAmount = 0.0;
    List<String> dataList = new ArrayList<>();
    List<String> CSVdataList = new ArrayList<>();
    int rowCount   = 0;
    int CSVrowCount;
    List<String[]> allRows = new ArrayList<>();
    List<String[]> allDataList = new ArrayList<>();
    
    String csvFilePath ;


	public TBL_M3_CSV_pageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void readCSVFileFunc(String path) {

		  String csvFilePath = path;
		   try (
		            FileReader reader = new FileReader(csvFilePath);
		            CSVParser csvParser = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(reader);
		        ) {
		            
		            // Iterate through CSV records
		            for (CSVRecord csvRecord : csvParser) {
		            	  System.out.println("csvRecord : " + csvRecord);
		            	  System.out.println("csvParser : " + csvParser);
		                // Ignore the first row (header)
		                if (csvRecord.getRecordNumber() > 1) {
		                	
		                	 System.out.println("csvRecord.getRecordNumber() : " + csvRecord.getRecordNumber());
		                	 
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
			                                       

		                }
		            }

		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		
	}
	
	
	public void readDBdataFunc(String fileName) throws SQLException, Exception {
		

		
		try {
	        System.setProperty("net.snowflake.client.log.loggerImpl", "net.snowflake.client.jdbc.internal.apache.log4j.Logger");
		 String query = "\n"
		 		+ "SELECT company_code,company_name,property_code,property_name,batch_id,batch_type,trans_type,vendor_id,invoice_no,invoice_date,GL_ACCOUNT,post_date,description,reference,amount\n"
		 		+ "FROM RAW.GL.TBL_M3_CSV WHERE\n"
		 		+ "company_code = "+csvColumn1+" and \n"
		 		+ "company_name = '"+csvColumn2+"' and\n"
		 		+ "batch_id = '"+csvColumn5+"' and \n"
		 		+ "GL_ACCOUNT = "+csvColumn11+" and \n"
		 		+ "FILE_NAME LIKE '"+fileName+"'";
		 
		   System.out.println("================================================================================================================================================================");
		   System.out.println("*                                                                                                                                                              *");
		   System.out.println("*                                                                                                                                                              *");
	   	   System.out.println("Query : " + query);
	   	   System.out.println("*                                                                                                                                                              *");
	   	   System.out.println("*                                                                                                                                                              *");
	   	   System.out.println("=================================================================================================================================================================");
	   	  
	   	  
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
	        	          
	        }
		}catch (Exception e) {
	        e.printStackTrace();
		
	}
	}
	
	
	public boolean verifyCSVdbFunc() {
		
		boolean results = false;
		
		for (int i = 0 ; i<dataList.size() ; i++) {
			if(CSVdataList.get(i).contains(dataList.get(i))) {
				results= true;
			}else {
				results = false;
				break;
			}
		}
		return results;
		
	}
	
	
	
	
//	public void countCSVRowFunc(String path) {
//
//	    String csvFilePath = path;
//
//	    try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
//	        // Skip the header row
//	        br.readLine();
//
//	        // Count the remaining rows
//	        while (br.readLine() != null) {
//	            rowCount++;
//	        }
//	    } catch (FileNotFoundException e) {
//	        System.err.println("File not found: " + csvFilePath);
//	        e.printStackTrace();
//	    } catch (IOException e) {
//	        System.err.println("Error reading the file: " + csvFilePath);
//	        e.printStackTrace();
//	    }
//
//	    CSVrowCount = rowCount-1;
//	    System.out.println("=========CSVrowCount==========="+CSVrowCount);
//	}

	public void countCSVRowFunc(String path) {
	    String csvFilePath = path;

	    // Reset rowCount for each file
	    rowCount = 0;

	    try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
	        // Skip the header row
	        br.readLine();

	        // Count the remaining rows
	        String line;
	        while ((line = br.readLine()) != null) {
	            line = line.replaceAll("\r", "");
	            rowCount++;
	        }

	    } catch (FileNotFoundException e) {
	        System.err.println("File not found: " + csvFilePath);
	        e.printStackTrace();
	    } catch (IOException e) {
	        System.err.println("Error reading the file: " + csvFilePath);
	        e.printStackTrace();
	    }

	    CSVrowCount = rowCount-1;
	    
	}
	
	
	
	public void countCSVRowFunc_2(String path) {
	    String csvFilePath = path;

	    // Reset rowCount for each file
	    rowCount = 0;

	    try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
	        // Skip the header row
	        br.readLine();

	        // Count the remaining rows
	        String line;
	        while ((line = br.readLine()) != null) {
	            line = line.replaceAll("\r", "");
	            rowCount++;
	        }

	    } catch (FileNotFoundException e) {
	        System.err.println("File not found: " + csvFilePath);
	        e.printStackTrace();
	    } catch (IOException e) {
	        System.err.println("Error reading the file: " + csvFilePath);
	        e.printStackTrace();
	    }

	    CSVrowCount = rowCount;

	}


     
     
     public void countDBRowFunc(String fileName) throws SQLException, Exception {
 		
    	 String query = "\n"
 		 		+ "SELECT count(GL_ACCOUNT) AS COUNT\n"
 		 		+ "FROM RAW.GL.TBL_M3_CSV WHERE\n"
 		 		+ "FILE_NAME LIKE '"+fileName+"'";
    	 
       System.out.println("================================================================================================================================================================");
	   System.out.println("*                                                                                                                                                              *");
	   System.out.println("*                                                                                                                                                              *");
   	   System.out.println("Query : " + query);
   	   System.out.println("*                                                                                                                                                              *");
   	   System.out.println("*                                                                                                                                                              *");
   	  System.out.println("=================================================================================================================================================================");
 		 
 		 st = SnowFlakeDBConnection.getConnection().createStatement();
 	        rs = st.executeQuery(query);

 	        while (rs.next()) {
 	            noOfCOUNT = rs.getInt("COUNT");
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
     
     
     
     public void readCSVSumAmoutFunc(String path) {
    	 
    	 String csvFilePath =path;
    	   

    	    try (
    	        FileReader reader = new FileReader(csvFilePath);
    	        CSVParser csvParser = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(reader);
    	    ) {
    	        // Iterate through CSV records
    	        for (CSVRecord csvRecord : csvParser) {
    	            // Ignore the first row (header)
    	            if (csvRecord.getRecordNumber() > 0) {
    	                // ... (Your existing code for reading other columns)
    	                // Read and accumulate the "Amount" column value
    	                String amountStr = csvRecord.get("Amount");
    	                double amount = amountStr.trim().isEmpty() ? 0.0 : Double.parseDouble(amountStr);
    	                totalAmount += amount;
    	                
    	                // ... (Your existing code for populating CSVdataList)
    	            }
    	        }

    	        // Print the total sum of "Amount" column values
    	        System.out.println("Total Amount: " + totalAmount);

    	    } catch (Exception e) {
    	        e.printStackTrace();
    	    }
    	 
     }
     
     
     
     public void readDBSumAmoutFunc(String fileName) throws SQLException, Exception {
    	 
    	 String query = "select sum(amount) as SUM_AMOUNT\n"
    	 		+ "from RAW.GL.TBL_M3_CSV\n"
    	 		+ "where FILE_NAME like  '"+fileName+"' ";
     	
    	  System.out.println("================================================================================================================================================================");
	        System.out.println("*                                                                                                                                                            *");
	        System.out.println("*                                                                                                                                                            *");
     	    System.out.println("Query : " + query);
     	    System.out.println("*                                                                                                                                                            *");
     	    System.out.println("*                                                                                                                                                            *");
     	  System.out.println("================================================================================================================================================================");
     	  
     	  
  		 st = SnowFlakeDBConnection.getConnection().createStatement();
  	        rs = st.executeQuery(query);

  	        while (rs.next()) {
  	            sum_amount = rs.getDouble("SUM_AMOUNT");
  	            System.out.println("DB SUM Amount : " +sum_amount);
  	        }
  		
    	 
     }
     
     
     
 public boolean verifySumAmountOfCSVdbFunc() {
    	 
    	 if(sum_amount==totalAmount)
    	 {
    		 return true;
    	 }else {
    		 return false;
    	 }
    	 
     }
     
 
 //4th ==================================================================================================================================================
 
 
 public void readAllCSVFileFunc(String path) {
	     csvFilePath = path;
	  

	    try (
	        FileReader reader = new FileReader(csvFilePath);
	        CSVParser csvParser = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(reader);
	    ) {
	        // Iterate through CSV records
	        for (CSVRecord csvRecord : csvParser) {
	      
	            // Ignore the first row (header)
	            if (csvRecord.getRecordNumber() > 0) {

	                // Store the row data in an array
	                String[] rowData = new String[csvRecord.size()];
	                for (int i = 0; i < csvRecord.size(); i++) {
	                    rowData[i] = csvRecord.get(i);
	                }
	                
	                // Add the row to the list
	                allRows.add(rowData);
	            }
	        }

	        // Print all rows
	        for (String[] row : allRows) {
	            System.out.println("CSV Row DATA : " + Arrays.toString(replaceEmptyWithNull(row)));
	        }
	        

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	private String[] replaceEmptyWithNull(String[] row) {
	    for (int i = 0; i < row.length; i++) {
	        if (row[i].trim().isEmpty()) {
	            row[i] = "null";
	        }
	    }
	    return row;
	}

 
 

	
	public void readAllDBdataFunc(String fileName) throws SQLException, Exception {
	    try {
	        String readAllDBdataFunc_query = "\n"
	                + "SELECT company_code,company_name,property_code,property_name,batch_id,batch_type,trans_type,vendor_id,invoice_no,invoice_date,GL_ACCOUNT,post_date,description,reference,amount\n"
	                + "FROM RAW.GL.TBL_M3_CSV WHERE  FILE_NAME LIKE '" + fileName + "'";

	        System.out.println(
	                "================================================================================================================================================================");
	        System.out.println("*                                                                                                                                                              *");
	        System.out.println("*                                                                                                                                                              *");
	        System.out.println(readAllDBdataFunc_query);
	        System.out.println("*                                                                                                                                                              *");
	        System.out.println("*                                                                                                                                                              *");
	        System.out.println(
	                "=================================================================================================================================================================");

	        st = SnowFlakeDBConnection.getConnection().createStatement();
	        rs = st.executeQuery(readAllDBdataFunc_query);

	        // Move dataList.clear() outside the while loop
	        dataList.clear();

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
	            String actualDataSet15 = rs.getString("AMOUNT");

	            dataList.add(actualDataSet1 == null ? "null" : actualDataSet1);
	            dataList.add(actualDataSet2 == null ? "null" : actualDataSet2);
	            dataList.add(actualDataSet3 == null ? "null" : actualDataSet3);
	            dataList.add(actualDataSet4 == null ? "null" : actualDataSet4);
	            dataList.add(actualDataSet5 == null ? "null" : actualDataSet5);
	            dataList.add(actualDataSet6 == null ? "null" : actualDataSet6);
	            dataList.add(actualDataSet7 == null ? "null" : actualDataSet7);
	            dataList.add(actualDataSet8 == null ? "null" : actualDataSet8);
	            dataList.add(actualDataSet9 == null ? "null" : actualDataSet9);
	            dataList.add(actualDataSet10 == null ? "null" : actualDataSet10);
	            dataList.add(actualDataSet11 == null ? "null" : actualDataSet11);
	            dataList.add(actualDataSet12 == null ? "null" : actualDataSet12);
	            dataList.add(actualDataSet13 == null ? "null" : actualDataSet13);
	            dataList.add(actualDataSet14 == null ? "null" : actualDataSet14);
	            dataList.add(actualDataSet15 == null ? "null" : actualDataSet15);
	        }

	        // Print dataList after all rows have been added
	        System.out.println("=======Data Base Data =================" + dataList);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}



	public boolean compareData() {
	    // Assuming allRows and dataList are class members or accessible within this method
	    boolean flag = true;
	    int numColumns = allRows.get(0).length; // Assuming all rows have the same number of columns
	    int rowIndex = 0; // Initialize the row index

	    // Iterate through each row in allRows
	    for (String[] csvRow : allRows) {
	        // Iterate through each element in the row
	        for (int i = 0; i < csvRow.length; i++) {
	            String csvValue = csvRow[i];
	            String dbValue = dataList.get(rowIndex * numColumns + i);

	            // Compare csvValue and dbValue
	            if (!csvValue.trim().equals(dbValue.trim())) {
	                System.out.println("Mismatch found at row " + Arrays.toString(csvRow) + " - Column " + i
	                        + ": CSV value = " + csvValue + ", DB value = " + dbValue);
	                flag = false;
	                break;
	            }
	        }
	        rowIndex++; // Increment the row index for the next iteration
	    }
	    return flag;
	}

	
	
	
//	  public void fileCountFunc() throws SQLException, Exception {
//	 		
//	    	 String fileCountFunc_query = "SELECT COUNT(DISTINCT FILE_NAME) AS UniqueFileCount FROM RAW.GL.TBL_M3_CSV WHERE COMPANY_CODE = "+csvColumn1+" AND PROPERTY_CODE = "+csvColumn3+"\n"
//	    	 		+ "  AND BATCH_ID = '"+csvColumn5+"' AND POST_DATE = '"+csvColumn12+"'";
//	    	 
//	       System.out.println("================================================================================================================================================================");
//		   System.out.println("*                                                                                                                                                              *");
//		   System.out.println("*                                                                                                                                                              *");
//	   	   System.out.println("fileCountFunc_query : " + fileCountFunc_query);
//	   	   System.out.println("*                                                                                                                                                              *");
//	   	   System.out.println("*                                                                                                                                                              *");
//	   	  System.out.println("=================================================================================================================================================================");
//	 		 
//	 		 st = SnowFlakeDBConnection.getConnection().createStatement();
//	 	        rs = st.executeQuery(fileCountFunc_query);
//
//	 	        
//	 	       while (rs.next()) {
//	 	    	    FileCount = rs.getInt(1);
//	 	    	}
//
//
//	 		
//	 	}
//	
//	  public boolean verifyduplicateCountFunc() {
//	    	 
//	    	 if(FileCount==0)
//	    	 {
//	    		 return true;
//	    	 }else {
//	    		 return false;
//	    	 }
//	    	 
//	     }
	
     
}
