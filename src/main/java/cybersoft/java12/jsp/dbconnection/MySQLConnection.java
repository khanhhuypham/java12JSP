package cybersoft.java12.jsp.dbconnection;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class MySQLConnection {
	private static String url = "jdbc:mysql://localhost:3306/customerdb";
	private static String username = "root";
	private static String password = "1234";
	private static Connection connection = null;
	
	
	public static Connection getConnection() {
		if(connection != null)
			return connection;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection =  DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.print("Can not find MySQL DB Driver!!!");
		}catch (SQLException e) {
			e.printStackTrace();
			System.out.print("Can not connect to database due to: invalid url or invalid");
		}
		return connection;
	}
}
