package by.it.agrinkevich.at22.repo;

import java.sql.SQLException;
import java.util.List;

public interface InterfaceDAO<TYPE>{
    TYPE read(long id) throws SQLException;

    boolean create(TYPE bean) throws SQLException;

    boolean update(TYPE bean) throws SQLException;

    boolean delete(TYPE bean) throws SQLException;

    List<TYPE> getAll() throws SQLException;
}
