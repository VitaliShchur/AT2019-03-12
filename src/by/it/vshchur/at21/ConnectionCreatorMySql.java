package by.it.vshchur.at21;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionCreatorMySql implements ConnectionCreator {


    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver not found");
        }
    }

    private final static String URL = ""+
            "jdbc:mysql://127.0.0.1:3306/vshchur" +
            "?useUnicode=true" +
            "&useJDBCCompliantTimezoneShift=true" +
            "&useLegacyDatetimeCode=false" +
            "&serverTimezone=UTC";
    private static final  String LOGIN = "root";
    private static final String PASSWORD = "";

    @Override
    public Connection get() throws SQLException {
        return DriverManager.getConnection(URL, LOGIN, PASSWORD);
    }
}
