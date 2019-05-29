package by.it.udalyou.at22;

import by.it.udalyou.at22.beans.User;
import by.it.udalyou.at22.connection.ConnectionCreator;
import by.it.udalyou.at22.connection.ConnectionCreatorMySQL;
import by.it.udalyou.at22.repo.UserDao;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

public class Runner {
    public static void main(String[] args) throws SQLException {

        //ConnectionCreator connectionCreator=new ConnectionCreatorMySQL();

        //проверим чтение
       // UserDao user1Dao = new UserDao(connectionCreator);
      //  Dao dao=new Dao(Dao.TypeDao.MY_SQL);
        Dao dao=new Dao(Dao.TypeDao.H2);
        User user1 = dao.user.read(3);
        System.out.println("user after read 3: " + user1);
        //проверим создание
        Date date = Timestamp.valueOf(LocalDateTime.now());
        user1 = new User(0, "NEW_LOGIN", "NEW_PASSWORD", "NEW_EMAIL", date);
        dao.user.create(user1);
        user1 = dao.user.read(user1.getId());
        System.out.println("user after create: " + user1);

        //проверим обновление
        user1.setUsername("LOGIN_UPDATE");
        dao.user.update(user1);
        user1 = dao.user.read(user1.getId());
        System.out.println("user after update: " + user1);

        //проверим удаление
        dao.user.delete(user1);
        user1 = dao.user.read(user1.getId());
        System.out.println("user after delete: " + user1);

    }
}
