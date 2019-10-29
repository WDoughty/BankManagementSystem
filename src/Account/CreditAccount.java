package Account;

import User.Client;

public class CreditAccount extends Account {
    private float creditLine;

    /**
     * Creates new account for client with account number
     *
     * @param client        New user client
     * @param accountNumber Account number assigned to this account
     */
    public CreditAccount(Client client, String accountNumber) {
        super(client, accountNumber);
    }

    //Calc interest
}
