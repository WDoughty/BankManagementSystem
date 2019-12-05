package Database;

import Account.*;
import GUI.LoginForm;
import HR.Shift;
import User.*;
import Exception.*;
import com.sun.corba.se.pept.broker.Broker;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;


public class Database implements DatabaseInterface {
    private Set<Employee> employeeSet;
    private Set<Client> clientSet;

	public Connection connection;

	@Override
	public boolean putClient(Client c) {
		//TODO
		try {
			connection = this.getConnection();
			if (c.getClientNumber() != null) {
				PreparedStatement ps = connection.prepareStatement(
						"INSERT INTO clients (client_number, client_name, client_password, email_address)"+
								"VALUES (?,?,?,?)"+
								"ON DUPLICATE KEY UPDATE "+
								"client_number = VALUES(client_number),"+
								"client_name = VALUES(client_name),"+
								"client_password = VALUES(client_password),"+
								"email_address = VALUES(email_address)");
				ps.setString(1,c.getClientNumber());
				ps.setString(2,c.getName());
				ps.setString(3,c.getPassword());
				ps.setString(4,c.getEmail());
				int retval = ps.executeUpdate();
				System.out.printf("executeUpdate returned %d%n", retval);

			}

			connection.close();
			return true;
		} catch (SQLException e) {
			return false;
		}
	}

	@Override
	public boolean putAdministrator(Administrator a) {
		//TODO
		try {
			connection = this.getConnection();
			if (a.getAdminNumber() != null) {
				PreparedStatement ps = connection.prepareStatement(
						"INSERT INTO administrators (admin_number, admin_name, admin_password)" +
								"VALUES (?,?,?)"+
								"ON DUPLICATE KEY UPDATE "+
								"admin_number = VALUES(admin_number),"+
								"admin_name = VALUES(admin_name),"+
								"admin_password = VALUES(admin_password)");
				ps.setString(1,a.getAdminNumber());
				ps.setString(2,a.getName());
				ps.setString(3,a.getPassword());
				int retval = ps.executeUpdate();
				System.out.printf("executeUpdate returned %d%n", retval);
			}

			connection.close();
			return true;
		} catch (SQLException e) {
			return false;
		}
	}

	@Override
	public boolean putEmployee(Employee e) {
		String employeeType= "employee";
		if(e instanceof Manager){
			employeeType = "manager";
		}
		try {
			connection = this.getConnection();
			//Statement s = connection.createStatement();
			if (e.getEmployeeNumber() != null) {
				PreparedStatement ps = connection.prepareStatement(
						"INSERT INTO employees (emp_number, emp_name, emp_password, emp_hours_worked, emp_pay, employee_type)" +
						"VALUES (?,?,?,?,?,?)" +
						"ON DUPLICATE KEY UPDATE "+
						"emp_number = VALUES(emp_number),"+
						"emp_name = VALUES(emp_name),"+
						"emp_password = VALUES(emp_password)," +
						"emp_hours_worked = VALUES(emp_hours_worked),"+
						"emp_pay = VALUES(emp_pay),"+
						"employee_type = VALUES(employee_type)");
				ps.setString(1,e.getEmployeeNumber());
				ps.setString(2,e.getName());
				ps.setString(3,e.getPassword());
				ps.setDouble(4,e.getHoursWorked());
				ps.setDouble(5,e.getHourlyPay());
				ps.setString(6, employeeType);
				int retval = ps.executeUpdate();
				System.out.printf("executeUpdate returned %d%n", retval);
			}
			connection.close();
			return true;
		} catch (SQLException sqle) {
			return false;
		}
	}

	@Override
	public boolean addShift(String sid, String eid, LocalDateTime start, LocalDateTime finish) {
		DateTimeFormatter sqlFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

		String formattedStart = start.format(sqlFormat);
		String formattedFinish = finish.format(sqlFormat);

		System.out.println(formattedStart);
		System.out.println(formattedFinish);

		try {
			connection = this.getConnection();
			Statement s = connection.createStatement();
			s.executeUpdate("insert into shifts values ('" + sid + "','" + eid + "','" + formattedStart + "','" + formattedFinish + "');");
			connection.close();
			return true;
		} catch (SQLException e) {
			return false;
		}
	}

