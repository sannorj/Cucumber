package dbConnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	private static Connection con;

	public static Connection getConnection() throws Exception {
		//Class.forName("com.postgresql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:postgresql://myp2-dev-reports.cspsockiiy7v.us-east-2.rds.amazonaws.com:5432/dev_myp2_reports", "mydigitaloffice", "CGB4sbN8Hk6Z");
		return con;
	}
}
