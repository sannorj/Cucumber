package myP1_pageObjects;

import java.io.FileReader;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import dbConnection.DBConnection;
import utils.ConstantsReader;

public class dbTest_myp1_PageObject {

	private WebDriver driver;
	private ConstantsReader configReader = new ConstantsReader();
	private Statement st;
	private ResultSet rs;
	private ResultSet rs1;
	String Actual, Base;
	SimpleDateFormat sdf;

	public dbTest_myp1_PageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		sdf = new SimpleDateFormat("yyyy-MM-dd");
	}

	public void selectTblValues(String table, String mdoglcode, String from_date, String to_date, String hotelid, String hre_type_id) {
		String csvFilePath = "./src/test/resources/myp1_Reports/test.csv";
		try {

			String query = "SELECT * FROM  "+ table + " where hotel_id = '" + hotelid+ "' and date Between '" + from_date + "' and '" + to_date + "' and mdo_gl_code ='" + mdoglcode + "' and hre_type_id ='" + hre_type_id + "' AND removed_at is NULL ";
			System.out.println("Query : " + query);
			st = DBConnection.getConnection().createStatement();
			rs = st.executeQuery(query);

			int iteration = 0; 
			while (rs.next()){

				System.out.println("Database Data==========");
				System.out.println("Actual data  : " + rs.getString(1));
				System.out.println("Actual data  : " + rs.getString(2));
				System.out.println("Actual data  : " + rs.getString(3));
				System.out.println("Actual data  : " + rs.getString(4));
				System.out.println("Actual data  : " + rs.getString(5));
				System.out.println("**********************************");
				
				
				try (FileReader fileReader = new FileReader(csvFilePath);
			             CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT)) {
			
					 	var records = csvParser.getRecords();
					 	int x=iteration+1;
			            if (!records.isEmpty()) {
			                var firstRecord = records.get(x);
			                String id = firstRecord.get(0);
			                String mdoGlCode = firstRecord.get(1);
			                String hotelId = firstRecord.get(2);
			                String date = firstRecord.get(3);
			                String hreTypeId = firstRecord.get(4);
			                System.out.println("Report File Data =============");
			                System.out.println("id: " + id + ", mdo_gl_code: " + mdoGlCode
			                        + ", hotel_id: " + hotelId + ", date: " + date
			                        + ", hre_type_id: " + hreTypeId);
			            } else {
			                System.out.println("CSV file is empty. No records to process.");
			            }
		           
						System.out.println("///////////////////////////////////////////////////");
			        } catch (IOException e) {
			            e.printStackTrace();
			        }
				
				iteration++;
			}
			
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
