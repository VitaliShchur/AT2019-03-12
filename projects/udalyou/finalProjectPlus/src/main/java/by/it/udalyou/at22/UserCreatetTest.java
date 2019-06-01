package by.it.udalyou.at22;


import by.it.udalyou.at22.beans.User;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.sql.Timestamp;

public class UserCreatetTest {
    @Test(timeOut = 10000)
    public void createUser() throws Exception{

        Dao dao = new Dao(Dao.TypeDao.H2);
        Timestamp timestamp = new Timestamp(55555555);
        User user = new User(0,"username", "556677", "user@yandex.ru", timestamp);
        dao.user.create(user);
        User user2 = dao.user.read(user.getId());
        Assert.assertEquals(user,user2);
      //  System.out.println(user);
       // System.out.println(user2);
       // System.out.println(user.equals(user2));
    }
}
