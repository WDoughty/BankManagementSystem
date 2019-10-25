package Account;
import User.Client;

public class Account implements AccountInterface {
    private int balance;
    private Client client;
    private String accountNumber;

    public Account(Client client, String accountNumber){
        balance = 0;
        this.client = client;
        this.accountNumber = accountNumber;
    }

    @Override
    public void deposit(int amount) {
        balance+=amount;

    }

    @Override
    public void withdraw(int amount) {
        if(isSufficientFunds(amount)){
            balance-=amount;
        }
        //Create new insufficient funds exception and throw it here

    }

    @Override
    public boolean isSufficientFunds(int amount) {
        if(balance-amount>0){
            return true;
        }
        else return false;
    }

    @Override
    public int getBalance() {
        return balance;
    }
}
