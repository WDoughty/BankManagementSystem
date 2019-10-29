package Account;

public interface AccountControllerInterface {

    /**
     * Requests balance from model account
     * @return balance
     */
    float getBalance();

    /**
     * Deposits amount in model account
     * @param amount
     */
    void deposit(float amount);

   /**
     * Withdraws amount from model account if there is sufficient funds
     * @param amount
     */
    void withdraw(float amount);

    /**
     * Checks if there is sufficient funds for amount in the model account
     * @param amount
     * @return boolean
     */
    boolean isSufficientFunds(float amount);

}
