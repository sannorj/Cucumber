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
	public static Connection getmyp1Connection() throws Exception {
		//Class.forName("com.postgresql.jdbc.Driver");
		
//		String jumpServerHost = "18.210.213.83";
//        String jumpServerUsername = "Nalina";
//        String jumpServerPassword = "bWSTUk9rwZnEf";
//        int jumpServerPort = 8881; // SSH port
//
//        String mysqlHost = "10.0.0.115";//"mysql_server_host";
//        int mysqlPort = 3306; // MySQL port
//		
//        try {
//            JSch jsch = new JSch();
//            Session session = jsch.getSession(jumpServerUsername, jumpServerHost, jumpServerPort);
//            session.setPassword(jumpServerPassword);
//            session.setConfig("StrictHostKeyChecking", "no");
//            session.connect();
//
//            int assignedPort = session.setPortForwardingL(0, mysqlHost, mysqlPort);
//            System.out.println("SSH Tunnel established. Local port: " + assignedPort);
//
//            // Now you can connect to the MySQL database using the assigned local port.
//            // Use the MySQL JDBC driver and the connection details.
//
//            // Don't forget to close the SSH session and tunnel when done.
//            session.disconnect();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        
//        
//        String jdbcUrl = "jdbc:mysql://localhost:assigned_port/db_name";
//        String dbUsername = "NimeshaD";
//        String dbPassword = "PbS&36zd[F";
//
//        try {
//            Connection connection = DriverManager.getConnection(jdbcUrl, dbUsername, dbPassword);
//            // Perform database operations using the connection
//
//            // Close the MySQL connection when done
//            connection.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
		
		
//		 String connectionUrl =
//	                "jdbc:sqlserver://yourserver.database.windows.net:1433;"
//	                        + "database=AdventureWorks;"
//	                        + "user=yourusername@yourserver;"
//	                        + "password=yourpassword;"
//	                        + "encrypt=true;"
//	                        + "trustServerCertificate=false;"
//	                        + "loginTimeout=30;";
//
//	        try (Connection connection = DriverManager.getConnection(connectionUrl);) {
//	            // Code here.
//	        }
//	        // Handle any errors that may have occurred.
//	        catch (SQLException e) {
//	            e.printStackTrace();
//	        }
		
		
		con = DriverManager.getConnection("jdbc:sqlserver://10.0.0.115:8881/Perspective", "NimeshaD", "PbS&36zd[F");
		return con; 
	}
}
