package Database;

import User.Client;
import User.Employee;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;

import Account.Account;

public class Database implements DatabaseInterface {
    private Set<Employee> employeeSet;
    private Set<Client> clientSet;

	public Connection connection = null;

	@Override
	public boolean putClient(Client c) {
		//TODO
		try {
			connection = this.getConnection();
			Statement s = connection.createStatement();
			if (c.getAccountNumber() != null) {
				s.executeUpdate("insert into users values ('" + c.getName() + "','" + c.getAccountNumber() + "')");
			}

			connection.close();
			return true;
		} catch (SQLException e) {
			return false;
		}
	}

	@Override
	public void addShift(String eid, LocalDateTime start, LocalDateTime finish) {
		DateTimeFormatter sqlFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

		String formattedStart = start.format(sqlFormat);
		String formattedFinish = finish.format(sqlFormat);

		try {
			connection = this.getConnection();
			Statement s = connection.createStatement();
			s.executeUpdate("insert into schedule values ('" + eid + "'," + formattedStart + "," + formattedFinish + ")");
		} catch (SQLException e) {

		}
	}

	@Override
	public void getShifts(String eid) {
		//TODO
	}

	@Override
	public boolean putAccount(Account a) {
		//TODO
		return true;
	}

	@Override
	public boolean getUser(String uid) {
		//TODO
		return true;
	}

	@Override
	public boolean getAccount(String aid) {
		//TODO
		return true;
	}

	@Override
	public Connection getConnection() {
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/BankManagementSystem", "root", "password");
		} catch (SQLException sqle) {
			connection = null;
		}
		return connection;
	}
}
