package gestabs.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource {
	
	public static DataSource INSTANCE = new DataSource(); 
	
	private DataSource() {
		try {
			Class.forName("org.h2.Driver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Impossible de charger le driver JDBC");
		}
	}
	
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:h2:~/database", "sa", "");
	}

}
