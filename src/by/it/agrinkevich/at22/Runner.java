package by.it.agrinkevich.at22;

import by.it.agrinkevich.at22.beans.User;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

import static by.it.agrinkevich.at22.DAO.TypeDAO.H2;

public class Runner {
    public static void main(String[] args) throws SQLException {
        //проверим чтение
        DAO dao = new DAO(H2);
        User user = dao.user.read(1);
        System.out.println("user after read 3: " + user);

        //проверим создание
        Date date = Timestamp.valueOf(LocalDateTime.now());
        user = new User(0, "Dasha", "54321", "test1@domain.com", date);
        dao.user.create(user);
        user = dao.user.read(user.getId());
        System.out.println("user after create: " + user);

        //проверим обновление
        user.setUsername("Masha");
        dao.user.update(user);
        user = dao.user.read(user.getId());
        System.out.println("user after update: " + user);

        //проверим удаление
        dao.user.delete(user);
        user = dao.user.read(user.getId());
        System.out.println("user after delete: " + user);

    }
}
