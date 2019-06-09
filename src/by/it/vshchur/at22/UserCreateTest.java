package by.it.vshchur.at22;

import by.it.vshchur.at22.Dao;
import by.it.vshchur.at22.beans.User;
import org.junit.Test;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

import static by.it.vshchur.at22.Dao.TypeDao.H2;
import static org.junit.Assert.assertEquals;


public class UserCreateTest {


    @Test(timeout = 5000)
    public void createUser() throws Exception{
        //проверим создание
        Dao dao=new Dao(H2);
        Date date = Timestamp.valueOf(LocalDateTime.now());
        User user = new User(0, "NEW_LOGIN", "NEW_PASSWORD", "NEW_EMAIL", date);
        dao.user.create(user);
        User user2 = dao.user.read(user.getId());
        assertEquals(user,user2);
    }
}
