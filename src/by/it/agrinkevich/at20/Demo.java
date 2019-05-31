package by.it.agrinkevich.at20;

import java.sql.*;
import java.time.LocalDateTime;

public class Demo {
    static {
        try { //mysql-connector 8.0.15
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Not found Driver");
        }
    }

    public static void main(String[] args) throws SQLException {
        System.out.println(Timestamp.valueOf(LocalDateTime.now()));
        try (
                Connection connection = DriverManager.getConnection(
                        "jdbc:mysql://127.0.0.1:3306/agrinkevich?" +
                                "useUnicode=true&" +
                                "useJDBCCompliantTimezoneShift=true&" +
                                "useLegacyDatetimeCode=false&" +
                                "serverTimezone=UTC",
                        "root", "");
                Statement statement = connection.createStatement()
        ) {
            ResultSet resultSet = statement.executeQuery("select * from user");
            while (resultSet.next()) {
                System.out.printf("name: %-10s email:%-15s\n",
                        resultSet.getString("username"),
                        resultSet.getString("password")
                );
            }

        }
    }
}
