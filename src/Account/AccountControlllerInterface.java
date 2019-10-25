package Account;

public interface AccountControlllerInterface {

    int getBalance();
    void deposit(int amount);
    void withdraw(int amount);
    boolean isSufficientFunds(int amount);

}
