package Account;

public interface AccountControllerInterface {

    /**
     * Requests balance from model account
     * @return balance
     */
    double getBalance();

    /**
     * Deposits amount in model account
     * @param amount
     */
    void deposit(double amount);

   /**
     * Withdraws amount from model account if there is sufficient funds
     * @param amount
     */
    void withdraw(double amount);

    /**
     * Checks if there is sufficient funds for amount in the model account
     * @param amount
     * @return boolean
     */
    boolean isSufficientFunds(double amount);

    /**
     * Sets the interest rate for the account
     * @param interestRate
     */
    void setInterestRate(double interestRate);

    /**
     * Returns the interest account for the account
     * @return double
     */
    double getInterestRate();


}
