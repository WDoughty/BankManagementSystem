package Database;

import User.Client;
import User.Employee;
import User.UserInterface;

import java.sql.Connection;
import java.util.Set;

import Account.Account;

public class Database implements DatabaseInterface {
    private Set<Employee> employeeSet;
    private Set<Client> clientSet;
	@Override
	public boolean getUser(String uid) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean getAccount(String aid) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public Connection getConnection() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean putUser(UserInterface u) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean putAccount(Account a) {
		// TODO Auto-generated method stub
		return false;
	}


}
