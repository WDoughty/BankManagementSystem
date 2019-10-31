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

    public void setInterestRate(double interestRate){
        this.interestRate = interestRate;
    }

    public void setCreditLine(double creditLine){
        this.creditLine = creditLine;
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
