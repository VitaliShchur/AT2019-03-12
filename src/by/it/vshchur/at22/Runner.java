package by.it.vshchur.at22;

import by.it.vshchur.at22.beans.User;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

import static by.it.vshchur.at22.Dao.TypeDao.H2;

public class Runner {
    public static void main(String[] args) throws SQLException {

        //user reading
        Dao dao = new Dao(H2);
        User user = dao.user.read(3);
        System.out.println("user after read: "+user);

        //user creation
        Date date = Timestamp.valueOf(LocalDateTime.now());
        user = new User(0, "NEW_LOGIN", "NEW_PASSWORD", "NEW_EMAIL", date);
        dao.user.create(user);
        user = dao.user.read(user.getId());
        System.out.println("user after create: " + user);

        //user update
        user.setUsername("LOGIN_UPDATE");
        dao.user.update(user);
        user = dao.user.read(user.getId());
        System.out.println("user after update: " + user);

        //user deletion
        dao.user.delete(user);
        user = dao.user.read(user.getId());
        System.out.println("user after delete: " + user);
    }
}
