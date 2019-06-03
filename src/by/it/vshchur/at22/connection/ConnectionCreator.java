package by.it.vshchur.at22.connection;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionCreator {
    Connection get() throws SQLException;
}
