package by.it.udalyou.at22;

import by.it.udalyou.at22.beans.User;
//import org.testng.Assert;
import org.testng.annotations.*;
import java.sql.SQLException;
import java.sql.Timestamp;

public class UserDaoTest {

   // private UserDao userDao;

    @BeforeMethod
    public void setUp() throws Exception {
        // userDao = new UserDao();
    }

    @Test
    public void create() throws SQLException {

        Timestamp timestamp = new Timestamp(555555555);
        User user = new User(0,"username", "556677", "user@yandex.ru", timestamp);

    }

    @Test
    public void update() {
    }

    @Test
    public void delete() {
    }
}
