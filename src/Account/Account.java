package Account;
import User.Client;


public class Account implements AccountInterface {
    private float balance;
    private Client client;
    private String accountNumber;


    /**
     * Creates new account for client with account number
     * @param client New user client
     * @param accountNumber Account number assigned to this account
     */
    public Account(Client client, String accountNumber){
        balance = 0;
        this.client = client;
        this.accountNumber = accountNumber;
    }

    /**
     * Deposits amount into the current account
     * @param amount Integer
     */
    @Override
    public void deposit(float amount) {
        balance+=amount; // Could change this from int to float/double

    }

    /**
     * Withdraws amount from current account balance if balance is greater than the amount requested.
     * Otherwise does nothing.
     * @param amount
     */
    @Override
    public void withdraw(float amount) {
        if(isSufficientFunds(amount)){
            balance-=amount;
        }
        //Create new insufficient funds exception and throw it here

    }

    /**
     * Returns boolean if the account has sufficient funds for the amount requested.
     * @param amount
     * @return boolean
     */
    @Override
    public boolean isSufficientFunds(float amount) {
        if(balance-amount>0){
            return true;
        }
        else return false;
    }

    /**
     * Returns the balance of the account
     * @return balance
     */
    @Override
    public float getBalance() {
        return balance;
    }
}
