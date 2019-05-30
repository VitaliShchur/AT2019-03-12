package by.it.okoyro.at22;

import org.junit.Test;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

import static by.it.okoyro.at22.Dao.DaoType.H2;

public class UserCreateTest {

	@Test(timeout = 5000)
	public void createUser() throws Exception {
		Dao dao = new Dao(H2);
		Date date = Timestamp.valueOf(LocalDateTime.now());
//		User user = new User("h2username","h2password","h2email",date);

//		dao.user.create(user);
//		System.out.println("New user has new ID and all values from user above\n" + user);
	}
}
