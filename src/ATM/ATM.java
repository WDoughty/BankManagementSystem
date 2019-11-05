package ATM;

import Account.Account;
import Database.Database;
import User.Client;
import Account.CheckingAccount;

public class ATM
{
	private Database db = new Database();
	private boolean login;
	private Client customer;
	private CheckingAccount cusAcct;
	private String acctNumber;
	
	public boolean userLogin(String id , String password, String aid)
	{
		customer = db.getClient(id);
		acctNumber = aid;
		login = customer != null && customer.getPassword() == password;
		return login;
	}
	
	public boolean buyStamps(int numStamps)
	{
		double total = numStamps * .55;
		cusAcct = db.getCheckingAccount(acctNumber, customer);
		
		if (cusAcct.getBalance() >= total)
		{
			cusAcct.withdraw(total);
			db.putCheckingAccount(cusAcct, customer.getAccountNumber());
			return true;
		}
		
		else
		{
			return false;
		}
	}
}