package by.it.udalyou.at22;

import by.it.udalyou.at22.connection.ConnectioCreatorH2;
import by.it.udalyou.at22.connection.ConnectionCreator;
import by.it.udalyou.at22.connection.ConnectionCreatorMySQL;
import by.it.udalyou.at22.repo.UserDao;

import java.util.NoSuchElementException;

public class Dao {
    enum TypeDao{
        MY_SQL,H2
    }
    public UserDao user;
    public Dao(TypeDao typeDao){

        ConnectionCreator connectionCreator;
        switch (typeDao){
            case MY_SQL:connectionCreator=new ConnectionCreatorMySQL();
            break;
            case H2:connectionCreator=new ConnectioCreatorH2();
            break;
            default:
                throw new NoSuchElementException("not define type of connection");

        }
        user=new UserDao(connectionCreator);
    }

}
