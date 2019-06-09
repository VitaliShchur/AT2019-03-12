package by.it.vshchur.at22;

import by.it.vshchur.at22.beans.User;
import org.junit.Test;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

import static by.it.vshchur.at22.Dao.TypeDao.H2;
import static org.junit.Assert.*;


public class UserDaoTest {


    @Test(timeout = 5000)
    public void userDaoCreateTest() throws Exception{
        Dao dao=new Dao(H2);
        Date date = Timestamp.valueOf(LocalDateTime.now());
        User user = new User(0, "NEW_LOGIN", "NEW_PASSWORD", "NEW_EMAIL", (Date)date);
        dao.user.create(user);
        User user2 = dao.user.read(user.getId());
        assertEquals(user,user2);
    }

    @Test(timeout = 5000)
    public void userDaoUpdateTest() throws Exception {
        Dao dao=new Dao(H2);
        Date date = Timestamp.valueOf(LocalDateTime.now());
        User user = new User(2, "LOGIN2", "PASSWORD2", "EMAIL2", (Date)date);
        dao.user.create(user);
        String email = user.getEmail();
        user.setEmail("EMAIL2_updated");
        dao.user.update(user);
        User user2 = dao.user.read(user.getId());
        assertNotEquals(email, user2.getEmail());
        assertEquals(user2.getEmail(), "EMAIL2_updated");
    }

    @Test(timeout = 5000)
    public void userDaoDeleteTest() throws Exception {
        Dao dao=new Dao(H2);
        Date date = Timestamp.valueOf(LocalDateTime.now());
        User user = new User(3, "LOGIN3", "PASSWORD3", "EMAIL3", (Date)date);
        dao.user.create(user);
        dao.user.delete(user);
        User readUser = dao.user.read(user.getId());
        assertNull(readUser);
    }
    
}
