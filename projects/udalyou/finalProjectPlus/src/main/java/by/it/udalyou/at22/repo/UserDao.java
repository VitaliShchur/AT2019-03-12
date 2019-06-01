package by.it.udalyou.at22.repo;

import by.it.udalyou.at22.beans.User;
import by.it.udalyou.at22.connection.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;


public class UserDao implements interfaseDAO<User> {

private ConnectionCreator connectionCreator;

    public UserDao(ConnectionCreator connectionCreator) {
        this.connectionCreator = connectionCreator;
    }

    @Override
    public User read(long id) throws SQLException {
        User user1 = null;
        String sql = "SELECT * FROM `udalyou`.`user` WHERE id=" + id;
          try (
                Connection connection = connectionCreator.get();
                Statement statement = connection.createStatement()
        ) {
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                user1 = new User(
                        resultSet.getLong("id"),
                        resultSet.getString("username"),
                        resultSet.getString("password"),
                        resultSet.getString("email"),
                        resultSet.getDate("create_time")
                );
            }
        }
        return user1;
    }

    @Override
    public boolean create(User user1) throws SQLException {

        String sql = String.format("insert INTO `udalyou`.`user` " +
                        "(username, email, password, create_time)" +
                        "values ('%s','%s','%s','%s')",
    user1.getUsername(), user1.getEmail(), user1.getPassword(), user1.getDate()
        );

        try (
                Connection connection = connectionCreator.get();
                Statement statement = connection.createStatement()
        ) {
            if (1 == statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS)) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    long id = generatedKeys.getLong(1);
                    user1.setId(id);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean update(User user1) throws SQLException {

        String sql = String.format("update `udalyou`.`user` " +
                        " SET username='%s', email='%s', password='%s', " +
                        "create_time='%s'" + " WHERE id='%d'",
                user1.getUsername(), user1.getEmail(), user1.getPassword(),
                user1.getDate(), user1.getId() );

        try (
                Connection connection = connectionCreator.get();
                Statement statement = connection.createStatement()
        ) {
            return (1 == statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS));
        }
    }

    @Override
    public boolean delete(User user1) throws SQLException {

        String sql = String.format("DELETE FROM `udalyou`.`user` " +
                " WHERE id='%d'", user1.getId() );

        try (
                Connection connection = connectionCreator.get();
                Statement statement = connection.createStatement()
        ) {
            return (1 == statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS));
        }
    }

    @Override
    public List<User> getAll() throws SQLException {

        return null;
    }
}