	@Override
	public boolean putCheckingAccount(CheckingAccount a, String cid) {
		//TODO
		try {
			connection = this.getConnection();
			Statement s = connection.createStatement();
			if (a.getAccountNumber() != null) {
				s.executeUpdate("replace into checking_accounts  values ('" + a.getAccountNumber() + "','" + cid + "'," + a.getBalance() + ");");
			}
			connection.close();
			return true;
		} catch (SQLException sqle) {
			return false;
		}
	}

	@Override
	public boolean putCreditAccount(CreditAccount a, String cid) {
		//TODO
		try {
			connection = this.getConnection();
			Statement s = connection.createStatement();
			if (a.getAccountNumber() != null) {
				s.executeUpdate("insert into credit_accounts  values ('" + a.getAccountNumber() + "','" + cid + "'," + a.getBalance() + "," + a.getCreditLine() + "," + a.getInterestRate() + ");");
			}
			connection.close();
			return true;
		} catch (SQLException sqle) {
			return false;
		}
	}

	@Override
	public boolean putLoanAccount(LoanAccount a, String cid) {
		//TODO
		try {
			connection = this.getConnection();
			Statement s = connection.createStatement();
			if (a.getAccountNumber() != null) {
				s.executeUpdate("insert into loan_accounts  values ('" + a.getAccountNumber() + "','" + cid + "'," + a.getBalance() + "," + a.getInterestRate() + ");");
			}
			connection.close();
			return true;
		} catch (SQLException sqle) {
			return false;
		}
	}

	@Override
	public boolean putBrokerageAccount(BrokerageAccount acc, String cid, String stock, int quantity){
		try{
			connection = this.getConnection();

			if(acc.getAccountNumber() != null){
				PreparedStatement ps = connection.prepareStatement(
						"INSERT INTO brokerage_accounts (brk_number,client_number,stock_abbrv,stock_amount)" +
								"VALUES (?,?,?,?)"+
								"ON DUPLICATE KEY UPDATE "+
								"brk_number = VALUES(brk_number),"+
								"client_number = VALUES(client_number),"+
								"stock_abbrv = VALUES(stock_abbrv),"+
								"stock_amount = VALUES(stock_amount)");
				ps.setString(1,acc.getAccountNumber());
				ps.setString(2,cid);
				ps.setString(3,stock);
				ps.setInt(4,quantity);
				int retval = ps.executeUpdate();
				System.out.printf("executeUpdate returned %d%n", retval);
			}
			connection.close();
			return true;
		} catch (SQLException sqle){
			return false;
		}

	}


	@Override
	public Shift getShifts(String sid) {
		//TODO
		Shift shift = new Shift();
		try {
			connection = this.getConnection();
			Statement s = connection.createStatement();
			ResultSet r = s.executeQuery("select * from shifts where shift_id = '" + sid + "';");
			r.next();
			shift.setShiftID(r.getString("shift_id"));
			shift.setEmployeeNumber(r.getString("emp_number"));
			shift.setStart(r.getString("start_time"));
			shift.setFinish(r.getString("end_time"));
			connection.close();
			return shift;
		} catch (SQLException sqle) {
			return shift;
		}
	}

	@Override
	public UserInterface getUser(String uid, String password) throws IncorrectUsernamePasswordException {
		UserInterface newUser;
		//TODO
		newUser = getAdministrator(uid,password);
		if(newUser == null){
			newUser = getEmployee(uid, password);
			if(newUser == null){
				newUser = getClient(uid,password);
				if(newUser == null) {
					throw new IncorrectUsernamePasswordException(
							"Incorrect username or password");
				}

			}
		}

		return newUser;
	}

