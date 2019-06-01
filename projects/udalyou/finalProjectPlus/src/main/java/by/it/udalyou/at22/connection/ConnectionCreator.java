package by.it.udalyou.at22.connection;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionCreator {



    Connection get()throws SQLException;
}
