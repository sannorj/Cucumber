package dbConnection;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.sql.ResultSet;
import java.sql.Statement;

public class SnowFlakeDBConnection {
	
	private static Connection con;
	private static WebDriver driver;
	private Statement st;
	private ResultSet rs;


	public SnowFlakeDBConnection(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//label[text()='Sign in to Snowflake']")
	static
	WebElement lblLogin;
	
	@FindBy(xpath = "//span[text()='Worksheets']")
	static
	WebElement lblhome;
	
	

	    // ... existing code

//	    public static Statement getSnowFlakeConnection() throws Exception {
//	    	
//	    	
//	    	   try {
//	   			driver.get("https://hlb66479.us-east-1.snowflakecomputing.com/");
//	   		} catch (Exception e) {
//	   			// TODO Auto-generated catch block
//	   			e.printStackTrace();
//	   		}
//	   
//	           Thread.sleep(40000);
//	           WebElement usernameInput = driver.findElement(By.xpath("(//input[@data-ref='inputEl'])[1]"));
//	           WebElement passwordInput = driver.findElement(By.xpath("(//input[@data-ref='inputEl'])[2]"));
//	           WebElement loginButton = driver.findElement(By.xpath("//span[@data-ref='btnEl']"));
//	   
//	           // Enter your Snowflake username and password
//	           usernameInput.sendKeys("sannorj");
//	           passwordInput.sendKeys("NbeUelR+Q?VKh{vU");
//	   
//	           // Click the login button
//	           loginButton.click();
//	           Thread.sleep(40000);
//	    		   
//	        try {
//	            // Load the Snowflake JDBC driver
//	            Class.forName("net.snowflake.client.jdbc.SnowflakeDriver");
//
//	            String encodedPassword = URLEncoder.encode("NbeUelR+Q?VKh{vU", StandardCharsets.UTF_8.toString());
//	          //  String jdbcUrl = "jdbc:snowflake://hlb66479.us-east-1.snowflakecomputing.com/"
//	           //                 + "?user=sannorj&password=" + encodedPassword + "&db=RAW&schema=GL";
//	            
//	            
//	              String jdbcUrl = "jdbc:snowflake://hlb66479.us-east-1.snowflakecomputing.com:443?/"
//		                            + "?user=sannorj&password=" + encodedPassword;
//		            
//	            //  snowflake://hlb66479.us-east-1.snowflakecomputing.com:443?warehouse=WH_TEST_AUTOMATION&db=DB_EDU
//	            //String jdbcUrl ="jdbc:snowflake://hlb66479.us-east-1.snowflakecomputing.com:443?warehouse=ROL_DWH_DEV_QA&db=DB_EDU";
//	            
//
//	            Connection connection = DriverManager.getConnection(jdbcUrl);
//	          
//
//	            System.out.println("-----working=========");
//
//	            System.out.println("-----connection========="+connection);
//	            return (Statement) connection;
//	          
//	        }
//	        catch (Exception e) {
//	        	 System.out.println("-----eeee========="+con);
//	           e.printStackTrace();
//	       }
//	        System.out.println("-----con========="+con);
//	        return (Statement) con;
//	        
//	    }
	
	
	

//	public static Connection getConnection() throws Exception {
//		
//		Class.forName("net.snowflake.client.jdbc.SnowflakeDriver");
//		con = DriverManager.getConnection("jdbc:snowflake://hlb66479.us-east-1.snowflakecomputing.com:443", "sannorj", "NbeUelR+Q?VKh{vU");
//
//		
//		//con = DriverManager.getConnection("jdbc:snowflake://hlb66479.us-east-1.snowflakecomputing.com:443", "sannorj", "NbeUelR+Q?VKh{vU");
//		return con;
//	}
	
	
	
	
	public static Connection getConnection() throws Exception {
	    try {
	        Class.forName("net.snowflake.client.jdbc.SnowflakeDriver");
	        String encodedPassword = URLEncoder.encode("NbeUelR+Q?VKh{vU", StandardCharsets.UTF_8.toString());
	        String jdbcUrl = "jdbc:snowflake://hlb66479.us-east-1.snowflakecomputing.com:443/?user=sannorj&password=" + encodedPassword;

	        Connection connection = DriverManager.getConnection(jdbcUrl);
	        System.out.println("=========working========" +connection);
	        return connection;
	    } catch (Exception e) {
	        // Handle other exceptions
	        throw e;
	    }
	}




	
	}



