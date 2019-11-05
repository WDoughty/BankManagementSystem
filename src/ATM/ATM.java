package ATM;

import Database.Database;
import User.Client;
import Account.CheckingAccount;

public class ATM
{
	private Database db = new Database();
	private boolean login = false;
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
	
	public void logOut()
	{
		login = false;
	}
	
	public boolean buyStamps(int numStamps)
	{
		if(login)
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
		
		else
		{
			return false;
		}
	}
}