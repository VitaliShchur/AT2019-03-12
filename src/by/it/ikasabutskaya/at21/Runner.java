package by.it.ikasabutskaya.at21;

import by.it.akhmelev.at21.beans.User;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

public class Runner {
    public static void main(String[] args) throws SQLException {
        //проверим чтение
        UserDao userDao = new UserDao();
        User user = userDao.read(3);
        System.out.println("user after read 3: " + user);

        //проверим создание
        Date date = Timestamp.valueOf(LocalDateTime.now());
        user = new User(0, "NEW_LOGIN", "NEW_PASSWORD", "NEW_EMAIL", date);
        userDao.create(user);
        user = userDao.read(user.getId());
        System.out.println("user after create: " + user);

        //проверим обновление
        user.setUsername("LOGIN_UPDATE");
        userDao.update(user);
        user = userDao.read(user.getId());
        System.out.println("user after update: " + user);

        //проверим удаление
        userDao.delete(user);
        user = userDao.read(user.getId());
        System.out.println("user after delete: " + user);

    }
}
