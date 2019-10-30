package Account;

public interface AccountInterface {

    /**
     * Deposits amount into the current account
     * @param amount integer
     */
    void deposit(double amount);

    /**
     * Withdraws amount from current account balance if balance is greater than the amount requested.
     * Otherwise does nothing.
     * @param amount integer
     */
    void withdraw(double amount);

    /**
     * Returns boolean if the account has sufficient funds for the amount requested.
     * @param amount
     * @return boolean
     */
    boolean isSufficientFunds(double amount);

    /**
     * Returns the balance of the account
     * @return balance
     */
    double getBalance();

}