	@Override
	public Employee getEmployee(String eid, String password) {
		Employee employee = new Employee();

		try {
			connection = this.getConnection();
			Statement s = connection.createStatement();
			ResultSet r = s.executeQuery("select * from employees where emp_number = '" + eid + "';");
			r.next();
			String pw = r.getString("emp_password");
			if(password.equalsIgnoreCase(pw)){
				if(r.getString("employee_type").equalsIgnoreCase("manager")){
					employee = new Manager();
				}
				employee.setEmployeeNumber(r.getString("emp_number"));
				employee.setName(r.getString("emp_name"));
				employee.setPassword(r.getString("emp_password"));
				employee.setHourlyPay(r.getDouble("emp_pay"));
				connection.close();
			}
			else{
				connection.close();
				return null;
			}

		} catch (SQLException sqle) {
			System.out.println(sqle.toString());
			return null;
		}

		return employee;
	}

	@Override
	public Client getClient(String cid, String password) {
		Client client = new Client();

		try {
			connection = this.getConnection();
			Statement s = connection.createStatement();
			ResultSet r = s.executeQuery("select * from clients where client_number = '" + cid + "';");
			r.next();
			String pw = r.getString("client_password");
			if(password.equalsIgnoreCase(pw)) {
				client.setClientNumber(r.getString("client_number"));
				client.setName(r.getString("client_name"));
				client.setPassword(r.getString("client_password"));
				client.setEmail(r.getString("email_address"));
				connection.close();
			}
			else{
				connection.close();
				return null;
			}
		} catch (SQLException sqle) {
			System.out.println(sqle.toString());
			return null;
		}

		return client;
	}

	@Override
	public Administrator getAdministrator(String aid, String password) {
		Administrator admin = new Administrator();

		try {
			connection = this.getConnection();
			Statement s = connection.createStatement();
			ResultSet r = s.executeQuery("select * from administrators where admin_number = '" + aid + "';");
			r.next();
			String pw = r.getString("admin_password");
			if(password.equalsIgnoreCase(pw)) {
				admin.setAdminNumber(r.getString("admin_number"));
				admin.setName(r.getString("admin_name"));
				admin.setPassword(r.getString("admin_password"));
				connection.close();
			}
			else{
				connection.close();
				return null;

			}
		} catch (SQLException sqle) {
			System.out.println(sqle.toString());
			return null;
		}

		return admin;
	}

	@Override
	public List<Account> getAccounts(Client client) {
		//TODO
		List<Account> accounts =  new ArrayList<Account>();
		Account account;
		account = getCheckingAccount(client);
		if(account != null){
			accounts.add(account);
		}
		account = getCreditAccount(client);
		if(account != null){
			accounts.add(account);
		}
		account = getLoanAccount(client);
		if(account != null){
			accounts.add(account);
		}
		account = getBrokerageAccount(client);
		if(account != null){
			accounts.add(account);
		}


		return accounts;
	}

	@Override
    public CheckingAccount getCheckingAccount(Client client) {
	    CheckingAccount account;

        try {
            connection = this.getConnection();
            Statement s = connection.createStatement();
            ResultSet r = s.executeQuery("select * from checking_accounts where client_number = '" + client.getClientNumber() + "';");
            r.next();
            account = new CheckingAccount(client,r.getString("chk_number"));
            account.deposit(r.getDouble("chk_balance"));
            connection.close();
        } catch (SQLException sqle) {
        	return null;

        }

	    return account;
    }

    @Override
    public CreditAccount getCreditAccount(Client client) {
        CreditAccount account;

        try {
            connection = this.getConnection();
            Statement s = connection.createStatement();
            ResultSet r = s.executeQuery("select * from credit_accounts where client_number = '" + client.getClientNumber() + "';");
            r.next();
            account = new CreditAccount(client,r.getString("crd_number"));
            account.deposit(r.getDouble("crd_balance"));
            account.setCreditLine(r.getDouble("crd_line"));
            account.setInterestRate(r.getDouble("crd_interst_rate"));
            connection.close();
        } catch (SQLException sqle) {
			return null;
        }

        return account;
    }

