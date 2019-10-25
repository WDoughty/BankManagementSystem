package Account;

public interface AccountInterface {

    void deposit(int amount);
    void withdraw(int amount);
    boolean isSufficientFunds(int amount);
    int getBalance();

}
