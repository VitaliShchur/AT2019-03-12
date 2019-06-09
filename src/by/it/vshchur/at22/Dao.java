package by.it.vshchur.at22;

import by.it.vshchur.at22.connection.ConnectionCreator;
import by.it.vshchur.at22.connection.ConnectionCreatorH2;
import by.it.vshchur.at22.connection.ConnectionCreatorMySql;
import by.it.vshchur.at22.repo.UserDao;
import by.it.vshchur.at22.repo.CategoryDao;

import java.util.NoSuchElementException;

public class Dao {

    enum TypeDao {
        MY_SQL, H2
    }

    //all bean DAO
    public UserDao user;
    public CategoryDao category;

    public Dao(TypeDao typeDao) {
        ConnectionCreator connectionCreator;
        switch (typeDao) {
            case MY_SQL:
                connectionCreator = new ConnectionCreatorMySql();
                break;
            case H2:
                connectionCreator = new ConnectionCreatorH2();
                break;
            default:
                throw new NoSuchElementException("connection type isn't defined");
        }
        user = new UserDao(connectionCreator);
        category = new CategoryDao(connectionCreator);
    }
}
