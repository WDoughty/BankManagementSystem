package User;

public class Client implements UserInterface {
    private String accountNumber;
    private String name;

    /**
     * Sets the name of the current user
     * @param name
     */
    @Override
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the name of the current user
     * @return name
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * Sets the account number for the Client
     * @param accountNumber
     */
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    /**
     * Returns the account number of the Client
     * @return
     */
    public String getAccountNumber(){
        return accountNumber;
    }
}

