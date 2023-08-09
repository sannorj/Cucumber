package myP1_pageObjects;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

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

	public void selectTblValues() {
		String csvFilePath = "./src/test/resources/myp1_Reports/test.csv";
		try {
			String query = "SELECT id,mdo_gl_code,hotel_id,hre_type_id,sum_amount,sum_amount_adjustment,sum_total FROM  calculation_mdo_gl_code_actual where hotel_id = '832' and date Between '2021-03-15 00:00:00+00' and '2021-03-20 00:00:00+00' and mdo_gl_code ='RMREV90' and hre_type_id ='Revenue' AND removed_at is NULL ";

			System.out.println("Query : " + query);
			st = DBConnection.getConnection().createStatement();
			rs = st.executeQuery(query);


			int iteration = 0; 
			while (rs.next()){
				int columnCount = rs.getMetaData().getColumnCount();
				for (int i = 1; i <= columnCount; i++) {
					String currentTblCellValue=rs.getString(i);
			        System.out.println("Database Data column " + i + ": " + currentTblCellValue);
			        
			        
			        try (FileReader fileReader = new FileReader(csvFilePath);
				             CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT)) {
				
						 	var records = csvParser.getRecords();
						 	int rawId=iteration+1;
						 	int cell =i-1;
				            if (!records.isEmpty()) {
				                var firstRecord = records.get(rawId);
				                String fileval = firstRecord.get(cell);
				                System.out.println("Report File Data no: " + cell +"="+fileval );
				                System.out.println("Raw="+rawId+", column="+i);
				                compareDBFileData(currentTblCellValue,fileval,"test_report",rawId,i);				           

				            } else {
				                System.out.println("CSV file is empty. No records to process.");
				            }
			           
							System.out.println("==========================================");
				        } catch (IOException e) {
				            e.printStackTrace();
				        }
			        
				}
				System.out.println("**********************************");
				
				iteration++;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private void compareDBFileData(String currentTblCellValue, String fileval,String reportName,int raw,int col) {
		 String filePath = "./src/test/resources/myp1_Reports/results.xlsx";
		 checkAndCreteFilePath(filePath);
		 
	        String sheetName = reportName; 
	        int columnIndex = 0; 

	        try (Workbook workbook = new XSSFWorkbook(new FileInputStream(filePath))) {
	            int sheetIndex = workbook.getSheetIndex(sheetName);
	            
	            Sheet sheet = workbook.getSheet(sheetName);

	            if (sheet == null) {
	                sheet = workbook.createSheet(sheetName);
	            }

	            int nextEmptyRow = sheet.getLastRowNum() + 1; 
	            Row row = sheet.createRow(nextEmptyRow);
	            
	            boolean areEqualIgnoreCase = currentTblCellValue.equalsIgnoreCase(fileval); 
	            System.out.println("Strings are equal (case-insensitive): " + areEqualIgnoreCase);
	            
	            String isValuesEqual;
	            if(areEqualIgnoreCase) 
	            	isValuesEqual="true";
	            else 
	            	isValuesEqual="false";
	            
	            String[] rowData = {"Raw = "+raw, "column = "+col, currentTblCellValue,fileval,isValuesEqual};

	            for (int i = 0; i < rowData.length; i++) {
	                Cell cell = row.createCell(i);
	                cell.setCellValue(rowData[i]);
	            }

	            try (FileOutputStream outputStream = new FileOutputStream(filePath)) {
	                workbook.write(outputStream);
	            }

	            System.out.println("Data filled or sheet created successfully!"); 
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	}

	private void checkAndCreteFilePath(String filePath) {
		File file = new File(filePath);

        if (file.exists()) {
            System.out.println("File already exists.");
        } else {
            try (Workbook workbook = new XSSFWorkbook()) {
//                Sheet sheet = workbook.createSheet("Sheet1");

//                Row headerRow = sheet.createRow(0);
//                Cell headerCell = headerRow.createCell(0);
//                headerCell.setCellValue("Header");

                try (FileOutputStream outputStream = new FileOutputStream(file)) {
                    workbook.write(outputStream);
                }

                System.out.println("File created successfully.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
	}
	
}