    @Override
    public LoanAccount getLoanAccount(Client client) {
        LoanAccount account;

        try {
            connection = this.getConnection();
            Statement s = connection.createStatement();
            ResultSet r = s.executeQuery("select * from loan_accounts where client_number = '" + client.getClientNumber() + "';");
            r.next();
            account = new LoanAccount(client,r.getString("loan_number"));
            account.deposit(r.getDouble("loan_balance"));
            account.setInterestRate(r.getDouble("loan_interest_rate"));
            connection.close();
        } catch (SQLException sqle) {
			return null;
        }

        return account;
    }

    @Override
	public BrokerageAccount getBrokerageAccount(Client client){
		BrokerageAccount account;
		try{
			connection = this.getConnection();
			Statement s = connection.createStatement();
			ResultSet r = s.executeQuery("select * from brokerage_accounts where client_number = '" + client.getClientNumber() + "';");
			r.next();
			account = new BrokerageAccount(client, r.getString("brk_number"));

			account.setStock(r.getString("stock_abbrv"));
			account.setQuantity(r.getInt("stock_amount"));
			connection.close();
		} catch(SQLException sqle){
			System.out.println(sqle.toString());
			return null;
		}
		return account;
	}

    @Override
	public List<Employee> getEmployees(){
		List<Employee> list = new ArrayList<>();

		try{
			connection = this.getConnection();
			Statement s = connection.createStatement();
			ResultSet r = s.executeQuery("SELECT * FROM employees");
			while(r.next()){
				Employee temp = new Employee();
				temp.setEmployeeNumber(r.getString("emp_number"));
				temp.setName(r.getString("emp_name"));
				temp.setHoursWorked(r.getInt("emp_hours_worked"));
				temp.setHourlyPay(r.getDouble("emp_pay"));
				list.add(temp);
			}
		}
		catch(SQLException e){
			System.out.println(e.toString());
		}
		return list;
	}

	public boolean putTransacation(String client, String account, String type, double amount) {
		try {
			connection = this.getConnection();
			Random rand = new Random();
			String id = Integer.toString(rand.nextInt(999999998) + 1);
			PreparedStatement ps = connection.prepareStatement(
					"INSERT INTO transactions (transaction_id, client_number, account_number, transaction_type, transaction_amount)"+
							"VALUES (?,?,?,?,?)"+
							"ON DUPLICATE KEY UPDATE "+
							"transaction_id = VALUES(transaction_id),"+
							"client_number = VALUES(client_number),"+
							"account_number = VALUES(account_number),"+
							"transaction_type = VALUES(transaction_type),"+
							"transaction_amount = VALUES(transaction_amount)");
			ps.setString(1,id);
			ps.setString(2,client);
			ps.setString(3,account);
			ps.setString(4,type);
			ps.setBigDecimal(5, BigDecimal.valueOf(amount));
			int retval = ps.executeUpdate();
			System.out.printf("executeUpdate returned %d%n", retval);



			connection.close();
			return true;
		} catch (SQLException e) {
			return false;
		}
	}

	public String getTransactions(String client) {
		String result = "";

		try {
			connection = this.getConnection();
			Statement s = connection.createStatement();
			ResultSet r = s.executeQuery("select * from transactions where client_number = '" + client + "';");

			while(r.next()) {
				result += r.getString("transaction_id") + " - " + r.getString("account_number") + " - " + r.getString("transaction_type") + " - " + r.getDouble("transaction_amount") + System.getProperty("line.separator");
			}

			connection.close();
			return result;
		} catch (SQLException sqle) {
			return null;
		}
	}


    @Override
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/bankmanagement";
			connection = DriverManager.getConnection(url, "root", "Password");
			//connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankmanagement", "root", "Password");
		} catch (ClassNotFoundException nfe) {
			connection = null;
		}
		catch (SQLException sqle) {
			connection = null;
		}
		return connection;
	}
}
