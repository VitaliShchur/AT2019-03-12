package by.it.okoyro.at22;


import by.it.okoyro.at22.beans.User;

import java.sql.SQLException;

import static by.it.okoyro.at22.Dao.DaoType.H2;

public class Runner {
	public static void main(String[] args) throws SQLException {
		
		Dao dao = new Dao(H2);
		User user = dao.user.read(3);
		System.out.println("User with ID=3 is \n" + user);

		dao.user.create(user);
		System.out.println("New user has new ID and all values from user above\n" + user);

		user.setUsername("test");
		dao.user.update(user);
		System.out.println("Updated user's name is test\n" + user);

		dao.user.delete(user);
		System.out.println("Deleted user id is above\n" + user);
	}
}
