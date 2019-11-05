package ATM;

import Account.Account;
import Database.Database;
import User.Client;

public class ATM
{
	private Database db = new Database();
	private boolean login;
	private Client customer;
	private Account cusAcct;
	
	private boolean userLogin(String id , String password)
	{
		customer = db.getClient(id);
		login = customer != null && customer.getPassword() == password;
		return login;
	}
	
	private boolean buyStamps(int numStamps)
	{
		double total = numStamps * .55;
		cusAcct = db.getAccount(customer, customer.getAccountNumber());
		
		if (cusAcct.getBalance() >= total)
		{
			cusAcct.withdraw(total);
			return true;
		}
		
		else
		{
			return false;
		}
	}
}