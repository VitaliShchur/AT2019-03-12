package by.it.okoyro.at22.connection;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionCreatorH2 implements ConnectionCreator {

	static {
		URL resource = ConnectionCreatorH2.class.getClassLoader() // resource is null!!!!
				.getResource("okoyro.sql");
		String sqlFile = resource.toString();
		try {
			DriverManager.getConnection("jdbc:h2:mem:test;" +     // mem - DB is created in memory
										"INIT=RUNSCRIPT FROM '" + sqlFile + "'");
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Connection get() throws SQLException {
		return DriverManager.getConnection("jdbc:h2:mem:test");
	}
}
