package by.it.udalyou.at22.connection;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectioCreatorH2 implements ConnectionCreator {

    static {
        URL resource = ConnectioCreatorH2.class.getClassLoader().
                getResource("udalyou.sql");
        String sqlFile=resource.toString();
       // String sqlFile=
        //  "C:/AT2019-03-12/src/by/it/udalyou/at21/create.sql";
        //"C:/AT2019-03-12/resources/akhmelev.sql";
        try {
           // DriverManager.getConnection("" +
             //       "jdbc:h2:mem:test;" +sqlFile);
            DriverManager.getConnection("jdbc:h2:mem:test;"+
                    "INIT=RUNSCRIPT FROM '"+sqlFile+"'");
        } catch (SQLException e) {



            e.printStackTrace();
        }
    }


    @Override
    public Connection get() throws SQLException {


        return DriverManager.getConnection("jdbc:h2:mem:test");
    }
}
