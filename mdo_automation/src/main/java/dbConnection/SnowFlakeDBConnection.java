package dbConnection;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class SnowFlakeDBConnection {
	
	
	private static WebDriver driver;
	


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
	
	
	
	
	
	public static Connection getConnection() throws Exception {
	    try {
	        Class.forName("net.snowflake.client.jdbc.SnowflakeDriver");
	        String encodedPassword = URLEncoder.encode("NbeUelR+Q?VKh{vU", StandardCharsets.UTF_8.toString());
	        String jdbcUrl = "jdbc:snowflake://hlb66479.us-east-1.snowflakecomputing.com:443/?user=sannorj&password=" + encodedPassword;

	        Connection connection = DriverManager.getConnection(jdbcUrl);
	        return connection;
	    } catch (Exception e) {
	        // Handle other exceptions
	        throw e;
	    }
	}




	
	}



