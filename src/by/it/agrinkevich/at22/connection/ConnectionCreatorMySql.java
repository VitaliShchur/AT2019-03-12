package by.it.agrinkevich.at22.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionCreatorMySql implements ConnectionCreator {
    static {
        try { //mysql-connector 8.0.15
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Not found Driver");
        }
    }

    private static final String URL = "" +
            "jdbc:mysql://127.0.0.1:3306/agrinkevich" +
            "?useUnicode=true" +
            "&useJDBCCompliantTimezoneShift=true" +
            "&useLegacyDatetimeCode=false" +
            "&serverTimezone=UTC";
    private static final String LOGIN="root";
    private static final String PASSWORD="";

    @Override
    public Connection get() throws SQLException {
        return DriverManager.getConnection(URL,LOGIN,PASSWORD);
    }
}
