package by.it.agrinkevich.at22;

import by.it.agrinkevich.at22.beans.User;
import org.junit.Test;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

import static by.it.agrinkevich.at22.DAO.TypeDAO.H2;
import static org.junit.Assert.assertEquals;

public class UserDAOTest {

    Date date = Timestamp.valueOf(LocalDateTime.now());
    DAO dao=new DAO(H2);
    User user = new User(0, "Sam", "12345", "test2@domain.com", date);

    @Test(timeout = 5000)
    public void userDAOCreateTest() throws Exception{
        dao.user.create(user);
        User user2 = dao.user.read(user.getId());
        assertEquals(user,user2);
        System.out.println(user);
    }

    /*@Test(timeout = 5000)
    public void userDAOUpdateTest() throws Exception{
        user.setUsername("Masha");
        dao.user.update(user);
        user = dao.user.read(user.getId());
        assertEquals("Masha",user.getUsername());
        System.out.println("user after update: " + user);
    }*/

    @Test(timeout = 5000)
    public void userDAODeleteTest() throws Exception {
        dao.user.delete(user);
        user = dao.user.read(user.getId());
        assertEquals(null, user);
        System.out.println("user after delete: " + user);
    }
}
