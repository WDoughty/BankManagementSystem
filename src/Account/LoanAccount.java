package Account;

import User.Client;

public class LoanAccount extends Account {
    /**
     * Creates new account for client with account number
     *
     * @param client        New user client
     * @param accountNumber Account number assigned to this account
     */
    public LoanAccount(Client client, String accountNumber) {
        super(client, accountNumber);
    }

    //Calc interest
}
