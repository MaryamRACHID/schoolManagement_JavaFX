package classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Access {
	public static Connection connectDB(String dbname) throws ClassNotFoundException {
		String databaseURL = "jdbc:mysql://localhost:3306/" + dbname;
		String user = "root";
		String password = ""; 
		Connection cnx = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cnx = DriverManager.getConnection(databaseURL, user, password);
 
			if (cnx != null) {
				System.out.println("Connected to the database");
	
				return cnx;
			} else
				return null;

		} catch (SQLException ex) {
			System.out.println("An error occurred. Maybe user/password is invalid");
			ex.printStackTrace();
		}

		return null;
	}
}
