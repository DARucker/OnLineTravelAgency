package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * This class is used to generate the object with the connection with the database
 */
public class Connector {
	
	
    private final static String url = "jdbc:mysql://localhost:3306/travel_search";
    private final static String user = "root";
    private final static String pass = "administrador";

	/**
	 * This method returns the object of the class Connection used to make the
	 * connection with the database
	 * @return Connection
	 */
	public Connection connector() throws SQLException {

		Connection myConnection = DriverManager.getConnection(url, user, pass);

		return myConnection;

	}
}
