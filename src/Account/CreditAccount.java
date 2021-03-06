package Account;

import User.Client;

public class CreditAccount extends Account {
    private double creditLine;
    private double interestRate;

    /**
     * Creates new account for client with account number
     *
     * @param client        New user client
     * @param accountNumber Account number assigned to this account
     */
    public CreditAccount(Client client, String accountNumber) {
        super(client, accountNumber);
    }

    /**
     * Sets the interest rate for the account
     * @param interestRate
     */
    public void setInterestRate(double interestRate){
        this.interestRate = interestRate;
    }

    /**
     * Sets the line of credit for the account
     * @param creditLine
     */
    public void setCreditLine(double creditLine){
        this.creditLine = creditLine;
    }

    /**
     * Returns the interest rate for the account
     * @return double
     */
    public double getInterestRate(){
        return interestRate;
    }

    /**
     * Calculates the accrued interest of the account by the account over
     * the amount of periods and returns the total balance of the account
     * @param periods
     * @return double
     */
    public double calculateInterest(double periods) {
        double interest = this.getBalance() * this.getInterestRate() * periods;
        return interest;
    }

    /**
     * Returns the credit line for this account
     * @return creditLine
     */
    public double getCreditLine() {
        return creditLine;
    }
}
