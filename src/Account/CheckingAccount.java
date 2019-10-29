package Account;

import User.Client;

public class CheckingAccount extends Account {

    /**
     * Creates new account for client with account number
     *
     * @param client        New user client
     * @param accountNumber Account number assigned to this account
     */
    public CheckingAccount(Client client, String accountNumber) {
        super(client, accountNumber);
    }


}
