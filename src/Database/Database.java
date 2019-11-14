package Database;

import Account.Account;
import Account.CreditAccount;
import Account.CheckingAccount;
import Account.LoanAccount;
import GUI.LoginForm;
import HR.Shift;
import User.*;
import Exception.*;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
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
			Statement s = connection.createStatement();
			if (c.getClientNumber() != null) {
				s.executeUpdate("insert into clients values ('" + c.getClientNumber() + "','" + c.getName() + "','" + c.getPassword() + "')");
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
			Statement s = connection.createStatement();
			if (a.getAdminNumber() != null) {
				s.executeUpdate("insert into administrators values ('" + a.getAdminNumber() + "','" + a.getName() + "','" + a.getPassword() + "')");
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
			Statement s = connection.createStatement();
			if (e.getEmployeeNumber() != null) {
				s.executeUpdate("insert into employees (emp_number, emp_name, emp_password, emp_pay, employee_type) values ('" + e.getEmployeeNumber() + "','" + e.getName() + "','" + e.getPassword() + "','" + e.getHourlyPay() + "','"+ employeeType + "'); ");
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
		if(newUser.getName()== null){
			newUser = getEmployee(uid, password);
			if(newUser.getName()== null){
				newUser = getClient(uid,password);
				if(newUser.getName() == null) {
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
				connection.close();
			}
			else{
				connection.close();
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
