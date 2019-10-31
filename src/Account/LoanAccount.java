package Account;

import User.Client;

public class LoanAccount extends Account {
    private double interestRate;
    /**
     * Creates new account for client with account number
     *
     * @param client        New user client
     * @param accountNumber Account number assigned to this account
     */
    public LoanAccount(Client client, String accountNumber) {
        super(client, accountNumber);
    }

    public void setInterestRate(double interestRate){
        this.interestRate = interestRate;
    }

    public double getInterestRate(){
        return interestRate;
    }

    //Calc interest
    public double calculateInterest(double periods) {
        double interest = this.getBalance() * this.getInterestRate() * periods;
        return interest;
    }
}
