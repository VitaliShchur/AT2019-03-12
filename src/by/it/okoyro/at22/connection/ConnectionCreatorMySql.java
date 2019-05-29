package by.it.okoyro.at22.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionCreatorMySql implements ConnectionCreator {

//	static {
//		try { //mysql-connector 8.0.15
//			Class.forName("com.mysql.cj.jdbc.Driver");
//		}
//		catch (ClassNotFoundException e) {
//			System.out.println("Not found Driver");
//		}
//	}

	private static final String URL = "jdbc:mysql://localhost:3306/okoyro?useSSL=false" +
									  "&connectTimeout=0" +
									  "&autoReconnect=true" +
									  "&useUnicode=true" +
									  "&characterEncoding=UTF-8";
	//							+
	//							"useJDBCCompliantTimezoneShift = true&" +
	//							"useLegacyDatetimeCode = false&" +
	//							"serverTimezone = UTC",
	private static final String USER = "root";
	private static final String PASSWORD = "password";

	@Override
	public Connection get() throws SQLException {
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}
}
