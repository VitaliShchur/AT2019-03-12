package by.it.okoyro.at22;

import by.it.okoyro.at22.connection.ConnectionCreator;
import by.it.okoyro.at22.connection.ConnectionCreatorH2;
import by.it.okoyro.at22.connection.ConnectionCreatorMySql;
import by.it.okoyro.at22.repo.UserDao;

import java.util.NoSuchElementException;

public class Dao {
	enum DaoType {
		MySQL, H2
	}

	//all bean Dao

	public UserDao user;

	public Dao(DaoType daoType) {
		ConnectionCreator connectionCreator;
		switch (daoType) {
			case MySQL:
				connectionCreator = new ConnectionCreatorMySql();
				break;
			case H2:
				connectionCreator = new ConnectionCreatorH2();
				break;
			default: throw new NoSuchElementException("connection type isn't defined");
		}
		user = new UserDao(connectionCreator);
	}
}
